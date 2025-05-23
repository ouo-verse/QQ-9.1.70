package com.tencent.qqlive.tvkplayer.api.batchvinfo;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKBatchVinfoRequester {
    int requestBatchVinfo(Map<String, TVKPlayerVideoInfo> map, TVKUserInfo tVKUserInfo) throws IllegalArgumentException;

    void setListener(ITVKBatchVinfoListener iTVKBatchVinfoListener);
}
