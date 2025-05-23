package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.statistics.MediaCodecStatistics;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TMediaCodec implements IMediaCodec {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TMediaCodec";

    @Nullable
    private CodecCallback codecCallback;
    public boolean codecFinalReuseEnable;

    @Nullable
    private CodecWrapper codecWrapper;
    private CreateBy createBy;
    public boolean isReUsed;
    private final MediaCodecStatistics mCodecStatistics;
    private boolean mConfigureCalled;

    @NonNull
    private final String nameOrType;
    private boolean reUseEnable;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class Callback {
        static IPatchRedirector $redirector_;

        public Callback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void onError(@NonNull TMediaCodec tMediaCodec, @NonNull MediaCodec.CodecException codecException);

        public abstract void onInputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3);

        public abstract void onOutputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(@NonNull TMediaCodec tMediaCodec, @NonNull MediaFormat mediaFormat);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class CreateBy {
        private static final /* synthetic */ CreateBy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CreateBy CreateByName;
        public static final CreateBy CreateByType;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61480);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CreateBy createBy = new CreateBy("CreateByName", 0);
            CreateByName = createBy;
            CreateBy createBy2 = new CreateBy("CreateByType", 1);
            CreateByType = createBy2;
            $VALUES = new CreateBy[]{createBy, createBy2};
        }

        CreateBy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CreateBy valueOf(String str) {
            return (CreateBy) Enum.valueOf(CreateBy.class, str);
        }

        public static CreateBy[] values() {
            return (CreateBy[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes26.dex */
    public static final class HookCallback extends MediaCodec.Callback {
        static IPatchRedirector $redirector_;

        @Nullable
        private final Callback callback;

        @NonNull
        private final TMediaCodec tMediaCodec;

        public HookCallback(@NonNull TMediaCodec tMediaCodec, @Nullable Callback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tMediaCodec, (Object) callback);
            } else {
                this.tMediaCodec = tMediaCodec;
                this.callback = callback;
            }
        }

        @Nullable
        public final Callback getCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Callback) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.callback;
        }

        @NonNull
        public final TMediaCodec getTMediaCodec() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TMediaCodec) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.tMediaCodec;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) mediaCodec, (Object) codecException);
                return;
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onError(this.tMediaCodec, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaCodec, i3);
                return;
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onInputBufferAvailable(this.tMediaCodec, i3);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, mediaCodec, Integer.valueOf(i3), bufferInfo);
                return;
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onOutputBufferAvailable(this.tMediaCodec, i3, bufferInfo);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaCodec, (Object) mediaFormat);
                return;
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onOutputFormatChanged(this.tMediaCodec, mediaFormat);
            }
        }
    }

    TMediaCodec(String str, CreateBy createBy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) createBy);
            return;
        }
        this.reUseEnable = true;
        this.nameOrType = str;
        this.createBy = createBy;
        this.mCodecStatistics = new MediaCodecStatistics(isVideo());
    }

    public static TMediaCodec createByCodecName(@NonNull String str) {
        return new TMediaCodec(str, CreateBy.CreateByName);
    }

    public static TMediaCodec createDecoderByType(@NonNull String str) {
        return new TMediaCodec(str, CreateBy.CreateByType);
    }

    private void onAfterConfigure() {
        this.mCodecStatistics.configCodecEnd(this.isReUsed);
        ThreadManager.postOnSubThread(new Runnable() { // from class: com.tencent.tmediacodec.TMediaCodec.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMediaCodec.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
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
        ThreadManager.postOnSubThread(new Runnable() { // from class: com.tencent.tmediacodec.TMediaCodec.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMediaCodec.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (TMediaCodec.this.codecCallback != null) {
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

    @Override // com.tencent.tmediacodec.IMediaCodec
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, mediaFormat, surface, mediaCrypto, Integer.valueOf(i3));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, j3)).intValue();
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.dequeueInputBuffer(j3);
        }
        return -1000;
    }

    public final int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, bufferInfo, Long.valueOf(j3))).intValue();
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            return codecWrapper.dequeueOutputBuffer(bufferInfo, j3);
        }
        return -1000;
    }

    public final void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.flush();
        }
    }

    public final CodecCallback getCodecCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CodecCallback) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.codecCallback;
    }

    @Nullable
    public final CodecWrapper getCodecWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CodecWrapper) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.codecWrapper;
    }

    public CreateBy getCreateBy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CreateBy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.createBy;
    }

    @TargetApi(21)
    @Nullable
    public final ByteBuffer getInputBuffer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ByteBuffer) iPatchRedirector.redirect((short) 22, (Object) this, i3);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ByteBuffer[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getInputBuffers();
        }
        return null;
    }

    @NonNull
    public final String getNameOrType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.nameOrType;
    }

    @TargetApi(21)
    @Nullable
    public final ByteBuffer getOutputBuffer(int i3) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ByteBuffer) iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ByteBuffer[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            return mediaCodec.getOutputFormat();
        }
        return null;
    }

    public final boolean isReuseEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.reUseEnable;
    }

    public final boolean isVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return TUtils.isVideo(this.nameOrType);
    }

    public final void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18));
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.queueInputBuffer(i3, i16, i17, j3, i18);
        }
    }

    public final void queueSecureInputBuffer(int i3, int i16, @NonNull MediaCodec.CryptoInfo cryptoInfo, long j3, int i17) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), cryptoInfo, Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.queueSecureInputBuffer(i3, i16, cryptoInfo, j3, i17);
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.release();
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    public void releaseOutputBuffer(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.releaseOutputBuffer(i3, z16);
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    @TargetApi(21)
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.reset();
        }
    }

    @TargetApi(21)
    public final void setCallback(@Nullable Callback callback) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) callback);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper == null || (mediaCodec = codecWrapper.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setCallback(new HookCallback(this, callback));
    }

    public final void setCodecCallback(@Nullable CodecCallback codecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) codecCallback);
        } else {
            this.codecCallback = codecCallback;
        }
    }

    @TargetApi(23)
    public final void setOutputSurface(@NonNull Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) surface);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.setOutputSurface(surface);
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    @TargetApi(19)
    public void setParameters(@Nullable Bundle bundle) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) bundle);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.setParameters(bundle);
        }
    }

    public final void setReuseEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.reUseEnable = z16;
        }
    }

    public final void setVideoScalingMode(int i3) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null && (mediaCodec = codecWrapper.getMediaCodec()) != null) {
            mediaCodec.setVideoScalingMode(i3);
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
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

    @Override // com.tencent.tmediacodec.IMediaCodec
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.stop();
        }
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    @TargetApi(21)
    public void releaseOutputBuffer(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper != null) {
            codecWrapper.releaseOutputBuffer(i3, j3);
        }
    }

    @TargetApi(23)
    public final void setCallback(@NonNull Callback callback, @Nullable Handler handler) {
        MediaCodec mediaCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) callback, (Object) handler);
            return;
        }
        CodecWrapper codecWrapper = this.codecWrapper;
        if (codecWrapper == null || (mediaCodec = codecWrapper.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setCallback(new HookCallback(this, callback), handler);
    }

    @Override // com.tencent.tmediacodec.IMediaCodec
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, mediaFormat, surface, Integer.valueOf(i3), mediaDescrambler);
            return;
        }
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
