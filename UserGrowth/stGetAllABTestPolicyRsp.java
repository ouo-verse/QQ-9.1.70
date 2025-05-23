package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGetAllABTestPolicyRsp extends JceStruct {
    static Map<String, String> cache_mapExt;
    static Map<String, stGrayPolicyInfo> cache_policyInfo = new HashMap();
    static Map<String, ArrayList<String>> cache_profile;
    public Map<String, String> mapExt;
    public Map<String, stGrayPolicyInfo> policyInfo;
    public Map<String, ArrayList<String>> profile;
    public long serverTime;

    static {
        cache_policyInfo.put("", new stGrayPolicyInfo());
        cache_profile = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_profile.put("", arrayList);
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public stGetAllABTestPolicyRsp() {
        this.policyInfo = null;
        this.profile = null;
        this.mapExt = null;
        this.serverTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.policyInfo = (Map) jceInputStream.read((JceInputStream) cache_policyInfo, 0, false);
        this.profile = (Map) jceInputStream.read((JceInputStream) cache_profile, 1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
        this.serverTime = jceInputStream.read(this.serverTime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, stGrayPolicyInfo> map = this.policyInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        Map<String, ArrayList<String>> map2 = this.profile;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 1);
        }
        Map<String, String> map3 = this.mapExt;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 2);
        }
        jceOutputStream.write(this.serverTime, 3);
    }

    public stGetAllABTestPolicyRsp(Map<String, stGrayPolicyInfo> map, Map<String, ArrayList<String>> map2, Map<String, String> map3, long j3) {
        this.policyInfo = map;
        this.profile = map2;
        this.mapExt = map3;
        this.serverTime = j3;
    }
}
