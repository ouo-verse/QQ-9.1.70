package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.ld.e;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends e {
    public m(String str, String str2) {
        this(str, str2, TVKEventId.PLAYER_STATE_SWITCHDEF_START);
    }

    @Override // com.tencent.luggage.wxa.ld.d
    public String a() {
        return "";
    }

    @Override // com.tencent.luggage.wxa.ld.e
    public String b() {
        return "SUBSCRIBE";
    }

    public m(String str, String str2, int i3) {
        super(str, "");
        a(e.a.SUBSCRIBE);
        a("Nt", "upnp:event");
        a(HttpHeaders.TIMEOUT, "Second-" + i3);
        a("Callback", "<" + str2 + ">");
    }
}
