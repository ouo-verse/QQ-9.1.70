package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.d f230158a = new com.tencent.mobileqq.guild.message.d(1);

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.d f230159b = new com.tencent.mobileqq.guild.message.d(2);

    private void c(com.tencent.mobileqq.guild.message.d dVar, com.tencent.mobileqq.guild.message.d dVar2) {
        if (dVar2.f230364c) {
            dVar.f230364c = true;
            dVar.f230362a = dVar2.f230362a;
        } else if (dVar2.f230362a.equals(dVar.f230362a)) {
            dVar.f230364c = false;
            dVar.f230362a.b();
        }
    }

    public com.tencent.mobileqq.guild.message.d a() {
        if (!this.f230159b.a()) {
            com.tencent.mobileqq.guild.message.d dVar = this.f230159b;
            if (dVar.f230364c) {
                return dVar;
            }
        }
        if (!this.f230158a.a()) {
            com.tencent.mobileqq.guild.message.d dVar2 = this.f230158a;
            if (dVar2.f230364c) {
                return dVar2;
            }
            return null;
        }
        return null;
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
        QLog.i("GuildActiveStrategy", 1, "setActiveGuild guildInfo: " + dVar);
        if (dVar == null || dVar.a()) {
            return false;
        }
        long b16 = b();
        int i3 = dVar.f230363b;
        if (i3 == 1) {
            c(this.f230158a, dVar);
            if (dVar.f230364c && ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isSplashActivityTop()) {
                com.tencent.mobileqq.guild.message.d dVar2 = this.f230159b;
                dVar2.f230364c = false;
                dVar2.f230362a.b();
            }
        } else if (i3 == 2) {
            c(this.f230159b, dVar);
        }
        long b17 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setActiveGuild mf: ");
        sb5.append(this.f230158a.toString());
        sb5.append(" oneSelf:");
        sb5.append(this.f230159b.toString());
        sb5.append(" new:");
        sb5.append(b17);
        sb5.append(" bChange:");
        if (b16 != b17) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GuildActiveStrategy", 1, sb5.toString());
        if (b16 != b17) {
            return true;
        }
        return false;
    }
}
