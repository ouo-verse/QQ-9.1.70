package com.tencent.filament.zplan.view.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GYFZPlanController$dealloc$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GYFZPlanController.d $viewerDestroyCallback;
    final /* synthetic */ GYFZPlanController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$dealloc$1(GYFZPlanController gYFZPlanController, GYFZPlanController.d dVar) {
        super(0);
        this.this$0 = gYFZPlanController;
        this.$viewerDestroyCallback = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z16;
        GYFZPlanNativeAPI nativeAPI = this.this$0.getNativeAPI();
        if (nativeAPI != null) {
            nativeAPI.flushAndWait();
        }
        GYFZPlanNativeAPI nativeAPI2 = this.this$0.getNativeAPI();
        if (nativeAPI2 != null) {
            nativeAPI2.delloc();
        }
        final Runnable runnable = new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$dealloc$1$delayedTask$1
            @Override // java.lang.Runnable
            public final void run() {
                HandlerThread P;
                AtomicBoolean atomicBoolean;
                P = GYFZPlanController$dealloc$1.this.this$0.P();
                P.quitSafely();
                GYFZPlanController$dealloc$1.this.this$0.p0(null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$dealloc$1$delayedTask$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (GYFZPlanController$dealloc$1.this.this$0.getSurface() != null) {
                            Surface surface = GYFZPlanController$dealloc$1.this.this$0.getSurface();
                            Intrinsics.checkNotNull(surface);
                            surface.release();
                        }
                        GYFZPlanController.d dVar = GYFZPlanController$dealloc$1.this.$viewerDestroyCallback;
                        if (dVar != null) {
                            dVar.a();
                        }
                    }
                });
                atomicBoolean = GYFZPlanController$dealloc$1.this.this$0.attached;
                atomicBoolean.set(false);
            }
        };
        z16 = this.this$0.isEnableDelayed;
        if (z16 && !this.this$0.getIsOffScreen()) {
            this.this$0.c0("deallocDelayed", 200L, new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$dealloc$1.1
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
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }
}
