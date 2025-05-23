package com.tencent.luggage.wxa.bj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends g {

    /* renamed from: c, reason: collision with root package name */
    public final String f122917c;

    /* renamed from: d, reason: collision with root package name */
    public final a f122918d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            f.super.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.tencent.luggage.wxa.ic.g rt5) {
        super(rt5);
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f122917c = "Luggage.WXA.NetworkServiceBySystemReceiver";
        this.f122918d = new a();
    }

    @Override // com.tencent.luggage.wxa.bj.g, com.tencent.luggage.wxa.ya.b
    public void G() {
        super.G();
        try {
            f().unregisterReceiver(this.f122918d);
        } catch (Throwable th5) {
            w.b(this.f122917c, "unregister network receiver, t=" + th5);
        }
    }

    @Override // com.tencent.luggage.wxa.bj.g, com.tencent.luggage.wxa.ya.b
    public void e() {
        super.e();
        try {
            Context f16 = f();
            a aVar = this.f122918d;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            Unit unit = Unit.INSTANCE;
            f16.registerReceiver(aVar, intentFilter);
        } catch (Throwable th5) {
            w.b(this.f122917c, "register network receiver, t=" + th5);
        }
    }

    public final Context f() {
        Context c16 = z.c();
        Intrinsics.checkNotNull(c16);
        return c16;
    }
}
