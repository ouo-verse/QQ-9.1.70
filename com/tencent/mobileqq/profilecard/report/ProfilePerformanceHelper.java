package com.tencent.mobileqq.profilecard.report;

import com.tencent.mobileqq.profilecard.api.IProfileTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0003J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfilePerformanceHelper;", "", "()V", "delayMemoryReport", "", "delayRefreshUI", "keyFpsOnDraw", "", "keyFpsOnScroll", "keyMemInc", "keyRefreshUICount", "sceneOnDraw", "sceneOnScroll", "tag", "isEnable", "", "reportFps", "", "scene", "fps", "", CacheTable.TABLE_NAME, "key", "value", "reportMemoryIncrement", "increment", "reportRefreshUICount", "count", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfilePerformanceHelper {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final ProfilePerformanceHelper INSTANCE;
    public static final long delayMemoryReport = 2000;
    public static final long delayRefreshUI = 3000;

    @NotNull
    public static final String keyFpsOnDraw = "page_fps_on_draw";

    @NotNull
    public static final String keyFpsOnScroll = "page_fps_on_scroll";

    @NotNull
    public static final String keyMemInc = "page_memory_increment";

    @NotNull
    public static final String keyRefreshUICount = "rerfresh_ui_count";

    @NotNull
    public static final String sceneOnDraw = "SceneOnDraw";

    @NotNull
    public static final String sceneOnScroll = "SceneOnScroll";

    @NotNull
    private static final String tag = "ProfilePerformanceHelper";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18671);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ProfilePerformanceHelper();
        }
    }

    ProfilePerformanceHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean isEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profilecard_performance_report_8973switch", false);
    }

    @JvmStatic
    public static final void reportFps(@NotNull String scene, int fps) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (Intrinsics.areEqual(scene, sceneOnDraw)) {
            reportInfo(keyFpsOnDraw, String.valueOf(fps));
        } else if (Intrinsics.areEqual(scene, sceneOnScroll)) {
            reportInfo(keyFpsOnScroll, String.valueOf(fps));
        }
    }

    @JvmStatic
    private static final void reportInfo(String key, String value) {
        QLog.i(tag, 1, "reportInfo,key=" + key + ",value=" + value);
        ((IProfileTracer) QRoute.api(IProfileTracer.class)).report(key, value);
    }

    @JvmStatic
    public static final void reportMemoryIncrement(long increment) {
        reportInfo(keyMemInc, String.valueOf(increment));
    }

    @JvmStatic
    public static final void reportRefreshUICount(int count) {
        reportInfo(keyRefreshUICount, String.valueOf(count));
    }
}
