package com.tencent.mobileqq.qqexpand.bean.flutter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ApiDecodeRequest {
    public String bitmapKey;
    public String faceId;
    public int faceShape;
    public int faceType;
    public String faceUin;
    public String pathKey;

    public ApiDecodeRequest(int i3, String str, int i16) {
        this.faceType = i3;
        this.faceUin = str;
        this.faceShape = i16;
        this.bitmapKey = getBitmapKey(i3, str, i16);
        this.pathKey = getPathKey(this.faceType, this.faceUin);
        this.faceId = str + "_" + i3 + "_" + i16;
    }

    public static String[] getAllFaceShapePathKeys(int i3, String str) {
        return new String[]{getPathKey(i3, str)};
    }

    private static String getBitmapKey(int i3, String str, int i16) {
        return "flutter_face_bmp_" + i3 + "_" + str + "_" + i16;
    }

    private static String getPathKey(int i3, String str) {
        return "flutter_face_path_" + i3 + "_" + str;
    }

    public String toString() {
        return "DecodeRequest{faceType=" + this.faceType + ", faceUin='" + this.faceUin + "', faceShape=" + this.faceShape + '}';
    }
}
