package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.capability.TPHdrCapabilityImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPHdrCapability {
    public static final int TP_HDR_CAP_NOT_SUPPORT = 0;
    public static final int TP_HDR_CAP_SUPPORT = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPHdrCap {
    }

    public static void addCustomizedHdrCapability(int i3, int i16, int i17) throws TPLoadLibraryException {
        TPHdrCapabilityImpl.addCustomizedHdrCapability(i3, i16, i17);
    }

    public static TPHdrCapAttribute getHdrCapAttribute(int i3) throws TPLoadLibraryException {
        return TPHdrCapabilityImpl.getHdrCapAttribute(i3);
    }

    public static int getHdrCapability(int i3) throws TPLoadLibraryException {
        return TPHdrCapabilityImpl.getHdrCapability(i3);
    }

    public static TPHdrCapAttribute getHdrCapAttribute(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams) throws TPLoadLibraryException {
        return TPHdrCapabilityImpl.getHdrCapAttribute(tPHdrCapabilityQueryParams);
    }

    public static int getHdrCapability(TPHdrCapabilityQueryParams tPHdrCapabilityQueryParams) throws TPLoadLibraryException {
        return TPHdrCapabilityImpl.getHdrCapability(tPHdrCapabilityQueryParams);
    }
}
