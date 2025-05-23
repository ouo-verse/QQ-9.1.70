package of2;

import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.qqnt.kernel.nativeinterface.FileFilterType;
import com.tencent.qqnt.kernel.nativeinterface.GetLocalFileListByStatusesReq;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/GetLocalFileListByStatusesReq;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/GetLocalFileListByStatusesReq;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class be {
    public static final GetLocalFileListByStatusesReq a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        GetLocalFileListByStatusesReq getLocalFileListByStatusesReq = new GetLocalFileListByStatusesReq();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                getLocalFileListByStatusesReq.fileSetId = (String) next2;
            } else if (Intrinsics.areEqual(next, "parentId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                getLocalFileListByStatusesReq.parentId = (String) next3;
            } else if (Intrinsics.areEqual(next, "indexPath")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                getLocalFileListByStatusesReq.indexPath = (String) next4;
            } else if (Intrinsics.areEqual(next, VasWebReport.WEB_CORE_DATA_FLAGS)) {
                FileFilterType[] values = FileFilterType.values();
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                getLocalFileListByStatusesReq.filterType = values[((Integer) next5).intValue()];
            }
        }
        return getLocalFileListByStatusesReq;
    }
}
