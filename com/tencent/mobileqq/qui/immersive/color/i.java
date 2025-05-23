package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i extends a {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? canHandle(view.getBackground()) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.a, com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(View view, IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) area);
        }
        return super.getColor(view.getBackground(), area);
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? drawable instanceof LayerDrawable : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable)).booleanValue();
    }
}
