package com.tencent.ams.fusion.widget.worldcupslide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WaveBgAnimatorLayer extends PathShapeLayer implements WorldCupSlideView.InteractListener {
    static IPatchRedirector $redirector_;
    private int mBottomEndPaddingBottom;
    private int mBottomPointMoveDistance;
    private int mBottomStartPaddingBottom;
    private int mC1EndYPaddingBottom;
    private int mC1StartYPaddingBottom;
    private int mC1XEnd;
    private int mC1XMoveDistance;
    private int mC1XStart;
    private int mC1YMoveDistance;
    private int mC2XEnd;
    private int mC2XMoveDistance;
    private int mC2XStart;
    private Animator mEndAnimator;
    private boolean mIsDisappear;
    private float mProgress;
    private Animator mShakeAnimator;
    private float mSlideMaxDistance;
    private int mTopEndPaddingBottom;
    private int mTopPointMoveDistance;
    private int mTopStartPaddingBottom;
    private Animator mTouchAnimator;
    private float mTouchStartY;

    public WaveBgAnimatorLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Animator createEndAnimator(AnimatorLayer animatorLayer) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 1.0f, 0.0f);
        alphaAnimator.setDuration(400L);
        alphaAnimator.setPathInterpolator(0.33f, 1.0f, 0.68f, 1.0f);
        return alphaAnimator;
    }

    private Animator createGoBackAnimator(AnimatorLayer animatorLayer) {
        GroupAnimator groupAnimator = new GroupAnimator(animatorLayer, new Animator[0]);
        ProgressAnimator progressAnimator = new ProgressAnimator(animatorLayer, this.mProgress, 0.0f);
        progressAnimator.setDuration(300L);
        progressAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        groupAnimator.addAnimators(progressAnimator);
        if (!this.mIsDisappear) {
            AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, animatorLayer.getAlpha() / 255.0f, 1.0f);
            alphaAnimator.setDuration(300L);
            alphaAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
            groupAnimator.addAnimators(alphaAnimator);
        }
        groupAnimator.setDuration(300L);
        groupAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.WaveBgAnimatorLayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WaveBgAnimatorLayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    WaveBgAnimatorLayer waveBgAnimatorLayer = WaveBgAnimatorLayer.this;
                    waveBgAnimatorLayer.setAnimator(waveBgAnimatorLayer.mShakeAnimator);
                }
            }
        });
        return groupAnimator;
    }

    private Shader createShader() {
        return new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{-1291845632, 1291845632, 0}, (float[]) null, Shader.TileMode.MIRROR);
    }

    private Animator createShakeAnimator(AnimatorLayer animatorLayer) {
        ProgressAnimator progressAnimator = new ProgressAnimator(animatorLayer, 0.0f, 0.35f);
        progressAnimator.setDuration(600L);
        progressAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        progressAnimator.setRepeatMode(2);
        progressAnimator.setRepeatCount(0);
        return progressAnimator;
    }

    private void initPosition(Context context) {
        this.mBottomStartPaddingBottom = Utils.getRelativeSize(context, 256);
        this.mBottomEndPaddingBottom = Utils.getRelativeSize(context, 318);
        this.mTopStartPaddingBottom = Utils.getRelativeSize(context, 424);
        this.mTopEndPaddingBottom = Utils.getRelativeSize(context, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
        this.mC1XStart = Utils.getRelativeSize(context, 208);
        this.mC1XEnd = Utils.getRelativeSize(context, 184);
        this.mC1StartYPaddingBottom = Utils.getRelativeSize(context, 322);
        this.mC1EndYPaddingBottom = Utils.getRelativeSize(context, 410);
        this.mC2XStart = Utils.getRelativeSize(context, 248);
        int relativeSize = Utils.getRelativeSize(context, 253);
        this.mC2XEnd = relativeSize;
        this.mBottomPointMoveDistance = this.mBottomEndPaddingBottom - this.mBottomStartPaddingBottom;
        this.mTopPointMoveDistance = this.mTopEndPaddingBottom - this.mTopStartPaddingBottom;
        this.mC1XMoveDistance = this.mC1XEnd - this.mC1XStart;
        this.mC1YMoveDistance = this.mC1EndYPaddingBottom - this.mC1StartYPaddingBottom;
        this.mC2XMoveDistance = relativeSize - this.mC2XStart;
        this.mIsDisappear = false;
    }

    private void updatePath(float f16) {
        Path path = this.mPath;
        if (path == null) {
            return;
        }
        float height = getHeight() - (this.mBottomStartPaddingBottom + (this.mBottomPointMoveDistance * f16));
        float height2 = getHeight() - (this.mTopStartPaddingBottom + (this.mTopPointMoveDistance * f16));
        float f17 = this.mC1XStart + (this.mC1XMoveDistance * f16);
        float height3 = getHeight() - (this.mC1StartYPaddingBottom + (this.mC1YMoveDistance * f16));
        float f18 = this.mC2XStart + (this.mC2XMoveDistance * f16);
        float[] fArr = {0.0f, getHeight()};
        float[] fArr2 = {getWidth(), getHeight()};
        float[] fArr3 = {0.0f, height};
        float[] fArr4 = {f17, height3};
        float[] fArr5 = {f18, height2};
        float[] fArr6 = {getWidth() / 2.0f, height2};
        float[] fArr7 = {getWidth() - f18, height2};
        float[] fArr8 = {getWidth() - f17, height3};
        float[] fArr9 = {getWidth(), height};
        path.reset();
        path.moveTo(fArr[0], fArr[1]);
        path.lineTo(fArr3[0], fArr3[1]);
        path.cubicTo(fArr4[0], fArr4[1], fArr5[0], fArr5[1], fArr6[0], fArr6[1]);
        path.cubicTo(fArr7[0], fArr7[1], fArr8[0], fArr8[1], fArr9[0], fArr9[1]);
        path.lineTo(fArr2[0], fArr2[1]);
        path.lineTo(fArr[0], fArr[1]);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
        } else {
            updatePath(this.mProgress);
            super.draw(canvas);
        }
    }

    public void init(Context context, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        initPosition(context);
        setWidth(i3);
        setHeight(i16);
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        setPath(path);
        updatePath(0.0f);
        setShader(createShader());
        setStyle(Paint.Style.FILL);
        this.mShakeAnimator = createShakeAnimator(this);
        this.mTouchAnimator = new KeepAnimator(this);
        this.mEndAnimator = createEndAnimator(this);
        setAnimator(this.mShakeAnimator);
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            setAnimator(createGoBackAnimator(this));
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onTouch(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            return;
        }
        if (motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float y16 = motionEvent.getY();
                float f16 = this.mTouchStartY;
                if (y16 <= f16) {
                    float f17 = f16 - y16;
                    float f18 = this.mSlideMaxDistance;
                    if (f17 >= f18) {
                        postProgress(1.0f);
                        return;
                    } else {
                        if (f18 > 0.0f) {
                            postProgress((f16 - y16) / f18);
                            return;
                        }
                        return;
                    }
                }
                postProgress(0.0f);
                return;
            }
            return;
        }
        this.mTouchStartY = motionEvent.getY();
        setAnimator(this.mTouchAnimator);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        this.mProgress = f16;
        if (f16 >= 1.0f) {
            setAnimator(this.mEndAnimator);
            this.mIsDisappear = true;
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mIsDisappear = false;
        reset();
        Animator animator = this.mShakeAnimator;
        if (animator != null) {
            animator.reset();
        }
        Animator animator2 = this.mTouchAnimator;
        if (animator2 != null) {
            animator2.reset();
        }
        Animator animator3 = this.mEndAnimator;
        if (animator3 != null) {
            animator3.reset();
        }
        setAnimator(this.mShakeAnimator);
    }

    public void setSlideMaxDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mSlideMaxDistance = f16;
        }
    }
}
