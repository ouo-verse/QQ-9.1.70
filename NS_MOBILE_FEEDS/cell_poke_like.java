package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_poke_like extends JceStruct {
    static ArrayList<String> cache_emotion_id;
    public int count;
    public ArrayList<String> emotion_id;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_emotion_id = arrayList;
        arrayList.add("");
    }

    public cell_poke_like() {
        this.emotion_id = null;
        this.count = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.emotion_id = (ArrayList) jceInputStream.read((JceInputStream) cache_emotion_id, 0, false);
        this.count = jceInputStream.read(this.count, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.emotion_id;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.count, 1);
    }

    public cell_poke_like(ArrayList<String> arrayList, int i3) {
        this.emotion_id = arrayList;
        this.count = i3;
    }
}
