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
public final class edit_batch_photo_req extends JceStruct {
    static EditPhoto cache_PhotoInfo;
    static Map<Integer, String> cache_busi_param;
    static ArrayList<String> cache_picid_list;
    static Map<String, EditPhoto> cache_picid_time_list;
    public EditPhoto PhotoInfo;
    public String albumid;
    public Map<Integer, String> busi_param;
    public int operatype;
    public ArrayList<String> picid_list;
    public Map<String, EditPhoto> picid_time_list;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_picid_list = arrayList;
        arrayList.add("");
        cache_PhotoInfo = new EditPhoto();
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_picid_time_list = new HashMap();
        cache_picid_time_list.put("", new EditPhoto());
    }

    public edit_batch_photo_req() {
        this.albumid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, true);
        this.picid_list = (ArrayList) jceInputStream.read((JceInputStream) cache_picid_list, 1, true);
        this.PhotoInfo = (EditPhoto) jceInputStream.read((JceStruct) cache_PhotoInfo, 2, true);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 3, false);
        this.operatype = jceInputStream.read(this.operatype, 4, false);
        this.picid_time_list = (Map) jceInputStream.read((JceInputStream) cache_picid_time_list, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.albumid, 0);
        jceOutputStream.write((Collection) this.picid_list, 1);
        jceOutputStream.write((JceStruct) this.PhotoInfo, 2);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.operatype, 4);
        Map<String, EditPhoto> map2 = this.picid_time_list;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
    }

    public edit_batch_photo_req(String str, ArrayList<String> arrayList, EditPhoto editPhoto, Map<Integer, String> map, int i3, Map<String, EditPhoto> map2) {
        this.albumid = str;
        this.picid_list = arrayList;
        this.PhotoInfo = editPhoto;
        this.busi_param = map;
        this.operatype = i3;
        this.picid_time_list = map2;
    }
}
