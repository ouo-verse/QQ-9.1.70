package com.tencent.thumbplayer.core.codec.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class THookTextureView extends TextureView {
    public static final String TAG = "THookTextureView";
    private static SurfaceTextureHookCallback sHookCallback;
    private final TextureView.SurfaceTextureListener mInnerSetListener;
    private TextureView.SurfaceTextureListener mOutSetListener;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface SurfaceTextureHookCallback {
        boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture surfaceTexture);
    }

    public THookTextureView(@Nullable Context context) {
        this(context, null, 0);
    }

    public static void setHookCallback(SurfaceTextureHookCallback surfaceTextureHookCallback) {
        sHookCallback = surfaceTextureHookCallback;
    }

    @Override // android.view.TextureView
    public final void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.mOutSetListener = surfaceTextureListener;
        super.setSurfaceTextureListener(this.mInnerSetListener);
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mInnerSetListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.hook.THookTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@Nullable SurfaceTexture surfaceTexture, int i16, int i17) {
                if (THookTextureView.this.mOutSetListener != null) {
                    THookTextureView.this.mOutSetListener.onSurfaceTextureAvailable(surfaceTexture, i16, i17);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
                boolean z16;
                boolean z17 = false;
                if (THookTextureView.this.mOutSetListener != null && !THookTextureView.this.mOutSetListener.onSurfaceTextureDestroyed(surfaceTexture)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (THookTextureView.sHookCallback != null) {
                    if (z16 && THookTextureView.sHookCallback.onSurfaceTextureDestroyedCalled(surfaceTexture)) {
                        z17 = true;
                    }
                    LogUtils.d("THookTextureView", this + "onSurfaceTextureDestroyed surfaceTexture:" + surfaceTexture + " hookResult:" + z17 + "result:" + z16);
                    return z17;
                }
                LogUtils.d("THookTextureView", this + ", onSurfaceTextureDestroyed surfaceTexture:" + surfaceTexture + " result:" + z16);
                return z16;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i16, int i17) {
                if (THookTextureView.this.mOutSetListener != null) {
                    THookTextureView.this.mOutSetListener.onSurfaceTextureSizeChanged(surfaceTexture, i16, i17);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
                if (THookTextureView.this.mOutSetListener != null) {
                    THookTextureView.this.mOutSetListener.onSurfaceTextureUpdated(surfaceTexture);
                }
            }
        };
        setSurfaceTextureListener(null);
    }
}
