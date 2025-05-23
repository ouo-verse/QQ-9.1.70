package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideRewardInfo extends JceStruct {
    static int cache_rewardType;
    public String closeDialogTipsWithLock;
    public String closeDialogTipsWithReceived;
    public String closeDialogTipsWithUnLock;
    public String lockTips;
    public String penetrateInfo;
    public String receivedTips;
    public int rewardType;
    public long unLockDuration;
    public String unLockTips;

    public AdInsideRewardInfo() {
        this.rewardType = 0;
        this.unLockDuration = 0L;
        this.unLockTips = "";
        this.lockTips = "";
        this.receivedTips = "";
        this.closeDialogTipsWithUnLock = "";
        this.closeDialogTipsWithLock = "";
        this.closeDialogTipsWithReceived = "";
        this.penetrateInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rewardType = jceInputStream.read(this.rewardType, 0, false);
        this.unLockDuration = jceInputStream.read(this.unLockDuration, 1, false);
        this.unLockTips = jceInputStream.readString(2, false);
        this.lockTips = jceInputStream.readString(3, false);
        this.receivedTips = jceInputStream.readString(4, false);
        this.closeDialogTipsWithUnLock = jceInputStream.readString(5, false);
        this.closeDialogTipsWithLock = jceInputStream.readString(6, false);
        this.closeDialogTipsWithReceived = jceInputStream.readString(7, false);
        this.penetrateInfo = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.rewardType, 0);
        jceOutputStream.write(this.unLockDuration, 1);
        String str = this.unLockTips;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.lockTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.receivedTips;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.closeDialogTipsWithUnLock;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.closeDialogTipsWithLock;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.closeDialogTipsWithReceived;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.penetrateInfo;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
    }

    public AdInsideRewardInfo(int i3, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.rewardType = i3;
        this.unLockDuration = j3;
        this.unLockTips = str;
        this.lockTips = str2;
        this.receivedTips = str3;
        this.closeDialogTipsWithUnLock = str4;
        this.closeDialogTipsWithLock = str5;
        this.closeDialogTipsWithReceived = str6;
        this.penetrateInfo = str7;
    }
}
