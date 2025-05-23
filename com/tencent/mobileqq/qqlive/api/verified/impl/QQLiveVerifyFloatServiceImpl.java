package com.tencent.mobileqq.qqlive.api.verified.impl;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyFloatService;
import com.tencent.mobileqq.qqlive.verified.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gh2.d;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveVerifyFloatServiceImpl implements IQQLiveVerifyFloatService {
    static IPatchRedirector $redirector_ = null;
    private static final int FLOAT_SIZE = 71;
    private static final String TAG = "QQLiveVerifyFloatServiceImpl";
    private View floatView;

    public QQLiveVerifyFloatServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyFloatService
    public boolean checkFloatingBallPermission(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ)) {
            QLog.d(TAG, 1, "the floating ball permission is granted");
            return true;
        }
        QLog.i(TAG, 1, "show the permission dialog");
        if (activity != null) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(activity, R.string.f199884qm, R.string.f199874ql);
            return false;
        }
        QLog.i(TAG, 1, "activity is null");
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyFloatService
    public void hideFloatingBall(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            QLog.e(TAG, 1, "hideFloatingBall context is null");
            return;
        }
        if (this.floatView == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hideFloatingBall floatView is null!");
            }
        } else {
            this.floatView = null;
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(a.CLASS_NAME);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyFloatService
    public void showFloatingBall(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            QLog.e(TAG, 1, "showFloatingBall activity is null");
            return;
        }
        if (this.floatView != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showFloatingBall floatView is null!");
                return;
            }
            return;
        }
        int dip2px = ViewUtils.dip2px(71.0f);
        FloatingScreenParams build = new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCanMove(true).setCanZoom(false).setCustomSize(dip2px, dip2px).build();
        this.floatView = LayoutInflater.from(activity).inflate(R.layout.hbv, (ViewGroup) null, false);
        IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
        View view = this.floatView;
        String str = a.CLASS_NAME;
        int enterCustomFloatingScreen = iQQFloatingWindow.enterCustomFloatingScreen(activity, view, build, str, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showFloatingBall result:" + enterCustomFloatingScreen);
        }
        if (enterCustomFloatingScreen == 0) {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(str, new d(activity) { // from class: com.tencent.mobileqq.qqlive.api.verified.impl.QQLiveVerifyFloatServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;

                {
                    this.val$activity = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVerifyFloatServiceImpl.this, (Object) activity);
                    }
                }

                @Override // gh2.d
                public boolean onCloseClick() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 3, (Object) this)).booleanValue();
                    }
                    return false;
                }

                @Override // gh2.d
                public boolean onEnterClick(int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d(QQLiveVerifyFloatServiceImpl.TAG, 4, "onEnterClick");
                    }
                    if (!BaseGesturePWDUtil.isAppOnForeground(this.val$activity)) {
                        BaseApplication.context.startActivity(this.val$activity.getIntent());
                    }
                    return true;
                }
            });
        }
    }
}
