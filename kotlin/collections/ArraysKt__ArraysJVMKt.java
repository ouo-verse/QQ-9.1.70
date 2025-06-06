package kotlin.collections;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a#\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0001\u00a2\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\b\u00a2\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\b\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\b\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes28.dex */
public class ArraysKt__ArraysJVMKt {
    @NotNull
    public static final <T> T[] arrayOfNulls(@NotNull T[] reference, int i3) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i3);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    public static <T> int contentDeepHashCode(@Nullable T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.3")
    public static final void copyOfRangeToIndexCheck(int i3, int i16) {
        if (i3 <= i16) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i16 + ").");
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr == null) {
            Intrinsics.reifiedOperationMarker(0, "T?");
            return (T[]) new Object[0];
        }
        return tArr;
    }

    @InlineOnly
    private static final String toString(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return tArr;
    }
}
