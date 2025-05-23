package of2;

import com.tencent.qqnt.kernel.nativeinterface.FlashTransferMsgTarget;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgReq;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferSendMsgReq;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferSendMsgReq;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ah {
    public static final FlashTransferSendMsgReq a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        FlashTransferSendMsgReq flashTransferSendMsgReq = new FlashTransferSendMsgReq();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "targets")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next2).intValue();
                ArrayList<FlashTransferMsgTarget> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next3 = it.next();
                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next3).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    arrayList.add(ag.b(objArr2));
                }
                flashTransferSendMsgReq.targets = arrayList;
            } else if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                flashTransferSendMsgReq.fileSetId = (String) next4;
            }
        }
        return flashTransferSendMsgReq;
    }
}
