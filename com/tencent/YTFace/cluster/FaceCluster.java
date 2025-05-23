package com.tencent.YTFace.cluster;

import android.text.TextUtils;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.p;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FaceCluster {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_INIT_TRACK_ERROR = -1001;
    public static final int ERROR_MODEL_NOT_EXIST = -1000;
    public static final int FACE_DETECT_FORMAT_BITMAP = 1;
    public static final int FACE_DETECT_FORMAT_PIC = 2;
    private static final String TAG = "FaceCluster";
    private static FaceCluster instance;
    private static boolean loadSoSuccess;
    private static boolean soLoaded;
    public static boolean useAssetSo;
    private long nativeFeaturePtr;
    private long nativeTrackPtr;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        instance = null;
        loadSoSuccess = false;
        soLoaded = false;
        useAssetSo = false;
    }

    FaceCluster() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            String d16 = p.d("YTFaceExtFeature");
            String d17 = p.d("YTFaceClusterJNI_V852");
            BaseApplicationImpl.sApplication.getSharedPreferences("QQCrashReportManager", 4).edit().putString("facefeature_ext_so_md5", d16).commit();
            QLog.d(TAG, 1, "FaceCluster faceFeatureExtSoMD5 = " + d16 + " faceJniSoMD5 =  " + d17);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "FaceCluster exception", e16);
        }
    }

    public static synchronized FaceCluster getInstance() {
        FaceCluster faceCluster;
        synchronized (FaceCluster.class) {
            if (instance == null) {
                instance = new FaceCluster();
            }
            if (!loadSoSuccess) {
                loadNativeLibrary();
            }
            faceCluster = instance;
        }
        return faceCluster;
    }

    public static synchronized boolean loadNativeLibrary() {
        boolean z16;
        synchronized (FaceCluster.class) {
            if (!p.h()) {
                return false;
            }
            if (soLoaded) {
                return loadSoSuccess;
            }
            soLoaded = true;
            try {
                byte k3 = p.k(p.e());
                byte k16 = p.k(p.g());
                System.loadLibrary(SoLoadConstants.SONAME_YTCOMMON);
                byte j3 = p.j("YTFaceCluster");
                byte k17 = p.k(p.f());
                byte j16 = p.j("YTFaceExtFeature");
                byte j17 = p.j("YTFaceClusterJNI_V852");
                if (k16 == 0 && j3 == 0 && j16 == 0 && k17 == 0 && j17 == 0 && k3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                loadSoSuccess = z16;
                QLog.e(TAG, 1, "[loadNativeLibrary], ,ytCppShared = " + ((int) k3) + ",ytOpencvTinyWorld = " + ((int) k16) + ",ytCluster = " + ((int) j3) + ",ytTrackPro = " + ((int) k17) + ",ytFeature = " + ((int) j16) + ",ytJni = " + ((int) j17));
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[loadNativeLibrary]:load face so failed!", th5);
                loadSoSuccess = false;
            }
            return loadSoSuccess;
        }
    }

    public static final void printQLog(int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public native float[] calcuFaceFeature(byte[] bArr, int i3, int i16, float[] fArr, int i17);

    public native float calcuSimilarity(float[] fArr, float[] fArr2);

    public boolean checkFaceTrackModelExistOrNot() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!q.p("")) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkFaceTrackModelExistOrNot false,path = ");
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkFaceTrackModelExistOrNot result = " + z16);
        }
        return z16;
    }

    public native int[] clusterFaces(float[][] fArr);

    public FaceStatus[] detectFace(byte[] bArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (FaceStatus[]) iPatchRedirector.redirect((short) 14, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        return null;
    }

    public native int faceDetect(Object obj, int i3, FaceTarget faceTarget);

    public int faceTrack(byte[] bArr, int i3, int i16, FaceTarget faceTarget, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), faceTarget, Boolean.valueOf(z16))).intValue();
        }
        return -1;
    }

    public native float[] getFaceFeature(byte[] bArr, int i3, int i16, float[] fArr, boolean z16);

    public native float[] getFaceFeature2(Object obj, int i3, float[] fArr);

    public int init(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, str3)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init start,face_feature_model_path = " + str3);
        }
        if (TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "init return1");
            }
            return -1000;
        }
        File file = new File(str3);
        if (checkFaceTrackModelExistOrNot() && file.exists()) {
            try {
                int initTrackPro = initTrackPro("");
                QLog.d(TAG, 1, "init initTrackPro ret = " + initTrackPro);
                if (initTrackPro != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "init return3");
                    }
                    return initTrackPro;
                }
                int initFaceExtFeature = initFaceExtFeature(str3);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "init finish result = " + initFaceExtFeature);
                }
                return initFaceExtFeature;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e(TAG, 1, "Exception", e16);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "init return4");
                }
                return -1001;
            } catch (UnsatisfiedLinkError e17) {
                e17.printStackTrace();
                QLog.e(TAG, 1, BaseQmcfProcessor.LINK_ERROR, e17);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "init return4");
                }
                return -1001;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init return2");
        }
        return -1000;
    }

    @Deprecated
    public native int initFaceExtFeature(String str);

    public native int initTrackPro(String str);

    public boolean isLoadSoSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return loadSoSuccess;
    }

    public native void release();

    public void releaseFaceStatusArray(FaceStatus[] faceStatusArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) faceStatusArr);
        }
    }

    public native FaceStatus[] trackFace(byte[] bArr, int i3, int i16, int i17, boolean z16);

    public int trackSingleFace(byte[] bArr, int i3, int i16, FaceStatus faceStatus, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), faceStatus, Boolean.valueOf(z16))).intValue();
        }
        return -1;
    }

    public int trackSingleFace2(byte[] bArr, int i3, int i16, FaceStatus faceStatus, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), faceStatus, Integer.valueOf(i17))).intValue();
        }
        return -1;
    }
}
