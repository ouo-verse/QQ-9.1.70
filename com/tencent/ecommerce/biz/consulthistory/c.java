package com.tencent.ecommerce.biz.consulthistory;

import com.tencent.ark.ark;
import com.tencent.ecommerce.base.network.api.IECResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import uj0.ECConsultHistory;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/consulthistory/c;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONArray;", ark.ARKMETADATA_JSON, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Lorg/json/JSONObject;", "data", "", "decodeData", "Luj0/a;", "d", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setHistoryList", "(Ljava/util/ArrayList;)V", "historyList", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ECConsultHistory> historyList = new ArrayList<>();

    private final ArrayList<String> b(JSONArray json) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (json != null) {
            int length = json.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(json.optString(i3));
            }
        }
        return arrayList;
    }

    public final ArrayList<ECConsultHistory> a() {
        return this.historyList;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECAfterSalesHistoryGetRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("consult_history");
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("history_records") : null;
        if (optJSONArray == null) {
            return true;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
            this.historyList.add(new ECConsultHistory(optJSONObject2.optInt("status"), optJSONObject2.optInt("role_type"), optJSONObject2.optString("title"), optJSONObject2.optString("pic_url"), optJSONObject2.optLong("time"), optJSONObject2.optString("content"), b(optJSONObject2.optJSONArray("imgs"))));
        }
        return true;
    }
}
