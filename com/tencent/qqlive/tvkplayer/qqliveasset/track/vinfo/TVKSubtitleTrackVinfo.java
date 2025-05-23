package com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo;

import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleTrackVinfo extends TVKTrackInfo {
    private boolean mIsOffline = false;
    private TVKNetVideoInfo.SubTitle mSubTitle;

    public TVKSubtitleTrackVinfo() {
        setTrackType(3);
    }

    public TVKNetVideoInfo.SubTitle getSubTitle() {
        return this.mSubTitle;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.TVKTrackInfo
    public String getTrackUniqueId() {
        TVKNetVideoInfo.SubTitle subTitle = this.mSubTitle;
        if (subTitle != null && subTitle.isAvsSeparate()) {
            return getTrackName();
        }
        return super.getTrackUniqueId();
    }

    public boolean isOffline() {
        return this.mIsOffline;
    }

    public void setOffline(boolean z16) {
        this.mIsOffline = z16;
    }

    public void setSubTitle(TVKNetVideoInfo.SubTitle subTitle) {
        this.mSubTitle = subTitle;
    }
}
