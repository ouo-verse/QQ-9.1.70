package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetProfileSwitchRsp;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGetProfileSwitchRsp implements IGProGetProfileSwitchRsp {
    public final GProGetProfileSwitchRsp mInfo;

    public GGProGetProfileSwitchRsp(GProGetProfileSwitchRsp gProGetProfileSwitchRsp) {
        this.mInfo = gProGetProfileSwitchRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetProfileSwitchRsp
    public ArrayList<Integer> getCloseSwitch() {
        return this.mInfo.getCloseSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetProfileSwitchRsp
    public ArrayList<Integer> getOpenSwitch() {
        return this.mInfo.getOpenSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetProfileSwitchRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
