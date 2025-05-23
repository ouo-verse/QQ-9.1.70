package com.tencent.mobileqq.triton.internal.render.monitor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u001e\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/monitor/ScreenShootMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "screenShotCallbackValueHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "canvasWidthHolder", "", "canvasHeightHolder", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "worker", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V", "needTakeScreenShot", "", "pendingCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "createScreenShot", "", HippyTKDListViewAdapter.X, "y", "w", h.F, "onGetScreenShot", "result", "Lkotlin/Result;", "Landroid/graphics/Bitmap;", "(Ljava/lang/Object;)V", "onSwap", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScreenShootMonitor implements RenderContext.SwapListener {
    private static final String TAG = "ScreenShootMonitor";
    private final ValueHolder<Integer> canvasHeightHolder;
    private final ValueHolder<Integer> canvasWidthHolder;
    private final Executor mainThreadExecutor;
    private volatile boolean needTakeScreenShot;
    private final CopyOnWriteArrayList<ScreenShotCallback> pendingCallback;
    private final ValueHolder<ScreenShotCallback> screenShotCallbackValueHolder;
    private final Executor worker;

    public ScreenShootMonitor(@NotNull ValueHolder<ScreenShotCallback> screenShotCallbackValueHolder, @NotNull ValueHolder<Integer> canvasWidthHolder, @NotNull ValueHolder<Integer> canvasHeightHolder, @NotNull Executor mainThreadExecutor, @NotNull Executor worker) {
        Intrinsics.checkParameterIsNotNull(screenShotCallbackValueHolder, "screenShotCallbackValueHolder");
        Intrinsics.checkParameterIsNotNull(canvasWidthHolder, "canvasWidthHolder");
        Intrinsics.checkParameterIsNotNull(canvasHeightHolder, "canvasHeightHolder");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(worker, "worker");
        this.screenShotCallbackValueHolder = screenShotCallbackValueHolder;
        this.canvasWidthHolder = canvasWidthHolder;
        this.canvasHeightHolder = canvasHeightHolder;
        this.mainThreadExecutor = mainThreadExecutor;
        this.worker = worker;
        this.pendingCallback = new CopyOnWriteArrayList<>();
        screenShotCallbackValueHolder.observe(new Function1<ScreenShotCallback, Unit>() { // from class: com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScreenShotCallback screenShotCallback) {
                invoke2(screenShotCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ScreenShotCallback screenShotCallback) {
                if (screenShotCallback != null) {
                    ScreenShootMonitor.this.screenShotCallbackValueHolder.setValue(null);
                    ScreenShootMonitor.this.pendingCallback.add(screenShotCallback);
                    ScreenShootMonitor.this.needTakeScreenShot = true;
                }
            }
        });
    }

    private final void createScreenShot(int x16, int y16, final int w3, final int h16) {
        try {
            if (x16 >= 0 && y16 >= 0 && w3 >= 0 && h16 >= 0 && x16 < w3 && y16 < h16) {
                final int[] iArr = new int[w3 * h16];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                GLES20.glReadPixels(x16, y16, w3, h16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
                this.worker.execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor$createScreenShot$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = w3;
                        int i16 = h16;
                        int[] iArr2 = new int[i3 * i16];
                        for (int i17 = 0; i17 < i16; i17++) {
                            int i18 = w3;
                            int i19 = i17 * i18;
                            int i26 = ((h16 - i17) - 1) * i18;
                            for (int i27 = 0; i27 < i18; i27++) {
                                int i28 = iArr[i19 + i27];
                                iArr2[i26 + i27] = (i28 & (-16711936)) | ((i28 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i28 >> 16) & 255);
                            }
                        }
                        Bitmap bitmap = Bitmap.createBitmap(iArr2, w3, h16, Bitmap.Config.ARGB_8888);
                        ScreenShootMonitor screenShootMonitor = ScreenShootMonitor.this;
                        Result.Companion companion = Result.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(bitmap, "bitmap");
                        screenShootMonitor.onGetScreenShot(Result.m476constructorimpl(bitmap));
                    }
                });
                return;
            }
            Logger.e$default(TAG, "createScreenShot params error x=" + x16 + " y=" + y16 + " w=" + w3 + " h=" + h16, null, 4, null);
        } catch (Exception e16) {
            Logger.e(TAG, "createScreenShot exception ", e16);
            Result.Companion companion = Result.INSTANCE;
            onGetScreenShot(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGetScreenShot(final Object result) {
        this.mainThreadExecutor.execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor$onGetScreenShot$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = ScreenShootMonitor.this.pendingCallback.iterator();
                while (it.hasNext()) {
                    ((ScreenShotCallback) it.next()).onGetScreenShot(result);
                }
                ScreenShootMonitor.this.pendingCallback.clear();
            }
        });
    }

    @Override // com.tencent.mobileqq.triton.render.RenderContext.SwapListener
    public void onSwap() {
        if (this.needTakeScreenShot) {
            this.needTakeScreenShot = false;
            createScreenShot(0, 0, this.canvasWidthHolder.getValue().intValue(), this.canvasHeightHolder.getValue().intValue());
        }
    }
}
