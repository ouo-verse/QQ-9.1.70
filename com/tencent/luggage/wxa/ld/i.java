package com.tencent.luggage.wxa.ld;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends e {

    /* renamed from: f, reason: collision with root package name */
    public String f133297f;

    public i(String str, String str2, String str3) {
        super(str, str2);
        this.f133297f = str3;
        a("SOAPACTION", "\"" + str2 + "#" + this.f133282b + "\"");
        f();
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        return b(0, "REL_TIME", this.f133297f);
    }

    @Override // com.tencent.luggage.wxa.ld.e
    public String b() {
        return "Seek";
    }

    public final String a(int i3, String str, String str2) {
        return "<u:" + this.f133282b + " xmlns:u=\"" + this.f133284d + "\">\n <InstanceID>" + i3 + "</InstanceID>\n <Unit>" + str + "</Unit>\n <Target>" + str2 + "</Target>\n</u:" + this.f133282b + ">\n";
    }

    public String b(int i3, String str, String str2) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + a(i3, str, str2) + "</s:Body></s:Envelope>";
    }
}
