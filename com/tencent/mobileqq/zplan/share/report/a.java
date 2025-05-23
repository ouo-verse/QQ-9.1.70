package com.tencent.mobileqq.zplan.share.report;

import android.view.View;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\"\u0010#J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&R\u001a\u0010\u001a\u001a\u00020\u00168\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/a;", "Lcom/tencent/mobileqq/zplan/share/report/c;", "", "channelID", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "", "", "k", "target", "view", "", "c", "Landroid/view/View;", "a", "b", "f", "e", "g", "d", tl.h.F, "Lid3/d;", "Lid3/d;", "j", "()Lid3/d;", "dtReporter", "Lcom/tencent/mobileqq/zplan/share/report/f;", "Lcom/tencent/mobileqq/zplan/share/report/f;", "i", "()Lcom/tencent/mobileqq/zplan/share/report/f;", "l", "(Lcom/tencent/mobileqq/zplan/share/report/f;)V", "commonInfo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReporter = new id3.d(null, 1, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    protected ShareReportCommonInfo commonInfo;

    private final Map<String, Object> k(int channelID, ZPlanShareLaunchParam launchParam) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pgid", i().getPageId());
        linkedHashMap.put("dt_pgid", i().getPageId());
        linkedHashMap.put("eid", i().getEIdShareItem());
        linkedHashMap.put(i().getKeyShareChannel(), Integer.valueOf(channelID));
        linkedHashMap.putAll(h(launchParam));
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void a(View view, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        id3.d.h(this.dtReporter, view, i().getEIdClose(), h(launchParam), false, true, null, 40, null);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void b(View view, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.dtReporter.c("dt_imp", view, h(launchParam));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void c(Object target, Object view, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.dtReporter.j(target, view, i().getPageId(), h(launchParam));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void d(int channelID, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        id3.d dVar = this.dtReporter;
        String evIdShareSuccess = i().getEvIdShareSuccess();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(i().getKeyShareChannel(), Integer.valueOf(channelID));
        linkedHashMap.putAll(h(launchParam));
        Unit unit = Unit.INSTANCE;
        dVar.d(evIdShareSuccess, linkedHashMap);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void e(int channelID, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.dtReporter.d("imp", k(channelID, launchParam));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void f(View view, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.dtReporter.c("dt_clck", view, h(launchParam));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.c
    public void g(int channelID, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.dtReporter.d("clck", k(channelID, launchParam));
    }

    public abstract Map<String, Object> h(ZPlanShareLaunchParam launchParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public final ShareReportCommonInfo i() {
        ShareReportCommonInfo shareReportCommonInfo = this.commonInfo;
        if (shareReportCommonInfo != null) {
            return shareReportCommonInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commonInfo");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j, reason: from getter */
    public final id3.d getDtReporter() {
        return this.dtReporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(ShareReportCommonInfo shareReportCommonInfo) {
        Intrinsics.checkNotNullParameter(shareReportCommonInfo, "<set-?>");
        this.commonInfo = shareReportCommonInfo;
    }
}
