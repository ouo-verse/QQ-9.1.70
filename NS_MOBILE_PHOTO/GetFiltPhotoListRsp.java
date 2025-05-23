package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetFiltPhotoListRsp extends JceStruct {
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();
    static s_outshare cache_shareinfo;
    public Album albuminfo;
    public String attach_info;
    public boolean hasmore;
    public ArrayList<s_picdata> photolist;
    public s_outshare shareinfo;

    static {
        cache_photolist.add(new s_picdata());
        cache_shareinfo = new s_outshare();
    }

    public GetFiltPhotoListRsp() {
        this.hasmore = false;
        this.attach_info = "";
        this.albuminfo = null;
        this.photolist = null;
        this.shareinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 0, false);
        this.attach_info = jceInputStream.readString(1, false);
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 2, false);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 3, false);
        this.shareinfo = (s_outshare) jceInputStream.read((JceStruct) cache_shareinfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 0);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Album album = this.albuminfo;
        if (album != null) {
            jceOutputStream.write((JceStruct) album, 2);
        }
        ArrayList<s_picdata> arrayList = this.photolist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        s_outshare s_outshareVar = this.shareinfo;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 4);
        }
    }

    public GetFiltPhotoListRsp(boolean z16, String str, Album album, ArrayList<s_picdata> arrayList, s_outshare s_outshareVar) {
        this.hasmore = z16;
        this.attach_info = str;
        this.albuminfo = album;
        this.photolist = arrayList;
        this.shareinfo = s_outshareVar;
    }
}
