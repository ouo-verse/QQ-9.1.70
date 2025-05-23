package kotlin.jvm.internal;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007\u00a2\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b\u00a2\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {PatternUtils.NO_MATCH, "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", GlobalUtil.DEF_STRING, "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "CollectionToArray")
/* loaded from: classes28.dex */
public final class CollectionToArray {

    @NotNull
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 2147483645;

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] toArray(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i3 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i16 = i3 + 1;
            objArr2[i3] = it.next();
            if (i16 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i17 = ((i16 * 3) + 1) >>> 1;
                if (i17 <= i16) {
                    i17 = MAX_SIZE;
                    if (i16 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i17);
                Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i16] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i16);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i3 = i16;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> collection, Function0<Object[]> function0, Function1<? super Integer, Object[]> function1, Function2<? super Object[], ? super Integer, Object[]> function2) {
        int size = collection.size();
        if (size == 0) {
            return function0.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return function0.invoke();
        }
        Object[] invoke = function1.invoke(Integer.valueOf(size));
        int i3 = 0;
        ?? r36 = invoke;
        while (true) {
            int i16 = i3 + 1;
            r36[i3] = it.next();
            if (i16 >= r36.length) {
                if (!it.hasNext()) {
                    return r36;
                }
                int i17 = ((i16 * 3) + 1) >>> 1;
                if (i17 <= i16) {
                    i17 = MAX_SIZE;
                    if (i16 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                }
                r36 = Arrays.copyOf((Object[]) r36, i17);
                Intrinsics.checkNotNullExpressionValue(r36, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return function2.invoke(r36, Integer.valueOf(i16));
            }
            i3 = i16;
            r36 = r36;
        }
    }

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] toArray(@NotNull Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    objArr[i3] = it.next();
                    if (i16 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i17 = ((i16 * 3) + 1) >>> 1;
                        if (i17 <= i16) {
                            i17 = MAX_SIZE;
                            if (i16 >= MAX_SIZE) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i17);
                        Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i16);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i3 = i16;
                }
            }
        }
        return EMPTY;
    }
}
