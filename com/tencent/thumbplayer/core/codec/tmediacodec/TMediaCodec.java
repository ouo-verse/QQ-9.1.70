package com.tencent.thumbplayer.core.codec.tmediacodec;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.statistics.MediaCodecStatistics;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ThreadManager;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TMediaCodec implements IMediaCodec {
    public static final String TAG = "TMediaCodec";

    @Nullable
    private CodecCallback codecCallback;
    public boolean codecFinalReuseEnable;

    @Nullable
    private CodecWrapper codecWrapper;
    private CreateBy createBy;
    public boolean isReUsed;
    private boolean mConfigureCalled;

    @NonNull
    private final String nameOrType;
    private boolean reUseEnable = true;
    private final MediaCodecStatistics mCodecStatistics = new MediaCodecStatistics(isVideo());

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class Callback {
        public abstract void onError(@NonNull TMediaCodec tMediaCodec, @NonNull MediaCodec.CodecException codecException);

        public abstract void onInputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3);

        public abstract void onOutputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(@NonNull TMediaCodec tMediaCodec, @NonNull MediaFormat mediaFormat);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum CreateBy {
        CreateByName,
        CreateByType
    }

    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes26.dex */
    public static final class HookCallback extends MediaCodec.Callback {

        @Nullable
        private final Callback callback;

        @NonNull
        private final TMediaCodec tMediaCodec;

        public HookCallback(@NonNull TMediaCodec tMediaCodec, @Nullable Callback callback) {
            this.tMediaCodec = tMediaCodec;
            this.callback = callback;
        }

        @Nullable
        public final Callback getCallback() {
            return this.callback;
        }

        @NonNull
        public final TMediaCodec getTMediaCodec() {
            return this.tMediaCodec;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onError(this.tMediaCodec, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onInputBufferAvailable(this.tMediaCodec, i3);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onOutputBufferAvailable(this.tMediaCodec, i3, bufferInfo);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onOutputFormatChanged(this.tMediaCodec, mediaFormat);
            }
        }
    }

    TMediaCodec(String str, CreateBy createBy) {
        this.nameOrType = str;
        this.createBy = createBy;
    }

    public static TMediaCodec createByCodecName(@NonNull String str) {
        return new TMediaCodec(str, CreateBy.CreateByName);
    }

    public static TMediaCodec createDecoderByType(@NonNull String str) {
        return new TMediaCodec(str, CreateBy.CreateByType);
    }

    private void onAfterConfigure() {
        this.mCodecStatistics.configCodecEnd(this.isReUsed);
        ThreadManager.postOnSubThread(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.1
            @Override // java.lang.Runnable
            public void run() {
                if (TMediaCodec.this.codecWrapper != null) {
                    TMediaCodec.this.codecWrapper.setCodecCallback(TMediaCodec.this.codecCallback);
                }
                if (TMediaCodec.this.codecCallback != null) {
                    TMediaCodec.this.codecCallback.onCreate(Boolean.valueOf(TMediaCodec.this.isReUsed));
                }
            }
        });
    }

    private void onAfterStart() {
        this.mCodecStatistics.startCodecEnd();
        ThreadManager.postOnSubThread(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.2
            @Override // java.lang.Runnable
            public void run() {
                if (TMediaCodec.this.codecCallback != null) {
                    TMediaCodec.this.codecCallback.onStarted(Boolean.valueOf(TMediaCodec.this.isReUsed), TMediaCodec.this.mCodecStatistics.getData());
                }
            }
        });
    }

    private void onBeforeConfigure(Surface surface) {
        this.codecFinalReuseEnable = TCodecManager.getInstance().reuseEnable(this, surface);
        this.mCodecStatistics.createByCodecStart();
        this.mCodecStatistics.createByCodecEnd();
        this.mCodecStatistics.configCodecStart(this.codecFinalReuseEnable);
    }

    private void onBeforeStart() {
        this.mCodecStatistics.startCodecStart();
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        if (this.mConfigureCalled) {
            LogUtils.w("TMediaCodec", "configure ignored, mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i3 + " stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.mConfigureCalled = true;
        onBeforeConfigure(surface);
        try {
            this.codecWrapper = TCodecManager.getInstance().configure(mediaFormat, surface, mediaCrypto, i3, this);
        } catch (IOException e16) {
            LogUtils.e("TMediaCodec", "createCodec mediaFormat:" + mediaFormat, e16);
        }
        onAfterConfigure();
    }

    public final int dequeueInputBuffer(long j3) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.dequeueInputBuffer(j3);
        }
        return -1000;
    }

    public final int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.dequeueOutputBuffer(bufferInfo, j3);
        }
        return -1000;
    }

    public final void flush() {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.flush();
        }
    }

    public final CodecCallback getCodecCallback() {
        return this.codecCallback;
    }

    @Nullable
    public String getCodecName() {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && codecWrapper.getMediaCodec() != null) {
            return TUtils.getCodeName(this.codecWrapper.getMediaCodec());
        }
        return null;
    }

    @Nullable
    public final CodecWrapper getCodecWrapper() {
        return this.codecWrapper;
    }

    public CreateBy getCreateBy() {
        return this.createBy;
    }

    @Nullable
    @TargetApi(21)
    public final ByteBuffer getInputBuffer(int i3) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.getMediaCodec().getInputBuffer(i3);
        }
        return null;
    }

    @NonNull
    @Nullable
    public final ByteBuffer[] getInputBuffers() {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getInputBuffers();
        }
        return null;
    }

    @NonNull
    public final String getNameOrType() {
        return this.nameOrType;
    }

    @Nullable
    @TargetApi(21)
    public final ByteBuffer getOutputBuffer(int i3) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getOutputBuffer(i3);
        }
        return null;
    }

    @NonNull
    @Nullable
    public final ByteBuffer[] getOutputBuffers() {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getOutputBuffers();
        }
        return null;
    }

    @NonNull
    @Nullable
    public final MediaFormat getOutputFormat() {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getOutputFormat();
        }
        return null;
    }

    @Nullable
    @TargetApi(21)
    public final Image getOutputImage(int i3) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.getMediaCodec().getOutputImage(i3);
        }
        return null;
    }

    public final boolean isReuseEnable() {
        return this.reUseEnable;
    }

    public final boolean isVideo() {
        return TUtils.isVideo(this.nameOrType);
    }

    public final void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.queueInputBuffer(i3, i16, i17, j3, i18);
        }
    }

    public final void queueSecureInputBuffer(int i3, int i16, @NonNull MediaCodec.CryptoInfo cryptoInfo, long j3, int i17) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.queueSecureInputBuffer(i3, i16, cryptoInfo, j3, i17);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    public void release() {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.release();
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    public void releaseOutputBuffer(int i3, boolean z16) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.releaseOutputBuffer(i3, z16);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    @TargetApi(21)
    public void reset() {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.reset();
        }
    }

    @TargetApi(21)
    public final void setCallback(@Nullable Callback callback) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper == null || (mediaCodec = codecWrapper.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setCallback(new HookCallback(this, callback));
    }

    public final void setCodecCallback(@Nullable CodecCallback codecCallback) {
        this.codecCallback = codecCallback;
    }

    @TargetApi(23)
    public final void setOutputSurface(@NonNull Surface surface) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.setOutputSurface(surface);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    @TargetApi(19)
    public void setParameters(@Nullable Bundle bundle) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.setParameters(bundle);
        }
    }

    public final void setReuseEnable(boolean z16) {
        this.reUseEnable = z16;
    }

    public final void setVideoScalingMode(int i3) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.setVideoScalingMode(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    public void start() {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TMediaCodec", "start codecWrapper:" + this.codecWrapper);
        }
        onBeforeStart();
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.start();
        }
        onAfterStart();
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    public void stop() {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.stop();
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    @TargetApi(21)
    public void releaseOutputBuffer(int i3, long j3) {
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.releaseOutputBuffer(i3, j3);
        }
    }

    @TargetApi(23)
    public final void setCallback(@NonNull Callback callback, @Nullable Handler handler) {
        MediaCodec mediaCodec;
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper == null || (mediaCodec = codecWrapper.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setCallback(new HookCallback(this, callback), handler);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.IMediaCodec
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        if (this.mConfigureCalled) {
            LogUtils.w("TMediaCodec", "configure ignored, mediaFormat:" + mediaFormat + " surface:" + surface + " flags:" + i3 + " descrambler:" + mediaDescrambler + " stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.mConfigureCalled = true;
        onBeforeConfigure(surface);
        try {
            this.codecWrapper = TCodecManager.getInstance().configure(mediaFormat, surface, i3, mediaDescrambler, this);
        } catch (IOException e16) {
            LogUtils.e("TMediaCodec", "createCodec mediaFormat:" + mediaFormat, e16);
        }
        onAfterConfigure();
    }
}
