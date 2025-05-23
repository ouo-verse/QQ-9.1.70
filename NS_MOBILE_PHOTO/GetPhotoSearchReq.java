package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class GetPhotoSearchReq extends JceStruct {
    static Map<Integer, PhotoSearchBoxChosenItem> cache_items;
    static int cache_req_type;
    static ArrayList<Integer> cache_types = new ArrayList<>();
    public String albumid;
    public String attach_info;
    public Map<Integer, PhotoSearchBoxChosenItem> items;
    public int req_type;
    public ArrayList<Integer> types;
    public long uin;

    static {
        cache_types.add(0);
        cache_items = new HashMap();
        cache_items.put(0, new PhotoSearchBoxChosenItem());
    }

    public GetPhotoSearchReq() {
        this.uin = 0L;
        this.albumid = "";
        this.req_type = 0;
        this.types = null;
        this.items = null;
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.albumid = jceInputStream.readString(1, false);
        this.req_type = jceInputStream.read(this.req_type, 2, false);
        this.types = (ArrayList) jceInputStream.read((JceInputStream) cache_types, 3, false);
        this.items = (Map) jceInputStream.read((JceInputStream) cache_items, 4, false);
        this.attach_info = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.req_type, 2);
        ArrayList<Integer> arrayList = this.types;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        Map<Integer, PhotoSearchBoxChosenItem> map = this.items;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        String str2 = this.attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public GetPhotoSearchReq(long j3, String str, int i3, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxChosenItem> map, String str2) {
        this.uin = j3;
        this.albumid = str;
        this.req_type = i3;
        this.types = arrayList;
        this.items = map;
        this.attach_info = str2;
    }
}
