package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NoticePattonInfo {
    public int pattonType;
    public PlainTxtInfo plainTxt = new PlainTxtInfo();
    public LeftTxtRightPicInfo lefttxtRightPic = new LeftTxtRightPicInfo();

    public LeftTxtRightPicInfo getLefttxtRightPic() {
        return this.lefttxtRightPic;
    }

    public int getPattonType() {
        return this.pattonType;
    }

    public PlainTxtInfo getPlainTxt() {
        return this.plainTxt;
    }
}
