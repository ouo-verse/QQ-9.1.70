package com.tencent.gdtad.basics.adbox;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f108691a;

    /* renamed from: b, reason: collision with root package name */
    private GdtAdBoxData f108692b;

    /* renamed from: c, reason: collision with root package name */
    private GdtAdBoxListener f108693c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f108691a = context;
    }

    public a a() {
        a aVar = new a();
        aVar.f(this.f108691a);
        aVar.g(this.f108692b);
        aVar.h(this.f108693c);
        return aVar;
    }

    public b b(GdtAdBoxData gdtAdBoxData) {
        this.f108692b = gdtAdBoxData;
        return this;
    }

    public b c(GdtAdBoxListener gdtAdBoxListener) {
        this.f108693c = gdtAdBoxListener;
        return this;
    }
}
