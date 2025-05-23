package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetAutoInfoResp extends JceStruct {
    static int cache_result;
    public byte cGroupID;
    public short errorCode;
    public int result;
    public String strGroupName;
    public String strRemark;

    public GetAutoInfoResp() {
        this.result = 0;
        this.errorCode = (short) 0;
        this.strRemark = "";
        this.cGroupID = (byte) 0;
        this.strGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.errorCode = jceInputStream.read(this.errorCode, 1, true);
        this.strRemark = jceInputStream.readString(2, true);
        this.cGroupID = jceInputStream.read(this.cGroupID, 3, true);
        this.strGroupName = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.errorCode, 1);
        jceOutputStream.write(this.strRemark, 2);
        jceOutputStream.write(this.cGroupID, 3);
        jceOutputStream.write(this.strGroupName, 4);
    }

    public GetAutoInfoResp(int i3, short s16, String str, byte b16, String str2) {
        this.result = i3;
        this.errorCode = s16;
        this.strRemark = str;
        this.cGroupID = b16;
        this.strGroupName = str2;
    }
}
