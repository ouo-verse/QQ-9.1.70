package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AccessRsp extends JceStruct {
    static byte[] cache_body;
    static Tips cache_tips = new Tips();
    public byte[] body;
    public int ret;
    public Tips tips;

    static {
        cache_body = r0;
        byte[] bArr = {0};
    }

    public AccessRsp() {
        this.ret = 0;
        this.body = null;
        this.tips = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.body = jceInputStream.read(cache_body, 1, true);
        this.tips = (Tips) jceInputStream.read((JceStruct) cache_tips, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.body, 1);
        Tips tips = this.tips;
        if (tips != null) {
            jceOutputStream.write((JceStruct) tips, 2);
        }
    }

    public AccessRsp(int i3, byte[] bArr, Tips tips) {
        this.ret = i3;
        this.body = bArr;
        this.tips = tips;
    }
}
