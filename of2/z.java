package of2;

import com.tencent.qqnt.kernel.nativeinterface.FileSet;
import com.tencent.qqnt.kernel.nativeinterface.FileSetUploadProgressInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileSetUploadProgressInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileSetUploadProgressInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class z {
    public static final Object[] a(FileSetUploadProgressInfo fileSetUploadProgressInfo) {
        Intrinsics.checkNotNullParameter(fileSetUploadProgressInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSet");
        FileSet fileSet = fileSetUploadProgressInfo.fileSet;
        Intrinsics.checkNotNullExpressionValue(fileSet, "fileSet");
        Object[] a16 = w.a(fileSet);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("uploadedFileCount");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.uploadedFileCount));
        arrayList.add("failedFileCount");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.failedFileCount));
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.totalFileCount));
        arrayList.add("uploadedFileSize");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.uploadedFileSize));
        arrayList.add("uploadSpeed");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.uploadSpeed));
        arrayList.add("vipUploadSpeed");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.vipUploadSpeed));
        arrayList.add("timeRemain");
        arrayList.add(String.valueOf(fileSetUploadProgressInfo.timeRemain));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
