package o93;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lo93/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "channelMsg", "b", "c", WadlProxyConsts.KEY_JUMP_URL, "iconUrl", "d", "nightIconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: o93.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PromotionChannelItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nightIconUrl;

    public PromotionChannelItem(@NotNull String channelMsg, @NotNull String jumpUrl, @NotNull String iconUrl, @NotNull String nightIconUrl) {
        Intrinsics.checkNotNullParameter(channelMsg, "channelMsg");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(nightIconUrl, "nightIconUrl");
        this.channelMsg = channelMsg;
        this.jumpUrl = jumpUrl;
        this.iconUrl = iconUrl;
        this.nightIconUrl = nightIconUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelMsg() {
        return this.channelMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getNightIconUrl() {
        return this.nightIconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionChannelItem)) {
            return false;
        }
        PromotionChannelItem promotionChannelItem = (PromotionChannelItem) other;
        if (Intrinsics.areEqual(this.channelMsg, promotionChannelItem.channelMsg) && Intrinsics.areEqual(this.jumpUrl, promotionChannelItem.jumpUrl) && Intrinsics.areEqual(this.iconUrl, promotionChannelItem.iconUrl) && Intrinsics.areEqual(this.nightIconUrl, promotionChannelItem.nightIconUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.channelMsg.hashCode() * 31) + this.jumpUrl.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.nightIconUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "PromotionChannelItem(channelMsg=" + this.channelMsg + ", jumpUrl=" + this.jumpUrl + ", iconUrl=" + this.iconUrl + ", nightIconUrl=" + this.nightIconUrl + ")";
    }
}
