package ei0;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lei0/a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "roomId", "userId", "", "a", "b", "Landroid/view/View;", "view", "eid", "d", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396300a = new a();

    a() {
    }

    public final void a(Fragment fragment, String roomId, String userId) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.a().g().h("pg_qqlive_gamelive_start").a("qqlive_user_id", userId).a("qqlive_zhibo_type", "0").a("qqlive_anchor_id", userId).a("qqlive_room_id", roomId).f("dt_pgin");
    }

    public final void b(Fragment fragment, String roomId, String userId) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.a().g().h("pg_qqlive_gamelive_start").a("qqlive_user_id", userId).a("qqlive_zhibo_type", "0").a("qqlive_anchor_id", userId).a("qqlive_room_id", roomId).f("dt_pgout");
    }

    public final void c(View view, String eid, String roomId, String userId) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h(eid).a("qqlive_user_id", userId).a("qqlive_zhibo_type", "0").a("qqlive_anchor_id", userId).a("qqlive_room_id", roomId).i();
        c.f396302a.c(view);
    }

    public final void d(View view, String eid, String roomId, String userId) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h(eid).a("qqlive_user_id", userId).a("qqlive_zhibo_type", "0").a("qqlive_anchor_id", userId).a("qqlive_room_id", roomId).i();
        c.f396302a.d(view);
    }
}
