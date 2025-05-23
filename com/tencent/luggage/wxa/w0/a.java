package com.tencent.luggage.wxa.w0;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f143983a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f143984b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b1.b f143985c;

    public a(Context context, com.tencent.luggage.wxa.b1.b bVar) {
        this.f143983a = context;
        this.f143984b = LayoutInflater.from(context);
        this.f143985c = bVar;
    }

    public Context a() {
        return this.f143983a;
    }

    public com.tencent.luggage.wxa.b1.b b() {
        return this.f143985c;
    }

    public LayoutInflater c() {
        return this.f143984b;
    }
}
