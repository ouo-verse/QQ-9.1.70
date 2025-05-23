package com.tencent.tavkit.resample;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVResample implements IAVResample {
    private static final String TAG = "TAVResample";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f374473a = 0;
    private long context;

    static {
        System.loadLibrary("tav-resample");
    }

    public TAVResample(int i3, int i16, int i17, int i18) {
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
