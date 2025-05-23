package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000\u00a2\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0086\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u000eH\u0002J7\u0010/\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00022!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020(01H\u0086\b\u00f8\u0001\u0000J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010$\u001a\u00020\u0002H\u0002J\u001b\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000\u00a2\u0006\u0002\u0010&J\u0013\u00106\u001a\u00020(2\u0006\u0010%\u001a\u00028\u0000\u00a2\u0006\u0002\u00107J/\u00108\u001a\u00020(2!\u00109\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020#01H\u0086\b\u00f8\u0001\u0000J#\u0010:\u001a\u00020(2\u0018\u0010;\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020(01H\u0082\bJ\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0011\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u000eH\u0082\bR4\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00058\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006?"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "scopeSets", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getScopeSets$annotations", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "setScopeSets", "([Landroidx/compose/runtime/collection/IdentityArraySet;)V", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "valueOrder", "", "getValueOrder$annotations", "getValueOrder", "()[I", "setValueOrder", "([I)V", "values", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", QCircleLpReportDc05507.KEY_CLEAR, "", "contains", DTConstants.TAG.ELEMENT, "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "valueAt", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i3 = 0; i3 < 50; i3++) {
            iArr[i3] = i3;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int find(Object value) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        int i3 = this.size - 1;
        int i16 = 0;
        while (i16 <= i3) {
            int i17 = (i16 + i3) >>> 1;
            Object obj = this.values[this.valueOrder[i17]];
            Intrinsics.checkNotNull(obj);
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj);
            if (identityHashCode2 < identityHashCode) {
                i16 = i17 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    return value == obj ? i17 : findExactIndex(i17, value, identityHashCode);
                }
                i3 = i17 - 1;
            }
        }
        return -(i16 + 1);
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object value) {
        int i3;
        if (this.size > 0) {
            i3 = find(value);
            if (i3 >= 0) {
                return scopeSetAt(i3);
            }
        } else {
            i3 = -1;
        }
        int i16 = -(i3 + 1);
        int i17 = this.size;
        int[] iArr = this.valueOrder;
        if (i17 < iArr.length) {
            int i18 = iArr[i17];
            this.values[i18] = value;
            IdentityArraySet<T> identityArraySet = this.scopeSets[i18];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                this.scopeSets[i18] = identityArraySet;
            }
            int i19 = this.size;
            if (i16 < i19) {
                int[] iArr2 = this.valueOrder;
                ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i16 + 1, i16, i19);
            }
            this.valueOrder[i16] = i18;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] copyOf = Arrays.copyOf(this.scopeSets, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.scopeSets = (IdentityArraySet[]) copyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        this.scopeSets[i17] = identityArraySet2;
        Object[] copyOf2 = Arrays.copyOf(this.values, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.values = copyOf2;
        copyOf2[i17] = value;
        int[] iArr3 = new int[length];
        int i26 = this.size;
        while (true) {
            i26++;
            if (i26 >= length) {
                break;
            }
            iArr3[i26] = i26;
        }
        int i27 = this.size;
        if (i16 < i27) {
            ArraysKt___ArraysJvmKt.copyInto(this.valueOrder, iArr3, i16 + 1, i16, i27);
        }
        iArr3[i16] = i17;
        if (i16 > 0) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.valueOrder, iArr3, 0, 0, i16, 6, (Object) null);
        }
        this.valueOrder = iArr3;
        this.size++;
        return identityArraySet2;
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> removalOperation) {
        int size = getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            int i17 = getValueOrder()[i16];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i17];
            Intrinsics.checkNotNull(identityArraySet);
            removalOperation.invoke(identityArraySet);
            if (identityArraySet.size() > 0) {
                if (i3 != i16) {
                    int i18 = getValueOrder()[i3];
                    getValueOrder()[i3] = i17;
                    getValueOrder()[i16] = i18;
                }
                i3++;
            }
        }
        int size2 = getSize();
        for (int i19 = i3; i19 < size2; i19++) {
            getValues()[getValueOrder()[i19]] = null;
        }
        setSize(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int index) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[index]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    private final Object valueAt(int index) {
        Object obj = this.values[this.valueOrder[index]];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    public final boolean add(Object value, T scope) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return getOrCreateIdentitySet(value).add(scope);
    }

    public final void clear() {
        int length = this.scopeSets.length;
        for (int i3 = 0; i3 < length; i3++) {
            IdentityArraySet<T> identityArraySet = this.scopeSets[i3];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            this.valueOrder[i3] = i3;
            this.values[i3] = null;
        }
        this.size = 0;
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return find(element) >= 0;
    }

    public final void forEachScopeOf(Object value, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(block, "block");
        int find = find(value);
        if (find >= 0) {
            Iterator<T> it = scopeSetAt(find).iterator();
            while (it.hasNext()) {
                block.invoke(it.next());
            }
        }
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean remove(Object value, T scope) {
        int i3;
        IdentityArraySet<T> identityArraySet;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int find = find(value);
        if (find < 0 || (identityArraySet = this.scopeSets[(i3 = this.valueOrder[find])]) == null) {
            return false;
        }
        boolean remove = identityArraySet.remove(scope);
        if (identityArraySet.size() == 0) {
            int i16 = find + 1;
            int i17 = this.size;
            if (i16 < i17) {
                int[] iArr = this.valueOrder;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, find, i16, i17);
            }
            int[] iArr2 = this.valueOrder;
            int i18 = this.size;
            iArr2[i18 - 1] = i3;
            this.values[i3] = null;
            this.size = i18 - 1;
        }
        return remove;
    }

    public final void removeScope(T scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int size = getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            int i17 = getValueOrder()[i16];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i17];
            Intrinsics.checkNotNull(identityArraySet);
            identityArraySet.remove(scope);
            if (identityArraySet.size() > 0) {
                if (i3 != i16) {
                    int i18 = getValueOrder()[i3];
                    getValueOrder()[i3] = i17;
                    getValueOrder()[i16] = i18;
                }
                i3++;
            }
        }
        int size2 = getSize();
        for (int i19 = i3; i19 < size2; i19++) {
            getValues()[getValueOrder()[i19]] = null;
        }
        setSize(i3);
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            int i17 = getValueOrder()[i16];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i17];
            Intrinsics.checkNotNull(identityArraySet);
            int size2 = identityArraySet.size();
            int i18 = 0;
            for (int i19 = 0; i19 < size2; i19++) {
                Object obj = identityArraySet.getValues()[i19];
                if (obj != null) {
                    if (!predicate.invoke(obj).booleanValue()) {
                        if (i18 != i19) {
                            identityArraySet.getValues()[i18] = obj;
                        }
                        i18++;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                }
            }
            int size3 = identityArraySet.size();
            for (int i26 = i18; i26 < size3; i26++) {
                identityArraySet.getValues()[i26] = null;
            }
            identityArraySet.setSize(i18);
            if (identityArraySet.size() > 0) {
                if (i3 != i16) {
                    int i27 = getValueOrder()[i3];
                    getValueOrder()[i3] = i17;
                    getValueOrder()[i16] = i27;
                }
                i3++;
            }
        }
        int size4 = getSize();
        for (int i28 = i3; i28 < size4; i28++) {
            getValues()[getValueOrder()[i28]] = null;
        }
        setSize(i3);
    }

    public final void setScopeSets(IdentityArraySet<T>[] identityArraySetArr) {
        Intrinsics.checkNotNullParameter(identityArraySetArr, "<set-?>");
        this.scopeSets = identityArraySetArr;
    }

    public final void setSize(int i3) {
        this.size = i3;
    }

    public final void setValueOrder(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.valueOrder = iArr;
    }

    public final void setValues(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        for (int i3 = midIndex - 1; -1 < i3; i3--) {
            Object obj = this.values[this.valueOrder[i3]];
            Intrinsics.checkNotNull(obj);
            if (obj == value) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj) != valueHash) {
                break;
            }
        }
        int i16 = midIndex + 1;
        int i17 = this.size;
        while (true) {
            if (i16 < i17) {
                Object obj2 = this.values[this.valueOrder[i16]];
                Intrinsics.checkNotNull(obj2);
                if (obj2 == value) {
                    return i16;
                }
                if (ActualJvm_jvmKt.identityHashCode(obj2) != valueHash) {
                    break;
                }
                i16++;
            } else {
                i16 = this.size;
                break;
            }
        }
    }

    public static /* synthetic */ void getScopeSets$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValueOrder$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
