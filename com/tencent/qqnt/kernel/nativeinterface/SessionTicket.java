package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SessionTicket {

    /* renamed from: a2, reason: collision with root package name */
    public String f359218a2;

    /* renamed from: d2, reason: collision with root package name */
    public String f359219d2;
    public String d2Key;

    public SessionTicket() {
        this.f359218a2 = "";
        this.f359219d2 = "";
        this.d2Key = "";
    }

    public String getA2() {
        return this.f359218a2;
    }

    public String getD2() {
        return this.f359219d2;
    }

    public String getD2Key() {
        return this.d2Key;
    }

    public String toString() {
        return "SessionTicket{a2=" + this.f359218a2 + ",d2=" + this.f359219d2 + ",d2Key=" + this.d2Key + ",}";
    }

    public SessionTicket(String str, String str2, String str3) {
        this.f359218a2 = str;
        this.f359219d2 = str2;
        this.d2Key = str3;
    }
}
