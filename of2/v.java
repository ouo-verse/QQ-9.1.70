package of2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FileList;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileList;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileList;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class v {
    public static final Object[] a(FileList fileList) {
        Intrinsics.checkNotNullParameter(fileList, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("parentId");
        String parentId = fileList.parentId;
        Intrinsics.checkNotNullExpressionValue(parentId, "parentId");
        arrayList.add(parentId);
        arrayList.add("depth");
        arrayList.add(String.valueOf(fileList.depth));
        arrayList.add("fileList");
        arrayList.add(Integer.valueOf(fileList.fileList.size()));
        ArrayList<File> fileList2 = fileList.fileList;
        Intrinsics.checkNotNullExpressionValue(fileList2, "fileList");
        for (File elem : fileList2) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = u.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("paginationInfo");
        byte[] paginationInfo = fileList.paginationInfo;
        Intrinsics.checkNotNullExpressionValue(paginationInfo, "paginationInfo");
        arrayList.add(paginationInfo);
        arrayList.add("isEnd");
        arrayList.add(Integer.valueOf(fileList.isEnd ? 1 : 0));
        arrayList.add(QAdRewardDefine$VideoParams.ISCACHE);
        arrayList.add(Integer.valueOf(fileList.isCache ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
