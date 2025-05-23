package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarJumpInfo {
    public int type;
    public String schema = "";
    public AiAvatarVipInfo vipInfo = new AiAvatarVipInfo();
    public AiAvatarDisplayInfo displayInfo = new AiAvatarDisplayInfo();

    public AiAvatarDisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    public String getSchema() {
        return this.schema;
    }

    public int getType() {
        return this.type;
    }

    public AiAvatarVipInfo getVipInfo() {
        return this.vipInfo;
    }

    public String toString() {
        return "AiAvatarJumpInfo{type=" + this.type + ",schema=" + this.schema + ",vipInfo=" + this.vipInfo + ",displayInfo=" + this.displayInfo + ",}";
    }
}
