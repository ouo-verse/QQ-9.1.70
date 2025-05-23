package p62;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqecommerce.biz.webview.IECWebViewProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomProxyActivity;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {
    public static boolean c(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str, i3, miniAppLaunchListener);
    }

    public static Integer f(Context context, String str, String str2, String str3) {
        boolean z16 = true;
        QLog.d("RIJJumpUtils", 1, "jumToUrl: " + str);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith("mqqapi:")) {
            try {
                ax c16 = bi.c(b.b(), context, str);
                if (c16 == null || !c16.b()) {
                    z16 = false;
                }
                if (z16) {
                    return 9;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("RIJJumpUtils", 2, "jumpToUrl failed for appInterface is null, url:" + str + ",error:" + th5.getMessage());
                }
            }
        }
        if (!str.startsWith("kandianapi:") && !str.startsWith("rijvideo:")) {
            return h(context, str);
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        intent.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        try {
            context.startActivity(intent);
            return 15;
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.d("RIJJumpUtils", 2, "jumpToUrl failed for appInterface is null, url:" + str + ",error:" + th6.getMessage());
            }
            return -1;
        }
    }

    public static Integer h(Context context, String str) {
        QLog.d("RIJJumpUtils", 1, "jumToWeb: " + str);
        if (((IQQSearchApi) QRoute.api(IQQSearchApi.class)).isKDSearchUrl(str)) {
            d(context, ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).getKDSearchKeyword(str), str);
            return 12;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("big_brother_source_key", a(0));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("url", str);
            context.startActivity(intent);
        }
        return 11;
    }

    public static Integer b(Context context, String str, Bundle bundle) {
        if (context != null && str != null) {
            if ((context instanceof BasePluginActivity) && (context = ((BasePluginActivity) context).getOutActivity()) == null) {
                QLog.e("RIJJumpUtils", 1, "jumpTo return by basePlugin context null");
                return -1;
            }
            boolean z16 = str.startsWith("http://clientui.3g.qq.com/mqqapi/") || str.startsWith("http://clientui.3g.qq.com/mqq/") || str.startsWith("http://qm.qq.com/cgi-bin/") || str.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard");
            if (str.startsWith("https://m.gamefeeds.qq.com/live.html?")) {
                LiveRoomProxyActivity.open((Activity) context, str, "kandian feed click");
                QLog.d("RIJJumpUtils", 1, "jumpTo return by LiveRoomProxyActivity open");
                return 0;
            }
            if (!z16 && (str.startsWith("http://") || str.startsWith("https://"))) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", str);
                bundle2.putBoolean("hide_operation_bar", true);
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                if (bundle != null && bundle.getBoolean("ecommerce_web")) {
                    intent = new Intent(context, (Class<?>) ReadInJoyArticleDetailActivity.class);
                    bundle2.putAll(bundle);
                }
                if (str.contains("&ecwebview_type")) {
                    intent = new Intent(context, ((IECWebViewProvider) QRoute.api(IECWebViewProvider.class)).getWebViewActivity());
                    bundle2.putAll(bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("RIJJumpUtils", 2, "jumpTo: jump ECWebViewActivity");
                    }
                }
                intent.putExtra("big_brother_source_key", a(0));
                intent.putExtras(bundle2);
                intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
                if (bundle != null) {
                    intent.putExtras(bundle);
                    if (bundle.containsKey("requestCode") && (context instanceof Activity)) {
                        ((Activity) context).startActivityForResult(intent, bundle.getInt("requestCode", -1));
                        QLog.d("RIJJumpUtils", 1, "jumpTo return by WEBVIEW_LANDINGPAGE 1");
                        return 11;
                    }
                }
                context.startActivity(intent);
                QLog.d("RIJJumpUtils", 1, "jumpTo return by WEBVIEW_LANDINGPAGE 2");
                return 11;
            }
            Intent intent2 = new Intent(context, (Class<?>) JumpActivity.class);
            Uri parse = Uri.parse(str);
            intent2.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent2.putExtra("big_brother_source_key", a(0));
            intent2.setData(parse);
            context.startActivity(intent2);
            QLog.d("RIJJumpUtils", 1, "jumpTo return by UNKNOWN");
            return 0;
        }
        QLog.e("RIJJumpUtils", 1, "jumpTo return by context or schema null");
        return -1;
    }

    public static Integer e(Context context, String str) {
        return f(context, str, null, null);
    }

    public static String a(int i3) {
        if (i3 != 40677) {
            return "biz_src_feeds_kandian";
        }
        return "biz_src_gzh_weishi";
    }

    public static void d(Context context, String str, String str2) {
    }

    public static void g(Context context, String str, String str2, String str3) {
    }
}
