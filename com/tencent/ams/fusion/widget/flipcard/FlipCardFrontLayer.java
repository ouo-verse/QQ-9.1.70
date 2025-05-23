package com.tencent.ams.fusion.widget.flipcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationYAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardBitmapLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardCountdownLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardInteractiveLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardSloganLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardTagLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardFrontLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int CAMERA_LOCATION_Z = -25;
    private static final float RADIUS;
    private static float bgBottomHeight;
    private static float bgLeftPosition;
    private static float bgTopHeight;
    private static float bgTopPosition;
    private static float bgWidth;
    private static float screenCenterY;
    private final FlipCardInfo mCardInfo;
    private FlipCardCountdownLayer mCountdownLayer;
    private KeepRotateAndProgressAnimator mKeepRotateAndProgressAnimator;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class KeepRotateAndProgressAnimator extends GroupAnimator {
        static IPatchRedirector $redirector_;
        private RotatePhoneProgressAnimator mProgressAnimator;
        private KeepRotateYAnimator mRotateKeepAnimator;

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
            KeepRotateYAnimator keepRotateYAnimator = new KeepRotateYAnimator(animatorLayer);
            this.mRotateKeepAnimator = keepRotateYAnimator;
            keepRotateYAnimator.setRepeatCount(0);
            RotatePhoneProgressAnimator rotatePhoneProgressAnimator = new RotatePhoneProgressAnimator(animatorLayer);
            this.mProgressAnimator = rotatePhoneProgressAnimator;
            rotatePhoneProgressAnimator.setRepeatCount(0);
            addAnimators(this.mRotateKeepAnimator, this.mProgressAnimator);
        }

        public void setCameraLocationZ(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.mRotateKeepAnimator.setLocation(0.0f, 0.0f, i3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        
            if (r5 > 1.0f) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void updateProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
                return;
            }
            float f17 = -1.0f;
            if (f16 >= -1.0f) {
                f17 = 1.0f;
            }
            f16 = f17;
            RotatePhoneProgressAnimator rotatePhoneProgressAnimator = this.mProgressAnimator;
            if (rotatePhoneProgressAnimator != null) {
                rotatePhoneProgressAnimator.setProgress(f16);
            }
        }

        public void updateRotateY(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                return;
            }
            KeepRotateYAnimator keepRotateYAnimator = this.mRotateKeepAnimator;
            if (keepRotateYAnimator != null) {
                keepRotateYAnimator.setRotationY(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class KeepRotateYAnimator extends RotationYAnimator {
        static IPatchRedirector $redirector_;

        public KeepRotateYAnimator(AnimatorLayer animatorLayer) {
            super(animatorLayer);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            } else {
                setLocation(0.0f, 0.0f, -25.0f);
            }
        }

        public void setRotationY(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                setRotationDegrees(f16, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class RotatePhoneProgressAnimator extends ProgressAnimator {
        static IPatchRedirector $redirector_;

        public RotatePhoneProgressAnimator(AnimatorLayer animatorLayer) {
            super(animatorLayer, 0.0f, 0.0f);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator, com.tencent.ams.fusion.widget.animatorview.animator.Animator
        public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
            } else if (z16 && !shouldRepeat()) {
                animatorLayer.postProgress(getToProgress());
            } else {
                animatorLayer.postProgress(computeProgress());
            }
        }

        public void setProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                setFromProgress(f16);
                setToProgress(f16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54617);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            RADIUS = Utils.dp2px(20.0f);
        }
    }

    public FlipCardFrontLayer(@NonNull Context context, int i3, int i16, @NonNull FlipCardInfo flipCardInfo) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), flipCardInfo);
            return;
        }
        setWidth(i3);
        setHeight(i16);
        this.mCardInfo = flipCardInfo;
        bgWidth = Utils.getRelativeSize375(context, 327);
        bgTopHeight = Utils.getRelativeSize375(context, 54);
        bgBottomHeight = Utils.getRelativeSize375(context, 76);
        bgLeftPosition = Utils.getRelativeSize375(context, 24);
        float f16 = i16;
        bgTopPosition = ((f16 - Utils.dp2px(118.0f)) - bgBottomHeight) - bgTopHeight;
        screenCenterY = f16 / 2.0f;
        addLayer(createTopBackgroundLayer());
        addLayer(createBottomBackgroundLayer());
        addLayer(createLogoLayer(context));
        addLayer(createProductLayer(context));
        addLayer(createTitleLayer(context));
        addLayer(createTagLayer(context));
        addLayer(createTagTextLayer(context));
        addLayer(createInteractiveLayer(context));
        if (flipCardInfo.hasCountDown()) {
            FlipCardCountdownLayer createCountdownLayer = createCountdownLayer(context);
            this.mCountdownLayer = createCountdownLayer;
            addLayer(createCountdownLayer);
        } else {
            addLayer(createSloganLayer(context));
        }
        setPx(bgLeftPosition + (bgWidth / 2.0f));
        setPy(bgTopPosition + ((bgTopHeight + bgBottomHeight) / 2.0f));
        if (!FlipCardAnimationHelper.isFlipMode(flipCardInfo) && !FlipCardAnimationHelper.isSlideMode(flipCardInfo)) {
            setAnimator(new KeepAnimator(this));
        } else {
            startRotationGuideAnimation();
        }
    }

    private AnimatorLayer createBottomBackgroundLayer() {
        Path path = new Path();
        float f16 = bgLeftPosition;
        float f17 = (bgTopPosition + bgTopHeight) - 1.0f;
        RectF rectF = new RectF(f16, f17, bgWidth + f16, bgBottomHeight + f17);
        float f18 = RADIUS;
        path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f18, f18, f18, f18}, Path.Direction.CW);
        path.close();
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path);
        pathShapeLayer.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{-419430401, -419430401}, (float[]) null, Shader.TileMode.MIRROR));
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    private FlipCardCountdownLayer createCountdownLayer(Context context) {
        FlipCardCountdownLayer flipCardCountdownLayer = new FlipCardCountdownLayer(context, bgLeftPosition + Utils.getRelativeSize375(context, 16), bgTopPosition + bgTopHeight + Utils.getRelativeSize375(context, 36), Utils.getRelativeSize375(context, 26), this.mCardInfo, true);
        flipCardCountdownLayer.setAnimator(new KeepAnimator(flipCardCountdownLayer));
        return flipCardCountdownLayer;
    }

    private FlipCardInteractiveLayer createInteractiveLayer(Context context) {
        float relativeSize375 = bgLeftPosition + Utils.getRelativeSize375(context, 261);
        float relativeSize3752 = bgTopPosition + bgTopHeight + Utils.getRelativeSize375(context, 10);
        int relativeSize3753 = Utils.getRelativeSize375(context, 56);
        FlipCardInteractiveLayer flipCardInteractiveLayer = new FlipCardInteractiveLayer(context, relativeSize375, relativeSize3752, relativeSize3753, relativeSize3753, this.mCardInfo);
        flipCardInteractiveLayer.setAnimator(new KeepAnimator(flipCardInteractiveLayer));
        return flipCardInteractiveLayer;
    }

    private AnimatorLayer createLogoLayer(Context context) {
        if (this.mCardInfo.getLogoBitmap() == null) {
            return null;
        }
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer(Utils.createBitmap(this.mCardInfo.getLogoBitmap(), Utils.getRelativeSize375(context, 64), Utils.getRelativeSize375(context, 32), false));
        flipCardBitmapLayer.setX(bgLeftPosition + Utils.getRelativeSize375(context, 12));
        flipCardBitmapLayer.setY(bgTopPosition + Utils.getRelativeSize375(context, 11));
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private AnimatorLayer createProductLayer(Context context) {
        if (this.mCardInfo.getProductBitmap() == null) {
            return null;
        }
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer(Utils.createBitmap(this.mCardInfo.getProductBitmap(), Utils.getRelativeSize375(context, 94), Utils.getRelativeSize375(context, 70), false));
        flipCardBitmapLayer.setX(bgLeftPosition + Utils.getRelativeSize375(context, 229));
        flipCardBitmapLayer.setY(bgTopPosition - Utils.getRelativeSize375(context, 16));
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private FlipCardSloganLayer createSloganLayer(Context context) {
        FlipCardSloganLayer flipCardSloganLayer = new FlipCardSloganLayer(context, bgLeftPosition + Utils.getRelativeSize375(context, 16), bgTopPosition + bgTopHeight + Utils.getRelativeSize375(context, 36), this.mCardInfo);
        flipCardSloganLayer.setAnimator(new KeepAnimator(flipCardSloganLayer));
        return flipCardSloganLayer;
    }

    private AnimatorLayer createTagLayer(Context context) {
        FlipCardTagLayer flipCardTagLayer = new FlipCardTagLayer(context, bgLeftPosition + Utils.getRelativeSize375(context, 16), bgTopPosition + bgTopHeight + Utils.getRelativeSize375(context, 12), Utils.getRelativeSize375(context, 24), Utils.getRelativeSize375(context, 14), this.mCardInfo);
        flipCardTagLayer.setAnimator(new KeepAnimator(flipCardTagLayer));
        return flipCardTagLayer;
    }

    private AnimatorLayer createTagTextLayer(Context context) {
        TextLayer textLayer = new TextLayer();
        textLayer.setText(this.mCardInfo.getTagText());
        textLayer.setTextSize(Utils.getRelativeSize375(context, 12));
        textLayer.setTextColor(Integer.MIN_VALUE);
        textLayer.setTextAlign(Paint.Align.LEFT);
        textLayer.setX(bgLeftPosition + Utils.getRelativeSize375(context, 46));
        textLayer.setY(bgTopPosition + bgTopHeight + Utils.getRelativeSize375(context, 23));
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private AnimatorLayer createTitleLayer(Context context) {
        CharSequence ellipsize;
        TextLayer textLayer = new TextLayer();
        textLayer.setTextSize(Utils.getRelativeSize375(context, 12));
        textLayer.setTextColor(-13553359);
        textLayer.setTextAlign(Paint.Align.LEFT);
        textLayer.setTextBold(true);
        float relativeSize375 = Utils.getRelativeSize375(context, 84);
        float relativeSize3752 = Utils.getRelativeSize375(context, 100);
        if (this.mCardInfo.getLogoBitmap() == null) {
            relativeSize375 = Utils.getRelativeSize375(context, 16);
        }
        if (this.mCardInfo.getProductBitmap() == null) {
            relativeSize3752 = Utils.getRelativeSize375(context, 4);
        }
        float f16 = (bgWidth - relativeSize375) - relativeSize3752;
        String titleText = this.mCardInfo.getTitleText();
        if (!TextUtils.isEmpty(titleText) && (ellipsize = TextUtils.ellipsize(this.mCardInfo.getTitleText(), new TextPaint(textLayer.getPaint()), f16, TextUtils.TruncateAt.END)) != null) {
            titleText = ellipsize.toString();
        }
        textLayer.setText(titleText);
        textLayer.setX(bgLeftPosition + relativeSize375);
        textLayer.setY(bgTopPosition + Utils.getRelativeSize375(context, 30));
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private AnimatorLayer createTopBackgroundLayer() {
        Path path = new Path();
        float f16 = bgLeftPosition;
        float f17 = bgTopPosition;
        RectF rectF = new RectF(f16, f17, bgWidth + f16, bgTopHeight + f17);
        float f18 = RADIUS;
        path.addRoundRect(rectF, new float[]{f18, f18, f18, f18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        path.close();
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path);
        pathShapeLayer.setColor(16777215);
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    @NonNull
    public RectF getCardRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RectF) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RectF rectF = new RectF();
        float f16 = bgLeftPosition;
        rectF.left = f16;
        float f17 = bgTopPosition;
        rectF.top = f17;
        rectF.right = f16 + bgWidth;
        rectF.bottom = f17 + bgTopHeight + bgBottomHeight;
        return rectF;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        super.postProgress(f16);
        KeepRotateAndProgressAnimator keepRotateAndProgressAnimator = this.mKeepRotateAndProgressAnimator;
        if (keepRotateAndProgressAnimator != null) {
            keepRotateAndProgressAnimator.updateProgress(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        super.postRotationY(f16);
        KeepRotateAndProgressAnimator keepRotateAndProgressAnimator = this.mKeepRotateAndProgressAnimator;
        if (keepRotateAndProgressAnimator != null) {
            keepRotateAndProgressAnimator.updateRotateY(f16);
        }
    }

    public void startEndAnimation(Animator.AnimatorListener animatorListener, boolean z16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, animatorListener, Boolean.valueOf(z16));
            return;
        }
        TranslateAnimator translateAnimator = new TranslateAnimator(this, 0.0f, 0.0f, 0.0f, (screenCenterY - ((bgTopHeight + bgBottomHeight) / 2.0f)) - bgTopPosition, getPx(), getPy()) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardFrontLayer.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ float val$px;
            final /* synthetic */ float val$py;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this, r9, r10, r11, r12);
                this.val$px = r13;
                this.val$py = r14;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlipCardFrontLayer.this, this, Float.valueOf(r9), Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Float.valueOf(r13), Float.valueOf(r14));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator
            public void postTranslate(Canvas canvas, AnimatorLayer animatorLayer, float f17, float f18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, canvas, animatorLayer, Float.valueOf(f17), Float.valueOf(f18));
                    return;
                }
                super.postTranslate(canvas, animatorLayer, f17, f18);
                FlipCardFrontLayer.this.setPx(this.val$px + f17);
                FlipCardFrontLayer.this.setPy(this.val$py + f18);
            }
        };
        RotationYAnimator rotationYAnimator = new RotationYAnimator(this);
        float rotationYDegrees = getRotationYDegrees();
        if (z16) {
            f16 = -90.0f;
        } else {
            f16 = 90.0f;
        }
        rotationYAnimator.setRotationDegrees(rotationYDegrees, f16);
        rotationYAnimator.setLocation(0.0f, 0.0f, -25.0f);
        GroupAnimator groupAnimator = new GroupAnimator(this, translateAnimator, rotationYAnimator);
        groupAnimator.setDuration(300L);
        groupAnimator.setAnimatorListener(animatorListener);
        setAnimator(groupAnimator);
    }

    public void startRotationGuideAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RotationAnimator.OnRotationChangeListener onRotationChangeListener = new RotationAnimator.OnRotationChangeListener() { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardFrontLayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlipCardFrontLayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator.OnRotationChangeListener
            public void onChange(float f16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Float.valueOf(f16));
                } else {
                    FlipCardFrontLayer.this.postProgress((f16 / 20.0f) * 0.3f);
                }
            }
        };
        RotationYAnimator rotationYAnimator = new RotationYAnimator(this);
        rotationYAnimator.setRotationDegrees(0.0f, -20.0f);
        rotationYAnimator.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        rotationYAnimator.setLocation(0.0f, 0.0f, -25.0f);
        rotationYAnimator.setDuration(600L);
        rotationYAnimator.setOnRotationChangeListener(onRotationChangeListener);
        RotationYAnimator rotationYAnimator2 = new RotationYAnimator(this);
        rotationYAnimator2.setRotationDegrees(-20.0f, 0.0f);
        rotationYAnimator2.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        rotationYAnimator2.setLocation(0.0f, 0.0f, -25.0f);
        rotationYAnimator2.setDuration(400L);
        rotationYAnimator2.setOnRotationChangeListener(onRotationChangeListener);
        KeepAnimator keepAnimator = new KeepAnimator(this);
        keepAnimator.setDuration(600L);
        RotationYAnimator rotationYAnimator3 = new RotationYAnimator(this);
        rotationYAnimator3.setRotationDegrees(0.0f, 20.0f);
        rotationYAnimator3.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        rotationYAnimator3.setLocation(0.0f, 0.0f, -25.0f);
        rotationYAnimator3.setDuration(600L);
        rotationYAnimator3.setOnRotationChangeListener(onRotationChangeListener);
        RotationYAnimator rotationYAnimator4 = new RotationYAnimator(this);
        rotationYAnimator4.setRotationDegrees(20.0f, 0.0f);
        rotationYAnimator4.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        rotationYAnimator4.setLocation(0.0f, 0.0f, -25.0f);
        rotationYAnimator4.setDuration(400L);
        rotationYAnimator4.setOnRotationChangeListener(onRotationChangeListener);
        KeepAnimator keepAnimator2 = new KeepAnimator(this);
        keepAnimator2.setDuration(600L);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this, rotationYAnimator, rotationYAnimator2, keepAnimator, rotationYAnimator3, rotationYAnimator4, keepAnimator2);
        sequentialAnimator.setRepeatCount(0);
        setAnimator(sequentialAnimator);
    }

    public void startRotationInteractive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        KeepRotateAndProgressAnimator keepRotateAndProgressAnimator = new KeepRotateAndProgressAnimator(this, new Animator[0]);
        this.mKeepRotateAndProgressAnimator = keepRotateAndProgressAnimator;
        setAnimator(keepRotateAndProgressAnimator);
    }

    public void updateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mCountdownLayer != null) {
            this.mCountdownLayer.updateTime(FlipCardAnimationHelper.computeLeftTime(this.mCardInfo.getBeginTime()));
        }
    }
}
