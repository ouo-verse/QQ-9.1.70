package com.tencent.qqlive.tvkplayer.qqliveasset.player.source;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMediaAssetParamMap;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKVodTPMediaAssetBuilder {
    private static final String FILE_ID_POSTFIX_HLS = ".hls";
    private static final String INVALID_RESOLUTION = "null";
    private TVKPlayerVideoInfo mPlayerVideoInfo = null;
    private String mInputDefinition = "";
    private long mStartPositionMs = 0;
    private long mSkipEndPositionMs = 0;
    private String mFlowId = "";
    private TVKVodVideoInfo mVodVideoInfo = null;

    TVKVodTPMediaAssetBuilder() {
    }

    private void addDataTransportTaskParams(ITPMediaAsset iTPMediaAsset) {
        long j3;
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_IS_PREVIEW, String.valueOf(this.mVodVideoInfo.isPreview()));
        iTPMediaAsset.setParam("dl_param_play_definition", this.mInputDefinition);
        TVKVodVideoInfo.SimulatedLiveInfo simulatedLiveInfo = this.mVodVideoInfo.getSimulatedLiveInfo();
        if (!simulatedLiveInfo.getVidList().isEmpty()) {
            j3 = simulatedLiveInfo.getCurrentPositionSec() * 1000;
        } else {
            j3 = this.mStartPositionMs;
        }
        iTPMediaAsset.setParam("dl_param_play_start_time", String.valueOf(j3));
        iTPMediaAsset.setParam("dl_param_play_end_time", String.valueOf(this.mSkipEndPositionMs));
        iTPMediaAsset.setParam("dl_param_current_format", this.mVodVideoInfo.getSelectedDefn());
        iTPMediaAsset.setParam("dl_param_current_formatid", String.valueOf(this.mVodVideoInfo.getSelectedDefnId()));
        iTPMediaAsset.setParam("dl_param_play_keyid", generateFileId());
        iTPMediaAsset.setParam("dl_param_vid", this.mVodVideoInfo.getVid());
        iTPMediaAsset.setParam("dl_param_file_size", String.valueOf(this.mVodVideoInfo.getSelectedFileSizeByte()));
        iTPMediaAsset.setParam("dl_param_file_duration", String.valueOf(this.mVodVideoInfo.getDurationSec() * 1000));
        iTPMediaAsset.setParam("dl_param_url_expire_time", String.valueOf(this.mVodVideoInfo.getCt()));
        boolean z16 = true;
        iTPMediaAsset.setParam("dl_param_enable_expand_download_url", String.valueOf(!this.mVodVideoInfo.isFreeNetFlowUrl()));
        iTPMediaAsset.setParam("dl_param_vinfo_base", this.mVodVideoInfo.getBase());
        iTPMediaAsset.setParam("dl_param_vinfo_m3u8", this.mVodVideoInfo.getM3u8());
        iTPMediaAsset.setParam("dl_param_vinfo_link_vid", this.mVodVideoInfo.getLnk());
        iTPMediaAsset.setParam("dl_param_vinfo_fp2p", String.valueOf(this.mVodVideoInfo.getFp2p()));
        iTPMediaAsset.setParam("dl_param_vinfo_testid", String.valueOf(this.mVodVideoInfo.getTestId()));
        iTPMediaAsset.setParam("dl_param_vinfo_tm", String.valueOf(this.mVodVideoInfo.getTm()));
        iTPMediaAsset.setParam("dl_param_band_width_level", String.valueOf(this.mVodVideoInfo.getBandwidthLevel()));
        iTPMediaAsset.setParam("dl_param_vinfo_request_platform", TVKVersion.getPlatform());
        iTPMediaAsset.setParam("dl_param_vinfo_request_app_ver", TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext()));
        if (this.mVodVideoInfo.getMasterM3u8Info() != null) {
            iTPMediaAsset.setParam("dl_param_vinfo_m3u8", this.mVodVideoInfo.getMasterM3u8Info().getM3u8Content());
            iTPMediaAsset.setParam("dl_param_vinfo_secondary_m3u8", generateSecondaryM3u8ContentJsonArray().toString());
        }
        iTPMediaAsset.setParam("dl_param_format_nodes", generateFormatNodesJsonArray().toString());
        iTPMediaAsset.setParam("dl_param_play_flowid", this.mFlowId);
        if (this.mVodVideoInfo.getFromType() != TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
            z16 = false;
        }
        iTPMediaAsset.setParam("dl_param_is_offline", String.valueOf(z16));
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        String str = "";
        for (TVKVodVideoInfo.TVKVideoPcdnInfo tVKVideoPcdnInfo : this.mVodVideoInfo.getPcdnInfos()) {
            sb5.append(str);
            sb5.append(tVKVideoPcdnInfo.getUrl());
            sb6.append(str);
            sb6.append(tVKVideoPcdnInfo.getVt());
            str = ";";
        }
        iTPMediaAsset.setParam("dl_param_pcdn_urls", sb5.toString());
        iTPMediaAsset.setParam("dl_param_pcdn_vts", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        String str2 = "";
        for (TVKVodVideoInfo.TVKVideoMultiNetUrlInfo tVKVideoMultiNetUrlInfo : this.mVodVideoInfo.getMultiNetUrlInfos()) {
            sb7.append(str2);
            sb7.append(tVKVideoMultiNetUrlInfo.getUrl());
            str2 = ";";
        }
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_MULTI_NET_URL, sb7.toString());
        iTPMediaAsset.setParam("task_file_type", String.valueOf(convertDownloadTypeToFileType(this.mVodVideoInfo.getDownloadType())));
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_INT_PLAY_EXPERIENCE_LEVEL, this.mVodVideoInfo.getPlayExperienceLevel());
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_VINFO_TS_REPORT_SEQUENCE_LIST, this.mVodVideoInfo.getSeReport());
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_VINFO_SELF_CDN_PARAM, this.mVodVideoInfo.getSescy());
        iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_VINFO_SELF_ENCRYPTION_CIPHERTEXT, this.mVodVideoInfo.getSse());
        if (this.mVodVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC) {
            iTPMediaAsset.setParam(TPDataTransportTaskParam.TASK_PARAM_INT_VINFO_FROM_TYPE, "1");
        }
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            iTPMediaAsset.setParam("dl_param_scene_id", tVKPlayerVideoInfo.getConfigMapValue("scene_id", ""));
            iTPMediaAsset.setParam("dl_param_pcdn_charge_id", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_PCDN_CHARGE_ID, ""));
            iTPMediaAsset.setParam("dl_param_save_path", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_SAVE_PATH, ""));
            iTPMediaAsset.setParam("dl_param_cache_copy_first", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_CACHE_COPY_FIRST, "false"));
            iTPMediaAsset.setParam("dl_param_need_cache", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_NEED_CACHE, "false"));
            iTPMediaAsset.setParam("dl_param_app_testid", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_APP_TESTID, ""));
            iTPMediaAsset.setParam("task_biz_id", this.mPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_DOWNLOAD_PROXY_BIZ_ID, ""));
        }
    }

    private void addNestedM3u8AvsSeparateParams(ITPUrlMediaAsset iTPUrlMediaAsset) {
        if (this.mVodVideoInfo.getCurDefinition() != null && this.mVodVideoInfo.getCurDefinition().isAvsSeparate()) {
            ITPMediaAssetParamMap createMediaAssetParamMap = TPMediaAssetFactory.createMediaAssetParamMap();
            TVKNetVideoInfo.DefnInfo curDefinition = this.mVodVideoInfo.getCurDefinition();
            createMediaAssetParamMap.add(ITPMediaAssetParamMap.TP_ASSET_PARAM_KEY_INT_HLS_TRACK_BANDWIDTH, String.valueOf(curDefinition.getVideoBandwidth()));
            String m3u8Resolution = curDefinition.getM3u8Resolution();
            if (TextUtils.isEmpty(m3u8Resolution) || "null".equalsIgnoreCase(m3u8Resolution)) {
                m3u8Resolution = "";
            }
            createMediaAssetParamMap.add(ITPMediaAssetParamMap.TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_RESOLUTION, m3u8Resolution);
            createMediaAssetParamMap.add(ITPMediaAssetParamMap.TP_ASSET_PARAM_KEY_FLOAT_HLS_TRACK_FRAMERATE, String.valueOf(curDefinition.getVfps()));
            iTPUrlMediaAsset.setObjectParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_VIDEO, createMediaAssetParamMap);
        }
        if (this.mVodVideoInfo.getCurAudioTrack() != null && this.mVodVideoInfo.getCurAudioTrack().isAvsSeparate()) {
            ITPMediaAssetParamMap createMediaAssetParamMap2 = TPMediaAssetFactory.createMediaAssetParamMap();
            createMediaAssetParamMap2.add(ITPMediaAssetParamMap.TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_NAME, this.mVodVideoInfo.getCurAudioTrack().getAudioShowName());
            iTPUrlMediaAsset.setObjectParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_AUDIO, createMediaAssetParamMap2);
        }
        if (this.mVodVideoInfo.getCurSubtitle() != null && this.mVodVideoInfo.getCurSubtitle().isAvsSeparate()) {
            ITPMediaAssetParamMap createMediaAssetParamMap3 = TPMediaAssetFactory.createMediaAssetParamMap();
            createMediaAssetParamMap3.add(ITPMediaAssetParamMap.TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_NAME, this.mVodVideoInfo.getCurSubtitle().getName());
            iTPUrlMediaAsset.setObjectParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_SUBTITLE, createMediaAssetParamMap3);
        }
    }

    private JSONObject convertDefinitionInfoToJsonObject(TVKNetVideoInfo.DefnInfo defnInfo) {
        String defn = defnInfo.getDefn();
        if (!TextUtils.isEmpty(defn) && !"audio".equalsIgnoreCase(defn)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_NAME, defn);
                jSONObject.put(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_BITRATE_PBS, String.valueOf(defnInfo.getVideoBandwidth() + defnInfo.getAudioBandwidth()));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return null;
    }

    private JSONObject convertDirectM3u8InfoToJsonObject(TVKVodVideoInfo.DirectM3u8Info directM3u8Info) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID, directM3u8Info.getKeyId());
            jSONObject.put(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8, directM3u8Info.getM3u8Content());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private int convertDownloadTypeToFileType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 8 || i3 == 3) {
            return 3;
        }
        if (i3 != 4 && i3 != 5) {
            return 0;
        }
        return 2;
    }

    @NonNull
    private ITPDrmMediaAsset generateChinaDrm20Asset() {
        ITPDrmMediaAsset createDrmMediaAsset = TPMediaAssetFactory.createDrmMediaAsset(this.mVodVideoInfo.getPlayUrl(), 3, null, removeUselessCharactersForLicenseUrl(this.mVodVideoInfo.getCkc()));
        createDrmMediaAsset.setParam(ITPDrmMediaAsset.TP_ASSET_PARAM_KEY_STRING_EXT_X_KEY, generateExtXKey());
        return createDrmMediaAsset;
    }

    private String generateClipMp4FileId() {
        return this.mVodVideoInfo.getVid() + "." + this.mVodVideoInfo.getSelectedDefn();
    }

    private ITPMultiMediaAsset generateClipMp4MediaAsset() throws IllegalArgumentException {
        int size;
        List<TVKVodVideoInfo.Section> sectionList = this.mVodVideoInfo.getSectionList();
        if (sectionList != null) {
            if (this.mVodVideoInfo.isPreview()) {
                size = this.mVodVideoInfo.getPreviewClipCount();
            } else {
                size = sectionList.size();
            }
            if (size != 0) {
                ITPMultiMediaAsset createMultiMediaAsset = TPMediaAssetFactory.createMultiMediaAsset();
                for (int i3 = 0; i3 < size; i3++) {
                    TVKVodVideoInfo.Section section = sectionList.get(i3);
                    String url = section.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(url);
                        createUrlMediaAsset.setHttpHeader(this.mVodVideoInfo.getCdnHttpHeaders());
                        addDataTransportTaskParams(createUrlMediaAsset);
                        createUrlMediaAsset.setParam("dl_param_file_size", String.valueOf(section.getSize()));
                        createUrlMediaAsset.setParam("dl_param_file_duration", String.valueOf(section.getDurationSec() * 1000.0d));
                        createUrlMediaAsset.setParam("dl_param_play_clip_no", String.valueOf(section.getIdx()));
                        createUrlMediaAsset.setParam("dl_param_play_clip_count", String.valueOf(size));
                        createUrlMediaAsset.setParam("dl_param_file_md5", section.getCmd5());
                        createUrlMediaAsset.setParam("dl_param_play_clip_keyid", section.getVbkeyId());
                        List<String> urlList = section.getUrlList();
                        for (int i16 = 1; i16 < urlList.size(); i16++) {
                            createUrlMediaAsset.addBackUrl(urlList.get(i16), this.mVodVideoInfo.getCdnHttpHeaders());
                        }
                        createMultiMediaAsset.addAsset(createUrlMediaAsset, (long) (section.getDurationSec() * 1000.0d));
                    } else {
                        throw new IllegalArgumentException("generateClipMp4MediaAsset: url of section " + i3 + " is empty");
                    }
                }
                return createMultiMediaAsset;
            }
            throw new IllegalArgumentException("generateClipMp4MediaAsset: no section found");
        }
        throw new IllegalArgumentException("generateClipMp4MediaAsset: section list is null");
    }

    private String generateDefaultFileId() {
        return this.mVodVideoInfo.getVid() + "." + this.mVodVideoInfo.getSelectedDefnId();
    }

    private ITPUrlMediaAsset generateDefaultUrlMediaAsset() {
        return TPMediaAssetFactory.createUrlMediaAsset(this.mVodVideoInfo.getPlayUrl());
    }

    private ITPDrmMediaAsset generateDrmMediaAsset() {
        int drm = this.mVodVideoInfo.getCurDefinition().getDrm();
        if (drm != 2) {
            if (drm != 5) {
                if (drm != 7) {
                    return TPMediaAssetFactory.createDrmMediaAsset(this.mVodVideoInfo.getPlayUrl(), -1, null, null);
                }
                return generateChinaDrm20Asset();
            }
            return generateWidevineAsset();
        }
        return TPMediaAssetFactory.createDrmMediaAsset(this.mVodVideoInfo.getPlayUrl(), 2, null, null);
    }

    private String generateExtXKey() {
        ArrayList<TVKVodVideoInfo.DirectM3u8Info> arrayList = new ArrayList();
        arrayList.addAll(this.mVodVideoInfo.getAudioM3u8List());
        arrayList.addAll(this.mVodVideoInfo.getVideoM3u8List());
        ArrayList<String> arrayList2 = new ArrayList();
        for (TVKVodVideoInfo.DirectM3u8Info directM3u8Info : arrayList) {
            if (!TextUtils.isEmpty(directM3u8Info.getM3u8Content())) {
                arrayList2.add(directM3u8Info.getM3u8Content());
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Pattern compile = Pattern.compile("(?m)^.*#EXT-X-KEY:METHOD=(?!NONE).*$");
        for (String str : arrayList2) {
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                sb5.append(str.substring(matcher.start(), matcher.end()));
            }
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(sb6)) {
                return sb6;
            }
        }
        return "";
    }

    private String generateFileId() {
        int downloadType = this.mVodVideoInfo.getDownloadType();
        if (downloadType != 1) {
            if (downloadType != 8 && downloadType != 3) {
                if (downloadType != 4 && downloadType != 5) {
                    return generateDefaultFileId();
                }
                return generateClipMp4FileId();
            }
            return generateHlsFileId();
        }
        return generateHttpMp4FileId();
    }

    private JSONArray generateFormatNodesJsonArray() {
        JSONArray jSONArray = new JSONArray();
        Iterator<TVKNetVideoInfo.DefnInfo> it = this.mVodVideoInfo.getDefinitionList().iterator();
        while (it.hasNext()) {
            JSONObject convertDefinitionInfoToJsonObject = convertDefinitionInfoToJsonObject(it.next());
            if (convertDefinitionInfoToJsonObject != null) {
                jSONArray.mo162put(convertDefinitionInfoToJsonObject);
            }
        }
        return jSONArray;
    }

    private String generateHlsFileId() {
        if (this.mVodVideoInfo.getMasterM3u8Info() != null) {
            return this.mVodVideoInfo.getMasterM3u8Info().getKeyId();
        }
        if (!TextUtils.isEmpty(this.mVodVideoInfo.getKeyid())) {
            return this.mVodVideoInfo.getKeyid() + FILE_ID_POSTFIX_HLS;
        }
        return this.mVodVideoInfo.getVid() + "." + this.mVodVideoInfo.getSelectedDefnId() + FILE_ID_POSTFIX_HLS;
    }

    private String generateHttpMp4FileId() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mVodVideoInfo.getVid());
        sb5.append(".");
        if (TextUtils.isEmpty(this.mInputDefinition)) {
            str = this.mVodVideoInfo.getSelectedDefn();
        } else {
            str = this.mInputDefinition;
        }
        sb5.append(str);
        return sb5.toString();
    }

    private JSONArray generateSecondaryM3u8ContentJsonArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mVodVideoInfo.getAudioM3u8List());
        arrayList.addAll(this.mVodVideoInfo.getVideoM3u8List());
        arrayList.addAll(this.mVodVideoInfo.getSubTitleM3u8List());
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(convertDirectM3u8InfoToJsonObject((TVKVodVideoInfo.DirectM3u8Info) it.next()));
        }
        return jSONArray;
    }

    private ITPUrlMediaAsset generateUrlMediaAsset() {
        ITPUrlMediaAsset generateDefaultUrlMediaAsset;
        if (!TextUtils.isEmpty(this.mVodVideoInfo.getPlayUrl())) {
            if (isDrmVideo()) {
                generateDefaultUrlMediaAsset = generateDrmMediaAsset();
            } else {
                generateDefaultUrlMediaAsset = generateDefaultUrlMediaAsset();
            }
            addNestedM3u8AvsSeparateParams(generateDefaultUrlMediaAsset);
            generateDefaultUrlMediaAsset.setHttpHeader(this.mVodVideoInfo.getCdnHttpHeaders());
            addDataTransportTaskParams(generateDefaultUrlMediaAsset);
            ArrayList<String> cdnUrlList = this.mVodVideoInfo.getCdnUrlList();
            for (int i3 = 1; i3 < cdnUrlList.size(); i3++) {
                generateDefaultUrlMediaAsset.addBackUrl(cdnUrlList.get(i3), this.mVodVideoInfo.getCdnHttpHeaders());
            }
            return generateDefaultUrlMediaAsset;
        }
        throw new IllegalArgumentException("generateUrlMediaAsset: url is empty");
    }

    @NonNull
    private ITPDrmMediaAsset generateWidevineAsset() {
        String removeUselessCharactersForLicenseUrl = removeUselessCharactersForLicenseUrl(this.mVodVideoInfo.getCkc());
        ITPDrmMediaAsset createDrmMediaAsset = TPMediaAssetFactory.createDrmMediaAsset(this.mVodVideoInfo.getPlayUrl(), 0, TVKMediaPlayerConfig.PlayerConfig.widevine_provision_url, removeUselessCharactersForLicenseUrl);
        createDrmMediaAsset.setParam(ITPDrmMediaAsset.TP_ASSET_PARAM_KEY_BOOL_LICENSE_STANDARDIZATION, String.valueOf(true));
        createDrmMediaAsset.setParam(ITPDrmMediaAsset.TP_ASSET_PARAM_KEY_STRING_EXT_X_KEY, generateExtXKey());
        if ((TVKMediaPlayerConfig.PlayerConfig.vod_cgi_ea_set & 2) == 0) {
            return createDrmMediaAsset;
        }
        createDrmMediaAsset.setLicenseRequestListener(new TVKWidevineLicenseRequester(removeUselessCharactersForLicenseUrl));
        return createDrmMediaAsset;
    }

    private boolean isClipMp4Video() {
        if (this.mVodVideoInfo.getDownloadType() != 4 && this.mVodVideoInfo.getDownloadType() != 5) {
            return false;
        }
        return true;
    }

    private boolean isDrmVideo() {
        TVKNetVideoInfo.DefnInfo curDefinition = this.mVodVideoInfo.getCurDefinition();
        if (curDefinition == null) {
            return false;
        }
        int drm = curDefinition.getDrm();
        if (drm != 5 && drm != 7 && drm != 2) {
            return false;
        }
        return true;
    }

    public static TVKVodTPMediaAssetBuilder newBuilder() {
        return new TVKVodTPMediaAssetBuilder();
    }

    @NonNull
    private String removeUselessCharactersForLicenseUrl(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("\\|$", "");
    }

    private void setDaTongReportParam(ITPMediaAsset iTPMediaAsset) {
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_PLAY_SCENE_TYPE, "normal");
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_VID, this.mVodVideoInfo.getVid());
        iTPMediaAsset.setParam(ITVKTPPlayer.TP_ASSET_PARAM_KEY_STRING_DT_REPORT_FLOWID, this.mFlowId);
    }

    public ITPMediaAsset build() throws IllegalArgumentException {
        ITPMediaAsset generateUrlMediaAsset;
        if (this.mVodVideoInfo != null) {
            if (isClipMp4Video()) {
                generateUrlMediaAsset = generateClipMp4MediaAsset();
            } else {
                generateUrlMediaAsset = generateUrlMediaAsset();
            }
            if (!this.mVodVideoInfo.getSimulatedLiveInfo().getVidList().isEmpty()) {
                generateUrlMediaAsset = TPMediaAssetFactory.createSimulatedLiveMediaAsset(generateUrlMediaAsset, null);
            }
            setDaTongReportParam(generateUrlMediaAsset);
            return generateUrlMediaAsset;
        }
        throw new IllegalArgumentException("Vod video info is null");
    }

    public TVKVodTPMediaAssetBuilder flowId(String str) {
        this.mFlowId = str;
        return this;
    }

    public TVKVodTPMediaAssetBuilder inputDefinition(String str) {
        this.mInputDefinition = str;
        return this;
    }

    public TVKVodTPMediaAssetBuilder playerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayerVideoInfo = tVKPlayerVideoInfo;
        return this;
    }

    public TVKVodTPMediaAssetBuilder skipEndPositionMs(long j3) {
        this.mSkipEndPositionMs = j3;
        return this;
    }

    public TVKVodTPMediaAssetBuilder startPositionMs(long j3) {
        this.mStartPositionMs = j3;
        return this;
    }

    public TVKVodTPMediaAssetBuilder vodVideoInfo(TVKVodVideoInfo tVKVodVideoInfo) {
        this.mVodVideoInfo = tVKVodVideoInfo;
        return this;
    }
}
