package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceReqInfo extends JceStruct {
    public short sLanType;
    public short sReqType;
    public short sResType;
    public String strPkgName;
    public long uiCurVer;
    public long uiResID;

    public GetResourceReqInfo() {
        this.uiResID = 0L;
        this.strPkgName = "";
        this.uiCurVer = 0L;
        this.sResType = (short) 0;
        this.sLanType = (short) 0;
        this.sReqType = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiResID = jceInputStream.read(this.uiResID, 1, true);
        this.strPkgName = jceInputStream.readString(2, true);
        this.uiCurVer = jceInputStream.read(this.uiCurVer, 3, true);
        this.sResType = jceInputStream.read(this.sResType, 4, true);
        this.sLanType = jceInputStream.read(this.sLanType, 5, true);
        this.sReqType = jceInputStream.read(this.sReqType, 6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiResID, 1);
        jceOutputStream.write(this.strPkgName, 2);
        jceOutputStream.write(this.uiCurVer, 3);
        jceOutputStream.write(this.sResType, 4);
        jceOutputStream.write(this.sLanType, 5);
        jceOutputStream.write(this.sReqType, 6);
    }

    public GetResourceReqInfo(long j3, String str, long j16, short s16, short s17, short s18) {
        this.uiResID = j3;
        this.strPkgName = str;
        this.uiCurVer = j16;
        this.sResType = s16;
        this.sLanType = s17;
        this.sReqType = s18;
    }
}
