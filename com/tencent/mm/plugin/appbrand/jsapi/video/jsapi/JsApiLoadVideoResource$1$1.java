package com.tencent.mm.plugin.appbrand.jsapi.video.jsapi;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.mg.f;
import com.tencent.luggage.wxa.mg.j;

/* compiled from: P */
/* loaded from: classes9.dex */
class JsApiLoadVideoResource$1$1 implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f152187a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f152188b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyed() {
        this.f152187a.a(this.f152188b);
    }
}
