package com.tencent.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XListView extends ListView {
    static IPatchRedirector $redirector_ = null;
    public static final int MODE_ALL = 1;
    public static final int MODE_BOTTOM = 5;
    public static final int MODE_LEFT = 2;
    public static final int MODE_NONE = 0;
    public static final int MODE_RIGHT = 4;
    public static final int MODE_TOP = 3;
    public static final int WINDOW_ORIENTATION_LANDSCAPE = 1;
    public static final int WINDOW_ORIENTATION_POERRAIT = 2;
    private DrawFinishedListener mDrawFinishedListener;
    private MotionEventInterceptor mInterceptor;
    private int mLastRadius;
    private int mLastRoundMode;
    private int mMaxHeight;
    private OnSizeChangeListener mOnSizeChangeListener;
    private int mOrientation;
    private int mRadius;
    private int mRoundMode;
    private Path mRoundPath;
    private boolean wrapByScroll;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface DrawFinishedListener {
        void drawFinished();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface MotionEventInterceptor {
        boolean intercept(View view, MotionEvent motionEvent);
    }

    public XListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void checkPathChanged() {
        if (this.mLastRadius == this.mRadius && this.mLastRoundMode == this.mRoundMode) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.mLastRadius = this.mRadius;
        this.mRoundPath.reset();
        int i3 = this.mRoundMode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Path path = this.mRoundPath;
                            RectF rectF = new RectF(0.0f, 0.0f, width, height);
                            int i16 = this.mRadius;
                            path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, i16, i16, i16}, Path.Direction.CW);
                            return;
                        }
                        return;
                    }
                    Path path2 = this.mRoundPath;
                    RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
                    int i17 = this.mRadius;
                    path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, i17, i17, i17, i17, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path3 = this.mRoundPath;
                RectF rectF3 = new RectF(0.0f, 0.0f, width, height);
                int i18 = this.mRadius;
                path3.addRoundRect(rectF3, new float[]{i18, i18, i18, i18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            Path path4 = this.mRoundPath;
            RectF rectF4 = new RectF(0.0f, 0.0f, width, height);
            int i19 = this.mRadius;
            path4.addRoundRect(rectF4, new float[]{i19, i19, 0.0f, 0.0f, 0.0f, 0.0f, i19, i19}, Path.Direction.CW);
            return;
        }
        Path path5 = this.mRoundPath;
        RectF rectF5 = new RectF(0.0f, 0.0f, width, height);
        int i26 = this.mRadius;
        path5.addRoundRect(rectF5, i26, i26, Path.Direction.CW);
    }

    private int getWindowOrientation() {
        if (getContext().getResources().getDisplayMetrics().widthPixels > getContext().getResources().getDisplayMetrics().heightPixels) {
            return 1;
        }
        return 2;
    }

    private void notifySizeChanged(int i3, int i16, int i17, int i18, boolean z16, int i19) {
        OnSizeChangeListener onSizeChangeListener = this.mOnSizeChangeListener;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onSizeChanged(i3, i16, i17, i18, z16, i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        DrawFinishedListener drawFinishedListener = this.mDrawFinishedListener;
        if (drawFinishedListener != null) {
            drawFinishedListener.drawFinished();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        MotionEvent obtain;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mInterceptor != null && (obtain = MotionEvent.obtain(motionEvent)) != null) {
            z16 = this.mInterceptor.intercept(this, obtain);
            obtain.recycle();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        try {
            z17 = super.dispatchTouchEvent(motionEvent);
        } catch (RuntimeException unused) {
            z17 = false;
        }
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) canvas);
            return;
        }
        if (this.mRoundMode != 0) {
            int save = canvas.save();
            checkPathChanged();
            canvas.clipPath(this.mRoundPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mMaxHeight > 0) {
            int mode = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i16);
            int i17 = this.mMaxHeight;
            if (size > i17 && mode != 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(i17, mode);
            }
        } else if (this.wrapByScroll) {
            i16 = View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        int windowOrientation = getWindowOrientation();
        if (this.mOrientation != windowOrientation) {
            z16 = true;
        } else {
            z16 = false;
        }
        notifySizeChanged(i3, i16, i17, i18, z16, windowOrientation);
        this.mOrientation = windowOrientation;
    }

    public void setCornerRadiusAndMode(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mRadius = i3;
            this.mRoundMode = i16;
        }
    }

    public void setDrawFinishedListener(DrawFinishedListener drawFinishedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) drawFinishedListener);
        } else {
            this.mDrawFinishedListener = drawFinishedListener;
        }
    }

    public void setMaxHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.mMaxHeight = i3;
        if (i3 < getMeasuredHeight()) {
            requestLayout();
        }
    }

    public void setMotionEventInterceptor(MotionEventInterceptor motionEventInterceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEventInterceptor);
        } else {
            this.mInterceptor = motionEventInterceptor;
        }
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onSizeChangeListener);
        } else {
            this.mOnSizeChangeListener = onSizeChangeListener;
        }
    }

    public void setOverScrollDistance(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mOverscrollDistance = i3;
        }
    }

    public void setWrapByScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.wrapByScroll = z16;
        }
    }

    public XListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public XListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mOrientation = 0;
        this.mMaxHeight = -1;
        this.mRoundMode = 0;
        this.wrapByScroll = false;
        this.mOverscrollDistance = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.P1);
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(u51.a.Q1, -1));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, u51.a.J1);
        boolean z16 = obtainStyledAttributes2.getBoolean(u51.a.K1, false);
        obtainStyledAttributes2.recycle();
        setEdgeEffectEnabled(z16);
        Path path = new Path();
        this.mRoundPath = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
