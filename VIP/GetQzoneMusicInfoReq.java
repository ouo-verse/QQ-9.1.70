package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetQzoneMusicInfoReq extends JceStruct {
    static SourceInfo cache_stSource;
    static ArrayList<String> cache_vSongIdList;
    public long iUin;
    public SourceInfo stSource;
    public ArrayList<String> vSongIdList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vSongIdList = arrayList;
        arrayList.add("");
        cache_stSource = new SourceInfo();
    }

    public GetQzoneMusicInfoReq() {
        this.iUin = 0L;
        this.vSongIdList = null;
        this.stSource = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.vSongIdList = (ArrayList) jceInputStream.read((JceInputStream) cache_vSongIdList, 1, false);
        this.stSource = (SourceInfo) jceInputStream.read((JceStruct) cache_stSource, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        ArrayList<String> arrayList = this.vSongIdList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        SourceInfo sourceInfo = this.stSource;
        if (sourceInfo != null) {
            jceOutputStream.write((JceStruct) sourceInfo, 2);
        }
    }

    public GetQzoneMusicInfoReq(long j3, ArrayList<String> arrayList, SourceInfo sourceInfo) {
        this.iUin = j3;
        this.vSongIdList = arrayList;
        this.stSource = sourceInfo;
    }
}
