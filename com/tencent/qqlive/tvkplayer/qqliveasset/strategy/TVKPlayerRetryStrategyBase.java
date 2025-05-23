package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerRetryStrategy;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public abstract class TVKPlayerRetryStrategyBase implements ITVKPlayerRetryStrategy {
    private static final List<String> DEFINITION_LIST;
    private static final Comparator<String> DEFN_COMPARATOR;
    private static final Map<Integer, String> ERROR_MDG_MAP;
    private static final int MAX_ERROR_RETRY_COUNT = 3;
    private static final String TAG = "TVKPlayer[TVKPlayerRetryStrategyBase]";

    @NonNull
    private final TVKPlayerInputParam mInputParam;

    @NonNull
    protected final ITVKPlayerFeatureGroup mPlayerFeatureGroup;

    @NonNull
    protected final TVKPlayerRuntimeParam mRuntimeParam;

    static {
        ArrayList arrayList = new ArrayList();
        DEFINITION_LIST = arrayList;
        arrayList.add(TVKDefinitionType.DEFINITION_TYPE_SUHD);
        arrayList.add(TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION);
        arrayList.add("uhd");
        arrayList.add(TVKDefinitionType.DEFINITION_TYPE_FHD10M);
        arrayList.add("fhd");
        arrayList.add("shd");
        arrayList.add("hd");
        arrayList.add("sd");
        arrayList.add("msd");
        DEFN_COMPARATOR = new Comparator<String>() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKPlayerRetryStrategyBase.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return TVKPlayerRetryStrategyBase.DEFINITION_LIST.indexOf(str) - TVKPlayerRetryStrategyBase.DEFINITION_LIST.indexOf(str2);
            }
        };
        HashMap hashMap = new HashMap();
        ERROR_MDG_MAP = hashMap;
        hashMap.put(2000, "TP_ERROR_TYPE_SYSTEM_MEDIA_PLAYER_GENERAL");
        hashMap.put(1001, "TP_ERROR_TYPE_SELF_DEV_PLAYER_GENERAL");
        hashMap.put(1300, "TP_ERROR_TYPE_SELF_DEV_PLAYER_RENDERER_GENERAL");
        hashMap.put(1500, "TP_ERROR_TYPE_SELF_DEV_PLAYER_AUDIO_POSTPROCESS_GENERAL");
        hashMap.put(2001, "TP_ERROR_TYPE_SYSTEM_MEDIA_PLAYER_NETWORK");
        hashMap.put(1100, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DEMUXER_GENERAL");
        hashMap.put(1101, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DEMUXER_NETWORK");
        hashMap.put(1102, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DEMUXER_STREAM");
        hashMap.put(1103, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DEMUXER_BUFFERING_TIMEOUT");
        hashMap.put(1200, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_GENERAL");
        hashMap.put(1210, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_AUDIO_NOT_SUPPORT");
        hashMap.put(Integer.valueOf(TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT), "TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT");
        hashMap.put(1211, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_AUDIO_STREAM");
        hashMap.put(1221, "TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_STREAM");
    }

    public TVKPlayerRetryStrategyBase(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
        this.mInputParam = tVKPlayerInputParam;
        this.mRuntimeParam = tVKPlayerRuntimeParam;
        this.mPlayerFeatureGroup = iTVKPlayerFeatureGroup;
    }

    private String dumpRetryModelAction(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                return "action_call_error";
            }
            return "action_disable_feature";
        }
        return "action_decrease_definition";
    }

    private static String dumpTpPlayerError(int i3, int i16) {
        String str;
        Map<Integer, String> map = ERROR_MDG_MAP;
        if (map.containsKey(Integer.valueOf(i3))) {
            str = map.get(Integer.valueOf(i3));
        } else {
            str = "unknown";
        }
        return "player [" + str + "] [" + i3 + "-" + i16 + "]error";
    }

    private List<ITVKPlayerFeature> getFeatureRetryList() {
        if (TVKAssetUtils.isLiveAsset(this.mRuntimeParam.getTVKAsset())) {
            return this.mPlayerFeatureGroup.getLiveRetryFeatureList();
        }
        return this.mPlayerFeatureGroup.getVodRetryFeatureList();
    }

    private boolean isInvalidParam(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (tVKPlayerRuntimeParam.getTVKAsset() != null && tVKPlayerRuntimeParam.getNetVideoInfo() != null) {
            int assetType = tVKPlayerRuntimeParam.getTVKAsset().getAssetType();
            if ((TVKAssetUtils.isLiveAsset(tVKPlayerRuntimeParam.getTVKAsset()) || assetType == 131072 || assetType == 524288 || assetType == 1048576) && tVKPlayerRuntimeParam.getNetVideoInfo().getDefinitionList() != null && tVKPlayerRuntimeParam.getNetVideoInfo().getCurDefinition() != null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ITVKFeatureBase findNeedDisableFeatureForRetry(TVKNetVideoInfo tVKNetVideoInfo, List<ITVKPlayerFeature> list) {
        if (list.isEmpty()) {
            return null;
        }
        for (ITVKPlayerFeature iTVKPlayerFeature : list) {
            if ((iTVKPlayerFeature instanceof ITVKFeatureBase) && TVKPlayerFeatureUtils.isNeedDisableFeatureForRetry(iTVKPlayerFeature, tVKNetVideoInfo)) {
                TVKLogUtil.i(TAG, "player error retry model : need disable feature:" + iTVKPlayerFeature.getClass().getName());
                return (ITVKFeatureBase) iTVKPlayerFeature;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDefinitionForPlayerErrorRetry() {
        if (!TVKMediaPlayerConfig.PlayerConfig.is_allow_decreases_definition) {
            return null;
        }
        TVKNetVideoInfo.DefnInfo curDefinition = this.mRuntimeParam.getNetVideoInfo().getCurDefinition();
        List<TVKNetVideoInfo.DefnInfo> definitionList = this.mRuntimeParam.getNetVideoInfo().getDefinitionList();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < definitionList.size(); i3++) {
            arrayList.add(definitionList.get(i3).getDefn());
        }
        Collections.sort(arrayList, DEFN_COMPARATOR);
        int indexOf = arrayList.indexOf(curDefinition.getDefn());
        if (indexOf < 0 || indexOf >= arrayList.size() - 1) {
            return null;
        }
        int i16 = indexOf + 1;
        if (("uhd".equalsIgnoreCase(curDefinition.getDefn()) && TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION.equalsIgnoreCase((String) arrayList.get(i16))) || (TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION.equalsIgnoreCase(curDefinition.getDefn()) && "uhd".equalsIgnoreCase((String) arrayList.get(i16)))) {
            indexOf = i16;
        }
        int i17 = indexOf + 1;
        if (i17 >= arrayList.size()) {
            return null;
        }
        return (String) arrayList.get(i17);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerRetryStrategy
    public ITVKPlayerRetryStrategy.RetryActionRet getRetryActionForPlayerError(int i3, int i16, int i17) {
        if (isInvalidParam(this.mRuntimeParam)) {
            return new ITVKPlayerRetryStrategy.RetryActionRet(1, null);
        }
        if (this.mRuntimeParam.getErrorRetryCount() >= 3) {
            TVKLogUtil.i(TAG, "player error retry model : has reach max retry count and call error!");
            return new ITVKPlayerRetryStrategy.RetryActionRet(1, null);
        }
        ITVKPlayerRetryStrategy.RetryActionRet retryActionWithError = getRetryActionWithError(i3, i16, getFeatureRetryList());
        TVKLogUtil.i(TAG, "********************************************************************");
        TVKLogUtil.i(TAG, "player error retry time(s) : " + this.mRuntimeParam.getErrorRetryCount());
        TVKLogUtil.i(TAG, "player error retry model : error params : " + dumpTpPlayerError(i16, i17));
        TVKLogUtil.i(TAG, "player error retry model : final decision action : " + dumpRetryModelAction(retryActionWithError.getRetryAction()));
        TVKLogUtil.i(TAG, "********************************************************************");
        return retryActionWithError;
    }

    protected abstract ITVKPlayerRetryStrategy.RetryActionRet getRetryActionWithError(int i3, int i16, List<ITVKPlayerFeature> list);
}
