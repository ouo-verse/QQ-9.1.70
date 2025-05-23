package com.tencent.mobileqq.qqlive.base.webview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.webview.HalfTranslucentBrowserActivity;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.e;
import com.tencent.timi.game.liveroom.impl.room.pendant.util.a;
import com.tencent.timi.game.web.business.api.CustomHalfBrowserFragment;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f271157a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f271157a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private static float a(Activity activity, float f16, float f17, float f18) {
        if (activity == null) {
            f271157a.i("QQLiveHalfWebHelper", 1, "forceScreenPortraitAndAdjustHeight activity is null");
            return f17;
        }
        if (!b()) {
            f271157a.i("QQLiveHalfWebHelper", 1, "Activity not in tool process, activity:" + activity);
            return f17;
        }
        if (activity.getRequestedOrientation() == 0 || 8 == activity.getRequestedOrientation()) {
            activity.setRequestedOrientation(1);
            float h16 = (int) (x.h(activity, x.f(activity).f185860a) * f18);
            if (f16 >= h16) {
                f16 = h16;
            }
            return f16;
        }
        return f17;
    }

    private static boolean b() {
        return "com.tencent.mobileqq:tool".equals(MobileQQ.sMobileQQ.getQQProcessName());
    }

    public static void c(Context context, String str, Bundle bundle) {
        d(context, str, bundle, null);
    }

    public static void d(Context context, String str, Bundle bundle, TouchWebView touchWebView) {
        e(context, str, bundle, touchWebView, null);
    }

    public static void e(Context context, String str, Bundle bundle, TouchWebView touchWebView, Drawable drawable) {
        f(context, str, "", bundle, touchWebView, drawable, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Context context, String str, String str2, Bundle bundle, TouchWebView touchWebView, Drawable drawable, boolean z16, com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar) {
        Bundle bundle2;
        Drawable drawable2;
        QQLiveWebShareActivity qQLiveWebShareActivity;
        if (bundle == null) {
            bundle2 = new Bundle();
            QLog.i("QQLiveHalfWebHelper", 1, "bundle=null");
        } else {
            bundle2 = bundle;
        }
        if (!bundle2.containsKey("halfFragmentClass")) {
            bundle2.putSerializable("halfFragmentClass", CustomHalfBrowserFragment.class);
        }
        float f16 = bundle2.getInt("height_web_dialog", x.h(context, x.f(context).f185861b));
        boolean z17 = bundle2.getBoolean("transparent_web_bg", false);
        boolean z18 = bundle2.getBoolean("add_to_queue", false);
        String qQLiveAppId = QQLiveSDKConfigHelper.getQQLiveAppId();
        a.C9947a a16 = com.tencent.timi.game.liveroom.impl.room.pendant.util.a.a(str);
        Map<String, String> map = a16.f378190b;
        String str3 = "";
        float f17 = 1.0f;
        if (map != null) {
            if (map.get("height") != null) {
                int h16 = x.h(context, x.f(context).f185861b);
                int h17 = x.h(context, x.f(context).f185860a);
                try {
                    f17 = Float.parseFloat(a16.f378190b.get("height"));
                } catch (Exception unused) {
                    QLog.e("QQLiveHalfWebHelper", 1, "parseFloat error");
                }
                if (h16 <= h17) {
                    h16 = h17;
                }
                f16 = h16 * f17;
            }
            if (a16.f378190b.get("bgColor") != null) {
                str3 = a16.f378190b.get("bgColor");
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        drawable2 = new ColorDrawable(Color.parseColor("#" + str3));
                    } catch (Exception unused2) {
                        QLog.e("QQLiveHalfWebHelper", 1, "openCustomWebView, parse bgColor error");
                    }
                    QLog.i("QQLiveHalfWebHelper", 1, "url=" + str + " heightDp(dp)=" + f16 + ",appid=" + qQLiveAppId + ", colorStr=" + str3);
                    if (!(context instanceof Activity)) {
                        Activity activity = (Activity) context;
                        if (activity instanceof QQLiveWebShareActivity) {
                            qQLiveWebShareActivity = (QQLiveWebShareActivity) activity;
                            qQLiveWebShareActivity.I2(str);
                        } else {
                            qQLiveWebShareActivity = null;
                        }
                        TouchWebView j3 = e.j(z18, activity, ViewUtils.dip2px(a(activity, f16, f16, f17)), true, drawable2, z17, str2, com.tencent.qqlive.common.webview.a.a(str, "qqlivestream_sdk_app_id=" + qQLiveAppId), touchWebView, z16, aVar);
                        if (qQLiveWebShareActivity != null) {
                            qQLiveWebShareActivity.H2(j3);
                            return;
                        }
                        return;
                    }
                    Activity activity2 = QBaseActivity.sTopActivity;
                    if (activity2 == null) {
                        activity2 = Foreground.getTopActivity();
                    }
                    HalfTranslucentBrowserActivity.W2(context, str, bundle2, a(activity2, f16, f16, f17), bundle2.getInt("bg_color_id", R.color.ajr), R.drawable.f161950l22, qQLiveAppId);
                    return;
                }
            }
        }
        drawable2 = drawable;
        QLog.i("QQLiveHalfWebHelper", 1, "url=" + str + " heightDp(dp)=" + f16 + ",appid=" + qQLiveAppId + ", colorStr=" + str3);
        if (!(context instanceof Activity)) {
        }
    }

    public static void g(Activity activity, Drawable drawable, String str, String str2, Bundle bundle) {
        f(activity, str2, str, bundle, null, drawable, true, null);
    }
}
