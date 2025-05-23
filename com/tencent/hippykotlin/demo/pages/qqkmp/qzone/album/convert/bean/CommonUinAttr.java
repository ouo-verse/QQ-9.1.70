package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e\u00a8\u0006'"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonUinAttr;", "", "()V", "addTime", "", "getAddTime", "()J", "setAddTime", "(J)V", "familyRole", "", "getFamilyRole", "()I", "setFamilyRole", "(I)V", "joinTime", "getJoinTime", "setJoinTime", "nick", "", "getNick", "()Ljava/lang/String;", "setNick", "(Ljava/lang/String;)V", "priv", "getPriv", "setPriv", "qa", "getQa", "setQa", "shareAlbumid", "getShareAlbumid", "setShareAlbumid", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "total", "getTotal", "setTotal", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonUinAttr {
    public static final int $stable = 8;
    private long addTime;
    private int familyRole;
    private long joinTime;
    private int priv;
    private int status;
    private int total;
    private String nick = "";
    private String shareAlbumid = "";
    private String qa = "";

    public final long getAddTime() {
        return this.addTime;
    }

    public final int getFamilyRole() {
        return this.familyRole;
    }

    public final long getJoinTime() {
        return this.joinTime;
    }

    public final String getNick() {
        return this.nick;
    }

    public final int getPriv() {
        return this.priv;
    }

    public final String getQa() {
        return this.qa;
    }

    public final String getShareAlbumid() {
        return this.shareAlbumid;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setAddTime(long j3) {
        this.addTime = j3;
    }

    public final void setFamilyRole(int i3) {
        this.familyRole = i3;
    }

    public final void setJoinTime(long j3) {
        this.joinTime = j3;
    }

    public final void setNick(String str) {
        this.nick = str;
    }

    public final void setPriv(int i3) {
        this.priv = i3;
    }

    public final void setQa(String str) {
        this.qa = str;
    }

    public final void setShareAlbumid(String str) {
        this.shareAlbumid = str;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final void setTotal(int i3) {
        this.total = i3;
    }
}
