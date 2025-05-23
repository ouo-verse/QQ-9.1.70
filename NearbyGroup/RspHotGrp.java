package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspHotGrp extends JceStruct {
    static byte[] cache_strRspHotGrp;
    public short shShowPos;
    public byte[] strRspHotGrp;

    public RspHotGrp() {
        this.strRspHotGrp = null;
        this.shShowPos = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_strRspHotGrp == null) {
            cache_strRspHotGrp = r0;
            byte[] bArr = {0};
        }
        this.strRspHotGrp = jceInputStream.read(cache_strRspHotGrp, 0, true);
        this.shShowPos = jceInputStream.read(this.shShowPos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strRspHotGrp, 0);
        jceOutputStream.write(this.shShowPos, 1);
    }

    public RspHotGrp(byte[] bArr, short s16) {
        this.strRspHotGrp = bArr;
        this.shShowPos = s16;
    }
}
