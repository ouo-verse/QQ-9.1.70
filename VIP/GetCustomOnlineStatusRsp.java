package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCustomOnlineStatusRsp extends JceStruct {
    public int iRet;
    public String sBuffer;
    public String sMsg;

    public GetCustomOnlineStatusRsp() {
        this.iRet = 0;
        this.sMsg = "";
        this.sBuffer = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, false);
        this.sMsg = jceInputStream.readString(1, false);
        this.sBuffer = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        String str = this.sMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sBuffer;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public GetCustomOnlineStatusRsp(int i3, String str, String str2) {
        this.iRet = i3;
        this.sMsg = str;
        this.sBuffer = str2;
    }
}
