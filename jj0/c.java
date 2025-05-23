package jj0;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ljj0/c;", "", "Lorg/json/JSONArray;", "b", "f", "c", "d", "Lorg/json/JSONObject;", "e", "", "a", "Lorg/json/JSONObject;", "sumDataJSONObject", "<init>", "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final JSONObject sumDataJSONObject;

    public c(JSONObject jSONObject) {
        this.sumDataJSONObject = jSONObject;
    }

    private final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "data_amount");
        jSONObject.put("title", "\u6210\u4ea4\u91d1\u989d");
        jSONObject.put("selected", true);
        jSONArray.mo162put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("key", "data_count");
        jSONObject2.put("title", "\u6210\u4ea4\u5355\u6570");
        jSONObject2.put("selected", false);
        jSONArray.mo162put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("key", "data_people");
        jSONObject3.put("title", "\u6210\u4ea4\u4eba\u6570");
        jSONObject3.put("selected", false);
        jSONArray.mo162put(jSONObject3);
        return jSONArray;
    }

    private final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "all");
        jSONObject.put("title", "\u5168\u90e8");
        jSONObject.put("typeNum", 0);
        jSONObject.put("selected", true);
        jSONArray.mo162put(jSONObject);
        return jSONArray;
    }

    private final JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "order_time_today");
        jSONObject.put("title", "\u4eca\u65e5");
        jSONObject.put("selected", true);
        jSONArray.mo162put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("key", "order_time_last_7");
        jSONObject2.put("title", "\u8fd17\u5929");
        jSONObject2.put("selected", false);
        jSONArray.mo162put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("key", "order_time_last_30");
        jSONObject3.put("title", "\u8fd130\u5929");
        jSONObject3.put("selected", false);
        jSONArray.mo162put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("key", "order_time_diy");
        jSONObject4.put("title", "\u81ea\u5b9a\u4e49");
        jSONObject4.put("selected", false);
        jSONArray.mo162put(jSONObject4);
        return jSONArray;
    }

    private final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WidgetCacheConstellationData.MONEY, this.sumDataJSONObject.optString(WidgetCacheConstellationData.MONEY));
        jSONObject.put("order_num", this.sumDataJSONObject.optLong("order_num"));
        jSONObject.put("person_num", this.sumDataJSONObject.optLong("person_num"));
        jSONObject.put("last_modified_time", this.sumDataJSONObject.optString("last_modified_time"));
        return jSONObject;
    }

    private final JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "time_filter_last_7");
        jSONObject.put("title", "\u8fd17\u5929");
        jSONObject.put("selected", true);
        jSONArray.mo162put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("key", "time_filter_last_30");
        jSONObject2.put("title", "\u8fd130\u5929");
        jSONObject2.put("selected", false);
        jSONArray.mo162put(jSONObject2);
        return jSONArray;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("custom_time", new JSONObject());
        jSONObject.put("order_time_filter_list", d());
        jSONObject.put("order_channel_filter_list", c());
        jSONObject.put("history_time_filter_list", f());
        jSONObject.put("history_data_filter_list", b());
        jSONObject.put("sum_info", e());
        return jSONObject.toString();
    }
}
