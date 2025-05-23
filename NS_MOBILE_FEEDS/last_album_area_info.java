package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class last_album_area_info extends JceStruct {
    static ArrayList<album_area_item> cache_pos = new ArrayList<>();
    public int anonymity;

    /* renamed from: id, reason: collision with root package name */
    public String f24987id;
    public String name;
    public ArrayList<album_area_item> pos;
    public long switch_state;

    static {
        cache_pos.add(new album_area_item());
    }

    public last_album_area_info() {
        this.f24987id = "";
        this.name = "";
        this.anonymity = 0;
        this.pos = null;
        this.switch_state = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24987id = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.anonymity = jceInputStream.read(this.anonymity, 2, false);
        this.pos = (ArrayList) jceInputStream.read((JceInputStream) cache_pos, 3, false);
        this.switch_state = jceInputStream.read(this.switch_state, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f24987id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.anonymity, 2);
        ArrayList<album_area_item> arrayList = this.pos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.switch_state, 4);
    }

    public last_album_area_info(String str, String str2, int i3, ArrayList<album_area_item> arrayList, long j3) {
        this.f24987id = str;
        this.name = str2;
        this.anonymity = i3;
        this.pos = arrayList;
        this.switch_state = j3;
    }
}
