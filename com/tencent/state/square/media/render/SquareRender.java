package com.tencent.state.square.media.render;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.ISquareRender;
import com.tencent.state.square.media.VideoInfo;
import com.tencent.state.square.media.utils.RenderConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/media/render/SquareRender;", "Lcom/tencent/state/square/media/render/SquareBaseRender;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "()V", "glRender", "Lcom/tencent/state/square/media/render/GlRender;", "glTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/Surface;", "doDestroy", "", "getOutputSurface", "onFrameAvailable", "surfaceTexture", "onOutFormatChanged", "info", "Lcom/tencent/state/square/media/VideoInfo;", "onSurfaceSizeChanged", "width", "", "height", "prepareGlRender", "", "videoWidth", "videoHeight", "prepareGlTexture", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareRender extends SquareBaseRender implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "Square_SquareRender";
    private GlRender glRender;
    private SurfaceTexture glTexture;
    private Surface surface;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.media.render.SquareBaseRender
    public void doDestroy() {
        SurfaceTexture surfaceTexture = this.glTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.glTexture = null;
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
        GlRender glRender = this.glRender;
        if (glRender != null) {
            glRender.destroy();
        }
        this.glRender = null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public Surface getOutputSurface() {
        if (this.glTexture != null) {
            if (this.surface == null) {
                this.surface = new Surface(this.glTexture);
            }
            return this.surface;
        }
        throw new RuntimeException("getOutputSurface returns null");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Handler renderHandler;
        if (isDestroying() || (renderHandler = getRenderHandler()) == null) {
            return;
        }
        renderHandler.post(new Runnable() { // from class: com.tencent.state.square.media.render.SquareRender$onFrameAvailable$1
            /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            
                r0 = r4.this$0.glTexture;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                SurfaceTexture surfaceTexture2;
                GlRender glRender;
                GlRender glRender2;
                try {
                    if (SquareBaseKt.getSquareCommon().isBackgroundStop() || surfaceTexture2 == null) {
                        return;
                    }
                    surfaceTexture2.updateTexImage();
                    glRender = SquareRender.this.glRender;
                    if (glRender != null) {
                        glRender.renderFrame(SquareRender.this.getIsFirstFrame());
                    }
                    glRender2 = SquareRender.this.glRender;
                    if (glRender2 != null) {
                        glRender2.swapBuffers();
                    }
                    if (SquareRender.this.getIsFirstFrame()) {
                        SquareRender.this.setFirstFrame(false);
                        ISquareRender.Listener listener = SquareRender.this.getListener();
                        if (listener != null) {
                            listener.onRenderFirstFrame();
                        }
                    }
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e("Square_SquareRender", "render exception=" + th5, th5);
                    ISquareRender.Listener listener2 = SquareRender.this.getListener();
                    if (listener2 != null) {
                        String message = th5.getMessage();
                        if (message == null) {
                            message = "unknow exception";
                        }
                        listener2.onRenderError(-1, message);
                    }
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.render.SquareAbsRender, com.tencent.state.square.media.ISquareRender
    public void onOutFormatChanged(VideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        float width = info.getWidth() / getMp4Width();
        float height = info.getHeight() / getMp4Height();
        if (height >= width) {
            float surfaceHeight = getSurfaceHeight() * height;
            float surfaceHeight2 = getSurfaceHeight() - surfaceHeight;
            GlRender glRender = this.glRender;
            if (glRender != null) {
                glRender.updateViewPort(getSurfaceWidth(), (int) surfaceHeight, 0, (int) surfaceHeight2);
                return;
            }
            return;
        }
        float surfaceWidth = getSurfaceWidth() * width;
        GlRender glRender2 = this.glRender;
        if (glRender2 != null) {
            glRender2.updateViewPort((int) surfaceWidth, getSurfaceHeight(), 0, 0);
        }
    }

    @Override // com.tencent.state.square.media.render.SquareAbsRender, com.tencent.state.square.media.ISquareRender
    public void onSurfaceSizeChanged(int width, int height) {
        super.onSurfaceSizeChanged(width, height);
        GlRender glRender = this.glRender;
        if (glRender != null) {
            GlRender.updateViewPort$default(glRender, width, height, 0, 0, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.media.render.SquareBaseRender
    public boolean prepareGlRender(int videoWidth, int videoHeight) {
        ISquareRender.Listener listener;
        if (this.glRender == null) {
            if (getDisplaySurface() == null && (listener = getListener()) != null) {
                ISquareRender.Listener.DefaultImpls.onRenderError$default(listener, -2, null, 2, null);
            }
            SurfaceTexture displaySurface = getDisplaySurface();
            if (displaySurface != null) {
                try {
                    GlRender glRender = new GlRender(displaySurface);
                    GlRender.updateViewPort$default(glRender, getSurfaceWidth(), getSurfaceHeight(), 0, 0, 12, null);
                    glRender.createTexture();
                    Unit unit = Unit.INSTANCE;
                    this.glRender = glRender;
                } catch (Throwable th5) {
                    String str = "compileShader failed: " + hashCode();
                    if (isSurfaceReady()) {
                        ISquareRender.Listener listener2 = getListener();
                        if (listener2 != null) {
                            String message = th5.getMessage();
                            if (message == null) {
                                message = "unknow exception";
                            }
                            listener2.onRenderError(-3, message);
                        }
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, str, null, 4, null);
                    } else {
                        SquareBaseKt.getSquareLog().w(TAG, str);
                    }
                }
            }
        }
        GlRender glRender2 = this.glRender;
        if (glRender2 != null) {
            glRender2.setRenderConfig(RenderConfig.INSTANCE.m252default(videoWidth, videoHeight));
        }
        return this.glRender != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.media.render.SquareBaseRender
    public boolean prepareGlTexture(int videoWidth, int videoHeight) {
        if (this.glTexture == null) {
            GlRender glRender = this.glRender;
            if (glRender == null) {
                ISquareRender.Listener listener = getListener();
                if (listener != null) {
                    ISquareRender.Listener.DefaultImpls.onRenderError$default(listener, -4, null, 2, null);
                }
                return false;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(glRender.getExternalTexture());
            surfaceTexture.setOnFrameAvailableListener(this);
            Unit unit = Unit.INSTANCE;
            this.glTexture = surfaceTexture;
        }
        SurfaceTexture surfaceTexture2 = this.glTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.setDefaultBufferSize(videoWidth, videoHeight);
        }
        return this.glTexture != null;
    }
}
