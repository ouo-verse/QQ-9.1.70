package com.tencent.luggage.wxa.dc;

import android.content.Context;
import com.tencent.luggage.wxa.fc.e;
import com.tencent.luggage.wxa.fc.f;
import com.tencent.luggage.wxa.hc.c;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ec.a f124177a;

    public b(Context context, f fVar) {
        com.tencent.luggage.wxa.ec.a aVar = new com.tencent.luggage.wxa.ec.a(2);
        this.f124177a = aVar;
        aVar.E = context;
        aVar.f124619b = fVar;
    }

    public b a(boolean[] zArr) {
        this.f124177a.f124627j = zArr;
        return this;
    }

    public b b(int i3) {
        this.f124177a.X = i3;
        return this;
    }

    public b a(Calendar calendar) {
        this.f124177a.f124628k = calendar;
        return this;
    }

    public b a(Calendar calendar, Calendar calendar2) {
        com.tencent.luggage.wxa.ec.a aVar = this.f124177a;
        aVar.f124629l = calendar;
        aVar.f124630m = calendar2;
        return this;
    }

    public b a(int i3) {
        this.f124177a.P = i3;
        return this;
    }

    public b a(boolean z16) {
        this.f124177a.f124625h = z16;
        return this;
    }

    public b a(e eVar) {
        this.f124177a.f124620c = eVar;
        return this;
    }

    public void a(c cVar) {
        cVar.a(this.f124177a);
    }
}
