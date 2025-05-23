package il3;

import android.content.Context;
import jl3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lil3/a;", "Lel3/a;", "Landroid/content/Context;", "context", "Ljl3/a$b;", "selectData", "Ljl3/a$a;", "onSelectCallback", "Ljl3/a;", "W", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements el3.a {
    @Override // el3.a
    public jl3.a W(Context context, a.SelectData selectData, a.InterfaceC10597a onSelectCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectData, "selectData");
        Intrinsics.checkNotNullParameter(onSelectCallback, "onSelectCallback");
        return new jl3.a(context, selectData, onSelectCallback);
    }
}
