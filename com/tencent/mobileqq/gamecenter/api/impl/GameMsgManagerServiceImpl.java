package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting$QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public class GameMsgManagerServiceImpl implements IGameMsgManagerService, Observer {
    public static final int DELAY_HANDLE_MSG_TIME = 1000;
    public static final int GAME_CONVERSATION_MAX_NUM = 200;
    public static final int GAME_SWITCH_PULL_INTERVAL = 300000;
    public static final int GAME_USER_INFO_PULL_INTERVAL = 120000;
    private static final long LIMIT_REQUEST_USER_INFO_TIME = 100;
    public static final String MMKV_KEY_MSG_PARTNER_LIST = "gamecenter_msg_partner_list";
    public static final String SP_KEY_ENTER_PUB = "sp_enter_pub";
    public static final String SP_KEY_PUBACC_MSG_REDPOINT = "sp_pubacc_msg_redpoint";
    public static final String SP_KEY_REQ_MSG_READ_TIME = "sp_key_req_msg_read_time";
    public static final String SP_KEY_REQ_MSG_R_VALUE = "sp_key_req_msg_unread_num";
    private static final String TAG = "GameMsgManagerServiceImpl";
    private EntityManager mEntityMgr;
    private volatile com.tencent.mobileqq.gamecenter.api.g mGameMsgPartnerCallback;
    private volatile com.tencent.mobileqq.gamecenter.api.h mGameMsgSayHiCallback;
    private List<com.tencent.mobileqq.gamecenter.data.n> mPartnerList;
    private com.tencent.mobileqq.gamecenter.api.j mRemoteListCallback;
    private GameDelSessionDataHelper mSessionDelDataHelper;
    public boolean mIsHasUnreadMsg = false;
    public com.tencent.mobileqq.gamecenter.data.h mQQPlayerUtil = new com.tencent.mobileqq.gamecenter.data.h();
    public boolean mNeedPopMsgView = false;
    public boolean mShowReqMsgUnread = false;
    private int mPubMsgRedPointSwitch = 0;
    private boolean mMsgShowedOnList = false;
    private boolean mInited = false;
    private final Map<String, String> mRoleIdRedDotMap = Collections.synchronizedMap(new HashMap());
    private long mGameSwitchLastUpdateTime = 0;
    private WeakReference<AppInterface> mApp = new WeakReference<>(null);
    private final Map<String, GameUserInfo> mGameUserInfoMapCache = Collections.synchronizedMap(new HashMap());
    private final Map<String, GameBasicInfo> mGameBasicConfigCache = Collections.synchronizedMap(new HashMap());
    private final Map<String, GameSwitchConfig> mGameSwitchConfigCache = Collections.synchronizedMap(new HashMap());
    private final Map<String, GameCenterSessionInfo> mSessionMap = new ConcurrentHashMap();
    private final Map<String, GameCenterSessionInfo> mFolderMap = new ConcurrentHashMap();
    private final Map<String, GameCenterSessionInfo> mNormalMap = new ConcurrentHashMap();
    private bd1.b mTabConfig = new bd1.b();
    private int mUnshowedUnreadCnt = 0;
    private int mHashcode = hashCode();
    private final ArrayList<WeakReference<ie1.b>> mUserInfoChangeObserverList = new ArrayList<>();
    private final HashMap<String, Long> mRequestGameUserInfoRecord = new HashMap<>(100);
    private final IGameMsgNtApi msgNtApi = (IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class);
    private final Handler mSubHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
    private final AtomicBoolean mIsDestroy = new AtomicBoolean(false);
    private Set<IGameMsgManagerService.a> mPartnerListeners = new CopyOnWriteArraySet();
    private boolean mPushMsgForH5 = false;
    private final RedpointObserver mRedPointObserver = new a();
    private final ie1.b mSessionInfoObserver = new ie1.b(this.mHashcode) { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.2
        @Override // ie1.b
        public void d(final Object obj) {
            super.d(obj);
            GameMsgManagerServiceImpl.this.notifyUserInfoChanged(obj);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!(obj instanceof ArrayList)) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, "[onGameUserInfoChangedNotify] detail:" + obj);
                    }
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (arrayList.get(i3) instanceof gd1.a) {
                            gd1.a aVar = (gd1.a) arrayList.get(i3);
                            if (GameMsgManagerServiceImpl.this.isGameMsgBlocked(aVar.f401939c)) {
                                QLog.i("GameCenterMsg.GameCenterUnissoObserver", 2, "[onGameUserInfoChangedNotify], blocked! gameId:" + aVar.f401939c);
                            } else {
                                GameCenterSessionInfo sessionInfoByRoleId = GameMsgManagerServiceImpl.this.getSessionInfoByRoleId(aVar.f401937a);
                                if (sessionInfoByRoleId != null) {
                                    GameMsgManagerServiceImpl.this.updateSessionInfo(sessionInfoByRoleId, aVar);
                                    GameMsgManagerServiceImpl.this.startNotifyOnUserInfoChanged(i3, size, sessionInfoByRoleId);
                                }
                            }
                        }
                    }
                }
            }, 32, null, true);
        }
    };
    private final Runnable mInitTask = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.3
        @Override // java.lang.Runnable
        public void run() {
            GameMsgManagerServiceImpl.this.checkIfSendPubDetailReq();
            GameMsgManagerServiceImpl.this.initGameUserInfo();
            GameMsgManagerServiceImpl.this.initGameBasicConfig();
            GameMsgManagerServiceImpl.this.tryGetGameSwitchFromSvr();
            GameMsgManagerServiceImpl.this.initGameSwitchConfig();
            GameMsgManagerServiceImpl.this.initTabCongif();
            GameMsgManagerServiceImpl.this.initSessionDelDb();
            GameMsgManagerServiceImpl.this.addObservers();
            GameMsgManagerServiceImpl.this.initSessionInfoListNt();
            QLog.i(GameMsgManagerServiceImpl.TAG, 1, "init task ends");
        }
    };
    private final IKernelMsgListener mMsgListener = new b();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends RedpointObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            if (z16) {
                GameMsgManagerServiceImpl.this.doOnNotifyLebaRedTouch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.qqnt.msg.i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(@NonNull MsgRecord msgRecord) {
            GameMsgManagerServiceImpl.this.handleOnMsgReceive(msgRecord);
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(@NonNull ArrayList<MsgRecord> arrayList) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                GameMsgManagerServiceImpl.this.handleOnMsgReceive(arrayList.get(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c implements k71.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GameMsgManagerServiceImpl> f211870a;

        public c(GameMsgManagerServiceImpl gameMsgManagerServiceImpl) {
            this.f211870a = new WeakReference<>(gameMsgManagerServiceImpl);
        }

        @Override // k71.a
        public void onLoadFailed() {
            QLog.i(GameMsgManagerServiceImpl.TAG, 1, "[fetchRecentGameContacts] onLoadFailed");
            GameMsgManagerServiceImpl gameMsgManagerServiceImpl = this.f211870a.get();
            if (gameMsgManagerServiceImpl != null) {
                gameMsgManagerServiceImpl.fetchGameRecentContactFromNt();
            }
        }

        @Override // k71.a
        public void onLoadSuccess() {
            QLog.i(GameMsgManagerServiceImpl.TAG, 1, "[fetchRecentGameContacts] onLoadSuccess");
            GameMsgManagerServiceImpl gameMsgManagerServiceImpl = this.f211870a.get();
            if (gameMsgManagerServiceImpl != null) {
                gameMsgManagerServiceImpl.fetchGameRecentContactFromNt();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GameMsgManagerServiceImpl> f211871a;

        public d(GameMsgManagerServiceImpl gameMsgManagerServiceImpl) {
            this.f211871a = new WeakReference<>(gameMsgManagerServiceImpl);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            GameMsgManagerServiceImpl gameMsgManagerServiceImpl = this.f211871a.get();
            if (gameMsgManagerServiceImpl != null) {
                if (!gameMsgManagerServiceImpl.mIsDestroy.get()) {
                    AppInterface appFromWeakRef = gameMsgManagerServiceImpl.getAppFromWeakRef();
                    if (appFromWeakRef == null) {
                        QLog.i(GameMsgManagerServiceImpl.TAG, 1, "[fetchGameRecentContactFromNt] app is null");
                        return;
                    }
                    QLog.i(GameMsgManagerServiceImpl.TAG, 1, "[fetchGameRecentContactFromNt] success,mMsgListener:" + gameMsgManagerServiceImpl.mMsgListener);
                    gameMsgManagerServiceImpl.getSessionInfoList(0, IGameMsgManagerService.GAMEID_INIT);
                    gameMsgManagerServiceImpl.initDataFromSp();
                    gameMsgManagerServiceImpl.msgNtApi.removeMsgListener(gameMsgManagerServiceImpl.mMsgListener);
                    gameMsgManagerServiceImpl.msgNtApi.addMsgListener(gameMsgManagerServiceImpl.mMsgListener);
                    ((ITempApi) QRoute.api(ITempApi.class)).updateRecentList(appFromWeakRef);
                    gameMsgManagerServiceImpl.mInited = true;
                    return;
                }
                QLog.i(GameMsgManagerServiceImpl.TAG, 1, "service is destroy");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addObservers() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null) {
            appFromWeakRef.addObserver(this.mSessionInfoObserver);
            appFromWeakRef.addObserver(this.mRedPointObserver);
        }
    }

    private void addUserInfo(List<GameCenterSessionInfo> list) {
        HashSet hashSet = new HashSet();
        if (list != null && list.size() != 0) {
            for (GameCenterSessionInfo gameCenterSessionInfo : list) {
                hashSet.add(gameCenterSessionInfo.v());
                hashSet.add(gameCenterSessionInfo.r());
            }
            QLog.i(TAG, 1, "[addUserInfo], roleid size:" + hashSet.size());
            HashMap<String, gd1.a> gameDetailInfo = getGameDetailInfo(new ArrayList<>(hashSet));
            for (GameCenterSessionInfo gameCenterSessionInfo2 : list) {
                gd1.a aVar = gameDetailInfo.get(gameCenterSessionInfo2.v());
                if (aVar != null) {
                    updateSessionInfo(gameCenterSessionInfo2, aVar);
                }
            }
            Iterator<String> it = this.mSessionMap.keySet().iterator();
            while (it.hasNext()) {
                GameCenterSessionInfo gameCenterSessionInfo3 = this.mSessionMap.get(it.next());
                gd1.a aVar2 = gameDetailInfo.get(gameCenterSessionInfo3.v());
                if (aVar2 != null) {
                    updateSessionInfo(gameCenterSessionInfo3, aVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int calculateUnreadCnt(boolean z16) {
        int i3;
        long reqMsgCnt;
        int i16;
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return 0;
        }
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appFromWeakRef.getRuntimeService(IGameMsgBoxManager.class, "");
        Iterator<String> it = this.mNormalMap.keySet().iterator();
        int i17 = 0;
        while (it.hasNext()) {
            GameCenterSessionInfo gameCenterSessionInfo = this.mNormalMap.get(it.next());
            if (gameCenterSessionInfo != null && (!isShowInMsgBox() || !iGameMsgBoxManager.isGameInGameBox(gameCenterSessionInfo.m()))) {
                i17 += gameCenterSessionInfo.z();
            }
        }
        if (this.mPubMsgRedPointSwitch == 1) {
            i3 = 0 + i17;
        } else {
            i3 = 0;
        }
        if (isShowInMsgBox()) {
            try {
                Iterator<String> it5 = iGameMsgBoxManager.getAppidsInGameBox().iterator();
                i16 = 0;
                while (it5.hasNext()) {
                    try {
                        if (this.mFolderMap.containsKey(it5.next())) {
                            i16++;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(TAG, 1, e, new Object[0]);
                        if (this.mFolderMap.size() - i16 <= 0) {
                        }
                        if (z16) {
                        }
                        if (i17 + reqMsgCnt > 0) {
                        }
                        QLog.i(TAG, 1, "[getUnreadCntNt] cnt:" + i3);
                        return i3;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i16 = 0;
            }
            if (this.mFolderMap.size() - i16 <= 0) {
                reqMsgCnt = getReqMsgCnt();
            } else {
                reqMsgCnt = 0;
            }
        } else {
            reqMsgCnt = getReqMsgCnt();
        }
        if (z16) {
            i3 = (int) (i3 + reqMsgCnt);
        }
        if (i17 + reqMsgCnt > 0) {
            this.mIsHasUnreadMsg = true;
        }
        QLog.i(TAG, 1, "[getUnreadCntNt] cnt:" + i3);
        return i3;
    }

    private int calculateUnreadCnt4MsgTab() {
        Iterator<String> it = this.mNormalMap.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            GameCenterSessionInfo gameCenterSessionInfo = this.mNormalMap.get(it.next());
            if (gameCenterSessionInfo != null) {
                i3 += gameCenterSessionInfo.z();
            }
        }
        int i16 = 0 + i3;
        if (i3 > 0) {
            this.mIsHasUnreadMsg = true;
        }
        QLog.i(TAG, 1, "[calculateUnreadCnt4MsgTabNt] cnt:" + i16);
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIfSendPubDetailReq() {
        QLog.i(TAG, 1, "init task starts.");
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null && ((IPublicAccountDataManager) appFromWeakRef.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfo("2747277822") == null) {
            QLog.i(TAG, 1, " qqgame public account detail not exist, try to get it.");
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(appFromWeakRef, appFromWeakRef.getApplication(), "2747277822");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> checkUsrInfoUpdateList(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                GameUserInfo findGameUserInfo = findGameUserInfo(next);
                if (findGameUserInfo == null) {
                    arrayList2.add(next);
                } else if (currentTimeMillis - findGameUserInfo.mSaveTs >= 120000) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return null;
    }

    private GameCenterSessionInfo createSessionInfo(TempChatGameSession tempChatGameSession) {
        QLog.d(TAG, 2, "[crreatSessionInfo] create new sessionInfo" + tempChatGameSession);
        GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
        if (tempChatGameSession != null) {
            String createConvertUinFromTinyId = this.msgNtApi.createConvertUinFromTinyId(tempChatGameSession.getSelfTinyId(), tempChatGameSession.getPeerTinyId());
            gameCenterSessionInfo.j0(createConvertUinFromTinyId);
            if (isGameMsgBlocked(tempChatGameSession.getGameAppId() + "")) {
                QLog.i(TAG, 1, "[update] ##-- new msg:" + createConvertUinFromTinyId + ", blocked.");
                return null;
            }
            gameCenterSessionInfo.i0(tempChatGameSession.getPeerRoleId());
            gameCenterSessionInfo.b0(tempChatGameSession.getSelfRoleId());
            gameCenterSessionInfo.G(tempChatGameSession.getPeerTinyId());
            gameCenterSessionInfo.l0(tempChatGameSession.getSelfTinyId());
            gameCenterSessionInfo.N(tempChatGameSession.getGameAppId() + "");
            gd1.a singleGameDetail = getSingleGameDetail(gameCenterSessionInfo.v());
            if (singleGameDetail != null) {
                updateSessionInfo(gameCenterSessionInfo, singleGameDetail);
            }
            if (isGameMsgSync(tempChatGameSession.getGameAppId() + "")) {
                gameCenterSessionInfo.k0(1);
                this.mNormalMap.put(gameCenterSessionInfo.w(), gameCenterSessionInfo);
            } else {
                gameCenterSessionInfo.k0(0);
                gameCenterSessionInfo.B();
                this.mFolderMap.put(gameCenterSessionInfo.m(), gameCenterSessionInfo);
            }
            this.mSessionMap.put(gameCenterSessionInfo.w(), gameCenterSessionInfo);
        }
        return gameCenterSessionInfo;
    }

    private void deleteAllSession(String str) {
        AppInterface appFromWeakRef;
        com.tencent.qqnt.kernel.api.aa recentContactService;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[deleteAllSession] gameId:" + str);
        }
        if (TextUtils.isEmpty(str) || (appFromWeakRef = getAppFromWeakRef()) == null || (recentContactService = ((IKernelService) appFromWeakRef.getRuntimeService(IKernelService.class, "")).getRecentContactService()) == null) {
            return;
        }
        Iterator<Map.Entry<String, GameCenterSessionInfo>> it = this.mSessionMap.entrySet().iterator();
        ArrayList<RecentContactInfo> arrayList = new ArrayList<>();
        while (it.hasNext()) {
            GameCenterSessionInfo value = it.next().getValue();
            if (str.equals(value.m())) {
                it.remove();
                arrayList.add(this.msgNtApi.buildRecentContactInfo(value.w(), 105));
            }
        }
        if (arrayList.size() > 0) {
            recentContactService.deleteRecentContacts(arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ad
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GameMsgManagerServiceImpl.lambda$deleteAllSession$2(i3, str2);
                }
            });
        }
        Iterator<Map.Entry<String, GameCenterSessionInfo>> it5 = this.mNormalMap.entrySet().iterator();
        while (it5.hasNext()) {
            if (str.equals(it5.next().getValue().m())) {
                it5.remove();
            }
        }
        Iterator<Map.Entry<String, GameCenterSessionInfo>> it6 = this.mFolderMap.entrySet().iterator();
        while (it6.hasNext()) {
            if (str.equals(it6.next().getKey())) {
                it6.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnNotifyLebaRedTouch() {
        ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).reportRedTouchArrived();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchGameRecentContactFromNt() {
        this.mSubHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ae
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgManagerServiceImpl.this.lambda$fetchGameRecentContactFromNt$0();
            }
        }, 1000L);
    }

    private void fillFolderMap(GameCenterSessionInfo gameCenterSessionInfo) {
        if (gameCenterSessionInfo == null) {
            return;
        }
        gameCenterSessionInfo.k0(0);
        if (gameCenterSessionInfo.z() > 0) {
            if (!this.mFolderMap.containsKey(gameCenterSessionInfo.m())) {
                gameCenterSessionInfo.B();
                this.mFolderMap.put(gameCenterSessionInfo.m(), gameCenterSessionInfo);
                return;
            }
            GameCenterSessionInfo gameCenterSessionInfo2 = this.mFolderMap.get(gameCenterSessionInfo.m());
            if (gameCenterSessionInfo2 != null && gameCenterSessionInfo.q() > gameCenterSessionInfo2.q()) {
                gameCenterSessionInfo.h0(gameCenterSessionInfo2.u() + 1);
                this.mFolderMap.put(gameCenterSessionInfo.m(), gameCenterSessionInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public AppInterface getAppFromWeakRef() {
        return this.mApp.get();
    }

    private List<GameCenterSessionInfo> getFilteredList(List<GameCenterSessionInfo> list, String str) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            if (!isSpecialGameId(str) && !TextUtils.isEmpty(str)) {
                for (GameCenterSessionInfo gameCenterSessionInfo : list) {
                    if (str.equals(gameCenterSessionInfo.m())) {
                        arrayList.add(gameCenterSessionInfo);
                    }
                }
                list = arrayList;
            }
            try {
                Collections.sort(list);
                QLog.i(TAG, 1, "[getFilteredList], gameList.size:" + list.size());
            } catch (IllegalArgumentException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            if (list.size() > 200) {
                return list.subList(0, 200);
            }
            return list;
        }
        return null;
    }

    private GameCenterSessionInfo getFolderSession(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mFolderMap.size() == 0) {
            getSessionInfoList();
        }
        return this.mFolderMap.get(str);
    }

    private List<GameCenterSessionInfo> getGameCenterSessionInfos(int i3, String str) {
        this.mNormalMap.clear();
        this.mFolderMap.clear();
        Iterator<String> it = this.mSessionMap.keySet().iterator();
        while (it.hasNext()) {
            GameCenterSessionInfo gameCenterSessionInfo = this.mSessionMap.get(it.next());
            gameCenterSessionInfo.h0(0);
            if (isGameMsgSync(gameCenterSessionInfo.m())) {
                gameCenterSessionInfo.k0(1);
                this.mNormalMap.put(gameCenterSessionInfo.w(), gameCenterSessionInfo);
            } else {
                fillFolderMap(gameCenterSessionInfo);
            }
        }
        return getRequiredSessionList(i3, str);
    }

    private GameCenterSessionInfo getLastSessionInfoFromMap() {
        ArrayList arrayList = new ArrayList(this.mFolderMap.values());
        ArrayList arrayList2 = new ArrayList(this.mNormalMap.values());
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        if (arrayList.size() > 0 && arrayList2.size() > 0) {
            GameCenterSessionInfo gameCenterSessionInfo = (GameCenterSessionInfo) arrayList.get(0);
            GameCenterSessionInfo gameCenterSessionInfo2 = (GameCenterSessionInfo) arrayList2.get(0);
            if (gameCenterSessionInfo.q() > gameCenterSessionInfo2.q()) {
                return gameCenterSessionInfo;
            }
            return gameCenterSessionInfo2;
        }
        if (arrayList.size() > 0) {
            return (GameCenterSessionInfo) arrayList.get(0);
        }
        if (arrayList2.size() > 0) {
            return (GameCenterSessionInfo) arrayList2.get(0);
        }
        return null;
    }

    private GameCenterSessionInfo getLastestSession(List<GameCenterSessionInfo> list) {
        for (GameCenterSessionInfo gameCenterSessionInfo : list) {
            if (gameCenterSessionInfo != null) {
                GameDelSessionRecord gameDelSessionRecord = new GameDelSessionRecord();
                gameDelSessionRecord.mUin = gameCenterSessionInfo.w();
                if (!this.mSessionDelDataHelper.b(gameDelSessionRecord)) {
                    return gameCenterSessionInfo;
                }
            }
        }
        return null;
    }

    @NonNull
    private static bd1.a getMsgConfigBean() {
        return (bd1.a) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_MSG_AIO_CONFIG, new bd1.a());
    }

    private List<GameCenterSessionInfo> getRequiredSessionList(int i3, String str) {
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            arrayList.addAll(this.mNormalMap.values());
            arrayList.addAll(this.mFolderMap.values());
        } else if (i3 == 1) {
            arrayList = new ArrayList(this.mFolderMap.values());
        } else if (i3 == 2) {
            arrayList = new ArrayList(this.mNormalMap.values());
        } else if (i3 == 3) {
            for (String str2 : this.mSessionMap.keySet()) {
                if (TextUtils.equals(str, this.mSessionMap.get(str2).m())) {
                    arrayList.add(this.mSessionMap.get(str2));
                }
            }
        }
        List<GameCenterSessionInfo> filteredList = getFilteredList(arrayList, str);
        if (!isSpecialGameId(str)) {
            addUserInfo(filteredList);
        }
        return filteredList;
    }

    @Nullable
    private GameCenterSessionInfo getSessionInfoByRoleIdFromCache(String str) {
        Iterator<String> it = this.mSessionMap.keySet().iterator();
        while (it.hasNext()) {
            GameCenterSessionInfo gameCenterSessionInfo = this.mSessionMap.get(it.next());
            if (gameCenterSessionInfo != null && str.equals(gameCenterSessionInfo.v())) {
                return gameCenterSessionInfo;
            }
        }
        return null;
    }

    private void handleFolderSession(GameCenterSessionInfo gameCenterSessionInfo) {
        if (gameCenterSessionInfo != null && gameCenterSessionInfo.x() == 0) {
            GameCenterSessionInfo folderSession = getFolderSession(gameCenterSessionInfo.m());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[handleFolderSession] folder session:" + folderSession);
            }
            if (folderSession != null) {
                gameCenterSessionInfo.h0(folderSession.u() + 1);
            } else {
                gameCenterSessionInfo.B();
            }
            this.mFolderMap.put(gameCenterSessionInfo.m(), gameCenterSessionInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleMsgBoxCase(int i3, String str, int i16) {
        int i17;
        boolean z16;
        boolean z17 = true;
        if (i3 == 0 && i16 == 1) {
            i17 = 3;
        } else if (i3 == 2) {
            if (i16 == 0) {
                i17 = 2;
            } else {
                i17 = 1;
            }
        } else {
            i17 = 0;
            z16 = false;
            if (z16 || !isShowInMsgBox()) {
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[onGameSwitchChange] gameId:" + str + ",switchType:" + i3 + ", value: " + i16 + ", notifyMsgBox:" + z17);
            }
            if (!z17) {
                notifyMsgBox(str, i17);
                return;
            }
            return;
        }
        z16 = true;
        if (z16) {
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        if (!z17) {
        }
    }

    private void handleMsgBoxNtCase(GameSwitchConfig gameSwitchConfig, int i3, int i16) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null && gameSwitchConfig != null) {
            if (i3 == 2 && i16 == 1) {
                gameSwitchConfig.mSyncSwitch = 1;
                gameSwitchConfig.mBlockSwitch = 0;
                gameSwitchConfig.mMuteSwitch = 0;
            } else if (i3 == 2 && i16 == 0) {
                gameSwitchConfig.mSyncSwitch = 1;
                gameSwitchConfig.mBlockSwitch = 0;
                gameSwitchConfig.mMuteSwitch = 1;
            } else if (i3 == 0 && i16 == 1) {
                gameSwitchConfig.mSyncSwitch = 0;
                gameSwitchConfig.mBlockSwitch = 1;
                gameSwitchConfig.mMuteSwitch = 0;
            }
            GameBasicInfo findGameConfig = findGameConfig(gameSwitchConfig.mAppId);
            if (findGameConfig != null) {
                ((IGameMsgBoxManager) appFromWeakRef.getRuntimeService(IGameMsgBoxManager.class, "")).setConfigToNTKernel(appFromWeakRef, gameSwitchConfig, findGameConfig.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMsgReceive(final MsgRecord msgRecord) {
        if (!isGameMsg(msgRecord)) {
            return;
        }
        this.mSubHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ac
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgManagerServiceImpl.this.lambda$handleOnMsgReceive$3(msgRecord);
            }
        }, 1000L);
    }

    private void handleRedPointSwitch(TempChatGameSession tempChatGameSession) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appFromWeakRef.getRuntimeService(IGameMsgBoxManager.class, "");
        if (isShowInMsgBox() && iGameMsgBoxManager.isGameInGameBox(String.valueOf(tempChatGameSession.getGameAppId()))) {
            onGameMsgRRecv(1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[handleRedPointSwitch] in msgBox,appId:" + tempChatGameSession.getGameAppId());
                return;
            }
            return;
        }
        onGameMsgRRecv(tempChatGameSession.getRedPointSwitch().intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleRequestGameUserInfo(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList);
        if (limitUpdateUserInfoRepeatedly(arrayList2)) {
            return;
        }
        QLog.i(TAG, 1, "[handleRequestGameUserInfo] list:" + arrayList);
        GameCenterUnissoHandler.N2().M2(this.mHashcode, arrayList2);
    }

    private void handleSessionInfo(MsgRecord msgRecord, RecentContactInfo recentContactInfo, int i3, GameCenterSessionInfo gameCenterSessionInfo) {
        int z16;
        if (getAppFromWeakRef() == null) {
            return;
        }
        if (gameCenterSessionInfo == null) {
            gameCenterSessionInfo = createSessionInfo(this.msgNtApi.getGameSessionFromContact(recentContactInfo));
            if (gameCenterSessionInfo == null) {
                return;
            } else {
                z16 = 0;
            }
        } else {
            z16 = gameCenterSessionInfo.z();
            handleFolderSession(gameCenterSessionInfo);
        }
        gameCenterSessionInfo.m0(i3);
        gameCenterSessionInfo.Z(hd1.a.b(msgRecord));
        gameCenterSessionInfo.a0(msgRecord.getMsgTime());
        notifyMessageChange(gameCenterSessionInfo, z16);
    }

    private void handleSwitchType0(GameSwitchConfig gameSwitchConfig, String str, int i3) {
        if (gameSwitchConfig == null) {
            return;
        }
        if (i3 != 0 && i3 != 1) {
            gameSwitchConfig.mBlockSwitch = 0;
        } else {
            gameSwitchConfig.mBlockSwitch = i3;
        }
        ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
        arrayList.add(gameSwitchConfig);
        saveOrUpdateGameSwitchConfigs(arrayList);
        if (gameSwitchConfig.mBlockSwitch == 1) {
            deleteAllSession(str);
        }
    }

    private void handleSwitchType1(GameSwitchConfig gameSwitchConfig, String str, int i3) {
        if (gameSwitchConfig == null) {
            return;
        }
        if (i3 != 0 && i3 != 1) {
            gameSwitchConfig.mSyncSwitch = 1;
        } else {
            gameSwitchConfig.mSyncSwitch = i3;
        }
        ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
        arrayList.add(gameSwitchConfig);
        saveOrUpdateGameSwitchConfigs(arrayList);
        if (gameSwitchConfig.mSyncSwitch == 0) {
            setAllReaded(str);
        }
    }

    private void handleSwitchType2(GameSwitchConfig gameSwitchConfig, String str, int i3) {
        if (gameSwitchConfig == null) {
            return;
        }
        if (i3 != 0 && i3 != 1) {
            gameSwitchConfig.mBoxSwitch = 0;
        } else {
            gameSwitchConfig.mBoxSwitch = i3;
        }
        ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
        arrayList.add(gameSwitchConfig);
        saveOrUpdateGameSwitchConfigs(arrayList);
    }

    private boolean initApp(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            this.mApp = new WeakReference<>((AppInterface) appRuntime);
            return true;
        }
        QLog.e(TAG, 1, "appRuntime not instanceof AppInterface");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDataFromSp() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        SharedPreferences sharedPreferences = appFromWeakRef.getApplication().getSharedPreferences("game_center_sp", 0);
        this.mUnshowedUnreadCnt = sharedPreferences.getInt(SP_KEY_ENTER_PUB + appFromWeakRef.getCurrentAccountUin(), 0);
        this.mPubMsgRedPointSwitch = sharedPreferences.getInt(SP_KEY_PUBACC_MSG_REDPOINT, 0);
        QLog.i(TAG, 1, "mPubMsgRedPointSwitch:" + this.mPubMsgRedPointSwitch + ",unreadCnt =" + this.mUnshowedUnreadCnt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGameBasicConfig() {
        try {
            ArrayList arrayList = (ArrayList) this.mEntityMgr.query(GameBasicInfo.class);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Entity entity = (Entity) it.next();
                    if (entity != null) {
                        GameBasicInfo gameBasicInfo = (GameBasicInfo) entity;
                        if (!TextUtils.isEmpty(gameBasicInfo.mAppId)) {
                            this.mGameBasicConfigCache.put(gameBasicInfo.mAppId, gameBasicInfo);
                        }
                    }
                }
                QLog.i(TAG, 1, "gameConfig.size:" + this.mGameBasicConfigCache.size());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGameSwitchConfig() {
        try {
            ArrayList arrayList = (ArrayList) this.mEntityMgr.query(GameSwitchConfig.class);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Entity entity = (Entity) it.next();
                    if (entity != null) {
                        GameSwitchConfig gameSwitchConfig = (GameSwitchConfig) entity;
                        if (!TextUtils.isEmpty(gameSwitchConfig.mAppId)) {
                            this.mGameSwitchConfigCache.put(gameSwitchConfig.mAppId, gameSwitchConfig);
                        }
                    }
                }
                QLog.i(TAG, 1, "gameSwitchConfig.size:" + this.mGameSwitchConfigCache.size());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGameUserInfo() {
        try {
            ArrayList arrayList = (ArrayList) this.mEntityMgr.query(GameUserInfo.class);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Entity entity = (Entity) it.next();
                    if (entity != null) {
                        GameUserInfo gameUserInfo = (GameUserInfo) entity;
                        if (!TextUtils.isEmpty(gameUserInfo.mRoleId)) {
                            this.mGameUserInfoMapCache.put(gameUserInfo.mRoleId, gameUserInfo);
                        }
                    }
                }
                QLog.i(TAG, 1, "ursInfo.size:" + this.mGameUserInfoMapCache.size());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSessionDelDb() {
        this.mSessionDelDataHelper.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSessionInfoListNt() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null) {
            ((IGameMsgBoxManager) appFromWeakRef.getRuntimeService(IGameMsgBoxManager.class, "")).fetchRecentGameContacts(true, new c(this), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTabCongif() {
        SharedPreferences sharedPreferences;
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null || (sharedPreferences = appFromWeakRef.getApplication().getSharedPreferences("game_center_sp", 0)) == null) {
            return;
        }
        this.mTabConfig = bd1.b.d(sharedPreferences.getString(appFromWeakRef.getCurrentAccountUin() + "sp_key_tab_config", ""));
    }

    private boolean isGameMsg(MsgRecord msgRecord) {
        if (msgRecord != null && msgRecord.getChatType() == 105) {
            return true;
        }
        return false;
    }

    private boolean isLastMessageInGameBox(int i3) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null || i3 == 0) {
            return false;
        }
        if (this.mSessionMap.size() == 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    GameMsgManagerServiceImpl.this.getSessionInfoList();
                }
            }, 16, null, false);
            return false;
        }
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appFromWeakRef.getRuntimeService(IGameMsgBoxManager.class, "");
        GameCenterSessionInfo lastSessionInfoExceptDelSession = getLastSessionInfoExceptDelSession();
        if (lastSessionInfoExceptDelSession == null) {
            return false;
        }
        return iGameMsgBoxManager.isGameInGameBox(lastSessionInfoExceptDelSession.m());
    }

    private boolean isSpecialGameId(String str) {
        if (!IGameMsgManagerService.GAMEID_INIT.equals(str) && !IGameMsgManagerService.GAMEID_GET_UNREAD_NUM.equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteAllSession$2(int i3, String str) {
        QLog.i(TAG, 2, "[deleteRecentContacts] result:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchGameRecentContactFromNt$0() {
        this.msgNtApi.fetchGameRecentContactInfo(new AnchorPointContactInfo(), true, 200, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(AppRuntime appRuntime) {
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.c.e().b(appRuntime, this.mEntityMgr);
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.d.f().b(appRuntime, this.mEntityMgr);
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b.j().b(appRuntime, this.mEntityMgr);
    }

    private void notifyMessageChange(GameCenterSessionInfo gameCenterSessionInfo, int i3) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        int unreadCnt = getUnreadCnt();
        int z16 = gameCenterSessionInfo.z();
        int unreadCnt4MsgTab = getUnreadCnt4MsgTab();
        if (gameCenterSessionInfo.x() == 0) {
            notifyMessageChange("action_qgame_messgae_change", getFolderSession(gameCenterSessionInfo.m()), 1, unreadCnt4MsgTab);
        } else {
            notifyMessageChange("action_qgame_messgae_change", gameCenterSessionInfo, 1, unreadCnt4MsgTab);
            notifyMessageChange("action_qgame_unread_change", gameCenterSessionInfo, 1, unreadCnt4MsgTab);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[update] oldUnread:" + i3 + ",newUnread:" + z16);
        }
        if (!com.tencent.mobileqq.gamecenter.utils.f.M(appFromWeakRef) || i3 == z16) {
            return;
        }
        ((ITempApi) QRoute.api(ITempApi.class)).refreshAppBadge(appFromWeakRef);
        setUnshowedUnreadCntV2(unreadCnt, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUserInfoChanged(Object obj) {
        WeakReference<ie1.b> next;
        try {
            Iterator<WeakReference<ie1.b>> it = this.mUserInfoChangeObserverList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                next.get().d(obj);
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, th5.getMessage());
        }
    }

    private List<com.tencent.mobileqq.gamecenter.data.n> readPartnerListFromMMKV() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        AppInterface appInterface = this.mApp.get();
        if (appInterface == null) {
            return new ArrayList();
        }
        byte[] bytes = fromV2.getBytes(MMKV_KEY_MSG_PARTNER_LIST + appInterface.getCurrentAccountUin(), null);
        if (bytes != null) {
            return com.tencent.mobileqq.gamecenter.utils.f.W(bytes);
        }
        return new ArrayList();
    }

    private void removeListeners() {
        this.msgNtApi.removeMsgListener(this.mMsgListener);
        this.msgNtApi.onDestroy();
    }

    private void removeObservers() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null) {
            appFromWeakRef.removeObserver(this.mSessionInfoObserver);
            appFromWeakRef.removeObserver(this.mRedPointObserver);
        }
    }

    private void setAllReaded(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setAllReaded] gameId:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = this.mSessionMap.keySet().iterator();
        while (it.hasNext()) {
            GameCenterSessionInfo gameCenterSessionInfo = this.mSessionMap.get(it.next());
            if (gameCenterSessionInfo != null && str.equals(gameCenterSessionInfo.m())) {
                setRead(gameCenterSessionInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNotifyOnUserInfoChanged(int i3, int i16, GameCenterSessionInfo gameCenterSessionInfo) {
        if (i16 > 30) {
            if (i3 == i16 - 1) {
                notifyMessageChange("action_qgame_messgae_change", gameCenterSessionInfo, 3, getUnreadCnt());
            }
        } else {
            if (gameCenterSessionInfo.x() == 0) {
                GameCenterSessionInfo folderSession = getFolderSession(gameCenterSessionInfo.m());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[onGameUserInfoChangedNotify] folder session:" + folderSession);
                }
                if (folderSession != null && folderSession.w().equals(gameCenterSessionInfo.w())) {
                    notifyMessageChange("action_qgame_messgae_change", folderSession, 2, getUnreadCnt());
                    return;
                }
                return;
            }
            notifyMessageChange("action_qgame_messgae_change", gameCenterSessionInfo, 2, getUnreadCnt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryGetGameSwitchFromSvr() {
        if (isGrayOpen() && System.currentTimeMillis() - this.mGameSwitchLastUpdateTime > MiniBoxNoticeInfo.MIN_5) {
            QLog.i(TAG, 1, "[tryGetGameSwitchFromSvr]");
            GameCenterUnissoHandler.N2().getGameSwitch(this.mHashcode);
            this.mGameSwitchLastUpdateTime = System.currentTimeMillis();
        }
    }

    private void updateGameConfigItem(GameBasicInfo gameBasicInfo) {
        if (gameBasicInfo != null && !TextUtils.isEmpty(gameBasicInfo.mAppId)) {
            QLog.i(TAG, 1, "[updateGameConfigItem], appId:" + gameBasicInfo.mAppId);
            this.mGameBasicConfigCache.put(gameBasicInfo.mAppId, gameBasicInfo);
            updateEntity(gameBasicInfo);
        }
    }

    private void updateGameUsrInfoItem(GameUserInfo gameUserInfo) {
        if (gameUserInfo != null && !TextUtils.isEmpty(gameUserInfo.mRoleId)) {
            this.mGameUserInfoMapCache.put(gameUserInfo.mRoleId, gameUserInfo);
            updateEntity(gameUserInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionInfo(GameCenterSessionInfo gameCenterSessionInfo, gd1.a aVar) {
        if (gameCenterSessionInfo != null && aVar != null) {
            gameCenterSessionInfo.g0(aVar.f401938b);
            gameCenterSessionInfo.f0(getFriendShowName(aVar.f401938b));
            gameCenterSessionInfo.c0(aVar.f401941e);
            gameCenterSessionInfo.N(aVar.f401939c);
            gameCenterSessionInfo.e0(aVar.f401946j);
            gameCenterSessionInfo.D(aVar.f401940d);
            gameCenterSessionInfo.V(aVar.f401947k);
            gameCenterSessionInfo.d0(aVar.f401950n);
            gameCenterSessionInfo.M(aVar.f401948l);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void addRecentPartnerListener(IGameMsgManagerService.a aVar) {
        if (aVar != null) {
            this.mPartnerListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void addUserInfoChangedObserver(ie1.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mUserInfoChangeObserverList.add(new WeakReference<>(bVar));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void applyPartner(String str, String str2, com.tencent.mobileqq.gamecenter.api.g gVar) {
        if (gVar == null) {
            return;
        }
        this.mGameMsgPartnerCallback = gVar;
        GameCenterUnissoHandler.N2().z3(gVar.hashCode(), str, str2, "", 1);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void checkGameMsgTabConfigUpdate() {
        ((IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameMsgTabConfig();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void cleanSessionUnread(String str) {
        GameCenterSessionInfo sessionInfoByUin;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[cleanSessionUnread] id:" + str);
        }
        if (TextUtils.isEmpty(str) || this.mApp == null || (sessionInfoByUin = getSessionInfoByUin(str)) == null) {
            return;
        }
        setRead(sessionInfoByUin);
        setUnshowedUnreadCnt(getUnreadCnt());
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameBasicInfo findGameConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        GameBasicInfo gameBasicInfo = this.mGameBasicConfigCache.get(str);
        if (gameBasicInfo != null) {
            return gameBasicInfo;
        }
        Entity find = DBMethodProxy.find(this.mEntityMgr, (Class<? extends Entity>) GameBasicInfo.class, str);
        if (find == null) {
            return null;
        }
        GameBasicInfo gameBasicInfo2 = (GameBasicInfo) find;
        this.mGameBasicConfigCache.put(str, gameBasicInfo2);
        return gameBasicInfo2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameSwitchConfig findGameSwitchConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        GameSwitchConfig gameSwitchConfig = this.mGameSwitchConfigCache.get(str);
        if (gameSwitchConfig != null) {
            return gameSwitchConfig;
        }
        Entity find = DBMethodProxy.find(this.mEntityMgr, (Class<? extends Entity>) GameSwitchConfig.class, str);
        if (find == null) {
            return null;
        }
        GameSwitchConfig gameSwitchConfig2 = (GameSwitchConfig) find;
        this.mGameSwitchConfigCache.put(str, gameSwitchConfig2);
        return gameSwitchConfig2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameSwitchConfig findGameSwitchConfigFromMemoryCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mGameSwitchConfigCache.get(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameUserInfo findGameUserInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        GameUserInfo gameUserInfo = this.mGameUserInfoMapCache.get(str);
        if (gameUserInfo != null) {
            return gameUserInfo;
        }
        Entity find = DBMethodProxy.find(this.mEntityMgr, (Class<? extends Entity>) GameUserInfo.class, str);
        if (find == null) {
            return null;
        }
        GameUserInfo gameUserInfo2 = (GameUserInfo) find;
        this.mGameUserInfoMapCache.put(str, gameUserInfo2);
        return gameUserInfo2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getAIORedDotStyleId() {
        bd1.b bVar = this.mTabConfig;
        if (bVar != null && bVar.b() != null && this.mTabConfig.b().get("grayPolicyId") != null) {
            return this.mTabConfig.b().get("grayPolicyId");
        }
        return "";
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getBoxMsgSwitchId() {
        bd1.b bVar = this.mTabConfig;
        if (bVar != null && bVar.c() != null && this.mTabConfig.c().get("grayPolicyId") != null) {
            return this.mTabConfig.c().get("grayPolicyId");
        }
        return "";
    }

    public String getFriendShowName(String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return str;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        if (friendsSimpleInfoWithUid != null) {
            return friendsSimpleInfoWithUid.m();
        }
        return str;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public Bundle getGameCenterRequestInfo(AppInterface appInterface, String str) {
        Bundle bundle = new Bundle();
        try {
            List<GameCenterSessionInfo> sessionInfoList = ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoList(3, str);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            if (sessionInfoList != null && sessionInfoList.size() > 0) {
                Iterator<GameCenterSessionInfo> it = sessionInfoList.iterator();
                while (it.hasNext()) {
                    JSONObject o16 = it.next().o();
                    if (o16 != null) {
                        jSONArray.mo162put(o16);
                    }
                }
            }
            jSONObject.put(SessionDbHelper.SESSION_ID, jSONArray);
            bundle.putInt("result", 0);
            bundle.putString("data", jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[handleMessage] data:" + jSONObject);
            }
        } catch (Throwable th5) {
            bundle.putInt("result", -1);
            QLog.e(TAG, 1, "getGameCenterRequestInfo e:" + th5);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public Bundle getGameCenterSessionInfo(AppInterface appInterface, int i3, String str) {
        Bundle bundle = new Bundle();
        List<GameCenterSessionInfo> sessionInfoList = ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoList(i3, str);
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            if (sessionInfoList != null && sessionInfoList.size() > 0) {
                Iterator<GameCenterSessionInfo> it = sessionInfoList.iterator();
                while (it.hasNext()) {
                    JSONObject o16 = it.next().o();
                    if (o16 != null) {
                        jSONArray.mo162put(o16);
                    }
                }
            }
            jSONObject.put(SessionDbHelper.SESSION_ID, jSONArray);
            bundle.putInt("result", 0);
            bundle.putString("data", jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[handleMessage] data:" + jSONObject.toString());
            }
        } catch (Throwable th5) {
            bundle.putInt("result", -1);
            QLog.e(TAG, 1, "getGameCenterSessionInfo e:" + th5);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public Bundle getGameCenterUnreadTotal() {
        String str;
        int unreadCnt4MsgTab = getUnreadCnt4MsgTab();
        HashMap<String, Integer> unreadForEachGame = getUnreadForEachGame();
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        bundle.putInt("cnt", unreadCnt4MsgTab);
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : unreadForEachGame.keySet()) {
                jSONObject.put(str2, unreadForEachGame.get(str2));
            }
            str = jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("singleUnread", str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[getGameCenterUnreadTotalNt] cmd:,data:" + bundle);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public HashMap<String, gd1.a> getGameDetailInfo(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            HashMap<String, gd1.a> hashMap = new HashMap<>();
            Iterator<String> it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                String next = it.next();
                GameUserInfo findGameUserInfo = findGameUserInfo(next);
                if (findGameUserInfo != null) {
                    GameBasicInfo findGameConfig = findGameConfig(findGameUserInfo.mAppId);
                    if (findGameConfig == null) {
                        QLog.w(TAG, 1, "basicinfo is null, appid:" + findGameUserInfo.mAppId);
                    } else {
                        hashMap.put(next, gd1.a.b(findGameConfig, findGameUserInfo));
                    }
                }
                z16 = true;
            }
            pullGameUsrInfoFromServer(z16, arrayList);
            return hashMap;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public HashMap<String, gd1.a> getGameDetailInfoV2(ArrayList<String> arrayList) {
        GameBasicInfo findGameConfig;
        if (arrayList != null && arrayList.size() != 0) {
            HashMap<String, gd1.a> hashMap = new HashMap<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                GameUserInfo findGameUserInfo = findGameUserInfo(next);
                if (findGameUserInfo != null && (findGameConfig = findGameConfig(findGameUserInfo.mAppId)) != null) {
                    hashMap.put(next, gd1.a.b(findGameConfig, findGameUserInfo));
                }
            }
            return hashMap;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getGameMsgListUrl() {
        bd1.a msgConfigBean = getMsgConfigBean();
        if (!TextUtils.isEmpty(msgConfigBean.mGameMsgListUrl)) {
            return msgConfigBean.mGameMsgListUrl;
        }
        return IGameMsgHelperApi.SESSION_URL;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getGameMsgSettingUrl() {
        bd1.a msgConfigBean = getMsgConfigBean();
        if (!TextUtils.isEmpty(msgConfigBean.mGameMsgSettingUrl)) {
            return msgConfigBean.mGameMsgSettingUrl;
        }
        return IGameMsgHelperApi.SESSION_SETTING_URL;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getGamePrefix() {
        bd1.a msgConfigBean = getMsgConfigBean();
        if (!TextUtils.isEmpty(msgConfigBean.mPrefix)) {
            return msgConfigBean.mPrefix;
        }
        return IGameMsgHelperApi.PREFIX;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean getHasUnreadMsg() {
        return this.mIsHasUnreadMsg;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameCenterSessionInfo getLastSessionInfo() {
        if (this.mSessionMap.size() == 0) {
            getSessionInfoList();
        }
        return getLastSessionInfoFromMap();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    @WorkerThread
    public GameCenterSessionInfo getLastSessionInfoExceptDelSession() {
        if (this.mSessionMap.size() == 0) {
            getSessionInfoList();
        }
        ArrayList arrayList = new ArrayList(this.mFolderMap.values());
        ArrayList arrayList2 = new ArrayList(this.mNormalMap.values());
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        GameCenterSessionInfo lastestSession = getLastestSession(arrayList);
        GameCenterSessionInfo lastestSession2 = getLastestSession(arrayList2);
        if (lastestSession != null && lastestSession2 != null) {
            if (lastestSession.q() > lastestSession2.q()) {
                return lastestSession;
            }
            return lastestSession2;
        }
        if (lastestSession == null) {
            return lastestSession2;
        }
        return lastestSession;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public JSONObject getMetaDreamSayHiConfig() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_META_DREAM_MSG_GREETING_CONFIG).optJSONObject("default");
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean getMsgShowOnList() {
        return this.mMsgShowedOnList;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean getNeedPopMsgView() {
        return this.mNeedPopMsgView;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getPlayerInfoUrl() {
        return getMsgConfigBean().mPlayerInfoUrl;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public JSONObject getQuickReplyConfig() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_MSG_QUICK_REPLY_CONFIG);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public List<com.tencent.mobileqq.gamecenter.data.n> getRecentPartnerList() {
        if (this.mPartnerList == null) {
            this.mPartnerList = readPartnerListFromMMKV();
            GameCenterUnissoHandler.N2().u3();
        }
        return this.mPartnerList;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getRedDotConfig(String str) {
        String str2 = this.mRoleIdRedDotMap.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void getRemoteGameSessionList(com.tencent.mobileqq.gamecenter.api.j jVar) {
        this.mRemoteListCallback = jVar;
        GameCenterUnissoHandler.N2().R2();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public long getReqMsgCnt() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return 0L;
        }
        long H = com.tencent.mobileqq.gamecenter.utils.f.H(appFromWeakRef.getCurrentAccountUin(), SP_KEY_REQ_MSG_R_VALUE);
        long H2 = com.tencent.mobileqq.gamecenter.utils.f.H(appFromWeakRef.getCurrentAccountUin(), SP_KEY_REQ_MSG_READ_TIME);
        if (!com.tencent.mobileqq.gamecenter.utils.f.P(H) || com.tencent.mobileqq.gamecenter.utils.f.P(H2) || this.mFolderMap.size() <= 0) {
            return 0L;
        }
        return 1L;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public JSONObject getSayHiDefaultConfig() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_MSG_GREETING_CONFIG).optJSONObject("default");
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public com.tencent.mobileqq.gamecenter.data.j getSessionDelDataHelper() {
        return this.mSessionDelDataHelper;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameCenterSessionInfo getSessionInfoByRoleId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mSessionMap.size() == 0) {
            getSessionInfoList();
        }
        return getSessionInfoByRoleIdFromCache(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameCenterSessionInfo getSessionInfoByUin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mSessionMap.size() == 0) {
            getSessionInfoList();
        }
        return this.mSessionMap.get(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public GameCenterSessionInfo getSessionInfoByUinV2(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mSessionMap.get(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public List<GameCenterSessionInfo> getSessionInfoList() {
        return getSessionInfoList(0, "");
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean getShowReqMsgUnread() {
        return this.mShowReqMsgUnread;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public gd1.a getSingleGameDetail(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        GameUserInfo findGameUserInfo = findGameUserInfo(str);
        ArrayList<String> arrayList = new ArrayList<>();
        if (findGameUserInfo == null) {
            arrayList.add(str);
            pullGameUsrInfoFromServer(true, arrayList);
            return null;
        }
        GameBasicInfo findGameConfig = findGameConfig(findGameUserInfo.mAppId);
        if (findGameConfig == null) {
            arrayList.add(str);
            pullGameUsrInfoFromServer(true, arrayList);
            return null;
        }
        arrayList.add(str);
        pullGameUsrInfoFromServer(false, arrayList);
        return gd1.a.b(findGameConfig, findGameUserInfo);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public gd1.a getSingleGameDetailV2(String str) {
        GameUserInfo findGameUserInfo;
        GameBasicInfo findGameConfig;
        if (TextUtils.isEmpty(str) || (findGameUserInfo = findGameUserInfo(str)) == null || (findGameConfig = findGameConfig(findGameUserInfo.mAppId)) == null) {
            return null;
        }
        return gd1.a.b(findGameConfig, findGameUserInfo);
    }

    @Deprecated
    public List<ConversationInfo> getTinyConvInfoList() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return new ArrayList();
        }
        return gd1.b.b().c(appFromWeakRef);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public int getUnreadCnt() {
        return getUnreadCnt(true);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public int getUnreadCnt4MsgTab() {
        if (this.mNormalMap.size() == 0) {
            getSessionInfoList();
        }
        return calculateUnreadCnt4MsgTab();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public HashMap<String, Integer> getUnreadForEachGame() {
        int i3;
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<GameCenterSessionInfo> sessionInfoList = getSessionInfoList(0, IGameMsgManagerService.GAMEID_GET_UNREAD_NUM);
        if (sessionInfoList != null && !sessionInfoList.isEmpty()) {
            for (GameCenterSessionInfo gameCenterSessionInfo : sessionInfoList) {
                if (gameCenterSessionInfo != null) {
                    String m3 = gameCenterSessionInfo.m();
                    if (isGameMsgSync(m3)) {
                        i3 = gameCenterSessionInfo.z();
                    } else {
                        i3 = 0;
                    }
                    Integer num = hashMap.get(m3);
                    if (num == null) {
                        hashMap.put(m3, Integer.valueOf(i3));
                    } else {
                        hashMap.put(m3, Integer.valueOf(num.intValue() + i3));
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public String getUnreadStr4EachGame() {
        HashMap<String, Integer> unreadForEachGame = getUnreadForEachGame();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : unreadForEachGame.keySet()) {
                jSONObject.put(str, unreadForEachGame.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public int getUnshowedUnreadCnt() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null || !com.tencent.mobileqq.gamecenter.utils.f.M(appFromWeakRef) || !isGrayOpen() || ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).isBelongServiceAccountFolderInner("2747277822")) {
            return 0;
        }
        return this.mUnshowedUnreadCnt;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public int getViewType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean gotoPlayerInfoPage(AppRuntime appRuntime, Context context, String str, String str2) {
        String str3;
        if ("1112198072".equals(str)) {
            return com.tencent.mobileqq.gamecenter.qa.util.l.f212717a.b(context, str2);
        }
        try {
            String playerInfoUrl = getPlayerInfoUrl();
            if (!TextUtils.isEmpty(playerInfoUrl) && context != null && !TextUtils.isEmpty(str2)) {
                if (playerInfoUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str3 = playerInfoUrl + "&roleId=" + URLEncoder.encode(str2, "utf-8");
                } else {
                    str3 = playerInfoUrl + "?roleId=" + URLEncoder.encode(str2, "utf-8");
                }
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str3);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isGameMsgBlocked(String str) {
        GameSwitchConfig findGameSwitchConfig = findGameSwitchConfig(str);
        if (findGameSwitchConfig == null) {
            QLog.i(TAG, 1, "[isGameMsgBlocked] gameId:" + str + ", config is null,return false");
            return false;
        }
        if (findGameSwitchConfig.mBlockSwitch == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isGameMsgShowInBoxFormTabConfig() {
        bd1.b bVar = this.mTabConfig;
        if (bVar != null && bVar.c() != null && "1".equals(this.mTabConfig.c().get("style"))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isGameMsgSync(String str) {
        GameSwitchConfig findGameSwitchConfig = findGameSwitchConfig(str);
        if (findGameSwitchConfig == null || findGameSwitchConfig.mSyncSwitch != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isGrayOpen() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMEPLAT_MSG_FUNC_SWITCH, true);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isInited() {
        return this.mInited;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isJumpGameProfileCard() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMEPLAT_WANGZHEPROFILE_JUMP_SWITCH);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public boolean isShowInMsgBox() {
        if (this.mApp == null) {
            return false;
        }
        return ((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab();
    }

    protected boolean limitUpdateUserInfoRepeatedly(ArrayList<String> arrayList) {
        long longValue;
        if (this.mRequestGameUserInfoRecord == null || arrayList == null) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = this.mRequestGameUserInfoRecord.get(next);
            if (l3 == null) {
                longValue = 0;
            } else {
                longValue = l3.longValue();
            }
            if (this.mRequestGameUserInfoRecord.containsKey(next) && currentTimeMillis - longValue < 100) {
                it.remove();
            }
            this.mRequestGameUserInfoRecord.put(next, Long.valueOf(currentTimeMillis));
        }
        if (arrayList.size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void notifyGameMsgSayHiInfo(int i3, long j3, String str, GameMsgGreeting$QueryAIOGreetInfoRsp gameMsgGreeting$QueryAIOGreetInfoRsp) {
        if (this.mGameMsgSayHiCallback != null && this.mGameMsgSayHiCallback.hashCode() == i3) {
            this.mGameMsgSayHiCallback.a(j3, str, gameMsgGreeting$QueryAIOGreetInfoRsp);
        }
    }

    public void notifyMsgBox(String str, int i3) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        Intent intent = new Intent("action_qgame_toggle_change");
        intent.setPackage(appFromWeakRef.getApplication().getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("key_msg_change_game_id", str);
        bundle.putInt("key_msg_change_type_id", i3);
        GameBasicInfo findGameConfig = findGameConfig(str);
        if (findGameConfig != null) {
            bundle.putString("key_msg_change_game_name", findGameConfig.mName);
        }
        intent.putExtras(bundle);
        appFromWeakRef.getApplication().sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void notifyReceiveGameMsgSayHiMessage(String str, String str2) {
        if (this.mGameMsgSayHiCallback != null) {
            this.mGameMsgSayHiCallback.b(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void notifyRemoteUserReady(int i3, ArrayList<com.tencent.mobileqq.gamecenter.data.f> arrayList) {
        QLog.i(TAG, 1, "[notifyRemoteUserReady], retCode:" + i3);
        com.tencent.mobileqq.gamecenter.api.j jVar = this.mRemoteListCallback;
        if (jVar != null) {
            jVar.a(i3, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void notifySessionChangedBySwitch() {
        notifyMessageChange("action_qgame_messgae_change", null, 3, getUnreadCnt());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(final AppRuntime appRuntime) {
        QLog.i(TAG, 1, "[onCreate] " + this);
        if (!initApp(appRuntime)) {
            return;
        }
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            QLog.e(TAG, 1, "app is null");
            return;
        }
        this.mIsDestroy.set(false);
        this.mHashcode = hashCode();
        EntityManager createEntityManager = appFromWeakRef.getEntityManagerFactory().createEntityManager();
        this.mEntityMgr = createEntityManager;
        this.mSessionDelDataHelper = new GameDelSessionDataHelper(createEntityManager);
        ThreadManagerV2.excute(this.mInitTask, 32, null, true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.af
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgManagerServiceImpl.this.lambda$onCreate$1(appRuntime);
            }
        }, 32, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "[onDestroy] mMsgListener:" + this.mMsgListener);
        removeObservers();
        removeListeners();
        removeGameMsgSayHiCallback();
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.d.f().c();
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b.j().c();
        com.tencent.mobileqq.activity.recent.gamemsgbox.manager.c.e().c();
        this.mInited = false;
        this.mIsDestroy.set(true);
        this.mPartnerList = null;
        this.mPartnerListeners.clear();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void onGameMsgRRecv(int i3) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        setPubAccRedSwitch(i3);
        if (i3 == 1) {
            com.tencent.mobileqq.gamecenter.utils.f.p0(appFromWeakRef, SP_KEY_REQ_MSG_R_VALUE, System.currentTimeMillis());
            com.tencent.mobileqq.gamecenter.utils.f.p0(appFromWeakRef, SP_KEY_REQ_MSG_READ_TIME, 0L);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void onGameSwitchChange(String str, int i3, int i16) {
        QLog.i(TAG, 1, "[onGameSwitchChange] gameId:" + str + ",switchType:" + i3 + ",value:" + i16);
        GameSwitchConfig findGameSwitchConfig = findGameSwitchConfig(str);
        if (findGameSwitchConfig == null) {
            findGameSwitchConfig = new GameSwitchConfig();
            findGameSwitchConfig.mAppId = str;
        }
        if (i3 == 0) {
            handleSwitchType0(findGameSwitchConfig, str, i16);
        } else if (i3 == 1) {
            handleSwitchType1(findGameSwitchConfig, str, i16);
        } else if (i3 == 2) {
            handleSwitchType2(findGameSwitchConfig, str, i16);
        }
        handleMsgBoxNtCase(findGameSwitchConfig, i3, i16);
        handleMsgBoxCase(i3, str, i16);
    }

    /* renamed from: onMsgReceive, reason: merged with bridge method [inline-methods] */
    public void lambda$handleOnMsgReceive$3(@NonNull MsgRecord msgRecord) {
        if (!isGrayOpen()) {
            return;
        }
        tryGetGameSwitchFromSvr();
        String peerUid = msgRecord.getPeerUid();
        RecentContactInfo gameRecentContact = this.msgNtApi.getGameRecentContact(peerUid);
        if (gameRecentContact == null) {
            QLog.e(TAG, 1, "[onMsgReceive] recentContactInfo is null");
            return;
        }
        TempChatGameSession gameSessionFromContact = this.msgNtApi.getGameSessionFromContact(gameRecentContact);
        if (gameSessionFromContact == null) {
            QLog.e(TAG, 1, "[onMsgReceive] gameSession is null");
            return;
        }
        handleRedPointSwitch(gameSessionFromContact);
        String createConvertUinFromTinyId = this.msgNtApi.createConvertUinFromTinyId(gameSessionFromContact.getSelfTinyId(), gameSessionFromContact.getPeerTinyId());
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(createConvertUinFromTinyId, peerUid);
        long unreadCnt = gameRecentContact.getUnreadCnt();
        QLog.i(TAG, 2, "[onMsgReceive] isMainTread:,unreadCnt:" + unreadCnt + ",sessionId:" + createConvertUinFromTinyId + ",peerUid:" + peerUid + ",msgTime:" + msgRecord.getMsgTime());
        GameDelSessionDataHelper gameDelSessionDataHelper = this.mSessionDelDataHelper;
        if (gameDelSessionDataHelper != null && unreadCnt > 0) {
            GameDelSessionDataHelper.j(createConvertUinFromTinyId, gameDelSessionDataHelper);
        }
        handleSessionInfo(msgRecord, gameRecentContact, (int) unreadCnt, getSessionInfoByUin(createConvertUinFromTinyId));
        if (gameSessionFromContact.getSayHiType().intValue() > 0) {
            notifyReceiveGameMsgSayHiMessage(gameSessionFromContact.getPeerRoleId(), gameSessionFromContact.getSelfRoleId());
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void onReceiveGamePartnerChangePush() {
        GameCenterUnissoHandler.N2().u3();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void onSendApplyPartnerMessage(int i3, int i16, long j3, String str) {
        com.tencent.mobileqq.gamecenter.api.g gVar = this.mGameMsgPartnerCallback;
        if (gVar != null && gVar.hashCode() == i3) {
            if (i16 != 0) {
                if (i16 == 1) {
                    gVar.b(j3, str);
                    return;
                }
                return;
            }
            gVar.a(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public Bundle openGameCenterAIO(AppInterface appInterface, String str) {
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        Context applicationContext = appInterface.getApp().getApplicationContext();
        GameCenterSessionInfo sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(str);
        Bundle bundle = new Bundle();
        if (sessionInfoByUin == null) {
            bundle.putInt("result", -1);
        } else {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(applicationContext, str, sessionInfoByUin.v(), sessionInfoByUin.r(), 1);
            bundle.putInt("result", 0);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[openGameCenterAIO] ,data:" + bundle);
        }
        return bundle;
    }

    protected void pullGameUsrInfoFromServer(final boolean z16, final ArrayList<String> arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z17 = true;
                if (GameMsgManagerServiceImpl.this.mApp == null) {
                    QLog.w(GameMsgManagerServiceImpl.TAG, 1, "app is null");
                    return;
                }
                if (!z16) {
                    ArrayList checkUsrInfoUpdateList = GameMsgManagerServiceImpl.this.checkUsrInfoUpdateList(arrayList);
                    if (checkUsrInfoUpdateList == null || checkUsrInfoUpdateList.size() <= 0) {
                        z17 = false;
                    }
                    if (z17) {
                        GameMsgManagerServiceImpl.this.handleRequestGameUserInfo(checkUsrInfoUpdateList);
                        return;
                    }
                    return;
                }
                QLog.i(GameMsgManagerServiceImpl.TAG, 1, "force to request user info from svr.");
                GameMsgManagerServiceImpl.this.handleRequestGameUserInfo(arrayList);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void pushMsgForH5(String str) {
        if (!this.mPushMsgForH5) {
            QLog.i(TAG, 1, "[pushMsgForH5] pushMsgForH5:" + this.mPushMsgForH5);
            return;
        }
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null) {
            Intent intent = new Intent(IGameMsgManagerService.ACTION_GAME_CENTER_PUSH);
            intent.setPackage(appFromWeakRef.getApplication().getPackageName());
            Bundle bundle = new Bundle();
            bundle.putString("key_push_msg", str);
            intent.putExtras(bundle);
            appFromWeakRef.getApplication().sendBroadcast(intent);
            QLog.i(TAG, 1, "[pushMsgForH5] msg:" + str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void removeGameMsgPartnerCallback() {
        QLog.i(TAG, 1, "[removeGameMsgPartnerCallback]");
        this.mGameMsgPartnerCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void removeGameMsgSayHiCallback() {
        QLog.i(TAG, 1, "[removeGameMsgSayHiCallback]");
        this.mGameMsgSayHiCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void removeRecentPartnerListener(IGameMsgManagerService.a aVar) {
        if (aVar != null && this.mPartnerListeners.contains(aVar)) {
            this.mPartnerListeners.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void removeUserInfoChangedObserver(ie1.b bVar) {
        WeakReference<ie1.b> next;
        if (bVar == null) {
            return;
        }
        try {
            Iterator<WeakReference<ie1.b>> it = this.mUserInfoChangeObserverList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (next.get() == bVar) {
                    this.mUserInfoChangeObserverList.remove(next);
                    return;
                }
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void reqGameMsgSayHiInfo(String str, String str2, com.tencent.mobileqq.gamecenter.api.h hVar) {
        if (hVar == null) {
            return;
        }
        this.mGameMsgSayHiCallback = hVar;
        GameCenterUnissoHandler.N2().r3(hVar.hashCode(), str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void saveOrUpdateGameBasicConfigs(ArrayList<GameBasicInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<GameBasicInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                GameBasicInfo next = it.next();
                if (next != null) {
                    GameBasicInfo gameBasicInfo = this.mGameBasicConfigCache.get(next.mAppId);
                    if (gameBasicInfo == null) {
                        next.setStatus(1000);
                        updateGameConfigItem(next);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 1, "[saveOrUpdateGameBasicConfigs], oldname:" + gameBasicInfo.mName + ", newName:" + next.mName + ", old:" + gameBasicInfo.mUpdateTs + ",new:" + next.mUpdateTs);
                        }
                        if (gameBasicInfo.mUpdateTs != next.mUpdateTs) {
                            updateGameConfigItem(next);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void saveOrUpdateGameSwitchConfigs(ArrayList<GameSwitchConfig> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<GameSwitchConfig> it = arrayList.iterator();
            while (it.hasNext()) {
                GameSwitchConfig next = it.next();
                if (next != null) {
                    this.mGameSwitchConfigCache.put(next.mAppId, next);
                    updateEntity(next);
                    com.tencent.mobileqq.activity.recent.gamemsgbox.manager.c.e().d(next.mAppId, next);
                }
            }
            com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b.j().s();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void saveOrUpdateGameUsrInfoArrays(ArrayList<GameUserInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<GameUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                GameUserInfo next = it.next();
                if (next != null) {
                    GameUserInfo gameUserInfo = this.mGameUserInfoMapCache.get(next.mRoleId);
                    if (gameUserInfo == null) {
                        next.setStatus(1000);
                        updateGameUsrInfoItem(next);
                    } else if (next.mUpdateTs != gameUserInfo.mUpdateTs) {
                        updateGameUsrInfoItem(next);
                    }
                    com.tencent.mobileqq.activity.recent.gamemsgbox.manager.d.f().h(next);
                }
            }
        }
    }

    public void saveOrUpdateTabConfigs(String str) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (!TextUtils.isEmpty(str) && appFromWeakRef != null) {
            this.mTabConfig = bd1.b.d(str);
            bd1.b.g(appFromWeakRef, str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void sendApplyPartnerMessage(String str, String str2, String str3, com.tencent.mobileqq.gamecenter.api.g gVar) {
        if (gVar == null) {
            return;
        }
        this.mGameMsgPartnerCallback = gVar;
        GameCenterUnissoHandler.N2().z3(gVar.hashCode(), str, str2, str3, 0);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setH5PushMsgState(boolean z16) {
        this.mPushMsgForH5 = z16;
        QLog.i(TAG, 1, "[setH5PushMsgState] state:" + z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setMsgShowOnList(boolean z16) {
        this.mMsgShowedOnList = z16;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setNeedPopMsgView(boolean z16) {
        this.mNeedPopMsgView = z16;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setPubAccRedSwitch(int i3) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef != null && i3 != this.mPubMsgRedPointSwitch) {
            appFromWeakRef.getApplication().getSharedPreferences("game_center_sp", 0).edit().putInt(SP_KEY_PUBACC_MSG_REDPOINT, i3).commit();
            this.mPubMsgRedPointSwitch = i3;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setRead(GameCenterSessionInfo gameCenterSessionInfo) {
        String w3 = gameCenterSessionInfo.w();
        this.msgNtApi.setMsgRead(gameCenterSessionInfo.t(), 105);
        gameCenterSessionInfo.m0(0);
        GameCenterSessionInfo gameCenterSessionInfo2 = this.mNormalMap.get(w3);
        if (gameCenterSessionInfo2 != null) {
            gameCenterSessionInfo2.m0(0);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setRecentPartnerList(List<com.tencent.mobileqq.gamecenter.data.n> list) {
        if (list == null) {
            this.mPartnerList = new ArrayList();
        } else {
            this.mPartnerList = list;
        }
    }

    protected void setReqMsgRead() {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        com.tencent.mobileqq.gamecenter.utils.f.p0(appFromWeakRef, SP_KEY_REQ_MSG_R_VALUE, 0L);
        com.tencent.mobileqq.gamecenter.utils.f.p0(appFromWeakRef, SP_KEY_REQ_MSG_READ_TIME, System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setShowReqMsgUnread(boolean z16) {
        this.mShowReqMsgUnread = z16;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setUnshowedUnreadCnt(int i3) {
        setUnshowedUnreadCntV2(i3, true);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void setUnshowedUnreadCntV2(int i3, boolean z16) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return;
        }
        if (isShowInMsgBox() && this.mUnshowedUnreadCnt == 0 && isLastMessageInGameBox(i3)) {
            this.mIsHasUnreadMsg = false;
            return;
        }
        if (this.msgNtApi.getRecentContactInfo(103, "u_-PBswiplK-7J7bmaQLA-mA") == null && i3 != 0) {
            QLog.i(TAG, 1, "[setUnshowedUnreadCntV2] cnt:" + i3);
            return;
        }
        this.mUnshowedUnreadCnt = i3;
        appFromWeakRef.getApplication().getSharedPreferences("game_center_sp", 0).edit().putInt(SP_KEY_ENTER_PUB + appFromWeakRef.getCurrentAccountUin(), this.mUnshowedUnreadCnt).apply();
        if (z16 && i3 == 0) {
            setReqMsgRead();
            this.mIsHasUnreadMsg = false;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public PopupWindow showGameAIOStatusPopupWindow(gd1.a aVar, Activity activity, Bundle bundle, View.OnClickListener onClickListener) {
        AppInterface appFromWeakRef = getAppFromWeakRef();
        if (appFromWeakRef == null) {
            return null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
        com.tencent.mobileqq.gamecenter.ui.l e16 = com.tencent.mobileqq.gamecenter.ui.l.e(appFromWeakRef, activity, aVar, bundle, onClickListener);
        e16.setAnimationStyle(R.style.a3z);
        e16.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
        e16.n();
        return e16;
    }

    protected boolean updateEntity(Entity entity) {
        if (this.mEntityMgr.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.mEntityMgr.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.mEntityMgr.update(entity);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void updateRecentPartnerList(List<com.tencent.mobileqq.gamecenter.data.n> list) {
        setRecentPartnerList(list);
        Iterator<IGameMsgManagerService.a> it = this.mPartnerListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this.mPartnerList);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void updateRedDotConfig(String str, String str2) {
        this.mRoleIdRedDotMap.put(str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public List<GameCenterSessionInfo> getSessionInfoList(int i3, String str) {
        if (this.mSessionMap.size() == 0) {
            Iterator<RecentContactInfo> it = this.msgNtApi.getGameRecentContactList().iterator();
            while (it.hasNext()) {
                GameCenterSessionInfo gameSessionInfo = this.msgNtApi.getGameSessionInfo(it.next());
                if (gameSessionInfo != null) {
                    this.mSessionMap.put(gameSessionInfo.w(), gameSessionInfo);
                }
            }
        }
        if (this.mSessionMap.size() == 0) {
            return null;
        }
        return getGameCenterSessionInfos(i3, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public int getUnreadCnt(boolean z16) {
        if (this.mNormalMap.size() == 0) {
            getSessionInfoList();
        }
        return calculateUnreadCnt(z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
    public void findGameSwitchConfig(final String str, final uc1.b<GameSwitchConfig> bVar) {
        GameSwitchConfig findGameSwitchConfigFromMemoryCache = findGameSwitchConfigFromMemoryCache(str);
        if (findGameSwitchConfigFromMemoryCache != null) {
            bVar.a(findGameSwitchConfigFromMemoryCache);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Entity find = DBMethodProxy.find(GameMsgManagerServiceImpl.this.mEntityMgr, (Class<? extends Entity>) GameSwitchConfig.class, str);
                    if (find != null) {
                        GameSwitchConfig gameSwitchConfig = (GameSwitchConfig) find;
                        GameMsgManagerServiceImpl.this.mGameSwitchConfigCache.put(str, gameSwitchConfig);
                        bVar.a(gameSwitchConfig);
                        return;
                    }
                    bVar.a(null);
                }
            }, 32, null, false);
        }
    }

    private void notifyMessageChange(String str, GameCenterSessionInfo gameCenterSessionInfo, int i3, int i16) {
        try {
            AppInterface appFromWeakRef = getAppFromWeakRef();
            if (appFromWeakRef == null) {
                return;
            }
            Intent intent = new Intent(str);
            intent.setPackage(appFromWeakRef.getApplication().getPackageName());
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_game_msg", gameCenterSessionInfo);
            bundle.putInt("key_msg_change_type", i3);
            bundle.putInt("key_msg_unread_cnt", i16);
            if ("action_qgame_unread_change".equals(str)) {
                bundle.putString("key_msg_single_unread_cnt", getUnreadStr4EachGame());
            }
            intent.putExtras(bundle);
            appFromWeakRef.getApplication().sendBroadcast(intent);
            QLog.i(TAG, 1, "[notifyMessageChange] action:" + str + ",type:" + i3 + ",cnt:" + i16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }
}
