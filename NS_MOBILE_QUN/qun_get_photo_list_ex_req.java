package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_photo_list_ex_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumid;
    public long batch_id;
    public Map<Integer, String> busi_param;
    public String curlloc;
    public int get_comment;
    public int get_pfinfo;
    public int get_poi;
    public long left;
    public String password;
    public String qunid;
    public long right;
    public int sort;
    public long type;
    public long uin;
    public String url;

    static {
        cache_busi_param.put(0, "");
    }

    public qun_get_photo_list_ex_req() {
        this.qunid = "";
        this.uin = 0L;
        this.albumid = "";
        this.curlloc = "";
        this.left = 0L;
        this.right = 0L;
        this.password = "";
        this.sort = 0;
        this.get_comment = 0;
        this.type = 0L;
        this.url = "";
        this.busi_param = null;
        this.batch_id = 0L;
        this.get_poi = 0;
        this.get_pfinfo = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.albumid = jceInputStream.readString(2, true);
        this.curlloc = jceInputStream.readString(3, true);
        this.left = jceInputStream.read(this.left, 4, true);
        this.right = jceInputStream.read(this.right, 5, true);
        this.password = jceInputStream.readString(6, true);
        this.sort = jceInputStream.read(this.sort, 7, true);
        this.get_comment = jceInputStream.read(this.get_comment, 8, true);
        this.type = jceInputStream.read(this.type, 9, false);
        this.url = jceInputStream.readString(10, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 11, false);
        this.batch_id = jceInputStream.read(this.batch_id, 12, false);
        this.get_poi = jceInputStream.read(this.get_poi, 13, false);
        this.get_pfinfo = jceInputStream.read(this.get_pfinfo, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.albumid, 2);
        jceOutputStream.write(this.curlloc, 3);
        jceOutputStream.write(this.left, 4);
        jceOutputStream.write(this.right, 5);
        jceOutputStream.write(this.password, 6);
        jceOutputStream.write(this.sort, 7);
        jceOutputStream.write(this.get_comment, 8);
        jceOutputStream.write(this.type, 9);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
        jceOutputStream.write(this.batch_id, 12);
        jceOutputStream.write(this.get_poi, 13);
        jceOutputStream.write(this.get_pfinfo, 14);
    }

    public qun_get_photo_list_ex_req(String str, long j3, String str2, String str3, long j16, long j17, String str4, int i3, int i16, long j18, String str5, Map<Integer, String> map, long j19, int i17, int i18) {
        this.qunid = str;
        this.uin = j3;
        this.albumid = str2;
        this.curlloc = str3;
        this.left = j16;
        this.right = j17;
        this.password = str4;
        this.sort = i3;
        this.get_comment = i16;
        this.type = j18;
        this.url = str5;
        this.busi_param = map;
        this.batch_id = j19;
        this.get_poi = i17;
        this.get_pfinfo = i18;
    }
}
