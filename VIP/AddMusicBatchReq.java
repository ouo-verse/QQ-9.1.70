package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddMusicBatchReq extends JceStruct {
    static SourceInfo cache_stSource;
    static ArrayList<MusicInfo> cache_vMusicList = new ArrayList<>();
    public long iUin;
    public SourceInfo stSource;
    public ArrayList<MusicInfo> vMusicList;

    static {
        cache_vMusicList.add(new MusicInfo());
        cache_stSource = new SourceInfo();
    }

    public AddMusicBatchReq() {
        this.iUin = 0L;
        this.vMusicList = null;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.vMusicList = (ArrayList) jceInputStream.read((JceInputStream) cache_vMusicList, 1, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        ArrayList<MusicInfo> arrayList = this.vMusicList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 2);
        }
    }

    public AddMusicBatchReq(long j3, ArrayList<MusicInfo> arrayList, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.vMusicList = arrayList;
        this.stSource = sourceInfo;
    }
}
