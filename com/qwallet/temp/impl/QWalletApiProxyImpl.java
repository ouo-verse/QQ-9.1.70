package com.qwallet.temp.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.ipc.TickReq;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes39.dex */
public class QWalletApiProxyImpl implements IQWalletApiProxy {
    private static final String TAG = "QwalletApiProxyImpl";

    @Override // com.qwallet.temp.IQWalletApiProxy
    public boolean getAppForground(Context context) {
        return BaseGesturePWDUtil.getAppForground(context);
    }

    @Override // com.qwallet.temp.IQWalletApiProxy
    public boolean launchPlugin(Context context, Bundle bundle) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (context == null || bundle == null || waitAppRuntime == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "launchPlugin comeFrom = " + bundle.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM));
        }
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchPayService(context, waitAppRuntime, bundle);
        return true;
    }

    @Override // com.qwallet.temp.IQWalletApiProxy
    public void setAppForground(Context context, boolean z16) {
        GesturePWDUtils.setAppForground(context, z16);
    }

    @Override // com.qwallet.temp.IQWalletApiProxy
    public void setLastExitWalletTime(long j3, TickReq tickReq) {
        try {
            PatternLockUtils.setLastExitWalletTime(BaseApplication.getContext().getApplicationContext(), BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin() + "", tickReq.exitQWalletTime);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setLastExitWalletTime: error", th5);
        }
    }

    @Override // com.qwallet.temp.IQWalletApiProxy
    public Drawable getDrawableForWallet(String str, Drawable drawable, Bundle bundle) {
        URLDrawable drawableInner = QWalletPicHelper.getDrawableInner(str, str, drawable, drawable, new int[]{26}, bundle);
        ApngImage.playByTag(26);
        return drawableInner;
    }

    @Override // com.qwallet.temp.IQWalletApiProxy
    public void onSetBaseActivityUnlockSuceess() {
        QBaseActivity.isUnLockSuccess = true;
    }
}
