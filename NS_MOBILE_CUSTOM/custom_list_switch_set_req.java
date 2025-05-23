package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class custom_list_switch_set_req extends JceStruct {
    public int iAvatar;
    public int iCover;
    public int iCustomNavi;
    public int iCustomVip;
    public int iFacade;
    public int iFeedSkin;
    public int iFloat;
    public int iSetItemBits;
    public int iVisitorSkin;
    public String strTraceInfo;

    public custom_list_switch_set_req() {
        this.iSetItemBits = 0;
        this.iFeedSkin = 0;
        this.iFacade = 0;
        this.iAvatar = 0;
        this.iFloat = 0;
        this.iCover = 0;
        this.strTraceInfo = "";
        this.iVisitorSkin = 0;
        this.iCustomVip = 0;
        this.iCustomNavi = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iSetItemBits = jceInputStream.read(this.iSetItemBits, 0, false);
        this.iFeedSkin = jceInputStream.read(this.iFeedSkin, 1, false);
        this.iFacade = jceInputStream.read(this.iFacade, 2, false);
        this.iAvatar = jceInputStream.read(this.iAvatar, 3, false);
        this.iFloat = jceInputStream.read(this.iFloat, 4, false);
        this.iCover = jceInputStream.read(this.iCover, 5, false);
        this.strTraceInfo = jceInputStream.readString(6, false);
        this.iVisitorSkin = jceInputStream.read(this.iVisitorSkin, 7, false);
        this.iCustomVip = jceInputStream.read(this.iCustomVip, 8, false);
        this.iCustomNavi = jceInputStream.read(this.iCustomNavi, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iSetItemBits, 0);
        jceOutputStream.write(this.iFeedSkin, 1);
        jceOutputStream.write(this.iFacade, 2);
        jceOutputStream.write(this.iAvatar, 3);
        jceOutputStream.write(this.iFloat, 4);
        jceOutputStream.write(this.iCover, 5);
        String str = this.strTraceInfo;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.iVisitorSkin, 7);
        jceOutputStream.write(this.iCustomVip, 8);
        jceOutputStream.write(this.iCustomNavi, 9);
    }

    public custom_list_switch_set_req(int i3, int i16, int i17, int i18, int i19, int i26, String str, int i27, int i28, int i29) {
        this.iSetItemBits = i3;
        this.iFeedSkin = i16;
        this.iFacade = i17;
        this.iAvatar = i18;
        this.iFloat = i19;
        this.iCover = i26;
        this.strTraceInfo = str;
        this.iVisitorSkin = i27;
        this.iCustomVip = i28;
        this.iCustomNavi = i29;
    }
}
