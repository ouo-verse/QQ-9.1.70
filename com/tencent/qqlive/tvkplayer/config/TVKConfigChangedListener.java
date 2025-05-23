package com.tencent.qqlive.tvkplayer.config;

import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigChangedListener;
import com.tencent.qqlive.tvkplayer.tools.config.TVKDVMARequester;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.capability.TPHdrCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKConfigChangedListener implements ITVKConfigChangedListener {
    private static final String TAG = "TVKPlayer[TVKConfigChangedListener]";

    private void addDeviceToDecoderCapabilityConfig() {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_dolby_audio_mediacodec) {
            try {
                TPDecoderCapability.addCustomizedAudioMediaCodecCapability(5040, 0);
            } catch (TPLoadLibraryException | IllegalArgumentException e16) {
                TVKLogUtil.e(TAG, "[updateTPPConfig] Fails to update dolby audio mediacodec blacklist: " + e16);
            }
        }
    }

    private void addDeviceToDolbyVisionCapabilityConfig() {
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.dolby_hard_render_device_black_list)) {
            try {
                TPHdrCapability.addCustomizedHdrCapability(2, 1, 0);
            } catch (TPLoadLibraryException e16) {
                TVKLogUtil.e(TAG, "addCustomizedHdrMediaCodecCapability failed, exception: " + e16);
            }
        }
    }

    private void addDeviceToHdrVividCapabilityConfig() {
        if (TVKTPCapability.isModelInHdrVividList(TVKMediaPlayerConfig.PlayerConfig.hdrvivid_white_list, "HDRVivid \u539f\u751f\u6e32\u67d3\u652f\u6301\u767d\u540d\u5355")) {
            try {
                TPHdrCapability.addCustomizedHdrCapability(4, 1, 1);
            } catch (TPLoadLibraryException e16) {
                TVKLogUtil.e(TAG, "addCustomizedHdrMediaCodecCapability failed, exception: " + e16);
            }
        }
        if (TVKTPCapability.isModelInHdrVividList(TVKMediaPlayerConfig.PlayerConfig.hdrvivid_black_list, "HDRVivid \u539f\u751f\u6e32\u67d3\u4e0d\u652f\u6301\u9ed1\u540d\u5355")) {
            try {
                TPHdrCapability.addCustomizedHdrCapability(4, 1, 0);
            } catch (TPLoadLibraryException e17) {
                TVKLogUtil.e(TAG, "addCustomizedHdrMediaCodecCapability failed, exception: " + e17);
            }
        }
        if (TVKTPCapability.isModelInHdrVividList(TVKMediaPlayerConfig.PlayerConfig.hdrvivid_mediacodec_white_list, "HDRVivid \u81ea\u7814\u6e32\u67d3\u767d\u540d\u5355")) {
            try {
                TPHdrCapability.addCustomizedHdrCapability(4, 2, 1);
            } catch (TPLoadLibraryException e18) {
                TVKLogUtil.e(TAG, "addCustomizedHdrVividCustomRenderCapability failed, exception: " + e18);
            }
        }
    }

    private void updateFFmpegLogPthreadLocalStoragePropertyIfNeeded() {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_ffmpeg_log_pthread_local_storage) {
            TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_FFMPEG_LOG_PTHREAD_LOCAL_STORAGE, true));
        }
    }

    private void updateTPPConfig() {
        TVKLogUtil.i(TAG, "[updateTPPConfig] Updating ThumbPlayer config.");
        TVKCapabilityMgr.getInstance().reset();
        addDeviceToHdrVividCapabilityConfig();
        addDeviceToDolbyVisionCapabilityConfig();
        addDeviceToDecoderCapabilityConfig();
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT, TVKMediaPlayerConfig.PlayerConfig.tp_player_report_enable));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT, TVKMediaPlayerConfig.PlayerConfig.is_thumbplayer_reportv2_on));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDR_DOWNWARD_COMPATIBILITY, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_downward_compatibility));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_SOFT_DYNAMIC_MAPPING, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_software_dynamic_mapping));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_HARD_DYNAMIC_MAPPING, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_hardware_dynamic_mapping));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_CAPABILITY_MODEL, TVKMediaPlayerConfig.PlayerConfig.enable_new_capability));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_LOOPBACK, TVKMediaPlayerConfig.PlayerConfig.enable_new_loopback));
        updateFFmpegLogPthreadLocalStoragePropertyIfNeeded();
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigChangedListener
    public void onConfigChanged() {
        updateTPPConfig();
        TVKDVMARequester.getInstance().requestOnlineConfigAsync(new ITVKConfigChangedListener() { // from class: com.tencent.qqlive.tvkplayer.config.TVKConfigChangedListener.1
            @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigChangedListener
            public void onConfigChanged() {
                TVKCapabilityMgr.getInstance().resetHQVideoCapability();
            }
        });
    }
}
