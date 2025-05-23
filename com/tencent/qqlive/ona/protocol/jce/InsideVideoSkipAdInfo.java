package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class InsideVideoSkipAdInfo extends JceStruct {
    static int cache_skipType;
    public boolean enableMultiTrueViewAd;
    public boolean enableSkip;
    public int skipAdDuration;
    public String skipAdSubtitle;
    public String skipAdTitle;
    public int skipType;

    public InsideVideoSkipAdInfo() {
        this.enableSkip = false;
        this.skipAdDuration = 0;
        this.skipAdTitle = "";
        this.skipAdSubtitle = "";
        this.enableMultiTrueViewAd = false;
        this.skipType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enableSkip = jceInputStream.read(this.enableSkip, 0, false);
        this.skipAdDuration = jceInputStream.read(this.skipAdDuration, 1, false);
        this.skipAdTitle = jceInputStream.readString(2, false);
        this.skipAdSubtitle = jceInputStream.readString(3, false);
        this.enableMultiTrueViewAd = jceInputStream.read(this.enableMultiTrueViewAd, 4, false);
        this.skipType = jceInputStream.read(this.skipType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enableSkip, 0);
        jceOutputStream.write(this.skipAdDuration, 1);
        String str = this.skipAdTitle;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.skipAdSubtitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.enableMultiTrueViewAd, 4);
        jceOutputStream.write(this.skipType, 5);
    }

    public InsideVideoSkipAdInfo(boolean z16, int i3, String str, String str2, boolean z17, int i16) {
        this.enableSkip = z16;
        this.skipAdDuration = i3;
        this.skipAdTitle = str;
        this.skipAdSubtitle = str2;
        this.enableMultiTrueViewAd = z17;
        this.skipType = i16;
    }
}
