package com.tencent.mobileqq.minigame.minigamecenter.hippy.module;

import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import nl0.d;

/* compiled from: P */
@HippyNativeModule(name = MiniAppWadlModule.NAME)
/* loaded from: classes33.dex */
public class MiniAppWadlModule extends QQBaseModule implements d {
    static final String NAME = "MiniAppWadlModule";
    private static final String TAG = "Wadl_MiniAppWadlModule";

    public MiniAppWadlModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.registerDownloadCallBack(this);
        }
    }

    private void sendEvent(String str, Object obj) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, obj);
    }

    public static HippyMap toHippyMap(WadlResult wadlResult) {
        HippyMap hippyMap = new HippyMap();
        if (wadlResult != null && wadlResult.wadlParams != null) {
            int convertRemoteStatusToLocal = GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus);
            WadlParams wadlParams = wadlResult.wadlParams;
            hippyMap.pushString("packagename", wadlParams.packageName);
            hippyMap.pushString("appid", wadlParams.appId);
            hippyMap.pushInt(WadlResult.WEB_KEY_PROGRESS, wadlResult.progress);
            hippyMap.pushInt("state", convertRemoteStatusToLocal);
            hippyMap.pushString("via", wadlParams.via);
            hippyMap.pushLong("mieActId", wadlParams.mieActId);
            hippyMap.pushString("extraInfo", wadlParams.extraData);
            int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
            hippyMap.pushInt("errorCode", wadlErrCode);
            hippyMap.pushString("errorMsg", GameCenterUtil.getWadlErrMsg(wadlErrCode));
            hippyMap.pushString("appName", wadlParams.appName);
            hippyMap.pushString("iconUrl", wadlParams.iconUrl);
            if (convertRemoteStatusToLocal == 4) {
                hippyMap.pushString("savePath", wadlResult.downloadFilePath);
            }
        }
        return hippyMap;
    }

    @HippyMethod(name = "delete")
    public void delete(String str) {
        QLog.i(TAG, 1, "delete packageName=" + str);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.deleteDownload(3, str);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.unRegisterDownloadCallBack(this);
        }
    }

    @HippyMethod(name = WadlProxyConsts.REMOTE_CMD_QUERY_TASK)
    public void doQueryAllTask(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doQueryAllTask jsonParams=" + str);
        }
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.doQueryAllTask(3);
        }
    }

    @HippyMethod(name = "download")
    public void download(String str) {
        QLog.i(TAG, 1, "download jsonParams=" + str);
        WadlParams wadlParams = new WadlParams(str);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.doDownloadAction(3, wadlParams);
        }
    }

    public int getBusinessId() {
        return 3;
    }

    @HippyMethod(name = VRReportDefine$ReportKey.INSTALL)
    public void install(String str) {
        QLog.i(TAG, 1, "install packageName=" + str);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.doInstallAction(3, str);
        }
    }

    @Override // nl0.d
    public void onWadlStatusChanged(WadlResult wadlResult) {
        sendEvent("onWadlTaskStatusChanged", toHippyMap(wadlResult));
    }

    @HippyMethod(name = "pause")
    public void pause(String str) {
        QLog.i(TAG, 1, "pause packageName=" + str);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.doPauseAction(3, str);
        }
    }

    @HippyMethod(name = "resume")
    public void resume(String str) {
        QLog.i(TAG, 1, "download packageName=" + str);
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        if (iQQGameDLService != null) {
            iQQGameDLService.doResumeAction(3, str);
        }
    }

    @Override // nl0.d
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        if (arrayList != null) {
            HippyArray hippyArray = new HippyArray();
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                hippyArray.pushMap(toHippyMap(it.next()));
            }
            sendEvent("onQueryCallback", hippyArray);
        }
    }
}
