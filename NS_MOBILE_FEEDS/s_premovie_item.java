package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_premovie_item extends JceStruct {
    public int actiontype;
    public int duration;
    public int height;
    public String jumpurl;
    public String vid;
    public String videourl;
    public int width;

    public s_premovie_item() {
        this.vid = "";
        this.videourl = "";
        this.width = 0;
        this.height = 0;
        this.duration = 0;
        this.actiontype = 0;
        this.jumpurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vid = jceInputStream.readString(0, false);
        this.videourl = jceInputStream.readString(1, false);
        this.width = jceInputStream.read(this.width, 2, false);
        this.height = jceInputStream.read(this.height, 3, false);
        this.duration = jceInputStream.read(this.duration, 4, false);
        this.actiontype = jceInputStream.read(this.actiontype, 5, false);
        this.jumpurl = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.videourl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.width, 2);
        jceOutputStream.write(this.height, 3);
        jceOutputStream.write(this.duration, 4);
        jceOutputStream.write(this.actiontype, 5);
        String str3 = this.jumpurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }

    public s_premovie_item(String str, String str2, int i3, int i16, int i17, int i18, String str3) {
        this.vid = str;
        this.videourl = str2;
        this.width = i3;
        this.height = i16;
        this.duration = i17;
        this.actiontype = i18;
        this.jumpurl = str3;
    }
}
