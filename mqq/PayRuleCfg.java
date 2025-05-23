package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PayRuleCfg extends JceStruct {
    static ShowRule cache_rule = new ShowRule();
    public String advId;
    public String aid;
    public int clickHide;
    public int clubType;
    public int enable;
    public String iconJumpUrl;
    public String iconText;
    public String iconTextCol;
    public String iconUrl;
    public String iosAid;
    public int payHide;
    public ShowRule rule;
    public int update;
    public int userType;

    public PayRuleCfg() {
        this.enable = 0;
        this.aid = "";
        this.iconText = "";
        this.iconUrl = "";
        this.iconJumpUrl = "";
        this.rule = null;
        this.advId = "";
        this.iconTextCol = "";
        this.iosAid = "";
        this.update = 0;
        this.userType = 0;
        this.clubType = 0;
        this.clickHide = 0;
        this.payHide = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enable = jceInputStream.read(this.enable, 0, false);
        this.aid = jceInputStream.readString(1, false);
        this.iconText = jceInputStream.readString(2, false);
        this.iconUrl = jceInputStream.readString(3, false);
        this.iconJumpUrl = jceInputStream.readString(4, false);
        this.rule = (ShowRule) jceInputStream.read((JceStruct) cache_rule, 5, false);
        this.advId = jceInputStream.readString(6, false);
        this.iconTextCol = jceInputStream.readString(7, false);
        this.iosAid = jceInputStream.readString(8, false);
        this.update = jceInputStream.read(this.update, 9, false);
        this.userType = jceInputStream.read(this.userType, 10, false);
        this.clubType = jceInputStream.read(this.clubType, 11, false);
        this.clickHide = jceInputStream.read(this.clickHide, 12, false);
        this.payHide = jceInputStream.read(this.payHide, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "PayRuleCfg{enable=" + this.enable + ", aid='" + this.aid + "', iconText='" + this.iconText + "', iconUrl='" + this.iconUrl + "', iconJumpUrl='" + this.iconJumpUrl + "', rule=" + this.rule + ", advId='" + this.advId + "', iconTextCol='" + this.iconTextCol + "', iosAid='" + this.iosAid + "', update=" + this.update + ", userType=" + this.userType + ", clubType=" + this.clubType + ", clickHide=" + this.clickHide + ", payHide=" + this.payHide + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enable, 0);
        String str = this.aid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.iconText;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.iconUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.iconJumpUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        ShowRule showRule = this.rule;
        if (showRule != null) {
            jceOutputStream.write((JceStruct) showRule, 5);
        }
        String str5 = this.advId;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.iconTextCol;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.iosAid;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.update, 9);
        jceOutputStream.write(this.userType, 10);
        jceOutputStream.write(this.clubType, 11);
        jceOutputStream.write(this.clickHide, 12);
        jceOutputStream.write(this.payHide, 13);
    }

    public PayRuleCfg(int i3, String str, String str2, String str3, String str4, ShowRule showRule, String str5, String str6, String str7, int i16, int i17, int i18, int i19, int i26) {
        this.enable = i3;
        this.aid = str;
        this.iconText = str2;
        this.iconUrl = str3;
        this.iconJumpUrl = str4;
        this.rule = showRule;
        this.advId = str5;
        this.iconTextCol = str6;
        this.iosAid = str7;
        this.update = i16;
        this.userType = i17;
        this.clubType = i18;
        this.clickHide = i19;
        this.payHide = i26;
    }
}
