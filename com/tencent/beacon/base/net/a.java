package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements Callback<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JceRequestEntity f77699a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f77700b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Callback f77701c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c f77702d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar, JceRequestEntity jceRequestEntity, boolean z16, Callback callback) {
        this.f77702d = cVar;
        this.f77699a = jceRequestEntity;
        this.f77700b = z16;
        this.f77701c = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(byte[] bArr) {
        String str;
        String str2;
        String str3;
        if (bArr != null && bArr.length > 0) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("jceRequest: ");
                sb5.append(this.f77699a.getType());
                sb5.append(" request success!");
                com.tencent.beacon.base.util.c.a("[BeaconNet]", sb5.toString(), new Object[0]);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("mode: ");
                if (this.f77700b) {
                    str3 = com.tencent.mobileqq.msf.core.d.f247918u;
                } else {
                    str3 = "http";
                }
                sb6.append(str3);
                com.tencent.beacon.base.util.c.a("[BeaconNet]", sb6.toString(), new Object[0]);
                this.f77701c.onResponse(bArr);
                this.f77702d.f();
                return;
            } catch (Exception e16) {
                String name = this.f77699a.getType().name();
                if (this.f77700b) {
                    str2 = "403";
                } else {
                    str2 = "453";
                }
                onFailure(new d(name, str2, 200, e16.getMessage(), e16));
                return;
            }
        }
        String name2 = this.f77699a.getType().name();
        if (this.f77700b) {
            str = "402";
        } else {
            str = "452";
        }
        onFailure(new d(name2, str, 200, "raw response == null", null));
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(d dVar) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "jceRequest: " + dVar.toString(), new Object[0]);
        this.f77702d.a(dVar);
        this.f77701c.onFailure(dVar);
        this.f77702d.f();
    }
}
