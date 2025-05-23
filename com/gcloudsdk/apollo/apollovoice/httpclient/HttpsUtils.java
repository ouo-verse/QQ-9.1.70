package com.gcloudsdk.apollo.apollovoice.httpclient;

import android.content.Context;
import android.os.Build;
import com.gcloudsdk.apollo.ApolloVoiceLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HttpsUtils {
    private static String PATTERN_IP = "(\\d*\\.){3}\\d*";
    private static Context ctx;

    public static boolean connnectWithIP(String str) {
        Pattern compile = Pattern.compile(PATTERN_IP);
        String host = getHost(str);
        if (host == null || !compile.matcher(host).find()) {
            return false;
        }
        ApolloVoiceLog.LogI("the url connect with ip: " + str);
        return true;
    }

    private static String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static HostnameVerifier getHostNameVerify(String str) {
        String host = getHost(str);
        if (host != null && host.length() != 0) {
            ApolloVoiceLog.LogI("url: " + str + " host: " + host);
            return new FastHostnameVerifier(host);
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x014d: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:334), block:B:112:0x014d */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SSLSocketFactory getSocketFactory(String str) throws CertificateException {
        InputStream inputStream;
        InputStream inputStream2;
        Certificate certificate;
        KeyStore keyStore;
        SSLContext sSLContext;
        CertificateFactory certificateFactory;
        InputStream inputStream3 = null;
        if (ctx == null) {
            ApolloVoiceLog.LogE("getSocketFactory but the context is null");
            return null;
        }
        if (str != null && str.length() != 0) {
            ApolloVoiceLog.LogI("Load CA from an InputStream.");
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        certificateFactory = CertificateFactory.getInstance("X.509");
                    } else {
                        certificateFactory = CertificateFactory.getInstance("X.509", "BC");
                    }
                    inputStream = ctx.getResources().getAssets().open(str);
                } catch (IOException e16) {
                    e = e16;
                    inputStream = null;
                } catch (NoSuchProviderException e17) {
                    e = e17;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream3 != null) {
                    }
                    throw th;
                }
                try {
                } catch (IOException e18) {
                    e = e18;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
                            ApolloVoiceLog.LogE("Close inputStream error.");
                            e19.printStackTrace();
                        }
                    }
                    return null;
                } catch (NoSuchProviderException e26) {
                    e = e26;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e27) {
                            ApolloVoiceLog.LogE("Close inputStream error.");
                            e27.printStackTrace();
                        }
                    }
                    certificate = null;
                    ApolloVoiceLog.LogI("Create a KeyStore contains our trusted CA.");
                    try {
                        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        if (keyStore != null) {
                        }
                    } catch (KeyStoreException e28) {
                        ApolloVoiceLog.LogE("Get keyStoreType error.");
                        e28.printStackTrace();
                        return null;
                    }
                }
                if (inputStream != null) {
                    certificate = certificateFactory.generateCertificate(inputStream);
                    try {
                        inputStream.close();
                    } catch (IOException e29) {
                        ApolloVoiceLog.LogE("Close inputStream error.");
                        e29.printStackTrace();
                    }
                    ApolloVoiceLog.LogI("Create a KeyStore contains our trusted CA.");
                    keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    if (keyStore != null) {
                        ApolloVoiceLog.LogE("The keyStore is null.");
                        return null;
                    }
                    if (certificate == null) {
                        return null;
                    }
                    if (str.contains(".")) {
                        str = str.split("\\.")[0];
                    }
                    try {
                        keyStore.load(null, null);
                        keyStore.setCertificateEntry(str, certificate);
                        ApolloVoiceLog.LogE("Create a TrustManager that trusts the CA in our KeyStore.");
                        try {
                            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            trustManagerFactory.init(keyStore);
                            ApolloVoiceLog.LogI("Create a SSLContext that uses our TrustManager.");
                            try {
                                sSLContext = SSLContext.getInstance("TLS");
                                try {
                                    sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
                                } catch (KeyManagementException e36) {
                                    e = e36;
                                    e.printStackTrace();
                                    if (sSLContext == null) {
                                    }
                                } catch (NoSuchAlgorithmException e37) {
                                    e = e37;
                                    e.printStackTrace();
                                    if (sSLContext == null) {
                                    }
                                }
                            } catch (KeyManagementException e38) {
                                e = e38;
                                sSLContext = null;
                            } catch (NoSuchAlgorithmException e39) {
                                e = e39;
                                sSLContext = null;
                            }
                            if (sSLContext == null) {
                                return null;
                            }
                            return sSLContext.getSocketFactory();
                        } catch (NullPointerException e46) {
                            e46.printStackTrace();
                            return null;
                        } catch (KeyStoreException e47) {
                            e47.printStackTrace();
                            return null;
                        } catch (NoSuchAlgorithmException e48) {
                            e48.printStackTrace();
                            return null;
                        }
                    } catch (IOException e49) {
                        ApolloVoiceLog.LogE("Load KeyStore error.");
                        e49.printStackTrace();
                        return null;
                    } catch (KeyStoreException e56) {
                        ApolloVoiceLog.LogE("SetCertificateEntry error.");
                        e56.printStackTrace();
                        return null;
                    } catch (NoSuchAlgorithmException e57) {
                        ApolloVoiceLog.LogE("Load KeyStore error.");
                        e57.printStackTrace();
                        return null;
                    }
                }
                ApolloVoiceLog.LogE("Read certificate from InputStream failed! " + str);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e58) {
                        ApolloVoiceLog.LogE("Close inputStream error.");
                        e58.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th6) {
                th = th6;
                inputStream3 = inputStream2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e59) {
                        ApolloVoiceLog.LogE("Close inputStream error.");
                        e59.printStackTrace();
                    }
                }
                throw th;
            }
        }
        ApolloVoiceLog.LogE("The parameter cerName is null or empty.");
        return null;
    }

    public static void setContext(Context context) {
        ctx = context;
    }
}
