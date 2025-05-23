package com.tencent.mobileqq.activity.qqsettingme.utils;

import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.bean.g;
import com.tencent.mobileqq.activity.qqsettingme.bean.q;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f185028a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f185028a = 0;
        }
    }

    public static int a() {
        if (BaseApplication.getContext() == null) {
            return 0;
        }
        int realHeight = (int) ((ScreenUtil.getRealHeight(r0) / 7) * 4 * 0.365d);
        f185028a = realHeight;
        return realHeight;
    }

    public static int b() {
        if (BaseApplication.getContext() == null) {
            return 0;
        }
        if (f185028a == 0) {
            f185028a = (int) ((ScreenUtil.getRealHeight(r0) / 7) * 4 * 0.365d);
        }
        return f185028a;
    }

    public static int c(String str) {
        QQSettingMeConstant.OpenPageType openPageType = QQSettingMeConstant.OpenPageType.H5_TYPE;
        if (((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).isCanOpenHippy(QQSettingMeConstant.f184664a.get(str))) {
            openPageType = QQSettingMeConstant.OpenPageType.HIPPY_TYPE;
        }
        return openPageType.ordinal();
    }

    public static CharSequence d(String str, CharSequence charSequence) {
        if (!QQTheme.isNowSimpleUI()) {
            return charSequence;
        }
        return a.a(str, charSequence);
    }

    public static boolean e(g gVar) {
        if (((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).isBigVipClub(gVar.f184893b.nameplateVipType) || ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).isSuperVip(gVar.f184893b.nameplateVipType)) {
            return true;
        }
        if (!gVar.f184900i) {
            if (gVar.f184898g == ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getQQBigMemberId() && gVar.f184897f && (gVar.f184905n >> 8) == 3) {
                return true;
            }
            return gVar.f184895d;
        }
        return false;
    }

    public static boolean f(q qVar) {
        if (qVar == null) {
            return false;
        }
        return g(qVar.f184952c, qVar.f184956g, qVar.f184957h);
    }

    public static boolean g(String str, int i3, String str2) {
        boolean z16;
        if (str != null && str.startsWith("http")) {
            if (i3 != 1 && i3 != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 || str2 != null) {
                return true;
            }
            QLog.e("QQSettingMeUtils", 1, "isZplanBubbleBeanValid ivalid. type: " + i3 + ", scheme: null");
            return false;
        }
        QLog.e("QQSettingMeUtils", 1, "isZplanBubbleBeanValid invalid. bgUrl: " + str);
        return false;
    }

    public static boolean h(QQSettingMeBizBean qQSettingMeBizBean) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (qQSettingMeBizBean == null) {
            return true;
        }
        if (!SimpleUIUtil.getSimpleUISwitch() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !qQSettingMeBizBean.u()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (SimpleUIUtil.getSimpleUISwitch() && !qQSettingMeBizBean.s()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !qQSettingMeBizBean.v()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return true;
        }
        if (SimpleUIUtil.isNowElderMode() && !qQSettingMeBizBean.t()) {
            return true;
        }
        return false;
    }
}
