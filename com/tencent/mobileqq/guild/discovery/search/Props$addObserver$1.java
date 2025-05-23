package com.tencent.mobileqq.guild.discovery.search;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh1.d;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discovery/search/Props$addObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onAny", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class Props$addObserver$1 implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f216793d;

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public final void onAny(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        WeakReference weakReference;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        weakReference = this.f216793d.weakRef;
        Fragment fragment = (Fragment) weakReference.get();
        if (fragment != null && event == Lifecycle.Event.ON_DESTROY) {
            fragment.getLifecycle().removeObserver(this);
        }
    }
}
