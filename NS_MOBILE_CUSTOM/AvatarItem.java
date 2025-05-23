package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AvatarItem extends JceStruct {
    static int cache_iProperty;
    static int cache_iType;
    static Map<String, String> cache_mapExtInfo;
    static ArrayList<AvatarItemView> cache_vecView;
    public int iHasNewFlag;
    public int iProperty;
    public int iType;
    public Map<String, String> mapExtInfo;
    public String strAvatarName;
    public String strDescription;
    public String strId;
    public String strThumbUrl;
    public String strTraceInfo;
    public ArrayList<AvatarItemView> vecView;

    public AvatarItem() {
        this.strId = "";
        this.strAvatarName = "";
        this.strDescription = "";
        this.strThumbUrl = "";
        this.strTraceInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strId = jceInputStream.readString(0, true);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.iProperty = jceInputStream.read(this.iProperty, 2, false);
        this.strAvatarName = jceInputStream.readString(3, false);
        this.strDescription = jceInputStream.readString(4, false);
        this.strThumbUrl = jceInputStream.readString(5, false);
        if (cache_vecView == null) {
            cache_vecView = new ArrayList<>();
            cache_vecView.add(new AvatarItemView());
        }
        this.vecView = (ArrayList) jceInputStream.read((JceInputStream) cache_vecView, 6, false);
        this.iHasNewFlag = jceInputStream.read(this.iHasNewFlag, 7, false);
        this.strTraceInfo = jceInputStream.readString(10, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtInfo = hashMap;
            hashMap.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strId, 0);
        jceOutputStream.write(this.iType, 1);
        jceOutputStream.write(this.iProperty, 2);
        String str = this.strAvatarName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strDescription;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.strThumbUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        ArrayList<AvatarItemView> arrayList = this.vecView;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        jceOutputStream.write(this.iHasNewFlag, 7);
        String str4 = this.strTraceInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
    }

    public AvatarItem(String str, int i3, int i16, String str2, String str3, String str4, ArrayList<AvatarItemView> arrayList, int i17, String str5, Map<String, String> map) {
        this.strId = str;
        this.iType = i3;
        this.iProperty = i16;
        this.strAvatarName = str2;
        this.strDescription = str3;
        this.strThumbUrl = str4;
        this.vecView = arrayList;
        this.iHasNewFlag = i17;
        this.strTraceInfo = str5;
        this.mapExtInfo = map;
    }
}
