package com.tencent.sqshow.zootopia.recommend.main.tab;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B-\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "", "", "needEncode", "", "a", "e", "f", "toString", "", "hashCode", "other", "equals", "I", "c", "()I", "pageType", "b", "getSubTabType", "subTabType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "<init>", "(IILjava/lang/String;Lorg/json/JSONObject;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanTabContentUrl {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pageType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subTabType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject hippyInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/e$a;", "", "", "jsonString", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.e$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanTabContentUrl a(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            if (TextUtils.isEmpty(jsonString)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                int optInt = jSONObject.optInt(MiniAppPlugin.ATTR_PAGE_TYPE, -1);
                int optInt2 = jSONObject.optInt("sub_tab_type", 0);
                String url = jSONObject.optString("jump_url", "");
                JSONObject optJSONObject = jSONObject.optJSONObject(IHippyIPC.BUNDLE_HIPPY_INFO);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                if (!ZPlanTabData.INSTANCE.a(optInt)) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(url, "url");
                return new ZPlanTabContentUrl(optInt, optInt2, url, optJSONObject);
            } catch (Exception unused) {
                QLog.e("ZPlanTabContentUrl", 1, "convertJsonData error, " + jsonString);
                return null;
            }
        }

        Companion() {
        }
    }

    public ZPlanTabContentUrl(int i3, int i16, String url, JSONObject hippyInfo) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(hippyInfo, "hippyInfo");
        this.pageType = i3;
        this.subTabType = i16;
        this.url = url;
        this.hippyInfo = hippyInfo;
    }

    public final String a(boolean needEncode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppPlugin.ATTR_PAGE_TYPE, this.pageType);
        jSONObject.put("sub_tab_type", this.subTabType);
        jSONObject.put("jump_url", this.url);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObj.toString()");
        return needEncode ? ISchemeApi.INSTANCE.b(jSONObject2) : jSONObject2;
    }

    /* renamed from: b, reason: from getter */
    public final JSONObject getHippyInfo() {
        return this.hippyInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getPageType() {
        return this.pageType;
    }

    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final boolean e() {
        return this.pageType == 4;
    }

    public final String f() {
        return this.pageType + "_" + this.subTabType + "_" + this.url;
    }

    public int hashCode() {
        return (((((this.pageType * 31) + this.subTabType) * 31) + this.url.hashCode()) * 31) + this.hippyInfo.hashCode();
    }

    public String toString() {
        return "ZPlanTabContentUrl(pageType=" + this.pageType + ", subTabType=" + this.subTabType + ", url=" + this.url + ", hippyInfo=" + this.hippyInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTabContentUrl)) {
            return false;
        }
        ZPlanTabContentUrl zPlanTabContentUrl = (ZPlanTabContentUrl) other;
        return this.pageType == zPlanTabContentUrl.pageType && this.subTabType == zPlanTabContentUrl.subTabType && Intrinsics.areEqual(this.url, zPlanTabContentUrl.url) && Intrinsics.areEqual(this.hippyInfo, zPlanTabContentUrl.hippyInfo);
    }

    public /* synthetic */ ZPlanTabContentUrl(int i3, int i16, String str, JSONObject jSONObject, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? new JSONObject() : jSONObject);
    }
}
