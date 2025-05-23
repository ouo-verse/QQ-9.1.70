package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SmartBox_HotWordsEgg extends JceStruct {
    public long iEndTimeStamp;
    public int iExposureCount;
    public int iId;
    public int iWordId;
    public String sAppend;
    public String sIcon;

    public SmartBox_HotWordsEgg() {
        this.iId = 0;
        this.sIcon = "";
        this.iExposureCount = 0;
        this.sAppend = "";
        this.iEndTimeStamp = 0L;
        this.iWordId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iId = jceInputStream.read(this.iId, 0, false);
        this.sIcon = jceInputStream.readString(1, false);
        this.iExposureCount = jceInputStream.read(this.iExposureCount, 2, false);
        this.sAppend = jceInputStream.readString(3, false);
        this.iEndTimeStamp = jceInputStream.read(this.iEndTimeStamp, 4, false);
        this.iWordId = jceInputStream.read(this.iWordId, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iId, 0);
        String str = this.sIcon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iExposureCount, 2);
        String str2 = this.sAppend;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.iEndTimeStamp, 4);
        jceOutputStream.write(this.iWordId, 5);
    }

    public SmartBox_HotWordsEgg(int i3, String str, int i16, String str2, long j3, int i17) {
        this.iId = i3;
        this.sIcon = str;
        this.iExposureCount = i16;
        this.sAppend = str2;
        this.iEndTimeStamp = j3;
        this.iWordId = i17;
    }
}
