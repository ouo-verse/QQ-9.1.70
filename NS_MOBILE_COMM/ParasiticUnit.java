package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ParasiticUnit extends JceStruct {
    static byte[] cache_vecData;
    public int iDataEdit;
    public int iDataType;
    public String strSubCmdCode;
    public byte[] vecData;

    static {
        cache_vecData = r0;
        byte[] bArr = {0};
    }

    public ParasiticUnit() {
        this.strSubCmdCode = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iDataType = jceInputStream.read(this.iDataType, 0, false);
        this.iDataEdit = jceInputStream.read(this.iDataEdit, 1, false);
        this.strSubCmdCode = jceInputStream.readString(2, false);
        this.vecData = jceInputStream.read(cache_vecData, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iDataType, 0);
        jceOutputStream.write(this.iDataEdit, 1);
        String str = this.strSubCmdCode;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        byte[] bArr = this.vecData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public ParasiticUnit(int i3, int i16, String str, byte[] bArr) {
        this.iDataType = i3;
        this.iDataEdit = i16;
        this.strSubCmdCode = str;
        this.vecData = bArr;
    }
}
