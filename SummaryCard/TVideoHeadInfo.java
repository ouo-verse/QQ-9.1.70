package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TVideoHeadInfo extends JceStruct {
    static byte[] cache_vMsg;
    public int iBasicFlag;
    public int iNearbyFlag;
    public byte[] vMsg;

    static {
        cache_vMsg = r0;
        byte[] bArr = {0};
    }

    public TVideoHeadInfo() {
        this.iNearbyFlag = 0;
        this.iBasicFlag = 0;
        this.vMsg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iNearbyFlag = jceInputStream.read(this.iNearbyFlag, 0, false);
        this.iBasicFlag = jceInputStream.read(this.iBasicFlag, 1, false);
        this.vMsg = jceInputStream.read(cache_vMsg, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iNearbyFlag, 0);
        jceOutputStream.write(this.iBasicFlag, 1);
        byte[] bArr = this.vMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public TVideoHeadInfo(int i3, int i16, byte[] bArr) {
        this.iNearbyFlag = i3;
        this.iBasicFlag = i16;
        this.vMsg = bArr;
    }
}
