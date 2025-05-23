package com.tencent.luggage.wxa.np;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(BufferedWriter bufferedWriter, byte[] bArr) {
        char[] cArr = new char[64];
        for (int i3 = 0; i3 < bArr.length; i3 += 64) {
            int i16 = 0;
            while (i16 != 64) {
                int i17 = i3 + i16;
                if (i17 >= bArr.length) {
                    break;
                }
                cArr[i16] = (char) bArr[i17];
                i16++;
            }
            bufferedWriter.write(cArr, 0, i16);
            bufferedWriter.write("\n");
        }
    }

    public static void b(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write("-----BEGIN " + str + "-----");
        bufferedWriter.write("\n");
    }

    public static void a(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write("-----END " + str + "-----");
        bufferedWriter.write("\n");
    }

    public static String a(Certificate certificate) {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        b(bufferedWriter, "CERTIFICATE");
        a(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        a(bufferedWriter, "CERTIFICATE");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    public static void a(X509Certificate x509Certificate, k kVar) {
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (extensionValue != null && extensionValue.length != 0) {
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
            int i18 = (i16 - i3) + 1;
            if (extensionValue[i3 - 1] != i18) {
                e.e("Soter.CertUtil", "read extension lenght error", new Object[0]);
            }
            byte[] bArr = new byte[i18];
            System.arraycopy(extensionValue, i3, bArr, 0, i18);
            String str = new String(bArr);
            e.c("Soter.CertUtil", "soter: challenge json in attestation certificate " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            kVar.a(jSONObject.getString("cpu_id"));
            kVar.a(jSONObject.getInt("uid"));
            kVar.a(jSONObject.getLong("counter"));
            return;
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
