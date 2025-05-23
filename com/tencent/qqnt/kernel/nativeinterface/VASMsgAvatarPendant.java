package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class VASMsgAvatarPendant {
    public Integer avatarId;
    public Integer pendantDiyInfoId;
    public Long pendantId;

    public VASMsgAvatarPendant() {
    }

    public Integer getAvatarId() {
        return this.avatarId;
    }

    public Integer getPendantDiyInfoId() {
        return this.pendantDiyInfoId;
    }

    public Long getPendantId() {
        return this.pendantId;
    }

    public String toString() {
        return "VASMsgAvatarPendant{avatarId=" + this.avatarId + ",pendantId=" + this.pendantId + ",pendantDiyInfoId=" + this.pendantDiyInfoId + ",}";
    }

    public VASMsgAvatarPendant(Integer num, Long l3, Integer num2) {
        this.avatarId = num;
        this.pendantId = l3;
        this.pendantDiyInfoId = num2;
    }
}
