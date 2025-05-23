package NS_MOBILE_QBOSS_PROTO;

import BOSSStrategyCenter.tAdvAppInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileQbossAdvReq extends JceStruct {
    static Map<Integer, SceneExt> cache_mapSceneExt;
    static ArrayList<tAdvAppInfo> cache_vecReqApp;
    public int iNeedExposeTime;
    public int iPullAsExposeOper;
    public int iReqFlag;
    public String idfa;
    public Map<Integer, SceneExt> mapSceneExt;
    public long uiUin;
    public ArrayList<tAdvAppInfo> vecReqApp;

    public MobileQbossAdvReq() {
        this.idfa = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiUin = jceInputStream.read(this.uiUin, 0, true);
        if (cache_vecReqApp == null) {
            cache_vecReqApp = new ArrayList<>();
            cache_vecReqApp.add(new tAdvAppInfo());
        }
        this.vecReqApp = (ArrayList) jceInputStream.read((JceInputStream) cache_vecReqApp, 1, true);
        this.iPullAsExposeOper = jceInputStream.read(this.iPullAsExposeOper, 2, false);
        this.iNeedExposeTime = jceInputStream.read(this.iNeedExposeTime, 3, false);
        this.iReqFlag = jceInputStream.read(this.iReqFlag, 4, false);
        this.idfa = jceInputStream.readString(5, false);
        if (cache_mapSceneExt == null) {
            cache_mapSceneExt = new HashMap();
            cache_mapSceneExt.put(0, new SceneExt());
        }
        this.mapSceneExt = (Map) jceInputStream.read((JceInputStream) cache_mapSceneExt, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiUin, 0);
        jceOutputStream.write((Collection) this.vecReqApp, 1);
        jceOutputStream.write(this.iPullAsExposeOper, 2);
        jceOutputStream.write(this.iNeedExposeTime, 3);
        jceOutputStream.write(this.iReqFlag, 4);
        String str = this.idfa;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        Map<Integer, SceneExt> map = this.mapSceneExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public MobileQbossAdvReq(long j3, ArrayList<tAdvAppInfo> arrayList, int i3, int i16, int i17, String str, Map<Integer, SceneExt> map) {
        this.uiUin = j3;
        this.vecReqApp = arrayList;
        this.iPullAsExposeOper = i3;
        this.iNeedExposeTime = i16;
        this.iReqFlag = i17;
        this.idfa = str;
        this.mapSceneExt = map;
    }
}
