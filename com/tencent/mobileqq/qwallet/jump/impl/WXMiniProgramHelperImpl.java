package com.tencent.mobileqq.qwallet.jump.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import qk2.WxMiniWhiteListBean;

/* loaded from: classes16.dex */
public class WXMiniProgramHelperImpl extends BroadcastReceiver implements IWXAPIEventHandler, IWXMiniProgramHelper {
    private static final String TAG = "WXMiniProgramHelperImpl";
    public static final String WX_APPID_DEBUG = "wx76a769350165bcff";
    public static final String WX_APPID_RELEASE = "wxf0a80d0ac2e82aa7";
    private final String WX_APP_ID = "wxf0a80d0ac2e82aa7";
    private final IWXAPI api = WXAPIFactory.createWXAPI(MobileQQ.sMobileQQ, "wxf0a80d0ac2e82aa7", true);

    public WXMiniProgramHelperImpl() {
        BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
        registerApp();
    }

    private void showToast(MqqHandler mqqHandler, final int i3) {
        mqqHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.jump.impl.WXMiniProgramHelperImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MobileQQ.sMobileQQ, 0, i3, 0).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper
    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleWXEntryActivityIntent");
        }
        if (this.api != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleWXEntryActivityIntent api != null");
            }
            this.api.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper
    public boolean isCanJumpToWxMiniProgram() {
        if (this.api.isWXAppInstalled() && this.api.getWXAppSupportAPI() >= 621086464) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper
    public void launchMiniProgram(Map<String, String> map, String str) {
        boolean z16;
        String str2;
        QLog.w(TAG, 1, "launchMiniProgram: " + map.toString());
        String str3 = map.get(AudienceReportConst.USER_NAME);
        WxMiniWhiteListBean wxMiniWhiteListBean = (WxMiniWhiteListBean) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_LAUNCH_WXMINIAPP_CONFIG, new WxMiniWhiteListBean());
        int i3 = 0;
        if (wxMiniWhiteListBean.a() != null && wxMiniWhiteListBean.a().contains(str3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("mqq_wxminiapp_launch", new WXMiniAppReportBean(str, str3, str2));
        if (z16) {
            QLog.i(TAG, 1, "in white list: " + str3);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            if (!this.api.isWXAppInstalled()) {
                showToast(uIHandler, R.string.f170986w14);
                return;
            }
            if (this.api.getWXAppSupportAPI() < 621086464) {
                showToast(uIHandler, R.string.f170987w15);
                return;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str3;
            try {
                i3 = Integer.parseInt(map.get("app_type"));
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            req.miniprogramType = i3;
            String str4 = map.get("path");
            if (!TextUtils.isEmpty(str4)) {
                try {
                    req.path = URLDecoder.decode(str4, "UTF-8");
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th5);
                }
            }
            String str5 = map.get("ext");
            if (str5 != null) {
                req.extData = str5;
            }
            this.api.sendReq(req);
            return;
        }
        QLog.w(TAG, 1, "block launch wxMiniApp: " + str3);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.api != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "onReceive() api != null");
            }
            this.api.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onReq: ");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onResp: ");
        }
    }

    public void registerApp() {
        try {
            this.api.registerApp(this.WX_APP_ID);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "registerApp()");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
