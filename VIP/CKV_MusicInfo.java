package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_MusicInfo extends JceStruct {
    static ArrayList<CKV_SingerInfo> cache_vSingerList = new ArrayList<>();
    public int iAccess;
    public long iAddTime;
    public long iDuration;
    public long iModifyTime;
    public long iState;
    public String sAlbumName;
    public String sPic;
    public String sSongId;
    public String sSongName;
    public String sSongUrl;
    public ArrayList<CKV_SingerInfo> vSingerList;

    static {
        cache_vSingerList.add(new CKV_SingerInfo());
    }

    public CKV_MusicInfo() {
        this.sSongId = "";
        this.sSongName = "";
        this.sAlbumName = "";
        this.vSingerList = null;
        this.sPic = "";
        this.sSongUrl = "";
        this.iState = 0L;
        this.iAddTime = 0L;
        this.iModifyTime = 0L;
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
        this.iState = jceInputStream.read(this.iState, 6, false);
        this.iAddTime = jceInputStream.read(this.iAddTime, 7, false);
        this.iModifyTime = jceInputStream.read(this.iModifyTime, 8, false);
        this.iAccess = jceInputStream.read(this.iAccess, 9, false);
        this.iDuration = jceInputStream.read(this.iDuration, 10, false);
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
        ArrayList<CKV_SingerInfo> arrayList = this.vSingerList;
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
        jceOutputStream.write(this.iState, 6);
        jceOutputStream.write(this.iAddTime, 7);
        jceOutputStream.write(this.iModifyTime, 8);
        jceOutputStream.write(this.iAccess, 9);
        jceOutputStream.write(this.iDuration, 10);
    }

    public CKV_MusicInfo(String str, String str2, String str3, ArrayList<CKV_SingerInfo> arrayList, String str4, String str5, long j3, long j16, long j17, int i3, long j18) {
        this.sSongId = str;
        this.sSongName = str2;
        this.sAlbumName = str3;
        this.vSingerList = arrayList;
        this.sPic = str4;
        this.sSongUrl = str5;
        this.iState = j3;
        this.iAddTime = j16;
        this.iModifyTime = j17;
        this.iAccess = i3;
        this.iDuration = j18;
    }
}
