package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSource {
    public long sourceApp;
    public long sourceId;
    public String sceneId = "";
    public String openid = "";
    public String platform = "";
    public String createSrc = "";

    public String getCreateSrc() {
        return this.createSrc;
    }

    public String getOpenid() {
        return this.openid;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public long getSourceApp() {
        return this.sourceApp;
    }

    public long getSourceId() {
        return this.sourceId;
    }

    public void setCreateSrc(String str) {
        this.createSrc = str;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSourceApp(long j3) {
        this.sourceApp = j3;
    }

    public void setSourceId(long j3) {
        this.sourceId = j3;
    }

    public String toString() {
        return "GProSource{sourceId=" + this.sourceId + ",sourceApp=" + this.sourceApp + ",sceneId=" + this.sceneId + ",openid=" + this.openid + ",platform=" + this.platform + ",createSrc=" + this.createSrc + ",}";
    }
}
