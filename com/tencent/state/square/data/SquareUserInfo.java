package com.tencent.state.square.data;

import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/data/SquareUserInfo;", "", "uin", "", "nick", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "(Ljava/lang/String;)V", "getNick", "setNick", "getUin", "setUin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareUserInfo {
    private String avatar;
    private String nick;
    private String uin;

    public SquareUserInfo(String uin, String nick, String avatar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        this.uin = uin;
        this.nick = nick;
        this.avatar = avatar;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    public final SquareUserInfo copy(String uin, String nick, String avatar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        return new SquareUserInfo(uin, nick, avatar);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNick() {
        return this.nick;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setNick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void setUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public String toString() {
        return "SquareUserInfo(uin=" + this.uin + ", nick=" + this.nick + ", avatar=" + this.avatar + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareUserInfo)) {
            return false;
        }
        SquareUserInfo squareUserInfo = (SquareUserInfo) other;
        return Intrinsics.areEqual(this.uin, squareUserInfo.uin) && Intrinsics.areEqual(this.nick, squareUserInfo.nick) && Intrinsics.areEqual(this.avatar, squareUserInfo.avatar);
    }

    public static /* synthetic */ SquareUserInfo copy$default(SquareUserInfo squareUserInfo, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareUserInfo.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = squareUserInfo.nick;
        }
        if ((i3 & 4) != 0) {
            str3 = squareUserInfo.avatar;
        }
        return squareUserInfo.copy(str, str2, str3);
    }
}
