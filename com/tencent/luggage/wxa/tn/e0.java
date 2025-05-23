package com.tencent.luggage.wxa.tn;

import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e0 extends b0 {

    /* renamed from: j, reason: collision with root package name */
    public static int f141573j;

    /* renamed from: e, reason: collision with root package name */
    public final int f141574e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f141575f;

    /* renamed from: g, reason: collision with root package name */
    public long f141576g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f141577h;

    /* renamed from: i, reason: collision with root package name */
    public a f141578i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a();
    }

    public e0(a aVar, boolean z16) {
        this.f141576g = 0L;
        this.f141577h = false;
        this.f141578i = aVar;
        this.f141574e = d();
        this.f141575f = z16;
        if (Thread.currentThread().getName().equals("initThread") || "initThread".equals(com.tencent.luggage.wxa.kq.a.e())) {
            w.b("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", w0.b());
        }
    }

    public static int d() {
        if (f141573j >= 8192) {
            f141573j = 0;
        }
        int i3 = f141573j + 1;
        f141573j = i3;
        return i3;
    }

    public void a(long j3) {
        a(j3, j3);
    }

    public void f() {
        c(this.f141574e);
        this.f141577h = true;
    }

    public void finalize() {
        f();
        super.finalize();
    }

    public boolean g() {
        if (!this.f141577h && a(this.f141574e)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.tn.b0
    public String toString() {
        if (this.f141578i == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.f141578i.getClass().getName() + "}";
    }

    public void a(long j3, long j16) {
        this.f141576g = j16;
        f();
        this.f141577h = false;
        a(this.f141574e, j3);
    }

    @Override // com.tencent.luggage.wxa.tn.b0
    public void d(Message message) {
        a aVar;
        if (message.what == this.f141574e && (aVar = this.f141578i) != null && aVar.a() && this.f141575f && !this.f141577h) {
            a(this.f141574e, this.f141576g);
        }
    }

    public e0(Looper looper, a aVar, boolean z16) {
        super(looper);
        this.f141576g = 0L;
        this.f141577h = false;
        this.f141578i = aVar;
        this.f141574e = d();
        this.f141575f = z16;
        if (Thread.currentThread().getName().equals("initThread") || "initThread".equals(com.tencent.luggage.wxa.kq.a.e())) {
            w.b("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", w0.b());
        }
    }

    public e0(String str, a aVar, boolean z16) {
        super(str);
        this.f141576g = 0L;
        this.f141577h = false;
        this.f141578i = aVar;
        this.f141574e = d();
        this.f141575f = z16;
    }
}
