package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_set_photo_wall_combinepic_req extends JceStruct {
    static Map<String, String> cache_extinfo;
    public Map<String, String> extinfo;
    public int photoWallCombinePic;
    public long uin;

    public mobile_sub_set_photo_wall_combinepic_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.photoWallCombinePic = jceInputStream.read(this.photoWallCombinePic, 1, false);
        if (cache_extinfo == null) {
            HashMap hashMap = new HashMap();
            cache_extinfo = hashMap;
            hashMap.put("", "");
        }
        this.extinfo = (Map) jceInputStream.read((JceInputStream) cache_extinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.photoWallCombinePic, 1);
        Map<String, String> map = this.extinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_sub_set_photo_wall_combinepic_req(long j3, int i3, Map<String, String> map) {
        this.uin = j3;
        this.photoWallCombinePic = i3;
        this.extinfo = map;
    }
}
