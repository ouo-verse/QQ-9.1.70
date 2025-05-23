package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdSpeechInfo extends JceStruct {
    public String adWord;
    public float confidence;
    public boolean isValid;
    public String mainTitle;
    public int openType;
    public String subTitle;
    public String voiceToken;

    public AdSpeechInfo() {
        this.isValid = false;
        this.voiceToken = "";
        this.confidence = 0.0f;
        this.openType = 0;
        this.mainTitle = "";
        this.adWord = "";
        this.subTitle = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isValid = jceInputStream.read(this.isValid, 0, false);
        this.voiceToken = jceInputStream.readString(1, false);
        this.confidence = jceInputStream.read(this.confidence, 2, false);
        this.openType = jceInputStream.read(this.openType, 3, false);
        this.mainTitle = jceInputStream.readString(4, false);
        this.adWord = jceInputStream.readString(5, false);
        this.subTitle = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isValid, 0);
        String str = this.voiceToken;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.confidence, 2);
        jceOutputStream.write(this.openType, 3);
        String str2 = this.mainTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.adWord;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.subTitle;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public AdSpeechInfo(boolean z16, String str, float f16, int i3, String str2, String str3, String str4) {
        this.isValid = z16;
        this.voiceToken = str;
        this.confidence = f16;
        this.openType = i3;
        this.mainTitle = str2;
        this.adWord = str3;
        this.subTitle = str4;
    }
}
