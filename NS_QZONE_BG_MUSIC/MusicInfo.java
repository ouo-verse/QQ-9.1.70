package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MusicInfo extends JceStruct {
    static ArrayList<SingerInfo> cache_vecSingerList = new ArrayList<>();
    public int iAccess;
    public long lDuration;
    public String strAlbumName;
    public String strName;
    public String strPic;
    public String strSongId;
    public String strUrl;
    public ArrayList<SingerInfo> vecSingerList;

    static {
        cache_vecSingerList.add(new SingerInfo());
    }

    public MusicInfo() {
        this.strSongId = "";
        this.strName = "";
        this.strAlbumName = "";
        this.vecSingerList = null;
        this.strPic = "";
        this.iAccess = 0;
        this.strUrl = "";
        this.lDuration = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strSongId = jceInputStream.readString(0, false);
        this.strName = jceInputStream.readString(1, false);
        this.strAlbumName = jceInputStream.readString(2, false);
        this.vecSingerList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecSingerList, 3, false);
        this.strPic = jceInputStream.readString(4, false);
        this.iAccess = jceInputStream.read(this.iAccess, 5, false);
        this.strUrl = jceInputStream.readString(6, false);
        this.lDuration = jceInputStream.read(this.lDuration, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strSongId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strAlbumName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<SingerInfo> arrayList = this.vecSingerList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str4 = this.strPic;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.iAccess, 5);
        String str5 = this.strUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.lDuration, 7);
    }

    public MusicInfo(String str, String str2, String str3, ArrayList<SingerInfo> arrayList, String str4, int i3, String str5, long j3) {
        this.strSongId = str;
        this.strName = str2;
        this.strAlbumName = str3;
        this.vecSingerList = arrayList;
        this.strPic = str4;
        this.iAccess = i3;
        this.strUrl = str5;
        this.lDuration = j3;
    }
}
