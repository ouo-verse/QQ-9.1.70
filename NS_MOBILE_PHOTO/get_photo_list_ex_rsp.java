package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_list_ex_rsp extends JceStruct {
    static Map<Integer, byte[]> cache_features;
    public Album albuminfo;
    public int appid;
    public Map<Integer, byte[]> features;
    public int imaxfetch;
    public int index;
    public int indexInVec;
    public long left_finish;
    public int lossy_service;
    public ArrayList<Photo> photolist;
    public long right_finish;
    static Album cache_albuminfo = new Album();
    static ArrayList<Photo> cache_photolist = new ArrayList<>();

    static {
        cache_photolist.add(new Photo());
        cache_features = new HashMap();
        cache_features.put(0, new byte[]{0});
    }

    public get_photo_list_ex_rsp() {
        this.index = 0;
        this.albuminfo = null;
        this.left_finish = 0L;
        this.right_finish = 0L;
        this.photolist = null;
        this.imaxfetch = 0;
        this.appid = 0;
        this.indexInVec = 0;
        this.lossy_service = 0;
        this.features = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.index = jceInputStream.read(this.index, 0, true);
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 1, true);
        this.left_finish = jceInputStream.read(this.left_finish, 2, true);
        this.right_finish = jceInputStream.read(this.right_finish, 3, true);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 4, true);
        this.imaxfetch = jceInputStream.read(this.imaxfetch, 5, false);
        this.appid = jceInputStream.read(this.appid, 6, false);
        this.indexInVec = jceInputStream.read(this.indexInVec, 7, false);
        this.lossy_service = jceInputStream.read(this.lossy_service, 8, false);
        this.features = (Map) jceInputStream.read((JceInputStream) cache_features, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.index, 0);
        jceOutputStream.write((JceStruct) this.albuminfo, 1);
        jceOutputStream.write(this.left_finish, 2);
        jceOutputStream.write(this.right_finish, 3);
        jceOutputStream.write((Collection) this.photolist, 4);
        jceOutputStream.write(this.imaxfetch, 5);
        jceOutputStream.write(this.appid, 6);
        jceOutputStream.write(this.indexInVec, 7);
        jceOutputStream.write(this.lossy_service, 8);
        Map<Integer, byte[]> map = this.features;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
    }

    public get_photo_list_ex_rsp(int i3, Album album, long j3, long j16, ArrayList<Photo> arrayList, int i16, int i17, int i18, int i19, Map<Integer, byte[]> map) {
        this.index = i3;
        this.albuminfo = album;
        this.left_finish = j3;
        this.right_finish = j16;
        this.photolist = arrayList;
        this.imaxfetch = i16;
        this.appid = i17;
        this.indexInVec = i18;
        this.lossy_service = i19;
        this.features = map;
    }
}
