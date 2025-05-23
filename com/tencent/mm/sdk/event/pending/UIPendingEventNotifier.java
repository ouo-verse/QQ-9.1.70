package com.tencent.mm.sdk.event.pending;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.pn.a;
import com.tencent.luggage.wxa.tn.b0;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u0018*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mm/sdk/event/pending/UIPendingEventNotifier;", "Lcom/tencent/luggage/wxa/pn/a;", "T", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "a", "Ljava/lang/Object;", "pendingLock", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "pendingEvent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingFlag", "Lcom/tencent/luggage/wxa/tn/b0;", "d", "Lcom/tencent/luggage/wxa/tn/b0;", "pendingHandler", "e", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class UIPendingEventNotifier<T extends a> implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object pendingLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final HashMap pendingEvent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean pendingFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final b0 pendingHandler;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.pendingHandler.a((Object) null);
        this.pendingFlag.set(false);
        synchronized (this.pendingLock) {
            this.pendingEvent.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
