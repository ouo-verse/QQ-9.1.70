package com.tencent.luggage.wxa.a8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface i {
    Bitmap getBitmap();

    SurfaceTexture getSurfaceTexture();

    void setImageBitmap(Bitmap bitmap);

    void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener);
}
