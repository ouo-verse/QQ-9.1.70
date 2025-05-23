package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_campus_qz extends JceStruct {
    public int is_campus_qz_bar;
    public int num_feeds;
    public int num_msg;

    public s_campus_qz() {
        this.is_campus_qz_bar = 0;
        this.num_msg = 0;
        this.num_feeds = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_campus_qz_bar = jceInputStream.read(this.is_campus_qz_bar, 0, false);
        this.num_msg = jceInputStream.read(this.num_msg, 1, false);
        this.num_feeds = jceInputStream.read(this.num_feeds, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_campus_qz_bar, 0);
        jceOutputStream.write(this.num_msg, 1);
        jceOutputStream.write(this.num_feeds, 2);
    }

    public s_campus_qz(int i3, int i16, int i17) {
        this.is_campus_qz_bar = i3;
        this.num_msg = i16;
        this.num_feeds = i17;
    }
}
