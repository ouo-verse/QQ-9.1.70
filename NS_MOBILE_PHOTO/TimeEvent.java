package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeEvent extends JceStruct {
    public String content;
    public String copywriter;
    public long time;
    public long type;

    public TimeEvent() {
        this.time = 0L;
        this.type = 0L;
        this.content = "";
        this.copywriter = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.time = jceInputStream.read(this.time, 0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.content = jceInputStream.readString(2, false);
        this.copywriter = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.time, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.copywriter;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public TimeEvent(long j3, long j16, String str, String str2) {
        this.time = j3;
        this.type = j16;
        this.content = str;
        this.copywriter = str2;
    }
}
