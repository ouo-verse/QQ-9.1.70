package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class doufu_piece_rsp extends JceStruct {
    static ArrayList<DouFuInfo> cache_doufu = new ArrayList<>();
    static Map<String, String> cache_mapExt;
    public ArrayList<DouFuInfo> doufu;
    public Map<String, String> mapExt;

    static {
        cache_doufu.add(new DouFuInfo());
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public doufu_piece_rsp() {
        this.doufu = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.doufu = (ArrayList) jceInputStream.read((JceInputStream) cache_doufu, 0, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<DouFuInfo> arrayList = this.doufu;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public doufu_piece_rsp(ArrayList<DouFuInfo> arrayList, Map<String, String> map) {
        this.doufu = arrayList;
        this.mapExt = map;
    }
}
