package com.tencent.common.danmaku.data;

import android.view.View;
import com.tencent.common.danmaku.render.j;
import com.tencent.common.danmaku.tool.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewDanmaku extends d {
    static IPatchRedirector $redirector_;
    private j.a H;
    private boolean I;

    public ViewDanmaku(com.tencent.common.danmaku.inject.b bVar) {
        super(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.I = false;
        }
    }

    public j.a A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.H;
    }

    public boolean B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.I;
    }

    public void C0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.I = z16;
        }
    }

    public void D0(j.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.H = aVar;
        }
    }

    @Override // com.tencent.common.danmaku.data.a
    /* renamed from: J */
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return -2147483647;
    }

    @Override // com.tencent.common.danmaku.data.a
    public com.tencent.common.danmaku.tool.b X(h hVar) {
        View e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.common.danmaku.tool.b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) hVar);
        }
        j.a aVar = this.H;
        if (aVar != null && (e16 = aVar.e(hVar)) != null) {
            com.tencent.common.danmaku.a.b().a().getHandler().post(new Runnable(e16) { // from class: com.tencent.common.danmaku.data.ViewDanmaku.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f99663d;

                {
                    this.f99663d = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ViewDanmaku.this, (Object) e16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f99663d.performClick();
                    }
                }
            });
        }
        return super.X(hVar);
    }

    @Override // com.tencent.common.danmaku.data.a
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.e0();
            this.I = false;
        }
    }
}
