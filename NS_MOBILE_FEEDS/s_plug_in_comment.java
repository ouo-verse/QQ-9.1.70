package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_plug_in_comment extends JceStruct {
    public int action_type;
    public String action_url;
    public int insert_index;
    public String title;

    public s_plug_in_comment() {
        this.title = "";
        this.action_type = 0;
        this.action_url = "";
        this.insert_index = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.action_type = jceInputStream.read(this.action_type, 1, false);
        this.action_url = jceInputStream.readString(2, false);
        this.insert_index = jceInputStream.read(this.insert_index, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.action_type, 1);
        String str2 = this.action_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.insert_index, 3);
    }

    public s_plug_in_comment(String str, int i3, String str2, int i16) {
        this.title = str;
        this.action_type = i3;
        this.action_url = str2;
        this.insert_index = i16;
    }
}
