package com.tencent.mobileqq.perf.tracker;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.memory.MemoryFlag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.Monitor;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.random.Random;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/c;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "c", "", "e", "Lcom/tencent/cache/api/Business;", "prevBusiness", "d", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "Z", "onForeground", "f", "J", "lastReportTime", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements IGuardInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f258237d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean onForeground;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastReportTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        c cVar = new c();
        f258237d = cVar;
        cVar.e();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        Business business;
        if (onForeground) {
            return;
        }
        Monitor monitor = Monitor.INSTANCE;
        if (monitor.getCurrentPageArgus() != null) {
            com.tencent.cache.api.d currentPageArgus = monitor.getCurrentPageArgus();
            Business business2 = null;
            if (currentPageArgus != null) {
                business = currentPageArgus.b();
            } else {
                business = null;
            }
            if (business == Business.Conversation) {
                if (lastReportTime != 0 && SystemClock.elapsedRealtime() - lastReportTime < 7200000) {
                    return;
                }
                lastReportTime = SystemClock.elapsedRealtime();
                c cVar = f258237d;
                com.tencent.cache.api.d prevPageArgus = monitor.getPrevPageArgus();
                if (prevPageArgus != null) {
                    business2 = prevPageArgus.b();
                }
                cVar.d(business2);
            }
        }
    }

    private final boolean c() {
        Business business;
        Monitor monitor = Monitor.INSTANCE;
        if (monitor.getCurrentPageArgus() != null) {
            com.tencent.cache.api.d currentPageArgus = monitor.getCurrentPageArgus();
            PageHierarchy pageHierarchy = null;
            if (currentPageArgus != null) {
                business = currentPageArgus.b();
            } else {
                business = null;
            }
            if (business == Business.Conversation) {
                com.tencent.cache.api.d currentPageArgus2 = monitor.getCurrentPageArgus();
                if (currentPageArgus2 != null) {
                    pageHierarchy = currentPageArgus2.c();
                }
                if (pageHierarchy == PageHierarchy.MainPage) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void d(Business prevBusiness) {
        List<MemoryFlag> listOf;
        com.tencent.cache.api.memory.d d16 = com.tencent.cache.api.memory.a.d(com.tencent.cache.api.memory.a.f98606b, null, false, 3, null);
        HashMap hashMap = new HashMap();
        hashMap.put("processLiveTime", String.valueOf(com.tencent.mobileqq.perf.process.util.b.f257946a.h()));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, String.valueOf(d16.i() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, String.valueOf(d16.e() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, String.valueOf(d16.b() / 1024));
        hashMap.put(MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, String.valueOf(d16.f() / 1024));
        hashMap.put("swapPss", String.valueOf(d16.h() / 1024));
        hashMap.put("codePss", String.valueOf(d16.a() / 1024));
        hashMap.put("dexMmapPss", String.valueOf(d16.g().get("dexMmap")));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MemoryFlag[]{MemoryFlag.OTHER_SO, MemoryFlag.OTHER_ART, MemoryFlag.OTHER_APK, MemoryFlag.OTHER_JAR, MemoryFlag.OTHER_OAT, MemoryFlag.OTHER_TTF, MemoryFlag.OTHER_DALVIK_OTHER});
        for (MemoryFlag memoryFlag : listOf) {
            hashMap.put(memoryFlag.getReportKey(), String.valueOf(d16.g().get(memoryFlag.getReportKey())));
        }
        if (prevBusiness != null) {
            hashMap.put("prevBusi", prevBusiness.name());
        }
        if (onForeground) {
            return;
        }
        PerfReportUtil.h("act_bg_mem", hashMap);
    }

    private final void e() {
        if (Random.INSTANCE.nextInt(MainProcConfig.INSTANCE.e().e()) != 0 || MobileQQ.sProcessId != 1 || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        QLog.d("BgMemTracker", 1, "start to track");
        GuardManagerCallbackDispatcher.registerCallBack(this);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (c() || com.tencent.mobileqq.perf.process.util.b.f257946a.h() < 150 || Random.INSTANCE.nextInt(MainProcConfig.INSTANCE.e().f()) != 0) {
                return;
            }
            onForeground = false;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.perf.tracker.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.b();
                }
            }, 16, null, true, 150000L);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            onForeground = true;
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, tick);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, tick);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, tick);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isEnabled);
        }
    }
}
