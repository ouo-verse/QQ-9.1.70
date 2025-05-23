package of2;

import com.tencent.qqnt.kernel.nativeinterface.FlashTransferUploadThumbnailInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferUploadThumbnailInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferUploadThumbnailInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class am {
    public static final Object[] a(FlashTransferUploadThumbnailInfo flashTransferUploadThumbnailInfo) {
        Intrinsics.checkNotNullParameter(flashTransferUploadThumbnailInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("result");
        arrayList.add(Integer.valueOf(flashTransferUploadThumbnailInfo.result));
        arrayList.add("errMsg");
        String errMsg = flashTransferUploadThumbnailInfo.errMsg;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        arrayList.add(errMsg);
        arrayList.add("fileSetId");
        String fileSetId = flashTransferUploadThumbnailInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("cliFileId");
        String cliFileId = flashTransferUploadThumbnailInfo.cliFileId;
        Intrinsics.checkNotNullExpressionValue(cliFileId, "cliFileId");
        arrayList.add(cliFileId);
        arrayList.add("thumbnailPath");
        String thumbnailPath = flashTransferUploadThumbnailInfo.thumbnailPath;
        Intrinsics.checkNotNullExpressionValue(thumbnailPath, "thumbnailPath");
        arrayList.add(thumbnailPath);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
