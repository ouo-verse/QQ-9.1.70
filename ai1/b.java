package ai1;

import android.view.View;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ar;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001j\u0002`\u0003B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J,\u0010\u0010\u001a\u00020\b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014\u00a8\u0006\u0013"}, d2 = {"Lai1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendCommonSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends ar<l<?>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull l<?> data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.guild.discoveryv2.util.b bVar = com.tencent.mobileqq.guild.discoveryv2.util.b.f217789a;
        View rootView = getRootView();
        String a16 = a.a(data);
        String valueOf = String.valueOf(data.getItemId());
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        Map<String, Object> c16 = a.c(data, position);
        IDynamicParams q16 = RecommendReportHelperKt.q(data, 0, 1, null);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        com.tencent.mobileqq.guild.discoveryv2.util.b.a(rootView, a16, valueOf, clickPolicy, exposurePolicy, endExposurePolicy, c16, Double.valueOf(0.8d), q16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
    }
}
