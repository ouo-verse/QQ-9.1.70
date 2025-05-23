package com.tencent.mobileqq.minorsmode;

import android.app.Activity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.r;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J0\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/c;", "", "", "oldMode", "targetType", "Lmqq/app/AppRuntime;", "app", "", "from", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "targetMode", "finalBPref", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f247122a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/minorsmode/c$a", "Lcom/tencent/mobileqq/theme/DarkModeManager$e;", "", "onConfirm", "onCancel", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements DarkModeManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f247123a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f247124b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppRuntime f247125c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f247126d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f247127e;

        a(int i3, int i16, AppRuntime appRuntime, String str, Activity activity) {
            this.f247123a = i3;
            this.f247124b = i16;
            this.f247125c = appRuntime;
            this.f247126d = str;
            this.f247127e = activity;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            c.a(this.f247123a, this.f247124b, this.f247125c, this.f247126d, this.f247127e);
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            c.a(this.f247123a, this.f247124b, this.f247125c, this.f247126d, this.f247127e);
        }
    }

    c() {
    }

    @JvmStatic
    public static final void a(int targetMode, int finalBPref, AppRuntime app, String from, Activity activity) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(activity, "activity");
        l lVar = (l) app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        if (lVar == null) {
            QLog.i("ModeChoiceUtil", 1, "from " + from + " manager is null, changeMode targetMode: " + targetMode + ", finalBPref: " + finalBPref + ", bSwitchElsePref: true failed!!! stack: " + QLog.getStackTraceString(new Throwable()));
            return;
        }
        lVar.f(activity, targetMode, finalBPref, true);
    }

    @JvmStatic
    public static final void b(int oldMode, int targetType, AppRuntime app, String from, Activity activity) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z16 = targetType == 1;
        ThemeUtil.isNowThemeIsNight(app, false, null);
        int e16 = r.e(app, z16);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("elder_to_simple_mode_8990_116300199", true) && oldMode == 3 && targetType == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("ModeChoiceUtil", 1, "appRuntime is null, can not update bPref for ModeConstantsKt.MODE_TYPE_ELDER");
            } else {
                String f16 = ElderModeManager.f(peekAppRuntime);
                if (!QQTheme.isThemeSimpleUI(f16)) {
                    QLog.i("ModeChoiceUtil", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType + ", but lastThemeId is not SimpleTheme");
                } else {
                    e16 = Math.max(SimpleUIUtil.getPrefByThemeId(f16), 0);
                    QLog.i("ModeChoiceUtil", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType);
                }
            }
        }
        int i3 = e16;
        if (z16) {
            if (DarkModeManager.w(activity, SimpleUIUtil.getThemeId(i3), new a(targetType, i3, app, from, activity))) {
                return;
            }
            a(targetType, i3, app, from, activity);
            return;
        }
        a(targetType, i3, app, from, activity);
    }
}
