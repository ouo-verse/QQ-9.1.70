package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tGetMusicInfoReq extends JceStruct {
    static ArrayList<String> cache_vecSongId;
    public int iNeedUrl;
    public long lUin;
    public ArrayList<String> vecSongId;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecSongId = arrayList;
        arrayList.add("");
    }

    public tGetMusicInfoReq() {
        this.lUin = 0L;
        this.vecSongId = null;
        this.iNeedUrl = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.vecSongId = (ArrayList) jceInputStream.read((JceInputStream) cache_vecSongId, 1, false);
        this.iNeedUrl = jceInputStream.read(this.iNeedUrl, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        ArrayList<String> arrayList = this.vecSongId;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.iNeedUrl, 2);
    }

    public tGetMusicInfoReq(long j3, ArrayList<String> arrayList, int i3) {
        this.lUin = j3;
        this.vecSongId = arrayList;
        this.iNeedUrl = i3;
    }
}
