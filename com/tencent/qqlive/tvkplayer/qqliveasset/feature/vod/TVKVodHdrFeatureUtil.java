package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodHdrFeatureUtil {
    private static final boolean DEFAULT_VIEW_SUPPORT_HDR = true;

    public static boolean doesViewSupportHdr(ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        TVKVodHdrFeatureParam tVKVodHdrFeatureParam;
        if (iTVKFeatureParamGroup == null) {
            tVKVodHdrFeatureParam = null;
        } else {
            tVKVodHdrFeatureParam = (TVKVodHdrFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKVodHdrFeatureParam.class);
        }
        if (tVKVodHdrFeatureParam == null) {
            return true;
        }
        return tVKVodHdrFeatureParam.isViewSupportHdr();
    }
}
