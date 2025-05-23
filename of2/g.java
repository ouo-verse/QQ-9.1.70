package of2;

import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusRsp;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusRsp;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {
    public static final Object[] a(CheckDeviceStatusRsp checkDeviceStatusRsp) {
        Intrinsics.checkNotNullParameter(checkDeviceStatusRsp, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("seq");
        arrayList.add(Integer.valueOf(checkDeviceStatusRsp.seq));
        arrayList.add("invalidStatus");
        arrayList.add(Integer.valueOf(checkDeviceStatusRsp.invalidStatus.size()));
        HashMap<Integer, String> invalidStatus = checkDeviceStatusRsp.invalidStatus;
        Intrinsics.checkNotNullExpressionValue(invalidStatus, "invalidStatus");
        for (Map.Entry<Integer, String> entry : invalidStatus.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            arrayList.add(key);
            String value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            arrayList.add(value);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
