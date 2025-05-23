package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSImageView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* loaded from: classes22.dex */
public class PTSNodeImage extends PTSNodeVirtual {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PTSNodeImage";
    private String imageUrl;

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
            return new PTSImageView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new PTSNodeImage(pTSAppInstance);
        }
    }

    public PTSNodeImage(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "img", null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onParseValueFinished();
            setImageSrc(this.imageUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).booleanValue();
        }
        if (super.setAttribute(str, obj)) {
            return true;
        }
        if ("src".equalsIgnoreCase(str) && (obj instanceof String)) {
            this.imageUrl = (String) obj;
            return true;
        }
        return false;
    }

    private void setImageSrc(String str) {
    }
}
