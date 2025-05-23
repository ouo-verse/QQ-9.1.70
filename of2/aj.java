package of2;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferTaskStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.Uploader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferTaskStatusInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferTaskStatusInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aj {
    public static final Object[] a(FlashTransferTaskStatusInfo flashTransferTaskStatusInfo) {
        Intrinsics.checkNotNullParameter(flashTransferTaskStatusInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = flashTransferTaskStatusInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("name");
        String name = flashTransferTaskStatusInfo.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        arrayList.add(name);
        arrayList.add("completedFileCount");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.completedFileCount));
        arrayList.add("failedFileCount");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.failedFileCount));
        arrayList.add("completedFileSize");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.completedFileSize));
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.totalFileCount));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.totalFileSize));
        arrayList.add("status");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.status.ordinal()));
        arrayList.add("fileSetStatus");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.fileSetStatus.ordinal()));
        arrayList.add("uploadStatus");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.uploadStatus.ordinal()));
        arrayList.add(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.downloadStatus.ordinal()));
        arrayList.add("speed");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.speed));
        arrayList.add("timeRemain");
        arrayList.add(String.valueOf(flashTransferTaskStatusInfo.timeRemain));
        arrayList.add("uploaders");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.uploaders.size()));
        ArrayList<Uploader> uploaders = flashTransferTaskStatusInfo.uploaders;
        Intrinsics.checkNotNullExpressionValue(uploaders, "uploaders");
        for (Uploader elem : uploaders) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = cb.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("transferType");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.transferType.ordinal()));
        arrayList.add("isLocalCreate");
        arrayList.add(Integer.valueOf(flashTransferTaskStatusInfo.isLocalCreate ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
