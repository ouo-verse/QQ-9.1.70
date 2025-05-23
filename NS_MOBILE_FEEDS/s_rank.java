package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_rank extends JceStruct {
    public int half_star_num;
    public int max;

    public s_rank() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.max = jceInputStream.read(this.max, 0, false);
        this.half_star_num = jceInputStream.read(this.half_star_num, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.max, 0);
        jceOutputStream.write(this.half_star_num, 1);
    }

    public s_rank(int i3, int i16) {
        this.max = i3;
        this.half_star_num = i16;
    }
}
