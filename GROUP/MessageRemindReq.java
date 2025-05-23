package GROUP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MessageRemindReq extends JceStruct {
    public long dwAppId;
    public long iGroupCode;
    public String sKey;
    public String sKeyType;
    public long uOwnerUin;

    public MessageRemindReq() {
        this.iGroupCode = 0L;
        this.uOwnerUin = 0L;
        this.dwAppId = 0L;
        this.sKey = "";
        this.sKeyType = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iGroupCode = jceInputStream.read(this.iGroupCode, 0, true);
        this.uOwnerUin = jceInputStream.read(this.uOwnerUin, 1, true);
        this.dwAppId = jceInputStream.read(this.dwAppId, 2, true);
        this.sKey = jceInputStream.readString(3, true);
        this.sKeyType = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iGroupCode, 0);
        jceOutputStream.write(this.uOwnerUin, 1);
        jceOutputStream.write(this.dwAppId, 2);
        jceOutputStream.write(this.sKey, 3);
        String str = this.sKeyType;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public MessageRemindReq(long j3, long j16, long j17, String str, String str2) {
        this.iGroupCode = j3;
        this.uOwnerUin = j16;
        this.dwAppId = j17;
        this.sKey = str;
        this.sKeyType = str2;
    }
}
