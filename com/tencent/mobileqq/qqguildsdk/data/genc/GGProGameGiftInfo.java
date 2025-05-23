package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGameGiftInfo;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGameGiftInfo implements IGProGameGiftInfo {
    public final GProGameGiftInfo mInfo;

    public GGProGameGiftInfo(GProGameGiftInfo gProGameGiftInfo) {
        this.mInfo = gProGameGiftInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo
    public ArrayList<String> getGiftIconList() {
        return this.mInfo.getGiftIconList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo
    public int getGiftNum() {
        return this.mInfo.getGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
