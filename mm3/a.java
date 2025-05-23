package mm3;

import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lmm3/a;", "", "Landroid/view/View;", "view", "", "nowId", "", "a", "b", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f417004a = new a();

    a() {
    }

    public final void a(@NotNull View view, long nowId) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(nowId));
        com.tencent.report.a.f364907a.a(view, true, null, "em_qqlive_lppk_interrupt_lp", hashMap);
    }

    public final void b(long nowId) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(nowId));
        com.tencent.report.a.f364907a.h("em_qqlive_lppk_reopen_pk_recept", hashMap);
    }
}
