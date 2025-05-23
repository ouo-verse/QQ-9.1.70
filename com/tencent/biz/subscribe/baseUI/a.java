package com.tencent.biz.subscribe.baseUI;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<T> implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    protected Context f95710d;

    /* renamed from: e, reason: collision with root package name */
    protected View f95711e;

    /* renamed from: f, reason: collision with root package name */
    protected int f95712f = -1;

    /* renamed from: h, reason: collision with root package name */
    protected int f95713h = -1;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f95714i = new Handler(Looper.getMainLooper(), this);

    public a(Context context, boolean z16) {
        this.f95710d = context;
        if (z16) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context a() {
        return this.f95710d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resources b() {
        Context context = this.f95710d;
        if (context != null) {
            return context.getResources();
        }
        return null;
    }

    protected abstract void c();

    protected abstract void d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e();

    protected abstract void f();

    public void g() {
        d();
        i(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f95714i.post(runnable);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        f();
        return true;
    }

    public void i(int i3) {
        this.f95712f = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        this.f95714i.sendEmptyMessage(1);
    }
}
