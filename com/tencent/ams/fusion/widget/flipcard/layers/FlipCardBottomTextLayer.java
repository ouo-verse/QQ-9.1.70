package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardBottomTextLayer extends TextLayer {
    static IPatchRedirector $redirector_;

    public FlipCardBottomTextLayer(Context context, float f16, float f17, @NonNull FlipCardInfo flipCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16), Float.valueOf(f17), flipCardInfo);
            return;
        }
        setX(f16);
        setY(f17);
        setText(flipCardInfo.getSubTitleText());
        setTextSize(Utils.getRelativeSize375(context, 12));
        setTextColor(-855638017);
        setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        setTextAlign(Paint.Align.CENTER);
        setAnimator(new KeepAnimator(this));
    }

    public void startDismissAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(this, 0.8f, 0.0f);
        alphaAnimator.setDuration(500L);
        setAnimator(alphaAnimator);
    }

    public void startShowAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(this, 0.0f, 0.8f);
        alphaAnimator.setDuration(500L);
        setAnimator(alphaAnimator);
    }
}
