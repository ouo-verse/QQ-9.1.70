package MCommon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Sharkfin extends JceStruct {
    public int apn = 0;
    public int authType = 0;
    public String guid = "";
    public String ext1 = "";
    public String sessionId = "";
    public int buildno = 0;
    public int netType = 0;
    public long accountId = 0;
    public int bootType = 0;
    public String wsGuid = "";

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new Sharkfin();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.apn = jceInputStream.read(this.apn, 0, true);
        this.authType = jceInputStream.read(this.authType, 1, true);
        this.guid = jceInputStream.readString(2, false);
        this.ext1 = jceInputStream.readString(3, false);
        this.sessionId = jceInputStream.readString(4, false);
        this.buildno = jceInputStream.read(this.buildno, 5, false);
        this.netType = jceInputStream.read(this.netType, 6, false);
        this.accountId = jceInputStream.read(this.accountId, 7, false);
        this.bootType = jceInputStream.read(this.bootType, 8, false);
        this.wsGuid = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.apn, 0);
        jceOutputStream.write(this.authType, 1);
        String str = this.guid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.ext1;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.sessionId;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        int i3 = this.buildno;
        if (i3 != 0) {
            jceOutputStream.write(i3, 5);
        }
        int i16 = this.netType;
        if (i16 != 0) {
            jceOutputStream.write(i16, 6);
        }
        long j3 = this.accountId;
        if (j3 != 0) {
            jceOutputStream.write(j3, 7);
        }
        int i17 = this.bootType;
        if (i17 != 0) {
            jceOutputStream.write(i17, 8);
        }
        String str4 = this.wsGuid;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }
}
