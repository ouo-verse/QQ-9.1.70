package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_remark extends JceStruct {
    static s_shoot_info cache_shoot_info = new s_shoot_info();
    public int action_type;
    public String action_url;
    public String remark;
    public String remark_down;
    public String remark_up;
    public s_shoot_info shoot_info;
    public int time;

    public cell_remark() {
        this.remark = "";
        this.remark_up = "";
        this.remark_down = "";
        this.action_type = 0;
        this.action_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.remark = jceInputStream.readString(0, false);
        this.remark_up = jceInputStream.readString(1, false);
        this.remark_down = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
        this.shoot_info = (s_shoot_info) jceInputStream.read((JceStruct) cache_shoot_info, 4, false);
        this.action_type = jceInputStream.read(this.action_type, 5, false);
        this.action_url = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.remark;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.remark_up;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.remark_down;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.time, 3);
        s_shoot_info s_shoot_infoVar = this.shoot_info;
        if (s_shoot_infoVar != null) {
            jceOutputStream.write((JceStruct) s_shoot_infoVar, 4);
        }
        jceOutputStream.write(this.action_type, 5);
        String str4 = this.action_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public cell_remark(String str, String str2, String str3, int i3, s_shoot_info s_shoot_infoVar, int i16, String str4) {
        this.remark = str;
        this.remark_up = str2;
        this.remark_down = str3;
        this.time = i3;
        this.shoot_info = s_shoot_infoVar;
        this.action_type = i16;
        this.action_url = str4;
    }
}
