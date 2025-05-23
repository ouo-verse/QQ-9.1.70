package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InnerReqHeader extends JceStruct {
    public long iClientIp;
    public int iSeq;
    public long lUIN;
    public int nAppid;
    public short shVersion;
    public String strA2;
    public String strImei;
    public long uClientPort;

    public InnerReqHeader() {
        this.lUIN = 0L;
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.nAppid = 0;
        this.iClientIp = 0L;
        this.strA2 = "";
        this.uClientPort = 0L;
        this.strImei = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.shVersion = jceInputStream.read(this.shVersion, 1, true);
        this.iSeq = jceInputStream.read(this.iSeq, 2, true);
        this.nAppid = jceInputStream.read(this.nAppid, 3, true);
        this.iClientIp = jceInputStream.read(this.iClientIp, 4, false);
        this.strA2 = jceInputStream.readString(5, false);
        this.uClientPort = jceInputStream.read(this.uClientPort, 6, false);
        this.strImei = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.shVersion, 1);
        jceOutputStream.write(this.iSeq, 2);
        jceOutputStream.write(this.nAppid, 3);
        jceOutputStream.write(this.iClientIp, 4);
        String str = this.strA2;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.uClientPort, 6);
        String str2 = this.strImei;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
    }

    public InnerReqHeader(long j3, short s16, int i3, int i16, long j16, String str, long j17, String str2) {
        this.lUIN = j3;
        this.shVersion = s16;
        this.iSeq = i3;
        this.nAppid = i16;
        this.iClientIp = j16;
        this.strA2 = str;
        this.uClientPort = j17;
        this.strImei = str2;
    }
}
