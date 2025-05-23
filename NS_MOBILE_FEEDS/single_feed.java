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
public final class single_feed extends JceStruct {
    static Map<Integer, byte[]> cache_patch_singlefeed;
    static ArrayList<Map<Integer, byte[]>> cache_recomfeeds;
    static Map<Integer, byte[]> cache_singlefeed = new HashMap();
    public String feed_attach_info;
    public String feed_info;
    public long feeds_update_time;
    public String feedskey;
    public int iUnifyRecomType;
    public Map<Integer, byte[]> patch_singlefeed;
    public boolean pullAll;
    public ArrayList<Map<Integer, byte[]>> recomfeeds;
    public Map<Integer, byte[]> singlefeed;
    public long status;
    public int time;
    public long uContainerSubType;

    static {
        cache_singlefeed.put(0, new byte[]{0});
        cache_recomfeeds = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put(0, new byte[]{0});
        cache_recomfeeds.add(hashMap);
        cache_patch_singlefeed = new HashMap();
        cache_patch_singlefeed.put(0, new byte[]{0});
    }

    public single_feed() {
        this.singlefeed = null;
        this.status = 0L;
        this.feed_info = "";
        this.feed_attach_info = "";
        this.feedskey = "";
        this.time = 0;
        this.recomfeeds = null;
        this.uContainerSubType = 0L;
        this.patch_singlefeed = null;
        this.feeds_update_time = 0L;
        this.pullAll = false;
        this.iUnifyRecomType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.singlefeed = (Map) jceInputStream.read((JceInputStream) cache_singlefeed, 0, false);
        this.status = jceInputStream.read(this.status, 1, false);
        this.feed_info = jceInputStream.readString(2, false);
        this.feed_attach_info = jceInputStream.readString(3, false);
        this.feedskey = jceInputStream.readString(4, false);
        this.time = jceInputStream.read(this.time, 5, false);
        this.recomfeeds = (ArrayList) jceInputStream.read((JceInputStream) cache_recomfeeds, 6, false);
        this.uContainerSubType = jceInputStream.read(this.uContainerSubType, 7, false);
        this.patch_singlefeed = (Map) jceInputStream.read((JceInputStream) cache_patch_singlefeed, 8, false);
        this.feeds_update_time = jceInputStream.read(this.feeds_update_time, 9, false);
        this.pullAll = jceInputStream.read(this.pullAll, 10, false);
        this.iUnifyRecomType = jceInputStream.read(this.iUnifyRecomType, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, byte[]> map = this.singlefeed;
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
        Map<Integer, byte[]> map2 = this.patch_singlefeed;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
        jceOutputStream.write(this.feeds_update_time, 9);
        jceOutputStream.write(this.pullAll, 10);
        jceOutputStream.write(this.iUnifyRecomType, 11);
    }

    public single_feed(Map<Integer, byte[]> map, long j3, String str, String str2, String str3, int i3, ArrayList<Map<Integer, byte[]>> arrayList, long j16, Map<Integer, byte[]> map2, long j17, boolean z16, int i16) {
        this.singlefeed = map;
        this.status = j3;
        this.feed_info = str;
        this.feed_attach_info = str2;
        this.feedskey = str3;
        this.time = i3;
        this.recomfeeds = arrayList;
        this.uContainerSubType = j16;
        this.patch_singlefeed = map2;
        this.feeds_update_time = j17;
        this.pullAll = z16;
        this.iUnifyRecomType = i16;
    }
}
