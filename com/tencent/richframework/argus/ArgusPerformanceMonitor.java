package com.tencent.richframework.argus;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.monitor.local.RFWPerformanceAnalyse;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R2\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/argus/ArgusPerformanceMonitor;", "Lcom/tencent/biz/richframework/monitor/RFWMonitorManager;", "Landroid/content/Context;", "context", "", "business", "Lcom/tencent/richframework/argus/PerformanceData;", "getPerformanceData", "", "start", "startMonitor", "stopMonitor", "Ljava/util/HashMap;", "Lcom/tencent/richframework/argus/MonitorData;", "Lkotlin/collections/HashMap;", "monitors", "Ljava/util/HashMap;", "<init>", "()V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusPerformanceMonitor extends RFWMonitorManager {

    @NotNull
    public static final ArgusPerformanceMonitor INSTANCE;
    private static HashMap<String, MonitorData> monitors;

    static {
        ArgusPerformanceMonitor argusPerformanceMonitor = new ArgusPerformanceMonitor();
        INSTANCE = argusPerformanceMonitor;
        monitors = new HashMap<>();
        argusPerformanceMonitor.injectProxyImpl(ArgusMonitorProxyImpl.INSTANCE);
    }

    ArgusPerformanceMonitor() {
    }

    private final PerformanceData getPerformanceData(Context context, String business) {
        NodePO nodePO = null;
        if (!(context instanceof Activity)) {
            return null;
        }
        if (this.mPerformanceAnalyse == null) {
            RFWLog.e("ArgusPerformanceMonitor", RFWLog.USR, "stopMonitor mPerformanceAnalyse is null");
            return null;
        }
        MonitorData remove = monitors.remove(business);
        if (remove == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(remove, "monitors.remove(business)?: return null");
        RFWLog.d("ArgusPerformanceMonitor", RFWLog.DEV, "stopMonitor key:" + business + ", size:" + monitors.size());
        ArgusMonitorProxyImpl argusMonitorProxyImpl = ArgusMonitorProxyImpl.INSTANCE;
        ArrayList<Float> currentFpsRecord = argusMonitorProxyImpl.getCurrentFpsRecord();
        Argus argus = Argus.INSTANCE;
        Window window = ((Activity) context).getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "context.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "context.window.decorView");
        ArgusNode findViewBlockNode$default = Argus.findViewBlockNode$default(argus, decorView, false, 2, null);
        if (findViewBlockNode$default != null) {
            nodePO = findViewBlockNode$default.getNodeTreeTag();
        }
        NodePO nodePO2 = nodePO;
        ArrayList arrayList = new ArrayList();
        if (currentFpsRecord.size() < remove.getStartFpsIndex()) {
            RFWLog.d("ArgusPerformanceMonitor", RFWLog.DEV, "stopMonitor record size:" + currentFpsRecord.size() + " data:" + remove);
        } else {
            arrayList.addAll(currentFpsRecord.subList(remove.getStartFpsIndex(), currentFpsRecord.size()));
        }
        return new PerformanceData((int) RFWDropFrameCollector.sRefreshRate, nodePO2, arrayList, argusMonitorProxyImpl.getCurrentSMVal(), System.currentTimeMillis() - remove.getStartTime());
    }

    @Override // com.tencent.biz.richframework.monitor.RFWMonitorManager, com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void start(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity)) {
            return;
        }
        RFWPerformanceAnalyse rFWPerformanceAnalyse = this.mPerformanceAnalyse;
        if (rFWPerformanceAnalyse == null) {
            super.start(context);
        } else {
            rFWPerformanceAnalyse.init((Activity) context, isEnabledFlowWindow());
            this.mPerformanceAnalyse.start(context);
        }
    }

    public final void startMonitor(@NotNull Context context, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        if (monitors.containsKey(business)) {
            return;
        }
        RFWPerformanceAnalyse rFWPerformanceAnalyse = this.mPerformanceAnalyse;
        if (rFWPerformanceAnalyse != null) {
            rFWPerformanceAnalyse.calculateOnce();
        }
        monitors.put(business, new MonitorData(System.currentTimeMillis(), ArgusMonitorProxyImpl.INSTANCE.getCurrentFpsRecord().size()));
        RFWLog.d("ArgusPerformanceMonitor", RFWLog.DEV, "startMonitor key:" + business + ", size:" + monitors.size());
        start(context);
        INSTANCE.startPageScroll(1);
    }

    @Nullable
    public final PerformanceData stopMonitor(@NotNull Context context, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        PerformanceData performanceData = getPerformanceData(context, business);
        if (monitors.size() == 0) {
            stop();
            ArgusMonitorProxyImpl.INSTANCE.clearPerformanceFPSRecord();
            INSTANCE.endPageScroll(1);
        }
        return performanceData;
    }
}
