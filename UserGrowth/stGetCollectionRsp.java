package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetCollectionRsp extends JceStruct {
    static stCollection cache_collection;
    static ArrayList<stSimpleMetaFeed> cache_feedList = new ArrayList<>();
    static Map<String, String> cache_map_ext;
    public String attachInfo;
    public stCollection collection;
    public ArrayList<stSimpleMetaFeed> feedList;
    public boolean isFinished;
    public Map<String, String> map_ext;
    public String traceId;

    static {
        cache_feedList.add(new stSimpleMetaFeed());
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
        cache_collection = new stCollection();
    }

    public stGetCollectionRsp() {
        this.attachInfo = "";
        this.isFinished = true;
        this.feedList = null;
        this.traceId = "";
        this.map_ext = null;
        this.collection = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.feedList = (ArrayList) jceInputStream.read((JceInputStream) cache_feedList, 2, false);
        this.traceId = jceInputStream.readString(3, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 4, false);
        this.collection = (stCollection) jceInputStream.read((JceStruct) cache_collection, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isFinished, 1);
        ArrayList<stSimpleMetaFeed> arrayList = this.feedList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.traceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        stCollection stcollection = this.collection;
        if (stcollection != null) {
            jceOutputStream.write((JceStruct) stcollection, 5);
        }
    }

    public stGetCollectionRsp(String str, boolean z16, ArrayList<stSimpleMetaFeed> arrayList, String str2, Map<String, String> map, stCollection stcollection) {
        this.attachInfo = str;
        this.isFinished = z16;
        this.feedList = arrayList;
        this.traceId = str2;
        this.map_ext = map;
        this.collection = stcollection;
    }
}
