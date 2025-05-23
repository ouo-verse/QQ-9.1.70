package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.twist.TwistAnimationHelper;
import com.tencent.ams.fusion.widget.twist.TwistAnimatorViewHelper;
import com.tencent.ams.fusion.widget.twist.TwistRotationHandler;
import com.tencent.ams.fusion.widget.twist.TwistView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicTwistView extends OlympicCarouselView implements TwistRotationHandler.TwistCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_REVERSE_TEXT = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    private static final String PHONE_ICON = "iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAYAAACOEfKtAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAHxSURBVHgB7dzRTQJBFIXhs8YCtAOoQK1AOsAOpAOwArEDS5AKxAqgA7UC6ECs4Ho3y4PRBwfP3dlZcr5kwguJkz/r7vIwFxAREfmnCpmY2Zl/nCGPXVVVO2TQakCPNvKPsa8bXwPktfW19rXwmGv0SR3O18rKsfE1QB/4RqdWrnuUrN6gla/MiFb2lffTDEFCHiLW3F826I/6CX3lD5ctSCeIUfa95bf6dSpkz/QV2MOr77tz9n0x4gocob8mIJ2CNz7gu7v9atMhv3gu0DVLf2F+Rib+tx4T9/SKrlnzlp/iEpnU9+XEPdH37qincIosP+5zyxnwKCkgSQFJCkhSQJICkhSQpIAkBSQpIEkBSQpIUkCSApIUkKSAJAUkKSBJAUkKSFJAkgKSFJCkgCQFJCkgSQFJCkhSQJICkhSQpIAkBSQpIEkBSQpIUkCSApIUkKSAJAUkKSBJAUnHGjDXgJ+QgKmHCKfIJ/U4/xakiAPX775SjrLOzGyCsg5cf4IUEfDN123id3POz0qxBCli6EQd5AP9NGRHn9D3wP3UiwX65ylibkzk4J16/kBJ/55/GRYzeGe/kQf0x11EvHB+Jc6tfHOUzMqOGDZ0rFXWjB3ZWDlW1kzTDJdjBOjE1zW6GQH64mvZ5ghQDaEVERHpyhf89FLXZQDT7QAAAABJRU5ErkJggg==";
    private static final int PHONE_ICON_WIDTH = 40;
    private static final int RING_RATIO_DP = 31;
    private static final int RING_STROKE_WIDTH_DP = 6;
    private static final String TAG = "OlympicTwistView";
    private int mDirection;
    private boolean mEntranceAnimationFinished;
    private RotationAnimator mKeepRotationAnimator;
    protected float mPhoneHeight;
    private AnimatorLayer mPhoneLayer;
    protected float mPhoneWidth;
    protected float mRingCenterX;
    protected float mRingCenterY;
    private ProgressAnimator mRingProgressAnimator;
    private RingShapeLayer mRingProgressLayer;
    protected float mRingRatio;
    private RingShapeLayer mRingShapeLayer;
    protected float mRingStokeWidth;
    private RotationSensor mSensor;
    private float mTargetAngle;
    private List<PathShapeLayer> mTriangleBgLayerList;
    protected float mTriangleWidth;
    private TwistView.ITwistInteractListener mTwistInteractListener;
    private TwistRotationHandler mTwistRotationListener;

    public OlympicTwistView(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.mTargetAngle = 90.0f;
            this.mDirection = 2;
        }
    }

    private void createEntranceAnimation() {
        showLayer(this.mTitleLayer);
        showLayer(this.mSubTitleLayer);
        showLayer(this.mRingShapeLayer, r0.getAlpha() / 255.0f);
        if (!Utils.isEmpty(this.mTriangleBgLayerList)) {
            for (PathShapeLayer pathShapeLayer : this.mTriangleBgLayerList) {
                if (pathShapeLayer != null) {
                    showLayer(pathShapeLayer, pathShapeLayer.getAlpha() / 255.0f);
                }
            }
        }
        RingShapeLayer ringShapeLayer = this.mRingProgressLayer;
        if (ringShapeLayer != null) {
            AlphaAnimator alphaAnimator = new AlphaAnimator(ringShapeLayer, 0.0f, 1.0f);
            alphaAnimator.setDuration(1000L);
            alphaAnimator.setStartDelay(300L);
            alphaAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicTwistView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicTwistView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        OlympicTwistView.this.mEntranceAnimationFinished = true;
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            this.mRingProgressLayer.setAnimator(new GroupAnimator(this.mRingProgressLayer, alphaAnimator, this.mRingProgressAnimator));
        }
        AnimatorLayer animatorLayer = this.mPhoneLayer;
        if (animatorLayer != null) {
            AlphaAnimator alphaAnimator2 = new AlphaAnimator(animatorLayer, 0.0f, 1.0f);
            alphaAnimator2.setDuration(1000L);
            alphaAnimator2.setStartDelay(300L);
            this.mPhoneLayer.setAnimator(new GroupAnimator(this.mPhoneLayer, alphaAnimator2, TwistAnimationHelper.getGuidAnimator(this.mPhoneLayer, this.mDirection, new Animator.AnimatorProgressListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicTwistView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicTwistView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
                public void onAnimationProgressUpdate(float f16) {
                    float f17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                        return;
                    }
                    if (OlympicTwistView.this.mDirection == 2) {
                        f17 = 45.0f;
                    } else {
                        f17 = 150.0f;
                    }
                    OlympicTwistView olympicTwistView = OlympicTwistView.this;
                    olympicTwistView.handleRingProgress(Math.abs(olympicTwistView.mPhoneLayer.getRotationDegrees()) / f17);
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
                public int updateInterval() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                    }
                    return 0;
                }
            })));
        }
    }

    private int getPhoneIconX() {
        return (int) (getTextX() - Utils.dp2px(58.0f));
    }

    private int getPhoneIconY() {
        return (int) (((getSubTextY() - this.mSubTitleTextSize) - (Utils.dp2px(40.0f) / 2.0f)) + Utils.dp2px(3.0f));
    }

    private void handleInteractSuccess() {
        TwistView.ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractResult(true);
        }
        this.mGalleryView.onInteractiveSucceed();
        this.mSensor.stop();
        this.mInteractiveSucceed = true;
    }

    private void handlePhoneRotation(float f16, float f17) {
        Animator animator;
        AnimatorLayer animatorLayer = this.mPhoneLayer;
        if (animatorLayer == null) {
            return;
        }
        if (f17 > 0.0f) {
            f16 = -f16;
        }
        float f18 = f16 * 45.0f;
        RotationAnimator rotationAnimator = this.mKeepRotationAnimator;
        if (rotationAnimator == null) {
            Animator animator2 = animatorLayer.getAnimator();
            float rotationDegrees = this.mPhoneLayer.getRotationDegrees();
            RotationAnimator rotationAnimator2 = new RotationAnimator(this.mPhoneLayer);
            rotationAnimator2.setRepeatCount(1);
            rotationAnimator2.setDuration(60L);
            rotationAnimator2.setRotationDegrees(rotationDegrees, f18);
            if (animator2 instanceof GroupAnimator) {
                GroupAnimator groupAnimator = new GroupAnimator(this.mPhoneLayer, new Animator[0]);
                List<Animator> animators = ((GroupAnimator) animator2).getAnimators();
                if (!Utils.isEmpty(animators)) {
                    animator = animators.get(0);
                } else {
                    animator = null;
                }
                groupAnimator.addAnimators(animator, rotationAnimator2);
                this.mPhoneLayer.setAnimator(groupAnimator);
            } else if (animator2 != null) {
                animator2.cancelAnimation();
                this.mPhoneLayer.setAnimator(rotationAnimator2);
            }
            this.mKeepRotationAnimator = rotationAnimator2;
            return;
        }
        rotationAnimator.setDuration(0L);
        rotationAnimator.setRotationDegrees(f18, f18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRingProgress(float f16) {
        if (f16 == 0.0f) {
            f16 = 0.01f;
        }
        ProgressAnimator progressAnimator = this.mRingProgressAnimator;
        if (progressAnimator != null) {
            progressAnimator.setFromProgress(f16);
            this.mRingProgressAnimator.setToProgress(f16);
        }
        if (this.mDirection == 2 && this.mRingProgressLayer != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleRingProgress progress:");
            sb5.append(f16);
            sb5.append(" StartAngle :");
            float f17 = (-90.0f) - (f16 * 45.0f);
            sb5.append(f17);
            Logger.d(TAG, sb5.toString());
            this.mRingProgressLayer.setStartAngle(f17);
        }
    }

    private void setProgress(float f16, int i3) {
        float f17 = i3 / 100.0f;
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > 1.0f) {
            f17 = 1.0f;
        }
        handleRingProgress(f17);
        handlePhoneRotation(f17, f16);
        if (!Utils.isEmpty(this.mTriangleBgLayerList)) {
            for (PathShapeLayer pathShapeLayer : this.mTriangleBgLayerList) {
                if (pathShapeLayer != null && this.mEntranceAnimationFinished) {
                    if (f17 >= 1.0f) {
                        pathShapeLayer.postAlpha(255);
                    } else {
                        pathShapeLayer.postAlpha(153);
                    }
                    pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
                }
            }
        }
    }

    protected void calculateUISize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mPhoneWidth = Utils.dp2px(40.0f);
        this.mPhoneHeight = Utils.dp2px(40.0f);
        this.mRingCenterX = getPhoneIconX() + (this.mPhoneWidth / 2.0f);
        this.mRingCenterY = getPhoneIconY() + (this.mPhoneHeight / 2.0f);
        this.mRingRatio = Utils.dp2px(31.0f);
        this.mRingStokeWidth = Utils.dp2px(6.0f);
        this.mTriangleWidth = Utils.dp2px(12.0f) * 1.414f;
        Logger.i(TAG, "calculateUISize mRingCenterX:" + this.mRingCenterX + " mRingCenterY:" + this.mRingCenterY);
    }

    protected AnimatorLayer createPhoneLayer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        AnimatorLayer iconAnimatorLayer = TwistAnimationHelper.getIconAnimatorLayer(str, new TwistAnimationHelper.IconParams(getPhoneIconX(), getPhoneIconY(), Utils.dp2px(40.0f), Utils.dp2px(40.0f)));
        this.mPhoneLayer = iconAnimatorLayer;
        this.mKeepRotationAnimator = null;
        return iconAnimatorLayer;
    }

    protected AnimatorLayer createRingBgLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        }
        RingShapeLayer createRingBgLayer = TwistAnimatorViewHelper.createRingBgLayer(f16, this.mRingCenterX, this.mRingCenterY, this.mRingStokeWidth);
        this.mRingShapeLayer = createRingBgLayer;
        return createRingBgLayer;
    }

    protected AnimatorLayer createRingProgressLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        }
        RingShapeLayer createRingProgressLayer = TwistAnimatorViewHelper.createRingProgressLayer(f16, this.mDirection, this.mRingCenterX, this.mRingCenterY, this.mRingStokeWidth);
        this.mRingProgressLayer = createRingProgressLayer;
        createRingProgressLayer.postProgress(0.01f);
        this.mRingProgressAnimator = (ProgressAnimator) this.mRingProgressLayer.getAnimator();
        return this.mRingProgressLayer;
    }

    protected PathShapeLayer createTriangleLayer(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PathShapeLayer) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Float.valueOf(f16));
        }
        return TwistAnimatorViewHelper.createTriangleLayer(i3, f16, this.mRingCenterX, this.mRingCenterY, this.mTriangleWidth);
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    protected void hideBottomIconAndTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.mTitleLayer != null && this.mSubTitleLayer != null && this.mPhoneLayer != null && this.mRingShapeLayer != null && this.mRingProgressLayer != null && !Utils.isEmpty(this.mTriangleBgLayerList)) {
            Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicTwistView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicTwistView.this);
                    }
                }

                private AlphaAnimator getAlphaAnimator(AnimatorLayer animatorLayer) {
                    if (animatorLayer == null) {
                        return null;
                    }
                    int alpha = animatorLayer.getAlpha();
                    Logger.i(OlympicTwistView.TAG, " getAlphaAnimator " + alpha);
                    AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, ((float) alpha) / 255.0f, 0.0f);
                    alphaAnimator.setDuration(300L);
                    return alphaAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!Utils.isEmpty(OlympicTwistView.this.mTriangleBgLayerList)) {
                        for (PathShapeLayer pathShapeLayer : OlympicTwistView.this.mTriangleBgLayerList) {
                            if (pathShapeLayer != null) {
                                pathShapeLayer.setAnimator(getAlphaAnimator(pathShapeLayer));
                            }
                        }
                    }
                    AlphaAnimator alphaAnimator = getAlphaAnimator(OlympicTwistView.this.mTitleLayer);
                    AlphaAnimator alphaAnimator2 = getAlphaAnimator(OlympicTwistView.this.mSubTitleLayer);
                    AlphaAnimator alphaAnimator3 = getAlphaAnimator(OlympicTwistView.this.mPhoneLayer);
                    AlphaAnimator alphaAnimator4 = getAlphaAnimator(OlympicTwistView.this.mRingProgressLayer);
                    AlphaAnimator alphaAnimator5 = getAlphaAnimator(OlympicTwistView.this.mRingShapeLayer);
                    RotationAnimator rotationAnimator = new RotationAnimator(OlympicTwistView.this.mPhoneLayer);
                    rotationAnimator.setDuration(0L);
                    rotationAnimator.setRotationDegrees(OlympicTwistView.this.mPhoneLayer.getRotationDegrees(), OlympicTwistView.this.mPhoneLayer.getRotationDegrees());
                    GroupAnimator groupAnimator = new GroupAnimator(OlympicTwistView.this.mPhoneLayer, new Animator[0]);
                    groupAnimator.addAnimators(alphaAnimator3, rotationAnimator);
                    groupAnimator.setDuration(300L);
                    OlympicTwistView.this.mTitleLayer.setAnimator(alphaAnimator);
                    OlympicTwistView.this.mSubTitleLayer.setAnimator(alphaAnimator2);
                    OlympicTwistView.this.mRingShapeLayer.setAnimator(alphaAnimator5);
                    OlympicTwistView.this.mRingProgressLayer.setAnimator(alphaAnimator4);
                    OlympicTwistView.this.mPhoneLayer.setAnimator(groupAnimator);
                }
            }, 500L);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    protected void initViews(@NonNull Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mSensor = new RotationSensor(getContext(), false);
        TwistRotationHandler twistRotationHandler = new TwistRotationHandler(this);
        this.mTwistRotationListener = twistRotationHandler;
        this.mSensor.setOnRotationChangeListener(twistRotationHandler);
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onBackInteractProgress(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        setProgress(f16, i3);
        changeText(this.mTitleLayer, "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c");
        TwistView.ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onBackInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractProgress(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        setProgress(f16, i3);
        TwistView.ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        TwistView.ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            handleInteractSuccess();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.pause();
            this.mSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.resume();
            this.mSensor.resume();
        }
    }

    public void setDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            Logger.w(TAG, "invalid direction: " + i3);
            return;
        }
        this.mDirection = i3;
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setDirection(i3);
        }
    }

    public void setReverseAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            Logger.i(TAG, "invalid reverseAngle");
            return;
        }
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setReverseAngle(f16);
        }
    }

    public void setTargetAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            Logger.i(TAG, "invalid targetAngle");
            return;
        }
        this.mTargetAngle = f16;
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setTargetAngle(f16);
        }
    }

    public void setTwistInteractListener(TwistView.ITwistInteractListener iTwistInteractListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iTwistInteractListener);
        } else {
            this.mTwistInteractListener = iTwistInteractListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        PathShapeLayer createBgShaderLayer = createBgShaderLayer();
        this.mBgShaderLayer = createBgShaderLayer;
        arrayList.add(createBgShaderLayer);
        TextLayer createTitleTextLayer = createTitleTextLayer();
        this.mTitleLayer = createTitleTextLayer;
        arrayList.add(createTitleTextLayer);
        TextLayer createSubTitleTextLayer = createSubTitleTextLayer();
        this.mSubTitleLayer = createSubTitleTextLayer;
        arrayList.add(createSubTitleTextLayer);
        calculateUISize();
        arrayList.add(createPhoneLayer(PHONE_ICON));
        arrayList.add(createRingBgLayer(this.mRingRatio));
        ArrayList arrayList2 = new ArrayList();
        this.mTriangleBgLayerList = arrayList2;
        int i3 = this.mDirection;
        if (i3 == 2) {
            arrayList2.add(createTriangleLayer(0, this.mRingRatio));
            this.mTriangleBgLayerList.add(createTriangleLayer(1, this.mRingRatio));
        } else {
            arrayList2.add(createTriangleLayer(i3, this.mRingRatio));
        }
        arrayList.addAll(this.mTriangleBgLayerList);
        arrayList.add(createRingProgressLayer(this.mRingRatio));
        createEntranceAnimation();
        GroupLayer groupLayer = new GroupLayer((AnimatorLayer[]) arrayList.toArray(new AnimatorLayer[0]));
        this.mAnimatableView.clearLayers();
        this.mAnimatableView.addLayer(groupLayer);
        this.mAnimatableView.startAnimation();
        this.mGalleryView.start();
        this.mSensor.start();
        Logger.i(TAG, "start() ...");
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.stop();
            this.mSensor.stop();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void stopInteractive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        }
    }
}
