package com.tencent.qqlive.tvkplayer.vinfo.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.xml.TVKVodXmlParseGetter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCGIFactory {
    public static ITVKHighRailInfoGetter createHighRailGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        return new TVKHighRailInfoGetter(tVKContext, looper);
    }

    public static ITVKLiveInfoGetter createLiveInfoGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        return new TVKLiveInfoGetter(tVKContext, looper);
    }

    public static ITVKVodInfoGetter createVodInfoGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        return new TVKVodInfoGetter(tVKContext, looper);
    }

    public static ITVKDataParseGetter createVodXmlParseGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        return new TVKVodXmlParseGetter(tVKContext, looper);
    }

    public static ITVKServerTimeGetter getServerTimeInstance() {
        return TVKServerTimeGetter.getInstance();
    }
}
