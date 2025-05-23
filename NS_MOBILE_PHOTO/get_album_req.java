package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_album_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumid;
    public Map<Integer, String> busi_param;
    public boolean is_from_public_url;
    public boolean is_get_url_key;
    public long owner_uin;
    public String share_key;
    public int type;

    static {
        cache_busi_param.put(0, "");
    }

    public get_album_req() {
        this.albumid = "";
        this.type = 0;
        this.busi_param = null;
        this.owner_uin = 0L;
        this.is_get_url_key = false;
        this.share_key = "";
        this.is_from_public_url = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, true);
        this.type = jceInputStream.read(this.type, 1, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 2, false);
        this.owner_uin = jceInputStream.read(this.owner_uin, 3, false);
        this.is_get_url_key = jceInputStream.read(this.is_get_url_key, 4, false);
        this.share_key = jceInputStream.readString(5, false);
        this.is_from_public_url = jceInputStream.read(this.is_from_public_url, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.albumid, 0);
        jceOutputStream.write(this.type, 1);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.owner_uin, 3);
        jceOutputStream.write(this.is_get_url_key, 4);
        String str = this.share_key;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.is_from_public_url, 6);
    }

    public get_album_req(String str, int i3, Map<Integer, String> map, long j3, boolean z16, String str2, boolean z17) {
        this.albumid = str;
        this.type = i3;
        this.busi_param = map;
        this.owner_uin = j3;
        this.is_get_url_key = z16;
        this.share_key = str2;
        this.is_from_public_url = z17;
    }
}
