package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.ig.l;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardBonusLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    private static final float RADIUS;
    private static final String TAG = "FlipCardBonusLayer";
    private final FlipCardInfo mCardInfo;
    private final Context mContext;
    private FlipCardCountdownLayer mCountdownLayer;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            RADIUS = Utils.dp2px(20.0f);
        }
    }

    public FlipCardBonusLayer(Context context, FlipCardInfo flipCardInfo, int i3, int i16) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, flipCardInfo, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mContext = context;
        this.mCardInfo = flipCardInfo;
        int relativeSize375 = Utils.getRelativeSize375(context, FilterEnum.MIC_PTU_TRANS_XINXIAN);
        int relativeSize3752 = Utils.getRelativeSize375(context, l.CTRL_INDEX);
        setWidth(relativeSize375);
        setHeight(relativeSize3752);
        setX((i3 - relativeSize375) / 2.0f);
        setY((i16 - relativeSize3752) / 2.0f);
        init();
    }

    private BitmapLayer createBitmapLayer() {
        float f16 = (int) RADIUS;
        float[] fArr = {f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f};
        int width = getWidth();
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer(Utils.createMaskBitmap(this.mCardInfo.getBonusCardBitmap(), width, width, fArr, 0));
        flipCardBitmapLayer.setWidth(width);
        flipCardBitmapLayer.setHeight(width);
        flipCardBitmapLayer.setY(getY());
        flipCardBitmapLayer.setX(getX());
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private FlipCardCountdownLayer createCountdownLayer(Context context, float f16) {
        float x16 = getX() + Utils.getRelativeSize375(this.mContext, 45);
        long[] lifeTime = this.mCardInfo.getLifeTime();
        if (lifeTime != null && lifeTime.length == 4 && lifeTime[0] == 0) {
            x16 += Utils.getRelativeSize375(this.mContext, 12);
        }
        FlipCardCountdownLayer flipCardCountdownLayer = new FlipCardCountdownLayer(context, x16, f16, Utils.getRelativeSize375(context, 32), this.mCardInfo, false);
        flipCardCountdownLayer.setAnimator(new KeepAnimator(flipCardCountdownLayer));
        return flipCardCountdownLayer;
    }

    private FlipCardSloganLayer createSloganLayer(Context context, float f16) {
        FlipCardSloganLayer flipCardSloganLayer = new FlipCardSloganLayer(context, getX() + ((getWidth() - (Utils.getTextWidth(Utils.getRelativeSize375(context, 17), true, this.mCardInfo.getProductSlogan()) + Utils.getRelativeSize375(context, 26))) / 2.0f), f16, this.mCardInfo);
        flipCardSloganLayer.setAnimator(new KeepAnimator(flipCardSloganLayer));
        return flipCardSloganLayer;
    }

    private AnimatorLayer createTagLayer(Context context, float f16, float f17) {
        FlipCardTagLayer flipCardTagLayer = new FlipCardTagLayer(context, f16, f17, Utils.getRelativeSize375(context, 24), Utils.getRelativeSize375(context, 14), this.mCardInfo);
        flipCardTagLayer.setAnimator(new KeepAnimator(flipCardTagLayer));
        return flipCardTagLayer;
    }

    private AnimatorLayer createTagTextLayer(Context context, String str, float f16, float f17) {
        TextLayer textLayer = new TextLayer();
        textLayer.setText(str);
        textLayer.setTextSize(Utils.getRelativeSize375(context, 12));
        textLayer.setTextColor(Integer.MIN_VALUE);
        textLayer.setTextAlign(Paint.Align.LEFT);
        textLayer.setX(f16);
        textLayer.setY(f17);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private AnimatorLayer createTitleLayer(Context context, int i3) {
        CharSequence ellipsize;
        TextLayer textLayer = new TextLayer();
        textLayer.setTextSize(Utils.getRelativeSize375(context, 15));
        textLayer.setTextColor(-13553359);
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setTextBold(true);
        textLayer.setY(getY() + Utils.getRelativeSize375(context, 324) + i3);
        textLayer.setX(getX() + (getWidth() / 2.0f));
        String titleText = this.mCardInfo.getTitleText();
        if (!TextUtils.isEmpty(titleText) && (ellipsize = TextUtils.ellipsize(titleText, new TextPaint(textLayer.getPaint()), getWidth() - Utils.getRelativeSize375(context, 30), TextUtils.TruncateAt.END)) != null) {
            titleText = ellipsize.toString();
        }
        textLayer.setText(titleText);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private void init() {
        if (this.mCardInfo == null) {
            return;
        }
        addLayer(createBitmapLayer());
        String tagText = this.mCardInfo.getTagText();
        Rect textBound = Utils.getTextBound(Utils.getRelativeSize375(this.mContext, 12), tagText);
        addLayer(createTitleLayer(this.mContext, Utils.getTextBound(Utils.getRelativeSize375(this.mContext, 15), this.mCardInfo.getTitleText()).height()));
        float x16 = getX() + (((getWidth() - textBound.width()) - Utils.getRelativeSize375(this.mContext, 30)) / 2.0f);
        float y16 = getY() + Utils.getRelativeSize375(this.mContext, g.CTRL_INDEX) + r2.height();
        textBound.height();
        float relativeSize375 = Utils.getRelativeSize375(this.mContext, 30) + y16;
        addLayer(createTagLayer(this.mContext, x16, y16));
        addLayer(createTagTextLayer(this.mContext, tagText, Utils.getRelativeSize375(this.mContext, 30) + x16, y16 + textBound.height()));
        if (this.mCardInfo.hasCountDown()) {
            FlipCardCountdownLayer createCountdownLayer = createCountdownLayer(this.mContext, relativeSize375);
            this.mCountdownLayer = createCountdownLayer;
            addLayer(createCountdownLayer);
            return;
        }
        addLayer(createSloganLayer(this.mContext, relativeSize375));
    }

    public RectF getRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RectF) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        float x16 = getX();
        float y16 = getY();
        return new RectF(x16, y16, getWidth() + x16, getHeight() + y16);
    }

    public void startAlphaAnimation(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorListener);
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(this, 0.0f, 1.0f);
        alphaAnimator.setDuration(500L);
        alphaAnimator.setAnimatorListener(animatorListener);
        Logger.i(TAG, "start animator");
        setAnimator(alphaAnimator);
    }

    public void updateTime() {
        FlipCardInfo flipCardInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        FlipCardCountdownLayer flipCardCountdownLayer = this.mCountdownLayer;
        if (flipCardCountdownLayer != null && (flipCardInfo = this.mCardInfo) != null) {
            flipCardCountdownLayer.updateTime(flipCardInfo.getLifeTime());
        }
    }
}
