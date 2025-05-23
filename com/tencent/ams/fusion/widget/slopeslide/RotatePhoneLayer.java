package com.tencent.ams.fusion.widget.slopeslide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationXAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class RotatePhoneLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int PHONE_HEIGHT = 152;
    private static final int PHONE_WIDTH = 104;
    private static final int PROGRESS_HEIGHT = 120;
    private static final int PROGRESS_WIDTH = 72;
    private static final String TAG = "RotatePhoneLayer";
    private Context mContext;
    private KeepRotateAndProgressAnimator mKeepRotateAndProgressAnimator;
    private BitmapLayer mPhoneLayer;
    private PathShapeLayer mProgressLayer;
    private float mProgressOffsetX;
    private float mProgressOffsetY;
    private int mStyle;

    /* loaded from: classes3.dex */
    public static class KeepRotateAndProgressAnimator extends GroupAnimator {
        static IPatchRedirector $redirector_;
        private RotatePhoneProgressAnimator mProgressAnimator;
        private KeepRotateXAnimator mRotateKeepAnimator;

        public KeepRotateAndProgressAnimator(AnimatorLayer animatorLayer, Animator... animatorArr) {
            super(animatorLayer, animatorArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer, (Object) animatorArr);
            } else {
                init(animatorLayer);
            }
        }

        private void init(AnimatorLayer animatorLayer) {
            KeepRotateXAnimator keepRotateXAnimator = new KeepRotateXAnimator(animatorLayer);
            this.mRotateKeepAnimator = keepRotateXAnimator;
            keepRotateXAnimator.setRepeatCount(0);
            RotatePhoneProgressAnimator rotatePhoneProgressAnimator = new RotatePhoneProgressAnimator(animatorLayer);
            this.mProgressAnimator = rotatePhoneProgressAnimator;
            rotatePhoneProgressAnimator.setRepeatCount(0);
            addAnimators(this.mRotateKeepAnimator, this.mProgressAnimator);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
        
            if (r5 > 1.0f) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void updateProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                return;
            }
            float f17 = 0.0f;
            if (f16 >= 0.0f) {
                f17 = 1.0f;
            }
            f16 = f17;
            RotatePhoneProgressAnimator rotatePhoneProgressAnimator = this.mProgressAnimator;
            if (rotatePhoneProgressAnimator != null) {
                rotatePhoneProgressAnimator.setProgress(f16);
            }
        }

        public void updateRotateX(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                return;
            }
            KeepRotateXAnimator keepRotateXAnimator = this.mRotateKeepAnimator;
            if (keepRotateXAnimator != null) {
                keepRotateXAnimator.setRotationX(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class KeepRotateXAnimator extends RotationXAnimator {
        static IPatchRedirector $redirector_;

        public KeepRotateXAnimator(AnimatorLayer animatorLayer) {
            super(animatorLayer);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            } else {
                setLocation(0.0f, 0.0f, -4.0f);
            }
        }

        public void setRotationX(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                setRotationDegrees(f16, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RotatePhoneProgressAnimator extends ProgressAnimator {
        static IPatchRedirector $redirector_;

        public RotatePhoneProgressAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
            super(animatorLayer, f16, f17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator, com.tencent.ams.fusion.widget.animatorview.animator.Animator
        public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, animatorLayer, Boolean.valueOf(z16));
            } else if (z16 && !shouldRepeat()) {
                animatorLayer.postProgress(getToProgress());
            } else {
                animatorLayer.postProgress(computeProgress());
            }
        }

        public void setProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            } else {
                setFromProgress(f16);
                setToProgress(f16);
            }
        }

        public RotatePhoneProgressAnimator(AnimatorLayer animatorLayer) {
            super(animatorLayer, 0.0f, 0.0f);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorLayer);
        }
    }

    public RotatePhoneLayer(Context context, @SlopeSlideView.STYLE int i3) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mStyle = i3;
        int relativeSizeByStyle = getRelativeSizeByStyle(context, 104);
        int relativeSizeByStyle2 = getRelativeSizeByStyle(context, 152);
        this.mProgressOffsetX = getRelativeSizeByStyle(this.mContext, 16);
        this.mProgressOffsetY = getRelativeSizeByStyle(this.mContext, 14);
        setWidth(relativeSizeByStyle);
        setHeight(relativeSizeByStyle2);
        this.mPhoneLayer = createPhoneLayer(context);
        PathShapeLayer createProgressLayer = createProgressLayer();
        this.mProgressLayer = createProgressLayer;
        addLayers(this.mPhoneLayer, createProgressLayer);
        this.mKeepRotateAndProgressAnimator = new KeepRotateAndProgressAnimator(this, new Animator[0]);
        setAnimator(createAutoRotationXAnimator());
    }

    private Animator createAutoRotationXAnimator() {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this, createRotationXAnimatorStep1(), createRotationXAnimatorStep2(), createRotationXAnimatorStep3());
        sequentialAnimator.setRepeatCount(0);
        return sequentialAnimator;
    }

    private BitmapLayer createPhoneLayer(Context context) {
        if (context == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(SlopeSlideHelper.getPhoneIcon(width, height));
        bitmapLayer.setWidth(width);
        bitmapLayer.setHeight(height);
        bitmapLayer.setX(getX());
        bitmapLayer.setY(getY());
        return bitmapLayer;
    }

    private PathShapeLayer createProgressLayer() {
        RotateProgressLayer rotateProgressLayer = new RotateProgressLayer();
        rotateProgressLayer.setShader(createShader());
        int relativeSizeByStyle = getRelativeSizeByStyle(this.mContext, 72);
        int relativeSizeByStyle2 = getRelativeSizeByStyle(this.mContext, 120);
        rotateProgressLayer.setWidth(relativeSizeByStyle);
        rotateProgressLayer.setHeight(relativeSizeByStyle2);
        rotateProgressLayer.setX(getX());
        rotateProgressLayer.setY(getY());
        return rotateProgressLayer;
    }

    private Animator createRotationXAnimatorStep1() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setRotationDegrees(0.0f, 30.0f);
        rotationXAnimator.setLocation(0.0f, 0.0f, -4.0f);
        GroupAnimator groupAnimator = new GroupAnimator(this, rotationXAnimator, new RotatePhoneProgressAnimator(this, 0.0f, 0.3f));
        groupAnimator.setDuration(720L);
        groupAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        return groupAnimator;
    }

    private Animator createRotationXAnimatorStep2() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setRotationDegrees(30.0f, 0.0f);
        rotationXAnimator.setLocation(0.0f, 0.0f, -4.0f);
        GroupAnimator groupAnimator = new GroupAnimator(this, rotationXAnimator, new RotatePhoneProgressAnimator(this, 0.3f, 0.0f));
        groupAnimator.setDuration(400L);
        groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        return groupAnimator;
    }

    private RotationXAnimator createRotationXAnimatorStep3() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setDuration(560L);
        rotationXAnimator.setRotationDegrees(0.0f, 0.0f);
        rotationXAnimator.setLocation(0.0f, 0.0f, -4.0f);
        return rotationXAnimator;
    }

    private Shader createShader() {
        return new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{1358954495, 1358954495}, (float[]) null, Shader.TileMode.MIRROR);
    }

    private int getRelativeSizeByStyle(Context context, int i3) {
        if (isPadStyle()) {
            return Utils.getRelativeSize1334(context, i3);
        }
        return Utils.getRelativeSize(context, i3);
    }

    private boolean isPadStyle() {
        if (this.mStyle == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        KeepRotateAndProgressAnimator keepRotateAndProgressAnimator = this.mKeepRotateAndProgressAnimator;
        if (keepRotateAndProgressAnimator != null) {
            keepRotateAndProgressAnimator.updateProgress(f16);
        }
    }

    public void postRotateX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        super.postRotationX(f16);
        KeepRotateAndProgressAnimator keepRotateAndProgressAnimator = this.mKeepRotateAndProgressAnimator;
        if (keepRotateAndProgressAnimator != null) {
            keepRotateAndProgressAnimator.updateRotateX(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.mPhoneLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setX(f16);
        }
        PathShapeLayer pathShapeLayer = this.mProgressLayer;
        if (pathShapeLayer != null) {
            pathShapeLayer.setX(this.mProgressOffsetX + f16);
        }
        return super.setX(f16);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.mPhoneLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setY(f16);
        }
        PathShapeLayer pathShapeLayer = this.mProgressLayer;
        if (pathShapeLayer != null) {
            pathShapeLayer.setY(this.mProgressOffsetY + f16);
        }
        return super.setY(f16);
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            setAnimator(this.mKeepRotateAndProgressAnimator);
        }
    }
}
