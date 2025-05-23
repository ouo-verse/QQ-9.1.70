package km;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.foregroud.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Lkm/a;", "", "Lmqq/app/AppRuntime;", "app", "", "from", "", "f", "g", "Landroid/content/Context;", "context", "processName", "", "c", "a", "b", "d", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412646a = new a();

    a() {
    }

    public final boolean a() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    public final boolean b(String processName) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        return MobileQQ.PACKAGE_NAME.equals(processName);
    }

    public final boolean c(Context context, String processName) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().processName, processName)) {
                if (!QZLog.isColorLevel()) {
                    return true;
                }
                QZLog.d("QZoneProcessManager", 2, "process exist " + processName);
                return true;
            }
        }
        return false;
    }

    public final void d() {
        if (a()) {
            QLog.d("QZoneProcessManager", 1, "killCurrentProcess fail, disable kill main process");
            return;
        }
        QLog.d("QZoneProcessManager", 1, "try to kill current process: " + BaseApplication.processName);
        SystemMethodProxy.killProcess(Process.myPid());
    }

    public final void e(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(processName, "processName");
        if (b(processName)) {
            QLog.d("QZoneProcessManager", 1, "killProcess fail, disable kill main process");
            return;
        }
        QLog.d("QZoneProcessManager", 1, "try to kill process: " + BaseApplication.processName);
        Utils.N(context, processName);
    }

    public final void f(AppRuntime app, String from) {
        if (c(BaseApplicationImpl.getApplication(), "com.tencent.mobileqq:qzone")) {
            QLog.d("QZoneProcessManager", 1, "preloadQzoneProcessSync fail, process exist");
        } else if (!b.f257916a.c("qzone_preload_entry", "com.tencent.mobileqq:qzone")) {
            QLog.d("QZoneProcessManager", 1, "preloadQzoneProcessSync fail: checkPreloadProcess false");
        } else {
            QZoneHelper.preloadQzone(app, from, null, false, true);
        }
    }

    public final void g() {
        try {
            if (c(BaseApplicationImpl.getApplication(), "com.tencent.mobileqq:tool")) {
                QLog.d("QZoneProcessManager", 2, "preloadToolProcessSync fail, process exist");
            } else if (!b.f257916a.c("qzone_preload_entry", "com.tencent.mobileqq:tool")) {
                QLog.d("QZoneProcessManager", 1, "preloadToolProcessSync fail: checkPreloadProcess false");
            } else {
                BaseApplicationImpl.getApplication().startService(new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPreloadWebServiceClass()));
            }
        } catch (Throwable th5) {
            QLog.e("QZoneProcessManager", 2, "preloadToolProcess, error=", th5);
        }
    }
}
