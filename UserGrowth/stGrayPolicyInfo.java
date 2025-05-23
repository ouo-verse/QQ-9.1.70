package UserGrowth;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGrayPolicyInfo extends JceStruct {
    static Map<String, String> cache_params;
    public String grayPolicyId;
    public Map<String, String> params;

    static {
        HashMap hashMap = new HashMap();
        cache_params = hashMap;
        hashMap.put("", "");
    }

    public stGrayPolicyInfo() {
        this.grayPolicyId = "";
        this.params = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || stGrayPolicyInfo.class != obj.getClass()) {
            return false;
        }
        stGrayPolicyInfo stgraypolicyinfo = (stGrayPolicyInfo) obj;
        if (!TextUtils.equals(this.grayPolicyId, stgraypolicyinfo.grayPolicyId)) {
            return false;
        }
        Map<String, String> map = this.params;
        Map<String, String> map2 = stgraypolicyinfo.params;
        if (map == null) {
            if (map2 == null) {
                return true;
            }
            return false;
        }
        return map.equals(map2);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grayPolicyId = jceInputStream.readString(0, false);
        this.params = (Map) jceInputStream.read((JceInputStream) cache_params, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "{grayPolicyId='" + this.grayPolicyId + "', params=" + this.params + "}\n";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.grayPolicyId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<String, String> map = this.params;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public stGrayPolicyInfo(String str, Map<String, String> map) {
        this.grayPolicyId = str;
        this.params = map;
    }
}
