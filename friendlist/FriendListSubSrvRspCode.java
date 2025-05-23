package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FriendListSubSrvRspCode extends JceStruct {
    public short wGetIntimateInfoRspCode;
    public short wGetMutualMarkRspCode;
    public short wGetRemarkRspCode;

    public FriendListSubSrvRspCode() {
        this.wGetMutualMarkRspCode = (short) 0;
        this.wGetIntimateInfoRspCode = (short) 0;
        this.wGetRemarkRspCode = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wGetMutualMarkRspCode = jceInputStream.read(this.wGetMutualMarkRspCode, 0, false);
        this.wGetIntimateInfoRspCode = jceInputStream.read(this.wGetIntimateInfoRspCode, 1, false);
        this.wGetRemarkRspCode = jceInputStream.read(this.wGetRemarkRspCode, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wGetMutualMarkRspCode, 0);
        jceOutputStream.write(this.wGetIntimateInfoRspCode, 1);
        jceOutputStream.write(this.wGetRemarkRspCode, 2);
    }

    public FriendListSubSrvRspCode(short s16, short s17, short s18) {
        this.wGetMutualMarkRspCode = s16;
        this.wGetIntimateInfoRspCode = s17;
        this.wGetRemarkRspCode = s18;
    }
}
