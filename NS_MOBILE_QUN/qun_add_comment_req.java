package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_add_comment_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumId;
    public Map<Integer, String> busi_param;
    public int comment_type;
    public String content;
    public long ownuin;
    public String qunid;
    public String srcid;
    public long uin;

    static {
        cache_busi_param.put(0, "");
    }

    public qun_add_comment_req() {
        this.qunid = "";
        this.uin = 0L;
        this.ownuin = 0L;
        this.srcid = "";
        this.content = "";
        this.comment_type = 0;
        this.albumId = "";
        this.busi_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.ownuin = jceInputStream.read(this.ownuin, 2, false);
        this.srcid = jceInputStream.readString(3, false);
        this.content = jceInputStream.readString(4, false);
        this.comment_type = jceInputStream.read(this.comment_type, 5, false);
        this.albumId = jceInputStream.readString(6, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.ownuin, 2);
        String str = this.srcid;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.comment_type, 5);
        String str3 = this.albumId;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public qun_add_comment_req(String str, long j3, long j16, String str2, String str3, int i3, String str4, Map<Integer, String> map) {
        this.qunid = str;
        this.uin = j3;
        this.ownuin = j16;
        this.srcid = str2;
        this.content = str3;
        this.comment_type = i3;
        this.albumId = str4;
        this.busi_param = map;
    }
}
