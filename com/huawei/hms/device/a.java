package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.util.j;
import com.tencent.mobileqq.app.LocaleManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (x509Certificate == null) {
            HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
            return false;
        }
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (X509Certificate x509Certificate2 : list) {
            if (x509Certificate2 != null) {
                try {
                    x509Certificate2.checkValidity();
                    x509Certificate2.verify(publicKey);
                    publicKey = x509Certificate2.getPublicKey();
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e16) {
                    HMSLog.e("X509CertUtil", "verify failed " + e16.getMessage());
                }
            }
            return false;
        }
        return a(list);
    }

    public static List<X509Certificate> b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private static List<String> c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            return arrayList;
        } catch (JSONException e16) {
            HMSLog.e("X509CertUtil", "Failed to getCertChain: " + e16.getMessage());
            return Collections.emptyList();
        }
    }

    public static List<X509Certificate> b(String str) {
        return b(c(str));
    }

    public static boolean b(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        return b(x509Certificate, "OU", str);
    }

    public static X509Certificate a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(Base64.decode(str));
        } catch (IllegalArgumentException e16) {
            HMSLog.e("X509CertUtil", "getCert failed : " + e16.getMessage());
            return null;
        }
    }

    public static X509Certificate a(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e16) {
            HMSLog.e("X509CertUtil", "Failed to get cert: " + e16.getMessage());
            return null;
        }
    }

    private static String a(String str, String str2) {
        int indexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 != -1) {
            return str.substring(indexOf + str2.length() + 1, indexOf2);
        }
        return str.substring(indexOf + str2.length() + 1);
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    public static boolean a(List<X509Certificate> list) {
        for (int i3 = 0; i3 < list.size() - 1; i3++) {
            if (!a(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        return b(x509Certificate, LocaleManager.MOBILE_COUNTRY_CODE_CN_STR, str);
    }

    public static boolean a(X509Certificate x509Certificate, String str, String str2) {
        try {
            return a(x509Certificate, str.getBytes("UTF-8"), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e16) {
            HMSLog.e("X509CertUtil", " plainText exception: " + e16.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e16) {
            HMSLog.e("X509CertUtil", "failed checkSignature : " + e16.getMessage());
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0097: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:38:0x0097 */
    public static X509Certificate a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        KeyStore keyStore;
        InputStream inputStream3 = null;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        keyStore = KeyStore.getInstance(j.f37993e);
                        inputStream2 = context.getAssets().open("hmsrootcas.bks");
                    } catch (IOException e16) {
                        e = e16;
                        inputStream2 = null;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (KeyStoreException e17) {
                        e = e17;
                        inputStream2 = null;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (NoSuchAlgorithmException e18) {
                        e = e18;
                        inputStream2 = null;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (CertificateException e19) {
                        e = e19;
                        inputStream2 = null;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        IOUtils.closeQuietly(inputStream3);
                        throw th;
                    }
                    try {
                        keyStore.load(inputStream2, "".toCharArray());
                    } catch (IOException e26) {
                        e = e26;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (KeyStoreException e27) {
                        e = e27;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (NoSuchAlgorithmException e28) {
                        e = e28;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (CertificateException e29) {
                        e = e29;
                        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    }
                    if (!keyStore.containsAlias(str)) {
                        HMSLog.e("X509CertUtil", "Not include alias " + str);
                        HMSPackageManager.getInstance(context).setUseOldCertificate(true);
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    }
                    Certificate certificate = keyStore.getCertificate(str);
                    if (!(certificate instanceof X509Certificate)) {
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    }
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    x509Certificate.checkValidity();
                    IOUtils.closeQuietly(inputStream2);
                    return x509Certificate;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream3 = inputStream;
            }
        }
        HMSLog.e("X509CertUtil", "args are error");
        return null;
    }

    public static X509Certificate a(Context context) {
        return a(context, j.f37994f);
    }
}
