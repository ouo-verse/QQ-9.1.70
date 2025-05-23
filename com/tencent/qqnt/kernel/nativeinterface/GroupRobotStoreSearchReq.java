package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotStoreSearchReq {
    public long groupId;
    public int sceneId;
    public String traceId = "";
    public String keywords = "";
    public byte[] sessionInfo = new byte[0];

    public long getGroupId() {
        return this.groupId;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setGroupId(long j3) {
        this.groupId = j3;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public void setSceneId(int i3) {
        this.sceneId = i3;
    }

    public void setSessionInfo(byte[] bArr) {
        this.sessionInfo = bArr;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        return "GroupRobotStoreSearchReq{traceId=" + this.traceId + ",keywords=" + this.keywords + ",groupId=" + this.groupId + ",sessionInfo=" + this.sessionInfo + ",sceneId=" + this.sceneId + ",}";
    }
}
