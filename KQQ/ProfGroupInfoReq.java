package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfGroupInfoReq extends JceStruct {
    public byte cIfGetAuthInfo;
    public byte cIsGetGroupAlbum;
    public byte cStatOption;
    public long dwTimeStamp;
    public long uGroupCode;
    public int wSourceID;
    public int wSourceSubID;

    public ProfGroupInfoReq() {
        this.uGroupCode = 0L;
        this.cIsGetGroupAlbum = (byte) 0;
        this.dwTimeStamp = 0L;
        this.cStatOption = (byte) 0;
        this.wSourceID = 0;
        this.wSourceSubID = 0;
        this.cIfGetAuthInfo = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uGroupCode = jceInputStream.read(this.uGroupCode, 0, true);
        this.cIsGetGroupAlbum = jceInputStream.read(this.cIsGetGroupAlbum, 1, false);
        this.dwTimeStamp = jceInputStream.read(this.dwTimeStamp, 2, false);
        this.cStatOption = jceInputStream.read(this.cStatOption, 3, false);
        this.wSourceID = jceInputStream.read(this.wSourceID, 4, false);
        this.wSourceSubID = jceInputStream.read(this.wSourceSubID, 5, false);
        this.cIfGetAuthInfo = jceInputStream.read(this.cIfGetAuthInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uGroupCode, 0);
        jceOutputStream.write(this.cIsGetGroupAlbum, 1);
        jceOutputStream.write(this.dwTimeStamp, 2);
        jceOutputStream.write(this.cStatOption, 3);
        jceOutputStream.write(this.wSourceID, 4);
        jceOutputStream.write(this.wSourceSubID, 5);
        jceOutputStream.write(this.cIfGetAuthInfo, 6);
    }

    public ProfGroupInfoReq(long j3, byte b16, long j16, byte b17, int i3, int i16, byte b18) {
        this.uGroupCode = j3;
        this.cIsGetGroupAlbum = b16;
        this.dwTimeStamp = j16;
        this.cStatOption = b17;
        this.wSourceID = i3;
        this.wSourceSubID = i16;
        this.cIfGetAuthInfo = b18;
    }
}
