package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class move_batch_photo_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static ArrayList<String> cache_src_picid_list;
    public Map<Integer, String> busi_param;
    public String dst_albumid;
    public String src_albumid;
    public ArrayList<String> src_picid_list;

    public move_batch_photo_req() {
        this.src_albumid = "";
        this.dst_albumid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.src_albumid = jceInputStream.readString(0, true);
        if (cache_src_picid_list == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_src_picid_list = arrayList;
            arrayList.add("");
        }
        this.src_picid_list = (ArrayList) jceInputStream.read((JceInputStream) cache_src_picid_list, 1, true);
        this.dst_albumid = jceInputStream.readString(2, true);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.src_albumid, 0);
        jceOutputStream.write((Collection) this.src_picid_list, 1);
        jceOutputStream.write(this.dst_albumid, 2);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public move_batch_photo_req(String str, ArrayList<String> arrayList, String str2, Map<Integer, String> map) {
        this.src_albumid = str;
        this.src_picid_list = arrayList;
        this.dst_albumid = str2;
        this.busi_param = map;
    }
}
