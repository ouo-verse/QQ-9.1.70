package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdVideoItem extends JceStruct {
    public int duration;
    public int encodeFormat;
    public int fileSize;
    public int height;
    public String md5;
    public String url;
    public String vid;
    public int width;

    public AdVideoItem() {
        this.url = "";
        this.md5 = "";
        this.fileSize = 0;
        this.duration = 0;
        this.width = 0;
        this.height = 0;
        this.vid = "";
        this.encodeFormat = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(1, false);
        this.md5 = jceInputStream.readString(2, false);
        this.fileSize = jceInputStream.read(this.fileSize, 3, false);
        this.duration = jceInputStream.read(this.duration, 4, false);
        this.width = jceInputStream.read(this.width, 5, false);
        this.height = jceInputStream.read(this.height, 6, false);
        this.vid = jceInputStream.readString(7, false);
        this.encodeFormat = jceInputStream.read(this.encodeFormat, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.md5;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.fileSize, 3);
        jceOutputStream.write(this.duration, 4);
        jceOutputStream.write(this.width, 5);
        jceOutputStream.write(this.height, 6);
        String str3 = this.vid;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.encodeFormat, 8);
    }

    public AdVideoItem(String str, String str2, int i3, int i16, int i17, int i18, String str3, int i19) {
        this.url = str;
        this.md5 = str2;
        this.fileSize = i3;
        this.duration = i16;
        this.width = i17;
        this.height = i18;
        this.vid = str3;
        this.encodeFormat = i19;
    }
}
