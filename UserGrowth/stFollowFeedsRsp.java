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
public final class stFollowFeedsRsp extends JceStruct {
    static stFollowFeedsGlobalConfig cache_config;
    static ArrayList<stFeed> cache_feeds = new ArrayList<>();
    static Map<String, String> cache_map_ext;
    public String attatch_info;
    public int cache_size;
    public stFollowFeedsGlobalConfig config;
    public ArrayList<stFeed> feeds;
    public String feeds_source;
    public boolean is_finished;
    public Map<String, String> map_ext;
    public String trace_id;

    static {
        cache_feeds.add(new stFeed());
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
        cache_config = new stFollowFeedsGlobalConfig();
    }

    public stFollowFeedsRsp() {
        this.feeds = null;
        this.attatch_info = "";
        this.is_finished = true;
        this.cache_size = 0;
        this.feeds_source = "";
        this.trace_id = "";
        this.map_ext = null;
        this.config = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feeds = (ArrayList) jceInputStream.read((JceInputStream) cache_feeds, 0, false);
        this.attatch_info = jceInputStream.readString(1, false);
        this.is_finished = jceInputStream.read(this.is_finished, 2, false);
        this.cache_size = jceInputStream.read(this.cache_size, 3, false);
        this.feeds_source = jceInputStream.readString(4, false);
        this.trace_id = jceInputStream.readString(5, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 6, false);
        this.config = (stFollowFeedsGlobalConfig) jceInputStream.read((JceStruct) cache_config, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stFeed> arrayList = this.feeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.attatch_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.is_finished, 2);
        jceOutputStream.write(this.cache_size, 3);
        String str2 = this.feeds_source;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.trace_id;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        stFollowFeedsGlobalConfig stfollowfeedsglobalconfig = this.config;
        if (stfollowfeedsglobalconfig != null) {
            jceOutputStream.write((JceStruct) stfollowfeedsglobalconfig, 7);
        }
    }

    public stFollowFeedsRsp(ArrayList<stFeed> arrayList, String str, boolean z16, int i3, String str2, String str3, Map<String, String> map, stFollowFeedsGlobalConfig stfollowfeedsglobalconfig) {
        this.feeds = arrayList;
        this.attatch_info = str;
        this.is_finished = z16;
        this.cache_size = i3;
        this.feeds_source = str2;
        this.trace_id = str3;
        this.map_ext = map;
        this.config = stfollowfeedsglobalconfig;
    }
}
