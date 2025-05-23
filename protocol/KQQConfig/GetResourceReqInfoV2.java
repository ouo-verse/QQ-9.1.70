package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceReqInfoV2 extends JceStruct {
    public byte cDelFlag;
    public byte cPush;
    public byte cState;
    public byte cStatus;
    public int iPluginType;
    public short sLanType;
    public short sResSubType;
    public String strPkgName;
    public long uiCurVer;
    public long uiResId;

    public GetResourceReqInfoV2() {
        this.strPkgName = "";
        this.uiCurVer = 0L;
        this.sResSubType = (short) 0;
        this.sLanType = (short) 0;
        this.cState = (byte) 0;
        this.uiResId = 0L;
        this.cStatus = (byte) 0;
        this.cPush = (byte) 0;
        this.iPluginType = 64;
        this.cDelFlag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPkgName = jceInputStream.readString(1, true);
        this.uiCurVer = jceInputStream.read(this.uiCurVer, 2, true);
        this.sResSubType = jceInputStream.read(this.sResSubType, 3, true);
        this.sLanType = jceInputStream.read(this.sLanType, 4, true);
        this.cState = jceInputStream.read(this.cState, 5, true);
        this.uiResId = jceInputStream.read(this.uiResId, 6, false);
        this.cStatus = jceInputStream.read(this.cStatus, 7, false);
        this.cPush = jceInputStream.read(this.cPush, 8, false);
        this.iPluginType = jceInputStream.read(this.iPluginType, 9, false);
        this.cDelFlag = jceInputStream.read(this.cDelFlag, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPkgName, 1);
        jceOutputStream.write(this.uiCurVer, 2);
        jceOutputStream.write(this.sResSubType, 3);
        jceOutputStream.write(this.sLanType, 4);
        jceOutputStream.write(this.cState, 5);
        jceOutputStream.write(this.uiResId, 6);
        jceOutputStream.write(this.cStatus, 7);
        jceOutputStream.write(this.cPush, 8);
        jceOutputStream.write(this.iPluginType, 9);
        jceOutputStream.write(this.cDelFlag, 10);
    }

    public GetResourceReqInfoV2(String str, long j3, short s16, short s17, byte b16, long j16, byte b17, byte b18, int i3, byte b19) {
        this.strPkgName = str;
        this.uiCurVer = j3;
        this.sResSubType = s16;
        this.sLanType = s17;
        this.cState = b16;
        this.uiResId = j16;
        this.cStatus = b17;
        this.cPush = b18;
        this.iPluginType = i3;
        this.cDelFlag = b19;
    }
}
