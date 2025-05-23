package di0;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ecommerce.base.network.api.IECResponse;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u0000 \u00182\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006\u0019"}, d2 = {"Ldi0/j;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "J", "a", "()J", "setOrderMoney", "(J)V", "orderMoney", "e", "b", "setOrderNum", "orderNum", "f", "c", "setPersonNum", "personNum", "<init>", "()V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class j implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long orderMoney;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long orderNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long personNum;

    /* renamed from: a, reason: from getter */
    public final long getOrderMoney() {
        return this.orderMoney;
    }

    /* renamed from: b, reason: from getter */
    public final long getOrderNum() {
        return this.orderNum;
    }

    /* renamed from: c, reason: from getter */
    public final long getPersonNum() {
        return this.personNum;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("LiveTransactionGetStatRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.orderMoney = data.optLong(WidgetCacheConstellationData.MONEY);
        this.orderNum = data.optLong("order_num");
        this.personNum = data.optLong("person_num");
        return true;
    }
}
