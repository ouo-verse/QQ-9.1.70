package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class action_flow extends JceStruct {
    static Map<Integer, String> cache_mapExtend = new HashMap();
    public long lTime;
    public Map<Integer, String> mapExtend;
    public int uActionHierarchy;
    public long uDurationTime;
    public int uPageType;

    static {
        cache_mapExtend.put(0, "");
    }

    public action_flow() {
        this.uActionHierarchy = 0;
        this.lTime = 0L;
        this.uPageType = 0;
        this.mapExtend = null;
        this.uDurationTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uActionHierarchy = jceInputStream.read(this.uActionHierarchy, 0, false);
        this.lTime = jceInputStream.read(this.lTime, 1, false);
        this.uPageType = jceInputStream.read(this.uPageType, 2, false);
        this.mapExtend = (Map) jceInputStream.read((JceInputStream) cache_mapExtend, 3, false);
        this.uDurationTime = jceInputStream.read(this.uDurationTime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uActionHierarchy, 0);
        jceOutputStream.write(this.lTime, 1);
        jceOutputStream.write(this.uPageType, 2);
        Map<Integer, String> map = this.mapExtend;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.uDurationTime, 4);
    }

    public action_flow(int i3, long j3, int i16, Map<Integer, String> map, long j16) {
        this.uActionHierarchy = i3;
        this.lTime = j3;
        this.uPageType = i16;
        this.mapExtend = map;
        this.uDurationTime = j16;
    }
}
