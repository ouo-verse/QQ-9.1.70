package com.tencent.beacon.base.net.adapter;

import okhttp3.Callback;

/* compiled from: P */
/* loaded from: classes2.dex */
class d implements Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.Callback f77711a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77712b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ OkHttpAdapter f77713c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OkHttpAdapter okHttpAdapter, com.tencent.beacon.base.net.call.Callback callback, String str) {
        this.f77713c = okHttpAdapter;
        this.f77711a = callback;
        this.f77712b = str;
    }
}
