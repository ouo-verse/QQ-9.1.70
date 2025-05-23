package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.utils.TPNativeLog;

/* loaded from: classes26.dex */
public class TPHDRCapabilityConfig {
    private static final String TAG = "TPHDRCapabilityConfig";

    public static boolean getHdrVividDownwardHDR10CompatibilityEnable() {
        try {
            return native_getHdrVividDownwardHDR10CompatibilityEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getHdrDownwardCompatibilityEnable " + e16.getMessage());
            return false;
        }
    }

    public static boolean getHdrVividHardDynamicMappingEnable() {
        try {
            return native_getHdrVividHardDynamicMappingEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getHdrVividHardDynamicMappingEnable " + e16.getMessage());
            return false;
        }
    }

    public static boolean getHdrVividSoftDynamicMappingEnable() {
        try {
            return native_getHdrVividSoftDynamicMappingEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getHdrVividSoftDynamicMappingEnable " + e16.getMessage());
            return false;
        }
    }

    public static boolean getHdrVividSoftOESTextureRenderEnable() {
        try {
            return native_getHdrVividSoftOESTextureRenderEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getHdrVividSoftOESTextureRenderEnable " + e16.getMessage());
            return false;
        }
    }

    public static boolean getHdrVividSoftSdrDynamicMappingEnable() {
        try {
            return native_getHdrVividSoftSdrDynamicMappingEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getHdrVividSoftSdrDynamicMappingEnable " + e16.getMessage());
            return false;
        }
    }

    private static native boolean native_getHdrVividDownwardHDR10CompatibilityEnable();

    private static native boolean native_getHdrVividHardDynamicMappingEnable();

    private static native boolean native_getHdrVividSoftDynamicMappingEnable();

    private static native boolean native_getHdrVividSoftOESTextureRenderEnable();

    private static native boolean native_getHdrVividSoftSdrDynamicMappingEnable();
}
