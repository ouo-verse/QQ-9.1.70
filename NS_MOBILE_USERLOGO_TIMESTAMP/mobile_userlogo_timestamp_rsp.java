package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_userlogo_timestamp_rsp extends JceStruct {
    static Map<Long, s_facade_info> cache_facade_data;
    static s_rc_tab_list cache_rc_data;
    static Map<Long, s_user_logo> cache_result;
    static Map<Long, s_skin_info> cache_skin_data;
    public boolean canRenew;
    public Map<Long, s_facade_info> facade_data;
    public int iOSPayType;
    public int open_vip_dialog_type;
    public s_rc_tab_list rc_data;
    public Map<Long, s_user_logo> result;
    public Map<Long, s_skin_info> skin_data;
    public long timestamp;

    public mobile_userlogo_timestamp_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_result == null) {
            cache_result = new HashMap();
            cache_result.put(0L, new s_user_logo());
        }
        this.result = (Map) jceInputStream.read((JceInputStream) cache_result, 0, false);
        if (cache_skin_data == null) {
            cache_skin_data = new HashMap();
            cache_skin_data.put(0L, new s_skin_info());
        }
        this.skin_data = (Map) jceInputStream.read((JceInputStream) cache_skin_data, 1, false);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
        if (cache_facade_data == null) {
            cache_facade_data = new HashMap();
            cache_facade_data.put(0L, new s_facade_info());
        }
        this.facade_data = (Map) jceInputStream.read((JceInputStream) cache_facade_data, 3, false);
        this.canRenew = jceInputStream.read(this.canRenew, 4, false);
        if (cache_rc_data == null) {
            cache_rc_data = new s_rc_tab_list();
        }
        this.rc_data = (s_rc_tab_list) jceInputStream.read((JceStruct) cache_rc_data, 5, false);
        this.iOSPayType = jceInputStream.read(this.iOSPayType, 6, false);
        this.open_vip_dialog_type = jceInputStream.read(this.open_vip_dialog_type, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, s_user_logo> map = this.result;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        Map<Long, s_skin_info> map2 = this.skin_data;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 1);
        }
        jceOutputStream.write(this.timestamp, 2);
        Map<Long, s_facade_info> map3 = this.facade_data;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 3);
        }
        jceOutputStream.write(this.canRenew, 4);
        s_rc_tab_list s_rc_tab_listVar = this.rc_data;
        if (s_rc_tab_listVar != null) {
            jceOutputStream.write((JceStruct) s_rc_tab_listVar, 5);
        }
        jceOutputStream.write(this.iOSPayType, 6);
        jceOutputStream.write(this.open_vip_dialog_type, 7);
    }

    public mobile_userlogo_timestamp_rsp(Map<Long, s_user_logo> map, Map<Long, s_skin_info> map2, long j3, Map<Long, s_facade_info> map3, boolean z16, s_rc_tab_list s_rc_tab_listVar, int i3, int i16) {
        this.result = map;
        this.skin_data = map2;
        this.timestamp = j3;
        this.facade_data = map3;
        this.canRenew = z16;
        this.rc_data = s_rc_tab_listVar;
        this.iOSPayType = i3;
        this.open_vip_dialog_type = i16;
    }
}
