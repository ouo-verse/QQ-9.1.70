package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import android.content.Context;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001b\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "", "Landroid/content/Context;", "context", "", "name", "", "nameResId", "I", "id", "<init>", "(Ljava/lang/String;III)V", "Companion", "a", "UNKNOWN", "QQ", "WECHAT", "ALL", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum PayType {
    UNKNOWN(R.string.wvs, 0),
    QQ(R.string.wvj, 1),
    WECHAT(R.string.wvv, 2),
    ALL(R.string.f169651wv0, 3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int id;
    public final int nameResId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType$a;", "", "", "id", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final PayType a(int id5) {
            PayType payType;
            PayType[] values = PayType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    payType = null;
                    break;
                }
                payType = values[i3];
                if (payType.id == id5) {
                    break;
                }
                i3++;
            }
            return payType != null ? payType : PayType.UNKNOWN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    PayType(int i3, int i16) {
        this.nameResId = i3;
        this.id = i16;
    }

    public final String name(Context context) {
        return context.getString(this.nameResId);
    }
}
