package com.qzone.reborn.feedx.bean;

import com.google.gson.annotations.SerializedName;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedx/bean/QZoneDragonThreeLayerBadgeInfo;", "Ljava/io/Serializable;", "()V", "bottom", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "getBottom", "()Lcom/qzone/feed/business/model/FeedResourceInfo;", "setBottom", "(Lcom/qzone/feed/business/model/FeedResourceInfo;)V", WadlProxyConsts.KEY_JUMP_URL, "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "middle", "", "getMiddle", "()Ljava/util/List;", "setMiddle", "(Ljava/util/List;)V", "top", "getTop", "setTop", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneDragonThreeLayerBadgeInfo implements Serializable {

    @SerializedName("bottom")
    private FeedResourceInfo bottom;

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("middle")
    private List<FeedResourceInfo> middle;

    @SerializedName("top")
    private FeedResourceInfo top;

    public final FeedResourceInfo getBottom() {
        return this.bottom;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<FeedResourceInfo> getMiddle() {
        return this.middle;
    }

    public final FeedResourceInfo getTop() {
        return this.top;
    }

    public final void setBottom(FeedResourceInfo feedResourceInfo) {
        this.bottom = feedResourceInfo;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final void setMiddle(List<FeedResourceInfo> list) {
        this.middle = list;
    }

    public final void setTop(FeedResourceInfo feedResourceInfo) {
        this.top = feedResourceInfo;
    }
}
