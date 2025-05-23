package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BindUin extends JceStruct {
    static byte[] cache_sKey;
    public int iStatus;
    public long lUin;
    public byte[] sKey;

    public BindUin() {
        this.lUin = 0L;
        this.sKey = null;
        this.iStatus = 11;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        if (cache_sKey == null) {
            cache_sKey = r0;
            byte[] bArr = {0};
        }
        this.sKey = jceInputStream.read(cache_sKey, 1, true);
        this.iStatus = jceInputStream.read(this.iStatus, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.sKey, 1);
        jceOutputStream.write(this.iStatus, 2);
    }

    public BindUin(long j3, byte[] bArr, int i3) {
        this.lUin = j3;
        this.sKey = bArr;
        this.iStatus = i3;
    }
}
