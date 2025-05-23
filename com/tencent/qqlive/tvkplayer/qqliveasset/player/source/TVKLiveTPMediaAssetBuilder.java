package com.tencent.qqlive.tvkplayer.qqliveasset.player.source;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;

/* loaded from: classes23.dex */
public class TVKLiveTPMediaAssetBuilder {
    protected TVKPlayerVideoInfo mPlayerVideoInfo = null;
    protected String mInputDefinition = "";
    protected String mFlowId = "";
    protected TVKLiveVideoInfo mLiveVideoInfo = null;
    protected String mPlayableUrl = "";
    protected String[] mPlayableBackupUrls = null;

    private void addDataTransportTaskParams(ITPMediaAsset iTPMediaAsset) {
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_IS_PREVIEW, String.valueOf(this.mLiveVideoInfo.isPreview()));
        iTPMediaAsset.setParam("task_file_type", String.valueOf(convertStreamTypeToFileType(this.mLiveVideoInfo.getStream())));
        iTPMediaAsset.setParam("dl_param_play_keyid", this.mLiveVideoInfo.getVid());
        iTPMediaAsset.setParam("dl_param_play_definition", this.mInputDefinition);
        iTPMediaAsset.setParam("dl_param_current_format", this.mLiveVideoInfo.getCurDefinition().getDefn());
        iTPMediaAsset.setParam("dl_param_enable_expand_download_url", String.valueOf(!this.mLiveVideoInfo.isFreeNetFlowUrl()));
        iTPMediaAsset.setParam("dl_param_vinfo_fp2p", String.valueOf(this.mLiveVideoInfo.getFp2p()));
        iTPMediaAsset.setParam("dl_param_vinfo_cdn_origin", String.valueOf(this.mLiveVideoInfo.getCdnOrigin()));
        iTPMediaAsset.setParam("dl_param_expect_delay_time", String.valueOf(this.mLiveVideoInfo.getExpectDelaySec() * 1000));
        iTPMediaAsset.setParam("dl_param_play_flowid", this.mFlowId);
        iTPMediaAsset.setParam("dl_param_encrypt_stream_key", this.mLiveVideoInfo.getDecKey());
        iTPMediaAsset.setParam("dl_param_encrypt_stream_randoms", this.mLiveVideoInfo.getRandoms());
        iTPMediaAsset.setParam("dl_param_nonce", this.mLiveVideoInfo.getNonce());
        iTPMediaAsset.setParam("dl_param_vinfo_request_platform", TVKVersion.getPlatform());
        iTPMediaAsset.setParam("dl_param_vinfo_request_app_ver", TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext()));
        if (this.mLiveVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC) {
            iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_INT_VINFO_FROM_TYPE, "1");
        }
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            iTPMediaAsset.setParam("xp2p_key", tVKPlayerVideoInfo.getConfigMapValue("xp2p_key", ""));
            iTPMediaAsset.setParam("task_biz_id", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_DOWNLOAD_PROXY_BIZ_ID, ""));
        }
    }

    private int convertStreamTypeToFileType(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return 0;
            }
            return 5;
        }
        return 16;
    }

    private ITPUrlMediaAsset generateDefaultUrlMediaAsset() {
        return TPMediaAssetFactory.createUrlMediaAsset(this.mPlayableUrl);
    }

    private ITPDrmMediaAsset generateDrmMediaAsset() {
        String str = this.mPlayableUrl;
        String drmCkc = this.mLiveVideoInfo.getDrmCkc();
        String str2 = "";
        if (!TextUtils.isEmpty(drmCkc)) {
            str2 = drmCkc.replaceAll("\\|$", "");
        }
        int drm = this.mLiveVideoInfo.getCurDefinition().getDrm();
        if (drm != 2) {
            if (drm != 5) {
                if (drm != 7) {
                    return TPMediaAssetFactory.createDrmMediaAsset(str, -1, null, null);
                }
                return TPMediaAssetFactory.createDrmMediaAsset(str, 3, null, str2);
            }
            ITPDrmMediaAsset createDrmMediaAsset = TPMediaAssetFactory.createDrmMediaAsset(str, 0, TVKMediaPlayerConfig.PlayerConfig.widevine_provision_url, str2);
            createDrmMediaAsset.setParam(ITPDrmMediaAsset.TP_ASSET_PARAM_KEY_BOOL_LICENSE_STANDARDIZATION, String.valueOf(true));
            return createDrmMediaAsset;
        }
        return TPMediaAssetFactory.createDrmMediaAsset(str, 2, null, null);
    }

    private ITPUrlMediaAsset generateUrlMediaAsset() {
        ITPUrlMediaAsset generateDefaultUrlMediaAsset;
        if (!TextUtils.isEmpty(this.mPlayableUrl)) {
            if (isDrmVideo()) {
                generateDefaultUrlMediaAsset = generateDrmMediaAsset();
            } else {
                generateDefaultUrlMediaAsset = generateDefaultUrlMediaAsset();
            }
            generateDefaultUrlMediaAsset.setHttpHeader(this.mLiveVideoInfo.getCdnHttpHeaders());
            addDataTransportTaskParams(generateDefaultUrlMediaAsset);
            for (String str : this.mPlayableBackupUrls) {
                generateDefaultUrlMediaAsset.addBackUrl(str, this.mLiveVideoInfo.getCdnHttpHeaders());
            }
            return generateDefaultUrlMediaAsset;
        }
        throw new IllegalArgumentException("Url is empty");
    }

    private boolean isDrmVideo() {
        TVKNetVideoInfo.DefnInfo curDefinition = this.mLiveVideoInfo.getCurDefinition();
        if (curDefinition == null) {
            return false;
        }
        int drm = curDefinition.getDrm();
        if (drm != 5 && drm != 7 && drm != 2) {
            return false;
        }
        return true;
    }

    public static TVKLiveTPMediaAssetBuilder newBuilder() {
        return new TVKLiveTPMediaAssetBuilder();
    }

    private void setDaTongReportParam(ITPMediaAsset iTPMediaAsset) {
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_PLAY_SCENE_TYPE, "normal");
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_VID, this.mLiveVideoInfo.getVid());
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_FLOWID, this.mFlowId);
    }

    public ITPMediaAsset build() throws IllegalArgumentException {
        if (this.mLiveVideoInfo != null) {
            initPlayableUrls();
            ITPUrlMediaAsset generateUrlMediaAsset = generateUrlMediaAsset();
            setDaTongReportParam(generateUrlMediaAsset);
            return generateUrlMediaAsset;
        }
        throw new IllegalArgumentException("Live video info is null");
    }

    public TVKLiveTPMediaAssetBuilder flowId(String str) {
        this.mFlowId = str;
        return this;
    }

    protected void initPlayableUrls() {
        this.mPlayableUrl = this.mLiveVideoInfo.getPlayUrl();
        this.mPlayableBackupUrls = this.mLiveVideoInfo.getBackPlayUrl();
    }

    public TVKLiveTPMediaAssetBuilder inputDefinition(String str) {
        this.mInputDefinition = str;
        return this;
    }

    public TVKLiveTPMediaAssetBuilder liveVideoInfo(TVKLiveVideoInfo tVKLiveVideoInfo) {
        this.mLiveVideoInfo = tVKLiveVideoInfo;
        return this;
    }

    public TVKLiveTPMediaAssetBuilder playerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayerVideoInfo = tVKPlayerVideoInfo;
        return this;
    }
}
