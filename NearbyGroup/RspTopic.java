package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspTopic extends JceStruct {
    static byte[] cache_strRspTopic;
    public short shShowPos;
    public byte[] strRspTopic;

    public RspTopic() {
        this.shShowPos = (short) 4;
        this.strRspTopic = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shShowPos = jceInputStream.read(this.shShowPos, 0, true);
        if (cache_strRspTopic == null) {
            cache_strRspTopic = r0;
            byte[] bArr = {0};
        }
        this.strRspTopic = jceInputStream.read(cache_strRspTopic, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shShowPos, 0);
        jceOutputStream.write(this.strRspTopic, 1);
    }

    public RspTopic(short s16, byte[] bArr) {
        this.shShowPos = s16;
        this.strRspTopic = bArr;
    }
}
