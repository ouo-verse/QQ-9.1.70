package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.gamecenter.api.IYunGameTipsService;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$AddRecentPlayReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$ExperienceGameRequest;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$ExperienceGameResponse;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetUserKeyReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetUserKeyRsp;
import com.tencent.mobileqq.gamecenter.yungame.YunGameService;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameManagerServiceImpl implements IYunGameManagerService {
    public static int CALLBACK_ID = 0;
    private static final int MSG_FLUSH_CMD = 3;
    private static final int MSG_START_SERVICE = 4;
    private static final int MSG_START_SERVICE_TIMEOUT = 2;
    public static final String TAG = "YunGameManagerServiceImpl";
    public static final String TRPC_ADD_RECENT_PLAY = "/v1/1055";
    public static final String TRPC_AUTH_CMD = "/v1/1024";
    public static final String TRPC_GET_GAME_TOGGLE = "/v1/1220";
    private static int mCurrentAuthId;
    private static WeakReference<com.tencent.mobileqq.qroute.module.c> mInstallListener;
    private String mAuthKey;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsServiceRunning;
    private int mYunGameActivityStatus;
    private CopyOnWriteArrayList<WeakReference<IYunGameManagerService.b>> mGameStateListenerList = new CopyOnWriteArrayList<>();
    private ConcurrentLinkedQueue<Pair<String, Bundle>> mCmdList = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<Integer, WeakReference<IYunGameManagerService.a>> mCallbackMap = new ConcurrentHashMap<>();
    private boolean mServiceStarting = false;
    private int mRetryCnt = 3;
    private final WadlTrpcListener mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameManagerServiceImpl.2
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameManagerServiceImpl.2.1
                {
                    add(YunGameManagerServiceImpl.TRPC_AUTH_CMD);
                    add(YunGameManagerServiceImpl.TRPC_ADD_RECENT_PLAY);
                    add(YunGameManagerServiceImpl.TRPC_GET_GAME_TOGGLE);
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            QLog.i(YunGameManagerServiceImpl.TAG, 2, "[onTrpcRsp] onTrpcRsp ret:" + j3 + ", cmd:" + str);
            if (intent == null) {
                QLog.i(YunGameManagerServiceImpl.TAG, 2, "[onTrpcRsp] onTrpcRsp request null.");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.i(YunGameManagerServiceImpl.TAG, 2, "[onTrpcRsp] cmd is empty.");
                return;
            }
            if (YunGameManagerServiceImpl.TRPC_AUTH_CMD.equals(str)) {
                if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                    try {
                        QLog.e(YunGameManagerServiceImpl.TAG, 1, "[onTrpcRsp] TRPC_AUTH_CMD suc.");
                        GameCenterYunGameAuth$GetUserKeyRsp gameCenterYunGameAuth$GetUserKeyRsp = new GameCenterYunGameAuth$GetUserKeyRsp();
                        gameCenterYunGameAuth$GetUserKeyRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                        YunGameManagerServiceImpl.this.mAuthKey = gameCenterYunGameAuth$GetUserKeyRsp.user_key.get();
                        YunGameManagerServiceImpl.this.startPluginServiceInternal();
                        return;
                    } catch (Exception e16) {
                        QLog.e(YunGameManagerServiceImpl.TAG, 1, e16, new Object[0]);
                        YunGameManagerServiceImpl.this.mServiceStarting = false;
                        return;
                    }
                }
                QLog.e(YunGameManagerServiceImpl.TAG, 1, "[onTrpcRsp] TRPC_AUTH_CMD failed.");
                YunGameManagerServiceImpl.this.mServiceStarting = false;
                YunGameManagerServiceImpl.this.onGetAuthKeyFailed();
                return;
            }
            if (YunGameManagerServiceImpl.TRPC_ADD_RECENT_PLAY.equals(str)) {
                if (j3 == 0) {
                    QLog.i(YunGameManagerServiceImpl.TAG, 2, "[addRecentPlay] add recent play ok.");
                    return;
                }
                return;
            }
            if (YunGameManagerServiceImpl.TRPC_GET_GAME_TOGGLE.equals(str)) {
                if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                    try {
                        GameCenterYunGameAuth$ExperienceGameResponse gameCenterYunGameAuth$ExperienceGameResponse = new GameCenterYunGameAuth$ExperienceGameResponse();
                        gameCenterYunGameAuth$ExperienceGameResponse.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                        List<GameCenterYunGameAuth$ExperienceGameResponse.Info> list = gameCenterYunGameAuth$ExperienceGameResponse.infos.get();
                        if (list != null && list.size() >= 1) {
                            GameCenterYunGameAuth$ExperienceGameResponse.Info info = list.get(0);
                            QLog.i(YunGameManagerServiceImpl.TAG, 2, "[GetGameToggle] info:" + info.appid.get() + ", =>" + info.allow.get() + ", =>" + info.hippy_link.get());
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(IYunGameConstant.KEY_TOGGLE_ALLOW, info.allow.get());
                            bundle.putString(IYunGameConstant.KEY_TOGGLE_URL, info.hippy_link.get());
                            YunGameManagerServiceImpl.this.addCmd(IYunGameConstant.CMD_GET_GAME_TOGGLE, bundle);
                        } else {
                            QLog.i(YunGameManagerServiceImpl.TAG, 2, "[GetGameToggle] info is null");
                        }
                        return;
                    } catch (Exception e17) {
                        QLog.e(YunGameManagerServiceImpl.TAG, 1, e17, new Object[0]);
                        return;
                    }
                }
                return;
            }
            QLog.i(YunGameManagerServiceImpl.TAG, 2, "[GetAuthKey] unknow cmd.");
        }
    };

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        QLog.i(YunGameManagerServiceImpl.TAG, 1, "[handleMessage] MSG_START_SERVICE mServiceStarting: " + YunGameManagerServiceImpl.this.mServiceStarting + ", mIsServiceRunning: " + YunGameManagerServiceImpl.this.mIsServiceRunning);
                        if (!YunGameManagerServiceImpl.this.mServiceStarting) {
                            YunGameManagerServiceImpl.this.mServiceStarting = true;
                            YunGameManagerServiceImpl.this.mHandler.sendEmptyMessageDelayed(2, 5000L);
                            YunGameManagerServiceImpl.this.getAuthKey();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:plugins")) {
                    YunGameManagerServiceImpl.this.mIsServiceRunning = false;
                    YunGameManagerServiceImpl.this.startPluginService();
                    return;
                }
                Iterator it = YunGameManagerServiceImpl.this.mCmdList.iterator();
                while (it.hasNext()) {
                    YunGameManagerServiceImpl.this.sendMsgToServer((Pair) it.next());
                    it.remove();
                }
                return;
            }
            QLog.i(YunGameManagerServiceImpl.TAG, 1, "[handleMessage] MSG_START_SERVICE_TIMEOUT: " + message.what);
            YunGameManagerServiceImpl.this.mServiceStarting = false;
            YunGameManagerServiceImpl.this.mIsServiceRunning = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameInfo f211894a;

        b(GameInfo gameInfo) {
            this.f211894a = gameInfo;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e(YunGameManagerServiceImpl.TAG, 1, "[startGame] get pSkey failed!!!");
            Bundle bundle = new Bundle();
            bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, this.f211894a);
            YunGameManagerServiceImpl.this.addCmd(IYunGameConstant.CMD_START_GAME, bundle);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            String substring;
            this.f211894a.setPskey(map.get("gamecenter.qq.com"));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[startGame] get pskey = ");
            if (TextUtils.isEmpty(this.f211894a.getPskey())) {
                substring = "null";
            } else {
                substring = this.f211894a.getPskey().substring(0, 10);
            }
            sb5.append(substring);
            QLog.i(YunGameManagerServiceImpl.TAG, 1, sb5.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, this.f211894a);
            YunGameManagerServiceImpl.this.addCmd(IYunGameConstant.CMD_START_GAME, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Pair f211896d;

        c(Pair pair) {
            this.f211896d = pair;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            YunGameManagerServiceImpl.this.onRespone((String) this.f211896d.first, eIPCResult.data, eIPCResult.code);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameInfo f211898a;

        d(GameInfo gameInfo) {
            this.f211898a = gameInfo;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e(YunGameManagerServiceImpl.TAG, 1, "[startGame] get pSkey failed!!!");
            Bundle bundle = new Bundle();
            bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, this.f211898a);
            YunGameManagerServiceImpl.this.addCmd(IYunGameConstant.CMD_RESTART_GAME, bundle);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            String substring;
            this.f211898a.setPskey(map.get("gamecenter.qq.com"));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[startGame] get pskey = ");
            if (TextUtils.isEmpty(this.f211898a.getPskey())) {
                substring = "null";
            } else {
                substring = this.f211898a.getPskey().substring(0, 10);
            }
            sb5.append(substring);
            QLog.i(YunGameManagerServiceImpl.TAG, 1, sb5.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, this.f211898a);
            YunGameManagerServiceImpl.this.addCmd(IYunGameConstant.CMD_RESTART_GAME, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthKey() {
        QLog.i(TAG, 2, "[GetAuthKey] start get Auth Key.....");
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(TRPC_AUTH_CMD, false, new GameCenterYunGameAuth$GetUserKeyReq().toByteArray());
        Bundle bundle = new Bundle();
        int i3 = mCurrentAuthId + 1;
        mCurrentAuthId = i3;
        bundle.putInt(IYunGameConstant.KEY_AUTH_ID, i3);
        bundle.putString("key_cmd", TRPC_AUTH_CMD);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    private String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUin();
    }

    private void getPskey(sd2.a aVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IPskeyManager) peekAppRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"gamecenter.qq.com"}, aVar);
    }

    private BaseQQAppInterface getQQAppInterface() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void handleGameActivityResume() {
        this.mYunGameActivityStatus = 1;
    }

    private void handleGameActivityStop() {
        IQQGameDownloadService iQQGameDownloadService;
        this.mYunGameActivityStatus = 0;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iQQGameDownloadService = (IQQGameDownloadService) peekAppRuntime.getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)) == null) {
            return;
        }
        iQQGameDownloadService.runWaitInstallTask();
    }

    private void handleOpenMenu(Context context, Bundle bundle) {
        try {
            if (bundle != null) {
                ax c16 = bi.c(getQQAppInterface(), context, bundle.getString(IYunGameConstant.KEY_PARAM_URL));
                if (c16 != null) {
                    c16.b();
                } else {
                    QLog.e(TAG, 1, "[cmd_open_menu] parse is null");
                }
            } else {
                QLog.e(TAG, 1, "[cmd_open_menu] params error");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private void handleQueueState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(IYunGameConstant.GameStatusInfo.class.getClassLoader());
            notifyGameStatusChange((IYunGameConstant.GameStatusInfo) bundle.getParcelable(IYunGameConstant.KEY_PARAM_QUEUE_INFO));
        }
    }

    private void handleRestartGame(Bundle bundle) {
        int i3;
        String str = "";
        int i16 = -1;
        if (bundle != null) {
            i3 = bundle.getInt(IYunGameConstant.KEY_PARAM_RET);
            str = bundle.getString(IYunGameConstant.KEY_PARAM_MSG, "");
            Bundle bundle2 = bundle.getBundle("key_data");
            if (bundle2 != null) {
                i16 = bundle2.getInt("key_callback_id");
            }
        } else {
            i3 = 0;
        }
        QLog.i(TAG, 1, "[handleRestartGame] ret:" + i3);
        WeakReference<IYunGameManagerService.a> weakReference = this.mCallbackMap.get(Integer.valueOf(i16));
        if (weakReference != null) {
            IYunGameManagerService.a aVar = weakReference.get();
            if (aVar != null) {
                aVar.onResult(i3, str);
            }
            this.mCallbackMap.remove(Integer.valueOf(i16));
        }
    }

    private void handleStartGame(Bundle bundle) {
        int i3;
        String str = "";
        GameInfo gameInfo = null;
        int i16 = -1;
        if (bundle != null) {
            i3 = bundle.getInt(IYunGameConstant.KEY_PARAM_RET);
            str = bundle.getString(IYunGameConstant.KEY_PARAM_MSG, "");
            Bundle bundle2 = bundle.getBundle("key_data");
            if (bundle2 != null) {
                bundle2.setClassLoader(GameInfo.class.getClassLoader());
                gameInfo = (GameInfo) bundle2.getParcelable(IYunGameConstant.KEY_GAME_INFO);
                i16 = bundle2.getInt("key_callback_id");
            }
        } else {
            i3 = 0;
        }
        QLog.i(TAG, 1, "[handleStartGame]  ret: " + i3);
        if (i3 == 3) {
            return;
        }
        if (i3 != 0) {
            reportStartGameFailed("914560", "20", i3, gameInfo);
        }
        WeakReference<IYunGameManagerService.a> weakReference = this.mCallbackMap.get(Integer.valueOf(i16));
        if (weakReference != null) {
            IYunGameManagerService.a aVar = weakReference.get();
            if (aVar != null) {
                aVar.onResult(i3, str);
            }
            this.mCallbackMap.remove(Integer.valueOf(i16));
        }
        IYunGameConstant.GameStatusInfo gameStatusInfo = new IYunGameConstant.GameStatusInfo();
        gameStatusInfo.setStatus(i3);
        gameStatusInfo.setMsg(str);
        gameStatusInfo.setGameInfo(gameInfo);
        notifyGameStatusChange(gameStatusInfo);
    }

    private void handleStartService(int i3) {
        this.mHandler.removeMessages(2);
        if (i3 == 0) {
            this.mIsServiceRunning = true;
        }
        this.mServiceStarting = false;
        flushCMD();
    }

    private void handleStoptGame(Bundle bundle) {
        int i3;
        String str = "";
        int i16 = -1;
        if (bundle != null) {
            i3 = bundle.getInt(IYunGameConstant.KEY_PARAM_RET);
            str = bundle.getString(IYunGameConstant.KEY_PARAM_MSG, "");
            Bundle bundle2 = bundle.getBundle("key_data");
            if (bundle2 != null) {
                i16 = bundle2.getInt("key_callback_id");
            }
        } else {
            i3 = 0;
        }
        WeakReference<IYunGameManagerService.a> weakReference = this.mCallbackMap.get(Integer.valueOf(i16));
        if (weakReference != null) {
            IYunGameManagerService.a aVar = weakReference.get();
            if (aVar != null) {
                aVar.onResult(i3, str);
            }
            this.mCallbackMap.remove(Integer.valueOf(i16));
        }
        cancelTips();
    }

    public static boolean hasOverlayPermission(Context context) {
        return Settings.canDrawOverlays(context);
    }

    private void notifyGameStatusChange(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        IYunGameManagerService.b bVar;
        QLog.i(TAG, 1, "[notifyGameStatusChange] statusInfo:" + gameStatusInfo);
        try {
            Iterator<WeakReference<IYunGameManagerService.b>> it = this.mGameStateListenerList.iterator();
            while (it.hasNext()) {
                WeakReference<IYunGameManagerService.b> next = it.next();
                if (next != null && (bVar = next.get()) != null) {
                    bVar.onStateChange(gameStatusInfo);
                }
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "[notifyGameStatusChange] e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetAuthKeyFailed() {
        IYunGameManagerService.a aVar;
        Iterator<Integer> it = this.mCallbackMap.keySet().iterator();
        while (it.hasNext()) {
            WeakReference<IYunGameManagerService.a> weakReference = this.mCallbackMap.get(Integer.valueOf(it.next().intValue()));
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                aVar.onResult(-1, "get auth key failed");
            }
        }
        this.mCallbackMap.clear();
        this.mCmdList.clear();
    }

    private void resetRetryCnt() {
        this.mRetryCnt = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgToServer(Pair<String, Bundle> pair) {
        String str = (String) pair.first;
        Intent intent = new Intent();
        intent.setAction(IYunGameConstant.YUN_GAME_BROADCAST_SERVICE_ACTION);
        intent.setPackage(this.mContext.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("key_cmd", str);
        bundle.putBundle("key_data", (Bundle) pair.second);
        intent.putExtras(bundle);
        this.mContext.sendBroadcast(intent);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:plugins", IYunGameConstant.IPC_NAME, (String) pair.first, bundle, new c(pair));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPluginServiceInternal() {
        QLog.i(TAG, 2, "[startPluginServiceInternal] start service, mRetryCnt:" + this.mRetryCnt);
        int i3 = this.mRetryCnt;
        if (i3 <= 0) {
            this.mRetryCnt = i3 - 1;
            return;
        }
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) YunGameService.class);
        intent.putExtra(IYunGameConstant.KEY_AUTH_KEY, this.mAuthKey);
        String currentUin = getCurrentUin();
        intent.putExtra(IYunGameConstant.KEY_USER_ID, currentUin);
        QLog.d(TAG, 4, "[startPluginService] key:" + this.mAuthKey + ", id:" + currentUin);
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 5000L);
        this.mContext.startService(intent);
    }

    public void addCmd(String str, Bundle bundle) {
        QLog.i(TAG, 1, "[addCmd] -> serviceRunnung:" + this.mIsServiceRunning + ", cmd:" + str);
        resetRetryCnt();
        this.mCmdList.add(new Pair<>(str, bundle));
        flushCMD();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void addGameStateListener(IYunGameManagerService.b bVar) {
        this.mGameStateListenerList.add(new WeakReference<>(bVar));
    }

    public void addRecentPlay(String str) {
        QLog.i(TAG, 2, "[addRecentPlay] add recent play list");
        GameCenterYunGameAuth$AddRecentPlayReq gameCenterYunGameAuth$AddRecentPlayReq = new GameCenterYunGameAuth$AddRecentPlayReq();
        gameCenterYunGameAuth$AddRecentPlayReq.appid.set(str);
        gameCenterYunGameAuth$AddRecentPlayReq.timestamp.set(System.currentTimeMillis());
        gameCenterYunGameAuth$AddRecentPlayReq.version_type.set(3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(TRPC_ADD_RECENT_PLAY, false, gameCenterYunGameAuth$AddRecentPlayReq.toByteArray());
        Bundle bundle = new Bundle();
        int i3 = mCurrentAuthId + 1;
        mCurrentAuthId = i3;
        bundle.putInt(IYunGameConstant.KEY_AUTH_ID, i3);
        bundle.putString("key_cmd", TRPC_ADD_RECENT_PLAY);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void cancelTips() {
        QLog.i(TAG, 1, "[cancelTips] cancel  tips.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        try {
            IYunGameTipsService iYunGameTipsService = (IYunGameTipsService) peekAppRuntime.getRuntimeService(IYunGameTipsService.class, "");
            if (iYunGameTipsService != null) {
                iYunGameTipsService.finish();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[showTips] e:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void exitBackground() {
        QLog.i(TAG, 1, "[exitBackground] exit background queue.");
        if (!hasOverlayPermission(MobileQQ.sMobileQQ)) {
            showTips();
        }
        addCmd(IYunGameConstant.CMD_EXIT_BACKGROUND, null);
    }

    public void flushCMD() {
        if (this.mIsServiceRunning) {
            this.mHandler.removeMessages(3);
            this.mHandler.sendEmptyMessage(3);
        } else {
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessage(4);
        }
    }

    public void getGameContinueToggle(String str) {
        QLog.i(TAG, 2, "[getGameContinueToggle] get game Toggle.");
        GameCenterYunGameAuth$ExperienceGameRequest gameCenterYunGameAuth$ExperienceGameRequest = new GameCenterYunGameAuth$ExperienceGameRequest();
        gameCenterYunGameAuth$ExperienceGameRequest.appids.add(str);
        gameCenterYunGameAuth$ExperienceGameRequest.plat.set(1);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(TRPC_GET_GAME_TOGGLE, false, gameCenterYunGameAuth$ExperienceGameRequest.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putString("key_cmd", TRPC_GET_GAME_TOGGLE);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public int getYunGameActivityStatus() {
        return this.mYunGameActivityStatus;
    }

    public boolean isSDKInstalled() {
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void notifyUserFeedback() {
        addCmd(IYunGameConstant.CMD_NOTIFY_USER_FEEDBACK, new Bundle());
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        Bundle bundle2;
        String str2;
        String str3;
        EIPCResult eIPCResult = new EIPCResult();
        if (bundle != null) {
            try {
                bundle2 = bundle.getBundle("key_data");
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[onCall] e:" + e16);
            }
        } else {
            bundle2 = null;
        }
        QLog.i(TAG, 1, "[onCall] server cmd: " + str);
        if (IYunGameConstant.CMD_START_GAME.equals(str)) {
            handleStartGame(bundle);
        } else {
            int i16 = -1;
            if (IYunGameConstant.CMD_SERVICE_START.equals(str)) {
                if (bundle != null) {
                    i16 = bundle.getInt(IYunGameConstant.KEY_PARAM_RET, -1);
                }
                handleStartService(i16);
            } else if (IYunGameConstant.CMD_GAME_STATUS_CHANGE.equals(str)) {
                handleQueueState(bundle2);
            } else if (IYunGameConstant.CMD_GAME_DESTORY.equals(str)) {
                cancelTips();
            } else if (IYunGameConstant.CMD_ERROR.equals(str)) {
                if (bundle != null) {
                    i16 = bundle.getInt(IYunGameConstant.KEY_PARAM_RET);
                }
                if (bundle != null) {
                    str3 = bundle.getString(IYunGameConstant.KEY_PARAM_MSG);
                } else {
                    str3 = "error";
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "[onCall] CMD_ERROR ret:" + i16 + ", msg: " + str3);
                }
                IYunGameConstant.GameStatusInfo gameStatusInfo = new IYunGameConstant.GameStatusInfo();
                gameStatusInfo.setStatus(i16);
                gameStatusInfo.setMsg(str3);
                notifyGameStatusChange(gameStatusInfo);
            } else if (IYunGameConstant.CMD_GAMEACTIVITY_ONSTART.equals(str)) {
                QLog.i(TAG, 1, "[onCall] handle onStart");
            } else if (IYunGameConstant.CMD_GAMEACTIVITY_ONRESUME.equals(str)) {
                QLog.i(TAG, 1, "[onCall] handle onResume");
                handleGameActivityResume();
            } else if (IYunGameConstant.CMD_GAMEACTIVITY_ONPAUSE.equals(str)) {
                QLog.i(TAG, 1, "[onCall] handle onPause");
            } else if (IYunGameConstant.CMD_GAMEACTIVITY_ONSTOP.equals(str)) {
                QLog.i(TAG, 1, "[onCall] handle onStop");
                handleGameActivityStop();
            } else if (IYunGameConstant.CMD_OPEN_MENU.equals(str)) {
                handleOpenMenu(this.mContext, bundle2);
            } else if (IYunGameConstant.CMD_SHOW_TIPS.equals(str)) {
                showTips();
            } else if (IYunGameConstant.CMD_GET_GAME_TOGGLE.equals(str)) {
                if (bundle2 != null) {
                    str2 = bundle2.getString(IYunGameConstant.KEY_PARAM_APPID);
                } else {
                    str2 = "";
                }
                QLog.i(TAG, 1, "[onCall] CMD_GET_GAME_TOGGLE:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                getGameContinueToggle(str2);
            }
        }
        eIPCResult.code = 0;
        return eIPCResult;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "[onCreate] onCreate======");
        this.mContext = appRuntime.getApplicationContext();
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        this.mHandler = new a(ThreadManagerV2.getSubThreadLooper());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "[onDestroy] onDestory======");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        mInstallListener = null;
        mCurrentAuthId = 0;
        this.mAuthKey = "";
        addCmd(IYunGameConstant.CMD_USER_DESTORY, null);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void onPushReceive(String str) {
        QLog.i(TAG, 1, "[onPushReceive] data:" + str);
        Bundle bundle = new Bundle();
        bundle.putString(IYunGameConstant.KEY_PUSH_DATA, str);
        addCmd(IYunGameConstant.CMD_PUSH, bundle);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public EIPCResult onRespone(String str, Bundle bundle, int i3) {
        Bundle bundle2;
        String str2;
        QLog.i(TAG, 1, "[onRespone] server action: " + str);
        EIPCResult eIPCResult = new EIPCResult();
        try {
            QLog.i(TAG, 1, "[onRespone] server cmd: " + str);
            if (IYunGameConstant.CMD_START_GAME.equals(str)) {
                handleStartGame(bundle);
            } else if (IYunGameConstant.CMD_RESTART_GAME.equals(str)) {
                handleRestartGame(bundle);
            } else if (IYunGameConstant.CMD_STOP_GAME.equals(str)) {
                handleStoptGame(bundle);
            } else if (IYunGameConstant.CMD_CHANGE_CLARITY.equals(str)) {
                QLog.d(TAG, 2, "[onRespone] change clarity ok");
            } else if (!IYunGameConstant.CMD_USER_DESTORY.equals(str)) {
                if (IYunGameConstant.CMD_SHOW_TIPS.equals(str)) {
                    showTips();
                } else if (IYunGameConstant.CMD_PUSH.equals(str)) {
                    QLog.d(TAG, 2, "[onRespone] push ok");
                } else if (IYunGameConstant.CMD_GET_GAME_TOGGLE.equals(str)) {
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("key_data");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        str2 = bundle2.getString(IYunGameConstant.KEY_PARAM_APPID);
                    } else {
                        str2 = "";
                    }
                    QLog.i(TAG, 1, "[onRespone] CMD_GET_GAME_TOGGLE:" + str2);
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    getGameContinueToggle(str2);
                } else if (IYunGameConstant.CMD_NOTIFY_USER_FEEDBACK.equals(str)) {
                    QLog.d(TAG, 2, "[onResponse] notify user feedback ok+++");
                }
            }
            eIPCResult.code = 0;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[onRespone] e:" + e16);
        }
        return eIPCResult;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void preLoadYunGame() {
        QLog.i(TAG, 1, "[preLoadYunGame] startService...");
        startPluginService();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void removeGameStateListener(IYunGameManagerService.b bVar) {
        Iterator<WeakReference<IYunGameManagerService.b>> it = this.mGameStateListenerList.iterator();
        while (it.hasNext()) {
            WeakReference<IYunGameManagerService.b> next = it.next();
            if (next != null && next.get() == bVar) {
                this.mGameStateListenerList.remove(next);
                return;
            }
        }
    }

    public void reportSDKAction(String str, String str2) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).report();
    }

    public void reportStartGameFailed(String str, String str2, int i3, GameInfo gameInfo) {
        String str3;
        String str4;
        String str5;
        String str6;
        QLog.i(TAG, 1, "[reportStartGameFailed] reportStartGameFailed======");
        if (gameInfo != null) {
            str3 = gameInfo.getReportChannelId();
            str5 = gameInfo.getGameId();
            str6 = gameInfo.getReportActId();
            str4 = gameInfo.getAppId();
        } else {
            str3 = "";
            str4 = "";
            str5 = str4;
            str6 = str5;
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setRetId(i3).setGameAppId(str4).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, str3).setExt(42, str5).setExt(43, str6).report();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void restartYunGame(GameInfo gameInfo, IYunGameManagerService.a aVar) {
        if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getGameId())) {
            QLog.i(TAG, 1, "[restartYunGame] restart game:");
            gameInfo.setCallbackId(CALLBACK_ID);
            ConcurrentHashMap<Integer, WeakReference<IYunGameManagerService.a>> concurrentHashMap = this.mCallbackMap;
            int i3 = CALLBACK_ID;
            CALLBACK_ID = i3 + 1;
            concurrentHashMap.put(Integer.valueOf(i3), new WeakReference<>(aVar));
            getPskey(new d(gameInfo));
            return;
        }
        QLog.e(TAG, 1, "[restartYunGame] err params:");
        if (aVar != null) {
            aVar.onResult(-5, "null param");
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void setYunGameClarity(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(IYunGameConstant.KEY_CLARITY, i3);
        addCmd(IYunGameConstant.CMD_CHANGE_CLARITY, bundle);
    }

    public void showTips() {
        QLog.i(TAG, 1, "[showTips] show tips.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        try {
            IYunGameTipsService iYunGameTipsService = (IYunGameTipsService) peekAppRuntime.getRuntimeService(IYunGameTipsService.class, "");
            if (iYunGameTipsService != null) {
                iYunGameTipsService.start();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[showTips] e:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void startGame(GameInfo gameInfo, IYunGameManagerService.a aVar) {
        if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getGameId())) {
            gameInfo.setLaunchGameTimeStamp(System.currentTimeMillis());
            addRecentPlay(gameInfo.getAppId());
            gameInfo.setCallbackId(CALLBACK_ID);
            ConcurrentHashMap<Integer, WeakReference<IYunGameManagerService.a>> concurrentHashMap = this.mCallbackMap;
            int i3 = CALLBACK_ID;
            CALLBACK_ID = i3 + 1;
            concurrentHashMap.put(Integer.valueOf(i3), new WeakReference<>(aVar));
            getPskey(new b(gameInfo));
            return;
        }
        QLog.e(TAG, 1, "[startGame] err params:");
        if (aVar != null) {
            aVar.onResult(-5, "null param");
        }
    }

    public void startPluginService() {
        if (this.mIsServiceRunning) {
            return;
        }
        this.mHandler.removeMessages(4);
        this.mHandler.sendEmptyMessage(4);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService
    public void stopGame(GameInfo gameInfo, IYunGameManagerService.a aVar) {
        if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getGameId())) {
            QLog.i(TAG, 1, "[stopGame] stopGame game:");
            gameInfo.setCallbackId(CALLBACK_ID);
            ConcurrentHashMap<Integer, WeakReference<IYunGameManagerService.a>> concurrentHashMap = this.mCallbackMap;
            int i3 = CALLBACK_ID;
            CALLBACK_ID = i3 + 1;
            concurrentHashMap.put(Integer.valueOf(i3), new WeakReference<>(aVar));
            Bundle bundle = new Bundle();
            bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, gameInfo);
            addCmd(IYunGameConstant.CMD_STOP_GAME, bundle);
            return;
        }
        QLog.e(TAG, 1, "[stopGame] err params:");
        if (aVar != null) {
            aVar.onResult(-5, "null param");
        }
    }
}
