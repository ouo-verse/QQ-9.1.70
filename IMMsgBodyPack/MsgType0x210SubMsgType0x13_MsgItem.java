package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0x13_MsgItem extends JceStruct {
    static byte[] cache_bytes_text;
    public byte[] bytes_text;
    public long uint32_type;

    public MsgType0x210SubMsgType0x13_MsgItem() {
        this.uint32_type = 0L;
        this.bytes_text = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uint32_type = jceInputStream.read(this.uint32_type, 0, false);
        if (cache_bytes_text == null) {
            cache_bytes_text = r0;
            byte[] bArr = {0};
        }
        this.bytes_text = jceInputStream.read(cache_bytes_text, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uint32_type, 0);
        byte[] bArr = this.bytes_text;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public MsgType0x210SubMsgType0x13_MsgItem(long j3, byte[] bArr) {
        this.uint32_type = j3;
        this.bytes_text = bArr;
    }
}
