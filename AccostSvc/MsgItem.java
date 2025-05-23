package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgItem extends JceStruct {
    static byte[] cache_MsgContent;
    public byte[] MsgContent;
    public byte cType;

    public MsgItem() {
        this.cType = (byte) 0;
        this.MsgContent = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cType = jceInputStream.read(this.cType, 0, true);
        if (cache_MsgContent == null) {
            cache_MsgContent = r0;
            byte[] bArr = {0};
        }
        this.MsgContent = jceInputStream.read(cache_MsgContent, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cType, 0);
        jceOutputStream.write(this.MsgContent, 1);
    }

    public MsgItem(byte b16, byte[] bArr) {
        this.cType = b16;
        this.MsgContent = bArr;
    }
}
