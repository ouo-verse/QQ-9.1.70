package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ab;", "", "", "toString", "", "hashCode", "other", "", "equals", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "description", "a", "imageUrl", "b", "okText", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.ab, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanMiniHomeGuidanceConfig {

    @SerializedName("description")
    private final String description;

    @SerializedName("imageUrl")
    private final String imageUrl;

    @SerializedName("okText")
    private final String okText;

    @SerializedName("title")
    private final String title;

    public ZPlanMiniHomeGuidanceConfig() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getOkText() {
        return this.okText;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.okText.hashCode();
    }

    public String toString() {
        return "ZPlanMiniHomeGuidanceConfig(title=" + this.title + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ", okText=" + this.okText + ')';
    }

    public ZPlanMiniHomeGuidanceConfig(String title, String description, String imageUrl, String okText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(okText, "okText");
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.okText = okText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanMiniHomeGuidanceConfig)) {
            return false;
        }
        ZPlanMiniHomeGuidanceConfig zPlanMiniHomeGuidanceConfig = (ZPlanMiniHomeGuidanceConfig) other;
        return Intrinsics.areEqual(this.title, zPlanMiniHomeGuidanceConfig.title) && Intrinsics.areEqual(this.description, zPlanMiniHomeGuidanceConfig.description) && Intrinsics.areEqual(this.imageUrl, zPlanMiniHomeGuidanceConfig.imageUrl) && Intrinsics.areEqual(this.okText, zPlanMiniHomeGuidanceConfig.okText);
    }

    public /* synthetic */ ZPlanMiniHomeGuidanceConfig(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "\u5f00\u542f\u8ff7\u4f60\u7a9d" : str, (i3 & 2) != 0 ? "\u62a2\u9c9c\u4f53\u9a8c\u9886\u53d6\u9650\u65f6\u514d\u8d39\u623f\u95f4" : str2, (i3 & 4) != 0 ? "https://image.superqqshow.qq.com/qq/mini_home/minihome_guidance_v2.png" : str3, (i3 & 8) != 0 ? "\u514d\u8d39\u9886\u53d6" : str4);
    }
}
