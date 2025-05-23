package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c implements com.tencent.mobileqq.surfaceviewaction.c<c> {
    static IPatchRedirector $redirector_;
    public List<com.tencent.mobileqq.surfaceviewaction.a> R;

    public b(SpriteNativeView spriteNativeView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spriteNativeView);
        } else {
            this.R = new ArrayList();
            this.P = spriteNativeView;
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.c
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean A = super.A();
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            A |= ((c) this.R.get(i3)).A();
        }
        return A;
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.c
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            if (cVar.I == null) {
                this.R.add(cVar);
                cVar.I = this;
                cVar.B();
                return;
            }
            new RuntimeException("the node had another parent");
        }
    }
}
