package kotlinx.coroutines.internal;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", QCircleDaTongConstant.ElementParamValue.PLUS, DTConstants.TAG.ELEMENT, "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@JvmInline
/* loaded from: classes28.dex */
public final class InlineList<E> {

    @Nullable
    private final Object holder;

    /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InlineList m2037boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m2039constructorimpl$default(Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        return m2038constructorimpl(obj);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2040equalsimpl(Object obj, Object obj2) {
        if (!(obj2 instanceof InlineList) || !Intrinsics.areEqual(obj, ((InlineList) obj2).getHolder())) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2041equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: forEachReversed-impl, reason: not valid java name */
    public static final void m2042forEachReversedimpl(Object obj, @NotNull Function1<? super E, Unit> function1) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            function1.invoke(obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            function1.invoke((Object) arrayList.get(size));
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2043hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @NotNull
    /* renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m2044plusFjFbRPM(Object obj, E e16) {
        if (obj == null) {
            return m2038constructorimpl(e16);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e16);
            return m2038constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e16);
        return m2038constructorimpl(arrayList);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2045toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m2040equalsimpl(getHolder(), obj);
    }

    public int hashCode() {
        return m2043hashCodeimpl(getHolder());
    }

    public String toString() {
        return m2045toStringimpl(getHolder());
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Object getHolder() {
        return this.holder;
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m2038constructorimpl(@Nullable Object obj) {
        return obj;
    }
}
