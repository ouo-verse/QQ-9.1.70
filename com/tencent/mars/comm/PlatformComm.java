package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class PlatformComm {
    static IPatchRedirector $redirector_ = null;
    public static final int EMobile = 2;
    public static final int ENoNet = -1;
    public static final int EOtherNet = 3;
    public static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    public static final int NETTYPE_2G = 3;
    public static final int NETTYPE_3G = 4;
    public static final int NETTYPE_4G = 5;
    public static final int NETTYPE_5G = 7;
    public static final int NETTYPE_NON = -1;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_UNKNOWN = 6;
    public static final int NETTYPE_WAP = 2;
    public static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    private static Context context;
    private static b0 handler;
    public static IReportCrash reportCrashImp;
    public static IResetProcess resetprocessimp;

    /* loaded from: classes9.dex */
    public static class APNInfo {
        static IPatchRedirector $redirector_;
        public String extraInfo;
        public int netType;
        public int subNetType;

        public APNInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class Assert {
        static IPatchRedirector $redirector_;

        public Assert() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static void assertTrue(String str, boolean z16) {
        }

        public static void assertTrue(boolean z16) {
        }
    }

    /* loaded from: classes9.dex */
    public static class CertVerifyResult {
        static IPatchRedirector $redirector_;
        public byte[][] certificateChain;
        public boolean isIssuedByKnownRoot;
        public int status;

        public CertVerifyResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.isIssuedByKnownRoot = false;
            this.status = 0;
            this.certificateChain = null;
        }
    }

    /* loaded from: classes9.dex */
    public interface IReportCrash {
        void reportIdkey();
    }

    /* loaded from: classes9.dex */
    public interface IResetProcess {
        void restartProcess();
    }

    /* loaded from: classes9.dex */
    public static class SIMInfo {
        static IPatchRedirector $redirector_;
        public String ispCode;
        public String ispName;

        public SIMInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class WifiInfo {
        static IPatchRedirector $redirector_;
        public String bssid;
        public String ssid;

        public WifiInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public PlatformComm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void init(Context context2, b0 b0Var) {
        context = context2;
        handler = b0Var;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
    }

    /* loaded from: classes9.dex */
    public static class C2Java {
        static IPatchRedirector $redirector_;

        public C2Java() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static CertVerifyResult convertToCronetResult(AndroidCertVerifyResult androidCertVerifyResult) {
            CertVerifyResult certVerifyResult = new CertVerifyResult();
            certVerifyResult.status = androidCertVerifyResult.getStatus();
            certVerifyResult.isIssuedByKnownRoot = androidCertVerifyResult.isIssuedByKnownRoot();
            certVerifyResult.certificateChain = androidCertVerifyResult.getCertificateChainEncoded();
            return certVerifyResult;
        }

        public static int doCertificateVerify(String str, byte[][] bArr) {
            w.d(PlatformComm.TAG, "verify certificate for %s", str);
            try {
                AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str);
                w.d(PlatformComm.TAG, "host %s verify result %d, is known roots %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()));
                return verifyServerCertificates.getStatus();
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, e16.getLocalizedMessage());
                return -1;
            }
        }

        public static CertVerifyResult doCertificateVerifyWithDetail(String str, byte[][] bArr) {
            w.d(PlatformComm.TAG, "verify certificate for %s", str);
            try {
                AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str);
                CertVerifyResult certVerifyResult = new CertVerifyResult();
                certVerifyResult.status = verifyServerCertificates.getStatus();
                certVerifyResult.isIssuedByKnownRoot = verifyServerCertificates.isIssuedByKnownRoot();
                certVerifyResult.certificateChain = verifyServerCertificates.getCertificateChainEncoded();
                verifyServerCertificates.getCertificateChainEncoded();
                w.d(PlatformComm.TAG, "host %s verify result %d, is known roots %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()));
                return certVerifyResult;
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, e16.getLocalizedMessage());
                CertVerifyResult certVerifyResult2 = new CertVerifyResult();
                certVerifyResult2.status = -1;
                return certVerifyResult2;
            }
        }

        private static String exception2String(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        public static APNInfo getAPNInfo() {
            String netGetExInfo;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) z.c().getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo != null) {
                    aPNInfo.netType = NetworkMonitor.getType(activeNetworkInfo);
                    aPNInfo.subNetType = NetworkMonitor.getSubtype(activeNetworkInfo);
                    if (1 != NetworkMonitor.getType(activeNetworkInfo)) {
                        if (NetworkMonitor.netGetExInfo(activeNetworkInfo) == null) {
                            netGetExInfo = "";
                        } else {
                            netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                        }
                        aPNInfo.extraInfo = netGetExInfo;
                    } else {
                        aPNInfo.extraInfo = getCurWifiInfo().ssid;
                    }
                    return aPNInfo;
                }
                return null;
            } catch (Exception e16) {
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                return null;
            }
        }

        public static int getCurRadioAccessNetworkInfo() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                return NetworkMonitor.getNetworkType((TelephonyManager) PlatformComm.context.getSystemService("phone"));
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, exception2String(e16));
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return 0;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            int b16;
            try {
                if (PlatformComm.context == null || (b16 = h0.b(PlatformComm.context)) == 0) {
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                String str = "" + b16;
                sIMInfo.ispCode = str;
                w.a(PlatformComm.TAG, "getISPCode MCC_MNC=%s", str);
                sIMInfo.ispName = h0.c(PlatformComm.context);
                return sIMInfo;
            } catch (Exception e16) {
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                return null;
            }
        }

        @Deprecated
        public static WifiInfo getCurWifiInfo() {
            WifiInfo wifiInfo = new WifiInfo();
            wifiInfo.ssid = "";
            wifiInfo.bssid = "";
            return wifiInfo;
        }

        public static int getNetInfo() {
            NetworkInfo networkInfo;
            ConnectivityManager connectivityManager;
            try {
                connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (connectivityManager == null) {
                return -1;
            }
            networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) {
                return -1;
            }
            try {
                int type = NetworkMonitor.getType(networkInfo);
                if (type != 0) {
                    if (type == 1) {
                        return 1;
                    }
                    if (type != 2 && type != 3 && type != 4 && type != 5) {
                        return 3;
                    }
                }
                return 2;
            } catch (Exception e16) {
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                return 3;
            }
        }

        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        public static long getSignal(boolean z16) {
            try {
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0L;
                }
                if (z16) {
                    return NetworkSignalUtil.getWifiSignalStrength();
                }
                return NetworkSignalUtil.getGSMSignalStrength();
            } catch (Exception e16) {
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                return 0L;
            }
        }

        public static int getStatisticsNetType() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                int d16 = h0.d(PlatformComm.context);
                if (d16 == -1) {
                    return -1;
                }
                if (h0.b(d16)) {
                    return 1;
                }
                if (h0.f(PlatformComm.context)) {
                    return 3;
                }
                if (h0.g(PlatformComm.context)) {
                    return 4;
                }
                if (h0.h(PlatformComm.context)) {
                    return 5;
                }
                if (h0.i(PlatformComm.context)) {
                    return 7;
                }
                if (h0.a(d16)) {
                    return 2;
                }
                return 6;
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, exception2String(e16));
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return -1;
            }
        }

        public static boolean isNetworkConnected() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return h0.k(PlatformComm.context);
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, exception2String(e16));
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return false;
            }
        }

        public static void restartProcess() {
            if (PlatformComm.resetprocessimp == null) {
                return;
            }
            try {
                PlatformComm.handler.a(new Runnable() { // from class: com.tencent.mars.comm.PlatformComm.C2Java.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            PlatformComm.resetprocessimp.restartProcess();
                        }
                    }
                });
            } catch (Exception e16) {
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
            }
        }

        public static boolean startAlarm(int i3, int i16, int i17) {
            w.d(PlatformComm.TAG, "start alarm type:%d id is %d", Integer.valueOf(i3), Integer.valueOf(i16));
            if (PlatformComm.context != null) {
                try {
                    return Alarm.start(i3, i16, i17, PlatformComm.context);
                } catch (Exception e16) {
                    IReportCrash iReportCrash = PlatformComm.reportCrashImp;
                    if (iReportCrash != null) {
                        iReportCrash.reportIdkey();
                    }
                    w.b(PlatformComm.TAG, exception2String(e16));
                    w.a(PlatformComm.TAG, e16, "", new Object[0]);
                    Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                    return false;
                }
            }
            Assert.assertTrue(false);
            return false;
        }

        public static boolean stopAlarm(int i3) {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.stop(i3, PlatformComm.context);
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, exception2String(e16));
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return false;
            }
        }

        public static CertVerifyResult verifyCertWithUserCA(byte[][] bArr) {
            try {
                try {
                    w.d("cronet", "verifyCertWithUserCA");
                    KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                    keyStore.load(null, null);
                    ArrayList arrayList = new ArrayList();
                    Enumeration<String> aliases = keyStore.aliases();
                    while (aliases.hasMoreElements()) {
                        String nextElement = aliases.nextElement();
                        if (nextElement != null && nextElement.startsWith("user:")) {
                            arrayList.add(nextElement);
                        }
                    }
                    w.d("cronet", "alias list size %d", Integer.valueOf(arrayList.size()));
                    if (arrayList.isEmpty()) {
                        w.b("cronet", "checkServerTrusted self check aliasList null");
                        return convertToCronetResult(new AndroidCertVerifyResult(-1));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (byte[] bArr2 : bArr) {
                        try {
                            arrayList2.add(X509Util.createCertificateFromBytes(bArr2));
                        } catch (CertificateException e16) {
                            w.b("cronet", e16.getLocalizedMessage());
                            return convertToCronetResult(new AndroidCertVerifyResult(-5));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate((String) it.next());
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            try {
                                ((X509Certificate) it5.next()).verify(x509Certificate.getPublicKey());
                                w.d("cronet", "do user verify success");
                                return convertToCronetResult(new AndroidCertVerifyResult(0));
                            } catch (Exception e17) {
                                w.a("cronet", e17, "Exception: check user verify certificate", new Object[0]);
                            }
                        }
                    }
                    return convertToCronetResult(new AndroidCertVerifyResult(-1));
                } catch (IOException e18) {
                    e = e18;
                    w.b("cronet", e.getLocalizedMessage());
                    return convertToCronetResult(new AndroidCertVerifyResult(-1));
                } catch (KeyStoreException e19) {
                    e = e19;
                    w.b("cronet", e.getLocalizedMessage());
                    return convertToCronetResult(new AndroidCertVerifyResult(-1));
                } catch (NoSuchAlgorithmException e26) {
                    e = e26;
                    w.b("cronet", e.getLocalizedMessage());
                    return convertToCronetResult(new AndroidCertVerifyResult(-1));
                }
            } catch (CertificateException e27) {
                e = e27;
                w.b("cronet", e.getLocalizedMessage());
                return convertToCronetResult(new AndroidCertVerifyResult(-1));
            }
        }

        public static WakerLock wakeupLock_new() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return null;
            }
            try {
                return new WakerLock(PlatformComm.context, PlatformComm.TAG);
            } catch (Exception e16) {
                w.b(PlatformComm.TAG, exception2String(e16));
                w.a(PlatformComm.TAG, e16, "", new Object[0]);
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return null;
            }
        }

        public static boolean startAlarm(int i3, int i16) {
            w.d(PlatformComm.TAG, "start alarm no type id is %d", Integer.valueOf(i3));
            if (PlatformComm.context != null) {
                try {
                    return Alarm.start(113, i3, i16, PlatformComm.context);
                } catch (Exception e16) {
                    IReportCrash iReportCrash = PlatformComm.reportCrashImp;
                    if (iReportCrash != null) {
                        iReportCrash.reportIdkey();
                    }
                    w.b(PlatformComm.TAG, exception2String(e16));
                    w.a(PlatformComm.TAG, e16, "", new Object[0]);
                    Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                    return false;
                }
            }
            Assert.assertTrue(false);
            return false;
        }
    }
}
