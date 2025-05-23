package com.tencent.state.square.pickfriend.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/pickfriend/service/FriendData;", "", "uin", "", "header", "nick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getNick", "getUin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FriendData {
    private final String header;
    private final String nick;
    private final String uin;

    public FriendData(String uin, String header, String nick) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(nick, "nick");
        this.uin = uin;
        this.header = header;
        this.nick = nick;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    public final FriendData copy(String uin, String header, String nick) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new FriendData(uin, header, nick);
    }

    public final String getHeader() {
        return this.header;
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
        String str2 = this.header;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nick;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "FriendData(uin=" + this.uin + ", header=" + this.header + ", nick=" + this.nick + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendData)) {
            return false;
        }
        FriendData friendData = (FriendData) other;
        return Intrinsics.areEqual(this.uin, friendData.uin) && Intrinsics.areEqual(this.header, friendData.header) && Intrinsics.areEqual(this.nick, friendData.nick);
    }

    public static /* synthetic */ FriendData copy$default(FriendData friendData, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = friendData.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = friendData.header;
        }
        if ((i3 & 4) != 0) {
            str3 = friendData.nick;
        }
        return friendData.copy(str, str2, str3);
    }
}
