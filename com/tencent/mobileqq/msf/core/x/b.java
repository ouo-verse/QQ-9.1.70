package com.tencent.mobileqq.msf.core.x;

import android.os.Build;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;
    public static int A = 0;
    public static int B = 0;
    public static boolean C = false;
    static AtomicBoolean D = null;
    public static final String E = "__loginSdk_iconf_Msf";
    public static final int F = 100;
    public static final int G = 1;
    public static final int H = 16;

    /* renamed from: f, reason: collision with root package name */
    public static final String f250175f = "ConfigService.ClientReq";

    /* renamed from: g, reason: collision with root package name */
    public static final String f250176g = "ResourceConfig.ClientReq";

    /* renamed from: h, reason: collision with root package name */
    static final String f250177h = "MSF.C.ConfigManager";

    /* renamed from: i, reason: collision with root package name */
    public static final String f250178i = "__loginSdk_iconf_UserConf";

    /* renamed from: j, reason: collision with root package name */
    public static final String f250179j = "__loginSdk_iconf_AppConf";

    /* renamed from: k, reason: collision with root package name */
    public static final String f250180k = "__loginSdk_iconf_UserCommCon";

    /* renamed from: l, reason: collision with root package name */
    public static final String f250181l = "__loginSdk_getConfigtime";

    /* renamed from: m, reason: collision with root package name */
    public static final String f250182m = "__loginSdk_lastCheckConfigssotime";

    /* renamed from: n, reason: collision with root package name */
    public static final String f250183n = "_msf_isBootingKey";

    /* renamed from: o, reason: collision with root package name */
    public static final int f250184o = 32;

    /* renamed from: p, reason: collision with root package name */
    public static final String f250185p = "__loginSdk_iConfAppidTimeKey";

    /* renamed from: q, reason: collision with root package name */
    public static final String f250186q = "__loginSdk_iConfSdkLastTimeKey";

    /* renamed from: r, reason: collision with root package name */
    public static final String f250187r = "__loginSdk_iConfGetEspLastTimeKe";

    /* renamed from: s, reason: collision with root package name */
    public static final String f250188s = "__msf_isAutoBootKey";

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f250189t = true;

    /* renamed from: u, reason: collision with root package name */
    static ConcurrentHashMap<String, String> f250190u;

    /* renamed from: v, reason: collision with root package name */
    public static HashSet<String> f250191v;

    /* renamed from: w, reason: collision with root package name */
    public static HashSet<String> f250192w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f250193x;

    /* renamed from: y, reason: collision with root package name */
    public static boolean f250194y;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f250195z;

    /* renamed from: a, reason: collision with root package name */
    private long f250196a;

    /* renamed from: b, reason: collision with root package name */
    private long f250197b;

    /* renamed from: c, reason: collision with root package name */
    MsfCore f250198c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f250199d;

    /* renamed from: e, reason: collision with root package name */
    public CopyOnWriteArrayList<C8100b> f250200e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.x.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8100b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f250201a;

        /* renamed from: b, reason: collision with root package name */
        public a.a.b.a.a.d.a f250202b;

        /* renamed from: c, reason: collision with root package name */
        public String f250203c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f250204d;

        public C8100b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19288);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250190u = new ConcurrentHashMap<>();
        f250191v = new HashSet<>();
        f250192w = new HashSet<>();
        f250193x = true;
        f250194y = true;
        f250195z = true;
        C = true;
        D = new AtomicBoolean();
    }

    public b(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f250196a = 0L;
        this.f250197b = 0L;
        this.f250199d = new CopyOnWriteArrayList<>();
        this.f250200e = new CopyOnWriteArrayList<>();
        this.f250198c = msfCore;
    }

    public static long A() {
        try {
            if (f250190u.containsKey("msf_connFastDetectDelay")) {
                return Long.parseLong(f250190u.get("msf_connFastDetectDelay"));
            }
            return 2000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getConnFastDetectDelay error" + e16);
                return 2000L;
            }
            return 2000L;
        }
    }

    public static int A0() {
        try {
            if (f250190u.containsKey("msf_ResumeCountLimit")) {
                return Integer.parseInt(f250190u.get("msf_ResumeCountLimit"));
            }
            return 3;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "ResumeCountLimit error" + e16);
                return 3;
            }
            return 3;
        }
    }

    public static long B() {
        try {
            if (f250190u.containsKey("msf_connFastDetectTimeout")) {
                return Long.parseLong(f250190u.get("msf_connFastDetectTimeout"));
            }
            return 10000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getConnFastDetectTimeout error" + e16);
                return 10000L;
            }
            return 10000L;
        }
    }

    public static int B0() {
        if (f250190u.containsKey("msf_RetryStartProcTimes")) {
            try {
                return Integer.parseInt(f250190u.get("msf_RetryStartProcTimes").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set getRetryStartProcessTimes error " + e16);
                    return 100;
                }
                return 100;
            }
        }
        return 100;
    }

    public static int C() {
        try {
            if (f250190u.containsKey("msf_continueConnInterval")) {
                return Integer.parseInt(f250190u.get("msf_continueConnInterval"));
            }
            return 1000;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getContinueConnInterval error" + e16);
                return 1000;
            }
            return 1000;
        }
    }

    public static boolean C0() {
        try {
            if (f250190u.containsKey("msf_ssopingavailable")) {
                return Boolean.parseBoolean(f250190u.get("msf_ssopingavailable"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get getSSOPingAvailable error" + e16);
                return true;
            }
            return true;
        }
    }

    public static long D() {
        try {
            if (f250190u.contains("DeepSleepMaxInterval")) {
                return Long.parseLong(f250190u.get("DeepSleepMaxInterval"));
            }
            return 57600000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get DeepSleepMaxInterval error " + e16);
                return 57600000L;
            }
            return 57600000L;
        }
    }

    public static long D0() {
        try {
            if (f250190u.containsKey("msf_pingTimeout")) {
                return Long.parseLong(f250190u.get("msf_pingTimeout")) * 1000;
            }
            return 12000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get getSSOPingTimeout error" + e16);
                return 12000L;
            }
            return 12000L;
        }
    }

    public static boolean E() {
        try {
            if (f250190u.containsKey(e.f250242n)) {
                return Boolean.parseBoolean(f250190u.get(e.f250242n));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getForceQuickSend1S error" + e16);
                return true;
            }
            return true;
        }
    }

    public static int F() {
        try {
            if (f250190u.containsKey(e.f250233e)) {
                return Integer.parseInt(f250190u.get(e.f250233e));
            }
            return 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getHeartBeatRetryCount error" + e16);
                return 1;
            }
            return 1;
        }
    }

    public static int F0() {
        try {
            if (f250190u.containsKey("msf_simpleGetTimeoutNumber")) {
                return Integer.parseInt(f250190u.get("msf_simpleGetTimeoutNumber"));
            }
            return 5;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSimpleGetTimeoutNumber error" + e16);
                return 5;
            }
            return 5;
        }
    }

    public static boolean G() {
        try {
            if (f250190u.containsKey("msf_heartBeatSwtich")) {
                return Boolean.parseBoolean(f250190u.get("msf_heartBeatSwtich"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getHeartBeatSwtich error" + e16);
                return true;
            }
            return true;
        }
    }

    public static int G0() {
        try {
            if (f250190u.containsKey("msf_SingleWiFiSSIDStoreTimes")) {
                return Integer.parseInt(f250190u.get("msf_SingleWiFiSSIDStoreTimes"));
            }
            return 3;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSingleWiFiSSIDStoreTimes error" + e16);
                return 3;
            }
            return 3;
        }
    }

    public static int H() {
        try {
            if (f250190u.containsKey(e.f250236h)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_heartBeatTimeInterval = " + f250190u.get(e.f250236h));
                }
                return Integer.parseInt(f250190u.get(e.f250236h)) * 60 * 1000;
            }
            return 60000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getHeartBeatTimeInterval error" + e16);
                return 60000;
            }
            return 60000;
        }
    }

    public static int H0() {
        try {
            if (f250190u.containsKey("msf_SortIpConnFullWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpConnFullWeight"));
            }
            return 20;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpConnFullWeight error" + e16);
                return 20;
            }
            return 20;
        }
    }

    public static long I() {
        if (!g()) {
            try {
                if (f250190u.containsKey(e.f250234f)) {
                    return Integer.parseInt(f250190u.get(e.f250234f));
                }
                return 30000L;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "getHeartBeatTimeout error" + e16);
                    return 30000L;
                }
                return 30000L;
            }
        }
        return k0();
    }

    public static int I0() {
        try {
            if (f250190u.containsKey("msf_SortIpContinueRspTimeoutWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpContinueRspTimeoutWeight"));
            }
            return 10;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpContinueRspTimeoutWeight error" + e16);
                return 10;
            }
            return 10;
        }
    }

    public static int J() {
        try {
            if (f250190u.containsKey("msf_getHttpReSendMessageConcurrentLimit")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_getHttpReSendMessageConcurrentLimit = " + f250190u.get("msf_getHttpReSendMessageConcurrentLimit"));
                }
                return Integer.parseInt(f250190u.get("msf_getHttpReSendMessageConcurrentLimit"));
            }
            return 5;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getHttpReSendMessageConcurrentLimit error" + e16);
                return 5;
            }
            return 5;
        }
    }

    public static int J0() {
        try {
            if (f250190u.containsKey("msf_SortIpInvalidDataWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpInvalidDataWeight"));
            }
            return 20;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpInvalidDataWeight error" + e16);
                return 20;
            }
            return 20;
        }
    }

    public static int K() {
        try {
            if (f250190u.containsKey("msf_getHttpReSendMessageTimeout")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_getHttpReSendMessageTimeout = " + f250190u.get("msf_getHttpReSendMessageTimeout"));
                }
                return Integer.parseInt(f250190u.get("msf_getHttpReSendMessageTimeout"));
            }
            return 30000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getHttpReSendMessageTimeout error" + e16);
                return 30000;
            }
            return 30000;
        }
    }

    public static int K0() {
        try {
            if (f250190u.containsKey("msf_SortIpNetDetectFailedWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpNetDetectFailedWeight"));
            }
            return 20;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpNetDetectFailedWeight error" + e16);
                return 20;
            }
            return 20;
        }
    }

    public static int L() {
        try {
            if (f250190u.containsKey("msf_getHttpRecvTimeout")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_getHttpRecvTimeout = " + f250190u.get("msf_getHttpRecvTimeout"));
                }
                return Integer.parseInt(f250190u.get("msf_getHttpRecvTimeout"));
            }
            return 30000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getHttpRecvTimeout error" + e16);
                return 30000;
            }
            return 30000;
        }
    }

    public static int L0() {
        try {
            if (f250190u.containsKey("msf_SortIpPingTimeoutWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpPingTimeoutWeight"));
            }
            return 10;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpPingTimeoutWeight error" + e16);
                return 10;
            }
            return 10;
        }
    }

    public static long M() {
        try {
            if (f250190u.containsKey("msf_hwExceptionCheckInterval")) {
                return Long.parseLong(f250190u.get("msf_hwExceptionCheckInterval"));
            }
            return 7200000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "hwExceptionCheckInterval error" + e16);
                return 7200000L;
            }
            return 7200000L;
        }
    }

    public static int M0() {
        try {
            if (f250190u.containsKey("msf_SortIpSocketErrorWeight")) {
                return Integer.parseInt(f250190u.get("msf_SortIpSocketErrorWeight"));
            }
            return 10;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getSortIpSocketErrorWeight error" + e16);
                return 10;
            }
            return 10;
        }
    }

    public static boolean N() {
        if (f250190u.containsKey("monitor_ipHostReportSwitch")) {
            try {
                return Boolean.parseBoolean(f250190u.get("monitor_ipHostReportSwitch"));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "get ipHostReportSwitch error " + e16);
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    public static String[] N0() {
        if (f250190u.containsKey("StandbyMode")) {
            return f250190u.get("StandbyMode").replaceAll("\\|", ",").split(",");
        }
        QLog.d(f250177h, 1, "StandbyMode whitelist not be found.");
        return null;
    }

    public static int O() {
        int i3 = com.tencent.mobileqq.msf.service.j.f250937l;
        try {
            if (f250190u.containsKey("jobscheduler_enable")) {
                i3 = Integer.parseInt(f250190u.get("jobscheduler_enable"));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "MSF_Alive_Log get jobscheduler_enable error" + e16);
            }
            i3 = 0;
        }
        QLog.d(f250177h, 1, "MSF_Alive_Log get config jobscheduler_enable=", Integer.valueOf(i3));
        return i3;
    }

    public static int O0() {
        if (f250190u.containsKey("msf_StandbyTestSeq")) {
            try {
                return Integer.parseInt(f250190u.get("msf_StandbyTestSeq").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set getStandbyTestSeq error " + e16);
                    return 0;
                }
                return 0;
            }
        }
        return 0;
    }

    public static long P() {
        try {
            if (f250190u.containsKey("msf_LogClearInterval")) {
                return Long.parseLong(f250190u.get("msf_LogClearInterval"));
            }
            return 3600000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get getLogClearInterval error" + e16);
                return 3600000L;
            }
            return 3600000L;
        }
    }

    public static long P0() {
        try {
            if (f250190u.containsKey("msf_standbyWaitInterval")) {
                return Long.parseLong(f250190u.get("msf_standbyWaitInterval"));
            }
            return 30000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get standbyWaitInterval error" + e16);
                return 30000L;
            }
            return 30000L;
        }
    }

    public static int Q() {
        try {
            if (f250190u.containsKey("msf_logCompressLevel")) {
                return Integer.parseInt(f250190u.get("msf_logCompressLevel"));
            }
            return 9;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getLogCompressLevel error" + e16);
                return 9;
            }
            return 9;
        }
    }

    public static long Q0() {
        try {
            if (f250190u.containsKey("msf_StoreLogcatTriggerInterval")) {
                return Long.parseLong(f250190u.get("msf_StoreLogcatTriggerInterval"));
            }
            return 10000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getStoreLogcatTriggerInterval error" + e16);
                return 10000L;
            }
            return 10000L;
        }
    }

    public static String R() {
        if (f250190u.containsKey("msf_locallogtime")) {
            return f250190u.get("msf_locallogtime");
        }
        return "3";
    }

    public static long R0() {
        try {
            if (f250190u.containsKey("msf_tcpDumpTime")) {
                return Long.parseLong(f250190u.get("msf_tcpDumpTime"));
            }
            return 600000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getTcpDumpTime error" + e16);
                return 600000L;
            }
            return 600000L;
        }
    }

    public static long S() {
        try {
            if (f250190u.containsKey("msf_LogcatStoreInterval")) {
                return Long.parseLong(f250190u.get("msf_LogcatStoreInterval"));
            }
            return 1800000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getLogcatStoreInterval error" + e16);
                return 1800000L;
            }
            return 1800000L;
        }
    }

    public static int S0() {
        try {
            if (f250190u.containsKey("TcpdumpSSOTime")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "TcpdumpSSOTime = " + f250190u.get("TcpdumpSSOTime"));
                }
                return Integer.parseInt(f250190u.get("TcpdumpSSOTime"));
            }
            return 0;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getTcpdumpSSOTime error" + e16);
                return 0;
            }
            return 0;
        }
    }

    public static String[] T() {
        if (f250190u.containsKey("MultiPkgPara")) {
            String[] split = f250190u.get("MultiPkgPara").replaceAll("\\|", ",").split(",");
            if (split.length == 4) {
                return split;
            }
            return null;
        }
        QLog.d(f250177h, 1, "login merge configuration not be found.");
        return null;
    }

    public static String T0() {
        try {
            if (f250190u.containsKey("TcpdumpSSOVip_new")) {
                return f250190u.get("TcpdumpSSOVip_new");
            }
            return null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getTcpdumpSSOVip error" + e16);
                return null;
            }
            return null;
        }
    }

    public static String U() {
        if (f250190u.containsKey("AndroidMergeDuration")) {
            return f250190u.get("AndroidMergeDuration");
        }
        QLog.d(f250177h, 1, "login merge duration not be found.");
        return "0";
    }

    public static boolean U0() {
        try {
            if (f250190u.containsKey("msf_updatehbtimeSwtich")) {
                return Boolean.parseBoolean(f250190u.get("msf_updateHBTimeSwtich"));
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getUpdateHBTimeSwtich error" + e16);
                return false;
            }
            return false;
        }
    }

    public static String[] V() {
        if (f250190u.containsKey("MultiPkgWL")) {
            return f250190u.get("MultiPkgWL").replaceAll("\\|", ",").split(",");
        }
        QLog.d(f250177h, 1, "login merge whitelist not be found.");
        return null;
    }

    public static int V0() {
        try {
            if (f250190u.containsKey("msf_weaknet_config")) {
                return Integer.parseInt(f250190u.get("msf_weaknet_config"));
            }
            return 0;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "msf_weaknet_config error" + e16);
                return 0;
            }
            return 0;
        }
    }

    public static int W() {
        try {
            if (f250190u.containsKey("msf_MSFPullReportBase")) {
                return Integer.parseInt(f250190u.get("msf_MSFPullReportBase"));
            }
            return 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getMSFPullReportBase error" + e16);
                return 1;
            }
            return 1;
        }
    }

    public static boolean W0() {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return true;
        }
        try {
            if (f250190u.containsKey("msf_weaknetXGSendMsg")) {
                if (Integer.parseInt(f250190u.get("msf_weaknetXGSendMsg")) != 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getWeaknetXGSendMsg error" + e16);
            }
        }
        return false;
    }

    public static int X() {
        try {
            if (f250190u.containsKey("msf_aliveAutoInterval")) {
                return Integer.parseInt(f250190u.get("msf_aliveAutoInterval"));
            }
            return 7200;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getMsfAliveAutoInterval error" + e16);
                return 7200;
            }
            return 7200;
        }
    }

    public static long X0() {
        try {
            if (f250190u.containsKey("msf_webTicketChangeInterval")) {
                return Long.parseLong(f250190u.get("msf_webTicketChangeInterval"));
            }
            return 0L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getWebTicketChangeInterval error" + e16);
                return 0L;
            }
            return 0L;
        }
    }

    public static int Y() {
        try {
            if (f250190u.containsKey("msf_aliveReportMax")) {
                return Integer.parseInt(f250190u.get("msf_aliveReportMax"));
            }
            return 15360;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getMsfAliveReportMax error" + e16);
                return 15360;
            }
            return 15360;
        }
    }

    public static int Z() {
        try {
            if (f250190u.containsKey("msf_aliveSplitLen")) {
                return Integer.parseInt(f250190u.get("msf_aliveSplitLen"));
            }
            return 1024;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getMsfAliveSplitLen error" + e16);
                return 1024;
            }
            return 1024;
        }
    }

    public static boolean Z0() {
        try {
            if (f250190u.containsKey("msf_innerSwitchForAdaptor")) {
                return Boolean.parseBoolean(f250190u.get("msf_innerSwitchForAdaptor"));
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "innerSwitchForAdaptor error" + e16);
                return false;
            }
            return false;
        }
    }

    public static boolean a1() {
        return D.get();
    }

    public static String b0() {
        if (f250190u.containsKey("MsfCrashControlInfo")) {
            return f250190u.get("MsfCrashControlInfo");
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "getMsfCrashControlInfo not found");
            return null;
        }
        return null;
    }

    public static boolean b1() {
        if (f250190u.containsKey("msf_basicTicketChangeLimit")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_basicTicketChangeLimit").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set isBasicTicketChangeLimit error " + e16);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static String c0() {
        if (f250190u.contains("NetFlowMax")) {
            return f250190u.get("NetFlowMax");
        }
        return "10485760";
    }

    public static boolean c1() {
        if (f250190u.containsKey("msf_isDelayChangeWebKey")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_isDelayChangeWebKey").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set msf_isDelayChangeWebKey error " + e16);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static int d0() {
        try {
            if (f250190u.containsKey("msf_netIdleTimeInterval")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_netIdleTimeInterval = " + f250190u.get("msf_netIdleTimeInterval"));
                }
                return Integer.parseInt(f250190u.get("msf_netIdleTimeInterval")) * 60 * 1000;
            }
            return 1680000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getNetIdleTimeInterval error" + e16);
                return 1680000;
            }
            return 1680000;
        }
    }

    public static boolean d1() {
        if (f250190u.containsKey("msf_limitWtChangetoken")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_limitWtChangetoken"));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "get msf_limitWtChangetoken error " + e16);
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    private void e() {
        if (f250190u.containsKey("msf_noReportRdmEvent")) {
            try {
                for (String str : f250190u.get("msf_noReportRdmEvent").split(";")) {
                    if (!str.trim().equals("")) {
                        f250191v.add(str);
                        if (QLog.isColorLevel()) {
                            QLog.d(f250177h, 2, "rdm event " + str + " set no report.");
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "set msf_noReportRdmEvent error " + e16);
                }
            }
        }
        if (f250190u.containsKey("msf_needPrintLogCmd")) {
            try {
                for (String str2 : f250190u.get("msf_needPrintLogCmd").split(";")) {
                    if (!str2.trim().equals("")) {
                        f250192w.add(str2);
                        if (QLog.isColorLevel()) {
                            QLog.d(f250177h, 2, "msg " + str2 + " need print log.");
                        }
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "set msf_noReportRdmEvent error " + e17);
                }
            }
        }
        if (f250190u.containsKey("msf_AnyPacketAsPushHB")) {
            try {
                String str3 = f250190u.get("msf_AnyPacketAsPushHB");
                f250193x = !str3.equals("0");
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "config useAnyPacketAsPushHB " + str3);
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "set msf_noReportRdmEvent error " + e18);
                }
            }
        }
        if (f250190u.containsKey("msf_preDetectionSupport")) {
            try {
                String str4 = f250190u.get("msf_preDetectionSupport");
                f250194y = !str4.equals("0");
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "config msf_preDetectionSupport " + str4);
                }
            } catch (Exception e19) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "set msf_preDetectionSupport error " + e19);
                }
            }
        }
        if (f250190u.containsKey("msf_simpleGetReportSwitch")) {
            try {
                String str5 = f250190u.get("msf_simpleGetReportSwitch");
                f250195z = !str5.equals("0");
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "config msf_simpleGetReportSwitch " + str5);
                }
            } catch (Exception e26) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "set msf_simpleGetReportSwitch error " + e26);
                }
            }
        }
    }

    public static int e0() {
        try {
            if (f250190u.containsKey("msf_netWeakExceptionCount")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_netWeakExceptionCount = " + f250190u.get("msf_netWeakExceptionCount"));
                }
                return Integer.parseInt(f250190u.get("msf_netWeakExceptionCount"));
            }
            return 3;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getNetWeakExceptionCount error" + e16);
                return 3;
            }
            return 3;
        }
    }

    public static boolean e1() {
        if (f250190u.containsKey("msf_quickSendAvailable")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_quickSendAvailable").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set isPermitQuickTimeoutCheck error " + e16);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static int f0() {
        try {
            if (f250190u.containsKey("msf_netWeakTimeInterval")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_netWeakTimeInterval = " + f250190u.get("msf_netWeakTimeInterval"));
                }
                return Integer.parseInt(f250190u.get("msf_netWeakTimeInterval")) * 60 * 1000;
            }
            return 180000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getNetWeakTimeInterval error" + e16);
                return 180000;
            }
            return 180000;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f1() {
        boolean z16;
        if (!ResourceAttributes.HostArchValues.X86.equals(com.tencent.mobileqq.msf.core.c.h(BaseApplication.getContext())) && (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion())) {
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "get quic_enable error" + e16);
                }
            }
            if (f250190u.containsKey("quic_enable")) {
                if (Integer.parseInt(f250190u.get("quic_enable")) != 0) {
                    z16 = true;
                    if (QLog.isColorLevel()) {
                        QLog.i(f250177h, 2, "isQuicEnabled enabled=" + z16 + " " + f250190u.get("quic_enable") + " reload=" + QuicWrapper.reload() + " isLoad=" + QuicWrapper.isLoaded);
                    }
                    if (!z16 && QuicWrapper.reload()) {
                        return true;
                    }
                    return false;
                }
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        if (!z16) {
        }
        return false;
    }

    public static boolean g() {
        try {
            if (f250190u.containsKey(e.f250231c)) {
                return Boolean.parseBoolean(f250190u.get(e.f250231c));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getActivePreDetect error" + e16);
                return true;
            }
            return true;
        }
    }

    public static boolean g0() {
        try {
            if (f250190u.containsKey("msf_newLogClearStrategy")) {
                return Boolean.parseBoolean(f250190u.get("msf_newLogClearStrategy"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getNewLogClearStrategy error" + e16);
                return true;
            }
            return true;
        }
    }

    public static boolean g1() {
        if (f250190u.containsKey("msf_isReportDataCorrupt")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_isReportDataCorrupt").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set msf_isReportDataCorrupt error " + e16);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean h() {
        try {
            if (f250190u.containsKey("msf_getAllowWhileIdleSwtich")) {
                return Boolean.parseBoolean(f250190u.get("msf_getAllowWhileIdleSwtich"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getAllowWhileIdleSwtich error" + e16);
                return true;
            }
            return true;
        }
    }

    public static boolean h0() {
        try {
            if (f250190u.containsKey("msf_newLogClearStrategyTest")) {
                return Boolean.parseBoolean(f250190u.get("msf_newLogClearStrategyTest"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getNewLogClearStrategyTest error" + e16);
                return true;
            }
            return true;
        }
    }

    public static boolean h1() {
        if (f250190u.containsKey("msf_isReqAllFailTest")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_isReqAllFailTest").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set isReqAllFailTest error " + e16);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static int i() {
        try {
            if (f250190u.containsKey("msf_apptimeout")) {
                return Integer.parseInt(f250190u.get("msf_apptimeout"));
            }
            return 2000;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getAppTimeout error" + e16);
                return 2000;
            }
            return 2000;
        }
    }

    public static boolean i0() {
        try {
            if (f250190u.containsKey("msf_newLogClearStrategyTestShutdown")) {
                return Boolean.parseBoolean(f250190u.get("msf_newLogClearStrategyTestShutdown"));
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getNewLogClearStrategyTestShutdown error" + e16);
                return false;
            }
            return false;
        }
    }

    public static boolean i1() {
        if (f250190u.containsKey("msf_isSetReloadKeyUin")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_isSetReloadKeyUin"));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "get msf_isSetReloadKeyUin error " + e16);
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    public static long j() {
        try {
            if (f250190u.containsKey("msf_autoReconnInterval")) {
                return Long.parseLong(f250190u.get("msf_autoReconnInterval"));
            }
            return 0L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getAutoReconnInterval error" + e16);
                return 0L;
            }
            return 0L;
        }
    }

    public static int j0() {
        try {
            if (f250190u.containsKey("msf_pcactiveretrytimes")) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_pcactiveretrytimes = " + f250190u.get("msf_pcactiveretrytimes"));
                }
                return Integer.parseInt(f250190u.get("msf_pcactiveretrytimes"));
            }
            return 10;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "msf_pcactiveretrytimes error" + e16);
                return 10;
            }
            return 10;
        }
    }

    public static boolean j1() {
        if (f250190u.containsKey("msf_StandbyModeAvailable")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_StandbyModeAvailable").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set isStandbyModeAvailable error " + e16);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static long k() {
        try {
            if (f250190u.containsKey("msf_basicTicketChangeInterval")) {
                return Long.parseLong(f250190u.get("msf_basicTicketChangeInterval"));
            }
            return 0L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getBasicTicketChangeInterval error" + e16);
                return 0L;
            }
            return 0L;
        }
    }

    public static long k0() {
        try {
            if (f250190u.containsKey(e.f250232d)) {
                return Integer.parseInt(f250190u.get(e.f250232d));
            }
            return 10000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getPreDetectTimeout error" + e16);
                return 10000L;
            }
            return 10000L;
        }
    }

    public static boolean k1() {
        if (f250190u.containsKey("msf_StandbyTestAvailable")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_StandbyTestAvailable").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set isStandbyTestAvailable error " + e16);
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    public static String l() {
        if (f250190u.containsKey("bigflowwifi_ver2")) {
            return f250190u.get("bigflowwifi_ver2");
        }
        return "20";
    }

    public static long l0() {
        try {
            if (f250190u.containsKey("msf_preDetectionAlarmTimeAlpha")) {
                return Integer.parseInt(f250190u.get("msf_preDetectionAlarmTimeAlpha"));
            }
            return 900000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getPreDetectionAlarmTimeAlpha error" + e16);
                return 900000L;
            }
            return 900000L;
        }
    }

    public static boolean l1() {
        if (f250190u.containsKey("msf_StartNoStickyForMSFService")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_StartNoStickyForMSFService").trim());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " set msf_StartNoStickyForMSFService error " + e16);
                }
            }
        }
        return false;
    }

    public static String m() {
        if (f250190u.containsKey("bigflow2g3g_ver2")) {
            return f250190u.get("bigflow2g3g_ver2");
        }
        return "40";
    }

    public static long m0() {
        try {
            if (f250190u.containsKey("msf_preDetectionAlarmTimeBeta")) {
                return Integer.parseInt(f250190u.get("msf_preDetectionAlarmTimeBeta"));
            }
            return 480000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getPreDetectionAlarmTimeBeta error" + e16);
                return 480000L;
            }
            return 480000L;
        }
    }

    public static boolean m1() {
        if (f250190u.containsKey("msf_useLastOpenAddress")) {
            try {
                return Boolean.parseBoolean(f250190u.get("msf_useLastOpenAddress"));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "get useLastOpenAddress error " + e16);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static int n() {
        try {
            if (f250190u.containsKey("msf_busPacketTimeoutMaxNum")) {
                return Integer.parseInt(f250190u.get("msf_busPacketTimeoutMaxNum"));
            }
            return 10;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getBusPacketTimeoutMaxNum error" + e16);
                return 10;
            }
            return 10;
        }
    }

    public static int n0() {
        try {
            if (f250190u.containsKey(e.f250241m)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "msf_preHeartBeatTimeInterval = " + f250190u.get(e.f250241m));
                }
                return Integer.parseInt(f250190u.get(e.f250241m)) * 1000;
            }
            return 10000;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f250177h, 4, "getPreHeartBeatTimeInterval error" + e16);
                return 10000;
            }
            return 10000;
        }
    }

    public static boolean n1() {
        try {
            if (f250190u.containsKey("msf_isUseWtlogin")) {
                return Boolean.parseBoolean(f250190u.get("msf_isUseWtlogin"));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "msf_isUseWtlogin error" + e16);
            }
        }
        return C;
    }

    public static long o() {
        if (f250190u.containsKey("msf_CallQQIntervTimeOnBoot")) {
            try {
                return Long.parseLong(f250190u.get("msf_CallQQIntervTimeOnBoot").trim());
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, " get CallQQIntervTimeOnBoot error " + e16);
                    return 0L;
                }
                return 0L;
            }
        }
        return 0L;
    }

    public static HashSet<String> o0() {
        String[] split;
        try {
            if (f250190u.containsKey("msf_getPskeyDomains")) {
                String str = f250190u.get("msf_getPskeyDomains");
                if (!TextUtils.isEmpty(str) && (split = str.split("#")) != null && split.length > 0) {
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (!TextUtils.isEmpty(split[i3])) {
                            com.tencent.mobileqq.msf.core.auth.i.f247475i.add(split[i3]);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getPskeyDomains error" + e16);
            }
        }
        return com.tencent.mobileqq.msf.core.auth.i.f247475i;
    }

    public static long p() {
        try {
            if (f250190u.containsKey("msf_ChangeTokenRequestInterval")) {
                return Integer.parseInt(f250190u.get("msf_ChangeTokenRequestInterval"));
            }
            return 1000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getChangeTokenRequestInterval error" + e16);
                return 1000L;
            }
            return 1000L;
        }
    }

    public static long p0() {
        try {
            if (f250190u.containsKey(e.f250239k)) {
                return Integer.parseInt(f250190u.get(e.f250239k));
            }
            return 120000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getQuickHeartBeatReConnInterval error" + e16);
                return 120000L;
            }
            return 120000L;
        }
    }

    public static boolean p1() {
        try {
            if (f250190u.containsKey("msf_loginWithPicSt")) {
                return Boolean.parseBoolean(f250190u.get("msf_loginWithPicSt"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "loginWithPicSt error" + e16);
                return true;
            }
            return true;
        }
    }

    public static long q() {
        try {
            if (f250190u.containsKey("msf_checkChangeTokenInterval")) {
                return Integer.parseInt(f250190u.get("msf_checkChangeTokenInterval"));
            }
            return 1800000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getCheckChangeTokenInterval error" + e16);
                return 1800000L;
            }
            return 1800000L;
        }
    }

    public static boolean q0() {
        try {
            if (f250190u.containsKey(e.f250240l)) {
                return Boolean.parseBoolean(f250190u.get(e.f250240l));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getQuickHeartBeatSwitch error" + e16);
                return true;
            }
            return true;
        }
    }

    public static boolean q1() {
        try {
            if (f250190u.containsKey("msf_reportMsfAliveFull")) {
                return Boolean.parseBoolean(f250190u.get("msf_reportMsfAliveFull"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "reportMsfAliveFull error" + e16);
                return true;
            }
            return true;
        }
    }

    public static long r0() {
        try {
            if (f250190u.containsKey(e.f250238j)) {
                return Integer.parseInt(f250190u.get(e.f250238j));
            }
            return 10000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getHeartBeatTimeout error" + e16);
                return 10000L;
            }
            return 10000L;
        }
    }

    public static boolean r1() {
        try {
            if (f250190u.containsKey("msf_reportPushDetail")) {
                return Boolean.parseBoolean(f250190u.get("msf_reportPushDetail"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "reportPushDetail error" + e16);
                return true;
            }
            return true;
        }
    }

    public static long s() {
        try {
            if (f250190u.containsKey("msf_checkServerTimeCompareInterval")) {
                return Long.parseLong(f250190u.get("msf_checkServerTimeCompareInterval"));
            }
            return 7200000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getCheckServerTimeCompareInterval error" + e16);
                return 7200000L;
            }
            return 7200000L;
        }
    }

    public static String[] s0() {
        if (f250190u.containsKey("getQuickSendBlackList")) {
            return f250190u.get("getQuickSendBlackList").replaceAll("\\|", "#").split("#");
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "getQuickSendBlackList not be found.");
            return null;
        }
        return null;
    }

    public static int s1() {
        try {
            if (f250190u.containsKey("msf_retryHeartbeatTestCount")) {
                return Integer.parseInt(f250190u.get("msf_retryHeartbeatTestCount"));
            }
            return 5;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "retryHeartbeatTestCount error" + e16);
                return 5;
            }
            return 5;
        }
    }

    public static long t() {
        try {
            if (f250190u.containsKey("msf_busCheckServerTimeInterval")) {
                return Long.parseLong(f250190u.get("msf_busCheckServerTimeInterval"));
            }
            return 5000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getBusPacketTimeoutMaxNum error" + e16);
                return 5000L;
            }
            return 5000L;
        }
    }

    public static int t0() {
        try {
            if (f250190u.containsKey(e.f250244p)) {
                return Integer.parseInt(f250190u.get(e.f250244p));
            }
            return 15000;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getQuickSendFastInterval error" + e16);
                return 15000;
            }
            return 15000;
        }
    }

    public static String u() {
        if (f250190u.containsKey("msf_checkSsoIntervtime")) {
            return f250190u.get("msf_checkSsoIntervtime");
        }
        return "300000";
    }

    public static int u0() {
        try {
            if (f250190u.containsKey(e.f250243o)) {
                return Integer.parseInt(f250190u.get(e.f250243o));
            }
            return 4;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getQuickSendFastTimes error" + e16);
                return 4;
            }
            return 4;
        }
    }

    public static long v() {
        try {
            if (f250190u.containsKey("msf_checkUpdateServerTimeExtraInterval")) {
                return Long.parseLong(f250190u.get("msf_checkUpdateServerTimeExtraInterval"));
            }
            return 7200000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getUpdateServerTimePacketTimeoutExtraInterval error" + e16);
                return 7200000L;
            }
            return 7200000L;
        }
    }

    public static int v0() {
        try {
            if (f250190u.containsKey("msf_RandomPushReportBase")) {
                return Integer.parseInt(f250190u.get("msf_RandomPushReportBase"));
            }
            return 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getRandomPushReportBase error" + e16);
                return 1;
            }
            return 1;
        }
    }

    public static long v1() {
        try {
            if (f250190u.containsKey("msf_startHeartBeatProxyInterval")) {
                return Long.parseLong(f250190u.get("msf_startHeartBeatProxyInterval"));
            }
            return 60000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "startHeartBeatProxyInterval error" + e16);
                return 60000L;
            }
            return 60000L;
        }
    }

    public static long w() {
        try {
            if (f250190u.containsKey("msf_checkUpdateServerTimeInterval")) {
                return Long.parseLong(f250190u.get("msf_checkUpdateServerTimeInterval"));
            }
            return 72000000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getUpdateServerTimePacketTimeoutMaxNum error" + e16);
                return 72000000L;
            }
            return 72000000L;
        }
    }

    public static boolean w0() {
        try {
            if (Build.VERSION.SDK_INT >= 28 && f250190u.containsKey("msf_reconnWhenMobileToWifi")) {
                if (Boolean.parseBoolean(f250190u.get("msf_reconnWhenMobileToWifi"))) {
                    return true;
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getReconnWhenMobileToWiFi error" + e16);
            }
        }
        return false;
    }

    public static int w1() {
        try {
            if (f250190u.containsKey("msf_timeoutPkgToResetMode")) {
                return Integer.parseInt(f250190u.get("msf_timeoutPkgToResetMode"));
            }
            return 100;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "timeoutPkgToResetMode error" + e16);
                return 100;
            }
            return 100;
        }
    }

    public static long x0() {
        try {
            if (f250190u.containsKey("msf_ReportWiFiSSIDInterval")) {
                return Long.parseLong(f250190u.get("msf_ReportWiFiSSIDInterval"));
            }
            return 72000000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "getReportWiFiSSIDInterval error" + e16);
                return 72000000L;
            }
            return 72000000L;
        }
    }

    public static long y() {
        try {
            if (f250190u.containsKey("msf_compressLogDelay")) {
                return Long.parseLong(f250190u.get("msf_compressLogDelay"));
            }
            return 60000L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get getCompressLogDelay error" + e16);
                return 60000L;
            }
            return 60000L;
        }
    }

    public static CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> y0() {
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (f250190u.containsKey("ydconn")) {
            try {
                for (String str : f250190u.get("ydconn").replaceAll("\\|", ",").split(",")) {
                    String[] split = str.split(":");
                    com.tencent.mobileqq.msf.core.d dVar = new com.tencent.mobileqq.msf.core.d();
                    dVar.b(split[0]);
                    dVar.a(Integer.parseInt(split[1]));
                    copyOnWriteArrayList.add(dVar);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (f250190u.containsKey("ltconn")) {
            try {
                for (String str2 : f250190u.get("ltconn").replaceAll("\\|", ",").split(",")) {
                    String[] split2 = str2.split(":");
                    com.tencent.mobileqq.msf.core.d dVar2 = new com.tencent.mobileqq.msf.core.d();
                    dVar2.b(split2[0]);
                    dVar2.a(Integer.parseInt(split2[1]));
                    copyOnWriteArrayList.add(dVar2);
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (f250190u.containsKey("dxconn")) {
            try {
                for (String str3 : f250190u.get("dxconn").replaceAll("\\|", ",").split(",")) {
                    String[] split3 = str3.split(":");
                    com.tencent.mobileqq.msf.core.d dVar3 = new com.tencent.mobileqq.msf.core.d();
                    dVar3.b(split3[0]);
                    dVar3.a(Integer.parseInt(split3[1]));
                    copyOnWriteArrayList.add(dVar3);
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    public static boolean z() {
        try {
            if (f250190u.containsKey("msf_connFastDetect")) {
                return Boolean.parseBoolean(f250190u.get("msf_connFastDetect"));
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "get getConnFastDetectAvailable error" + e16);
                return true;
            }
            return true;
        }
    }

    public static CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> z0() {
        String str;
        String f16 = com.tencent.mobileqq.msf.core.o.f();
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (f16 == null) {
            return null;
        }
        if (!f16.startsWith("460") && !f16.startsWith("461")) {
            return null;
        }
        if (!f16.startsWith("46000") && !f16.startsWith("46002")) {
            if (f16.startsWith("46001")) {
                str = "ltconn";
            } else {
                if (!f16.startsWith("46003")) {
                    return null;
                }
                str = "dxconn";
            }
        } else {
            str = "ydconn";
        }
        if (f250190u.containsKey(str)) {
            try {
                for (String str2 : f250190u.get(str).replaceAll("\\|", ",").split(",")) {
                    String[] split = str2.split(":");
                    com.tencent.mobileqq.msf.core.d dVar = new com.tencent.mobileqq.msf.core.d();
                    dVar.b(split[0]);
                    dVar.a(Integer.parseInt(split[1]));
                    copyOnWriteArrayList.add(dVar);
                }
                return copyOnWriteArrayList;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            QLog.d(f250177h, 1, "getReqAllFailDetectXGSSOList not be found.");
        }
        return null;
    }

    public ConcurrentHashMap<String, String> E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return f250190u;
    }

    public void Y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            o1();
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerConfigListener ");
        sb5.append(aVar == null ? "null" : Integer.toHexString(aVar.hashCode()));
        QLog.d(f250177h, 1, sb5.toString());
        if (aVar != null) {
            this.f250199d.add(aVar);
        }
    }

    public String a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return a(MsfStore.getNativeConfigStore().getConfig(E));
    }

    public boolean b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterConfigListener ");
        sb5.append(aVar == null ? "null" : Integer.toHexString(aVar.hashCode()));
        QLog.d(f250177h, 1, sb5.toString());
        if (aVar == null) {
            return false;
        }
        return this.f250199d.remove(aVar);
    }

    public String c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg);
        }
        int intValue = ((Integer) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_TYPE)).intValue();
        if (intValue == 0) {
            return x();
        }
        if (intValue == 1) {
            return d(toServiceMsg.getUin());
        }
        if (intValue != 2) {
            return null;
        }
        return f();
    }

    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return a(MsfStore.getNativeConfigStore().getConfig(str + "_" + f250178i));
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return a(MsfStore.getNativeConfigStore().getConfig(f250179j));
    }

    protected void o1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        String config = MsfStore.getNativeConfigStore().getConfig(f250182m);
        String str = "0";
        if (config == null || config.length() == 0) {
            config = "0";
        }
        this.f250197b = Long.parseLong(config);
        String config2 = MsfStore.getNativeConfigStore().getConfig(f250181l);
        if (config2 != null && config2.length() != 0) {
            str = config2;
        }
        this.f250196a = Long.parseLong(str);
        String config3 = MsfStore.getNativeConfigStore().getConfig(f250183n);
        if (config3 == null || config3.length() == 0) {
            config3 = "false";
        }
        a(Boolean.parseBoolean(config3));
        String a06 = a0();
        if (a06 != null && a06.length() > 0) {
            a("msfConfig", a06, "");
        }
        String x16 = x();
        if (x16 != null && x16.length() > 0) {
            a(SkinConstants.TintConstant.KEY_COMMON_CONFIG, x16, "");
        }
        String f16 = f();
        if (f16 != null && f16.length() > 0) {
            a("appidConfig", f16, "");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f250177h, 4, f16);
        }
        Iterator<String> it = this.f250198c.getAccountCenter().h().iterator();
        while (it.hasNext()) {
            String next = it.next();
            String d16 = d(next);
            if (d16 != null && d16.length() > 0) {
                a("userConfig", d16, next + "_");
            }
        }
        e();
    }

    public byte[] r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
        uniPacket.setFuncName("ClientReq");
        uniPacket.put("iCmdType", 32);
        com.tencent.msf.service.protocol.kqqconfig.c cVar = new com.tencent.msf.service.protocol.kqqconfig.c();
        String config = MsfStore.getNativeConfigStore().getConfig(f250185p);
        if (config == null || config.length() == 0) {
            config = "1";
        }
        int parseInt = Integer.parseInt(config);
        A = parseInt;
        if (parseInt == 0) {
            A = 1;
        }
        String config2 = MsfStore.getNativeConfigStore().getConfig(f250186q);
        String str = "0";
        if (config2 == null || config2.length() == 0) {
            config2 = "0";
        }
        B = Integer.parseInt(config2);
        String config3 = MsfStore.getNativeConfigStore().getConfig(f250187r);
        if (config3 != null && config3.length() != 0) {
            str = config3;
        }
        int parseInt2 = Integer.parseInt(str);
        cVar.f336485e = A;
        cVar.f336482b = B;
        cVar.f336484d = parseInt2;
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "load confReq iGetAppidTime" + cVar.f336485e + " iGetSdkLastTime:" + cVar.f336482b + " iGetEspLastTime:" + cVar.f336484d);
        }
        ArrayList<SimpleAccount> i3 = this.f250198c.getAccountCenter().i();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<SimpleAccount> it = i3.iterator();
        while (it.hasNext()) {
            SimpleAccount next = it.next();
            arrayList.add(next.getUin());
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "checkConfig uin=" + next.getUin());
            }
        }
        cVar.f336483c = arrayList;
        uniPacket.put("SDKConfReq", cVar);
        return uniPacket.encode();
    }

    public void t1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        MsfStore.getNativeConfigStore().n_setConfig(f250181l, String.valueOf(this.f250196a));
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "save next get config time is " + this.f250198c.timeFormatter.format(Long.valueOf(this.f250196a)));
        }
    }

    public boolean u1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f250197b == 0) {
            return true;
        }
        long j3 = this.f250196a;
        if (j3 == 0) {
            if (currentTimeMillis - j3 >= 43200000) {
                return true;
            }
            return false;
        }
        if (currentTimeMillis >= j3) {
            return true;
        }
        return false;
    }

    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return a(MsfStore.getNativeConfigStore().getConfig(f250180k));
    }

    public static boolean d() {
        try {
            if (f250190u.containsKey("msf_applySocketAdaptorFeature")) {
                return Boolean.parseBoolean(f250190u.get("msf_applySocketAdaptorFeature"));
            }
            return false;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(f250177h, 2, "applySocketAdaptorFeature error" + e16);
            return false;
        }
    }

    public static synchronized void a(boolean z16) {
        synchronized (b.class) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "msfCore setAutoStaring " + z16);
            }
            D.set(z16);
            if (MsfStore.getNativeConfigStore() != null) {
                MsfStore.getNativeConfigStore().setConfig(f250183n, String.valueOf(z16));
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "storeAutoStaring " + z16);
            }
        }
    }

    public static boolean c() {
        try {
            if (f250190u.containsKey("msf_applyHeartbeatProxyFeature")) {
                return Boolean.parseBoolean(f250190u.get("msf_applyHeartbeatProxyFeature"));
            }
            return false;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(f250177h, 2, "applyHeartbeatProxyFeature error" + e16);
            return false;
        }
    }

    public int b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg.getWupBuffer() == null || toServiceMsg.getWupBuffer().length <= 0) {
            a.a.b.a.a.e.f fVar = new a.a.b.a.a.e.f();
            fVar.f25234f = (byte) 0;
            fVar.f25229a = new a.a.b.a.a.e.b();
            fVar.f25232d = "";
            fVar.f25233e = "";
            fVar.f25235g = new byte[0];
            fVar.f25231c = new ArrayList<>();
            fVar.f25230b = new ArrayList<>();
            a.a.b.a.a.e.d dVar = new a.a.b.a.a.e.d();
            dVar.f25217e = (byte) 0;
            dVar.f25216d = (short) 0;
            dVar.f25215c = (short) 0;
            dVar.f25213a = "";
            dVar.f25214b = 0L;
            ArrayList<a.a.b.a.a.e.d> arrayList = new ArrayList<>();
            arrayList.add(dVar);
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.setRequestId(0);
            uniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
            uniPacket.setFuncName("ClientReq");
            uniPacket.put("iCmdType", 64);
            uniPacket.put("ReqUserInfo", fVar);
            a.a.b.a.a.e.e eVar = new a.a.b.a.a.e.e();
            eVar.f25223a = arrayList;
            uniPacket.put("GetResourceReqV2", eVar);
            toServiceMsg.putWupBuffer(uniPacket.encode());
        }
        this.f250198c.sendSsoMsg(toServiceMsg);
        return toServiceMsg.getRequestSsoSeq();
    }

    public static Object c(String str) {
        return f250190u.get(str);
    }

    public void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fromServiceMsg, (Object) toServiceMsg);
            return;
        }
        QLog.i(f250177h, 1, "handleConfig before quic_enable=" + c("quic_enable"));
        if (!fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "wait " + toServiceMsg + " timeout.");
                return;
            }
            return;
        }
        try {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("UTF-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            int intValue = ((Integer) uniPacket.getByClass("iCmdType", 0)).intValue();
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle check ConfigResp ." + intValue);
            }
            if (intValue != 16 && intValue == 32) {
                a((com.tencent.msf.service.protocol.kqqconfig.d) uniPacket.getByClass("SDKConfRes", new com.tencent.msf.service.protocol.kqqconfig.d()), fromServiceMsg, toServiceMsg);
            }
            QLog.i(f250177h, 1, "handleConfig after quic_enable=" + c("quic_enable"));
        } catch (Exception e16) {
            QLog.e(f250177h, 1, "handleConfig, decode fail", e16);
        }
    }

    public void a(com.tencent.msf.service.protocol.kqqconfig.d dVar, FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, dVar, fromServiceMsg, toServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "recvServerConfig: " + dVar);
        }
        if (dVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "configInfo.iUpdateType is null , return");
                return;
            }
            return;
        }
        if (dVar.f336486a != 1) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "configInfo.iUpdateType is " + dVar.f336486a + " , return");
                return;
            }
            return;
        }
        String str3 = dVar.f336489d;
        if (str3 != null && str3.length() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle sConf " + dVar.f336489d);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle sEspConf " + dVar.f336491f);
            }
            String packageName = BaseApplication.getContext().getPackageName();
            int indexOf = str3.indexOf("<MSF>");
            int indexOf2 = str3.indexOf("</MSF>");
            String str4 = "";
            if (indexOf != -1 && indexOf2 != -1 && indexOf < indexOf2) {
                str2 = str3.substring(indexOf + 5, indexOf2);
                str = str3.substring(0, indexOf) + str3.substring(indexOf2 + 6, str3.length());
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "handle config MSF null, skip");
                }
                str = str3;
                str2 = "";
            }
            int indexOf3 = str.indexOf("<quic_enable>");
            int indexOf4 = str.indexOf("</quic_enable>");
            if (indexOf3 > 0 && indexOf4 > 0 && indexOf3 <= indexOf4) {
                QLog.d(f250177h, 1, "parse config str_quic_enable: " + str.substring(indexOf3 + 13, indexOf4));
            } else {
                QLog.d(f250177h, 1, "parse quic_enable config error");
            }
            if (str2 != null && str2.length() != 0) {
                if (a("msfConfig", str2, "")) {
                    String b16 = b(str2);
                    if (QLog.isColorLevel()) {
                        QLog.d(f250177h, 2, "recv config str_msf: " + b16);
                    }
                    MsfStore.getNativeConfigStore().n_setConfig(E, b16);
                } else if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "parse msfConf error , skip store.");
                }
            }
            int i3 = dVar.f336487b;
            if (i3 != 0 && B != i3) {
                B = i3;
                if (QLog.isDevelopLevel()) {
                    QLog.d(f250177h, 4, "save confReq iGetSdkNewTime" + dVar.f336487b);
                }
                MsfStore.getNativeConfigStore().n_setConfig(f250186q, String.valueOf(dVar.f336487b));
                int indexOf5 = str.indexOf("<CommConf>");
                int indexOf6 = str.indexOf("</CommConf>");
                if (indexOf5 != -1 && indexOf6 != -1 && indexOf5 < indexOf6) {
                    String substring = str.substring(indexOf5 + 10, indexOf6);
                    if (substring != null && substring.length() != 0) {
                        if (a("commConfig", substring, "")) {
                            MsfStore.getNativeConfigStore().n_setConfig(f250180k, b(substring));
                        } else if (QLog.isColorLevel()) {
                            QLog.d(f250177h, 2, "parse commonConf error , skip store.");
                        }
                    } else {
                        MsfStore.getNativeConfigStore().n_setConfig(f250180k, "");
                    }
                    try {
                        MsfSdkUtils.writeServerConfig(packageName, 0, substring, com.tencent.mobileqq.msf.core.e0.i.i());
                    } catch (IOException e16) {
                        QLog.e(f250177h, 1, "write config error " + e16);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250177h, 2, "handle config CommConf error");
                        return;
                    }
                    return;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle config,  iGetSdkLastTime is obsolete, skip...");
            }
            int i16 = dVar.f336492g;
            if (i16 != 0 && A != i16) {
                A = i16;
                if (QLog.isDevelopLevel()) {
                    QLog.d(f250177h, 4, "save confReq getiConfAppidTimeKey" + dVar.f336492g);
                }
                MsfStore.getNativeConfigStore().n_setConfig(f250185p, String.valueOf(dVar.f336492g));
                int indexOf7 = str.indexOf("<APPIDConf>");
                int indexOf8 = str.indexOf("</APPIDConf>");
                if (indexOf7 != -1 && indexOf8 != -1 && indexOf7 < indexOf8) {
                    String substring2 = str.substring(indexOf7 + 11, indexOf8);
                    if (substring2 != null && substring2.length() != 0) {
                        if (a("appidConf", substring2, "")) {
                            MsfStore.getNativeConfigStore().n_setConfig(f250179j, b(substring2));
                        } else if (QLog.isColorLevel()) {
                            QLog.d(f250177h, 2, "parse appidConf error , skip store.");
                        }
                    } else {
                        MsfStore.getNativeConfigStore().n_setConfig(f250179j, "");
                    }
                    try {
                        MsfSdkUtils.writeServerConfig(packageName, 2, substring2, com.tencent.mobileqq.msf.core.e0.i.i());
                    } catch (IOException e17) {
                        QLog.e(f250177h, 1, "write config error " + e17);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250177h, 2, "handle config APPIDConf error");
                        return;
                    }
                    return;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle config, iGetAppidTime is obsolete, skip...");
            }
            String str5 = dVar.f336491f;
            if (str5 != null && str5.length() != 0) {
                int indexOf9 = str5.indexOf("<UserConf>");
                int indexOf10 = str5.indexOf("</UserConf>");
                if (indexOf9 != -1 && indexOf10 != -1 && indexOf9 < indexOf10) {
                    str4 = str5.substring(indexOf9 + 10, indexOf10);
                } else if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "handle config UserConf skip");
                }
                if (str4 != null && str4.length() != 0) {
                    if (a("userConf", str4, fromServiceMsg.getUin() + "_")) {
                        String b17 = b(str4);
                        MsfStore.getNativeConfigStore().n_setConfig(fromServiceMsg.getUin() + "_" + f250178i, b17);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(f250177h, 2, "parse userConfig error , skip store.");
                    }
                }
                try {
                    MsfSdkUtils.writeServerConfig(packageName, 1, str4, com.tencent.mobileqq.msf.core.e0.i.i());
                } catch (IOException e18) {
                    QLog.e(f250177h, 1, "write config error " + e18);
                }
                MsfStore.getNativeConfigStore().n_setConfig(f250187r, String.valueOf(dVar.f336490e));
                if (QLog.isDevelopLevel()) {
                    QLog.d(f250177h, 4, "save confReq getiConfGetEspLastTimeKey" + dVar.f336490e);
                }
                e();
                Iterator<a> it = this.f250199d.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, "handle server config ok");
                }
                CodecWarpper.nativeGetFileStoreKey();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250177h, 2, "handle config, res.sEspConf null, return");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250177h, 2, "handle config, res.sConf null, return");
        }
    }

    static String b(String str) {
        try {
            return HexUtil.bytes2HexStr(str.getBytes("UTF-8"));
        } catch (Exception e16) {
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            QLog.d(f250177h, 4, "Str2HexStr error " + e16, e16);
            return null;
        }
    }

    public static int b() {
        try {
            if (f250190u.containsKey("msf_ExptionCountToResetMode")) {
                return Integer.parseInt(f250190u.get("msf_ExptionCountToResetMode"));
            }
            return 15;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 15;
            }
            QLog.d(f250177h, 2, "ExptionCountToResetMode error" + e16);
            return 15;
        }
    }

    public static boolean e(String str) {
        if (!f250190u.containsKey(str + "_isAutoBoot")) {
            return true;
        }
        try {
            return Boolean.parseBoolean(f250190u.get(str + "_isAutoBoot").trim());
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(f250177h, 2, str + " set isAutoBoot error " + e16);
            return false;
        }
    }

    private boolean a(String str, String str2, String str3) {
        try {
            p.a(new ByteArrayInputStream(("<" + str + ">" + str2 + "</" + str + ">").getBytes("UTF-8")), f250190u, str3);
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(f250177h, 2, "parse " + str + "Config error " + e16, e16);
            return false;
        }
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3));
            return;
        }
        if (u1()) {
            this.f250197b = j3;
            MsfStore.getNativeConfigStore().n_setConfig(f250182m, String.valueOf(this.f250197b));
            this.f250196a = this.f250197b + 3600000;
            t1();
            try {
                a(str, 60000);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250177h, 2, e16.toString(), e16);
                }
            }
        }
    }

    static String a(String str) {
        try {
            return new String(HexUtil.hexStr2Bytes(str), "UTF-8");
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(f250177h, 2, "HexStr2Str error " + e16, e16);
            return null;
        }
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
            return;
        }
        byte[] r16 = r();
        ToServiceMsg toServiceMsg = new ToServiceMsg("", str, "ConfigService.ClientReq");
        toServiceMsg.setMsfCommand(MsfCommand._msf_getConfig);
        toServiceMsg.setRequestSsoSeq(this.f250198c.getNextSeq());
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.putWupBuffer(r16);
        toServiceMsg.setTimeout(i3);
        this.f250198c.sendSsoMsg(toServiceMsg);
        QLog.d(f250177h, 1, "send checkConfig uin=" + MsfSdkUtils.getShortUin(str) + " appid=" + BaseApplication.getContext().getAppId());
    }

    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg)).intValue();
        }
        byte byteValue = ((Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REPORT_TYPE)).byteValue();
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REPORT_CONTENT);
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setRequestId(this.f250198c.getNextSeq());
        uniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
        uniPacket.setFuncName("ClientReportReq");
        com.tencent.msf.service.protocol.kqqconfig.a aVar = new com.tencent.msf.service.protocol.kqqconfig.a();
        aVar.f336471a = byteValue;
        try {
            aVar.f336473c = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        uniPacket.put("ClientReportReq", aVar);
        toServiceMsg.putWupBuffer(uniPacket.encode());
        return this.f250198c.sendSsoMsg(toServiceMsg);
    }

    public int a(HashMap<String, ArrayList<byte[]>> hashMap, String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) hashMap, (Object) str)).intValue();
        }
        byte[] a16 = a(str, hashMap);
        ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_REPORTSTAT);
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setRequestSsoSeq(this.f250198c.getNextSeq());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.putWupBuffer(a16);
        return this.f250198c.sendSsoMsg(toServiceMsg);
    }

    byte[] a(String str, HashMap<String, ArrayList<byte[]>> hashMap) {
        StrupBuff strupBuff = new StrupBuff();
        strupBuff.prefix = str;
        strupBuff.logstring = new HashMap(hashMap);
        strupBuff.encoding = (byte) 2;
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setRequestId(this.f250198c.getNextSeq());
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName("QQService.CliLogSvc.MainServantObj");
        uniPacket.setFuncName("UploadReq");
        uniPacket.put("Data", strupBuff);
        return uniPacket.encode();
    }

    public void a(FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) fromServiceMsg);
            return;
        }
        a.a.b.a.a.d.b bVar = new a.a.b.a.a.d.b();
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        byte[] bArr = new byte[wupBuffer.length - 4];
        System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
        bVar.readFrom(new JceInputStream(bArr));
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<a.a.b.a.a.d.a> it = bVar.f25193a.iterator();
        while (it.hasNext()) {
            a.a.b.a.a.d.a next = it.next();
            if (next != null && (i3 = next.f25188b) > 0 && i3 <= 1800) {
                String str = new String(next.f25187a);
                String substring = str.substring(0, str.indexOf(".") + 1);
                Iterator<C8100b> it5 = this.f250200e.iterator();
                while (it5.hasNext()) {
                    C8100b next2 = it5.next();
                    if (str.equals(next2.f250203c)) {
                        this.f250200e.remove(next2);
                    } else if (str.endsWith(".*") || next2.f250203c.endsWith(".*")) {
                        if (next2.f250203c.startsWith(substring)) {
                            this.f250200e.remove(next2);
                        }
                    }
                }
                C8100b c8100b = new C8100b();
                c8100b.f250203c = str;
                c8100b.f250201a = currentTimeMillis;
                c8100b.f250202b = next;
                this.f250200e.add(c8100b);
                QLog.d(f250177h, 1, "recved OverloadPushNotify cmd: " + str + " delaySecs = " + next.f25188b + " timeReced: " + currentTimeMillis + " tips: " + ((int) next.f25191e));
            }
        }
    }

    public static int a() {
        try {
            if (f250190u.containsKey("msf_ExptionCountToCloseHeartbeat")) {
                return Integer.parseInt(f250190u.get("msf_ExptionCountToCloseHeartbeat"));
            }
            return 50;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 50;
            }
            QLog.d(f250177h, 2, "ExptionCountToCloseHeartbeat error" + e16);
            return 50;
        }
    }
}
