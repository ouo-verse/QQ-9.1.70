package com.tencent.mm.sdk.event;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.on.a;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.tn.t;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.to.b;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.sdk.event.IListener;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class IListener<T extends c> implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final int f152543a;

    /* renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f152544b;

    /* renamed from: c, reason: collision with root package name */
    public int f152545c;

    /* renamed from: d, reason: collision with root package name */
    public b f152546d;

    public IListener(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (this.f152544b.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            this.f152544b.getLifecycle().addObserver(this);
        } else {
            onLifecycleDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (this.f152544b.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            this.f152544b.getLifecycle().removeObserver(this);
        }
    }

    public synchronized void alive() {
        if (this.f152546d == null) {
            t.a(this);
            this.f152546d = a.f137044d.a(this);
        }
        if (this.f152544b.getLifecycle() instanceof com.tencent.luggage.wxa.un.a) {
            this.f152544b.getLifecycle().addObserver(this);
        } else {
            h.f146825d.a(new Runnable() { // from class: t51.a
                @Override // java.lang.Runnable
                public final void run() {
                    IListener.this.d();
                }
            });
        }
    }

    public final void c() {
        b bVar = this.f152546d;
        if (bVar != null) {
            t.b((IListener) bVar.a());
            this.f152546d.g();
            this.f152546d = null;
        }
    }

    public abstract boolean callback(c cVar);

    public synchronized void dead() {
        c();
        if (this.f152544b.getLifecycle() instanceof com.tencent.luggage.wxa.un.a) {
            if (this.f152544b.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                this.f152544b.getLifecycle().removeObserver(this);
            }
        } else {
            h.f146825d.a(new Runnable() { // from class: t51.b
                @Override // java.lang.Runnable
                public final void run() {
                    IListener.this.e();
                }
            });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifecycleDestroy() {
        c();
    }

    public IListener(LifecycleOwner lifecycleOwner, int i3) {
        this.f152545c = 0;
        this.f152544b = lifecycleOwner;
        this.f152543a = i3;
    }

    public int a() {
        if (this.f152545c == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            this.f152545c = ((Class) type).getName().hashCode();
            w.g("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.f152545c;
    }

    public int b() {
        return this.f152543a;
    }
}
