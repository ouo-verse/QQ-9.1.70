package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class DirectCodecWrapper implements CodecWrapper {
    public static final String TAG = "DirectCodecWrapper";
    private static AtomicInteger sCodecNum = new AtomicInteger(0);

    @NonNull
    private final MediaCodec mCodec;

    public DirectCodecWrapper(@NonNull MediaCodec mediaCodec) {
        this.mCodec = mediaCodec;
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper sCodecNum:" + sCodecNum.incrementAndGet());
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuseType(@NonNull FormatWrapper formatWrapper) {
        LogUtils.w("DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...");
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        this.mCodec.configure(mediaFormat, surface, mediaCrypto, i3);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public int dequeueInputBuffer(long j3) {
        return this.mCodec.dequeueInputBuffer(j3);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        return this.mCodec.dequeueOutputBuffer(bufferInfo, j3);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void flush() {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper flush start ...");
        this.mCodec.flush();
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper flush end ...");
    }

    @NonNull
    public final MediaCodec getCodec() {
        return this.mCodec;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @NonNull
    public MediaCodec getMediaCodec() {
        return this.mCodec;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void prepareToReUse() {
        LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        this.mCodec.queueInputBuffer(i3, i16, i17, j3, i18);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void release() {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper release start ...");
        this.mCodec.release();
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper release end ... sCodecNum:" + sCodecNum.decrementAndGet());
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void releaseOutputBuffer(int i3, boolean z16) {
        this.mCodec.releaseOutputBuffer(i3, z16);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void reset() {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper reset start ...");
        this.mCodec.reset();
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper reset end ...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void setCodecCallback(@Nullable CodecCallback codecCallback) {
        LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(23)
    public void setOutputSurface(@NonNull Surface surface) {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface start, surface:" + surface);
        this.mCodec.setOutputSurface(surface);
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface end ...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void start() {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper start ...");
        this.mCodec.start();
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper start end...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void stop() {
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper stop before ...");
        this.mCodec.stop();
        LogUtils.i("DirectCodecWrapper", "DirectCodecWrapper stop end ...");
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        this.mCodec.configure(mediaFormat, surface, i3, mediaDescrambler);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void releaseOutputBuffer(int i3, long j3) {
        this.mCodec.releaseOutputBuffer(i3, j3);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void attachThread() {
    }
}
