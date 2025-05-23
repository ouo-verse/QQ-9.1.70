package NS_COMM_UPLOAD_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CUploadDownstream extends JceStruct {
    static byte[] cache_extra;
    public byte[] extra;
    public int retcode;
    public String serverID;

    static {
        cache_extra = r0;
        byte[] bArr = {0};
    }

    public CUploadDownstream() {
        this.retcode = 0;
        this.serverID = "";
        this.extra = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retcode = jceInputStream.read(this.retcode, 0, false);
        this.serverID = jceInputStream.readString(1, false);
        this.extra = jceInputStream.read(cache_extra, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retcode, 0);
        String str = this.serverID;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        byte[] bArr = this.extra;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public CUploadDownstream(int i3, String str, byte[] bArr) {
        this.retcode = i3;
        this.serverID = str;
        this.extra = bArr;
    }
}
