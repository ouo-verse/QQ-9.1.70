package com.tencent.luggage.wxa.ld;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends e {
    public c(String str, String str2) {
        super(str, str2);
        a("SOAPACTION", "\"" + str2 + "#" + this.f133282b + "\"");
        f();
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        return b(0, "Master");
    }

    @Override // com.tencent.luggage.wxa.ld.e
    public String b() {
        return "GetVolume";
    }

    public final String a(int i3, String str) {
        return "<u:" + this.f133282b + " xmlns:u=\"" + this.f133284d + "\">\n<InstanceID>" + i3 + "</InstanceID>\n<Channel>" + str + "</Channel>\n</u:" + this.f133282b + ">\n";
    }

    public String b(int i3, String str) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + a(i3, str) + "</s:Body></s:Envelope>";
    }
}
