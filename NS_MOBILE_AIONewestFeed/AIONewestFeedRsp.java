package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AIONewestFeedRsp extends JceStruct {
    static Map<String, String> cache_mapEx;
    static ArrayList<NewestFeedInfo> cache_uFeedInfos = new ArrayList<>();
    public Map<String, String> mapEx;
    public ArrayList<NewestFeedInfo> uFeedInfos;
    public long uOpFlag;
    public long uOpuin;
    public long uTime;

    static {
        cache_uFeedInfos.add(new NewestFeedInfo());
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public AIONewestFeedRsp() {
        this.uOpuin = 0L;
        this.uTime = 0L;
        this.uFeedInfos = null;
        this.uOpFlag = 0L;
        this.mapEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uOpuin = jceInputStream.read(this.uOpuin, 0, false);
        this.uTime = jceInputStream.read(this.uTime, 1, false);
        this.uFeedInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_uFeedInfos, 2, false);
        this.uOpFlag = jceInputStream.read(this.uOpFlag, 3, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uOpuin, 0);
        jceOutputStream.write(this.uTime, 1);
        ArrayList<NewestFeedInfo> arrayList = this.uFeedInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.uOpFlag, 3);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public AIONewestFeedRsp(long j3, long j16, ArrayList<NewestFeedInfo> arrayList, long j17, Map<String, String> map) {
        this.uOpuin = j3;
        this.uTime = j16;
        this.uFeedInfos = arrayList;
        this.uOpFlag = j17;
        this.mapEx = map;
    }
}
