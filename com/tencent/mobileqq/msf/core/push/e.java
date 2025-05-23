package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.pb.MsfProbe;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends BroadcastReceiver implements com.tencent.mobileqq.msf.core.push.b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249661f = "MSF.C.MsfProbeManager";

    /* renamed from: g, reason: collision with root package name */
    private static final int f249662g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f249663h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final int f249664i = 4;

    /* renamed from: j, reason: collision with root package name */
    private static final long f249665j = 180000;

    /* renamed from: k, reason: collision with root package name */
    private static final long f249666k = 3600000;

    /* renamed from: l, reason: collision with root package name */
    private static final long f249667l = 450000;

    /* renamed from: m, reason: collision with root package name */
    private static long f249668m;

    /* renamed from: a, reason: collision with root package name */
    private final String f249669a;

    /* renamed from: b, reason: collision with root package name */
    private PendingIntent f249670b;

    /* renamed from: c, reason: collision with root package name */
    private final MsfCore f249671c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f249672d;

    /* renamed from: e, reason: collision with root package name */
    private String f249673e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements b.InterfaceC8070b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.auth.b.InterfaceC8070b
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.f249673e = str;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver f249675a;

        b(BroadcastReceiver broadcastReceiver) {
            this.f249675a = broadcastReceiver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) broadcastReceiver);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            BaseApplication.getContext().registerReceiver(this.f249675a, new IntentFilter(e.this.f249669a));
            e eVar = e.this;
            eVar.b(eVar.e());
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e eVar = e.this;
                eVar.b(eVar.e());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e eVar = e.this;
                eVar.b(eVar.e());
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.push.e$e, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class RunnableC8095e implements Runnable {
        static IPatchRedirector $redirector_;

        RunnableC8095e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e eVar = e.this;
                eVar.b(eVar.e());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements Runnable {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.f();
                e eVar = e.this;
                eVar.b(eVar.e());
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public e(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f249671c = msfCore;
        Handler h16 = q.h();
        this.f249672d = h16;
        this.f249673e = msfCore.getMainAccount();
        msfCore.getAccountCenter().a(new a());
        this.f249669a = MsfSdkUtils.getProcessName(BaseApplication.getContext()) + "_" + getClass().hashCode();
        h16.post(new b(this));
    }

    private long a(long j3) {
        return j3 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (a(this.f249673e)) {
            QLog.d(f249661f, 1, "cancel sendStatusSvcMsfHello because of no login, currentUin: " + this.f249673e);
            return;
        }
        boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
        if (isProcessExist) {
            QLog.d(f249661f, 1, "cancel sendStatusSvcMsfHello because of main process alive");
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("", this.f249673e, BaseConstants.CMD_STATUS_SVC_MSF_HELLO);
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setMsfCommand(MsfCommand._msf_hello);
        toServiceMsg.setRequestSsoSeq(this.f249671c.getNextSeq());
        toServiceMsg.setTimeout(30000L);
        MsfProbe.MsfHelloReq msfHelloReq = new MsfProbe.MsfHelloReq();
        msfHelloReq.main_process_status.set(isProcessExist ? 1 : 0);
        toServiceMsg.putWupBuffer(MsfSdkUtils.addByteLen(msfHelloReq.toByteArray()));
        this.f249671c.sendSsoMsg(toServiceMsg);
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            if (j3 < 180000 || j3 > 3600000) {
                return;
            }
            f249668m = j3;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(f249661f, 1, "onConnOpened");
            this.f249672d.post(new c());
        }
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        long j3 = f249668m;
        if (j3 == 0) {
            return f249667l;
        }
        return j3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) intent);
            return;
        }
        QLog.d(f249661f, 1, "MSF_Alive_Log alarm receive " + intent);
        if (!TextUtils.isEmpty(this.f249669a) && this.f249669a.equals(intent.getAction())) {
            this.f249672d.post(new f());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d(f249661f, 1, "onRegProxySvcSend");
            this.f249672d.post(new RunnableC8095e());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.d(f249661f, 1, "onNtHeartBeatSend");
            this.f249672d.post(new d());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j3) {
        AlarmManager alarmManager = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            QLog.d(f249661f, 1, "doRegisterAlarm error, get null alarmManager");
            return;
        }
        if (this.f249670b != null) {
            try {
                QLog.d(f249661f, 1, "cancel alarm, intent:" + this.f249670b);
                alarmManager.cancel(this.f249670b);
            } catch (Exception e16) {
                QLog.e(f249661f, 1, "cancel alarm error:" + e16.getMessage(), e16);
                BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), e16, "AlarmManagerCancelException", null);
            }
        }
        if (a(this.f249673e)) {
            QLog.d(f249661f, 1, "cancel doRegisterAlarm because of no login, currentUin: " + this.f249673e);
            return;
        }
        Intent intent = new Intent(this.f249669a);
        intent.setAction(this.f249669a);
        try {
            this.f249670b = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent, Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
        } catch (Throwable th5) {
            QLog.e(f249661f, 1, "doRegisterAlarm error:" + th5.getMessage(), th5);
        }
        long currentTimeMillis = System.currentTimeMillis() + j3;
        try {
            QLog.d(f249661f, 1, "register alarm with setAndAllowWhileIdle, intent:" + this.f249670b);
            Method declaredMethod = AlarmManager.class.getDeclaredMethod("setExactAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(alarmManager, 0, Long.valueOf(currentTimeMillis), this.f249670b);
        } catch (Throwable th6) {
            QLog.e(f249661f, 1, "doRegisterAlarm get setAndAllowWhileIdle method error!", th6);
            try {
                QLog.d(f249661f, 1, "register alarm, intent:" + this.f249670b);
                alarmManager.setExact(0, currentTimeMillis, this.f249670b);
            } catch (Throwable th7) {
                QLog.e(f249661f, 1, "doRegisterAlarm set alarm error!", th7);
            }
        }
        QLog.d(f249661f, 1, "register " + this.f249669a + " alarm alive send at " + MsfSdkUtils.timeMillisToDay(currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void a(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            try {
                MsfProbe.MsfHelloResp mergeFrom = new MsfProbe.MsfHelloResp().mergeFrom(a(fromServiceMsg.getWupBuffer()));
                if (mergeFrom.msf_hello_interval.has()) {
                    c(a(mergeFrom.msf_hello_interval.get()));
                }
                QLog.d(f249661f, 1, "[handleStatueSvsMsfHelloResp] receive msf hello response, timeInterval: " + mergeFrom.msf_hello_interval.get());
                return;
            } catch (Exception e16) {
                QLog.e(f249661f, 1, "[handleStatueSvsMsfHelloResp] parse MsfHelloResp error", e16);
                return;
            }
        }
        QLog.d(f249661f, 1, "[handleStatueSvsMsfHelloResp] send msf hello fail, retCode: " + fromServiceMsg.getResultCode());
    }

    private byte[] a(byte[] bArr) {
        int length = bArr.length - 4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 4, bArr2, 0, length);
        return bArr2;
    }

    private boolean a(String str) {
        return str == null || str.equals("0");
    }

    @Override // com.tencent.mobileqq.msf.core.push.b
    public void b(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            try {
                MsfProbe.MsfProbePush mergeFrom = new MsfProbe.MsfProbePush().mergeFrom(a(fromServiceMsg.getWupBuffer()));
                if (mergeFrom.msf_hello_interval.has()) {
                    c(a(mergeFrom.msf_hello_interval.get()));
                }
                QLog.d(f249661f, 1, "[handleMsfProbePush] receive MsfProbePush, timeInterval: " + mergeFrom.msf_hello_interval.get());
            } catch (Exception e16) {
                QLog.e(f249661f, 1, "[handleMsfProbePush] parse msfProbePush error", e16);
            }
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), BaseConstants.CMD_MSF_CONN_PROBE_ACK);
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setMsfCommand(MsfCommand.unknown);
        toServiceMsg.setRequestSsoSeq(this.f249671c.getNextSeq());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        MsfProbe.AckMsfProbeReq ackMsfProbeReq = new MsfProbe.AckMsfProbeReq();
        ackMsfProbeReq.main_process_status.set(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), BaseApplication.getContext().getPackageName()) ? 1 : 0);
        toServiceMsg.putWupBuffer(MsfSdkUtils.addByteLen(ackMsfProbeReq.toByteArray()));
        this.f249671c.sendSsoMsg(toServiceMsg);
        QLog.d(f249661f, 1, "[replyMsfProbePush] ", toServiceMsg.getStringForLog());
        b(e());
    }
}
