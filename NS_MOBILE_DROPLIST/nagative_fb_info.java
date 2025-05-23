package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class nagative_fb_info extends JceStruct {
    public String attach_info;
    public String fb_name;
    public int fb_type;
    public String tag_name;
    public int tag_type;

    public nagative_fb_info() {
        this.fb_type = 0;
        this.fb_name = "";
        this.tag_type = 0;
        this.tag_name = "";
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fb_type = jceInputStream.read(this.fb_type, 0, false);
        this.fb_name = jceInputStream.readString(1, false);
        this.tag_type = jceInputStream.read(this.tag_type, 2, false);
        this.tag_name = jceInputStream.readString(3, false);
        this.attach_info = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fb_type, 0);
        String str = this.fb_name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.tag_type, 2);
        String str2 = this.tag_name;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.attach_info;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public nagative_fb_info(int i3, String str, int i16, String str2, String str3) {
        this.fb_type = i3;
        this.fb_name = str;
        this.tag_type = i16;
        this.tag_name = str2;
        this.attach_info = str3;
    }
}
