package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLikeListReq extends JceStruct {
    static SourceInfo cache_stSource = new SourceInfo();
    public long iNum;
    public long iUin;
    public String sCookie;
    public SourceInfo stSource;

    public GetLikeListReq() {
        this.iUin = 0L;
        this.sCookie = "";
        this.iNum = 0L;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sCookie = jceInputStream.readString(1, false);
        this.iNum = jceInputStream.read(this.iNum, 2, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        String str = this.sCookie;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iNum, 2);
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 3);
        }
    }

    public GetLikeListReq(long j3, String str, long j16, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.sCookie = str;
        this.iNum = j16;
        this.stSource = sourceInfo;
    }
}
