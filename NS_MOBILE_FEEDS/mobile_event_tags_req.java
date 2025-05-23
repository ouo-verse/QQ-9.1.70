package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_event_tags_req extends JceStruct {
    public String content;
    public int count;
    public int recom_type;

    public mobile_event_tags_req() {
        this.count = 0;
        this.content = "";
        this.recom_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.count = jceInputStream.read(this.count, 0, false);
        this.content = jceInputStream.readString(1, false);
        this.recom_type = jceInputStream.read(this.recom_type, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.count, 0);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.recom_type, 2);
    }

    public mobile_event_tags_req(int i3, String str, int i16) {
        this.count = i3;
        this.content = str;
        this.recom_type = i16;
    }
}
