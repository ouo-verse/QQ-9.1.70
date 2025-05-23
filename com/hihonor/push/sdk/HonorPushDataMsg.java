package com.hihonor.push.sdk;

/* loaded from: classes2.dex */
public class HonorPushDataMsg {

    /* renamed from: a, reason: collision with root package name */
    public int f36347a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f36348b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f36349c;

    /* renamed from: d, reason: collision with root package name */
    public String f36350d;

    public String getData() {
        return this.f36350d;
    }

    public long getMsgId() {
        return this.f36349c;
    }

    public int getType() {
        return this.f36348b;
    }

    public int getVersion() {
        return this.f36347a;
    }

    public void setData(String str) {
        this.f36350d = str;
    }

    public void setMsgId(long j3) {
        this.f36349c = j3;
    }

    public void setType(int i3) {
        this.f36348b = i3;
    }

    public void setVersion(int i3) {
        this.f36347a = i3;
    }
}
