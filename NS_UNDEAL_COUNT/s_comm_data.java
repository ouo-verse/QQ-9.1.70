package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_comm_data extends JceStruct {
    static byte[] cache_vecData;
    public int iHasDataFlag;
    public String strAttachInfo;
    public byte[] vecData;

    public s_comm_data() {
        this.strAttachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iHasDataFlag = jceInputStream.read(this.iHasDataFlag, 0, false);
        this.strAttachInfo = jceInputStream.readString(1, false);
        if (cache_vecData == null) {
            cache_vecData = r0;
            byte[] bArr = {0};
        }
        this.vecData = jceInputStream.read(cache_vecData, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iHasDataFlag, 0);
        String str = this.strAttachInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        byte[] bArr = this.vecData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public s_comm_data(int i3, String str, byte[] bArr) {
        this.iHasDataFlag = i3;
        this.strAttachInfo = str;
        this.vecData = bArr;
    }
}
