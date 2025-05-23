package com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/a;", "Lc94/a;", "", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "Lwf3/a;", "", "l", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends c94.a<Integer, ZPlanTabTitleData, wf3.a> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    public a(Context context, ZplanViewReportHelper reportHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.context = context;
        this.reportHelper = reportHelper;
    }

    @Override // c94.a
    public String l() {
        return "SmallHomeDataTabAdapter";
    }

    @Override // c94.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public wf3.a d(ZPlanTabTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        wf3.a aVar = new wf3.a(this.context, this.reportHelper);
        aVar.setData(data);
        return aVar;
    }
}
