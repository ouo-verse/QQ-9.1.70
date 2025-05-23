package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.widget.VerticalGallery;

/* compiled from: P */
/* loaded from: classes18.dex */
public class WheelView extends VerticalGallery {
    static IPatchRedirector $redirector_;
    private static final int[] SHADOWS_COLORS;
    private GradientDrawable mBottomShadow;
    private Camera mCamera;
    private int mCoveflowCenter;
    private boolean mIsNeedTranslate;
    private boolean mIsNeedTranslateCenter;
    private boolean mIsTranslateCenterToRight;
    private float mMaxAlpha;
    private float mMaxOffset;
    private int mMaxRotationAngle;
    private float mMaxSkew;
    private int mMaxZoom;
    private Rect mSelectorBound;
    private GradientDrawable mTopShadow;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50755);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            SHADOWS_COLORS = new int[]{DownloadCardView.COLOR_APP_NAME, 11184810, 11184810};
        }
    }

    public WheelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mCamera = new Camera();
        this.mCoveflowCenter = 0;
        this.mMaxRotationAngle = 80;
        this.mMaxZoom = -80;
        this.mMaxSkew = -0.1f;
        this.mMaxAlpha = 0.8f;
        this.mMaxOffset = -25.0f;
        initialize(context);
    }

    private void adjustViewAlignmentPosition(Matrix matrix, int i3, int i16) {
        if (!this.mIsNeedTranslateCenter) {
            matrix.preTranslate((-i3) / 2, (-i16) / 2);
            matrix.postTranslate(i3 / 2, i16 / 2);
        } else if (this.mIsTranslateCenterToRight) {
            matrix.preTranslate(((-i3) * 5.0f) / 6.0f, (-i16) / 2);
            matrix.postTranslate((i3 * 5.0f) / 6.0f, i16 / 2);
        } else {
            matrix.preTranslate(0.0f, (-i16) / 2);
            matrix.postTranslate(0.0f, i16 / 2);
        }
    }

    private float caculateOffset(View view) {
        int centerOfView = getCenterOfView(view);
        if (this.mIsNeedTranslate) {
            return (Math.abs(this.mCoveflowCenter - centerOfView) / this.mCoveflowCenter) * this.mMaxOffset;
        }
        return 0.0f;
    }

    private float calculateAlpha(View view) {
        return (1.0f - (Math.abs(getCenterOfView(view) - this.mCoveflowCenter) / this.mCoveflowCenter)) * this.mMaxAlpha;
    }

    private float calculateRotationAngle(View view) {
        float f16;
        int i3;
        int centerOfView = getCenterOfView(view);
        if (this.mIsNeedTranslateCenter) {
            f16 = (r0 - centerOfView) / ((float) (this.mCoveflowCenter * 2.2d));
            i3 = this.mMaxRotationAngle;
        } else {
            f16 = (r0 - centerOfView) / this.mCoveflowCenter;
            i3 = this.mMaxRotationAngle;
        }
        float f17 = f16 * i3;
        int i16 = this.mMaxRotationAngle;
        if (f17 > i16) {
            return i16;
        }
        if (f17 < (-i16)) {
            return -i16;
        }
        return f17;
    }

    private float calculateSkewAngle(View view) {
        int i3;
        int centerOfView = getCenterOfView(view);
        float f16 = this.mMaxSkew;
        if (f16 == -0.1f) {
            i3 = this.mCoveflowCenter;
        } else {
            i3 = this.mCoveflowCenter;
        }
        return ((i3 - centerOfView) / i3) * f16;
    }

    private float calculateTranslateDistance(View view) {
        float f16;
        int i3;
        int centerOfView = getCenterOfView(view);
        int i16 = this.mCoveflowCenter;
        if (centerOfView < i16) {
            f16 = centerOfView / i16;
            i3 = this.mMaxZoom;
        } else if (centerOfView > i16) {
            f16 = ((i16 * 2) - centerOfView) / i16;
            i3 = this.mMaxZoom;
        } else {
            return this.mMaxZoom;
        }
        return f16 * i3;
    }

    private int getCenterOfCoverflow() {
        return (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop();
    }

    private int getCenterOfView(View view) {
        return view.getTop() + (view.getHeight() / 2);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(0.5f);
        setWillNotDraw(false);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int[] iArr = SHADOWS_COLORS;
        this.mTopShadow = new GradientDrawable(orientation, iArr);
        this.mBottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        setSoundEffectsEnabled(true);
        setStaticTransformationsEnabled(true);
        setChildrenDrawingOrderEnabled(true);
        if (getResources().getDisplayMetrics().densityDpi <= 160) {
            this.mMaxZoom = -40;
        }
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    public static boolean isInAdditionalBlackList() {
        if (DeviceInfoMonitor.getModel().equals("VKY-AL00") && Build.VERSION.SDK_INT == 24) {
            return true;
        }
        if (DeviceInfoMonitor.getModel().equals("NXT-AL10") && Build.VERSION.SDK_INT == 24) {
            return true;
        }
        return false;
    }

    private void transformChildView(View view, Transformation transformation, float f16, float f17, float f18, float f19, float f26) {
        transformation.clear();
        transformation.setTransformationType(3);
        Matrix matrix = transformation.getMatrix();
        int width = view.getWidth();
        int height = view.getHeight();
        this.mCamera.save();
        this.mCamera.translate(0.0f, 0.0f, 100.0f);
        transformation.setAlpha(f19);
        if (!DeviceInfoMonitor.getModel().equals("HUAWEI Y325-T00") && !DeviceInfoMonitor.getModel().equals("Lenovo A318t") && !DeviceInfoMonitor.getModel().equals("Lenovo A308t") && !DeviceInfoMonitor.getModel().equals("Lenovo A269") && !DeviceInfoMonitor.getModel().equals("PRA-TL10") && !DeviceInfoMonitor.getModel().equals("HUAWEI CAZ-TL10") && !DeviceInfoMonitor.getModel().equals("BLN-TL10") && !isInAdditionalBlackList()) {
            this.mCamera.rotateX(f16);
        }
        if (!this.mIsNeedTranslateCenter) {
            this.mCamera.translate(0.0f, 0.0f, f17);
        }
        this.mCamera.getMatrix(matrix);
        if (!this.mIsNeedTranslateCenter) {
            matrix.preSkew(f18, 0.0f);
        }
        matrix.preTranslate(f26, 0.0f);
        adjustViewAlignmentPosition(matrix, width, height);
        this.mCamera.restore();
    }

    @Override // com.tencent.widget.VerticalGallery, android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) transformation)).booleanValue();
        }
        transformChildView(view, transformation, calculateRotationAngle(view), calculateTranslateDistance(view), calculateSkewAngle(view), calculateAlpha(view), caculateOffset(view));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.VerticalGallery, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.mCoveflowCenter = getCenterOfCoverflow();
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i19 = childAt.getMeasuredHeight();
        } else {
            i19 = 50;
        }
        int i26 = centerOfGallery - (i19 / 2);
        this.mSelectorBound.set(getPaddingLeft(), i26, getWidth() - getPaddingRight(), i19 + i26);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsSpinner, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            this.mCoveflowCenter = getCenterOfCoverflow();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mCoveflowCenter = getCenterOfCoverflow();
            super.onSizeChanged(i3, i16, i17, i18);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // com.tencent.widget.VerticalGallery, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.VerticalGallery
    public void selectionChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.selectionChanged();
            playSoundEffect(0);
        }
    }

    public void setNeedTranslate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mIsNeedTranslate = z16;
        }
    }

    public void setNeedTranslateCenter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mIsNeedTranslateCenter = z16;
        }
    }

    public void setNeedTranslateCenterToRight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mIsTranslateCenterToRight = z16;
        }
    }

    public void setmMaxRotationAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mMaxRotationAngle = i3;
        }
    }

    public void setmMaxSkew(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mMaxSkew = f16;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mCamera = new Camera();
        this.mCoveflowCenter = 0;
        this.mMaxRotationAngle = 80;
        this.mMaxZoom = -80;
        this.mMaxSkew = -0.1f;
        this.mMaxAlpha = 0.8f;
        this.mMaxOffset = -25.0f;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mCamera = new Camera();
        this.mCoveflowCenter = 0;
        this.mMaxRotationAngle = 80;
        this.mMaxZoom = -80;
        this.mMaxSkew = -0.1f;
        this.mMaxAlpha = 0.8f;
        this.mMaxOffset = -25.0f;
        initialize(context);
    }
}
