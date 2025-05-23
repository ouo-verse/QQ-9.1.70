package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DelMusicReq extends JceStruct {
    static SourceInfo cache_stSource = new SourceInfo();
    public long iUin;
    public String sSongId;
    public SourceInfo stSource;

    public DelMusicReq() {
        this.iUin = 0L;
        this.sSongId = "";
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sSongId = jceInputStream.readString(1, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        String str = this.sSongId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 2);
        }
    }

    public DelMusicReq(long j3, String str, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.sSongId = str;
        this.stSource = sourceInfo;
    }
}
