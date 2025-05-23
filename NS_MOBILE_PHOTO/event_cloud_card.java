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
public final class event_cloud_card extends JceStruct {
    static Map<String, String> cache_ext;
    static ArrayList<event_cloud_photo> cache_photos = new ArrayList<>();
    static int cache_type;
    public String desc;
    public Map<String, String> ext;
    public ArrayList<event_cloud_photo> photos;
    public int type;

    static {
        cache_photos.add(new event_cloud_photo());
        cache_type = 0;
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
    }

    public event_cloud_card() {
        this.photos = null;
        this.type = 0;
        this.desc = "";
        this.ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 0, true);
        this.type = jceInputStream.read(this.type, 1, false);
        this.desc = jceInputStream.readString(2, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.photos, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public event_cloud_card(ArrayList<event_cloud_photo> arrayList, int i3, String str, Map<String, String> map) {
        this.photos = arrayList;
        this.type = i3;
        this.desc = str;
        this.ext = map;
    }
}
