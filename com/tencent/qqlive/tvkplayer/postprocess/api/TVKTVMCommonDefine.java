package com.tencent.qqlive.tvkplayer.postprocess.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKTVMCommonDefine {
    public static final int TVK_TVMSR_TYPE_480P = 2;
    public static final int TVK_TVMSR_TYPE_720P = 4;
    public static final int TVK_TVMSR_TYPE_INVALID = 0;
    public static final int TVMSR_CAPABILITY_CODE_SUPPORT = 0;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_BLACK_DEVICE = 1004;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_DOWNLOAD_FAILED = 1007;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_LIBRARY_BLACK_DEVICE = 2002;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_LIBRARY_DOWNLOAD_FAILED = 2004;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_LIBRARY_NOT_READY = 2003;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_MODEL_NOT_READY = 1005;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_REFLECT_ERROR = 2001;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_RESOLUTION_MISMATCH = 1006;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_TVK_BLACK_CHIP = 1003;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_TVK_BLACK_DEVICE = 1002;
    public static final int TVMSR_CAPABILITY_CODE_UNSUPPORT_TVK_CONFIG = 1001;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_1080P = 16;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_270P = 1;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_480P = 2;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_540P = 4;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_720P = 8;
    public static final int TVM_SUPER_RESOLUTION_SUPPORT_NONE = 0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface MonetTVMResolutionType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface MonetTVMSRCapabilityCode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface MonetTVMSRType {
    }
}
