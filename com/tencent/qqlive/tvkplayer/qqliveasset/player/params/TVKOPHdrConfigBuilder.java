package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLiveHdrVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdr10Feature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdrVividFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodUhdHighFpsHdrVividFeature;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.thumbplayer.api.capability.TPHdrCapAttribute;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPHdrConfigBuilder implements ITVKOptionalParamBuilder {
    private static final int LIVE_NET_VIDEO_INFO_HDR_DYNAMIC_MAPPING_FLAG = 0;
    private static final String LOG_PREFIX = "hdr optional builder :";
    private static final String MODULE_NAME = "TVKQQLiveAssetPlayer";
    private static final int VOD_NET_VIDEO_INFO_HDR_DYNAMIC_MAPPING_FLAG = 2;
    private static final Class<?> VOD_HDR_VIVID_FEATURE_CLASS = TVKVodHdrVividFeature.class;
    private static final Class<?> VOD_UHD_HDR_VIVID_FEATURE_CLASS = TVKVodUhdHighFpsHdrVividFeature.class;
    private static final Class<?> LIVE_HDR_VIVID_FEATURE_CLASS = TVKLiveHdrVividFeature.class;
    private static final Class<?> VOD_HDR10_FEATURE_CLASS = TVKVodHdr10Feature.class;
    private static final Class<?> LIVE_HDR10_FEATURE_CLASS = TVKLiveHdrVividFeature.class;

    private List<TPOptionalParam<int[]>> buildHdrMappingTypeOptionalParamListForHdrVivid(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        TVKLogger tVKLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_hdr_dynamic_mapping_config) {
            tVKLogger.info("hdr optional builder :mapping config not enabled, no optional param build", new Object[0]);
            return new ArrayList();
        }
        if (!isHdrVividNetVideoInfo(tVKQQLiveAssetPlayerContext)) {
            tVKLogger.info("hdr optional builder :not vivid video, no optional param build", new Object[0]);
            return new ArrayList();
        }
        TPHdrCapAttribute hdrCapAttribute = TVKTPCapability.getHdrCapAttribute(4);
        if (hdrCapAttribute != null && !hdrCapAttribute.getSupportedMappingTypes().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
            int buildHdrVividHardMappingType = buildHdrVividHardMappingType(hdrCapAttribute, netVideoInfo);
            if (buildHdrVividHardMappingType != 0) {
                tVKLogger.info("hdr optional builder :hard hdr dynamic mapping type supported & build", new Object[0]);
                arrayList.add(Integer.valueOf(buildHdrVividHardMappingType));
            }
            int buildHdrVividSoftMappingType = buildHdrVividSoftMappingType(hdrCapAttribute, netVideoInfo);
            if (buildHdrVividSoftMappingType != 0) {
                tVKLogger.info("hdr optional builder :soft hdr dynamic mapping type supported & build", new Object[0]);
                arrayList.add(Integer.valueOf(buildHdrVividSoftMappingType));
            }
            int buildHdrVividDownwardHdr10MappingType = buildHdrVividDownwardHdr10MappingType(hdrCapAttribute, netVideoInfo);
            if (buildHdrVividDownwardHdr10MappingType != 0) {
                tVKLogger.info("hdr optional builder :hard hdr10 static mapping type supported & build", new Object[0]);
                arrayList.add(Integer.valueOf(buildHdrVividDownwardHdr10MappingType));
            }
            if (arrayList.isEmpty()) {
                tVKLogger.info("hdr optional builder :no mapping type supported, no optional param build", new Object[0]);
                return new ArrayList();
            }
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            return Collections.singletonList(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_HDR_MAPPING_TYPE, iArr));
        }
        tVKLogger.info("hdr optional builder :supported mapping type empty, no optional param build", new Object[0]);
        return new ArrayList();
    }

    private int buildHdrVividDownwardHdr10MappingType(TPHdrCapAttribute tPHdrCapAttribute, TVKNetVideoInfo tVKNetVideoInfo) {
        boolean z16 = TVKMediaPlayerConfig.PlayerConfig.enable_hdr_downward_compatibility;
        boolean contains = tPHdrCapAttribute.getSupportedMappingTypes().contains(3);
        if (z16 && contains) {
            return 3;
        }
        return 0;
    }

    private int buildHdrVividHardMappingType(TPHdrCapAttribute tPHdrCapAttribute, TVKNetVideoInfo tVKNetVideoInfo) {
        boolean z16 = TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_hardware_dynamic_mapping;
        boolean contains = tPHdrCapAttribute.getSupportedMappingTypes().contains(1);
        boolean isHdrVividInfoEnableDynamicMetadata = isHdrVividInfoEnableDynamicMetadata(tVKNetVideoInfo);
        if (z16 && contains && isHdrVividInfoEnableDynamicMetadata) {
            return 1;
        }
        return 0;
    }

    private int buildHdrVividSoftMappingType(TPHdrCapAttribute tPHdrCapAttribute, TVKNetVideoInfo tVKNetVideoInfo) {
        boolean z16 = TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_software_dynamic_mapping;
        boolean contains = tPHdrCapAttribute.getSupportedMappingTypes().contains(2);
        boolean isHdrVividInfoEnableDynamicMetadata = isHdrVividInfoEnableDynamicMetadata(tVKNetVideoInfo);
        if (z16 && contains && isHdrVividInfoEnableDynamicMetadata) {
            return 2;
        }
        return 0;
    }

    private boolean isHdrVividInfoEnableDynamicMetadata(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            return isHdrVividVodInfoEnableDynamicMetadata((TVKVodVideoInfo) tVKNetVideoInfo);
        }
        if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
            return isHdrVividLiveInfoEnableDynamicMetadata((TVKLiveVideoInfo) tVKNetVideoInfo);
        }
        return false;
    }

    private boolean isHdrVividLiveInfo(ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup, TVKLiveVideoInfo tVKLiveVideoInfo) {
        for (ITVKPlayerFeature iTVKPlayerFeature : iTVKPlayerFeatureGroup.getLivePlayerFeatureList()) {
            if (LIVE_HDR_VIVID_FEATURE_CLASS.isInstance(iTVKPlayerFeature) && iTVKPlayerFeature.isMatchFeature(tVKLiveVideoInfo)) {
                return true;
            }
        }
        return false;
    }

    private boolean isHdrVividLiveInfoEnableDynamicMetadata(TVKLiveVideoInfo tVKLiveVideoInfo) {
        if ((tVKLiveVideoInfo.getCurDefinition().getFeature() & 0) == 0) {
            return false;
        }
        return true;
    }

    private boolean isHdrVividNetVideoInfo(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        ITVKAsset tVKAsset = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset();
        ITVKPlayerFeatureGroup featureGroup = tVKQQLiveAssetPlayerContext.getFeatureGroup();
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (TVKAssetUtils.isVodAsset(tVKAsset) && (netVideoInfo instanceof TVKVodVideoInfo)) {
            return isHdrVividVodInfo(featureGroup, (TVKVodVideoInfo) netVideoInfo);
        }
        if (TVKAssetUtils.isLiveAsset(tVKAsset) && (netVideoInfo instanceof TVKLiveVideoInfo)) {
            return isHdrVividLiveInfo(featureGroup, (TVKLiveVideoInfo) netVideoInfo);
        }
        return false;
    }

    private boolean isHdrVividVodInfo(ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup, TVKVodVideoInfo tVKVodVideoInfo) {
        for (ITVKPlayerFeature iTVKPlayerFeature : iTVKPlayerFeatureGroup.getVodPlayerFeatureList()) {
            if (VOD_HDR_VIVID_FEATURE_CLASS.isInstance(iTVKPlayerFeature) && iTVKPlayerFeature.isMatchFeature(tVKVodVideoInfo)) {
                return true;
            }
            if (VOD_UHD_HDR_VIVID_FEATURE_CLASS.isInstance(iTVKPlayerFeature) && iTVKPlayerFeature.isMatchFeature(tVKVodVideoInfo)) {
                return true;
            }
        }
        return false;
    }

    private boolean isHdrVividVodInfoEnableDynamicMetadata(TVKVodVideoInfo tVKVodVideoInfo) {
        TVKNetVideoInfo.DefnInfo curDefinition = tVKVodVideoInfo.getCurDefinition();
        if (TVKDefinitionType.DEFINITION_TYPE_SUHD.equals(curDefinition.getDefn()) && curDefinition.getVideoCodec() == 27) {
            if ((curDefinition.getFeature() & 2) != 0 && TVKMediaPlayerConfig.PlayerConfig.enable_uhd_hdrvivid_dynamic_metadata) {
                return true;
            }
            return false;
        }
        if ((curDefinition.getFeature() & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(buildHdrMappingTypeOptionalParamListForHdrVivid(tVKQQLiveAssetPlayerContext));
        return arrayList;
    }
}
