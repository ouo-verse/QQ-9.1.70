package NS_QBOSS_GATEWAY_PROTO;

import BOSSStrategyCenter.tPullADVRequest;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QbossGateWayReq extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static tPullADVRequest cache_stAdvReq = new tPullADVRequest();
    static LoginInfo cache_stLoginInfo = new LoginInfo();
    public int iAppID;
    public Map<String, String> mapExtInfo;
    public tPullADVRequest stAdvReq;
    public LoginInfo stLoginInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public QbossGateWayReq() {
        this.stAdvReq = null;
        this.stLoginInfo = null;
        this.iAppID = 0;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stAdvReq = (tPullADVRequest) jceInputStream.read((JceStruct) cache_stAdvReq, 0, true);
        this.stLoginInfo = (LoginInfo) jceInputStream.read((JceStruct) cache_stLoginInfo, 1, false);
        this.iAppID = jceInputStream.read(this.iAppID, 2, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stAdvReq, 0);
        LoginInfo loginInfo = this.stLoginInfo;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 1);
        }
        jceOutputStream.write(this.iAppID, 2);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public QbossGateWayReq(tPullADVRequest tpulladvrequest, LoginInfo loginInfo, int i3, Map<String, String> map) {
        this.stAdvReq = tpulladvrequest;
        this.stLoginInfo = loginInfo;
        this.iAppID = i3;
        this.mapExtInfo = map;
    }
}
