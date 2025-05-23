package com.tencent.mobileqq.tvideo.pullqqlive;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.pullqqlive.h;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import org.jetbrains.annotations.NotNull;
import uq3.k;
import uq3.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static int f304752a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f304753b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f304754c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String f304755d = "txvideo://v.qq.com/VideoDetailActivity?from=QQGZH001";

    /* renamed from: e, reason: collision with root package name */
    private static String f304756e = "https://m.v.qq.com/activity/downapp_activity.html?channel=2000026&not_auto_open=1";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16);
    }

    public static void c() {
        int i3 = f304752a;
        if (i3 >= 0) {
            f304752a = i3 + 1;
        }
    }

    public static boolean d() {
        if (!n.c(k.a().f("tvideo_qqlive_jump_time", 0L), System.currentTimeMillis())) {
            return true;
        }
        return false;
    }

    public static int e() {
        if (f304752a == -1) {
            f304752a = iy2.a.b("exp_ug_qqoa_laduan20230704", "auto_jump_index") - 1;
        }
        return f304752a;
    }

    public static boolean f() {
        return f304754c;
    }

    public static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tvideo_detail_entry_enable", false);
    }

    public static boolean h(Context context) {
        boolean isAppInstalled = PackageUtil.isAppInstalled(context, "com.tencent.qqlive");
        QLog.i("TVideoPullQQliveUtils", 1, " hasQQLive = " + isAppInstalled);
        return isAppInstalled;
    }

    public static void i(@NotNull final a aVar) {
        if (!g()) {
            aVar.a(false);
            return;
        }
        Boolean bool = f304753b;
        if (bool == null) {
            new TVideoPullUpAppViewModel().L1(new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.f
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    h.l(h.a.this, baseRequest, z16, j3, str, (TVideoPullUpAppProto$GetPullUpAppEntranceResponse) obj);
                }
            });
        } else {
            aVar.a(bool.booleanValue());
        }
    }

    private static void j(Context context) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", f304756e);
        intent.putExtra("Configuration", 1);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(TVideoPullUpAppProto$GetPullUpAppEntranceResponse tVideoPullUpAppProto$GetPullUpAppEntranceResponse, a aVar) {
        if (tVideoPullUpAppProto$GetPullUpAppEntranceResponse != null) {
            f304753b = Boolean.valueOf(tVideoPullUpAppProto$GetPullUpAppEntranceResponse.data.isShown.get());
            f304755d = tVideoPullUpAppProto$GetPullUpAppEntranceResponse.data.pullUpAppLink.get();
            f304756e = tVideoPullUpAppProto$GetPullUpAppEntranceResponse.data.downloadPageLink.get();
            f304754c = tVideoPullUpAppProto$GetPullUpAppEntranceResponse.data.isAutoPull.get();
            aVar.a(f304753b.booleanValue());
            return;
        }
        aVar.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(final a aVar, BaseRequest baseRequest, boolean z16, long j3, String str, final TVideoPullUpAppProto$GetPullUpAppEntranceResponse tVideoPullUpAppProto$GetPullUpAppEntranceResponse) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.g
            @Override // java.lang.Runnable
            public final void run() {
                h.k(TVideoPullUpAppProto$GetPullUpAppEntranceResponse.this, aVar);
            }
        });
    }

    public static void m(Context context, String str) {
        if (h(context)) {
            q(context, str);
        } else {
            j(context);
        }
    }

    public static void n() {
        f304752a = -1;
        f304753b = null;
    }

    public static void o() {
        k.a().n("tvideo_qqlive_jump_time", System.currentTimeMillis());
    }

    public static void p(Context context, String str) {
        if (!h(context)) {
            j(context);
            return;
        }
        try {
            context.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str)));
        } catch (Exception e16) {
            QLog.e("TVideoPullQQliveUtils", 1, " startActionUrl\uff0c has Exception action=" + str, e16);
        }
    }

    public static void q(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "txvideo://v.qq.com/HomeActivity?from=QQGZH001";
        } else {
            str2 = f304755d + "&vid=" + str + "&skipStart=" + (w20.a.j().b() / 1000);
        }
        try {
            context.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str2)));
        } catch (Exception e16) {
            QLog.e("TVideoPullQQliveUtils", 1, " startQQLiveApp\uff0c has Exception", e16);
        }
    }
}
