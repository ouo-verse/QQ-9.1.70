package com.tencent.tdf.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.TDFEngineConfig;
import com.tencent.tdf.embed.mutatorsstack.EmbeddedMutatorView;
import com.tencent.tdf.view.RenderSurface;
import com.tencent.tdf.view.overlay.TDFBackGroundImageView;
import com.tencent.tdf.view.overlay.TDFOverlayImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFOutputView extends FrameLayout implements INativeViewDelegate, RenderSurface.Callback {
    static IPatchRedirector $redirector_;
    private List<View> mImageViewOverLayList;
    private INativeViewDelegate mNativeViewDelegate;
    private RenderSurface mPreviousRenderSurface;
    private RenderSurface mRenderSurface;
    private TDFImageView mTdfImageView;
    private final String tag;
    private final TDFEngine tdfEngine;
    private final TDFViewportMetrics viewportMetrics;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.tencent.tdf.view.RenderSurface$Callback, android.view.View, java.lang.Object, com.tencent.tdf.view.TDFOutputView] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.tencent.tdf.view.TDFSurfaceView] */
    public TDFOutputView(Context context, TDFEngineConfig.TDFViewMode tDFViewMode, TDFEngine tDFEngine) {
        super(context);
        TDFTextureView tDFTextureView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFViewMode, tDFEngine);
            return;
        }
        this.viewportMetrics = new TDFViewportMetrics();
        this.mImageViewOverLayList = new ArrayList();
        this.tag = TDFOutputView.class.getSimpleName();
        if (tDFViewMode == TDFEngineConfig.TDFViewMode.SurfaceView) {
            tDFTextureView = new TDFSurfaceView(context, this);
        } else {
            tDFTextureView = new TDFTextureView(context, this);
        }
        this.tdfEngine = tDFEngine;
        init(tDFTextureView);
        this.mRenderSurface = tDFTextureView;
        this.mNativeViewDelegate = new NativeViewDelegate(this);
    }

    private boolean acquireLatestImageViewFrame() {
        TDFImageView tDFImageView = this.mTdfImageView;
        if (tDFImageView != null) {
            return tDFImageView.acquireLatestImage();
        }
        return false;
    }

    private int calculateShouldZeroSides() {
        Context context = getContext();
        int i3 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i3 == 2) {
            if (rotation == 1) {
                return 2;
            }
            if (rotation == 3) {
                return 1;
            }
            if (rotation == 0 || rotation == 2) {
                return 3;
            }
            return 0;
        }
        return 0;
    }

    private TDFImageView createImageView() {
        return new TDFBackGroundImageView(getContext(), this.tdfEngine, getWidth(), getHeight());
    }

    @RequiresApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void init(View view) {
        addView(view);
    }

    public void convertToImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        TDFImageView tDFImageView = this.mTdfImageView;
        if (tDFImageView == null) {
            TDFImageView createImageView = createImageView();
            this.mTdfImageView = createImageView;
            addView(createImageView);
        } else {
            tDFImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.mRenderSurface.setRenderInImageView(true);
        this.mPreviousRenderSurface = this.mRenderSurface;
        TDFImageView tDFImageView2 = this.mTdfImageView;
        this.mRenderSurface = tDFImageView2;
        if (this.tdfEngine != null) {
            tDFImageView2.attachSurfaceToRenderer();
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            this.mImageViewOverLayList.remove(view);
            this.mNativeViewDelegate.deleteView(view);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.tdfEngine.handleMotionEvent(motionEvent);
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) keyEvent)).booleanValue();
        }
        this.tdfEngine.handleKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof EmbeddedMutatorView) {
                    ((EmbeddedMutatorView) childAt).tryUpdateEmbeddedViewGestureInfo(motionEvent, this.tdfEngine.getJNI());
                }
            }
        }
        this.tdfEngine.handleMotionEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) rect)).booleanValue();
        }
        return super.fitSystemWindows(rect);
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Rect) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mNativeViewDelegate.getLayoutRect();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, i3);
            return;
        }
        if (view instanceof TDFImageView) {
            this.mImageViewOverLayList.add(view);
        }
        this.mNativeViewDelegate.insertView(view, i3);
    }

    @Override // android.view.View
    @RequiresApi(20)
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Insets systemGestureInsets;
        int i26;
        int i27;
        int i28;
        int i29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WindowInsets) iPatchRedirector.redirect((short) 2, (Object) this, (Object) windowInsets);
        }
        if (Build.VERSION.SDK_INT == 29) {
            systemGestureInsets = windowInsets.getSystemGestureInsets();
            TDFViewportMetrics tDFViewportMetrics = this.viewportMetrics;
            i26 = systemGestureInsets.top;
            tDFViewportMetrics.systemGestureInsetTop = i26;
            TDFViewportMetrics tDFViewportMetrics2 = this.viewportMetrics;
            i27 = systemGestureInsets.right;
            tDFViewportMetrics2.systemGestureInsetRight = i27;
            TDFViewportMetrics tDFViewportMetrics3 = this.viewportMetrics;
            i28 = systemGestureInsets.bottom;
            tDFViewportMetrics3.systemGestureInsetBottom = i28;
            TDFViewportMetrics tDFViewportMetrics4 = this.viewportMetrics;
            i29 = systemGestureInsets.left;
            tDFViewportMetrics4.systemGestureInsetLeft = i29;
        }
        if ((getWindowSystemUiVisibility() & 4) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((getWindowSystemUiVisibility() & 2) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            i3 = calculateShouldZeroSides();
        } else {
            i3 = 0;
        }
        TDFViewportMetrics tDFViewportMetrics5 = this.viewportMetrics;
        if (z16) {
            i16 = windowInsets.getSystemWindowInsetTop();
        } else {
            i16 = 0;
        }
        tDFViewportMetrics5.viewPaddingTop = i16;
        TDFViewportMetrics tDFViewportMetrics6 = this.viewportMetrics;
        if (i3 != 2 && i3 != 3) {
            i17 = windowInsets.getSystemWindowInsetRight();
        } else {
            i17 = 0;
        }
        tDFViewportMetrics6.viewPaddingRight = i17;
        TDFViewportMetrics tDFViewportMetrics7 = this.viewportMetrics;
        if (z17 && guessBottomKeyboardInset(windowInsets) == 0) {
            i18 = windowInsets.getSystemWindowInsetBottom();
        } else {
            i18 = 0;
        }
        tDFViewportMetrics7.viewPaddingBottom = i18;
        TDFViewportMetrics tDFViewportMetrics8 = this.viewportMetrics;
        if (i3 != 1 && i3 != 3) {
            i19 = windowInsets.getSystemWindowInsetLeft();
        } else {
            i19 = 0;
        }
        tDFViewportMetrics8.viewPaddingLeft = i19;
        this.viewportMetrics.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
        TDFViewportMetrics tDFViewportMetrics9 = this.viewportMetrics;
        tDFViewportMetrics9.viewInsetTop = 0;
        tDFViewportMetrics9.viewInsetRight = 0;
        tDFViewportMetrics9.viewInsetLeft = 0;
        updateViewportMetrics();
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (InputConnection) iPatchRedirector.redirect((short) 8, (Object) this, (Object) editorInfo);
        }
        InputConnection createInputConnection = this.tdfEngine.createInputConnection(editorInfo);
        if (createInputConnection == null) {
            return super.onCreateInputConnection(editorInfo);
        }
        return createInputConnection;
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void onEndFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        acquireLatestImageViewFrame();
        for (View view : this.mImageViewOverLayList) {
            if (view instanceof TDFOverlayImageView) {
                ((TDFOverlayImageView) view).acquireLatestImage();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    public void revertImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.mTdfImageView == null) {
            Log.v(this.tag, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.mPreviousRenderSurface;
        if (renderSurface == null) {
            Log.v(this.tag, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        renderSurface.setRenderInImageView(false);
        this.mRenderSurface = this.mPreviousRenderSurface;
        this.mPreviousRenderSurface = null;
        this.mTdfImageView.detachFromRenderer();
        this.mRenderSurface.attachSurfaceToRenderer();
    }

    @Override // com.tencent.tdf.view.RenderSurface.Callback
    public void surfaceChanged(Surface surface, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TDFViewportMetrics tDFViewportMetrics = this.viewportMetrics;
        tDFViewportMetrics.width = i3;
        tDFViewportMetrics.height = i16;
        updateViewportMetrics();
        this.tdfEngine.onSurfaceSizeChanged(i3, i16);
    }

    @Override // com.tencent.tdf.view.RenderSurface.Callback
    public void surfaceCreated(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) surface);
        } else {
            this.tdfEngine.onSurfaceCreated(surface);
        }
    }

    @Override // com.tencent.tdf.view.RenderSurface.Callback
    public void surfaceDestroyed(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) surface);
        } else {
            this.tdfEngine.onSurfaceDestroyed();
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mNativeViewDelegate.updateLayoutParams(i3, i16, i17, i18);
        }
    }

    public void updateViewportMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.tdfEngine.updateViewportMetrics(this.viewportMetrics);
    }
}
