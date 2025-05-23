package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_set_cover_req extends JceStruct {
    public int controlBits;
    public String cover;
    public long coverScene;
    public String coverkey;
    public int iTransparency;
    public int iVideoHeight;
    public int iVideoWidth;
    public String strVideoPlay;
    public long syncflag;
    public String trace;
    public String type;
    public long uin;

    public mobile_sub_set_cover_req() {
        this.cover = "";
        this.type = "";
        this.coverkey = "";
        this.trace = "";
        this.iTransparency = 0;
        this.strVideoPlay = "";
        this.iVideoWidth = 0;
        this.iVideoHeight = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.cover = jceInputStream.readString(1, false);
        this.type = jceInputStream.readString(2, false);
        this.coverkey = jceInputStream.readString(3, false);
        this.syncflag = jceInputStream.read(this.syncflag, 4, false);
        this.coverScene = jceInputStream.read(this.coverScene, 5, false);
        this.controlBits = jceInputStream.read(this.controlBits, 6, false);
        this.trace = jceInputStream.readString(7, false);
        this.iTransparency = jceInputStream.read(this.iTransparency, 8, false);
        this.strVideoPlay = jceInputStream.readString(9, false);
        this.iVideoWidth = jceInputStream.read(this.iVideoWidth, 10, false);
        this.iVideoHeight = jceInputStream.read(this.iVideoHeight, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.cover;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.type;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.coverkey;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.syncflag, 4);
        jceOutputStream.write(this.coverScene, 5);
        jceOutputStream.write(this.controlBits, 6);
        String str4 = this.trace;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.iTransparency, 8);
        String str5 = this.strVideoPlay;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        jceOutputStream.write(this.iVideoWidth, 10);
        jceOutputStream.write(this.iVideoHeight, 11);
    }

    public mobile_sub_set_cover_req(long j3, String str, String str2, String str3, long j16, long j17, int i3, String str4, int i16, String str5, int i17, int i18) {
        this.uin = j3;
        this.cover = str;
        this.type = str2;
        this.coverkey = str3;
        this.syncflag = j16;
        this.coverScene = j17;
        this.controlBits = i3;
        this.trace = str4;
        this.iTransparency = i16;
        this.strVideoPlay = str5;
        this.iVideoWidth = i17;
        this.iVideoHeight = i18;
    }
}
