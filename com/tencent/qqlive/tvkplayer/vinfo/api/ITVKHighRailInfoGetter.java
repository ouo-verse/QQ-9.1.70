package com.tencent.qqlive.tvkplayer.vinfo.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKHighRailInfoGetter {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKHighRailInfoGetterListener {
        void onHighRailInfoFailure(int i3, @NonNull TVKError tVKError);

        void onHighRailInfoSuccess(int i3, String str, long j3);
    }

    void cancelRequest(int i3);

    int requestPlayInfo(@NonNull String str);

    void setListener(ITVKHighRailInfoGetterListener iTVKHighRailInfoGetterListener);
}
