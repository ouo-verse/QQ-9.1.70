package com.tencent.mobileqq.mini.out;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MapHelper implements ActionSheet.OnButtonClickListener {
    public static final int ACTION_BAIDU_MAP = 2;
    public static final int ACTION_STREET = 0;
    public static final int ACTION_TENCENT_MAP = 1;
    public static final String BAIDU_PKGNAME = "com.baidu.BaiduMap";
    protected static final int DRAVING = 1;
    public static final String QQMAP_DOWNLOAD_URL = "https://pr.map.qq.com/j/tmap/download";
    public static final String QQMAP_PKGNAME = "com.tencent.map";
    protected static final int WALKING = 0;
    protected Context mContext;
    protected String mSelfPoiName;
    protected LatLng mSelfPoint;
    private String mStreetViewUrl;
    protected String mTargetPoiName;
    protected LatLng mTargetPoint;
    protected Handler mUIHandler;
    protected ActionSheet mActionSheet = null;
    protected HashSet<String> mInstalledMapAppSet = new HashSet<>();
    protected LinkedHashMap<String, String> mAppNameMap = new LinkedHashMap<>();
    protected HashMap<String, Integer> mActionMap = new HashMap<>();
    protected int[] mActionArray = new int[6];
    protected int mRouteMode = 0;

    public MapHelper(Context context) {
        this.mContext = context;
        this.mAppNameMap.put("com.tencent.map", HardCodeUtil.qqStr(R.string.nxw));
        this.mAppNameMap.put(BAIDU_PKGNAME, HardCodeUtil.qqStr(R.string.f172164ny2));
        this.mActionMap.put("com.tencent.map", 1);
        this.mActionMap.put(BAIDU_PKGNAME, 2);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public static double getDistance(double d16, double d17, double d18, double d19) {
        double d26 = (d17 * 3.141592653589793d) / 180.0d;
        double d27 = (d19 * 3.141592653589793d) / 180.0d;
        double sin = Math.sin((d26 - d27) / 2.0d);
        double sin2 = Math.sin((((d16 - d18) * 3.141592653589793d) / 180.0d) / 2.0d);
        return 1.2756274E7d * Math.asin(Math.sqrt((sin * sin) + (Math.cos(d26) * Math.cos(d27) * sin2 * sin2)));
    }

    public static double[] map_tx2bd(double d16, double d17) {
        double sqrt = Math.sqrt((d17 * d17) + (d16 * d16)) + (Math.sin(d16 * 3.141592653589793d) * 2.0E-5d);
        double atan2 = Math.atan2(d16, d17) + (Math.cos(d17 * 3.141592653589793d) * 3.0E-6d);
        return new double[]{(sqrt * Math.sin(atan2)) + 0.006d, (Math.cos(atan2) * sqrt) + 0.0065d};
    }

    protected void checkInstalledMapApp() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mInstalledMapAppSet.clear();
        this.mContext.getPackageManager();
        if (PackageUtil.isPackageInstalled(this.mContext, "com.tencent.map")) {
            this.mInstalledMapAppSet.add("com.tencent.map");
        }
        if (PackageUtil.isPackageInstalled(this.mContext, BAIDU_PKGNAME)) {
            this.mInstalledMapAppSet.add(BAIDU_PKGNAME);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QQMAP, 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
    public void onClick(View view, int i3) {
        int i16 = this.mActionArray[i3];
        if (i16 != 1) {
            if (i16 == 2) {
                openBaiduMapForRoute();
            }
        } else {
            openQQMapForRoute();
        }
        if (this.mActionSheet.isShowing()) {
            this.mActionSheet.dismiss();
        }
    }

    protected void openBaiduMapForRoute() {
        String str;
        if (this.mRouteMode == 0) {
            str = HiHealthActivities.WALKING;
        } else {
            str = "driving";
        }
        String str2 = "";
        try {
            double[] map_tx2bd = map_tx2bd(this.mSelfPoint.getLatitude(), this.mSelfPoint.getLongitude());
            double[] map_tx2bd2 = map_tx2bd(this.mTargetPoint.getLatitude(), this.mTargetPoint.getLongitude());
            str2 = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", Double.valueOf(map_tx2bd[0]), Double.valueOf(map_tx2bd[1]), this.mSelfPoiName, Double.valueOf(map_tx2bd2[0]), Double.valueOf(map_tx2bd2[1]), this.mTargetPoiName, str);
            Intent intent = Intent.getIntent(str2);
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            this.mContext.startActivity(intent);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "openBaiduMapForRoute:" + str2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.TAG_QQMAP, 2, "openBaiduMapForRoute:" + str2, e16);
            }
        }
    }

    protected void openQQMapForRoute() {
        String str;
        if (this.mInstalledMapAppSet.contains("com.tencent.map")) {
            if (this.mRouteMode == 0) {
                str = "walk";
            } else {
                str = "drive";
            }
            String format = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", str, this.mSelfPoiName, Double.valueOf(this.mSelfPoint.getLatitude()), Double.valueOf(this.mSelfPoint.getLongitude()), this.mTargetPoiName, Double.valueOf(this.mTargetPoint.getLatitude()), Double.valueOf(this.mTargetPoint.getLongitude()));
            try {
                Intent parseUri = Intent.parseUri(format, 0);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                this.mContext.startActivity(parseUri);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_QQMAP, 2, "openQQMapForRoute:" + format);
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "openQQMapForRoute:" + format, e16);
                }
            }
        }
        Intent intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", QQMAP_DOWNLOAD_URL);
        this.mContext.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QQMAP, 2, "openQQMapForRoute, download=https://pr.map.qq.com/j/tmap/download");
        }
    }

    protected void openStreetViewMap() {
        if (TextUtils.isEmpty(this.mStreetViewUrl)) {
            QQToast.makeText(this.mContext.getApplicationContext(), 0, HardCodeUtil.qqStr(R.string.nxy), 1).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.mStreetViewUrl);
        intent.putExtra("reqType", 4);
        this.mContext.startActivity(intent);
    }

    public void setStreetViewUrl(String str) {
        this.mStreetViewUrl = str;
    }

    public void showActionSheet(LatLng latLng, LatLng latLng2, String str, String str2) {
        int i3 = 0;
        if (latLng != null && latLng2 != null) {
            this.mSelfPoint = latLng;
            this.mTargetPoint = latLng2;
            this.mSelfPoiName = str;
            this.mTargetPoiName = str2;
            if (TextUtils.isEmpty(str)) {
                this.mSelfPoiName = HardCodeUtil.qqStr(R.string.nxx);
            }
            if (TextUtils.isEmpty(this.mTargetPoiName)) {
                this.mTargetPoiName = HardCodeUtil.qqStr(R.string.nxv);
            }
            double distance = getDistance(latLng.getLongitude(), latLng.getLatitude(), latLng2.getLongitude(), latLng2.getLatitude());
            if (distance > 1000.0d) {
                this.mRouteMode = 1;
            } else {
                this.mRouteMode = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "showActionSheet: self=" + latLng.toString() + ",to=" + latLng2.toString() + ",selfPoi=" + str + ",toPoi=" + str2 + ",distance=" + distance);
            }
            checkInstalledMapApp();
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mContext, null);
            this.mActionSheet = actionSheet;
            actionSheet.setOnButtonClickListener(this);
            if (!TextUtils.isEmpty(this.mStreetViewUrl)) {
                this.mActionSheet.addButton(HardCodeUtil.qqStr(R.string.nxz));
                this.mActionArray[0] = 0;
                i3 = 1;
            }
            this.mActionSheet.addButton(HardCodeUtil.qqStr(R.string.f172162ny0));
            int i16 = i3 + 1;
            this.mActionArray[i3] = 1;
            for (Map.Entry<String, String> entry : this.mAppNameMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (this.mInstalledMapAppSet.contains(key)) {
                    this.mActionSheet.addButton(value);
                    this.mActionArray[i16] = this.mActionMap.get(key).intValue();
                    i16++;
                }
            }
            this.mActionSheet.show();
            return;
        }
        QQToast.makeText(this.mContext, 0, HardCodeUtil.qqStr(R.string.f172163ny1), 1).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
