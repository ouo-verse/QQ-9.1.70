package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BatchGetSimilarGroupidRsp extends JceStruct {
    static Map<String, Integer> cache_fails;
    static Map<String, String> cache_new_groupids;
    static Map<String, ArrayList<cluster_search_result>> cache_results = new HashMap();
    public Map<String, Integer> fails;

    /* renamed from: msg, reason: collision with root package name */
    public String f25023msg;
    public Map<String, String> new_groupids;
    public Map<String, ArrayList<cluster_search_result>> results;
    public int ret;

    static {
        ArrayList<cluster_search_result> arrayList = new ArrayList<>();
        arrayList.add(new cluster_search_result());
        cache_results.put("", arrayList);
        cache_fails = new HashMap();
        cache_fails.put("", 0);
        HashMap hashMap = new HashMap();
        cache_new_groupids = hashMap;
        hashMap.put("", "");
    }

    public BatchGetSimilarGroupidRsp() {
        this.ret = 0;
        this.f25023msg = "";
        this.results = null;
        this.fails = null;
        this.new_groupids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25023msg = jceInputStream.readString(1, false);
        this.results = (Map) jceInputStream.read((JceInputStream) cache_results, 2, false);
        this.fails = (Map) jceInputStream.read((JceInputStream) cache_fails, 3, false);
        this.new_groupids = (Map) jceInputStream.read((JceInputStream) cache_new_groupids, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25023msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, ArrayList<cluster_search_result>> map = this.results;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        Map<String, Integer> map2 = this.fails;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 3);
        }
        Map<String, String> map3 = this.new_groupids;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 4);
        }
    }

    public BatchGetSimilarGroupidRsp(int i3, String str, Map<String, ArrayList<cluster_search_result>> map, Map<String, Integer> map2, Map<String, String> map3) {
        this.ret = i3;
        this.f25023msg = str;
        this.results = map;
        this.fails = map2;
        this.new_groupids = map3;
    }
}
