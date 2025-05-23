package com.tencent.mobileqq.msf.core.push;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.push.MSFAlarmManager;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.x.o;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.pb.MsfProbe;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001BB\u000f\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J \u0010*\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020#H\u0002R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFProbeNewManager;", "Lcom/tencent/mobileqq/msf/core/push/IMSFProbe;", "", "checkMSFHelloSend", "", "time", "convertTimeToMillis", "", "buff", "getBusinessBuff", "getMSFPingIntervalTime", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "handleMsfProbePush", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "toMsg", "fromMsg", "handleSsoResponse", "handleStatueSvsMsfHelloResp", "", "uin", "", "isCurrentUinOffline", "cmd", "isStateSvcMsg", "onAlarm", "onConnClosed", "onConnClosedInner", "onConnOpenInner", "onConnOpened", "onNtHeartBeatSend", "Landroid/content/Intent;", "intent", "onRecvAlarm", "onRegProxySvcSend", "", "id", "intervalTime", "registerMSFAlarm", "registerMSFPingAlarm", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "missTime", "reportOnAlarm", "sendStatusSvcMsfHello", "setQueryIntervalTimeFromServer", "lockTime", "tryWakeLock", "Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$AlarmCallback;", "mAlarmCallback", "Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$AlarmCallback;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "mLastRefreshMSFHelloAlarmTime", "J", "mLastRegisterMSFPingAlarmTime", "Lcom/tencent/mobileqq/msf/core/MsfCore;", "msfCore", "Lcom/tencent/mobileqq/msf/core/MsfCore;", "queryIntervalTimeFromStatusSvc", "I", "Lcom/tencent/mobileqq/msf/core/wakeup/MSFWakeLock;", "wakeLock", "Lcom/tencent/mobileqq/msf/core/wakeup/MSFWakeLock;", "<init>", "(Lcom/tencent/mobileqq/msf/core/MsfCore;)V", "Companion", "MSFSDK_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.msf.core.push.d, reason: from Kotlin metadata */
/* loaded from: classes15.dex */
public final class MSFProbeNewManager implements com.tencent.mobileqq.msf.core.push.b {
    static IPatchRedirector $redirector_ = null;
    private static final int A = 450000;
    private static final int B = 5000;
    private static final int C = 10000;
    private static final int D = 60000;
    private static final int E = 600000;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f249634h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f249635i = "MSF.J.MSFProbeNewManager";

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final String f249636j = "alarm_id";

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final String f249637k = "alarm_wait_time";

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final String f249638l = "alarm_advance_time";

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f249639m = "alarm_delay_time";

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final String f249640n = "use_wake_lock";

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final String f249641o = "event_name_on_alarm_monitor";

    /* renamed from: p, reason: collision with root package name */
    private static final int f249642p = 101;

    /* renamed from: q, reason: collision with root package name */
    private static final int f249643q = 1;

    /* renamed from: r, reason: collision with root package name */
    private static final int f249644r = 2;

    /* renamed from: s, reason: collision with root package name */
    private static final int f249645s = 3;

    /* renamed from: t, reason: collision with root package name */
    private static final int f249646t = 4;

    /* renamed from: u, reason: collision with root package name */
    private static final int f249647u = 5;

    /* renamed from: v, reason: collision with root package name */
    private static final int f249648v = 4;

    /* renamed from: w, reason: collision with root package name */
    private static final int f249649w = 1;

    /* renamed from: x, reason: collision with root package name */
    private static final int f249650x = 0;

    /* renamed from: y, reason: collision with root package name */
    private static final int f249651y = 180000;

    /* renamed from: z, reason: collision with root package name */
    private static final int f249652z = 3600000;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final MsfCore f249653a;

    /* renamed from: b, reason: collision with root package name */
    private int f249654b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private com.tencent.mobileqq.msf.core.h0.a f249655c;

    /* renamed from: d, reason: collision with root package name */
    private long f249656d;

