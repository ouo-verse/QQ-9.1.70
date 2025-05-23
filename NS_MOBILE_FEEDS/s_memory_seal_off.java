package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_memory_seal_off extends JceStruct {
    public int action_type;
    public String action_url;
    public String button_text;
    public int memory_time;
    public String no_right_summary;
    public String summary;
    public int type;

    public s_memory_seal_off() {
        this.memory_time = 0;
        this.summary = "";
        this.action_type = 0;
        this.action_url = "";
        this.button_text = "";
        this.type = 0;
        this.no_right_summary = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.memory_time = jceInputStream.read(this.memory_time, 0, false);
        this.summary = jceInputStream.readString(1, false);
        this.action_type = jceInputStream.read(this.action_type, 2, false);
        this.action_url = jceInputStream.readString(3, false);
        this.button_text = jceInputStream.readString(4, false);
        this.type = jceInputStream.read(this.type, 5, false);
        this.no_right_summary = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.memory_time, 0);
        String str = this.summary;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.action_type, 2);
        String str2 = this.action_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.button_text;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.type, 5);
        String str4 = this.no_right_summary;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public s_memory_seal_off(int i3, String str, int i16, String str2, String str3, int i17, String str4) {
        this.memory_time = i3;
        this.summary = str;
        this.action_type = i16;
        this.action_url = str2;
        this.button_text = str3;
        this.type = i17;
        this.no_right_summary = str4;
    }
}
