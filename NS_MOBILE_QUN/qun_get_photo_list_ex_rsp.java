package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_photo_list_ex_rsp extends JceStruct {
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();
    public Album albuminfo;
    public int appid;
    public int imaxfetch;
    public int index;
    public int indexInVec;
    public long left_finish;
    public ArrayList<s_picdata> photolist;
    public long right_finish;

    static {
        cache_photolist.add(new s_picdata());
    }

    public qun_get_photo_list_ex_rsp() {
        this.index = 0;
        this.albuminfo = null;
        this.left_finish = 0L;
        this.right_finish = 0L;
        this.photolist = null;
        this.imaxfetch = 0;
        this.indexInVec = 0;
        this.appid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.index = jceInputStream.read(this.index, 0, true);
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 1, true);
        this.left_finish = jceInputStream.read(this.left_finish, 2, true);
        this.right_finish = jceInputStream.read(this.right_finish, 3, true);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 4, true);
        this.imaxfetch = jceInputStream.read(this.imaxfetch, 5, false);
        this.indexInVec = jceInputStream.read(this.indexInVec, 6, false);
        this.appid = jceInputStream.read(this.appid, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.index, 0);
        jceOutputStream.write((JceStruct) this.albuminfo, 1);
        jceOutputStream.write(this.left_finish, 2);
        jceOutputStream.write(this.right_finish, 3);
        jceOutputStream.write((Collection) this.photolist, 4);
        jceOutputStream.write(this.imaxfetch, 5);
        jceOutputStream.write(this.indexInVec, 6);
        jceOutputStream.write(this.appid, 7);
    }

    public qun_get_photo_list_ex_rsp(int i3, Album album, long j3, long j16, ArrayList<s_picdata> arrayList, int i16, int i17, int i18) {
        this.index = i3;
        this.albuminfo = album;
        this.left_finish = j3;
        this.right_finish = j16;
        this.photolist = arrayList;
        this.imaxfetch = i16;
        this.indexInVec = i17;
        this.appid = i18;
    }
}
