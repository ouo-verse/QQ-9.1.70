package cooperation.vip.ad.license;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.l;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import cooperation.vip.tianshu.TianShuMMKVUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tianshu.TianShuQuantityLimit$MapEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    private void b(List<TianShuQuantityLimit$MapEntry> list) {
        if (bl.b(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TianShuQuantityLimit$MapEntry tianShuQuantityLimit$MapEntry : list) {
            if (tianShuQuantityLimit$MapEntry.license.canShow.get()) {
                arrayList.add(String.valueOf(tianShuQuantityLimit$MapEntry.key.get()));
            }
        }
        String string = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("vas_splash_ad_ids_with_showdate_with_priority_" + SplashADUtil.i(BaseApplicationImpl.getApplication()), "");
        QLog.i("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "resetTianShuSplashBeginTimeLabel  idsWithTime = " + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String[] split = string.split(",");
        long j3 = 0;
        for (int i3 = 0; i3 + 2 < split.length; i3 += 3) {
            if (arrayList.contains(split[i3])) {
                try {
                    long parseLong = Long.parseLong(split[i3 + 1]);
                    if (j3 == 0 || parseLong < j3) {
                        j3 = parseLong;
                    }
                } catch (NumberFormatException e16) {
                    QLog.w("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "resetTianShuSplashBeginTimeLabel  e = " + e16);
                }
            }
        }
        if (j3 == 0) {
            return;
        }
        l.f288780d.n(1, j3);
        QLog.i("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "resetTianShuSplashBeginTimeLabel   beginTime = " + j3);
    }

    public boolean a(String str) {
        JSONObject jSONObject;
        long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
        Set<String> stringSet = TianShuMMKVUtil.g(i3 + "").getStringSet(TianShuMMKVConstant.SplashKey.TS_SPLASH_AD_LICENSE_INFO, null);
        if (bl.b(stringSet)) {
            QLog.w("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "canShowSplashAd  licenseInfoList is empty , uin = " + i3);
            return true;
        }
        QLog.i("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "canShowSplashAd  | adId = " + str + " | licenseInfoList = " + Arrays.toString(stringSet.toArray()));
        for (String str2 : stringSet) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e16) {
                QLog.e("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "canShowSplashAd  | licenseInfo = " + str2 + " | e = " + e16);
            }
            if (TextUtils.equals(jSONObject.optString("adId", ""), str)) {
                return jSONObject.optBoolean(TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, true);
            }
        }
        return true;
    }

    public void c(List<TianShuQuantityLimit$MapEntry> list) {
        if (bl.b(list)) {
            QLog.w("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "updateAdLicenseInfo  licenseList is empty");
            return;
        }
        QLog.i("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "updateAdLicenseInfo  licenseList.size = " + list.size());
        HashSet hashSet = new HashSet();
        for (TianShuQuantityLimit$MapEntry tianShuQuantityLimit$MapEntry : list) {
            if (tianShuQuantityLimit$MapEntry == null) {
                QLog.e("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "updateAdLicenseInfo  mapEntry == null");
            } else {
                int i3 = tianShuQuantityLimit$MapEntry.key.get();
                boolean z16 = tianShuQuantityLimit$MapEntry.license.canShow.get();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("adId", i3);
                    jSONObject.put(TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, z16);
                    hashSet.add(jSONObject.toString());
                } catch (JSONException e16) {
                    QLog.e("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "updateAdLicenseInfo  e = " + e16);
                }
            }
        }
        TianShuMMKVUtil.g(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()).putStringSet(TianShuMMKVConstant.SplashKey.TS_SPLASH_AD_LICENSE_INFO, hashSet);
        QLog.d("QSplash@-TSL-TSSplashLicenseInfoOperate", 1, "updateAdLicenseInfo  licenseInfoList = " + Arrays.toString(hashSet.toArray()));
        b(list);
    }
}
