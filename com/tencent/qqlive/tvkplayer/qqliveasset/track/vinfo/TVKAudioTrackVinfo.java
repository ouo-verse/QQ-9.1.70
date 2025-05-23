package com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioTrackVinfo extends TVKTrackInfo {
    private TVKNetVideoInfo.AudioTrackInfo mAudioTrackInfo;
    private boolean mIsOffline = false;

    public TVKAudioTrackVinfo() {
        setTrackType(2);
    }

    public TVKNetVideoInfo.AudioTrackInfo getAudioTrackInfo() {
        return this.mAudioTrackInfo;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.TVKTrackInfo
    public String getTrackUniqueId() {
        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = this.mAudioTrackInfo;
        if (audioTrackInfo != null && audioTrackInfo.getTrackType() == 1) {
            return getTrackName();
        }
        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo2 = this.mAudioTrackInfo;
        if (audioTrackInfo2 != null && audioTrackInfo2.isAvsSeparate()) {
            return getTrackName();
        }
        return super.getTrackUniqueId();
    }

    public boolean isOffline() {
        return this.mIsOffline;
    }

    public void setAudioTrackInfo(@NonNull TVKNetVideoInfo.AudioTrackInfo audioTrackInfo) {
        this.mAudioTrackInfo = audioTrackInfo;
    }

    public void setOffline(boolean z16) {
        this.mIsOffline = z16;
    }
}
