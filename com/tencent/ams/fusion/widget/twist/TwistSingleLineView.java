package com.tencent.ams.fusion.widget.twist;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RectangleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwistSingleLineView extends TwistView {
    static IPatchRedirector $redirector_ = null;
    private static final float LEFT_ICON_RATIO = 0.5f;
    private static final int LEFT_RECT_BG_COLOR = Integer.MIN_VALUE;
    private static final int LEFT_RECT_HEIGHT_DP = 30;
    private static final int LEFT_RECT_PADDING_DP = 8;
    private static final int LEFT_TEXT_LEFT_MARGIN_DP = 34;
    private static final int LEFT_TEXT_RIGHT_MARGIN_DP = 10;
    private static final int PHONE_CENTER_MARGIN_DP = 10;
    private static final int PHONE_HEIGHT_DP = 28;
    private static final int PHONE_MARGIN_DP = 6;
    private static final int PHONE_WIDTH_DP = 28;
    private static final int RING_RADIUS_DP = 30;
    private static final float RING_RATIO = 0.666f;
    private static final int RING_STROKE_WIDTH_DP = 4;
    private static final int TITLE_VERTICAL_MARGIN_DP = 6;
    private int mLayoutStyle;
    private View mPlaceHolderView;

    public TwistSingleLineView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mLayoutStyle = 0;
        setEnableShowBgShadow(false);
        setEnableShowCircle(false);
        setEnableShowCircleBg(true);
    }

    private void addPlaceView() {
        View view = this.mPlaceHolderView;
        if (view == null) {
            return;
        }
        removeView(view);
        float f16 = this.mRingRatio;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(((int) f16) * 2, ((int) f16) * 2);
        float f17 = this.mRingCenterX;
        float f18 = this.mRingRatio;
        marginLayoutParams.leftMargin = (int) (f17 - f18);
        marginLayoutParams.topMargin = (int) (this.mRingCenterY - f18);
        addView(this.mPlaceHolderView, marginLayoutParams);
    }

    private void calculateHorizontalUISize() {
        this.mTitleTextSize = Utils.dp2px(13.0f);
        this.mRingRatio = Utils.dp2px(30.0f) * 0.5f;
        this.mPhoneWidth = Utils.dp2px(28.0f) * 0.5f;
        this.mPhoneHeight = Utils.dp2px(28.0f) * 0.5f;
        this.mPhoneX = Utils.dp2px(8.0f) + Utils.dp2px(8.0f);
        this.mPhoneY = ((getHeight() - Utils.dp2px(8.0f)) - this.mPhoneHeight) - Utils.dp2px(6.0f);
        this.mRingStokeWidth = Utils.dp2px(4.0f) * 0.5f;
        this.mRingCenterX = this.mPhoneX + (this.mPhoneWidth / 2.0f);
        this.mRingCenterY = this.mPhoneY + (this.mPhoneHeight / 2.0f);
        this.mTriangleWidth = Utils.dp2px(6.0f) * 1.414f * 0.5f;
        this.mTitleTextX = this.mPhoneX + this.mPhoneWidth + Utils.dp2px(6.0f) + (Utils.getTextWidth(this.mTitleTextSize, false, this.mTitle) / 2.0f);
        this.mTitleTextY = ((getHeight() - Utils.dp2px(8.0f)) - Utils.getTextPaintBaselineToBottom(this.mTitleTextSize)) - ((Utils.dp2px(30.0f) - Utils.getTextPaintHeight(this.mTitleTextSize)) / 2.0f);
        addPlaceView();
    }

    private void calculateVerticalUISize() {
        this.mTitleTextSize = Utils.dp2px(14.0f);
        float dp2px = Utils.dp2px(30.0f);
        this.mRingRatio = dp2px;
        float dp2px2 = (dp2px * 2.0f) + Utils.dp2px(6.0f) + Utils.getTextPaintHeight(this.mTitleTextSize);
        this.mTitleTextX = getWidth() / 2.0f;
        this.mTitleTextY = (getHeight() - ((getHeight() - dp2px2) / 2.0f)) - Utils.getTextPaintBaselineToBottom(this.mTitleTextSize);
        this.mPhoneWidth = Utils.dp2px(28.0f);
        this.mPhoneHeight = Utils.dp2px(28.0f);
        this.mPhoneX = (getWidth() - this.mPhoneWidth) / 2.0f;
        this.mPhoneY = (((this.mTitleTextY - Utils.dp2px(6.0f)) - Utils.dp2px(10.0f)) - this.mPhoneHeight) - Utils.getTextPaintHeight(this.mTitleTextSize);
        this.mRingStokeWidth = Utils.dp2px(4.0f);
        this.mRingCenterX = getWidth() / 2.0f;
        this.mRingCenterY = (((this.mTitleTextY - Utils.dp2px(6.0f)) - this.mRingRatio) + Utils.dp2px(3.0f)) - Utils.getTextPaintHeight(this.mTitleTextSize);
        this.mTriangleWidth = Utils.dp2px(8.0f) * 1.414f;
        addPlaceView();
    }

    private AnimatorLayer createHorizontalCircleLayer() {
        RectangleShapeLayer rectangleShapeLayer = new RectangleShapeLayer((int) (Utils.dp2px(34.0f) + Utils.getTextWidth(this.mTitleTextSize, false, this.mTitle) + Utils.dp2px(10.0f)), (int) Utils.dp2px(30.0f), Integer.MIN_VALUE);
        rectangleShapeLayer.setX((int) Utils.dp2px(8.0f));
        rectangleShapeLayer.setY((int) ((getHeight() - Utils.dp2px(8.0f)) - Utils.dp2px(30.0f)));
        rectangleShapeLayer.setRadius(Utils.dp2px(16.0f));
        rectangleShapeLayer.setAnimator(new KeepAnimator(rectangleShapeLayer));
        return rectangleShapeLayer;
    }

    private AnimatorLayer createVerticalCircleLayer() {
        RingShapeLayer strokeCap = new RingShapeLayer(getWidth() / 2, this.mRingCenterY - Utils.dp2px(3.0f), this.mRingRatio, -16777216, 1.0f).setStrokeCap(Paint.Cap.BUTT);
        strokeCap.postAlpha(179);
        strokeCap.setStartAngle(0.0f);
        strokeCap.setSweepAngle(360.0f);
        strokeCap.setUseCenter(true);
        strokeCap.setStyle(Paint.Style.FILL);
        strokeCap.postProgress(100.0f);
        strokeCap.setAnimator(new KeepAnimator(strokeCap));
        return strokeCap;
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    protected void calculateUISize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.mLayoutStyle == 0) {
            calculateVerticalUISize();
        } else {
            calculateHorizontalUISize();
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    protected AnimatorLayer createCircleBgLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mLayoutStyle == 0) {
            return createVerticalCircleLayer();
        }
        return createHorizontalCircleLayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    public AnimatorLayer createRingBgLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        }
        return super.createRingBgLayer(f16 * RING_RATIO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    public AnimatorLayer createRingProgressLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
        return super.createRingProgressLayer(f16 * RING_RATIO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    public PathShapeLayer createTriangleLayer(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PathShapeLayer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Float.valueOf(f16));
        }
        return super.createTriangleLayer(i3, f16 * RING_RATIO);
    }

    public View getPlaceHolderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mPlaceHolderView;
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistView
    protected IAnimatorView newInstance(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IAnimatorView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new TextureAnimatorView(context);
    }

    public void setLayoutStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mLayoutStyle = i3;
        }
    }

    public void setTwistClickable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16) {
            this.mPlaceHolderView = new View(getContext());
        }
    }
}
