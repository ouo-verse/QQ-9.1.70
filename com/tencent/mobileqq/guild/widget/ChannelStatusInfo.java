package com.tencent.mobileqq.guild.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isAnimation", "b", "I", "()I", "iconResource", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "statusText", "Lcom/tencent/mobileqq/guild/widget/a;", "Lcom/tencent/mobileqq/guild/widget/a;", "()Lcom/tencent/mobileqq/guild/widget/a;", "backgroundInfo", "<init>", "(ZILjava/lang/String;Lcom/tencent/mobileqq/guild/widget/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.widget.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ChannelStatusInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAnimation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconResource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String statusText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BackgroundInfo backgroundInfo;

    public ChannelStatusInfo(boolean z16, int i3, @NotNull String statusText, @NotNull BackgroundInfo backgroundInfo) {
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(backgroundInfo, "backgroundInfo");
        this.isAnimation = z16;
        this.iconResource = i3;
        this.statusText = statusText;
        this.backgroundInfo = backgroundInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final BackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getIconResource() {
        return this.iconResource;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsAnimation() {
        return this.isAnimation;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelStatusInfo)) {
            return false;
        }
        ChannelStatusInfo channelStatusInfo = (ChannelStatusInfo) other;
        if (this.isAnimation == channelStatusInfo.isAnimation && this.iconResource == channelStatusInfo.iconResource && Intrinsics.areEqual(this.statusText, channelStatusInfo.statusText) && Intrinsics.areEqual(this.backgroundInfo, channelStatusInfo.backgroundInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isAnimation;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.iconResource) * 31) + this.statusText.hashCode()) * 31) + this.backgroundInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelStatusInfo(isAnimation=" + this.isAnimation + ", iconResource=" + this.iconResource + ", statusText=" + this.statusText + ", backgroundInfo=" + this.backgroundInfo + ")";
    }
}
