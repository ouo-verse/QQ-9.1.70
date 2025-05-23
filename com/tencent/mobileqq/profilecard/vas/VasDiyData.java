package com.tencent.mobileqq.profilecard.vas;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "urlPrefix", "", QQBrowserActivityConstants.KEY_TITLE_STYLE, "", "mainColor", "headerJson", "", "bodyJson", "Lorg/json/JSONObject;", "bgJson", "(Ljava/lang/String;IILjava/lang/Object;Lorg/json/JSONObject;Ljava/lang/Object;)V", "getBgJson", "()Ljava/lang/Object;", "getBodyJson", "()Lorg/json/JSONObject;", "getHeaderJson", "getMainColor", "()I", "getTitleStyle", "getUrlPrefix", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class VasDiyData implements IProfileBusinessInfo {

    @NotNull
    private final Object bgJson;

    @NotNull
    private final JSONObject bodyJson;

    @NotNull
    private final Object headerJson;
    private final int mainColor;
    private final int titleStyle;

    @NotNull
    private final String urlPrefix;

    public VasDiyData(@NotNull String urlPrefix, int i3, int i16, @NotNull Object headerJson, @NotNull JSONObject bodyJson, @NotNull Object bgJson) {
        Intrinsics.checkNotNullParameter(urlPrefix, "urlPrefix");
        Intrinsics.checkNotNullParameter(headerJson, "headerJson");
        Intrinsics.checkNotNullParameter(bodyJson, "bodyJson");
        Intrinsics.checkNotNullParameter(bgJson, "bgJson");
        this.urlPrefix = urlPrefix;
        this.titleStyle = i3;
        this.mainColor = i16;
        this.headerJson = headerJson;
        this.bodyJson = bodyJson;
        this.bgJson = bgJson;
    }

    public static /* synthetic */ VasDiyData copy$default(VasDiyData vasDiyData, String str, int i3, int i16, Object obj, JSONObject jSONObject, Object obj2, int i17, Object obj3) {
        if ((i17 & 1) != 0) {
            str = vasDiyData.urlPrefix;
        }
        if ((i17 & 2) != 0) {
            i3 = vasDiyData.titleStyle;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            i16 = vasDiyData.mainColor;
        }
        int i19 = i16;
        if ((i17 & 8) != 0) {
            obj = vasDiyData.headerJson;
        }
        Object obj4 = obj;
        if ((i17 & 16) != 0) {
            jSONObject = vasDiyData.bodyJson;
        }
        JSONObject jSONObject2 = jSONObject;
        if ((i17 & 32) != 0) {
            obj2 = vasDiyData.bgJson;
        }
        return vasDiyData.copy(str, i18, i19, obj4, jSONObject2, obj2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrlPrefix() {
        return this.urlPrefix;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTitleStyle() {
        return this.titleStyle;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMainColor() {
        return this.mainColor;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Object getHeaderJson() {
        return this.headerJson;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final JSONObject getBodyJson() {
        return this.bodyJson;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final Object getBgJson() {
        return this.bgJson;
    }

    @NotNull
    public final VasDiyData copy(@NotNull String urlPrefix, int titleStyle, int mainColor, @NotNull Object headerJson, @NotNull JSONObject bodyJson, @NotNull Object bgJson) {
        Intrinsics.checkNotNullParameter(urlPrefix, "urlPrefix");
        Intrinsics.checkNotNullParameter(headerJson, "headerJson");
        Intrinsics.checkNotNullParameter(bodyJson, "bodyJson");
        Intrinsics.checkNotNullParameter(bgJson, "bgJson");
        return new VasDiyData(urlPrefix, titleStyle, mainColor, headerJson, bodyJson, bgJson);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasDiyData)) {
            return false;
        }
        VasDiyData vasDiyData = (VasDiyData) other;
        if (Intrinsics.areEqual(this.urlPrefix, vasDiyData.urlPrefix) && this.titleStyle == vasDiyData.titleStyle && this.mainColor == vasDiyData.mainColor && Intrinsics.areEqual(this.headerJson, vasDiyData.headerJson) && Intrinsics.areEqual(this.bodyJson, vasDiyData.bodyJson) && Intrinsics.areEqual(this.bgJson, vasDiyData.bgJson)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Object getBgJson() {
        return this.bgJson;
    }

    @NotNull
    public final JSONObject getBodyJson() {
        return this.bodyJson;
    }

    @NotNull
    public final Object getHeaderJson() {
        return this.headerJson;
    }

    public final int getMainColor() {
        return this.mainColor;
    }

    public final int getTitleStyle() {
        return this.titleStyle;
    }

    @NotNull
    public final String getUrlPrefix() {
        return this.urlPrefix;
    }

    public int hashCode() {
        return (((((((((this.urlPrefix.hashCode() * 31) + this.titleStyle) * 31) + this.mainColor) * 31) + this.headerJson.hashCode()) * 31) + this.bodyJson.hashCode()) * 31) + this.bgJson.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasDiyData(urlPrefix=" + this.urlPrefix + ", titleStyle=" + this.titleStyle + ", mainColor=" + this.mainColor + ", headerJson=" + this.headerJson + ", bodyJson=" + this.bodyJson + ", bgJson=" + this.bgJson + ")";
    }
}
