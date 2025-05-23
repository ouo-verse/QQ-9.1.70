package of2;

import com.tencent.qqnt.kernel.nativeinterface.FlashTransferThumbnailInfo;
import com.tencent.qqnt.kernel.nativeinterface.Specification;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferThumbnailInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferThumbnailInfo;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferThumbnailInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class al {
    public static final Object[] a(FlashTransferThumbnailInfo flashTransferThumbnailInfo) {
        Intrinsics.checkNotNullParameter(flashTransferThumbnailInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = flashTransferThumbnailInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("fileId");
        String fileId = flashTransferThumbnailInfo.fileId;
        Intrinsics.checkNotNullExpressionValue(fileId, "fileId");
        arrayList.add(fileId);
        arrayList.add("spec");
        arrayList.add(Integer.valueOf(flashTransferThumbnailInfo.spec.ordinal()));
        arrayList.add("url");
        String url = flashTransferThumbnailInfo.url;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        arrayList.add(url);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final FlashTransferThumbnailInfo b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        FlashTransferThumbnailInfo flashTransferThumbnailInfo = new FlashTransferThumbnailInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                flashTransferThumbnailInfo.fileSetId = (String) next2;
            } else if (Intrinsics.areEqual(next, "fileId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                flashTransferThumbnailInfo.fileId = (String) next3;
            } else if (Intrinsics.areEqual(next, "spec")) {
                Specification[] values = Specification.values();
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                flashTransferThumbnailInfo.spec = values[((Integer) next4).intValue()];
            } else if (Intrinsics.areEqual(next, "url")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                flashTransferThumbnailInfo.url = (String) next5;
            }
        }
        return flashTransferThumbnailInfo;
    }
}
