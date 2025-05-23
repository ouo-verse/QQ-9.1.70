package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameSmobaRoomInfo;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProVoiceSmobaGameSmobaRoomInfo implements IGProVoiceSmobaGameSmobaRoomInfo {
    public final GProVoiceSmobaGameSmobaRoomInfo mInfo;

    public GGProVoiceSmobaGameSmobaRoomInfo(GProVoiceSmobaGameSmobaRoomInfo gProVoiceSmobaGameSmobaRoomInfo) {
        this.mInfo = gProVoiceSmobaGameSmobaRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public int getGameMode() {
        return this.mInfo.getGameMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public ArrayList<Integer> getGradeList() {
        return this.mInfo.getGradeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
