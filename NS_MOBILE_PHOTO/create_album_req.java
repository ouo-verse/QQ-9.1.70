package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class create_album_req extends JceStruct {
    static int cache_action;
    static Album cache_album = new Album();
    static Map<Integer, String> cache_busi_param = new HashMap();
    public int action;
    public Album album;
    public Map<Integer, String> busi_param;
    public String invite_key;
    public boolean is_from_public_url;
    public String itemid;

    static {
        cache_busi_param.put(0, "");
        cache_action = 0;
    }

    public create_album_req() {
        this.album = null;
        this.busi_param = null;
        this.itemid = "";
        this.action = 0;
        this.invite_key = "";
        this.is_from_public_url = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.album = (Album) jceInputStream.read((JceStruct) cache_album, 0, true);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
        this.itemid = jceInputStream.readString(2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.invite_key = jceInputStream.readString(4, false);
        this.is_from_public_url = jceInputStream.read(this.is_from_public_url, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.album, 0);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        String str = this.itemid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.action, 3);
        String str2 = this.invite_key;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.is_from_public_url, 5);
    }

    public create_album_req(Album album, Map<Integer, String> map, String str, int i3, String str2, boolean z16) {
        this.album = album;
        this.busi_param = map;
        this.itemid = str;
        this.action = i3;
        this.invite_key = str2;
        this.is_from_public_url = z16;
    }
}
