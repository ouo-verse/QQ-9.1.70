package com.tencent.state.square.media.render;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.ISquareRender;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH$J\b\u0010\u0003\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H$J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/media/render/SquareBaseRender;", "Lcom/tencent/state/square/media/render/SquareAbsRender;", "()V", "isDestroying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "renderHandler", "Landroid/os/Handler;", "getRenderHandler", "()Landroid/os/Handler;", "setRenderHandler", "(Landroid/os/Handler;)V", "renderThread", "Landroid/os/HandlerThread;", "doDestroy", "", "", "onBeforeDecode", "videoWidth", "", "videoHeight", "callback", "Lkotlin/Function1;", "onFrameRender", "info", "Landroid/media/MediaCodec$BufferInfo;", "image", "Landroid/media/Image;", "onSurfaceDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "prepareGlRender", "prepareGlTexture", "prepareThread", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class SquareBaseRender extends SquareAbsRender {
    private static final String TAG = "Square_SquareBaseRender";
    private final AtomicBoolean isDestroying = new AtomicBoolean(false);
    private Handler renderHandler;
    private HandlerThread renderThread;

    private final void prepareThread() {
        if (this.renderThread == null) {
            synchronized (this) {
                if (this.renderThread == null) {
                    HandlerThread handlerThread = new HandlerThread("Render-Thread");
                    try {
                        handlerThread.start();
                        this.renderThread = handlerThread;
                        this.renderHandler = new Handler(handlerThread.getLooper());
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e(TAG, "start Handler Thread err.", th5);
                        this.renderThread = null;
                        this.renderHandler = null;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doDestroy();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Handler getRenderHandler() {
        return this.renderHandler;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public boolean isDestroying() {
        return this.isDestroying.get();
    }

    @Override // com.tencent.state.square.media.render.SquareAbsRender, com.tencent.state.square.media.ISquareRender
    public void onBeforeDecode(final int videoWidth, final int videoHeight, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.onBeforeDecode(videoWidth, videoHeight, callback);
        if (isDestroying()) {
            ISquareRender.Listener listener = getListener();
            if (listener != null) {
                ISquareRender.Listener.DefaultImpls.onRenderError$default(listener, -5, null, 2, null);
            }
            SquareBaseKt.getSquareLog().w(TAG, '(' + getUniqueId() + ")(" + hashCode() + ") onBeforeDecode but render is destroying");
            callback.invoke(Boolean.FALSE);
            return;
        }
        prepareThread();
        Handler handler = this.renderHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.state.square.media.render.SquareBaseRender$onBeforeDecode$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (SquareBaseRender.this.prepareGlRender(videoWidth, videoHeight) && SquareBaseRender.this.prepareGlTexture(videoWidth, videoHeight)) {
                        callback.invoke(Boolean.TRUE);
                        return;
                    }
                    ISquareRender.Listener listener2 = SquareBaseRender.this.getListener();
                    if (listener2 != null) {
                        ISquareRender.Listener.DefaultImpls.onRenderError$default(listener2, -6, null, 2, null);
                    }
                    SquareBaseKt.getSquareLog().w("Square_SquareBaseRender", '(' + SquareBaseRender.this.getUniqueId() + ")(" + SquareBaseRender.this.hashCode() + ") onBeforeDecode prepared gl render failed");
                    callback.invoke(Boolean.FALSE);
                }
            });
        }
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, Image image) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // com.tencent.state.square.media.render.SquareAbsRender, com.tencent.state.square.media.ISquareRender
    public void onSurfaceDestroyed(final SurfaceTexture surface) {
        Handler handler;
        super.onSurfaceDestroyed(surface);
        SquareBaseKt.getSquareLog().i(TAG, '(' + getUniqueId() + ")(" + hashCode() + ") onSurfaceDestroyed: isDestroying=" + isDestroying() + ", renderHandler=" + this.renderHandler + ", " + surface + ", current: " + getDisplaySurface());
        if (this.renderHandler == null || !this.isDestroying.compareAndSet(false, true) || (handler = this.renderHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.state.square.media.render.SquareBaseRender$onSurfaceDestroyed$1
            @Override // java.lang.Runnable
            public final void run() {
                HandlerThread handlerThread;
                AtomicBoolean atomicBoolean;
                SquareBaseRender.this.doDestroy();
                SquareBaseKt.getSquareLog().i("Square_SquareBaseRender", '(' + SquareBaseRender.this.getUniqueId() + ")(" + SquareBaseRender.this.hashCode() + ") glRender.destroy(): " + surface);
                Handler renderHandler = SquareBaseRender.this.getRenderHandler();
                if (renderHandler != null) {
                    renderHandler.removeCallbacksAndMessages(null);
                }
                handlerThread = SquareBaseRender.this.renderThread;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
                SquareBaseRender.this.renderThread = null;
                SquareBaseRender.this.setRenderHandler(null);
                atomicBoolean = SquareBaseRender.this.isDestroying;
                atomicBoolean.set(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean prepareGlRender(int videoWidth, int videoHeight);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean prepareGlTexture(int videoWidth, int videoHeight) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRenderHandler(Handler handler) {
        this.renderHandler = handler;
    }
}
