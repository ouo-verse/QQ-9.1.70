package com.tencent.luggage.wxa.ld;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends e {

    /* renamed from: f, reason: collision with root package name */
    public int f133299f;

    public k(String str, String str2, int i3) {
        super(str, str2);
        this.f133299f = i3;
        a("SOAPACTION", "\"" + str2 + "#" + this.f133282b + "\"");
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        return b(0, "Master", this.f133299f);
    }

    @Override // com.tencent.luggage.wxa.ld.e
    public String b() {
        return "SetVolume";
    }

    public final String a(int i3, String str, int i16) {
        return "<u:" + this.f133282b + " xmlns:u=\"" + this.f133284d + "\">\n<InstanceID>" + i3 + "</InstanceID>\n<Channel>" + str + "</Channel>\n<DesiredVolume>" + i16 + "</DesiredVolume>\n</u:" + this.f133282b + ">\n";
    }

    public String b(int i3, String str, int i16) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + a(i3, str, i16) + "</s:Body></s:Envelope>";
    }
}
