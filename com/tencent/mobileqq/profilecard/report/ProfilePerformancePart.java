package com.tencent.mobileqq.profilecard.report;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.b;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfilePerformancePart;", "Lcom/tencent/biz/richframework/part/Part;", "()V", "enterAvailMemory", "", "fpsMonitor", "Lcom/tencent/mobileqq/profilecard/report/ProfileFpsMonitor;", "hasEnd", "", "hasStart", "monitorManager", "Lcom/tencent/biz/richframework/monitor/RFWMonitorManager;", "captureMemoryOnStable", "", "captureMemoryOnStart", "endMonitor", "scene", "", "getMemoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "onCreate", "onPartDestroy", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "startMonitor", "context", "Landroid/content/Context;", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfilePerformancePart extends Part {
    static IPatchRedirector $redirector_;
    private long enterAvailMemory;

    @NotNull
    private final ProfileFpsMonitor fpsMonitor;
    private boolean hasEnd;
    private boolean hasStart;

    @NotNull
    private final RFWMonitorManager monitorManager;

    public ProfilePerformancePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.monitorManager = new RFWMonitorManager();
            this.fpsMonitor = new ProfileFpsMonitor();
        }
    }

    private final ActivityManager.MemoryInfo getMemoryInfo() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = applicationContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final void captureMemoryOnStable() {
        ActivityManager.MemoryInfo memoryInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null || !(qBaseActivity instanceof FriendProfileCardActivity) || (memoryInfo = getMemoryInfo()) == null) {
            return;
        }
        long j3 = this.enterAvailMemory;
        long j16 = ((float) (j3 - memoryInfo.availMem)) / 1048576.0f;
        if (j3 > 0 && j16 > 0) {
            ProfilePerformanceHelper.reportMemoryIncrement(j16);
        }
    }

    public final void captureMemoryOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo();
        if (memoryInfo == null) {
            return;
        }
        this.enterAvailMemory = memoryInfo.availMem;
    }

    public final void endMonitor(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) scene);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.hasStart && !this.hasEnd) {
            this.hasEnd = true;
            this.monitorManager.stop();
            this.fpsMonitor.onEndFPSFrameMonitor(scene);
        }
    }

    public final void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.monitorManager.injectProxyImpl(this.fpsMonitor);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@org.jetbrains.annotations.Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            this.monitorManager.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        b.c(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        b.d(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        b.f(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        b.g(this, activity);
    }

    public final void startMonitor(@org.jetbrains.annotations.Nullable Context context, @NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) scene);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.hasStart) {
            return;
        }
        this.hasStart = true;
        if (context != null) {
            this.fpsMonitor.onBeginFPSFrameMonitor(scene);
            this.monitorManager.start(context);
        }
    }
}
