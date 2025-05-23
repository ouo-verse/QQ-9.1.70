package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserClientShowInfo extends JceStruct {
    static Map<String, IconInfo> cache_mapIconInfo = new HashMap();
    public int iIsUseVipIcon;
    public int iKeepVipDays;
    public int iLevel;
    public int iScore;
    public int iSpeed;
    public int iVip;
    public int iVipRatio;
    public Map<String, IconInfo> mapIconInfo;
    public String strUid;

    static {
        cache_mapIconInfo.put("", new IconInfo());
    }

    public UserClientShowInfo() {
        this.strUid = "";
        this.iVipRatio = 0;
        this.iKeepVipDays = 0;
        this.iVip = 0;
        this.iLevel = 0;
        this.iSpeed = 0;
        this.iScore = 0;
        this.iIsUseVipIcon = 0;
        this.mapIconInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strUid = jceInputStream.readString(0, false);
        this.iVipRatio = jceInputStream.read(this.iVipRatio, 1, false);
        this.iKeepVipDays = jceInputStream.read(this.iKeepVipDays, 2, false);
        this.iVip = jceInputStream.read(this.iVip, 3, false);
        this.iLevel = jceInputStream.read(this.iLevel, 4, false);
        this.iSpeed = jceInputStream.read(this.iSpeed, 5, false);
        this.iScore = jceInputStream.read(this.iScore, 6, false);
        this.iIsUseVipIcon = jceInputStream.read(this.iIsUseVipIcon, 7, false);
        this.mapIconInfo = (Map) jceInputStream.read((JceInputStream) cache_mapIconInfo, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strUid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iVipRatio, 1);
        jceOutputStream.write(this.iKeepVipDays, 2);
        jceOutputStream.write(this.iVip, 3);
        jceOutputStream.write(this.iLevel, 4);
        jceOutputStream.write(this.iSpeed, 5);
        jceOutputStream.write(this.iScore, 6);
        jceOutputStream.write(this.iIsUseVipIcon, 7);
        Map<String, IconInfo> map = this.mapIconInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public UserClientShowInfo(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Map<String, IconInfo> map) {
        this.strUid = str;
        this.iVipRatio = i3;
        this.iKeepVipDays = i16;
        this.iVip = i17;
        this.iLevel = i18;
        this.iSpeed = i19;
        this.iScore = i26;
        this.iIsUseVipIcon = i27;
        this.mapIconInfo = map;
    }
}
