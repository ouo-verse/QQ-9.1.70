package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_visit_contentkey extends JceStruct {
    public long appid;
    public String contentid;
    public long tid;

    public s_visit_contentkey() {
        this.contentid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tid = jceInputStream.read(this.tid, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.contentid = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tid, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.contentid, 2);
    }

    public s_visit_contentkey(long j3, long j16, String str) {
        this.tid = j3;
        this.appid = j16;
        this.contentid = str;
    }
}
