package bp3;

import bp3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u001a@\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u001a(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u001a(\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0000\"\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"T", "", "Lbp3/a$b;", "ranges", "", "start", "end", "d", "", "text", "Lbp3/a;", "a", "baseStart", "baseEnd", "targetStart", "targetEnd", "", "c", "lStart", "lEnd", "rStart", "rEnd", "e", "Lbp3/a;", "EmptyAnnotatedString", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f28862a = a("");

    public static final a a(String text) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(text, "text");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return new a(text, emptyList, emptyList2);
    }

    public static final boolean c(int i3, int i16, int i17, int i18) {
        boolean z16;
        boolean z17;
        if (i3 > i17 || i18 > i16) {
            return false;
        }
        if (i16 == i18) {
            if (i17 == i18) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 == i16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 != z17) {
                return false;
            }
        }
        return true;
    }

    public static final boolean e(int i3, int i16, int i17, int i18) {
        return Math.max(i3, i17) < Math.min(i16, i18) || c(i3, i16, i17, i18) || c(i17, i18, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<a.b<T>> d(List<? extends a.b<? extends T>> list, int i3, int i16) {
        if (i3 <= i16) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                a.b<? extends T> bVar = list.get(i17);
                a.b<? extends T> bVar2 = bVar;
                if (e(i3, i16, bVar2.c(), bVar2.a())) {
                    arrayList.add(bVar);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i18 = 0; i18 < size2; i18++) {
                a.b bVar3 = (a.b) arrayList.get(i18);
                arrayList2.add(new a.b(bVar3.b(), Math.max(i3, bVar3.c()) - i3, Math.min(i16, bVar3.a()) - i3, bVar3.d()));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException(("start (" + i3 + ") should be less than or equal to end (" + i16 + ')').toString());
    }
}
