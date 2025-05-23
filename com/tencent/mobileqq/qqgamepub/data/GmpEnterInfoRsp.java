package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class GmpEnterInfoRsp extends JceStruct {
    public String appid;
    public int bubbleAppear;
    public int bubbleDisappear;
    public String bubbleId;
    public String content;
    public String errStr;
    public String icon;
    public int retCode;
    public int state;
    public String tabGrayid;
    public String url;
    public int urlType;

    public GmpEnterInfoRsp() {
        this.retCode = 0;
        this.errStr = "";
        this.state = 0;
        this.icon = "";
        this.content = "";
        this.url = "";
        this.urlType = 0;
        this.bubbleId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, false);
        this.errStr = jceInputStream.readString(1, false);
        this.state = jceInputStream.read(this.state, 2, false);
        this.icon = jceInputStream.readString(3, false);
        this.content = jceInputStream.readString(4, false);
        this.url = jceInputStream.readString(5, false);
        this.urlType = jceInputStream.read(this.urlType, 6, false);
        this.bubbleId = jceInputStream.readString(7, false);
        this.bubbleAppear = jceInputStream.read(this.bubbleAppear, 8, false);
        this.bubbleDisappear = jceInputStream.read(this.bubbleDisappear, 9, false);
        this.appid = jceInputStream.readString(10, false);
        this.tabGrayid = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retCode, 0);
        String str = this.errStr;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.state, 2);
        String str2 = this.icon;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.url;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.urlType, 6);
        String str5 = this.bubbleId;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.bubbleAppear, 8);
        jceOutputStream.write(this.bubbleDisappear, 9);
        String str6 = this.appid;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.tabGrayid;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
    }

    public GmpEnterInfoRsp(int i3, String str, int i16, String str2, String str3, String str4, int i17, String str5, int i18, int i19, String str6, String str7) {
        this.retCode = i3;
        this.errStr = str;
        this.state = i16;
        this.icon = str2;
        this.content = str3;
        this.url = str4;
        this.urlType = i17;
        this.bubbleId = str5;
        this.bubbleAppear = i18;
        this.bubbleDisappear = i19;
        this.appid = str6;
        this.tabGrayid = str7;
    }
}
