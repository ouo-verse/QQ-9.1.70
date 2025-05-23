package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SmartBox_HotWordsItem extends JceStruct {
    public int bubbleCanClose;
    public int iBubbleStyle;
    public int iClickCount;
    public int iDisplayPosition;
    public int iDuration;
    public long iEndTimeStamp;
    public int iExposureCount;
    public int iId;
    public int iIsForcedInsertion;
    public int iSubType;
    public int iType;
    public int iWordSource;
    public String sAppend;
    public String sIcon;
    public String sItemExtInfo;
    public String sShowTitle;
    public String sSubShowTitle;
    public String sTagUrl;
    public String sTextColor;
    public String sTextSize;
    public String sTitle;
    public String sUrl;
    public String symbolUrl;

    public SmartBox_HotWordsItem() {
        this.sTitle = "";
        this.iType = 0;
        this.iId = 0;
        this.sShowTitle = "";
        this.sIcon = "";
        this.sUrl = "";
        this.iExposureCount = 0;
        this.iClickCount = 0;
        this.sAppend = "";
        this.iSubType = 0;
        this.sSubShowTitle = "";
        this.iBubbleStyle = 0;
        this.iDuration = 0;
        this.iEndTimeStamp = 0L;
        this.symbolUrl = "";
        this.bubbleCanClose = 1;
        this.iDisplayPosition = -1;
        this.iIsForcedInsertion = 0;
        this.iWordSource = 0;
        this.sItemExtInfo = "";
        this.sTextSize = "";
        this.sTextColor = "";
        this.sTagUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sTitle = jceInputStream.readString(0, false);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.iId = jceInputStream.read(this.iId, 2, false);
        this.sShowTitle = jceInputStream.readString(3, false);
        this.sIcon = jceInputStream.readString(4, false);
        this.sUrl = jceInputStream.readString(5, false);
        this.iExposureCount = jceInputStream.read(this.iExposureCount, 6, false);
        this.iClickCount = jceInputStream.read(this.iClickCount, 7, false);
        this.sAppend = jceInputStream.readString(8, false);
        this.iSubType = jceInputStream.read(this.iSubType, 9, false);
        this.sSubShowTitle = jceInputStream.readString(10, false);
        this.iBubbleStyle = jceInputStream.read(this.iBubbleStyle, 11, false);
        this.iDuration = jceInputStream.read(this.iDuration, 12, false);
        this.iEndTimeStamp = jceInputStream.read(this.iEndTimeStamp, 13, false);
        this.symbolUrl = jceInputStream.readString(14, false);
        this.bubbleCanClose = jceInputStream.read(this.bubbleCanClose, 15, false);
        this.iDisplayPosition = jceInputStream.read(this.iDisplayPosition, 16, false);
        this.iIsForcedInsertion = jceInputStream.read(this.iIsForcedInsertion, 17, false);
        this.iWordSource = jceInputStream.read(this.iWordSource, 18, false);
        this.sItemExtInfo = jceInputStream.readString(19, false);
        this.sTextSize = jceInputStream.readString(20, false);
        this.sTextColor = jceInputStream.readString(21, false);
        this.sTagUrl = jceInputStream.readString(22, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iType, 1);
        jceOutputStream.write(this.iId, 2);
        String str2 = this.sShowTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.sIcon;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.sUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.iExposureCount, 6);
        jceOutputStream.write(this.iClickCount, 7);
        String str5 = this.sAppend;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.iSubType, 9);
        String str6 = this.sSubShowTitle;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this.iBubbleStyle, 11);
        jceOutputStream.write(this.iDuration, 12);
        jceOutputStream.write(this.iEndTimeStamp, 13);
        String str7 = this.symbolUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.bubbleCanClose, 15);
        jceOutputStream.write(this.iDisplayPosition, 16);
        jceOutputStream.write(this.iIsForcedInsertion, 17);
        jceOutputStream.write(this.iWordSource, 18);
        String str8 = this.sItemExtInfo;
        if (str8 != null) {
            jceOutputStream.write(str8, 19);
        }
        String str9 = this.sTextSize;
        if (str9 != null) {
            jceOutputStream.write(str9, 20);
        }
        String str10 = this.sTextColor;
        if (str10 != null) {
            jceOutputStream.write(str10, 21);
        }
        String str11 = this.sTagUrl;
        if (str11 != null) {
            jceOutputStream.write(str11, 22);
        }
    }

    public SmartBox_HotWordsItem(String str, int i3, int i16, String str2, String str3, String str4, int i17, int i18, String str5, int i19, String str6, int i26, int i27, long j3, String str7, int i28, int i29, int i36, int i37, String str8, String str9, String str10, String str11) {
        this.sTitle = str;
        this.iType = i3;
        this.iId = i16;
        this.sShowTitle = str2;
        this.sIcon = str3;
        this.sUrl = str4;
        this.iExposureCount = i17;
        this.iClickCount = i18;
        this.sAppend = str5;
        this.iSubType = i19;
        this.sSubShowTitle = str6;
        this.iBubbleStyle = i26;
        this.iDuration = i27;
        this.iEndTimeStamp = j3;
        this.symbolUrl = str7;
        this.bubbleCanClose = i28;
        this.iDisplayPosition = i29;
        this.iIsForcedInsertion = i36;
        this.iWordSource = i37;
        this.sItemExtInfo = str8;
        this.sTextSize = str9;
        this.sTextColor = str10;
        this.sTagUrl = str11;
    }
}
