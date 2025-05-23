package com.tencent.av.avgesture;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import com.tencent.av.avgesture.AVCosUpload;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVGestureWrapper {
    public static final String AppVersion = "7.2.0";
    public static final String UPLOAD_REPORT_DETAILED = "0X80083AD";
    public static final String UPLOAD_REPORT_OK = "0X800839C";
    public static final String UPLOAD_REPORT_START = "0X800839B";
    private static final AVCosUpload cos = AVCosUpload.createInstance();
    static String mFilePath = null;
    public static AVUploadReport mReport = null;
    public static final int sImgFmtBGRA = 1;
    public static final int sImgFmtI420 = 3;
    public static final int sImgFmtNV21 = 2;
    public static final int sImgFmtRGBA = 0;
    private long mGestureRecognizor;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AVUploadReport {
        void avGestureUploadReport(String str, String str2);
    }

    public AVGestureWrapper() {
        this(null);
    }

    public static native void clearCache();

    private static native long createRecognizor(byte[] bArr, int i3, int i16, int i17, int i18);

    private static native void destroyRecognizor(long j3);

    private static native boolean doCalc(long j3);

    private static native boolean doCalc(long j3, boolean z16);

    public static native int getFcnInputHeight();

    public static native int getFcnInputWidth();

    private static native String getGestureType(long j3);

    private static native float[] getHotRegion(long j3);

    private static native float[] getHotRegionInOriginImg(long j3);

    public static native byte[] getInputRGBA(long j3);

    private static native float[] getKeyPoints(long j3);

    private static native float[] getKeyPointsByName(long j3, String str);

    public static native String getMultiSign(String str, String str2, String str3, String str4);

    public static native String getParamTips();

    public static native String getVersionInfo();

    private static String readFile(String str) {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str2 = str2 + readLine;
                        } catch (IOException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str2;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                    bufferedReader2.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        return str2;
    }

    public static void setAVGestureReport(AVUploadReport aVUploadReport) {
        mReport = aVUploadReport;
    }

    private static native void setCnnThresHold(float f16);

    private static native void setDeviceInfo(String str, String str2, int i3);

    private static native void setDilateKernelSize(int i3);

    private static native void setDilateKernelSizeAfterCrop(int i3);

    private static native void setErodeKernelSize(int i3);

    private static native void setFcnMinSize(int i3);

    private static native void setFcnThresHold(int i3, float f16);

    public static native boolean setFilePath(String str, String str2, String str3);

    public static boolean setGlobalConfigFile(String str) {
        mFilePath = str;
        try {
            JSONObject jSONObject = new JSONObject(readFile(str + "/global.config"));
            if (jSONObject.has("cnnThresHold")) {
                setCnnThresHold((float) jSONObject.getDouble("cnnThresHold"));
            }
            if (jSONObject.has("fcnThresHold")) {
                JSONArray jSONArray = jSONObject.getJSONArray("fcnThresHold");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    setFcnThresHold(i3, (float) jSONArray.getDouble(i3));
                }
            }
            if (jSONObject.has("dilate")) {
                setDilateKernelSize(jSONObject.getInt("dilate"));
            }
            if (jSONObject.has("erode")) {
                setErodeKernelSize(jSONObject.getInt("erode"));
            }
            if (jSONObject.has("fcnMinSize")) {
                setFcnMinSize(jSONObject.getInt("fcnMinSize"));
            }
            if (jSONObject.has("dilateAfterCrop")) {
                setDilateKernelSizeAfterCrop(jSONObject.getInt("dilateAfterCrop"));
            }
            if (jSONObject.has("hotPointRate")) {
                setHotPointRate((float) jSONObject.getDouble("hotPointRate"));
            }
            if (jSONObject.has("skinColorRate")) {
                setSkinColorRate((float) jSONObject.getDouble("skinColorRate"));
                return true;
            }
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static native void setHotPointRate(float f16);

    public static void setShouldUpload(boolean z16) {
        cos.ShouldUpload = z16;
    }

    private static native void setSkinColorRate(float f16);

    public void destroyRecognizor() {
        long j3 = this.mGestureRecognizor;
        if (j3 != 0) {
            destroyRecognizor(j3);
            this.mGestureRecognizor = 0L;
        }
    }

    public boolean doCalc(byte[] bArr, int i3, int i16, int i17, int i18) {
        return doCalc(bArr, i3, i16, i17, i18, true);
    }

    public String getGestureType() {
        return getGestureType(this.mGestureRecognizor);
    }

    public RectF getHotRegion() {
        float[] hotRegion = getHotRegion(this.mGestureRecognizor);
        return new RectF(hotRegion[0], hotRegion[1], hotRegion[2], hotRegion[3]);
    }

    public RectF getHotRegionInOriginImg() {
        float[] hotRegionInOriginImg = getHotRegionInOriginImg(this.mGestureRecognizor);
        float f16 = hotRegionInOriginImg[0];
        float f17 = hotRegionInOriginImg[1];
        return new RectF(f16, f17, hotRegionInOriginImg[2] + f16, hotRegionInOriginImg[3] + f17);
    }

    public PointF getKeyPointByName(String str) {
        float[] keyPointsByName = getKeyPointsByName(this.mGestureRecognizor, str);
        PointF pointF = new PointF();
        pointF.x = keyPointsByName[1];
        pointF.y = keyPointsByName[0];
        return pointF;
    }

    public PointF[] getKeyPoints() {
        float[] keyPoints = getKeyPoints(this.mGestureRecognizor);
        PointF[] pointFArr = new PointF[keyPoints.length / 2];
        for (int i3 = 0; i3 < keyPoints.length; i3 += 2) {
            pointFArr[i3] = new PointF(keyPoints[i3 + 1], keyPoints[i3]);
        }
        return pointFArr;
    }

    public AVGestureWrapper(Context context) {
        this.mGestureRecognizor = 0L;
        int i3 = context != null ? ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion : 0;
        setDeviceInfo("" + Build.VERSION.SDK_INT, Build.MANUFACTURER + ":" + DeviceInfoMonitor.getModel(), i3);
    }

    public boolean doCalc(byte[] bArr, int i3, int i16, int i17, int i18, boolean z16) {
        destroyRecognizor();
        long createRecognizor = createRecognizor(bArr, i3, i16, i17, i18);
        this.mGestureRecognizor = createRecognizor;
        boolean doCalc = doCalc(createRecognizor, z16);
        if (doCalc && cos.ShouldUpload) {
            AVCosUpload.createInstance().uploadFile(mFilePath, getGestureType(this.mGestureRecognizor), getInputRGBA(this.mGestureRecognizor), getFcnInputWidth(), getFcnInputHeight(), new AVCosUpload.UploadFileListener() { // from class: com.tencent.av.avgesture.AVGestureWrapper.1
                @Override // com.tencent.av.avgesture.AVCosUpload.UploadFileListener
                public void onCompleted(int i19, String str, String str2) {
                    AVUploadReport aVUploadReport = AVGestureWrapper.mReport;
                    if (aVUploadReport != null) {
                        aVUploadReport.avGestureUploadReport(AVGestureWrapper.UPLOAD_REPORT_DETAILED, String.valueOf(i19));
                        if (i19 == 0) {
                            AVGestureWrapper.mReport.avGestureUploadReport(AVGestureWrapper.UPLOAD_REPORT_OK, "0");
                        }
                    }
                }
            });
        }
        return doCalc;
    }
}
