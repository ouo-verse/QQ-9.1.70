package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdRichMediaItem extends JceStruct {
    public boolean isValid;
    public String richMediaParams;
    public String richMediaUrl;
    public String richMediaZip;
    public boolean zipFailedSkipAd;

    public AdRichMediaItem() {
        this.richMediaUrl = "";
        this.richMediaZip = "";
        this.zipFailedSkipAd = true;
        this.richMediaParams = "";
        this.isValid = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.richMediaUrl = jceInputStream.readString(0, false);
        this.richMediaZip = jceInputStream.readString(1, false);
        this.zipFailedSkipAd = jceInputStream.read(this.zipFailedSkipAd, 2, false);
        this.richMediaParams = jceInputStream.readString(3, false);
        this.isValid = jceInputStream.read(this.isValid, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.richMediaUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.richMediaZip;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.zipFailedSkipAd, 2);
        String str3 = this.richMediaParams;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.isValid, 4);
    }

    public AdRichMediaItem(String str, String str2, boolean z16, String str3, boolean z17) {
        this.richMediaUrl = str;
        this.richMediaZip = str2;
        this.zipFailedSkipAd = z16;
        this.richMediaParams = str3;
        this.isValid = z17;
    }
}
