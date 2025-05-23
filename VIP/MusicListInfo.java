package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MusicListInfo extends JceStruct {
    static ArrayList<MusicInfo> cache_vMusicList = new ArrayList<>();
    public ArrayList<MusicInfo> vMusicList;

    static {
        cache_vMusicList.add(new MusicInfo());
    }

    public MusicListInfo() {
        this.vMusicList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vMusicList = (ArrayList) jceInputStream.read((JceInputStream) cache_vMusicList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MusicInfo> arrayList = this.vMusicList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public MusicListInfo(ArrayList<MusicInfo> arrayList) {
        this.vMusicList = arrayList;
    }
}
