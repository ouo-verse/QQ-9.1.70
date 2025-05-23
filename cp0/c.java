package cp0;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcp0/c;", "", "", "payloads", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f391513a = new c();

    c() {
    }

    @NotNull
    public final List<Integer> a(@NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ArrayList arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 instanceof Integer) {
                        arrayList.add(obj2);
                    }
                }
            }
        }
        return arrayList;
    }
}
