package com.tencent.hippy.qq.module.gamecenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.gamecenter.api.k;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgAppFragment;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(init = true, name = "QQGameCenterModule")
/* loaded from: classes7.dex */
public class QQGameCenterModule extends QQBaseWebIpcModule implements HippyActivityLifecycleListener {
    static final String CLASSNAME = "QQGameCenterModule";
    private static final SparseArray<Integer> FRIEND_TYPE_MAP = new SparseArray<Integer>() { // from class: com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule.1
        {
            put(0, 1);
            put(1, 2);
            put(10018, 3);
        }
    };
    static final String GAME_CENTER_EVENT_MSG_CHANGE = "QQGameCenter_sessionChanged";
    static final String GAME_CENTER_EVENT_MSG_UNREAD_CNT = "QQGameCenter_newMsgCountChanged";
    private static final byte REQ_CODE_CHOOSE_FRIEND = 16;
    public static final String TAG = "QQGameCenterModule";
    private IYunGameManagerService.b mGameStateListener;
    private Promise mGetFriendInfoPromise;
    boolean mIsInMainProcess;
    private MessageBroadcastReceiver mMsgReceiver;
    private com.tencent.mobileqq.qroute.module.c mPluginListener;
    Bundle mReqBundle;
    private IYunGameManagerService.a mRestartCallBack;
    private IYunGameManagerService.a mStartCallBack;
    private IYunGameManagerService.a mStopCallBack;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class MessageBroadcastReceiver extends BroadcastReceiver {
        private WeakReference<QQGameCenterModule> weakRefModule;

        public MessageBroadcastReceiver(QQGameCenterModule qQGameCenterModule) {
            this.weakRefModule = new WeakReference<>(qQGameCenterModule);
        }

        private HippyQQEngine getHippyQQEngine() {
            QQGameCenterModule qQGameCenterModule = this.weakRefModule.get();
            if (qQGameCenterModule != null) {
                return qQGameCenterModule.getHippyQQEngine();
            }
            return null;
        }

        public void onDestroy() {
            this.weakRefModule.clear();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            JSONObject parseGameMessageUnreadCount;
            JSONObject parseGameMessageChange;
            String action = intent.getAction();
            HippyQQEngine hippyQQEngine = getHippyQQEngine();
            if (action != null && hippyQQEngine != null && ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isQQGameCenterBundle(hippyQQEngine.getModuleName())) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameCenterModule", 2, "[onRecevier] action:" + action + ",data:" + intent.getExtras());
                }
                if ("action_qgame_messgae_change".equals(action)) {
                    Bundle extras = intent.getExtras();
                    if (!extras.getBoolean("is_update_publicaccount_only", false) && (parseGameMessageChange = GameCenterAPIJavaScript.parseGameMessageChange(extras)) != null) {
                        HippyMap hippyMap = new HippyMap();
                        hippyMap.pushJSONObject(parseGameMessageChange);
                        hippyQQEngine.sendEvent(QQGameCenterModule.GAME_CENTER_EVENT_MSG_CHANGE, hippyMap);
                        return;
                    }
                    return;
                }
                if ("action_qgame_unread_change".equals(action) && (parseGameMessageUnreadCount = GameCenterAPIJavaScript.parseGameMessageUnreadCount(intent.getExtras())) != null) {
                    HippyMap hippyMap2 = new HippyMap();
                    hippyMap2.pushJSONObject(parseGameMessageUnreadCount);
                    hippyQQEngine.sendEvent(QQGameCenterModule.GAME_CENTER_EVENT_MSG_UNREAD_CNT, hippyMap2);
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QQGameCenterModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext, r0);
        boolean z16;
        if (MobileQQ.sProcessId != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mReqBundle = new Bundle();
        this.mIsInMainProcess = MobileQQ.sProcessId == 1;
        this.mMsgReceiver = new MessageBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_qgame_messgae_change");
        intentFilter.addAction("action_qgame_unread_change");
        BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, intentFilter);
        bindLifecycleListener();
    }

