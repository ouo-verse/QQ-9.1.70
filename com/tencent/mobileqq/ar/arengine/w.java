package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.o;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class w {

    /* renamed from: h, reason: collision with root package name */
    static w f198283h;

    /* renamed from: a, reason: collision with root package name */
    public long f198284a;

    /* renamed from: b, reason: collision with root package name */
    public long f198285b;

    /* renamed from: c, reason: collision with root package name */
    public long f198286c;

    /* renamed from: d, reason: collision with root package name */
    public long f198287d;

    /* renamed from: e, reason: collision with root package name */
    public long f198288e;

    /* renamed from: f, reason: collision with root package name */
    public int f198289f;

    /* renamed from: g, reason: collision with root package name */
    public long f198290g;

    public static w a() {
        synchronized (w.class) {
            if (f198283h == null) {
                f198283h = new w();
            }
        }
        return f198283h;
    }

    public static void c(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARExtracFaceFeatrue,cost  = " + j3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", String.valueOf(ARMapTracer.a()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARExtractFaceFeatrue", true, j3, 0L, hashMap, "", true);
    }

    public static void d(q qVar, o oVar) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("errorcode_mq", String.valueOf(oVar.f198218a));
        hashMap.put("errorcode_yt", String.valueOf(oVar.f198220c));
        int i18 = 0;
        if (oVar.f198218a == 0 && oVar.f198220c == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FaceStatus[] faceStatusArr = qVar.f198248i.f198199b;
            if (faceStatusArr != null) {
                i17 = faceStatusArr.length;
            } else {
                i17 = 0;
            }
            ArrayList<o.a> arrayList = oVar.f198225h;
            if (arrayList != null) {
                i18 = arrayList.size();
            }
            hashMap.put("send_person_count", String.valueOf(i17));
            hashMap.put("receive_star_count", String.valueOf(i18));
            i3 = i17;
            i16 = i18;
        } else {
            i3 = 0;
            i16 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - qVar.f198256q;
        hashMap.put("upload_cost", String.valueOf(currentTimeMillis));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceCloudResult", z16, 0L, 0L, hashMap, "", true);
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARFaceCloudResult,sendPersonCount  = " + i3 + ",starCount = " + i16 + ",uploadCost = " + currentTimeMillis);
        }
    }

    public static void e(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARFaceDetect,cost  = " + j3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", String.valueOf(ARMapTracer.a()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceDetect", true, j3, 0L, hashMap, "", true);
    }

    public static void f(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARFaceInit,initCost  = " + j3 + ",devType = " + ARMapTracer.a());
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", String.valueOf(ARMapTracer.a()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceInit", true, j3, 0L, hashMap, "", true);
    }

    public static void g(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARSoLoadResult,libName  = " + str + ",result = " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("libName", str);
        hashMap.put(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceSoLoadResult", true, 0L, 0L, hashMap, "", true);
    }

    public static void h(long j3, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "reportARTrackStablity,duration  = " + j3 + ",count = " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", String.valueOf(ARMapTracer.a()));
        hashMap.put("recoverCount", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceTrackStability", true, j3, 0L, hashMap, "", true);
    }

    public static void i() {
        w a16 = a();
        a16.b();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", String.valueOf(ARMapTracer.a()));
        hashMap.put("ppTotalCost", String.valueOf(a16.f198285b));
        hashMap.put("ppFaceDectectCost", String.valueOf(a16.f198286c));
        hashMap.put("upload_cost", String.valueOf(a16.f198287d));
        hashMap.put("ppExtractCost", String.valueOf(a16.f198288e));
        hashMap.put("ppExtractFaceCount", String.valueOf(a16.f198289f));
        hashMap.put("firstDrawUICost", String.valueOf(a16.f198290g));
        long j3 = a16.f198285b;
        long j16 = a16.f198288e;
        long j17 = a16.f198287d;
        if (j16 <= j17) {
            j16 = j17;
        }
        hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, String.valueOf(j3 + j16 + a16.f198290g));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actFaceStepDuration", true, 0L, 0L, hashMap, "", true);
        a16.j();
    }

    public void b() {
        long j3 = this.f198285b;
        long j16 = this.f198288e;
        long j17 = this.f198287d;
        if (j16 <= j17) {
            j16 = j17;
        }
        long j18 = j3 + j16 + this.f198290g;
        long currentTimeMillis = System.currentTimeMillis() - this.f198284a;
        if (QLog.isColorLevel()) {
            QLog.d("ARFaceDataCollector", 2, "printStepDuration preprocessTotalCost  = " + this.f198285b + ",preprocessFaceDetectCost = " + this.f198286c + ",picUploadCost = " + this.f198287d + ",preprocessFeatureExtrctCost = " + this.f198288e + ",preprocessFaceCount = " + this.f198289f + ",firstDrawUICost = " + this.f198290g + ",totalCost = " + j18 + ",starTime = " + this.f198284a + ",realCost = " + currentTimeMillis);
        }
    }

    public void j() {
        this.f198284a = 0L;
        this.f198285b = 0L;
        this.f198286c = 0L;
        this.f198287d = 0L;
        this.f198288e = 0L;
        this.f198290g = 0L;
    }
}
