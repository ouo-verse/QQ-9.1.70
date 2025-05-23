package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f182347a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f182348b;

    public static boolean a() {
        if (f182347a == 1) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        QLog.i("TabCacheManager", 1, "firstSwitchToGuild uin=" + StringUtil.getSimpleUinForPrint(str) + ", sGetTabListResp=" + f182348b + "\uff0c sOnResumeCount=" + f182347a);
        if (!a()) {
            return false;
        }
        return d(context, str);
    }

    public static boolean c(Context context, String str) {
        QLog.i("TabCacheManager", 1, "switchToGuild uin=" + StringUtil.getSimpleUinForPrint(str) + ", sGetTabListResp=" + f182348b);
        if (f182348b) {
            if (TabDataHelper.getTabInit(context, str) == 2) {
                return true;
            }
            return false;
        }
        return d(context, str);
    }

    private static boolean d(Context context, String str) {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.i("TabCacheManager", 1, "isSwitchToGuildByLocal StudyMode=true");
            return false;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            QLog.i("TabCacheManager", 1, "isSwitchToGuildByLocal elderMode=true");
            return false;
        }
        if (TabDataHelper.getRealTabInit(context, str) != 2) {
            return false;
        }
        return true;
    }

    public static void e() {
        f182348b = false;
        QLog.e("TabCacheManager", 1, "onAccountChanged uin=" + StringUtil.getSimpleUinForPrint(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()));
    }

    public static void f(int i3, int i16) {
        QLog.e("TabCacheManager", 1, "onGetTabListResponse initTab=" + i3 + ", realInitTab=" + i16 + ", uin=" + StringUtil.getSimpleUinForPrint(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()));
        f182348b = true;
    }

    public static void g() {
        f182348b = false;
        QLog.e("TabCacheManager", 1, "onLogout uin=" + StringUtil.getSimpleUinForPrint(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()));
    }

    public static void h() {
        f182347a++;
        QLog.e("TabCacheManager", 1, "onResume sOnResumeCount=" + f182347a);
    }
}
