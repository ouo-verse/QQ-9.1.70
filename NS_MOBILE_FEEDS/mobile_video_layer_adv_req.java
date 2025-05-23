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
public final class mobile_video_layer_adv_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static ArrayList<feeds_context_info> cache_context_list = new ArrayList<>();
    static Map<String, String> cache_mapExt;
    public Map<Integer, String> busi_param;
    public ArrayList<feeds_context_info> context_list;
    public Map<String, String> mapExt;
    public int req_type;
    public long uin;

    static {
        cache_context_list.add(new feeds_context_info());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public mobile_video_layer_adv_req() {
        this.uin = 0L;
        this.context_list = null;
        this.busi_param = null;
        this.mapExt = null;
        this.req_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.context_list = (ArrayList) jceInputStream.read((JceInputStream) cache_context_list, 1, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 2, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 3, false);
        this.req_type = jceInputStream.read(this.req_type, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        ArrayList<feeds_context_info> arrayList = this.context_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        Map<String, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 3);
        }
        jceOutputStream.write(this.req_type, 4);
    }

    public mobile_video_layer_adv_req(long j3, ArrayList<feeds_context_info> arrayList, Map<Integer, String> map, Map<String, String> map2, int i3) {
        this.uin = j3;
        this.context_list = arrayList;
        this.busi_param = map;
        this.mapExt = map2;
        this.req_type = i3;
    }
}
