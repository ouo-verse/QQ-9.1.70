package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetReminderReq extends JceStruct {
    static Map<String, String> cache_MapUserInfo;
    public Map<String, String> MapUserInfo;
    public int iZoneId;
    public String sIp;
    public String sQua;
    public long uiUin;

    public GetReminderReq() {
        this.sQua = "";
        this.sIp = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiUin = jceInputStream.read(this.uiUin, 0, true);
        this.iZoneId = jceInputStream.read(this.iZoneId, 1, true);
        this.sQua = jceInputStream.readString(2, false);
        this.sIp = jceInputStream.readString(3, false);
        if (cache_MapUserInfo == null) {
            HashMap hashMap = new HashMap();
            cache_MapUserInfo = hashMap;
            hashMap.put("", "");
        }
        this.MapUserInfo = (Map) jceInputStream.read((JceInputStream) cache_MapUserInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiUin, 0);
        jceOutputStream.write(this.iZoneId, 1);
        String str = this.sQua;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.sIp;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<String, String> map = this.MapUserInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public GetReminderReq(long j3, int i3, String str, String str2, Map<String, String> map) {
        this.uiUin = j3;
        this.iZoneId = i3;
        this.sQua = str;
        this.sIp = str2;
        this.MapUserInfo = map;
    }
}
