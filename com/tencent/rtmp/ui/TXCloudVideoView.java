package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TXCloudVideoView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener {
    static IPatchRedirector $redirector_ = null;
    private static final int FOCUS_AREA_SIZE_IN_DP = 70;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f368796m = 0;
    private WeakReference<b> mCallback;
    private final Rect mDashMargin;
    private final Dashboard mDashboard;
    private final a mDelayedTapRunnable;
    private final HashSet<TextureView> mDeprecatedTextureViewSet;
    private boolean mEnableShowLog;
    private boolean mEnableTouchToFocus;
    private boolean mEnableZoom;
    private FocusIndicatorView mFocusIndicatorView;
    protected Object mGLContext;
    private final Runnable mHideIndicatorViewRunnable;
    private float mLastScaleFactor;
    private float mScaleFactor;
    private ScaleGestureDetector mScaleGestureDetector;
    private WeakReference<Surface> mSurface;
    private final WeakReference<SurfaceView> mSurfaceView;
    private final String mTAG;
    private TextureView mTopTextureView;
    private String mUserId;
    private TextureView mVideoViewSetByUser;
    private AndroidViewEventListener mViewEventListener;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
        void onShowLog(boolean z16);
    }

    public TXCloudVideoView(Context context) {
        this(context, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void addViewInternal(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.mTAG, "addViewInternal,TextureView is null.");
            return;
        }
        if (textureView.getParent() == null) {
            addView(textureView);
            updateTopTextureView();
        } else if (textureView.getParent() == this) {
            LiteavLog.i(this.mTAG, "view has been added.");
        } else {
            LiteavLog.w(this.mTAG, "view has been added to other parent view. parent=" + textureView.getParent());
        }
        this.mDeprecatedTextureViewSet.remove(textureView);
    }

    private TextureView getTextureViewSetByUser() {
        return this.mVideoViewSetByUser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideIndicatorView() {
        FocusIndicatorView focusIndicatorView = this.mFocusIndicatorView;
        if (focusIndicatorView != null) {
            focusIndicatorView.setVisibility(8);
        }
    }

    private boolean isShowLogEnabled() {
        return this.mEnableShowLog;
    }

    private static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void removeDeprecatedViews(TextureView textureView) {
        Iterator<TextureView> it = this.mDeprecatedTextureViewSet.iterator();
        while (it.hasNext()) {
            TextureView next = it.next();
            if (next != null && next != textureView) {
                try {
                    removeView(next);
                } catch (Exception e16) {
                    LiteavLog.e(this.mTAG, "removeView view error: ", e16);
                }
                it.remove();
            }
        }
        updateTopTextureView();
    }

    private void removeViewInternal(TextureView textureView, boolean z16) {
        if (textureView == null) {
            return;
        }
        if (z16) {
            try {
                removeView(textureView);
            } catch (Exception e16) {
                LiteavLog.e(this.mTAG, "removeView view error: ", e16);
            }
            updateTopTextureView();
            this.mDeprecatedTextureViewSet.remove(textureView);
            return;
        }
        if (textureView.getParent() == this) {
            removeDeprecatedViews(textureView);
            this.mDeprecatedTextureViewSet.add(textureView);
        } else if (textureView.getParent() == null) {
            LiteavLog.i(this.mTAG, "current view has been removed from the parent view. view=".concat(String.valueOf(textureView)));
        } else if (textureView.getParent() != this) {
            LiteavLog.w(this.mTAG, "current view is not a child view of this view. parent=" + textureView.getParent());
        }
    }

    private void repositionDashBoard() {
        try {
            removeView(this.mDashboard);
        } catch (Exception e16) {
            LiteavLog.e(this.mTAG, "removeView dashboard view error: ", e16);
        }
        addView(this.mDashboard);
    }

    private void setAndroidViewEventListener(AndroidViewEventListener androidViewEventListener) {
        this.mViewEventListener = androidViewEventListener;
    }

    private void setBackgroundColorForInternalView(int i3) {
        LiteavLog.i(this.mTAG, "setBackgroundColorForInternalView color:".concat(String.valueOf(i3)));
        if (this.mSurface == null && this.mSurfaceView == null) {
            int i16 = (i3 >> 16) & 255;
            post(com.tencent.rtmp.ui.b.a(this, i3 & 255, (i3 >> 24) & 255, i16, (i3 >> 8) & 255));
        }
    }

    private void setShowLogCallback(WeakReference<b> weakReference) {
        this.mCallback = weakReference;
    }

    private void setTouchToFocusEnabled(boolean z16) {
        this.mEnableTouchToFocus = z16;
    }

    private void setZoomEnabled(boolean z16) {
        LiteavLog.i(this.mTAG, "setZoomEnabled: ".concat(String.valueOf(z16)));
        this.mEnableZoom = z16;
    }

    private void showFocusView(int i3, int i16, int i17, int i18) {
        post(c.a(this, i3, i16, i17, i18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFocusViewInternal(int i3, int i16, int i17, int i18) {
        if ((i17 != 0 && i17 != getWidth()) || (i18 != 0 && i18 != getHeight())) {
            LiteavLog.i(this.mTAG, "ignore show indicator view when view size changed");
            return;
        }
        LiteavLog.v(this.mTAG, "show indicator view at (%d,%d)", Integer.valueOf(i3), Integer.valueOf(i16));
        removeCallbacks(this.mHideIndicatorViewRunnable);
        int i19 = (int) ((getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i19, i19);
        int i26 = i19 / 2;
        layoutParams.leftMargin = g.a(i3 - i26, 0, getWidth() - i19);
        layoutParams.topMargin = g.a(i16 - i26, 0, getHeight() - i19);
        View view = this.mFocusIndicatorView;
        if (view == null) {
            FocusIndicatorView focusIndicatorView = new FocusIndicatorView(getContext());
            this.mFocusIndicatorView = focusIndicatorView;
            addView(focusIndicatorView, layoutParams);
        } else if (indexOfChild(view) != getChildCount() - 1) {
            try {
                removeView(this.mFocusIndicatorView);
            } catch (Exception e16) {
                LiteavLog.e(this.mTAG, "removeView focus indicator view error: ", e16);
            }
            addView(this.mFocusIndicatorView, layoutParams);
        } else {
            this.mFocusIndicatorView.setLayoutParams(layoutParams);
        }
        this.mFocusIndicatorView.setVisibility(0);
        FocusIndicatorView focusIndicatorView2 = this.mFocusIndicatorView;
        focusIndicatorView2.startAnimation(focusIndicatorView2.f368792a);
        postDelayed(this.mHideIndicatorViewRunnable, TimeUnit.SECONDS.toMillis(1L));
    }

    private void updateTopTextureView() {
        TextureView textureView;
        int childCount = getChildCount() - 1;
        while (true) {
            if (childCount >= 0) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof TextureView) {
                    textureView = (TextureView) childAt;
                    break;
                }
                childCount--;
            } else {
                textureView = null;
                break;
            }
        }
        if (this.mTopTextureView != textureView) {
            this.mTopTextureView = textureView;
        }
    }

    public void addVideoView(TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) textureView);
            return;
        }
        removeViewInternal(this.mVideoViewSetByUser, true);
        addViewInternal(textureView);
        this.mVideoViewSetByUser = textureView;
        repositionDashBoard();
    }

    public void clearLastFrame(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else if (z16) {
            setVisibility(8);
        }
    }

    public void clearLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        Dashboard dashboard = this.mDashboard;
        if (dashboard != null) {
            dashboard.f368785a.setLength(0);
            TextView textView = dashboard.f368786b;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = dashboard.f368787c;
            if (textView2 != null) {
                textView2.setText("");
            }
        }
    }

    public void disableLog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        }
    }

    @Deprecated
    public TextureView getHWVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextureView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return getVideoView();
    }

    public Object getOpenGLContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mGLContext;
    }

    public Surface getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Surface) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        WeakReference<Surface> weakReference = this.mSurface;
        if (weakReference == null) {
            return null;
        }
        Surface surface = weakReference.get();
        if (surface == null) {
            LiteavLog.w(this.mTAG, "surface is null.");
        }
        return surface;
    }

    public SurfaceView getSurfaceView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SurfaceView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference == null) {
            return null;
        }
        SurfaceView surfaceView = weakReference.get();
        if (surfaceView == null) {
            LiteavLog.w(this.mTAG, "surfaceView is null.");
        }
        return surfaceView;
    }

    public String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mUserId;
    }

    @Deprecated
    public TextureView getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextureView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        TextureView textureView = this.mVideoViewSetByUser;
        if (textureView != null) {
            return textureView;
        }
        return this.mTopTextureView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onAttachedToWindow();
            LiteavLog.i(this.mTAG, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onDetachedFromWindow();
            LiteavLog.i(this.mTAG, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        Dashboard dashboard = this.mDashboard;
        Rect rect = this.mDashMargin;
        dashboard.a(rect.left, rect.top, rect.right, rect.bottom);
        this.mDashboard.setStatusTextSize((float) (px2dip(getContext(), getWidth()) / 30.0d));
        this.mDashboard.setEventTextSize((float) (px2dip(getContext(), getWidth()) / 25.0d));
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        if (!this.mEnableZoom) {
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor() - this.mLastScaleFactor;
        this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
        float a16 = g.a(this.mScaleFactor + scaleFactor, 0.0f);
        this.mScaleFactor = a16;
        AndroidViewEventListener androidViewEventListener = this.mViewEventListener;
        if (androidViewEventListener != null) {
            androidViewEventListener.onZoom(a16);
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
        return this.mEnableZoom;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) scaleGestureDetector);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        AndroidViewEventListener androidViewEventListener = this.mViewEventListener;
        if (androidViewEventListener != null) {
            androidViewEventListener.onSizeChanged(i3, i16, i17, i18);
        }
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            if (this.mEnableTouchToFocus) {
                a aVar = this.mDelayedTapRunnable;
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int width = getWidth();
                int height = getHeight();
                Point point = aVar.f368802a;
                point.x = x16;
                point.y = y16;
                aVar.f368803b = width;
                aVar.f368804c = height;
                removeCallbacks(this.mDelayedTapRunnable);
                postDelayed(this.mDelayedTapRunnable, 100L);
            }
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2 && this.mEnableZoom) {
            removeCallbacks(this.mDelayedTapRunnable);
            hideIndicatorView();
            if (this.mScaleGestureDetector == null) {
                this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), this);
            }
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
        }
        if (this.mEnableZoom) {
            if (motionEvent.getAction() == 0) {
                performClick();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            removeViewInternal(this.mVideoViewSetByUser, true);
            this.mVideoViewSetByUser = null;
        }
    }

    public void setDashBoardMarginInPx(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Rect rect = this.mDashMargin;
        rect.left = i3;
        rect.right = i16;
        rect.top = i17;
        rect.bottom = i18;
        this.mDashboard.a(i3, i17, i16, i18);
    }

    public void setDashBoardMarginInRatio(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            postDelayed(new Runnable(f16, f17, f18, f19) { // from class: com.tencent.rtmp.ui.TXCloudVideoView.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ float f368797a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ float f368798b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ float f368799c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f368800d;

                {
                    this.f368797a = f16;
                    this.f368798b = f17;
                    this.f368799c = f18;
                    this.f368800d = f19;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TXCloudVideoView.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TXCloudVideoView.this.setDashBoardMarginInPx((int) (r0.getWidth() * this.f368797a), (int) (TXCloudVideoView.this.getWidth() * this.f368798b), (int) (TXCloudVideoView.this.getHeight() * this.f368799c), (int) (TXCloudVideoView.this.getHeight() * this.f368800d));
                    }
                }
            }, 100L);
        }
    }

    public void setLogMargin(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            setDashBoardMarginInPx((int) f16, (int) f17, (int) f18, (int) f19);
        }
    }

    public void setOpenGLContext(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj);
        } else {
            this.mGLContext = obj;
        }
    }

    public void setUserId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.mUserId = str;
        }
    }

    public void showLog(boolean z16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        this.mEnableShowLog = z16;
        WeakReference<b> weakReference = this.mCallback;
        if (weakReference == null) {
            bVar = null;
        } else {
            bVar = weakReference.get();
        }
        if (bVar != null) {
            bVar.onShowLog(z16);
        }
    }

    public TXCloudVideoView(SurfaceView surfaceView) {
        this(surfaceView.getContext(), null, surfaceView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceView);
    }

    public TXCloudVideoView(Context context, Surface surface) {
        this(context, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mSurface = surface != null ? new WeakReference<>(surface) : null;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) surface);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final Point f368802a;

        /* renamed from: b, reason: collision with root package name */
        int f368803b;

        /* renamed from: c, reason: collision with root package name */
        int f368804c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TXCloudVideoView.this);
                return;
            }
            this.f368802a = new Point();
            this.f368803b = 0;
            this.f368804c = 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (TXCloudVideoView.this.mViewEventListener != null) {
                AndroidViewEventListener androidViewEventListener = TXCloudVideoView.this.mViewEventListener;
                Point point = this.f368802a;
                androidViewEventListener.onTap(point.x, point.y, this.f368803b, this.f368804c);
            }
        }

        /* synthetic */ a(TXCloudVideoView tXCloudVideoView, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, tXCloudVideoView, Byte.valueOf(b16));
        }
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, surfaceView);
            return;
        }
        this.mTAG = "TXCloudVideoView_" + hashCode();
        this.mDashMargin = new Rect();
        this.mDeprecatedTextureViewSet = new HashSet<>();
        this.mEnableTouchToFocus = false;
        this.mDelayedTapRunnable = new a(this, (byte) 0);
        this.mEnableZoom = false;
        this.mUserId = "";
        this.mHideIndicatorViewRunnable = com.tencent.rtmp.ui.a.a(this);
        this.mDashboard = new Dashboard(context);
        this.mSurfaceView = surfaceView != null ? new WeakReference<>(surfaceView) : null;
    }
}
