package com.tencent.luggage.wxa.nl;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.nb.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends f implements a {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.cg.c f135879b;

    /* renamed from: c, reason: collision with root package name */
    public a.c f135880c;

    public e(Context context) {
        super(context);
        this.f135879b = null;
    }

    @Override // com.tencent.luggage.wxa.nl.f, com.tencent.luggage.wxa.ee.f
    public /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.tencent.luggage.wxa.nl.a
    @Nullable
    public a.c getKeyValueSet() {
        return this.f135880c;
    }

    @Override // com.tencent.luggage.wxa.cg.b
    @Nullable
    public com.tencent.luggage.wxa.cg.c getReferrerPolicy() {
        return this.f135879b;
    }

    @Override // com.tencent.luggage.wxa.nl.f
    public /* bridge */ /* synthetic */ void setInterceptEvent(boolean z16) {
        super.setInterceptEvent(z16);
    }

    @Override // com.tencent.luggage.wxa.nl.a
    public void setKeyValueSet(@Nullable a.c cVar) {
        this.f135880c = cVar;
    }

    @Override // com.tencent.luggage.wxa.cg.b
    public void setReferrerPolicy(@Nullable com.tencent.luggage.wxa.cg.c cVar) {
        this.f135879b = cVar;
    }

    @Override // com.tencent.luggage.wxa.nl.a
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.nl.c
    public void setImageByteArray(byte[] bArr) {
    }

    public void setImageFilePath(String str) {
    }
}
