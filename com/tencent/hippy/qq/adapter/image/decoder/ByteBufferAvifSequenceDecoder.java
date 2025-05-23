package com.tencent.hippy.qq.adapter.image.decoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import libavif.AvifDecoder;
import libavif.AvifSequenceDrawable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ByteBufferAvifSequenceDecoder implements HippyImageDecoder<ByteBuffer, AvifSequenceDrawable> {
    @Override // com.tencent.hippy.qq.adapter.image.decoder.HippyImageDecoder
    @Nullable
    public AvifSequenceDrawable decode(@NonNull ByteBuffer byteBuffer, int i3, int i16) {
        AvifDecoder e16 = AvifDecoder.e(byteBuffer);
        if (e16 == null) {
            AvifLibraryLoader.onDecodeAvifFailure("decode avifs failed, decoder is null.");
            return null;
        }
        return new AvifSequenceDrawable(e16);
    }

    @Override // com.tencent.hippy.qq.adapter.image.decoder.HippyImageDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer) {
        return ImageDetector.isAvifAnimated(byteBuffer);
    }
}
