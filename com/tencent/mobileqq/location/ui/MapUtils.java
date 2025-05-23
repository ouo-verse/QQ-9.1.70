package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MapUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f241509a;

    /* renamed from: b, reason: collision with root package name */
    private static long f241510b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27958);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241509a = null;
            f241510b = 0L;
        }
    }

    public static void a() {
        f241509a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(TencentMap tencentMap) {
        if (tencentMap != null) {
            Object o16 = o(o(o(tencentMap, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO), "a"), "b");
            p(o(o16, "b"), "b", null);
            Object o17 = o(o16, "u");
            if (o17 instanceof List) {
                ((List) o17).clear();
            }
        }
    }

    public static LatLng c(Collection<com.tencent.mobileqq.location.data.a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<com.tencent.mobileqq.location.data.a> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        return d(arrayList);
    }

    private static LatLng d(List<LatLng> list) {
        int size = list.size();
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        for (LatLng latLng : list) {
            double latitude = (latLng.getLatitude() * 3.141592653589793d) / 180.0d;
            double longitude = (latLng.getLongitude() * 3.141592653589793d) / 180.0d;
            d16 += Math.cos(latitude) * Math.cos(longitude);
            d17 += Math.cos(latitude) * Math.sin(longitude);
            d18 += Math.sin(latitude);
        }
        double d19 = size;
        double d26 = d16 / d19;
        double d27 = d17 / d19;
        return new LatLng((Math.atan2(d18 / d19, Math.sqrt((d26 * d26) + (d27 * d27))) * 180.0d) / 3.141592653589793d, (Math.atan2(d27, d26) * 180.0d) / 3.141592653589793d);
    }

    private static double e(double d16, double d17, double d18, double d19) {
        double n3 = n(d16);
        double n16 = n(d18);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((n3 - n16) / 2.0d), 2.0d) + (Math.cos(n3) * Math.cos(n16) * Math.pow(Math.sin((n(d17) - n(d19)) / 2.0d), 2.0d)))) * 2.0d * 6378137.0d;
    }

    public static double f(LatLng latLng, LatLng latLng2) {
        return e(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }

    public static String g(double d16) {
        int round;
        if (d16 < 60.0d) {
            if (Math.round(d16) <= 0) {
                round = 1;
            } else {
                round = (int) Math.round(d16);
            }
            return round + "\u5206\u949f";
        }
        if (d16 < 1440.0d) {
            return ((int) (d16 / 60.0d)) + "\u5c0f\u65f6" + ((int) Math.round(d16 - (r0 * 60))) + "\u5206\u949f";
        }
        int i3 = (int) (d16 / 1440.0d);
        return i3 + "\u5929" + ((int) ((d16 / 60.0d) - (i3 * 24))) + "\u5c0f\u65f6" + ((int) Math.round((d16 - (r0 * 60)) - (r4 * 60))) + "\u5206\u949f";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Context context) {
        int i3;
        try {
            i3 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MapUtils", 2, "getLocationMode: invoked. locationMode: " + i3);
        }
        return i3;
    }

    public static void i(View view, String str) {
        if (AppSetting.f99565y) {
            view.setContentDescription(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(Context context, TencentMap tencentMap, LatLng latLng) {
        Rect rect = new Rect(0, 0, context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
        Projection projection = tencentMap.getProjection();
        if (projection == null) {
            return false;
        }
        Point screenLocation = projection.toScreenLocation(latLng);
        return rect.contains(screenLocation.x, screenLocation.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        if (f241509a == null) {
            f241509a = Boolean.valueOf(PackageUtil.isAppInstalled(MobileQQ.sMobileQQ, "com.tencent.map"));
        }
        return f241509a.booleanValue();
    }

    public static void l(Context context, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", str);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_location_share");
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Activity activity, String str, String str2, String str3, LatLng latLng, LatLng latLng2) {
        if (k()) {
            String format = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", str, str2, Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), str3, Double.valueOf(latLng2.latitude), Double.valueOf(latLng2.longitude));
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                parseUri.putExtra("big_brother_source_key", "biz_src_location_share");
                activity.startActivity(parseUri);
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
            String str4 = "https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882&intention=" + URLEncoder.encode(format2, "UTF-8");
            l(activity, str4);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap, download = " + str4);
            }
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            l(activity, "https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "launchQQMap, download = https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
            }
        }
    }

    private static double n(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    private static Object o(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private static void p(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
    }

    public static void q(String str, String str2, TextView textView) {
        if (textView.getWidth() == 0) {
            textView.post(new Runnable(str, str2, textView) { // from class: com.tencent.mobileqq.location.ui.MapUtils.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f241511d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f241512e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ TextView f241513f;

                {
                    this.f241511d = str;
                    this.f241512e = str2;
                    this.f241513f = textView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, textView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MapUtils.q(this.f241511d, this.f241512e, this.f241513f);
                    }
                }
            });
            return;
        }
        String str3 = str + str2;
        float width = textView.getWidth();
        float measureText = textView.getPaint().measureText(str);
        float measureText2 = textView.getPaint().measureText(str2);
        if (measureText + measureText2 <= width) {
            textView.setText(str3);
            return;
        }
        float measureText3 = textView.getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        while (measureText + measureText3 + measureText2 > width && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
            measureText = textView.getPaint().measureText(str);
        }
        textView.setText(str + MiniBoxNoticeInfo.APPNAME_SUFFIX + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r(TencentMap tencentMap, int i3) {
        if (tencentMap != null) {
            Object o16 = o(o(o(o(tencentMap.getUiSettings(), "a"), "a"), "d"), "W");
            if (o16 instanceof ViewGroup) {
                ((ViewGroup) o16).setVisibility(i3);
            }
        }
    }
}
