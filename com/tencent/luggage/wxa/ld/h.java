package com.tencent.luggage.wxa.ld;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f133296a;

    public h(boolean z16) {
        this.f133296a = z16;
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        if (this.f133296a) {
            return b("ssdp:all");
        }
        return a("ssdp:all");
    }

    public String b(String str) {
        return a(str, "[FF0x::C]");
    }

    public String a(String str) {
        return a(str, "239.255.255.250");
    }

    public String a(String str, String str2) {
        return "M-SEARCH * HTTP/1.1\r\nST:" + str + "\r\nHOST: " + str2 + ":1900\r\nMX: 3\r\nMAN: \"ssdp:discover\"\r\n\r\n";
    }
}
