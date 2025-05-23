package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMusicListRsp extends JceStruct {
    static ArrayList<MusicInfo> cache_music_list;
    public ArrayList<MusicInfo> music_list;

    public GetMusicListRsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_music_list == null) {
            cache_music_list = new ArrayList<>();
            cache_music_list.add(new MusicInfo());
        }
        this.music_list = (ArrayList) jceInputStream.read((JceInputStream) cache_music_list, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MusicInfo> arrayList = this.music_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetMusicListRsp(ArrayList<MusicInfo> arrayList) {
        this.music_list = arrayList;
    }
}
