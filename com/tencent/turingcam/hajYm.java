package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class hajYm {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f382254c;

    /* renamed from: a, reason: collision with root package name */
    public int f382255a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f382256b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ITeamWorkDocEditBrowserProxy.REQUEST_CODE_OPEN_TEAM_WORK_EDIT_BROWSER);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382254c = new byte[0];
        }
    }

    public hajYm(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
        } else {
            this.f382255a = i3;
            this.f382256b = bArr;
        }
    }

    public static hajYm a(int i3) {
        return new hajYm(i3, f382254c);
    }
}
