package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareAlbumMeta;", "", "()V", "autoJoin", "", "getAutoJoin", "()Z", "setAutoJoin", "(Z)V", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getOwner", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "setOwner", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;)V", "shareNums", "", "getShareNums", "()I", "setShareNums", "(I)V", "shareattrs", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonClientAttr;", "getShareattrs", "()Ljava/util/List;", "setShareattrs", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonShareAlbumMeta {
    public static final int $stable = 8;
    private boolean autoJoin;
    private int shareNums;
    private CommonStUser owner = new CommonStUser();
    private List<CommonClientAttr> shareattrs = new ArrayList();

    public final boolean getAutoJoin() {
        return this.autoJoin;
    }

    public final CommonStUser getOwner() {
        return this.owner;
    }

    public final int getShareNums() {
        return this.shareNums;
    }

    public final List<CommonClientAttr> getShareattrs() {
        return this.shareattrs;
    }

    public final void setAutoJoin(boolean z16) {
        this.autoJoin = z16;
    }

    public final void setOwner(CommonStUser commonStUser) {
        this.owner = commonStUser;
    }

    public final void setShareNums(int i3) {
        this.shareNums = i3;
    }

    public final void setShareattrs(List<CommonClientAttr> list) {
        this.shareattrs = list;
    }
}
