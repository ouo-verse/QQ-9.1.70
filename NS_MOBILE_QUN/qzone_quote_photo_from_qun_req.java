package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qzone_quote_photo_from_qun_req extends JceStruct {
    static ArrayList<s_quote_photo_info> cache_photos;
    public long albumhandset;
    public String albumid;
    public long batchid;
    public String desc;
    public ArrayList<s_quote_photo_info> photos;
    public String qunid;

    public qzone_quote_photo_from_qun_req() {
        this.qunid = "";
        this.albumid = "";
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.desc = jceInputStream.readString(2, false);
        if (cache_photos == null) {
            cache_photos = new ArrayList<>();
            cache_photos.add(new s_quote_photo_info());
        }
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 3, true);
        this.batchid = jceInputStream.read(this.batchid, 4, false);
        this.albumhandset = jceInputStream.read(this.albumhandset, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.albumid, 1);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write((Collection) this.photos, 3);
        jceOutputStream.write(this.batchid, 4);
        jceOutputStream.write(this.albumhandset, 5);
    }

    public qzone_quote_photo_from_qun_req(String str, String str2, String str3, ArrayList<s_quote_photo_info> arrayList, long j3, long j16) {
        this.qunid = str;
        this.albumid = str2;
        this.desc = str3;
        this.photos = arrayList;
        this.batchid = j3;
        this.albumhandset = j16;
    }
}
