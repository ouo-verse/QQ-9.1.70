package NS_BG_VOICE_LOGIC_APP;

import NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone;
import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BGFM extends JceStruct {
    static ArrayList<BroadcastForQzone> cache_stFmBroadcast;
    static ArrayList<BGMusicForQzone> cache_stFmLists = new ArrayList<>();
    public ArrayList<BroadcastForQzone> stFmBroadcast;
    public ArrayList<BGMusicForQzone> stFmLists;

    static {
        cache_stFmLists.add(new BGMusicForQzone());
        cache_stFmBroadcast = new ArrayList<>();
        cache_stFmBroadcast.add(new BroadcastForQzone());
    }

    public BGFM() {
        this.stFmLists = null;
        this.stFmBroadcast = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFmLists = (ArrayList) jceInputStream.read((JceInputStream) cache_stFmLists, 1, false);
        this.stFmBroadcast = (ArrayList) jceInputStream.read((JceInputStream) cache_stFmBroadcast, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<BGMusicForQzone> arrayList = this.stFmLists;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<BroadcastForQzone> arrayList2 = this.stFmBroadcast;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public BGFM(ArrayList<BGMusicForQzone> arrayList, ArrayList<BroadcastForQzone> arrayList2) {
        this.stFmLists = arrayList;
        this.stFmBroadcast = arrayList2;
    }
}
