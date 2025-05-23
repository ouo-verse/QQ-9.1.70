package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_FEEDS.cell_id;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_ugc_visit_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static cell_id cache_ugcId;
    public int appid;
    public Map<Integer, String> busi_param;
    public boolean is_need_top;
    public String page;
    public cell_id ugcId;
    public long uin;

    public mobile_sub_get_ugc_visit_req() {
        this.page = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        if (cache_ugcId == null) {
            cache_ugcId = new cell_id();
        }
        this.ugcId = (cell_id) jceInputStream.read((JceStruct) cache_ugcId, 2, false);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 3, false);
        this.page = jceInputStream.readString(4, false);
        this.is_need_top = jceInputStream.read(this.is_need_top, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        cell_id cell_idVar = this.ugcId;
        if (cell_idVar != null) {
            jceOutputStream.write((JceStruct) cell_idVar, 2);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str = this.page;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.is_need_top, 5);
    }

    public mobile_sub_get_ugc_visit_req(long j3, int i3, cell_id cell_idVar, Map<Integer, String> map, String str, boolean z16) {
        this.uin = j3;
        this.appid = i3;
        this.ugcId = cell_idVar;
        this.busi_param = map;
        this.page = str;
        this.is_need_top = z16;
    }
}
