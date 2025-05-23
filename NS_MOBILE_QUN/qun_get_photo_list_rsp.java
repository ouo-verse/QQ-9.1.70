package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_photo_list_rsp extends JceStruct {
    static ArrayList<Long> cache_adminUin;
    static Album cache_albuminfo;
    static ArrayList<s_picdata> cache_photolist;
    public ArrayList<Long> adminUin;
    public Album albuminfo;
    public String attach_info;
    public int hasmore;
    public int operationMask;
    public long ownerUin;
    public ArrayList<s_picdata> photolist;

    public qun_get_photo_list_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_albuminfo == null) {
            cache_albuminfo = new Album();
        }
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 0, true);
        if (cache_photolist == null) {
            cache_photolist = new ArrayList<>();
            cache_photolist.add(new s_picdata());
        }
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 1, true);
        this.hasmore = jceInputStream.read(this.hasmore, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.ownerUin = jceInputStream.read(this.ownerUin, 4, false);
        if (cache_adminUin == null) {
            cache_adminUin = new ArrayList<>();
            cache_adminUin.add(0L);
        }
        this.adminUin = (ArrayList) jceInputStream.read((JceInputStream) cache_adminUin, 5, false);
        this.operationMask = jceInputStream.read(this.operationMask, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.albuminfo, 0);
        jceOutputStream.write((Collection) this.photolist, 1);
        jceOutputStream.write(this.hasmore, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.ownerUin, 4);
        ArrayList<Long> arrayList = this.adminUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        jceOutputStream.write(this.operationMask, 6);
    }

    public qun_get_photo_list_rsp(Album album, ArrayList<s_picdata> arrayList, int i3, String str, long j3, ArrayList<Long> arrayList2, int i16) {
        this.albuminfo = album;
        this.photolist = arrayList;
        this.hasmore = i3;
        this.attach_info = str;
        this.ownerUin = j3;
        this.adminUin = arrayList2;
        this.operationMask = i16;
    }
}
