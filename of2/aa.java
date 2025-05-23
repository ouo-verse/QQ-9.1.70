package of2;

import com.tencent.qqnt.kernel.nativeinterface.ClientPollControl;
import com.tencent.qqnt.kernel.nativeinterface.FileTransferProgress;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransferProgress;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransferProgress;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aa {
    public static final Object[] a(FileTransferProgress fileTransferProgress) {
        Intrinsics.checkNotNullParameter(fileTransferProgress, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("srvFileId");
        String srvFileId = fileTransferProgress.srvFileId;
        Intrinsics.checkNotNullExpressionValue(srvFileId, "srvFileId");
        arrayList.add(srvFileId);
        arrayList.add("transferProgressPercent");
        arrayList.add(Float.valueOf(fileTransferProgress.transferProgressPercent));
        arrayList.add("srvStatus");
        arrayList.add(Integer.valueOf(fileTransferProgress.srvStatus.ordinal()));
        arrayList.add("physicalId");
        String physicalId = fileTransferProgress.physicalId;
        Intrinsics.checkNotNullExpressionValue(physicalId, "physicalId");
        arrayList.add(physicalId);
        arrayList.add("thumbnailUrl");
        String thumbnailUrl = fileTransferProgress.thumbnailUrl;
        Intrinsics.checkNotNullExpressionValue(thumbnailUrl, "thumbnailUrl");
        arrayList.add(thumbnailUrl);
        arrayList.add("safeStatus");
        arrayList.add(Integer.valueOf(fileTransferProgress.safeStatus.ordinal()));
        arrayList.add("name");
        String name = fileTransferProgress.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        arrayList.add(name);
        arrayList.add("srvLastModifyTimestamp");
        arrayList.add(String.valueOf(fileTransferProgress.srvLastModifyTimestamp));
        arrayList.add("pollControl");
        ClientPollControl pollControl = fileTransferProgress.pollControl;
        Intrinsics.checkNotNullExpressionValue(pollControl, "pollControl");
        Object[] a16 = h.a(pollControl);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
