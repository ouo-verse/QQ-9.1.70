package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_picurl extends JceStruct {
    public int enlarge_rate;
    public int focus_x;
    public int focus_y;
    public int height;
    public String md5;
    public long size;
    public String url;
    public int width;

    public s_picurl() {
        this.url = "";
        this.width = 0;
        this.height = 0;
        this.focus_x = 0;
        this.focus_y = 0;
        this.enlarge_rate = 200;
        this.size = 0L;
        this.md5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.width = jceInputStream.read(this.width, 1, false);
        this.height = jceInputStream.read(this.height, 2, false);
        this.focus_x = jceInputStream.read(this.focus_x, 3, false);
        this.focus_y = jceInputStream.read(this.focus_y, 4, false);
        this.enlarge_rate = jceInputStream.read(this.enlarge_rate, 5, false);
        this.size = jceInputStream.read(this.size, 6, false);
        this.md5 = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.width, 1);
        jceOutputStream.write(this.height, 2);
        jceOutputStream.write(this.focus_x, 3);
        jceOutputStream.write(this.focus_y, 4);
        jceOutputStream.write(this.enlarge_rate, 5);
        jceOutputStream.write(this.size, 6);
        String str2 = this.md5;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
    }

    public s_picurl(String str, int i3, int i16, int i17, int i18, int i19, long j3, String str2) {
        this.url = str;
        this.width = i3;
        this.height = i16;
        this.focus_x = i17;
        this.focus_y = i18;
        this.enlarge_rate = i19;
        this.size = j3;
        this.md5 = str2;
    }
}
