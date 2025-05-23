package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUserAccountEntry;", "", "()V", "account", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUserAccountBaseMate;", "getAccount", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUserAccountBaseMate;", "setAccount", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUserAccountBaseMate;)V", "uid", "", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStUserAccountEntry {
    public static final int $stable = 8;
    private String uid = "";
    private CommonStUserAccountBaseMate account = new CommonStUserAccountBaseMate();

    public final CommonStUserAccountBaseMate getAccount() {
        return this.account;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setAccount(CommonStUserAccountBaseMate commonStUserAccountBaseMate) {
        this.account = commonStUserAccountBaseMate;
    }

    public final void setUid(String str) {
        this.uid = str;
    }
}
