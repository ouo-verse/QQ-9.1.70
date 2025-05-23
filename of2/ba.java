package of2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernel.nativeinterface.FileSet;
import com.tencent.qqnt.kernel.nativeinterface.GetFileSetListRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GetFileSetListRsp;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetFileSetListRsp;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ba {
    public static final Object[] a(GetFileSetListRsp getFileSetListRsp) {
        Intrinsics.checkNotNullParameter(getFileSetListRsp, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("seq");
        arrayList.add(Integer.valueOf(getFileSetListRsp.seq));
        arrayList.add("result");
        arrayList.add(Integer.valueOf(getFileSetListRsp.result));
        arrayList.add("errMs");
        String errMs = getFileSetListRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
        arrayList.add(errMs);
        arrayList.add("fileSetList");
        arrayList.add(Integer.valueOf(getFileSetListRsp.fileSetList.size()));
        ArrayList<FileSet> fileSetList = getFileSetListRsp.fileSetList;
        Intrinsics.checkNotNullExpressionValue(fileSetList, "fileSetList");
        for (FileSet elem : fileSetList) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = w.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("totalFileSetCount");
        arrayList.add(String.valueOf(getFileSetListRsp.totalFileSetCount));
        arrayList.add("isEnd");
        arrayList.add(Integer.valueOf(getFileSetListRsp.isEnd ? 1 : 0));
        arrayList.add("paginationInfo");
        byte[] paginationInfo = getFileSetListRsp.paginationInfo;
        Intrinsics.checkNotNullExpressionValue(paginationInfo, "paginationInfo");
        arrayList.add(paginationInfo);
        arrayList.add(QAdRewardDefine$VideoParams.ISCACHE);
        arrayList.add(Integer.valueOf(getFileSetListRsp.isCache ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
