package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BroadcastAudio extends JceStruct {
    static BroadcastUrl cache_masterUrl = new BroadcastUrl();
    static ArrayList<BroadcastUrl> cache_slaveUrl = new ArrayList<>();
    public BroadcastUrl masterUrl;
    public ArrayList<BroadcastUrl> slaveUrl;

    static {
        cache_slaveUrl.add(new BroadcastUrl());
    }

    public BroadcastAudio() {
        this.masterUrl = null;
        this.slaveUrl = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.masterUrl = (BroadcastUrl) jceInputStream.read((JceStruct) cache_masterUrl, 0, false);
        this.slaveUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_slaveUrl, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        BroadcastUrl broadcastUrl = this.masterUrl;
        if (broadcastUrl != null) {
            jceOutputStream.write((JceStruct) broadcastUrl, 0);
        }
        ArrayList<BroadcastUrl> arrayList = this.slaveUrl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public BroadcastAudio(BroadcastUrl broadcastUrl, ArrayList<BroadcastUrl> arrayList) {
        this.masterUrl = broadcastUrl;
        this.slaveUrl = arrayList;
    }
}
