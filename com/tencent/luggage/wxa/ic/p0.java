package com.tencent.luggage.wxa.ic;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p0 implements com.tencent.luggage.wxa.dq.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tn.b0 f129984a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f129985b;

    public p0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Printer printer, String str) {
        this.f129984a.a(printer, str);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public String b() {
        return this.f129984a.b();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean c(Runnable runnable) {
        return this.f129984a.c(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean e() {
        return this.f129984a.e();
    }

    public p0(com.tencent.luggage.wxa.tn.b0 mLegacyHandler) {
        Intrinsics.checkNotNullParameter(mLegacyHandler, "mLegacyHandler");
        this.f129984a = mLegacyHandler;
        this.f129985b = Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : null;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Looper a() {
        return this.f129984a.a();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(int i3, Object obj) {
        this.f129984a.b(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void c(int i3) {
        this.f129984a.c(i3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3) {
        return this.f129984a.a(i3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean b(int i3) {
        return this.f129984a.b(i3);
    }

    public /* synthetic */ p0(com.tencent.luggage.wxa.tn.b0 b0Var, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper()) : b0Var);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, int i16, int i17, Object obj) {
        return this.f129984a.a(i3, i16, i17, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f129984a.b(runnable);
        Handler handler = this.f129985b;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, Object obj) {
        return this.f129984a.a(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable) {
        return this.f129984a.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable, long j3) {
        return this.f129984a.a(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3, long j3) {
        return this.f129984a.a(i3, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message) {
        return this.f129984a.a(message);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message, long j3) {
        return this.f129984a.a(message, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Object obj) {
        this.f129984a.a(obj);
        Handler handler = this.f129985b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(obj);
        }
    }

    public final void a(Runnable runnable, boolean z16) {
        Handler handler;
        if (runnable == null) {
            return;
        }
        if (z16 && (handler = this.f129985b) != null) {
            handler.postAtFrontOfQueue(runnable);
        } else {
            this.f129984a.c(runnable);
        }
    }
}
