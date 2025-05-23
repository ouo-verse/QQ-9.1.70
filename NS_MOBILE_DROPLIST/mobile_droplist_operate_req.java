package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_droplist_operate_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public Map<Integer, String> busi_param;
    public int feedback_id;
    public long login_uin;
    public long owner_uin;

    static {
        cache_busi_param.put(0, "");
    }

    public mobile_droplist_operate_req() {
        this.busi_param = null;
        this.login_uin = 0L;
        this.owner_uin = 0L;
        this.feedback_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 0, false);
        this.login_uin = jceInputStream.read(this.login_uin, 1, false);
        this.owner_uin = jceInputStream.read(this.owner_uin, 2, false);
        this.feedback_id = jceInputStream.read(this.feedback_id, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.login_uin, 1);
        jceOutputStream.write(this.owner_uin, 2);
        jceOutputStream.write(this.feedback_id, 3);
    }

    public mobile_droplist_operate_req(Map<Integer, String> map, long j3, long j16, int i3) {
        this.busi_param = map;
        this.login_uin = j3;
        this.owner_uin = j16;
        this.feedback_id = i3;
    }
}
