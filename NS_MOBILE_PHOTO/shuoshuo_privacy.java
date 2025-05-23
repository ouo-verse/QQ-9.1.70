package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class shuoshuo_privacy extends JceStruct {
    static ArrayList<Long> cache_mood_allowuins;
    public ArrayList<Long> mood_allowuins;
    public String mood_permission;

    public shuoshuo_privacy() {
        this.mood_permission = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mood_permission = jceInputStream.readString(0, true);
        if (cache_mood_allowuins == null) {
            cache_mood_allowuins = new ArrayList<>();
            cache_mood_allowuins.add(0L);
        }
        this.mood_allowuins = (ArrayList) jceInputStream.read((JceInputStream) cache_mood_allowuins, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mood_permission, 0);
        ArrayList<Long> arrayList = this.mood_allowuins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public shuoshuo_privacy(String str, ArrayList<Long> arrayList) {
        this.mood_permission = str;
        this.mood_allowuins = arrayList;
    }
}
