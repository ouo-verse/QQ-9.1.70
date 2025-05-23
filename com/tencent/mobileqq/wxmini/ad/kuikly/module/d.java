package com.tencent.mobileqq.wxmini.ad.kuikly.module;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;

/* compiled from: P */
/* loaded from: classes35.dex */
final class d {

    @SerializedName("adInfo")
    JsonObject adInfo;

    @SerializedName("context")
    a contextInfo;

    @SerializedName("options")
    b optionsInfo;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static final class a {

        @SerializedName("bundleName")
        public String bundleName;

        @SerializedName("pageName")
        public String pageName;

        public String toString() {
            return cb3.a.c(this, "{}");
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static final class b {

        @SerializedName("slot")
        public int slot;

        @SerializedName("ext")
        public JsonObject wxMiniHostExtraData;

        @SerializedName("hostScene")
        public int wxMiniHostScene;

        public boolean a() {
            boolean z16 = this.wxMiniHostScene != Integer.MIN_VALUE;
            int i3 = this.slot;
            return z16 && (i3 == Integer.MIN_VALUE || i3 >= 0);
        }

        public String toString() {
            return cb3.a.c(this, "{}");
        }
    }

    d() {
    }

    public boolean a() {
        b bVar;
        JsonObject jsonObject = this.adInfo;
        return jsonObject != null && jsonObject.isJsonObject() && (bVar = this.optionsInfo) != null && bVar.a();
    }

    public String b(GdtAd gdtAd) {
        String posId = gdtAd != null ? gdtAd.getPosId() : null;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        String traceId = gdtAd != null ? gdtAd.getTraceId() : null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WxMiniGameCenterAdKuiklyModuleClickHandler.Info(contextInfo=");
        sb5.append(this.contextInfo);
        sb5.append(", optionsInfo=");
        sb5.append(this.optionsInfo);
        sb5.append(", withAdInfo=");
        JsonObject jsonObject = this.adInfo;
        sb5.append(jsonObject != null && jsonObject.isJsonObject());
        sb5.append(", adInfo=(posId=");
        sb5.append(posId);
        sb5.append(", aid=");
        sb5.append(aId);
        sb5.append(", traceId=");
        sb5.append(traceId);
        sb5.append(", ))");
        return sb5.toString();
    }
}
