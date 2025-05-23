package com.tencent.mobileqq.processkiller;

import android.app.Application;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.processkiller.config.ProcessExitConfigProcessor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00028\u0006B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010-R\u0014\u00105\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/processkiller/ProcessMonitor;", "Landroid/os/Handler$Callback;", "", "f", "k", "b", "a", "", h.F, "i", "e", "Lcom/tencent/mobileqq/processkiller/ProcessMonitor$a;", "killMethod", "j", "isEmpty", "g", "c", "d", "Landroid/os/Message;", "msg", "handleMessage", "Z", "hasDoubleReport", "Landroid/app/Application;", "Landroid/app/Application;", "application", "Lcom/tencent/mobileqq/processkiller/config/a;", "Lcom/tencent/mobileqq/processkiller/config/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/processkiller/ProcessMonitor$a;", "killProcessInterface", "Landroid/os/Handler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Handler;", "monitorHandler", "", BdhLogUtil.LogTag.Tag_Conn, "I", "lastMemory", "", "D", UserInfo.SEX_FEMALE, "lastCPU", "", "E", "J", "getStartMonitorTime", "()J", "setStartMonitorTime", "(J)V", "startMonitorTime", "cpuSampleInterval", "G", "memorySampleInterval", "<init>", "()V", "Command", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProcessMonitor implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private static int lastMemory;

    /* renamed from: D, reason: from kotlin metadata */
    private static float lastCPU;

    /* renamed from: E, reason: from kotlin metadata */
    private static long startMonitorTime;

    /* renamed from: F, reason: from kotlin metadata */
    private static final long cpuSampleInterval;

    /* renamed from: G, reason: from kotlin metadata */
    private static final long memorySampleInterval;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final ProcessMonitor f259724d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasDoubleReport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Application application;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.processkiller.config.a config;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a killProcessInterface;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler monitorHandler;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/processkiller/ProcessMonitor$Command;", "", "(Ljava/lang/String;I)V", "Start", PreDownloadConstants.RPORT_KEY_CPU, "Memory", "KillProcess", "End", "DOUBLE_CHECK", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Command {
        private static final /* synthetic */ Command[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Command CPU;
        public static final Command DOUBLE_CHECK;
        public static final Command End;
        public static final Command KillProcess;
        public static final Command Memory;
        public static final Command Start;

        private static final /* synthetic */ Command[] $values() {
            return new Command[]{Start, CPU, Memory, KillProcess, End, DOUBLE_CHECK};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47262);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Start = new Command("Start", 0);
            CPU = new Command(PreDownloadConstants.RPORT_KEY_CPU, 1);
            Memory = new Command("Memory", 2);
            KillProcess = new Command("KillProcess", 3);
            End = new Command("End", 4);
            DOUBLE_CHECK = new Command("DOUBLE_CHECK", 5);
            $VALUES = $values();
        }

        Command(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Command valueOf(String str) {
            return (Command) Enum.valueOf(Command.class, str);
        }

        public static Command[] values() {
            return (Command[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/processkiller/ProcessMonitor$a;", "", "", "a", "", "b", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a();

        boolean b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        ProcessMonitor processMonitor = new ProcessMonitor();
        f259724d = processMonitor;
        application = BaseApplication.getContext();
        config = ProcessExitConfigProcessor.INSTANCE.a();
        monitorHandler = new Handler(QQPerfHandlerThreadManager.INSTANCE.d().getLooper(), processMonitor);
        lastMemory = -1;
        lastCPU = -1.0f;
        cpuSampleInterval = config.a() * 1000;
        memorySampleInterval = config.e() * 1000;
    }

    ProcessMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        HashMap hashMapOf;
        int b16 = b.b(application, "zplan");
        if (b16 == -1) {
            return;
        }
        float g16 = CpuUtil.f258160a.g(b16);
        Debug.MemoryInfo l3 = MemoryUtil.l(b16);
        QLog.d("ProcessMonitor", 1, "double check: cpu -> " + g16 + ", memory -> " + l3.getTotalPss());
        if (!hasDoubleReport) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("cpu", String.valueOf(g16)), TuplesKt.to("memory", String.valueOf(l3.getTotalPss())));
            b.c("double_checker", hashMapOf);
            hasDoubleReport = true;
        }
        if (config.c() == 1) {
            k();
        }
    }

    private final void b() {
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "endMonitor");
        }
        for (Command command : Command.values()) {
            monitorHandler.removeMessages(command.ordinal());
        }
    }

    private final void f() {
        HashMap hashMapOf;
        a aVar = killProcessInterface;
        if (aVar != null) {
            boolean b16 = aVar.b();
            QLog.i("ProcessMonitor", 1, "canIKillIt: " + b16 + ", config: " + config.d());
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("canIKill", String.valueOf(b16)), TuplesKt.to("memory", String.valueOf(lastMemory)), TuplesKt.to("cpu", String.valueOf(lastCPU)));
            b.c("before_kill_perf", hashMapOf);
            if (!b16) {
                return;
            }
            int d16 = config.d();
            if (d16 != 1) {
                if (d16 == 2) {
                    a aVar2 = killProcessInterface;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    b.d("kill_process", null, 2, null);
                }
            } else {
                SystemMethodProxy.killProcess(b.b(application, "zplan"));
                b.d("kill_process", null, 2, null);
            }
            f259724d.b();
            monitorHandler.sendEmptyMessageDelayed(Command.DOUBLE_CHECK.ordinal(), 15000L);
        }
    }

    private final boolean h() {
        float g16 = CpuUtil.f258160a.g(b.b(application, "zplan")) * 100;
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "Sample CPU: " + g16);
        }
        lastCPU = g16;
        if (g16 > config.b()) {
            QLog.i("ProcessMonitor", 1, "sample CPU: " + g16 + " > " + config.b() + ", will kill process");
            f();
            return true;
        }
        return false;
    }

    private final boolean i() {
        Debug.MemoryInfo l3 = MemoryUtil.l(b.b(application, "zplan"));
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "sampleMemory: cur->" + l3.getTotalPss() + ", last-> " + lastMemory);
        }
        int totalPss = l3.getTotalPss();
        int i3 = lastMemory;
        if (totalPss != i3 && i3 != -1) {
            lastMemory = l3.getTotalPss();
            if (l3.getTotalPss() <= config.f()) {
                return false;
            }
            QLog.i("ProcessMonitor", 1, "sample CPU: " + l3.getTotalPss() + " > " + config.f() + ", will kill process");
            f();
            return true;
        }
        lastMemory = l3.getTotalPss();
        return false;
    }

    private final void k() {
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "startMonitor");
        }
        startMonitorTime = System.currentTimeMillis();
        lastMemory = -1;
        Handler handler = monitorHandler;
        handler.sendEmptyMessageDelayed(Command.Memory.ordinal(), memorySampleInterval);
        handler.sendEmptyMessageDelayed(Command.CPU.ordinal(), cpuSampleInterval);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "enterBackground");
        }
        Handler handler = monitorHandler;
        handler.sendEmptyMessage(Command.Start.ordinal());
        handler.sendEmptyMessageDelayed(Command.End.ordinal(), config.g() * 1000);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "enterForeground");
        }
        monitorHandler.sendEmptyMessage(Command.End.ordinal());
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (killProcessInterface != null) {
            return true;
        }
        return false;
    }

    public final void g(boolean isEmpty) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isEmpty);
            return;
        }
        if (config.h() && MobileQQ.sProcessId == 1 && e()) {
            if (isEmpty) {
                c();
            } else {
                d();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("ProcessMonitor", 1, "handle Message: " + msg2.what);
        }
        if (b.b(application, "zplan") == -1) {
            QLog.d("ProcessMonitor", 1, "handler Message but ZPlan not Exist.");
            b();
            return true;
        }
        int i3 = msg2.what;
        if (i3 == Command.Start.ordinal()) {
            k();
        } else if (i3 == Command.End.ordinal()) {
            b();
        } else {
            Command command = Command.CPU;
            if (i3 == command.ordinal()) {
                if (!h()) {
                    monitorHandler.sendEmptyMessageDelayed(command.ordinal(), cpuSampleInterval);
                }
            } else {
                Command command2 = Command.Memory;
                if (i3 == command2.ordinal()) {
                    if (!i()) {
                        monitorHandler.sendEmptyMessageDelayed(command2.ordinal(), memorySampleInterval);
                    }
                } else if (i3 == Command.KillProcess.ordinal()) {
                    f();
                } else if (i3 == Command.DOUBLE_CHECK.ordinal()) {
                    a();
                }
            }
        }
        return true;
    }

    public final void j(@NotNull a killMethod) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) killMethod);
        } else {
            Intrinsics.checkNotNullParameter(killMethod, "killMethod");
            killProcessInterface = killMethod;
        }
    }
}
