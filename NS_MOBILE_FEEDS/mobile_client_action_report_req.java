package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_client_action_report_req extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static int cache_report_feed_type;
    static int cache_user_action;
    public long action_subtype;
    public Map<String, String> extendinfo;
    public int report_feed_type;
    public int user_action;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
        cache_report_feed_type = 0;
    }

    public mobile_client_action_report_req() {
        this.user_action = 0;
        this.action_subtype = 0L;
        this.extendinfo = null;
        this.report_feed_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user_action = jceInputStream.read(this.user_action, 0, true);
        this.action_subtype = jceInputStream.read(this.action_subtype, 1, true);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
        this.report_feed_type = jceInputStream.read(this.report_feed_type, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.user_action, 0);
        jceOutputStream.write(this.action_subtype, 1);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.report_feed_type, 3);
    }

    public mobile_client_action_report_req(int i3, long j3, Map<String, String> map, int i16) {
        this.user_action = i3;
        this.action_subtype = j3;
        this.extendinfo = map;
        this.report_feed_type = i16;
    }
}
