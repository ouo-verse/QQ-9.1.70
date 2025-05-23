package id;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lid/b;", "", "Landroid/content/Context;", "context", "", "Lhd/b;", "b", "c", "e", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class b {
    public List<hd.b> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }

    public final List<hd.b> b(Context context) {
        List plus;
        List plus2;
        List<hd.b> plus3;
        Intrinsics.checkNotNullParameter(context, "context");
        plus = CollectionsKt___CollectionsKt.plus((Collection) c(context), (Iterable) e(context));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) a(context));
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) d(context));
        return plus3;
    }

    public List<hd.b> c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }

    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }

    public List<hd.b> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }
}
