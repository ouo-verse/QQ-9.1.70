package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DeviceItemDes extends JceStruct {
    static byte[] cache_vecItemDes;
    public byte[] vecItemDes;

    public DeviceItemDes() {
        this.vecItemDes = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecItemDes == null) {
            cache_vecItemDes = r0;
            byte[] bArr = {0};
        }
        this.vecItemDes = jceInputStream.read(cache_vecItemDes, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecItemDes, 0);
    }

    public DeviceItemDes(byte[] bArr) {
        this.vecItemDes = bArr;
    }
}
