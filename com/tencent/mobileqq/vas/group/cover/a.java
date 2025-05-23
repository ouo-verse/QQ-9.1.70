package com.tencent.mobileqq.vas.group.cover;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/group/cover/a;", "", "", "a", "b", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "reportApi", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "reportData", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IZootopiaReportApi reportApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> reportData;

    public a() {
        QRouteApi api = QRoute.api(IZootopiaReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaReportApi::class.java)");
        this.reportApi = (IZootopiaReportApi) api;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.reportData = hashMap;
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.SUB_SOURCE_SET_COVER);
    }

    public final void a() {
        this.reportData.put("zplan_action_type", "click");
        this.reportApi.reportEvent("ev_zplan_external_entrance_action", this.reportData);
    }

    public final void b() {
        this.reportData.put("zplan_action_type", "imp");
        this.reportApi.reportEvent("ev_zplan_external_entrance_action", this.reportData);
    }
}
