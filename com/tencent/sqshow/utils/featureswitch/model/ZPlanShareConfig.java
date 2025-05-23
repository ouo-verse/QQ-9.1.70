package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.imsdk.BaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ai;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/utils/featureswitch/model/k;", "defaultBackgrounds", "Ljava/util/List;", "c", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "portraitIds", "d", "g", "activityBackground", "Lcom/tencent/sqshow/utils/featureswitch/model/k;", "a", "()Lcom/tencent/sqshow/utils/featureswitch/model/k;", "activityPortraitId", "I", "b", "()I", "shareBaseMapUrl", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/tencent/sqshow/utils/featureswitch/model/k;ILjava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.ai, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanShareConfig {

    @SerializedName("activityBackground")
    private final ShareBackground activityBackground;

    @SerializedName("activityPortraitId")
    private final int activityPortraitId;

    @SerializedName("defaultBackgrounds")
    private List<ShareBackground> defaultBackgrounds;

    @SerializedName("portraitIds")
    private List<Integer> portraitIds;

    @SerializedName("shareBaseMapUrl")
    private final String shareBaseMapUrl;

    public ZPlanShareConfig() {
        this(null, null, null, 0, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final ShareBackground getActivityBackground() {
        return this.activityBackground;
    }

    /* renamed from: b, reason: from getter */
    public final int getActivityPortraitId() {
        return this.activityPortraitId;
    }

    public final List<ShareBackground> c() {
        return this.defaultBackgrounds;
    }

    public final List<Integer> d() {
        return this.portraitIds;
    }

    /* renamed from: e, reason: from getter */
    public final String getShareBaseMapUrl() {
        return this.shareBaseMapUrl;
    }

    public final void f(List<ShareBackground> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.defaultBackgrounds = list;
    }

    public final void g(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.portraitIds = list;
    }

    public int hashCode() {
        int hashCode = ((this.defaultBackgrounds.hashCode() * 31) + this.portraitIds.hashCode()) * 31;
        ShareBackground shareBackground = this.activityBackground;
        return ((((hashCode + (shareBackground == null ? 0 : shareBackground.hashCode())) * 31) + this.activityPortraitId) * 31) + this.shareBaseMapUrl.hashCode();
    }

    public String toString() {
        return "ZPlanShareConfig(defaultBackgrounds=" + this.defaultBackgrounds + ", portraitIds=" + this.portraitIds + ", activityBackground=" + this.activityBackground + ", activityPortraitId=" + this.activityPortraitId + ", shareBaseMapUrl=" + this.shareBaseMapUrl + ')';
    }

    public ZPlanShareConfig(List<ShareBackground> defaultBackgrounds, List<Integer> portraitIds, ShareBackground shareBackground, int i3, String shareBaseMapUrl) {
        Intrinsics.checkNotNullParameter(defaultBackgrounds, "defaultBackgrounds");
        Intrinsics.checkNotNullParameter(portraitIds, "portraitIds");
        Intrinsics.checkNotNullParameter(shareBaseMapUrl, "shareBaseMapUrl");
        this.defaultBackgrounds = defaultBackgrounds;
        this.portraitIds = portraitIds;
        this.activityBackground = shareBackground;
        this.activityPortraitId = i3;
        this.shareBaseMapUrl = shareBaseMapUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanShareConfig)) {
            return false;
        }
        ZPlanShareConfig zPlanShareConfig = (ZPlanShareConfig) other;
        return Intrinsics.areEqual(this.defaultBackgrounds, zPlanShareConfig.defaultBackgrounds) && Intrinsics.areEqual(this.portraitIds, zPlanShareConfig.portraitIds) && Intrinsics.areEqual(this.activityBackground, zPlanShareConfig.activityBackground) && this.activityPortraitId == zPlanShareConfig.activityPortraitId && Intrinsics.areEqual(this.shareBaseMapUrl, zPlanShareConfig.shareBaseMapUrl);
    }

    public /* synthetic */ ZPlanShareConfig(List list, List list2, ShareBackground shareBackground, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : list, (i16 & 2) != 0 ? CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(BaseConstants.ERR_USER_CANCELED)) : list2, (i16 & 4) != 0 ? null : shareBackground, (i16 & 8) == 0 ? i3 : 0, (i16 & 16) != 0 ? "" : str);
    }
}
