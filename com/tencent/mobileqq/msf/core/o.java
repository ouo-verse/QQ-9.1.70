package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f249558a = "MSF.C.Util";

    /* renamed from: b, reason: collision with root package name */
    private static final int f249559b = 60000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f249560c = 1000000;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f249561d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f249562e = "sp_imei";

    /* renamed from: f, reason: collision with root package name */
    public static final int f249563f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249564g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249565h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249566i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249567j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static long f249568k;

    /* renamed from: l, reason: collision with root package name */
    public static String f249569l;

    /* renamed from: m, reason: collision with root package name */
    public static String f249570m;

    /* renamed from: n, reason: collision with root package name */
    public static int f249571n;

    /* renamed from: o, reason: collision with root package name */
    private static String f249572o;

    /* renamed from: p, reason: collision with root package name */
    private static String f249573p;

    /* renamed from: q, reason: collision with root package name */
    private static int f249574q;

    /* renamed from: r, reason: collision with root package name */
    private static int f249575r;

    /* renamed from: s, reason: collision with root package name */
    private static String f249576s;

    /* renamed from: t, reason: collision with root package name */
    private static String f249577t;

    /* renamed from: u, reason: collision with root package name */
    private static String f249578u;

    /* renamed from: v, reason: collision with root package name */
    private static String f249579v;

    /* renamed from: w, reason: collision with root package name */
    private static String f249580w;

    /* renamed from: x, reason: collision with root package name */
    private static String f249581x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements IAsyncQimeiListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
        public void onQimeiDispatch(Qimei qimei) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                String unused = o.f249581x = qimei.getQimei36();
                QLog.d("libboot_MSF.C.Util", 1, "[initQimei] getQimeiAsync, sQimei = " + o.f249581x + ", qimeiOld = " + qimei.getQimei16());
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MsfCore core = MsfService.getCore();
            int i3 = o.f249571n;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            core.reportRDM(com.tencent.mobileqq.msf.core.c0.g.F0, z16, i3, 0L, null, false, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements IAsyncQimeiListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f249582a;

        c(d dVar) {
            this.f249582a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
        public void onQimeiDispatch(Qimei qimei) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            } else if (qimei == null) {
                this.f249582a.a("", "");
            } else {
                this.f249582a.a(qimei.getQimei16(), qimei.getQimei36());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f249561d = new AtomicInteger(new Random().nextInt(100000) + 60000);
        f249568k = 0L;
        f249569l = "";
        f249570m = "";
        f249571n = 0;
        f249572o = "";
        f249573p = "";
        f249575r = 0;
        f249576s = "";
        f249577t = "";
        f249578u = "";
        f249579v = "";
        f249580w = "";
        f249581x = "";
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String b(ToServiceMsg toServiceMsg) {
        return toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME) != null ? (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME) : "";
    }

    public static int c() {
        return f249574q;
    }

    public static void d(String str) {
        File file = new File(MsfCore.getIMEIPath());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                Properties loadConfig = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
                loadConfig.put("imei", str);
                MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), loadConfig);
                return;
            }
            QLog.d(f249558a, 1, "can not create imei file");
        } catch (Exception e16) {
            QLog.d(f249558a, 1, "save sys imei error", e16);
        }
    }

    public static String e() {
        return f249576s;
    }

    public static String f() {
        return f249577t;
    }

    public static String g() {
        return f249578u;
    }

    public static String h() {
        return f249572o;
    }

    public static String i() {
        return f249580w;
    }

    public static synchronized int j() {
        int incrementAndGet;
        synchronized (o.class) {
            AtomicInteger atomicInteger = f249561d;
            incrementAndGet = atomicInteger.incrementAndGet();
            if (incrementAndGet > 1000000) {
                atomicInteger.set(new Random().nextInt(100000) + 60000);
            }
        }
        return incrementAndGet;
    }

    public static String k() {
        return f249581x;
    }

    public static String l() {
        Random random = new Random(System.currentTimeMillis());
        String str = "---------";
        for (int i3 = 0; i3 < 12; i3++) {
            str = str + String.valueOf(random.nextInt(10));
        }
        return str;
    }

    public static String m() {
        String str;
        File file = new File(MsfCore.getIMEIPath());
        try {
            if (file.exists()) {
                str = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
            } else {
                str = null;
            }
            if (str != null) {
                if (str.length() > 0) {
                    return str;
                }
            }
        } catch (Exception e16) {
            QLog.d(f249558a, 1, "load sys imei error", e16);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 15; i3++) {
            stringBuffer.append(new Random().nextInt(10));
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                Properties loadConfig = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
                loadConfig.put("imei", stringBuffer2);
                MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), loadConfig);
                if (QLog.isColorLevel()) {
                    QLog.d(f249558a, 2, "write imei " + stringBuffer2);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f249558a, 2, "can not create imei file");
            }
        } catch (Exception e17) {
            QLog.d(f249558a, 1, "load imei error", e17);
        }
        return stringBuffer.toString();
    }

    public static String n() {
        return f249579v;
    }

    public static String o() {
        return f249573p;
    }

    public static void p() {
        s();
        r();
        q();
        t();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0159 A[Catch: Exception -> 0x017c, TRY_LEAVE, TryCatch #0 {Exception -> 0x017c, blocks: (B:3:0x0008, B:5:0x001b, B:7:0x0029, B:9:0x0040, B:11:0x0048, B:12:0x006c, B:15:0x0086, B:18:0x008d, B:19:0x0147, B:21:0x0159, B:26:0x0091, B:28:0x009b, B:30:0x00b2, B:32:0x0142, B:33:0x0144, B:36:0x00ba, B:38:0x00c0, B:41:0x00f8, B:43:0x00fe, B:45:0x0107, B:47:0x011e, B:49:0x012b, B:51:0x00d1, B:55:0x00df, B:56:0x00e4, B:58:0x00ea, B:60:0x00f0, B:61:0x002f), top: B:2:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:3:0x0008, B:5:0x001b, B:7:0x0029, B:9:0x0040, B:11:0x0048, B:12:0x006c, B:15:0x0086, B:18:0x008d, B:19:0x0147, B:21:0x0159, B:26:0x0091, B:28:0x009b, B:30:0x00b2, B:32:0x0142, B:33:0x0144, B:36:0x00ba, B:38:0x00c0, B:41:0x00f8, B:43:0x00fe, B:45:0x0107, B:47:0x011e, B:49:0x012b, B:51:0x00d1, B:55:0x00df, B:56:0x00e4, B:58:0x00ea, B:60:0x00f0, B:61:0x002f), top: B:2:0x0008, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void q() {
        String str;
        String str2;
        SharedPreferences sharedPreferences;
        TelephonyManager telephonyManager;
        int i3;
        String imei;
        try {
            f249571n = 0;
            str = null;
            if (new File(MsfCore.getIMEIPath()).exists()) {
                str2 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
                if (str2 == null || str2.length() == 0) {
                    LockMethodProxy.sleep(200L);
                    str2 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
                }
                f249571n = 1;
                if (QLog.isColorLevel()) {
                    QLog.d(f249558a, 2, "read imei from file " + MsfCore.getIMEIPath() + ", imei:" + str2);
                }
            } else {
                str2 = null;
            }
            sharedPreferences = MsfService.getCore().getSharedPreferences(f249558a, 0);
            telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
        } catch (Exception e16) {
            QLog.d(f249558a, 1, "read sys imei error " + e16, e16);
        }
        if (str2 != null && str2.length() != 0) {
            f249571n = 1;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(f249562e, str2);
            edit.commit();
            f249576s = str2;
            if (QLog.isColorLevel()) {
                QLog.d(f249558a, 1, "save imei:" + f249576s + ",with order:" + f249571n);
            }
            q.q().post(new b());
        }
        str2 = sharedPreferences.getString(f249562e, null);
        if (QLog.isColorLevel()) {
            QLog.d(f249558a, 2, "read imei from sharepreference:" + str2);
        }
        if ((str2 == null || str2.length() == 0) && telephonyManager != null) {
            try {
                i3 = Build.VERSION.SDK_INT;
            } catch (SecurityException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249558a, 2, "read sys imei SecurityException=", e17);
                }
            }
            if (i3 > 28) {
                imei = DeviceInfoMonitor.getStringSystem(BaseApplication.getContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            } else {
                if (m.i().e()) {
                    if (i3 < 26) {
                        imei = DeviceInfoMonitor.getDeviceId(telephonyManager);
                    } else {
                        imei = DeviceInfoMonitor.getImei(telephonyManager);
                    }
                }
                if (str == null && str.length() > 0) {
                    f249571n = 3;
                    if (QLog.isColorLevel()) {
                        QLog.d(f249558a, 2, "read sys imei:" + str);
                    }
                    str2 = str;
                } else {
                    String m3 = m();
                    f249571n = 4;
                    if (QLog.isColorLevel()) {
                        QLog.d(f249558a, 2, "load imei:" + m3);
                    }
                    str2 = m3;
                }
            }
            str = imei;
            if (str == null) {
            }
            String m36 = m();
            f249571n = 4;
            if (QLog.isColorLevel()) {
            }
            str2 = m36;
        } else {
            f249571n = 2;
        }
        d(str2);
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putString(f249562e, str2);
        edit2.commit();
        f249576s = str2;
        if (QLog.isColorLevel()) {
        }
        q.q().post(new b());
    }

    private static void r() {
        if (!m.i().f()) {
            QLog.d(f249558a, 1, "can not get imsi by toggle");
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
            String subscriberId = DeviceInfoMonitor.getSubscriberId(telephonyManager);
            if (subscriberId != null) {
                f249577t = subscriberId;
                f249578u = subscriberId;
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null) {
                f249580w = networkOperatorName;
            }
            f249572o = telephonyManager.getNetworkCountryIso();
            f249573p = telephonyManager.getSimCountryIso();
        } catch (Exception e16) {
            QLog.d(f249558a, 1, "get imsi error " + e16, e16);
        }
        String str = f249577t;
        if (str == null) {
            f249577t = "";
        } else if (str.length() > 5) {
            f249577t = f249577t.substring(0, 5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249558a, 2, "[initImsi], imsi:" + f249577t + " networkOperatorName:" + f249580w);
        }
    }

    private static void s() {
        String beaconAppKey = BaseApplication.getContext().getMSFInterfaceAdapter().getBeaconAppKey();
        Qimei qimei = QimeiSDK.getInstance(beaconAppKey).getQimei();
        if (qimei != null) {
            f249581x = qimei.getQimei36();
            QLog.d("libboot_MSF.C.Util", 1, "[initQimei] getQimeiSync, qimei=" + f249581x);
        }
        if (TextUtils.isEmpty(f249581x)) {
            QimeiSDK.getInstance(beaconAppKey).getQimei(new a());
        }
    }

    private static void t() {
        f249579v = "testrevision";
        try {
            try {
                byte[] bArr = new byte[64];
                int read = BaseApplication.getContext().getAssets().open("revision.txt").read(bArr, 0, 64);
                if (read != -1) {
                    f249579v = new String(bArr, 0, read);
                    if (QLog.isColorLevel()) {
                        QLog.d(f249558a, 2, "revision:" + f249579v);
                    }
                }
            } catch (IOException e16) {
                QLog.d(f249558a, 1, "get revision IOException " + e16.getMessage());
            }
        } catch (Exception e17) {
            QLog.d(f249558a, 1, "get revision error " + e17.getMessage());
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0045 -> B:6:0x0046). Please report as a decompilation issue!!! */
    public static void u() {
        String str;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
        try {
            i3 = Build.VERSION.SDK_INT;
        } catch (SecurityException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249558a, 2, e16, new Object[0]);
            }
        }
        if (i3 > 28) {
            str = com.tencent.qphone.base.util.c.a(BaseApplication.getContext());
        } else {
            if (m.i().e()) {
                if (i3 < 26) {
                    str = DeviceInfoMonitor.getDeviceId(telephonyManager);
                } else {
                    str = DeviceInfoMonitor.getImei(telephonyManager);
                }
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            QLog.d(f249558a, 1, "APP clone:get imei from Pandora");
            f249571n = 3;
        } else {
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < 15; i16++) {
                sb5.append(new Random().nextInt(10));
            }
            str = sb5.toString();
            QLog.d(f249558a, 1, "APP clone:get imei from Random");
            f249571n = 4;
        }
        d(str);
        SharedPreferences.Editor edit = MsfService.getCore().getSharedPreferences(f249558a, 0).edit();
        edit.putString(f249562e, str);
        edit.commit();
        QLog.d(f249558a, 1, "APP clone:old imei =" + MsfSdkUtils.getShortUin(f249576s));
        f249576s = str;
        QLog.d(f249558a, 1, "APP clone:new imei =" + MsfSdkUtils.getShortUin(f249576s));
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                sb5.append(String.format("%02x", Integer.valueOf(b16 & 255)));
            }
            return sb5.toString();
        } catch (NoSuchAlgorithmException e16) {
            QLog.e(f249558a, 1, "md5Hash error, ", e16);
            return "";
        }
    }

    public static FromServiceMsg a(ToServiceMsg toServiceMsg) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.setAppId(toServiceMsg.getAppId());
        fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
        fromServiceMsg.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
        fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME));
        fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_NET2MSF, Long.valueOf(System.currentTimeMillis()));
        return fromServiceMsg;
    }

    public static int b() {
        return f249575r;
    }

    public static String b(String str) {
        return "http".equals(str) ? com.tencent.mobileqq.msf.core.x.q.f250389u : "quic".equals(str) ? com.tencent.mobileqq.msf.core.x.q.f250390v : com.tencent.mobileqq.msf.core.x.q.f250388t;
    }

    private static void a(File file, List<SimpleAccount> list) {
        Properties properties = new Properties();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    for (SimpleAccount simpleAccount : list) {
                        properties.put(simpleAccount.getUin(), simpleAccount.toStoreString());
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream2, "");
                        fileOutputStream2.close();
                        QLog.d(f249558a, 1, "write simpleUser succ at " + file.getName());
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        fileOutputStream = fileOutputStream2;
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.d(f249558a, 2, "write simpleUser " + file.getName() + " error " + e, e);
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String d() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && !nextElement2.isLoopbackAddress() && !nextElement2.isAnyLocalAddress() && !nextElement2.isLinkLocalAddress()) {
                            return nextElement.getName() + ":" + nextElement2.getHostAddress();
                        }
                    }
                }
            }
            return "0";
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return "0";
            }
            QLog.w(f249558a, 2, "getDeviceIp error " + e16.toString(), e16);
            return "0";
        }
    }

    private static void a(String str, List<SimpleAccount> list) {
        int i3;
        while (true) {
            for (boolean z16 = true; z16; z16 = false) {
                Iterator<SimpleAccount> it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next().getUin().equals(str)) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            return;
            list.remove(i3);
        }
    }

    public static void a(d dVar) {
        QimeiSDK.getInstance(BaseApplication.getContext().getMSFInterfaceAdapter().getBeaconAppKey()).getQimei(new c(dVar));
    }

    public static void a(String str, String str2, long j3) {
        f249568k = j3;
        f249569l = str;
        f249570m = str2;
    }

    public static String a(Context context) {
        Object obj;
        try {
            try {
                return context.getFilesDir().getParent();
            } catch (Exception unused) {
                if (context instanceof ContextWrapper) {
                    obj = ((ContextWrapper) context).getBaseContext();
                } else {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(context);
                }
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((File) declaredMethod.invoke(obj, new Object[0])).getAbsolutePath();
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static long a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
            } else {
                return crc32.getValue();
            }
        }
    }

    public static long a(File file) {
        if (file == null || !file.exists()) {
            return -100L;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long a16 = a(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return a16;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return -100L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static long a(Context context, String str) {
        File file = new File(a(context) + str);
        if (file.exists()) {
            return a(file);
        }
        return 0L;
    }
}
