package com.tencent.biz.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f97760d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Resources f97761e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f97762f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ LatLng f97763h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ LatLng f97764i;

        a(int i3, Resources resources, String str, LatLng latLng, LatLng latLng2) {
            this.f97760d = i3;
            this.f97761e = resources;
            this.f97762f = str;
            this.f97763h = latLng;
            this.f97764i = latLng2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16 = this.f97760d;
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 == 5) {
                            b.e(this.f97761e.getString(R.string.f225006kg), this.f97762f, this.f97763h, this.f97764i);
                        }
                    } else {
                        b.d(this.f97761e.getString(R.string.f225006kg), this.f97762f, this.f97763h, this.f97764i);
                    }
                } else {
                    b.c(this.f97761e.getString(R.string.f225006kg), this.f97762f, this.f97763h, this.f97764i);
                }
            } else {
                b.f("bus", this.f97761e.getString(R.string.f225006kg), this.f97762f, this.f97763h, this.f97764i);
            }
            ReportController.o(null, "CliOper", "", "", "0X800A970", "0X800A970", 0, 0, "0", "0", "0", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.widgets.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterfaceOnClickListenerC0997b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0997b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "CliOper", "", "", "0X800A971", "0X800A971", 0, 0, "0", "0", "0", "");
        }
    }

    static boolean a(String str) {
        return PackageUtil.isAppInstalled(MobileQQ.sMobileQQ, str);
    }

    public static void b(Context context, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", str);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_location_share");
        QRoute.startUri(activityURIRequest, (o) null);
    }

    static void c(String str, String str2, LatLng latLng, LatLng latLng2) {
        if (a(MapHelper.BAIDU_PKGNAME)) {
            double[] g16 = g(latLng.latitude, latLng.longitude);
            double[] g17 = g(latLng2.latitude, latLng2.longitude);
            String format = String.format("baidumap://map/direction?mode=driving&origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s", Double.valueOf(g16[0]), Double.valueOf(g16[1]), str, Double.valueOf(g17[0]), Double.valueOf(g17[1]), str2);
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.putExtra("big_brother_source_key", "biz_src_location_share");
                parseUri.addFlags(268435456);
                BaseApplication.getContext().startActivity(parseUri);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_QQMAP, 2, "launchBaiduMap: " + format);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "launchBaiduMap: " + format, e16);
                }
            }
        }
    }

    static void d(String str, String str2, LatLng latLng, LatLng latLng2) {
        if (a("com.autonavi.minimap")) {
            String format = String.format("androidamap://route?sourceApplication=qq&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&m=0&t=%d", Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), str, Double.valueOf(latLng2.latitude), Double.valueOf(latLng2.longitude), str2, 2);
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.putExtra("big_brother_source_key", "biz_src_location_share");
                parseUri.addFlags(268435456);
                BaseApplication.getContext().startActivity(parseUri);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_QQMAP, 2, "launchGaoDeMap: " + format);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "launchGaoDeMap: " + format, e16);
                }
            }
        }
    }

    static void e(String str, String str2, LatLng latLng, LatLng latLng2) {
        if (a("com.google.android.apps.maps")) {
            String format = String.format("https://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh", Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), Double.valueOf(latLng2.latitude), Double.valueOf(latLng2.longitude));
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.putExtra("big_brother_source_key", "biz_src_location_share");
                parseUri.addFlags(268435456);
                BaseApplication.getContext().startActivity(parseUri);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_QQMAP, 2, "launchGoogleMap: " + format);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "launchGoogleMap: " + format, e16);
                }
            }
        }
    }

    static void f(String str, String str2, String str3, LatLng latLng, LatLng latLng2) {
        if (a("com.tencent.map")) {
            String format = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", str, str2, Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), str3, Double.valueOf(latLng2.latitude), Double.valueOf(latLng2.longitude));
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.putExtra("big_brother_source_key", "biz_src_location_share");
                parseUri.addFlags(268435456);
                BaseApplication.getContext().startActivity(parseUri);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap: " + format);
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "launchQQMap: " + format, e16);
                }
                ReportController.o(null, "CliOper", "", "", "0X800A972", "0X800A972", 1, 0, "0", "0", "0", "");
            }
        } else {
            ReportController.o(null, "CliOper", "", "", "0X800A972", "0X800A972", 2, 0, "0", "0", "0", "");
        }
        try {
            String format2 = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&referer=qq", str, str2, Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), str3, Double.valueOf(latLng2.latitude), Double.valueOf(latLng2.longitude));
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap, mapparam = " + format2);
            }
            URLEncoder.encode(format2, "UTF-8");
            b(BaseApplication.getContext(), "https://map.wap.qq.com/online/h5_activity_474/index.html");
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap, download = https://map.wap.qq.com/online/h5_activity_474/index.html");
            }
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap, download = https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
            }
        }
    }

    public static double[] g(double d16, double d17) {
        double sqrt = Math.sqrt((d17 * d17) + (d16 * d16)) + (Math.sin(d16 * 3.141592653589793d) * 2.0E-5d);
        double atan2 = Math.atan2(d16, d17) + (Math.cos(d17 * 3.141592653589793d) * 3.0E-6d);
        double cos = (Math.cos(atan2) * sqrt) + 0.0065d;
        double sin = (sqrt * Math.sin(atan2)) + 0.006d;
        double[] dArr = {sin, cos};
        System.out.println("bd_lat:" + sin);
        System.out.println("bd_lon:" + cos);
        return dArr;
    }

    public static void h(Activity activity, String str, LatLng latLng, LatLng latLng2, int i3) {
        Resources resources = BaseApplication.getContext().getResources();
        i(activity, dq.a(activity, 230, null, resources.getString(R.string.gfz), R.string.cancel, R.string.f171151ok, new a(i3, resources, str, latLng, latLng2), new DialogInterfaceOnClickListenerC0997b()));
    }

    public static void i(Activity activity, QQCustomDialog qQCustomDialog) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    qQCustomDialog.show();
                }
            } catch (Exception e16) {
                QLog.e("MapUtils", 1, "showSafely: failed. ", e16);
            }
        }
    }
}
