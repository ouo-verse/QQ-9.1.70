package com.tencent.ams.fusion.widget.slopecard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationYAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.DrawableLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlopeCardView extends SlopeSlideView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SlopeCardView";
    private Bitmap mBackIconBitmap;
    private AnimatorLayer mBgShadowLayer;
    private Bitmap mCenterIconBitmap;
    private ReversibleBitmapLayer mCenterIconLayer;
    private Animator mCenterIconShakeAnimator;
    private EndCardClickListener mClickListener;
    private boolean mIsClickDownInEndCard;
    private String mJumpTipsText;
    private Bitmap mLeftIconBitmap;
    private BitmapLayer mLeftIconLayer;
    private Animator mLeftIconShakeAnimator;
    private Bitmap mRightIconBitmap;
    private BitmapLayer mRightIconLayer;
    private Animator mRightIconShakeAnimator;
    private AnimatorLayer mUpBgShadowLayer;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CardFlyParams {
        static IPatchRedirector $redirector_;
        private final float cardFlyToY;
        private final float scaleTo;

        public CardFlyParams(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.cardFlyToY = f16;
                this.scaleTo = f17;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface EndCardClickListener {
        void onClick(float f16, float f17);
    }

    public SlopeCardView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void createCenterIconEndAnimator(Animator.AnimatorListener animatorListener) {
        if (this.mCenterIconLayer == null) {
            return;
        }
        CardFlyParams cardFlyParams = getCardFlyParams();
        GroupAnimator groupAnimator = new GroupAnimator(this.mCenterIconLayer, new TranslateAnimator(this.mCenterIconLayer, 0.0f, 0.0f, 0.0f, cardFlyParams.cardFlyToY - this.mCenterIconLayer.getCenterY()), new ScaleAnimator(this.mCenterIconLayer, 1.0f, cardFlyParams.scaleTo, 1.0f, cardFlyParams.scaleTo));
        groupAnimator.setDuration(320L);
        groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        ScaleAnimator scaleAnimator = new ScaleAnimator(this.mCenterIconLayer, cardFlyParams.scaleTo, cardFlyParams.scaleTo, cardFlyParams.scaleTo, cardFlyParams.scaleTo);
        RotationYAnimator rotationYAnimator = new RotationYAnimator(this.mCenterIconLayer);
        rotationYAnimator.setRotationDegrees(360.0f, 180.0f);
        GroupAnimator groupAnimator2 = new GroupAnimator(this.mCenterIconLayer, rotationYAnimator, scaleAnimator);
        groupAnimator2.setDuration(560L);
        groupAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mCenterIconLayer, groupAnimator, groupAnimator2);
        sequentialAnimator.setAnimatorListener(animatorListener);
        this.mCenterIconLayer.setAnimator(sequentialAnimator);
    }

    private void createHideAnimator(AnimatorLayer animatorLayer) {
        if (animatorLayer == null) {
            return;
        }
        KeepAnimator keepAnimator = new KeepAnimator(animatorLayer);
        keepAnimator.setDuration(200L);
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 1.0f, 0.0f);
        alphaAnimator.setDuration(120L);
        alphaAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        animatorLayer.setAnimator(new SequentialAnimator(animatorLayer, keepAnimator, alphaAnimator));
    }

    private Animator createIconShakeAnimator(AnimatorLayer animatorLayer, int i3) {
        float f16 = -Utils.getRelativeSize375(getContext(), i3);
        TranslateAnimator translateAnimator = new TranslateAnimator(animatorLayer, 0.0f, 0.0f, 0.0f, f16);
        translateAnimator.setDuration(720L);
        translateAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        TranslateAnimator translateAnimator2 = new TranslateAnimator(animatorLayer, 0.0f, 0.0f, f16, 0.0f);
        translateAnimator2.setDuration(760L);
        translateAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        KeepAnimator keepAnimator = new KeepAnimator(animatorLayer);
        keepAnimator.setDuration(200L);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer, translateAnimator, translateAnimator2, keepAnimator);
        sequentialAnimator.setRepeatCount(0);
        return sequentialAnimator;
    }

    private void createLeftIconEndAnimator() {
        BitmapLayer bitmapLayer = this.mLeftIconLayer;
        if (bitmapLayer == null) {
            return;
        }
        GroupAnimator groupAnimator = new GroupAnimator(this.mLeftIconLayer, new TranslateAnimator(bitmapLayer, 0.0f, -Utils.getRelativeSize375(getContext(), 166), 0.0f, 0.0f), new AlphaAnimator(this.mLeftIconLayer, 1.0f, 0.0f));
        groupAnimator.setDuration(360L);
        groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.mLeftIconLayer.setAnimator(groupAnimator);
    }

    private AnimatorLayer createLeftIconLayer() {
        Bitmap bitmap = this.mLeftIconBitmap;
        if (bitmap == null) {
            return null;
        }
        BitmapLayer bitmapLayer = new BitmapLayer(bitmap);
        this.mLeftIconLayer = bitmapLayer;
        bitmapLayer.setWidth(getLeftIconWidth());
        this.mLeftIconLayer.setHeight(getLeftIconHeight());
        this.mLeftIconLayer.setX(Utils.getRelativeSize375(getContext(), 12));
        this.mLeftIconLayer.setY(getHeight() - Utils.getRelativeSize375(getContext(), 40));
        this.mLeftIconShakeAnimator = createIconShakeAnimator(this.mLeftIconLayer, 8);
        return this.mLeftIconLayer;
    }

    private void createRightIconEndAnimator() {
        BitmapLayer bitmapLayer = this.mRightIconLayer;
        if (bitmapLayer == null) {
            return;
        }
        GroupAnimator groupAnimator = new GroupAnimator(this.mRightIconLayer, new TranslateAnimator(bitmapLayer, 0.0f, Utils.getRelativeSize375(getContext(), 166), 0.0f, 0.0f), new AlphaAnimator(this.mRightIconLayer, 1.0f, 0.0f));
        groupAnimator.setDuration(360L);
        groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.mRightIconLayer.setAnimator(groupAnimator);
    }

    private AnimatorLayer createRightIconLayer() {
        Bitmap bitmap = this.mRightIconBitmap;
        if (bitmap == null) {
            return null;
        }
        BitmapLayer bitmapLayer = new BitmapLayer(bitmap);
        this.mRightIconLayer = bitmapLayer;
        bitmapLayer.setWidth(getLeftIconWidth());
        this.mRightIconLayer.setHeight(getLeftIconHeight());
        this.mRightIconLayer.setX((getWidth() - Utils.getRelativeSize375(getContext(), 12)) - this.mRightIconBitmap.getWidth());
        this.mRightIconLayer.setY(getHeight() - Utils.getRelativeSize375(getContext(), 40));
        this.mRightIconShakeAnimator = createIconShakeAnimator(this.mRightIconLayer, 8);
        return this.mRightIconLayer;
    }

    private void createShowBgShadowAnimator() {
        AnimatorLayer animatorLayer = this.mBgShadowLayer;
        if (animatorLayer == null) {
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 0.0f, 0.4f);
        alphaAnimator.setDuration(360L);
        alphaAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.mBgShadowLayer.setAnimator(alphaAnimator);
    }

    private void createSubTitleAnimator() {
        if (this.mSubTitleLayer == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mJumpTipsText)) {
            createHideAnimator(this.mSubTitleLayer);
            return;
        }
        KeepAnimator keepAnimator = new KeepAnimator(this.mSubTitleLayer);
        keepAnimator.setDuration(100L);
        AlphaAnimator alphaAnimator = new AlphaAnimator(this.mSubTitleLayer, 1.0f, 0.0f);
        alphaAnimator.setDuration(160L);
        alphaAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        alphaAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.slopecard.SlopeCardView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeCardView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((SlopeSlideView) SlopeCardView.this).mSubTitleLayer.setText(SlopeCardView.this.mJumpTipsText);
                }
            }
        });
        KeepAnimator keepAnimator2 = new KeepAnimator(this.mSubTitleLayer);
        keepAnimator2.setDuration(380L);
        AlphaAnimator alphaAnimator2 = new AlphaAnimator(this.mSubTitleLayer, 0.0f, 1.0f);
        alphaAnimator2.setDuration(280L);
        alphaAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        TextLayer textLayer = this.mSubTitleLayer;
        textLayer.setAnimator(new SequentialAnimator(textLayer, keepAnimator, alphaAnimator, keepAnimator2, alphaAnimator2));
    }

    private CardFlyParams getCardFlyParams() {
        float subtitleTextY = getSubtitleTextY() - Utils.getTextPaintBaselineToTop(Utils.dp2px(14.0f));
        float dp2px = Utils.dp2px(18.0f);
        float height = getHeight() / 2.0f;
        int centerIconHeight = getCenterIconHeight();
        float f16 = centerIconHeight;
        float f17 = 2.2f;
        float f18 = f16 * 2.2f;
        if ((getHeight() / 2.0f) + (f18 / 2.0f) + dp2px > subtitleTextY) {
            float f19 = subtitleTextY - dp2px;
            float dp2px2 = f19 - Utils.dp2px(28.0f);
            if (dp2px2 < f18 && centerIconHeight > 0) {
                f17 = dp2px2 / f16;
            }
            height = f19 - ((f16 * f17) / 2.0f);
            Logger.d(TAG, "createCenterIconEndAnimator scaleTo: " + f17 + ", cardFlyToY:" + height);
        }
        return new CardFlyParams(height, f17);
    }

    private int getCenterIconHeight() {
        return Utils.getRelativeSize375(getContext(), 224);
    }

    private int getCenterIconWidth() {
        return Utils.getRelativeSize375(getContext(), 126);
    }

    private int getLeftIconHeight() {
        return Utils.getRelativeSize375(getContext(), 182);
    }

    private int getLeftIconWidth() {
        return Utils.getRelativeSize375(getContext(), 102);
    }

    private boolean isClickInEndCard(float f16, float f17) {
        if (this.mCenterIconLayer != null) {
            float width = (r0.getWidth() * this.mCenterIconLayer.getScaleX()) / 2.0f;
            float height = (this.mCenterIconLayer.getHeight() * this.mCenterIconLayer.getScaleY()) / 2.0f;
            return new RectF(this.mCenterIconLayer.getCenterX() - width, this.mCenterIconLayer.getCenterY() - height, this.mCenterIconLayer.getCenterX() + width, this.mCenterIconLayer.getCenterY() + height).contains(f16, f17);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorLayer createBgShadowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setAlpha(0);
        DrawableLayer drawableLayer = new DrawableLayer(colorDrawable);
        drawableLayer.setX(0.0f);
        drawableLayer.setY(0.0f);
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(getHeight());
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        this.mBgShadowLayer = drawableLayer;
        return drawableLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorLayer createCenterIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.mCenterIconBitmap == null) {
            return null;
        }
        int centerIconWidth = getCenterIconWidth();
        int centerIconHeight = getCenterIconHeight();
        ReversibleBitmapLayer reversibleBitmapLayer = new ReversibleBitmapLayer(this.mCenterIconBitmap);
        this.mCenterIconLayer = reversibleBitmapLayer;
        reversibleBitmapLayer.setReverseBitmap(this.mBackIconBitmap);
        this.mCenterIconLayer.setWidth(centerIconWidth);
        this.mCenterIconLayer.setHeight(centerIconHeight);
        this.mCenterIconLayer.setX((getWidth() - centerIconWidth) / 2.0f);
        this.mCenterIconLayer.setY(getCenterIconLayerHeight());
        this.mCenterIconShakeAnimator = createIconShakeAnimator(this.mCenterIconLayer, 16);
        return this.mCenterIconLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public GroupLayer createGroupLayer(@NonNull List<AnimatorLayer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (GroupLayer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        }
        list.add(0, createUpBgShadowLayer());
        list.add(0, createBgShadowLayer());
        int size = list.size() - 1;
        int i3 = size + 1;
        list.add(size, createLeftIconLayer());
        list.add(i3, createRightIconLayer());
        list.add(i3 + 1, createCenterIconLayer());
        return super.createGroupLayer(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorLayer createUpBgShadowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        DrawableLayer drawableLayer = new DrawableLayer(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, 436207616}));
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 114);
        drawableLayer.setX(0.0f);
        drawableLayer.setY(0.0f);
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(relativeSize375);
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        this.mUpBgShadowLayer = drawableLayer;
        return drawableLayer;
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EndCardClickListener endCardClickListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mAnimatorFinished) {
            boolean isClickInEndCard = isClickInEndCard(motionEvent.getX(), motionEvent.getY());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && this.mIsClickDownInEndCard && isClickInEndCard && (endCardClickListener = this.mClickListener) != null) {
                    endCardClickListener.onClick(motionEvent.getX(), motionEvent.getY());
                    this.mIsClickDownInEndCard = false;
                    return true;
                }
            } else if (isClickInEndCard) {
                this.mIsClickDownInEndCard = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCenterIconLayerHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return getHeight() - Utils.getRelativeSize375(getContext(), 62);
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    protected void resetIconLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        BitmapLayer bitmapLayer = this.mLeftIconLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setAnimator(this.mLeftIconShakeAnimator);
        }
        BitmapLayer bitmapLayer2 = this.mRightIconLayer;
        if (bitmapLayer2 != null) {
            bitmapLayer2.setAnimator(this.mRightIconShakeAnimator);
        }
        ReversibleBitmapLayer reversibleBitmapLayer = this.mCenterIconLayer;
        if (reversibleBitmapLayer != null) {
            reversibleBitmapLayer.setAnimator(this.mCenterIconShakeAnimator);
        }
    }

    public void setEndCardClickListener(EndCardClickListener endCardClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) endCardClickListener);
        } else {
            this.mClickListener = endCardClickListener;
        }
    }

    public void setIconBackBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        } else {
            if (bitmap == null) {
                return;
            }
            Bitmap createMaskBitmap = Utils.createMaskBitmap(bitmap, getLeftIconWidth(), getLeftIconHeight(), Utils.getRelativeSize375(getContext(), 6), 855638016);
            this.mLeftIconBitmap = Utils.rotateBitmap(createMaskBitmap, -15.0f, false);
            this.mRightIconBitmap = Utils.rotateBitmap(createMaskBitmap, 15.0f, true);
            this.mCenterIconBitmap = Utils.createMaskBitmap(bitmap, getCenterIconWidth(), getCenterIconHeight(), Utils.getRelativeSize375(getContext(), 8), 0);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public void setIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            if (bitmap == null) {
                return;
            }
            Bitmap createMaskBitmap = Utils.createMaskBitmap(bitmap, getCenterIconWidth(), getCenterIconHeight(), Utils.getRelativeSize375(getContext(), 8), 0);
            this.mBackIconBitmap = createMaskBitmap;
            this.mBackIconBitmap = Utils.reverse(createMaskBitmap);
        }
    }

    public void setJumpTipsText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mJumpTipsText = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public void startEndAnimation(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animatorListener);
            return;
        }
        createCenterIconEndAnimator(animatorListener);
        createLeftIconEndAnimator();
        createRightIconEndAnimator();
        createHideAnimator(this.mPhoneLayer);
        createHideAnimator(this.mTitleLayer);
        createSubTitleAnimator();
        createHideAnimator(this.mBgShaderLayer);
        createHideAnimator(this.mUpBgShadowLayer);
        createHideAnimator(this.mArrowLayer1);
        createHideAnimator(this.mArrowLayer2);
        createShowBgShadowAnimator();
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    protected void updateEndUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        ReversibleBitmapLayer reversibleBitmapLayer = this.mCenterIconLayer;
        if (reversibleBitmapLayer != null) {
            reversibleBitmapLayer.reset();
            CardFlyParams cardFlyParams = getCardFlyParams();
            TranslateAnimator translateAnimator = new TranslateAnimator(this.mCenterIconLayer, 0.0f, (getWidth() / 2.0f) - this.mCenterIconLayer.getCenterX(), 0.0f, cardFlyParams.cardFlyToY - this.mCenterIconLayer.getCenterY());
            RotationYAnimator rotationYAnimator = new RotationYAnimator(this.mCenterIconLayer);
            rotationYAnimator.setRotationDegrees(360.0f, 180.0f);
            GroupAnimator groupAnimator = new GroupAnimator(this.mCenterIconLayer, rotationYAnimator, new ScaleAnimator(this.mCenterIconLayer, cardFlyParams.scaleTo, cardFlyParams.scaleTo, cardFlyParams.scaleTo, cardFlyParams.scaleTo), translateAnimator);
            groupAnimator.setDuration(0L);
            this.mCenterIconLayer.setAnimator(groupAnimator);
        }
        TextLayer textLayer = this.mSubTitleLayer;
        if (textLayer != null) {
            textLayer.reset();
            this.mSubTitleLayer.setX(getWidth() / 2.0f);
            this.mSubTitleLayer.setY(getSubtitleTextY());
            this.mSubTitleLayer.setTextSize(getSubTitleTextSize());
        }
        AnimatorLayer animatorLayer = this.mBgShadowLayer;
        if (animatorLayer != null) {
            animatorLayer.reset();
            this.mBgShadowLayer.setWidth(getWidth());
            this.mBgShadowLayer.setHeight(getHeight());
        }
        startAnimation(false);
    }
}
