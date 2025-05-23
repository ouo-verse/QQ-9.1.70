package of2;

import com.tencent.qqnt.kernel.nativeinterface.ReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.SortCondition;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/ReqInfo;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/ReqInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class br {
    public static final ReqInfo a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        ReqInfo reqInfo = new ReqInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "parentId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                reqInfo.parentId = (String) next2;
            } else if (Intrinsics.areEqual(next, "reqDepth")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                reqInfo.reqDepth = Integer.parseInt((String) next3);
            } else if (Intrinsics.areEqual(next, "reqIndexPath")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                reqInfo.reqIndexPath = (String) next4;
            } else if (Intrinsics.areEqual(next, "count")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                reqInfo.count = Integer.parseInt((String) next5);
            } else if (Intrinsics.areEqual(next, "paginationInfo")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.ByteArray");
                reqInfo.paginationInfo = (byte[]) next6;
            } else {
                if (Intrinsics.areEqual(next, "filterCondition")) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next7).intValue();
                    Object[] objArr2 = new Object[intValue];
                    for (int i3 = 0; i3 < intValue; i3++) {
                        objArr2[i3] = it.next();
                    }
                    reqInfo.filterCondition = ac.a(objArr2);
                } else if (Intrinsics.areEqual(next, "sortConditions")) {
                    Object next8 = it.next();
                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next8).intValue();
                    ArrayList<SortCondition> arrayList = new ArrayList<>();
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        Object next9 = it.next();
                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                        int intValue3 = ((Integer) next9).intValue();
                        Object[] objArr3 = new Object[intValue3];
                        for (int i17 = 0; i17 < intValue3; i17++) {
                            objArr3[i17] = it.next();
                        }
                        arrayList.add(bw.a(objArr3));
                    }
                    reqInfo.sortConditions = arrayList;
                } else if (Intrinsics.areEqual(next, "isNeedPhysicalInfoReady")) {
                    Object next10 = it.next();
                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                    reqInfo.isNeedPhysicalInfoReady = ((Integer) next10).intValue() == 1;
                }
            }
        }
        return reqInfo;
    }
}
