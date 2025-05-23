package com.tencent.richframework.argus.business.performance.report;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.ReleaseMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.preload.PreloadGrayMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.preload.PreloadPublicMeetStrategy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/ArgusPreloadEventInterceptor;", "Lcom/tencent/richframework/argus/business/performance/report/IEventReportInterceptor;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "()V", "strategies", "", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "dispatchEvent", "", "eventId", "", "map", "", "", "getMeetStrategies", "report", "", "Companion", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class ArgusPreloadEventInterceptor implements IEventReportInterceptor, IRFWSampleManager {

    @NotNull
    private final List<IRFWSampleMeetStrategy> strategies;

    public ArgusPreloadEventInterceptor() {
        List<IRFWSampleMeetStrategy> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IRFWSampleMeetStrategy[]{new PreloadGrayMeetStrategy(), new PreloadPublicMeetStrategy(), new ReleaseMeetStrategy()});
        this.strategies = listOf;
    }

    private final void report(final Map<String, ? extends Object> map) {
        if (!map.isEmpty() && IRFWSampleManager.DefaultImpls.hitSample$default(this, null, 1, null)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.richframework.argus.business.performance.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    ArgusPreloadEventInterceptor.report$lambda$1(map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$1(Map map) {
        Intrinsics.checkNotNullParameter(map, "$map");
        HashMap hashMap = new HashMap();
        hashMap.put("type", "preload_situation");
        ArgusReportHelper argusReportHelper = ArgusReportHelper.INSTANCE;
        hashMap.put("ext", argusReportHelper.toSafeJson(argusReportHelper.getGson(), map));
        argusReportHelper.report(hashMap);
    }

    @Override // com.tencent.richframework.argus.business.performance.report.IEventReportInterceptor
    public boolean dispatchEvent(@Nullable String eventId, @Nullable Map<String, ? extends Object> map) {
        if (Intrinsics.areEqual("argus_preload_report_event", eventId)) {
            if (map != null) {
                report(map);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    @NotNull
    public List<IRFWSampleMeetStrategy> getMeetStrategies() {
        return this.strategies;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    public boolean hitSample(@Nullable String str) {
        return IRFWSampleManager.DefaultImpls.hitSample(this, str);
    }
}
