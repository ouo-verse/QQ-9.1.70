package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes11.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f197332j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f197333k;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.armap.sensor.a f197334a;

    /* renamed from: b, reason: collision with root package name */
    private Context f197335b;

    /* renamed from: c, reason: collision with root package name */
    private ReentrantLock f197336c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private boolean f197337d = false;

    /* renamed from: e, reason: collision with root package name */
    private b f197338e = null;

    /* renamed from: f, reason: collision with root package name */
    private float[] f197339f = new float[16];

    /* renamed from: g, reason: collision with root package name */
    private float[] f197340g = null;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.armap.sensor.d f197341h = new a();

    /* renamed from: i, reason: collision with root package name */
    private float[] f197342i = new float[4];

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.armap.sensor.d {
        a() {
        }

        @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
        public void onRotationUpdateQuaternion(float[] fArr) {
            if (r.this.f197338e != null) {
                r.this.f197338e.y(fArr);
            }
        }

        @Override // com.tencent.mobileqq.armap.sensor.d, com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
        public void updateAccelerometer(float f16, float f17, float f18, long j3) {
            if (r.this.f197338e != null) {
                r.this.f197338e.d(f16, f17, f18, j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void d(float f16, float f17, float f18, long j3);

        void y(float[] fArr);
    }

    static {
        float[] fArr = new float[16];
        f197332j = fArr;
        Matrix.setIdentityM(fArr, 0);
        f197333k = true;
    }

    private static boolean d() {
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("HRY-AL00T") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("SM-G955F") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("AQM-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("MI CC9 Pro")) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        boolean z16;
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            String[] strArr = {""};
            int parseComplexParamsBySimpleStringParser = ((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsBySimpleStringParser(featureValueWithoutAccountManager, strArr);
            if (parseComplexParamsBySimpleStringParser >= 1 && Integer.valueOf(strArr[0]).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("AREngine_SensorTrackManager", 1, "arCfg = " + featureValueWithoutAccountManager + ", size = " + parseComplexParamsBySimpleStringParser + ", params[0] = " + strArr[0] + ", isUseGameRotationVector = " + z16);
        } else {
            z16 = false;
        }
        if (z16 || d()) {
            return true;
        }
        return false;
    }

    public void b(boolean z16) {
        if (this.f197337d != z16) {
            this.f197337d = z16;
            QLog.d("SensorTrackManager", 2, "enableSensor enabled: " + z16);
        }
    }

    public void c(Context context, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f197335b = context;
        this.f197338e = bVar;
        g();
        f197333k = this.f197334a.d();
        ARReport.c().q(System.currentTimeMillis() - currentTimeMillis);
    }

    public void f() {
        b(true);
    }

    public void g() {
        if (this.f197334a == null) {
            if (e()) {
                this.f197334a = new com.tencent.mobileqq.armap.sensor.a(this.f197335b, 5);
            } else {
                this.f197334a = new com.tencent.mobileqq.armap.sensor.a(this.f197335b, 4);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SensorTrackManager", 2, "startupSensor");
        }
        this.f197334a.f(this.f197341h, 1);
    }

    public void h() {
        b(false);
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("SensorTrackManager", 2, "stopSensor");
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.f197334a;
        if (aVar != null) {
            aVar.g();
            this.f197334a = null;
        }
    }

    public void j() {
        i();
        this.f197335b = null;
        this.f197337d = false;
        this.f197340g = null;
    }
}
