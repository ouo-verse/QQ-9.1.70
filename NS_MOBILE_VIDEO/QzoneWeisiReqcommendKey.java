package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneWeisiReqcommendKey extends JceStruct {
    public String feed_id;
    public String ugckey;
    public long uin;

    public QzoneWeisiReqcommendKey() {
        this.feed_id = "";
        this.ugckey = "";
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(0, false);
        this.ugckey = jceInputStream.readString(1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.feed_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.ugckey;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.uin, 2);
    }

    public QzoneWeisiReqcommendKey(String str, String str2, long j3) {
        this.feed_id = str;
        this.ugckey = str2;
        this.uin = j3;
    }
}
