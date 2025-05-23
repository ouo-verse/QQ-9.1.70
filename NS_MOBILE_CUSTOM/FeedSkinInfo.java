package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedSkinInfo extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public String desc;
    public int iExpireTime;
    public int iHasNewFlag;
    public int iPrice;
    public int iVipPrize;
    public long lTime;
    public long lUin;
    public Map<String, String> mapExtInfo;
    public String sPicUrl;
    public String sSkinId;
    public int sSkinType;
    public String strBgColor;
    public String strDesignerInfo;
    public String strGradientColorBegin;
    public String strGradientColorEnd;
    public String strItemSummary;
    public String strMusicH5Url;
    public String strThumbUrl;
    public String strTraceInfo;
    public String title;
    public long uiSettleTime;
    public int vip_property;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public FeedSkinInfo() {
        this.sSkinId = "";
        this.lUin = 0L;
        this.sPicUrl = "";
        this.lTime = 0L;
        this.desc = "";
        this.title = "";
        this.vip_property = 0;
        this.sSkinType = 0;
        this.iPrice = 0;
        this.iVipPrize = 0;
        this.iExpireTime = 0;
        this.uiSettleTime = 0L;
        this.strItemSummary = "";
        this.strThumbUrl = "";
        this.strTraceInfo = "";
        this.iHasNewFlag = 0;
        this.strDesignerInfo = "";
        this.strMusicH5Url = "";
        this.mapExtInfo = null;
        this.strBgColor = "";
        this.strGradientColorBegin = "";
        this.strGradientColorEnd = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sSkinId = jceInputStream.readString(0, false);
        this.lUin = jceInputStream.read(this.lUin, 1, false);
        this.sPicUrl = jceInputStream.readString(2, false);
        this.lTime = jceInputStream.read(this.lTime, 3, false);
        this.desc = jceInputStream.readString(4, false);
        this.title = jceInputStream.readString(5, false);
        this.vip_property = jceInputStream.read(this.vip_property, 6, false);
        this.sSkinType = jceInputStream.read(this.sSkinType, 7, false);
        this.iPrice = jceInputStream.read(this.iPrice, 8, false);
        this.iVipPrize = jceInputStream.read(this.iVipPrize, 9, false);
        this.iExpireTime = jceInputStream.read(this.iExpireTime, 10, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 11, false);
        this.strItemSummary = jceInputStream.readString(12, false);
        this.strThumbUrl = jceInputStream.readString(13, false);
        this.strTraceInfo = jceInputStream.readString(14, false);
        this.iHasNewFlag = jceInputStream.read(this.iHasNewFlag, 15, false);
        this.strDesignerInfo = jceInputStream.readString(16, false);
        this.strMusicH5Url = jceInputStream.readString(17, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 18, false);
        this.strBgColor = jceInputStream.readString(19, false);
        this.strGradientColorBegin = jceInputStream.readString(20, false);
        this.strGradientColorEnd = jceInputStream.readString(21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sSkinId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.lUin, 1);
        String str2 = this.sPicUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.lTime, 3);
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.title;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.vip_property, 6);
        jceOutputStream.write(this.sSkinType, 7);
        jceOutputStream.write(this.iPrice, 8);
        jceOutputStream.write(this.iVipPrize, 9);
        jceOutputStream.write(this.iExpireTime, 10);
        jceOutputStream.write(this.uiSettleTime, 11);
        String str5 = this.strItemSummary;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        String str6 = this.strThumbUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        String str7 = this.strTraceInfo;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.iHasNewFlag, 15);
        String str8 = this.strDesignerInfo;
        if (str8 != null) {
            jceOutputStream.write(str8, 16);
        }
        String str9 = this.strMusicH5Url;
        if (str9 != null) {
            jceOutputStream.write(str9, 17);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 18);
        }
        String str10 = this.strBgColor;
        if (str10 != null) {
            jceOutputStream.write(str10, 19);
        }
        String str11 = this.strGradientColorBegin;
        if (str11 != null) {
            jceOutputStream.write(str11, 20);
        }
        String str12 = this.strGradientColorEnd;
        if (str12 != null) {
            jceOutputStream.write(str12, 21);
        }
    }

    public FeedSkinInfo(String str, long j3, String str2, long j16, String str3, String str4, int i3, int i16, int i17, int i18, int i19, long j17, String str5, String str6, String str7, int i26, String str8, String str9, Map<String, String> map, String str10, String str11, String str12) {
        this.sSkinId = str;
        this.lUin = j3;
        this.sPicUrl = str2;
        this.lTime = j16;
        this.desc = str3;
        this.title = str4;
        this.vip_property = i3;
        this.sSkinType = i16;
        this.iPrice = i17;
        this.iVipPrize = i18;
        this.iExpireTime = i19;
        this.uiSettleTime = j17;
        this.strItemSummary = str5;
        this.strThumbUrl = str6;
        this.strTraceInfo = str7;
        this.iHasNewFlag = i26;
        this.strDesignerInfo = str8;
        this.strMusicH5Url = str9;
        this.mapExtInfo = map;
        this.strBgColor = str10;
        this.strGradientColorBegin = str11;
        this.strGradientColorEnd = str12;
    }
}
