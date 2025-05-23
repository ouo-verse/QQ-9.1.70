package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DCacheUserInfo extends JceStruct {
    static byte[] cache_strBlackList;
    public byte cPushNbTimes;
    public int iAtoRTimes;
    public int iRtoATimes;
    public int lTime;
    public byte[] strBlackList;

    public DCacheUserInfo() {
        this.strBlackList = null;
        this.lTime = 0;
        this.iAtoRTimes = 0;
        this.iRtoATimes = 0;
        this.cPushNbTimes = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_strBlackList == null) {
            cache_strBlackList = r0;
            byte[] bArr = {0};
        }
        this.strBlackList = jceInputStream.read(cache_strBlackList, 0, true);
        this.lTime = jceInputStream.read(this.lTime, 1, false);
        this.iAtoRTimes = jceInputStream.read(this.iAtoRTimes, 2, false);
        this.iRtoATimes = jceInputStream.read(this.iRtoATimes, 3, false);
        this.cPushNbTimes = jceInputStream.read(this.cPushNbTimes, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strBlackList, 0);
        jceOutputStream.write(this.lTime, 1);
        jceOutputStream.write(this.iAtoRTimes, 2);
        jceOutputStream.write(this.iRtoATimes, 3);
        jceOutputStream.write(this.cPushNbTimes, 4);
    }

    public DCacheUserInfo(byte[] bArr, int i3, int i16, int i17, byte b16) {
        this.strBlackList = bArr;
        this.lTime = i3;
        this.iAtoRTimes = i16;
        this.iRtoATimes = i17;
        this.cPushNbTimes = b16;
    }
}
