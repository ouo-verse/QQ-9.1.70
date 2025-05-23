package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.d f230156a = new com.tencent.mobileqq.guild.message.d(1);

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.d f230157b = new com.tencent.mobileqq.guild.message.d(2);

    private com.tencent.mobileqq.guild.message.d a() {
        if (!this.f230157b.a()) {
            com.tencent.mobileqq.guild.message.d dVar = this.f230157b;
            if (dVar.f230364c) {
                return dVar;
            }
        }
        if (!this.f230156a.a()) {
            com.tencent.mobileqq.guild.message.d dVar2 = this.f230156a;
            if (dVar2.f230364c) {
                return dVar2;
            }
            return null;
        }
        return null;
    }

    private void c(com.tencent.mobileqq.guild.message.d dVar, com.tencent.mobileqq.guild.message.d dVar2) {
        if (dVar2.f230364c) {
            dVar.f230364c = true;
            dVar.f230362a = dVar2.f230362a;
        } else if (dVar2.f230362a.equals(dVar.f230362a)) {
            dVar.f230364c = false;
            dVar.f230362a.b();
        }
    }

    public long b() {
        com.tencent.mobileqq.guild.message.d a16 = a();
        if (a16 != null) {
            return a16.f230362a.f230365a;
        }
        return com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;
    }

    public boolean d(com.tencent.mobileqq.guild.message.d dVar) {
        boolean z16;
        QLog.i("ChannelActiveStrategy", 1, "setActiveChannel channelInfo: " + dVar);
        if (dVar == null || dVar.a()) {
            return false;
        }
        long b16 = b();
        int i3 = dVar.f230363b;
        if (i3 == 1) {
            c(this.f230156a, dVar);
            if (dVar.f230364c && ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isSplashActivityTop()) {
                com.tencent.mobileqq.guild.message.d dVar2 = this.f230157b;
                dVar2.f230364c = false;
                dVar2.f230362a.b();
            }
        } else if (i3 == 2) {
            c(this.f230157b, dVar);
        }
        long b17 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setActiveChannel mf: ");
        sb5.append(this.f230156a.toString());
        sb5.append(" oneSelf:");
        sb5.append(this.f230157b.toString());
        sb5.append(" new:");
        sb5.append(b17);
        sb5.append(" bChange:");
        if (b16 != b17) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("ChannelActiveStrategy", 1, sb5.toString());
        if (b16 != b17) {
            return true;
        }
        return false;
    }
}
