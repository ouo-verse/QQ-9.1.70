package com.google.android.filament.android;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UiHelper {
    private static final boolean LOGGING = false;
    private static final String LOG_TAG = "UiHelper";
    private int mDesiredHeight;
    private int mDesiredWidth;
    private boolean mHasSwapChain;
    private Object mNativeWindow;
    private boolean mOpaque;
    private boolean mOverlay;
    private RendererCallback mRenderCallback;
    private RenderSurface mRenderSurface;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ContextErrorPolicy {
        CHECK,
        DONT_CHECK
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RenderSurface {
        void detach();

        void resize(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RendererCallback {
        void onDetachedFromSurface();

        void onNativeWindowChanged(Surface surface);

        void onResized(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class TextureViewHandler implements RenderSurface {
        private Surface mSurface;
        private TextureView mTextureView;

        TextureViewHandler(TextureView textureView) {
            this.mTextureView = textureView;
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void detach() {
            setSurface(null);
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void resize(int i3, int i16) {
            this.mTextureView.getSurfaceTexture().setDefaultBufferSize(i3, i16);
            UiHelper.this.mRenderCallback.onResized(i3, i16);
        }

        void setSurface(Surface surface) {
            Surface surface2;
            if (surface == null && (surface2 = this.mSurface) != null) {
                surface2.release();
            }
            this.mSurface = surface;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements SurfaceHolder.Callback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SurfaceHolder f33056d;

        a(SurfaceHolder surfaceHolder) {
            this.f33056d = surfaceHolder;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            UiHelper.this.mRenderCallback.onResized(i16, i17);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            UiHelper.this.createSwapChain(this.f33056d.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            UiHelper.this.destroySwapChain();
        }
    }

    public UiHelper() {
        this(ContextErrorPolicy.CHECK);
    }

    private boolean attach(@NonNull Object obj) {
        Object obj2 = this.mNativeWindow;
        if (obj2 != null) {
            if (obj2 == obj) {
                return false;
            }
            destroySwapChain();
        }
        this.mNativeWindow = obj;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSwapChain(@NonNull Surface surface) {
        this.mRenderCallback.onNativeWindowChanged(surface);
        this.mHasSwapChain = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroySwapChain() {
        RenderSurface renderSurface = this.mRenderSurface;
        if (renderSurface != null) {
            renderSurface.detach();
        }
        this.mRenderCallback.onDetachedFromSurface();
        this.mHasSwapChain = false;
    }

    public void attachTo(@NonNull SurfaceView surfaceView) {
        int i3;
        if (attach(surfaceView)) {
            boolean z16 = !isOpaque();
            if (isMediaOverlay()) {
                surfaceView.setZOrderMediaOverlay(z16);
            } else {
                surfaceView.setZOrderOnTop(z16);
            }
            int i16 = isOpaque() ? -1 : -3;
            surfaceView.getHolder().setFormat(i16);
            this.mRenderSurface = new SurfaceViewHandler(surfaceView);
            SurfaceHolder.Callback callback = new SurfaceHolder.Callback() { // from class: com.google.android.filament.android.UiHelper.1
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i17, int i18, int i19) {
                    UiHelper.this.mRenderCallback.onResized(i18, i19);
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    UiHelper.this.createSwapChain(surfaceHolder.getSurface());
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    UiHelper.this.destroySwapChain();
                }
            };
            SurfaceHolder holder = surfaceView.getHolder();
            holder.addCallback(callback);
            int i17 = this.mDesiredWidth;
            if (i17 > 0 && (i3 = this.mDesiredHeight) > 0) {
                holder.setFixedSize(i17, i3);
            }
            Surface surface = holder.getSurface();
            if (surface == null || !surface.isValid()) {
                return;
            }
            callback.surfaceCreated(holder);
            callback.surfaceChanged(holder, i16, holder.getSurfaceFrame().width(), holder.getSurfaceFrame().height());
        }
    }

    public void detach() {
        destroySwapChain();
        this.mNativeWindow = null;
        this.mRenderSurface = null;
    }

    public int getDesiredHeight() {
        return this.mDesiredHeight;
    }

    public int getDesiredWidth() {
        return this.mDesiredWidth;
    }

    @Nullable
    public RendererCallback getRenderCallback() {
        return this.mRenderCallback;
    }

    public long getSwapChainFlags() {
        if (isOpaque()) {
            return 0L;
        }
        return 1L;
    }

    public boolean isMediaOverlay() {
        return this.mOverlay;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    public boolean isReadyToRender() {
        return this.mHasSwapChain;
    }

    public void setDesiredSize(int i3, int i16) {
        this.mDesiredWidth = i3;
        this.mDesiredHeight = i16;
        RenderSurface renderSurface = this.mRenderSurface;
        if (renderSurface != null) {
            renderSurface.resize(i3, i16);
        }
    }

    public void setMediaOverlay(boolean z16) {
        this.mOverlay = z16;
    }

    public void setOpaque(boolean z16) {
        this.mOpaque = z16;
    }

    public void setRenderCallback(@Nullable RendererCallback rendererCallback) {
        this.mRenderCallback = rendererCallback;
    }

    public UiHelper(ContextErrorPolicy contextErrorPolicy) {
        this.mOpaque = true;
        this.mOverlay = false;
    }

    public void attachTo(@NonNull TextureView textureView) {
        if (attach(textureView)) {
            textureView.setOpaque(isOpaque());
            this.mRenderSurface = new TextureViewHandler(textureView);
            TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.google.android.filament.android.UiHelper.2
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                    if (UiHelper.this.mDesiredWidth > 0 && UiHelper.this.mDesiredHeight > 0) {
                        surfaceTexture.setDefaultBufferSize(UiHelper.this.mDesiredWidth, UiHelper.this.mDesiredHeight);
                    }
                    Surface surface = new Surface(surfaceTexture);
                    ((TextureViewHandler) UiHelper.this.mRenderSurface).setSurface(surface);
                    UiHelper.this.createSwapChain(surface);
                    UiHelper.this.mRenderCallback.onResized(i3, i16);
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    UiHelper.this.destroySwapChain();
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                    if (UiHelper.this.mDesiredWidth > 0 && UiHelper.this.mDesiredHeight > 0) {
                        surfaceTexture.setDefaultBufferSize(UiHelper.this.mDesiredWidth, UiHelper.this.mDesiredHeight);
                        UiHelper.this.mRenderCallback.onResized(UiHelper.this.mDesiredWidth, UiHelper.this.mDesiredHeight);
                    } else {
                        UiHelper.this.mRenderCallback.onResized(i3, i16);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            };
            textureView.setSurfaceTextureListener(surfaceTextureListener);
            if (textureView.isAvailable()) {
                surfaceTextureListener.onSurfaceTextureAvailable(textureView.getSurfaceTexture(), this.mDesiredWidth, this.mDesiredHeight);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SurfaceViewHandler implements RenderSurface {
        private SurfaceView mSurfaceView;

        SurfaceViewHandler(SurfaceView surfaceView) {
            this.mSurfaceView = surfaceView;
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void resize(int i3, int i16) {
            this.mSurfaceView.getHolder().setFixedSize(i3, i16);
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void detach() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b implements RenderSurface {

        /* renamed from: a, reason: collision with root package name */
        private SurfaceHolder f33058a;

        b(SurfaceHolder surfaceHolder) {
            this.f33058a = surfaceHolder;
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void resize(int i3, int i16) {
            this.f33058a.setFixedSize(i3, i16);
        }

        @Override // com.google.android.filament.android.UiHelper.RenderSurface
        public void detach() {
        }
    }

    public void attachTo(@NonNull SurfaceHolder surfaceHolder) {
        int i3;
        if (attach(surfaceHolder)) {
            int i16 = isOpaque() ? -1 : -3;
            surfaceHolder.setFormat(i16);
            this.mRenderSurface = new b(surfaceHolder);
            a aVar = new a(surfaceHolder);
            surfaceHolder.addCallback(aVar);
            int i17 = this.mDesiredWidth;
            if (i17 > 0 && (i3 = this.mDesiredHeight) > 0) {
                surfaceHolder.setFixedSize(i17, i3);
            }
            Surface surface = surfaceHolder.getSurface();
            if (surface == null || !surface.isValid()) {
                return;
            }
            aVar.surfaceCreated(surfaceHolder);
            aVar.surfaceChanged(surfaceHolder, i16, surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
        }
    }
}
