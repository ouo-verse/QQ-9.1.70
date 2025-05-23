package com.tencent.mobileqq.ar.arengine;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageProc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class ARCloudPretreatmentManager {

    /* renamed from: d, reason: collision with root package name */
    public static int f197784d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f197785e = -1;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f197786a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f197787b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f197788c = "";

    /* loaded from: classes11.dex */
    public interface a {
        void a(j jVar);

        void b(k kVar);

        void c(j jVar);

        void d(int i3, p pVar, long j3);

        void e(l lVar);

        void f(i iVar);

        void g(r rVar);
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f197794a;

        /* renamed from: b, reason: collision with root package name */
        public String f197795b;

        /* renamed from: c, reason: collision with root package name */
        public YuvImage f197796c = null;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f197797d;

        public b(String str, String str2, byte[] bArr) {
            this.f197794a = str;
            this.f197795b = str2;
            this.f197797d = bArr;
        }
    }

    private void a() {
        QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "delete backup file.");
        File[] listFiles = new File(this.f197788c).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private String b() {
        return "FilteredImg" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + ".jpg";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.graphics.YuvImage] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(String str, String str2, byte[] bArr, YuvImage yuvImage) {
        Throwable th5;
        FileOutputStream fileOutputStream;
        IOException e16;
        FileNotFoundException e17;
        File file = new File(str);
        File file2 = new File(str + ((String) str2));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
        }
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException e19) {
                    fileOutputStream = null;
                    e17 = e19;
                } catch (IOException e26) {
                    fileOutputStream = null;
                    e16 = e26;
                } catch (Throwable th6) {
                    str2 = 0;
                    th5 = th6;
                    if (str2 != 0) {
                    }
                    throw th5;
                }
                try {
                    if (bArr != null) {
                        fileOutputStream.write(bArr);
                    } else if (yuvImage != 0) {
                        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 50, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (FileNotFoundException e27) {
                    e17 = e27;
                    e17.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e28) {
                    e16 = e28;
                    e16.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (str2 != 0) {
                    try {
                        str2.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (IOException e36) {
            e36.printStackTrace();
        }
    }

    public void c() {
        this.f197788c = com.tencent.mobileqq.ar.i.e() + "ar_cloud_img/";
        ARCloudImageProc.nativeInit();
        if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "ARCloudPretreatmentManager mImgDir = " + this.f197788c);
        }
    }

    public void d(byte[] bArr, ArrayList<ARRecognition> arrayList, a aVar, int i3, int i16, int i17) {
        int i18;
        int i19;
        long j3;
        int i26;
        int i27;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "AREngine_ARCloudPretreatmentManagert";
        if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] Preprocess start");
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i28 = 480;
            if (i3 > i16) {
                i18 = ((((i3 * 480) / i16) + 3) / 4) * 4;
            } else {
                i18 = 480;
                i28 = ((((i16 * 480) / i3) + 3) / 4) * 4;
            }
            if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g)) {
                i19 = 270;
            } else {
                i19 = 90;
            }
            int i29 = i19;
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "pretreatAllType  degree = " + i29);
            }
            int i36 = (int) (i28 * i18 * 1.5d);
            if (this.f197786a == null || this.f197787b != i36) {
                this.f197786a = new byte[i36];
                this.f197787b = i36;
            }
            if (ARCloudImageProc.nativeScaleAndRotate(this.f197786a, i18, i28, i29, bArr, i3, i16) == 0) {
                QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "Preprocess failed. ScaleAndRotate failed. scaledWidth = " + i18 + ", scaledHeight = " + i28 + ", degree = " + i29 + ", srcWidth = " + i3 + ", srcHeight = " + i16);
                aVar.d(f197785e, null, -1L);
                return;
            }
            Iterator<ARRecognition> it = arrayList.iterator();
            long j16 = -1;
            while (it.hasNext()) {
                ARRecognition next = it.next();
                long j17 = 1 << ((int) next.f196956d);
                if (j17 == 1) {
                    g(this.f197786a, next, aVar);
                } else if (j17 == 2) {
                    h(this.f197786a, next, aVar);
                } else {
                    if (j17 == 4) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        i26 = i28;
                        i27 = i18;
                        e(this.f197786a, i28, i18, next, aVar);
                        j16 = System.currentTimeMillis() - currentTimeMillis2;
                        str = str2;
                    } else {
                        i26 = i28;
                        i27 = i18;
                        str = str2;
                        if (j17 == 64) {
                            i(this.f197786a, next, aVar);
                        } else if (j17 == 128) {
                            f(this.f197786a, next, aVar);
                        } else if (j17 == 2048) {
                            j(this.f197786a, next, aVar);
                        }
                    }
                    str2 = str;
                    i28 = i26;
                    i18 = i27;
                }
                i26 = i28;
                i27 = i18;
                str = str2;
                str2 = str;
                i28 = i26;
                i18 = i27;
            }
            YuvImage yuvImage = new YuvImage(this.f197786a, i17, i28, i18, null);
            b bVar = new b(this.f197788c, b(), this.f197786a);
            k(bVar.f197794a, bVar.f197795b, null, yuvImage);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i(str2, 1, "[DEBUG_SCAN_yt_face] Preprocess end. save img: " + bVar.f197794a + bVar.f197795b + ",preProcessCost = " + currentTimeMillis3 + ",pretreatFaceRecogCost = " + j16);
            p pVar = new p();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(bVar.f197794a);
            sb5.append(bVar.f197795b);
            pVar.f198235a = sb5.toString();
            pVar.f198236b = 0;
            w a16 = w.a();
            a16.f198286c = j16;
            a16.f198285b = currentTimeMillis3;
            byte[] bArr2 = bVar.f197797d;
            if (bArr2 != null) {
                j3 = bArr2.length / 8192;
            } else {
                j3 = 0;
            }
            aVar.d(f197784d, pVar, j3);
        }
    }

    public void e(final byte[] bArr, final int i3, final int i16, ARRecognition aRRecognition, a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace]pretreatFaceRecogInfo,  FaceScanModelsLoader.hasFaceModelInit =  " + com.tencent.mobileqq.ar.o.f198546c);
        }
        if (com.tencent.mobileqq.ar.o.f198547d) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return for releasing");
            return;
        }
        if (!com.tencent.mobileqq.ar.o.f198546c) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return1 FaceModel not init!");
            return;
        }
        i iVar = new i();
        iVar.f198198a = (int) aRRecognition.f196960i;
        final FaceCluster faceCluster = FaceCluster.getInstance();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!com.tencent.mobileqq.ar.o.f198546c) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return2 FaceModel not init!");
            return;
        }
        final FaceStatus[] trackFace = faceCluster.trackFace(bArr, i3, i16, 0, false);
        Handler handler = ARLocalFaceRecog.C;
        if (handler != null) {
            if (handler.hasMessages(4)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreatFaceRecogInfo, remove pending task");
                }
                ARLocalFaceRecog.C.removeMessages(4);
            }
            Message obtain = Message.obtain(ARLocalFaceRecog.C, new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature start");
                    }
                    FaceStatus[] faceStatusArr = trackFace;
                    int i17 = 0;
                    if (faceStatusArr != null && faceStatusArr.length > 0) {
                        int length = faceStatusArr.length;
                        while (i17 < length) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (com.tencent.mobileqq.ar.o.f198546c) {
                                FaceStatus faceStatus = trackFace[i17];
                                faceStatus.feature = faceCluster.calcuFaceFeature(bArr, i3, i16, faceStatus.xys, 0);
                            } else {
                                QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "[DEBUG_SCAN_yt_face] pretreat, FaceModel not init!");
                            }
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "  calcuFaceFeature TimeCost = " + currentTimeMillis3);
                                if (trackFace[i17].feature != null) {
                                    QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "  calcuFaceFeature feature = " + Arrays.toString(trackFace[i17].feature));
                                }
                            }
                            i17++;
                        }
                        i17 = length;
                    }
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                    w.a().f198288e = currentTimeMillis4;
                    w.a().f198289f = i17;
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature TimeCost = " + currentTimeMillis4);
                    }
                }
            });
            obtain.what = 4;
            Handler handler2 = ARLocalFaceRecog.C;
            if (handler2 != null) {
                handler2.sendMessage(obtain);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "pretreatFaceRecogInfo ,handler is null");
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace][TimeCost]pretreatFaceRecogInfo  cost = " + uptimeMillis2 + ", faceStatus = " + Arrays.toString(trackFace));
        }
        if (trackFace != null && trackFace.length > 0) {
            iVar.f198199b = trackFace;
            ReportController.o(null, "dc00898", "", "", "0X800834C", "0X800834C", 0, 0, "", "", "", "");
        }
        aVar.f(iVar);
    }

    public void f(byte[] bArr, ARRecognition aRRecognition, a aVar) {
        j jVar = new j();
        jVar.f198200a = (int) aRRecognition.f196960i;
        aVar.a(jVar);
    }

    public void g(byte[] bArr, ARRecognition aRRecognition, a aVar) {
        r rVar = new r();
        rVar.f198257a = (int) aRRecognition.f196960i;
        aVar.g(rVar);
    }

    public void h(byte[] bArr, ARRecognition aRRecognition, a aVar) {
        j jVar = new j();
        jVar.f198200a = (int) aRRecognition.f196960i;
        aVar.c(jVar);
    }

    public void i(byte[] bArr, ARRecognition aRRecognition, a aVar) {
        k kVar = new k();
        kVar.f198201a = (int) aRRecognition.f196960i;
        aVar.b(kVar);
    }

    public void j(byte[] bArr, ARRecognition aRRecognition, a aVar) {
        l lVar = new l();
        lVar.f198202a = (int) aRRecognition.f196960i;
        aVar.e(lVar);
    }

    public void l() {
        a();
        ARCloudImageProc.nativeUninit();
    }
}
