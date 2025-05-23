package com.tencent.thumbplayer.core.codec.decoder;

import android.view.Surface;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPMediaCodecDecoder {
    public static final int BOOL_DISABLE_MEDIA_CODEC_DOLBY_VISION_COMPONENT = 6;
    public static final int BOOL_DISABLE_MEDIA_DRM_HW_SECURE_COMPONENT = 8;
    public static final int BOOL_ENABLE_ASYNC_MODE = 1;
    public static final int BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA = 5;
    public static final int BOOL_ENABLE_MEDIACODEC_RELEASE_OUTPUTBUFFER_WITH_TIMESTAMP = 7;
    public static final int BOOL_ENABLE_MEDIACODEC_REUSE = 4;
    public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 0;
    public static final int BOOL_SET_IS_ADTS = 2;
    public static final int BOOL_SET_IS_AUDIO_PASSTHROUGH = 3;
    public static final int BYTES_SET_CSD0_DATA = 200;
    public static final int BYTES_SET_CSD1_DATA = 201;
    public static final int BYTES_SET_CSD2_DATA = 202;
    public static final int BYTES_SET_MEDIA_DRM_SESSION_ID = 350;
    public static final int OBJECT_SET_MEDIACODEC_PARAMS = 9;
    public static final int OBJECT_SET_MEDIA_CRYPTO = 300;
    public static final int STRING_SET_MEDIA_DRM_UUID = 351;
    public static final int TP_CODEC_RETURN_CODE_EOS = 2;
    public static final int TP_CODEC_RETURN_CODE_ERROR = 3;
    public static final int TP_CODEC_RETURN_CODE_INTERNAL_RESET = 4;
    public static final int TP_CODEC_RETURN_CODE_OK = 0;
    public static final int TP_CODEC_RETURN_CODE_TRY_AGAIN = 1;
    public static final int TP_ERROR_DECODE_FAILED = 103;
    public static final int TP_ERROR_FLUSH_FAILED = 104;
    public static final int TP_ERROR_INVALID_CODECPAR = 100;
    public static final int TP_ERROR_NO_CODEC = 101;
    public static final int TP_ERROR_OPEN_FAILED = 102;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface MediaCodecReturnCode {
    }

    int decode(byte[] bArr, boolean z16, long j3, boolean z17);

    TPFrameInfo dequeueOutputBuffer();

    int flush();

    int getMediaType();

    boolean initDecoder(String str, int i3, int i16, int i17, int i18);

    boolean initDecoder(String str, int i3, int i16, int i17, Surface surface, int i18, int i19, int i26);

    int release();

    int releaseOutputBuffer(int i3, boolean z16, long j3);

    void setCryptoInfo(int i3, @NonNull int[] iArr, @NonNull int[] iArr2, @NonNull byte[] bArr, @NonNull byte[] bArr2, int i16, int i17, int i18);

    int setOperateRate(float f16);

    int setOutputSurface(Surface surface);

    boolean setParamBool(int i3, boolean z16);

    boolean setParamBytes(int i3, byte[] bArr);

    boolean setParamInt(int i3, int i16);

    boolean setParamLong(int i3, long j3);

    boolean setParamObject(int i3, Object obj);

    boolean setParamString(int i3, String str);

    int signalEndOfStream();

    boolean startDecoder();
}
