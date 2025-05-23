package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QbossAdv extends JceStruct {
    public int iAdId;
    public int iAdType;
    public int iBoardId;
    public String sBosstrace;
    public String sExtData;
    public String sPostrace;

    public QbossAdv() {
        this.sBosstrace = "";
        this.sExtData = "";
        this.sPostrace = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAdId = jceInputStream.read(this.iAdId, 0, true);
        this.iAdType = jceInputStream.read(this.iAdType, 1, true);
        this.iBoardId = jceInputStream.read(this.iBoardId, 2, true);
        this.sBosstrace = jceInputStream.readString(3, true);
        this.sExtData = jceInputStream.readString(4, true);
        this.sPostrace = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAdId, 0);
        jceOutputStream.write(this.iAdType, 1);
        jceOutputStream.write(this.iBoardId, 2);
        jceOutputStream.write(this.sBosstrace, 3);
        jceOutputStream.write(this.sExtData, 4);
        jceOutputStream.write(this.sPostrace, 5);
    }

    public QbossAdv(int i3, int i16, int i17, String str, String str2, String str3) {
        this.iAdId = i3;
        this.iAdType = i16;
        this.iBoardId = i17;
        this.sBosstrace = str;
        this.sExtData = str2;
        this.sPostrace = str3;
    }
}
