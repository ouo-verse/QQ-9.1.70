package of2;

import com.tencent.qqnt.kernel.nativeinterface.MediaClusteringDetailTotalInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringDetailTotalInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringDetailTotalInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bl {
    public static final Object[] a(MediaClusteringDetailTotalInfo mediaClusteringDetailTotalInfo) {
        Intrinsics.checkNotNullParameter(mediaClusteringDetailTotalInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("count");
        arrayList.add(String.valueOf(mediaClusteringDetailTotalInfo.count));
        arrayList.add("size");
        arrayList.add(String.valueOf(mediaClusteringDetailTotalInfo.size));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
