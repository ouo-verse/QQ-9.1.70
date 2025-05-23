package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAdsRsp extends JceStruct {
    static Map<Long, AdPlacementInfo> cache_mapAds = new HashMap();
    public int code;
    public String errmsg;
    public Map<Long, AdPlacementInfo> mapAds;
    public String rspExtInfo;

    static {
        cache_mapAds.put(0L, new AdPlacementInfo());
    }

    public GetAdsRsp() {
        this.code = 0;
        this.errmsg = "";
        this.mapAds = null;
        this.rspExtInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 1, false);
        this.errmsg = jceInputStream.readString(2, false);
        this.mapAds = (Map) jceInputStream.read((JceInputStream) cache_mapAds, 3, false);
        this.rspExtInfo = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 1);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<Long, AdPlacementInfo> map = this.mapAds;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str2 = this.rspExtInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GetAdsRsp(int i3, String str, Map<Long, AdPlacementInfo> map, String str2) {
        this.code = i3;
        this.errmsg = str;
        this.mapAds = map;
        this.rspExtInfo = str2;
    }
}
