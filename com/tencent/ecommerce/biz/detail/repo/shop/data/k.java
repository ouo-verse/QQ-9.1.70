package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010'\u001a\u00020\u0010\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b+\u0010,J,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J,\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u001c\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007J\u001a\u0010\u001b\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u001a\u0010\u001c\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\"\u0010\u001f\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010!\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u0019J\u001a\u0010\"\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u001a\u0010#\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u001a\u0010$\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u001a\u0010%\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005R\u0014\u0010'\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R\u0019\u0010*\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/k;", "", "", "name", "value", "", "options", "", ReportConstant.COSTREPORT_PREFIX, "t", DomainData.DOMAIN_NAME, "Lorg/json/JSONArray;", "k", "specInfoItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lorg/json/JSONObject;", "skuItemInfo", "r", "p", "c", "b", "a", "j", "isStrictly", "", "u", "g", "f", "", "count", "e", "skuItems", "i", tl.h.F, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lorg/json/JSONObject;", "productInfo", "getActiveInfo", "()Lorg/json/JSONObject;", "activeInfo", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final JSONObject productInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final JSONObject activeInfo;

    public k(JSONObject jSONObject, JSONObject jSONObject2) {
        this.productInfo = jSONObject;
        this.activeInfo = jSONObject2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r7 = com.tencent.ecommerce.biz.detail.repo.shop.data.l.r(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject a(Map<String, String> options) {
        JSONObject jSONObject;
        String str;
        String str2;
        JSONObject p16;
        String optString;
        JSONObject c16 = c(options);
        JSONObject j3 = j(options);
        if (j3 == null || jSONObject == null) {
            jSONObject = this.activeInfo;
        }
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("active_stock") : null;
        JSONObject optJSONObject2 = jSONObject != null ? jSONObject.optJSONObject("active_price") : null;
        int optInt = optJSONObject != null ? optJSONObject.optInt("remain") : 0;
        if (optJSONObject == null || (str = optJSONObject.optString("remain_txt")) == null) {
            str = "0";
        }
        if (optInt > 0) {
            String str3 = "";
            if (optJSONObject2 == null || (str2 = optJSONObject2.optString("discount_price_txt", "")) == null) {
                str2 = "";
            }
            if (optJSONObject2 != null && (optString = optJSONObject2.optString("discount_price_desc", "")) != null) {
                str3 = optString;
            }
            p16 = l.p(c16);
            p16.put("discount_price_txt", str2);
            p16.put("discount_price_desc", str3);
            c16.put("stock", str);
        }
        return c16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r6 = com.tencent.ecommerce.biz.detail.repo.shop.data.l.r(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject b(Map<String, String> options) {
        JSONObject jSONObject;
        String str;
        JSONObject p16;
        JSONObject c16 = c(options);
        JSONObject j3 = j(options);
        if (j3 == null || jSONObject == null) {
            jSONObject = this.activeInfo;
        }
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("live_stock") : null;
        JSONObject optJSONObject2 = jSONObject != null ? jSONObject.optJSONObject("live_price") : null;
        int optInt = optJSONObject != null ? optJSONObject.optInt("remain") : 0;
        if (optJSONObject == null || (str = optJSONObject.optString("remain_txt")) == null) {
            str = "0";
        }
        if (optInt > 0) {
            long optLong = optJSONObject2 != null ? optJSONObject2.optLong("live_special", 0L) : 0L;
            p16 = l.p(c16);
            p16.put("price_txt", com.tencent.ecommerce.biz.util.i.f104869a.b(optLong));
            c16.put("stock", str);
        }
        return c16;
    }

    private final String d(Map<String, String> options) {
        StringBuilder sb5 = new StringBuilder("");
        Iterator<String> it = k().keySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            String str = options.get(it.next());
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                sb5.append(str);
                sb5.append(";");
            }
        }
        if (!(sb5.length() > 0)) {
            return "";
        }
        String str2 = "\u5df2\u9009\u62e9 " + ((Object) sb5);
        return str2.subSequence(0, str2.length() - 1).toString();
    }

    private final Map<String, JSONArray> k() {
        JSONArray s16;
        JSONArray y16;
        String w3;
        String x16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        s16 = l.s(this.productInfo);
        int length = s16.length();
        for (int i3 = 0; i3 < length; i3++) {
            y16 = l.y(s16.optJSONObject(i3));
            int length2 = y16.length();
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject optJSONObject = y16.optJSONObject(i16);
                w3 = l.w(optJSONObject);
                x16 = l.x(optJSONObject);
                JSONArray jSONArray = (JSONArray) linkedHashMap.get(w3);
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                if (!m(jSONArray, x16)) {
                    jSONArray.mo162put(x16);
                    linkedHashMap.put(w3, jSONArray);
                }
            }
        }
        return linkedHashMap;
    }

    private final boolean m(JSONArray specInfoItem, String value) {
        int length = specInfoItem.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = specInfoItem.optString(i3);
            if ((optString.length() > 0) && Intrinsics.areEqual(optString, value)) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(String name, String value, Map<String, String> options) {
        int u16;
        if (s(name, value, options)) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(options);
        linkedHashMap.put(name, value);
        Iterator<JSONObject> it = u(linkedHashMap, false).iterator();
        while (it.hasNext()) {
            u16 = l.u(it.next());
            if (u16 == 1) {
                return false;
            }
        }
        return true;
    }

    private final boolean s(String name, String value, Map<String, String> options) {
        String str = options.get(name);
        if (str != null) {
            return Intrinsics.areEqual(str, value);
        }
        return false;
    }

    private final boolean t(String name, String value, Map<String, String> options) {
        int A;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(options);
        linkedHashMap.put(name, value);
        boolean z16 = false;
        Iterator<JSONObject> it = u(linkedHashMap, false).iterator();
        while (it.hasNext()) {
            A = l.A(it.next());
            if (A != 0) {
                z16 = true;
            }
        }
        return !z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject e(Map<String, String> options, int count) {
        int i3;
        boolean z16;
        Object first;
        String str;
        int A;
        JSONObject jSONObject = new JSONObject();
        List<JSONObject> u16 = u(options, true);
        int i16 = i(u16);
        if ((!u16.isEmpty()) && u16.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
            JSONObject jSONObject2 = (JSONObject) first;
            int optInt = jSONObject2.optInt("sku_type", 0);
            JSONObject jSONObject3 = this.activeInfo;
            if (jSONObject3 == null || (str = jSONObject3.optString("active_id")) == null) {
                str = "";
            }
            if (optInt == 0) {
                if (str.length() > 0) {
                    z16 = true;
                    if (i16 != 0) {
                        i3 = l.A(jSONObject2);
                    } else {
                        A = l.A(jSONObject2);
                        i3 = Math.min(i16, A);
                    }
                }
            }
            z16 = false;
            if (i16 != 0) {
            }
        } else {
            i3 = 1;
            z16 = false;
        }
        jSONObject.put("limit", i16);
        jSONObject.put("count", count);
        jSONObject.put("max_count", i3);
        jSONObject.put("min_count", Math.min(i3, 1));
        jSONObject.put("soldout", i3 == 0);
        jSONObject.put("is_activity_soldout", z16);
        return jSONObject;
    }

    public final JSONObject f(Map<String, String> options) {
        JSONObject c16;
        if (q(options)) {
            c16 = b(options);
        } else if (o(options)) {
            c16 = a(options);
        } else {
            c16 = c(options);
        }
        String d16 = d(options);
        if (!(d16.length() > 0)) {
            d16 = "\u8bf7\u9009\u62e9\u89c4\u683c";
        }
        c16.put("spec_text", d16);
        return c16;
    }

    public final JSONArray g(Map<String, String> options) {
        JSONArray jSONArray = new JSONArray();
        Map<String, JSONArray> k3 = k();
        for (String str : k3.keySet()) {
            JSONArray jSONArray2 = k3.get(str);
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            JSONArray jSONArray3 = new JSONArray();
            int length = jSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONArray2.optString(i3);
                if (optString == null) {
                    optString = "";
                }
                boolean s16 = s(str, optString, options);
                boolean n3 = n(str, optString, options);
                boolean t16 = t(str, optString, options);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", optString);
                jSONObject.put("select", s16);
                jSONObject.put("disable", n3);
                jSONObject.put("soldout", t16);
                Unit unit = Unit.INSTANCE;
                jSONArray3.mo162put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IPCConst.KEY_TITLE_TEXT, str);
            jSONObject2.put("choose_items", jSONArray3);
            Unit unit2 = Unit.INSTANCE;
            jSONArray.mo162put(jSONObject2);
        }
        return jSONArray;
    }

    public final String h(Map<String, String> options) {
        StringBuilder sb5 = new StringBuilder("");
        Iterator<String> it = k().keySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            String str = options.get(next);
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                sb5.append(next);
                sb5.append("\u3001");
            }
        }
        if (!(sb5.length() > 0)) {
            return "";
        }
        String str2 = "\u8bf7\u9009\u62e9 " + ((Object) sb5);
        return str2.subSequence(0, str2.length() - 1).toString();
    }

    public final boolean l(Map<String, String> options) {
        JSONObject j3 = j(options);
        JSONObject r16 = j3 != null ? l.r(j3) : null;
        if (r16 != null) {
            JSONObject optJSONObject = r16.optJSONObject("live_stock");
            if ((optJSONObject != null ? optJSONObject.optInt("remain") : 0) > 0) {
                return true;
            }
        } else if (j3 == null) {
            return true;
        }
        return false;
    }

    public final boolean o(Map<String, String> options) {
        return p(j(options));
    }

    public final boolean q(Map<String, String> options) {
        return r(j(options));
    }

    public final List<JSONObject> u(Map<String, String> options, boolean isStrictly) {
        JSONArray s16;
        JSONArray y16;
        String w3;
        String x16;
        ArrayList arrayList = new ArrayList();
        s16 = l.s(this.productInfo);
        int length = s16.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = s16.optJSONObject(i3);
            y16 = l.y(optJSONObject);
            int length2 = y16.length();
            boolean z16 = true;
            boolean z17 = true;
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject optJSONObject2 = y16.optJSONObject(i16);
                w3 = l.w(optJSONObject2);
                x16 = l.x(optJSONObject2);
                String str = options.get(w3);
                if (str == null || str.length() == 0) {
                    z17 = false;
                } else if (!Intrinsics.areEqual(str, x16)) {
                    z16 = false;
                    z17 = false;
                }
            }
            if ((!isStrictly && z16) || (isStrictly && z17)) {
                arrayList.add(optJSONObject);
            }
        }
        return arrayList;
    }

    private final JSONObject c(Map<String, String> options) {
        String z16;
        JSONObject p16;
        JSONArray o16;
        JSONObject t16;
        Object first;
        List<JSONObject> u16 = u(options, true);
        JSONObject jSONObject = this.productInfo;
        if ((!u16.isEmpty()) && u16.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
            jSONObject = (JSONObject) first;
        }
        z16 = l.z(jSONObject);
        p16 = l.p(jSONObject);
        o16 = l.o(jSONObject);
        t16 = l.t(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("stock", z16);
        jSONObject2.put("price", p16);
        jSONObject2.put(QCircleLpReportDc05507.KEY_PIC_INFO, o16);
        jSONObject2.put(IndividuationUrlHelper.UrlId.PENDANT_HOME, t16);
        return jSONObject2;
    }

    private final JSONObject j(Map<String, String> options) {
        Object first;
        List<JSONObject> u16 = u(options, true);
        if (!(true ^ u16.isEmpty())) {
            return null;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
        return (JSONObject) first;
    }

    public final int i(List<? extends JSONObject> skuItems) {
        JSONObject jSONObject;
        int q16;
        int n3;
        Object first;
        if (!skuItems.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) skuItems);
            jSONObject = (JSONObject) first;
        } else {
            jSONObject = null;
        }
        if (!r(jSONObject)) {
            q16 = l.q(this.productInfo);
            return q16;
        }
        if (jSONObject == null) {
            return 0;
        }
        n3 = l.n(jSONObject);
        return n3;
    }

    private final boolean p(JSONObject skuItemInfo) {
        if (skuItemInfo != null) {
            return skuItemInfo.optInt("sku_type", 0) == 2;
        }
        JSONObject jSONObject = this.activeInfo;
        if (jSONObject != null) {
            return com.tencent.ecommerce.biz.detail.utils.f.c(jSONObject);
        }
        return false;
    }

    private final boolean r(JSONObject skuItemInfo) {
        if (skuItemInfo != null) {
            return skuItemInfo.optInt("sku_type", 0) == 1;
        }
        JSONObject jSONObject = this.activeInfo;
        if (jSONObject != null) {
            return com.tencent.ecommerce.biz.detail.utils.f.a(jSONObject);
        }
        return false;
    }
}
