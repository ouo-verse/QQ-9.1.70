package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.pb.StatSvcSimpleGet;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;
    private static final BroadcastReceiver A;
    static boolean B = false;
    public static final String C = "com.tencent.mobileqq.msf.WatchdogForInfoLogin";

    /* renamed from: k, reason: collision with root package name */
    public static final String f249682k = "StatSvc.register";

    /* renamed from: l, reason: collision with root package name */
    private static String f249683l = "SvcReqRegister";

    /* renamed from: m, reason: collision with root package name */
    private static String f249684m = "PushService";

    /* renamed from: n, reason: collision with root package name */
    private static byte f249685n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static final String f249686o = "MSF.C.PushManager:PushCoder";

    /* renamed from: p, reason: collision with root package name */
    private static boolean f249687p = false;

    /* renamed from: q, reason: collision with root package name */
    private static int f249688q = -1;

    /* renamed from: r, reason: collision with root package name */
    public static long f249689r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static long f249690s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f249691t = false;

    /* renamed from: u, reason: collision with root package name */
    private static String f249692u = "PullUnreadMsgCount";

    /* renamed from: v, reason: collision with root package name */
    private static String f249693v = "MessageSvc";

    /* renamed from: w, reason: collision with root package name */
    private static String f249694w = "SvcReqGet";

    /* renamed from: x, reason: collision with root package name */
    private static String f249695x = "PushService";

    /* renamed from: y, reason: collision with root package name */
    public static String f249696y = "StatSvc.get";

    /* renamed from: z, reason: collision with root package name */
    public static String f249697z = "StatSvc.SimpleGet";

    /* renamed from: a, reason: collision with root package name */
    h f249698a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f249699b;

    /* renamed from: c, reason: collision with root package name */
    long f249700c;

    /* renamed from: d, reason: collision with root package name */
    private final String f249701d;

    /* renamed from: e, reason: collision with root package name */
    int f249702e;

    /* renamed from: f, reason: collision with root package name */
    long f249703f;

    /* renamed from: g, reason: collision with root package name */
    int f249704g;

    /* renamed from: h, reason: collision with root package name */
    private int f249705h;

    /* renamed from: i, reason: collision with root package name */
    private long f249706i;

    /* renamed from: j, reason: collision with root package name */
    private int f249707j;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                QLog.d(g.f249686o, 1, "onReceive action null");
            } else if (action.equals(g.C)) {
                MsfService.getCore().pushManager.f249743j.a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            A = new a();
            B = false;
        }
    }

    public g(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
            return;
        }
        this.f249699b = false;
        this.f249700c = 0L;
        this.f249701d = "unrtime";
        this.f249702e = 0;
        this.f249703f = 0L;
        this.f249704g = 0;
        this.f249705h = 0;
        this.f249706i = 0L;
        this.f249707j = 0;
        this.f249698a = hVar;
    }

    boolean a(RegPushReason regPushReason) {
        return regPushReason == RegPushReason.appRegister || regPushReason == RegPushReason.fillRegProxy || regPushReason == RegPushReason.createDefaultRegInfo || regPushReason == RegPushReason.setOnlineStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(1:3)|4|5|6|7|(2:213|(3:215|216|(1:218)(43:219|220|221|222|223|224|225|226|227|228|229|231|232|233|234|235|236|237|238|(2:312|313)|240|(3:242|243|244)(1:310)|246|247|248|(13:282|283|284|285|286|287|288|289|290|291|292|293|294)(1:250)|251|(7:253|254|255|256|257|258|259)(1:281)|260|261|262|263|264|12|13|14|(2:204|205)(1:16)|17|(20:19|20|21|22|23|24|25|26|27|(5:149|150|151|152|153)(5:29|30|31|32|33)|34|(4:36|37|(6:39|40|(9:44|45|46|47|48|49|50|51|52)|72|(2:74|(7:76|77|78|79|80|81|82))|83)(8:134|135|136|137|138|139|140|141)|(5:85|(3:87|88|89)(1:129)|90|(1:125)|94)(3:130|(1:132)|133))(1:144)|95|96|97|(2:99|100)(3:120|121|(1:123)(1:124))|101|(1:103)(1:119)|104|(5:106|(1:108)(1:112)|109|110|111)(1:114))(7:162|163|164|165|(1:199)(6:169|170|171|172|173|(4:175|(1:177)|178|179)(3:191|(1:193)|194))|180|(4:182|(1:184)(1:188)|185|187)(1:189))|57|(3:59|(1:61)(1:63)|62)|64|65)))|9|10|11|12|13|14|(0)(0)|17|(0)(0)|57|(0)|64|65|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04a9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0533, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0534, code lost:
    
        r24 = r8;
        r5 = true;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x053f, code lost:
    
        r18 = r17;
        r5 = r5;
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0195 A[Catch: all -> 0x01a1, TRY_LEAVE, TryCatch #0 {all -> 0x01a1, blocks: (B:234:0x0074, B:237:0x0078, B:313:0x0080, B:240:0x0092, B:244:0x0098, B:247:0x00a3, B:283:0x00ac, B:287:0x00b5, B:291:0x00bd, B:294:0x00cc, B:251:0x00e9, B:253:0x00ef, B:256:0x00fb, B:259:0x0108, B:260:0x0127, B:270:0x018f, B:272:0x0195), top: B:219:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x054b  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v31, types: [int] */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v75 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v31, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        String str;
        String str2;
        boolean z16;
        String str3;
        byte b16;
        SvcRespRegister svcRespRegister;
        int i3;
        byte b17;
        long j16;
        byte b18;
        long j17;
        long j18;
        int i16;
        boolean z17;
        boolean z18;
        long j19;
        byte b19;
        ?? r75;
        byte b26;
        long j26;
        ?? r56;
        boolean z19;
        String str4;
        boolean z26;
        MsfCommand msfCommand;
        MsfCommand msfCommand2;
        int i17;
        long longValue = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)).longValue();
        boolean z27 = false;
        boolean z28 = false;
        boolean z29 = false;
        if (longValue > this.f249700c) {
            this.f249699b = false;
        }
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        long a16 = com.tencent.mobileqq.msf.core.c0.j.a(toServiceMsg, fromServiceMsg);
        try {
        } catch (Throwable th5) {
            th = th5;
            j3 = currentTimeMillis;
            str = "unknown";
            boolean z36 = true;
        }
        if (fromServiceMsg.isSuccess()) {
            if (fromServiceMsg.getWupBuffer() != null) {
                try {
                } catch (Throwable th6) {
                    th = th6;
                    j3 = currentTimeMillis;
                    str2 = "unknown";
                    z16 = true;
                }
                if (fromServiceMsg.getWupBuffer().length >= 5) {
                    try {
                        UniPacket uniPacket = new UniPacket(true);
                        try {
                            uniPacket.decode(fromServiceMsg.getWupBuffer());
                            svcRespRegister = (SvcRespRegister) uniPacket.getByClass("SvcRespRegister", new SvcRespRegister());
                            try {
                                com.tencent.mobileqq.msf.core.e0.i.b(svcRespRegister.strClientIP);
                                com.tencent.mobileqq.msf.core.e0.i.a(svcRespRegister.iClientPort);
                                byte b27 = svcRespRegister.bUpdateFlag;
                                try {
                                    long j27 = svcRespRegister.timeStamp;
                                    try {
                                        byte b28 = svcRespRegister.cReplyCode;
                                        try {
                                            int i18 = svcRespRegister.iStatus;
                                            j16 = j27;
                                            try {
                                                long j28 = svcRespRegister.lServerTime;
                                                if (j28 > 0) {
                                                    try {
                                                        NetConnInfoCenter.handleGetServerTimeResp(j28);
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                        str3 = f249686o;
                                                        j3 = -1;
                                                        b17 = b28;
                                                        i3 = i18;
                                                        b16 = b27;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        b18 = b16;
                                                        j17 = j16;
                                                        r75 = i3;
                                                        j26 = j17;
                                                        b19 = b18;
                                                        z19 = false;
                                                        j19 = longValue;
                                                        str = "unknown";
                                                        b26 = b17;
                                                        r56 = j3;
                                                        long j29 = j19;
                                                        if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                        }
                                                        if (!z19) {
                                                        }
                                                        if (this.f249698a.f249731a.getStatReporter() != null) {
                                                        }
                                                        h hVar = this.f249698a;
                                                        hVar.a(hVar.n());
                                                        th.printStackTrace();
                                                    }
                                                }
                                                long j36 = svcRespRegister.uExtOnlineStatus;
                                                if (b28 == 0) {
                                                    j3 = j36;
                                                    try {
                                                        j18 = svcRespRegister.uClientBatteryGetInterval;
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        str3 = f249686o;
                                                        b17 = b28;
                                                        i3 = i18;
                                                        b16 = b27;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d(str3, 2, "decodeRegisterPushResp error", e);
                                                        }
                                                        b18 = b16;
                                                        j17 = j16;
                                                        r75 = i3;
                                                        j26 = j17;
                                                        b19 = b18;
                                                        z19 = false;
                                                        j19 = longValue;
                                                        str = "unknown";
                                                        b26 = b17;
                                                        r56 = j3;
                                                        long j292 = j19;
                                                        if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                        }
                                                        if (!z19) {
                                                        }
                                                        if (this.f249698a.f249731a.getStatReporter() != null) {
                                                        }
                                                        h hVar2 = this.f249698a;
                                                        hVar2.a(hVar2.n());
                                                        th.printStackTrace();
                                                    }
                                                } else {
                                                    j3 = j36;
                                                    j18 = -1;
                                                }
                                                try {
                                                    i16 = i18;
                                                    if (QLog.isColorLevel()) {
                                                        try {
                                                            Object[] objArr = new Object[4];
                                                            try {
                                                                objArr[0] = "pushresp cReplyCode:";
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                j3 = currentTimeMillis;
                                                                str2 = "unknown";
                                                                z28 = false;
                                                                z16 = true;
                                                                z29 = z28;
                                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                                }
                                                                h hVar22 = this.f249698a;
                                                                hVar22.a(hVar22.n());
                                                                th.printStackTrace();
                                                            }
                                                            try {
                                                                objArr[1] = Byte.valueOf(b28);
                                                                objArr[2] = " sendBatteryInterval:";
                                                                objArr[3] = Long.valueOf(j18);
                                                                str3 = f249686o;
                                                                try {
                                                                    QLog.d(str3, 2, objArr);
                                                                } catch (Exception e18) {
                                                                    e = e18;
                                                                    b16 = b27;
                                                                    b17 = b28;
                                                                    i3 = i16;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    b18 = b16;
                                                                    j17 = j16;
                                                                    r75 = i3;
                                                                    j26 = j17;
                                                                    b19 = b18;
                                                                    z19 = false;
                                                                    j19 = longValue;
                                                                    str = "unknown";
                                                                    b26 = b17;
                                                                    r56 = j3;
                                                                    long j2922 = j19;
                                                                    if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                                    }
                                                                    if (!z19) {
                                                                    }
                                                                    if (this.f249698a.f249731a.getStatReporter() != null) {
                                                                    }
                                                                    h hVar222 = this.f249698a;
                                                                    hVar222.a(hVar222.n());
                                                                    th.printStackTrace();
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                j3 = currentTimeMillis;
                                                                str2 = "unknown";
                                                                z17 = true;
                                                                z29 = false;
                                                                z16 = z17;
                                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                                }
                                                                h hVar2222 = this.f249698a;
                                                                hVar2222.a(hVar2222.n());
                                                                th.printStackTrace();
                                                            }
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            str3 = f249686o;
                                                            b16 = b27;
                                                            b17 = b28;
                                                            i3 = i16;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            b18 = b16;
                                                            j17 = j16;
                                                            r75 = i3;
                                                            j26 = j17;
                                                            b19 = b18;
                                                            z19 = false;
                                                            j19 = longValue;
                                                            str = "unknown";
                                                            b26 = b17;
                                                            r56 = j3;
                                                            long j29222 = j19;
                                                            if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                            }
                                                            if (!z19) {
                                                            }
                                                            if (this.f249698a.f249731a.getStatReporter() != null) {
                                                            }
                                                            h hVar22222 = this.f249698a;
                                                            hVar22222.a(hVar22222.n());
                                                            th.printStackTrace();
                                                        }
                                                    } else {
                                                        str3 = f249686o;
                                                    }
                                                    if (QLog.isDevelopLevel()) {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("pushresp servertime is ");
                                                        b16 = b27;
                                                        try {
                                                            sb5.append(svcRespRegister.lServerTime);
                                                            b17 = b28;
                                                            try {
                                                                sb5.append(this.f249698a.f249731a.timeFormatter.format(Long.valueOf(svcRespRegister.lServerTime * 1000)));
                                                                QLog.d(str3, 4, sb5.toString());
                                                            } catch (Exception e26) {
                                                                e = e26;
                                                                i3 = i16;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                b18 = b16;
                                                                j17 = j16;
                                                                r75 = i3;
                                                                j26 = j17;
                                                                b19 = b18;
                                                                z19 = false;
                                                                j19 = longValue;
                                                                str = "unknown";
                                                                b26 = b17;
                                                                r56 = j3;
                                                                long j292222 = j19;
                                                                if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                                }
                                                                if (!z19) {
                                                                }
                                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                                }
                                                                h hVar222222 = this.f249698a;
                                                                hVar222222.a(hVar222222.n());
                                                                th.printStackTrace();
                                                            }
                                                        } catch (Exception e27) {
                                                            e = e27;
                                                            b17 = b28;
                                                            i3 = i16;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            b18 = b16;
                                                            j17 = j16;
                                                            r75 = i3;
                                                            j26 = j17;
                                                            b19 = b18;
                                                            z19 = false;
                                                            j19 = longValue;
                                                            str = "unknown";
                                                            b26 = b17;
                                                            r56 = j3;
                                                            long j2922222 = j19;
                                                            if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                            }
                                                            if (!z19) {
                                                            }
                                                            if (this.f249698a.f249731a.getStatReporter() != null) {
                                                            }
                                                            h hVar2222222 = this.f249698a;
                                                            hVar2222222.a(hVar2222222.n());
                                                            th.printStackTrace();
                                                        }
                                                    } else {
                                                        b16 = b27;
                                                        b17 = b28;
                                                    }
                                                    z18 = false;
                                                    try {
                                                        MsfPullConfigUtil.parseConfigResponse(svcRespRegister.bytes_0x769_rspbody, false);
                                                        j19 = longValue;
                                                        b19 = b16;
                                                        str = "unknown";
                                                        r75 = i16;
                                                        b26 = b17;
                                                        j26 = j16;
                                                        r56 = j3;
                                                        z19 = true;
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        j3 = currentTimeMillis;
                                                        str2 = "unknown";
                                                        z28 = z18;
                                                        z16 = true;
                                                        z29 = z28;
                                                        if (this.f249698a.f249731a.getStatReporter() != null) {
                                                        }
                                                        h hVar22222222 = this.f249698a;
                                                        hVar22222222.a(hVar22222222.n());
                                                        th.printStackTrace();
                                                    }
                                                } catch (Exception e28) {
                                                    e = e28;
                                                    i16 = i18;
                                                    b16 = b27;
                                                    str3 = f249686o;
                                                }
                                            } catch (Exception e29) {
                                                e = e29;
                                                b16 = b27;
                                                str3 = f249686o;
                                                b17 = b28;
                                                i3 = i18;
                                                j3 = -1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                b18 = b16;
                                                j17 = j16;
                                                r75 = i3;
                                                j26 = j17;
                                                b19 = b18;
                                                z19 = false;
                                                j19 = longValue;
                                                str = "unknown";
                                                b26 = b17;
                                                r56 = j3;
                                                long j29222222 = j19;
                                                if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                                }
                                                if (!z19) {
                                                }
                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                }
                                                h hVar222222222 = this.f249698a;
                                                hVar222222222.a(hVar222222222.n());
                                                th.printStackTrace();
                                            }
                                        } catch (Exception e36) {
                                            e = e36;
                                            j16 = j27;
                                            b16 = b27;
                                            str3 = f249686o;
                                            b17 = b28;
                                            i3 = -1;
                                        }
                                    } catch (Exception e37) {
                                        e = e37;
                                        j16 = j27;
                                        b16 = b27;
                                        str3 = f249686o;
                                        i3 = -1;
                                        b17 = -1;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        j3 = currentTimeMillis;
                                        str2 = "unknown";
                                    }
                                } catch (Exception e38) {
                                    e = e38;
                                    b16 = b27;
                                    str3 = f249686o;
                                    i3 = -1;
                                    b17 = -1;
                                    j16 = -1;
                                    j3 = -1;
                                    if (QLog.isColorLevel()) {
                                    }
                                    b18 = b16;
                                    j17 = j16;
                                    r75 = i3;
                                    j26 = j17;
                                    b19 = b18;
                                    z19 = false;
                                    j19 = longValue;
                                    str = "unknown";
                                    b26 = b17;
                                    r56 = j3;
                                    long j292222222 = j19;
                                    if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                                    }
                                    if (!z19) {
                                    }
                                    if (this.f249698a.f249731a.getStatReporter() != null) {
                                    }
                                    h hVar2222222222 = this.f249698a;
                                    hVar2222222222.a(hVar2222222222.n());
                                    th.printStackTrace();
                                }
                            } catch (Exception e39) {
                                e = e39;
                                str3 = f249686o;
                                b16 = -1;
                            }
                        } catch (Exception e46) {
                            e = e46;
                            str3 = f249686o;
                            b16 = -1;
                            svcRespRegister = null;
                        }
                        long j2922222222 = j19;
                        if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
                            str4 = str;
                        } else {
                            try {
                                str4 = (String) toServiceMsg.getAttribute("regPushReason");
                            } catch (Throwable th11) {
                                th = th11;
                                j3 = currentTimeMillis;
                                str2 = str;
                                z17 = true;
                                z29 = false;
                                z16 = z17;
                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                }
                                h hVar22222222222 = this.f249698a;
                                hVar22222222222.a(hVar22222222222.n());
                                th.printStackTrace();
                            }
                        }
                        if (!z19) {
                            try {
                                f249691t = true;
                                try {
                                    this.f249702e = 0;
                                    j3 = currentTimeMillis;
                                    try {
                                        this.f249703f = System.currentTimeMillis();
                                        MsfCommand msfCommand3 = toServiceMsg.getMsfCommand();
                                        MsfCommand msfCommand4 = MsfCommand._msf_UnRegPush;
                                        if (msfCommand3 == msfCommand4) {
                                            try {
                                                z26 = true;
                                                try {
                                                    QLog.d(str3, 1, "handlerPush unregister push succ " + MD5.toMD5(fromServiceMsg.getUin()));
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    str2 = str4;
                                                    z17 = z26;
                                                    z29 = false;
                                                    z16 = z17;
                                                    if (this.f249698a.f249731a.getStatReporter() != null) {
                                                    }
                                                    h hVar222222222222 = this.f249698a;
                                                    hVar222222222222.a(hVar222222222222.n());
                                                    th.printStackTrace();
                                                }
                                            } catch (Throwable th13) {
                                                th = th13;
                                                str2 = str4;
                                                z17 = true;
                                                z29 = false;
                                                z16 = z17;
                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                }
                                                h hVar2222222222222 = this.f249698a;
                                                hVar2222222222222.a(hVar2222222222222.n());
                                                th.printStackTrace();
                                            }
                                        } else {
                                            try {
                                                QLog.d(str3, 1, "handlerPush register push succ " + MD5.toMD5(fromServiceMsg.getUin()) + " bUpdateFlag: " + b19 + ", timeStamp:  " + j26 + ", cReplyCode:" + b26 + " ,iStatus: " + r75 + ", regPushReason: " + str4);
                                                b(n.b(toServiceMsg));
                                            } catch (Throwable th14) {
                                                th = th14;
                                                r56 = 1;
                                                str2 = str4;
                                                z17 = r56;
                                                z29 = false;
                                                z16 = z17;
                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                }
                                                h hVar22222222222222 = this.f249698a;
                                                hVar22222222222222.a(hVar22222222222222.n());
                                                th.printStackTrace();
                                            }
                                        }
                                        com.tencent.mobileqq.msf.core.push.a aVar = this.f249698a.f249742i.get(n.b(toServiceMsg));
                                        if (aVar != null) {
                                            ?? r85 = this.f249698a.f249731a.nowSocketConnAdd;
                                            aVar.f249595i = r85;
                                            aVar.f249592f = System.currentTimeMillis();
                                            try {
                                                if (r75 > 0) {
                                                    PushRegisterInfo pushRegisterInfo = aVar.f249597k;
                                                    if (pushRegisterInfo != null && (i17 = pushRegisterInfo.iStatus) != r75) {
                                                        Object[] objArr2 = new Object[2];
                                                        z18 = false;
                                                        try {
                                                            objArr2[0] = Integer.valueOf(i17);
                                                        } catch (Throwable th15) {
                                                            th = th15;
                                                            str2 = str4;
                                                            z28 = z18;
                                                            z16 = true;
                                                            z29 = z28;
                                                            if (this.f249698a.f249731a.getStatReporter() != null) {
                                                            }
                                                            h hVar222222222222222 = this.f249698a;
                                                            hVar222222222222222.a(hVar222222222222222.n());
                                                            th.printStackTrace();
                                                        }
                                                        try {
                                                            objArr2[1] = Integer.valueOf((int) r75);
                                                            QLog.d(str3, 1, String.format("update old status: %s to %s", objArr2));
                                                            aVar.f249597k.iStatus = r75;
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                            str2 = str4;
                                                            z17 = true;
                                                            z29 = false;
                                                            z16 = z17;
                                                            if (this.f249698a.f249731a.getStatReporter() != null) {
                                                            }
                                                            h hVar2222222222222222 = this.f249698a;
                                                            hVar2222222222222222.a(hVar2222222222222222.n());
                                                            th.printStackTrace();
                                                        }
                                                    }
                                                    PushRegisterInfo pushRegisterInfo2 = aVar.f249597k;
                                                    if (pushRegisterInfo2 != null) {
                                                        long j37 = pushRegisterInfo2.extStatus;
                                                        if (j37 != (r56 == true ? 1L : 0L)) {
                                                            Object[] objArr3 = new Object[2];
                                                            objArr3[0] = Long.valueOf(j37);
                                                            objArr3[1] = Long.valueOf(r56 == true ? 1L : 0L);
                                                            QLog.d(str3, 1, String.format("update old status: %s to %s", objArr3));
                                                            aVar.f249597k.extStatus = r56 == true ? 1L : 0L;
                                                        }
                                                    }
                                                    z26 = true;
                                                } else {
                                                    int i19 = toServiceMsg.extraData.getInt("oldStatus", 0);
                                                    z26 = true;
                                                    QLog.d(str3, 1, "iStatus is 0, use old status: " + i19);
                                                    fromServiceMsg.attributes.put("attr_online_status", Integer.valueOf(i19));
                                                }
                                                if (svcRespRegister != null) {
                                                    if (QLog.isColorLevel()) {
                                                        StringBuilder sb6 = new StringBuilder();
                                                        sb6.append("recv register push resp.iInterval=");
                                                        sb6.append(svcRespRegister.iHelloInterval);
                                                        sb6.append(", queryIntervTime=");
                                                        sb6.append(this.f249698a.n());
                                                        sb6.append(", next query time is ");
                                                        msfCommand = msfCommand4;
                                                        sb6.append(h.f249713i0.format(Long.valueOf(System.currentTimeMillis() + (svcRespRegister.iHelloInterval * 1000))));
                                                        QLog.d(str3, 2, sb6.toString());
                                                    } else {
                                                        msfCommand = msfCommand4;
                                                    }
                                                    if (!com.tencent.mobileqq.msf.core.x.b.c() || com.tencent.mobileqq.msf.core.net.r.b.f248972e) {
                                                        this.f249698a.f249758y = svcRespRegister.iHelloInterval * 1000;
                                                    }
                                                    h hVar3 = this.f249698a;
                                                    hVar3.a(hVar3.n());
                                                } else {
                                                    msfCommand = msfCommand4;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d(str3, 2, "recv null register push resp, use default intervTime " + this.f249698a.n());
                                                    }
                                                    h hVar4 = this.f249698a;
                                                    hVar4.a(hVar4.n());
                                                }
                                            } catch (Throwable th17) {
                                                th = th17;
                                                str2 = str4;
                                                z28 = r85;
                                                z16 = true;
                                                z29 = z28;
                                                if (this.f249698a.f249731a.getStatReporter() != null) {
                                                }
                                                h hVar22222222222222222 = this.f249698a;
                                                hVar22222222222222222.a(hVar22222222222222222.n());
                                                th.printStackTrace();
                                            }
                                        } else {
                                            msfCommand = msfCommand4;
                                        }
                                        fromServiceMsg.attributes.put("ext_status", Long.valueOf(r56 == true ? 1L : 0L));
                                        if (toServiceMsg.getMsfCommand() == MsfCommand._msf_RegPush) {
                                            fromServiceMsg.setMsfCommand(MsfCommand.registerPush);
                                            msfCommand2 = msfCommand;
                                        } else {
                                            msfCommand2 = msfCommand;
                                            if (toServiceMsg.getMsfCommand() == msfCommand2) {
                                                fromServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
                                            } else {
                                                fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
                                            }
                                        }
                                        if (toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_TOSERVICEMSG_SRCCMD)) {
                                            this.f249698a.f249731a.addRespToQuque(toServiceMsg, fromServiceMsg);
                                        } else {
                                            MsfSdkUtils.addFromMsgProcessName(n.b(toServiceMsg), fromServiceMsg);
                                            this.f249698a.f249731a.addRespToQuque(null, fromServiceMsg);
                                        }
                                        if (this.f249698a.f249731a.getStatReporter() != null) {
                                            this.f249698a.f249731a.getStatReporter().a(true, j3, fromServiceMsg.getBusinessFailCode(), a16, toServiceMsg.getMsfCommand() == msfCommand2, str4);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th18) {
                                        th = th18;
                                        r56 = 1;
                                    }
                                } catch (Throwable th19) {
                                    th = th19;
                                    j3 = currentTimeMillis;
                                    z16 = true;
                                    str2 = str4;
                                    z29 = false;
                                }
                            } catch (Throwable th20) {
                                th = th20;
                                j3 = currentTimeMillis;
                                r56 = 1;
                            }
                        } else {
                            j3 = currentTimeMillis;
                            z16 = true;
                            try {
                                try {
                                    if (j2922222222 <= this.f249700c || this.f249699b) {
                                        r75 = 0;
                                    } else {
                                        try {
                                            h.f249718n0 = false;
                                            if (this.f249702e > 2) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(str3, 2, "register push register error, retry count " + this.f249702e + ", set retry at " + h.f249713i0.format(Long.valueOf(this.f249698a.n() + System.currentTimeMillis())));
                                                }
                                                r75 = 0;
                                                this.f249702e = 0;
                                                h hVar5 = this.f249698a;
                                                hVar5.a(hVar5.n());
                                            } else {
                                                r75 = 0;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(str3, 2, "register push register error, retry count " + this.f249702e + ",set retry at " + h.f249713i0.format(Long.valueOf(System.currentTimeMillis() + 60000)));
                                                }
                                                this.f249702e++;
                                                this.f249698a.a(60000L);
                                            }
                                        } catch (Throwable th21) {
                                            th = th21;
                                            r75 = 0;
                                            str2 = str4;
                                            z29 = r75;
                                            if (this.f249698a.f249731a.getStatReporter() != null) {
                                            }
                                            h hVar222222222222222222 = this.f249698a;
                                            hVar222222222222222222.a(hVar222222222222222222.n());
                                            th.printStackTrace();
                                        }
                                    }
                                    if (this.f249698a.f249731a.getStatReporter() != null) {
                                        this.f249698a.f249731a.getStatReporter().a(false, j3, fromServiceMsg.getBusinessFailCode(), a16, toServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush ? true : r75 == true ? 1 : 0, str4);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th22) {
                                    th = th22;
                                }
                            } catch (Throwable th23) {
                                th = th23;
                                r75 = 0;
                            }
                        }
                    } catch (Throwable th24) {
                        th = th24;
                        j3 = currentTimeMillis;
                        str2 = "unknown";
                        z17 = true;
                        z29 = false;
                        z16 = z17;
                        if (this.f249698a.f249731a.getStatReporter() != null) {
                        }
                        h hVar2222222222222222222 = this.f249698a;
                        hVar2222222222222222222.a(hVar2222222222222222222.n());
                        th.printStackTrace();
                    }
                    if (this.f249698a.f249731a.getStatReporter() != null) {
                        this.f249698a.f249731a.getStatReporter().a(false, j3, fromServiceMsg.getBusinessFailCode(), a16, toServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush ? z16 : z29, str2);
                    }
                    h hVar22222222222222222222 = this.f249698a;
                    hVar22222222222222222222.a(hVar22222222222222222222.n());
                    th.printStackTrace();
                }
            }
        }
        str3 = f249686o;
        svcRespRegister = null;
        i3 = -1;
        j17 = -1;
        b18 = -1;
        b17 = -1;
        j3 = -1;
        r75 = i3;
        j26 = j17;
        b19 = b18;
        z19 = false;
        j19 = longValue;
        str = "unknown";
        b26 = b17;
        r56 = j3;
        long j29222222222 = j19;
        if (toServiceMsg.getAttributes().containsKey("regPushReason")) {
        }
        if (!z19) {
        }
        if (this.f249698a.f249731a.getStatReporter() != null) {
        }
        h hVar222222222222222222222 = this.f249698a;
        hVar222222222222222222222.a(hVar222222222222222222222.n());
        th.printStackTrace();
    }

    long c(String str) {
        return BaseApplication.getContext().getSharedPreferences("unrtime", 0).getLong(str, 0L);
    }

    void a(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(str, j3).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.mobileqq.msf.core.push.a aVar, ToServiceMsg toServiceMsg, boolean z16, RegPushReason regPushReason) {
        if (aVar.f249597k == null) {
            return;
        }
        if (this.f249698a.p()) {
            QLog.d(f249686o, 1, "has blocked sendMsgPushRegister");
            return;
        }
        if (com.tencent.mobileqq.msf.core.x.b.a1() && !com.tencent.mobileqq.msf.core.x.b.e(aVar.f249597k.uin)) {
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, aVar.f249597k.uin + " is booting and can not autoRegisterPush,return.");
                return;
            }
            return;
        }
        boolean a16 = a(regPushReason);
        if (!a16 && !z16 && this.f249699b && System.currentTimeMillis() - aVar.f249591e < 30000) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("also send pushRegister, return. ");
            sb5.append(!a16);
            sb5.append(" ");
            sb5.append(!z16);
            sb5.append(" ");
            sb5.append(this.f249699b);
            QLog.d(f249686o, 1, sb5.toString());
            return;
        }
        try {
            if (z16) {
                a(toServiceMsg.getUin(), System.currentTimeMillis());
            } else if (toServiceMsg != null) {
                long c16 = c(toServiceMsg.getUin());
                if (c16 != 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - c16;
                    if (j3 > 0) {
                        long j16 = j3 / 1000;
                        HashMap hashMap = new HashMap();
                        hashMap.put("unRegtime", String.valueOf(c16));
                        hashMap.put("now", String.valueOf(currentTimeMillis));
                        hashMap.put("uin", toServiceMsg.getUin());
                        if (this.f249698a.f249731a.getStatReporter() != null) {
                            this.f249698a.f249731a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247659a, true, j16, 0L, (Map<String, String>) hashMap, false, false);
                        }
                    }
                    a(toServiceMsg.getUin(), 0L);
                }
            }
        } catch (Exception e16) {
            QLog.d(f249686o, 1, "get reginterv error " + e16, e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249686o, 2, "ConfigManager.isAutoStarting():" + com.tencent.mobileqq.msf.core.x.b.a1());
        }
        try {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setServantName(f249684m);
            uniPacket.setFuncName(f249683l);
            SvcReqRegister svcReqRegister = new SvcReqRegister();
            svcReqRegister.cConnType = f249685n;
            svcReqRegister.lBid = aVar.f249589c;
            svcReqRegister.lUin = Long.parseLong(aVar.f249597k.uin);
            PushRegisterInfo pushRegisterInfo = aVar.f249597k;
            svcReqRegister.iStatus = pushRegisterInfo.iStatus;
            svcReqRegister.bKikPC = pushRegisterInfo.bKikPC;
            svcReqRegister.bKikWeak = pushRegisterInfo.bKikWeak;
            svcReqRegister.timeStamp = pushRegisterInfo.timeStamp;
            svcReqRegister.iLargeSeq = pushRegisterInfo.iLargeSeq;
            svcReqRegister.cBindUinNotifySwitch = pushRegisterInfo.cBindUinNotifySwitch;
            svcReqRegister.bRegType = (byte) (!a(regPushReason) ? 1 : 0);
            svcReqRegister.bIsSetStatus = (byte) (regPushReason == RegPushReason.setOnlineStatus ? 1 : 0);
            PushRegisterInfo pushRegisterInfo2 = aVar.f249597k;
            svcReqRegister.uExtOnlineStatus = pushRegisterInfo2.extStatus;
            if (MsfSdkUtils.isBatteryOnlineStatus(pushRegisterInfo2)) {
                PushRegisterInfo pushRegisterInfo3 = aVar.f249597k;
                svcReqRegister.iBatteryStatus = MsfSdkUtils.getSendBatteryStatus(pushRegisterInfo3.batteryCapacity, pushRegisterInfo3.powerConnect);
            } else {
                svcReqRegister.iBatteryStatus = 0;
            }
            try {
                svcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (NetConnInfoCenter.isMobileConn()) {
                svcReqRegister.cNetType = (byte) 0;
            } else if (NetConnInfoCenter.isWifiConn()) {
                svcReqRegister.cNetType = (byte) 1;
            }
            svcReqRegister.vecGuid = NetConnInfoCenter.GUID;
            String model = DeviceInfoMonitor.getModel();
            svcReqRegister.strDevName = model;
            svcReqRegister.strDevType = model;
            svcReqRegister.strOSVer = Build.VERSION.RELEASE;
            if (!z16) {
                svcReqRegister.uNewSSOIp = f249690s;
                svcReqRegister.uOldSSOIp = f249689r;
                svcReqRegister.strVendorName = ROMUtil.getRomName();
                svcReqRegister.strVendorOSName = ROMUtil.getRomVersion(20);
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "register online report " + svcReqRegister.strVendorName + " " + svcReqRegister.strVendorOSName);
                }
            }
            svcReqRegister.bytes_0x769_reqbody = MsfPullConfigUtil.pullConfigRequest(false);
            if (SettingCloneUtil.readValue((Context) BaseApplication.getContext(), aVar.f249597k.uin, (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false)) {
                svcReqRegister.bSetMute = (byte) 1;
            } else {
                svcReqRegister.bSetMute = (byte) 0;
            }
            int h16 = com.tencent.qphone.base.util.c.h();
            if (h16 > 0) {
                VendorPushInfo vendorPushInfo = new VendorPushInfo();
                vendorPushInfo.uVendorType = h16;
                svcReqRegister.stVendorPushInfo = vendorPushInfo;
                if (h16 == 3) {
                    boolean b16 = f.b(BaseApplication.getContext(), MsfCore.sCore.getMainAccount());
                    QLog.d(f249686o, 1, "HPush_msf-pushCoder msgNotificationEnabled = " + b16);
                    svcReqRegister.cNotifySwitch = b16 ? (byte) 1 : (byte) 0;
                }
            }
            if (toServiceMsg != null && toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_LOGIN_TYPE)) {
                svcReqRegister.bLoginType = ((Byte) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_TYPE, (byte) 0)).byteValue();
            }
            if (!z16 && toServiceMsg != null && toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_REGISTER_EXT_DATA)) {
                byte[] bArr = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_EXT_DATA, new byte[0]);
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "[sendMsgPushRegister], set registerExt = " + HexUtil.bytes2HexStr(bArr));
                }
                svcReqRegister.vecRegisterExtData = bArr;
            }
            QLog.d(f249686o, 1, "HPush_msf-pushCoder.vendor_push_type:" + h16);
            uniPacket.put(f249683l, svcReqRegister);
            byte[] encode = uniPacket.encode();
            ToServiceMsg toServiceMsg2 = new ToServiceMsg("", aVar.f249597k.uin, "StatSvc.register");
            toServiceMsg2.setAppId(aVar.f249587a);
            if (toServiceMsg != null) {
                toServiceMsg2.setAppSeq(toServiceMsg.getAppSeq());
                toServiceMsg2.addAttribute(MsfConstants.ATTRIBUTE_TOSERVICEMSG_SRCCMD, toServiceMsg.getServiceCmd());
                toServiceMsg2.extraData.putInt("oldStatus", toServiceMsg.extraData.getInt("oldStatus", 0));
            }
            toServiceMsg2.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            toServiceMsg2.putWupBuffer(encode);
            toServiceMsg2.setTimeout(30000L);
            toServiceMsg2.addAttribute("regPushReason", regPushReason.toString());
            if (z16) {
                toServiceMsg2.setMsfCommand(MsfCommand._msf_UnRegPush);
            } else {
                toServiceMsg2.setMsfCommand(MsfCommand._msf_RegPush);
            }
            MsfSdkUtils.addToMsgProcessName(aVar.f249588b, toServiceMsg2);
            h.f249718n0 = true;
            this.f249700c = System.currentTimeMillis();
            this.f249698a.f249731a.sendSsoMsg(toServiceMsg2);
            aVar.f249591e = System.currentTimeMillis();
            if (z16) {
                QLog.d(f249686o, 1, "handlerPush send " + MD5.toMD5(aVar.f249597k.uin) + " unregister push id " + aVar.f249589c + " pushStatus:" + aVar.f249597k.iStatus + " bRegType:" + ((int) svcReqRegister.bRegType) + " extStatus:" + aVar.f249597k.extStatus + " batter:" + svcReqRegister.iBatteryStatus);
            } else {
                this.f249699b = true;
                QLog.d(f249686o, 1, "handlerPush send " + MD5.toMD5(aVar.f249597k.uin) + " register push id " + aVar.f249589c + " pushStatus:" + aVar.f249597k.iStatus + " bRegType:" + ((int) svcReqRegister.bRegType) + " timeStamp:" + svcReqRegister.timeStamp + " newIP:" + f249690s + " oldIP:" + f249689r + ",regPushReason:" + regPushReason.toString() + " extStatus:" + aVar.f249597k.extStatus + " battery:" + svcReqRegister.iBatteryStatus);
            }
        } catch (Exception e18) {
            QLog.d(f249686o, 1, "send registerPush error " + e18, e18);
        }
        this.f249698a.o();
    }

    void b(String str) {
        if (com.tencent.mobileqq.msf.service.e.a()) {
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, str + " is running, no need send SvcRequestPullUnreadMsgCountReq");
                return;
            }
            return;
        }
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249698a.f249742i.get(str);
        if (MsfService.getCore().getUinPushStatus(aVar.f249597k.uin) == 95) {
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "on recvOfflineMsg status don't start QQ");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249686o, 2, "QQ not running, send SvcRequestPullUnreadMsgCountReq now");
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName(f249693v);
        uniPacket.setFuncName(f249692u);
        a.a.b.a.a.a.a aVar2 = new a.a.b.a.a.a.a();
        aVar2.f25159a = true;
        aVar2.f25160b = true;
        aVar2.f25161c = true;
        uniPacket.put("req_PullUnreadMsgCount", aVar2);
        ToServiceMsg toServiceMsg = new ToServiceMsg("", aVar.f249597k.uin, BaseConstants.COMMAND_RequestPullUnreadMsgCount);
        toServiceMsg.setAppId(aVar.f249587a);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
        toServiceMsg.setNeedCallback(true);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.putWupBuffer(uniPacket.encode());
        try {
            this.f249698a.f249731a.sendSsoMsg(toServiceMsg);
        } catch (Exception e16) {
            QLog.w(f249686o, 1, "query push error " + e16, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.mobileqq.msf.core.push.a aVar, boolean z16) {
        if (com.tencent.mobileqq.msf.core.x.b.f250193x && !z16) {
            long i3 = this.f249698a.i() + this.f249698a.n();
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "sendMsgPushQuery, check time now=" + h.f249713i0.format(Long.valueOf(System.currentTimeMillis())) + ", shouldSendQueryTime=" + h.f249713i0.format(Long.valueOf(i3)));
            }
            if (System.currentTimeMillis() < i3) {
                this.f249698a.a(i3 - System.currentTimeMillis());
                return;
            }
        }
        try {
            if (this.f249698a.j() > 0) {
                h.f249715k0 = SystemClock.elapsedRealtime() - this.f249698a.j();
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "alarmTime: " + h.f249715k0 + " ,lastRecvSsoPacketTimeForSimpleGet=" + this.f249698a.j());
            }
            if (com.tencent.mobileqq.msf.core.x.b.f250194y && h.f249715k0 > com.tencent.mobileqq.msf.core.x.b.l0()) {
                String e16 = MsfService.getCore().getAccountCenter().e();
                if (com.tencent.mobileqq.msf.core.x.b.f250195z && Long.parseLong(e16) % 2 != 0) {
                    this.f249698a.f249759z = SystemClock.elapsedRealtime();
                    QLog.d(f249686o, 1, "wakeup too long, but not close conn:" + h.f249715k0);
                }
                QLog.d(f249686o, 1, "try closeConn closeByAlarmWakeUpTooLong by a exceeded time to wakeup alarm :" + h.f249715k0);
                MsfService.core.closeConn(com.tencent.qphone.base.a.closeByAlarmWakeUpTooLong);
                if (this.f249698a.f249731a.getStatReporter() != null) {
                    this.f249698a.f249731a.getStatReporter().a("1", e16, true, 0L);
                }
            }
            if (com.tencent.mobileqq.msf.core.x.b.f250194y && h.f249715k0 > com.tencent.mobileqq.msf.core.x.b.m0() && h.f249715k0 <= com.tencent.mobileqq.msf.core.x.b.l0()) {
                this.f249698a.B = SystemClock.elapsedRealtime();
            }
        } catch (Exception e17) {
            QLog.d(f249686o, 1, "do PreDetectionAlarmTimeAlpha error!", e17);
        }
        PushRegisterInfo pushRegisterInfo = aVar.f249597k;
        if (pushRegisterInfo != null) {
            if (pushRegisterInfo.uin != null && aVar.f249589c > 0) {
                String str = this.f249698a.f249739f + "|" + NetConnInfoCenter.getSystemNetworkType() + "|" + NetConnInfoCenter.getCurrentAPN() + "|" + (System.currentTimeMillis() - this.f249703f);
                ToServiceMsg toServiceMsg = new ToServiceMsg("", aVar.f249597k.uin, f249697z);
                toServiceMsg.setAppId(aVar.f249587a);
                toServiceMsg.setTimeout(30000L);
                toServiceMsg.setMsfCommand(MsfCommand._msf_queryPush);
                toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
                long j3 = h.f249715k0;
                if (j3 > 0) {
                    toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_ALARM_ELAPSED_TIEM, Long.valueOf(j3));
                    h.f249715k0 = 0L;
                }
                MsfSdkUtils.addToMsgProcessName(aVar.f249588b, toServiceMsg);
                try {
                    this.f249698a.f249731a.sendSsoMsg(toServiceMsg);
                } catch (Exception e18) {
                    QLog.w(f249686o, 1, "query push error " + e18, e18);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "send " + aVar.f249597k.uin + " query push id " + aVar.f249589c + " model:" + str);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "pushUin is " + aVar.f249597k.uin + ", queryPushId is " + aVar.f249589c + ". no query");
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f249706i == 0) {
            this.f249706i = currentTimeMillis;
        }
        int i3 = this.f249707j;
        if (i3 >= 5 && currentTimeMillis - this.f249706i < 600000) {
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "watchdog mStartWatchdogForInfoLoginRetryCount:" + this.f249707j + " time:" + (currentTimeMillis - this.f249706i));
                QLog.d(f249686o, 2, "watchdog launch QQ Process too much stop.");
                return;
            }
            return;
        }
        if (i3 == 5) {
            this.f249707j = 0;
            this.f249706i = currentTimeMillis;
        }
        this.f249707j++;
        if (QLog.isColorLevel()) {
            QLog.d(f249686o, 2, "watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:" + this.f249705h);
        }
        if (!B) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C);
            BaseApplication.getContext().registerReceiver(A, intentFilter);
            B = true;
        }
        MsfService.getCore().mbIsInfoLoginGetted.set(false);
        this.f249705h = 0;
        try {
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, new Intent(C), Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
            AlarmManager alarmManager = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            long currentTimeMillis2 = System.currentTimeMillis() + 10000;
            QLog.d(f249686o, 1, "register alarm, intent:" + broadcast);
            alarmManager.set(0, currentTimeMillis2, broadcast);
        } catch (Exception e16) {
            QLog.d(f249686o, 1, "watchdog startWatchdogForInfoLogin excep!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (this.f249698a.f249742i.get(n.b(toServiceMsg)) != null) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)).longValue();
            long a16 = com.tencent.mobileqq.msf.core.c0.j.a(toServiceMsg, fromServiceMsg);
            try {
                if (fromServiceMsg.isSuccess()) {
                    this.f249698a.b(SystemClock.elapsedRealtime());
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr = new byte[length];
                    System.arraycopy(fromServiceMsg.getWupBuffer(), 4, bArr, 0, length);
                    StatSvcSimpleGet.RspBody rspBody = new StatSvcSimpleGet.RspBody();
                    rspBody.mergeFrom(bArr);
                    this.f249704g = 0;
                    if (!com.tencent.mobileqq.msf.core.x.b.c() || com.tencent.mobileqq.msf.core.net.r.b.f248972e) {
                        this.f249698a.f249758y = rspBody.uint32_hello_interval.get() * 1000;
                    }
                    h hVar = this.f249698a;
                    hVar.a(hVar.n());
                    com.tencent.mobileqq.msf.core.e0.i.b(rspBody.str_clientip.get());
                    return;
                }
                if (this.f249698a.f249731a.getStatReporter() != null) {
                    this.f249698a.f249731a.getStatReporter().a(false, currentTimeMillis, fromServiceMsg.getBusinessFailCode(), a16);
                }
                this.f249698a.a(180000L);
            } catch (Throwable th5) {
                th5.printStackTrace();
                h hVar2 = this.f249698a;
                hVar2.a(hVar2.n());
            }
        }
    }

    public void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromServiceMsg, (Object) toServiceMsg);
            return;
        }
        String a16 = n.a();
        try {
            if (fromServiceMsg.isSuccess()) {
                UniPacket uniPacket = new UniPacket(true);
                uniPacket.decode(fromServiceMsg.getWupBuffer());
                a.a.b.a.a.a.b bVar = (a.a.b.a.a.a.b) uniPacket.getByClass("resp_PullUnreadMsgCount", new a.a.b.a.a.a.b());
                if (bVar != null && (bVar.f25164c > 0 || bVar.f25165d > 0 || bVar.f25166e > 0)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f249686o, 2, "UnreadMsg getted, call QQ process now resp.c2c_count:" + bVar.f25164c + " resp.group_count :" + bVar.f25165d + " resp.discuss_count" + bVar.f25166e);
                    }
                    a(a16);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "UnreadMsg getted,  resp.c2c_count:" + bVar.f25164c + " resp.group_count :" + bVar.f25165d + " resp.discuss_count" + bVar.f25166e);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249686o, 2, "UnreadMsg timeout, call QQ process now");
            }
            a(a16);
        } catch (Throwable th5) {
            QLog.d(f249686o, 1, "handle unreadmsg error " + th5, th5);
            a(a16);
        }
    }

    void a(String str) {
        h.f249716l0 = true;
        b();
        NetConnInfoCenter.callQQProcess(str);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249686o, 2, "watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:" + this.f249705h);
        }
        String processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
        if (processName != null && processName.indexOf(":") > 0) {
            processName = processName.substring(0, processName.indexOf(":"));
        }
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249698a.f249742i.get(processName);
        if (aVar != null && aVar.f249597k != null && MsfService.getCore().getUinPushStatus(aVar.f249597k.uin) != 95) {
            if (MsfService.getCore().mbIsInfoLoginGetted.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "watchdog startWatchdogCallback mbIsInfoLoginGetted:" + MsfService.getCore().mbIsInfoLoginGetted + " ok");
                    return;
                }
                return;
            }
            if (n.c()) {
                if (this.f249705h < 6) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f249686o, 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.f249705h);
                    }
                    this.f249705h++;
                    try {
                        PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, new Intent(C), Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
                        AlarmManager alarmManager = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
                        long currentTimeMillis = System.currentTimeMillis() + 10000;
                        QLog.d(f249686o, 1, "register alarm, intent:" + broadcast);
                        alarmManager.set(0, currentTimeMillis, broadcast);
                        return;
                    } catch (Exception e16) {
                        QLog.d(f249686o, 1, "watchdog startWatchdogCallback excep!", e16);
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f249686o, 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.f249705h);
                    return;
                }
                return;
            }
            QLog.d(f249686o, 1, "watchdog startWatchdogCallback QQProcess killed restart now");
            a(n.a());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249686o, 2, "watchdog startWatchdogCallback in 95 status do not start QQ Process");
        }
    }
}
