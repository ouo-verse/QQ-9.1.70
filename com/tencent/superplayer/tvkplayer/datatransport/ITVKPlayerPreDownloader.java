package com.tencent.superplayer.tvkplayer.datatransport;

import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.superplayer.api.ISPlayerPreDownloader;

/* loaded from: classes26.dex */
public interface ITVKPlayerPreDownloader {
    int startTVKPreDownload(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ISPlayerPreDownloader.Listener listener);
}
