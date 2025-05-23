package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientOnlineNotfiyReq extends JceStruct {
    static byte[] cache_AttachInfo;
    public byte[] AttachInfo;
    public long LastMsgTime;

    static {
        cache_AttachInfo = r0;
        byte[] bArr = {0};
    }

    public ClientOnlineNotfiyReq() {
        this.AttachInfo = null;
        this.LastMsgTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.AttachInfo = jceInputStream.read(cache_AttachInfo, 0, false);
        this.LastMsgTime = jceInputStream.read(this.LastMsgTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.AttachInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.LastMsgTime, 1);
    }

    public ClientOnlineNotfiyReq(byte[] bArr, long j3) {
        this.AttachInfo = bArr;
        this.LastMsgTime = j3;
    }
}
