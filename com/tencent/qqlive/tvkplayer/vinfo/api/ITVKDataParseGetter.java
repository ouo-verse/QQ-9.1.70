package com.tencent.qqlive.tvkplayer.vinfo.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;

/* loaded from: classes23.dex */
public interface ITVKDataParseGetter {

    /* loaded from: classes23.dex */
    public interface ITVKVodDataParseGetterListener {
        void onFailure(int i3, @NonNull TVKError tVKError);

        void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo);
    }

    void cancelRequest(int i3);

    int parse(@NonNull String str, ITVKFeatureGroup iTVKFeatureGroup);

    void setListener(ITVKVodDataParseGetterListener iTVKVodDataParseGetterListener);
}
