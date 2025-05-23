package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_tab_get_req extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public int iAppid;
    public long lUin;
    public Map<String, String> mapExtInfo;
    public String strAttachInfo;
    public String strQua;
    public String strTabKey;
    public String strTraceInfo;
    public long uiSettleTime;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_tab_get_req() {
        this.lUin = 0L;
        this.iAppid = 0;
        this.strTabKey = "";
        this.strAttachInfo = "";
        this.uiSettleTime = 0L;
        this.strTraceInfo = "";
        this.mapExtInfo = null;
        this.strQua = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.iAppid = jceInputStream.read(this.iAppid, 1, false);
        this.strTabKey = jceInputStream.readString(2, false);
        this.strAttachInfo = jceInputStream.readString(3, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 4, false);
        this.strTraceInfo = jceInputStream.readString(5, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 6, false);
        this.strQua = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iAppid, 1);
        String str = this.strTabKey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strAttachInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.uiSettleTime, 4);
        String str3 = this.strTraceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str4 = this.strQua;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
    }

    public material_tab_get_req(long j3, int i3, String str, String str2, long j16, String str3, Map<String, String> map, String str4) {
        this.lUin = j3;
        this.iAppid = i3;
        this.strTabKey = str;
        this.strAttachInfo = str2;
        this.uiSettleTime = j16;
        this.strTraceInfo = str3;
        this.mapExtInfo = map;
        this.strQua = str4;
    }
}
