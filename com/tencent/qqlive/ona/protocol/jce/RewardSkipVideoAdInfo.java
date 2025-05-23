package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RewardSkipVideoAdInfo extends JceStruct {
    static int cache_skipVideoAdType;
    public String clickableTitle;
    public int disappearRemainingTime;
    public boolean shouldUpdateInfo;
    public String skipSuccessToast;
    public int skipVideoAdType;
    public int unclickableDuration;
    public String unclickableTitle;

    public RewardSkipVideoAdInfo() {
        this.shouldUpdateInfo = false;
        this.skipVideoAdType = 0;
        this.unclickableDuration = 0;
        this.clickableTitle = "";
        this.unclickableTitle = "";
        this.disappearRemainingTime = 0;
        this.skipSuccessToast = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shouldUpdateInfo = jceInputStream.read(this.shouldUpdateInfo, 0, false);
        this.skipVideoAdType = jceInputStream.read(this.skipVideoAdType, 1, false);
        this.unclickableDuration = jceInputStream.read(this.unclickableDuration, 2, false);
        this.clickableTitle = jceInputStream.readString(3, false);
        this.unclickableTitle = jceInputStream.readString(4, false);
        this.disappearRemainingTime = jceInputStream.read(this.disappearRemainingTime, 5, false);
        this.skipSuccessToast = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shouldUpdateInfo, 0);
        jceOutputStream.write(this.skipVideoAdType, 1);
        jceOutputStream.write(this.unclickableDuration, 2);
        String str = this.clickableTitle;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.unclickableTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.disappearRemainingTime, 5);
        String str3 = this.skipSuccessToast;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }

    public RewardSkipVideoAdInfo(boolean z16, int i3, int i16, String str, String str2, int i17, String str3) {
        this.shouldUpdateInfo = z16;
        this.skipVideoAdType = i3;
        this.unclickableDuration = i16;
        this.clickableTitle = str;
        this.unclickableTitle = str2;
        this.disappearRemainingTime = i17;
        this.skipSuccessToast = str3;
    }
}
