package com.tencent.mobileqq.kandian.biz.detail;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/detail/b;", "", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "uin", "", "a", "", "b", "Z", "aladdinMonitorSwitchStates", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f239363a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean aladdinMonitorSwitchStates = d.f239367a.a();

    b() {
    }

    public final void a(String eventName, HashMap<String, String> dataMap, String uin) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (aladdinMonitorSwitchStates) {
            dataMap.put("uin", uin);
            dataMap.put("app_env", "2");
            dataMap.put("os", "Android");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("0DOU0QDD2U4LOCOP", uin, eventName, true, 0L, 0L, dataMap, "", true);
            QLog.i("ECWebViewDataReportUtil", 1, eventName + dataMap + uin + "\u4e0a\u62a5\u6210\u529f");
        }
    }
}
