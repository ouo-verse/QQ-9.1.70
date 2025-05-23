package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqGetPositionApi extends JceStruct {
    static byte[] cache_vLBSKeyData;
    public int iClientIp;
    public byte[] vLBSKeyData;

    public ReqGetPositionApi() {
        this.vLBSKeyData = null;
        this.iClientIp = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 0, true);
        this.iClientIp = jceInputStream.read(this.iClientIp, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vLBSKeyData, 0);
        jceOutputStream.write(this.iClientIp, 1);
    }

    public ReqGetPositionApi(byte[] bArr, int i3) {
        this.vLBSKeyData = bArr;
        this.iClientIp = i3;
    }
}
