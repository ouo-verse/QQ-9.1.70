package com.tencent.mm.sdk.event.pending;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.pn.a;
import com.tencent.luggage.wxa.tn.b0;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000b*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "Lcom/tencent/luggage/wxa/pn/a;", "T", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/luggage/wxa/tn/b0;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/luggage/wxa/tn/b0;", "pendingHandler", "b", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class PendingEventNotifier<T extends a> implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy pendingHandler;

    public final b0 a() {
        return (b0) this.pendingHandler.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        a().a((Object) null);
        a().b(2);
    }
}
