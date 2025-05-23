package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.g;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class SSLUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37878a = "SSLUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37879b = "TLSv1.3";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37880c = "TLSv1.2";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37881d = "TLS";

    /* renamed from: e, reason: collision with root package name */
    private static final String f37882e = "TLSv1";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f37883f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f37884g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f37885h = {"TLS_RSA", KeyPropertiesCompact.BLOCK_MODE_CBC, "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES, "DESX", "DES40", "RC2", KeyPropertiesCompact.DIGEST_MD5, "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            g.c(f37878a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            g.c(f37878a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f37885h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket != null && !setWhiteListCipherSuites(sSLSocket)) {
            setBlackListCipherSuites(sSLSocket);
        }
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{f37879b, f37880c});
        }
        if (i3 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f37880c});
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        if (Build.VERSION.SDK_INT >= 29) {
            return SSLContext.getInstance(f37879b);
        }
        return SSLContext.getInstance(f37880c);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        setEnabledProtocols(sSLSocket);
        setEnableSafeCipherSuites(sSLSocket);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setWhiteListCipherSuites(sSLSocket, f37884g);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                break;
            }
            String str = enabledCipherSuites[i3];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length2) {
                    z16 = false;
                    break;
                }
                if (upperCase.contains(strArr[i16].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i16++;
            }
            if (!z16) {
                arrayList.add(str);
            }
            i3++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e16) {
                g.b(f37878a, "setEnabledProtocols: exception : " + e16.getMessage());
            }
        }
        return false;
    }
}
