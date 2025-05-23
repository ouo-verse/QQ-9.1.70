package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameInstallService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes6.dex */
public class WadlPackageMgr implements Observer {
    private static WadlPackageMgr INSTANCE = null;
    private static byte[] LOCK = new byte[0];
    public static final String TAG = "Wadl_WadlPackageMgr";

    WadlPackageMgr() {
    }

    private boolean canUseCustomInstaller(String str) {
        int expType = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getExpType(str, false, WadlProxyConsts.EXP_QQ_QQGAME_CUSTOM_INSTALL, IQQGameInstallService.K_ABTEST_WHITE_APPIDS);
        boolean isInstallModelChecked = ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).isInstallModelChecked(str);
        QLog.d(TAG, 1, "canUseCustomInstaller appid=", str, ", usrExpType=", Integer.valueOf(expType), ", isInstallModelChecked=", Boolean.valueOf(isInstallModelChecked));
        if (expType != 2 || isInstallModelChecked) {
            return false;
        }
        return true;
    }

    private WadlTask findTaskByBusinessId(int i3, String str) {
        if (i3 == 1) {
            return WadlGameCenterTaskMgr.getInstance().findWadlTask(str);
        }
        if (i3 == 3) {
            return WadlVMTaskManager.getInstance().findTaskByPkgName(str);
        }
        return null;
    }

    private void forwardToQQProcessCheck(String str, String str2, long j3, boolean z16, boolean z17) {
        WadlQIPCConnector.getInstance().checkConnect();
        Bundle bundle = new Bundle();
        bundle.putString(WadlProxyConsts.PARAM_WADL_PARAMS_JSON_STR, str);
        bundle.putString(WadlProxyConsts.PARAM_LOCAL_APK_PATH, str2);
        bundle.putLong(WadlProxyConsts.PARAM_APK_FILE_SIZE, j3);
        bundle.putBoolean(WadlProxyConsts.PARAM_IS_FOREGROUND, z16);
        bundle.putBoolean(WadlProxyConsts.PARAM_HAS_INSTALL_PERMISSION, z17);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_CHECK_INSTALL_MODEL, bundle);
    }

    public static WadlPackageMgr getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new WadlPackageMgr();
                }
            }
        }
        return INSTANCE;
    }

    private void installApp(final WadlTask wadlTask, final String str, final String str2) {
        if (wadlTask != null && wadlTask.mWadlParams != null) {
            if ("auto".equals(str2)) {
                forwardToQQProcessCheck(wadlTask.mWadlParams);
                return;
            }
            if (!TextUtils.isEmpty(wadlTask.downloadFilePath)) {
                wadlTask.onInstallStart();
                QLog.d(TAG, 1, "installApp hasPermission=" + GameCenterUtil.checkInstallPermission() + ", wadlTask=" + wadlTask);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.dlmgr.WadlPackageMgr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WadlPackageMgr.this.isPassCheckSign(wadlTask)) {
                            WadlPackageMgr.this.installAppOutOfSign(wadlTask, str, str2);
                        } else {
                            WadlPackageMgr.this.installAppBySign(wadlTask, str, str2);
                        }
                    }
                }, 16, null, false);
                return;
            }
            onInstallFail(wadlTask, 50008);
            return;
        }
        QLog.w(TAG, 1, "installApp params error, wadlTask=" + wadlTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installAppBySign(WadlTask wadlTask, String str, String str2) {
        int checkFileSign = WadlUtils.checkFileSign(wadlTask.appId, wadlTask.downloadFilePath, wadlTask.mWadlParams.apkSign);
        QLog.d(TAG, 1, "installAppBySign appId=" + wadlTask.appId + ",apkFile=" + wadlTask.downloadFilePath + ",result=" + checkFileSign);
        if (checkFileSign == 0) {
            checkFileSign = installAppBySystem(str, wadlTask.mWadlParams, wadlTask.downloadFilePath, wadlTask.fileSize, str2);
        }
        if (checkFileSign == 0) {
            return;
        }
        onInstallFail(wadlTask, checkFileSign);
        if (WadlUtils.isSignError(checkFileSign)) {
            WadlGameCenterTaskMgr.getInstance().deleteWadlTask(wadlTask.appId, true, WadlProxyConsts.DELETE_FROM_INSTALL_APPBYSIGN);
            WadlVMTaskManager.getInstance().deleteWadlTask(wadlTask.pkgName, true);
        }
    }

    private int installAppBySystem(String str, WadlParams wadlParams, String str2, long j3, String str3) {
        boolean checkInstallPermission;
        boolean isForeground;
        h b16;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        try {
            if (TextUtils.isEmpty(wadlParams.sourceId)) {
                wadlParams.sourceId = "biz_src_zf_games";
            }
            checkInstallPermission = GameCenterUtil.checkInstallPermission();
            isForeground = GameCenterUtil.isForeground();
            QLog.d(TAG, 1, "installAppBySystem localAPKPath=" + str2 + ",sourceId=" + wadlParams.sourceId + ",fromAdtag=" + str + ",haveInstallPermission=" + checkInstallPermission + ",isForeground=" + isForeground);
            b16 = h.b();
            b16.f106814a = wadlParams;
            String str5 = "1";
            if (isForeground) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            b16.f106815b = str4;
            if (!checkInstallPermission) {
                str5 = "0";
            }
            b16.f106821h = str5;
        } catch (Exception e16) {
            e = e16;
        }
        try {
            if (Build.VERSION.SDK_INT > 28 && !WadlProxyConsts.FROM_CUSTOM_INSTALLER.equals(str)) {
                boolean canUseCustomInstaller = canUseCustomInstaller(wadlParams.appId);
                QLog.d(TAG, 1, "installAppBySystem appid=", wadlParams.appId, ", canUseCustomInstaller=", Boolean.valueOf(canUseCustomInstaller));
                if (canUseCustomInstaller) {
                    forwardToQQProcessCheck(wadlParams.parseToJsonStr(), str2, j3, isForeground, checkInstallPermission);
                } else {
                    GameCenterUtil.goToInstall(wadlParams.appId, wadlParams.packageName, str2, wadlParams.sourceId, str3);
                }
            } else {
                b16.f106816c = 0;
                GameCenterUtil.goToInstall(wadlParams.appId, wadlParams.packageName, str2, wadlParams.sourceId, str3);
            }
            b16.f106818e = String.valueOf(GameCenterUtil.getFileLastModifyTime(str2));
            WadlReportManager.wadlReportDC(WadlProxyConsts.OPER_ID_INSTALL_REQUEST, "20", b16);
            WadlReportManager.wadlReportDC04239(wadlParams, "virtual_click_start");
            return 0;
        } catch (Exception e17) {
            e = e17;
            QLog.e(TAG, 1, "installAppBySystem exception", e);
            return 50007;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installAppOutOfSign(WadlTask wadlTask, String str, String str2) {
        int installAppBySystem = installAppBySystem(str, wadlTask.mWadlParams, wadlTask.downloadFilePath, wadlTask.fileSize, str2);
        QLog.d(TAG, 1, "installAppOutOfSign appId=" + wadlTask.appId + ",apkFile=" + wadlTask.downloadFilePath + ",result=" + installAppBySystem);
        if (installAppBySystem == 0) {
            return;
        }
        onInstallFail(wadlTask, installAppBySystem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPassCheckSign(WadlTask wadlTask) {
        if (!TextUtils.isEmpty(wadlTask.mWadlParams.apkSign) && wadlTask.mWadlParams.getFlagEnable(32)) {
            return false;
        }
        return true;
    }

    private void onInstallFail(WadlTask wadlTask, int i3) {
        if (wadlTask.businessId != 1) {
            return;
        }
        wadlTask.taskStatus = 14;
        wadlTask.errCode = 100;
        h b16 = h.b();
        b16.f106814a = wadlTask.mWadlParams;
        b16.f106816c = i3;
        WadlReportManager.wadlReportDC(WadlProxyConsts.OPER_ID_INSTALL_FAIL, WadlProxyConsts.OPER_TYPE_APK_SIGN, b16);
    }

    private void optReportInstallFail(int i3, int i16, String str, WadlResult wadlResult, WadlTask wadlTask) {
        if (i3 == 1) {
            h b16 = h.b();
            b16.f106816c = i16;
            b16.f106817d = str;
            if (wadlTask != null) {
                b16.f106814a = wadlTask.mWadlParams;
            }
            if (b16.f106814a == null && wadlResult != null) {
                b16.f106814a = wadlResult.wadlParams;
            }
            WadlReportManager.wadlReportDC(WadlProxyConsts.OPER_ID_INSTALL_FAIL, WadlProxyConsts.OPER_TYPE_APK_SIGN, b16);
        }
    }

    private void updateInstallParams(WadlParams wadlParams, WadlParams wadlParams2) {
        if (wadlParams != null && wadlParams2 != null) {
            int i3 = wadlParams2.flags;
            if (i3 != 0) {
                wadlParams.setFlags(i3);
            }
            int i16 = wadlParams2.extFlags;
            if (i16 != 0) {
                wadlParams.setExtFlags(i16);
            }
            wadlParams.sourceId = wadlParams2.sourceId;
        }
    }

    private boolean validEvent(int i3) {
        if (i3 == 1008) {
            return true;
        }
        return false;
    }

    public void install(WadlRequest wadlRequest) {
        Bundle bundle;
        QLog.d(TAG, 1, "install wadlRequest=" + wadlRequest);
        if (wadlRequest != null && (bundle = wadlRequest.f106596h) != null) {
            int i3 = wadlRequest.f106593d;
            WadlTask wadlTask = null;
            String str = "";
            if (i3 == 1) {
                WadlParams wadlParams = (WadlParams) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
                if (wadlParams != null) {
                    WadlTask findTaskByBusinessId = findTaskByBusinessId(wadlRequest.f106593d, wadlParams.appId);
                    if (findTaskByBusinessId != null) {
                        updateInstallParams(findTaskByBusinessId.mWadlParams, wadlParams);
                    }
                    wadlTask = findTaskByBusinessId;
                    str = wadlParams.adtag;
                }
            } else if (i3 == 3) {
                wadlTask = findTaskByBusinessId(wadlRequest.f106593d, bundle.getString("packageName"));
            }
            installApp(wadlTask, str, "default");
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str;
        String message;
        int i3;
        WadlParams wadlParams;
        int i16;
        WadlResult wadlResult = (WadlResult) obj;
        if (wadlResult != null && wadlResult.wadlParams != null) {
            if (!validEvent(wadlResult.event)) {
                return;
            }
            int i17 = wadlResult.businessId;
            if (i17 == 1) {
                str = wadlResult.wadlParams.appId;
            } else if (i17 != 3) {
                str = "";
            } else {
                str = wadlResult.wadlParams.packageName;
            }
            WadlTask findTaskByBusinessId = findTaskByBusinessId(i17, str);
            if (findTaskByBusinessId != null) {
                try {
                    wadlParams = findTaskByBusinessId.mWadlParams;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "update exception", e16);
                    message = e16.getMessage();
                    i3 = 50009;
                }
                if (wadlParams != null) {
                    if (wadlResult.event == 1008) {
                        if (wadlParams.getFlagEnable(1)) {
                            installApp(findTaskByBusinessId, "", "auto");
                            return;
                        }
                        i16 = 50011;
                    } else {
                        i16 = -1;
                    }
                    i3 = i16;
                    message = "";
                    optReportInstallFail(wadlResult.businessId, i3, message, wadlResult, findTaskByBusinessId);
                    return;
                }
            }
            QLog.w(TAG, 1, "update task not found, appId=" + wadlResult.wadlParams.appId);
            i16 = 50010;
            i3 = i16;
            message = "";
            optReportInstallFail(wadlResult.businessId, i3, message, wadlResult, findTaskByBusinessId);
            return;
        }
        QLog.w(TAG, 1, "update error,wadlResult is null");
    }

    private void forwardToQQProcessCheck(WadlParams wadlParams) {
        WadlQIPCConnector.getInstance().checkConnect();
        Bundle bundle = new Bundle();
        bundle.putString(WadlProxyConsts.PARAM_WADL_PARAMS_JSON_STR, wadlParams.parseToJsonStr());
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_CHECK_INSTALL_YUNGAME_STATUS, bundle);
    }
}