    /* renamed from: e, reason: collision with root package name */
    private long f249657e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final Handler f249658f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final MSFAlarmManager.a f249659g;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFProbeNewManager$Companion;", "", "()V", "ALARM_TYPE_SEND_MSF_PING", "", "BEACON_EVENT_NAME_ON_ALARM_MONITOR", "", "BUFF_LENGTH_BYTES", "DEFAULT_QUERY_INTERVAL_TIME", "HANDLE_MESSAGE_CONN_CLOSED", "HANDLE_MESSAGE_CONN_OPENED", "HANDLE_MESSAGE_RECV_ALARM_BROADCAST", "HANDLE_MESSAGE_RECV_MAIN_CONN_SSO_RESP", "HANDLE_MESSAGE_RECV_STATE_SVC_RESP", "MAIN_PROCESS_EXIST", "MAIN_PROCESS_NOT_EXIST", "MAX_LOCK_TIME", "MAX_MSF_PING_INTERVAL_TIME", "MAX_QUERY_INTERVAL_TIME", "MIN_MSF_PING_ALARM_REGISTER_INTERVAL", "MIN_MSF_PING_INTERVAL_TIME", "MIN_QUERY_INTERVAL_TIME", "PARAM_KEY_ALARM_ADVANCE_TIME", "PARAM_KEY_ALARM_DELAY_TIME", "PARAM_KEY_ALARM_ID", "PARAM_KEY_ALARM_WAIT_TIME", "PARAM_KEY_USE_WAKE_LOCK", "TAG", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.msf.core.push.d$a */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/msf/core/push/MSFProbeNewManager$mAlarmCallback$1", "Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$AlarmCallback;", "onAlarm", "", "intent", "Landroid/content/Intent;", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.msf.core.push.d$b */
    /* loaded from: classes15.dex */
    public static final class b implements MSFAlarmManager.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFProbeNewManager.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.push.MSFAlarmManager.a
        public void a(@NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = intent;
            MSFProbeNewManager.this.f249658f.sendMessage(obtain);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22595);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f249634h = new a(null);
        }
    }

    public MSFProbeNewManager(@NotNull MsfCore msfCore) {
        Intrinsics.checkNotNullParameter(msfCore, "msfCore");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f249653a = msfCore;
        this.f249654b = 450000;
        this.f249658f = new Handler(q.l().getLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.msf.core.push.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a16;
                a16 = MSFProbeNewManager.a(MSFProbeNewManager.this, message);
                return a16;
            }
        });
        this.f249659g = new b();
    }

    private final long a(long j3) {
        return j3 * 1000;
    }

    private final long f() {
        long N = com.tencent.mobileqq.msf.core.x.d.N();
        if (N < 60000 || N > 600000) {
            return 180000L;
        }
        return N;
    }

    private final void g() {
        QLog.d(f249635i, 1, "handle onAlarm");
        if (com.tencent.mobileqq.msf.core.x.d.H()) {
            int M = com.tencent.mobileqq.msf.core.x.d.M();
            QLog.d(f249635i, 1, "try send MSFPingCheck, timeout:" + M);
            this.f249653a.sendMSFPingCheck(M);
        }
        e();
        j();
    }

    private final void h() {
        QLog.d(f249635i, 1, "onConnClosedInner");
        MSFAlarmManager.f249601e.a().a(101);
    }

    private final void i() {
        QLog.d(f249635i, 1, "onConnOpenInner");
        this.f249657e = SystemClock.elapsedRealtime();
        j();
    }

    private final void j() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.f249656d;
        if (j3 < 10000) {
            return;
        }
        QLog.d(f249635i, 1, "try registerMSFPingAlarm, mLastRegisterMSFPingAlarmTime:" + this.f249656d + ", curTime:" + elapsedRealtime + ", elapsed:" + j3);
        if (a(101, f())) {
            this.f249656d = SystemClock.elapsedRealtime();
        }
    }

    private final void k() {
        String mainAccount = MsfService.getCore().getMainAccount();
        if (a(mainAccount)) {
            QLog.d(f249635i, 1, "cancel sendStatusSvcMsfHello because of no login, currentUin: " + mainAccount);
            return;
        }
        boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
        if (isProcessExist) {
            QLog.d(f249635i, 1, "cancel sendStatusSvcMsfHello because of main process alive");
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("", mainAccount, BaseConstants.CMD_STATUS_SVC_MSF_HELLO);
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setMsfCommand(MsfCommand._msf_hello);
        toServiceMsg.setRequestSsoSeq(this.f249653a.getNextSeq());
        toServiceMsg.setTimeout(30000L);
        MsfProbe.MsfHelloReq msfHelloReq = new MsfProbe.MsfHelloReq();
        msfHelloReq.main_process_status.set(isProcessExist ? 1 : 0);
        toServiceMsg.putWupBuffer(MsfSdkUtils.addByteLen(msfHelloReq.toByteArray()));
        this.f249653a.sendSsoMsg(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            QLog.d(f249635i, 1, "onRegProxySvcSend");
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    private final void e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f249657e > this.f249654b) {
            QLog.d(f249635i, 1, "need to send MSFHello, elapsedTime: " + (elapsedRealtime - this.f249657e));
            k();
            this.f249657e = elapsedRealtime;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void b(@Nullable FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg == null || !fromServiceMsg.isSuccess()) {
            return;
        }
        try {
            MsfProbe.MsfProbePush msfProbePush = new MsfProbe.MsfProbePush();
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            Intrinsics.checkNotNullExpressionValue(wupBuffer, "fromServiceMsg.wupBuffer");
            MsfProbe.MsfProbePush mergeFrom = msfProbePush.mergeFrom(a(wupBuffer));
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "msfProbePush.mergeFrom(g\u2026romServiceMsg.wupBuffer))");
            MsfProbe.MsfProbePush msfProbePush2 = mergeFrom;
            if (msfProbePush2.msf_hello_interval.has()) {
                b(a(msfProbePush2.msf_hello_interval.get()));
            }
            QLog.d(f249635i, 1, "[handleMsfProbePush] receive MsfProbePush, timeInterval:" + msfProbePush2.msf_hello_interval.get());
        } catch (Exception e16) {
            QLog.e(f249635i, 1, "[handleMsfProbePush] parse msfProbePush error", e16);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), BaseConstants.CMD_MSF_CONN_PROBE_ACK);
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setMsfCommand(MsfCommand.unknown);
        toServiceMsg.setRequestSsoSeq(this.f249653a.getNextSeq());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        MsfProbe.AckMsfProbeReq ackMsfProbeReq = new MsfProbe.AckMsfProbeReq();
        ackMsfProbeReq.main_process_status.set(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), BaseApplication.getContext().getPackageName()) ? 1 : 0);
        toServiceMsg.putWupBuffer(MsfSdkUtils.addByteLen(ackMsfProbeReq.toByteArray()));
        this.f249653a.sendSsoMsg(toServiceMsg);
        this.f249658f.sendEmptyMessage(3);
        QLog.d(f249635i, 1, "[replyMsfProbePush] ", toServiceMsg.getStringForLog());
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            QLog.d(f249635i, 1, "onNtHeartBeatSend");
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d(f249635i, 1, "onConnOpened");
            this.f249658f.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(MSFProbeNewManager this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            this$0.i();
            return false;
        }
        if (i3 == 2) {
            this$0.h();
            return false;
        }
        if (i3 == 3) {
            this$0.f249657e = SystemClock.elapsedRealtime();
            return false;
        }
        if (i3 == 4) {
            this$0.e();
            this$0.j();
            return false;
        }
        if (i3 != 5) {
            return false;
        }
        Object obj = msg2.obj;
        if (!(obj instanceof Intent)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Intent");
        this$0.a((Intent) obj);
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d(f249635i, 1, "onConnClosed");
            this.f249658f.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a(@Nullable ToServiceMsg toServiceMsg, @Nullable FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg != null && o.f250373j.contains(toServiceMsg.getServiceCmd())) {
            this.f249658f.sendEmptyMessage(4);
            QLog.d(f249635i, 1, "onRecvMainConnSsoResp, cmd:" + toServiceMsg.getServiceCmd());
            Intrinsics.checkNotNull(fromServiceMsg);
            if (fromServiceMsg.isSuccess()) {
                String serviceCmd = toServiceMsg.getServiceCmd();
                Intrinsics.checkNotNullExpressionValue(serviceCmd, "toMsg.serviceCmd");
                if (b(serviceCmd)) {
                    this.f249658f.sendEmptyMessage(3);
                    return;
                }
                return;
            }
            return;
        }
        if (toServiceMsg == null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            QLog.d(f249635i, 1, "onRecvMainConnPush, cmd:" + fromServiceMsg.getServiceCmd());
            this.f249658f.sendEmptyMessage(4);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a(@Nullable FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                MsfProbe.MsfHelloResp msfHelloResp = new MsfProbe.MsfHelloResp();
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                Intrinsics.checkNotNullExpressionValue(wupBuffer, "fromServiceMsg.wupBuffer");
                MsfProbe.MsfHelloResp mergeFrom = msfHelloResp.mergeFrom(a(wupBuffer));
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "resp.mergeFrom(getBusine\u2026romServiceMsg.wupBuffer))");
                MsfProbe.MsfHelloResp msfHelloResp2 = mergeFrom;
                if (msfHelloResp2.msf_hello_interval.has()) {
                    b(a(msfHelloResp2.msf_hello_interval.get()));
                }
                QLog.d(f249635i, 1, "[handleStatueSvsMsfHelloResp] receive msf hello response, timeInterval:" + msfHelloResp2.msf_hello_interval.get());
                return;
            } catch (Exception e16) {
                QLog.e(f249635i, 1, "[handleStatueSvsMsfHelloResp] parse MsfHelloResp error", e16);
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleStatueSvsMsfHelloResp] send msf hello fail, retCode: ");
        sb5.append(fromServiceMsg != null ? Integer.valueOf(fromServiceMsg.getResultCode()) : null);
        QLog.d(f249635i, 1, sb5.toString());
    }

    private final void b(long j3) {
        if (j3 < 180000 || j3 > 3600000) {
            return;
        }
        this.f249654b = (int) j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MSFProbeNewManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final boolean b(String str) {
        return Intrinsics.areEqual(BaseConstants.CMD_NT_SSO_HEART_BEAT, str) || Intrinsics.areEqual(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC, str) || Intrinsics.areEqual(BaseConstants.CMD_STATUS_SVC_MSF_HELLO, str);
    }

    private final void a(Intent intent) {
        int intExtra = intent.getIntExtra(MSFAlarmManager.f249603g, -1);
        if (intExtra == -1) {
            QLog.w(f249635i, 1, "onRecvAlarmBroadcast, get Id:" + intExtra + " from intent is invalid");
            return;
        }
        long longExtra = intent.getLongExtra(MSFAlarmManager.f249606j, 0L);
        long longExtra2 = intent.getLongExtra(MSFAlarmManager.f249605i, 0L);
        long longExtra3 = intent.getLongExtra(MSFAlarmManager.f249607k, 0L) - longExtra;
        long j3 = longExtra2 - longExtra3;
        QLog.d(f249635i, 1, "onRecvAlarm, id:" + intExtra + ", registerTime:" + longExtra + ", elapse:" + longExtra3 + ", waitTime:" + longExtra2 + ", miss:" + j3);
        a(intExtra, longExtra2, j3);
        if (j3 > 0) {
            if (j3 < 5000) {
                Boolean I = com.tencent.mobileqq.msf.core.x.d.I();
                Intrinsics.checkNotNullExpressionValue(I, "getMSFProbeEnableWakeLock()");
                if (I.booleanValue()) {
                    a((int) j3);
                }
                this.f249658f.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.msf.core.push.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        MSFProbeNewManager.b(MSFProbeNewManager.this);
                    }
                }, j3);
                return;
            }
            if (a(intExtra, j3)) {
                return;
            }
        }
        g();
    }

    private final boolean a(int i3, long j3) {
        MSFAlarmManager.c cVar = MSFAlarmManager.f249601e;
        cVar.a().a(i3);
        return cVar.a().a(i3, j3, this.f249659g);
    }

    private final void a(int i3) {
        if (com.tencent.mobileqq.msf.core.x.d.I().booleanValue()) {
            if (this.f249655c == null) {
                this.f249655c = new com.tencent.mobileqq.msf.core.h0.a();
            }
            if (i3 > 0) {
                QLog.d(f249635i, 1, "tryWakeLock, lockTime:" + i3 + "ms");
                com.tencent.mobileqq.msf.core.h0.a aVar = this.f249655c;
                if (aVar != null) {
                    aVar.a(i3);
                }
            }
        }
    }

    private final void a(final int i3, final long j3, final long j16) {
        q.q().post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.push.j
            @Override // java.lang.Runnable
            public final void run() {
                MSFProbeNewManager.a(MSFProbeNewManager.this, i3, j3, j16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MSFProbeNewManager this$0, int i3, long j3, long j16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            com.tencent.mobileqq.msf.core.c0.j statReporter = this$0.f249653a.getStatReporter();
            if (statReporter == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("alarm_id", String.valueOf(i3));
            hashMap.put("alarm_wait_time", String.valueOf(j3));
            if (j16 >= 0) {
                hashMap.put(f249638l, String.valueOf(j16));
            } else {
                hashMap.put(f249639m, String.valueOf(-j16));
            }
            hashMap.put(f249640n, String.valueOf(com.tencent.mobileqq.msf.core.x.d.I()));
            statReporter.a(f249641o, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Exception e16) {
            QLog.e(f249635i, 1, "reportOnAlarm, exception:" + e16.getMessage());
        }
    }

    private final byte[] a(byte[] bArr) {
        int length = bArr.length - 4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 4, bArr2, 0, length);
        return bArr2;
    }

    private final boolean a(String str) {
        return str == null || Intrinsics.areEqual(str, "0");
    }
}
