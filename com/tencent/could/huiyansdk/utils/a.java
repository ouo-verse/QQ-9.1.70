package com.tencent.could.huiyansdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public p<byte[]> f100296a;

    /* compiled from: P */
    /* renamed from: com.tencent.could.huiyansdk.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1020a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f100297a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_HDR_INFO_CHANGED);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100297a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        p<byte[]> pVar = this.f100296a;
        if (pVar == null) {
            return null;
        }
        return pVar.acquire();
    }
}
