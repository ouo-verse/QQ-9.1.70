package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.capability.TPDecoderCapabilityImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPDecoderCapability {
    public static final int TP_DECODER_CAP_NOT_SUPPORT = 0;
    public static final int TP_DECODER_CAP_SUPPORT = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPDecoderCap {
    }

    public static void addCustomizedAudioMediaCodecCapability(int i3, int i16) throws TPLoadLibraryException {
        TPDecoderCapabilityImpl.addCustomizedAudioMediaCodecCapability(i3, i16);
    }

    public static void addCustomizedVideoMediaCodecCapability(int i3, int i16) throws TPLoadLibraryException {
        addCustomizedVideoMediaCodecCapability(i3, new TPVideoDecoderCapabilityRange(), i16);
    }

    public static int getAudioDecoderCapability(int i3) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getAudioDecoderCapability(i3);
    }

    public static int getVideoDecoderCapability(int i3, int i16, int i17, float f16) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getVideoDecoderCapability(i3, i16, i17, f16);
    }

    public static void addCustomizedVideoMediaCodecCapability(int i3, TPVideoDecoderCapabilityRange tPVideoDecoderCapabilityRange, int i16) throws TPLoadLibraryException {
        TPDecoderCapabilityImpl.addCustomizedVideoMediaCodecCapability(i3, tPVideoDecoderCapabilityRange, i16);
    }

    public static int getAudioDecoderCapability(int i3, int i16) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getAudioDecoderCapability(i3, i16);
    }

    public static int getVideoDecoderCapability(int i3, int i16, int i17, int i18, float f16) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getVideoDecoderCapability(i3, i16, i17, i18, f16);
    }

    public static int getAudioDecoderCapability(TPAudioCapabilityQueryParams tPAudioCapabilityQueryParams) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getAudioDecoderCapability(tPAudioCapabilityQueryParams);
    }

    public static int getVideoDecoderCapability(TPVideoCapabilityQueryParams tPVideoCapabilityQueryParams) throws TPLoadLibraryException {
        return TPDecoderCapabilityImpl.getVideoDecoderCapability(tPVideoCapabilityQueryParams);
    }
}
