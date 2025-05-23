package of2;

import com.tencent.qqnt.kernel.nativeinterface.FileSetStatus;
import com.tencent.qqnt.kernel.nativeinterface.UpdateFlashTransferParam;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/UpdateFlashTransferParam;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/UpdateFlashTransferParam;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bz {
    public static final UpdateFlashTransferParam a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        UpdateFlashTransferParam updateFlashTransferParam = new UpdateFlashTransferParam();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                updateFlashTransferParam.fileSetId = (String) next2;
            } else if (Intrinsics.areEqual(next, "name")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                updateFlashTransferParam.name = (String) next3;
            } else if (Intrinsics.areEqual(next, "status")) {
                FileSetStatus[] values = FileSetStatus.values();
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                updateFlashTransferParam.status = values[((Integer) next4).intValue()];
            }
        }
        return updateFlashTransferParam;
    }
}
