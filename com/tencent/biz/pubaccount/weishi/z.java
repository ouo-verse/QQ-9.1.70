package com.tencent.biz.pubaccount.weishi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.operationh5.WSCommonWebViewFragment;
import com.tencent.biz.pubaccount.weishi.operationh5.WSOperationWebViewFragment;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import cooperation.qzone.QZoneHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class z {
    private static WSRedDotPushMsg b(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        JSONObject optJSONObject;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TrendsTab RedDot Msg : ");
        if (appInfo != null) {
            str = appInfo.buffer.get();
        } else {
            str = "appInfo is null.";
        }
        sb5.append(str);
        com.tencent.biz.pubaccount.weishi.util.x.b("WeishiActivityHelper", sb5.toString());
        if (appInfo == null || TextUtils.isEmpty(appInfo.buffer.get())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
            String optString = jSONObject.optString("_show_mission");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("msg");
            if (optJSONObject2 == null || TextUtils.isEmpty(optString) || (optJSONObject = optJSONObject2.optJSONObject(optString)) == null) {
                return null;
            }
            String optString2 = optJSONObject.optString(QZoneHelper.INTENT_EXTINFO);
            com.tencent.biz.pubaccount.weishi.util.x.b("WeishiActivityHelper", "TrendsTab RedDot extInfoStr : " + optString2);
            return WSRedDotPushMsg.getInstance(optString2);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void c(Activity activity, Intent intent, WSRedDotPushMsg wSRedDotPushMsg) {
        a.b.c(new com.tencent.biz.pubaccount.weishi.verticalvideo.k(activity, "trends", ""));
    }

    private static boolean d(Context context, WSRedDotPushMsg wSRedDotPushMsg, int i3, Intent intent) {
        Object obj;
        com.tencent.biz.pubaccount.weishi.util.x.i("WeishiActivityHelper", "handleRedDotClick scene=" + i3 + ", pushMsgData=" + wSRedDotPushMsg);
        if (wSRedDotPushMsg == null || (obj = wSRedDotPushMsg.mStrategyInfo) == null) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.push.b bVar = (com.tencent.biz.pubaccount.weishi.push.b) obj;
        com.tencent.biz.pubaccount.weishi.push.biz.a a16 = com.tencent.biz.pubaccount.weishi.push.biz.g.a(wSRedDotPushMsg, i3, intent);
        if (a16 != null) {
            return a16.a(context, bVar);
        }
        return false;
    }

    public static void e(Context context, String str, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo, Intent intent) {
        com.tencent.biz.pubaccount.weishi.util.v.b().e();
        if ("1".equals(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().x())) {
            m(context, new q(str, 0, true));
        } else {
            k(context, z16, appInfo, intent);
        }
    }

    public static boolean f(String str) {
        return "from_qq_chat".equals(str) || "from_qq_scheme".equals(str) || "from_operation_h5".equals(str) || "from_float_window".equals(str);
    }

    public static boolean g(Context context, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.util.v.b().f();
        com.tencent.biz.pubaccount.weishi.util.v.b().e();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
        intent.putExtra("fragmentClass", WSOperationWebViewFragment.class);
        intent.putExtra("url", map.get("h5url"));
        intent.putExtra("spid", map.get("spid"));
        intent.putExtra("web_test_id", map.get("web_test_id"));
        intent.putExtra(TuxDialogBundleKey.WEB_URL, map.get("h5url"));
        intent.putExtra("share_scenes_from", map.get("share_scenes_from"));
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        return true;
    }

    public static void i(Context context, String str, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
        intent.putExtra("fragmentClass", WSCommonWebViewFragment.class);
        intent.putExtra("url", str);
        intent.putExtra(IPCConst.KEY_HIDE_TITLE_BAR, z16);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Context context, q qVar, WSRedDotPushMsg wSRedDotPushMsg) {
        ty.g.f437886a.r(wSRedDotPushMsg);
        n(context, qVar, wSRedDotPushMsg);
    }

    private static void k(Context context, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo, Intent intent) {
        WSRedDotPushMsg wSRedDotPushMsg;
        bb.V(appInfo, z16);
        com.tencent.biz.pubaccount.weishi.util.v.b().g();
        com.tencent.biz.pubaccount.weishi.util.x.b("WeishiActivityHelper", "handleTrendsTabClick hasRedDot = " + z16);
        if (z16) {
            wSRedDotPushMsg = b(appInfo);
            WSReportDc00898.z();
        } else {
            wSRedDotPushMsg = null;
        }
        WSReportDc00898.x(wSRedDotPushMsg, z16);
        WSPublicAccReport.getInstance().enterTrendsTabReport(wSRedDotPushMsg, z16);
        if (d(context, wSRedDotPushMsg, 6, intent)) {
            return;
        }
        c((Activity) context, intent, wSRedDotPushMsg);
    }

    public static void l(Context context, q qVar) {
        String b16 = qVar.b();
        com.tencent.biz.pubaccount.weishi.util.x.f("WeishiActivityHelper", "\u5916\u90e8\u8df3\u8f6c\u5fae\u89c6\u516c\u4f17\u53f7 from=" + b16);
        f10.b.f397582a.f(b16);
        if (!f(b16)) {
            com.tencent.biz.pubaccount.weishi.util.v.b().e();
        }
        m(context, qVar);
    }

    private static void m(final Context context, final q qVar) {
        ty.g.f437886a.e(qVar.d(), new ty.a() { // from class: com.tencent.biz.pubaccount.weishi.y
            @Override // ty.a
            public final void a(WSRedDotPushMsg wSRedDotPushMsg) {
                z.j(context, qVar, wSRedDotPushMsg);
            }
        });
    }

    public static void o(Context context, String str, MiniAppLaunchListener miniAppLaunchListener) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, n00.a.c(str), 4006, miniAppLaunchListener);
    }

    public static void h(Context context, String str) {
        i(context, str, false);
    }

    private static void n(Context context, q qVar, WSRedDotPushMsg wSRedDotPushMsg) {
        if (context == null) {
            com.tencent.biz.pubaccount.weishi.util.x.f("WSPushLog", "WeishiActivityHelper handleJumpTargetVideoFeed, context is null.");
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.v.b().f();
        if (TextUtils.equals(qVar.b(), "from_home_page")) {
            WSReportDc00898.A(wSRedDotPushMsg);
            if (d(context, wSRedDotPushMsg, 2, null)) {
                WSPublicAccReport.getInstance().enterPublicAccReport(wSRedDotPushMsg, wSRedDotPushMsg != null ? wSRedDotPushMsg.mStrategyInfo.getType() : 1, qVar.b(), null);
                return;
            }
        }
        if (!f(qVar.b())) {
            Bundle bundle = new Bundle();
            bundle.putString(TuxDialogBundleKey.WEB_URL, qVar.c());
            WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, qVar.b(), bundle);
        }
        WSHomeFragment.di(new l(context, 1, qVar.b()).i(qVar.e()).k(qVar.f()).j(qVar.a()));
    }
}
