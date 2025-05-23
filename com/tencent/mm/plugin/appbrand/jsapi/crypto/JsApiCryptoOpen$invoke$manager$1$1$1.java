package com.tencent.mm.plugin.appbrand.jsapi.crypto;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.ze.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0004"}, d2 = {"com/tencent/mm/plugin/appbrand/jsapi/crypto/JsApiCryptoOpen$invoke$manager$1$1$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroyed", "luggage-commons-jsapi-crypto-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class JsApiCryptoOpen$invoke$manager$1$1$1 implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f152096a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyed() {
        a.C6981a c6981a = a.f146560a;
        String appId = this.f152096a;
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        c6981a.a(appId);
    }
}
