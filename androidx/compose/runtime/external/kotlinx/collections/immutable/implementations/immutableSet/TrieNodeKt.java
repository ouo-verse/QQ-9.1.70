package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\b\u00a2\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"LOG_MAX_BRANCHING_FACTOR", "", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", "E", DTConstants.TAG.ELEMENT, "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] objArr, int i3, E e16) {
        Object[] objArr2 = new Object[objArr.length + 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3 + 1, i3, objArr.length);
        objArr2[i3] = e16;
        return objArr2;
    }

    public static final int indexSegment(int i3, int i16) {
        return (i3 >> i16) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3, i3 + 1, objArr.length);
        return objArr2;
    }

    private static final int filterTo(Object[] objArr, Object[] objArr2, int i3, Function1<Object, Boolean> function1) {
        int i16 = 0;
        int i17 = 0;
        while (i16 < objArr.length) {
            CommonFunctionsKt.m32assert(i17 <= i16);
            if (function1.invoke(objArr[i16]).booleanValue()) {
                objArr2[i3 + i17] = objArr[i16];
                i17++;
                CommonFunctionsKt.m32assert(i3 + i17 <= objArr2.length);
            }
            i16++;
        }
        return i17;
    }

    static /* synthetic */ int filterTo$default(Object[] objArr, Object[] objArr2, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            function1 = new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt$filterTo$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj2) {
                    return Boolean.valueOf(obj2 != TrieNode.Companion.getEMPTY$runtime_release());
                }
            };
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < objArr.length) {
            CommonFunctionsKt.m32assert(i18 <= i17);
            if (((Boolean) function1.invoke(objArr[i17])).booleanValue()) {
                objArr2[i3 + i18] = objArr[i17];
                i18++;
                CommonFunctionsKt.m32assert(i3 + i18 <= objArr2.length);
            }
            i17++;
        }
        return i18;
    }
}
