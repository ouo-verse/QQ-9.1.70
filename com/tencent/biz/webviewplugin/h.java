package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private QQPermission f97570d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f97571a;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.webviewplugin.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C0995a extends LbsManagerServiceOnLocationChangeListener {
            C0995a(String str) {
                super(str);
            }

            @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                if (QLog.isColorLevel()) {
                    QLog.e("LocationPlugin", 2, "onLocationFinish errCode = " + i3);
                }
                a aVar = a.this;
                h.this.q(sosoLbsInfo, aVar.f97571a);
            }
        }

        a(String str) {
            this.f97571a = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new C0995a("webview"));
            if (QLog.isColorLevel()) {
                QLog.d("LocationPlugin", 2, "SosoInterface.startLocation");
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            h.this.callJs(this.f97571a, "-3", "{}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(SosoLbsInfo sosoLbsInfo, String str) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat02);
                jSONObject.put("lon", sosoLbsInfo.mLocation.mLon02);
                jSONObject.put("nation", s(sosoLbsInfo.mLocation.nation));
                jSONObject.put("province", s(sosoLbsInfo.mLocation.province));
                jSONObject.put("city", s(sosoLbsInfo.mLocation.city));
                jSONObject.put("adcode", s(sosoLbsInfo.mLocation.cityCode));
                jSONObject.put("district", s(sosoLbsInfo.mLocation.district));
                jSONObject.put("town", s(sosoLbsInfo.mLocation.town));
                jSONObject.put("village", s(sosoLbsInfo.mLocation.village));
                jSONObject.put("street", s(sosoLbsInfo.mLocation.street));
                jSONObject.put("streetNo", s(sosoLbsInfo.mLocation.streetNo));
                List<TencentPoi> list = sosoLbsInfo.mLocation.poi;
                if (list != null && list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (TencentPoi tencentPoi : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", s(tencentPoi.getName()));
                        jSONObject2.put("addr", s(tencentPoi.getAddress()));
                        jSONObject2.put(Element.ELEMENT_NAME_DISTANCE, tencentPoi.getDistance());
                        jSONObject2.put("catalog", s(tencentPoi.getCatalog()));
                        jSONObject2.put(QCircleSchemeAttr.Polymerize.LAT, tencentPoi.getLatitude());
                        jSONObject2.put("lon", tencentPoi.getLongitude());
                        jSONArray.mo162put(jSONObject2);
                    }
                    jSONObject.put("pois", jSONArray);
                }
                callJs(str, "0", jSONObject.toString());
                return;
            } catch (Exception e16) {
                QLog.e("LocationPlugin", 1, "onLocationFinish Failed!", e16);
                callJs(str, "-5", "{}");
                return;
            }
        }
        callJs(str, "-4", "{}");
    }

    private void r(SosoLbsInfo sosoLbsInfo, String str) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat02);
                jSONObject.put("lon", sosoLbsInfo.mLocation.mLon02);
                jSONObject.put("nation", s(sosoLbsInfo.mLocation.nation));
                jSONObject.put("province", s(sosoLbsInfo.mLocation.province));
                jSONObject.put("city", s(sosoLbsInfo.mLocation.city));
                jSONObject.put("adcode", s(sosoLbsInfo.mLocation.cityCode));
                jSONObject.put("district", s(sosoLbsInfo.mLocation.district));
                jSONObject.put("town", s(sosoLbsInfo.mLocation.town));
                jSONObject.put("village", s(sosoLbsInfo.mLocation.village));
                jSONObject.put("street", s(sosoLbsInfo.mLocation.street));
                jSONObject.put("streetNo", s(sosoLbsInfo.mLocation.streetNo));
                callJs(str, "0", jSONObject.toString());
                return;
            } catch (Exception e16) {
                QLog.e("LocationPlugin", 1, "onLocationFinish Failed!", e16);
                callJs(str, "-5", "{}");
                return;
            }
        }
        callJs(str, "-4", "{}");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "location";
    }

    public void t(String str) {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.e() == null || (a16 = this.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        if (str.charAt(0) == '{') {
            try {
                str = new JSONObject(str).getString("callback");
            } catch (JSONException e16) {
                QLog.e("LocationPlugin", 1, e16.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview"), str);
    }

    public void u(String str) {
        SosoLocation sosoLocation;
        List<TencentPoi> list;
        if (QLog.isColorLevel()) {
            QLog.d("LocationPlugin", 2, "getPois:" + str);
        }
        if (this.mRuntime.e() == null) {
            if (QLog.isColorLevel()) {
                QLog.w("LocationPlugin", 2, "getWebView()==null, return");
                return;
            }
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            if (str.charAt(0) == '{') {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    str = jSONObject.getString("callback");
                    jSONObject.optLong("allowCacheTime", 0L);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("LocationPlugin", 2, "getLocation exception:", e16);
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (a16 instanceof AppActivity) {
                SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
                if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null && (list = sosoLocation.poi) != null && list.size() > 0) {
                    q(cachedLbsInfo, str);
                    return;
                }
                if (this.f97570d == null) {
                    this.f97570d = QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_LOCATION));
                }
                this.f97570d.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new a(str));
                return;
            }
            callJs(str, "-4", "{}");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("LocationPlugin", 2, "context==null || isFinishing, return");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4 = strArr[0];
        if ("getLocationWithPoi".equals(str3)) {
            u(str4);
            return true;
        }
        if (!"getLocationCache".equals(str3)) {
            return true;
        }
        t(str4);
        return true;
    }

    private String s(String str) {
        return (str == null || "Unknown".equals(str)) ? "" : str;
    }
}
