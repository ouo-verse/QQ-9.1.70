package p10;

import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lp10/e;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "", "Lp10/a;", "Ljava/util/List;", "jumpHelperList", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<a> jumpHelperList;

    public e() {
        List<a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new b(), new d(), new c()});
        this.jumpHelperList = listOf;
    }

    public final void a(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<a> it = this.jumpHelperList.iterator();
        while (it.hasNext() && !it.next().a(context, bundle)) {
        }
    }
}
