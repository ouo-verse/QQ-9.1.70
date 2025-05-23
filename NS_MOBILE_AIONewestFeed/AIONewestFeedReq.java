package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AIONewestFeedReq extends JceStruct {
    static ArrayList<Long> cache_uHostUin = new ArrayList<>();
    public int src;
    public ArrayList<Long> uHostUin;
    public long uLastTime;
    public long uOpUin;

    static {
        cache_uHostUin.add(0L);
    }

    public AIONewestFeedReq() {
        this.uOpUin = 0L;
        this.uHostUin = null;
        this.uLastTime = 0L;
        this.src = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uOpUin = jceInputStream.read(this.uOpUin, 0, false);
        this.uHostUin = (ArrayList) jceInputStream.read((JceInputStream) cache_uHostUin, 1, false);
        this.uLastTime = jceInputStream.read(this.uLastTime, 2, false);
        this.src = jceInputStream.read(this.src, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uOpUin, 0);
        ArrayList<Long> arrayList = this.uHostUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.uLastTime, 2);
        jceOutputStream.write(this.src, 3);
    }

    public AIONewestFeedReq(long j3, ArrayList<Long> arrayList, long j16, int i3) {
        this.uOpUin = j3;
        this.uHostUin = arrayList;
        this.uLastTime = j16;
        this.src = i3;
    }
}
