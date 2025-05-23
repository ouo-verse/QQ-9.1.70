package of2;

import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.qqnt.kernel.nativeinterface.ClusteringType;
import com.tencent.qqnt.kernel.nativeinterface.FileFilterType;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSceneType;
import com.tencent.qqnt.kernel.nativeinterface.MediaClusteringDetailReq;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringDetailReq;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringDetailReq;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bj {
    public static final MediaClusteringDetailReq a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        MediaClusteringDetailReq mediaClusteringDetailReq = new MediaClusteringDetailReq();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "seq")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                mediaClusteringDetailReq.seq = ((Integer) next2).intValue();
            } else if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                mediaClusteringDetailReq.fileSetId = (String) next3;
            } else if (Intrinsics.areEqual(next, "type")) {
                ClusteringType[] values = ClusteringType.values();
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                mediaClusteringDetailReq.type = values[((Integer) next4).intValue()];
            } else if (Intrinsics.areEqual(next, "clusteringId")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                mediaClusteringDetailReq.clusteringId = (String) next5;
            } else if (Intrinsics.areEqual(next, VasWebReport.WEB_CORE_DATA_FLAGS)) {
                FileFilterType[] values2 = FileFilterType.values();
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                mediaClusteringDetailReq.filterType = values2[((Integer) next6).intValue()];
            } else if (Intrinsics.areEqual(next, "paginationInfo")) {
                Object next7 = it.next();
                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.ByteArray");
                mediaClusteringDetailReq.paginationInfo = (byte[]) next7;
            } else if (Intrinsics.areEqual(next, "count")) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                mediaClusteringDetailReq.count = Integer.parseInt((String) next8);
            } else if (Intrinsics.areEqual(next, "sceneType")) {
                FlashTransferSceneType[] values3 = FlashTransferSceneType.values();
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                mediaClusteringDetailReq.sceneType = values3[((Integer) next9).intValue()];
            }
        }
        return mediaClusteringDetailReq;
    }
}
