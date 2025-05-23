package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestVerifySmscode extends JceStruct {
    static byte[] cache_sessionSid;
    static int cache_type;
    public boolean isFromChangeBind;
    public boolean isFromUni;
    public byte[] sessionSid;
    public String smsCode;
    public int type;

    public RequestVerifySmscode() {
        this.smsCode = "";
        this.sessionSid = null;
        this.type = 0;
        this.isFromUni = false;
        this.isFromChangeBind = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.smsCode = jceInputStream.readString(0, true);
        if (cache_sessionSid == null) {
            cache_sessionSid = r2;
            byte[] bArr = {0};
        }
        this.sessionSid = jceInputStream.read(cache_sessionSid, 1, true);
        this.type = jceInputStream.read(this.type, 2, false);
        this.isFromUni = jceInputStream.read(this.isFromUni, 3, false);
        this.isFromChangeBind = jceInputStream.read(this.isFromChangeBind, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.smsCode, 0);
        jceOutputStream.write(this.sessionSid, 1);
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.isFromUni, 3);
        jceOutputStream.write(this.isFromChangeBind, 4);
    }

    public RequestVerifySmscode(String str, byte[] bArr, int i3, boolean z16, boolean z17) {
        this.smsCode = str;
        this.sessionSid = bArr;
        this.type = i3;
        this.isFromUni = z16;
        this.isFromChangeBind = z17;
    }
}
