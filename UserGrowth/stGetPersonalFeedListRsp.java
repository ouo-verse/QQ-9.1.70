package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGetPersonalFeedListRsp extends JceStruct {
    static stGlobalConfig cache_config;
    static stFeedStatus cache_contextFeedStatus;
    static ArrayList<stSimpleMetaFeed> cache_feeds = new ArrayList<>();
    static Map<String, String> cache_map_ext;
    public String attach_info;
    public stGlobalConfig config;
    public stFeedStatus contextFeedStatus;
    public ArrayList<stSimpleMetaFeed> feeds;
    public boolean is_finished;
    public Map<String, String> map_ext;
    public String traceId;

    static {
        cache_feeds.add(new stSimpleMetaFeed());
        cache_config = new stGlobalConfig();
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
        cache_contextFeedStatus = new stFeedStatus();
    }

    public stGetPersonalFeedListRsp() {
        this.feeds = null;
        this.attach_info = "";
        this.is_finished = true;
        this.config = null;
        this.traceId = "";
        this.map_ext = null;
        this.contextFeedStatus = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feeds = (ArrayList) jceInputStream.read((JceInputStream) cache_feeds, 0, false);
        this.attach_info = jceInputStream.readString(1, false);
        this.is_finished = jceInputStream.read(this.is_finished, 2, false);
        this.config = (stGlobalConfig) jceInputStream.read((JceStruct) cache_config, 3, false);
        this.traceId = jceInputStream.readString(4, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 5, false);
        this.contextFeedStatus = (stFeedStatus) jceInputStream.read((JceStruct) cache_contextFeedStatus, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stSimpleMetaFeed> arrayList = this.feeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.is_finished, 2);
        stGlobalConfig stglobalconfig = this.config;
        if (stglobalconfig != null) {
            jceOutputStream.write((JceStruct) stglobalconfig, 3);
        }
        String str2 = this.traceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        stFeedStatus stfeedstatus = this.contextFeedStatus;
        if (stfeedstatus != null) {
            jceOutputStream.write((JceStruct) stfeedstatus, 6);
        }
    }

    public stGetPersonalFeedListRsp(ArrayList<stSimpleMetaFeed> arrayList, String str, boolean z16, stGlobalConfig stglobalconfig, String str2, Map<String, String> map, stFeedStatus stfeedstatus) {
        this.feeds = arrayList;
        this.attach_info = str;
        this.is_finished = z16;
        this.config = stglobalconfig;
        this.traceId = str2;
        this.map_ext = map;
        this.contextFeedStatus = stfeedstatus;
    }
}
