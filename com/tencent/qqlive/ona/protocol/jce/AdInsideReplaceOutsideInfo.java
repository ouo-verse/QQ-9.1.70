package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideReplaceOutsideInfo extends JceStruct {
    public String bigPicUrl;
    public String clickUrl;
    public boolean shouldReplace;
    public String smallPicUrl;
    public String text;

    public AdInsideReplaceOutsideInfo() {
        this.shouldReplace = false;
        this.smallPicUrl = "";
        this.bigPicUrl = "";
        this.text = "";
        this.clickUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shouldReplace = jceInputStream.read(this.shouldReplace, 0, false);
        this.smallPicUrl = jceInputStream.readString(1, false);
        this.bigPicUrl = jceInputStream.readString(2, false);
        this.text = jceInputStream.readString(3, false);
        this.clickUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shouldReplace, 0);
        String str = this.smallPicUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.bigPicUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.clickUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public AdInsideReplaceOutsideInfo(boolean z16, String str, String str2, String str3, String str4) {
        this.shouldReplace = z16;
        this.smallPicUrl = str;
        this.bigPicUrl = str2;
        this.text = str3;
        this.clickUrl = str4;
    }
}
