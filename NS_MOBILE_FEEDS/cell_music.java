package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_music extends JceStruct {
    public String coverurl;
    public int height;
    public String musicMId;
    public String musicMUrl;
    public String musicType;
    public String musicid;
    public int musictime;
    public String musicurl;
    public String title;
    public int width;

    public cell_music() {
        this.musicid = "";
        this.musicurl = "";
        this.coverurl = "";
        this.width = 0;
        this.height = 0;
        this.title = "";
        this.musictime = 0;
        this.musicMId = "";
        this.musicType = "";
        this.musicMUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.musicid = jceInputStream.readString(0, false);
        this.musicurl = jceInputStream.readString(1, false);
        this.coverurl = jceInputStream.readString(2, false);
        this.width = jceInputStream.read(this.width, 3, false);
        this.height = jceInputStream.read(this.height, 4, false);
        this.title = jceInputStream.readString(5, false);
        this.musictime = jceInputStream.read(this.musictime, 6, false);
        this.musicMId = jceInputStream.readString(7, false);
        this.musicType = jceInputStream.readString(8, false);
        this.musicMUrl = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.musicid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.musicurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.coverurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.width, 3);
        jceOutputStream.write(this.height, 4);
        String str4 = this.title;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.musictime, 6);
        String str5 = this.musicMId;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.musicType;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.musicMUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
    }

    public cell_music(String str, String str2, String str3, int i3, int i16, String str4, int i17, String str5, String str6, String str7) {
        this.musicid = str;
        this.musicurl = str2;
        this.coverurl = str3;
        this.width = i3;
        this.height = i16;
        this.title = str4;
        this.musictime = i17;
        this.musicMId = str5;
        this.musicType = str6;
        this.musicMUrl = str7;
    }
}
