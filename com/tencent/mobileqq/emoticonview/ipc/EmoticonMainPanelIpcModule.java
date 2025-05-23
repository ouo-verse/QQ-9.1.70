package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService;
import com.tencent.mobileqq.emoticonview.api.IAiEmoticonService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class EmoticonMainPanelIpcModule extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_EXTERNALPANEL_HEIGHT = "externalpanel_height";
    public static final String HEIGHT = "height";
    public static final String NAME = "module_emoticon_mainpanel";
    public static final String TAG = "EmoticonMainPanelIpcModule";
    public static EmoticonMainPanelIpcModule mInstance;
    public String processName;

    public EmoticonMainPanelIpcModule() {
        super("module_emoticon_mainpanel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized EmoticonMainPanelIpcModule getInstance() {
        EmoticonMainPanelIpcModule emoticonMainPanelIpcModule;
        synchronized (EmoticonMainPanelIpcModule.class) {
            if (mInstance == null) {
                synchronized (EmoticonMainPanelIpcModule.class) {
                    if (mInstance == null) {
                        mInstance = new EmoticonMainPanelIpcModule();
                    }
                }
            }
            emoticonMainPanelIpcModule = mInstance;
        }
        return emoticonMainPanelIpcModule;
    }

    private EIPCResult ipcUpdateAIEmoticon(AppRuntime appRuntime, Bundle bundle) {
        if (!(appRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        ((IEmoticonAIManagerService) ((BaseQQAppInterface) appRuntime).getRuntimeService(IEmoticonAIManagerService.class)).setForceRequest(true);
        QLog.i(TAG, 1, "ipcUpdateAIEmoticonForceRequest  setForceRequest");
        return EIPCResult.createSuccessResult(null);
    }

    @Nullable
    private static EIPCResult ipcUploadPicAndCheck(Bundle bundle) {
        if (bundle == null) {
            QLog.i(TAG, 1, "ipcUploadPicAndCheck params is null");
            return null;
        }
        String string = bundle.getString(IEmoticonPanelIpcService.PARAM_FILE_PATH);
        if (TextUtils.isEmpty(string)) {
            QLog.i(TAG, 1, "ipcUploadPicAndCheck filePath is null");
            return null;
        }
        return ((IAiEmoticonService) QRoute.api(IAiEmoticonService.class)).uploadPicAndCheck(string);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return EIPCResult.createResult(-105, null);
        }
        if (bundle != null) {
            bundle.setClassLoader(EmoticonPackage.class.getClassLoader());
        }
        if (EmoticonMainPanelChildIpcModule.OTHER_RIGISTER_CALLBACK.equals(str)) {
            if (bundle != null) {
                this.processName = bundle.getString("process_name");
            }
            return EIPCResult.createSuccessResult(null);
        }
        EIPCResult checkMatch = CommercialDrainageManagerServiceProxy.checkMatch(waitAppRuntime, str, bundle, i3);
        if (checkMatch != null) {
            return checkMatch;
        }
        EIPCResult checkMatch2 = CommonUsedSystemEmojiManagerServiceProxy.checkMatch(waitAppRuntime, str, bundle, i3);
        if (checkMatch2 != null) {
            return checkMatch2;
        }
        EIPCResult checkMatch3 = EmojiManagerServiceProxy.checkMatch(waitAppRuntime, str, bundle, i3);
        if (checkMatch3 != null) {
            return checkMatch3;
        }
        EIPCResult checkMatch4 = EmoticonHandlerProxy.checkMatch(waitAppRuntime, str, bundle, i3);
        if (checkMatch4 != null) {
            return checkMatch4;
        }
        EIPCResult checkMatch5 = EmoticonManagerServiceProxy.checkMatch(waitAppRuntime, str, bundle, i3);
        if (checkMatch5 != null) {
            return checkMatch5;
        }
        if (FavEmoRoamingHandlerProxy.ACTION_FAVEMOROAMINGHANDLER_NOTIFYUI.equals(str)) {
            return FavEmoRoamingHandlerProxy.onNotifyUI((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (FontManagerProxy.ACTION_FONTMANAGER_ISSUPPORTFONT.equals(str)) {
            return FontManagerProxy.onIsSupportFont((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (GameCenterManagerImpProxy.ACTION_GAMECENTERMANAGERIMP_CHECKNEWFLAGBYPATH.equals(str)) {
            return GameCenterManagerImpProxy.onCheckNewFlagByPath((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (MqqHandlerProxy.ACTION_MQQHANDLER_SENDTOTARGET.equals(str)) {
            return MqqHandlerProxy.onSendToTarget((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (RedTouchManagerProxy.ACTION_REDTOUCHMANAGER_ONREDTOUCHITEMCLICK.equals(str)) {
            return RedTouchManagerProxy.onOnRedTouchItemClick((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (RedTouchManagerProxy.ACTION_REDTOUCHMANAGER_GETAPPINFOBYPATH.equals(str)) {
            return RedTouchManagerProxy.onGetAppInfoNewFlagByPath((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (SVIPHandlerProxy.ACTION_SVIPHANDLER_GETCURRENTUSERVIPTYPE.equals(str)) {
            return SVIPHandlerProxy.onGetCurrentUserVipType((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (VipComicMqqHandlerProxy.ACTION_VIPCOMICM_FAVOREMOTICONS.equals(str)) {
            return VipComicMqqHandlerProxy.onGetMyComicFavorEmotIcons((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (VipComicMqqManagerServiceProxy.ACTION_VIPCOMICM_UPLOADINITCOMICEINFO.equals(str)) {
            return VipComicMqqManagerServiceProxy.onUploadInitComicEmoStructMsgInfo((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (QQMessageFacadeProxy.ACTION_QQMESSAGEFACADE_GETCURRCHATTYPE.equals(str)) {
            return QQMessageFacadeProxy.onGetCurrChatType((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (QQMessageFacadeProxy.ACTION_QQMESSAGEFACADE_CURRCHATUIN.equals(str)) {
            return QQMessageFacadeProxy.onGetCurrChatUin((BaseQQAppInterface) waitAppRuntime, str, bundle, i3);
        }
        if (ACTION_EXTERNALPANEL_HEIGHT.equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", ((IEmosmService) QRoute.api(IEmosmService.class)).getExternalPanelheight());
            return EIPCResult.createSuccessResult(bundle2);
        }
        if (IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK.equals(str)) {
            return ipcUploadPicAndCheck(bundle);
        }
        if (!IEmoticonPanelIpcService.ACTION_GET_AI_EMOTICON_LIST.equals(str)) {
            return null;
        }
        return ipcUpdateAIEmoticon(waitAppRuntime, bundle);
    }

    public void postChildIPCBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (EmotionUtils.b() && !TextUtils.isEmpty(this.processName) && !this.processName.equals(MobileQQ.processName)) {
            if (!QIPCServerHelper.getInstance().isProcessRunning(this.processName)) {
                this.processName = null;
            } else {
                QIPCServerHelper.getInstance().callClient(this.processName, EmoticonMainPanelChildIpcModule.NAME, EmoticonMainPanelChildIpcModule.OTHER_PROCESS_CALLBACK, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonMainPanelIpcModule.this);
                        }
                    }

                    @Override // eipc.EIPCResultCallback
                    public void onCallback(EIPCResult eIPCResult) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eIPCResult);
                            return;
                        }
                        if (eIPCResult != null && eIPCResult.isSuccess()) {
                            if (QLog.isColorLevel()) {
                                QLog.d(EmoticonMainPanelIpcModule.TAG, 4, "postChildIPCBundle suc.");
                                return;
                            }
                            return;
                        }
                        QLog.e(EmoticonMainPanelIpcModule.TAG, 4, "postChildIPCBundle fail.");
                    }
                });
            }
        }
    }
}