    private void clickCommonSessionByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        Bundle bundle = this.mReqBundle;
        if (hippyMap.containsKey("sessionId")) {
            str = hippyMap.getString("sessionId");
        } else {
            str = "";
        }
        bundle.putString("sessionId", str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_open_aio", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void clickCommonSessionInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        String str2 = "";
        if (!hippyMap.containsKey("sessionId")) {
            str = "";
        } else {
            str = hippyMap.getString("sessionId");
        }
        JSONObject parseClickCommonSessionRsp = parseClickCommonSessionRsp(((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).openGameCenterAIO((QQAppInterface) appInterface, str));
        if (promise != null) {
            if (parseClickCommonSessionRsp != null) {
                str2 = parseClickCommonSessionRsp.toString();
            }
            promise.resolve(str2);
        }
    }

    private void delSessionByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        Bundle bundle = this.mReqBundle;
        if (hippyMap.containsKey("sessionList")) {
            str = hippyMap.getString("sessionList");
        } else {
            str = "";
        }
        bundle.putString("sessionList", str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_del_game_session", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void delSessionInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[delSessionInMainProcess]");
        }
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        if (hippyMap.containsKey("sessionList")) {
            str = hippyMap.getString("sessionList");
        } else {
            str = "";
        }
        MessengerService.F((QQAppInterface) appInterface, str);
    }

    private void getMetaDreamUnreadMsgInfoByIpc(HippyMap hippyMap, Promise promise) {
        QLog.d("QQGameCenterModule", 2, "getMetaDreamUnreadMsgInfoByIpc");
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_metadream_get_session_unread_info", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void getMetaDreamUnreadMsgInfoInMainProcess(HippyMap hippyMap, Promise promise) {
        QLog.d("QQGameCenterModule", 2, "getMetaDreamUnreadMsgInfoInMainProcess");
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        String str = "";
        JSONObject parseGetMetaDreamUnreadMsgInfo = parseGetMetaDreamUnreadMsgInfo(((IMetaDreamService) appInterface.getRuntimeService(IMetaDreamService.class, "")).getMetaDreamUnreadMsgInfoBundle());
        if (promise != null) {
            if (parseGetMetaDreamUnreadMsgInfo != null) {
                str = parseGetMetaDreamUnreadMsgInfo.toString();
            }
            promise.resolve(str);
        }
    }

    private void getNewMsgCountByIpc(Promise promise) {
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_unread_total", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void getNewMsgCountInMainProcess(Promise promise) {
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        String str = "";
        JSONObject parseGetNewMsgCountRsp = parseGetNewMsgCountRsp(((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterUnreadTotal());
        if (promise != null) {
            if (parseGetNewMsgCountRsp != null) {
                str = parseGetNewMsgCountRsp.toString();
            }
            promise.resolve(str);
        }
    }

    private void getRequestDataByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        int saveCallback = saveCallback(promise);
        if (hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        } else {
            str = "";
        }
        this.mReqBundle.clear();
        this.mReqBundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_request_info", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void getRequestDataInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        String str2 = "";
        if (!hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = "";
        } else {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        }
        JSONObject parseGetSessionRsp = parseGetSessionRsp(((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterRequestInfo((QQAppInterface) appInterface, str));
        if (promise != null) {
            if (parseGetSessionRsp != null) {
                str2 = parseGetSessionRsp.toString();
            }
            promise.resolve(str2);
        }
    }

    private void getSessionDataByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        if (hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        } else {
            str = "";
        }
        QLog.i("QQGameCenterModule", 1, "[getSessionDataByIpc], gameId:" + str);
        this.mReqBundle.putInt("dataType", hippyMap.getInt("dataType"));
        this.mReqBundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_session_info", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void getSessionDataInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        String str2 = "";
        if (!hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = "";
        } else {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        }
        QLog.i("QQGameCenterModule", 1, "[getSessionDataInMainProcess], gameId:" + str);
        JSONObject parseGetSessionRsp = parseGetSessionRsp(((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterSessionInfo((QQAppInterface) appInterface, hippyMap.getInt("dataType"), str));
        if (promise != null) {
            if (parseGetSessionRsp != null) {
                str2 = parseGetSessionRsp.toString();
            }
            promise.resolve(str2);
        }
    }

    private void handleChooseFriendResult(Intent intent, int i3) {
        if (i3 != -1) {
            return;
        }
        IGameCenterFriendApi iGameCenterFriendApi = (IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class);
        final int intValue = FRIEND_TYPE_MAP.get(intent.getIntExtra("uintype", -1)).intValue();
        final String stringExtra = intent.getStringExtra("uinname");
        final String stringExtra2 = intent.getStringExtra("uin");
        String stringExtra3 = intent.getStringExtra(AppConstants.Key.KEY_GC_SENDER_ID);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = getAppInterface().getCurrentAccountUin();
        }
        final String str = stringExtra3;
        iGameCenterFriendApi.reportFriendChooseResult(intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID), intValue, "1");
        iGameCenterFriendApi.getTokenForFriendChosen(str, stringExtra2, new k() { // from class: com.tencent.hippy.qq.module.gamecenter.a
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                QQGameCenterModule.this.lambda$handleChooseFriendResult$6(stringExtra, intValue, stringExtra2, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getFriendInfo$1(String str, boolean z16, Promise promise, Boolean bool) {
        startChooseFriendPage(str, bool.booleanValue(), z16, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChooseFriendResult$6(String str, int i3, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("name", str);
                jSONObject2.put("type", i3);
                jSONObject2.put("friendId", str2);
                jSONObject2.put("senderId", str3);
                jSONObject2.put("token", str4);
                jSONObject.put(GuildMsgItem.NICK_FRIEND, jSONObject2);
                jSONObject.put("ret", 0);
            } else {
                jSONObject.put("ret", 1);
            }
        } catch (JSONException e16) {
            QLog.e("QQGameCenterModule", 2, "[handleChooseFriendResult] " + e16);
        }
        this.mGetFriendInfoPromise.resolve(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportMiniAppOpen$0(Promise promise, boolean z16, JSONObject jSONObject) {
        String str;
        if (z16) {
            callback(promise, 0, "success");
        } else {
            callback(promise, jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1), jSONObject.optString("resultMessage", ""));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext7", str);
        hashMap.put("ext2", "appid");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9410", "941001", "914450", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartYunGame$4(Promise promise, int i3, String str) {
        callback(promise, i3, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startYunGame$2(Promise promise, int i3, String str) {
        callback(promise, i3, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopYunGame$3(Promise promise, int i3, String str) {
        callback(promise, i3, i3, str);
    }

    private void openQQPlayerAioByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j3;
        int i3;
        String str7;
        int i16;
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        Bundle bundle = this.mReqBundle;
        String str8 = "";
        if (!hippyMap.containsKey("fromRoleId")) {
            str = "";
        } else {
            str = hippyMap.getString("fromRoleId");
        }
        bundle.putString("fromRoleId", str);
        Bundle bundle2 = this.mReqBundle;
        if (!hippyMap.containsKey("fromOpenId")) {
            str2 = "";
        } else {
            str2 = hippyMap.getString("fromOpenId");
        }
        bundle2.putString("fromOpenId", str2);
        Bundle bundle3 = this.mReqBundle;
        if (!hippyMap.containsKey("toRoleId")) {
            str3 = "";
        } else {
            str3 = hippyMap.getString("toRoleId");
        }
        bundle3.putString("toRoleId", str3);
        Bundle bundle4 = this.mReqBundle;
        if (!hippyMap.containsKey("toOpenId")) {
            str4 = "";
        } else {
            str4 = hippyMap.getString("toOpenId");
        }
        bundle4.putString("toOpenId", str4);
        Bundle bundle5 = this.mReqBundle;
        if (!hippyMap.containsKey("fromTinyId")) {
            str5 = "";
        } else {
            str5 = hippyMap.getString("fromTinyId");
        }
        bundle5.putString("fromTinyId", str5);
        Bundle bundle6 = this.mReqBundle;
        if (!hippyMap.containsKey("toTinyId")) {
            str6 = "";
        } else {
            str6 = hippyMap.getString("toTinyId");
        }
        bundle6.putString("toTinyId", str6);
        Bundle bundle7 = this.mReqBundle;
        if (hippyMap.containsKey("gameAppId")) {
            j3 = hippyMap.getLong("gameAppId");
        } else {
            j3 = 0;
        }
        bundle7.putLong("gameAppId", j3);
        Bundle bundle8 = this.mReqBundle;
        if (hippyMap.containsKey("windowFlag")) {
            i3 = hippyMap.getInt("windowFlag");
        } else {
            i3 = 0;
        }
        bundle8.putInt("windowFlag", i3);
        Bundle bundle9 = this.mReqBundle;
        if (!hippyMap.containsKey("topGrayText")) {
            str7 = "";
        } else {
            str7 = hippyMap.getString("topGrayText");
        }
        bundle9.putString("topGrayText", str7);
        Bundle bundle10 = this.mReqBundle;
        if (hippyMap.containsKey(PreloadTRTCPlayerParams.KEY_SIG)) {
            str8 = hippyMap.getString(PreloadTRTCPlayerParams.KEY_SIG);
        }
        bundle10.putString(PreloadTRTCPlayerParams.KEY_SIG, str8);
        Bundle bundle11 = this.mReqBundle;
        if (hippyMap.containsKey("fromPage")) {
            i16 = hippyMap.getInt("fromPage");
        } else {
            i16 = 0;
        }
        bundle11.putInt("fromPage", i16);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_open_qqplayer_aio", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void openQQPlayerAioInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i3;
        int i16;
        long j3;
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        Context applicationContext = qQAppInterface.getApp().getApplicationContext();
        String str9 = "";
        if (!hippyMap.containsKey("fromRoleId")) {
            str = "";
        } else {
            str = hippyMap.getString("fromRoleId");
        }
        if (!hippyMap.containsKey("fromOpenId")) {
            str2 = "";
        } else {
            str2 = hippyMap.getString("fromOpenId");
        }
        if (!hippyMap.containsKey("toRoleId")) {
            str3 = "";
        } else {
            str3 = hippyMap.getString("toRoleId");
        }
        if (!hippyMap.containsKey("toOpenId")) {
            str4 = "";
        } else {
            str4 = hippyMap.getString("toOpenId");
        }
        if (!hippyMap.containsKey("fromTinyId")) {
            str5 = "";
        } else {
            str5 = hippyMap.getString("fromTinyId");
        }
        if (!hippyMap.containsKey("toTinyId")) {
            str6 = "";
        } else {
            str6 = hippyMap.getString("toTinyId");
        }
        if (!hippyMap.containsKey("topGrayText")) {
            str7 = "";
        } else {
            str7 = hippyMap.getString("topGrayText");
        }
        if (!hippyMap.containsKey(PreloadTRTCPlayerParams.KEY_SIG)) {
            str8 = "";
        } else {
            str8 = hippyMap.getString(PreloadTRTCPlayerParams.KEY_SIG);
        }
        if (hippyMap.containsKey("windowFlag")) {
            i3 = hippyMap.getInt("windowFlag");
        } else {
            i3 = 0;
        }
        if (hippyMap.containsKey("fromPage")) {
            i16 = hippyMap.getInt("fromPage");
        } else {
            i16 = 0;
        }
        if (hippyMap.containsKey("gameAppId")) {
            j3 = hippyMap.getLong("gameAppId");
        } else {
            j3 = 0;
        }
        ((IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class)).openGameMsgAIO(qQAppInterface, applicationContext, str, str2, str3, str4, str7, str8, j3, str5, str6, i3, i16);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        JSONObject parseClickCommonSessionRsp = parseClickCommonSessionRsp(bundle);
        if (promise != null) {
            if (parseClickCommonSessionRsp != null) {
                str9 = parseClickCommonSessionRsp.toString();
            }
            promise.resolve(str9);
        }
    }

    private JSONObject parseGetMetaDreamUnreadMsgInfo(Bundle bundle) {
        int i3;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            i3 = bundle.getInt("result");
            String string = bundle.getString("data");
            if (string == null) {
                string = "";
            }
            jSONObject = new JSONObject(string);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            jSONObject.put("ret", i3);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenterModule", 2, "parseGetMetaDreamUnreadMsgInfo jsonObject=", jSONObject);
                return jSONObject;
            }
            return jSONObject;
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            QLog.d("QQGameCenterModule", 1, "parseGetMetaDreamUnreadMsgInfo error:" + th);
            return jSONObject2;
        }
    }

    private void setSwitchByIpc(HippyMap hippyMap, Promise promise) {
        String str;
        int i3;
        int saveCallback = saveCallback(promise);
        this.mReqBundle.clear();
        Bundle bundle = this.mReqBundle;
        if (hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        } else {
            str = "";
        }
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        Bundle bundle2 = this.mReqBundle;
        int i16 = -1;
        if (hippyMap.containsKey("switchType")) {
            i3 = hippyMap.getInt("switchType");
        } else {
            i3 = -1;
        }
        bundle2.putInt("switchType", i3);
        Bundle bundle3 = this.mReqBundle;
        if (hippyMap.containsKey("value")) {
            i16 = hippyMap.getInt("value");
        }
        bundle3.putInt("value", i16);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_toggle_changed", String.valueOf(saveCallback), this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    private void setSwitchInMainProcess(HippyMap hippyMap, Promise promise) {
        String str;
        int i3;
        AppInterface appInterface = getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        if (!hippyMap.containsKey(VirtualAppProxy.KEY_GAME_ID)) {
            str = "";
        } else {
            str = hippyMap.getString(VirtualAppProxy.KEY_GAME_ID);
        }
        int i16 = -1;
        if (hippyMap.containsKey("switchType")) {
            i3 = hippyMap.getInt("switchType");
        } else {
            i3 = -1;
        }
        if (hippyMap.containsKey("value")) {
            i16 = hippyMap.getInt("value");
        }
        MessengerService.L((QQAppInterface) appInterface, str, i3, i16);
        callback(promise, 0, "");
    }

    private void startChooseFriendPage(String str, boolean z16, boolean z17, Promise promise) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1058);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.KEY_GC_GAME_APPID, str);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_GAME_FRIEND_ENTRANCE, z16);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_TROOP_ENTRANCE, z17);
        intent.putExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC, "1");
        this.mGetFriendInfoPromise = promise;
        activity.startActivityForResult(intent, 16);
    }

    public final void bindLifecycleListener() {
        HippyActivityLifecycleOwner hippyActivityLifecycleOwner = getHippyActivityLifecycleOwner();
        if (hippyActivityLifecycleOwner != null) {
            hippyActivityLifecycleOwner.getActivityLifecycleDispatcher().addActivityLifecycleListener(this);
        }
    }

    void callback(String str, String str2) {
        Promise callback = getCallback(str);
        if (callback != null) {
            callback.resolve(str2);
        }
    }

    @HippyMethod(name = "clickCommonSession")
    public void clickCommonSession(HippyMap hippyMap, Promise promise) {
        if (this.mIsInMainProcess) {
            clickCommonSessionInMainProcess(hippyMap, promise);
        } else {
            clickCommonSessionByIpc(hippyMap, promise);
        }
    }

    @HippyMethod(name = "delGameSession")
    public void delGameSession(HippyMap hippyMap, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[delGameSession], params:" + hippyMap);
        }
        if (this.mIsInMainProcess) {
            delSessionInMainProcess(hippyMap, promise);
        } else {
            delSessionByIpc(hippyMap, promise);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseWebIpcModule, com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        MessageBroadcastReceiver messageBroadcastReceiver = this.mMsgReceiver;
        if (messageBroadcastReceiver != null) {
            messageBroadcastReceiver.onDestroy();
            BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
        }
        unbindLifecycleListener();
        super.destroy();
    }

    @HippyMethod(name = "exitBackground")
    public void exitBackground() {
        QLog.d("QQGameCenterModule", 2, "[exitBackground]");
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            QLog.e("QQGameCenterModule", 2, "[exitBackground], service is null");
        } else {
            iYunGameManagerService.exitBackground();
        }
    }

    @HippyMethod(name = "getFloatWndToggle")
    public void getFloatWndToggle(Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[getFloatWndToggle]");
        callback(promise, 0, ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).getIntOutAccount(WadlProxyConsts.KEY_FLOAT_WND_TOGGLE, 1), "");
    }

    @HippyMethod(name = VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO)
    @Deprecated
    public void getFriendInfo(HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[getFriendInfo], params:" + hippyMap);
        }
        final String string = hippyMap.getString("appid");
        final boolean z16 = hippyMap.getBoolean("withGroup");
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).getGameFriendEnableStatus(string, new k() { // from class: com.tencent.hippy.qq.module.gamecenter.f
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                QQGameCenterModule.this.lambda$getFriendInfo$1(string, z16, promise, (Boolean) obj);
            }
        });
    }

    protected HippyActivityLifecycleOwner getHippyActivityLifecycleOwner() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine == null) {
            return null;
        }
        return hippyQQEngine.getHippyActivityLifecycleOwner();
    }

    @HippyMethod(name = "getMetaDreamUnreadMsgInfo")
    public void getMetaDreamUnreadMsgInfo(HippyMap hippyMap, Promise promise) {
        QLog.d("QQGameCenterModule", 2, "getMetaDreamUnreadMsgInfo mIsInMainProcess=", Boolean.valueOf(this.mIsInMainProcess));
        if (this.mIsInMainProcess) {
            getMetaDreamUnreadMsgInfoInMainProcess(hippyMap, promise);
        } else {
            getMetaDreamUnreadMsgInfoByIpc(hippyMap, promise);
        }
    }

    @HippyMethod(name = "getNewMsgCount")
    public void getNewMsgCount(Promise promise) {
        if (this.mIsInMainProcess) {
            getNewMsgCountInMainProcess(promise);
        } else {
            getNewMsgCountByIpc(promise);
        }
    }

    @HippyMethod(name = "getPageUrl")
    public void getPageUrl(Promise promise) {
        if (promise == null) {
            return;
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        String str = "";
        if (engineInstance != null) {
            if (engineInstance.getPageUrl() != null) {
                str = engineInstance.getPageUrl();
            }
            promise.resolve(str);
            return;
        }
        promise.reject("");
    }

    @HippyMethod(name = "getRequestData")
    public void getRequestData(HippyMap hippyMap, Promise promise) {
        if (this.mIsInMainProcess) {
            getRequestDataInMainProcess(hippyMap, promise);
        } else {
            getRequestDataByIpc(hippyMap, promise);
        }
    }

    @HippyMethod(name = "getSSRBundleData")
    public void getSSRBundleData(Promise promise) {
        if (promise == null) {
            return;
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        String str = "";
        if (engineInstance != null) {
            String str2 = engineInstance.getOpenHippyInfo().ssrBundleData;
            if (str2 != null) {
                str = str2;
            }
            promise.resolve(str);
            return;
        }
        promise.reject("");
    }

    @HippyMethod(name = "getScreenOrientation")
    public void getScreenOrientation(HippyMap hippyMap, Promise promise) {
        String string = QMMKV.fromV2(getActivity(), "common_mmkv_configurations").getString(IYunGameConstant.KEY_SCREEN_CFG + hippyMap.getString(VirtualAppProxy.KEY_GAME_ID), "");
        QLog.d("YunGameActivity", 2, "[getScreenOrientation] " + string);
        JSONObject jSONObject = new JSONObject();
        try {
            if (!StringUtil.isEmpty(string) && string.contains(",")) {
                String[] split = string.split(",");
                if (split.length == 2) {
                    jSONObject.put(VirtualAppProxy.KEY_GAME_ID, split[0]);
                    jSONObject.put(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, split[1]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @HippyMethod(name = "getSessionData")
    public void getSessionData(HippyMap hippyMap, Promise promise) {
        if (this.mIsInMainProcess) {
            getSessionDataInMainProcess(hippyMap, promise);
        } else {
            getSessionDataByIpc(hippyMap, promise);
        }
    }

    @HippyMethod(name = "getYunGameClarits")
    public void getYunGameClarits(Promise promise) {
        String string = QMMKV.fromV2(getActivity(), "common_mmkv_configurations").getString(IYunGameConstant.KEY_QUALITY_CFG, "");
        QLog.d("YunGameActivity", 2, "[getYunGameClarits] " + string);
        callback(promise, 0, 0, string);
    }

    @HippyMethod(name = "installYunGameSDK")
    public void installYunGameSDK(Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[installYunGameSDK], params:");
        }
    }

    @HippyMethod(name = "isYunGameInstalled")
    public void isYunGameInstalled(Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[isYunGameInstalled], params:");
        }
        callback(promise, 0, 0, "sdk installed.");
    }

    @HippyMethod(name = "notifyUserFeedback")
    public void notifyUserFeedback(Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[notifyUserFeedback]");
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            callback(promise, -1, -1, "service not exist.");
        } else {
            iYunGameManagerService.notifyUserFeedback();
            callback(promise, 0, 0, "");
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (16 == i3) {
            handleChooseFriendResult(intent, i16);
        }
    }

    @HippyMethod(name = "onBackButtonClick")
    public void onBackButtonClick() {
        QBaseFragment fragment = super.getFragment();
        if (fragment instanceof GameMsgAppFragment) {
            ((GameMsgAppFragment) fragment).sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.module.QQBaseWebIpcModule
    public void onResponse(Bundle bundle) {
        super.onResponse(bundle);
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("cmd");
        int i3 = bundle.getInt("respkey", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 1, "[onResponse] cmd:" + string + " respkey:" + i3 + "\uff0ckey:" + this.mOnRemoteResp.key);
        }
        if (i3 != this.mOnRemoteResp.key) {
            return;
        }
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle("response");
        if (!TextUtils.isEmpty(string) && bundle2 != null) {
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                try {
                    String str = "";
                    if (!"ipc_cmd_gamecenter_get_session_info".equals(string) && !"ipc_cmd_gamecenter_get_request_info".equals(string)) {
                        if ("ipc_cmd_gamecenter_open_aio".equals(string)) {
                            JSONObject parseClickCommonSessionRsp = parseClickCommonSessionRsp(bundle2);
                            if (parseClickCommonSessionRsp != null) {
                                str = parseClickCommonSessionRsp.toString();
                            }
                            callback(string2, str);
                            return;
                        }
                        if ("ipc_cmd_gamecenter_get_unread_total".equals(string)) {
                            JSONObject parseGetNewMsgCountRsp = parseGetNewMsgCountRsp(bundle2);
                            if (parseGetNewMsgCountRsp != null) {
                                str = parseGetNewMsgCountRsp.toString();
                            }
                            callback(string2, str);
                            return;
                        }
                        if ("ipc_cmd_gamecenter_toggle_changed".equals(string)) {
                            callback(string2, 0, "");
                            return;
                        }
                        if ("ipc_cmd_gamecenter_open_qqplayer_aio".equals(string)) {
                            JSONObject parseClickCommonSessionRsp2 = parseClickCommonSessionRsp(bundle2);
                            if (parseClickCommonSessionRsp2 != null) {
                                str = parseClickCommonSessionRsp2.toString();
                            }
                            callback(string2, str);
                            return;
                        }
                        if ("ipc_cmd_gamecenter_del_game_session".equals(string)) {
                            JSONObject parseClickCommonSessionRsp3 = parseClickCommonSessionRsp(bundle2);
                            if (parseClickCommonSessionRsp3 != null) {
                                str = parseClickCommonSessionRsp3.toString();
                            }
                            callback(string2, str);
                            return;
                        }
                        if ("ipc_cmd_gamecenter_metadream_get_session_unread_info".equals(string)) {
                            JSONObject parseGetMetaDreamUnreadMsgInfo = parseGetMetaDreamUnreadMsgInfo(bundle2);
                            if (parseGetMetaDreamUnreadMsgInfo != null) {
                                str = parseGetMetaDreamUnreadMsgInfo.toString();
                            }
                            callback(string2, str);
                            return;
                        }
                        return;
                    }
                    JSONObject parseGetSessionRsp = parseGetSessionRsp(bundle2);
                    if (parseGetSessionRsp != null) {
                        str = parseGetSessionRsp.toString();
                    }
                    callback(string2, str);
                    return;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQGameCenterModule", 2, th5.getMessage());
                    }
                    callback(string2, 1, "-2000");
                    return;
                }
            }
            callback(string2, 1, "-1000");
        }
    }

    @HippyMethod(name = "openQQPlayerAio")
    public void openQQPlayerAio(HippyMap hippyMap, Promise promise) {
        if (this.mIsInMainProcess) {
            openQQPlayerAioInMainProcess(hippyMap, promise);
        } else {
            openQQPlayerAioByIpc(hippyMap, promise);
        }
    }

    protected JSONObject parseClickCommonSessionRsp(Bundle bundle) {
        int i3;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            i3 = bundle.getInt("result", -1);
            jSONObject = new JSONObject();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            jSONObject.put("ret", i3);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenterModule", 2, "parseClickCommonSessionRsp ret:" + i3);
                return jSONObject;
            }
            return jSONObject;
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            QLog.d("QQGameCenterModule", 1, "parseClickCommonSessionRsp error:" + th);
            return jSONObject2;
        }
    }

    public GameInfo parseGameInfo(HippyMap hippyMap) {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameId(hippyMap.getString(VirtualAppProxy.KEY_GAME_ID));
        gameInfo.setAppId(hippyMap.getString("appid"));
        gameInfo.setGameName(hippyMap.getString("gameName"));
        gameInfo.setConfigUrl(hippyMap.getString("configUrl"));
        gameInfo.setPlayType(hippyMap.getInt(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE));
        gameInfo.setExtraInfo(hippyMap.getString("extraInfo"));
        gameInfo.setJumpUrl(hippyMap.getString(WadlProxyConsts.KEY_JUMP_URL));
        gameInfo.setIconUrl(hippyMap.getString("iconUrl"));
        gameInfo.setLoadingUrl(hippyMap.getString("loadingUrl"));
        gameInfo.setAutoLogin(hippyMap.getBoolean("autoLogin"));
        gameInfo.setGameData(hippyMap.getString("gameData"));
        gameInfo.setOaid(hippyMap.getString("oaid"));
        gameInfo.setDcEventReqCmd(hippyMap.getString("dcEventReqCmd"));
        gameInfo.setDcEventReqData(hippyMap.getString("dcEventReqData"));
        gameInfo.setReportChannelId(hippyMap.getString("reportChannelId"));
        gameInfo.setReportActId(hippyMap.getString("reportActId"));
        return gameInfo;
    }

    protected JSONObject parseGetNewMsgCountRsp(Bundle bundle) {
        int i3;
        int i16;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            i3 = bundle.getInt("result");
            i16 = bundle.getInt("cnt");
            jSONObject = new JSONObject();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            jSONObject.put("ret", i3);
            jSONObject.put("newMsgCount", i16);
            String string = bundle.getString("singleUnread", "");
            QLog.i("QQGameCenterModule", 1, "[parseGetNewMsgCountRsp] ----unreadStr---:" + string);
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("tabMsgCount", new JSONObject(string));
            }
            QLog.d("QQGameCenterModule", 1, "----885unread----:" + jSONObject);
            return jSONObject;
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            QLog.d("QQGameCenterModule", 1, "parseGetNewMsgCountRsp error:" + th);
            return jSONObject2;
        }
    }

    protected JSONObject parseGetSessionRsp(Bundle bundle) {
        int i3;
        String string;
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2 = null;
        try {
            i3 = bundle.getInt("result");
            string = bundle.getString("data");
            if (string == null) {
                str = "";
            } else {
                str = string;
            }
            jSONObject = new JSONObject(str);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            jSONObject.put("ret", i3);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenterModule", 2, "parseGetSessionRsp dataStr is:" + string);
                return jSONObject;
            }
            return jSONObject;
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            QLog.d("QQGameCenterModule", 1, "parseGetSessionRsp error:" + th);
            return jSONObject2;
        }
    }

    @HippyMethod(name = "preLoadYunGame")
    public void preLoadYunGame(HippyMap hippyMap) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[preLoadYunGame], params:");
        }
        if (hippyMap == null) {
            str = "";
        } else {
            str = hippyMap.getString("oaid");
        }
        saveOaid(str);
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            QLog.e("QQGameCenterModule", 2, "[preLoadYunGame], service is null");
        } else {
            iYunGameManagerService.preLoadYunGame();
        }
    }

    @HippyMethod(name = "queryInstallProgress")
    public void queryInstallProgress(Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[queryInstallProgress], params:");
        }
        callback(promise, 0, 100, "");
    }

    @HippyMethod(name = "registerGameStatusListener")
    public void registerGameStatusListener(Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[registerGameStatusListener]");
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            callback(promise, -1, -1, "service not exist.");
            return;
        }
        IYunGameManagerService.b bVar = new IYunGameManagerService.b() { // from class: com.tencent.hippy.qq.module.gamecenter.e
            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.b
            public final void onStateChange(IYunGameConstant.GameStatusInfo gameStatusInfo) {
                QQGameCenterModule.this.lambda$registerGameStatusListener$5(gameStatusInfo);
            }
        };
        this.mGameStateListener = bVar;
        iYunGameManagerService.addGameStateListener(bVar);
        callback(promise, 0, 0, "");
    }

    @HippyMethod(name = "reportMiniAppOpen")
    public void reportMiniAppOpen(HippyMap hippyMap, final Promise promise) {
        if (hippyMap == null) {
            return;
        }
        String string = hippyMap.getString("appId");
        if (TextUtils.isEmpty(string)) {
            callback(promise, -1, "parameters error");
        } else {
            ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).reportMiniAppOpen(string, new MiniAppCmdInterface() { // from class: com.tencent.hippy.qq.module.gamecenter.c
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    QQGameCenterModule.this.lambda$reportMiniAppOpen$0(promise, z16, jSONObject);
                }
            });
        }
    }

    @HippyMethod(name = "requestGameCenterTabConfig")
    public void requestGameCenterTabConfig(String str, Promise promise) {
        AppInterface appInterface;
        if (TextUtils.isEmpty(str) || (appInterface = getAppInterface()) == null) {
            return;
        }
        File tabConfigFile = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getTabConfigFile(appInterface.getCurrentUin(), str);
        String str2 = "";
        if (tabConfigFile != null && tabConfigFile.exists()) {
            String readFileContent = FileUtils.readFileContent(tabConfigFile);
            if (readFileContent != null) {
                str2 = readFileContent;
            }
            promise.resolve(str2);
            return;
        }
        promise.resolve("");
    }

    @HippyMethod(name = "requestSpringHBPreloadSource")
    public void requestSpringHBPreloadSource() {
        ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).requestSpringHBPreloadSource();
    }

    @HippyMethod(name = "restartYunGame")
    public void restartYunGame(HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[restartYunGame], params:" + hippyMap);
        }
        if (hippyMap != null && !TextUtils.isEmpty(hippyMap.getString(VirtualAppProxy.KEY_GAME_ID))) {
            IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            if (iYunGameManagerService == null) {
                callback(promise, 0, -100, "service not exist.");
                QLog.e("QQGameCenterModule", 2, "[stopYunGame], service is null");
                return;
            } else {
                GameInfo parseGameInfo = parseGameInfo(hippyMap);
                IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.hippy.qq.module.gamecenter.g
                    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                    public final void onResult(int i3, String str) {
                        QQGameCenterModule.this.lambda$restartYunGame$4(promise, i3, str);
                    }
                };
                this.mRestartCallBack = aVar;
                iYunGameManagerService.restartYunGame(parseGameInfo, aVar);
                return;
            }
        }
        QLog.e("QQGameCenterModule", 2, "[restartYunGame], params error:" + hippyMap);
        callback(promise, 0, -5, "param error");
    }

    public void saveOaid(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QQGameCenterModule", 2, "[saveOaid], oaid is empty, get from truingSdk");
            ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
            if (c16 != null) {
                str = c16.getAIDTicket();
            } else {
                str = null;
            }
        }
        QMMKV.fromV2(getActivity(), "common_mmkv_configurations").putString(IYunGameConstant.KEY_OAID_CFG, str);
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[saveOaid], oaid:" + str);
        }
    }

    /* renamed from: sendGameStatu, reason: merged with bridge method [inline-methods] */
    public void lambda$registerGameStatusListener$5(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        String str;
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            HippyMap hippyMap = new HippyMap();
            if (gameStatusInfo != null) {
                hippyMap.pushInt("ret", gameStatusInfo.getStatus());
                hippyMap.pushInt("index", gameStatusInfo.getIndex());
                hippyMap.pushInt("total", gameStatusInfo.getTotal());
                String str2 = "-1";
                if (gameStatusInfo.getGameInfo() == null) {
                    str = "-1";
                } else {
                    str = gameStatusInfo.getGameInfo().getGameId();
                }
                hippyMap.pushString(VirtualAppProxy.KEY_GAME_ID, str);
                hippyMap.pushString("msg", gameStatusInfo.getMsg());
                if (gameStatusInfo.getStatus() == -6) {
                    if (gameStatusInfo.getGameInfo() != null) {
                        str2 = gameStatusInfo.getGameInfo().getGameId();
                    }
                    hippyMap.pushString("msg", str2);
                    hippyMap.pushString(VirtualAppProxy.KEY_GAME_ID, gameStatusInfo.getMsg());
                }
            } else {
                QLog.e("QQGameCenterModule", 1, "[sendGameStatu] info is null");
            }
            hippyQQEngine.sendEvent("gameStatusChange", hippyMap);
            return;
        }
        QLog.e("QQGameCenterModule", 1, "[sendGameStatu] engine is null");
    }

    @HippyMethod(name = "setFloatWndToggle")
    public void setFloatWndToggle(HippyMap hippyMap, Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[setFloatWndToggle]");
        IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) getAppInterface().getRuntimeService(IQQGameNoticeService.class, "");
        if (iQQGameNoticeService == null) {
            callback(promise, -1, -1, "service not exist.");
        } else {
            iQQGameNoticeService.setFloatWndToggle(hippyMap.getInt("toggle"));
            callback(promise, 0, 0, "");
        }
    }

    @HippyMethod(name = "setSwitch")
    public void setSwitch(HippyMap hippyMap, Promise promise) {
        if (this.mIsInMainProcess) {
            setSwitchInMainProcess(hippyMap, promise);
        } else {
            setSwitchByIpc(hippyMap, promise);
        }
    }

    @HippyMethod(name = "setYunGameClarity")
    public void setYunGameClarity(HippyMap hippyMap, Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[setYunGameClarity]");
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            callback(promise, -1, -1, "service not exist.");
        } else {
            iYunGameManagerService.setYunGameClarity(hippyMap.getInt(TPReportParams.JSON_KEY_VAL));
            callback(promise, 0, 0, "");
        }
    }

    @HippyMethod(name = "startYunGame")
    public void startYunGame(HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[startYunGame], params:" + hippyMap);
        }
        if (hippyMap != null && !TextUtils.isEmpty(hippyMap.getString(VirtualAppProxy.KEY_GAME_ID))) {
            IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            if (iYunGameManagerService == null) {
                callback(promise, 0, -100, "service not exist.");
                QLog.e("QQGameCenterModule", 2, "[startYunGame], service is null");
                return;
            }
            GameInfo parseGameInfo = parseGameInfo(hippyMap);
            saveOaid(parseGameInfo.getOaid());
            QLog.i("QQGameCenterModule", 2, "[startYunGame], gameId:" + parseGameInfo.getGameId() + ", autoLogin:" + parseGameInfo.getAutoLogin() + " gameData:" + parseGameInfo.getGameData());
            IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.hippy.qq.module.gamecenter.b
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                public final void onResult(int i3, String str) {
                    QQGameCenterModule.this.lambda$startYunGame$2(promise, i3, str);
                }
            };
            this.mStartCallBack = aVar;
            iYunGameManagerService.startGame(parseGameInfo, aVar);
            return;
        }
        QLog.e("QQGameCenterModule", 2, "[startYunGame], params error:" + hippyMap);
        callback(promise, 0, -5, "param error");
    }

    @HippyMethod(name = "stopYunGame")
    public void stopYunGame(HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 2, "[stopYunGame], params:" + hippyMap);
        }
        if (hippyMap != null && !TextUtils.isEmpty(hippyMap.getString(VirtualAppProxy.KEY_GAME_ID))) {
            IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            if (iYunGameManagerService == null) {
                callback(promise, 0, -100, "service not exist.");
                QLog.e("QQGameCenterModule", 2, "[stopYunGame], service is null");
                return;
            } else {
                GameInfo parseGameInfo = parseGameInfo(hippyMap);
                IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.hippy.qq.module.gamecenter.d
                    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                    public final void onResult(int i3, String str) {
                        QQGameCenterModule.this.lambda$stopYunGame$3(promise, i3, str);
                    }
                };
                this.mStopCallBack = aVar;
                iYunGameManagerService.stopGame(parseGameInfo, aVar);
                return;
            }
        }
        QLog.e("QQGameCenterModule", 2, "[stopYunGame], params error:" + hippyMap);
        callback(promise, 0, -5, "param error");
    }

    public final void unbindLifecycleListener() {
        HippyActivityLifecycleOwner hippyActivityLifecycleOwner = getHippyActivityLifecycleOwner();
        if (hippyActivityLifecycleOwner != null) {
            hippyActivityLifecycleOwner.getActivityLifecycleDispatcher().removeActivityLifecycleListener(this);
        }
    }

    @HippyMethod(name = "unregisterGameStatusListener")
    public void unregisterGameStatusListener(Promise promise) {
        QLog.d("QQGameCenterModule", 2, "[registerGameStatusListener]");
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService == null) {
            callback(promise, -1, -1, "service not exist.");
        } else {
            iYunGameManagerService.removeGameStateListener(this.mGameStateListener);
            callback(promise, 0, 0, "");
        }
    }

    void callback(String str, int i3, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            jSONObject.put("ret", i3);
            jSONObject.put("msg", str2);
            callback(str, jSONObject.toString());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGameCenterModule", 2, e16.getMessage());
            }
        }
    }

    void callback(Promise promise, int i3, int i16, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            jSONObject.put("ret", i16);
            jSONObject.put("msg", str);
            if (promise != null) {
                promise.resolve(jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGameCenterModule", 2, e16.getMessage());
            }
        }
    }

    void callback(Promise promise, int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            jSONObject.put("ret", i3);
            jSONObject.put("msg", str);
            if (promise != null) {
                promise.resolve(jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGameCenterModule", 2, e16.getMessage());
            }
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
    }
}
