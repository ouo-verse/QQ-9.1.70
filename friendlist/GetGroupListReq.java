package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetGroupListReq extends JceStruct {
    public byte flush;
    public byte getgroupCount;
    public byte startIndex;
    public long uin;

    public GetGroupListReq() {
        this.uin = 0L;
        this.startIndex = (byte) 0;
        this.getgroupCount = (byte) 0;
        this.flush = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.startIndex = jceInputStream.read(this.startIndex, 1, true);
        this.getgroupCount = jceInputStream.read(this.getgroupCount, 2, true);
        this.flush = jceInputStream.read(this.flush, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.startIndex, 1);
        jceOutputStream.write(this.getgroupCount, 2);
        jceOutputStream.write(this.flush, 3);
    }

    public GetGroupListReq(long j3, byte b16, byte b17, byte b18) {
        this.uin = j3;
        this.startIndex = b16;
        this.getgroupCount = b17;
        this.flush = b18;
    }
}
