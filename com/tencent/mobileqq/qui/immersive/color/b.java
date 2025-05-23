package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements IColorFetcher {
    static IPatchRedirector $redirector_;

    public b() {
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

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(Drawable drawable, IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) area);
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(c.a(((BitmapDrawable) drawable).getBitmap())));
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? drawable instanceof BitmapDrawable : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(View view, IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getColor(view.getBackground(), area) : (Pair) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) area);
    }
}
