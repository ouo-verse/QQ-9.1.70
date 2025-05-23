package com.tencent.qqlive.module.videoreport.dtreport.api;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.Map;

/* loaded from: classes22.dex */
public interface IDTTVKDataProvider {
    boolean active(TVKPlayerVideoInfo tVKPlayerVideoInfo);

    Map<String, Object> formatBizParams(TVKProperties tVKProperties);

    Map<String, Object> formatOpenParams(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str);

    Map<String, Object> formatStartParams(TVKNetVideoInfo tVKNetVideoInfo, boolean z16);

    String getContentId(TVKPlayerVideoInfo tVKPlayerVideoInfo);

    int getContentType(TVKPlayerVideoInfo tVKPlayerVideoInfo, int i3);

    boolean isBizReady(TVKProperties tVKProperties);
}
