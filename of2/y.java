package of2;

import com.tencent.qqnt.kernel.nativeinterface.AIClusteringStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleUploadInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileSetSimpleUploadInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileSetSimpleUploadInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class y {
    public static final Object[] a(FileSetSimpleUploadInfo fileSetSimpleUploadInfo) {
        Intrinsics.checkNotNullParameter(fileSetSimpleUploadInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = fileSetSimpleUploadInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("fileSetStatus");
        arrayList.add(Integer.valueOf(fileSetSimpleUploadInfo.fileSetStatus.ordinal()));
        arrayList.add("aiClusteringStatus");
        AIClusteringStatus aiClusteringStatus = fileSetSimpleUploadInfo.aiClusteringStatus;
        Intrinsics.checkNotNullExpressionValue(aiClusteringStatus, "aiClusteringStatus");
        Object[] a16 = a.a(aiClusteringStatus);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("firstLevelItemCount");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.firstLevelItemCount));
        arrayList.add("uploadStatus");
        arrayList.add(Integer.valueOf(fileSetSimpleUploadInfo.uploadStatus.ordinal()));
        arrayList.add("uploadedFileCount");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.uploadedFileCount));
        arrayList.add("failedFileCount");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.failedFileCount));
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.totalFileCount));
        arrayList.add("uploadedFileSize");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.uploadedFileSize));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.totalFileSize));
        arrayList.add("uploadSpeed");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.uploadSpeed));
        arrayList.add("timeRemain");
        arrayList.add(String.valueOf(fileSetSimpleUploadInfo.timeRemain));
        arrayList.add("transferType");
        arrayList.add(Integer.valueOf(fileSetSimpleUploadInfo.transferType.ordinal()));
        arrayList.add("isLocalCreate");
        arrayList.add(Integer.valueOf(fileSetSimpleUploadInfo.isLocalCreate ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
