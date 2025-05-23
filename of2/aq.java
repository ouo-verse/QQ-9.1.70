package of2;

import com.tencent.qqnt.kernel.nativeinterface.FileList;
import com.tencent.qqnt.kernel.nativeinterface.GetCompressedFileFolderRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GetCompressedFileFolderRsp;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetCompressedFileFolderRsp;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aq {
    public static final Object[] a(GetCompressedFileFolderRsp getCompressedFileFolderRsp) {
        Intrinsics.checkNotNullParameter(getCompressedFileFolderRsp, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("seq");
        arrayList.add(Integer.valueOf(getCompressedFileFolderRsp.seq));
        arrayList.add("result");
        arrayList.add(Integer.valueOf(getCompressedFileFolderRsp.result));
        arrayList.add("errMs");
        String errMs = getCompressedFileFolderRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
        arrayList.add(errMs);
        arrayList.add("fileLists");
        arrayList.add(Integer.valueOf(getCompressedFileFolderRsp.fileLists.size()));
        ArrayList<FileList> fileLists = getCompressedFileFolderRsp.fileLists;
        Intrinsics.checkNotNullExpressionValue(fileLists, "fileLists");
        for (FileList elem : fileLists) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = v.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(getCompressedFileFolderRsp.totalFileCount));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(getCompressedFileFolderRsp.totalFileSize));
        arrayList.add("remainingTime");
        arrayList.add(String.valueOf(getCompressedFileFolderRsp.remainingTime));
        arrayList.add("remainingMsg");
        String remainingMsg = getCompressedFileFolderRsp.remainingMsg;
        Intrinsics.checkNotNullExpressionValue(remainingMsg, "remainingMsg");
        arrayList.add(remainingMsg);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
