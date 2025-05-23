package com.tencent.mobileqq.zplan.minihome;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "iconUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "giftBubbleText", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.v, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GiftDesc {

    @SerializedName("giftBubbleText")
    @NotNull
    private final String giftBubbleText;

    @SerializedName("iconUrl")
    @NotNull
    private final String iconUrl;

    public GiftDesc() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGiftBubbleText() {
        return this.giftBubbleText;
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
        if (!(other instanceof GiftDesc)) {
            return false;
        }
        GiftDesc giftDesc = (GiftDesc) other;
        if (Intrinsics.areEqual(this.iconUrl, giftDesc.iconUrl) && Intrinsics.areEqual(this.giftBubbleText, giftDesc.giftBubbleText)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.iconUrl.hashCode() * 31) + this.giftBubbleText.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftDesc(iconUrl=" + this.iconUrl + ", giftBubbleText=" + this.giftBubbleText + ')';
    }

    public GiftDesc(@NotNull String iconUrl, @NotNull String giftBubbleText) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(giftBubbleText, "giftBubbleText");
        this.iconUrl = iconUrl;
        this.giftBubbleText = giftBubbleText;
    }

    public /* synthetic */ GiftDesc(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
