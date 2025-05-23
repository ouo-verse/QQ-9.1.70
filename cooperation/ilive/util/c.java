package cooperation.ilive.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.ilive.manager.ILiveDbManagerApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f390148a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private static long f390149b = 0;

    private static boolean b(n05.a aVar) {
        if (aVar != null && aVar.f417945a != null) {
            IModule moduleByName = AVBizModuleFactory.getModuleByName("QQ\u76f4\u64ad");
            final Context context = aVar.f417945a;
            String checkAVFocus = moduleByName.checkAVFocus();
            if (!"true".equals(checkAVFocus)) {
                final String format = String.format(context.getResources().getString(R.string.z_k), checkAVFocus);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.ilive.util.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.g(context, format);
                    }
                });
                f390148a.e("IliveEntranceUtil", 1, "preCheckIsUserGamePlaying, res[" + checkAVFocus + "]");
                return false;
            }
        }
        return true;
    }

    public static boolean c() {
        if (((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).getIliveSwitch(1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean d(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = true;
        QLog.i("IliveEntranceUtil", 1, " offset = " + (currentTimeMillis - f390149b));
        if (currentTimeMillis - f390149b <= i3) {
            z16 = false;
        }
        f390149b = currentTimeMillis;
        return z16;
    }

    @Deprecated
    public static boolean e(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        ComponentName componentName;
        try {
            a.a("IliveEntranceUtilisServiceExisted");
            runningServices = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        } catch (Throwable th5) {
            f390148a.e("IliveEntranceUtil", th5.getMessage());
        }
        if (runningServices != null && runningServices.size() != 0) {
            for (int i3 = 0; i3 < runningServices.size(); i3++) {
                ActivityManager.RunningServiceInfo runningServiceInfo = runningServices.get(i3);
                if (runningServiceInfo != null && (componentName = runningServiceInfo.service) != null && componentName.getClassName().equals(str)) {
                    return true;
                }
            }
            a.b("IliveEntranceUtilisServiceExisted");
            return false;
        }
        return false;
    }

    public static boolean f() {
        if (((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).getIliveSwitch(2) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Context context, String str) {
        QQToast.makeText(context, str, 1).show();
    }

    public static void h(n05.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!b(aVar)) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(aVar.E).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_BREAK).desc("AV Disable"));
            return;
        }
        if (!TextUtils.isEmpty(aVar.f417948d)) {
            try {
                aVar.f417948d = Uri.decode(aVar.f417948d);
            } catch (Exception e16) {
                f390148a.e("IliveEntranceUtil", e16.getMessage());
            }
        }
        if (!TextUtils.isEmpty(aVar.f417952h)) {
            try {
                aVar.f417952h = Uri.decode(aVar.f417952h);
            } catch (Exception e17) {
                f390148a.e("IliveEntranceUtil", e17.getMessage());
            }
        }
        if (!TextUtils.isEmpty(aVar.f417956l)) {
            try {
                aVar.f417956l = Uri.decode(aVar.f417956l);
            } catch (Exception e18) {
                f390148a.e("IliveEntranceUtil", e18.getMessage());
            }
        }
        f390148a.i("IliveEntranceUtil", "liveWatchEntranceJump source = " + aVar.f417946b + " roomID = " + aVar.f417947c + " retain = " + aVar.f417950f);
        if (TextUtils.isEmpty(aVar.f417947c)) {
            aVar.f417947c = "-1";
        }
        if (aVar.f417956l == null) {
            aVar.f417956l = "";
        }
        p05.a.c().b(aVar);
    }
}
