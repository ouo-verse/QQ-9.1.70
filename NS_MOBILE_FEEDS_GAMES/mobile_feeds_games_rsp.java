package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_feeds_games_rsp extends JceStruct {
    public Map<Integer, String> mapRsp;
    public st_Games_MarketData mkData;
    public st_Games_OpData opData;
    public st_Games_OrderData orderData;
    static st_Games_OrderData cache_orderData = new st_Games_OrderData();
    static st_Games_OpData cache_opData = new st_Games_OpData();
    static st_Games_MarketData cache_mkData = new st_Games_MarketData();
    static Map<Integer, String> cache_mapRsp = new HashMap();

    static {
        cache_mapRsp.put(0, "");
    }

    public mobile_feeds_games_rsp() {
        this.orderData = null;
        this.opData = null;
        this.mkData = null;
        this.mapRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.orderData = (st_Games_OrderData) jceInputStream.read((JceStruct) cache_orderData, 0, false);
        this.opData = (st_Games_OpData) jceInputStream.read((JceStruct) cache_opData, 1, false);
        this.mkData = (st_Games_MarketData) jceInputStream.read((JceStruct) cache_mkData, 2, false);
        this.mapRsp = (Map) jceInputStream.read((JceInputStream) cache_mapRsp, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        st_Games_OrderData st_games_orderdata = this.orderData;
        if (st_games_orderdata != null) {
            jceOutputStream.write((JceStruct) st_games_orderdata, 0);
        }
        st_Games_OpData st_games_opdata = this.opData;
        if (st_games_opdata != null) {
            jceOutputStream.write((JceStruct) st_games_opdata, 1);
        }
        st_Games_MarketData st_games_marketdata = this.mkData;
        if (st_games_marketdata != null) {
            jceOutputStream.write((JceStruct) st_games_marketdata, 2);
        }
        Map<Integer, String> map = this.mapRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public mobile_feeds_games_rsp(st_Games_OrderData st_games_orderdata, st_Games_OpData st_games_opdata, st_Games_MarketData st_games_marketdata, Map<Integer, String> map) {
        this.orderData = st_games_orderdata;
        this.opData = st_games_opdata;
        this.mkData = st_games_marketdata;
        this.mapRsp = map;
    }
}
