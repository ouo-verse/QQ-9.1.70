package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdRewardGuideInfo extends JceStruct {
    static int cache_rewardGuideType;
    public String lockTips;
    public String penetrateInfo;
    public int rewardGuideType;
    public int rewardValidTime;
    public String unLockTips;

    public AdRewardGuideInfo() {
        this.rewardGuideType = 0;
        this.unLockTips = "";
        this.lockTips = "";
        this.penetrateInfo = "";
        this.rewardValidTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rewardGuideType = jceInputStream.read(this.rewardGuideType, 0, false);
        this.unLockTips = jceInputStream.readString(1, false);
        this.lockTips = jceInputStream.readString(2, false);
        this.penetrateInfo = jceInputStream.readString(3, false);
        this.rewardValidTime = jceInputStream.read(this.rewardValidTime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.rewardGuideType, 0);
        String str = this.unLockTips;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.lockTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.penetrateInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.rewardValidTime, 4);
    }

    public AdRewardGuideInfo(int i3, String str, String str2, String str3, int i16) {
        this.rewardGuideType = i3;
        this.unLockTips = str;
        this.lockTips = str2;
        this.penetrateInfo = str3;
        this.rewardValidTime = i16;
    }
}
