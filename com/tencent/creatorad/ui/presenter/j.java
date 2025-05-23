package com.tencent.creatorad.ui.presenter;

import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends com.tencent.creatorad.ui.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final int f100437f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f100437f = com.tencent.creatorad.ui.c.c(4, true, 1);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f100437f;
    }

    @Override // com.tencent.creatorad.ui.b
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e4w;
    }

    @Override // com.tencent.creatorad.ui.b
    protected void j(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) creatorReader$ShareAD);
        }
    }

    @Override // com.tencent.creatorad.ui.b
    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
