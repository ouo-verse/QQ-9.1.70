package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_card extends JceStruct {
    static Map<String, String> cache_ext;
    static ArrayList<event_photo> cache_photos = new ArrayList<>();
    static int cache_type;
    public String cardid;
    public String desc;
    public Map<String, String> ext;
    public ArrayList<event_photo> photos;
    public int status;
    public int type;

    static {
        cache_photos.add(new event_photo());
        cache_type = 0;
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
    }

    public event_card() {
        this.cardid = "";
        this.photos = null;
        this.status = 0;
        this.type = 0;
        this.desc = "";
        this.ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cardid = jceInputStream.readString(0, true);
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 1, true);
        this.status = jceInputStream.read(this.status, 2, true);
        this.type = jceInputStream.read(this.type, 3, false);
        this.desc = jceInputStream.readString(4, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cardid, 0);
        jceOutputStream.write((Collection) this.photos, 1);
        jceOutputStream.write(this.status, 2);
        jceOutputStream.write(this.type, 3);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public event_card(String str, ArrayList<event_photo> arrayList, int i3, int i16, String str2, Map<String, String> map) {
        this.cardid = str;
        this.photos = arrayList;
        this.status = i3;
        this.type = i16;
        this.desc = str2;
        this.ext = map;
    }
}
