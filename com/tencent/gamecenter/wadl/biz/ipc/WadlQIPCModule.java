package com.tencent.gamecenter.wadl.biz.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameInstallService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class WadlQIPCModule extends QIPCModule {
    public static final String NAME = "WadlQIPCModule";
    public static WadlQIPCModule mInstance;

    WadlQIPCModule() {
        super(NAME);
    }

    public static WadlQIPCModule getInstance() {
        if (mInstance == null) {
            synchronized (WadlQIPCModule.class) {
                if (mInstance == null) {
                    mInstance = new WadlQIPCModule();
                }
            }
        }
        return mInstance;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QPublicBaseFragment fragment;
        QLog.d(NAME, 1, "action = " + str + ", params = " + bundle);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IQQGameDownloadService iQQGameDownloadService = null;
        if (!TextUtils.isEmpty(str) && peekAppRuntime != null) {
            if (WadlProxyConsts.QIPC_ACTION_GETUIN.equals(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("uin", peekAppRuntime.getAccount());
                return EIPCResult.createSuccessResult(bundle2);
            }
            if (WadlProxyConsts.QIPC_ACTION_REPORT.equals(str)) {
                ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(peekAppRuntime, bundle.getString("reportData"));
            } else if (WadlProxyConsts.QIPC_ACTION_REPORT_V2.equals(str)) {
                String string = bundle.getString("reportData");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportAttaV2(new JSONObject(string));
                    } catch (JSONException e16) {
                        QLog.e(NAME, 1, "QIPC_ACTION_REPORT_78603 exception", e16);
                    }
                }
            } else {
                if (WadlProxyConsts.QIPC_ACTION_CHECK_FOREGROUND.equals(str)) {
                    boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
                    Bundle bundle3 = new Bundle();
                    bundle3.putBoolean("isForeground", isCurrentProcessForeground);
                    return EIPCResult.createSuccessResult(bundle3);
                }
                if (WadlProxyConsts.QIPC_ACTION_CHECK_TOP_FRAGMENT.equals(str)) {
                    Activity topActivity = Foreground.getTopActivity();
                    Bundle bundle4 = new Bundle();
                    if ((topActivity instanceof QPublicFragmentActivity) && (fragment = ((QPublicFragmentActivity) topActivity).getFragment()) != null) {
                        String name = fragment.getClass().getName();
                        if (TextUtils.isEmpty(name)) {
                            name = "";
                        }
                        bundle4.putString(WadlProxyConsts.TOP_FRAGMENT_NAME, name);
                        bundle4.putBoolean("isForeground", Foreground.isCurrentProcessForeground());
                        return EIPCResult.createSuccessResult(bundle4);
                    }
                    return EIPCResult.createResult(-102, bundle4);
                }
                if (WadlProxyConsts.QIPC_ACTION_CHECK_INSTALL_MODEL.equals(str)) {
                    ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).selectInstaller(bundle);
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                if (WadlProxyConsts.QIPC_ACTION_CHECK_INSTALL_YUNGAME_STATUS.equals(str)) {
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime2 != null) {
                        iQQGameDownloadService = (IQQGameDownloadService) peekAppRuntime2.getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
                    }
                    if (iQQGameDownloadService != null) {
                        iQQGameDownloadService.checkYunGameStatus(bundle);
                    }
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                if (WadlProxyConsts.QIPC_ACTION_CHANGE_WND_TOGGLE.equals(str)) {
                    int i16 = bundle.getInt("toggle");
                    QLog.e(NAME, 1, "QIPC_ACTION_CLOSE_DOWNLOAD_WINDOW : " + i16);
                    IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "all");
                    if (iQQGameNoticeService != null) {
                        iQQGameNoticeService.setFloatWndToggle(i16);
                    }
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                if (WadlProxyConsts.QIPC_ACTION_INSTALL_APK.equals(str)) {
                    String string2 = bundle.getString("appid");
                    String string3 = bundle.getString("packageName");
                    String string4 = bundle.getString(WadlProxyConsts.PARAM_LOCAL_APK_PATH);
                    String string5 = bundle.getString("sourceId");
                    String string6 = bundle.getString("actionFrom");
                    QLog.i(NAME, 2, "QIPC_ACTION_INSTALL_APK pkgName=" + string3 + ",appId=" + string2 + ",filePath=" + string4 + ",sourceId=" + string5 + ",callFrom=" + string6);
                    GameCenterUtil.goToInstall(string2, string3, string4, string5, string6);
                    return EIPCResult.createSuccessResult(new Bundle());
                }
            }
        }
        return null;
    }
}
