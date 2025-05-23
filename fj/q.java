package fj;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\t\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\f\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\r\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u00a8\u0006\u0012"}, d2 = {"Lfj/q;", "", "", "", "pageParam", "elementId", "Landroid/view/View;", "view", "", "c", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "e", "b", "d", "Lfo/b;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f399468a = new q();

    q() {
    }

    public final fo.b a(Map<String, ? extends Object> pageParam) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.b j3 = new fo.b().l(hashMap).k(ExposurePolicy.REPORT_ALL).g(ClickPolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_ALL);
        Intrinsics.checkNotNullExpressionValue(j3, "QZoneDTTrackingParam()\n \u2026xposurePolicy.REPORT_ALL)");
        return j3;
    }

    public final void b(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_clck", view, elementId, a(hashMap));
    }

    public final void c(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_imp", view, elementId, a(hashMap));
    }

    public final void d(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_imp_end", view, elementId, a(hashMap));
    }

    public final void e(String uniqueId, String elementId, View view) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        fo.b a16 = a(new HashMap());
        a16.i(uniqueId);
        fo.c.b("qq_clck", view, elementId, a16);
    }
}
