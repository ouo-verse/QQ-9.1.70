package pi0;

import ck0.Category;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.api.ProcessConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zj0.FilterCond;
import zj0.FilterOption;
import zj0.RangeCond;
import zj0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001\u0003BW\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0013\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR*\u0010,\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001a\u00a8\u00060"}, d2 = {"Lpi0/a;", "", "Lorg/json/JSONObject;", "a", "", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "query", "Lck0/b;", "b", "Lck0/b;", "getCategory", "()Lck0/b;", "setCategory", "(Lck0/b;)V", "category", "", "Lzj0/a;", "c", "Ljava/util/List;", "getFilter", "()Ljava/util/List;", "setFilter", "(Ljava/util/List;)V", "filter", "Lzj0/c;", "d", "Lzj0/c;", "getOrderBy", "()Lzj0/c;", "setOrderBy", "(Lzj0/c;)V", "orderBy", "e", "getCookie", "setCookie", "cookie", "Lzj0/d;", "f", "getRangeCond", "setRangeCond", "rangeCond", "<init>", "(Ljava/lang/String;Lck0/b;Ljava/util/List;Lzj0/c;Ljava/lang/String;Ljava/util/List;)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String query;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Category category;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<FilterCond> filter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c orderBy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String cookie;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<RangeCond> rangeCond;

    public a(String str, Category category, List<FilterCond> list, c cVar, String str2, List<RangeCond> list2) {
        this.query = str;
        this.category = category;
        this.filter = list;
        this.orderBy = cVar;
        this.cookie = str2;
        this.rangeCond = list2;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("query", this.query);
            jSONObject.put("cookie", this.cookie);
            Category category = this.category;
            if (category != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", category.id);
                jSONObject2.put("name", category.name);
                jSONObject2.put("goods_type", category.goodsType);
                jSONObject.put("cat", jSONObject2);
            }
            c cVar = this.orderBy;
            if (cVar != null) {
                jSONObject.put("order_by", cVar.a());
                jSONObject.put("order_by_type", cVar.b());
            }
            List<FilterCond> list = this.filter;
            if (list != null) {
                JSONArray jSONArray = new JSONArray();
                for (FilterCond filterCond : list) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", filterCond.type);
                    jSONObject3.put("name", filterCond.name);
                    jSONObject3.put(ProcessConstant.MULTI, filterCond.multi);
                    JSONArray jSONArray2 = new JSONArray();
                    for (FilterOption filterOption : filterCond.a()) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("id", filterOption.optionId);
                        jSONObject4.put("name", filterOption.optionName);
                        jSONObject4.put("short_name", filterOption.shortName);
                        jSONArray2.mo162put(jSONObject4);
                    }
                    jSONObject3.put("options", jSONArray2);
                    jSONArray.mo162put(jSONObject3);
                }
                jSONObject.put("filter_cond_list", jSONArray);
            }
            List<RangeCond> list2 = this.rangeCond;
            if (list2 != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (RangeCond rangeCond : list2) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("type", rangeCond.type);
                    jSONObject5.put("name", rangeCond.name);
                    jSONObject5.put("lower", rangeCond.getLower());
                    jSONObject5.put("upper", rangeCond.getUpper());
                    jSONObject5.put("lower_txt", rangeCond.lowerText);
                    jSONObject5.put("upper_txt", rangeCond.upperText);
                    jSONObject5.put("unit", rangeCond.unit);
                    jSONObject5.put("min_limit", rangeCond.minLimit);
                    jSONObject5.put("max_limit", rangeCond.maxLimit);
                    jSONObject5.put("err_toast", rangeCond.errorToast);
                    jSONArray3.mo162put(jSONObject5);
                }
                jSONObject.put("range_cond", jSONArray3);
            }
            cg0.a.b("ECSelectProductListReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECSelectProductListReq", "encodeParams", "[encodeParams] error, e = " + e16);
            return new JSONObject();
        }
    }

    public /* synthetic */ a(String str, Category category, List list, c cVar, String str2, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : category, (i3 & 4) != 0 ? null : list, (i3 & 8) != 0 ? null : cVar, (i3 & 16) == 0 ? str2 : "", (i3 & 32) != 0 ? null : list2);
    }
}
