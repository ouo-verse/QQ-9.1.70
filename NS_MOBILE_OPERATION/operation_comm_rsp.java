package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_comm_rsp extends JceStruct {
    static byte[] cache_message;
    public byte[] message;

    /* renamed from: msg, reason: collision with root package name */
    public String f25013msg;
    public int ret;

    static {
        cache_message = r0;
        byte[] bArr = {0};
    }

    public operation_comm_rsp() {
        this.ret = 0;
        this.f25013msg = "";
        this.message = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25013msg = jceInputStream.readString(1, false);
        this.message = jceInputStream.read(cache_message, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25013msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        byte[] bArr = this.message;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public operation_comm_rsp(int i3, String str, byte[] bArr) {
        this.ret = i3;
        this.f25013msg = str;
        this.message = bArr;
    }
}
