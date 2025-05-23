package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bz {
    public static Size a(int i3, int i16) {
        if (i16 > 0 && i3 > 0) {
            Size qFunctionZoneSize = QCircleHostGlobalInfo.getQFunctionZoneSize();
            if (qFunctionZoneSize == null) {
                QLog.e("QFSPadUtils", 1, "[adjustSizeInPad] targetSize is null, coverH: " + i16 + ", coverW: " + i3);
                qFunctionZoneSize = new Size(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
            }
            return c(i3, i16, qFunctionZoneSize);
        }
        QLog.e("QFSPadUtils", 1, "[adjustSizeInPad] coverH: " + i16 + ", coverW: " + i3);
        return new Size(i3, i16);
    }

    public static Size b(int i3, int i16) {
        if (i16 > 0 && i3 > 0) {
            return c(i3, i16, new Size(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight()));
        }
        QLog.e("QFSPadUtils", 1, "[adjustSizeInPad] coverH: " + i16 + ", coverW: " + i3);
        return new Size(i3, i16);
    }

    private static Size c(int i3, int i16, Size size) {
        int i17;
        int i18;
        int width = size.getWidth();
        Application application = RFWApplication.getApplication();
        int height = (size.getHeight() - DisplayUtil.dip2px(application, 56.0f)) - ImmersiveUtils.getStatusBarHeight(application);
        float f16 = i16;
        float f17 = i3;
        float f18 = f16 / f17;
        float f19 = height;
        float f26 = width;
        float f27 = f19 / f26;
        if (f18 > f27) {
            i18 = (int) (f19 * (f17 / f16));
            i17 = height;
        } else {
            i17 = (int) (f26 * f18);
            i18 = width;
        }
        QLog.d("QFSPadUtils", 1, "[adjustSizeInPad] coverScale: " + f18 + ", containerScale: " + f27 + ", coverW: " + i3 + ", coverH: " + i16 + ", containerW: " + width + ", containerH: " + height + ", targetW: " + i18 + ", targetH: " + i17);
        return new Size(i18, i17);
    }

    public static void d(View view, Size size) {
        if (k() && view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = size.getWidth();
            layoutParams.height = size.getHeight();
            view.setLayoutParams(layoutParams);
        }
    }

    private static boolean e() {
        if (uq3.c.X0("qqcircle", "secondary_key_enable_allow_landscape", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fold_screen_mode", true) && l() && p()) {
            return true;
        }
        return false;
    }

    private static boolean g() {
        if (uq3.c.X0("qqcircle", "secondary_key_enable_pad_split_view_mode", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static HashMap<String, String> h(Activity activity) {
        QCircleFolderBean qCircleFolderBean;
        if (activity == null || activity.getIntent() == null || !(activity.getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean) || (qCircleFolderBean = (QCircleFolderBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean")) == null) {
            return null;
        }
        return qCircleFolderBean.getSchemeAttrs();
    }

    public static int i(Context context) {
        if (!r()) {
            return Math.min(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
        }
        if (s(context)) {
            return j();
        }
        return DisplayUtil.getScreenWidth();
    }

    public static int j() {
        int i3;
        int screenWidth = DisplayUtil.getScreenWidth();
        Size qFunctionZoneSize = QCircleHostGlobalInfo.getQFunctionZoneSize();
        if (qFunctionZoneSize != null) {
            i3 = qFunctionZoneSize.getWidth();
        } else {
            i3 = 0;
        }
        if (p() && i3 != 0) {
            return i3;
        }
        return screenWidth;
    }

    public static boolean k() {
        if (HostAppSettingUtil.isAllowLandscape() && !m() && e()) {
            return true;
        }
        return false;
    }

    public static boolean l() {
        if (PadUtil.a(RFWApplication.getApplication()) == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        if (PadUtil.a(RFWApplication.getApplication()) == DeviceType.FOLD && !TransitionHelper.isFolderScreenOpenMode(RFWApplication.getApplication())) {
            return true;
        }
        return false;
    }

    public static boolean n(Activity activity) {
        boolean isInMultiWindowMode;
        if (activity != null && Build.VERSION.SDK_INT >= 30) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (!isInMultiWindowMode) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean o() {
        if (QCircleApplication.getAPP().getApplicationContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean p() {
        if (QCircleHostGlobalInfo.isNowFlatState() && k()) {
            return true;
        }
        return false;
    }

    public static boolean q(Activity activity) {
        HashMap<String, String> h16 = h(activity);
        if (h16 != null && String.valueOf(1004).equals(h16.get("key_jump_from"))) {
            return true;
        }
        return false;
    }

    public static boolean r() {
        DeviceType a16 = PadUtil.a(RFWApplication.getApplication());
        if (a16 != DeviceType.FOLD && a16 != DeviceType.TABLET) {
            return false;
        }
        return true;
    }

    public static boolean s(Context context) {
        if (!(context instanceof Activity)) {
            QLog.e("QFSPadUtils", 1, "context is not Activity");
            return false;
        }
        Activity activity = (Activity) context;
        if (QCircleHostGlobalInfo.getQFunctionZoneSize() == null || !q(activity) || !p()) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        if (QCircleHostGlobalInfo.isSplitViewMode() && g()) {
            return true;
        }
        return false;
    }

    public static void u(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(activity);
            if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB.equals(qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance"))) {
                QLog.d("QFSPadUtils", 1, "[orientationAdapt] is start from tab mode. ");
                return;
            }
            int i3 = -1;
            if (activity.getIntent() != null && activity.getIntent().getIntExtra("orientation_type_flag", -1) != -1) {
                return;
            }
            if (!k()) {
                i3 = 1;
            }
            activity.setRequestedOrientation(i3);
        } catch (Exception e16) {
            QLog.e("QFSPadUtils", 1, "[orientationAdapt] " + e16);
        }
    }
}
