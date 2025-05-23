package mc;

import android.view.Window;
import androidx.core.util.Consumer;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.richframework.monitor.window.RFWWindowPerformanceMonitor;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.performance.report.ArgusReportHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lmc/c;", "", "", "pageName", "", "pageShowCost", "feedShowCost", "scene", "", "d", "requestName", "costTime", "", QzoneIPCModule.RESULT_CODE, "e", HippyTKDListViewAdapter.SCROLL_STATE, "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Landroid/view/Window;", "window", "monitorKey", "b", "", "Ljava/util/Set;", "warmLaunchSet", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f416541a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Set<String> warmLaunchSet = new LinkedHashSet();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String pageName, WindowPerformanceData windowPerformanceData) {
        Intrinsics.checkNotNullParameter(pageName, "$pageName");
        if (windowPerformanceData != null) {
            ArgusReportHelper argusReportHelper = ArgusReportHelper.INSTANCE;
            HashMap<String, String> createReportMap = argusReportHelper.createReportMap(windowPerformanceData, "list_view_scroll");
            createReportMap.put("current_block", pageName);
            argusReportHelper.report(createReportMap);
        }
    }

    public final void b(int scrollState, com.tencent.qqnt.avatar.meta.refresh.c<Window> window, final String pageName, String monitorKey) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(monitorKey, "monitorKey");
        Window window2 = window.get();
        if (window2 == null) {
            QLog.e("QZAlbumxPrefReporter", 1, "window is null");
            return;
        }
        if (scrollState == 0) {
            RFWWindowPerformanceMonitor.INSTANCE.stopMonitor(window2, monitorKey, new Consumer() { // from class: mc.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    c.c(pageName, (WindowPerformanceData) obj);
                }
            });
            QLog.d("QZAlbumxPrefReporter", 4, "scrollState: SCROLL_STATE_IDLE, pageName: " + pageName + ", monitorKey: " + monitorKey);
            return;
        }
        if (scrollState != 1) {
            return;
        }
        RFWWindowPerformanceMonitor.INSTANCE.startMonitor(window2, monitorKey);
        QLog.d("QZAlbumxPrefReporter", 4, "scrollState: SCROLL_STATE_TOUCH_SCROLL, pageName: " + pageName + ", monitorKey: " + monitorKey);
    }

    public final void e(String requestName, long costTime, int resultCode) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        QZonePerfReporter qZonePerfReporter = QZonePerfReporter.f59697a;
        qZonePerfReporter.s(requestName, costTime, resultCode, qZonePerfReporter.c(), true);
    }

    public final void d(String pageName, long pageShowCost, long feedShowCost, String scene) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        boolean contains = warmLaunchSet.contains(pageName);
        QZonePerfReporter qZonePerfReporter = QZonePerfReporter.f59697a;
        qZonePerfReporter.q(pageName, pageShowCost, feedShowCost, contains, qZonePerfReporter.c(), scene, true);
        warmLaunchSet.add(pageName);
    }
}
