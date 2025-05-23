package eb4;

import android.view.View;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.l;
import pu4.n;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004JB\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Leb4/a;", "", "Lpu4/n;", "outfitWorksInfo", "", "sourceId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "map", "Landroid/view/View;", "view", "id", "", "b", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396070a = new a();

    a() {
    }

    public final HashMap<String, Object> a(n outfitWorksInfo, String sourceId) {
        l lVar;
        l lVar2;
        HashMap<String, Object> hashMap = new HashMap<>();
        Object obj = "";
        if (sourceId == null) {
            sourceId = "";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, sourceId);
        String str = (outfitWorksInfo == null || (lVar2 = outfitWorksInfo.f427499b) == null) ? null : lVar2.f427476a;
        if (str == null) {
            str = "";
        }
        hashMap.put("zplan_content_id", str);
        if (outfitWorksInfo != null && (lVar = outfitWorksInfo.f427499b) != null) {
            obj = Integer.valueOf(lVar.f427491p);
        }
        hashMap.put("zplan_content_type", obj);
        hashMap.put("dt_pgid", "pg_zplan_outfit_detail");
        return hashMap;
    }

    public final void b(ZplanViewReportHelper reportHelper, HashMap<String, Object> map, View view, String id5) {
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        reportHelper.e(view, id5, map);
    }

    public final void c(ZplanViewReportHelper reportHelper, HashMap<String, Object> map, View view, String id5) {
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        reportHelper.g(view, id5, (r16 & 4) != 0 ? null : map, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
