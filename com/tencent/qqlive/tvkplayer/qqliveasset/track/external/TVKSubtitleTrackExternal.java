package com.tencent.qqlive.tvkplayer.qqliveasset.track.external;

import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleTrackExternal extends TVKTrackInfo {
    private String mSubTitleUrl;

    public TVKSubtitleTrackExternal() {
        setTrackType(3);
    }

    public String getSubTitleUrl() {
        return this.mSubTitleUrl;
    }

    public void setSubTitleUrl(String str) {
        this.mSubTitleUrl = str;
    }
}
