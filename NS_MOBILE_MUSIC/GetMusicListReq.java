package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMusicListReq extends JceStruct {
    static ArrayList<MusicID> cache_music_id;
    public ArrayList<MusicID> music_id;

    public GetMusicListReq() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_music_id == null) {
            cache_music_id = new ArrayList<>();
            cache_music_id.add(new MusicID());
        }
        this.music_id = (ArrayList) jceInputStream.read((JceInputStream) cache_music_id, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MusicID> arrayList = this.music_id;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetMusicListReq(ArrayList<MusicID> arrayList) {
        this.music_id = arrayList;
    }
}
