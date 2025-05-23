package com.tencent.qqlive.tvkplayer.qqliveasset.track.external;

import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioTrackExternal extends TVKTrackInfo {
    private String mAudioTrackUrl;

    public TVKAudioTrackExternal() {
        setTrackType(2);
    }

    public String getAudioTrackUrl() {
        return this.mAudioTrackUrl;
    }

    public void setAudioTrackUrl(String str) {
        this.mAudioTrackUrl = str;
    }
}
