package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QuanInfo extends JceStruct {
    static FaceRect cache_faceRect = new FaceRect();
    static FacePoint cache_leftEye;
    static Map<String, String> cache_property;
    static FaceRect cache_regionRect;
    static Map<String, String> cache_reserve;
    static FacePoint cache_rightEye;
    public int Quanstate;
    public int confidence;
    public FaceRect faceRect;
    public long iSource;
    public long identity;
    public FacePoint leftEye;
    public int photoHeight;
    public int photoWidth;
    public Map<String, String> property;
    public FaceRect regionRect;
    public Map<String, String> reserve;
    public FacePoint rightEye;

    static {
        HashMap hashMap = new HashMap();
        cache_property = hashMap;
        hashMap.put("", "");
        cache_leftEye = new FacePoint();
        cache_rightEye = new FacePoint();
        cache_regionRect = new FaceRect();
        HashMap hashMap2 = new HashMap();
        cache_reserve = hashMap2;
        hashMap2.put("", "");
    }

    public QuanInfo() {
        this.faceRect = null;
        this.confidence = 0;
        this.property = null;
        this.leftEye = null;
        this.rightEye = null;
        this.regionRect = null;
        this.identity = 0L;
        this.photoWidth = 0;
        this.photoHeight = 0;
        this.reserve = null;
        this.iSource = 0L;
        this.Quanstate = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.faceRect = (FaceRect) jceInputStream.read((JceStruct) cache_faceRect, 0, true);
        this.confidence = jceInputStream.read(this.confidence, 1, true);
        this.property = (Map) jceInputStream.read((JceInputStream) cache_property, 2, true);
        this.leftEye = (FacePoint) jceInputStream.read((JceStruct) cache_leftEye, 3, true);
        this.rightEye = (FacePoint) jceInputStream.read((JceStruct) cache_rightEye, 4, true);
        this.regionRect = (FaceRect) jceInputStream.read((JceStruct) cache_regionRect, 5, true);
        this.identity = jceInputStream.read(this.identity, 6, true);
        this.photoWidth = jceInputStream.read(this.photoWidth, 7, true);
        this.photoHeight = jceInputStream.read(this.photoHeight, 8, true);
        this.reserve = (Map) jceInputStream.read((JceInputStream) cache_reserve, 9, true);
        this.iSource = jceInputStream.read(this.iSource, 10, true);
        this.Quanstate = jceInputStream.read(this.Quanstate, 11, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.faceRect, 0);
        jceOutputStream.write(this.confidence, 1);
        jceOutputStream.write((Map) this.property, 2);
        jceOutputStream.write((JceStruct) this.leftEye, 3);
        jceOutputStream.write((JceStruct) this.rightEye, 4);
        jceOutputStream.write((JceStruct) this.regionRect, 5);
        jceOutputStream.write(this.identity, 6);
        jceOutputStream.write(this.photoWidth, 7);
        jceOutputStream.write(this.photoHeight, 8);
        jceOutputStream.write((Map) this.reserve, 9);
        jceOutputStream.write(this.iSource, 10);
        jceOutputStream.write(this.Quanstate, 11);
    }

    public QuanInfo(FaceRect faceRect, int i3, Map<String, String> map, FacePoint facePoint, FacePoint facePoint2, FaceRect faceRect2, long j3, int i16, int i17, Map<String, String> map2, long j16, int i18) {
        this.faceRect = faceRect;
        this.confidence = i3;
        this.property = map;
        this.leftEye = facePoint;
        this.rightEye = facePoint2;
        this.regionRect = faceRect2;
        this.identity = j3;
        this.photoWidth = i16;
        this.photoHeight = i17;
        this.reserve = map2;
        this.iSource = j16;
        this.Quanstate = i18;
    }
}
