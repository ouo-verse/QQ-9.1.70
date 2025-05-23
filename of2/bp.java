package of2;

import com.tencent.qqnt.kernel.nativeinterface.PhysicalInfo;
import com.tencent.qqnt.kernel.nativeinterface.ServerFileStatus;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PhysicalInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/PhysicalInfo;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/PhysicalInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bp {
    public static final Object[] a(PhysicalInfo physicalInfo) {
        Intrinsics.checkNotNullParameter(physicalInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("id");
        String id5 = physicalInfo.f359199id;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        arrayList.add(id5);
        arrayList.add("url");
        String url = physicalInfo.url;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        arrayList.add(url);
        arrayList.add("status");
        arrayList.add(Integer.valueOf(physicalInfo.status.ordinal()));
        arrayList.add("processing");
        String processing = physicalInfo.processing;
        Intrinsics.checkNotNullExpressionValue(processing, "processing");
        arrayList.add(processing);
        arrayList.add("localPath");
        String localPath = physicalInfo.localPath;
        Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
        arrayList.add(localPath);
        arrayList.add("width");
        arrayList.add(String.valueOf(physicalInfo.width));
        arrayList.add("height");
        arrayList.add(String.valueOf(physicalInfo.height));
        arrayList.add("time");
        arrayList.add(String.valueOf(physicalInfo.time));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final PhysicalInfo b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        PhysicalInfo physicalInfo = new PhysicalInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "id")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.f359199id = (String) next2;
            } else if (Intrinsics.areEqual(next, "url")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.url = (String) next3;
            } else if (Intrinsics.areEqual(next, "status")) {
                ServerFileStatus[] values = ServerFileStatus.values();
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                physicalInfo.status = values[((Integer) next4).intValue()];
            } else if (Intrinsics.areEqual(next, "processing")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.processing = (String) next5;
            } else if (Intrinsics.areEqual(next, "localPath")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.localPath = (String) next6;
            } else if (Intrinsics.areEqual(next, "width")) {
                Object next7 = it.next();
                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.width = Integer.parseInt((String) next7);
            } else if (Intrinsics.areEqual(next, "height")) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.height = Integer.parseInt((String) next8);
            } else if (Intrinsics.areEqual(next, "time")) {
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                physicalInfo.time = Integer.parseInt((String) next9);
            }
        }
        return physicalInfo;
    }
}
