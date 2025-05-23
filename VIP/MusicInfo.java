package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MusicInfo extends JceStruct {
    static ArrayList<SingerInfo> cache_vSingerList = new ArrayList<>();
    public int iAccess;
    public long iDuration;
    public String sAlbumName;
    public String sPic;
    public String sSongId;
    public String sSongName;
    public String sSongUrl;
    public ArrayList<SingerInfo> vSingerList;

    static {
        cache_vSingerList.add(new SingerInfo());
    }

    public MusicInfo() {
        this.sSongId = "";
        this.sSongName = "";
        this.sAlbumName = "";
        this.vSingerList = null;
        this.sPic = "";
        this.sSongUrl = "";
        this.iAccess = 0;
        this.iDuration = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sSongId = jceInputStream.readString(0, false);
        this.sSongName = jceInputStream.readString(1, false);
        this.sAlbumName = jceInputStream.readString(2, false);
        this.vSingerList = (ArrayList) jceInputStream.read((JceInputStream) cache_vSingerList, 3, false);
        this.sPic = jceInputStream.readString(4, false);
        this.sSongUrl = jceInputStream.readString(5, false);
        this.iAccess = jceInputStream.read(this.iAccess, 6, false);
        this.iDuration = jceInputStream.read(this.iDuration, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sSongId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sSongName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sAlbumName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<SingerInfo> arrayList = this.vSingerList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str4 = this.sPic;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.sSongUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.iAccess, 6);
        jceOutputStream.write(this.iDuration, 7);
    }

    public MusicInfo(String str, String str2, String str3, ArrayList<SingerInfo> arrayList, String str4, String str5, int i3, long j3) {
        this.sSongId = str;
        this.sSongName = str2;
        this.sAlbumName = str3;
        this.vSingerList = arrayList;
        this.sPic = str4;
        this.sSongUrl = str5;
        this.iAccess = i3;
        this.iDuration = j3;
    }
}
