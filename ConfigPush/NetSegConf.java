package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NetSegConf extends JceStruct {
    public long uint32_curconnnum;
    public long uint32_net_type;
    public long uint32_segnum;
    public long uint32_segsize;

    public NetSegConf() {
        this.uint32_net_type = 0L;
        this.uint32_segsize = 0L;
        this.uint32_segnum = 0L;
        this.uint32_curconnnum = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uint32_net_type = jceInputStream.read(this.uint32_net_type, 0, false);
        this.uint32_segsize = jceInputStream.read(this.uint32_segsize, 1, false);
        this.uint32_segnum = jceInputStream.read(this.uint32_segnum, 2, false);
        this.uint32_curconnnum = jceInputStream.read(this.uint32_curconnnum, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uint32_net_type, 0);
        jceOutputStream.write(this.uint32_segsize, 1);
        jceOutputStream.write(this.uint32_segnum, 2);
        jceOutputStream.write(this.uint32_curconnnum, 3);
    }

    public NetSegConf(long j3, long j16, long j17, long j18) {
        this.uint32_net_type = j3;
        this.uint32_segsize = j16;
        this.uint32_segnum = j17;
        this.uint32_curconnnum = j18;
    }
}
