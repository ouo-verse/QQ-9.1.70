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
public final class del_batch_photo_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static ArrayList<String> cache_picid_list;
    static ArrayList<String> cache_vids;
    public String albumid;
    public int appid;
    public Map<Integer, String> busi_param;
    public ArrayList<String> picid_list;
    public ArrayList<String> vids;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_picid_list = arrayList;
        arrayList.add("");
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_vids = arrayList2;
        arrayList2.add("");
    }

    public del_batch_photo_req() {
        this.albumid = "";
        this.picid_list = null;
        this.busi_param = null;
        this.appid = 4;
        this.vids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, true);
        this.picid_list = (ArrayList) jceInputStream.read((JceInputStream) cache_picid_list, 1, true);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 2, false);
        this.appid = jceInputStream.read(this.appid, 3, false);
        this.vids = (ArrayList) jceInputStream.read((JceInputStream) cache_vids, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write((Collection) this.picid_list, 1);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.appid, 3);
        ArrayList<String> arrayList = this.vids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public del_batch_photo_req(String str, ArrayList<String> arrayList, Map<Integer, String> map, int i3, ArrayList<String> arrayList2) {
        this.albumid = str;
        this.picid_list = arrayList;
        this.busi_param = map;
        this.appid = i3;
        this.vids = arrayList2;
    }
}
