package com.tencent.turingcam;

import android.util.Base64;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class nq6Fd {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382319a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382320b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f382321c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f382322d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f382323e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382323e = true;
        f382319a = LwgsO.a(LwgsO.T0);
        f382320b = LwgsO.a(LwgsO.P0);
        f382321c = LwgsO.a(LwgsO.Q0);
        f382322d = LwgsO.a(LwgsO.R0);
    }

    public nq6Fd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(Certificate certificate) {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN CERTIFICATE-----");
        bufferedWriter.write("\n");
        byte[] encode = Base64.encode(certificate.getEncoded(), 2);
        char[] cArr = new char[64];
        for (int i3 = 0; i3 < encode.length; i3 += 64) {
            int i16 = 0;
            while (i16 != 64) {
                int i17 = i3 + i16;
                if (i17 >= encode.length) {
                    break;
                }
                cArr[i16] = (char) encode[i17];
                i16++;
            }
            bufferedWriter.write(cArr, 0, i16);
            bufferedWriter.write("\n");
        }
        bufferedWriter.write("-----END CERTIFICATE-----");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    public static void a(X509Certificate x509Certificate, d3EI1 d3ei1) {
        byte[] extensionValue = x509Certificate.getExtensionValue(f382319a);
        if (extensionValue != null && extensionValue.length != 0) {
            try {
                byte b16 = "{".getBytes()[0];
                byte b17 = "}".getBytes()[0];
                int i3 = 0;
                int i16 = 0;
                for (int i17 = 0; i17 < extensionValue.length; i17++) {
                    byte b18 = extensionValue[i17];
                    if (b18 == b16) {
                        i3 = i17;
                    } else if (b18 == b17) {
                        i16 = i17;
                    }
                }
                if (i3 <= 0 || i3 >= i16) {
                    return;
                }
                if (!f382323e && extensionValue[i3 - 1] != (i16 - i3) + 1) {
                    throw new AssertionError();
                }
                int i18 = (i16 - i3) + 1;
                byte[] bArr = new byte[i18];
                System.arraycopy(extensionValue, i3, bArr, 0, i18);
                JSONObject jSONObject = new JSONObject(new String(bArr));
                d3ei1.f382187c = jSONObject.getString(f382321c);
                d3ei1.f382186b = jSONObject.getInt(f382322d);
                d3ei1.f382185a = jSONObject.getLong(f382320b);
                return;
            } catch (Exception e16) {
                StringBuilder a16 = tmnyR.a(BdhLogUtil.LogTag.Tag_Conn);
                a16.append(e16.getStackTrace());
                throw new Exception(a16.toString());
            }
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
