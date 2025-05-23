package WUP_SECRET_UGC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportUgcTopicReq extends JceStruct {
    public String content;
    public long time;
    public String ugc_id;
    public String uid;

    public ReportUgcTopicReq() {
        this.uid = "";
        this.ugc_id = "";
        this.content = "";
        this.time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.readString(0, false);
        this.ugc_id = jceInputStream.readString(1, false);
        this.content = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.ugc_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.time, 3);
    }

    public ReportUgcTopicReq(String str, String str2, String str3, long j3) {
        this.uid = str;
        this.ugc_id = str2;
        this.content = str3;
        this.time = j3;
    }
}
