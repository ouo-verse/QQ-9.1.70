package iz3;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class k {
    public static void a(l lVar, @NotNull List list, @NotNull List list2, @NotNull List list3) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(list2);
        lVar.onSuccess(arrayList);
    }
}
