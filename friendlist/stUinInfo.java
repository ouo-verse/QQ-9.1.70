package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stUinInfo extends JceStruct {
    public byte cGender;
    public long dwFlag;
    public long dwuin;
    public String sEmail;
    public String sName;
    public String sPhone;
    public String sRemark;

    public stUinInfo() {
        this.dwuin = 0L;
        this.dwFlag = 0L;
        this.sName = "";
        this.cGender = (byte) 0;
        this.sPhone = "";
        this.sEmail = "";
        this.sRemark = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwuin = jceInputStream.read(this.dwuin, 0, true);
        this.dwFlag = jceInputStream.read(this.dwFlag, 1, true);
        this.sName = jceInputStream.readString(2, true);
        this.cGender = jceInputStream.read(this.cGender, 3, true);
        this.sPhone = jceInputStream.readString(4, true);
        this.sEmail = jceInputStream.readString(5, true);
        this.sRemark = jceInputStream.readString(6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwuin, 0);
        jceOutputStream.write(this.dwFlag, 1);
        jceOutputStream.write(this.sName, 2);
        jceOutputStream.write(this.cGender, 3);
        jceOutputStream.write(this.sPhone, 4);
        jceOutputStream.write(this.sEmail, 5);
        jceOutputStream.write(this.sRemark, 6);
    }

    public stUinInfo(long j3, long j16, String str, byte b16, String str2, String str3, String str4) {
        this.dwuin = j3;
        this.dwFlag = j16;
        this.sName = str;
        this.cGender = b16;
        this.sPhone = str2;
        this.sEmail = str3;
        this.sRemark = str4;
    }
}
