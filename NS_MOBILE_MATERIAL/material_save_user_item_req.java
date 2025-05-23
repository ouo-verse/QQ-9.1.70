package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_save_user_item_req extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public int iAppid;
    public int iSendFeed;
    public long lUin;
    public Map<String, String> mapExtInfo;
    public String strItemId;
    public String strQua;
    public String strSkey;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_save_user_item_req() {
        this.lUin = 0L;
        this.iAppid = 0;
        this.strItemId = "";
        this.strQua = "";
        this.iSendFeed = 0;
        this.strSkey = "";
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iAppid = jceInputStream.read(this.iAppid, 1, true);
        this.strItemId = jceInputStream.readString(2, true);
        this.strQua = jceInputStream.readString(3, false);
        this.iSendFeed = jceInputStream.read(this.iSendFeed, 4, false);
        this.strSkey = jceInputStream.readString(5, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iAppid, 1);
        jceOutputStream.write(this.strItemId, 2);
        String str = this.strQua;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.iSendFeed, 4);
        String str2 = this.strSkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public material_save_user_item_req(long j3, int i3, String str, String str2, int i16, String str3, Map<String, String> map) {
        this.lUin = j3;
        this.iAppid = i3;
        this.strItemId = str;
        this.strQua = str2;
        this.iSendFeed = i16;
        this.strSkey = str3;
        this.mapExtInfo = map;
    }
}
