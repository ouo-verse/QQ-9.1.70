package com.qzone.reborn.feedpro.banner.topbanner.constant;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "", WadlProxyConsts.BANNER_TYPE, "", "(Ljava/lang/String;II)V", "getBannerType", "()I", "TYPE_UNKNOWN", "TYPE_TOP_MSG_BANNER", "TYPE_SECOND_UNKNOWN", "TYPE_SECOND_NEW_MSG", "TYPE_SECOND_FRIEND_UPDATE", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public enum FeedProTopBannerType {
    TYPE_UNKNOWN(0),
    TYPE_TOP_MSG_BANNER(1),
    TYPE_SECOND_UNKNOWN(10000),
    TYPE_SECOND_NEW_MSG(10001),
    TYPE_SECOND_FRIEND_UPDATE(10002);

    private final int bannerType;

    FeedProTopBannerType(int i3) {
        this.bannerType = i3;
    }

    public final int getBannerType() {
        return this.bannerType;
    }
}
