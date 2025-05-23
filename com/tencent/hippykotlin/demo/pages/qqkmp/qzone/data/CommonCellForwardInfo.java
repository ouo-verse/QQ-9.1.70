package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "", "()V", "forwardList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getForwardList", "()Ljava/util/List;", "setForwardList", "(Ljava/util/List;)V", WadlProxyConsts.KEY_JUMP_URL, "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "retweetCount", "", "getRetweetCount", "()I", "setRetweetCount", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellForwardInfo {
    public static final int $stable = 8;
    private List<CommonUser> forwardList = new ArrayList();
    private String jumpUrl = "";
    private int retweetCount;

    public final List<CommonUser> getForwardList() {
        return this.forwardList;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getRetweetCount() {
        return this.retweetCount;
    }

    public final void setForwardList(List<CommonUser> list) {
        this.forwardList = list;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final void setRetweetCount(int i3) {
        this.retweetCount = i3;
    }
}
