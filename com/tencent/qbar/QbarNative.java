package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader;
import com.tencent.mobileqq.qrscan.u;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QbarNative {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_BYTES = 1024;
    public static final int MAX_CODE_NUM = 3;
    private static final String TAG = "QbarNative";
    static boolean hasCppSharedSoLoad;
    static boolean hasSoLoad;
    public static boolean hasSoLoadByPath;
    private int mHeight;
    private int mWidth;
    private int qbarId;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarCodeDetectInfo {
        static IPatchRedirector $redirector_;
        public float prob;
        public int readerId;

        public QBarCodeDetectInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarPoint {
        static IPatchRedirector $redirector_;
        public int point_cnt;

        /* renamed from: x0, reason: collision with root package name */
        public float f342416x0;

        /* renamed from: x1, reason: collision with root package name */
        public float f342417x1;

        /* renamed from: x2, reason: collision with root package name */
        public float f342418x2;

        /* renamed from: x3, reason: collision with root package name */
        public float f342419x3;

        /* renamed from: y0, reason: collision with root package name */
        public float f342420y0;

        /* renamed from: y1, reason: collision with root package name */
        public float f342421y1;

        /* renamed from: y2, reason: collision with root package name */
        public float f342422y2;

        /* renamed from: y3, reason: collision with root package name */
        public float f342423y3;

        public QBarPoint() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarReportMsg {
        static IPatchRedirector $redirector_;
        public int qrcodeVersion;

        public QBarReportMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarResultJNI {
        static IPatchRedirector $redirector_;
        public String charset;
        public byte[] data;
        public QBarPoint points;
        public int typeID;
        public String typeName;

        public QBarResultJNI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarZoomInfo {
        static IPatchRedirector $redirector_;
        public boolean isZoom;
        public float zoomFactor;

        public QBarZoomInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QbarAiModelParam {
        static IPatchRedirector $redirector_;
        public String detect_model_bin_path_;
        public String detect_model_param_path_;
        public String superresolution_model_bin_path_;
        public String superresolution_model_param_path_;

        public QbarAiModelParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        hasSoLoad = false;
        hasCppSharedSoLoad = false;
        hasSoLoadByPath = false;
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            try {
                hasCppSharedSoLoad = SoLoadUtilNew.loadSoByName(context, "c++_shared");
            } catch (Throwable th5) {
                hasCppSharedSoLoad = false;
                QLog.w(TAG, 1, "loadSoByName, load libc++_shared.so failed:", th5);
            }
        }
        if (!hasCppSharedSoLoad) {
            QLog.e(TAG, 1, "Init load c++_shared fail, try system load.");
            try {
                System.loadLibrary("c++_shared");
                hasCppSharedSoLoad = true;
            } catch (Throwable th6) {
                hasCppSharedSoLoad = false;
                QLog.e(TAG, 1, "Init system load c++_shared fail:", th6);
            }
        }
        if (u.a()) {
            QLog.i(TAG, 1, "enable download qbar so");
            String d16 = QBarSoDownloader.h().d();
            if (!TextUtils.isEmpty(d16)) {
                try {
                    System.load(d16);
                    hasSoLoad = true;
                    hasSoLoadByPath = true;
                    QLog.i(TAG, 1, "loadSoByPath success");
                } catch (Throwable th7) {
                    QLog.e(TAG, 1, "loadSoByPath, load libQBarMod.so failed:", th7);
                    hasSoLoad = false;
                    QQBeaconReport.report("", "scan_qbar_so_load_path_fail");
                }
            }
        }
        if (!hasSoLoad && context != null) {
            try {
                hasSoLoad = SoLoadUtilNew.loadSoByName(context, "QBarMod");
            } catch (Throwable th8) {
                hasSoLoad = false;
                QLog.e(TAG, 1, "loadSoByName, load libQBarMod.so failed:", th8);
            }
        }
        if (!hasSoLoad) {
            QLog.e(TAG, 1, "Init load QBarMod fail, try system load.");
            try {
                System.loadLibrary("QBarMod");
                hasSoLoad = true;
            } catch (Throwable th9) {
                QLog.e(TAG, 1, "Init system load QBarMod fail:", th9);
                hasSoLoad = false;
            }
            if (context != null) {
                ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).reportQBarSoLoadFail(hasSoLoad);
            }
        }
    }

    public QbarNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.qbarId = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int Encode(byte[] bArr, int[] iArr, String str, int i3, int i16, String str2, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int EncodeBitmap(String str, Bitmap bitmap, int i3, int i16, int i17, int i18, String str2, int i19);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native String GetVersion();

    public static Bitmap encode(String str, int i3, int i16, int i17, int i18, String str2, int i19) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        if (EncodeBitmap(str, createBitmap, i3, i16, i17, i18, str2, i19) > 0) {
            return createBitmap;
        }
        return null;
    }

    public static String getVersion() {
        return GetVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeArrayConvert(int i3, int i16, byte[] bArr, int[] iArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeCropGray2(byte[] bArr, byte[] bArr2, int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeGrayRotateCropSub(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr2, int[] iArr, int i27, int i28);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeTransBytes(int[] iArr, byte[] bArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeTransPixels(int[] iArr, byte[] bArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeYUVrotate(byte[] bArr, byte[] bArr2, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeYUVrotateLess(byte[] bArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int nativeYuvToCropIntArray(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26);

    /* JADX INFO: Access modifiers changed from: protected */
    public native int GetCodeDetectInfo(QBarCodeDetectInfo[] qBarCodeDetectInfoArr, QBarPoint[] qBarPointArr, int i3);

    public int GetOneResult(StringBuilder sb5, StringBuilder sb6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) sb5, (Object) sb6)).intValue();
        }
        ArrayList<QBarResult> GetResults = GetResults(1);
        if (GetResults == null || GetResults.size() <= 0) {
            return 0;
        }
        sb5.append(GetResults.get(0).f276507e);
        sb6.append(GetResults.get(0).f276508f);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public native int GetOneResult(byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native int GetResults(QBarResultJNI[] qBarResultJNIArr, int i3);

    public ArrayList<QBarResult> GetResults(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : GetResults qbarId:" + this.qbarId + " hasSoLoad:" + hasSoLoad);
        }
        if (i3 <= 0 || this.qbarId < 0) {
            return null;
        }
        QBarResultJNI[] qBarResultJNIArr = new QBarResultJNI[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            QBarResultJNI qBarResultJNI = new QBarResultJNI();
            qBarResultJNIArr[i16] = qBarResultJNI;
            qBarResultJNI.charset = new String();
            QBarResultJNI qBarResultJNI2 = qBarResultJNIArr[i16];
            qBarResultJNI2.data = new byte[1024];
            qBarResultJNI2.typeName = new String();
            qBarResultJNIArr[i16].points = new QBarPoint();
        }
        synchronized (this) {
            int i17 = this.qbarId;
            if (i17 < 0) {
                return null;
            }
            GetResults(qBarResultJNIArr, i17);
            ArrayList<QBarResult> arrayList = new ArrayList<>();
            for (int i18 = 0; i18 < i3; i18++) {
                try {
                    QBarResultJNI qBarResultJNI3 = qBarResultJNIArr[i18];
                    String str = qBarResultJNI3.typeName;
                    if (str != null && !str.isEmpty()) {
                        QBarResult qBarResult = new QBarResult();
                        qBarResult.f276507e = qBarResultJNI3.typeName;
                        if (qBarResultJNI3.charset.equals("ANY")) {
                            String str2 = new String(qBarResultJNI3.data, "UTF-8");
                            qBarResult.f276508f = str2;
                            if (TextUtils.isEmpty(str2)) {
                                qBarResult.f276508f = new String(qBarResultJNI3.data, "ASCII");
                            }
                        } else {
                            qBarResult.f276508f = new String(qBarResultJNI3.data, qBarResultJNI3.charset);
                        }
                        qBarResult.f276506d = 1.0f;
                        int i19 = this.mWidth;
                        if (i19 > 0 && this.mHeight > 0) {
                            QBarPoint qBarPoint = qBarResultJNI3.points;
                            if (qBarPoint.point_cnt > 2) {
                                float min = Math.min(qBarPoint.f342416x0 / i19, qBarPoint.f342418x2 / i19);
                                QBarPoint qBarPoint2 = qBarResultJNI3.points;
                                float f16 = qBarPoint2.f342416x0;
                                int i26 = this.mWidth;
                                float max = Math.max(f16 / i26, qBarPoint2.f342418x2 / i26);
                                QBarPoint qBarPoint3 = qBarResultJNI3.points;
                                float f17 = qBarPoint3.f342420y0;
                                int i27 = this.mHeight;
                                float min2 = Math.min(f17 / i27, qBarPoint3.f342422y2 / i27);
                                QBarPoint qBarPoint4 = qBarResultJNI3.points;
                                float f18 = qBarPoint4.f342420y0;
                                int i28 = this.mHeight;
                                qBarResult.f276509h = new RectF(min, min2, max, Math.max(f18 / i28, qBarPoint4.f342422y2 / i28));
                            } else {
                                float min3 = Math.min(qBarPoint.f342416x0 / i19, qBarPoint.f342417x1 / i19) - 0.01f;
                                QBarPoint qBarPoint5 = qBarResultJNI3.points;
                                float f19 = qBarPoint5.f342416x0;
                                int i29 = this.mWidth;
                                float max2 = Math.max(f19 / i29, qBarPoint5.f342417x1 / i29) + 0.01f;
                                QBarPoint qBarPoint6 = qBarResultJNI3.points;
                                float f26 = qBarPoint6.f342420y0;
                                int i36 = this.mHeight;
                                float min4 = Math.min(f26 / i36, qBarPoint6.f342421y1 / i36) - 0.01f;
                                QBarPoint qBarPoint7 = qBarResultJNI3.points;
                                float f27 = qBarPoint7.f342420y0;
                                int i37 = this.mHeight;
                                qBarResult.f276509h = new RectF(min3, min4, max2, Math.max(f27 / i37, qBarPoint7.f342421y1 / i37) + 0.01f);
                            }
                        } else {
                            qBarResult.f276509h = new RectF();
                        }
                        arrayList.add(qBarResult);
                    }
                } catch (UnsupportedEncodingException e16) {
                    QLog.e(TAG, 1, "GetResults exp:" + e16.getMessage());
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public native int GetZoomInfo(QBarZoomInfo qBarZoomInfo, int i3);

    protected native int Init(int i3, int i16, String str, String str2, QbarAiModelParam qbarAiModelParam);

    protected native int Release(int i3);

    protected native int ScanImage(byte[] bArr, int i3, int i16, int i17);

    protected native int SetReaders(int[] iArr, int i3, int i16);

    public int init(int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : init ");
        }
        return init(i3, i16, str, str2, null);
    }

    public int release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : release qbarId:" + this.qbarId + " hasSoLoad:" + hasSoLoad);
        }
        this.mWidth = 0;
        this.mHeight = 0;
        synchronized (this) {
            int i3 = this.qbarId;
            if (i3 < 0) {
                return 0;
            }
            int Release = Release(i3);
            this.qbarId = -1;
            return Release;
        }
    }

    public int scanImage(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : scanImage qbarId:" + this.qbarId + " hasSoLoad:" + hasSoLoad);
        }
        this.mWidth = i3;
        this.mHeight = i16;
        synchronized (this) {
            int i17 = this.qbarId;
            if (i17 < 0) {
                return -1;
            }
            if (ScanImage(bArr, i3, i16, i17) < 0) {
                return -1;
            }
            ArrayList<QBarResult> GetResults = GetResults(1);
            if (GetResults != null && GetResults.size() > 0) {
                return 0;
            }
            return -1;
        }
    }

    public int setReaders(int[] iArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr, i3)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : setReaders qbarId:" + this.qbarId + " hasSoLoad:" + hasSoLoad);
        }
        synchronized (this) {
            int i16 = this.qbarId;
            if (i16 < 0) {
                return -1;
            }
            return SetReaders(iArr, i3, i16);
        }
    }

    public static int encode(byte[] bArr, int[] iArr, String str, int i3, int i16, String str2, int i17) {
        return Encode(bArr, iArr, str, i3, i16, str2, i17);
    }

    public int init(int i3, int i16, String str, String str2, QbarAiModelParam qbarAiModelParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, qbarAiModelParam)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QbarNative : init qbarId:" + this.qbarId + " hasSoLoad:" + hasSoLoad);
        }
        if (!hasSoLoad) {
            return -1;
        }
        if (this.qbarId < 0) {
            try {
                synchronized (this) {
                    if (qbarAiModelParam != null) {
                        this.qbarId = Init(i3, i16, str, str2, qbarAiModelParam);
                    } else {
                        QbarAiModelParam qbarAiModelParam2 = new QbarAiModelParam();
                        qbarAiModelParam2.detect_model_bin_path_ = "";
                        qbarAiModelParam2.detect_model_param_path_ = "";
                        qbarAiModelParam2.superresolution_model_bin_path_ = "";
                        qbarAiModelParam2.superresolution_model_param_path_ = "";
                        this.qbarId = Init(i3, i16, str, str2, qbarAiModelParam2);
                    }
                }
            } catch (Throwable th5) {
                this.qbarId = -1;
                QLog.e(TAG, 1, "QbarNative init hasSoLoad:" + hasSoLoad + " error:" + th5.getMessage());
            }
        }
        this.mWidth = 0;
        this.mHeight = 0;
        return this.qbarId < 0 ? -1 : 0;
    }
}
