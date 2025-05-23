package cooperation.vip.ad.license;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;
import tianshu.TianShuQuantityLimit$CommInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {
    public static TianShuQuantityLimit$CommInfo a(String str) {
        TianShuQuantityLimit$CommInfo tianShuQuantityLimit$CommInfo = new TianShuQuantityLimit$CommInfo();
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        AppRuntime runtime = application.getRuntime();
        if (runtime == null) {
            runtime = application.peekAppRuntime();
        }
        if (runtime == null) {
            QLog.i("QSplash@-TSL-TianShuLicenseUtils", 1, "getCommInfo , get null appRuntime ");
            return tianShuQuantityLimit$CommInfo;
        }
        tianShuQuantityLimit$CommInfo.lUin.set(runtime.getLongAccountUin());
        tianShuQuantityLimit$CommInfo.strApp.set("sq");
        tianShuQuantityLimit$CommInfo.strOs.set("and");
        tianShuQuantityLimit$CommInfo.strDeviceInfo.set(String.valueOf(k15.a.c()));
        tianShuQuantityLimit$CommInfo.strVersion.set(AppSetting.n());
        tianShuQuantityLimit$CommInfo.iBid.set(AppSetting.f());
        tianShuQuantityLimit$CommInfo.strCityCode.set(String.valueOf(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode()));
        tianShuQuantityLimit$CommInfo.strQimei.set(String.valueOf(k15.a.d()));
        tianShuQuantityLimit$CommInfo.strQua.set(String.valueOf(QUA.getQUA3()));
        tianShuQuantityLimit$CommInfo.bLocationAuthorization.set(b(runtime.getApplicationContext(), !TextUtils.isEmpty(r4)));
        tianShuQuantityLimit$CommInfo.traceId.set(str);
        QLog.d("QSplash@-TSL-TianShuLicenseUtils", 1, "getLicenseCommInfo  traceId = " + str);
        return tianShuQuantityLimit$CommInfo;
    }

    private static boolean b(Context context, boolean z16) {
        boolean z17;
        boolean z18;
        if (context == null) {
            return false;
        }
        if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z17 && !z18) {
            return false;
        }
        return true;
    }
}
