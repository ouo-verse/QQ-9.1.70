package com.tencent.mobileqq.perf.process.foregroud;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.process.config.e;
import com.tencent.mobileqq.perf.process.foregroud.ProcessExitManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.cq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/perf/process/foregroud/ProcessExitManager;", "Landroid/os/Handler$Callback;", "", "f", "Landroid/os/Message;", "msg", "", "handleMessage", "Lcom/tencent/mobileqq/perf/process/foregroud/ProcessExitManager$FromTag;", "fromTag", "d", "b", "g", "c", "e", "Lcom/tencent/mobileqq/perf/process/foregroud/ProcessExitManager$FromTag;", "currentTag", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "FromTag", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProcessExitManager implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final ProcessExitManager f257912d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static FromTag currentTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/perf/process/foregroud/ProcessExitManager$FromTag;", "", "(Ljava/lang/String;I)V", "LowMemory", "RMonitor", "RegularCheck", "PreloadCheck", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class FromTag {
        private static final /* synthetic */ FromTag[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FromTag LowMemory;
        public static final FromTag PreloadCheck;
        public static final FromTag RMonitor;
        public static final FromTag RegularCheck;

        private static final /* synthetic */ FromTag[] $values() {
            return new FromTag[]{LowMemory, RMonitor, RegularCheck, PreloadCheck};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32154);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LowMemory = new FromTag("LowMemory", 0);
            RMonitor = new FromTag("RMonitor", 1);
            RegularCheck = new FromTag("RegularCheck", 2);
            PreloadCheck = new FromTag("PreloadCheck", 3);
            $VALUES = $values();
        }

        FromTag(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FromTag valueOf(String str) {
            return (FromTag) Enum.valueOf(FromTag.class, str);
        }

        public static FromTag[] values() {
            return (FromTag[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ProcessExitManager processExitManager = new ProcessExitManager();
        f257912d = processExitManager;
        currentTag = FromTag.RegularCheck;
        handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), processExitManager);
    }

    ProcessExitManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FromTag fromTag) {
        Intrinsics.checkNotNullParameter(fromTag, "$fromTag");
        if (e.INSTANCE.b().f()) {
            GuardManager guardManager = GuardManager.sInstance;
            boolean z16 = false;
            if (guardManager != null && guardManager.isApplicationForeground()) {
                z16 = true;
            }
            if (z16) {
                f257912d.f();
                QLog.i("ProcessExitManager", 1, "exitIdleProcess, from:" + fromTag);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProcessExitManager", 2, "exitIdleProcess, switch is false");
        }
    }

    private final void f() {
        Intent intent = new Intent("com.tencent.process.is.idle");
        intent.putExtra("process_verify", cq.c(null, false));
        BaseApplication.context.sendBroadcast(intent);
    }

    public final void b(@NotNull FromTag fromTag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fromTag);
            return;
        }
        Intrinsics.checkNotNullParameter(fromTag, "fromTag");
        e.Companion companion = e.INSTANCE;
        if (!companion.b().f()) {
            QLog.i("ProcessExitManager", 1, "checkIdleProcessRegular, switch is false");
            return;
        }
        FromTag fromTag2 = FromTag.RegularCheck;
        if (fromTag == fromTag2 || currentTag == fromTag2) {
            if (QLog.isColorLevel()) {
                QLog.i("ProcessExitManager", 2, "checkIdleProcessRegular, from:" + fromTag + ", currentTag:" + currentTag);
            }
            d(fromTag);
            int d16 = companion.b().d() * 60 * 1000;
            Handler handler2 = handler;
            handler2.removeMessages(1);
            handler2.sendEmptyMessageDelayed(1, d16);
        }
    }

    public final void c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
        boolean b16 = bVar.b();
        boolean z17 = false;
        if (b16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && peekAppRuntime.isProcessIdle()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            QLog.i("ProcessExitManager", 1, "checkProcessIdleIndeed, idle state, " + MobileQQ.processName);
            com.tencent.mobileqq.perf.process.foregroud.report.a aVar = com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a;
            String processName = MobileQQ.processName;
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            aVar.c(processName);
            bVar.e();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProcessExitManager", 1, "checkProcessIdleIndeed, noActivityInProcess:" + b16 + ", isProcessIdle:false, processName:" + MobileQQ.processName);
        }
    }

    public final void d(@NotNull final FromTag fromTag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromTag);
            return;
        }
        Intrinsics.checkNotNullParameter(fromTag, "fromTag");
        currentTag = fromTag;
        if (!Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
            QLog.i("ProcessExitManager", 1, "exitIdleProcess, no in main process, from:" + fromTag);
            return;
        }
        com.tencent.mobileqq.perf.process.util.b.f257946a.p(new Runnable() { // from class: com.tencent.mobileqq.perf.process.foregroud.a
            @Override // java.lang.Runnable
            public final void run() {
                ProcessExitManager.e(ProcessExitManager.FromTag.this);
            }
        });
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Intent intent = new Intent("com.tencent.process.trigger.exit");
        intent.putExtra("process_verify", cq.c(null, false));
        BaseApplication.context.sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.i("ProcessExitManager", 2, "triggerExitFromOtherProcess");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            b(FromTag.RegularCheck);
        }
        return true;
    }
}
