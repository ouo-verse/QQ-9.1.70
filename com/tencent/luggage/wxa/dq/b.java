package com.tencent.luggage.wxa.dq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.luggage.wxa.zp.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f124432a;

    /* renamed from: b, reason: collision with root package name */
    public AtomicBoolean f124433b = new AtomicBoolean();

    public b(Handler handler) {
        this.f124432a = handler;
    }

    public static b a(Handler handler) {
        return new b(handler);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public String b() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean c(Runnable runnable) {
        return this.f124432a.postAtFrontOfQueue(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean e() {
        if (!this.f124433b.compareAndSet(false, true)) {
            return false;
        }
        a((Object) null);
        if (a() != null) {
            d.f146814c.w("WrapperHandler", "Do you want to quit this looper thread? You'd better get this Looper to quit.", new Object[0]);
        }
        return true;
    }

    public String toString() {
        return this.f124432a.toString();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, Object obj) {
        return this.f124432a.obtainMessage(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(Runnable runnable) {
        this.f124432a.removeCallbacks(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void c(int i3) {
        this.f124432a.removeMessages(i3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, int i16, int i17, Object obj) {
        return this.f124432a.obtainMessage(i3, i16, i17, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean b(int i3) {
        return this.f124432a.sendEmptyMessage(i3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable) {
        return this.f124432a.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(int i3, Object obj) {
        this.f124432a.removeMessages(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable, long j3) {
        return this.f124432a.postDelayed(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message) {
        return this.f124432a.sendMessage(message);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3, long j3) {
        return this.f124432a.sendEmptyMessageDelayed(i3, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message, long j3) {
        return this.f124432a.sendMessageDelayed(message, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Object obj) {
        this.f124432a.removeCallbacksAndMessages(obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3) {
        return this.f124432a.hasMessages(i3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Looper a() {
        return this.f124432a.getLooper();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Printer printer, String str) {
        this.f124432a.dump(printer, str);
    }
}
