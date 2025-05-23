package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_audio extends JceStruct {
    static ArrayList<s_audio> cache_audio = new ArrayList<>();
    public ArrayList<s_audio> audio;

    static {
        cache_audio.add(new s_audio());
    }

    public cell_audio() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.audio = (ArrayList) jceInputStream.read((JceInputStream) cache_audio, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_audio> arrayList = this.audio;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public cell_audio(ArrayList<s_audio> arrayList) {
        this.audio = arrayList;
    }
}
