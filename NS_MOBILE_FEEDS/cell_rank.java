package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_rank extends JceStruct {
    static s_rank cache_rank = new s_rank();
    public s_rank rank;

    public cell_rank() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rank = (s_rank) jceInputStream.read((JceStruct) cache_rank, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_rank s_rankVar = this.rank;
        if (s_rankVar != null) {
            jceOutputStream.write((JceStruct) s_rankVar, 0);
        }
    }

    public cell_rank(s_rank s_rankVar) {
        this.rank = s_rankVar;
    }
}
