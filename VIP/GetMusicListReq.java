package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMusicListReq extends JceStruct {
    static SourceInfo cache_stSource = new SourceInfo();
    public int iMode;
    public long iNum;
    public long iUin;
    public String sCookie;
    public SourceInfo stSource;

    public GetMusicListReq() {
        this.iUin = 0L;
        this.sCookie = "";
        this.iNum = 0L;
        this.stSource = null;
        this.iMode = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sCookie = jceInputStream.readString(1, false);
        this.iNum = jceInputStream.read(this.iNum, 2, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 3, false);
        this.iMode = jceInputStream.read(this.iMode, 4, false);
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
        jceOutputStream.write(this.iMode, 4);
    }

    public GetMusicListReq(long j3, String str, long j16, SourceInfo sourceInfo, int i3) {
        this.iUin = j3;
        this.sCookie = str;
        this.iNum = j16;
        this.stSource = sourceInfo;
        this.iMode = i3;
    }
}
