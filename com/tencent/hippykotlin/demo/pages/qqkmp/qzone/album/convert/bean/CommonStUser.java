package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "", "()V", "nick", "", "getNick", "()Ljava/lang/String;", "setNick", "(Ljava/lang/String;)V", "uid", "getUid", "setUid", "uin", "getUin", "setUin", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStUser {
    public static final int $stable = 8;
    private String uid = "";
    private String uin = "";
    private String nick = "";

    public final String getNick() {
        return this.nick;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUin() {
        return this.uin;
    }

    public final void setNick(String str) {
        this.nick = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUin(String str) {
        this.uin = str;
    }
}
