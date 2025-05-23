package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoDebugSettingImpl implements IShortVideoDebugSetting {
    private static final String KEY_AIO_USE_ASYNC_HARDWARE_VIDEO_COMPRESS = "aio_use_async_hardware_video_compress";
    private static final String KEY_RICH_MEDIA_PATH_DEBUG_TOOL = "rich_media_path_debug_tool";
    private static final String KEY_SHOW_AIO_VIDEO_DEBUG_INFO = "show_aio_video_debug_info";
    private static final String KEY_SIMULATE_FORWARD_VIDEO_NOT_EXISTS_ON_SERVER = "simulate_forward_video_not_exists_on_server";

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public boolean isAIOUseAsyncHardwareVideoCompress() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(KEY_AIO_USE_ASYNC_HARDWARE_VIDEO_COMPRESS, false);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public boolean isRichMediaPathDebugToolEnable() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(KEY_RICH_MEDIA_PATH_DEBUG_TOOL, false);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public boolean isShowAIOVideoViewDebugInfo() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(KEY_SHOW_AIO_VIDEO_DEBUG_INFO, false);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public boolean isSimulateForwardVideoNotExistsOnServer() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(KEY_SIMULATE_FORWARD_VIDEO_NOT_EXISTS_ON_SERVER, false);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public void setAIOUseAsyncHardwareVideoCompress(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(KEY_AIO_USE_ASYNC_HARDWARE_VIDEO_COMPRESS, z16);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public void setRichMediaPathDebugToolEnable(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(KEY_RICH_MEDIA_PATH_DEBUG_TOOL, z16);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public void setShowAIOVideoViewDebugInfo(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(KEY_SHOW_AIO_VIDEO_DEBUG_INFO, z16);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting
    public void setSimulateForwardVideoNotExistsOnServer(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(KEY_SIMULATE_FORWARD_VIDEO_NOT_EXISTS_ON_SERVER, z16);
    }
}
