package com.tencent.mobileqq.nearby.api.impl;

import EncounterSvc.UserDetailLocalInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.config.af;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nearby.NearbyEntityManagerFactory;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyTransFileController;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.nearby.api.b;
import com.tencent.mobileqq.nearby.e;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AccountManagerImpl;
import mqq.app.Constants;
import mqq.app.IToolProcEventListener;
import mqq.app.NewIntent;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$SelfInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyAppInterfaceImpl extends BaseToolAppInterface implements IToolProcEventListener, INearbyAppInterface {
    public static final String TAG = "NearbyAppInterface";
    private static boolean sEnableFreshPreload = true;
    private static boolean sEnableFreshStaticLayout = true;
    NearbyEntityManagerFactory emFactory;
    boolean mDPCInit;
    private Object mEmFactoryLock;
    private int mLastTabIndex;
    Object mLock;
    private boolean mNeedStoreAnchorage;
    private int mPerfState;
    private long mPreLoadTime;
    private int mPreloadFrom;
    private oidb_0x8dd$SelfInfo mSelfRespEncounterInfo;
    private b mService;
    private UserDetailLocalInfo mUdlInfo;
    int mVoteRedDotState;
    Map<Integer, Manager> managers;
    a netHandler;
    private INearbyTransFileController transFileController;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetMobile2None();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetMobile2Wifi(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetNone2Mobile(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetNone2Wifi(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetWifi2Mobile(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            if (((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine != null) {
                ((AppInterface) NearbyAppInterfaceImpl.this).mHwEngine.onNetWifi2None();
            }
        }
    }

    public NearbyAppInterfaceImpl(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        this.mLastTabIndex = 0;
        this.mNeedStoreAnchorage = true;
        this.managers = new HashMap(20);
        this.mLock = new Object();
        this.mDPCInit = false;
        this.mUdlInfo = null;
        this.mEmFactoryLock = new Object();
        this.netHandler = null;
        this.mVoteRedDotState = Integer.MIN_VALUE;
        this.mPerfState = 0;
        this.mPreloadFrom = 0;
    }

    public static void freePartBitmapCache() {
        ImageCacheHelper.f98636a.e();
    }

    @Override // mqq.app.AppRuntime
    public void addManager(int i3, Manager manager) {
        if (this.managers.get(Integer.valueOf(i3)) != null) {
            return;
        }
        this.managers.put(Integer.valueOf(i3), manager);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void finalize() throws Throwable {
        super.finalize();
        NearbyEntityManagerFactory nearbyEntityManagerFactory = this.emFactory;
        if (nearbyEntityManagerFactory != null) {
            nearbyEntityManagerFactory.close();
        }
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public String getCurrentNickname() {
        if (getmSelfRespEncounterInfo() == null) {
            return getAccount();
        }
        return getmSelfRespEncounterInfo().bytes_nick.get().toStringUtf8();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory() {
        return getEntityManagerFactory(getAccount());
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        Manager manager = this.managers.get(Integer.valueOf(i3));
        if (manager == null) {
            synchronized (this.managers) {
                try {
                    if (i3 == 0) {
                        manager = new AccountManagerImpl(this);
                    } else if (i3 == 1) {
                        manager = new WtloginManagerImpl(this);
                    } else if (i3 == 2) {
                        manager = new TicketManagerImpl(this);
                    } else if (i3 == e.f252577d) {
                        manager = new af(this);
                    } else if (i3 == e.f252579f) {
                        manager = (Manager) ((IFactoryApi) QRoute.api(IFactoryApi.class)).getNearbyProcManager(this);
                    } else if (i3 == e.f252581h) {
                        IOldBigDataChannelManager iOldBigDataChannelManager = (IOldBigDataChannelManager) QRoute.api(IOldBigDataChannelManager.class);
                        iOldBigDataChannelManager.init(this);
                        manager = (Manager) iOldBigDataChannelManager;
                    } else if (i3 == e.f252583j) {
                        manager = new UsingTimeReportManager(this);
                    } else if (i3 == e.f252584k) {
                        manager = new DownloaderFactory(this);
                    } else if (i3 == QQManagerFactory.DYNAMIC_AVATAR_MANAGER) {
                        manager = new DynamicAvatarManager(this);
                    }
                    if (this.managers.get(Integer.valueOf(i3)) != null) {
                        manager = this.managers.get(Integer.valueOf(i3));
                    } else if (manager != null) {
                        this.managers.put(Integer.valueOf(i3), manager);
                    }
                } finally {
                }
            }
        }
        return manager;
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        return (MobileQQServiceBase) getmService();
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return FaceConstant.NEARBY_MODULAR_MODULE_ID;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public com.tencent.mobileqq.nearby.ipc.b getNearbyProcManager() {
        return (com.tencent.mobileqq.nearby.ipc.b) getManager(e.f252579f);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public int getmPerfState() {
        return this.mPerfState;
    }

    public int getmPreloadFrom() {
        return this.mPreloadFrom;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public b getmService() {
        return this.mService;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public boolean isSVip() {
        return false;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public boolean isVip() {
        return false;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void nearbyReportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        String checkClickEventParam = checkClickEventParam(str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        if (TextUtils.isEmpty(checkClickEventParam)) {
            getNearbyProcManager().b(false, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
            return;
        }
        throw new IllegalArgumentException(checkClickEventParam);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setmService(new com.tencent.mobileqq.nearby.api.impl.a(this));
        ((com.tencent.mobileqq.nearby.ipc.b) getManager(e.f252579f)).d();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (NearbyAppInterfaceImpl.this.mLock) {
                    if (!NearbyAppInterfaceImpl.this.mDPCInit) {
                        try {
                            ((IDPCApi) QRoute.api(IDPCApi.class)).registerBroadCast(NearbyAppInterfaceImpl.this);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(NearbyAppInterfaceImpl.TAG, 2, "onDestroy: ", e16);
                            }
                        }
                        NearbyAppInterfaceImpl.this.mDPCInit = true;
                    }
                }
            }
        }, 8, null, true);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        super.onDestroy();
        HwEngine hwEngine = this.mHwEngine;
        if (hwEngine != null) {
            hwEngine.closeEngine();
        }
        synchronized (this.mLock) {
            if (this.mDPCInit) {
                try {
                    ((IDPCApi) QRoute.api(IDPCApi.class)).unRegisterBroadCast(this);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "onDestroy: ", e16);
                    }
                }
            } else {
                this.mDPCInit = true;
            }
        }
        synchronized (this.managers) {
            Set<Integer> keySet = this.managers.keySet();
            if (keySet != null && keySet.size() > 0) {
                Iterator<Integer> it = keySet.iterator();
                while (it.hasNext()) {
                    try {
                        Manager manager = this.managers.get(it.next());
                        if (manager != null) {
                            manager.onDestroy();
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        if (QLog.isColorLevel()) {
                            l.b(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY, e17.toString());
                        }
                    }
                }
            }
            this.managers.clear();
        }
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void reportClickEventAsync(final String str, final String str2, final String str3, final String str4, final String str5, final int i3, final int i16, final String str6, final String str7, final String str8, final String str9) {
        String checkClickEventParam = checkClickEventParam(str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        if (TextUtils.isEmpty(checkClickEventParam)) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    NearbyAppInterfaceImpl.this.getNearbyProcManager().b(false, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
                }
            }, 2, null, false);
            return;
        }
        throw new IllegalArgumentException(checkClickEventParam);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setTalkbackSwitch() {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.app.getSystemService("accessibility");
            AppSetting.f99565y = accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "set talkback enable: " + AppSetting.f99565y);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setmPerfState(int i3) {
        this.mPerfState = i3;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setmPreLoadTime(long j3) {
        this.mPreLoadTime = j3;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setmPreloadFrom(int i3) {
        this.mPreloadFrom = i3;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setmSelfRespEncounterInfo(Object obj) {
        this.mSelfRespEncounterInfo = (oidb_0x8dd$SelfInfo) obj;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void setmService(b bVar) {
        this.mService = bVar;
    }

    @Override // mqq.app.AppRuntime
    public void start(boolean z16) {
        this.netHandler = new a();
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.netHandler);
        super.start(z16);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void updatePerfState(int i3, int i16) {
        if (QLog.isColorLevel()) {
            l.b("updatePerfState", Integer.valueOf(i3), Integer.valueOf(getmPerfState()));
        }
        if (i3 > getmPerfState()) {
            setmPerfState(i3);
            if (getmPerfState() == 1) {
                setmPreLoadTime(System.currentTimeMillis());
                setmPreloadFrom(i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public void writeVoteRedDotState(int i3) {
        this.mVoteRedDotState = i3;
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(getAccount(), INearbySPUtil.SP_FILE_NAME_MYTAB, 0, INearbySPUtil.KEY_NEARBY_MYTAB_ZAN_CHECK, Integer.valueOf(this.mVoteRedDotState));
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(getAccount())) {
            NearbyEntityManagerFactory nearbyEntityManagerFactory = this.emFactory;
            if (nearbyEntityManagerFactory != null) {
                return nearbyEntityManagerFactory;
            }
            synchronized (this.mEmFactoryLock) {
                if (this.emFactory == null) {
                    this.emFactory = new NearbyEntityManagerFactory(str);
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NearbyAppInterfaceImpl.this.emFactory.verifyAuthentication()) {
                                return;
                            }
                            QLog.e(NearbyAppInterfaceImpl.TAG, 1, "verify fail!");
                            if (NearbyAppInterfaceImpl.this.isLogin()) {
                                NearbyAppInterfaceImpl.this.logout(true);
                            }
                            Intent intent = new Intent(NewIntent.ACTION_ACCOUNT_KICKED);
                            intent.putExtra("title", HardCodeUtil.qqStr(R.string.oed));
                            intent.putExtra("msg", HardCodeUtil.qqStr(R.string.oee));
                            intent.putExtra("reason", Constants.LogoutReason.kicked);
                            intent.addFlags(268435456);
                            BaseApplicationImpl.sApplication.startActivity(intent);
                        }
                    }, 1000L);
                }
            }
            return this.emFactory;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is not match." + str + "!=" + getAccount());
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyAppInterface
    public oidb_0x8dd$SelfInfo getmSelfRespEncounterInfo() {
        return this.mSelfRespEncounterInfo;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        l.b("onReceiveAccountAction", new Object[0]);
        if (NewIntent.ACTION_ACCOUNT_KICKED.equals(str)) {
            ((UsingTimeReportManager) getManager(e.f252583j)).a();
        }
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        l.b("onReceiveLegalExitProcAction", new Object[0]);
        return false;
    }

    private String checkClickEventParam(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        if (str2 != null && str4 != null && str5 != null) {
            if (str.equals("CliOper") && str2.length() > 0) {
                return "mainAction is not empty";
            }
            if (!str.equals("CliOper")) {
                return null;
            }
            if (!TextUtils.isEmpty(str6)) {
                try {
                    Long.parseLong(str6);
                } catch (Exception unused) {
                    return "r2 must be a numeric string";
                }
            }
            if (TextUtils.isEmpty(str7)) {
                return null;
            }
            try {
                Long.parseLong(str7);
                return null;
            } catch (Exception unused2) {
                return "r3 must be a numeric string";
            }
        }
        return "mainAction or subAction or actionName may not be null";
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
    }
}
