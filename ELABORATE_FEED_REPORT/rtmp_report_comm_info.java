package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class rtmp_report_comm_info extends JceStruct {
    static int cache_play_type;
    public String appid;
    public long flow;
    public String network;
    public String play_id;
    public int play_type;
    public String qua;
    public String room_id;
    public long uin;

    public rtmp_report_comm_info() {
        this.play_id = "";
        this.qua = "";
        this.network = "";
        this.appid = "";
        this.play_type = 0;
        this.room_id = "";
        this.uin = 0L;
        this.flow = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.play_id = jceInputStream.readString(0, false);
        this.qua = jceInputStream.readString(1, false);
        this.network = jceInputStream.readString(2, false);
        this.appid = jceInputStream.readString(3, false);
        this.play_type = jceInputStream.read(this.play_type, 4, false);
        this.room_id = jceInputStream.readString(5, false);
        this.uin = jceInputStream.read(this.uin, 6, false);
        this.flow = jceInputStream.read(this.flow, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.play_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.network;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.appid;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.play_type, 4);
        String str5 = this.room_id;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.uin, 6);
        jceOutputStream.write(this.flow, 7);
    }

    public rtmp_report_comm_info(String str, String str2, String str3, String str4, int i3, String str5, long j3, long j16) {
        this.play_id = str;
        this.qua = str2;
        this.network = str3;
        this.appid = str4;
        this.play_type = i3;
        this.room_id = str5;
        this.uin = j3;
        this.flow = j16;
    }
}
