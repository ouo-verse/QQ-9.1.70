package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ZPlanPtaResult extends JceStruct {
    static Map<String, Double> cache_FaceControlData = new HashMap();
    static QQPtaColor cache_FaceLipsColor;
    static QQPtaColor cache_FaceSkinColor;
    static ZplanFaceStyle[] cache_FaceStyles;
    static QQPtaColor cache_HairColor;
    static Map<Integer, MaterialInfo> cache_MaterialInfos;
    public String EyebrowId;
    public String EyeglassesId;
    public String EyelidId;
    public Map<String, Double> FaceControlData;
    public QQPtaColor FaceLipsColor;
    public QQPtaColor FaceSkinColor;
    public ZplanFaceStyle[] FaceStyles;
    public QQPtaColor HairColor;
    public String HairId;
    public String JsonString;
    public Map<Integer, MaterialInfo> MaterialInfos;

    static {
        cache_FaceControlData.put("", Double.valueOf(0.0d));
        cache_FaceSkinColor = new QQPtaColor();
        cache_FaceLipsColor = new QQPtaColor();
        cache_HairColor = new QQPtaColor();
        cache_FaceStyles = new ZplanFaceStyle[1];
        cache_FaceStyles[0] = new ZplanFaceStyle();
        cache_MaterialInfos = new HashMap();
        cache_MaterialInfos.put(0, new MaterialInfo());
    }

    public ZPlanPtaResult() {
        this.FaceControlData = null;
        this.FaceSkinColor = null;
        this.FaceLipsColor = null;
        this.HairColor = null;
        this.EyebrowId = "";
        this.HairId = "";
        this.EyeglassesId = "";
        this.EyelidId = "";
        this.JsonString = "";
        this.FaceStyles = null;
        this.MaterialInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.FaceControlData = (Map) jceInputStream.read((JceInputStream) cache_FaceControlData, 0, false);
        this.FaceSkinColor = (QQPtaColor) jceInputStream.read((JceStruct) cache_FaceSkinColor, 1, false);
        this.FaceLipsColor = (QQPtaColor) jceInputStream.read((JceStruct) cache_FaceLipsColor, 2, false);
        this.HairColor = (QQPtaColor) jceInputStream.read((JceStruct) cache_HairColor, 3, false);
        this.EyebrowId = jceInputStream.readString(4, false);
        this.HairId = jceInputStream.readString(5, false);
        this.EyeglassesId = jceInputStream.readString(6, false);
        this.EyelidId = jceInputStream.readString(7, false);
        this.JsonString = jceInputStream.readString(8, false);
        this.FaceStyles = (ZplanFaceStyle[]) jceInputStream.read((JceStruct[]) cache_FaceStyles, 9, false);
        this.MaterialInfos = (Map) jceInputStream.read((JceInputStream) cache_MaterialInfos, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, Double> map = this.FaceControlData;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        QQPtaColor qQPtaColor = this.FaceSkinColor;
        if (qQPtaColor != null) {
            jceOutputStream.write((JceStruct) qQPtaColor, 1);
        }
        QQPtaColor qQPtaColor2 = this.FaceLipsColor;
        if (qQPtaColor2 != null) {
            jceOutputStream.write((JceStruct) qQPtaColor2, 2);
        }
        QQPtaColor qQPtaColor3 = this.HairColor;
        if (qQPtaColor3 != null) {
            jceOutputStream.write((JceStruct) qQPtaColor3, 3);
        }
        String str = this.EyebrowId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.HairId;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.EyeglassesId;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.EyelidId;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.JsonString;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        ZplanFaceStyle[] zplanFaceStyleArr = this.FaceStyles;
        if (zplanFaceStyleArr != null) {
            jceOutputStream.write((Object[]) zplanFaceStyleArr, 9);
        }
        Map<Integer, MaterialInfo> map2 = this.MaterialInfos;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 10);
        }
    }

    public ZPlanPtaResult(Map<String, Double> map, QQPtaColor qQPtaColor, QQPtaColor qQPtaColor2, QQPtaColor qQPtaColor3, String str, String str2, String str3, String str4, String str5, ZplanFaceStyle[] zplanFaceStyleArr, Map<Integer, MaterialInfo> map2) {
        this.FaceControlData = map;
        this.FaceSkinColor = qQPtaColor;
        this.FaceLipsColor = qQPtaColor2;
        this.HairColor = qQPtaColor3;
        this.EyebrowId = str;
        this.HairId = str2;
        this.EyeglassesId = str3;
        this.EyelidId = str4;
        this.JsonString = str5;
        this.FaceStyles = zplanFaceStyleArr;
        this.MaterialInfos = map2;
    }
}
