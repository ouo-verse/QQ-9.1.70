package com.tencent.mobileqq.loverzone;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(String str, String str2, String str3, String str4) {
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", str, str2, str3, str4));
    }

    public static void b(QQAppInterface qQAppInterface, Context context, int i3, String str) {
        c(qQAppInterface, context, i3, str, "2");
    }

    public static void c(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2) {
        d(qQAppInterface, context, i3, str, str2, null);
    }

    public static void d(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SWEET_MINI_APP, QzoneConfig.SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL, QzoneConfig.DEFAULT_SWEET_MAIN_PAGE_JUMP_URL);
        }
        e(qQAppInterface, context, i3, str3);
        a(str, str2, "2", LpReportInfo_dc03950.getReportUserType(qQAppInterface));
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("goToLoverZone, url: %s", str3));
        }
    }

    private static void e(QQAppInterface qQAppInterface, Context context, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str, i3, null);
                return;
            }
            if (str.startsWith("mqqapi://") && qQAppInterface != null) {
                ax c16 = bi.c(qQAppInterface, context, str);
                if (c16 != null) {
                    c16.b();
                    return;
                }
                return;
            }
            if (qQAppInterface != null) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str.replace("{hostuin}", qQAppInterface.getCurrentAccountUin()));
                intent.putExtra("injectrecommend", true);
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, true);
                intent.putExtra(QQBrowserActivity.IS_WRAP_CONTENT, true);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                context.startActivity(intent);
            }
        }
    }
}
