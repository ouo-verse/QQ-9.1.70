package com.tencent.luggage.wxa.gi;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements com.tencent.luggage.wxa.hi.d {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f126766b = Pattern.compile(String.format("%s(.*)%s", "<kLog>", "</kLog>"));

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.hi.d f126767a = null;

    @Override // com.tencent.luggage.wxa.hi.d
    public void a(String str, String str2, Object... objArr) {
        com.tencent.luggage.wxa.hi.d dVar = this.f126767a;
        if (dVar == null) {
            return;
        }
        dVar.a(str, String.format("%s%s%s", "<kLog>", str2, "</kLog>"), objArr);
    }
}
