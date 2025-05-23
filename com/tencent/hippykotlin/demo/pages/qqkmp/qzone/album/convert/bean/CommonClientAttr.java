package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonClientAttr;", "", "()V", "attr", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonUinAttr;", "getAttr", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonUinAttr;", "setAttr", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonUinAttr;)V", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getUser", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "setUser", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonClientAttr {
    public static final int $stable = 8;
    private CommonStUser user = new CommonStUser();
    private CommonUinAttr attr = new CommonUinAttr();

    public final CommonUinAttr getAttr() {
        return this.attr;
    }

    public final CommonStUser getUser() {
        return this.user;
    }

    public final void setAttr(CommonUinAttr commonUinAttr) {
        this.attr = commonUinAttr;
    }

    public final void setUser(CommonStUser commonStUser) {
        this.user = commonStUser;
    }
}
