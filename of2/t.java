package of2;

import com.tencent.qqnt.kernel.nativeinterface.FileDownLoadInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserActionFileDownLoadStatus;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileDownLoadInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileDownLoadInfo;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/FileDownLoadInfo;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class t {
    public static final Object[] a(FileDownLoadInfo fileDownLoadInfo) {
        Intrinsics.checkNotNullParameter(fileDownLoadInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("status");
        arrayList.add(Integer.valueOf(fileDownLoadInfo.status.ordinal()));
        arrayList.add("curDownLoadedBytes");
        arrayList.add(String.valueOf(fileDownLoadInfo.curDownLoadedBytes));
        arrayList.add("totalFileBytes");
        arrayList.add(String.valueOf(fileDownLoadInfo.totalFileBytes));
        arrayList.add("errorCode");
        arrayList.add(String.valueOf(fileDownLoadInfo.errorCode));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final FileDownLoadInfo b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        FileDownLoadInfo fileDownLoadInfo = new FileDownLoadInfo();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "status")) {
                UserActionFileDownLoadStatus[] values = UserActionFileDownLoadStatus.values();
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                fileDownLoadInfo.status = values[((Integer) next2).intValue()];
            } else if (Intrinsics.areEqual(next, "curDownLoadedBytes")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                fileDownLoadInfo.curDownLoadedBytes = Long.parseLong((String) next3);
            } else if (Intrinsics.areEqual(next, "totalFileBytes")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                fileDownLoadInfo.totalFileBytes = Long.parseLong((String) next4);
            } else if (Intrinsics.areEqual(next, "errorCode")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                fileDownLoadInfo.errorCode = Integer.parseInt((String) next5);
            }
        }
        return fileDownLoadInfo;
    }
}
