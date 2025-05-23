package com.tencent.biz.pubaccount.weishi.home;

import com.tencent.biz.pubaccount.weishi.home.guide.WSMonoTabGuideInfo;
import com.tencent.biz.pubaccount.weishi.home.guide.WSMonoTabPopupWindowGuideInfo;
import com.tencent.biz.pubaccount.weishi.home.guide.WSMonoTabRedDotGuideInfo;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0003J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0003J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0003J\u0006\u0010!\u001a\u00020 J\u0010\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0006R$\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/c;", "", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "f", "", "e", "bottomBarId", "l", "barInfoStr", "selectedBarId", "", "Lvy/a;", "o", "position", "Lorg/json/JSONObject;", "barInfoJson", DomainData.DOMAIN_NAME, "jsonObject", "Lcom/tencent/biz/pubaccount/weishi/home/guide/c;", "p", "Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/pubaccount/weishi/home/guide/h;", "r", "key", "g", "default", h.F, "", "a", "barId", "b", "i", "d", "c", "Ljava/util/Map;", "barInfoMap", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f80807a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<String, WSNavigationBarInfo> barInfoMap;

    c() {
    }

    @JvmStatic
    public static final String e() {
        String h16 = h("selected_bar", "waterfall_tab");
        return (!l(h16) || e.i()) ? "waterfall_tab" : h16;
    }

    @JvmStatic
    private static final int f() {
        return bb.Y(g("type"), 0);
    }

    @JvmStatic
    private static final String g(String key) {
        return h(key, "");
    }

    @JvmStatic
    private static final String h(String key, String r26) {
        String str;
        Map<String, String> w3 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().w();
        return (w3 == null || (str = w3.get(key)) == null) ? r26 : str;
    }

    @JvmStatic
    public static final boolean j() {
        return f() == 2;
    }

    @JvmStatic
    public static final boolean k() {
        return f() == 0;
    }

    @JvmStatic
    private static final boolean l(String bottomBarId) {
        int hashCode = bottomBarId.hashCode();
        return hashCode == -2026706425 ? bottomBarId.equals("follow_tab") : hashCode == -710258968 ? bottomBarId.equals("waterfall_tab") : hashCode == 194805079 && bottomBarId.equals("monofeed_tab");
    }

    @JvmStatic
    public static final boolean m() {
        return f() == 1;
    }

    private final WSNavigationBarInfo n(int position, JSONObject barInfoJson, String selectedBarId) {
        String barId = barInfoJson.optString("id");
        int optInt = barInfoJson.optInt("type");
        String barName = barInfoJson.optString("title");
        Intrinsics.checkNotNullExpressionValue(barId, "barId");
        Intrinsics.checkNotNullExpressionValue(barName, "barName");
        return new WSNavigationBarInfo(position, barId, selectedBarId, optInt, barName);
    }

    private final Map<String, WSNavigationBarInfo> o(String barInfoStr, String selectedBarId) {
        boolean isBlank;
        JSONArray jSONArray;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        isBlank = StringsKt__StringsJVMKt.isBlank(barInfoStr);
        if (isBlank) {
            return linkedHashMap;
        }
        try {
            jSONArray = new JSONArray(barInfoStr);
        } catch (Exception e16) {
            x.f("WSComboExpHelperLog", "[WSComboExpHelper.kt][parseBarInfoStr] e:" + e16.getLocalizedMessage());
            jSONArray = null;
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                    WSNavigationBarInfo n3 = f80807a.n(i3, optJSONObject, selectedBarId);
                }
            }
        }
        return linkedHashMap;
    }

    private final WSMonoTabGuideInfo p(JSONObject jsonObject) {
        c cVar = f80807a;
        JSONObject optJSONObject = jsonObject.optJSONObject("popup_window");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        } else {
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "jsonObject.optJSONObject\u2026P_WINDOW) ?: JSONObject()");
        }
        WSMonoTabPopupWindowGuideInfo q16 = cVar.q(optJSONObject);
        JSONObject optJSONObject2 = jsonObject.optJSONObject("red_dot");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        } else {
            Intrinsics.checkNotNullExpressionValue(optJSONObject2, "jsonObject.optJSONObject\u2026.RED_DOT) ?: JSONObject()");
        }
        return new WSMonoTabGuideInfo(q16, cVar.r(optJSONObject2));
    }

    private final WSMonoTabPopupWindowGuideInfo q(JSONObject jsonObject) {
        boolean z16 = jsonObject.optInt("is_show") == 1;
        String optString = jsonObject.optString(LayoutAttrDefine.BG_Color);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(WSExpConstant.ParamKey.BG_COLOR)");
        String optString2 = jsonObject.optString("desc");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(WSExpConstant.ParamKey.DESC)");
        String optString3 = jsonObject.optString("desc_color");
        Intrinsics.checkNotNullExpressionValue(optString3, "optString(WSExpConstant.ParamKey.DESC_COLOR)");
        return new WSMonoTabPopupWindowGuideInfo(z16, optString, optString2, optString3, jsonObject.optLong("show_duration", 5L), jsonObject.optInt("interval_days", 7), jsonObject.optInt("max_times", 3));
    }

    private final WSMonoTabRedDotGuideInfo r(JSONObject jsonObject) {
        return new WSMonoTabRedDotGuideInfo(jsonObject.optInt("is_show") == 1, jsonObject.optLong("interval_duration", 3600L));
    }

    public final void a() {
        Map<String, WSNavigationBarInfo> map = barInfoMap;
        if (map != null) {
            map.clear();
        }
    }

    public final WSNavigationBarInfo b(String barId) {
        Intrinsics.checkNotNullParameter(barId, "barId");
        Map<String, WSNavigationBarInfo> map = barInfoMap;
        if (map != null) {
            return map.get(barId);
        }
        return null;
    }

    public final int c() {
        return bb.Y(g("home_back_type"), 0);
    }

    public final WSMonoTabGuideInfo d() {
        boolean isBlank;
        String g16 = g("monofeed_tab_guide");
        isBlank = StringsKt__StringsJVMKt.isBlank(g16);
        int i3 = 3;
        WSMonoTabPopupWindowGuideInfo wSMonoTabPopupWindowGuideInfo = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        byte b26 = 0;
        if (isBlank) {
            return new WSMonoTabGuideInfo(wSMonoTabPopupWindowGuideInfo, b26 == true ? 1 : 0, i3, b19 == true ? 1 : 0);
        }
        try {
            return p(new JSONObject(g16));
        } catch (JSONException e16) {
            x.f("WSHomeExpHelper", "[WSHomeExpHelper.kt][getMonoTabGuideInfo] e:" + e16.getLocalizedMessage());
            return new WSMonoTabGuideInfo(b18 == true ? 1 : 0, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
        }
    }

    public final void i() {
        barInfoMap = o(g("bar_infos"), e());
    }
}
