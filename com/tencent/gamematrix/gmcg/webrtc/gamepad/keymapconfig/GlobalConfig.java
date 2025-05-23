package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.graphics.PointF;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.TVKeyMapMsg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GlobalConfig {
    public static final int GAME_TYPE_BIT_MAX = 16;
    public static final int GAME_TYPE_BIT_MIN = 1;
    public static final float JoystickAxisCenter = 0.0f;
    public static final float JoystickAxisMax = 1.0f;
    private static int kGameControllerId;
    private CloudDeviceCofing mCloudDeviceCofing;
    private int mGameType;
    private boolean mGameTypeMixedKeyMapEnabled;
    private boolean mGamepadPerfMonitorEnable;
    private boolean mIsGlobalConfigLoaded;
    private boolean mIsKeyTrackMenuEnabled;
    private boolean mIsNeedLogin;
    private boolean mIsSupportKeyTrack;
    private boolean mIsSupportMonitor;
    private boolean mIsSupportTGPA;
    private boolean mIsUseGamepadPidVidConfig;
    private boolean mIsUseGamepadPrivateEvent;
    private int mMaxPlayerNum;
    private int mNativeInputProtocolType;
    private int[] mProductIds;
    private int[] mVendorIds;
    private int mVirtualGamePadType;
    public static PointF kSGameSkillCancelPos = new PointF(0.912f, 0.177f);
    public static PointF kTouchMapPos = new PointF(0.0f, 0.0f);
    public static float kTouchMapSensitivityX = 1.0f;
    public static float kTouchMapSensitivityY = 1.0f;
    public static boolean kIsJoystickToMove = false;
    public static int JoystickViewRadiusMin = 8;
    public static int JoystickViewRadiusMid = 12;
    public static int JoystickViewRadiusMax = 24;
    public static float AxisSensitivityLevelMid = 0.6f;
    public static float AxisSensitivityLevelMax = 0.9f;
    public static boolean IsLongPressForMenu = true;
    public static int MenuKeyCodeForGamepad = 108;
    public static int MenuModeKeyCodeForTVController = 23;
    public static float TVJoystickAxisCenter = 0.0f;
    public static float TVJoystickAxis = 0.5f;
    public static boolean IsLongPressForSwitchMode = false;
    public static int KeyMapSwitchModeKeyCodeForGamepad = 107;
    public static int KeyMapSwitchModeKeyCodeForTVController = 25;
    public static float PubgSprintMoveAbsValueRangle = 0.3f;
    public static int PubgSprintMoveRadius = 500;
    public static float PubgSprintMovePercentX = 0.1796875f;
    public static float PubgSprintMovePercentY = 0.2916667f;
    public static boolean IsOpenMFGamepad = false;
    private static volatile GlobalConfig sGlobalConfig = null;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CloudDeviceCofing {
        public static final int CLOUD_CREATE_FLAG_FORCE_CREATE = 1;
        public static final int CLOUD_CREATE_FLAG_FORCE_DONT_CREATE = 2;
        int mAddedGamepaCreateMaxSize;
        int mAddedTVControllerCreateMaxSize;
        List<CloudPassDeviceConfig> mCloudPassDeviceConfigs;
        int mConnectedGamepadCreateMaxSize;
        int mConnectedTVControllerCreateMaxSize;
        int mCreateCloudDeviceFlag;
        int[] mInitCloudDeviceIds;
        boolean mIsCheckDeviceMapIndex;
        boolean mIsPassProduct0Vendor0;
        boolean mIsPassProduct1Vendor1;
        boolean mIsUniqueDeviceByVendorProduct;
        int mMapMode;

        public CloudDeviceCofing() {
            reset();
        }

        public void reset() {
            this.mMapMode = 0;
            this.mIsCheckDeviceMapIndex = false;
            this.mCreateCloudDeviceFlag = 0;
            this.mConnectedGamepadCreateMaxSize = 0;
            this.mConnectedTVControllerCreateMaxSize = 0;
            this.mAddedGamepaCreateMaxSize = 0;
            this.mAddedTVControllerCreateMaxSize = 0;
            this.mIsUniqueDeviceByVendorProduct = true;
            this.mIsPassProduct0Vendor0 = true;
            this.mIsPassProduct1Vendor1 = true;
            this.mInitCloudDeviceIds = r1;
            int[] iArr = {0};
            List<CloudPassDeviceConfig> list = this.mCloudPassDeviceConfigs;
            if (list != null) {
                list.clear();
            } else {
                this.mCloudPassDeviceConfigs = new ArrayList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CloudPassDeviceConfig {
        int mPassLevel = 0;
        int mProductId = 0;
        int mVendorId = 0;
        String mDeviceName = null;
    }

    GlobalConfig() {
        if (sGlobalConfig == null) {
            kGameControllerId = 1;
            if (this.mCloudDeviceCofing == null) {
                this.mCloudDeviceCofing = new CloudDeviceCofing();
            }
            reset();
            return;
        }
        throw new RuntimeException("already construct!");
    }

    public static GlobalConfig getInstance() {
        if (sGlobalConfig == null) {
            synchronized (KeyMapConfigManager.class) {
                if (sGlobalConfig == null) {
                    sGlobalConfig = new GlobalConfig();
                }
            }
        }
        return sGlobalConfig;
    }

    public static void releaseGlobalConfig() {
        resetGlobalConfig();
        sGlobalConfig = null;
        CGLog.i("[globalconfig] release global config.");
    }

    private void reset() {
        this.mGameTypeMixedKeyMapEnabled = false;
        this.mIsGlobalConfigLoaded = false;
        this.mIsSupportTGPA = false;
        this.mIsSupportMonitor = false;
        this.mIsUseGamepadPrivateEvent = false;
        this.mIsUseGamepadPidVidConfig = false;
        this.mVirtualGamePadType = -1;
        this.mGamepadPerfMonitorEnable = false;
        this.mIsSupportKeyTrack = false;
        this.mIsKeyTrackMenuEnabled = false;
        this.mGameType = 1;
        this.mNativeInputProtocolType = 0;
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            cloudDeviceCofing.reset();
        }
    }

    public static void resetGlobalConfig() {
        if (sGlobalConfig != null) {
            sGlobalConfig.reset();
        }
        CGLog.i("[globalconfig] reset global config.");
    }

    public int getCreateCloudDeviceMaxSize(int i3) {
        if (i3 != 2 && i3 != 4) {
            if (i3 == 3) {
                return this.mCloudDeviceCofing.mConnectedTVControllerCreateMaxSize;
            }
            if (i3 == 1) {
                CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
                return cloudDeviceCofing.mConnectedTVControllerCreateMaxSize + cloudDeviceCofing.mConnectedGamepadCreateMaxSize;
            }
            return 0;
        }
        return this.mCloudDeviceCofing.mConnectedGamepadCreateMaxSize;
    }

    public int getGameType() {
        return this.mGameType;
    }

    public int[] getInitCloudDeviceIds() {
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            return cloudDeviceCofing.mInitCloudDeviceIds;
        }
        return null;
    }

    public int getMaxPlayerNum() {
        return this.mMaxPlayerNum;
    }

    public int getNativeInputProtocolType() {
        return this.mNativeInputProtocolType;
    }

    public int getNextId() {
        int i3 = kGameControllerId;
        kGameControllerId = i3 + 1;
        return i3 % 200000;
    }

    public CloudPassDeviceConfig getPassDeviceConfig(int i3, int i16, String str) {
        List<CloudPassDeviceConfig> list;
        String str2;
        String str3;
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null && (list = cloudDeviceCofing.mCloudPassDeviceConfigs) != null) {
            for (CloudPassDeviceConfig cloudPassDeviceConfig : list) {
                if (cloudPassDeviceConfig != null) {
                    int i17 = cloudPassDeviceConfig.mPassLevel;
                    if (i17 == 0) {
                        if (cloudPassDeviceConfig.mVendorId == i3 && cloudPassDeviceConfig.mProductId == i16 && (str2 = cloudPassDeviceConfig.mDeviceName) != null && str != null && str.equals(str2)) {
                            return cloudPassDeviceConfig;
                        }
                    } else if (i17 == 1) {
                        if (cloudPassDeviceConfig.mVendorId == i3 && cloudPassDeviceConfig.mProductId == i16) {
                            return cloudPassDeviceConfig;
                        }
                    } else if (i17 == 2) {
                        if (cloudPassDeviceConfig.mVendorId == i3) {
                            return cloudPassDeviceConfig;
                        }
                    } else if (i17 == 3 && (str3 = cloudPassDeviceConfig.mDeviceName) != null && str != null && str.equals(str3)) {
                        return cloudPassDeviceConfig;
                    }
                }
            }
        }
        return null;
    }

    public int[] getUsbProductIds() {
        return this.mProductIds;
    }

    public int[] getUsbVendorIds() {
        return this.mVendorIds;
    }

    public int getVirtualGamePadType() {
        return this.mVirtualGamePadType;
    }

    public boolean hasSceneConfig() {
        int i3 = this.mGameType;
        if (i3 != 2 && i3 != 16) {
            return false;
        }
        return true;
    }

    public boolean isCreateCloudDevice() {
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            int i3 = cloudDeviceCofing.mCreateCloudDeviceFlag;
            if (i3 == 1) {
                return true;
            }
            if (i3 == 2) {
                return false;
            }
        }
        int i16 = this.mGameType;
        if (i16 != 4 && i16 != 8) {
            return false;
        }
        return true;
    }

    public boolean isGameTypeMixedKeyMapEnabled() {
        return this.mGameTypeMixedKeyMapEnabled;
    }

    public boolean isGamepadGameType() {
        if (this.mGameType == 4) {
            return true;
        }
        return false;
    }

    public boolean isGamepadPerfMonitorEnable() {
        return this.mGamepadPerfMonitorEnable;
    }

    public boolean isKeyTracMenukEnabled() {
        return this.mIsKeyTrackMenuEnabled;
    }

    public boolean isNeedLogin() {
        return this.mIsNeedLogin;
    }

    public boolean isPassProduct0Vendor0() {
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            return cloudDeviceCofing.mIsPassProduct0Vendor0;
        }
        return false;
    }

    public boolean isPassProduct1Vendor1() {
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            return cloudDeviceCofing.mIsPassProduct1Vendor1;
        }
        return false;
    }

    public boolean isSendNativeEventToGame() {
        int i3 = this.mGameType;
        if (i3 == 4 || i3 == 8) {
            return true;
        }
        if (i3 == 16 && !isGameTypeMixedKeyMapEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isSupportKeyTrack() {
        return this.mIsSupportKeyTrack;
    }

    public boolean isSupportMonitor() {
        return this.mIsSupportMonitor;
    }

    public boolean isSupportTGPA() {
        return this.mIsSupportTGPA;
    }

    public boolean isTVControllerGameType() {
        if (this.mGameType == 8) {
            return true;
        }
        return false;
    }

    public boolean isUniqueDeviceByVendorProduct() {
        CloudDeviceCofing cloudDeviceCofing = this.mCloudDeviceCofing;
        if (cloudDeviceCofing != null) {
            return cloudDeviceCofing.mIsUniqueDeviceByVendorProduct;
        }
        return false;
    }

    public boolean isUseGamepadPidVidConfig() {
        return this.mIsUseGamepadPidVidConfig;
    }

    public boolean isUseGamepadPrivateEvent() {
        return this.mIsUseGamepadPrivateEvent;
    }

    public boolean loadGlobalConfig(TVKeyMapMsg.TVMsgGameConfig tVMsgGameConfig) {
        int i3;
        CloudDeviceCofing cloudDeviceCofing;
        boolean z16 = false;
        if (tVMsgGameConfig == null) {
            return false;
        }
        this.mIsSupportTGPA = tVMsgGameConfig.tgpa_support;
        this.mIsSupportMonitor = false;
        if (tVMsgGameConfig.is_necessary_to_login == 1) {
            z16 = true;
        }
        this.mIsNeedLogin = z16;
        this.mMaxPlayerNum = tVMsgGameConfig.max_number_of_player;
        this.mIsUseGamepadPrivateEvent = tVMsgGameConfig.gamepad_private_data_enable;
        this.mIsUseGamepadPidVidConfig = tVMsgGameConfig.gamepad_pid_vid_enable;
        this.mProductIds = tVMsgGameConfig.product_ids;
        this.mVendorIds = tVMsgGameConfig.vendor_ids;
        this.mVirtualGamePadType = tVMsgGameConfig.virtual_gamepad_type;
        int i16 = tVMsgGameConfig.game_type_bit;
        if (1 <= i16 && i16 <= 16) {
            i3 = 1 << i16;
        } else {
            i3 = tVMsgGameConfig.game_type;
            if (i3 == 1) {
                i3 = 2;
            } else if (i3 == 2) {
                i3 = 4;
            } else if (i3 == 3 || i3 == 4) {
                i3 = 8;
            }
        }
        this.mGameType = i3;
        this.mNativeInputProtocolType = tVMsgGameConfig.native_input_protocol_type;
        this.mGamepadPerfMonitorEnable = tVMsgGameConfig.gamepad_perf_monitor_enable;
        this.mIsSupportKeyTrack = tVMsgGameConfig.key_tracking_enable;
        TVKeyMapMsg.TVCloudDeviceConfig tVCloudDeviceConfig = tVMsgGameConfig.cloud_device_config;
        if (tVCloudDeviceConfig != null && (cloudDeviceCofing = this.mCloudDeviceCofing) != null) {
            cloudDeviceCofing.mMapMode = tVCloudDeviceConfig.map_mode;
            cloudDeviceCofing.mIsCheckDeviceMapIndex = tVCloudDeviceConfig.is_check_device_map_index;
            cloudDeviceCofing.mCreateCloudDeviceFlag = tVCloudDeviceConfig.create_cloud_device_flag;
            boolean z17 = tVCloudDeviceConfig.is_unique_device_by_vendor_product;
            cloudDeviceCofing.mIsUniqueDeviceByVendorProduct = z17;
            cloudDeviceCofing.mConnectedGamepadCreateMaxSize = tVCloudDeviceConfig.connected_gamepad_create_max_size;
            cloudDeviceCofing.mConnectedTVControllerCreateMaxSize = tVCloudDeviceConfig.connected_tv_controller_create_max_size;
            cloudDeviceCofing.mAddedGamepaCreateMaxSize = tVCloudDeviceConfig.added_gamepad_create_max_size;
            cloudDeviceCofing.mAddedTVControllerCreateMaxSize = tVCloudDeviceConfig.added_tv_controller_create_max_size;
            cloudDeviceCofing.mIsUniqueDeviceByVendorProduct = z17;
            cloudDeviceCofing.mIsPassProduct0Vendor0 = tVCloudDeviceConfig.is_pass_product_0_vendor_0;
            cloudDeviceCofing.mIsPassProduct1Vendor1 = tVCloudDeviceConfig.is_pass_product_1_vendor_1;
            cloudDeviceCofing.mInitCloudDeviceIds = tVCloudDeviceConfig.init_cloud_device_ids;
            List<TVKeyMapMsg.PassInputDevice> list = tVCloudDeviceConfig.pass_input_devices;
            if (list != null && cloudDeviceCofing.mCloudPassDeviceConfigs != null) {
                for (TVKeyMapMsg.PassInputDevice passInputDevice : list) {
                    if (passInputDevice != null) {
                        CloudPassDeviceConfig cloudPassDeviceConfig = new CloudPassDeviceConfig();
                        cloudPassDeviceConfig.mPassLevel = passInputDevice.pass_level;
                        cloudPassDeviceConfig.mProductId = passInputDevice.product_id;
                        cloudPassDeviceConfig.mVendorId = passInputDevice.vendor_id;
                        cloudPassDeviceConfig.mDeviceName = passInputDevice.device_name;
                        this.mCloudDeviceCofing.mCloudPassDeviceConfigs.add(cloudPassDeviceConfig);
                    }
                }
            }
        }
        this.mIsGlobalConfigLoaded = true;
        return true;
    }

    public void setGameTypeMixedKeyMapEnabled(boolean z16) {
        this.mGameTypeMixedKeyMapEnabled = z16;
    }

    public void setKeyTracMenukEnabled(boolean z16) {
        this.mIsKeyTrackMenuEnabled = z16;
    }
}
