package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CategoryOpReq extends JceStruct {
    static Map<String, ArrayList<String>> cache_category_groupids;
    static Map<String, category_face_confirm_info> cache_groupid_confirm_info;
    static Map<String, ArrayList<s_picdata>> cache_groupid_photos = new HashMap();
    static int cache_op;
    public Map<String, ArrayList<String>> category_groupids;
    public Map<String, category_face_confirm_info> groupid_confirm_info;
    public Map<String, ArrayList<s_picdata>> groupid_photos;

    /* renamed from: op, reason: collision with root package name */
    public int f25024op;
    public long op_uin;

    static {
        ArrayList<s_picdata> arrayList = new ArrayList<>();
        arrayList.add(new s_picdata());
        cache_groupid_photos.put("", arrayList);
        cache_groupid_confirm_info = new HashMap();
        cache_groupid_confirm_info.put("", new category_face_confirm_info());
        cache_category_groupids = new HashMap();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("");
        cache_category_groupids.put("", arrayList2);
    }

    public CategoryOpReq() {
        this.op_uin = 0L;
        this.f25024op = 0;
        this.groupid_photos = null;
        this.groupid_confirm_info = null;
        this.category_groupids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.f25024op = jceInputStream.read(this.f25024op, 1, false);
        this.groupid_photos = (Map) jceInputStream.read((JceInputStream) cache_groupid_photos, 2, false);
        this.groupid_confirm_info = (Map) jceInputStream.read((JceInputStream) cache_groupid_confirm_info, 3, false);
        this.category_groupids = (Map) jceInputStream.read((JceInputStream) cache_category_groupids, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_uin, 0);
        jceOutputStream.write(this.f25024op, 1);
        Map<String, ArrayList<s_picdata>> map = this.groupid_photos;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        Map<String, category_face_confirm_info> map2 = this.groupid_confirm_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 3);
        }
        Map<String, ArrayList<String>> map3 = this.category_groupids;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 4);
        }
    }

    public CategoryOpReq(long j3, int i3, Map<String, ArrayList<s_picdata>> map, Map<String, category_face_confirm_info> map2, Map<String, ArrayList<String>> map3) {
        this.op_uin = j3;
        this.f25024op = i3;
        this.groupid_photos = map;
        this.groupid_confirm_info = map2;
        this.category_groupids = map3;
    }
}
