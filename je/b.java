package je;

import android.view.View;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\b\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a*\u0010\t\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a*\u0010\n\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a8\u0006\r"}, d2 = {"", "", "", "pageParam", "elementId", "Landroid/view/View;", "view", "", "c", "b", "d", "Lfo/b;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final fo.b a(Map<String, ? extends Object> pageParam) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.b j3 = new fo.b().l(hashMap).k(ExposurePolicy.REPORT_ALL).g(ClickPolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_ALL);
        Intrinsics.checkNotNullExpressionValue(j3, "QZoneDTTrackingParam()\n \u2026xposurePolicy.REPORT_ALL)");
        return j3;
    }

    public static final void b(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_clck", view, elementId, a(hashMap));
    }

    public static final void c(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_imp", view, elementId, a(hashMap));
    }

    public static final void d(Map<String, ? extends Object> pageParam, String elementId, View view) {
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.putAll(pageParam);
        fo.c.b("dt_imp_end", view, elementId, a(hashMap));
    }
}
