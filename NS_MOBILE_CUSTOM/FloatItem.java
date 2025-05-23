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
public final class FloatItem extends JceStruct {
    static int cache_iProperty;
    static int cache_iType;
    static Map<String, String> cache_mapExtInfo;
    static ArrayList<FloatItemView> cache_vecView = new ArrayList<>();
    public int iAngleSpeed;
    public int iCount;
    public int iDirection;
    public int iHasNewFlag;
    public int iMaxAngle;
    public int iMaxSize;
    public int iMinSize;
    public int iProperty;
    public int iRotationX;
    public int iRotationY;
    public int iSpeed;
    public int iType;
    public Map<String, String> mapExtInfo;
    public String strDescription;
    public String strDesignerInfo;
    public String strFloatName;
    public String strId;
    public String strThumbUrl;
    public String strTraceInfo;
    public ArrayList<FloatItemView> vecView;

    static {
        cache_vecView.add(new FloatItemView());
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public FloatItem() {
        this.strId = "";
        this.strFloatName = "";
        this.strDescription = "";
        this.strThumbUrl = "";
        this.strTraceInfo = "";
        this.strDesignerInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strId = jceInputStream.readString(0, true);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.iProperty = jceInputStream.read(this.iProperty, 2, false);
        this.strFloatName = jceInputStream.readString(3, false);
        this.iSpeed = jceInputStream.read(this.iSpeed, 4, false);
        this.iMaxAngle = jceInputStream.read(this.iMaxAngle, 5, false);
        this.iCount = jceInputStream.read(this.iCount, 6, false);
        this.iAngleSpeed = jceInputStream.read(this.iAngleSpeed, 7, false);
        this.iRotationX = jceInputStream.read(this.iRotationX, 8, false);
        this.iRotationY = jceInputStream.read(this.iRotationY, 9, false);
        this.iMaxSize = jceInputStream.read(this.iMaxSize, 10, false);
        this.iMinSize = jceInputStream.read(this.iMinSize, 11, false);
        this.iDirection = jceInputStream.read(this.iDirection, 12, false);
        this.strDescription = jceInputStream.readString(13, false);
        this.strThumbUrl = jceInputStream.readString(14, false);
        this.vecView = (ArrayList) jceInputStream.read((JceInputStream) cache_vecView, 15, false);
        this.strTraceInfo = jceInputStream.readString(16, false);
        this.iHasNewFlag = jceInputStream.read(this.iHasNewFlag, 17, false);
        this.strDesignerInfo = jceInputStream.readString(18, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strId, 0);
        jceOutputStream.write(this.iType, 1);
        jceOutputStream.write(this.iProperty, 2);
        String str = this.strFloatName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.iSpeed, 4);
        jceOutputStream.write(this.iMaxAngle, 5);
        jceOutputStream.write(this.iCount, 6);
        jceOutputStream.write(this.iAngleSpeed, 7);
        jceOutputStream.write(this.iRotationX, 8);
        jceOutputStream.write(this.iRotationY, 9);
        jceOutputStream.write(this.iMaxSize, 10);
        jceOutputStream.write(this.iMinSize, 11);
        jceOutputStream.write(this.iDirection, 12);
        String str2 = this.strDescription;
        if (str2 != null) {
            jceOutputStream.write(str2, 13);
        }
        String str3 = this.strThumbUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 14);
        }
        ArrayList<FloatItemView> arrayList = this.vecView;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 15);
        }
        String str4 = this.strTraceInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 16);
        }
        jceOutputStream.write(this.iHasNewFlag, 17);
        String str5 = this.strDesignerInfo;
        if (str5 != null) {
            jceOutputStream.write(str5, 18);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 19);
        }
    }

    public FloatItem(String str, int i3, int i16, String str2, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, String str3, String str4, ArrayList<FloatItemView> arrayList, String str5, int i38, String str6, Map<String, String> map) {
        this.strId = str;
        this.iType = i3;
        this.iProperty = i16;
        this.strFloatName = str2;
        this.iSpeed = i17;
        this.iMaxAngle = i18;
        this.iCount = i19;
        this.iAngleSpeed = i26;
        this.iRotationX = i27;
        this.iRotationY = i28;
        this.iMaxSize = i29;
        this.iMinSize = i36;
        this.iDirection = i37;
        this.strDescription = str3;
        this.strThumbUrl = str4;
        this.vecView = arrayList;
        this.strTraceInfo = str5;
        this.iHasNewFlag = i38;
        this.strDesignerInfo = str6;
        this.mapExtInfo = map;
    }
}
