package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RMCodecInfo {
    public RMBizTypeEnum bizType;
    public RMCodecAbility decodeAbility;
    public RMCodecAbility encodeAbility;

    public RMCodecInfo() {
        this.bizType = RMBizTypeEnum.values()[0];
        this.encodeAbility = new RMCodecAbility();
        this.decodeAbility = new RMCodecAbility();
    }

    public RMBizTypeEnum getBizType() {
        return this.bizType;
    }

    public RMCodecAbility getDecodeAbility() {
        return this.decodeAbility;
    }

    public RMCodecAbility getEncodeAbility() {
        return this.encodeAbility;
    }

    public RMCodecInfo(RMBizTypeEnum rMBizTypeEnum, RMCodecAbility rMCodecAbility, RMCodecAbility rMCodecAbility2) {
        this.bizType = RMBizTypeEnum.values()[0];
        this.encodeAbility = new RMCodecAbility();
        new RMCodecAbility();
        this.bizType = rMBizTypeEnum;
        this.encodeAbility = rMCodecAbility;
        this.decodeAbility = rMCodecAbility2;
    }
}
