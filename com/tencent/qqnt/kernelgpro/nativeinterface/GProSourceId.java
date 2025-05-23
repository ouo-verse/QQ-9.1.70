package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSourceId {
    public String contentId;
    public int entranceId;
    public String flag1;
    public String inviteCode;
    public String inviteUuid;
    public String openid;
    public String pageId;
    public String pginSourceName;
    public String sceneId;
    public String searchExtensionInfo;
    public String sessionId;
    public long sourceApp;
    public String sourceId;
    public int sourceType;
    public String subSourceId;
    public String visitForm;

    public GProSourceId() {
        this.sceneId = "";
        this.openid = "";
        this.flag1 = "";
        this.sourceId = "";
        this.subSourceId = "";
        this.pginSourceName = "";
        this.visitForm = "";
        this.sessionId = "";
        this.inviteCode = "";
        this.pageId = "";
        this.searchExtensionInfo = "";
        this.contentId = "";
        this.inviteUuid = "";
    }

    public String getContentId() {
        return this.contentId;
    }

    public int getEntranceId() {
        return this.entranceId;
    }

    public String getFlag1() {
        return this.flag1;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getInviteUuid() {
        return this.inviteUuid;
    }

    public String getOpenid() {
        return this.openid;
    }

    public String getPageId() {
        return this.pageId;
    }

    public String getPginSourceName() {
        return this.pginSourceName;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSearchExtensionInfo() {
        return this.searchExtensionInfo;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public long getSourceApp() {
        return this.sourceApp;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getSubSourceId() {
        return this.subSourceId;
    }

    public String getVisitForm() {
        return this.visitForm;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public void setEntranceId(int i3) {
        this.entranceId = i3;
    }

    public void setFlag1(String str) {
        this.flag1 = str;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setInviteUuid(String str) {
        this.inviteUuid = str;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public void setPginSourceName(String str) {
        this.pginSourceName = str;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSearchExtensionInfo(String str) {
        this.searchExtensionInfo = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSourceApp(long j3) {
        this.sourceApp = j3;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceType(int i3) {
        this.sourceType = i3;
    }

    public void setSubSourceId(String str) {
        this.subSourceId = str;
    }

    public void setVisitForm(String str) {
        this.visitForm = str;
    }

    public String toString() {
        return "GProSourceId{sourceApp=" + this.sourceApp + ",sceneId=" + this.sceneId + ",openid=" + this.openid + ",flag1=" + this.flag1 + ",sourceId=" + this.sourceId + ",subSourceId=" + this.subSourceId + ",entranceId=" + this.entranceId + ",pginSourceName=" + this.pginSourceName + ",visitForm=" + this.visitForm + ",sessionId=" + this.sessionId + ",inviteCode=" + this.inviteCode + ",pageId=" + this.pageId + ",searchExtensionInfo=" + this.searchExtensionInfo + ",contentId=" + this.contentId + ",inviteUuid=" + this.inviteUuid + ",sourceType=" + this.sourceType + ",}";
    }

    public GProSourceId(long j3, String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, int i16) {
        this.inviteCode = "";
        this.pageId = "";
        this.searchExtensionInfo = "";
        this.contentId = "";
        this.inviteUuid = "";
        this.sourceApp = j3;
        this.sceneId = str;
        this.openid = str2;
        this.flag1 = str3;
        this.sourceId = str4;
        this.subSourceId = str5;
        this.entranceId = i3;
        this.pginSourceName = str6;
        this.visitForm = str7;
        this.sessionId = str8;
        this.sourceType = i16;
    }
}
