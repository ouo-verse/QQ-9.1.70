package com.tencent.mobileqq.wink.aiavatar.detailpage;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "iconUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "iconTitle", "a", "isRight", "I", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.aiavatar.detailpage.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class AIAvatarImgPickGuideDataItem {

    @SerializedName("iconTitle")
    @NotNull
    private final String iconTitle;

    @SerializedName("iconUrl")
    @NotNull
    private final String iconUrl;

    @SerializedName("isRight")
    private final int isRight;

    public AIAvatarImgPickGuideDataItem() {
        this(null, null, 0, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getIconTitle() {
        return this.iconTitle;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIAvatarImgPickGuideDataItem)) {
            return false;
        }
        AIAvatarImgPickGuideDataItem aIAvatarImgPickGuideDataItem = (AIAvatarImgPickGuideDataItem) other;
        if (Intrinsics.areEqual(this.iconUrl, aIAvatarImgPickGuideDataItem.iconUrl) && Intrinsics.areEqual(this.iconTitle, aIAvatarImgPickGuideDataItem.iconTitle) && this.isRight == aIAvatarImgPickGuideDataItem.isRight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iconUrl.hashCode() * 31) + this.iconTitle.hashCode()) * 31) + this.isRight;
    }

    @NotNull
    public String toString() {
        return "AIAvatarImgPickGuideDataItem(iconUrl=" + this.iconUrl + ", iconTitle=" + this.iconTitle + ", isRight=" + this.isRight + ")";
    }

    public AIAvatarImgPickGuideDataItem(@NotNull String iconUrl, @NotNull String iconTitle, int i3) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(iconTitle, "iconTitle");
        this.iconUrl = iconUrl;
        this.iconTitle = iconTitle;
        this.isRight = i3;
    }

    public /* synthetic */ AIAvatarImgPickGuideDataItem(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "https://downv6.qq.com/shadow_qqcamera/AIAvatar/suggust_sample_0.png" : str, (i16 & 2) != 0 ? "\u6b63\u9762\u6e05\u6670" : str2, (i16 & 4) != 0 ? 1 : i3);
    }
}
