package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class QzmallCustomPraise extends JceStruct {
    public int iFrameRate;
    public int iItemId;
    public int iSubPraisetype;
    public int iType;
    public long lUin;
    public String strCmShowActionId;
    public String strItemSummary;
    public String strPraiseComboZip;
    public String strPraiseListPic;
    public String strPraisePic;
    public String strPraisePicBefore;
    public String strPraiseZip;
    public String strPraiseZipAfter;

    public QzmallCustomPraise() {
        this.iItemId = -1;
        this.strItemSummary = "";
        this.strPraisePic = "";
        this.strPraiseZip = "";
        this.strPraiseComboZip = "";
        this.iFrameRate = 0;
        this.strPraiseListPic = "";
        this.lUin = 0L;
        this.iType = 0;
        this.iSubPraisetype = 0;
        this.strPraisePicBefore = "";
        this.strPraiseZipAfter = "";
        this.strCmShowActionId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strItemSummary = jceInputStream.readString(1, false);
        this.strPraisePic = jceInputStream.readString(2, false);
        this.strPraiseZip = jceInputStream.readString(3, false);
        this.strPraiseComboZip = jceInputStream.readString(5, false);
        this.iFrameRate = jceInputStream.read(this.iFrameRate, 6, false);
        this.strPraiseListPic = jceInputStream.readString(7, false);
        this.lUin = jceInputStream.read(this.lUin, 8, false);
        this.iType = jceInputStream.read(this.iType, 9, false);
        this.iSubPraisetype = jceInputStream.read(this.iSubPraisetype, 10, false);
        this.strPraisePicBefore = jceInputStream.readString(11, false);
        this.strPraiseZipAfter = jceInputStream.readString(12, false);
        this.strCmShowActionId = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strItemSummary;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strPraisePic;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strPraiseZip;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strPraiseComboZip;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.iFrameRate, 6);
        String str5 = this.strPraiseListPic;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.lUin, 8);
        jceOutputStream.write(this.iType, 9);
        jceOutputStream.write(this.iSubPraisetype, 10);
        String str6 = this.strPraisePicBefore;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        String str7 = this.strPraiseZipAfter;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        String str8 = this.strCmShowActionId;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
    }

    public QzmallCustomPraise(int i3, String str, String str2, String str3, String str4, int i16, String str5, long j3, int i17, int i18, String str6, String str7, String str8) {
        this.iItemId = i3;
        this.strItemSummary = str;
        this.strPraisePic = str2;
        this.strPraiseZip = str3;
        this.strPraiseComboZip = str4;
        this.iFrameRate = i16;
        this.strPraiseListPic = str5;
        this.lUin = j3;
        this.iType = i17;
        this.iSubPraisetype = i18;
        this.strPraisePicBefore = str6;
        this.strPraiseZipAfter = str7;
        this.strCmShowActionId = str8;
    }
}
