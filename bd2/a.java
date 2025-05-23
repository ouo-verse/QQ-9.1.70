package bd2;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleKaDunOptApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqperf.tools.d;
import com.tencent.richframework.argus.business.performance.report.ArgusReportHelper;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.base.plugin.listener.IDropFrameListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lbd2/a;", "Lcom/tencent/rmonitor/base/plugin/listener/IDropFrameListener;", "", "fps", "", "totalRefreshDuration", "hitchesDuration", "suspendDuration", "totalDuration", "", "scene", "", "c", "Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", PublicAccountMessageUtilImpl.META_NAME, "onRecordData", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements IDropFrameListener {
    private final void c(float fps, long totalRefreshDuration, long hitchesDuration, long suspendDuration, long totalDuration, String scene) {
        HashMap hashMap = new HashMap();
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        hashMap.put("stage", scene);
        hashMap.put("fps", String.valueOf(fps));
        hashMap.put("totalRefreshDuration", String.valueOf(totalRefreshDuration));
        hashMap.put("hitchesDuration", String.valueOf(hitchesDuration));
        hashMap.put("suspendDuration", String.valueOf(suspendDuration));
        hashMap.put("totalDuration", String.valueOf(totalDuration));
        hashMap.put("argusParams", ArgusReportHelper.INSTANCE.getArgusReportParams(scene));
        hashMap.put("deviceLevel", String.valueOf(d.f363413a.a()));
        if (PerfReportUtil.d(scene)) {
            String qCircleExtParams = ((IQCircleKaDunOptApi) QRoute.api(IQCircleKaDunOptApi.class)).getQCircleExtParams();
            Intrinsics.checkNotNullExpressionValue(qCircleExtParams, "api(IQCircleKaDunOptApi:\u2026ss.java).qCircleExtParams");
            hashMap.put("ext", qCircleExtParams);
        }
        PerfReportUtil.h("perf_rmonitor_fps", hashMap);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IDropFrameListener
    public void onRecordData(@Nullable DropFrameResultMeta meta) {
        float f16;
        if (meta == null) {
            return;
        }
        long j3 = meta.hitchesDuration;
        long j16 = meta.suspendDuration;
        long j17 = 0;
        for (long j18 : meta.refreshDuration) {
            j17 += j18;
        }
        if (j17 > 0) {
            f16 = (((float) (j17 - j3)) * 60.0f) / ((float) j17);
        } else {
            f16 = -1.0f;
        }
        float f17 = f16;
        com.tencent.mobileqq.perf.log.a.a("DF", "totalRefreshDuration: " + j17 + ", fps: " + f17);
        c(f17, j17, j3, j16, meta.totalDuration, meta.scene);
    }
}
