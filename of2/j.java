package of2;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.CompressFileFolderInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadStatus;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/CompressFileFolderInfo;", "", "", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/CompressFileFolderInfo;)[Ljava/lang/Object;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/CompressFileFolderInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j {
    public static final CompressFileFolderInfo a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        CompressFileFolderInfo compressFileFolderInfo = new CompressFileFolderInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                FileSetDownloadStatus[] values = FileSetDownloadStatus.values();
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                compressFileFolderInfo.downloadStatus = values[((Integer) next2).intValue()];
            } else if (Intrinsics.areEqual(next, "saveFileDirPath")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                compressFileFolderInfo.saveFileDirPath = (String) next3;
            } else if (Intrinsics.areEqual(next, "totalFileCount")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                compressFileFolderInfo.totalFileCount = Long.parseLong((String) next4);
            } else if (Intrinsics.areEqual(next, "totalFileSize")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                compressFileFolderInfo.totalFileSize = Long.parseLong((String) next5);
            }
        }
        return compressFileFolderInfo;
    }

    public static final Object[] b(CompressFileFolderInfo compressFileFolderInfo) {
        Intrinsics.checkNotNullParameter(compressFileFolderInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        arrayList.add(Integer.valueOf(compressFileFolderInfo.downloadStatus.ordinal()));
        arrayList.add("saveFileDirPath");
        String saveFileDirPath = compressFileFolderInfo.saveFileDirPath;
        Intrinsics.checkNotNullExpressionValue(saveFileDirPath, "saveFileDirPath");
        arrayList.add(saveFileDirPath);
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(compressFileFolderInfo.totalFileCount));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(compressFileFolderInfo.totalFileSize));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
