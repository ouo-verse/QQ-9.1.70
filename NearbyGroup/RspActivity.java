package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspActivity extends JceStruct {
    static byte[] cache_strRspAct;
    public short shShowPos;
    public byte[] strRspAct;

    public RspActivity() {
        this.shShowPos = (short) 2;
        this.strRspAct = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shShowPos = jceInputStream.read(this.shShowPos, 0, true);
        if (cache_strRspAct == null) {
            cache_strRspAct = r0;
            byte[] bArr = {0};
        }
        this.strRspAct = jceInputStream.read(cache_strRspAct, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shShowPos, 0);
        jceOutputStream.write(this.strRspAct, 1);
    }

    public RspActivity(short s16, byte[] bArr) {
        this.shShowPos = s16;
        this.strRspAct = bArr;
    }
}
