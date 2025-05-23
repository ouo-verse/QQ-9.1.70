package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ConfigRect extends JceStruct {
    static int cache_iContentStyle;
    static int cache_iType;
    static Map<String, String> cache_mapExtInfo;
    static CustomColor cache_stTextColor;
    static CustomColor cache_stTextColorClick;
    public int iCanEdit;
    public int iContentStyle;
    public int iFontSize;
    public int iHp;
    public int iIndexId;
    public int iType;
    public int iWp;
    public int iXp;
    public int iYp;
    public Map<String, String> mapExtInfo;
    public CustomColor stTextColor;
    public CustomColor stTextColorClick;
    public String strImageUrl;
    public String strSchema;
    public String strText;
    public String strUserText;

    public ConfigRect() {
        this.strText = "";
        this.strUserText = "";
        this.strSchema = "";
        this.strImageUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIndexId = jceInputStream.read(this.iIndexId, 0, false);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.iXp = jceInputStream.read(this.iXp, 2, false);
        this.iYp = jceInputStream.read(this.iYp, 3, false);
        this.iWp = jceInputStream.read(this.iWp, 4, false);
        this.iHp = jceInputStream.read(this.iHp, 5, false);
        this.iCanEdit = jceInputStream.read(this.iCanEdit, 6, false);
        this.strText = jceInputStream.readString(7, false);
        this.strUserText = jceInputStream.readString(8, false);
        if (cache_stTextColor == null) {
            cache_stTextColor = new CustomColor();
        }
        this.stTextColor = (CustomColor) jceInputStream.read((JceStruct) cache_stTextColor, 9, false);
        if (cache_stTextColorClick == null) {
            cache_stTextColorClick = new CustomColor();
        }
        this.stTextColorClick = (CustomColor) jceInputStream.read((JceStruct) cache_stTextColorClick, 10, false);
        this.iFontSize = jceInputStream.read(this.iFontSize, 11, false);
        this.strSchema = jceInputStream.readString(12, false);
        this.strImageUrl = jceInputStream.readString(13, false);
        this.iContentStyle = jceInputStream.read(this.iContentStyle, 14, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtInfo = hashMap;
            hashMap.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIndexId, 0);
        jceOutputStream.write(this.iType, 1);
        jceOutputStream.write(this.iXp, 2);
        jceOutputStream.write(this.iYp, 3);
        jceOutputStream.write(this.iWp, 4);
        jceOutputStream.write(this.iHp, 5);
        jceOutputStream.write(this.iCanEdit, 6);
        String str = this.strText;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        String str2 = this.strUserText;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        CustomColor customColor = this.stTextColor;
        if (customColor != null) {
            jceOutputStream.write((JceStruct) customColor, 9);
        }
        CustomColor customColor2 = this.stTextColorClick;
        if (customColor2 != null) {
            jceOutputStream.write((JceStruct) customColor2, 10);
        }
        jceOutputStream.write(this.iFontSize, 11);
        String str3 = this.strSchema;
        if (str3 != null) {
            jceOutputStream.write(str3, 12);
        }
        String str4 = this.strImageUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 13);
        }
        jceOutputStream.write(this.iContentStyle, 14);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 15);
        }
    }

    public ConfigRect(int i3, int i16, int i17, int i18, int i19, int i26, int i27, String str, String str2, CustomColor customColor, CustomColor customColor2, int i28, String str3, String str4, int i29, Map<String, String> map) {
        this.iIndexId = i3;
        this.iType = i16;
        this.iXp = i17;
        this.iYp = i18;
        this.iWp = i19;
        this.iHp = i26;
        this.iCanEdit = i27;
        this.strText = str;
        this.strUserText = str2;
        this.stTextColor = customColor;
        this.stTextColorClick = customColor2;
        this.iFontSize = i28;
        this.strSchema = str3;
        this.strImageUrl = str4;
        this.iContentStyle = i29;
        this.mapExtInfo = map;
    }
}
