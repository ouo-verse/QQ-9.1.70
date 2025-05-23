package of2;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.SimpleFileSetStatusInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bv {
    public static final Object[] a(SimpleFileSetStatusInfo simpleFileSetStatusInfo) {
        Intrinsics.checkNotNullParameter(simpleFileSetStatusInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetSimpleInfo");
        FileSetSimpleInfo fileSetSimpleInfo = simpleFileSetStatusInfo.fileSetSimpleInfo;
        Intrinsics.checkNotNullExpressionValue(fileSetSimpleInfo, "fileSetSimpleInfo");
        Object[] a16 = x.a(fileSetSimpleInfo);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("completedFileCount");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.completedFileCount));
        arrayList.add("failedFileCount");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.failedFileCount));
        arrayList.add("completedFileSize");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.completedFileSize));
        arrayList.add("totalTaskFileCount");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.totalTaskFileCount));
        arrayList.add("totalTaskFileSize");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.totalTaskFileSize));
        arrayList.add("status");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.status.ordinal()));
        arrayList.add("fileSetStatus");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.fileSetStatus.ordinal()));
        arrayList.add("uploadStatus");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.uploadStatus.ordinal()));
        arrayList.add(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.downloadStatus.ordinal()));
        arrayList.add("uploadPauseReason");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.uploadPauseReason.ordinal()));
        arrayList.add("downloadPauseReason");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.downloadPauseReason.ordinal()));
        arrayList.add("speed");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.speed));
        arrayList.add("timeRemain");
        arrayList.add(String.valueOf(simpleFileSetStatusInfo.timeRemain));
        arrayList.add("isLocalCreate");
        arrayList.add(Integer.valueOf(simpleFileSetStatusInfo.isLocalCreate ? 1 : 0));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
