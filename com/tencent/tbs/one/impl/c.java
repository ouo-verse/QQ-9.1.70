package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.TBSOneCallback;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class c<T> extends TBSOneCallback<T> {

    /* renamed from: a, reason: collision with root package name */
    T f374628a;

    /* renamed from: b, reason: collision with root package name */
    int f374629b = 109;

    /* renamed from: c, reason: collision with root package name */
    String f374630c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f374631d;

    private synchronized void a() {
        this.f374631d = true;
        notify();
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onCompleted(T t16) {
        this.f374629b = 0;
        this.f374628a = t16;
        a();
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onError(int i3, String str) {
        this.f374629b = i3;
        this.f374630c = str;
        a();
    }

    public final synchronized void a(long j3) {
        if (!this.f374631d) {
            try {
                wait(j3);
            } catch (InterruptedException unused) {
                this.f374629b = 103;
                this.f374630c = "Failed to wait for loading result";
            }
        }
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onProgressChanged(int i3, int i16) {
    }
}
