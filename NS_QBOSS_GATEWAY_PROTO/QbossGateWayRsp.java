package NS_QBOSS_GATEWAY_PROTO;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QbossGateWayRsp extends JceStruct {
    static Map<Integer, ArrayList<tAdvDesc>> cache_mapAdv = new HashMap();
    public int iRet;
    public Map<Integer, ArrayList<tAdvDesc>> mapAdv;
    public String strMsg;

    static {
        ArrayList<tAdvDesc> arrayList = new ArrayList<>();
        arrayList.add(new tAdvDesc());
        cache_mapAdv.put(0, arrayList);
    }

    public QbossGateWayRsp() {
        this.iRet = 0;
        this.strMsg = "";
        this.mapAdv = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.strMsg = jceInputStream.readString(1, true);
        this.mapAdv = (Map) jceInputStream.read((JceInputStream) cache_mapAdv, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.strMsg, 1);
        jceOutputStream.write((Map) this.mapAdv, 2);
    }

    public QbossGateWayRsp(int i3, String str, Map<Integer, ArrayList<tAdvDesc>> map) {
        this.iRet = i3;
        this.strMsg = str;
        this.mapAdv = map;
    }
}
