package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyVerify {

    /* renamed from: msg, reason: collision with root package name */
    public String f359161msg;
    public int type;
    public String url;

    public BuddyVerify() {
        this.f359161msg = "";
        this.url = "";
    }

    public String getMsg() {
        return this.f359161msg;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public BuddyVerify(int i3, String str, String str2) {
        this.type = i3;
        this.f359161msg = str;
        this.url = str2;
    }
}
