package WEBAPP_FAMOUS;

import NS_FAMOUS_BASE.SchoolSingleGameItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBottomNaviRsp extends JceStruct {
    static Map<String, ArrayList<SchoolSingleGameItem>> cache_app_list;
    static ArrayList<ActInfo> cache_vec_out_app = new ArrayList<>();
    public Map<String, ArrayList<SchoolSingleGameItem>> app_list;
    public int bitmap_flag;
    public ArrayList<ActInfo> vec_out_app;

    static {
        cache_vec_out_app.add(new ActInfo());
        cache_app_list = new HashMap();
        ArrayList<SchoolSingleGameItem> arrayList = new ArrayList<>();
        arrayList.add(new SchoolSingleGameItem());
        cache_app_list.put("", arrayList);
    }

    public GetBottomNaviRsp() {
        this.vec_out_app = null;
        this.app_list = null;
        this.bitmap_flag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vec_out_app = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_out_app, 0, false);
        this.app_list = (Map) jceInputStream.read((JceInputStream) cache_app_list, 1, false);
        this.bitmap_flag = jceInputStream.read(this.bitmap_flag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<ActInfo> arrayList = this.vec_out_app;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, ArrayList<SchoolSingleGameItem>> map = this.app_list;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.bitmap_flag, 2);
    }

    public GetBottomNaviRsp(ArrayList<ActInfo> arrayList, Map<String, ArrayList<SchoolSingleGameItem>> map, int i3) {
        this.vec_out_app = arrayList;
        this.app_list = map;
        this.bitmap_flag = i3;
    }
}
