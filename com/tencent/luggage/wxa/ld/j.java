package com.tencent.luggage.wxa.ld;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends e {

    /* renamed from: f, reason: collision with root package name */
    public String f133298f;

    public j(String str, String str2, String str3) {
        super(str, str2);
        this.f133298f = str3;
        a("SOAPACTION", "\"" + str2 + "#" + this.f133282b + "\"");
        f();
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        return b(0, this.f133298f);
    }

    @Override // com.tencent.luggage.wxa.ld.e
    public String b() {
        return "SetAVTransportURI";
    }

    public final String a(int i3, String str) {
        String a16 = new com.tencent.luggage.wxa.nd.n().a(str);
        return "<u:" + this.f133282b + " xmlns:u=\"" + this.f133284d + "\">\n<InstanceID>" + i3 + "</InstanceID>\n<CurrentURI>" + a16 + "</CurrentURI>\n<CurrentURIMetaData>" + ("&lt;DIDL-Lite xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:sec=&quot;http://www.sec.co.kr/&quot;&gt;&lt;item id=&quot;123&quot; parentID=&quot;-1&quot; restricted=&quot;1&quot;&gt;&lt;upnp:storageMedium&gt;UNKNOWN&lt;/upnp:storageMedium&gt;&lt;upnp:writeStatus&gt;UNKNOWN&lt;/upnp:writeStatus&gt;&lt;dc:title&gt;Video&lt;/dc:title&gt;&lt;dc:creator&gt;QGame&lt;/dc:creator&gt;&lt;upnp:class&gt;object.item.videoItem&lt;/upnp:class&gt;&lt;res protocolInfo=&quot;http-get:*:video/*:DLNA.ORG_OP=01;DLNA.ORG_CI=0;DLNA.ORG_FLAGS=01700000000000000000000000000000&quot;&gt;" + new com.tencent.luggage.wxa.nd.n().a(a16) + "&lt;/res&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;") + "</CurrentURIMetaData>\n</u:SetAVTransportURI>\n";
    }

    public String b(int i3, String str) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + a(i3, str) + "</s:Body></s:Envelope>";
    }
}
