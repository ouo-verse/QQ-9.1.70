package com.tencent.libra.extension.gif;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.libra.extension.gif.GifTextureView;

/* compiled from: P */
/* loaded from: classes7.dex */
class k implements TextureView.SurfaceTextureListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GifTextureView.b bVar) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        new Surface(surfaceTexture).lockCanvas(null);
        throw null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
    }
}
