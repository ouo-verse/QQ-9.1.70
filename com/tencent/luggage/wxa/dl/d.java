package com.tencent.luggage.wxa.dl;

import com.tencent.luggage.wxa.gl.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {
    @Override // com.tencent.luggage.wxa.dl.b, com.tencent.luggage.wxa.dl.a
    public com.tencent.luggage.wxa.gl.c a(com.tencent.luggage.wxa.gl.a aVar, i iVar) {
        super.a(aVar, iVar);
        iVar.c("WebSocket Protocol Handshake");
        iVar.a("Server", "Java-WebSocket");
        iVar.a("Date", d());
        return iVar;
    }

    public final String d() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    @Override // com.tencent.luggage.wxa.dl.c, com.tencent.luggage.wxa.dl.b, com.tencent.luggage.wxa.dl.a
    public a a() {
        return new d();
    }
}
