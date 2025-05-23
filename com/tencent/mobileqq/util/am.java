package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.login.GetLocalPhone$GuidChangeMibaoData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static BroadcastReceiver f306570a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ne1.a {
        a() {
        }

        @Override // ne1.a
        public void a(@Nullable GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp) {
            if (getLocalPhone$OIDBGetPhoneRsp == null) {
                QLog.e("GuideChangePhoneNumHelper", 1, "GetLocalPhone data is null!");
            } else {
                GetLocalPhone$GuidChangeMibaoData getLocalPhone$GuidChangeMibaoData = getLocalPhone$OIDBGetPhoneRsp.msg_guid_change_mibao_data.get();
                am.k(getLocalPhone$GuidChangeMibaoData.str_guid_wording.get(), getLocalPhone$GuidChangeMibaoData.str_guid_url.get());
            }
        }

        @Override // ne1.a
        public void onFail(int i3, @Nullable String str) {
            QLog.e("GuideChangePhoneNumHelper", 1, "Guide change number getMaskPhone error: " + str);
            am.j(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f306571d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.phone.b f306572e;

        b(AppRuntime appRuntime, com.tencent.mobileqq.activity.phone.b bVar) {
            this.f306571d = appRuntime;
            this.f306572e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.y(this.f306571d, "0X800C107");
            this.f306572e.R();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f306573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f306574e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f306575f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.phone.b f306576h;

        c(AppRuntime appRuntime, String str, Context context, com.tencent.mobileqq.activity.phone.b bVar) {
            this.f306573d = appRuntime;
            this.f306574e = str;
            this.f306575f = context;
            this.f306576h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.y(this.f306573d, "0X800C106");
            Intent intent = new Intent();
            intent.putExtra("uin", this.f306573d.getAccount());
            intent.putExtra("url", this.f306574e);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("portraitOnly", true);
            intent.putExtra("isShowAd", false);
            intent.putExtra("needResult", true);
            intent.putExtra("business", 16384L);
            RouteUtils.startActivity(this.f306575f, intent, RouterConstants.UI_ROUTE_BROWSER);
            am.n(this.f306576h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.phone.b f306577a;

        d(com.tencent.mobileqq.activity.phone.b bVar) {
            this.f306577a = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QLog.i("GuideChangePhoneNumHelper", 1, "onReceive");
            am.x();
            this.f306577a.dismiss();
        }
    }

    private static String d() {
        return h("change_secret_phone_wording" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }

    private static String e() {
        return h("change_secret_phone_url" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }

    private static long f(String str) {
        return MobileQQ.sMobileQQ.getSharedPreferences("gateway_guide_change_secret_phone_sp", 0).getLong("last_req_time_" + str, 0L);
    }

    private static SharedPreferences g() {
        return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ.getBaseContext(), "gateway_guide_change_secret_phone_sp", "common_mmkv_configurations");
    }

    private static String h(String str) {
        return g().getString(str, "");
    }

    private static double i() {
        double parseDouble = Double.parseDouble("90");
        try {
            String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("gateway_guide_change_secret_phone", new byte[0]), StandardCharsets.UTF_8);
            QLog.d("GuideChangePhoneNumHelper", 2, "getUnitedConfigTime config: " + str);
            parseDouble = new JSONObject(str).getDouble("time_cycle");
            QLog.d("GuideChangePhoneNumHelper", 1, "getUnitedConfigTime time:" + parseDouble);
            return parseDouble;
        } catch (Exception e16) {
            QLog.e("GuideChangePhoneNumHelper", 1, "getUnitedConfigTime error: " + e16);
            return parseDouble;
        }
    }

    public static void j(int i3, String str) {
        QLog.e("GuideChangePhoneNumHelper", 1, "handleComparisonFailed, errorCode = " + i3 + " errorMsg = " + str);
        s();
    }

    public static void k(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            r(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            q(str);
        }
        s();
    }

    public static boolean m(String str) {
        int b16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.tencent.mobileqq.login.account.a e16 = com.tencent.mobileqq.login.account.d.f241848a.e(str);
        if (e16 != null && (b16 = e16.b()) != 5 && b16 != 4 && b16 != 7) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public static void n(com.tencent.mobileqq.activity.phone.b bVar) {
        if (f306570a == null) {
            f306570a = new d(bVar);
            try {
                BaseApplication.getContext().registerReceiver(f306570a, new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify"));
            } catch (Exception e16) {
                QLog.e("GuideChangePhoneNumHelper", 1, "registerReceiver error:", e16);
            }
        }
    }

    private static void o() {
        r("");
        q("");
    }

    public static void p(@NonNull AppInterface appInterface) {
        QLog.d("GuideChangePhoneNumHelper", 1, "startGetPhone sendReq");
        com.tencent.mobileqq.gateway.localphone.ecdh.g.m(5, 1, new a(), null);
    }

    private static void q(String str) {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            QLog.e("GuideChangePhoneNumHelper", 1, "uin is empty!");
            return;
        }
        t("change_secret_phone_wording" + account, str);
    }

    private static void r(String str) {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            QLog.e("GuideChangePhoneNumHelper", 1, "uin is empty!");
            return;
        }
        t("change_secret_phone_url" + account, str);
    }

    public static void s() {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            QLog.e("GuideChangePhoneNumHelper", 1, "uin is empty!");
            return;
        }
        MobileQQ.sMobileQQ.getSharedPreferences("gateway_guide_change_secret_phone_sp", 0).edit().putLong("last_req_time_" + account, System.currentTimeMillis()).commit();
    }

    private static void t(String str, String str2) {
        g().edit().putString(str, str2).commit();
    }

    public static boolean u(@NonNull AppInterface appInterface) {
        String account = appInterface.getAccount();
        boolean z16 = false;
        if (TextUtils.isEmpty(account)) {
            QLog.e("GuideChangePhoneNumHelper", 1, "uin is empty!");
            return false;
        }
        if (m(account)) {
            QLog.i("GuideChangePhoneNumHelper", 1, "shouldGuideChangePhoneNum login with phone");
            return false;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("gateway_guide_change_secret_phone", false)) {
            QLog.d("GuideChangePhoneNumHelper", 1, "shouldGuideChangePhoneNum unitedConfig switch is off");
            return false;
        }
        double i3 = i();
        long f16 = f(account);
        if (f16 == 0 || System.currentTimeMillis() - f16 > 24.0d * i3 * 3600.0d * 1000.0d) {
            z16 = true;
        }
        QLog.d("GuideChangePhoneNumHelper", 1, "lastReqTime = " + f16 + ", time_cycle = " + i3 + " timeInValid: " + z16);
        return z16;
    }

    public static boolean v() {
        String account = ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getAccount();
        if (TextUtils.isEmpty(account)) {
            QLog.e("GuideChangePhoneNumHelper", 1, "uin is empty!");
            return false;
        }
        if (m(account)) {
            QLog.d("GuideChangePhoneNumHelper", 2, "shouldShowGuideDialog login with phone!");
            return false;
        }
        String e16 = e();
        String d16 = d();
        QLog.d("GuideChangePhoneNumHelper", 2, "shouldShowGuideDialog secretUll : " + e16 + " phoneWording: " + d16);
        if (!TextUtils.isEmpty(e16) && !TextUtils.isEmpty(d16)) {
            return true;
        }
        return false;
    }

    public static void w(AppRuntime appRuntime, Context context) {
        String e16 = e();
        String d16 = d();
        int indexOf = d16.indexOf(63);
        if (indexOf <= 0) {
            QLog.e("GuideChangePhoneNumHelper", 1, "Invalid Wording!");
            o();
            return;
        }
        com.tencent.mobileqq.activity.phone.b bVar = new com.tencent.mobileqq.activity.phone.b(context, appRuntime);
        bVar.W(d16.substring(0, indexOf), d16.substring(indexOf + 1));
        bVar.U(new b(appRuntime, bVar), new c(appRuntime, e16, context, bVar));
        bVar.show();
        bVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.util.al
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                am.x();
            }
        });
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x() {
        if (f306570a != null) {
            try {
                QLog.i("GuideChangePhoneNumHelper", 1, "unregisterBindFinishReceiver");
                BaseApplication.getContext().unregisterReceiver(f306570a);
            } catch (Exception e16) {
                QLog.e("GuideChangePhoneNumHelper", 1, "unregisterReceiver error:", e16);
            }
            f306570a = null;
        }
    }
}
