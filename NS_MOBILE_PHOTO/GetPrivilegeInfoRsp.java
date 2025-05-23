package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPrivilegeInfoRsp extends JceStruct {
    public long bought_balance;
    public long free_balance;
    public long used_count;

    public GetPrivilegeInfoRsp() {
        this.free_balance = 0L;
        this.bought_balance = 0L;
        this.used_count = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.free_balance = jceInputStream.read(this.free_balance, 0, false);
        this.bought_balance = jceInputStream.read(this.bought_balance, 1, false);
        this.used_count = jceInputStream.read(this.used_count, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.free_balance, 0);
        jceOutputStream.write(this.bought_balance, 1);
        jceOutputStream.write(this.used_count, 2);
    }

    public GetPrivilegeInfoRsp(long j3, long j16, long j17) {
        this.free_balance = j3;
        this.bought_balance = j16;
        this.used_count = j17;
    }
}
