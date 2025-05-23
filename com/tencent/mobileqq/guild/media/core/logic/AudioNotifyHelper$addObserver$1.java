package com.tencent.mobileqq.guild.media.core.logic;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/AudioNotifyHelper$addObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AudioNotifyHelper$addObserver$1 implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AudioNotifyHelper f228154d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.notify.q f228155e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f228156f;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onCreate() {
        this.f228154d.b(this.f228155e);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f228154d.B(this.f228155e);
        this.f228156f.getLifecycle().removeObserver(this);
    }
}
