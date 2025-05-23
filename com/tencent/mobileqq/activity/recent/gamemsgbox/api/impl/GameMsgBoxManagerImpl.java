package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.al;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.ar;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.api.j;
import com.tencent.mobileqq.gamecenter.data.f;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.GameMsgBoxConfig;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstractElementData;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxManagerImpl implements IGameMsgBoxManager {
    static IPatchRedirector $redirector_ = null;
    private static final int FETCH_INTERVAL_20_MIN_IN_MILL = 1200000;
    private static final int FETCH_INTERVAL_24_HOUR_IN_MILL = 86400000;
    private static final String KING_HONOR_NAME = "\u738b\u8005\u8363\u8000";
    private static final int PARTNER_STATUS_APPLY_RECEIVER = 2;
    private static final int PARTNER_STATUS_APPLY_SENDER = 1;
    private static final int PARTNER_STATUS_PARTNER = 3;
    private static final int PARTNER_STATUS_RAW = 0;
    private static final String TAG = "GameMsgBoxManagerImpl";
    private k71.a fetchListener;
    private final Object gameTabLock;
    private final Object lock;
    private AppInterface mApp;
    private boolean mCanLoadRemoteUserList;
    private EntityManager mEntityMgr;
    private final Map<String, GameBoxRecentUser> mGameRecentUserCache;
    private final ConcurrentHashMap<String, GameSwitchConfig> mNTGameSwitchConfigCache;
    private IGameMsgBoxManager.a mNTGameTabListener;
    private CopyOnWriteArrayList<String> openSyncNTRecentUserList;
    private CopyOnWriteArrayList<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> titles;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGameMsgManagerService f185492a;

        a(IGameMsgManagerService iGameMsgManagerService) {
            this.f185492a = iGameMsgManagerService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxManagerImpl.this, (Object) iGameMsgManagerService);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.api.j
        public void a(int i3, ArrayList<f> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                return;
            }
            if (GameMsgBoxManagerImpl.this.mApp == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(GameMsgBoxManagerImpl.TAG, 2, "onGetRemoteUserList\uff1a mApp is null");
                    return;
                }
                return;
            }
            if (i3 == 0 && arrayList != null && !arrayList.isEmpty()) {
                GameMsgBoxManagerImpl gameMsgBoxManagerImpl = GameMsgBoxManagerImpl.this;
                gameMsgBoxManagerImpl.upsertRemoteRecentUserToNT(gameMsgBoxManagerImpl.mApp, arrayList);
                ((IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameSwitch(0);
                ArrayList<GameBoxRecentUser> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(GameMsgBoxManagerImpl.TAG, 2, "item is null.");
                        }
                    } else {
                        arrayList3.add(next.f212014c);
                        String f16 = ((IMessageFacade) GameMsgBoxManagerImpl.this.mApp.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().f(next.f212016e, next.f212015d);
                        if (!StringUtil.isValideUin(f16)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(GameMsgBoxManagerImpl.TAG, 2, "illegal uin. ");
                            }
                        } else {
                            arrayList2.add(new GameBoxRecentUser(f16, next));
                        }
                    }
                }
                if (!arrayList3.isEmpty()) {
                    this.f185492a.getGameDetailInfo(arrayList3);
                    if (QLog.isColorLevel()) {
                        QLog.d(GameMsgBoxManagerImpl.TAG, 2, "onGetRemoteUserList getGameDetailInfo from roleId");
                    }
                }
                GameMsgBoxManagerImpl.this.saveOrUpdateGameRecentUserInfoArrays(arrayList2);
            } else if (QLog.isColorLevel()) {
                QLog.e(GameMsgBoxManagerImpl.TAG, 2, "game sync close. retCode: " + i3);
            }
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(GameMsgBoxManagerImpl.TAG, 2, "update contacts config.");
                }
                if (GameMsgBoxManagerImpl.this.fetchListener != null) {
                    GameMsgBoxManagerImpl.this.fetchListener.onLoadSuccess();
                }
                p.g(GameMsgBoxManagerImpl.this.mApp.getApp(), GameMsgBoxManagerImpl.this.mApp.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_GAME_MSG_BOX_LAST_FETCH_TIME, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (GameMsgBoxManagerImpl.this.fetchListener != null) {
                GameMsgBoxManagerImpl.this.fetchListener.onLoadFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxManagerImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i(GameMsgBoxManagerImpl.TAG, 1, "upsertRemoteRecentUserToNT onResult:" + i3 + " ,errMsg:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements IOperateCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxManagerImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i(GameMsgBoxManagerImpl.TAG, 1, "setConfigToNTKernel callback, result=" + i3 + ", errMsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final MMKVOptionEntity f185496a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final d f185497a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20695);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f185497a = new d(null);
                }
            }
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }

        private String a(String str) {
            return "GameMsgBoxMMKV_" + str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }

        public static d b() {
            return a.f185497a;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f185496a.decodeBool(a("gamebox_remote_user_list_upsert_nt_key"), false);
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f185496a.encodeBool(a("gamebox_remote_user_list_upsert_nt_key"), true);
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f185496a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GameMsgBoxManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGameRecentUserCache = new ConcurrentHashMap();
        this.mNTGameSwitchConfigCache = new ConcurrentHashMap<>();
        this.lock = new Object();
        this.openSyncNTRecentUserList = new CopyOnWriteArrayList<>();
        this.titles = new CopyOnWriteArrayList<>();
        this.gameTabLock = new Object();
        this.mCanLoadRemoteUserList = false;
    }

    private ArrayList<MsgAbstractElementData> createAbstractContent(String str) {
        MsgAbstractElementData msgAbstractElementData = new MsgAbstractElementData(1, str, "", 0, 0);
        ArrayList<MsgAbstractElementData> arrayList = new ArrayList<>();
        arrayList.add(msgAbstractElementData);
        return arrayList;
    }

    private ArrayList<RecentContactExtAttr> createRecentContactExtAttr(f fVar) {
        long j3;
        long j16;
        long j17 = 0;
        try {
            j3 = Long.parseLong(fVar.f212012a);
            try {
                j16 = Long.parseLong(fVar.f212015d);
            } catch (NumberFormatException e16) {
                e = e16;
                j16 = 0;
            }
        } catch (NumberFormatException e17) {
            e = e17;
            j3 = 0;
            j16 = 0;
        }
        try {
            j17 = Long.parseLong(fVar.f212016e);
        } catch (NumberFormatException e18) {
            e = e18;
            QLog.e(TAG, 1, e.getMessage(), e);
            TempChatGameSession tempChatGameSession = new TempChatGameSession(j3, "", j16, fVar.f212013b, fVar.f212017f, j17, fVar.f212014c, fVar.f212018g, 0, 0, 0, 0);
            ArrayList<RecentContactExtAttr> arrayList = new ArrayList<>();
            arrayList.add(new RecentContactExtAttr(tempChatGameSession, null, null));
            return arrayList;
        }
        TempChatGameSession tempChatGameSession2 = new TempChatGameSession(j3, "", j16, fVar.f212013b, fVar.f212017f, j17, fVar.f212014c, fVar.f212018g, 0, 0, 0, 0);
        ArrayList<RecentContactExtAttr> arrayList2 = new ArrayList<>();
        arrayList2.add(new RecentContactExtAttr(tempChatGameSession2, null, null));
        return arrayList2;
    }

    private static String getConvertUinByPeerUid(String str) {
        String[] split = str.split(PeerUid.BIDIRECTION_TINY_ID_PERFIX);
        if (split.length != 2) {
            return "";
        }
        String[] split2 = split[1].split("_");
        if (split2.length != 2) {
            return "";
        }
        try {
            return ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createConvertUinFromTinyId(Long.parseLong(split2[0]), Long.parseLong(split2[1]));
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16.getMessage(), e16);
            return "";
        }
    }

    private boolean isConfigNTUpdated(GameSwitchConfig gameSwitchConfig) {
        GameSwitchConfig gameSwitchConfig2;
        if (gameSwitchConfig == null || TextUtils.isEmpty(gameSwitchConfig.mAppId)) {
            return false;
        }
        if (!this.mNTGameSwitchConfigCache.containsKey(gameSwitchConfig.mAppId) || (gameSwitchConfig2 = this.mNTGameSwitchConfigCache.get(gameSwitchConfig.mAppId)) == null) {
            return true;
        }
        if (gameSwitchConfig2.mSyncSwitch == gameSwitchConfig.mSyncSwitch && gameSwitchConfig2.mMuteSwitch == gameSwitchConfig.mMuteSwitch && gameSwitchConfig2.mBlockSwitch == gameSwitchConfig.mBlockSwitch) {
            return false;
        }
        return true;
    }

    private void updateGameUsrInfoItem(GameBoxRecentUser gameBoxRecentUser) {
        if (gameBoxRecentUser != null && !TextUtils.isEmpty(gameBoxRecentUser.mConvertUin)) {
            QLog.i(TAG, 1, "[updateGameUsrInfoItem], roleId:" + gameBoxRecentUser.mFromRoleId);
            this.mGameRecentUserCache.put(gameBoxRecentUser.mConvertUin, gameBoxRecentUser);
            updateEntity(gameBoxRecentUser);
        }
    }

    private void updateTabTitle(Set<String> set, gd1.a aVar, GameSwitchConfig gameSwitchConfig) {
        if (!set.contains(aVar.f401939c)) {
            com.tencent.mobileqq.activity.recent.gamemsgbox.data.b bVar = new com.tencent.mobileqq.activity.recent.gamemsgbox.data.b();
            bVar.f185507d = aVar;
            bVar.f185508e = gameSwitchConfig;
            set.add(aVar.f401939c);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "add tab title, " + aVar.toString());
            }
            this.titles.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upsertRemoteRecentUserToNT(AppRuntime appRuntime, ArrayList<f> arrayList) {
        aa recentContactService;
        if (d.b().c() || arrayList.isEmpty() || (recentContactService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService()) == null) {
            return;
        }
        List<RecentContactInfo> M = recentContactService.M(4);
        HashMap hashMap = new HashMap();
        if (M != null) {
            for (RecentContactInfo recentContactInfo : M) {
                hashMap.put(recentContactInfo.getPeerUid(), recentContactInfo);
            }
        }
        Iterator<f> it = arrayList.iterator();
        while (it.hasNext()) {
            f next = it.next();
            String str = PeerUid.BIDIRECTION_TINY_ID_PERFIX + next.f212015d + "_" + next.f212016e;
            if (!hashMap.containsKey(str)) {
                QLog.i(TAG, 1, "upsertRemoteRecentUserToNT appid:" + next.f212012a + " bidtiny:" + next.f212015d);
                recentContactService.upsertRecentContactManually(new RecentContactData(str, 0L, "", 105, 0L, "", "", 2, createAbstractContent(""), next.f212020i, null, null, createRecentContactExtAttr(next)), new b());
            }
        }
        d.b().d();
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void asyncFindGameBoxRecentUserInfo(String str, k71.b<GameBoxRecentUser> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        if (bVar == null) {
            QLog.e(TAG, 1, "asyncFindGameBoxRecentUserInfo listener is null.");
            return;
        }
        GameBoxRecentUser gameBoxRecentUser = this.mGameRecentUserCache.get(str);
        if (gameBoxRecentUser != null) {
            bVar.a(gameBoxRecentUser);
        } else {
            ThreadManagerV2.excute(new Runnable(str, bVar) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f185486d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ k71.b f185487e;

                {
                    this.f185486d = str;
                    this.f185487e = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GameMsgBoxManagerImpl.this, str, bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(GameMsgBoxManagerImpl.this.findGameBoxRecentUserInfo(this.f185486d)) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.4.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ GameBoxRecentUser f185488d;

                            {
                                this.f185488d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass4.this.f185487e.a(this.f185488d);
                                }
                            }
                        });
                    }
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void clearTitles() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        CopyOnWriteArrayList<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> copyOnWriteArrayList = this.titles;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void fetchRecentGameContacts(boolean z16, k71.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar, Integer.valueOf(i3));
        } else {
            this.fetchListener = aVar;
            ThreadManagerV2.excute(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f185484d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f185485e;

                {
                    this.f185484d = z16;
                    this.f185485e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GameMsgBoxManagerImpl.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        GameMsgBoxManagerImpl gameMsgBoxManagerImpl = GameMsgBoxManagerImpl.this;
                        gameMsgBoxManagerImpl.syncLoadRecentGameContacts(this.f185484d, gameMsgBoxManagerImpl.fetchListener, this.f185485e);
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public GameBoxRecentUser findGameBoxRecentUserInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (GameBoxRecentUser) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        GameBoxRecentUser gameBoxRecentUser = this.mGameRecentUserCache.get(str);
        if (gameBoxRecentUser != null) {
            return gameBoxRecentUser;
        }
        Entity find = DBMethodProxy.find(this.mEntityMgr, (Class<? extends Entity>) GameBoxRecentUser.class, str);
        if (find == null) {
            return null;
        }
        GameBoxRecentUser gameBoxRecentUser2 = (GameBoxRecentUser) find;
        this.mGameRecentUserCache.put(str, gameBoxRecentUser2);
        return gameBoxRecentUser2;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public gd1.a findGameDetailInfoByConvertUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (gd1.a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        GameBoxRecentUser findGameBoxRecentUserInfo = findGameBoxRecentUserInfo(str);
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return null;
        }
        if (findGameBoxRecentUserInfo != null) {
            return ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetailV2(findGameBoxRecentUserInfo.mToRoleId);
        }
        GameCenterSessionInfo sessionInfoByUin = ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoByUin(str);
        AppInterface appInterface2 = this.mApp;
        if (appInterface2 == null || sessionInfoByUin == null) {
            return null;
        }
        return ((IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetailV2(sessionInfoByUin.v());
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public gd1.a findGameDetailInfoByConvertUinV2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (gd1.a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        GameBoxRecentUser findGameBoxRecentUserInfo = findGameBoxRecentUserInfo(str);
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return null;
        }
        if (findGameBoxRecentUserInfo != null) {
            return ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetailV2(findGameBoxRecentUserInfo.mToRoleId);
        }
        GameCenterSessionInfo sessionInfoByUinV2 = ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoByUinV2(str);
        AppInterface appInterface2 = this.mApp;
        if (appInterface2 == null || sessionInfoByUinV2 == null) {
            return null;
        }
        return ((IGameMsgManagerService) appInterface2.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetailV2(sessionInfoByUinV2.v());
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public ArrayList<String> getAppidsInGameBox() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ArrayList) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        SharedPreferences gameMsgBoxSp = getGameMsgBoxSp();
        if (!gameMsgBoxSp.contains("size")) {
            return arrayList;
        }
        int i3 = gameMsgBoxSp.getInt("size", 0);
        if (i3 == 0) {
            return arrayList;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(String.valueOf(gameMsgBoxSp.getLong(String.valueOf(i16), 0L)));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public ar getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ar) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return al.f185475a;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public SharedPreferences getGameMsgBoxSp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return BaseApplication.getContext().getSharedPreferences("gameBoxAppid", 0);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public List<String> getNTAllOpenSyncRecentUserList() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        synchronized (this.lock) {
            copyOnWriteArrayList = this.openSyncNTRecentUserList;
        }
        return copyOnWriteArrayList;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    @Nullable
    public List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> getTitles() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        synchronized (this.lock) {
            copyOnWriteArrayList = new CopyOnWriteArrayList(this.titles);
        }
        return copyOnWriteArrayList;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public int getUnreadCount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return 0;
        }
        return ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str, 10007);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public boolean isGameInGameBox(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) baseQQAppInterface, (Object) str)).booleanValue();
    }

    public boolean isInLimitOfTheFrequency(long j3, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        if (i3 == 2) {
            i16 = 1200000;
        } else {
            i16 = 86400000;
        }
        if (System.currentTimeMillis() - j3 < i16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public boolean isShowGameBoxTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return false;
        }
        return ((Boolean) p.b(appInterface.getApp(), this.mApp.getCurrentAccountUin(), AppConstants.Preferences.KEY_GAME_MSG_BOX_TIPS, Boolean.TRUE)).booleanValue();
    }

    protected boolean isShowRedPoint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).booleanValue();
        }
        return ((Boolean) p.b(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_game_msg_box_tab_red_point_config_" + str, Boolean.TRUE)).booleanValue();
    }

    protected void loadRemoteGameSessionList(IGameMsgManagerService iGameMsgManagerService, k71.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iGameMsgManagerService, (Object) aVar);
            return;
        }
        this.fetchListener = aVar;
        if (iGameMsgManagerService == null) {
            return;
        }
        iGameMsgManagerService.getRemoteGameSessionList(new a(iGameMsgManagerService));
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public String obtainConvertUinByPeerUid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        }
        return getConvertUinByPeerUid(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        this.mEntityMgr = appInterface.getEntityManagerFactory().createEntityManager();
    }

    @Override // mqq.app.api.IRuntimeService
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void registerNTGameTabListener(IGameMsgBoxManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        } else {
            this.mNTGameTabListener = aVar;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void resetFetchListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.fetchListener = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void resetNTLoadRemoteUserList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.mCanLoadRemoteUserList = true;
        }
    }

    public void saveOrUpdateGameRecentUserInfoArrays(ArrayList<GameBoxRecentUser> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[saveOrUpdateGameUsrInfoArrays], size:" + arrayList.size());
            }
            Iterator<GameBoxRecentUser> it = arrayList.iterator();
            while (it.hasNext()) {
                GameBoxRecentUser next = it.next();
                if (next != null) {
                    if (this.mGameRecentUserCache.get(next.mConvertUin) == null) {
                        next.setStatus(1000);
                    }
                    updateGameUsrInfoItem(next);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void setConfigToNTKernel(AppRuntime appRuntime, GameSwitchConfig gameSwitchConfig, String str, boolean z16) {
        long j3;
        int i3;
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, appRuntime, gameSwitchConfig, str, Boolean.valueOf(z16));
            return;
        }
        if (gameSwitchConfig == null) {
            return;
        }
        if (!z16 && !isConfigNTUpdated(gameSwitchConfig)) {
            return;
        }
        if (this.mNTGameSwitchConfigCache.containsKey(gameSwitchConfig.mAppId)) {
            this.mNTGameSwitchConfigCache.remove(gameSwitchConfig.mAppId);
        }
        this.mNTGameSwitchConfigCache.put(gameSwitchConfig.mAppId, gameSwitchConfig);
        try {
            j3 = Long.parseLong(gameSwitchConfig.mAppId);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16.getMessage(), e16);
            j3 = 0;
        }
        int i16 = gameSwitchConfig.mSyncSwitch;
        if (i16 == 1 && gameSwitchConfig.mBlockSwitch == 0 && gameSwitchConfig.mMuteSwitch == 1) {
            i3 = 1;
        } else if (i16 == 0 && gameSwitchConfig.mBlockSwitch == 0 && gameSwitchConfig.mMuteSwitch == 0) {
            i3 = 2;
        } else if (gameSwitchConfig.mBlockSwitch == 1) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        GameMsgBoxConfig gameMsgBoxConfig = new GameMsgBoxConfig(j3, str, i3, KING_HONOR_NAME.equals(str) ? 1 : 0);
        if (appRuntime == null || (recentContactService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService()) == null) {
            return;
        }
        ArrayList<GameMsgBoxConfig> arrayList = new ArrayList<>();
        arrayList.add(gameMsgBoxConfig);
        try {
            QLog.i(TAG, 1, "setConfigToNTKernel:" + gameMsgBoxConfig);
            recentContactService.updateGameMsgConfigs(arrayList, new c());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage(), th5);
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.mApp.getRuntimeService(IGameMsgManagerService.class, "");
        ArrayList<GameSwitchConfig> arrayList2 = new ArrayList<>();
        arrayList2.add(gameSwitchConfig);
        iGameMsgManagerService.saveOrUpdateGameSwitchConfigs(arrayList2);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public boolean shouldForbidNotification(AppRuntime appRuntime, RecentContactInfo recentContactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) appRuntime, (Object) recentContactInfo)).booleanValue();
        }
        boolean z16 = false;
        if (appRuntime == null) {
            QLog.e(TAG, 1, "shouldForbidNotification return false, app is null");
            return false;
        }
        TempChatGameSession gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(recentContactInfo.getPeerUid());
        if (gameSessionFromPeerUid == null) {
            QLog.e(TAG, 1, "shouldForbidNotification return false, gameSession is null");
            return false;
        }
        if (TextUtils.isEmpty(gameSessionFromPeerUid.getPeerRoleId())) {
            QLog.e(TAG, 1, "shouldForbidNotification return false, PeerRoleId is empty");
            return false;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(gameSessionFromPeerUid.getPeerRoleId());
        if (singleGameDetail == null) {
            QLog.e(TAG, 1, "shouldForbidNotification return false, gameDetailInfo is null");
            return false;
        }
        GameSwitchConfig findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(singleGameDetail.f401939c);
        if (findGameSwitchConfig == null) {
            return false;
        }
        if (findGameSwitchConfig.mSyncSwitch != 1 || findGameSwitchConfig.mBlockSwitch != 0 || findGameSwitchConfig.mMuteSwitch != 0) {
            z16 = true;
        }
        QLog.i(TAG, 1, "shouldForbidNotification:" + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public boolean shouldShowRedPoint(GameSwitchConfig gameSwitchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) gameSwitchConfig)).booleanValue();
        }
        if (gameSwitchConfig == null || TextUtils.isEmpty(gameSwitchConfig.mAppId) || gameSwitchConfig.mSyncSwitch == 1 || gameSwitchConfig.mBlockSwitch != 0) {
            return false;
        }
        return isShowRedPoint(gameSwitchConfig.mAppId);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void startAddFriend(Context context, String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, str, str2, str3, str4);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startAddFriendActivity " + str + " " + str3);
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 3, str, str2, 3016, 101, str3, str4, null, activity.getResources().getString(R.string.button_back), null);
            if (startAddFriend != null) {
                startAddFriend.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, startAddFriend);
            }
        }
    }

    protected synchronized void syncLoadRecentGameContacts(boolean z16, k71.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar, Integer.valueOf(i3));
            return;
        }
        if (this.mApp == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "mApp not QQApp.");
            }
            return;
        }
        if (z16) {
            try {
                if (!((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isFirstLaunchNew()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "no isFirstLaunch. game contacts not fetch again.");
                    }
                    if (aVar != null) {
                        aVar.onLoadFailed();
                    }
                    return;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "syncLoadRecentGameContacts occur error:", e16);
            }
        }
        if (isInLimitOfTheFrequency(((Long) p.b(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), AppConstants.Preferences.KEY_GAME_MSG_BOX_LAST_FETCH_TIME, 0L)).longValue(), i3) && !this.mCanLoadRemoteUserList) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "limitOfTheFrequency game contacts not fetch again.");
            }
            if (aVar != null) {
                aVar.onLoadFailed();
            }
            return;
        }
        this.mCanLoadRemoteUserList = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetch recent game contacts.");
        }
        loadRemoteGameSessionList((IGameMsgManagerService) this.mApp.getRuntimeService(IGameMsgManagerService.class, ""), aVar);
    }

    protected boolean timeInToday(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, j3)).booleanValue();
        }
        try {
            Calendar calendar = Calendar.getInstance();
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            int i17 = calendar.get(5);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            int i18 = calendar2.get(1);
            int i19 = calendar2.get(2) + 1;
            int i26 = calendar2.get(5);
            if (i3 != i18 || i16 != i19 || i17 != i26) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16, new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void tryUpdateGameMsgInfoFromRecentUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mGameRecentUserCache.isEmpty()) {
            ThreadManagerV2.excute(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f185490d;

                {
                    this.f185490d = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgBoxManagerImpl.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (GameMsgBoxManagerImpl.this.mApp == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e(GameMsgBoxManagerImpl.TAG, 2, "tryUpdateGameMsgInfoFromRecentUser\uff1a mApp is null and GameRecentUserCache isEmpty");
                            return;
                        }
                        return;
                    }
                    List<? extends Entity> query = GameMsgBoxManagerImpl.this.mEntityMgr.query(GameBoxRecentUser.class);
                    if (query != null && !query.isEmpty()) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            GameBoxRecentUser gameBoxRecentUser = (GameBoxRecentUser) it.next();
                            if (gameBoxRecentUser != null) {
                                GameMsgBoxManagerImpl.this.mGameRecentUserCache.put(gameBoxRecentUser.mConvertUin, gameBoxRecentUser);
                                this.f185490d.add(gameBoxRecentUser.mToRoleId);
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(GameMsgBoxManagerImpl.TAG, 2, "getGameDetailInfo from local");
                    }
                    ((IGameMsgManagerService) GameMsgBoxManagerImpl.this.mApp.getRuntimeService(IGameMsgManagerService.class, "")).getGameDetailInfo(this.f185490d);
                }
            }, 32, null, false);
        } else {
            ThreadManagerV2.excute(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f185491d;

                {
                    this.f185491d = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgBoxManagerImpl.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (GameMsgBoxManagerImpl.this.mApp == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e(GameMsgBoxManagerImpl.TAG, 2, "tryUpdateGameMsgInfoFromRecentUser\uff1a mApp is null and GameRecentUserCache is not Empty");
                            return;
                        }
                        return;
                    }
                    for (GameBoxRecentUser gameBoxRecentUser : GameMsgBoxManagerImpl.this.mGameRecentUserCache.values()) {
                        if (gameBoxRecentUser != null) {
                            this.f185491d.add(gameBoxRecentUser.mToRoleId);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(GameMsgBoxManagerImpl.TAG, 2, "getGameDetailInfo from cache");
                    }
                    ((IGameMsgManagerService) GameMsgBoxManagerImpl.this.mApp.getRuntimeService(IGameMsgManagerService.class, "")).getGameDetailInfo(this.f185491d);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void unregisterNTGameTabListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mNTGameTabListener = null;
        }
    }

    protected boolean updateEntity(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) entity)).booleanValue();
        }
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

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void updateGameTab(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> it = this.titles.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.activity.recent.gamemsgbox.data.b next = it.next();
            if (list.contains(next.f185507d.f401939c)) {
                arrayList.add(next);
            }
        }
        if (this.titles.size() != arrayList.size() && this.mNTGameTabListener != null) {
            this.titles.clear();
            this.titles.addAll(arrayList);
            this.mNTGameTabListener.a();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateGameTab invoke by nt chat change");
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void updateGameTabInfo(gd1.a aVar, GameSwitchConfig gameSwitchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar, (Object) gameSwitchConfig);
            return;
        }
        if (aVar == null) {
            return;
        }
        synchronized (this.gameTabLock) {
            String str = aVar.f401939c;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> it = this.titles.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f185507d.f401939c)) {
                    return;
                }
            }
            com.tencent.mobileqq.activity.recent.gamemsgbox.data.b bVar = new com.tencent.mobileqq.activity.recent.gamemsgbox.data.b();
            bVar.f185507d = aVar;
            bVar.f185508e = gameSwitchConfig;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateGameTabInfo:" + aVar);
            }
            this.titles.add(bVar);
            IGameMsgBoxManager.a aVar2 = this.mNTGameTabListener;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void updateNTOpenSyncUser(gd1.a aVar, GameSwitchConfig gameSwitchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar, (Object) gameSwitchConfig);
            return;
        }
        if (gameSwitchConfig == null) {
            return;
        }
        synchronized (this.lock) {
            if (gameSwitchConfig.mSyncSwitch == 1 && !this.openSyncNTRecentUserList.contains(aVar.f401937a)) {
                this.openSyncNTRecentUserList.add(aVar.f401937a);
            } else if (gameSwitchConfig.mSyncSwitch != 1) {
                this.openSyncNTRecentUserList.remove(aVar.f401937a);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void updateRedPointShowState(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), str);
            return;
        }
        if (isShowRedPoint(str) == z16) {
            return;
        }
        p.g(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), true, "key_game_msg_box_tab_red_point_config_" + str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public void updateShowGameBoxTips(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            p.g(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_GAME_MSG_BOX_TIPS, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
    public boolean isGameInGameBox(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str)).booleanValue();
    }
}
