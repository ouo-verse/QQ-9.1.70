package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RemarkSignExtInfo {
    public Integer chatType;
    public Long groupCode;
    public RemarkSceneId sceneId;
    public byte[] sig;

    public RemarkSignExtInfo() {
        this.sceneId = RemarkSceneId.values()[0];
        this.sig = new byte[0];
    }

    public Integer getChatType() {
        return this.chatType;
    }

    public Long getGroupCode() {
        return this.groupCode;
    }

    public RemarkSceneId getSceneId() {
        return this.sceneId;
    }

    public byte[] getSig() {
        return this.sig;
    }

    public RemarkSignExtInfo(RemarkSceneId remarkSceneId, Integer num, Long l3, byte[] bArr) {
        RemarkSceneId remarkSceneId2 = RemarkSceneId.values()[0];
        this.sceneId = remarkSceneId;
        this.chatType = num;
        this.groupCode = l3;
        this.sig = bArr;
    }
}
