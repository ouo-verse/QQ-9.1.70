package of2;

import com.tencent.qqnt.kernel.nativeinterface.FlashFileSetDownloadInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FlashFileSetDownloadInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FlashFileSetDownloadInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ae {
    public static final Object[] a(FlashFileSetDownloadInfo flashFileSetDownloadInfo) {
        Intrinsics.checkNotNullParameter(flashFileSetDownloadInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("curDownLoadFailFileNum");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curDownLoadFailFileNum));
        arrayList.add("curDownLoadedPauseFileNum");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curDownLoadedPauseFileNum));
        arrayList.add("curDownLoadedFileNum");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curDownLoadedFileNum));
        arrayList.add("curDownloadingFileNum");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curDownloadingFileNum));
        arrayList.add("totalDownLoadedFileNum");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.totalDownLoadedFileNum));
        arrayList.add("curDownLoadedBytes");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curDownLoadedBytes));
        arrayList.add("totalDownLoadedBytes");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.totalDownLoadedBytes));
        arrayList.add("curSpeedBps");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.curSpeedBps));
        arrayList.add("avgSpeedBps");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.avgSpeedBps));
        arrayList.add("maxSpeedBps");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.maxSpeedBps));
        arrayList.add("remainDownLoadSeconds");
        arrayList.add(String.valueOf(flashFileSetDownloadInfo.remainDownLoadSeconds));
        arrayList.add("failFileIdList");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.failFileIdList.size()));
        ArrayList<String> failFileIdList = flashFileSetDownloadInfo.failFileIdList;
        Intrinsics.checkNotNullExpressionValue(failFileIdList, "failFileIdList");
        arrayList.addAll(failFileIdList);
        arrayList.add("allFileIdList");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.allFileIdList.size()));
        ArrayList<String> allFileIdList = flashFileSetDownloadInfo.allFileIdList;
        Intrinsics.checkNotNullExpressionValue(allFileIdList, "allFileIdList");
        arrayList.addAll(allFileIdList);
        arrayList.add("hasNormalFileDownloading");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.hasNormalFileDownloading ? 1 : 0));
        arrayList.add("onlyCompressInnerFileDownloading");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.onlyCompressInnerFileDownloading ? 1 : 0));
        arrayList.add("isAllFileAlreadyDownloaded");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.isAllFileAlreadyDownloaded ? 1 : 0));
        arrayList.add("saveFileSetDir");
        String saveFileSetDir = flashFileSetDownloadInfo.saveFileSetDir;
        Intrinsics.checkNotNullExpressionValue(saveFileSetDir, "saveFileSetDir");
        arrayList.add(saveFileSetDir);
        arrayList.add("allWaitingStatusTask");
        arrayList.add(Integer.valueOf(flashFileSetDownloadInfo.allWaitingStatusTask ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
