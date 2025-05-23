package com.tencent.mobileqq.triton.internal.render.monitor;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.render.RenderContext;
import java.nio.IntBuffer;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/monitor/BlackScreenMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "lastBlackTimeHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "canvasWidthHolder", "", "canvasHeightHolder", "mWorker", "Ljava/util/concurrent/Executor;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;)V", "lastCheckBlackTime", "checkBlackScreen", "", "onSwap", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class BlackScreenMonitor implements RenderContext.SwapListener {
    private static final long CHECK_BLACK_INTERVAL = 2000;
    private static final String TAG = "BlackScreenMonitor";
    private final ValueHolder<Integer> canvasHeightHolder;
    private final ValueHolder<Integer> canvasWidthHolder;
    private final ValueHolder<Long> lastBlackTimeHolder;
    private long lastCheckBlackTime;
    private final Executor mWorker;

    public BlackScreenMonitor(@NotNull ValueHolder<Long> lastBlackTimeHolder, @NotNull ValueHolder<Integer> canvasWidthHolder, @NotNull ValueHolder<Integer> canvasHeightHolder, @NotNull Executor mWorker) {
        Intrinsics.checkParameterIsNotNull(lastBlackTimeHolder, "lastBlackTimeHolder");
        Intrinsics.checkParameterIsNotNull(canvasWidthHolder, "canvasWidthHolder");
        Intrinsics.checkParameterIsNotNull(canvasHeightHolder, "canvasHeightHolder");
        Intrinsics.checkParameterIsNotNull(mWorker, "mWorker");
        this.lastBlackTimeHolder = lastBlackTimeHolder;
        this.canvasWidthHolder = canvasWidthHolder;
        this.canvasHeightHolder = canvasHeightHolder;
        this.mWorker = mWorker;
    }

    private final void checkBlackScreen() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastCheckBlackTime >= 2000) {
            this.lastCheckBlackTime = currentTimeMillis;
            int intValue = (this.canvasWidthHolder.getValue().intValue() / 2) - 64;
            int intValue2 = (this.canvasHeightHolder.getValue().intValue() / 2) - 64;
            try {
                if (intValue >= 0 && intValue2 >= 0) {
                    int glGetError = GLES20.glGetError();
                    if (glGetError != 0 && glGetError != 12288) {
                        Logger.e$default(TAG, "checkBlackScreen glGetError=" + glGetError, null, 4, null);
                        return;
                    }
                    final int[] iArr = new int[16384];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    GLES20.glReadPixels(intValue, intValue2, 128, 128, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
                    this.mWorker.execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.render.monitor.BlackScreenMonitor$checkBlackScreen$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ValueHolder valueHolder;
                            ValueHolder valueHolder2;
                            int[] iArr2 = iArr;
                            boolean z16 = false;
                            int i3 = iArr2[0];
                            int length = iArr2.length;
                            int i16 = 0;
                            while (true) {
                                boolean z17 = true;
                                if (i16 < length) {
                                    if (iArr2[i16] != i3) {
                                        z17 = false;
                                    }
                                    if (!z17) {
                                        break;
                                    } else {
                                        i16++;
                                    }
                                } else {
                                    z16 = true;
                                    break;
                                }
                            }
                            if (z16) {
                                valueHolder2 = BlackScreenMonitor.this.lastBlackTimeHolder;
                                valueHolder2.setValue(Long.valueOf(currentTimeMillis));
                            } else {
                                valueHolder = BlackScreenMonitor.this.lastBlackTimeHolder;
                                valueHolder.setValue(0L);
                            }
                        }
                    });
                    return;
                }
                Logger.e$default(TAG, "checkBlackScreen params error x=" + intValue + " y=" + intValue2 + " w=128 h=128", null, 4, null);
            } catch (Exception e16) {
                Logger.e(TAG, "checkBlackScreen exception ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.render.RenderContext.SwapListener
    public void onSwap() {
        checkBlackScreen();
    }
}
