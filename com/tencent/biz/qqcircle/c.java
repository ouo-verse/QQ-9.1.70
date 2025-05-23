package com.tencent.biz.qqcircle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StGPSV2;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f83141c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f83142a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StGPSV2 f83143b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {
        a(String str, boolean z16) {
            super(str, z16);
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (i3 == 0) {
                if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                    c.this.j(sosoLbsInfo);
                    return;
                } else {
                    QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request: location is null");
                    return;
                }
            }
            QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request: failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f83145a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z16, WeakReference weakReference) {
            super(str, z16);
            this.f83145a = weakReference;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            InterfaceC0846c interfaceC0846c = (InterfaceC0846c) this.f83145a.get();
            if (i3 == 0) {
                if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                    c.this.j(sosoLbsInfo);
                    if (interfaceC0846c != null) {
                        interfaceC0846c.v9(c.this.f83143b);
                        return;
                    }
                    return;
                }
                if (interfaceC0846c != null) {
                    interfaceC0846c.g9(i3);
                }
                QLog.d("QCircleGpsHelper", 1, "getLocationNow get GpsInfo from request: location is null");
                return;
            }
            QLog.d("QCircleGpsHelper", 1, "getLocationNow get GpsInfo from request: failed. errCode =" + i3);
            if (interfaceC0846c != null) {
                interfaceC0846c.g9(i3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0846c {
        void g9(int i3);

        void v9(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2);
    }

    c() {
    }

    public static c e() {
        if (f83141c == null) {
            synchronized (c.class) {
                if (f83141c == null) {
                    f83141c = new c();
                }
            }
        }
        return f83141c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(SosoLbsInfo sosoLbsInfo) {
        this.f83142a = true;
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        this.f83143b = feedCloudMeta$StGPSV2;
        feedCloudMeta$StGPSV2.lat.set(f(sosoLbsInfo));
        this.f83143b.lon.set(i(sosoLbsInfo));
    }

    public boolean c(Activity activity) {
        return z.a(activity, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public FeedCloudMeta$StGPSV2 d() {
        if (this.f83142a) {
            return this.f83143b;
        }
        return null;
    }

    protected int f(SosoLbsInfo sosoLbsInfo) {
        try {
            if (QCircleApplication.isRDMVersion() && QCirclePluginGlobalInfo.j() != null && !TextUtils.isEmpty(QCirclePluginGlobalInfo.j().latitude)) {
                return Integer.parseInt(QCirclePluginGlobalInfo.j().latitude);
            }
        } catch (Exception e16) {
            QLog.d("QCircleGpsHelper", 1, "getLatitude exception:" + e16.toString());
        }
        return Double.valueOf(sosoLbsInfo.mLocation.mLat02 * 1000000.0d).intValue();
    }

    public void g(Context context, boolean z16) {
        this.f83142a = false;
        SosoLbsInfo cachedLbsInfo = QCircleHostLbsHelper.getCachedLbsInfo("qqcircle");
        if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
            j(cachedLbsInfo);
            QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from cache");
        } else {
            if (!(context instanceof Activity) || !c((Activity) context) || !z16) {
                return;
            }
            QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request");
            QCircleHostLbsHelper.startLocation(new a("qqcircle", true));
        }
    }

    public void h(InterfaceC0846c interfaceC0846c) {
        QLog.d("QCircleGpsHelper", 1, "getLocationNow");
        QCircleHostLbsHelper.startLocation(new b("qqcircle", true, new WeakReference(interfaceC0846c)));
    }

    protected int i(SosoLbsInfo sosoLbsInfo) {
        try {
            if (QCircleApplication.isRDMVersion() && QCirclePluginGlobalInfo.j() != null && !TextUtils.isEmpty(QCirclePluginGlobalInfo.j().longitude)) {
                return Integer.parseInt(QCirclePluginGlobalInfo.j().longitude);
            }
        } catch (Exception e16) {
            QLog.d("QCircleGpsHelper", 1, "getLongitude exception:" + e16.toString());
        }
        return Double.valueOf(sosoLbsInfo.mLocation.mLon02 * 1000000.0d).intValue();
    }

    public boolean k() {
        return this.f83142a;
    }
}
