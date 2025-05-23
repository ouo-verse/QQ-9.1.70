package com.tencent.ams.mosaic.jsengine;

import com.tencent.ams.mosaic.MosaicView;
import com.tencent.ams.mosaic.jsengine.component.container.Container;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MosaicView f71444a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.b
    public void a(Container container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) container);
        } else if (container instanceof MosaicView) {
            this.f71444a = (MosaicView) container;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MosaicView getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MosaicView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71444a;
    }
}
