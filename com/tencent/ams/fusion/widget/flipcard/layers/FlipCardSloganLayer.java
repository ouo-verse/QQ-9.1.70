package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import android.graphics.Paint;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardAnimationHelper;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardSloganLayer extends GroupLayer {
    static IPatchRedirector $redirector_;
    private final int layerPadding;
    private final FlipCardInfo mCardInfo;
    private final int quotationHeight;
    private final int quotationWidth;

    public FlipCardSloganLayer(Context context, float f16, float f17, FlipCardInfo flipCardInfo) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16), Float.valueOf(f17), flipCardInfo);
            return;
        }
        this.mCardInfo = flipCardInfo;
        setX(f16);
        setY(f17);
        this.quotationWidth = Utils.getRelativeSize375(context, 9);
        this.quotationHeight = Utils.getRelativeSize375(context, 26);
        int relativeSize375 = Utils.getRelativeSize375(context, 4);
        this.layerPadding = relativeSize375;
        addLayer(createLeftQuotationLayer(context, flipCardInfo));
        AnimatorLayer createTextLayer = createTextLayer(context, flipCardInfo);
        addLayer(createTextLayer);
        addLayer(createRightQuotationLayer(createTextLayer.getX() + createTextLayer.getWidth() + relativeSize375));
    }

    private AnimatorLayer createLeftQuotationLayer(Context context, FlipCardInfo flipCardInfo) {
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.QUOTATION_LEFT, this.quotationWidth, this.quotationHeight));
        flipCardBitmapLayer.setWidth(this.quotationWidth);
        flipCardBitmapLayer.setHeight(this.quotationHeight);
        flipCardBitmapLayer.setX(0.0f);
        flipCardBitmapLayer.setY(0.0f);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private AnimatorLayer createRightQuotationLayer(float f16) {
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.QUOTATION_RIGHT, this.quotationWidth, this.quotationHeight));
        flipCardBitmapLayer.setWidth(this.quotationWidth);
        flipCardBitmapLayer.setHeight(this.quotationHeight);
        flipCardBitmapLayer.setX(f16);
        flipCardBitmapLayer.setY(0.0f);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private AnimatorLayer createTextLayer(Context context, FlipCardInfo flipCardInfo) {
        TextLayer textLayer = new TextLayer();
        textLayer.setText(flipCardInfo.getProductSlogan());
        float relativeSize375 = Utils.getRelativeSize375(context, 17);
        textLayer.setTextSize(relativeSize375);
        textLayer.setTextColor(-13553359);
        int textWidth = (int) Utils.getTextWidth(relativeSize375, true, flipCardInfo.getProductSlogan());
        textLayer.setHeight(this.quotationHeight);
        textLayer.setWidth(textWidth);
        textLayer.setTextAlign(Paint.Align.LEFT);
        textLayer.setTextBold(true);
        textLayer.setX(this.quotationWidth + this.layerPadding);
        textLayer.setY(Utils.getTextPaintBaselineToTop(relativeSize375) + Utils.getRelativeSize(context, 2));
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }
}
