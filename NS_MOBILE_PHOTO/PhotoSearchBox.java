package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PhotoSearchBox extends JceStruct {
    static Map<Integer, PhotoSearchBoxItem> cache_items;
    static int cache_status;
    static ArrayList<Integer> cache_types = new ArrayList<>();
    public Map<Integer, PhotoSearchBoxItem> items;
    public int status;
    public ArrayList<Integer> types;

    static {
        cache_types.add(0);
        cache_items = new HashMap();
        cache_items.put(0, new PhotoSearchBoxItem());
    }

    public PhotoSearchBox() {
        this.status = 1;
        this.types = null;
        this.items = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.types = (ArrayList) jceInputStream.read((JceInputStream) cache_types, 1, false);
        this.items = (Map) jceInputStream.read((JceInputStream) cache_items, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        ArrayList<Integer> arrayList = this.types;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<Integer, PhotoSearchBoxItem> map = this.items;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public PhotoSearchBox(int i3, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxItem> map) {
        this.status = i3;
        this.types = arrayList;
        this.items = map;
    }
}
