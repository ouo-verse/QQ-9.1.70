package com.tencent.mobileqq.dt.report;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.dt.data.e;
import com.tencent.mobileqq.dt.model.WebCheck;
import com.tencent.mobileqq.dt.model.g;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexResInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.UpdateType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, com.tencent.mobileqq.dt.api.d> f203860a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203860a = new HashMap<>();
        }
    }

    public static void a() {
        f203860a.clear();
    }

    public static void b(Context context, com.tencent.mobileqq.dt.api.b bVar, com.tencent.mobileqq.dt.api.d dVar) {
        int i3;
        String str;
        e a16 = g.a();
        String c16 = bVar.c();
        if (TextUtils.isEmpty(c16) && bVar.e() == 2) {
            c16 = bVar.d();
        }
        if (!TextUtils.isEmpty(c16)) {
            bVar.l(com.tencent.mobileqq.dt.util.a.c(c16));
        }
        long j3 = -1;
        if (a16.c() != 0 && !a16.a().contains(bVar.a())) {
            if (bVar.e() == 2 && "0".equals(bVar.b()) && !TextUtils.isEmpty(bVar.d())) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if ((peekAppRuntime instanceof AppInterface) && ProfileUtils.isFriend((AppInterface) peekAppRuntime, bVar.d())) {
                    bVar.j("1");
                }
            }
            if (dVar != null) {
                String str2 = String.valueOf(System.currentTimeMillis()) + String.valueOf(new Random().nextInt());
                Bundle f16 = bVar.f();
                if (f16 == null) {
                    f16 = new Bundle();
                }
                f16.putString(IECDtReport.ACTION_IDENTIFIER, str2);
                bVar.p(f16);
                f203860a.put(str2, dVar);
            }
            if (a16.e().contains(bVar.a())) {
                Bundle f17 = bVar.f();
                if (f17 == null) {
                    f17 = new Bundle();
                }
                f17.putBoolean("useDefaultHeight", true);
                bVar.p(f17);
            }
            KuiklyLaunchParams kuiklyLaunchParams = new KuiklyLaunchParams();
            kuiklyLaunchParams.setDynamicMode(true);
            kuiklyLaunchParams.setPageName("Jubao");
            kuiklyLaunchParams.setModal(true);
            kuiklyLaunchParams.getExtMap().put("jubaoModel", bVar.h());
            kuiklyLaunchParams.setResId("o3");
            kuiklyLaunchParams.setMinResVersion(a16.b());
            kuiklyLaunchParams.setUpdateType(UpdateType.TYPE_USE_LOCAL_PRIORITY);
            if (context instanceof BasePluginActivity) {
                context = BaseApplication.getContext();
            }
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, kuiklyLaunchParams);
            DexResInfo dexResInfo = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo("o3");
            DexConfig config = dexResInfo.getConfig();
            i3 = 0;
            str = "kuikly";
            if (config != null && config.getTag() >= ft0.a.f400599a.longValue()) {
                j3 = dexResInfo.getResVersion();
            }
        } else {
            String valueOf = String.valueOf(System.currentTimeMillis());
            Intent intent = new Intent();
            intent.putExtra("SafeReportDataId", valueOf);
            intent.putExtra("SafeReportData", bVar.g().getBytes(StandardCharsets.UTF_8));
            intent.putExtra("NewSafeReportData", bVar.h());
            intent.putExtra("hide_more_button", true);
            intent.putExtra("ishiderefresh", true);
            intent.putExtra("ishidebackforward", true);
            intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
            if (QLog.isColorLevel()) {
                QLog.i("O3ReportManager", 1, "jumpReport postData is " + bVar.h());
                QLog.i("O3ReportManager", 1, "jumpReport oldPostData is " + bVar.g());
            }
            context.startActivity(intent.putExtra("url", WebCheck.b(a16.d(), bVar.a(), valueOf)));
            if (a16.c() == 0) {
                i3 = 1;
            } else {
                i3 = 3;
            }
            str = "h5";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("appid", bVar.a());
        hashMap.put("page_model", str);
        if (i3 != 0) {
            hashMap.put("h5_reson", Integer.valueOf(i3));
        }
        hashMap.put("kuikly_ver", String.valueOf(j3));
        VideoReport.reportEvent("ev_safe_report_interface", hashMap);
        QLog.i("O3ReportManager", 1, "jumpReport appid = " + bVar.a() + " page_model = " + str + " h5_reson = " + i3 + " kuikly_ver = " + j3);
    }

    public static void c(String str, int i3) {
        com.tencent.mobileqq.dt.api.d dVar = f203860a.get(str);
        if (dVar != null) {
            dVar.a(i3);
        }
    }
}
