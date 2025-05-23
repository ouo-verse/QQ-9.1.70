package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAnchorInfo;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveRoomAnchorInfo implements ILiveRoomAnchorInfo {
    private GProAnchorInfo anchorInfo;

    public LiveRoomAnchorInfo(GProAnchorInfo gProAnchorInfo) {
        this.anchorInfo = gProAnchorInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
    public String getAnchorAvatarMeta() {
        return this.anchorInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
    public String getAnchorIcon() {
        return this.anchorInfo.getAnchorIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
    public String getAnchorName() {
        return this.anchorInfo.getAnchorName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
    public String getAnchorTinyId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.anchorInfo.getTinyId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
    public long getIdVerifyTimestamp() {
        return this.anchorInfo.getIdVerifyTimestamp();
    }

    @NotNull
    public String toString() {
        GProAnchorInfo gProAnchorInfo = this.anchorInfo;
        if (gProAnchorInfo != null) {
            return gProAnchorInfo.toString();
        }
        return "null";
    }
}
