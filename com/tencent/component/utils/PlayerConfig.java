package com.tencent.component.utils;

import com.tencent.component.core.storage.StorageCenter;

/* loaded from: classes5.dex */
public class PlayerConfig {
    public static final String KEY_CURRENT_SDK_TYPE = "current_sdk_type";
    public static final String KEY_SERVER_SDK_TYPE = "server_sdk_type";

    /* loaded from: classes5.dex */
    public @interface SdkType {
        public static final int VALUE_DEFAULT = 0;
        public static final int VALUE_FLV = 4;
        public static final int VALUE_OPEN_SDK = 1;
        public static final int VALUE_TRTC_SDK = 3;
    }

    public static int getCurrentSdkType() {
        return StorageCenter.getInt(KEY_CURRENT_SDK_TYPE, 0);
    }

    public static int getServerSdkType() {
        return StorageCenter.getInt(KEY_SERVER_SDK_TYPE, 0);
    }

    public static boolean isTrtcPlayer() {
        if (3 == getCurrentSdkType()) {
            return true;
        }
        return false;
    }

    public static void resetSdkTypeAsDefault() {
        StorageCenter.putInt(KEY_CURRENT_SDK_TYPE, 0);
    }

    public static void saveSdkType(@SdkType int i3) {
        StorageCenter.putInt(KEY_CURRENT_SDK_TYPE, i3);
    }

    public static void saveSdkTypeAsFlv() {
        StorageCenter.putInt(KEY_CURRENT_SDK_TYPE, 4);
    }

    public static void saveSdkTypeAsOpenSdk() {
        StorageCenter.putInt(KEY_CURRENT_SDK_TYPE, 1);
    }

    public static void saveSdkTypeAsTrtc() {
        StorageCenter.putInt(KEY_CURRENT_SDK_TYPE, 3);
    }

    public static void saveServerSdkType(int i3) {
        StorageCenter.putInt(KEY_SERVER_SDK_TYPE, i3);
    }
}
