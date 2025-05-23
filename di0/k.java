package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0006B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Ldi0/k;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "", "a", "Ljava/util/List;", "activityIdList", "<init>", "(Ljava/util/List;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class k implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<String> activityIdList;

    public k(List<String> list) {
        this.activityIdList = list;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.activityIdList;
            if (list != null) {
                for (String str : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("query_id_type", 4);
                    jSONObject2.put("query_id", str);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("id", jSONArray);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowGetActivitiesReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
