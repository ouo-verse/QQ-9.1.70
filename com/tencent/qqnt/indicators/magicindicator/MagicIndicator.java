package com.tencent.qqnt.indicators.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class MagicIndicator extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private bx3.a f357043d;

    public MagicIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void setNavigator(bx3.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        bx3.a aVar2 = this.f357043d;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.b();
        }
        this.f357043d = aVar;
        removeAllViews();
        if (this.f357043d instanceof View) {
            addView((View) this.f357043d, new FrameLayout.LayoutParams(-1, -1));
            this.f357043d.a();
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
