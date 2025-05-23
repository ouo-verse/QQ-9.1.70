package com.tencent.luggage.wxa.l0;

import android.content.Context;
import com.tencent.luggage.wxa.l0.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m implements g.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f132805a;

    /* renamed from: b, reason: collision with root package name */
    public final u f132806b;

    /* renamed from: c, reason: collision with root package name */
    public final g.a f132807c;

    public m(Context context, u uVar, g.a aVar) {
        this.f132805a = context.getApplicationContext();
        this.f132806b = uVar;
        this.f132807c = aVar;
    }

    @Override // com.tencent.luggage.wxa.l0.g.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l createDataSource() {
        return new l(this.f132805a, this.f132806b, this.f132807c.createDataSource());
    }
}
