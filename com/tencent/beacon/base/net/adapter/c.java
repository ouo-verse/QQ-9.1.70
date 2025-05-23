package com.tencent.beacon.base.net.adapter;

import okhttp3.Callback;

/* compiled from: P */
/* loaded from: classes2.dex */
class c implements Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.Callback f77708a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77709b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ OkHttpAdapter f77710c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(OkHttpAdapter okHttpAdapter, com.tencent.beacon.base.net.call.Callback callback, String str) {
        this.f77710c = okHttpAdapter;
        this.f77708a = callback;
        this.f77709b = str;
    }
}
