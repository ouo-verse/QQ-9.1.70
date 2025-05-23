package kotlin.collections;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001\u00a2\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003\u00a2\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u00a2\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003\u00a2\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2 = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, RemoteHandleConst.PARAM_DEFAULT_VALUE, "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes28.dex */
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static <T> boolean contentDeepEquals(@Nullable T[] tArr, @Nullable T[] tArr2) {
        boolean m1054contentEqualslec5QzE;
        boolean m1050contentEqualsKJPZfPQ;
        boolean m1049contentEqualsFGO6Aew;
        boolean m1052contentEqualskV0jMPg;
        boolean contentDeepEquals;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Object[] objArr = tArr[i3];
            Object[] objArr2 = tArr2[i3];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    contentDeepEquals = contentDeepEquals(objArr, objArr2);
                    if (!contentDeepEquals) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof UByteArray) && (objArr2 instanceof UByteArray)) {
                    m1052contentEqualskV0jMPg = UArraysKt___UArraysKt.m1052contentEqualskV0jMPg(((UByteArray) objArr).getStorage(), ((UByteArray) objArr2).getStorage());
                    if (!m1052contentEqualskV0jMPg) {
                        return false;
                    }
                } else if ((objArr instanceof UShortArray) && (objArr2 instanceof UShortArray)) {
                    m1049contentEqualsFGO6Aew = UArraysKt___UArraysKt.m1049contentEqualsFGO6Aew(((UShortArray) objArr).getStorage(), ((UShortArray) objArr2).getStorage());
                    if (!m1049contentEqualsFGO6Aew) {
                        return false;
                    }
                } else if ((objArr instanceof UIntArray) && (objArr2 instanceof UIntArray)) {
                    m1050contentEqualsKJPZfPQ = UArraysKt___UArraysKt.m1050contentEqualsKJPZfPQ(((UIntArray) objArr).getStorage(), ((UIntArray) objArr2).getStorage());
                    if (!m1050contentEqualsKJPZfPQ) {
                        return false;
                    }
                } else if ((objArr instanceof ULongArray) && (objArr2 instanceof ULongArray)) {
                    m1054contentEqualslec5QzE = UArraysKt___UArraysKt.m1054contentEqualslec5QzE(((ULongArray) objArr).getStorage(), ((ULongArray) objArr2).getStorage());
                    if (!m1054contentEqualslec5QzE) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    public static <T> String contentDeepToString(@Nullable T[] tArr) {
        int coerceAtMost;
        if (tArr == null) {
            return "null";
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(tArr.length, 429496729);
        StringBuilder sb5 = new StringBuilder((coerceAtMost * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb5, new ArrayList());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb5, List<Object[]> list) {
        int lastIndex;
        String m1072contentToStringuLth9ew;
        String m1069contentToStringXUkPCBk;
        String m1070contentToStringd6D3K8;
        String m1066contentToString2csIQuQ;
        if (list.contains(tArr)) {
            sb5.append("[...]");
            return;
        }
        list.add(tArr);
        sb5.append('[');
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb5.append(", ");
            }
            Object[] objArr = tArr[i3];
            if (objArr == 0) {
                sb5.append("null");
            } else if (objArr instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt(objArr, sb5, list);
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb5.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
                sb5.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays3, "toString(this)");
                sb5.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays4, "toString(this)");
                sb5.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays5, "toString(this)");
                sb5.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays6, "toString(this)");
                sb5.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays7, "toString(this)");
                sb5.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays8, "toString(this)");
                sb5.append(arrays8);
            } else if (objArr instanceof UByteArray) {
                m1066contentToString2csIQuQ = UArraysKt___UArraysKt.m1066contentToString2csIQuQ(((UByteArray) objArr).getStorage());
                sb5.append(m1066contentToString2csIQuQ);
            } else if (objArr instanceof UShortArray) {
                m1070contentToStringd6D3K8 = UArraysKt___UArraysKt.m1070contentToStringd6D3K8(((UShortArray) objArr).getStorage());
                sb5.append(m1070contentToStringd6D3K8);
            } else if (objArr instanceof UIntArray) {
                m1069contentToStringXUkPCBk = UArraysKt___UArraysKt.m1069contentToStringXUkPCBk(((UIntArray) objArr).getStorage());
                sb5.append(m1069contentToStringXUkPCBk);
            } else if (objArr instanceof ULongArray) {
                m1072contentToStringuLth9ew = UArraysKt___UArraysKt.m1072contentToStringuLth9ew(((ULongArray) objArr).getStorage());
                sb5.append(m1072contentToStringuLth9ew);
            } else {
                sb5.append(objArr.toString());
            }
        }
        sb5.append(']');
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        list.remove(lastIndex);
    }

    @NotNull
    public static final <T> List<T> flatten(@NotNull T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i3 = 0;
        for (T[] tArr2 : tArr) {
            i3 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i3);
        for (T[] tArr3 : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Object[] objArr, Function0 defaultValue) {
        boolean z16;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return defaultValue.invoke();
        }
        return objArr;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(Object[] objArr) {
        boolean z16;
        if (objArr == null) {
            return true;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
