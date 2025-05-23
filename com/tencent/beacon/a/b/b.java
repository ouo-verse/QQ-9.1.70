package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements Callback<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77589a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77590b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Throwable f77591c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f77592d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, String str, String str2, Throwable th5) {
        this.f77592d = gVar;
        this.f77589a = str;
        this.f77590b = str2;
        this.f77591c = th5;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(BResponse bResponse) {
        com.tencent.beacon.base.util.c.a("AttaReport", "net ret: " + bResponse.toString(), new Object[0]);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        this.f77592d.b(this.f77589a, this.f77590b, this.f77591c);
    }
}
