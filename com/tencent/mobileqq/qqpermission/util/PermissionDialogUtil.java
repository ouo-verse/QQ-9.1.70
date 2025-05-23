package com.tencent.mobileqq.qqpermission.util;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.az;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.Foreground;

/* loaded from: classes17.dex */
public class PermissionDialogUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PermissionDialogUtil";

    public PermissionDialogUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dialog show(Activity activity, BusinessConfig businessConfig, String str) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.ayn);
        try {
            qQCustomDialog.setContentView(R.layout.f167850e54);
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.setTitle(az.g(QQPermissionConstants.Permission.PERMISSION_TITLE.get(str).intValue()));
            String g16 = az.g(QQPermissionConstants.Permission.PERMISSION_INTRODUCE.get(str).intValue());
            String introductionByScene = PermissionUtil.getIntroductionByScene(businessConfig, str);
            if (introductionByScene != null) {
                g16 = introductionByScene;
            }
            qQCustomDialog.setMessage(g16);
            if (QQTheme.isNowThemeIsNight()) {
                qQCustomDialog.setBackground(R.drawable.lkz);
                qQCustomDialog.setMessageTextColor(R.color.acn);
                qQCustomDialog.setTitleTextColor(R.color.acn);
            } else {
                qQCustomDialog.setBackground(R.drawable.lky);
                qQCustomDialog.setMessageTextColor(R.color.f156931fl);
                qQCustomDialog.setTitleTextColor(R.color.f156931fl);
            }
            Window window = qQCustomDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            attributes.gravity = 48;
            attributes.width = point.x;
            if ((activity instanceof ISystemBarPropertyProvider) && !((ISystemBarPropertyProvider) activity).actNeedImmersive()) {
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
                attributes.y = statusBarHeight;
                QLog.d(TAG, 1, "activity actNeedImmersive is false, set statusBarHeight : " + statusBarHeight);
            }
            if (QQPermissionConstants.Business.SCENE.QQ_AR_OLYMPIC_TORCH.equals(businessConfig.getBusinessScene()) && "V2020A".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                int statusBarHeight2 = ImmersiveUtils.getStatusBarHeight(activity);
                attributes.y = statusBarHeight2;
                QLog.d(TAG, 1, "VIVO QQ_AR_OLYMPIC_TORCH show QQPermission, set statusBarHeight : " + statusBarHeight2);
            }
            window.setAttributes(attributes);
            window.setFlags(1024, 1024);
            window.addFlags(2);
            qQCustomDialog.show();
            QLog.d(TAG, 1, "Permission Dialog show");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Permission Dialog show error ", e16);
        }
        return qQCustomDialog;
    }

    public static Dialog show(BusinessConfig businessConfig, String str) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.e(TAG, 1, "Permission show dialog activity is null");
            return null;
        }
        return show(topActivity, businessConfig, str);
    }
}
