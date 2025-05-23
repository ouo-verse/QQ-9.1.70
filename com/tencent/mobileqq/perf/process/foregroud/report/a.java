package com.tencent.mobileqq.perf.process.foregroud.report;

import android.app.ActivityManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.perf.process.config.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002J2\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/perf/process/foregroud/report/a;", "", "", "processName", "", "b", "", "canPreload", "Landroid/app/ActivityManager$MemoryInfo;", "memoryInfo", "e", "Lcom/tencent/mobileqq/perf/process/foregroud/session/a;", SessionDbHelper.SESSION_ID, "d", "(Lcom/tencent/mobileqq/perf/process/foregroud/session/a;)V", "process", "c", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "a", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257918a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f257918a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String eventName, @NotNull HashMap<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eventName, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, eventName, true, 0L, 0L, params, "");
    }

    public final void b(@NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) processName);
            return;
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", processName);
        if (QLog.isColorLevel()) {
            QLog.d("ProcessPreloadManager_EffectReport", 2, "reportIllegalPreloadProcess, " + hashMap);
        }
        f257918a.a("report_illegal_preload", hashMap);
    }

    public final void c(@NotNull String process) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) process);
            return;
        }
        Intrinsics.checkNotNullParameter(process, "process");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", process);
        f257918a.a("report_process_exit", hashMap);
    }

    public final void d(@NotNull com.tencent.mobileqq.perf.process.foregroud.session.a session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) session);
            return;
        }
        Intrinsics.checkNotNullParameter(session, "session");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", String.valueOf(session.d()));
        hashMap.put(TagName.ENTRY_NAME, String.valueOf(session.c()));
        hashMap.put("isHit", String.valueOf(session.f()));
        if (QLog.isColorLevel()) {
            QLog.d("ProcessPreloadManager_EffectReport", 2, "reportProcessPreload, " + hashMap);
        }
        f257918a.a("report_process_preload", hashMap);
    }

    public final void e(@NotNull String processName, boolean canPreload, @Nullable ActivityManager.MemoryInfo memoryInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, processName, Boolean.valueOf(canPreload), memoryInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", processName);
        hashMap.put("canPreload", String.valueOf(canPreload));
        if (memoryInfo != null) {
            long j3 = 1024;
            hashMap.put("totalMem", String.valueOf((memoryInfo.totalMem / j3) / j3));
            hashMap.put("availMem", String.valueOf((memoryInfo.availMem / j3) / j3));
            hashMap.put("threshold", String.valueOf((memoryInfo.threshold / j3) / j3));
            hashMap.put(HippyReporter.RemoveEngineReason.LOW_MEMORY, String.valueOf(memoryInfo.lowMemory));
            e.Companion companion = e.INSTANCE;
            hashMap.put("configRatio", String.valueOf(companion.b().g()));
            hashMap.put("configThreshold", String.valueOf(companion.b().h()));
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProcessPreloadManager_EffectReport", 2, "reportProcessPreloadState, " + hashMap);
        }
        f257918a.a("report_process_preload_info", hashMap);
    }
}
