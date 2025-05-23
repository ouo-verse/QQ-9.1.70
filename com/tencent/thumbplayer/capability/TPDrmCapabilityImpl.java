package com.tencent.thumbplayer.capability;

import com.tencent.thumbplayer.api.capability.TPDrmCapAttribute;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPDrmCapabilityImpl {
    private static final String TAG = "TPDrmCapabilityImpl";

    public static void addCustomizedMediaDrmCapability(int i3, int i16) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_addCustomizedMediaDrmCapability(i3, i16);
                return;
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_addCustomizedMediaDrmCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_addCustomizedMediaDrmCapability.");
            }
        }
        throw new TPLoadLibraryException("addCustomizedMediaDrmCapability failed, native library not load.");
    }

    public static TPDrmCapAttribute[] getDrmCapAttributes() throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getDrmCapAttributes();
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getDrmCapAttributes has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getDrmCapAttributes.");
            }
        }
        throw new TPLoadLibraryException("getDrmCapAttributes failed, native library not load.");
    }

    public static int getDrmCapability(int i3) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                return native_getDrmCapability(i3);
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "call native_getDrmCapability has exception:" + th5.getMessage());
                throw new TPLoadLibraryException("Failed to call native_getDrmCapability.");
            }
        }
        throw new TPLoadLibraryException("getDrmCapability failed, native library not load.");
    }

    private static native void native_addCustomizedMediaDrmCapability(int i3, int i16);

    private static native TPDrmCapAttribute[] native_getDrmCapAttributes();

    private static native int native_getDrmCapability(int i3);

    public static void preloadDrmCapability() {
        try {
            getDrmCapability(0);
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.e(TAG, e16);
        }
    }
}
