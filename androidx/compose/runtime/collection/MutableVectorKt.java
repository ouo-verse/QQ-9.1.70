package androidx.compose.runtime.collection;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u001a \u0010\u0010\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0013"}, d2 = {"MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", "T", "capacity", "", "size", "init", "Lkotlin/Function1;", "mutableVectorOf", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "checkIndex", "", "", "index", "checkSubIndex", "fromIndex", "toIndex", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class MutableVectorKt {
    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i3) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[i3], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i3) {
        int size = list.size();
        if (i3 < 0 || i3 >= size) {
            throw new IndexOutOfBoundsException("Index " + i3 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i3, int i16) {
        int size = list.size();
        if (i3 > i16) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i3 + ") is greater than toIndex (" + i16 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than 0.");
        }
        if (i16 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i16 + ") is more than than the list size (" + size + ')');
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new MutableVector<>(elements, elements.length);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i3, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] objArr = new Object[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            objArr[i16] = init.invoke(Integer.valueOf(i16));
        }
        return new MutableVector<>(objArr, i3);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[16], 0);
    }

    public static /* synthetic */ MutableVector MutableVector$default(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 16;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[i3], 0);
    }
}
