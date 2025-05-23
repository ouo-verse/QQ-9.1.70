package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFriendFeedRsp extends JceStruct {
    static stFriendFeed cache_friendFeed = new stFriendFeed();
    static Map<String, String> cache_mapExt;
    public stFriendFeed friendFeed;
    public int isFinished;
    public Map<String, String> mapExt;
    public String traceId;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public stFriendFeedRsp() {
        this.friendFeed = null;
        this.isFinished = 0;
        this.traceId = "";
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.friendFeed = (stFriendFeed) jceInputStream.read((JceStruct) cache_friendFeed, 0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.traceId = jceInputStream.readString(2, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stFriendFeed stfriendfeed = this.friendFeed;
        if (stfriendfeed != null) {
            jceOutputStream.write((JceStruct) stfriendfeed, 0);
        }
        jceOutputStream.write(this.isFinished, 1);
        String str = this.traceId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public stFriendFeedRsp(stFriendFeed stfriendfeed, int i3, String str, Map<String, String> map) {
        this.friendFeed = stfriendfeed;
        this.isFinished = i3;
        this.traceId = str;
        this.mapExt = map;
    }
}
