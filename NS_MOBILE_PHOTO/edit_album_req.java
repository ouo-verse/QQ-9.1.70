package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class edit_album_req extends JceStruct {
    static Album cache_album = new Album();
    static Map<Integer, String> cache_busi_param = new HashMap();
    public Album album;
    public Map<Integer, String> busi_param;
    public long cancelIndividual;
    public boolean isModifyBitmap;
    public String itemid;
    public String newCoverId;

    static {
        cache_busi_param.put(0, "");
    }

    public edit_album_req() {
        this.newCoverId = "";
        this.itemid = "";
        this.isModifyBitmap = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.album = (Album) jceInputStream.read((JceStruct) cache_album, 0, true);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
        this.newCoverId = jceInputStream.readString(2, false);
        this.itemid = jceInputStream.readString(3, false);
        this.cancelIndividual = jceInputStream.read(this.cancelIndividual, 4, false);
        this.isModifyBitmap = jceInputStream.read(this.isModifyBitmap, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.album, 0);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        String str = this.newCoverId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.itemid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.cancelIndividual, 4);
        jceOutputStream.write(this.isModifyBitmap, 5);
    }

    public edit_album_req(Album album, Map<Integer, String> map, String str, String str2, long j3, boolean z16) {
        this.album = album;
        this.busi_param = map;
        this.newCoverId = str;
        this.itemid = str2;
        this.cancelIndividual = j3;
        this.isModifyBitmap = z16;
    }
}
