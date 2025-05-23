package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Rect;
import android.util.Base64;
import com.qzone.component.cache.database.table.photo.PhotoQualityInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SilentLivenessHelper {
    static IPatchRedirector $redirector_ = null;
    public static float SHELTER_CHIN_THRESHOLD = 0.95f;
    public static float SHELTER_LEFT_FACE_THRESHOLD = 0.95f;
    public static float SHELTER_MOUTH_THRESHOLD = 0.8f;
    public static float SHELTER_NOSE_THRESHOLD = 0.8f;
    public static float SHELTER_RIGHT_FACE_THRESHOLD = 0.95f;
    private static final String TAG = "SilentLivenessHelper";
    private static int previewHeight;
    private static int previewWidth;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface FacePreviewingAdvise {
        public static final int ADVISE_EYE_CLOSE = 6;
        public static final int ADVISE_INBUFFER_PASS = 9;
        public static final int ADVISE_INCOMPLETE_FACE = 8;
        public static final int ADVISE_INCORRECT_POSTURE = 5;
        public static final int ADVISE_NAN = -1;
        public static final int ADVISE_NOT_IN_RECT = 4;
        public static final int ADVISE_NO_FACE = 1;
        public static final int ADVISE_PASS = 0;
        public static final int ADVISE_TOO_CLOSE = 3;
        public static final int ADVISE_TOO_FAR = 2;
        public static final int ADVISE_TOO_MANY_FACE = 7;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface ShelterJudge {
        public static final int SHELTER_CHIN = 2;
        public static final int SHELTER_LEFTEYE = 7;
        public static final int SHELTER_LEFTFACE = 1;
        public static final int SHELTER_MOUTH = 3;
        public static final int SHELTER_NOSE = 5;
        public static final int SHELTER_PARAM_ERROR = -2;
        public static final int SHELTER_PARAM_NULL = -1;
        public static final int SHELTER_PASS = 0;
        public static final int SHELTER_RIGHTEYE = 6;
        public static final int SHELTER_RIGHTFACE = 4;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SilentImage {
        static IPatchRedirector $redirector_;
        public int height;
        public byte[] image;
        public int wight;

        public SilentImage(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.image = bArr;
            this.wight = i3;
            this.height = i16;
        }
    }

    public SilentLivenessHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static float[] convert130PtsTo90Pts(float[] fArr) {
        float[] fArr2 = new float[180];
        int[] iArr = {0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20};
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < 32) {
            fArr2[i17] = fArr[i18];
            i16++;
            i18++;
            i17++;
        }
        int i19 = 0;
        while (i19 < 32) {
            fArr2[i17] = fArr[i18];
            i19++;
            i18++;
            i17++;
        }
        float[] fArr3 = new float[44];
        int i26 = 0;
        while (i26 < 44) {
            fArr3[i26] = fArr[i18];
            i26++;
            i18++;
        }
        fArr3[16] = (fArr3[16] + fArr3[18]) / 2.0f;
        float f16 = fArr3[19];
        fArr3[19] = (f16 + f16) / 2.0f;
        fArr3[28] = (fArr3[28] + fArr3[26]) / 2.0f;
        fArr3[29] = (fArr3[29] + fArr3[27]) / 2.0f;
        for (int i27 = 0; i27 < 13; i27++) {
            int i28 = i17 + 1;
            int i29 = iArr[i27];
            fArr2[i17] = fArr3[i29 * 2];
            i17 = i28 + 1;
            fArr2[i28] = fArr3[(i29 * 2) + 1];
        }
        int i36 = 0;
        while (i36 < 44) {
            fArr2[i17] = fArr[i18];
            i36++;
            i18++;
            i17++;
        }
        int i37 = 0;
        while (i37 < 82) {
            if ((i37 / 2) % 2 != 1) {
                fArr2[i17] = fArr[i18];
                i17++;
            }
            i37++;
            i18++;
        }
        int i38 = 0;
        while (i38 < 14) {
            i38++;
            i18++;
        }
        while (i3 < 4) {
            fArr2[i17] = fArr[i18];
            i3++;
            i18++;
            i17++;
        }
        return fArr2;
    }

    public static YTFaceTracker.TrackedFace[] convert130To90(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        for (int i3 = 0; i3 < trackedFaceArr.length; i3++) {
            YTFaceTracker.TrackedFace trackedFace = trackedFaceArr[i3];
            trackedFace.faceShape = convert130PtsTo90Pts(trackedFace.faceShape);
            YTFaceTracker.TrackedFace trackedFace2 = trackedFaceArr[i3];
            trackedFace2.faceVisible = convert130VisTo90Vis(trackedFace2.faceVisible);
        }
        return trackedFaceArr;
    }

    private static float[] convert130VisTo90Vis(float[] fArr) {
        float[] fArr2 = new float[90];
        int[] iArr = {0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20};
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < 16) {
            fArr2[i17] = fArr[i18];
            i16++;
            i18++;
            i17++;
        }
        int i19 = 0;
        while (i19 < 16) {
            fArr2[i17] = fArr[i18];
            i19++;
            i18++;
            i17++;
        }
        float[] fArr3 = new float[22];
        int i26 = 0;
        while (i26 < 22) {
            fArr3[i26] = fArr[i18];
            i26++;
            i18++;
        }
        fArr3[8] = (fArr3[8] + fArr3[9]) / 2.0f;
        fArr3[14] = (fArr3[14] + fArr3[13]) / 2.0f;
        int i27 = 0;
        while (i27 < 13) {
            fArr2[i17] = fArr3[iArr[i27]];
            i27++;
            i17++;
        }
        int i28 = 0;
        while (i28 < 22) {
            fArr2[i17] = fArr[i18];
            i28++;
            i18++;
            i17++;
        }
        int i29 = 0;
        while (i29 < 41) {
            if (i29 % 2 != 1) {
                fArr2[i17] = fArr[i18];
                i17++;
            }
            i29++;
            i18++;
        }
        int i36 = 0;
        while (i36 < 7) {
            i36++;
            i18++;
        }
        while (i3 < 2) {
            fArr2[i17] = fArr[i18];
            i3++;
            i18++;
            i17++;
        }
        return fArr2;
    }

    public static String convertAdvise(int i3) {
        if (i3 != 4) {
            if (i3 == 2) {
                return StringCode.FL_POSE_CLOSER;
            }
            if (i3 == 3) {
                return StringCode.FL_POSE_FARER;
            }
            if (i3 == 5) {
                return StringCode.FL_POSE_INCORRECT;
            }
            if (i3 == 1) {
                return StringCode.FL_NO_FACE;
            }
            if (i3 == 6) {
                return StringCode.FL_POSE_OPEN_EYE;
            }
            if (i3 != 8) {
                if (i3 == 7) {
                    return StringCode.FL_TOO_MANY_FACES;
                }
                return StringCode.FL_POSE_KEEP;
            }
        }
        return StringCode.FL_INCOMPLETE_FACE;
    }

    public static String convertBlock(int i3) {
        if (i3 == 1) {
            return StringCode.FL_NO_LEFT_FACE;
        }
        if (i3 == 2) {
            return StringCode.FL_NO_CHIN;
        }
        if (i3 == 3) {
            return StringCode.FL_NO_MOUTH;
        }
        if (i3 == 4) {
            return StringCode.FL_NO_RIGHT_FACE;
        }
        if (i3 == 5) {
            return StringCode.FL_NO_NOSE;
        }
        if (i3 == 6) {
            return StringCode.FL_NO_RIGHT_EYE;
        }
        if (i3 == 7) {
            return StringCode.FL_NO_LEFT_EYE;
        }
        return "";
    }

    public static boolean faceAngleForceCheck(YTFaceTracker.TrackedFace trackedFace, float f16, float f17, float f18) {
        boolean z16;
        float abs = Math.abs(trackedFace.yaw);
        float abs2 = Math.abs(trackedFace.pitch);
        float abs3 = Math.abs(trackedFace.roll);
        if (abs <= f16 && abs2 <= f17 && abs3 <= f18) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("face_angle_force_check_result", false);
                jSONObject2.put("angle_yaw", abs);
                jSONObject2.put("angle_pitch", abs2);
                jSONObject2.put("angle_roll", abs3);
                jSONObject2.put("angle_yaw_thr", f16);
                jSONObject2.put("angle_pitch_thr", f17);
                jSONObject2.put("angle_roll_thr", f18);
                jSONObject.put("TraceType", "FaceAngleForceCheck");
                jSONObject.put("TraceData", jSONObject2);
            } catch (JSONException e16) {
                YtLogger.e(TAG, "make log json error", e16);
            }
            YtLogger.o(TAG, jSONObject);
        }
        return z16;
    }

    private static JSONArray floatsToJSONArray(float[] fArr, boolean z16) {
        JSONArray jSONArray = new JSONArray();
        for (float f16 : fArr) {
            if (z16) {
                f16 *= 100.0f;
            }
            jSONArray.put(Math.round(f16));
        }
        return jSONArray;
    }

    public static Rect getFaceRect(YTFaceTracker.TrackedFace trackedFace) {
        float[] fArr = trackedFace.faceShape;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = f16;
        float f19 = f18;
        int i3 = 0;
        float f26 = f17;
        while (i3 < 180) {
            f18 = Math.min(f18, trackedFace.faceShape[i3]);
            f19 = Math.max(f19, trackedFace.faceShape[i3]);
            int i16 = i3 + 1;
            f26 = Math.min(f26, trackedFace.faceShape[i16]);
            f17 = Math.max(f17, trackedFace.faceShape[i16]);
            i3 = i16 + 1;
        }
        float f27 = previewWidth - 1;
        float f28 = f27 - f18;
        float f29 = (float) ((f27 - f19) - (((f28 - r4) * 0.1d) / 2.0d));
        float f36 = (float) (f28 + (((f28 - f29) * 0.1d) / 2.0d));
        float f37 = (float) (f26 - (((f17 - f26) * 0.1d) / 2.0d));
        float f38 = (float) (f17 + (((f17 - f37) * 0.1d) / 2.0d));
        if (f29 < 0.0f) {
            f29 = 0.0f;
        }
        if (f36 < 0.0f) {
            f36 = 0.0f;
        }
        if (f29 > f27) {
            f29 = f27;
        }
        if (f36 <= f27) {
            f27 = f36;
        }
        if (f37 < 0.0f) {
            f37 = 0.0f;
        }
        if (f38 < 0.0f) {
            f38 = 0.0f;
        }
        float f39 = previewHeight - 1;
        if (f37 > f39) {
            f37 = f39;
        }
        if (f38 > f39) {
            f38 = f39;
        }
        Rect rect = new Rect();
        rect.left = (int) f29;
        rect.top = (int) f37;
        rect.right = (int) f27;
        rect.bottom = (int) f38;
        return rect;
    }

    public static Rect getIntersectionRect(Rect rect, Rect rect2) {
        return new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] gzipCompress(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (IOException e16) {
            e = e16;
            gZIPOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (gZIPOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                } catch (IOException e17) {
                    YtLogger.e(TAG, " gzip.close(): ", e17);
                }
                return byteArray;
            } catch (Throwable th6) {
                th = th6;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e18) {
                        YtLogger.e(TAG, " gzip.close(): ", e18);
                    }
                }
                throw th;
            }
        } catch (IOException e19) {
            e = e19;
            YtLogger.e(TAG, "compress Exception e: ", e);
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException e26) {
                    YtLogger.e(TAG, " gzip.close(): ", e26);
                }
            }
            return null;
        }
    }

    public static String makeFaceQualityLogJson(String str, String str2, float f16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("quality_type", str);
            jSONObject.put(PhotoQualityInfo.QUALITY_SCORE, str2);
            jSONObject.put("quality_thr", f16);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "make log json error", e16);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("TraceType", "FaceQuality");
            jSONObject2.put("TraceData", jSONObject);
        } catch (JSONException e17) {
            YtLogger.e(TAG, "make log info error", e17);
        }
        return jSONObject2.toString();
    }

    public static void optimizationFace(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        int i3 = Integer.MIN_VALUE;
        int i16 = 0;
        for (int i17 = 0; i17 < trackedFaceArr.length; i17++) {
            Rect faceRect = getFaceRect(trackedFaceArr[i17]);
            int width = faceRect.width() * faceRect.height();
            if (width >= i3) {
                i16 = i17;
                i3 = width;
            }
        }
        if (i16 != 0) {
            YtLogger.i(TAG, "Found max face id:" + i16);
            trackedFaceArr[0] = trackedFaceArr[i16];
        }
    }

    private static JSONArray rectToJSONArray(Rect rect) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(rect.left);
        jSONArray.put(rect.top);
        jSONArray.put(rect.right);
        jSONArray.put(rect.bottom);
        return jSONArray;
    }

    public static void setPreviewWh(int i3, int i16) {
        previewWidth = i3;
        previewHeight = i16;
    }

    public static int shelterJudge(float[] fArr) {
        if (fArr == null) {
            YtLogger.e(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis is null.", null);
            return -1;
        }
        if (fArr.length != 90) {
            YtLogger.e(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: " + fArr.length, null);
            return -2;
        }
        int i3 = 0;
        for (int i16 = 33; i16 <= 45; i16++) {
            if (fArr[i16 - 1] < SHELTER_NOSE_THRESHOLD) {
                i3++;
            }
        }
        if (i3 >= 4) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            for (int i17 = 33; i17 <= 45; i17++) {
                int i18 = i17 - 1;
                if (fArr[i18] < SHELTER_NOSE_THRESHOLD) {
                    stringBuffer.append(i18);
                    stringBuffer.append("-");
                    stringBuffer.append(fArr[i18]);
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append("]");
            YtLogger.o(TAG, makeFaceQualityLogJson("SHELTER_NOSE", stringBuffer.toString(), SHELTER_NOSE_THRESHOLD).toString());
            return 5;
        }
        int i19 = 0;
        for (int i26 = 46; i26 <= 67; i26++) {
            if (fArr[i26 - 1] < SHELTER_MOUTH_THRESHOLD) {
                i19++;
            }
        }
        if (i19 >= 4) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("[");
            for (int i27 = 46; i27 <= 67; i27++) {
                int i28 = i27 - 1;
                if (fArr[i28] < SHELTER_MOUTH_THRESHOLD) {
                    stringBuffer2.append(i28);
                    stringBuffer2.append("-");
                    stringBuffer2.append(fArr[i28]);
                    stringBuffer2.append(",");
                }
            }
            stringBuffer2.append("]");
            YtLogger.o(TAG, makeFaceQualityLogJson("SHELTER_MOUTH", stringBuffer2.toString(), SHELTER_MOUTH_THRESHOLD).toString());
            return 3;
        }
        int i29 = 0;
        for (int i36 = 9; i36 <= 16; i36++) {
            if (fArr[i36 - 1] < 0.9f) {
                i29++;
            }
        }
        for (int i37 = 25; i37 <= 32; i37++) {
            if (fArr[i37 - 1] < 0.9f) {
                i29++;
            }
        }
        if (fArr[89] < 0.7f) {
            i29++;
        }
        if (i29 >= 4) {
            return 6;
        }
        int i38 = 0;
        for (int i39 = 1; i39 <= 8; i39++) {
            if (fArr[i39 - 1] < 0.9f) {
                i38++;
            }
        }
        for (int i46 = 17; i46 <= 24; i46++) {
            if (fArr[i46 - 1] < 0.9f) {
                i38++;
            }
        }
        if (fArr[88] < 0.9f) {
            i38++;
        }
        if (i38 >= 4) {
            return 7;
        }
        int i47 = 0;
        for (int i48 = 68; i48 < 74; i48++) {
            if (fArr[i48 - 1] < SHELTER_LEFT_FACE_THRESHOLD) {
                i47++;
            }
        }
        if (i47 >= 3) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            for (int i49 = 68; i49 < 74; i49++) {
                int i56 = i49 - 1;
                if (fArr[i56] < SHELTER_LEFT_FACE_THRESHOLD) {
                    stringBuffer3.append(i56);
                    stringBuffer3.append("-");
                    stringBuffer3.append(fArr[i56]);
                    stringBuffer3.append(",");
                }
            }
            stringBuffer3.append("]");
            YtLogger.o(TAG, makeFaceQualityLogJson("SHELTER_LEFT_FACE", stringBuffer3.toString(), SHELTER_LEFT_FACE_THRESHOLD).toString());
            return 1;
        }
        int i57 = 0;
        for (int i58 = 82; i58 <= 88; i58++) {
            if (fArr[i58 - 1] < SHELTER_RIGHT_FACE_THRESHOLD) {
                i57++;
            }
        }
        if (i57 >= 3) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("[");
            for (int i59 = 82; i59 <= 88; i59++) {
                int i65 = i59 - 1;
                if (fArr[i65] < SHELTER_RIGHT_FACE_THRESHOLD) {
                    stringBuffer4.append(i65);
                    stringBuffer4.append("-");
                    stringBuffer4.append(fArr[i65]);
                    stringBuffer4.append(",");
                }
            }
            stringBuffer4.append("]");
            YtLogger.o(TAG, makeFaceQualityLogJson("SHELTER_RIGHT_FACE", stringBuffer4.toString(), SHELTER_RIGHT_FACE_THRESHOLD).toString());
            return 4;
        }
        int i66 = 0;
        for (int i67 = 75; i67 <= 81; i67++) {
            if (fArr[i67 - 1] < SHELTER_CHIN_THRESHOLD) {
                i66++;
            }
        }
        if (i66 < 3) {
            return 0;
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("[");
        for (int i68 = 75; i68 <= 81; i68++) {
            int i69 = i68 - 1;
            if (fArr[i69] < SHELTER_CHIN_THRESHOLD) {
                stringBuffer5.append(i69);
                stringBuffer5.append("-");
                stringBuffer5.append(fArr[i69]);
                stringBuffer5.append(";");
            }
        }
        stringBuffer5.append("]");
        YtLogger.o(TAG, makeFaceQualityLogJson("SHELTER_CHIN", stringBuffer5.toString(), SHELTER_CHIN_THRESHOLD).toString());
        return 2;
    }

    public static String trackedFacesToJson(YTFaceTracker.TrackedFace[] trackedFaceArr, int i3, int i16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TraceType", "FaceTracker");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("detect_rect", rectToJSONArray(YtSDKKitFramework.getInstance().getDetectRect()));
            jSONObject2.put("pose_state", i16);
            jSONObject2.put("shelter_state", i3);
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put("faces", jSONArray);
            if (trackedFaceArr != null) {
                for (YTFaceTracker.TrackedFace trackedFace : trackedFaceArr) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONArray.mo162put(jSONObject3);
                    jSONObject3.put("frameId", trackedFace.frameId);
                    jSONObject3.put("traceId", trackedFace.traceId);
                    jSONObject3.put(CanvasView.ACTION_RECT, rectToJSONArray(trackedFace.faceRect));
                    jSONObject3.put("points", floatsToJSONArray(trackedFace.faceShape, false));
                    jSONObject3.put(NodeProps.VISIBLE, floatsToJSONArray(trackedFace.faceVisible, true));
                    jSONObject3.put("angle_r", trackedFace.roll);
                    jSONObject3.put("angle_p", trackedFace.pitch);
                    jSONObject3.put("angle_y", trackedFace.yaw);
                }
            }
            jSONObject.put("TraceData", jSONObject2);
            YtLogger.d(TAG, "TraceJson: " + jSONObject);
            jSONObject.put("TraceData", Base64.encodeToString(gzipCompress(jSONObject2.toString()), 2));
        } catch (JSONException e16) {
            YtLogger.e(TAG, "make log info error", e16);
        }
        return jSONObject.toString();
    }
}
