package of2;

import com.tencent.qqnt.kernel.nativeinterface.UserDownloadOperationInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/UserDownloadOperationInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/UserDownloadOperationInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class cc {
    public static final Object[] a(UserDownloadOperationInfo userDownloadOperationInfo) {
        Intrinsics.checkNotNullParameter(userDownloadOperationInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = userDownloadOperationInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("allFileList");
        arrayList.add(Integer.valueOf(userDownloadOperationInfo.allFileList.size()));
        ArrayList<String> allFileList = userDownloadOperationInfo.allFileList;
        Intrinsics.checkNotNullExpressionValue(allFileList, "allFileList");
        arrayList.addAll(allFileList);
        arrayList.add("safeBeatFileList");
        arrayList.add(Integer.valueOf(userDownloadOperationInfo.safeBeatFileList.size()));
        ArrayList<String> safeBeatFileList = userDownloadOperationInfo.safeBeatFileList;
        Intrinsics.checkNotNullExpressionValue(safeBeatFileList, "safeBeatFileList");
        arrayList.addAll(safeBeatFileList);
        arrayList.add("safePendingFileList");
        arrayList.add(Integer.valueOf(userDownloadOperationInfo.safePendingFileList.size()));
        ArrayList<String> safePendingFileList = userDownloadOperationInfo.safePendingFileList;
        Intrinsics.checkNotNullExpressionValue(safePendingFileList, "safePendingFileList");
        arrayList.addAll(safePendingFileList);
        arrayList.add("uploadFailedFileList");
        arrayList.add(Integer.valueOf(userDownloadOperationInfo.uploadFailedFileList.size()));
        ArrayList<String> uploadFailedFileList = userDownloadOperationInfo.uploadFailedFileList;
        Intrinsics.checkNotNullExpressionValue(uploadFailedFileList, "uploadFailedFileList");
        arrayList.addAll(uploadFailedFileList);
        arrayList.add("downloadRunningFileList");
        arrayList.add(Integer.valueOf(userDownloadOperationInfo.downloadRunningFileList.size()));
        ArrayList<String> downloadRunningFileList = userDownloadOperationInfo.downloadRunningFileList;
        Intrinsics.checkNotNullExpressionValue(downloadRunningFileList, "downloadRunningFileList");
        arrayList.addAll(downloadRunningFileList);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
