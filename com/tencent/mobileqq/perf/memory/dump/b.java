package com.tencent.mobileqq.perf.memory.dump;

import android.app.ActivityManager;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.memory.collect.a;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0002J%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/b;", "", "Lkotlin/Pair;", "", "", "", "c", "", "needWrite", "a", "(Z)Ljava/util/Map;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final b f257725a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257725a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Map b(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return bVar.a(z16);
    }

    private final Pair<String, Map<String, Integer>> c() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BaseInfo, scene:" + SceneTracker.f() + ", apiVersion:" + Build.VERSION.SDK_INT + ", model:" + DeviceInfoMonitor.getModel() + ", manufacturer:" + Build.MANUFACTURER + ", appVersion:" + AppSetting.j(MobileQQ.sMobileQQ) + '\n');
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null) {
            Iterator<T> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                sb5.append("ProcessInfo, " + ((ActivityManager.RunningAppProcessInfo) it.next()).processName + '\n');
            }
        }
        com.tencent.mobileqq.perf.memory.collect.a c16 = a.Companion.c(com.tencent.mobileqq.perf.memory.collect.a.INSTANCE, null, true, 1, null);
        sb5.append("System Memory, " + c16.d() + '\n');
        sb5.append("Java   Memory, " + c16.a().k() + '\n');
        sb5.append("Native Memory, " + c16.b() + '\n');
        sb5.append("Pss distribution:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, Integer.valueOf(c16.c().i()));
        linkedHashMap.put(MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, Integer.valueOf(c16.c().b()));
        linkedHashMap.put(MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, Integer.valueOf(c16.c().e()));
        linkedHashMap.put(MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, Integer.valueOf(c16.c().f()));
        linkedHashMap.put("swappedPss", Integer.valueOf(c16.c().h()));
        linkedHashMap.put("codePss", Integer.valueOf(c16.c().a()));
        linkedHashMap.put("graphicPss", Integer.valueOf(c16.c().c()));
        linkedHashMap.put("totalPssModified", Integer.valueOf(c16.c().d()));
        linkedHashMap.putAll(c16.c().g());
        if (runningAppProcesses != null) {
            i3 = runningAppProcesses.size();
        } else {
            i3 = 0;
        }
        linkedHashMap.put("processNum", Integer.valueOf(i3));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            sb5.append('\n' + ((String) entry.getKey()) + ':' + ((Number) entry.getValue()).intValue());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "memoryInfo.toString()");
        return new Pair<>(sb6, linkedHashMap);
    }

    @NotNull
    public final Map<String, Integer> a(boolean needWrite) {
        BufferedWriter bufferedWriter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, needWrite);
        }
        QLog.d("MemoryFileDump", 1, "dump memory info begin");
        Pair<String, Map<String, Integer>> c16 = c();
        QLog.d("MemoryFileDump", 1, "dump memory info, \n" + c16.getFirst());
        if (needWrite) {
            String d16 = a.f257721a.d();
            MemoryFile.f257700a.b(d16);
            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(d16)), Charsets.UTF_8);
            if (outputStreamWriter instanceof BufferedWriter) {
                bufferedWriter = (BufferedWriter) outputStreamWriter;
            } else {
                bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
            }
            try {
                bufferedWriter.write(c16.getFirst());
                bufferedWriter.flush();
                QLog.d("MemoryFileDump", 1, "write memory info success, dumpPath\uff1a" + d16);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
            } finally {
            }
        }
        return c16.getSecond();
    }
}
