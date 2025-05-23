package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_separator extends JceStruct {
    public int action_type;
    public String action_url;
    public int pic_height;
    public String pic_url;
    public int pic_width;

    public cell_separator() {
        this.pic_url = "";
        this.action_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pic_url = jceInputStream.readString(0, false);
        this.action_url = jceInputStream.readString(1, false);
        this.action_type = jceInputStream.read(this.action_type, 2, false);
        this.pic_width = jceInputStream.read(this.pic_width, 3, false);
        this.pic_height = jceInputStream.read(this.pic_height, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.pic_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.action_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.action_type, 2);
        jceOutputStream.write(this.pic_width, 3);
        jceOutputStream.write(this.pic_height, 4);
    }

    public cell_separator(String str, String str2, int i3, int i16, int i17) {
        this.pic_url = str;
        this.action_url = str2;
        this.action_type = i3;
        this.pic_width = i16;
        this.pic_height = i17;
    }
}
