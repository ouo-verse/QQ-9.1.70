package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MidAdAdvanceInfo extends JceStruct {
    public String buttonText;
    public int fadeInDuration;
    public int fadeOutDuration;
    public String firstTitle;
    public boolean isNeedToAheadMidAd;
    public String midAdCompleteToast;
    public String requestAdFailToast;
    public String secondTitle;
    public int showDuration;

    public MidAdAdvanceInfo() {
        this.isNeedToAheadMidAd = false;
        this.showDuration = 0;
        this.fadeInDuration = 0;
        this.fadeOutDuration = 0;
        this.firstTitle = "";
        this.secondTitle = "";
        this.buttonText = "";
        this.requestAdFailToast = "";
        this.midAdCompleteToast = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isNeedToAheadMidAd = jceInputStream.read(this.isNeedToAheadMidAd, 0, false);
        this.showDuration = jceInputStream.read(this.showDuration, 1, false);
        this.fadeInDuration = jceInputStream.read(this.fadeInDuration, 2, false);
        this.fadeOutDuration = jceInputStream.read(this.fadeOutDuration, 3, false);
        this.firstTitle = jceInputStream.readString(4, false);
        this.secondTitle = jceInputStream.readString(5, false);
        this.buttonText = jceInputStream.readString(6, false);
        this.requestAdFailToast = jceInputStream.readString(7, false);
        this.midAdCompleteToast = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isNeedToAheadMidAd, 0);
        jceOutputStream.write(this.showDuration, 1);
        jceOutputStream.write(this.fadeInDuration, 2);
        jceOutputStream.write(this.fadeOutDuration, 3);
        String str = this.firstTitle;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.secondTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.buttonText;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.requestAdFailToast;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.midAdCompleteToast;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
    }

    public MidAdAdvanceInfo(boolean z16, int i3, int i16, int i17, String str, String str2, String str3, String str4, String str5) {
        this.isNeedToAheadMidAd = z16;
        this.showDuration = i3;
        this.fadeInDuration = i16;
        this.fadeOutDuration = i17;
        this.firstTitle = str;
        this.secondTitle = str2;
        this.buttonText = str3;
        this.requestAdFailToast = str4;
        this.midAdCompleteToast = str5;
    }
}
