package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardAnimationHelper;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardTagLayer extends GroupLayer {
    static IPatchRedirector $redirector_;

    public FlipCardTagLayer(Context context, float f16, float f17, int i3, int i16, FlipCardInfo flipCardInfo) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), flipCardInfo);
            return;
        }
        setX(f16);
        setY(f17);
        setWidth(i3);
        setHeight(i16);
        addLayer(createBackgroundLayer(context, flipCardInfo));
        addLayer(createTextLayer(context, flipCardInfo));
    }

    private AnimatorLayer createBackgroundLayer(Context context, FlipCardInfo flipCardInfo) {
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        int relativeSize375 = Utils.getRelativeSize375(context, 24);
        int relativeSize3752 = Utils.getRelativeSize375(context, 14);
        flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.IMAGE_TAG_BG, relativeSize375, relativeSize3752));
        flipCardBitmapLayer.setTintColor(FlipCardAnimationHelper.getThemeColor(flipCardInfo));
        flipCardBitmapLayer.setWidth(relativeSize375);
        flipCardBitmapLayer.setHeight(relativeSize3752);
        flipCardBitmapLayer.setX(0.0f);
        flipCardBitmapLayer.setY(0.0f);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private AnimatorLayer createTextLayer(Context context, FlipCardInfo flipCardInfo) {
        String str;
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        int relativeSize375 = Utils.getRelativeSize375(context, 24);
        int relativeSize3752 = Utils.getRelativeSize375(context, 14);
        if (flipCardInfo.getStyleType() == 1) {
            str = FlipCardAnimationHelper.IMAGE_TAG_NEW;
        } else if (flipCardInfo.getStyleType() == 2 || flipCardInfo.getStyleType() != 3) {
            str = FlipCardAnimationHelper.IMAGE_TAG_HOT;
        } else {
            str = FlipCardAnimationHelper.IMAGE_TAG_LIVE;
        }
        flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(str, relativeSize375, relativeSize3752));
        flipCardBitmapLayer.setWidth(relativeSize375);
        flipCardBitmapLayer.setHeight(relativeSize3752);
        flipCardBitmapLayer.setX(0.0f);
        flipCardBitmapLayer.setY(0.0f);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }
}
