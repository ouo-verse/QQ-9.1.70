package com.tencent.tab.exp.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final q f374094a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TabExpDependInjector f374095b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    protected final dd4.a f374096c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    protected final jd4.a f374097d;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f374099f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final WeakReference<c> f374101h;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final w f374098e = new w();

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final Handler f374100g = new b(b(), this);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<i> f374102a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar;
            super.handleMessage(message);
            if (message == null || (iVar = this.f374102a.get()) == null) {
                return;
            }
            iVar.a(message.what);
        }

        b(Looper looper, i iVar) {
            super(looper);
            this.f374102a = new WeakReference<>(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector, @NonNull c cVar) {
        this.f374094a = qVar;
        this.f374095b = tabExpDependInjector;
        this.f374096c = tabExpDependInjector.getLogImpl();
        this.f374097d = tabExpDependInjector.getThreadImpl();
        this.f374099f = qVar.c();
        this.f374101h = new WeakReference<>(cVar);
    }

    private Looper b() {
        jd4.a aVar = this.f374097d;
        if (aVar == null) {
            return Looper.getMainLooper();
        }
        Looper a16 = aVar.a();
        if (a16 == null) {
            return Looper.getMainLooper();
        }
        return a16;
    }

    void a(int i3) {
        if (!d()) {
            e("callBackOnHandleRollMessage-----return by is not using");
            return;
        }
        c cVar = this.f374101h.get();
        if (cVar == null) {
            return;
        }
        cVar.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        synchronized (this.f374098e) {
            if (this.f374098e.b()) {
                e("initUse-----return by isCalledInitUse");
            } else {
                this.f374098e.f();
                e("initUse-----finish");
            }
        }
    }

    protected boolean d() {
        return this.f374098e.e();
    }

    protected void e(String str) {
        dd4.a aVar = this.f374096c;
        if (aVar == null) {
            return;
        }
        aVar.i("TAB.TabExpDataRoller", x.a(this.f374094a.i(), this.f374094a.f(), this.f374094a.n(), this.f374094a.j(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f374100g.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i3, long j3) {
        if (!this.f374099f) {
            e("sendRollMessageDelayed-----return by is not auto poll");
            return;
        }
        if (!d()) {
            e("sendRollMessageDelayed-----return by is not using");
            return;
        }
        Handler handler = this.f374100g;
        handler.sendMessageDelayed(handler.obtainMessage(i3), j3);
        e("sendRollMessageDelayed-----delayMillis = " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        synchronized (this.f374098e) {
            if (this.f374098e.c()) {
                e("startUse-----return by isCalledStartUse");
            } else {
                this.f374098e.g();
                e("startUse-----finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        synchronized (this.f374098e) {
            if (this.f374098e.d()) {
                e("stopUse-----return by isCalledStopUse");
                return;
            }
            f();
            this.f374098e.h();
            e("stopUse-----finish");
        }
    }
}
