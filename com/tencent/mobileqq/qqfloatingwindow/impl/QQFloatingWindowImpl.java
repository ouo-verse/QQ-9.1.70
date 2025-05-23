package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gh2.c;
import gh2.d;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQFloatingWindowImpl implements IQQFloatingWindow {
    static IPatchRedirector $redirector_ = null;
    private static final String QQFS_LOCATION_CENTER_X = "qqfs_floating_center_x";
    private static final String QQFS_LOCATION_CENTER_Y = "qqfs_floating_center_y";
    public static final String TAG = "FloatingScreenManager";
    private com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.a mWrapperFactory;

    public QQFloatingWindowImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mWrapperFactory = new com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.a();
        }
    }

    private static void sendWindowClosedBroadcastWithId(Context context, int i3) {
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_concern_floating_type", 0);
        intent.putExtra("param_curr_window_status", 104);
        intent.putExtra("param_busitype", i3);
        intent.putExtra("param_ignored_processid", MobileQQ.sProcessId);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public int enterCustomFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, context, view, floatingScreenParams, str, Integer.valueOf(i3))).intValue();
        }
        if (context == null || view == null) {
            return 2;
        }
        if (!FloatingScreenPermission.checkPermission(context)) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enterCustomFloatingScreen:", Integer.valueOf(i3), ", view:", view.toString());
        }
        if (floatingScreenParams == null) {
            floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(context, str);
        if (b16 == null) {
            return 3;
        }
        return b16.j(floatingScreenParams, view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public synchronized int enterFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return enterFloatingScreen(context, view, floatingScreenParams, i3, FloatingVideoWrapper.CLASS_NAME);
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, this, context, view, floatingScreenParams, Integer.valueOf(i3))).intValue();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public synchronized int enterLocationFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, context, view, floatingScreenParams, str)).intValue();
        }
        if (context == null || view == null) {
            return 2;
        }
        if (!FloatingScreenPermission.checkPermission(context)) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enterLocationFloatingScreen:", view.toString());
        }
        if (floatingScreenParams == null) {
            floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(context, str);
        if (b16 == null) {
            return 3;
        }
        b16.J(floatingScreenParams);
        return b16.j(floatingScreenParams, view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public synchronized int enterWatchTogetherFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, context, view, floatingScreenParams, str)).intValue();
        }
        if (context == null || view == null) {
            return 2;
        }
        if (!FloatingScreenPermission.checkPermission(context)) {
            return 1;
        }
        if (!MobileQQ.sMobileQQ.getQQProcessName().endsWith(":tool")) {
            QQToast.makeText(context, R.string.f209645fz, 0).show();
            if (!com.tencent.mobileqq.qqfloatingwindow.impl.inject.a.c()) {
                return -1;
            }
            throw new RuntimeException("Open Watch Floating Windows in NOT tool process, Now Process is " + MobileQQ.sMobileQQ.getQQProcessName());
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enterLocationFloatingScreen:", view.toString());
        }
        if (floatingScreenParams == null) {
            floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(context, str);
        if (b16 == null) {
            return 3;
        }
        b16.J(floatingScreenParams);
        return b16.j(floatingScreenParams, view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public ArrayList<com.tencent.mobileqq.qqfloatingwindow.a> getExistFloatingWrappers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mWrapperFactory.a();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public com.tencent.mobileqq.qqfloatingwindow.a getFloatingProxyWrapper(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.qqfloatingwindow.a) iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) str);
        }
        return this.mWrapperFactory.b(context, str);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void quitFloatingScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, FloatingVideoWrapper.CLASS_NAME);
        if (b16 != null) {
            b16.quitWindowFloat(4);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "quitFloatingScreen Fail, wrapper is null");
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void saveFloatingCenter(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        SharedPreferences.Editor edit = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, FloatingScreenParams.QQFS_SP_NAME, "common_mmkv_configurations").edit();
        edit.putInt(QQFS_LOCATION_CENTER_X, i3);
        edit.putInt(QQFS_LOCATION_CENTER_Y, i16);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IVideoOuterStatusListener) iPatchRedirector.redirect((short) 14, (Object) this, (Object) iVideoInnerStatusListener, (Object) str);
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            return b16.M(iVideoInnerStatusListener);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    @Deprecated
    public void setFullScreenListener(IFullScreenEnterListener iFullScreenEnterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iFullScreenEnterListener);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, FloatingVideoWrapper.CLASS_NAME);
        if (b16 != null) {
            b16.X(iFullScreenEnterListener);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void setFullScreenViewClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, FloatingVideoWrapper.CLASS_NAME);
        if (b16 != null) {
            b16.Y(cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void setWindowClickListener(String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.j0(dVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void updateFloatingWindowLocation(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.k0(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void updateFloatingWindowRatio(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), str);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.l0(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void updateFloatingWindowShape(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.m0(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void updateFloatingWindowSize(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.n0(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public int enterFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, context, view, floatingScreenParams, Integer.valueOf(i3), str)).intValue();
        }
        if (context == null || view == null) {
            return 2;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.e(i3);
        if (!FloatingScreenPermission.checkPermission(context)) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enterFloatingScree:", view.toString());
        }
        sendWindowClosedBroadcastWithId(context, i3);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 2);
        if (floatingScreenParams == null) {
            floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(2).setCanZoom(true).build();
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, FloatingScreenParams.QQFS_SP_NAME, "common_mmkv_configurations");
        int i16 = fromSpAdapter.getInt(QQFS_LOCATION_CENTER_X, Integer.MIN_VALUE);
        int i17 = fromSpAdapter.getInt(QQFS_LOCATION_CENTER_Y, Integer.MIN_VALUE);
        if (i16 != Integer.MIN_VALUE && i17 != Integer.MIN_VALUE) {
            floatingScreenParams.setFloatingCenterX(i16);
            floatingScreenParams.setFloatingCenterY(i17);
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(context, str);
        if (b16 == null) {
            QLog.e(TAG, 1, "FloatingBaseProxyWrapper is empty! so return");
            return 3;
        }
        int j3 = b16.j(floatingScreenParams, view);
        if (j3 == 0) {
            com.tencent.mobileqq.qqfloatingwindow.b.o(i3);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IVideoOuterStatusListener) iPatchRedirector.redirect((short) 15, (Object) this, (Object) iVideoInnerStatusListener);
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, FloatingVideoWrapper.CLASS_NAME);
        if (b16 != null) {
            return b16.M(iVideoInnerStatusListener);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
    public void quitFloatingScreen(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a b16 = this.mWrapperFactory.b(null, str);
        if (b16 != null) {
            b16.quitWindowFloat(4);
        }
    }
}
