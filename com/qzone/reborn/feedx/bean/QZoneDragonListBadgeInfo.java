package com.qzone.reborn.feedx.bean;

import com.google.gson.annotations.SerializedName;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedx/bean/QZoneDragonListBadgeInfo;", "Ljava/io/Serializable;", "()V", WadlProxyConsts.KEY_JUMP_URL, "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "list", "", "Lcom/qzone/feed/business/model/FeedResourceInfo;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneDragonListBadgeInfo implements Serializable {

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("list")
    private List<FeedResourceInfo> list;

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<FeedResourceInfo> getList() {
        return this.list;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final void setList(List<FeedResourceInfo> list) {
        this.list = list;
    }
}
