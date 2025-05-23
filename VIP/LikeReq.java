package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LikeReq extends JceStruct {
    static SourceInfo cache_stSource = new SourceInfo();
    public long fromUin;
    public SourceInfo stSource;
    public long toUin;

    public LikeReq() {
        this.fromUin = 0L;
        this.toUin = 0L;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fromUin = jceInputStream.read(this.fromUin, 0, false);
        this.toUin = jceInputStream.read(this.toUin, 1, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fromUin, 0);
        jceOutputStream.write(this.toUin, 1);
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 2);
        }
    }

    public LikeReq(long j3, long j16, SourceInfo sourceInfo) {
        this.fromUin = j3;
        this.toUin = j16;
        this.stSource = sourceInfo;
    }
}
