package com.tencent.beacon.event;

import com.tencent.beacon.a.b.i;
import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements Callback<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBean f77901a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77902b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f77903c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, EventBean eventBean, String str) {
        this.f77903c = dVar;
        this.f77901a = eventBean;
        this.f77902b = str;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(byte[] bArr) {
        com.tencent.beacon.base.util.c.a("[EventManager]", "convert to report by beacon socket success, eventCode = %s, logId = %s", this.f77901a.getEventCode(), this.f77902b);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        com.tencent.beacon.base.util.c.e("convert to report by beacon socket also fail, failure = %s", dVar.toString());
        i.e().a("464", dVar.toString());
        this.f77903c.b(this.f77902b, this.f77901a);
    }
}
