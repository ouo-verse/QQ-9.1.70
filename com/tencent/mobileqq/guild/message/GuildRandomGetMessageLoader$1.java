package com.tencent.mobileqq.guild.message;

import android.util.Pair;
import com.tencent.imcore.message.aj;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
class GuildRandomGetMessageLoader$1 implements Runnable {
    final /* synthetic */ boolean C;
    final /* synthetic */ boolean D;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ aj f230101d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f230102e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f230103f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f230104h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f230105i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Pair f230106m;
    final /* synthetic */ u this$0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.GuildRandomGetMessageLoader$1$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildRandomGetMessageLoader$1 f230107d;

        @Override // java.lang.Runnable
        public void run() {
            this.f230107d.getClass();
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.d("GuildRandomGetMessageLoader", 2, "refreshUnreadMessage begin");
        }
        aj ajVar = this.f230101d;
        int i3 = this.f230102e;
        ajVar.f116543u = i3;
        ajVar.f116535m = 0;
        u.a(null, this.f230103f, this.f230104h, this.f230105i, i3, this.f230106m, ajVar, this.C);
        boolean b16 = u.b(null, this.f230103f, this.f230104h, this.f230105i, ((Long) this.f230106m.first).longValue(), this.f230102e);
        QLog.d("GuildRandomGetMessageLoader", 1, "refreshTroopUnreadMessage isSuccess:", Boolean.valueOf(b16));
        if (b16 && this.D) {
            throw null;
        }
        this.f230101d.f116532j = b16;
        if (this.C) {
            throw null;
        }
        throw null;
    }
}
