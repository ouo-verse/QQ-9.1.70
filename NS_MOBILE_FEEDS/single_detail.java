package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class single_detail extends JceStruct {
    static ArrayList<Map<Integer, byte[]>> cache_recomfeeds;
    static Map<Integer, byte[]> cache_singledetail = new HashMap();
    public String feed_attach_info;
    public String feed_info;
    public String feedskey;
    public ArrayList<Map<Integer, byte[]>> recomfeeds;
    public Map<Integer, byte[]> singledetail;
    public long status;
    public int time;
    public long uContainerSubType;

    static {
        cache_singledetail.put(0, new byte[]{0});
        cache_recomfeeds = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put(0, new byte[]{0});
        cache_recomfeeds.add(hashMap);
    }

    public single_detail() {
        this.status = 0L;
        this.feed_info = "";
        this.feed_attach_info = "";
        this.feedskey = "";
        this.time = 0;
        this.recomfeeds = null;
        this.uContainerSubType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.singledetail = (Map) jceInputStream.read((JceInputStream) cache_singledetail, 0, false);
        this.status = jceInputStream.read(this.status, 1, false);
        this.feed_info = jceInputStream.readString(2, false);
        this.feed_attach_info = jceInputStream.readString(3, false);
        this.feedskey = jceInputStream.readString(4, false);
        this.time = jceInputStream.read(this.time, 5, false);
        this.recomfeeds = (ArrayList) jceInputStream.read((JceInputStream) cache_recomfeeds, 6, false);
        this.uContainerSubType = jceInputStream.read(this.uContainerSubType, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, byte[]> map = this.singledetail;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.status, 1);
        String str = this.feed_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.feed_attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.feedskey;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.time, 5);
        ArrayList<Map<Integer, byte[]>> arrayList = this.recomfeeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        jceOutputStream.write(this.uContainerSubType, 7);
    }

    public single_detail(Map<Integer, byte[]> map, long j3, String str, String str2, String str3, int i3, ArrayList<Map<Integer, byte[]>> arrayList, long j16) {
        this.singledetail = map;
        this.status = j3;
        this.feed_info = str;
        this.feed_attach_info = str2;
        this.feedskey = str3;
        this.time = i3;
        this.recomfeeds = arrayList;
        this.uContainerSubType = j16;
    }
}
