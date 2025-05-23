package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonActiveAlbumInfo;", "", "()V", "isActiveAlbum", "", "()Z", "setActiveAlbum", "(Z)V", WadlProxyConsts.KEY_JUMP_URL, "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonActiveAlbumInfo {
    public static final int $stable = 8;
    private boolean isActiveAlbum;
    private String jumpUrl = "";

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: isActiveAlbum, reason: from getter */
    public final boolean getIsActiveAlbum() {
        return this.isActiveAlbum;
    }

    public final void setActiveAlbum(boolean z16) {
        this.isActiveAlbum = z16;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }
}
