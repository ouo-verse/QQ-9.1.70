package com.tencent.guild.aio.util.flowbus;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/util/flowbus/BusExtentsKt$bindLifecycle$1", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class BusExtentsKt$bindLifecycle$1 implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FlowEventReceiver f112388d;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f112388d.d();
    }
}
