package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusinessCheckItem extends JceStruct {
    public int appid;
    public String errmsg;
    public int itemid;
    public int ret;
    public String strAID;
    public String txRuleID;
    public String url;

    public UniBusinessCheckItem() {
        this.appid = 0;
        this.itemid = 0;
        this.ret = 0;
        this.errmsg = "";
        this.url = "";
        this.txRuleID = "";
        this.strAID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.itemid = jceInputStream.read(this.itemid, 1, false);
        this.ret = jceInputStream.read(this.ret, 2, false);
        this.errmsg = jceInputStream.readString(3, false);
        this.url = jceInputStream.readString(4, false);
        this.txRuleID = jceInputStream.readString(5, false);
        this.strAID = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.itemid, 1);
        jceOutputStream.write(this.ret, 2);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.txRuleID;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.strAID;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public UniBusinessCheckItem(int i3, int i16, int i17, String str, String str2, String str3, String str4) {
        this.appid = i3;
        this.itemid = i16;
        this.ret = i17;
        this.errmsg = str;
        this.url = str2;
        this.txRuleID = str3;
        this.strAID = str4;
    }
}
