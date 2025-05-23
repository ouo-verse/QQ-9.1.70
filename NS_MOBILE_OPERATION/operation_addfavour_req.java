package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addfavour_req extends JceStruct {
    static Map<String, String> cache_busi_params;
    static ArrayList<PhotoInformation> cache_photo_url;
    public long appid;
    public Map<String, String> busi_params;
    public String cellid;
    public long owner_uin;
    public ArrayList<PhotoInformation> photo_url;
    public String sid;
    public long subid;
    public String text;
    public String ugc_key;

    public operation_addfavour_req() {
        this.cellid = "";
        this.sid = "";
        this.ugc_key = "";
        this.text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owner_uin = jceInputStream.read(this.owner_uin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.subid = jceInputStream.read(this.subid, 2, false);
        this.cellid = jceInputStream.readString(3, false);
        this.sid = jceInputStream.readString(4, false);
        this.ugc_key = jceInputStream.readString(5, false);
        if (cache_photo_url == null) {
            cache_photo_url = new ArrayList<>();
            cache_photo_url.add(new PhotoInformation());
        }
        this.photo_url = (ArrayList) jceInputStream.read((JceInputStream) cache_photo_url, 6, false);
        this.text = jceInputStream.readString(7, false);
        if (cache_busi_params == null) {
            HashMap hashMap = new HashMap();
            cache_busi_params = hashMap;
            hashMap.put("", "");
        }
        this.busi_params = (Map) jceInputStream.read((JceInputStream) cache_busi_params, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owner_uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.subid, 2);
        String str = this.cellid;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.sid;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.ugc_key;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        ArrayList<PhotoInformation> arrayList = this.photo_url;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        String str4 = this.text;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        Map<String, String> map = this.busi_params;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public operation_addfavour_req(long j3, long j16, long j17, String str, String str2, String str3, ArrayList<PhotoInformation> arrayList, String str4, Map<String, String> map) {
        this.owner_uin = j3;
        this.appid = j16;
        this.subid = j17;
        this.cellid = str;
        this.sid = str2;
        this.ugc_key = str3;
        this.photo_url = arrayList;
        this.text = str4;
        this.busi_params = map;
    }
}
