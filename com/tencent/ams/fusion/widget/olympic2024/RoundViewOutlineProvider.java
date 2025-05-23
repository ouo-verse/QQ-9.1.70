package com.tencent.ams.fusion.widget.olympic2024;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class RoundViewOutlineProvider extends ViewOutlineProvider {
    static IPatchRedirector $redirector_;
    private final float mRadius;

    public RoundViewOutlineProvider(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
        } else {
            this.mRadius = f16;
        }
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
        } else {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), this.mRadius);
        }
    }
}
