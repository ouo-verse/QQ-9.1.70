package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_feedsphoto_bytimeline_req extends JceStruct {
    public String attach_info;
    public long begin_time;
    public long end_time;
    public int type;
    public long uin;

    public get_feedsphoto_bytimeline_req() {
        this.uin = 0L;
        this.begin_time = 0L;
        this.end_time = 0L;
        this.type = 0;
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.begin_time = jceInputStream.read(this.begin_time, 1, false);
        this.end_time = jceInputStream.read(this.end_time, 2, false);
        this.type = jceInputStream.read(this.type, 3, false);
        this.attach_info = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.begin_time, 1);
        jceOutputStream.write(this.end_time, 2);
        jceOutputStream.write(this.type, 3);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public get_feedsphoto_bytimeline_req(long j3, long j16, long j17, int i3, String str) {
        this.uin = j3;
        this.begin_time = j16;
        this.end_time = j17;
        this.type = i3;
        this.attach_info = str;
    }
}
