package of2;

import com.tencent.qqnt.kernel.nativeinterface.Clustering;
import com.tencent.qqnt.kernel.nativeinterface.Picture;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/Clustering;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/Clustering;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i {
    public static final Object[] a(Clustering clustering) {
        Intrinsics.checkNotNullParameter(clustering, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = clustering.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("clusteringId");
        String clusteringId = clustering.clusteringId;
        Intrinsics.checkNotNullExpressionValue(clusteringId, "clusteringId");
        arrayList.add(clusteringId);
        arrayList.add(AssetExtension.SCENE_THUMBNAIL);
        Picture thumbnail = clustering.thumbnail;
        Intrinsics.checkNotNullExpressionValue(thumbnail, "thumbnail");
        Object[] a16 = bq.a(thumbnail);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("name");
        String name = clustering.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        arrayList.add(name);
        arrayList.add("clusteringNum");
        arrayList.add(String.valueOf(clustering.clusteringNum));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
