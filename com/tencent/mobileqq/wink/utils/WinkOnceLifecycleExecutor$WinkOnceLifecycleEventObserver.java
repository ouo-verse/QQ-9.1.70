package com.tencent.mobileqq.wink.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/wink/utils/WinkOnceLifecycleExecutor$WinkOnceLifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lcom/tencent/mobileqq/wink/utils/WinkOnceLifecycleScope;", "d", "Lcom/tencent/mobileqq/wink/utils/WinkOnceLifecycleScope;", "getScope", "()Lcom/tencent/mobileqq/wink/utils/WinkOnceLifecycleScope;", "scope", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/wink/utils/IWinkAction;", "e", "Lkotlin/jvm/functions/Function0;", "getAction", "()Lkotlin/jvm/functions/Function0;", "action", "", "f", "I", "alreadyExecuteCount", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
final class WinkOnceLifecycleExecutor$WinkOnceLifecycleEventObserver implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkOnceLifecycleScope scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int alreadyExecuteCount;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.getLifecycle().removeObserver(this);
        }
        if (!this.scope.equalToLifecycleEvent(event)) {
            return;
        }
        this.alreadyExecuteCount++;
        this.action.invoke();
    }
}
