package com.tencent.timi.game.room.impl.operation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import km4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/room/impl/operation/RoomOperationService$delegateRoomOperation$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RoomOperationService$delegateRoomOperation$1 implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f379209d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f379210e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f379211f;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        List list;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            b bVar = this.f379209d;
            list = bVar.operationBundleList;
            bVar.R3(list, this.f379210e);
            this.f379211f.getLifecycle().removeObserver(this);
        }
    }
}
