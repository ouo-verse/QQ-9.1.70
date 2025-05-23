package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_MusicListInfo extends JceStruct {
    static ArrayList<CKV_MusicInfo> cache_vMusicList = new ArrayList<>();
    public ArrayList<CKV_MusicInfo> vMusicList;

    static {
        cache_vMusicList.add(new CKV_MusicInfo());
    }

    public CKV_MusicListInfo() {
        this.vMusicList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vMusicList = (ArrayList) jceInputStream.read((JceInputStream) cache_vMusicList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<CKV_MusicInfo> arrayList = this.vMusicList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public CKV_MusicListInfo(ArrayList<CKV_MusicInfo> arrayList) {
        this.vMusicList = arrayList;
    }
}
