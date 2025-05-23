package com.tencent.hippy.qq.adapter.image.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ByteBufferAvifDecoder implements HippyImageDecoder<ByteBuffer, Bitmap> {
    @Override // com.tencent.hippy.qq.adapter.image.decoder.HippyImageDecoder
    public Bitmap decode(@NonNull ByteBuffer byteBuffer, int i3, int i16) {
        AvifDecoder e16 = AvifDecoder.e(byteBuffer);
        if (e16 == null) {
            AvifLibraryLoader.onDecodeAvifFailure("decode failed=======>decoder is null.");
            return null;
        }
        if (!e16.j()) {
            AvifLibraryLoader.onDecodeAvifFailure("decode failed=======>next image is null.");
            return null;
        }
        AvifImage g16 = e16.g();
        Bitmap createBitmap = Bitmap.createBitmap(g16.b(), g16.a(), Bitmap.Config.ARGB_8888);
        e16.f(createBitmap);
        e16.b();
        return createBitmap;
    }

    @Override // com.tencent.hippy.qq.adapter.image.decoder.HippyImageDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer) {
        return ImageDetector.isAvifStaticImage(byteBuffer);
    }
}
