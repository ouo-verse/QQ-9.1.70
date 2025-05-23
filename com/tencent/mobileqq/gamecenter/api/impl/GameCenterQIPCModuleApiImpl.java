package com.tencent.mobileqq.gamecenter.api.impl;

import android.os.Bundle;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class GameCenterQIPCModuleApiImpl implements IGameCenterQIPCModuleApi {
    private static final String ACTION_CREATE_WIDGET = "create_widget";
    private static final String ACTION_GET_GAME_FRIEND_ENABLE_STATUS = "get_game_friend_enable_status";
    private static final String ACTION_QUERY_WIDGET_ADD_STATUS = "query_widget_add_status";
    private static final String ACTION_SET_SWITCH_STATUS = "setSwitchStatus";
    private static final String KEY_APPID = "appid";
    private static final String KEY_BUS_ID = "busId";
    private static final String KEY_GAME_FRIEND_ENABLE_STATUS = "game_friend_enable_status";
    private static final String KEY_IS_ADD_WIDGET = "is_add_widget";
    private static final String TAG = "GameCenterQIPCModuleApiImpl";
    private final ArrayMap<String, c> mActionToProcessorMap;
    private final QIPCModule mQIPCModule;

    /* loaded from: classes12.dex */
    class a extends QIPCModule {
        a(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            c cVar = (c) GameCenterQIPCModuleApiImpl.this.mActionToProcessorMap.get(str);
            if (cVar != null) {
                return cVar.onCall(str, bundle, i3);
            }
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class b implements com.tencent.qqnt.http.api.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.gamecenter.api.k f211852a;

        b(com.tencent.mobileqq.gamecenter.api.k kVar) {
            this.f211852a = kVar;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull com.tencent.qqnt.http.api.m mVar) {
            QLog.e(GameCenterQIPCModuleApiImpl.TAG, 1, "[onFailed]");
            try {
                if (this.f211852a != null && mVar != null) {
                    int intValue = mVar.c().intValue();
                    QLog.e(GameCenterQIPCModuleApiImpl.TAG, 1, "http code:" + intValue);
                    this.f211852a.onResult(Integer.valueOf(intValue));
                }
            } catch (Throwable th5) {
                QLog.e(GameCenterQIPCModuleApiImpl.TAG, 1, "[reportAtta], th:" + th5);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull com.tencent.qqnt.http.api.m mVar) {
            QLog.i(GameCenterQIPCModuleApiImpl.TAG, 1, "[onSuccess]");
            com.tencent.mobileqq.gamecenter.api.k kVar = this.f211852a;
            if (kVar != null && mVar != null) {
                kVar.onResult(mVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public interface c {
        EIPCResult onCall(String str, Bundle bundle, int i3);
    }

    public GameCenterQIPCModuleApiImpl() {
        ArrayMap<String, c> arrayMap = new ArrayMap<>();
        this.mActionToProcessorMap = arrayMap;
        arrayMap.put(ACTION_GET_GAME_FRIEND_ENABLE_STATUS, new c() { // from class: com.tencent.mobileqq.gamecenter.api.impl.m
            @Override // com.tencent.mobileqq.gamecenter.api.impl.GameCenterQIPCModuleApiImpl.c
            public final EIPCResult onCall(String str, Bundle bundle, int i3) {
                EIPCResult checkGameFriendEnableStatusImpl;
                checkGameFriendEnableStatusImpl = GameCenterQIPCModuleApiImpl.this.checkGameFriendEnableStatusImpl(str, bundle, i3);
                return checkGameFriendEnableStatusImpl;
            }
        });
        arrayMap.put(ACTION_QUERY_WIDGET_ADD_STATUS, new c() { // from class: com.tencent.mobileqq.gamecenter.api.impl.n
            @Override // com.tencent.mobileqq.gamecenter.api.impl.GameCenterQIPCModuleApiImpl.c
            public final EIPCResult onCall(String str, Bundle bundle, int i3) {
                EIPCResult checkWidgetAddStatusImpl;
                checkWidgetAddStatusImpl = GameCenterQIPCModuleApiImpl.this.checkWidgetAddStatusImpl(str, bundle, i3);
                return checkWidgetAddStatusImpl;
            }
        });
        arrayMap.put(ACTION_CREATE_WIDGET, new c() { // from class: com.tencent.mobileqq.gamecenter.api.impl.o
            @Override // com.tencent.mobileqq.gamecenter.api.impl.GameCenterQIPCModuleApiImpl.c
            public final EIPCResult onCall(String str, Bundle bundle, int i3) {
                EIPCResult createWidgetImpl;
                createWidgetImpl = GameCenterQIPCModuleApiImpl.this.createWidgetImpl(str, bundle, i3);
                return createWidgetImpl;
            }
        });
        arrayMap.put(ACTION_SET_SWITCH_STATUS, new c() { // from class: com.tencent.mobileqq.gamecenter.api.impl.p
            @Override // com.tencent.mobileqq.gamecenter.api.impl.GameCenterQIPCModuleApiImpl.c
            public final EIPCResult onCall(String str, Bundle bundle, int i3) {
                EIPCResult switchStatusInner;
                switchStatusInner = GameCenterQIPCModuleApiImpl.this.setSwitchStatusInner(str, bundle, i3);
                return switchStatusInner;
            }
        });
        this.mQIPCModule = new a(IGameCenterQIPCModuleApi.NAME);
    }

    private void callbackGameFriendEnableStatusAction(int i3, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_GAME_FRIEND_ENABLE_STATUS, z16);
        this.mQIPCModule.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EIPCResult checkGameFriendEnableStatusImpl(String str, Bundle bundle, final int i3) {
        String string = bundle.getString("appid");
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null && ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).isGameMsgSync(string)) {
            ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getGameFriendRelationRange(string, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.mobileqq.gamecenter.api.impl.l
                @Override // com.tencent.mobileqq.gamecenter.api.k
                public final void onResult(Object obj) {
                    GameCenterQIPCModuleApiImpl.this.lambda$checkGameFriendEnableStatusImpl$3(i3, (Integer) obj);
                }
            });
            return null;
        }
        callbackGameFriendEnableStatusAction(i3, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EIPCResult checkWidgetAddStatusImpl(String str, Bundle bundle, int i3) {
        QLog.i(TAG, 1, "[checkWidgetAddStatusImpl]");
        boolean hasWidgetV2 = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).hasWidgetV2();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(KEY_IS_ADD_WIDGET, hasWidgetV2);
        this.mQIPCModule.callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EIPCResult createWidgetImpl(String str, Bundle bundle, int i3) {
        QLog.i(TAG, 1, "[createWidget]");
        ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).addWidgetV2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        if (r4.intValue() != 2) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$checkGameFriendEnableStatusImpl$3(int i3, Integer num) {
        boolean z16;
        if (num != null) {
            z16 = true;
            if (num.intValue() != 1) {
            }
            callbackGameFriendEnableStatusAction(i3, z16);
        }
        z16 = false;
        callbackGameFriendEnableStatusAction(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGameFriendEnableStatus$2(com.tencent.mobileqq.gamecenter.api.k kVar, EIPCResult eIPCResult) {
        Bundle bundle;
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
            z16 = bundle.getBoolean(KEY_GAME_FRIEND_ENABLE_STATUS, false);
        }
        kVar.onResult(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryWidget$0(com.tencent.mobileqq.gamecenter.api.k kVar, EIPCResult eIPCResult) {
        Bundle bundle;
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
            z16 = bundle.getBoolean(KEY_IS_ADD_WIDGET, false);
        }
        kVar.onResult(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setSwitchStatus$1(com.tencent.mobileqq.gamecenter.api.k kVar, EIPCResult eIPCResult) {
        Bundle bundle;
        int i3 = 0;
        if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
            i3 = bundle.getInt("ret", 0);
        }
        kVar.onResult(new Integer(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EIPCResult setSwitchStatusInner(String str, Bundle bundle, int i3) {
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).setDualSwitch(bundle.getInt("status"), bundle.getInt("switchId"));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("ret", 0);
        this.mQIPCModule.callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public void createWidget(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_BUS_ID, i3);
        QIPCClientHelper.getInstance().callServer(IGameCenterQIPCModuleApi.NAME, ACTION_CREATE_WIDGET, bundle);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public void getGameFriendEnableStatus(String str, @NonNull final com.tencent.mobileqq.gamecenter.api.k<Boolean> kVar) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        QIPCClientHelper.getInstance().callServer(IGameCenterQIPCModuleApi.NAME, ACTION_GET_GAME_FRIEND_ENABLE_STATUS, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.gamecenter.api.impl.q
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GameCenterQIPCModuleApiImpl.lambda$getGameFriendEnableStatus$2(com.tencent.mobileqq.gamecenter.api.k.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public QIPCModule getQIPCModule() {
        return this.mQIPCModule;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public void queryWidget(int i3, @NonNull final com.tencent.mobileqq.gamecenter.api.k<Boolean> kVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_BUS_ID, i3);
        QIPCClientHelper.getInstance().callServer(IGameCenterQIPCModuleApi.NAME, ACTION_QUERY_WIDGET_ADD_STATUS, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.gamecenter.api.impl.s
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GameCenterQIPCModuleApiImpl.lambda$queryWidget$0(com.tencent.mobileqq.gamecenter.api.k.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public void reportAtta(String str, @NonNull com.tencent.mobileqq.gamecenter.api.k<Integer> kVar) {
        try {
            if (str.isEmpty()) {
                QLog.w(TAG, 1, "---req body is empty----");
            } else {
                com.tencent.mobileqq.gamecenter.utils.a.INSTANCE.a(str, new b(kVar));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[reportAtta], error:" + th5);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi
    public void setSwitchStatus(int i3, int i16, @NonNull final com.tencent.mobileqq.gamecenter.api.k<Integer> kVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("status", i3);
        bundle.putInt("switchId", i16);
        QIPCClientHelper.getInstance().callServer(IGameCenterQIPCModuleApi.NAME, ACTION_SET_SWITCH_STATUS, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.gamecenter.api.impl.r
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GameCenterQIPCModuleApiImpl.lambda$setSwitchStatus$1(com.tencent.mobileqq.gamecenter.api.k.this, eIPCResult);
            }
        });
    }
}
