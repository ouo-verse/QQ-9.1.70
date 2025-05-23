package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.capability.TPVideoRendererCapabilityNative;

/* loaded from: classes26.dex */
public class TPVideoRendererCapability {
    public static boolean isRendererColorBitDepthSupported(int i3, int i16, int i17, int i18, int i19) throws TPLoadLibraryException {
        return TPVideoRendererCapabilityNative.isRendererColorBitDepthSupported(i3, i16, i17, i18, i19);
    }

    public static boolean isRendererExtensionSupported(int i3, String str) throws TPLoadLibraryException {
        return TPVideoRendererCapabilityNative.isRendererExtensionSupported(i3, str);
    }

    public static boolean isRendererVersionSupported(int i3, String str) throws TPLoadLibraryException {
        return TPVideoRendererCapabilityNative.isRendererVersionSupported(i3, str);
    }
}
