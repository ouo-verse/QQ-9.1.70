package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005J \u0010\f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;", "", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "d", "", "Lcom/tencent/filament/zplan/scene/square/EngineTime;", "nowTime", "", "c", "from", "to", "durationMs", "g", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "touchEvent", "e", "f", "a", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "currentViewportInfo", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/scene/square/e;", "b", "Ljava/lang/ref/WeakReference;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Ljava/lang/ref/WeakReference;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareMapViewport {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ViewportInfo currentViewportInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<e> parent;

    public SquareMapViewport(@NotNull WeakReference<e> parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        this.currentViewportInfo = new ViewportInfo(0.0f, null, 3, null);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ViewportInfo getCurrentViewportInfo() {
        return this.currentViewportInfo;
    }

    public final void e(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
    }

    public final void f(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
    }

    public final void g(@Nullable ViewportInfo from, @NotNull final ViewportInfo to5, final long durationMs) {
        FilamentThreadHandler c16;
        Intrinsics.checkNotNullParameter(to5, "to");
        FLog.INSTANCE.d("SquareMapViewport", "moveTo from=" + from + ", to=" + to5 + ", durationMs=" + durationMs);
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.d("moveViewport", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapViewport$moveTo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    if (durationMs == 0) {
                        SquareMapViewport.this.currentViewportInfo = to5;
                        weakReference = SquareMapViewport.this.parent;
                        e eVar2 = (e) weakReference.get();
                        if (eVar2 != null) {
                            eVar2.e(new ResetObjectLocationEvent());
                        }
                    }
                }
            });
        }
    }

    public final void c(long nowTime) {
    }
}
