package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static int b() {
        return R.string.f13792086;
    }

    private static String c(Resources resources) {
        return resources.getString(R.string.f225786mk, resources.getString(d()));
    }

    public static int d() {
        return R.string.f201154u2;
    }

    public static int e(AppRuntime appRuntime, boolean z16) {
        int simpleUIPref = SimpleUIUtil.getSimpleUIPref();
        if (z16) {
            if (ThemeUtil.isNowThemeIsNight(appRuntime, false, null)) {
                return SimpleUIUtil.INDEX_OF_SIMPLE_UI_NIGHT;
            }
            if (ThemeUtil.isNowThemeIsNight(appRuntime, false, SimpleUIUtil.getThemeId(simpleUIPref))) {
                return SimpleUIUtil.getSimpleNoNightUIPref();
            }
            return simpleUIPref;
        }
        return simpleUIPref;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(DialogInterface dialogInterface, int i3) {
        if (dialogInterface instanceof QQCustomDialog) {
            ((QQCustomDialog) dialogInterface).setOnDismissListener(null);
        }
    }

    public static void g(AppRuntime appRuntime) {
        SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(appRuntime);
        if (uinThemePreferences.getBoolean("key_simple_show_welcome_back_dialog", false)) {
            uinThemePreferences.edit().putBoolean("key_simple_show_welcome_back_dialog", false).apply();
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.studymode.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    r.f(dialogInterface, i3);
                }
            };
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                return;
            }
            Resources resources = qBaseActivity.getResources();
            DialogUtil.createCustomDialog(qBaseActivity, 230, resources.getString(R.string.f225796ml), c(resources), 0, R.string.vrh, onClickListener, (DialogInterface.OnClickListener) null).show();
        }
    }
}
