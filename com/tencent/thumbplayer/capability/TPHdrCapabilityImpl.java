package com.tencent.thumbplayer.capability;

import com.tencent.thumbplayer.api.capability.TPHdrCapAttribute;
import com.tencent.thumbplayer.api.capability.TPHdrCapabilityQueryParams;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPHdrCapabilityImpl {
    private static final String TAG = "TPNativeHdrCapability";

    public static void addCustomizedHdrCapability(int i3, int i16, int i17) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_addCustomizedHdrCapability(i3, i16, i17);
                return;
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_addCustomizedHdrCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_addCustomizedHdrMediaCodecCapability.");
            }
        }
        throw new TPLoadLibraryException("addCustomizedHdrCapability failed, native library not load.");
    }

    public static TPHdrCapAttribute getHdrCapAttribute(int i3) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getHdrCapAttribute(i3);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getHdrCapAttribute has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getHdrCapAttribute.");
            }
        }
        throw new TPLoadLibraryException("getHdrCapAttribute failed, native library not load.");
    }

    public static int getHdrCapability(int i3) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getHdrCapability(i3);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getHdrCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getHdrCapability.");
            }
        }
        throw new TPLoadLibraryException("getHdrCapability failed, native library not load.");
    }

    private static native void native_addCustomizedHdrCapability(int i3, int i16, int i17);

    private static native TPHdrCapAttribute native_getHdrCapAttribute(int i3);

    private static native TPHdrCapAttribute native_getHdrCapAttribute(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams);

    private static native int native_getHdrCapability(int i3);

    private static native int native_getHdrCapability(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams);

    public static TPHdrCapAttribute getHdrCapAttribute(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getHdrCapAttribute(tPHdrCapabilityQueryParams);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getHdrCapAttribute has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getHdrCapAttribute.");
            }
        }
        throw new TPLoadLibraryException("getHdrCapAttribute failed, native library not load.");
    }

    public static int getHdrCapability(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getHdrCapability(tPHdrCapabilityQueryParams);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getHdrCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getHdrCapability.");
            }
        }
        throw new TPLoadLibraryException("getHdrCapability failed, native library not load.");
    }
}
