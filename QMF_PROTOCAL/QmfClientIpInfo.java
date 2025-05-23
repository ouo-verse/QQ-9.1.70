package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfClientIpInfo extends JceStruct {
    static byte[] cache_ClientIpv6;
    public int ClientIpv4;
    public byte[] ClientIpv6;
    public short ClientPort;
    public byte IpType;

    public QmfClientIpInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.IpType = jceInputStream.read(this.IpType, 0, true);
        this.ClientPort = jceInputStream.read(this.ClientPort, 1, true);
        this.ClientIpv4 = jceInputStream.read(this.ClientIpv4, 2, true);
        if (cache_ClientIpv6 == null) {
            cache_ClientIpv6 = r0;
            byte[] bArr = {0};
        }
        this.ClientIpv6 = jceInputStream.read(cache_ClientIpv6, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.IpType, 0);
        jceOutputStream.write(this.ClientPort, 1);
        jceOutputStream.write(this.ClientIpv4, 2);
        byte[] bArr = this.ClientIpv6;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public QmfClientIpInfo(byte b16, short s16, int i3, byte[] bArr) {
        this.IpType = b16;
        this.ClientPort = s16;
        this.ClientIpv4 = i3;
        this.ClientIpv6 = bArr;
    }
}
