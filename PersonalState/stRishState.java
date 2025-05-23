package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRishState extends JceStruct {
    static byte[] cache_vState;
    public long uModifyTime;
    public byte[] vState;

    public stRishState() {
        this.vState = null;
        this.uModifyTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vState == null) {
            cache_vState = r0;
            byte[] bArr = {0};
        }
        this.vState = jceInputStream.read(cache_vState, 0, true);
        this.uModifyTime = jceInputStream.read(this.uModifyTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vState, 0);
        jceOutputStream.write(this.uModifyTime, 1);
    }

    public stRishState(byte[] bArr, long j3) {
        this.vState = bArr;
        this.uModifyTime = j3;
    }
}
