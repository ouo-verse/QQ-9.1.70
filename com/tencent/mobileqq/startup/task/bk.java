package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ek;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.builder.QLogConfig;
import com.tencent.qphone.base.util.report.IQLogReport;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bk;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", "b", TencentLocation.RUN_MODE, "", "blockUntilFinish", "", "d", "Ljava/lang/String;", "TAG", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bk extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/startup/task/bk$a", "Lcom/tencent/qphone/base/util/QLog$ILogCallback;", "", "tag", "msg", "", "onWriteLog", "", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements QLog.ILogCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ek.d(tag);
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@NotNull String tag, @NotNull byte[] msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ek.d(tag);
        }
    }

    public bk() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "QLogInitTask";
        }
    }

    private final void b(Context context) {
        long j3;
        QLogConfig.Builder buildNumber = new QLogConfig.Builder().setAppContext(context).setDebug(false).setPublish(true).setGray(false).setProcessName(BaseApplication.processName).setPackageName(MobileQQ.PACKAGE_NAME).setBuildNumber(AppSetting.f99553m);
        if (MobileQQ.sProcessId == 1) {
            j3 = 3000;
        } else {
            j3 = 0;
        }
        QLog.init(buildNumber.setDelayInit(j3).setIs64Bit(true).setUseXlog(true).setQLogConfigBeanSwitchKey("QLogConfig_C").setQLogReport(new IQLogReport() { // from class: com.tencent.mobileqq.startup.task.bj
            @Override // com.tencent.qphone.base.util.report.IQLogReport
            public final void sendToBeacon(String str, HashMap hashMap) {
                bk.c(str, hashMap);
            }
        }).build());
        QLog.i(this.TAG, 1, "AppSetting.isPublicVersion=true, useXLog=true");
        if (MobileQQ.sProcessId == 1) {
            QLog.setLogCallback(new a());
        }
        com.tencent.qqnt.startup.utils.a.f362281a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String str, HashMap hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance("", str, true, 0L, 0L, (HashMap<String, String>) hashMap, "", false);
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            b(context);
            if (MobileQQ.sProcessId == 1) {
                CrashDefendManager.i().k();
            }
        } catch (Throwable th5) {
            Log.e(this.TAG, "initQLog error! " + Log.getStackTraceString(th5));
        }
    }
}
