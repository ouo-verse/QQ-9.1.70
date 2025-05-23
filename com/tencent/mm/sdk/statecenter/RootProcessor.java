package com.tencent.mm.sdk.statecenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vn.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \r*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0002\b\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f0\u0007R\b\u0012\u0004\u0012\u00028\u00000\u00000\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mm/sdk/statecenter/RootProcessor;", "", "State", "Lcom/tencent/luggage/wxa/vn/a;", "Landroidx/lifecycle/LifecycleObserver;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/sdk/statecenter/RootProcessor$LifecycleBoundProcessor;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "processorMap", "<init>", "()V", "b", "LifecycleBoundProcessor", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class RootProcessor<State> implements a, LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap processorMap = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0096\u0004\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0017R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mm/sdk/statecenter/RootProcessor$LifecycleBoundProcessor;", "Landroidx/lifecycle/LifecycleObserver;", "", "a", "onLifecycleDestroy", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/luggage/wxa/vn/a;", "b", "Lcom/tencent/luggage/wxa/vn/a;", "getProcessor", "()Lcom/tencent/luggage/wxa/vn/a;", "processor", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public class LifecycleBoundProcessor implements LifecycleObserver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final LifecycleOwner owner;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final a processor;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RootProcessor f152580c;

        public final void a() {
            this.owner.getLifecycle().removeObserver(this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onLifecycleDestroy() {
            w.a("MicroMsg.Mvvm.RootProcessor", "onLifecycleDestroy owner:" + this.owner.hashCode() + " observer:" + this.processor.hashCode());
            LifecycleBoundProcessor lifecycleBoundProcessor = (LifecycleBoundProcessor) this.f152580c.processorMap.remove(Integer.valueOf(this.processor.hashCode()));
            if (lifecycleBoundProcessor != null) {
                lifecycleBoundProcessor.a();
            }
        }
    }
}
