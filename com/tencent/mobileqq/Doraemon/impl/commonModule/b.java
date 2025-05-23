package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends com.tencent.mobileqq.Doraemon.e {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static abstract class a extends SosoInterfaceOnLocationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f154158a;

        /* renamed from: b, reason: collision with root package name */
        com.tencent.mobileqq.Doraemon.a f154159b;

        /* renamed from: c, reason: collision with root package name */
        long f154160c;

        /* renamed from: d, reason: collision with root package name */
        long f154161d;

        public a(com.tencent.mobileqq.Doraemon.a aVar, int i3, long j3) {
            super(i3, true, true, j3, true, false, "Doraemon");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.f154159b = aVar;
            this.f154161d = 10000L;
            this.f154160c = System.currentTimeMillis();
            this.f154158a = true;
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onConsecutiveFailure(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.sensor.location", 2, "onConsecutiveFailure: errCode=" + i3 + ", failCount=" + i16);
            }
            if (i16 * 2000 < this.f154161d || !this.f154158a) {
                return;
            }
            this.f154158a = false;
            DoraemonUtil.c(this.f154159b, i3, "error " + i3);
            Long.toString(System.currentTimeMillis() - this.f154160c);
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.commonModule.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C7079b extends a {
        static IPatchRedirector $redirector_;

        public C7079b(com.tencent.mobileqq.Doraemon.a aVar, long j3) {
            super(aVar, 3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + i3 + ", info=" + sosoLbsInfo + ", isActive=" + this.f154158a);
            }
            if (!this.f154158a) {
                return;
            }
            this.f154158a = false;
            if (i3 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("nation", sosoLbsInfo.mLocation.nation);
                    jSONObject.put("province", sosoLbsInfo.mLocation.province);
                    jSONObject.put("city", sosoLbsInfo.mLocation.city);
                    jSONObject.put("district", sosoLbsInfo.mLocation.district);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DoraemonOpenAPI.sensor", 2, e16.getMessage(), e16);
                    }
                }
                DoraemonUtil.e(this.f154159b, jSONObject);
                return;
            }
            DoraemonUtil.c(this.f154159b, i3, "error " + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class c extends a {
        static IPatchRedirector $redirector_;

        public c(com.tencent.mobileqq.Doraemon.a aVar, long j3) {
            super(aVar, 0, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + i3 + ", info=" + sosoLbsInfo + ", isActive=" + this.f154158a);
            }
            if (!this.f154158a) {
                return;
            }
            this.f154158a = false;
            if (i3 == 0) {
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                double d16 = sosoLocation.mLat02;
                double d17 = sosoLocation.mLon02;
                double d18 = sosoLocation.speed;
                double d19 = sosoLocation.accuracy;
                double d26 = sosoLocation.altitude;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("latitude", d16);
                    jSONObject.put("longitude", d17);
                    jSONObject.put("speed", d18);
                    jSONObject.put("accuracy", d19);
                    jSONObject.put("altitude", d26);
                    jSONObject.put("verticalAccuracy", 0.0d);
                    jSONObject.put("horizontalAccuracy", d19);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DoraemonOpenAPI.sensor", 2, e16.getMessage(), e16);
                    }
                }
                DoraemonUtil.e(this.f154159b, jSONObject);
                return;
            }
            DoraemonUtil.c(this.f154159b, i3, "error " + i3);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 6) {
            if (i3 != 7) {
                return false;
            }
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new c(aVar, jSONObject.optInt("allowCacheTime", 10) * 1000));
        } else {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new C7079b(aVar, jSONObject.optInt("allowCacheTime", 10) * 1000));
        }
        return true;
    }
}
