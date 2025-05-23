package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetGroupRedPackListReq extends JceStruct {
    public String sGroupUin = "";
    public int iPlatForm = 0;
    public String sQQVersion = "";
    public int iGroupType = 0;
    public String sUin = "";
    public String sSkey = "";
    public String sClientIp = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sGroupUin = jceInputStream.readString(0, false);
        this.iPlatForm = jceInputStream.read(this.iPlatForm, 1, false);
        this.sQQVersion = jceInputStream.readString(2, false);
        this.iGroupType = jceInputStream.read(this.iGroupType, 3, false);
        this.sUin = jceInputStream.readString(4, false);
        this.sSkey = jceInputStream.readString(5, false);
        this.sClientIp = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sGroupUin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iPlatForm, 1);
        String str2 = this.sQQVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iGroupType, 3);
        String str3 = this.sUin;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.sSkey;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.sClientIp;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
    }
}
