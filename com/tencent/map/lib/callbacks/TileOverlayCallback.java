package com.tencent.map.lib.callbacks;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public interface TileOverlayCallback {
    Bitmap onLoadTile(int i3, int i16, int i17, byte[] bArr);

    void onLoadTileFinish(int i3, int i16, int i17);

    void onWriteTile(int i3, int i16, int i17, String str, byte[] bArr);
}
