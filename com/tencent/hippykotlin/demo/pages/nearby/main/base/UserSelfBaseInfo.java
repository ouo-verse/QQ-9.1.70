package com.tencent.hippykotlin.demo.pages.nearby.main.base;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserSelfBaseInfo {
    public String accountId;
    public int appId;
    public String avatarUrl;
    public String nick;

    public UserSelfBaseInfo() {
        this(0, 15);
    }

    public UserSelfBaseInfo(int i3, String str, String str2, String str3) {
        this.appId = i3;
        this.accountId = str;
        this.nick = str2;
        this.avatarUrl = str3;
    }

    public /* synthetic */ UserSelfBaseInfo(int i3, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : null, (i16 & 4) != 0 ? "" : null, (i16 & 8) == 0 ? null : "");
    }
}
