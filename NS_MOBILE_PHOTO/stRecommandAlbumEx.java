package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRecommandAlbumEx extends JceStruct {
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();
    public Album albuminfo;
    public int commentCnt;
    public int likeCnt;
    public ArrayList<s_picdata> photolist;
    public int viewCnt;

    static {
        cache_photolist.add(new s_picdata());
    }

    public stRecommandAlbumEx() {
        this.albuminfo = null;
        this.commentCnt = 0;
        this.likeCnt = 0;
        this.photolist = null;
        this.viewCnt = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 0, false);
        this.commentCnt = jceInputStream.read(this.commentCnt, 1, false);
        this.likeCnt = jceInputStream.read(this.likeCnt, 2, false);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 3, false);
        this.viewCnt = jceInputStream.read(this.viewCnt, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Album album = this.albuminfo;
        if (album != null) {
            jceOutputStream.write((JceStruct) album, 0);
        }
        jceOutputStream.write(this.commentCnt, 1);
        jceOutputStream.write(this.likeCnt, 2);
        ArrayList<s_picdata> arrayList = this.photolist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.viewCnt, 4);
    }

    public stRecommandAlbumEx(Album album, int i3, int i16, ArrayList<s_picdata> arrayList, int i17) {
        this.albuminfo = album;
        this.commentCnt = i3;
        this.likeCnt = i16;
        this.photolist = arrayList;
        this.viewCnt = i17;
    }
}
