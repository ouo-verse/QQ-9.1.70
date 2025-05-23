package com.tencent.tavkit.tavffmpeg;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FFmpegResample implements IAVResample {
    private static final String TAG = "TAVResample";
    private long context;

    public FFmpegResample(int i3, int i16, int i17, int i18) {
        this.context = nativeSetup(i3, i16, i17, i18);
    }

    private native void nativeRelease(long j3);

    private native byte[] nativeResample(long j3, ByteBuffer byteBuffer, int i3);

    private native byte[] nativeResampleByByteArray(long j3, byte[] bArr, int i3);

    private native long nativeSetup(int i3, int i16, int i17, int i18);

    private native void updateSrcFormat(long j3, int i3, int i16);

    @Override // com.tencent.tav.coremedia.IAVResample
    public void release() {
        nativeRelease(this.context);
        this.context = -1L;
    }

    @Override // com.tencent.tav.coremedia.IAVResample
    @Nullable
    public byte[] resample(ByteBuffer byteBuffer, int i3) {
        if (byteBuffer == null || i3 <= 64) {
            return null;
        }
        if (byteBuffer.isDirect()) {
            return nativeResample(this.context, byteBuffer, i3);
        }
        return nativeResampleByByteArray(this.context, byteBuffer.array(), i3);
    }

    @Override // com.tencent.tav.coremedia.IAVResample
    public void updateSrcFormat(int i3, int i16) {
        updateSrcFormat(this.context, i3, i16);
    }

    public byte[] resample(byte[] bArr, int i3) {
        return nativeResampleByByteArray(this.context, bArr, i3);
    }
}
