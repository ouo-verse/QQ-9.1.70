package com.tencent.ams.fusion.widget.flip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationYAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.base.AnimatableView;
import com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipView extends FrameLayout implements IAnimatorViewHandler, AnimatableView {
    static IPatchRedirector $redirector_ = null;
    private static final int ALPHA_IDLE_ARROW_BG = 102;
    private static final float ARROW_LINE_HEIGHT_RATIO = 0.33333334f;
    private static final float ARROW_LINE_WIDTH_RATIO = 0.75f;
    private static final int COLOR_TITLE = -1;
    private static final int DEFAULT_BG_SHADER_COLOR_END;
    private static final int DEFAULT_BG_SHADER_COLOR_START;
    public static final float DEFAULT_REVERSE_ROTATION_THRESHOLD = 0.0f;
    public static final String DEFAULT_REVERSE_TITLE_TEXT = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    public static final float DEFAULT_TARGET_ROTATION_THRESHOLD = 45.0f;
    protected static final long DURATION_ENTRANCE_STEP1_MS = 542;
    protected static final long DURATION_ENTRANCE_STEP2_MS = 583;
    protected static final long DURATION_ENTRANCE_STEP3_MS = 500;
    public static final int LOCATION_Z_CAMERA_PX = -10;
    private static final String TAG = "FlipView";
    private final int COLOR_SUBTITLE;
    private final int DEFAULT_BG_SHADER_HEIGHT_PX;
    protected final int HEIGHT_ARROW_PX;
    private final int OFFSET_CENTER_X_ARROW_PX;
    private final float RADIUS_ARROW_LINE;
    private final float RADIUS_ARROW_TRIANGLE;
    private final int SIZE_PHONE_ICON_PX;
    private final int TEXT_SIZE_SUBTITLE_PX;
    private final int TEXT_SIZE_TITLE_PX;
    protected final int WIDTH_ARROW_PX;
    protected final AnimatorView mAnimatorView;
    protected PathShapeLayer mBgShaderLayer;
    private final View mClickArea;
    private FlipPhoneLayer mFlipPhoneLayer;
    private final FlipRotationHandler mFlipRotationHandler;
    private final FlipRotationHandler.IFlipRotationListener mFlipRotationListener;
    private int mHotAreaBottomMargin;
    private int mHotAreaHeight;
    private int mHotAreaLeftMargin;
    private int mHotAreaRightMargin;
    protected boolean mIsInteractFinished;
    protected boolean mIsInteractStart;
    private boolean mIsShowingEntranceAnimation;
    protected boolean mIsUserStarted;
    protected ArrowShapeLayer mLeftArrowBgLayer;
    protected ArrowShapeLayer mLeftArrowFrontLayer;

    @Nullable
    private IFlipInteractiveListener mListener;
    private float mReverseRotationThreshold;
    private String mReverseTitleText;
    protected ArrowShapeLayer mRightArrowBgLayer;
    protected ArrowShapeLayer mRightArrowFrontLayer;
    private final RotationSensor mSensor;
    private String mSubTitleText;
    private float mSubtitleMarginBottomDp;
    protected TextLayer mSubtitleTextLayer;
    private float mTargetRotationThreshold;
    private String mTitleText;
    protected TextLayer mTitleTextLayer;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37398);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            DEFAULT_BG_SHADER_COLOR_START = Color.parseColor("#00000000");
            DEFAULT_BG_SHADER_COLOR_END = Color.parseColor("#80000000");
        }
    }

    public FlipView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private AlphaAnimator createAlphaAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3, float f18, float f19, float f26, float f27) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, f16, f17);
        alphaAnimator.setDuration(j3);
        alphaAnimator.setPathInterpolator(f18, f19, f26, f27);
        return alphaAnimator;
    }

    private ArrowShapeLayer createArrowLayer(int i3, int i16, int i17, int i18) {
        ArrowShapeLayer arrowShapeLayer = new ArrowShapeLayer();
        arrowShapeLayer.init(i3, i16, this.WIDTH_ARROW_PX, this.HEIGHT_ARROW_PX, i18, i17, ARROW_LINE_HEIGHT_RATIO, 0.75f, this.RADIUS_ARROW_LINE, this.RADIUS_ARROW_TRIANGLE);
        arrowShapeLayer.setAnimator(new KeepAnimator(arrowShapeLayer));
        return arrowShapeLayer;
    }

    private AlphaAnimator createEntranceAlphaAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        return createAlphaAnimator(animatorLayer, f16, f17, j3, 0.33f, 0.0f, 0.67f, 1.0f);
    }

    private RotationYAnimator createEntranceRotationYAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        RotationYAnimator rotationYAnimator = new RotationYAnimator(animatorLayer);
        rotationYAnimator.setRotationDegrees(f16, f17);
        rotationYAnimator.setDuration(j3);
        rotationYAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        rotationYAnimator.setLocation(0.0f, 0.0f, -10.0f);
        return rotationYAnimator;
    }

    private FlipPhoneLayer createPhoneLayer() {
        FlipPhoneLayer flipPhoneLayer = new FlipPhoneLayer();
        int height = (getHeight() - getPhoneIconMarginBottomPx()) - (this.SIZE_PHONE_ICON_PX / 2);
        Context context = getContext();
        int i3 = this.SIZE_PHONE_ICON_PX;
        flipPhoneLayer.init(context, (int) (getWidth() / 2.0f), height, i3, i3, -10);
        flipPhoneLayer.setAnimator(new KeepAnimator(flipPhoneLayer));
        return flipPhoneLayer;
    }

    private TextLayer createTextLayer(String str, int i3, float f16, float f17, float f18, boolean z16) {
        Logger.i(TAG, "createTextLayer, x" + f17 + ", y:" + f18);
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private int getPhoneIconMarginBottomPx() {
        return getTitleMarginBottomPx() + ((int) Utils.dp2px(37.0f));
    }

    private int getSubtitleMarginBottomPx() {
        return (int) Utils.dp2px(this.mSubtitleMarginBottomDp);
    }

    private int getTitleMarginBottomPx() {
        return getSubtitleMarginBottomPx() + ((int) Utils.dp2px(24.0f));
    }

    private void initClickArea() {
        int i3 = this.mHotAreaHeight;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = this.mHotAreaLeftMargin;
        layoutParams.rightMargin = this.mHotAreaRightMargin;
        layoutParams.bottomMargin = this.mHotAreaBottomMargin;
        this.mClickArea.setLayoutParams(layoutParams);
        if (i3 <= 0) {
            this.mClickArea.setOnClickListener(null);
        } else {
            this.mClickArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.flip.FlipView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlipView.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        FlipView.this.notifyClickSuccess();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClickSuccess() {
        if (this.mIsInteractFinished) {
            return;
        }
        this.mIsInteractFinished = true;
        tryStopEntranceAnimation();
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        }
        IFlipInteractiveListener iFlipInteractiveListener = this.mListener;
        if (iFlipInteractiveListener != null) {
            iFlipInteractiveListener.onInteractStart(1);
            iFlipInteractiveListener.onInteractResult(1, true);
        }
    }

    private void stopLayerAnimation(AnimatorLayer animatorLayer) {
        if (animatorLayer == null) {
            return;
        }
        Animator animator = animatorLayer.getAnimator();
        if (animator != null) {
            animator.cancelAnimation();
        }
        animatorLayer.setAnimator(new KeepAnimator(animatorLayer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PathShapeLayer createBgShaderLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (PathShapeLayer) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        int i3 = this.DEFAULT_BG_SHADER_HEIGHT_PX;
        int[] iArr = {DEFAULT_BG_SHADER_COLOR_START, DEFAULT_BG_SHADER_COLOR_END};
        int width = getWidth();
        int height = getHeight();
        float f16 = height - i3;
        float f17 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f16, 0.0f, f17, iArr, (float[]) null, Shader.TileMode.MIRROR);
        Path path = new Path();
        path.moveTo(0.0f, f16);
        path.lineTo(0.0f, f17);
        float f18 = width;
        path.lineTo(f18, f17);
        path.lineTo(f18, f16);
        path.lineTo(0.0f, f16);
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, linearGradient, Paint.Style.FILL);
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    protected GroupLayer createGroupLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (GroupLayer) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        this.mTitleTextLayer = createTitleTextLayer();
        this.mSubtitleTextLayer = createSubTitleTextLayer();
        this.mLeftArrowBgLayer = createLeftArrow();
        this.mRightArrowBgLayer = createRightArrow();
        this.mLeftArrowFrontLayer = createLeftArrow();
        this.mRightArrowFrontLayer = createRightArrow();
        this.mLeftArrowBgLayer.postProgress(1.0f);
        this.mRightArrowBgLayer.postProgress(1.0f);
        this.mLeftArrowFrontLayer.postProgress(0.0f);
        this.mRightArrowFrontLayer.postProgress(0.0f);
        this.mFlipPhoneLayer = createPhoneLayer();
        PathShapeLayer createBgShaderLayer = createBgShaderLayer();
        this.mBgShaderLayer = createBgShaderLayer;
        return new GroupLayer(createBgShaderLayer, this.mTitleTextLayer, this.mSubtitleTextLayer, this.mLeftArrowBgLayer, this.mRightArrowBgLayer, this.mLeftArrowFrontLayer, this.mRightArrowFrontLayer, this.mFlipPhoneLayer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrowShapeLayer createLeftArrow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ArrowShapeLayer) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return createArrowLayer(getLeftArrowShapeLayerCenterX(), getArrowShapeLayerCenterY(), -1, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrowShapeLayer createRightArrow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ArrowShapeLayer) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return createArrowLayer(getRightArrowShapeLayerCenterX(), getArrowShapeLayerCenterY(), -1, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextLayer createSubTitleTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (TextLayer) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return createTextLayer(this.mSubTitleText, this.COLOR_SUBTITLE, this.TEXT_SIZE_SUBTITLE_PX, getWidth() / 2.0f, getHeight() - getSubtitleMarginBottomPx(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextLayer createTitleTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (TextLayer) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return createTextLayer(this.mTitleText, -1, this.TEXT_SIZE_TITLE_PX, getWidth() / 2.0f, getHeight() - getTitleMarginBottomPx(), true);
    }

    protected int getArrowShapeLayerCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return (getHeight() - getPhoneIconMarginBottomPx()) - (this.SIZE_PHONE_ICON_PX / 2);
    }

    protected int getLeftArrowShapeLayerCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (int) ((getWidth() / 2.0f) - this.OFFSET_CENTER_X_ARROW_PX);
    }

    public String getReverseTitleText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (TextUtils.isEmpty(this.mReverseTitleText)) {
            return DEFAULT_REVERSE_TITLE_TEXT;
        }
        return this.mReverseTitleText;
    }

    protected int getRightArrowShapeLayerCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (int) ((getWidth() / 2.0f) + this.OFFSET_CENTER_X_ARROW_PX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mSensor.setOnRotationChangeListener(this.mFlipRotationHandler);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.mSensor.setOnRotationChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mIsUserStarted && !this.mIsInteractFinished) {
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mAnimatorView.pauseAnimation();
            this.mSensor.pause();
        }
    }

    protected void postUpdateProgress(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mAnimatorView.postOnAnimation(new Runnable(f17, f16) { // from class: com.tencent.ams.fusion.widget.flip.FlipView.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$progress;
                final /* synthetic */ float val$rotationY;

                {
                    this.val$progress = f17;
                    this.val$rotationY = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlipView.this, Float.valueOf(f17), Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    float f18 = this.val$progress;
                    if (f18 >= 0.0f) {
                        FlipView.this.mRightArrowFrontLayer.postProgress(f18);
                        FlipView.this.mLeftArrowFrontLayer.postProgress(0.0f);
                    } else {
                        FlipView.this.mRightArrowFrontLayer.postProgress(0.0f);
                        FlipView.this.mLeftArrowFrontLayer.postProgress(-this.val$progress);
                    }
                    FlipView.this.mFlipPhoneLayer.postRotationY(this.val$rotationY);
                }
            });
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mAnimatorView.clearLayers();
            this.mAnimatorView.stopAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mAnimatorView.resumeAnimation();
            this.mSensor.resume();
        }
    }

    public void setClickHotArea(int i3, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (getContext() != null && getContext().getResources() != null) {
            Resources resources = getContext().getResources();
            this.mHotAreaLeftMargin = (int) TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
            this.mHotAreaRightMargin = (int) TypedValue.applyDimension(i3, f17, resources.getDisplayMetrics());
            this.mHotAreaBottomMargin = (int) TypedValue.applyDimension(i3, f18, resources.getDisplayMetrics());
            this.mHotAreaHeight = (int) TypedValue.applyDimension(i3, f19, resources.getDisplayMetrics());
        }
    }

    public void setInteractiveListener(@Nullable IFlipInteractiveListener iFlipInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iFlipInteractiveListener);
        } else {
            this.mListener = iFlipInteractiveListener;
        }
    }

    public void setReverseRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            f16 = 0.0f;
        }
        this.mReverseRotationThreshold = f16;
    }

    public void setReverseTitleText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mReverseTitleText = str;
        }
    }

    public void setSubTitleText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mSubTitleText = str;
        }
    }

    public void setSubtitleMarginBottomDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16));
        } else if (f16 > 0.0f) {
            this.mSubtitleMarginBottomDp = f16;
        }
    }

    public void setTargetRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            f16 = 45.0f;
        }
        this.mTargetRotationThreshold = f16;
    }

    public void setTitleText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mTitleText = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler
    public void smoothHideView(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) animatorListener);
            return;
        }
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.smoothHideView(animatorListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mIsUserStarted = true;
        reset();
        this.mAnimatorView.addLayer(createGroupLayer());
        this.mAnimatorView.startAnimation();
        this.mFlipRotationHandler.setTargetRotationThreshold(this.mTargetRotationThreshold);
        this.mFlipRotationHandler.setReverseRotationThreshold(this.mReverseRotationThreshold);
        initClickArea();
        startEntranceAnimation();
        this.mSensor.start();
    }

    protected void startEntranceAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        Logger.i(TAG, "startEntranceAnimation");
        this.mIsShowingEntranceAnimation = true;
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mLeftArrowBgLayer);
        sequentialAnimator.addAnimator(createEntranceAlphaAnimator(this.mLeftArrowBgLayer, 0.4f, 0.8f, DURATION_ENTRANCE_STEP1_MS));
        sequentialAnimator.addAnimator(createEntranceAlphaAnimator(this.mLeftArrowBgLayer, 0.8f, 0.3f, DURATION_ENTRANCE_STEP2_MS));
        sequentialAnimator.addAnimator(createEntranceAlphaAnimator(this.mLeftArrowBgLayer, 0.3f, 0.4f, 500L));
        sequentialAnimator.setRepeatCount(0);
        sequentialAnimator.setRepeatMode(1);
        this.mLeftArrowBgLayer.setAnimator(sequentialAnimator);
        SequentialAnimator sequentialAnimator2 = new SequentialAnimator(this.mRightArrowBgLayer);
        sequentialAnimator2.addAnimator(createEntranceAlphaAnimator(this.mRightArrowBgLayer, 0.4f, 0.3f, DURATION_ENTRANCE_STEP1_MS));
        sequentialAnimator2.addAnimator(createEntranceAlphaAnimator(this.mRightArrowBgLayer, 0.3f, 0.8f, DURATION_ENTRANCE_STEP2_MS));
        sequentialAnimator2.addAnimator(createEntranceAlphaAnimator(this.mRightArrowBgLayer, 0.8f, 0.4f, 500L));
        sequentialAnimator2.setRepeatCount(0);
        sequentialAnimator2.setRepeatMode(1);
        this.mRightArrowBgLayer.setAnimator(sequentialAnimator2);
        FlipPhoneLayer flipPhoneLayer = this.mFlipPhoneLayer;
        if (flipPhoneLayer != null) {
            SequentialAnimator sequentialAnimator3 = new SequentialAnimator(flipPhoneLayer);
            sequentialAnimator3.addAnimator(createEntranceRotationYAnimator(this.mFlipPhoneLayer, 0.0f, -25.0f, DURATION_ENTRANCE_STEP1_MS));
            sequentialAnimator3.addAnimator(createEntranceRotationYAnimator(this.mFlipPhoneLayer, -25.0f, 25.0f, DURATION_ENTRANCE_STEP2_MS));
            sequentialAnimator3.addAnimator(createEntranceRotationYAnimator(this.mFlipPhoneLayer, 25.0f, 0.0f, 500L));
            sequentialAnimator3.setRepeatCount(0);
            sequentialAnimator3.setRepeatMode(1);
            this.mFlipPhoneLayer.setAnimator(sequentialAnimator3);
        }
    }

    protected void startFlipInteractive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        Logger.i(TAG, "startFlipInteractive");
        FlipPhoneLayer flipPhoneLayer = this.mFlipPhoneLayer;
        if (flipPhoneLayer != null) {
            flipPhoneLayer.startInteractive();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IFlipInteractiveListener iFlipInteractiveListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "stop()");
        this.mAnimatorView.stopAnimation();
        this.mSensor.stop();
        if (this.mIsInteractStart && !this.mIsInteractFinished && (iFlipInteractiveListener = this.mListener) != null) {
            iFlipInteractiveListener.onInteractResult(3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryStopEntranceAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        Logger.i(TAG, "tryStopEntranceAnimation, " + this.mIsShowingEntranceAnimation);
        if (!this.mIsShowingEntranceAnimation) {
            return;
        }
        this.mIsShowingEntranceAnimation = false;
        stopLayerAnimation(this.mLeftArrowBgLayer);
        stopLayerAnimation(this.mRightArrowBgLayer);
        stopLayerAnimation(this.mFlipPhoneLayer);
        this.mLeftArrowBgLayer.postAlpha(102);
        this.mRightArrowBgLayer.postAlpha(102);
    }

    public FlipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.SIZE_PHONE_ICON_PX = (int) Utils.dp2px(70.0f);
        this.OFFSET_CENTER_X_ARROW_PX = (int) Utils.dp2px(55.0f);
        this.WIDTH_ARROW_PX = (int) Utils.dp2px(32.0f);
        this.HEIGHT_ARROW_PX = (int) Utils.dp2px(14.0f);
        this.TEXT_SIZE_TITLE_PX = (int) Utils.dp2px(18.0f);
        this.TEXT_SIZE_SUBTITLE_PX = (int) Utils.dp2px(14.0f);
        this.COLOR_SUBTITLE = Color.parseColor("#CCFFFFFF");
        this.RADIUS_ARROW_LINE = Utils.dp2px(1.0f);
        this.RADIUS_ARROW_TRIANGLE = Utils.dp2px(3.0f);
        this.DEFAULT_BG_SHADER_HEIGHT_PX = (int) Utils.dp2px(277.0f);
        this.mTargetRotationThreshold = 45.0f;
        this.mReverseRotationThreshold = 0.0f;
        this.mIsInteractStart = false;
        this.mIsInteractFinished = false;
        this.mIsShowingEntranceAnimation = false;
        this.mSubtitleMarginBottomDp = 82.0f;
        FlipRotationHandler.IFlipRotationListener iFlipRotationListener = new FlipRotationHandler.IFlipRotationListener() { // from class: com.tencent.ams.fusion.widget.flip.FlipView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlipView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onError() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, (Object) this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipBackInteractProgress(float f16, float f17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
                    return;
                }
                FlipView.this.postUpdateProgress(f16, f17);
                IFlipInteractiveListener iFlipInteractiveListener = FlipView.this.mListener;
                if (iFlipInteractiveListener != null) {
                    iFlipInteractiveListener.onBackInteractProgress(f16);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipBackInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                FlipView flipView = FlipView.this;
                TextLayer textLayer = flipView.mTitleTextLayer;
                if (textLayer != null) {
                    textLayer.setText(flipView.getReverseTitleText());
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractFinish(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    return;
                }
                FlipView flipView = FlipView.this;
                flipView.mIsInteractFinished = true;
                if (flipView.mSensor != null) {
                    FlipView.this.mSensor.stop();
                }
                IFlipInteractiveListener iFlipInteractiveListener = FlipView.this.mListener;
                if (iFlipInteractiveListener != null) {
                    iFlipInteractiveListener.onInteractResult(3, z16);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractProgress(float f16, float f17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
                    return;
                }
                FlipView.this.postUpdateProgress(f16, f17);
                IFlipInteractiveListener iFlipInteractiveListener = FlipView.this.mListener;
                if (iFlipInteractiveListener != null) {
                    iFlipInteractiveListener.onInteractProgress(f16);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                FlipView flipView = FlipView.this;
                flipView.mIsInteractStart = true;
                flipView.tryStopEntranceAnimation();
                FlipView.this.startFlipInteractive();
                IFlipInteractiveListener iFlipInteractiveListener = FlipView.this.mListener;
                if (iFlipInteractiveListener != null) {
                    iFlipInteractiveListener.onInteractStart(3);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onRotationChanged(float f16, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Float.valueOf(f16), Boolean.valueOf(z16));
                }
            }
        };
        this.mFlipRotationListener = iFlipRotationListener;
        AnimatorView animatorView = new AnimatorView(context);
        this.mAnimatorView = animatorView;
        addView(animatorView);
        this.mSensor = new RotationSensor(context);
        FlipRotationHandler flipRotationHandler = new FlipRotationHandler();
        this.mFlipRotationHandler = flipRotationHandler;
        flipRotationHandler.setRotationListener(iFlipRotationListener);
        View view = new View(getContext());
        this.mClickArea = view;
        addView(view);
    }
}
