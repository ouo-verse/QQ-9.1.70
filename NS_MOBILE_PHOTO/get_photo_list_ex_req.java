package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_list_ex_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumid;
    public long albumtype;
    public int appid;
    public Map<Integer, String> busi_param;
    public String curid;
    public String curlloc;
    public int get_comment;
    public int get_photo_ex_type;
    public long left;
    public String password;
    public long right;
    public long sharer;
    public int sheight;
    public int sort;
    public int swidth;
    public long type;
    public long uin;
    public String url;

    static {
        cache_busi_param.put(0, "");
    }

    public get_photo_list_ex_req() {
        this.albumid = "";
        this.curlloc = "";
        this.password = "";
        this.url = "";
        this.curid = "";
        this.get_photo_ex_type = 0;
        this.sharer = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.curlloc = jceInputStream.readString(2, true);
        this.left = jceInputStream.read(this.left, 3, true);
        this.right = jceInputStream.read(this.right, 4, true);
        this.password = jceInputStream.readString(5, true);
        this.sort = jceInputStream.read(this.sort, 6, true);
        this.get_comment = jceInputStream.read(this.get_comment, 7, true);
        this.swidth = jceInputStream.read(this.swidth, 8, false);
        this.sheight = jceInputStream.read(this.sheight, 9, false);
        this.type = jceInputStream.read(this.type, 10, false);
        this.url = jceInputStream.readString(11, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 12, false);
        this.appid = jceInputStream.read(this.appid, 13, false);
        this.curid = jceInputStream.readString(14, false);
        this.albumtype = jceInputStream.read(this.albumtype, 15, false);
        this.get_photo_ex_type = jceInputStream.read(this.get_photo_ex_type, 16, false);
        this.sharer = jceInputStream.read(this.sharer, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.curlloc, 2);
        jceOutputStream.write(this.left, 3);
        jceOutputStream.write(this.right, 4);
        jceOutputStream.write(this.password, 5);
        jceOutputStream.write(this.sort, 6);
        jceOutputStream.write(this.get_comment, 7);
        jceOutputStream.write(this.swidth, 8);
        jceOutputStream.write(this.sheight, 9);
        jceOutputStream.write(this.type, 10);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 11);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        jceOutputStream.write(this.appid, 13);
        String str2 = this.curid;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        jceOutputStream.write(this.albumtype, 15);
        jceOutputStream.write(this.get_photo_ex_type, 16);
        jceOutputStream.write(this.sharer, 17);
    }

    public get_photo_list_ex_req(long j3, String str, String str2, long j16, long j17, String str3, int i3, int i16, int i17, int i18, long j18, String str4, Map<Integer, String> map, int i19, String str5, long j19, int i26, long j26) {
        this.uin = j3;
        this.albumid = str;
        this.curlloc = str2;
        this.left = j16;
        this.right = j17;
        this.password = str3;
        this.sort = i3;
        this.get_comment = i16;
        this.swidth = i17;
        this.sheight = i18;
        this.type = j18;
        this.url = str4;
        this.busi_param = map;
        this.appid = i19;
        this.curid = str5;
        this.albumtype = j19;
        this.get_photo_ex_type = i26;
        this.sharer = 0L;
    }
}
