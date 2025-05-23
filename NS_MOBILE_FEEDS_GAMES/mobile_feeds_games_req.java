package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_feeds_games_req extends JceStruct {
    static Map<String, String> cache_mapExt;
    public int iLastGamesRes;
    public int iNextGamesStatus;
    public int iType;
    public Map<String, String> mapExt;
    public Map<Integer, String> mapRsp;
    public st_Games_OpData opData;
    static st_Games_OpData cache_opData = new st_Games_OpData();
    static Map<Integer, String> cache_mapRsp = new HashMap();

    static {
        cache_mapRsp.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public mobile_feeds_games_req() {
        this.iType = -1;
        this.iLastGamesRes = -1;
        this.opData = null;
        this.iNextGamesStatus = -1;
        this.mapRsp = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, true);
        this.iLastGamesRes = jceInputStream.read(this.iLastGamesRes, 1, false);
        this.opData = (st_Games_OpData) jceInputStream.read((JceStruct) cache_opData, 2, false);
        this.iNextGamesStatus = jceInputStream.read(this.iNextGamesStatus, 3, false);
        this.mapRsp = (Map) jceInputStream.read((JceInputStream) cache_mapRsp, 4, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        jceOutputStream.write(this.iLastGamesRes, 1);
        st_Games_OpData st_games_opdata = this.opData;
        if (st_games_opdata != null) {
            jceOutputStream.write((JceStruct) st_games_opdata, 2);
        }
        jceOutputStream.write(this.iNextGamesStatus, 3);
        Map<Integer, String> map = this.mapRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        Map<String, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
    }

    public mobile_feeds_games_req(int i3, int i16, st_Games_OpData st_games_opdata, int i17, Map<Integer, String> map, Map<String, String> map2) {
        this.iType = i3;
        this.iLastGamesRes = i16;
        this.opData = st_games_opdata;
        this.iNextGamesStatus = i17;
        this.mapRsp = map;
        this.mapExt = map2;
    }
}
