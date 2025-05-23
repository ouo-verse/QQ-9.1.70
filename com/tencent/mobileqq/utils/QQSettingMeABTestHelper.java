package com.tencent.mobileqq.utils;

import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQSettingMeABTestHelper {

    /* renamed from: c, reason: collision with root package name */
    private static final a f307219c = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f307220a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f307221b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        QQSettingMeABTestHelper f307222a = new QQSettingMeABTestHelper();

        a() {
        }
    }

    public static boolean c() {
        if (QQTheme.isNowSimpleUI()) {
            QLog.i("QQSettingMeABTestHelper", 1, "isV9 simple");
            return false;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.i("QQSettingMeABTestHelper", 1, "isV9 study");
            return false;
        }
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            DeviceType a16 = PadUtil.a(context);
            if (a16 == DeviceType.TABLET) {
                QLog.i("QQSettingMeABTestHelper", 1, "isV9 tablet device");
                return false;
            }
            if (a16 == DeviceType.FOLD) {
                QLog.i("QQSettingMeABTestHelper", 1, "isV9 fold device");
                return false;
            }
            if (AppSetting.o(context)) {
                QLog.i("QQSettingMeABTestHelper", 1, "isV9 isAllowLandscape");
                return false;
            }
        } else {
            QLog.e("QQSettingMeABTestHelper", 1, "isV9 context is null");
        }
        String string = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo().getString("themeId");
        QLog.i("QQSettingMeABTestHelper", 2, "isV9 themeId: " + string);
        if (!"1000".equals(string) && !"1103".equals(string) && !de.f307628a.b()) {
            return false;
        }
        boolean g16 = e().g();
        QLog.i("QQSettingMeABTestHelper", 2, "isV9 abTest: " + g16);
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int... iArr) {
        int drawerType = ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getDrawerType();
        for (int i3 : iArr) {
            if (drawerType == i3) {
                return true;
            }
        }
        return false;
    }

    public static QQSettingMeABTestHelper e() {
        return f307219c.f307222a;
    }

    public boolean f() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.QQSettingMeABTestHelper.1
            @Override // java.lang.Runnable
            public void run() {
                QQSettingMeABTestHelper qQSettingMeABTestHelper = QQSettingMeABTestHelper.this;
                qQSettingMeABTestHelper.f307220a = qQSettingMeABTestHelper.d(3);
            }
        }, 16, null, false);
        return this.f307220a;
    }

    public boolean g() {
        boolean d16 = d(1, 2, 3);
        QLog.i("QQSettingMeABTestHelper", 1, "isV9ExpGroup: " + d16);
        return d16;
    }

    public boolean h() {
        boolean d16 = d(2, 3);
        if (this.f307221b != d16) {
            this.f307221b = d16;
            QLog.i("QQSettingMeABTestHelper", 1, "isZPlanExpGroup: " + this.f307221b);
        }
        return this.f307221b;
    }

    QQSettingMeABTestHelper() {
        this.f307220a = false;
        this.f307221b = false;
    }
}
