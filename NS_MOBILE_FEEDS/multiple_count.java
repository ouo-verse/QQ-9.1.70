package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class multiple_count extends JceStruct {
    static ArrayList<String> cache_icon;
    public ArrayList<String> icon;
    public int num;
    public int type;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_icon = arrayList;
        arrayList.add("");
    }

    public multiple_count() {
        this.type = 0;
        this.num = 0;
        this.icon = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.num = jceInputStream.read(this.num, 1, false);
        this.icon = (ArrayList) jceInputStream.read((JceInputStream) cache_icon, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.num, 1);
        ArrayList<String> arrayList = this.icon;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public multiple_count(int i3, int i16, ArrayList<String> arrayList) {
        this.type = i3;
        this.num = i16;
        this.icon = arrayList;
    }
}
