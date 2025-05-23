package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RoamInfo extends JceStruct {
    public byte cValue;
    public long lFriendUin;

    public RoamInfo() {
        this.lFriendUin = 0L;
        this.cValue = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFriendUin = jceInputStream.read(this.lFriendUin, 0, true);
        this.cValue = jceInputStream.read(this.cValue, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFriendUin, 0);
        jceOutputStream.write(this.cValue, 1);
    }

    public RoamInfo(long j3, byte b16) {
        this.lFriendUin = j3;
        this.cValue = b16;
    }
}
