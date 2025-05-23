package com.tencent.mobileqq.minigame.va.banner;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/banner/MiniGameVAResourceBannerInfo;", "", VirtualAppProxy.KEY_GAME_ID, "", "miniGameAppId", "bannerStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBannerStr", "()Ljava/lang/String;", "getGameId", "getMiniGameAppId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class MiniGameVAResourceBannerInfo {
    private final String bannerStr;
    private final String gameId;
    private final String miniGameAppId;

    public MiniGameVAResourceBannerInfo(String gameId, String miniGameAppId, String bannerStr) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(miniGameAppId, "miniGameAppId");
        Intrinsics.checkNotNullParameter(bannerStr, "bannerStr");
        this.gameId = gameId;
        this.miniGameAppId = miniGameAppId;
        this.bannerStr = bannerStr;
    }

    /* renamed from: component1, reason: from getter */
    public final String getGameId() {
        return this.gameId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMiniGameAppId() {
        return this.miniGameAppId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBannerStr() {
        return this.bannerStr;
    }

    public final MiniGameVAResourceBannerInfo copy(String gameId, String miniGameAppId, String bannerStr) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(miniGameAppId, "miniGameAppId");
        Intrinsics.checkNotNullParameter(bannerStr, "bannerStr");
        return new MiniGameVAResourceBannerInfo(gameId, miniGameAppId, bannerStr);
    }

    public final String getBannerStr() {
        return this.bannerStr;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getMiniGameAppId() {
        return this.miniGameAppId;
    }

    public int hashCode() {
        return (((this.gameId.hashCode() * 31) + this.miniGameAppId.hashCode()) * 31) + this.bannerStr.hashCode();
    }

    public String toString() {
        return "MiniGameVAResourceBannerInfo(gameId=" + this.gameId + ", miniGameAppId=" + this.miniGameAppId + ", bannerStr=" + this.bannerStr + ")";
    }

    public static /* synthetic */ MiniGameVAResourceBannerInfo copy$default(MiniGameVAResourceBannerInfo miniGameVAResourceBannerInfo, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = miniGameVAResourceBannerInfo.gameId;
        }
        if ((i3 & 2) != 0) {
            str2 = miniGameVAResourceBannerInfo.miniGameAppId;
        }
        if ((i3 & 4) != 0) {
            str3 = miniGameVAResourceBannerInfo.bannerStr;
        }
        return miniGameVAResourceBannerInfo.copy(str, str2, str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniGameVAResourceBannerInfo)) {
            return false;
        }
        MiniGameVAResourceBannerInfo miniGameVAResourceBannerInfo = (MiniGameVAResourceBannerInfo) other;
        return Intrinsics.areEqual(this.gameId, miniGameVAResourceBannerInfo.gameId) && Intrinsics.areEqual(this.miniGameAppId, miniGameVAResourceBannerInfo.miniGameAppId) && Intrinsics.areEqual(this.bannerStr, miniGameVAResourceBannerInfo.bannerStr);
    }
}
