package com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends Scroller {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f71090a;

    public a(Context context, int i3, Interpolator interpolator) {
        super(context, interpolator);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), interpolator);
        } else {
            this.f71090a = i3;
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        } else {
            super.startScroll(i3, i16, i17, i18, this.f71090a);
        }
    }
}
