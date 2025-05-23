package com.tencent.mars.comm;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_ = null;
    private static final char[] HEX_DIGITS;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    public static final int STATE_APPBRAND = 1;
    public static final int STATE_CDN = 0;
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock;
    private static v sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class CertVerifyStatusAndroid {
        static IPatchRedirector $redirector_ = null;
        public static final int EXPIRED = -3;
        public static final int FAILED = -1;
        public static final int INCORRECT_KEY_USAGE = -6;
        public static final int NOT_YET_VALID = -4;
        public static final int NO_TRUSTED_ROOT = -2;
        public static final int OK = 0;
        public static final int UNABLE_TO_PARSE = -5;

        public CertVerifyStatusAndroid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class TrustStorageListener extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        TrustStorageListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean equals;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (!"android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) && !"android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction()) && (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false))) {
                    equals = false;
                } else {
                    equals = true;
                }
            } else {
                equals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            }
            if (equals) {
                try {
                    X509Util.reloadDefaultTrustManager();
                } catch (KeyStoreException e16) {
                    w.b(X509Util.TAG, "Unable to reload the default TrustManager", e16);
                } catch (NoSuchAlgorithmException e17) {
                    w.b(X509Util.TAG, "Unable to reload the default TrustManager", e17);
                } catch (CertificateException e18) {
                    w.b(X509Util.TAG, "Unable to reload the default TrustManager", e18);
                }
            }
        }

        public /* synthetic */ TrustStorageListener(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        static IPatchRedirector $redirector_;
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) x509TrustManager);
            } else {
                this.mTrustManager = x509TrustManager;
            }
        }

        @Override // com.tencent.mars.comm.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, this, x509CertificateArr, str, str2);
            }
            this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        static IPatchRedirector $redirector_;
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) x509TrustManager);
            } else {
                this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            }
        }

        @Override // com.tencent.mars.comm.X509Util.X509TrustManagerImplementation
        @SuppressLint({"NewApi"})
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, this, x509CertificateArr, str, str2);
            }
            return this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        $assertionsDisabled = true;
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
        synchronized (sLock) {
            sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), createCertificateFromBytes);
            reloadTestTrustManager();
        }
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        ensureInitialized();
        synchronized (sLock) {
            try {
                sTestKeyStore.load(null);
                reloadTestTrustManager();
            } catch (IOException unused) {
            }
        }
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    return new X509TrustManagerJellyBean((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e16) {
                    w.b(TAG, "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e16);
                }
            }
        }
        w.b(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void ensureInitialized() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        synchronized (sLock) {
            ensureInitializedLocked();
        }
    }

    private static void ensureInitializedLocked() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (sCertificateFactory == null) {
            sCertificateFactory = CertificateFactory.getInstance("X.509");
        }
        AnonymousClass1 anonymousClass1 = null;
        if (sDefaultTrustManager == null) {
            sDefaultTrustManager = createTrustManager(null);
        }
        if (!sLoadedSystemKeyStore) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                sSystemKeyStore = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                sSystemCertificateDirectory = new v(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            sLoadedSystemKeyStore = true;
        }
        if (sSystemTrustAnchorCache == null) {
            sSystemTrustAnchorCache = new HashSet();
        }
        if (sTestKeyStore == null) {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            sTestKeyStore = keyStore2;
            try {
                keyStore2.load(null);
            } catch (IOException unused3) {
            }
        }
        if (sTestTrustManager == null) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
        }
        if (sTrustStorageListener == null) {
            sTrustStorageListener = new TrustStorageListener(anonymousClass1);
            IntentFilter intentFilter = new IntentFilter();
            if (Build.VERSION.SDK_INT >= 26) {
                intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
            } else {
                intentFilter.addAction("android.security.STORAGE_CHANGED");
            }
            z.c().registerReceiver(sTrustStorageListener, intentFilter);
        }
    }

    private static List<String> getSubjectAlternativeNames(X509Certificate x509Certificate) throws CertificateParsingException {
        String str;
        Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<List<?>> it = subjectAlternativeNames.iterator();
        while (it.hasNext()) {
            Object obj = it.next().get(1);
            if (obj instanceof String) {
                arrayList.add(((String) obj).toLowerCase());
            }
        }
        String trim = x509Certificate.getSubjectDN().getName().trim();
        int indexOf = trim.indexOf("CN=");
        if (indexOf >= 0) {
            str = trim.substring(indexOf + 3);
            int indexOf2 = str.indexOf(",");
            if (indexOf2 > 0) {
                str = str.substring(0, indexOf2);
            }
        } else {
            str = "";
        }
        w.d(TAG, "certificate dn %s cn %s", trim, str);
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static String hashPrincipal(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = i3 * 2;
            char[] cArr2 = HEX_DIGITS;
            byte b16 = digest[3 - i3];
            cArr[i16] = cArr2[(b16 >> 4) & 15];
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    private static boolean isHostMatched(List<String> list, String str) {
        if (list.contains(str)) {
            return true;
        }
        int indexOf = str.indexOf(".");
        int lastIndexOf = str.lastIndexOf(".");
        while (indexOf > 0 && indexOf < lastIndexOf) {
            String str2 = "*" + str.substring(indexOf);
            w.d(TAG, "try match nhost " + str2);
            if (list.contains(str2)) {
                return true;
            }
            indexOf = str.indexOf(".", indexOf + 1);
        }
        return false;
    }

    private static boolean isKnownRoot(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (sSystemKeyStore == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (sSystemTrustAnchorCache.contains(pair)) {
            return true;
        }
        String hashPrincipal = hashPrincipal(x509Certificate.getSubjectX500Principal());
        int i3 = 0;
        while (true) {
            String str = hashPrincipal + '.' + i3;
            if (!new v(sSystemCertificateDirectory, str).e()) {
                return false;
            }
            Certificate certificate = sSystemKeyStore.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    w.b(TAG, "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        sSystemTrustAnchorCache.add(pair);
                        return true;
                    }
                }
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reloadDefaultTrustManager() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        synchronized (sLock) {
            sDefaultTrustManager = null;
            sSystemTrustAnchorCache = null;
            ensureInitializedLocked();
        }
    }

    private static void reloadTestTrustManager() throws KeyStoreException, NoSuchAlgorithmException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    public static boolean verifyKeyUsage(X509Certificate x509Certificate) throws CertificateException {
        List<String> extendedKeyUsage;
        try {
            extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        } catch (NullPointerException unused) {
        }
        if (extendedKeyUsage == null) {
            return true;
        }
        for (String str : extendedKeyUsage) {
            if (str.equals(OID_TLS_SERVER_AUTH) || str.equals(OID_ANY_EKU) || str.equals(OID_SERVER_GATED_NETSCAPE) || str.equals(OID_SERVER_GATED_MICROSOFT)) {
                return true;
            }
        }
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) throws KeyStoreException, NoSuchAlgorithmException, CertificateParsingException {
        return verifyServerCertificates(bArr, str, str2, 0, null);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, X509TrustManager x509TrustManager) throws KeyStoreException, NoSuchAlgorithmException, CertificateParsingException {
        return verifyServerCertificates(bArr, str, str2, 0, x509TrustManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: CertificateException -> 0x016e, CertificateNotYetValidException -> 0x0174, CertificateExpiredException -> 0x017b, TRY_LEAVE, TryCatch #10 {CertificateExpiredException -> 0x017b, CertificateNotYetValidException -> 0x0174, CertificateException -> 0x016e, blocks: (B:36:0x00c4, B:38:0x00d1), top: B:35:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i3, X509TrustManager x509TrustManager) throws KeyStoreException, NoSuchAlgorithmException, CertificateParsingException {
        boolean z16;
        int i16;
        X509Certificate[] x509CertificateArr;
        List<X509Certificate> checkServerTrusted;
        List<String> subjectAlternativeNames;
        w.d(TAG, "verifyServerCertificates %s type %s", str2, str);
        if (bArr != null && bArr.length != 0 && bArr[0] != null) {
            try {
                ensureInitialized();
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(createCertificateFromBytes(bArr[0]));
                    try {
                        subjectAlternativeNames = getSubjectAlternativeNames((X509Certificate) arrayList.get(0));
                        w.d(TAG, "check host %s in altnames %s", str2, subjectAlternativeNames.toString());
                    } catch (Exception e16) {
                        w.b(TAG, "hostname verify failed " + e16.getLocalizedMessage());
                        if (i3 != 1) {
                            return new AndroidCertVerifyResult(-1);
                        }
                    }
                    if (!isHostMatched(subjectAlternativeNames, str2)) {
                        w.b(TAG, "hostname mismatch");
                        if (i3 != 1) {
                            return new AndroidCertVerifyResult(-1);
                        }
                        z16 = false;
                        for (i16 = 1; i16 < bArr.length; i16++) {
                            try {
                                arrayList.add(createCertificateFromBytes(bArr[i16]));
                            } catch (CertificateException unused) {
                                w.f(TAG, "intermediate " + i16 + " failed parsing");
                            }
                        }
                        x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                        try {
                            x509CertificateArr[0].checkValidity();
                            if (verifyKeyUsage(x509CertificateArr[0])) {
                                return new AndroidCertVerifyResult(-6);
                            }
                            synchronized (sLock) {
                                X509TrustManagerImplementation x509TrustManagerImplementation = sDefaultTrustManager;
                                if (x509TrustManagerImplementation == null && x509TrustManager == null) {
                                    return new AndroidCertVerifyResult(-1);
                                }
                                if (x509TrustManager != null) {
                                    try {
                                        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                                        return new AndroidCertVerifyResult(0, true, new ArrayList(), z16);
                                    } catch (CertificateException e17) {
                                        w.d(TAG, "Failed to validate the certificate chain use self trustmanager, error: " + e17.getMessage());
                                        return new AndroidCertVerifyResult(-2);
                                    }
                                }
                                try {
                                    checkServerTrusted = x509TrustManagerImplementation.checkServerTrusted(x509CertificateArr, str, str2);
                                } catch (CertificateException e18) {
                                    try {
                                        checkServerTrusted = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                    } catch (CertificateException unused2) {
                                        w.d(TAG, "Failed to validate the certificate chain, error: " + e18.getMessage());
                                        return new AndroidCertVerifyResult(-2);
                                    }
                                }
                                return new AndroidCertVerifyResult(0, checkServerTrusted.size() > 0 ? isKnownRoot(checkServerTrusted.get(checkServerTrusted.size() - 1)) : false, checkServerTrusted, z16);
                            }
                        } catch (CertificateExpiredException unused3) {
                            return new AndroidCertVerifyResult(-3);
                        } catch (CertificateNotYetValidException unused4) {
                            return new AndroidCertVerifyResult(-4);
                        } catch (CertificateException unused5) {
                            return new AndroidCertVerifyResult(-1);
                        }
                    }
                    z16 = true;
                    while (i16 < bArr.length) {
                    }
                    x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    x509CertificateArr[0].checkValidity();
                    if (verifyKeyUsage(x509CertificateArr[0])) {
                    }
                } catch (CertificateException unused6) {
                    return new AndroidCertVerifyResult(-5);
                }
            } catch (CertificateException unused7) {
                return new AndroidCertVerifyResult(-1);
            }
        } else {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
    }
}
