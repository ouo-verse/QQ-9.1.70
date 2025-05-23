package com.tencent.filament.zplan.view.controller;

import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/HandlerThread;", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class GYFZPlanController$viewerHandlerThread$2 extends Lambda implements Function0<HandlerThread> {
    public static final GYFZPlanController$viewerHandlerThread$2 INSTANCE = new GYFZPlanController$viewerHandlerThread$2();

    GYFZPlanController$viewerHandlerThread$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final HandlerThread invoke() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("filament_controller_" + UUID.randomUUID());
        baseHandlerThread.start();
        return baseHandlerThread;
    }
}
