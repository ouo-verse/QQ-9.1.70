package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BroadcastForQzone extends JceStruct {
    static BroadcastAudio cache_broadcastAudioUrl = new BroadcastAudio();
    static ArrayList<BroadcastOneShow> cache_showList = new ArrayList<>();
    public BroadcastAudio broadcastAudioUrl;
    public String broadcastID;
    public String broadcastName;
    public ArrayList<BroadcastOneShow> showList;

    static {
        cache_showList.add(new BroadcastOneShow());
    }

    public BroadcastForQzone() {
        this.broadcastID = "";
        this.broadcastName = "";
        this.broadcastAudioUrl = null;
        this.showList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.broadcastID = jceInputStream.readString(0, false);
        this.broadcastName = jceInputStream.readString(1, false);
        this.broadcastAudioUrl = (BroadcastAudio) jceInputStream.read((JceStruct) cache_broadcastAudioUrl, 2, false);
        this.showList = (ArrayList) jceInputStream.read((JceInputStream) cache_showList, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.broadcastID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.broadcastName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        BroadcastAudio broadcastAudio = this.broadcastAudioUrl;
        if (broadcastAudio != null) {
            jceOutputStream.write((JceStruct) broadcastAudio, 2);
        }
        ArrayList<BroadcastOneShow> arrayList = this.showList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public BroadcastForQzone(String str, String str2, BroadcastAudio broadcastAudio, ArrayList<BroadcastOneShow> arrayList) {
        this.broadcastID = str;
        this.broadcastName = str2;
        this.broadcastAudioUrl = broadcastAudio;
        this.showList = arrayList;
    }
}
