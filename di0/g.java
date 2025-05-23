package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Ldi0/g;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "roomId", "<init>", "(Ljava/lang/String;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class g implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String roomId;

    public g(String str) {
        this.roomId = str;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("live_room_id", this.roomId);
        return jSONObject;
    }
}
