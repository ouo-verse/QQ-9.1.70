package com.tencent.mobileqq.qqlive.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFolderScreenUtil {
    static IPatchRedirector $redirector_ = null;
    private static final float RATIO_MIN_SCREEN = 0.71f;
    private static final String TAG = "FolderScreenUtil";

    public QQLiveFolderScreenUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isFolderScreenOpenMode(Context context) {
        if (context == null) {
            return false;
        }
        return isFolderScreenOpenModeByWH(context, ScreenUtils.getScreenWidth(context), ScreenUtils.getScreenHeight(context));
    }

    public static boolean isFolderScreenOpenModeByWH(Context context, int i3, int i16) {
        if (context == null || i3 == 0 || i16 == 0) {
            return false;
        }
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        if (PadUtil.a(BaseApplication.getContext()) != DeviceType.FOLD) {
            return false;
        }
        double d16 = i3 / i16;
        iAegisLogApi.i(TAG, 1, "isFolderScreenOpenModeByWH:" + d16 + "|configRatio:0.7099999785423279|maxRatio1.408450746791654__disPlayWidth| disPlayHeight:" + i3 + "|" + i16);
        if (d16 <= 0.7099999785423279d || d16 >= 1.408450746791654d) {
            return false;
        }
        return true;
    }

    public static boolean isFolderScreenOpenModeByWindow(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return isFolderScreenOpenModeByWH(context, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
