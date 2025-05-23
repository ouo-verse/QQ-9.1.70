package hd2;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.IQCircleKaDunOptApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqperf.tools.d;
import com.tencent.rmonitor.base.meta.LooperMeta;
import com.tencent.rmonitor.base.plugin.listener.ILooperListener;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lhd2/c;", "Lcom/tencent/rmonitor/base/plugin/listener/ILooperListener;", "", QCircleWeakNetReporter.KEY_COST, "", "c", "(Ljava/lang/Integer;)V", "Lcom/tencent/rmonitor/base/meta/LooperMeta;", PublicAccountMessageUtilImpl.META_NAME, "onBeforeReport", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements ILooperListener {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArrayList<a> f404749b = new CopyOnWriteArrayList<>();

    private final void c(Integer cost) {
        if (AppSetting.isGrayVersion() && Math.random() < 0.9d) {
            return;
        }
        HashMap hashMap = new HashMap();
        String f16 = SceneTracker.f();
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        hashMap.put("stage", f16);
        hashMap.put("deviceLevel", String.valueOf(d.f363413a.a()));
        hashMap.put("time_cost", String.valueOf(cost));
        if (PerfReportUtil.d(f16)) {
            String qCircleExtParams = ((IQCircleKaDunOptApi) QRoute.api(IQCircleKaDunOptApi.class)).getQCircleExtParams();
            Intrinsics.checkNotNullExpressionValue(qCircleExtParams, "api(IQCircleKaDunOptApi:\u2026ss.java).qCircleExtParams");
            hashMap.put("ext", qCircleExtParams);
        }
        PerfReportUtil.h("perf_rmonitor_looper", hashMap);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.ILooperListener
    public void onBeforeReport(@Nullable LooperMeta meta) {
        Integer num;
        JSONObject jSONObject;
        if (meta == null) {
            return;
        }
        JSONObject looperParams = meta.getLooperParams();
        String valueOf = String.valueOf(looperParams);
        if (valueOf.length() > 4000) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("main looper slow : ");
            String substring = valueOf.substring(0, 4000);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            com.tencent.mobileqq.perf.log.a.d("ML", sb5.toString());
        } else {
            com.tencent.mobileqq.perf.log.a.d("ML", "main looper slow : " + valueOf);
        }
        Iterator<T> it = f404749b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(new QQLooperMeta(looperParams));
        }
        if (looperParams != null && (jSONObject = looperParams.getJSONObject(ReportDataBuilder.KEY_ATTRIBUTES)) != null) {
            num = Integer.valueOf(jSONObject.getInt("time_cost"));
        } else {
            num = null;
        }
        c(num);
    }
}
