package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSUmbreonImageView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends PTSNodeImage {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f342262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.pts.utils.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.pts.utils.b
        public void a(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            } else {
                ((ImageView) b.this.getView()).setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.pts.ui.vnode.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C9290b implements PTSNodeVirtual.a {
        static IPatchRedirector $redirector_;

        public C9290b() {
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
            return new PTSUmbreonImageView((b) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new b(pTSAppInstance);
        }
    }

    public b(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
        }
    }

    private void a() {
        String str = this.f342262a;
        if (str != null && !str.equals("")) {
            c.c(this.f342262a, new a());
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeImage, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onParseValueFinished();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeImage, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).booleanValue();
        }
        if ("src".equalsIgnoreCase(str) && (obj instanceof String)) {
            this.f342262a = (String) obj;
            return true;
        }
        return super.setAttribute(str, obj);
    }
}
