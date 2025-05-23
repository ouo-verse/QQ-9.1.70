package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdMarkLableInfo extends JceStruct {
    public String bgColor;
    public String imageUrl;
    public byte position;
    public String primeText;
    public byte type;

    public AdMarkLableInfo() {
        this.position = (byte) 0;
        this.imageUrl = "";
        this.type = (byte) 0;
        this.bgColor = "";
        this.primeText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.position = jceInputStream.read(this.position, 0, true);
        this.imageUrl = jceInputStream.readString(1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.bgColor = jceInputStream.readString(3, false);
        this.primeText = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.position, 0);
        String str = this.imageUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.type, 2);
        String str2 = this.bgColor;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.primeText;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public AdMarkLableInfo(byte b16, String str, byte b17, String str2, String str3) {
        this.position = b16;
        this.imageUrl = str;
        this.type = b17;
        this.bgColor = str2;
        this.primeText = str3;
    }
}
