package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.util.LogUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class DirectCodecWrapper implements CodecWrapper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "DirectCodecWrapper";

    @NonNull
    private final MediaCodec codec;

    public DirectCodecWrapper(@NonNull MediaCodec mediaCodec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaCodec);
        } else {
            this.codec = mediaCodec;
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void attachThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.codec.configure(mediaFormat, surface, mediaCrypto, i3);
        } else {
            iPatchRedirector.redirect((short) 7, this, mediaFormat, surface, mediaCrypto, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public int dequeueInputBuffer(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, j3)).intValue();
        }
        return this.codec.dequeueInputBuffer(j3);
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, bufferInfo, Long.valueOf(j3))).intValue();
        }
        return this.codec.dequeueOutputBuffer(bufferInfo, j3);
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.codec.flush();
        }
    }

    @NonNull
    public final MediaCodec getCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (MediaCodec) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.codec;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @NonNull
    public MediaCodec getMediaCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MediaCodec) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.codec;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void prepareToReUse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...");
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18));
        } else {
            this.codec.queueInputBuffer(i3, i16, i17, j3, i18);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.codec.release();
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void releaseOutputBuffer(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.codec.releaseOutputBuffer(i3, z16);
        } else {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.codec.reset();
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @NonNull
    public ReuseHelper.ReuseType setCanReuseType(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReuseHelper.ReuseType) iPatchRedirector.redirect((short) 4, (Object) this, (Object) formatWrapper);
        }
        LogUtils.w("DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...");
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void setCodecCallback(@Nullable CodecCallback codecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) codecCallback);
        } else {
            LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...");
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(23)
    public void setOutputSurface(@NonNull Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) surface);
        } else {
            this.codec.setOutputSurface(surface);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.codec.start();
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.codec.stop();
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.codec.configure(mediaFormat, surface, i3, mediaDescrambler);
        } else {
            iPatchRedirector.redirect((short) 8, this, mediaFormat, surface, Integer.valueOf(i3), mediaDescrambler);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void releaseOutputBuffer(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.codec.releaseOutputBuffer(i3, j3);
        } else {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }
}
