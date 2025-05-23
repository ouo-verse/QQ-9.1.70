package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stcustomPraise extends JceStruct {
    public int customPraisetype;
    public int iFrameRate;
    public int iItemId;
    public int iPraiseActId;
    public String strPraiseButton;
    public String strPraiseComboZip;
    public String strPraisePic;
    public String strPraiseZip;
    public int subpraisetype;
    public long uiComboCount;

    public stcustomPraise() {
        this.iItemId = 0;
        this.strPraisePic = "";
        this.strPraiseZip = "";
        this.strPraiseComboZip = "";
        this.iFrameRate = 0;
        this.strPraiseButton = "";
        this.customPraisetype = 0;
        this.uiComboCount = 0L;
        this.subpraisetype = 0;
        this.iPraiseActId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strPraisePic = jceInputStream.readString(1, false);
        this.strPraiseZip = jceInputStream.readString(2, false);
        this.strPraiseComboZip = jceInputStream.readString(3, false);
        this.iFrameRate = jceInputStream.read(this.iFrameRate, 4, false);
        this.strPraiseButton = jceInputStream.readString(5, false);
        this.customPraisetype = jceInputStream.read(this.customPraisetype, 6, false);
        this.uiComboCount = jceInputStream.read(this.uiComboCount, 7, false);
        this.subpraisetype = jceInputStream.read(this.subpraisetype, 8, false);
        this.iPraiseActId = jceInputStream.read(this.iPraiseActId, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strPraisePic;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strPraiseZip;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strPraiseComboZip;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.iFrameRate, 4);
        String str4 = this.strPraiseButton;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.customPraisetype, 6);
        jceOutputStream.write(this.uiComboCount, 7);
        jceOutputStream.write(this.subpraisetype, 8);
        jceOutputStream.write(this.iPraiseActId, 9);
    }

    public stcustomPraise(int i3, String str, String str2, String str3, int i16, String str4, int i17, long j3, int i18, int i19) {
        this.iItemId = i3;
        this.strPraisePic = str;
        this.strPraiseZip = str2;
        this.strPraiseComboZip = str3;
        this.iFrameRate = i16;
        this.strPraiseButton = str4;
        this.customPraisetype = i17;
        this.uiComboCount = j3;
        this.subpraisetype = i18;
        this.iPraiseActId = i19;
    }
}
