package com.tencent.kuikly.core.render.android.turbo;

import android.view.ViewGroup;
import com.tencent.kuikly.core.render.android.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0000H\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/a;", "Lkotlin/Function0;", "", "setCurrentUICallback", "closeTurboDisplayCallback", "c", "a", "b", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {
    public static final void a(@NotNull com.tencent.kuikly.core.render.android.a fireCloseTurboDisplayCallback) {
        ViewGroup view;
        Function0 function0;
        Intrinsics.checkNotNullParameter(fireCloseTurboDisplayCallback, "$this$fireCloseTurboDisplayCallback");
        d O0 = fireCloseTurboDisplayCallback.O0();
        if (O0 != null && (view = O0.getView()) != null && (function0 = (Function0) fireCloseTurboDisplayCallback.P0(view, "kCloseTurboDisplayNotificationName")) != null) {
        }
    }

    public static final void b(@NotNull com.tencent.kuikly.core.render.android.a fireSetCurrentUIAsFirstScreenForNextLaunchCallback) {
        ViewGroup view;
        Function0 function0;
        Intrinsics.checkNotNullParameter(fireSetCurrentUIAsFirstScreenForNextLaunchCallback, "$this$fireSetCurrentUIAsFirstScreenForNextLaunchCallback");
        d O0 = fireSetCurrentUIAsFirstScreenForNextLaunchCallback.O0();
        if (O0 != null && (view = O0.getView()) != null && (function0 = (Function0) fireSetCurrentUIAsFirstScreenForNextLaunchCallback.P0(view, "kSetCurrentUIAsFirstScreenForNextLaunchNotificationName")) != null) {
        }
    }

    public static final void c(@NotNull com.tencent.kuikly.core.render.android.a setTurboDisplayCallbacks, @NotNull Function0<Unit> setCurrentUICallback, @NotNull Function0<Unit> closeTurboDisplayCallback) {
        ViewGroup view;
        Intrinsics.checkNotNullParameter(setTurboDisplayCallbacks, "$this$setTurboDisplayCallbacks");
        Intrinsics.checkNotNullParameter(setCurrentUICallback, "setCurrentUICallback");
        Intrinsics.checkNotNullParameter(closeTurboDisplayCallback, "closeTurboDisplayCallback");
        d O0 = setTurboDisplayCallbacks.O0();
        if (O0 != null && (view = O0.getView()) != null) {
            setTurboDisplayCallbacks.N0(view, "kCloseTurboDisplayNotificationName", closeTurboDisplayCallback);
            setTurboDisplayCallbacks.N0(view, "kSetCurrentUIAsFirstScreenForNextLaunchNotificationName", setCurrentUICallback);
        }
    }
}
