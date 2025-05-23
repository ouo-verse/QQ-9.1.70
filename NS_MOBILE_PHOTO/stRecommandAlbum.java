package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRecommandAlbum extends JceStruct {
    static ArrayList<Album> cache_recommandAlbumVec = new ArrayList<>();
    static ArrayList<stRecommandAlbumEx> cache_recommandAlbumVecEx;
    public boolean hasMore;
    public ArrayList<Album> recommandAlbumVec;
    public ArrayList<stRecommandAlbumEx> recommandAlbumVecEx;
    public String summary;

    static {
        cache_recommandAlbumVec.add(new Album());
        cache_recommandAlbumVecEx = new ArrayList<>();
        cache_recommandAlbumVecEx.add(new stRecommandAlbumEx());
    }

    public stRecommandAlbum() {
        this.recommandAlbumVec = null;
        this.summary = "";
        this.hasMore = false;
        this.recommandAlbumVecEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.recommandAlbumVec = (ArrayList) jceInputStream.read((JceInputStream) cache_recommandAlbumVec, 0, false);
        this.summary = jceInputStream.readString(1, false);
        this.hasMore = jceInputStream.read(this.hasMore, 2, false);
        this.recommandAlbumVecEx = (ArrayList) jceInputStream.read((JceInputStream) cache_recommandAlbumVecEx, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Album> arrayList = this.recommandAlbumVec;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.summary;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.hasMore, 2);
        ArrayList<stRecommandAlbumEx> arrayList2 = this.recommandAlbumVecEx;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public stRecommandAlbum(ArrayList<Album> arrayList, String str, boolean z16, ArrayList<stRecommandAlbumEx> arrayList2) {
        this.recommandAlbumVec = arrayList;
        this.summary = str;
        this.hasMore = z16;
        this.recommandAlbumVecEx = arrayList2;
    }
}
