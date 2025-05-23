package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SetMusicPosReq extends JceStruct {
    static SourceInfo cache_stSource = new SourceInfo();
    public int iPos;
    public long iUin;
    public String sSongId;
    public SourceInfo stSource;

    public SetMusicPosReq() {
        this.iUin = 0L;
        this.sSongId = "";
        this.iPos = 0;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sSongId = jceInputStream.readString(1, false);
        this.iPos = jceInputStream.read(this.iPos, 2, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        String str = this.sSongId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iPos, 2);
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 3);
        }
    }

    public SetMusicPosReq(long j3, String str, int i3, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.sSongId = str;
        this.iPos = i3;
        this.stSource = sourceInfo;
    }
}
