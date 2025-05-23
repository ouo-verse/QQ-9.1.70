package com.tencent.biz.pubaccount.weishi.baseui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AbsWsUI<T> implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    protected Context f80409d;

    /* renamed from: e, reason: collision with root package name */
    protected View f80410e;

    /* renamed from: f, reason: collision with root package name */
    protected int f80411f = -1;

    /* renamed from: h, reason: collision with root package name */
    protected int f80412h = -1;

    /* renamed from: i, reason: collision with root package name */
    protected T f80413i;

    public AbsWsUI(Context context) {
        this.f80409d = context;
    }

    private void n() {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI.1
            @Override // java.lang.Runnable
            public void run() {
                AbsWsUI.this.h();
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context b() {
        return this.f80409d;
    }

    public T c() {
        return this.f80413i;
    }

    public int d() {
        return this.f80411f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resources e() {
        Context context = this.f80409d;
        if (context != null) {
            return context.getResources();
        }
        return null;
    }

    protected abstract void f();

    protected abstract void g();

    protected abstract void h();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        h();
        return true;
    }

    public void i() {
        f();
        k(-1);
    }

    public void j(T t16) {
        this.f80413i = t16;
        g();
        n();
    }

    public void k(int i3) {
        this.f80411f = i3;
    }

    public void l(int i3) {
        View view = this.f80410e;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void m(View view, boolean z16) {
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }
}
