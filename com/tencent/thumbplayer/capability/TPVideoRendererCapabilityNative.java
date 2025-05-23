package com.tencent.thumbplayer.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPVideoRendererCapabilityNative {
    private static final String TAG = "TPNativeVideoRendererCapability";

    public static boolean isRendererColorBitDepthSupported(int i3, int i16, int i17, int i18, int i19) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return native_isRendererColorBitDepthSupported(i3, i16, i17, i18, i19);
        }
        throw new TPLoadLibraryException("getVideoRendererCapability failed, native library not load.");
    }

    public static boolean isRendererExtensionSupported(int i3, String str) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return native_isRendererExtensionSupported(i3, str);
        }
        throw new TPLoadLibraryException("getVideoRendererCapability failed, native library not load.");
    }

    public static boolean isRendererVersionSupported(int i3, String str) throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return native_isRendererVersionSupported(i3, str);
        }
        throw new TPLoadLibraryException("getVideoRendererCapability failed, native library not load.");
    }

    private static native boolean native_isRendererColorBitDepthSupported(int i3, int i16, int i17, int i18, int i19);

    private static native boolean native_isRendererExtensionSupported(int i3, String str);

    private static native boolean native_isRendererVersionSupported(int i3, String str);
}
