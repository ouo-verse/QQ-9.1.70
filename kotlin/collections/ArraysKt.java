package kotlin.collections;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class ArraysKt extends ArraysKt___ArraysKt {
    ArraysKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static /* bridge */ /* synthetic */ boolean contentDeepEquals(@Nullable Object[] objArr, @Nullable Object[] objArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(objArr, objArr2);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    public static /* bridge */ /* synthetic */ String contentDeepToString(@Nullable Object[] objArr) {
        return ArraysKt__ArraysKt.contentDeepToString(objArr);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ byte[] copyInto(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i3, int i16, int i17) {
        return ArraysKt___ArraysJvmKt.copyInto(bArr, bArr2, i3, i16, i17);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Set toSet(@NotNull int[] iArr) {
        return ArraysKt___ArraysKt.toSet(iArr);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Object getOrNull(@NotNull Object[] objArr, int i3) {
        return ArraysKt___ArraysKt.getOrNull(objArr, i3);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ IntRange getIndices(@NotNull Object[] objArr) {
        return ArraysKt___ArraysKt.getIndices(objArr);
    }

    public static /* bridge */ /* synthetic */ boolean contains(@NotNull Object[] objArr, Object obj) {
        return ArraysKt___ArraysKt.contains(objArr, obj);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i16, Object obj) {
        return ArraysKt___ArraysKt.joinToString$default(objArr, charSequence, charSequence2, charSequence3, i3, charSequence4, function1, i16, obj);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List toList(@NotNull int[] iArr) {
        return ArraysKt___ArraysKt.toList(iArr);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List toList(@NotNull Object[] objArr) {
        return ArraysKt___ArraysKt.toList(objArr);
    }
}
