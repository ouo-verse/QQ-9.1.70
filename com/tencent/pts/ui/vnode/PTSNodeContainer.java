package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSContainerView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* loaded from: classes22.dex */
public class PTSNodeContainer extends PTSNodeVirtual {
    static IPatchRedirector $redirector_;

    /* loaded from: classes22.dex */
    public static class a implements PTSNodeVirtual.a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) pTSNodeVirtual);
            }
            return new PTSContainerView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new PTSNodeContainer(pTSAppInstance);
        }
    }

    public PTSNodeContainer(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "view", null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
        }
    }
}
