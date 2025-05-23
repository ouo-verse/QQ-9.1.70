package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKGetVinfoData {
    private TVKVodRetryAndErrorInfo mErrorInfo;
    private int mParseResult = 0;
    private TVKVodVideoInfo mVodInfo;

    public TVKVodRetryAndErrorInfo getErrorInfo() {
        return this.mErrorInfo;
    }

    public int getParseResult() {
        return this.mParseResult;
    }

    public TVKVodVideoInfo getVodInfo() {
        return this.mVodInfo;
    }

    public void setErrorInfo(TVKVodRetryAndErrorInfo tVKVodRetryAndErrorInfo) {
        this.mErrorInfo = tVKVodRetryAndErrorInfo;
    }

    public void setParseResult(int i3) {
        this.mParseResult = i3;
    }

    public void setVodInfo(TVKVodVideoInfo tVKVodVideoInfo) {
        this.mVodInfo = tVKVodVideoInfo;
    }
}
