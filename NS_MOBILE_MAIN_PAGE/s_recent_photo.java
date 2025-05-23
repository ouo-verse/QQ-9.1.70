package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_recent_photo extends JceStruct {
    public String albumid;
    public String albumname;
    public int comment;
    public String desc;
    public int height;
    public String lloc;
    public int mheight;
    public int modifytime;
    public String murl;
    public int mwidth;
    public String name;
    public int sheight;
    public String sloc;
    public String surl;
    public int swidth;
    public int type;
    public int uploadtime;
    public String url;
    public int width;

    public s_recent_photo() {
        this.lloc = "";
        this.sloc = "";
        this.name = "";
        this.desc = "";
        this.url = "";
        this.murl = "";
        this.surl = "";
        this.albumid = "";
        this.albumname = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lloc = jceInputStream.readString(0, true);
        this.sloc = jceInputStream.readString(1, true);
        this.name = jceInputStream.readString(2, true);
        this.desc = jceInputStream.readString(3, true);
        this.uploadtime = jceInputStream.read(this.uploadtime, 4, true);
        this.modifytime = jceInputStream.read(this.modifytime, 5, true);
        this.comment = jceInputStream.read(this.comment, 6, true);
        this.width = jceInputStream.read(this.width, 7, true);
        this.height = jceInputStream.read(this.height, 8, true);
        this.mwidth = jceInputStream.read(this.mwidth, 9, true);
        this.mheight = jceInputStream.read(this.mheight, 10, true);
        this.swidth = jceInputStream.read(this.swidth, 11, true);
        this.sheight = jceInputStream.read(this.sheight, 12, true);
        this.type = jceInputStream.read(this.type, 13, true);
        this.url = jceInputStream.readString(14, true);
        this.murl = jceInputStream.readString(15, true);
        this.surl = jceInputStream.readString(16, true);
        this.albumid = jceInputStream.readString(17, true);
        this.albumname = jceInputStream.readString(18, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lloc, 0);
        jceOutputStream.write(this.sloc, 1);
        jceOutputStream.write(this.name, 2);
        jceOutputStream.write(this.desc, 3);
        jceOutputStream.write(this.uploadtime, 4);
        jceOutputStream.write(this.modifytime, 5);
        jceOutputStream.write(this.comment, 6);
        jceOutputStream.write(this.width, 7);
        jceOutputStream.write(this.height, 8);
        jceOutputStream.write(this.mwidth, 9);
        jceOutputStream.write(this.mheight, 10);
        jceOutputStream.write(this.swidth, 11);
        jceOutputStream.write(this.sheight, 12);
        jceOutputStream.write(this.type, 13);
        jceOutputStream.write(this.url, 14);
        jceOutputStream.write(this.murl, 15);
        jceOutputStream.write(this.surl, 16);
        jceOutputStream.write(this.albumid, 17);
        jceOutputStream.write(this.albumname, 18);
    }

    public s_recent_photo(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, String str5, String str6, String str7, String str8, String str9) {
        this.lloc = str;
        this.sloc = str2;
        this.name = str3;
        this.desc = str4;
        this.uploadtime = i3;
        this.modifytime = i16;
        this.comment = i17;
        this.width = i18;
        this.height = i19;
        this.mwidth = i26;
        this.mheight = i27;
        this.swidth = i28;
        this.sheight = i29;
        this.type = i36;
        this.url = str5;
        this.murl = str6;
        this.surl = str7;
        this.albumid = str8;
        this.albumname = str9;
    }
}
