package com.tencent.qimei.av;

/* compiled from: P */
/* loaded from: classes22.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f343186a;

    public o(p pVar) {
        this.f343186a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            p.a(this.f343186a);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
        }
    }
}
