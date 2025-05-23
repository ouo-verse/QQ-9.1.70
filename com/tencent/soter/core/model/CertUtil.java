package com.tencent.soter.core.model;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CertUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String JSON_KEY_COUNTER = "counter";
    public static final String JSON_KEY_CPU_ID = "cpu_id";
    public static final String JSON_KEY_UID = "uid";
    private static final String KEY_DESCRIPTION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final int LINE_LENGTH = 64;
    private static final String LINE_SEPARATOR = "\n";
    protected static final String TAG = "Soter.CertUtil";

    public CertUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void extractAttestationSequence(X509Certificate x509Certificate, SoterPubKeyModel soterPubKeyModel) throws Exception, IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(KEY_DESCRIPTION_OID);
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
            if (i3 > 0 && i3 < i16) {
                int i18 = (i16 - i3) + 1;
                if (extensionValue[i3 - 1] != i18) {
                    SLogger.w(TAG, "read extension lenght error", new Object[0]);
                }
                byte[] bArr = new byte[i18];
                System.arraycopy(extensionValue, i3, bArr, 0, i18);
                String str = new String(bArr);
                SLogger.i(TAG, "soter: challenge json in attestation certificate " + str, new Object[0]);
                JSONObject jSONObject = new JSONObject(str);
                soterPubKeyModel.setCpu_id(jSONObject.getString("cpu_id"));
                soterPubKeyModel.setUid(jSONObject.getInt("uid"));
                soterPubKeyModel.setCounter(jSONObject.getLong("counter"));
                return;
            }
            return;
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }

    public static String format(Certificate certificate) throws Exception {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        writePreEncapsulationBoundary(bufferedWriter, "CERTIFICATE");
        writeEncoded(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        writePostEncapsulationBoundary(bufferedWriter, "CERTIFICATE");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    private static void writeEncoded(BufferedWriter bufferedWriter, byte[] bArr) throws IOException {
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

    private static void writePostEncapsulationBoundary(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write("-----END " + str + "-----");
        bufferedWriter.write("\n");
    }

    private static void writePreEncapsulationBoundary(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write("-----BEGIN " + str + "-----");
        bufferedWriter.write("\n");
    }
}
