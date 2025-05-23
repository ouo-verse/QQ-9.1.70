package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_comm_mall extends JceStruct {
    static byte[] cache_busi_buff;
    public byte[] busi_buff;

    static {
        cache_busi_buff = r0;
        byte[] bArr = {0};
    }

    public cell_comm_mall() {
        this.busi_buff = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busi_buff = jceInputStream.read(cache_busi_buff, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.busi_buff;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public cell_comm_mall(byte[] bArr) {
        this.busi_buff = bArr;
    }
}
