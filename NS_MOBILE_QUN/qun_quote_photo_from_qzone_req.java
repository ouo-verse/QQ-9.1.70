package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_quote_photo_from_qzone_req extends JceStruct {
    static ArrayList<s_quote_photo_info> cache_photo_list;
    public String albumid;
    public long batchid;
    public String clientkey;
    public String desc;
    public long fromUin;
    public ArrayList<s_quote_photo_info> photo_list;
    public String qunid;

    public qun_quote_photo_from_qzone_req() {
        this.qunid = "";
        this.albumid = "";
        this.desc = "";
        this.clientkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.fromUin = jceInputStream.read(this.fromUin, 2, true);
        if (cache_photo_list == null) {
            cache_photo_list = new ArrayList<>();
            cache_photo_list.add(new s_quote_photo_info());
        }
        this.photo_list = (ArrayList) jceInputStream.read((JceInputStream) cache_photo_list, 3, true);
        this.desc = jceInputStream.readString(4, false);
        this.batchid = jceInputStream.read(this.batchid, 5, false);
        this.clientkey = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.fromUin, 2);
        jceOutputStream.write((Collection) this.photo_list, 3);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.batchid, 5);
        String str2 = this.clientkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
    }

    public qun_quote_photo_from_qzone_req(String str, String str2, long j3, ArrayList<s_quote_photo_info> arrayList, String str3, long j16, String str4) {
        this.qunid = str;
        this.albumid = str2;
        this.fromUin = j3;
        this.photo_list = arrayList;
        this.desc = str3;
        this.batchid = j16;
        this.clientkey = str4;
    }
}
