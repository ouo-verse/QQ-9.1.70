package com.tencent.sqshow.zootopia.data;

import android.os.Bundle;
import com.tencent.ark.Constants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u000eB\u001d\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ac;", "", "", "d", "Landroid/os/Bundle;", "b", "c", "g", "i", tl.h.F, "j", "f", "k", "e", "a", "toString", "", "hashCode", "other", "", "equals", "", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/util/Map;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.ac, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZplanShareArkInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Map<String, Object> params;

    public ZplanShareArkInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Bundle b() {
        Bundle bundle = new Bundle();
        String h16 = h();
        bundle.putString("forward_ark_app_name", IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS);
        bundle.putString("forward_ark_app_view", IndividuationUrlHelper.UrlId.CARD_HOME);
        bundle.putString("forward_ark_app_ver", f());
        bundle.putString("forward_ark_app_meta", h16);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, f());
        bundle.putString("forward_ark_app_prompt", "[\u8d85\u7ea7QQ\u79c0]\u9080\u8bf7\u4f60\u4e00\u8d77\u73a9");
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, g());
        bundle.putString("appName", IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, f());
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, IndividuationUrlHelper.UrlId.CARD_HOME);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, h16);
        return bundle;
    }

    private final Bundle c() {
        Bundle bundle = new Bundle();
        String j3 = j();
        Object obj = this.params.get("name_app_ark");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_SHOT;
        }
        Object obj2 = this.params.get("view_app_ark");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            str2 = "invite";
        }
        bundle.putString("forward_ark_app_name", str);
        bundle.putString("forward_ark_app_view", str2);
        bundle.putString("forward_ark_app_ver", f());
        bundle.putString("forward_ark_app_meta", j3);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, f());
        bundle.putString("forward_ark_app_prompt", k());
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, i());
        bundle.putString("appName", str);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, f());
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, str2);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, j3);
        return bundle;
    }

    private final String d() {
        Object obj = this.params.get("name_app_ark");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS : str;
    }

    private final String f() {
        Object obj = this.params.get("ark_version");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? Constants.DEFAULT_MIN_APP_VERSION : str;
    }

    private final String g() {
        try {
            JSONObject jSONObject = new JSONObject();
            Object obj = this.params.get("forward");
            if (obj == null) {
                obj = 0;
            }
            jSONObject.put("forward", obj);
            Object obj2 = this.params.get("round");
            if (obj2 == null) {
                obj2 = 0;
            }
            jSONObject.put("round", obj2);
            Object obj3 = this.params.get("width");
            if (obj3 == null) {
                obj3 = 0;
            }
            jSONObject.put("width", obj3);
            Object obj4 = this.params.get("height");
            if (obj4 == null) {
                obj4 = 0;
            }
            jSONObject.put("height", obj4);
            Object obj5 = this.params.get("autosize");
            if (obj5 == null) {
                obj5 = 0;
            }
            jSONObject.put("autosize", obj5);
            jSONObject.put("type", "normal");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            val config\u2026nfig.toString()\n        }");
            return jSONObject2;
        } catch (Throwable th5) {
            QLog.e("ZplanShareArkInfo", 1, th5, new Object[0]);
            return "";
        }
    }

    private final String h() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", e());
        Object obj = this.params.get("cover_img");
        if (obj == null) {
            obj = "";
        }
        jSONObject2.put("cover_img", obj);
        Object obj2 = this.params.get("desc");
        if (obj2 == null) {
            obj2 = "";
        }
        jSONObject2.put("desc", obj2);
        Object obj3 = this.params.get("creator_head_img");
        if (obj3 == null) {
            obj3 = "";
        }
        jSONObject2.put("creator_head_img", obj3);
        Object obj4 = this.params.get("logo_img");
        if (obj4 == null) {
            obj4 = "";
        }
        jSONObject2.put("logo_img", obj4);
        Object obj5 = this.params.get("creator_nick_name");
        if (obj5 == null) {
            obj5 = "";
        }
        jSONObject2.put("creator_nick_name", obj5);
        Object obj6 = this.params.get("show_play_button");
        jSONObject2.put("show_play_button", obj6 != null ? obj6 : "");
        jSONObject2.put("is_preview", 1);
        jSONObject.put("info", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "meta.toString()");
        return jSONObject3;
    }

    private final String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            Object obj = this.params.get("forward");
            if (obj == null) {
                obj = 0;
            }
            jSONObject.put("forward", obj);
            Object obj2 = this.params.get("round");
            if (obj2 == null) {
                obj2 = 0;
            }
            jSONObject.put("round", obj2);
            Object obj3 = this.params.get("autosize");
            if (obj3 == null) {
                obj3 = 0;
            }
            jSONObject.put("autosize", obj3);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            val config\u2026nfig.toString()\n        }");
            return jSONObject2;
        } catch (Throwable th5) {
            QLog.e("ZplanShareArkInfo", 1, th5, new Object[0]);
            return "";
        }
    }

    private final String j() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", e());
        Object obj = this.params.get("roomId");
        if (obj == null) {
            obj = "";
        }
        jSONObject2.put("roomId", obj);
        Object obj2 = this.params.get("roomCreateTime");
        if (obj2 == null) {
            obj2 = "";
        }
        jSONObject2.put("roomCreateTime", obj2);
        Object obj3 = this.params.get("background");
        if (obj3 == null) {
            obj3 = "";
        }
        jSONObject2.put("background", obj3);
        Object obj4 = this.params.get("title");
        if (obj4 == null) {
            obj4 = "";
        }
        jSONObject2.put("title", obj4);
        Object obj5 = this.params.get("tag");
        if (obj5 == null) {
            obj5 = "";
        }
        jSONObject2.put("tag", obj5);
        Object obj6 = this.params.get("tagIcon");
        jSONObject2.put("tagIcon", obj6 != null ? obj6 : "");
        Object obj7 = this.params.get("showRoomState");
        if (obj7 == null) {
            obj7 = Boolean.FALSE;
        }
        jSONObject2.put("showRoomState", obj7);
        jSONObject.put("invite", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "meta.toString()");
        return jSONObject3;
    }

    private final String k() {
        Object obj = this.params.get("prompt");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "[\u5c0f\u7a9d]\u9080\u8bf7\u4f60\u4e00\u8d77\u73a9" : str;
    }

    public final Bundle a() {
        Bundle bundle;
        String d16 = d();
        if (Intrinsics.areEqual(d16, IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS)) {
            bundle = b();
        } else if (Intrinsics.areEqual(d16, IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_SHOT)) {
            bundle = c();
        } else {
            bundle = new Bundle();
        }
        QLog.i("ZplanShareArkInfo", 1, "bundle = " + bundle);
        return bundle;
    }

    public final String e() {
        Object obj = this.params.get("id");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    public int hashCode() {
        return this.params.hashCode();
    }

    public String toString() {
        return "ZplanShareArkInfo(params=" + this.params + ")";
    }

    public ZplanShareArkInfo(Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    public /* synthetic */ ZplanShareArkInfo(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZplanShareArkInfo) && Intrinsics.areEqual(this.params, ((ZplanShareArkInfo) other).params);
    }
}
