package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarStatusInfo {
    public ArrayList<AiAvatarActionStatus> actionsList = new ArrayList<>();
    public AiAvatarJumpInfo jumpInfo = new AiAvatarJumpInfo();

    public ArrayList<AiAvatarActionStatus> getActionsList() {
        return this.actionsList;
    }

    public AiAvatarJumpInfo getJumpInfo() {
        return this.jumpInfo;
    }

    public String toString() {
        return "AiAvatarStatusInfo{actionsList=" + this.actionsList + ",jumpInfo=" + this.jumpInfo + ",}";
    }
}
