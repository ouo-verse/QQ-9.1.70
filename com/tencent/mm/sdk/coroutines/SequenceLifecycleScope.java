package com.tencent.mm.sdk.coroutines;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.tn.w;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\nJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mm/sdk/coroutines/SequenceLifecycleScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "a", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "default", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/channels/Channel;", "sequenceChannel", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "c", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SequenceLifecycleScope implements CoroutineScope, LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy default;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Channel sequenceChannel;

    public final ExecutorCoroutineDispatcher a() {
        return (ExecutorCoroutineDispatcher) this.default.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return a();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            w.d("MicroMsg.Mvvm.SequenceLifecycleScope", hashCode() + " onDestroy");
            SendChannel.DefaultImpls.close$default(this.sequenceChannel, null, 1, null);
            a().close();
        }
    }
}
