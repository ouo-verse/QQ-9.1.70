package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public class ShareAlbumMemberData extends JceStruct {
    static comm_page_info cache_page_info = new comm_page_info();
    static ArrayList<s_picdata> cache_photos = new ArrayList<>();
    public String nick;
    public comm_page_info page;
    public long photo_cnt;
    public ArrayList<s_picdata> photos;
    public long uin;
    public long video_cnt;

    static {
        cache_photos.add(new s_picdata());
    }

    public ShareAlbumMemberData() {
        this.uin = 0L;
        this.nick = "";
        this.photo_cnt = 0L;
        this.video_cnt = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nick = jceInputStream.readString(1, false);
        this.photo_cnt = jceInputStream.read(this.photo_cnt, 2, false);
        this.video_cnt = jceInputStream.read(this.video_cnt, 3, false);
        this.page = (comm_page_info) jceInputStream.read((JceStruct) cache_page_info, 4, false);
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.photo_cnt, 2);
        jceOutputStream.write(this.video_cnt, 3);
        comm_page_info comm_page_infoVar = this.page;
        if (comm_page_infoVar != null) {
            jceOutputStream.write((JceStruct) comm_page_infoVar, 4);
        }
        ArrayList<s_picdata> arrayList = this.photos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
    }

    public ShareAlbumMemberData(long j3, String str, long j16, long j17, comm_page_info comm_page_infoVar, ArrayList<s_picdata> arrayList) {
        this.uin = j3;
        this.nick = str;
        this.photo_cnt = j16;
        this.video_cnt = j17;
        this.page = comm_page_infoVar;
        this.photos = arrayList;
    }
}
