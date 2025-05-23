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
public final class modify_active_album_req extends JceStruct {
    static ArrayList<active_photo> cache_added_photo;
    static Map<String, String> cache_map_params;
    static shuoshuo_privacy cache_ss_info;
    public ArrayList<active_photo> added_photo;
    public Map<String, String> map_params;
    public String mgz_id;
    public long pic_total;
    public shuoshuo_privacy ss_info;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_map_params = hashMap;
        hashMap.put("", "");
        cache_added_photo = new ArrayList<>();
        cache_added_photo.add(new active_photo());
        cache_ss_info = new shuoshuo_privacy();
    }

    public modify_active_album_req() {
        this.uin = 0L;
        this.map_params = null;
        this.added_photo = null;
        this.ss_info = null;
        this.mgz_id = "";
        this.pic_total = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.map_params = (Map) jceInputStream.read((JceInputStream) cache_map_params, 1, false);
        this.added_photo = (ArrayList) jceInputStream.read((JceInputStream) cache_added_photo, 2, false);
        this.ss_info = (shuoshuo_privacy) jceInputStream.read((JceStruct) cache_ss_info, 3, false);
        this.mgz_id = jceInputStream.readString(4, false);
        this.pic_total = jceInputStream.read(this.pic_total, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        Map<String, String> map = this.map_params;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        ArrayList<active_photo> arrayList = this.added_photo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        shuoshuo_privacy shuoshuo_privacyVar = this.ss_info;
        if (shuoshuo_privacyVar != null) {
            jceOutputStream.write((JceStruct) shuoshuo_privacyVar, 3);
        }
        String str = this.mgz_id;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.pic_total, 5);
    }

    public modify_active_album_req(long j3, Map<String, String> map, ArrayList<active_photo> arrayList, shuoshuo_privacy shuoshuo_privacyVar, String str, long j16) {
        this.uin = j3;
        this.map_params = map;
        this.added_photo = arrayList;
        this.ss_info = shuoshuo_privacyVar;
        this.mgz_id = str;
        this.pic_total = j16;
    }
}
