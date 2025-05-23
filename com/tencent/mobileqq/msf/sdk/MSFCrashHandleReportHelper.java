package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ThreadUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCrashHandleReportHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_CRASH_COUNT = "crashcount";
    private static final String KEY_SHOULD_STOP_MSF = "shouldStopMsf";
    private static final String KEY_START_TIME = "starttime";
    private static final String SP_MSF_CRASH_CONTROL = "msf_crashcontrol";
    private static final String TAG = "MSF.C.CrashReport";
    private static final SimpleDateFormat simpleDateFormat;
    private final b crashControl;
    private final StringBuilder crashControlInfo;
    private boolean shouldStopMsf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f250467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f250468b;

        a(boolean z16, String str) {
            this.f250467a = z16;
            this.f250468b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MSFCrashHandleReportHelper.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.msf.core.k.c().a(this.f250467a, this.f250468b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final MSFCrashHandleReportHelper f250473a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24221);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250473a = new MSFCrashHandleReportHelper();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            simpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
        }
    }

    public MSFCrashHandleReportHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.crashControl = new b(null);
        this.crashControlInfo = new StringBuilder("\nMsf Crash Control info:\n");
        this.shouldStopMsf = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doCrashControl() {
        boolean z16;
        String str;
        int i3;
        if (!this.crashControl.f250470a) {
            QLog.d(TAG, 1, "doCrashControl crash control is off..");
            return;
        }
        SharedPreferences a16 = com.tencent.mobileqq.msf.core.b0.a.b().a(SP_MSF_CRASH_CONTROL, true);
        if (a16 == null) {
            QLog.d(TAG, 1, "doCrashControl crash control get SharedPreferences null..");
            return;
        }
        long j3 = a16.getLong("starttime", 0L);
        int i16 = a16.getInt(KEY_CRASH_COUNT, 0);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = this.crashControlInfo;
        sb5.append("doCrashControl startTime=");
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        sb5.append(simpleDateFormat2.format(new Date(j3)));
        sb5.append(",currenttime=");
        sb5.append(simpleDateFormat2.format(new Date(currentTimeMillis)));
        sb5.append(",crashCount=");
        sb5.append(i16);
        sb5.append("\n");
        if (j3 > 0 && currentTimeMillis > j3 && i16 >= 0) {
            str = "starttime";
            z16 = true;
            z16 = true;
            if (currentTimeMillis - j3 <= this.crashControl.f250471b * 1000) {
                i3 = i16 + 1;
                if (i3 > this.crashControl.f250472c) {
                    this.shouldStopMsf = z16;
                }
                if (this.shouldStopMsf) {
                    QLog.d(TAG, 1, "doCrashControl crashCount=" + i3 + ",shouldStopMsf=" + this.shouldStopMsf);
                    MsfService.getCore().getStatReporter().a(i3);
                    BaseApplication context = BaseApplication.getContext();
                    context.stopService(new Intent(context, (Class<?>) MsfService.class));
                }
                StringBuilder sb6 = this.crashControlInfo;
                sb6.append("doCrashControl shouldStopMsf=");
                sb6.append(this.shouldStopMsf);
                sb6.append("\n");
                a16.edit().putLong(str, j3).putInt(KEY_CRASH_COUNT, i3).putBoolean(KEY_SHOULD_STOP_MSF, this.shouldStopMsf).apply();
            }
        } else {
            z16 = true;
            str = "starttime";
        }
        j3 = currentTimeMillis;
        i3 = z16 ? 1 : 0;
        if (i3 > this.crashControl.f250472c) {
        }
        if (this.shouldStopMsf) {
        }
        StringBuilder sb62 = this.crashControlInfo;
        sb62.append("doCrashControl shouldStopMsf=");
        sb62.append(this.shouldStopMsf);
        sb62.append("\n");
        a16.edit().putLong(str, j3).putInt(KEY_CRASH_COUNT, i3).putBoolean(KEY_SHOULD_STOP_MSF, this.shouldStopMsf).apply();
    }

    private void doOnCrashSave(boolean z16, String str) {
        com.tencent.mobileqq.msf.core.q.s().post(new a(z16, str));
    }

    private void initCrashControl() {
        String b06 = com.tencent.mobileqq.msf.core.x.b.b0();
        if (!TextUtils.isEmpty(b06)) {
            try {
                JSONObject jSONObject = new JSONObject(b06);
                this.crashControl.f250470a = jSONObject.getBoolean("control_switch");
                this.crashControl.f250471b = jSONObject.getInt("control_window");
                this.crashControl.f250472c = jSONObject.getInt("control_freq");
            } catch (Throwable unused) {
                this.crashControl.a();
                QLog.d(TAG, 1, "initCrashControl parse json throws an exception, so reset.");
            }
        }
        StringBuilder sb5 = this.crashControlInfo;
        sb5.append("initCrashControl");
        sb5.append(",controlJson=");
        sb5.append(b06);
        sb5.append(",switch=");
        sb5.append(this.crashControl.f250470a);
        sb5.append(",window=");
        sb5.append(this.crashControl.f250471b);
        sb5.append(",Freq=");
        sb5.append(this.crashControl.f250472c);
        sb5.append("\n");
    }

    public static MSFCrashHandleReportHelper instance() {
        return c.f250473a;
    }

    public byte[] getCrashExtraData(boolean z16, String str, String str2, String str3, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return null;
    }

    public String getCrashExtraMessage(boolean z16, String str, String str2, String str3, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
        }
        QLog.d(TAG, 1, "getCrashExtraMessage...isNativeCrashed: " + z16 + " crashType=" + str + " crashAddress=" + str2 + " crashStack=" + str3 + " native_SICODE=" + i3 + " crashTime=" + j3);
        QLog.flushLog(true);
        if (str.contains("OutOfMemory")) {
            ThreadUtils.dumpThreadInfo(this.crashControlInfo);
            StringBuilder sb5 = this.crashControlInfo;
            sb5.append("\n:heapMax=");
            sb5.append(Runtime.getRuntime().maxMemory());
            StringBuilder sb6 = this.crashControlInfo;
            sb6.append(",heapTotal=");
            sb6.append(Runtime.getRuntime().totalMemory());
            StringBuilder sb7 = this.crashControlInfo;
            sb7.append(",heapFree=");
            sb7.append(Runtime.getRuntime().freeMemory());
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCrashExtraMessage." + ((Object) this.crashControlInfo));
        }
        return this.crashControlInfo.toString();
    }

    public void initCrashReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        StringBuilder sb5 = this.crashControlInfo;
        sb5.append("\nCurrent process id=");
        sb5.append(Process.myPid());
        sb5.append("\n");
    }

    public boolean onCrashHandleEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, z16)).booleanValue();
        }
        return true;
    }

    public void onCrashHandleStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 1, "onCrashHandleStart...isNativeCrashed: " + z16);
        initCrashControl();
        doCrashControl();
    }

    public boolean onCrashSaving(boolean z16, String str, String str2, String str3, int i3, long j3, String str4, String str5, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), str4, str5, str6, str7)).booleanValue();
        }
        doOnCrashSave(z16, str3);
        if (!z16 && "java.util.concurrent.TimeoutException".equals(str) && !TextUtils.isEmpty(str3) && str3.contains("java.lang.Daemons$FinalizerDaemon")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f250470a;

        /* renamed from: b, reason: collision with root package name */
        int f250471b;

        /* renamed from: c, reason: collision with root package name */
        int f250472c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f250470a = true;
            this.f250471b = 86400;
            this.f250472c = 20;
        }

        void a() {
            this.f250470a = true;
            this.f250471b = 86400;
            this.f250472c = 20;
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
