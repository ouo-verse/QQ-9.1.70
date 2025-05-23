package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.capability.TPDrmCapabilityImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPDrmCapability {
    public static final int TP_DRM_CAP_NOT_SUPPORT = 0;
    public static final int TP_DRM_CAP_SUPPORT = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPDrmCap {
    }

    public static void addCustomizedMediaDrmCapability(int i3, int i16) throws TPLoadLibraryException, IllegalArgumentException {
        if (i3 != 0 && i3 != 3) {
            throw new IllegalArgumentException("the drm is not support customize capability!");
        }
        TPDrmCapabilityImpl.addCustomizedMediaDrmCapability(i3, i16);
    }

    public static TPDrmCapAttribute getDrmCapAttribute(int i3) throws TPLoadLibraryException {
        for (TPDrmCapAttribute tPDrmCapAttribute : getDrmCapAttributes()) {
            if (tPDrmCapAttribute.getDrmType() == i3) {
                return tPDrmCapAttribute;
            }
        }
        return null;
    }

    public static TPDrmCapAttribute[] getDrmCapAttributes() throws TPLoadLibraryException {
        return TPDrmCapabilityImpl.getDrmCapAttributes();
    }

    public static int getDrmCapability(int i3) throws TPLoadLibraryException {
        return TPDrmCapabilityImpl.getDrmCapability(i3);
    }
}
