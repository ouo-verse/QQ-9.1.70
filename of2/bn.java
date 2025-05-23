package of2;

import com.tencent.qqnt.kernel.nativeinterface.Clustering;
import com.tencent.qqnt.kernel.nativeinterface.MediaClusteringListRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringListRsp;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringListRsp;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bn {
    public static final Object[] a(MediaClusteringListRsp mediaClusteringListRsp) {
        Intrinsics.checkNotNullParameter(mediaClusteringListRsp, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("seq");
        arrayList.add(Integer.valueOf(mediaClusteringListRsp.seq));
        arrayList.add("result");
        arrayList.add(Integer.valueOf(mediaClusteringListRsp.result));
        arrayList.add("errMs");
        String errMs = mediaClusteringListRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
        arrayList.add(errMs);
        arrayList.add("type");
        arrayList.add(Integer.valueOf(mediaClusteringListRsp.type.ordinal()));
        arrayList.add("paginationInfo");
        byte[] paginationInfo = mediaClusteringListRsp.paginationInfo;
        Intrinsics.checkNotNullExpressionValue(paginationInfo, "paginationInfo");
        arrayList.add(paginationInfo);
        arrayList.add("isEnd");
        arrayList.add(Integer.valueOf(mediaClusteringListRsp.isEnd ? 1 : 0));
        arrayList.add("clusteringList");
        arrayList.add(Integer.valueOf(mediaClusteringListRsp.clusteringList.size()));
        ArrayList<Clustering> clusteringList = mediaClusteringListRsp.clusteringList;
        Intrinsics.checkNotNullExpressionValue(clusteringList, "clusteringList");
        for (Clustering elem : clusteringList) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = i.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("totalCount");
        arrayList.add(String.valueOf(mediaClusteringListRsp.totalCount));
        arrayList.add("pollBatchSeq");
        arrayList.add(String.valueOf(mediaClusteringListRsp.pollBatchSeq));
        arrayList.add("fileSetId");
        String fileSetId = mediaClusteringListRsp.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
