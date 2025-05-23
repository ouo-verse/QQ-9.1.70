package com.tencent.qqnt.qwallet.aio.pay;

import com.tencent.qqnt.qwallet.aio.pay.PaymentConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/e$b;", "", "stateInt", "", "default", "a", "(Lcom/tencent/qqnt/qwallet/aio/pay/e$b;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f {
    @NotNull
    public static final String a(@Nullable PaymentConfig.PaymentTypeItem paymentTypeItem, @Nullable Integer num, @NotNull String str) {
        List<PaymentConfig.StateDesc> b16;
        Object obj;
        String desc;
        Intrinsics.checkNotNullParameter(str, "default");
        if (paymentTypeItem != null && (b16 = paymentTypeItem.b()) != null) {
            Iterator<T> it = b16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((PaymentConfig.StateDesc) obj).getState(), num)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            PaymentConfig.StateDesc stateDesc = (PaymentConfig.StateDesc) obj;
            if (stateDesc != null && (desc = stateDesc.getDesc()) != null) {
                return desc;
            }
            return str;
        }
        return str;
    }

    public static /* synthetic */ String b(PaymentConfig.PaymentTypeItem paymentTypeItem, Integer num, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return a(paymentTypeItem, num, str);
    }
}
