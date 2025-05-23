package com.tencent.thumbplayer.capability;

import com.tencent.thumbplayer.api.capability.TPAudioCapabilityQueryParams;
import com.tencent.thumbplayer.api.capability.TPVideoCapabilityQueryParams;
import com.tencent.thumbplayer.api.capability.TPVideoDecoderCapabilityRange;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPDecoderCapabilityImpl {
    private static final String TAG = "TPDecoderCapabilityImpl";

    public static void addCustomizedAudioMediaCodecCapability(int i3, int i16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_addCustomizedAudioMediaCodecCapability(i3, i16);
                return;
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_addCustomizedAudioMediaCodecCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_addCustomizedAudioMediaCodecCapability.");
            }
        }
        throw new TPLoadLibraryException("addCustomizedAudioMediaCodecCapability failed, native library not load.");
    }

    public static void addCustomizedVideoMediaCodecCapability(int i3, TPVideoDecoderCapabilityRange tPVideoDecoderCapabilityRange, int i16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_addCustomizedVideoMediaCodecCapability(i3, tPVideoDecoderCapabilityRange, i16);
                return;
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_addCustomizedVideoMediaCodecCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_addCustomizedVideoMediaCodecCapability.");
            }
        }
        throw new TPLoadLibraryException("addCustomizedVideoMediaCodecCapability failed, native library not load.");
    }

    public static int getAudioDecoderCapability(int i3) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getAudioDecoderCapability(i3);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getAudioDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getAudioDecoderCapability.");
            }
        }
        throw new TPLoadLibraryException("getAudioDecoderCapability failed, native library not load.");
    }

    public static int getVideoDecoderCapability(int i3, int i16, int i17, float f16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getVideoDecoderCapability(i3, i16, i17, f16);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getVideoDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getVideoDecoderCapability.");
            }
        }
        throw new TPLoadLibraryException("getVideoDecoderCapability failed, native library not load.");
    }

    private static native void native_addCustomizedAudioMediaCodecCapability(int i3, int i16);

    private static native void native_addCustomizedVideoMediaCodecCapability(int i3, TPVideoDecoderCapabilityRange tPVideoDecoderCapabilityRange, int i16);

    private static native int native_getAudioDecoderCapability(int i3);

    private static native int native_getAudioDecoderCapability(int i3, int i16);

    private static native int native_getAudioDecoderCapability(TPAudioCapabilityQueryParams tPAudioCapabilityQueryParams);

    private static native int native_getVideoDecoderCapability(int i3, int i16, int i17, float f16);

    private static native int native_getVideoDecoderCapability(int i3, int i16, int i17, int i18, float f16);

    private static native int native_getVideoDecoderCapability(TPVideoCapabilityQueryParams tPVideoCapabilityQueryParams);

    public static int getAudioDecoderCapability(int i3, int i16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getAudioDecoderCapability(i3, i16);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getAudioDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getAudioDecoderCapability.");
            }
        }
        throw new TPLoadLibraryException("getAudioDecoderCapability failed, native library not load.");
    }

    public static int getVideoDecoderCapability(int i3, int i16, int i17, int i18, float f16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getVideoDecoderCapability(i3, i16, i17, i18, f16);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getVideoDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getVideoDecoderCapability.");
            }
        }
        throw new TPLoadLibraryException("getVideoDecoderCapability failed, native library not load.");
    }

    public static int getAudioDecoderCapability(TPAudioCapabilityQueryParams tPAudioCapabilityQueryParams) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getAudioDecoderCapability(tPAudioCapabilityQueryParams);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getAudioDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getAudioDecoderCapability with query params.");
            }
        }
        throw new TPLoadLibraryException("getAudioDecoderCapability failed, native library not load.");
    }

    public static int getVideoDecoderCapability(TPVideoCapabilityQueryParams tPVideoCapabilityQueryParams) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getVideoDecoderCapability(tPVideoCapabilityQueryParams);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getVideoDecoderCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getVideoDecoderCapability.");
            }
        }
        throw new TPLoadLibraryException("getVideoDecoderCapability failed, native library not load.");
    }
}
