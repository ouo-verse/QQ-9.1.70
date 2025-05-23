package com.tencent.biz.richframework.video.rfw.player;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;

/* loaded from: classes5.dex */
public class RFWTVKPlayerOptions {
    private String mBusinessCookie;
    private String mDefinition;
    private long mSkipEndMilSec;
    private long mStartPositionMilSec;
    private int mTVKPlayerType;
    private TVKPlayerVideoInfo mTVKPlayerVideoInfo;
    private TVKUserInfo mTVKUserInfo;
    private String mUrl;
    private String mVid;

    RFWTVKPlayerOptions() {
    }

    public static RFWTVKPlayerOptions obtain() {
        return new RFWTVKPlayerOptions();
    }

    public String getBusinessCookie() {
        return this.mBusinessCookie;
    }

    public String getDefinition() {
        return this.mDefinition;
    }

    public long getSkipEndMilSec() {
        return this.mSkipEndMilSec;
    }

    public long getStartPositionMilSec() {
        return this.mStartPositionMilSec;
    }

    public int getTVKPlayerType() {
        return this.mTVKPlayerType;
    }

    public TVKPlayerVideoInfo getTVKPlayerVideoInfo() {
        return this.mTVKPlayerVideoInfo;
    }

    public TVKUserInfo getTVKUserInfo() {
        return this.mTVKUserInfo;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVid() {
        return this.mVid;
    }

    public RFWTVKPlayerOptions setDefinition(String str) {
        this.mDefinition = str;
        return this;
    }

    public RFWTVKPlayerOptions setSkipEndMilSec(long j3) {
        this.mSkipEndMilSec = j3;
        return this;
    }

    public RFWTVKPlayerOptions setStartPositionMilSec(long j3) {
        this.mStartPositionMilSec = j3;
        return this;
    }

    public RFWTVKPlayerOptions setTVKPlayerType(int i3) {
        this.mTVKPlayerType = i3;
        return this;
    }

    public RFWTVKPlayerOptions setTVKPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mTVKPlayerVideoInfo = tVKPlayerVideoInfo;
        return this;
    }

    public RFWTVKPlayerOptions setTVKUserInfo(TVKUserInfo tVKUserInfo) {
        this.mTVKUserInfo = tVKUserInfo;
        return this;
    }

    public RFWTVKPlayerOptions setVid(String str) {
        this.mVid = str;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSTVKPlayerOptions{");
        stringBuffer.append("mVid='");
        stringBuffer.append(this.mVid);
        stringBuffer.append('\'');
        stringBuffer.append(", mUrl='");
        stringBuffer.append(this.mUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mTVKPlayerType=");
        stringBuffer.append(this.mTVKPlayerType);
        stringBuffer.append(", mTVKUserInfo=");
        stringBuffer.append(this.mTVKUserInfo);
        stringBuffer.append(", mDefinition='");
        stringBuffer.append(this.mDefinition);
        stringBuffer.append('\'');
        stringBuffer.append(", mStartPositionMilSec=");
        stringBuffer.append(this.mStartPositionMilSec);
        stringBuffer.append(", mSkipEndMilSec=");
        stringBuffer.append(this.mSkipEndMilSec);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
