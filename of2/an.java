package of2;

import com.tencent.qqnt.kernel.nativeinterface.FolderDownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FolderDownloadInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FolderDownloadInfo;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/FolderDownloadInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class an {
    public static final Object[] a(FolderDownloadInfo folderDownloadInfo) {
        Intrinsics.checkNotNullParameter(folderDownloadInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("totalDownloadedFileSize");
        arrayList.add(String.valueOf(folderDownloadInfo.totalDownloadedFileSize));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(folderDownloadInfo.totalFileSize));
        arrayList.add("totalDownloadFileCount");
        arrayList.add(String.valueOf(folderDownloadInfo.totalDownloadFileCount));
        arrayList.add("successCount");
        arrayList.add(String.valueOf(folderDownloadInfo.successCount));
        arrayList.add("failedCount");
        arrayList.add(String.valueOf(folderDownloadInfo.failedCount));
        arrayList.add("pausedCount");
        arrayList.add(String.valueOf(folderDownloadInfo.pausedCount));
        arrayList.add("cancelCount");
        arrayList.add(String.valueOf(folderDownloadInfo.cancelCount));
        arrayList.add("downloadingCount");
        arrayList.add(String.valueOf(folderDownloadInfo.downloadingCount));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final FolderDownloadInfo b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        FolderDownloadInfo folderDownloadInfo = new FolderDownloadInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "totalDownloadedFileSize")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.totalDownloadedFileSize = Long.parseLong((String) next2);
            } else if (Intrinsics.areEqual(next, "totalFileSize")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.totalFileSize = Long.parseLong((String) next3);
            } else if (Intrinsics.areEqual(next, "totalDownloadFileCount")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.totalDownloadFileCount = Integer.parseInt((String) next4);
            } else if (Intrinsics.areEqual(next, "successCount")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.successCount = Integer.parseInt((String) next5);
            } else if (Intrinsics.areEqual(next, "failedCount")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.failedCount = Integer.parseInt((String) next6);
            } else if (Intrinsics.areEqual(next, "pausedCount")) {
                Object next7 = it.next();
                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.pausedCount = Integer.parseInt((String) next7);
            } else if (Intrinsics.areEqual(next, "cancelCount")) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.cancelCount = Integer.parseInt((String) next8);
            } else if (Intrinsics.areEqual(next, "downloadingCount")) {
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                folderDownloadInfo.downloadingCount = Integer.parseInt((String) next9);
            }
        }
        return folderDownloadInfo;
    }
}
