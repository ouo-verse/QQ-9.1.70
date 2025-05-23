package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RbRz0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final fDI6Z f382020a;

    /* renamed from: b, reason: collision with root package name */
    public tZ3Yi f382021b;

    public RbRz0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382020a = new fDI6Z();
            this.f382021b = null;
        }
    }

    public final void a() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String a16 = Ckq8l.a(16);
        this.f382020a.getClass();
        this.f382020a.getClass();
        try {
            fDI6Z fdi6z = this.f382020a;
            if (fdi6z.f382240a == null) {
                try {
                    fdi6z.f382240a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Z8Pvx.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtAg68zSoKYYQn13AFxhZO0a010h83/sa/u8r7do4u8E4FtBZq1HL5sQK6tM5eO6x/wjMDLSQWy1tZmfnmGUVLBBH9Ofsq387Nm2sL3IusyH47pO2o6AEsXjJNVkq0jXwuLTBFe117btxtXdZosOt9Tlimknwbk6T1g6qCqlguIGMf6/iAS020FPcSneCP2uCeAi60+Yykld+wU+dK4uaPRUQWWUfOnI/Nh5D5afrjKg26xDNVkWPWqTnzcxHXvlHeI78vt4z4NUdIS+DzJKPSeXg+/vjozg9i48r/V/GERAzEWq65+o3R/50690/9+49s4Yb5e4zgLdS1gMY4y4epQIDAQAB", 0)));
                } catch (Exception unused) {
                }
            }
            fDI6Z fdi6z2 = this.f382020a;
            byte[] a17 = Ckq8l.a(a16);
            fdi6z2.getClass();
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, fdi6z2.f382240a);
                bArr = cipher.doFinal(a17);
            } catch (Exception unused2) {
                bArr = null;
            }
            Xjpd8 xjpd8 = new Xjpd8(128);
            xjpd8.f382097b = "UTF-8";
            xjpd8.a(1, 0);
            if (bArr != null) {
                xjpd8.a(bArr, 1);
            }
            xjpd8.a("EP_TuringMM", 2);
            byte[] a18 = xjpd8.a();
            this.f382020a.getClass();
            tZ3Yi tz3yi = new tZ3Yi(1, a18, a16, null, 0);
            synchronized (this) {
                this.f382021b = tz3yi;
            }
        } catch (UnsupportedEncodingException unused3) {
        }
    }
}
