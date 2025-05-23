package com.tencent.mobileqq.avifcodec.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f200185a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.avifcodec.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C7436a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f200186a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34793);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f200186a = new a();
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200185a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
    }

    public static a c() {
        return C7436a.f200186a;
    }

    public long b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, j3)).longValue();
        }
        return this.f200185a.decodeLong(a("KEY_AVIF_UPDATE_CYCLE"), j3);
    }

    public long d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, j3)).longValue();
        }
        return this.f200185a.decodeLong(a("KEY_AVIF_LAST_UPDATE_TIME"), j3);
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f200185a.decodeInt(a("KEY_RECORD_UNSUPPORTED_AVIF_DECODE_REASON"), 1);
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f200185a.decodeBool(a("KEY_SUPPROT_AVIF_DECODE"), false);
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f200185a.decodeBool(a("KEY_SUPPROT_AVIF_ENCODE"), false);
    }

    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.f200185a.encodeLong(a("KEY_AVIF_UPDATE_CYCLE"), j3);
        }
    }

    public void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.f200185a.encodeLong(a("KEY_AVIF_LAST_UPDATE_TIME"), j3);
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f200185a.encodeBool(a("KEY_SUPPROT_AVIF_DECODE"), z16);
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f200185a.encodeInt(a("KEY_RECORD_UNSUPPORTED_AVIF_DECODE_REASON"), i3);
        }
    }

    public static String a(String str) {
        return str;
    }
}
