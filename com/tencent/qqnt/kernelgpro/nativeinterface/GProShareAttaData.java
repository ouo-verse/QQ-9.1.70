package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProShareAttaData {
    public String attaContentId = "";
    public String fromUin = "";
    public String timeStamp = "";
    public String guildId = "";
    public String channelId = "";
    public String contentId = "";
    public String sharePanelPageSource = "";
    public String shareContentType = "";
    public String shareSource = "";
    public ArrayList<String> toUinList = new ArrayList<>();
    public String streamPginSourceName = "";
    public String visitFrom = "";
    public String sessionId = "";
    public String platformId = "";
    public String userAgent = "";
    public String appVersion = "";

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAttaContentId() {
        return this.attaContentId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getContentId() {
        return this.contentId;
    }

    public String getFromUin() {
        return this.fromUin;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getPlatformId() {
        return this.platformId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getShareContentType() {
        return this.shareContentType;
    }

    public String getSharePanelPageSource() {
        return this.sharePanelPageSource;
    }

    public String getShareSource() {
        return this.shareSource;
    }

    public String getStreamPginSourceName() {
        return this.streamPginSourceName;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<String> getToUinList() {
        return this.toUinList;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getVisitFrom() {
        return this.visitFrom;
    }

    public String toString() {
        return "GProShareAttaData{attaContentId=" + this.attaContentId + ",fromUin=" + this.fromUin + ",timeStamp=" + this.timeStamp + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",contentId=" + this.contentId + ",sharePanelPageSource=" + this.sharePanelPageSource + ",shareContentType=" + this.shareContentType + ",shareSource=" + this.shareSource + ",toUinList=" + this.toUinList + ",streamPginSourceName=" + this.streamPginSourceName + ",visitFrom=" + this.visitFrom + ",sessionId=" + this.sessionId + ",platformId=" + this.platformId + ",userAgent=" + this.userAgent + ",appVersion=" + this.appVersion + ",}";
    }
}
