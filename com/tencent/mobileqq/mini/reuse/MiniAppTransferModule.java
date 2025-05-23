package com.tencent.mobileqq.mini.reuse;

import Wallet.AcsDelMsgRsp;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGameHomeReportService;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.share.WXShareHelperFromQQMiniApp;
import com.tencent.mobileqq.mini.utils.ReportLogUtil;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.minigame.report.StartupReportDispatcher;
import com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper;
import com.tencent.mobileqq.minigame.va.DownloadScene;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.StatusListener;
import com.tencent.mobileqq.minigame.va.download.MiniGameVaHotfixDownloadCallback;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dq;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.IMiniAppGetGroupInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MiniAppGetGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.MiniAppGetGroupInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.MiniAppGroupInfoReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppTransferModule extends QIPCModule {
    public static final String ACTION_CHECK_IS_GROUP_MEMBER = "check_is_group_member";
    public static final String ACTION_CHECK_IS_IN_MY_APP_LIST = "check_is_in_my_app_list";
    public static final String ACTION_CHECK_META_GUIDE_BUBBLE_RED_TOUCH = "check_meta_guide_bubble_red_touch";
    public static final String ACTION_DELETE_QQ_NOTIFY = "del_qq_notify";
    public static final String ACTION_FLUSH_REPORT_DATA = "flush_report_data";
    public static final String ACTION_GET_BACK_HOME_SCENE_LIST = "get_back_home_scene_list";
    public static final String ACTION_GET_MAIN_SERVICE_API = "get_main_service_api";
    public static final String ACTION_LAUNCH_REPORT = "launch_report";
    public static final String ACTION_LAUNCH_REPORT2 = "launch_report2";
    public static final String ACTION_LAUNCH_REPORT_APP_PAUSE = "launch_report_app_pause";
    public static final String ACTION_LAUNCH_REPORT_APP_RESUME = "launch_report_app_resume";
    public static final String ACTION_LAUNCH_REPORT_JS_ERROR = "launch_report_js_error";
    public static final String ACTION_LAUNCH_REPORT_SDK_4239 = "launch_report_sdk_4239";
    public static final String ACTION_LETS_GO_RED_INFO = "action_lets_go_red_info";
    public static final String ACTION_LETS_GO_RES_PAUSE_DOWNLOAD = "action_lets_go_res_pause_download";
    public static final String ACTION_LETS_GO_RES_REGISTER_CALLBACK = "action_lets_go_res_register_callback";
    public static final String ACTION_LETS_GO_RES_START_DOWNLOAD = "action_lets_go_res_start_download";
    public static final String ACTION_LETS_GO_RES_STOP_DOWNLOAD = "action_lets_go_res_stop_download";
    public static final String ACTION_LETS_GO_RES_UNREGISTER_CALLBACK = "action_lets_go_res_unregister_callback";
    public static final String ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ = "mini_record_wx_share_miniapp_for_qq";
    public static final String ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK = "mini_record_wx_share_miniapp_for_sdk";
    public static final String ACTION_PA_FOLLOW = "public_account_follow";
    public static final String ACTION_PA_IS_FOLLOW = "public_account_is_follow";
    public static final String ACTION_PRELOAD_LOADING_AD = "preload_loading_ad";
    public static final String ACTION_QUERY_MINI_APP_DATA = "query_mini_app_data";
    public static final String ACTION_QUERY_USER_TROOP_INFO = "query_user_troop_info";
    public static final String ACTION_RECORD_DURATION = "record_duration";
    public static final String ACTION_RECORD_DURATION_SDK_4239 = "record_duration_sdk_4239";
    public static final String ACTION_SHARE_TO_Q_CIRCLE = "action_share_to_q_circle";
    public static final String ACTION_SHOW_MEMORY_DIALOG = "show_memory_dialog";
    public static final String ACTION_STARTUP_REPORT = "action_startup_report";
    public static final String ACTION_SYNC_MINI_APP_DATA = "sync_mini_app_data";
    public static final String ACTION_UNZIP_WXA_DYNAMIC_PACKAGE = "action_unzip_wxa_dynamic_package";
    public static final String ACTION_UPDATE_ENTRY_LIST = "update_entry_list";
    public static final String ACTION_UPLOAD_USER_LOG = "upload_user_log";
    public static final String ACTION_VA_ADD_DOWNLOAD_LISTENER = "action_va_add_download_listener";
    public static final String ACTION_VA_CANCEL_DOWNLOAD = "action_va_cancel_download";
    public static final String ACTION_VA_QUERY_CAN_UPDATE_VA = "action_va_query_can_update_va";
    public static final String ACTION_VA_QUERY_CRASH_BLOCK = "action_va_query_crash_block";
    public static final String ACTION_VA_QUERY_DOWNLOAD_STATE = "action_va_query_download_state";
    public static final String ACTION_VA_REMOVE_DOWNLOAD_LISTENER = "action_va_remove_download_listener";
    public static final String ACTION_VA_RESTART_AND_INSTALL_VA = "action_va_restart_and_install_va";
    public static final String ACTION_VA_RESTART_DOWNLOAD = "action_va_restart_download";
    public static final String ACTION_VA_START_DOWNLOAD = "action_va_start_download";
    public static final String ACTION_VA_STOP_DOWNLOAD = "action_va_stop_download";
    private static final long GET_AVATAR_TIMEOUT = 5000;
    public static final String NAME = "MiniAppTransferModule";
    public static final String NOTIFY_HOME_REPORT_ACCOUNT_CHANGE = "home_report_account_change";
    private static final String NOTIFY_NATIVE_UPDATEAPPLIST = "updateAppList";
    public static final int RESULT_CODE_SUCCESS = 0;
    private static final String TAG = "MiniAppTransferModule";
    private static MiniAppTransferModule sInstance;
    private CardObserver cardObserver;
    private final ConcurrentHashMap<String, WeakReference<MiniGameVaHotfixDownloadCallback>> gameIdToHotFixListeners;
    private final ConcurrentHashMap<String, WeakReference<StatusListener>> gameIdToListeners;
    private AtomicBoolean mSendingRequest;
    private int noDisturbModeCallbackId;
    private MiniGameQCircleShareHelper qCircleShareHelper;

    public MiniAppTransferModule(String str) {
        super(str);
        this.noDisturbModeCallbackId = -1;
        this.gameIdToListeners = new ConcurrentHashMap<>();
        this.gameIdToHotFixListeners = new ConcurrentHashMap<>();
        this.mSendingRequest = new AtomicBoolean(false);
        this.cardObserver = new CardObserver() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.CardObserver
            public void onSetNotDisturb(boolean z16, String str2, String str3) {
                super.onSetNotDisturb(z16, str2, str3);
                if (!"not_disturb_from_miniapp".equals(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniAppTransferModule", 4, "onSetNotDisturb NOT FROM THIS" + str3);
                        return;
                    }
                    return;
                }
                MiniAppTransferModule.this.mSendingRequest.set(false);
                if (!z16) {
                    QLog.d("MiniAppTransferModule", 1, "Request failed, return.");
                    if (MiniAppTransferModule.this.noDisturbModeCallbackId != -1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("errMsg", "Request failed");
                        MiniAppTransferModule miniAppTransferModule = MiniAppTransferModule.this;
                        miniAppTransferModule.callbackResult(miniAppTransferModule.noDisturbModeCallbackId, EIPCResult.createResult(-102, bundle));
                    }
                } else {
                    MqqHandler handler = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
                    if (handler != null) {
                        Conversation.updateDonDisturb(handler, BaseApplication.getContext());
                    }
                    if (MiniAppTransferModule.this.noDisturbModeCallbackId != -1) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        MiniAppTransferModule miniAppTransferModule2 = MiniAppTransferModule.this;
                        miniAppTransferModule2.callbackResult(miniAppTransferModule2.noDisturbModeCallbackId, EIPCResult.createResult(0, bundle2));
                    }
                }
                MiniAppTransferModule.this.noDisturbModeCallbackId = -1;
            }
        };
    }

    private void deleteQQNotifyAction(Bundle bundle, final int i3) {
        String string = bundle.getString("msgid");
        if (!StringUtil.isEmpty(string) && !StringUtil.isEmpty(string)) {
            IQQReminderService iQQReminderService = (IQQReminderService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService == null) {
                QLog.i("MiniAppTransferModule", 1, "friendjsplugin qqnotify delete reminderService == null ");
                return;
            } else {
                iQQReminderService.sendDelReminderListById(string, 0L, 2, new BusinessObserver() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.7
                    @Override // mqq.observer.BusinessObserver
                    public void onReceive(int i16, boolean z16, Bundle bundle2) {
                        if (i16 == 2001) {
                            if (z16) {
                                try {
                                    AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) bundle2.getSerializable("rsp");
                                    if (acsDelMsgRsp != null) {
                                        if (acsDelMsgRsp.ret_code == 0) {
                                            QLog.i("MiniAppTransferModule", 1, "friendjsplugin qqnotify delete success ");
                                            MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createSuccessResult(new Bundle()));
                                            return;
                                        }
                                        String str = "friendjsplugin delete notify not success, return code = " + acsDelMsgRsp.ret_code;
                                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createExceptionResult(new Throwable(str)));
                                        QLog.i("MiniAppTransferModule", 1, str);
                                        return;
                                    }
                                } catch (Exception e16) {
                                    MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createExceptionResult(e16));
                                    QLog.e("MiniAppTransferModule", 1, "friendjsplugin sendDelReminderListById onReceive", e16);
                                    return;
                                }
                            }
                            MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createExceptionResult(new Throwable("qqnotify delete faield not success")));
                            QLog.i("MiniAppTransferModule", 1, "friendjsplugin qqnotify delete faield not success ");
                        }
                    }
                });
                return;
            }
        }
        callbackResult(i3, EIPCResult.createExceptionResult(new Throwable(QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR)));
    }

    private String findPkgNameFromGameId(String str) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            for (MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig : miniGameVAInterceptConfig.getInterceptConfigMap().values()) {
                if (TextUtils.equals(str, vAInterceptConfig.getGameAppId())) {
                    return vAInterceptConfig.getGameAppPkgName();
                }
            }
        }
        return "";
    }

    public static MiniAppTransferModule getInstance() {
        if (sInstance == null) {
            synchronized (MiniAppTransferModule.class) {
                if (sInstance == null) {
                    sInstance = new MiniAppTransferModule("MiniAppTransferModule");
                }
            }
        }
        return sInstance;
    }

    private IMiniGameVAService getVAService(AppRuntime appRuntime) {
        try {
            return (IMiniGameVAService) appRuntime.getRuntimeService(IMiniGameVAService.class, "");
        } catch (Exception e16) {
            QLog.e("MiniAppTransferModule", 1, "getVAService e:", e16);
            return null;
        }
    }

    private EIPCResult innerOnCall(QQAppInterface qQAppInterface, String str, Bundle bundle, int i3) {
        str.hashCode();
        if (!str.equals(ACTION_PA_FOLLOW)) {
            if (!str.equals(ACTION_PA_IS_FOLLOW)) {
                return null;
            }
            PublicAccountUtil.isPAFollow(qQAppInterface, bundle, this, i3);
            return null;
        }
        PublicAccountUtil.followPA(qQAppInterface, bundle, this, i3);
        return null;
    }

    private void isGroupMember(Bundle bundle, final int i3) {
        String string = bundle.getString("appId");
        String string2 = bundle.getString("openGid");
        MiniAppGetGroupInfoReq miniAppGetGroupInfoReq = new MiniAppGetGroupInfoReq();
        miniAppGetGroupInfoReq.appID = Integer.parseInt(string);
        MiniAppGroupInfoReq miniAppGroupInfoReq = new MiniAppGroupInfoReq();
        miniAppGroupInfoReq.groupOpenID = string2.getBytes();
        miniAppGetGroupInfoReq.groupInfoReqList = new ArrayList<>(Collections.singletonList(miniAppGroupInfoReq));
        s groupService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getGroupService();
        if (groupService != null) {
            groupService.miniAppGetGroupInfo(miniAppGetGroupInfoReq, new IMiniAppGetGroupInfoCallback() { // from class: com.tencent.mobileqq.mini.reuse.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMiniAppGetGroupInfoCallback
                public final void onResult(int i16, String str, MiniAppGetGroupInfoRsp miniAppGetGroupInfoRsp) {
                    MiniAppTransferModule.this.lambda$isGroupMember$6(i3, i16, str, miniAppGetGroupInfoRsp);
                }
            });
        } else {
            QLog.d("MiniAppTransferModule", 1, "IsGroupMember groupService is null!");
        }
        QLog.i("MiniAppTransferModule", 1, "IsGroupMember appId:" + string + " openGroupId:" + string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isGroupMember$6(int i3, int i16, String str, MiniAppGetGroupInfoRsp miniAppGetGroupInfoRsp) {
        QLog.i("MiniAppTransferModule", 1, "errCode:" + i16 + " errMsg:" + str + " rsp:" + miniAppGetGroupInfoRsp);
        Bundle bundle = new Bundle();
        if (i16 != 0) {
            bundle.putInt("errorCode", i16);
            bundle.getString("errorMsg", str);
            callbackResult(i3, EIPCResult.createResult(-102, bundle));
            return;
        }
        if (miniAppGetGroupInfoRsp.getGroupInfoRspList().isEmpty()) {
            bundle.putBoolean("IsGroupMember", false);
        } else {
            MemberRole memberRole = miniAppGetGroupInfoRsp.getGroupInfoRspList().get(0).getMemberInfo().getMemberRole();
            QLog.i("MiniAppTransferModule", 1, "openGroupId:" + PluginBaseInfoHelper.Base64Helper.encodeToString(miniAppGetGroupInfoRsp.getGroupInfoRspList().get(0).getMiniAppGroupInfoReq().groupOpenID, 0));
            if (memberRole != MemberRole.UNSPECIFIED && memberRole != MemberRole.STRANGER) {
                if (memberRole == MemberRole.ADMIN || memberRole == MemberRole.MEMBER || memberRole == MemberRole.OWNER) {
                    bundle.putBoolean("IsGroupMember", true);
                }
            } else {
                bundle.putBoolean("IsGroupMember", false);
            }
        }
        callbackResult(i3, EIPCResult.createResult(0, bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCall$0(Bundle bundle, int i3) {
        bundle.putInt("callbackId", i3);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).setMiniAppTransferModuleEvent(ACTION_SYNC_MINI_APP_DATA, bundle, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCall$2() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            return;
        }
        dq.a(topActivity, 0, "\u63d0\u793a", "\u8fd0\u884c\u5185\u5b58\u4e0d\u8db3\u5bfc\u81f4\u8be5\u5c0f\u6e38\u620f\u65e0\u6cd5\u4f7f\u7528", -1, R.string.xyn, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.reuse.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCall$4(String str, int i3, Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
        QLog.i("MiniAppTransferModule", 1, "queryCanUpdateVA gameId:" + str + ", success:" + bool + ", data:" + miniGameDownloadDataWrapper);
        if (bool.booleanValue() && miniGameDownloadDataWrapper != null) {
            Bundle bundle = new Bundle();
            bundle.putString(VirtualAppProxy.KEY_GAME_ID, miniGameDownloadDataWrapper.getData().getGameId());
            bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, miniGameDownloadDataWrapper.getDownloadStatus());
            bundle.putInt("progress", miniGameDownloadDataWrapper.getProgress());
            bundle.putString(VirtualAppProxy.KEY_GAME_VERSION_CODE, miniGameDownloadDataWrapper.getData().getVersionCode());
            bundle.putLong(VirtualAppProxy.KEY_PKG_SIZE, miniGameDownloadDataWrapper.getData().getSize());
            bundle.putLong("downloadSize", miniGameDownloadDataWrapper.getData().getDownloadSize());
            callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        } else {
            callbackResult(i3, EIPCResult.createResult(-102, null));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCall$5(int i3, Boolean bool, String str) {
        callbackResult(i3, EIPCResult.createResult(bool.booleanValue() ? 0 : -1, new Bundle()));
        return null;
    }

    private void updateNoDisturbMode(boolean z16, int i3) {
        boolean c16 = FriendsStatusUtil.c(BaseApplication.getContext());
        if (c16 == z16) {
            QLog.d("MiniAppTransferModule", 1, "noDisturbMode : " + c16 + "; return.");
            Bundle bundle = new Bundle();
            bundle.putString("errMsg", "same mode");
            callbackResult(i3, EIPCResult.createResult(-102, bundle));
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            int netWorkType = HttpUtil.getNetWorkType();
            if (netWorkType == -1) {
                netWorkType = 2;
            }
            if (netWorkType == 0) {
                QLog.d("MiniAppTransferModule", 1, "NetType cannot connect, return.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("errMsg", "Network cannot connect");
                callbackResult(i3, EIPCResult.createResult(-102, bundle2));
                return;
            }
            if (this.mSendingRequest.compareAndSet(true, true)) {
                QLog.d("MiniAppTransferModule", 1, "Request too frequently, return.");
                Bundle bundle3 = new Bundle();
                bundle3.putString("errMsg", "Request too frequently");
                callbackResult(i3, EIPCResult.createResult(-102, bundle3));
                return;
            }
            this.mSendingRequest.set(true);
            qQAppInterface.addObserver(this.cardObserver, true);
            this.noDisturbModeCallbackId = i3;
            if (z16) {
                ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4((int) (NetConnInfoCenter.getServerTime() + 3600), "", "not_disturb_from_miniapp");
            } else {
                ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4(0, "", "not_disturb_from_miniapp");
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, final Bundle bundle, final int i3) {
        MiniGameVaHotfixDownloadCallback miniGameVaHotfixDownloadCallback;
        MiniGameVaHotfixDownloadCallback miniGameVaHotfixDownloadCallback2;
        MiniGameVaHotfixDownloadCallback miniGameVaHotfixDownloadCallback3;
        StatusListener statusListener;
        StatusListener statusListener2;
        QLog.d("MiniAppTransferModule", 2, "action = " + str + ", params = " + bundle + ", callbackId = " + i3);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        if (ACTION_VA_QUERY_DOWNLOAD_STATE.equals(str)) {
            final String string = bundle.getString("appId");
            final String string2 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
            IMiniGameVAService vAService = getVAService(runtime);
            if (vAService == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            vAService.queryVAInfo(string, new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.1
                @Override // kotlin.jvm.functions.Function2
                public Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                    QLog.i("MiniAppTransferModule", 1, "queryVAInfo callback:" + string + " gameId:" + string2);
                    if (!bool.booleanValue()) {
                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                        return null;
                    }
                    if (miniGameDownloadDataWrapper != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(VirtualAppProxy.KEY_GAME_ID, miniGameDownloadDataWrapper.getData().getGameId());
                        bundle2.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, miniGameDownloadDataWrapper.getDownloadStatus());
                        bundle2.putInt("progress", miniGameDownloadDataWrapper.getProgress());
                        bundle2.putString(VirtualAppProxy.KEY_GAME_VERSION_CODE, miniGameDownloadDataWrapper.getData().getVersionCode());
                        bundle2.putLong(VirtualAppProxy.KEY_PKG_SIZE, miniGameDownloadDataWrapper.getData().getSize());
                        bundle2.putLong("downloadSize", miniGameDownloadDataWrapper.getData().getDownloadSize());
                        bundle2.putInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE, miniGameDownloadDataWrapper.getScene());
                        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
                        if (miniGameVAInterceptConfig != null) {
                            bundle2.putInt(VirtualAppProxy.KEY_AUTO_DOWNLOAD, miniGameVAInterceptConfig.getAutoDownload());
                            bundle2.putInt(VirtualAppProxy.KEY_DOWNLOAD_TYPE_ON_WIFI, miniGameVAInterceptConfig.getDownloadTypeOnWifi());
                        }
                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(0, bundle2));
                        return null;
                    }
                    MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                    return null;
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_QUERY_DOWNLOAD_STATE appId:" + string + " gameId:" + string2);
            }
        }
        if (ACTION_VA_START_DOWNLOAD.equals(str)) {
            IMiniGameVAService vAService2 = getVAService(runtime);
            if (vAService2 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            String string3 = bundle.getString(VirtualAppProxy.KEY_GAME_ID, "");
            Boolean valueOf = bundle.containsKey("download_need_install") ? Boolean.valueOf(bundle.getBoolean("download_need_install", false)) : null;
            Boolean valueOf2 = bundle.containsKey("download_only_wifi") ? Boolean.valueOf(bundle.getBoolean("download_only_wifi", false)) : null;
            int i16 = bundle.getInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE, DownloadScene.SCENE_INSTALL_UNKNOW.getScene());
            boolean z16 = bundle.getBoolean("download_auto_resume", true);
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_START_DOWNLOAD gameId:" + string3);
            }
            vAService2.startDownload(string3, valueOf, valueOf2, i16, z16);
        }
        if (ACTION_VA_STOP_DOWNLOAD.equals(str)) {
            IMiniGameVAService vAService3 = getVAService(runtime);
            if (vAService3 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            String string4 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_STOP_DOWNLOAD gameId:" + string4);
            }
            vAService3.pauseDownload(string4);
        }
        if (ACTION_VA_CANCEL_DOWNLOAD.equals(str)) {
            IMiniGameVAService vAService4 = getVAService(runtime);
            if (vAService4 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            String string5 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_CANCEL_DOWNLOAD gameId:" + string5);
            }
            vAService4.cancelDownload(string5);
        }
        if (ACTION_VA_RESTART_DOWNLOAD.equals(str)) {
            final IMiniGameVAService vAService5 = getVAService(runtime);
            if (vAService5 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            final String string6 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
            String string7 = bundle.getString("appId");
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_RESTART_DOWNLOAD gameId:" + string6 + " appId:" + string7);
            }
            vAService5.queryVAInfo(string7, new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.2
                @Override // kotlin.jvm.functions.Function2
                public Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                    if (!bool.booleanValue()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("retCode", -1);
                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(-102, bundle2));
                    } else if (miniGameDownloadDataWrapper != null) {
                        vAService5.launchVA(miniGameDownloadDataWrapper, null);
                        QLog.i("MiniAppTransferModule", 1, "MiniGameVAManager launchVA gameId:" + string6);
                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(0, new Bundle()));
                    } else {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("retCode", -2);
                        MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(-102, bundle3));
                    }
                    return null;
                }
            });
        }
        if (ACTION_VA_ADD_DOWNLOAD_LISTENER.equals(str)) {
            IMiniGameVAService vAService6 = getVAService(runtime);
            if (vAService6 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
            final String string8 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
            final MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("mini_app_info");
            final ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("receiver");
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_ADD_DOWNLOAD_LISTENER gameId:" + string8);
            }
            StatusListener statusListener3 = new StatusListener() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.3
                @Override // com.tencent.mobileqq.minigame.va.StatusListener
                public void onStatusChanged(MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniAppTransferModule", 2, "ACTION_VA_ADD_DOWNLOAD_LISTENER onStatusChanged dataWrapper:" + miniGameDownloadDataWrapper.getData());
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(VirtualAppProxy.KEY_GAME_ID, string8);
                    bundle2.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, miniGameDownloadDataWrapper.getDownloadStatus());
                    bundle2.putInt("progress", miniGameDownloadDataWrapper.getProgress());
                    bundle2.putLong(VirtualAppProxy.KEY_PKG_SIZE, miniGameDownloadDataWrapper.getData().getSize());
                    bundle2.putLong("downloadSize", miniGameDownloadDataWrapper.getData().getDownloadSize());
                    bundle2.putString(VirtualAppProxy.KEY_GAME_VERSION_CODE, miniGameDownloadDataWrapper.getData().getVersionCode());
                    IMiniServer miniServer = AppLoaderFactory.g().getMiniServer();
                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                    if (miniAppInfo2 != null && miniServer != null) {
                        miniServer.sendCmdToMiniProcess(1003, bundle2, miniAppInfo2, null);
                    }
                    ResultReceiver resultReceiver2 = resultReceiver;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, bundle2);
                    }
                }
            };
            WeakReference<StatusListener> remove = this.gameIdToListeners.remove(string8);
            if (remove != null && (statusListener2 = remove.get()) != null) {
                vAService6.unregisterStatusListener(string8, statusListener2);
            }
            this.gameIdToListeners.put(string8, new WeakReference<>(statusListener3));
            vAService6.registerStatusListener(string8, statusListener3);
        }
        if (ACTION_VA_REMOVE_DOWNLOAD_LISTENER.equals(str)) {
            IMiniGameVAService vAService7 = getVAService(runtime);
            if (vAService7 == null) {
                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                return null;
            }
            String string9 = bundle.getString(VirtualAppProxy.KEY_GAME_ID, "");
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_REMOVE_DOWNLOAD_LISTENER gameId:" + string9);
            }
            WeakReference<StatusListener> remove2 = this.gameIdToListeners.remove(string9);
            if (remove2 != null && (statusListener = remove2.get()) != null) {
                vAService7.unregisterStatusListener(string9, statusListener);
            }
        } else if (ACTION_UPDATE_ENTRY_LIST.equals(str)) {
            try {
                String optString = new JSONObject(bundle.getString("data")).optString("command");
                if (MiniAppConfProcessor.m()) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).setMiniAppTransferModuleEvent(str, bundle, new EIPCModule(str) { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.4
                        @Override // eipc.EIPCModule
                        public EIPCResult onCall(String str2, Bundle bundle2, int i17) {
                            QLog.i("MiniAppTransferModule", 2, "onCall action:" + str2);
                            return null;
                        }
                    });
                } else if (NOTIFY_NATIVE_UPDATEAPPLIST.equals(optString)) {
                    ((MiniAppUserAppInfoListManager) runtime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)).sendUserAppListRequest(Long.parseLong(((QQAppInterface) runtime).getCurrentAccountUin()), 20L);
                }
            } catch (Exception e16) {
                QLog.e("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface", e16);
            }
        } else if (ACTION_SYNC_MINI_APP_DATA.equals(str)) {
            String string10 = bundle.getString("appid");
            int i17 = bundle.getInt(MiniChatConstants.MINI_APP_TOP_TYPE);
            int i18 = bundle.getInt("verType");
            if (MiniAppConfProcessor.m()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppTransferModule.this.lambda$onCall$0(bundle, i3);
                    }
                });
            } else {
                MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) runtime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
                if (miniAppUserAppInfoListManager != null && !TextUtils.isEmpty(string10)) {
                    if (i17 == 1 && miniAppUserAppInfoListManager.getTopMiniAppNumber() >= 10) {
                        callbackResult(i3, EIPCResult.createResult(-100, null));
                        return null;
                    }
                    com.tencent.mobileqq.mini.apkg.MiniAppInfo findMiniApp = miniAppUserAppInfoListManager.findMiniApp(string10, i18);
                    QLog.d("MiniAppTransferModule", 2, "miniappInfo : " + findMiniApp);
                    if (findMiniApp != null) {
                        findMiniApp.topType = i17;
                        if (i17 == 1) {
                            findMiniApp.updateTimeStamp();
                        }
                        miniAppUserAppInfoListManager.updateMiniAppTopStatus(findMiniApp);
                        callbackResult(i3, EIPCResult.createResult(0, null));
                    }
                }
            }
        } else if (ACTION_QUERY_MINI_APP_DATA.equals(str)) {
            String string11 = bundle.getString("appid");
            bundle.getInt("verType");
            if (MiniAppConfProcessor.m()) {
                bundle.putInt("callbackId", i3);
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).setMiniAppTransferModuleEvent(ACTION_QUERY_MINI_APP_DATA, bundle, this);
            } else {
                MiniAppUserAppInfoListManager miniAppUserAppInfoListManager2 = (MiniAppUserAppInfoListManager) runtime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
                if (miniAppUserAppInfoListManager2 != null && !TextUtils.isEmpty(string11)) {
                    try {
                        com.tencent.mobileqq.mini.apkg.MiniAppInfo findTopMiniApp = miniAppUserAppInfoListManager2.findTopMiniApp(string11);
                        QLog.d("MiniAppTransferModule", 2, "miniappInfo : " + findTopMiniApp);
                        Bundle bundle2 = new Bundle();
                        if (findTopMiniApp != null) {
                            bundle2.putParcelable("miniappinfo", findTopMiniApp);
                            bundle2.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, 1);
                        } else {
                            bundle2.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, 0);
                        }
                        ArrayList<Integer> a16 = MiniAppConfProcessor.j().a();
                        if (a16 != null) {
                            bundle2.putIntegerArrayList("backHomeSceneList", a16);
                        }
                        callbackResult(i3, EIPCResult.createResult(0, bundle2));
                    } catch (Throwable unused) {
                        callbackResult(i3, EIPCResult.createResult(-102, null));
                    }
                }
            }
        } else if (ACTION_UPLOAD_USER_LOG.equals(str)) {
            String string12 = bundle.getString("appid");
            QLog.d("MiniAppTransferModule", 2, " ACTION_UPLOAD_USER_LOG : " + string12);
            ReportLogUtil.compressAndUploadLog(string12);
        } else if ("launch_report".equals(str)) {
            bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
            MiniAppReportManager.reportToDc04239((MiniAppConfig) bundle.getParcelable("app_config"), bundle.getString("path"), "page_view", bundle.getString("sub_action"), bundle.getString("reserves"), bundle.getString("app_type"), bundle.getBoolean("x5_enable"));
        } else if ("launch_report2".equals(str)) {
            bundle.setClassLoader(MiniAppReportManager2.class.getClassLoader());
            MiniAppReportManager2.reportPageView(bundle.getString("sub_action"), bundle.getString("reserves"), bundle.getString("path"), (MiniAppConfig) bundle.getParcelable("app_config"));
        } else if (ACTION_LAUNCH_REPORT_JS_ERROR.equals(str)) {
            bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
            MiniAppReportManager.setJsError((MiniAppConfig) bundle.getParcelable("app_config"));
        } else if (ACTION_LAUNCH_REPORT_APP_PAUSE.equals(str)) {
            bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
            MiniAppReportManager.setAppPauseTime((MiniAppConfig) bundle.getParcelable("app_config"));
        } else if (ACTION_LAUNCH_REPORT_APP_RESUME.equals(str)) {
            bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
            MiniAppReportManager.clearAppPauseTime((MiniAppConfig) bundle.getParcelable("app_config"));
        } else if (ACTION_FLUSH_REPORT_DATA.equals(str)) {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.5
                @Override // java.lang.Runnable
                public void run() {
                    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
                }
            });
        } else if ("record_duration".equals(str)) {
            bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
            MiniAppReportManager.recordDuration((MiniAppConfig) bundle.getParcelable("app_config"), bundle.getLong("add_duration_ms"));
        } else {
            try {
                if ("launch_report_sdk_4239".equals(str)) {
                    bundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                    MiniAppInfo miniAppInfo2 = (MiniAppInfo) bundle.getParcelable("app_config");
                    String string13 = bundle.getString("sub_action");
                    String string14 = bundle.getString("path");
                    String string15 = bundle.getString("reserves");
                    String string16 = bundle.getString("app_type");
                    boolean z17 = bundle.getBoolean("x5_enable");
                    MiniAppConfig h16 = aq.h(miniAppInfo2);
                    if (h16 != null) {
                        MiniAppReportManager.reportToDc04239(h16, string14, "page_view", string13, string15, string16, z17);
                    }
                } else if ("record_duration_sdk_4239".equals(str)) {
                    bundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                    MiniAppInfo miniAppInfo3 = (MiniAppInfo) bundle.getParcelable("app_config");
                    long j3 = bundle.getLong("add_duration_ms");
                    MiniAppConfig h17 = aq.h(miniAppInfo3);
                    if (h17 != null) {
                        MiniAppReportManager.recordDuration(h17, j3);
                    }
                } else if (ACTION_QUERY_USER_TROOP_INFO.equals(str)) {
                    try {
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean("hasCreateOrManageTroop", TroopUtils.m());
                        callbackResult(i3, EIPCResult.createResult(0, bundle3));
                    } catch (Exception unused2) {
                        callbackResult(i3, EIPCResult.createResult(-102, null));
                    }
                } else if (ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK.equals(str)) {
                    try {
                        bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
                        WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromSDK((MiniAppInfo) bundle.getParcelable("MiniAppInfoForSDK"));
                    } catch (Exception e17) {
                        QLog.e("MiniAppTransferModule", 1, "ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK get an exception:" + e17.toString());
                    }
                } else if (ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ.equals(str)) {
                    try {
                        bundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
                        WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromQQ((com.tencent.mobileqq.mini.apkg.MiniAppInfo) bundle.getParcelable("MiniAppInfoForQQ"), (LaunchParam) bundle.getParcelable("MiniAppLaunchParamForQQ"));
                    } catch (Exception e18) {
                        QLog.e("MiniAppTransferModule", 1, "ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ get an exception:" + e18.toString());
                    }
                } else if (ACTION_SHOW_MEMORY_DIALOG.equals(str)) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniAppTransferModule.lambda$onCall$2();
                        }
                    }, 5000L);
                } else if (ACTION_DELETE_QQ_NOTIFY.equals(str)) {
                    deleteQQNotifyAction(bundle, i3);
                } else {
                    if (ACTION_GET_MAIN_SERVICE_API.equals(str)) {
                        return MiniAppMainServiceApiManager.INSTANCE.buildServiceApiEIPCResult();
                    }
                    if (ACTION_CHECK_IS_IN_MY_APP_LIST.equals(str)) {
                        bundle.putInt("callbackId", i3);
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).setMiniAppTransferModuleEvent(ACTION_CHECK_IS_IN_MY_APP_LIST, bundle, this);
                    } else if (ACTION_CHECK_IS_GROUP_MEMBER.equals(str)) {
                        isGroupMember(bundle, i3);
                    } else if (ACTION_CHECK_META_GUIDE_BUBBLE_RED_TOUCH.equals(str)) {
                        ((IMiniGameMetaGuideBubbleApi) QRoute.api(IMiniGameMetaGuideBubbleApi.class)).checkRedTouchWhenExit();
                        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).updateWidgetData(2);
                    } else if (NOTIFY_HOME_REPORT_ACCOUNT_CHANGE.equals(str)) {
                        MiniGameHomeReportService.INSTANCE.recordAccountUpdate();
                    } else if (ACTION_STARTUP_REPORT.equals(str)) {
                        bundle.setClassLoader(StartupReportData.class.getClassLoader());
                        StartupReportData startupReportData = (StartupReportData) bundle.getParcelable("data");
                        if (startupReportData != null) {
                            StartupReportDispatcher.reportAsync(startupReportData);
                        } else {
                            QLog.e("MiniAppTransferModule", 1, "ACTION_STARTUP_REPORT fail param is null.");
                        }
                    } else if (ACTION_SHARE_TO_Q_CIRCLE.equals(str)) {
                        if (this.qCircleShareHelper == null) {
                            this.qCircleShareHelper = new MiniGameQCircleShareHelper();
                        }
                        if (!this.qCircleShareHelper.doShareToQCircle(bundle, i3, new MiniGameQCircleShareHelper.Callback() { // from class: com.tencent.mobileqq.mini.reuse.m
                            @Override // com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper.Callback
                            public final void onComplete(int i19, int i26) {
                                MiniAppTransferModule.this.lambda$onCall$3(i19, i26);
                            }
                        })) {
                            callbackResult(i3, EIPCResult.createResult(1, null));
                        }
                    } else if (ACTION_LETS_GO_RES_START_DOWNLOAD.equals(str)) {
                        String string17 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
                        if ("com.tencent.letsgo".equals(findPkgNameFromGameId(string17))) {
                            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).startDownloadRes();
                        } else {
                            QLog.i("MiniAppTransferModule", 1, "ACTION_LETS_GO_RES_START_DOWNLOAD not meta dream service gameId:" + string17);
                            WeakReference<MiniGameVaHotfixDownloadCallback> remove3 = this.gameIdToHotFixListeners.remove(string17);
                            if (remove3 != null && (miniGameVaHotfixDownloadCallback3 = remove3.get()) != null) {
                                miniGameVaHotfixDownloadCallback3.onDownloadComplete(2);
                            }
                        }
                    } else if (ACTION_LETS_GO_RES_STOP_DOWNLOAD.equals(str)) {
                        String string18 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
                        if ("com.tencent.letsgo".equals(findPkgNameFromGameId(string18))) {
                            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).stopDownloadRes();
                        } else {
                            QLog.i("MiniAppTransferModule", 1, "ACTION_LETS_GO_RES_STOP_DOWNLOAD not meta dream service gameId:" + string18);
                        }
                    } else if (ACTION_LETS_GO_RES_PAUSE_DOWNLOAD.equals(str)) {
                        String string19 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
                        if ("com.tencent.letsgo".equals(findPkgNameFromGameId(string19))) {
                            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).pauseDownloadRes();
                        } else {
                            QLog.i("MiniAppTransferModule", 1, "ACTION_LETS_GO_RES_PAUSE_DOWNLOAD not meta dream service gameId:" + string19);
                        }
                    } else if (ACTION_LETS_GO_RES_REGISTER_CALLBACK.equals(str)) {
                        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
                        MiniAppInfo miniAppInfo4 = (MiniAppInfo) bundle.getParcelable("mini_app_info");
                        String string20 = bundle.getString(VirtualAppProxy.KEY_GAME_ID, "");
                        WeakReference<MiniGameVaHotfixDownloadCallback> remove4 = this.gameIdToHotFixListeners.remove(string20);
                        if (remove4 != null && (miniGameVaHotfixDownloadCallback2 = remove4.get()) != null) {
                            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).unregisterDownloadCallback(miniGameVaHotfixDownloadCallback2);
                        }
                        MiniGameVaHotfixDownloadCallback miniGameVaHotfixDownloadCallback4 = new MiniGameVaHotfixDownloadCallback();
                        miniGameVaHotfixDownloadCallback4.setAppInfo(miniAppInfo4);
                        this.gameIdToHotFixListeners.put(string20, new WeakReference<>(miniGameVaHotfixDownloadCallback4));
                        if ("com.tencent.letsgo".equals(findPkgNameFromGameId(string20))) {
                            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).registerDownloadCallback(miniGameVaHotfixDownloadCallback4);
                        } else {
                            QLog.i("MiniAppTransferModule", 1, "ACTION_LETS_GO_RES_REGISTER_CALLBACK not meta dream service gameId:" + string20);
                        }
                    } else if (ACTION_LETS_GO_RES_UNREGISTER_CALLBACK.equals(str)) {
                        String string21 = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
                        if ("com.tencent.letsgo".equals(findPkgNameFromGameId(string21))) {
                            WeakReference<MiniGameVaHotfixDownloadCallback> remove5 = this.gameIdToHotFixListeners.remove(string21);
                            if (remove5 != null && (miniGameVaHotfixDownloadCallback = remove5.get()) != null) {
                                ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).unregisterDownloadCallback(miniGameVaHotfixDownloadCallback);
                            }
                        } else {
                            QLog.i("MiniAppTransferModule", 1, "ACTION_LETS_GO_RES_UNREGISTER_CALLBACK not meta dream service gameId:" + string21);
                        }
                    } else {
                        if (ACTION_VA_QUERY_CRASH_BLOCK.equals(str)) {
                            return EIPCResult.createResult(((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).isCrashProtectBlock(BaseApplication.getContext(), bundle.getString("appId"), false) ? 1 : 0, null);
                        }
                        if (ACTION_VA_QUERY_CAN_UPDATE_VA.equals(str)) {
                            final String string22 = bundle.getString("appId", "");
                            if (QLog.isColorLevel()) {
                                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_QUERY_AND_UPDATE_VA_SILENCE appId:" + string22);
                            }
                            IMiniGameVAService vAService8 = getVAService(runtime);
                            if (vAService8 == null) {
                                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                                return null;
                            }
                            vAService8.queryCanUpdateVA(string22, new Function2() { // from class: com.tencent.mobileqq.mini.reuse.n
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit lambda$onCall$4;
                                    lambda$onCall$4 = MiniAppTransferModule.this.lambda$onCall$4(string22, i3, (Boolean) obj, (MiniGameDownloadDataWrapper) obj2);
                                    return lambda$onCall$4;
                                }
                            });
                        } else if (ACTION_VA_RESTART_AND_INSTALL_VA.equals(str)) {
                            IMiniGameVAService vAService9 = getVAService(runtime);
                            if (vAService9 == null) {
                                callbackResult(i3, EIPCResult.createResult(-102, new Bundle()));
                                return null;
                            }
                            String string23 = bundle.getString("appId", "");
                            String string24 = bundle.getString(VirtualAppProxy.KEY_GAME_ID, "");
                            String string25 = bundle.getString(VirtualAppProxy.KEY_GAME_VERSION_CODE, "");
                            if (QLog.isColorLevel()) {
                                QLog.d("MiniAppTransferModule", 2, "ACTION_VA_RESTART_AND_INSTALL_VA appId:" + string23 + ", gameId:" + string24);
                            }
                            vAService9.restartAndInstallVA(string23, string24, string25, new Function2() { // from class: com.tencent.mobileqq.mini.reuse.o
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit lambda$onCall$5;
                                    lambda$onCall$5 = MiniAppTransferModule.this.lambda$onCall$5(i3, (Boolean) obj, (String) obj2);
                                    return lambda$onCall$5;
                                }
                            });
                        } else if (ACTION_LETS_GO_RED_INFO.equals(str)) {
                            String letsGoRedInfo = ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).getLetsGoRedInfo();
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("BundleData", letsGoRedInfo);
                            callbackResult(i3, EIPCResult.createSuccessResult(bundle4));
                        } else if (ACTION_UNZIP_WXA_DYNAMIC_PACKAGE.equals(str)) {
                            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).unzipDynamicPackage(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.6
                                @Override // com.tencent.mobileqq.wxmini.api.data.b
                                public void onCallback(boolean z18, Bundle bundle5) {
                                    MiniAppTransferModule.this.callbackResult(i3, EIPCResult.createResult(z18 ? 0 : -102, bundle5));
                                }
                            });
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        }
        return innerOnCall((QQAppInterface) runtime, str, bundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCall$3(int i3, int i16) {
        callbackResult(i3, EIPCResult.createResult(i16, null));
    }
}
