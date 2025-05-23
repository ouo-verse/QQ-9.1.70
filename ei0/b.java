package ei0;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lei0/b;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "c", "Landroid/view/View;", "view", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f396301a = new b();

    b() {
    }

    public final void a(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_salescancel_button").i();
    }

    public final void b(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_salesok_button").i();
    }

    public final void c(Fragment fragment) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g().h("pg_qqlive_set_selling").j(true).i();
    }
}
