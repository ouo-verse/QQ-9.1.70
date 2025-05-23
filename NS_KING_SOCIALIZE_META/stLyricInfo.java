package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stLyricInfo extends JceStruct {
    public String strFormat;
    public String strLyric;
    public String strSongMid;
    public long uiSongId;

    public stLyricInfo() {
        this.uiSongId = 0L;
        this.strSongMid = "";
        this.strFormat = "";
        this.strLyric = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiSongId = jceInputStream.read(this.uiSongId, 0, false);
        this.strSongMid = jceInputStream.readString(1, false);
        this.strFormat = jceInputStream.readString(2, false);
        this.strLyric = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiSongId, 0);
        String str = this.strSongMid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strFormat;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strLyric;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stLyricInfo(long j3, String str, String str2, String str3) {
        this.uiSongId = j3;
        this.strSongMid = str;
        this.strFormat = str2;
        this.strLyric = str3;
    }
}
