package com.tencent.mobileqq.popanim;

import com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends AbstractEmoticonPanelHelper<EmoticonPanelController> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<InterfaceC8226a> f259108d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.popanim.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC8226a {
        void onHide();

        void onPause();
    }

    public a(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
        }
    }

    public void b(InterfaceC8226a interfaceC8226a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interfaceC8226a);
        } else {
            this.f259108d = new WeakReference<>(interfaceC8226a);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "EmoticonPopOutHelper";
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new int[]{7, 4};
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        WeakReference<InterfaceC8226a> weakReference = this.f259108d;
        if (weakReference != null && weakReference.get() != null) {
            this.f259108d.get().onHide();
        }
        PopOutAnimViewHolder.d().f();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        WeakReference<InterfaceC8226a> weakReference = this.f259108d;
        if (weakReference != null && weakReference.get() != null) {
            this.f259108d.get().onPause();
        }
    }
}
