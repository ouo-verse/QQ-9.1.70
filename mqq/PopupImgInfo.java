package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PopupImgInfo extends JceStruct {
    public int iOpen;
    public int iPopupVer;
    public int iRate;
    public int iRateType;
    public String sContinueText;
    public String sPopupImgUrl;
    public String sPopupText;
    public String sRedirectText;

    public PopupImgInfo() {
        this.iOpen = 0;
        this.iRate = 0;
        this.iPopupVer = 0;
        this.sPopupText = "";
        this.sRedirectText = "";
        this.sContinueText = "";
        this.sPopupImgUrl = "";
        this.iRateType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iOpen = jceInputStream.read(this.iOpen, 0, false);
        this.iRate = jceInputStream.read(this.iRate, 1, false);
        this.iPopupVer = jceInputStream.read(this.iPopupVer, 2, false);
        this.sPopupText = jceInputStream.readString(3, false);
        this.sRedirectText = jceInputStream.readString(4, false);
        this.sContinueText = jceInputStream.readString(5, false);
        this.sPopupImgUrl = jceInputStream.readString(6, false);
        this.iRateType = jceInputStream.read(this.iRateType, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iOpen, 0);
        jceOutputStream.write(this.iRate, 1);
        jceOutputStream.write(this.iPopupVer, 2);
        String str = this.sPopupText;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.sRedirectText;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.sContinueText;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.sPopupImgUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.iRateType, 7);
    }

    public PopupImgInfo(int i3, int i16, int i17, String str, String str2, String str3, String str4, int i18) {
        this.iOpen = i3;
        this.iRate = i16;
        this.iPopupVer = i17;
        this.sPopupText = str;
        this.sRedirectText = str2;
        this.sContinueText = str3;
        this.sPopupImgUrl = str4;
        this.iRateType = i18;
    }
}
