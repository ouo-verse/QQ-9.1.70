package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddMusicReq extends JceStruct {
    static MusicInfo cache_stMusic = new MusicInfo();
    static SourceInfo cache_stSource = new SourceInfo();
    public long iUin;
    public MusicInfo stMusic;
    public SourceInfo stSource;

    public AddMusicReq() {
        this.iUin = 0L;
        this.stMusic = null;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.stMusic = (MusicInfo) jceInputStream.read((JceStruct) cache_stMusic, 1, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        MusicInfo musicInfo = this.stMusic;
        if (musicInfo != null) {
            jceOutputStream.write((JceStruct) musicInfo, 1);
        }
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 2);
        }
    }

    public AddMusicReq(long j3, MusicInfo musicInfo, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.stMusic = musicInfo;
        this.stSource = sourceInfo;
    }
}
