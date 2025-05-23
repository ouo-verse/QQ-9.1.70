package com.tencent.mobileqq.activity.aio.intimate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    public static void a(Context context, String str, long j3, com.tencent.mobileqq.activity.aio.intimate.header.h hVar, String str2) {
        String str3;
        if (hVar != null && context != null) {
            String replace = hVar.getBindGameJumpUrl().replace("{touin}", str).replace("{fromuin}", str2).replace("{mutualmark_id}", String.valueOf(j3));
            int i3 = (int) j3;
            if (IntimateHeaderCardUtil.R(i3)) {
                if (w.a(1000L)) {
                    String replace2 = hVar.getNewIntimateJumpUrl().replace("{uin}", str).replace("{id}", String.valueOf(j3));
                    Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
                    intent.putExtra("url", replace2);
                    intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                    intent.putExtra(QQTranslucentBrowserActivity.FLAG_HIDE_FLOAT_BAR, true);
                    intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            if (IntimateHeaderCardUtil.N(i3)) {
                if (f(i3)) {
                    str3 = "0.507";
                } else {
                    str3 = "0.442";
                }
                String str4 = "mqqapi://openhalfscreenweb/?height={height}&url=".replace("{height}", str3) + URLEncoder.encode(replace);
                Intent intent2 = new Intent(context, (Class<?>) JumpActivity.class);
                intent2.setData(Uri.parse(str4));
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                context.startActivity(intent2);
                return;
            }
            if (IntimateHeaderCardUtil.O(i3)) {
                replace = hVar.getBindIntimateJumpUrl().replace("{touin}", str);
            }
            Intent intent3 = new Intent(context, (Class<?>) QQBrowserActivity.class);
            if (!(context instanceof Activity)) {
                intent3.addFlags(268435456);
            }
            context.startActivity(intent3.putExtra("url", replace));
        }
    }

    public static String b(Context context, long j3) {
        if (context != null) {
            if (j3 == 1) {
                return context.getString(R.string.byg);
            }
            if (j3 == 2) {
                return context.getString(R.string.bye);
            }
            if (j3 == 3) {
                return context.getString(R.string.byf);
            }
            if (j3 == 26) {
                return context.getString(R.string.f160981wh);
            }
        }
        return "";
    }

    public static com.tencent.mobileqq.mutualmark.info.c c(QQAppInterface qQAppInterface, String str, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        for (long j3 : com.tencent.mobileqq.mutualmark.g.f252051e) {
            com.tencent.mobileqq.mutualmark.info.c f16 = com.tencent.mobileqq.mutualmark.c.f(qQAppInterface, str, aVar, j3);
            if (f16 != null) {
                return f16;
            }
        }
        return null;
    }

    public static boolean d(IntimateInfo intimateInfo) {
        f61.h hVar;
        List<f61.j> list;
        if (intimateInfo == null || (hVar = intimateInfo.mutualMarkList) == null || (list = hVar.f397927h) == null) {
            return false;
        }
        Iterator<f61.j> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getIsBind()) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(long j3) {
        for (long j16 : com.tencent.mobileqq.mutualmark.g.f252051e) {
            if (j16 == j3) {
                return true;
            }
        }
        return false;
    }

    private static boolean f(int i3) {
        if (i3 != 90 && i3 != 101) {
            return false;
        }
        return true;
    }

    public static void g(Context context, String str, long j3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("IntimateUtil", 1, "jumpBindPage fail, app is null");
            return;
        }
        if (context == null) {
            QLog.e("IntimateUtil", 1, "jumpBindPage fail, context is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("IntimateUtil", 1, "jumpBindPage fail, friendUin is null");
            return;
        }
        com.tencent.mobileqq.activity.aio.intimate.header.h hVar = (com.tencent.mobileqq.activity.aio.intimate.header.h) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
        if (hVar == null) {
            return;
        }
        a(context, str, j3, hVar, peekAppRuntime.getCurrentUin());
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ProfileUtils.openProfileCard(BaseApplication.getContext(), new AllInOne(str, 1));
        } catch (Throwable unused) {
            QLog.e("IntimateUtil", 1, "jump to qq profile card failed!");
        }
    }
}
