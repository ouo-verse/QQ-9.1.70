package id3;

import android.view.View;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lid3/e;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "f", "pageStatus", "", "e", "Landroid/view/View;", "view", "a", "adId", "g", "position", "c", "b", h.F, "id", "type", "d", "i", "Lid3/d;", "Lid3/d;", "reportHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f407552a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final d reportHelper = new d(null, 1, null);

    e() {
    }

    private final int f(ZootopiaSource source) {
        return ZootopiaSource.INSTANCE.j(source) == 3 ? 1 : 0;
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        d.h(reportHelper, view, "em_zplan_playground_gallery_banner", new LinkedHashMap(), false, false, null, 56, null);
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        d.i(reportHelper, view, "em_zplan_playground_samestyle_more", new LinkedHashMap(), false, false, null, false, false, 240, null);
    }

    public final void c(View view, int position) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        d dVar = reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_module_id", Integer.valueOf(position)));
        d.h(dVar, view, "em_zplan_playground_gallery_samestyle", mutableMapOf, false, false, null, 56, null);
    }

    public final void d(View view, int id5, int type) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        d dVar = reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(id5)), TuplesKt.to("zplan_playground_samestyle_module_type", Integer.valueOf(type)));
        d.i(dVar, view, "em_zplan_playground_samestyle_video", mutableMapOf, false, false, null, false, false, 240, null);
    }

    public final void e(int pageStatus, ZootopiaSource source) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(source, "source");
        d dVar = reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_playground_page_status", Integer.valueOf(pageStatus)), TuplesKt.to("zplan_playground_page_status_type", Integer.valueOf(f(source))));
        dVar.d("ev_zplan_playground_page_status", mutableMapOf);
    }

    public final void g(View view, int adId) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        d dVar = reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_playground_banner_id", Integer.valueOf(adId)));
        dVar.c("clck", view, mutableMapOf);
    }

    public final void h(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        reportHelper.c("clck", view, new LinkedHashMap());
    }

    public final void i(View view, int id5, int type) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        d dVar = reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(id5)), TuplesKt.to("zplan_playground_samestyle_module_type", Integer.valueOf(type)));
        dVar.c("clck", view, mutableMapOf);
    }
}
