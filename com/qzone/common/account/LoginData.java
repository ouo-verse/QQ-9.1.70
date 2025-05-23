package com.qzone.common.account;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import a9.f;
import android.text.TextUtils;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.app.ResourcePreloader;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.publish.business.publishqueue.intimate.i;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.viewmodel.p;
import com.qzone.reborn.feedx.viewmodel.q;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneDetailCacheManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AppSetting;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import t7.d;
import x7.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LoginData implements IAccountCallback {
    private static final String TAG = "LoginData";
    private static final int UPBITMAP_ANNUAL_FEE_MASK = 65536;
    private static final int UPBITMAP_HIGH_VIP_MASK = 268435456;
    private static final int UPBITMAP_QZONEVIP_MASK = 67108864;
    private static final int UPBITMAP_VIP_LEVEL_MASK = 1966080;
    private static final Object lock = new Object();
    private static volatile LoginData sInstance;
    private AppRuntime app;
    private volatile boolean isLogining;
    private String postUin;
    private long uin = 0;
    private String userName = "";
    private volatile WeakReference<AppRuntime> mainAppRef = new WeakReference<>(null);
    private boolean enableGetA2Async = g.f53821a.b().J();
    private volatile String a2AsyncCache = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements MainTicketCallback {
        a() {
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.e(LoginData.TAG, 1, "refreshA2Cache onFail! uin:", Long.valueOf(LoginData.this.uin), ",errorCode:", Integer.valueOf(i3), ",errMsg:", str);
            LoginData.this.a2AsyncCache = null;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            String str;
            Object[] objArr = new Object[3];
            objArr[0] = "refreshA2Cache onSuccess!";
            objArr[1] = " uin:" + LoginData.this.uin;
            if (AppSetting.isDebugVersion()) {
                str = ",a2:" + mainTicketInfo.getA2();
            } else {
                str = "";
            }
            objArr[2] = str;
            QLog.d(LoginData.TAG, 1, objArr);
            LoginData.this.a2AsyncCache = mainTicketInfo.getA2();
        }
    }

    LoginData() {
        MobileQQ.sMobileQQ.registerAccountCallback(this);
    }

    public static LoginData getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new LoginData();
                }
            }
        }
        return sInstance;
    }

    private TicketManager getTicketManager() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            return (TicketManager) appRuntime.getManager(2);
        }
        if (this.mainAppRef != null) {
            AppRuntime appRuntime2 = this.mainAppRef.get();
            if (appRuntime2 != null) {
                return (TicketManager) appRuntime2.getManager(2);
            }
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (TicketManager) peekAppRuntime.getManager(2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAccountChanged$1() {
        d.l();
        x7.b.o();
        h.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preGetA2$0() {
        TicketManager ticketManager = getTicketManager();
        if (ticketManager == null || !ticketManager.useAsyncTicketInterface()) {
            return;
        }
        QLog.d(TAG, 2, "preGetA2 called");
        getA2Async(true, ticketManager);
    }

    private void preGetA2() {
        if (this.enableGetA2Async) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.common.account.a
                @Override // java.lang.Runnable
                public final void run() {
                    LoginData.this.lambda$preGetA2$0();
                }
            });
        }
    }

    private void refreshA2Cache(TicketManager ticketManager) {
        QLog.d(TAG, 2, "refreshA2Cache uin:" + this.uin);
        ticketManager.getA2(this.uin, 16, new a());
    }

    public String getA2() {
        TicketManager ticketManager;
        if (this.enableGetA2Async && (ticketManager = getTicketManager()) != null && ticketManager.useAsyncTicketInterface()) {
            return getA2Async(false, ticketManager);
        }
        return getA2Sync();
    }

    public byte[] getA2Bytes() {
        String a26 = getA2();
        if (!TextUtils.isEmpty(a26)) {
            return HexUtil.hexStr2Bytes(a26);
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "getA2Bytes null");
        return null;
    }

    public AppRuntime getMainApp() {
        return this.mainAppRef.get();
    }

    public String getNickName(String str) {
        String property = BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + getUinString());
        this.userName = property;
        return !TextUtils.isEmpty(property) ? this.userName : str;
    }

    public String getPostUin() {
        if (TextUtils.isEmpty(this.postUin)) {
            this.postUin = u5.b.h0(getUin() + "_POST_UIN", "");
        }
        return this.postUin;
    }

    public AppRuntime getQZoneRuntime() {
        AppRuntime appRuntime = this.app;
        return appRuntime == null ? this.mainAppRef.get() : appRuntime;
    }

    public AppRuntime getQzoneAppInterface() {
        return this.app;
    }

    public String getSelfTroopNickName(String str) {
        String troopNickName = getTroopNickName(str, getUinString());
        return TextUtils.isEmpty(troopNickName) ? getNickName("") : troopNickName;
    }

    public String getSid() {
        return "";
    }

    public int getStarVipLevel() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        if (currentVipInfo != null) {
            return currentVipInfo.getStarLevel();
        }
        return 0;
    }

    public String getTroopNickName(String str, String str2) {
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "LoginData-gTNN");
        if (troopMemberInfoSync == null) {
            return "";
        }
        return troopMemberInfoSync.troopnick;
    }

    public String getUid() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            return appRuntime.getCurrentUid();
        }
        if (this.mainAppRef.get() != null) {
            return this.mainAppRef.get().getCurrentUid();
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        }
        return "";
    }

    public long getUin() {
        long j3 = this.uin;
        if (j3 != 0) {
            return j3;
        }
        String uinString = getUinString();
        if (!TextUtils.isEmpty(uinString)) {
            try {
                long parseLong = Long.parseLong(uinString);
                this.uin = parseLong;
                return parseLong;
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        return 0L;
    }

    public String getUinString() {
        String account;
        String account2;
        String account3;
        long j3 = this.uin;
        if (j3 != 0) {
            return String.valueOf(j3);
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (account3 = appRuntime.getAccount()) != null) {
            return account3;
        }
        AppRuntime appRuntime2 = this.mainAppRef.get();
        if (appRuntime2 != null && (account2 = appRuntime2.getAccount()) != null) {
            return account2;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) ? "0" : account;
    }

    public int getUserType() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        if (currentVipInfo != null) {
            return currentVipInfo.getVipType();
        }
        return 0;
    }

    public QzoneVipInfo getUserVipInfo() {
        return VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
    }

    public int getVipLevel() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        if (currentVipInfo != null) {
            return currentVipInfo.getVipLevel();
        }
        return 0;
    }

    public boolean isAnnualVip() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        if (currentVipInfo != null) {
            return currentVipInfo.isAnnualVip();
        }
        return false;
    }

    public boolean isQzoneVip() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        return (currentVipInfo != null && currentVipInfo.getVipType() >= 1) || VipNtMMKV.getCommon(String.valueOf(getInstance().getUin())).decodeBool("vas_qzone_vip_pay", false);
    }

    public boolean isQzoneVipExpired() {
        return !isQzoneVip() && getVipLevel() > 0;
    }

    public boolean isSuperQzoneVip() {
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        return currentVipInfo != null && currentVipInfo.getVipType() >= 2;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        this.app = appRuntime;
        this.mainAppRef = new WeakReference<>(appRuntime);
        this.uin = 0L;
        this.uin = getUin();
        resetA2();
        QLog.i(TAG, 1, "onAccountChanged reset cache");
        if (km.a.f412646a.a()) {
            QLog.i(TAG, 1, "onAccountChanged and in show feedx mode reset cache");
            QZoneApiProxy.onAccountChange(MobileQQ.sMobileQQ, appRuntime);
            ResourcePreloader.b().k();
            jm.b.f410600a.l();
            QZoneFeedAlertService.getInstance().onAccountChange();
            q.N2();
            com.qzone.reborn.feedpro.utils.d dVar = com.qzone.reborn.feedpro.utils.d.f54318a;
            if (dVar.a()) {
                QzoneDetailCacheManager.INSTANCE.clear();
                QzoneFeedListCacheManager.INSTANCE.clearAllCache();
                QzoneFriendFeedManager.INSTANCE.clear();
                p.i2();
            }
            ze.a.a().clearAll();
            lg.g.f414459a.j();
            QZoneFeedService.N();
            kj.b.l().p();
            zh.b.l().o();
            kj.c.c().g();
            QzoneFavoriteService.M().H();
            i.f51168a.e();
            z8.c.f452134a.e();
            f.f25725a.e();
            QZonePhotoRepairTaskQueueManger.q().E();
            com.qzone.business.tianshu.c.i();
            QZoneCommentQuickInputHelper.n().l();
            mh.d.d().f();
            mh.b.d().f();
            com.qzone.adapter.feedcomponent.i.H().C1();
            e.f286406a.j();
            com.qzone.homepage.ui.Facade.h.l().x(null);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.common.account.b
                @Override // java.lang.Runnable
                public final void run() {
                    LoginData.lambda$onAccountChanged$1();
                }
            });
            com.qzone.reborn.albumx.qzonex.utils.d.b();
            if (!g.f53821a.c().j()) {
                ((IQQKuiklyService) QRoute.api(IQQKuiklyService.class)).startKMPCore();
            }
            if (dVar.b()) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager = QzoneFakeFeedLogicManager.INSTANCE;
                Objects.requireNonNull(qzoneFakeFeedLogicManager);
                rFWThreadManager.execOnFileThread(new c(qzoneFakeFeedLogicManager), 2000L);
            }
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        q.N2();
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            p.i2();
        }
    }

    public void setApp(AppRuntime appRuntime) {
        this.app = appRuntime;
        this.isLogining = false;
        preGetA2();
    }

    public void setMainApp(AppRuntime appRuntime) {
        this.mainAppRef = new WeakReference<>(appRuntime);
        this.isLogining = false;
        preGetA2();
    }

    public void setNickName(String str) {
        this.userName = str;
    }

    public void setPostUin(String str) {
        this.postUin = str;
        u5.b.v0(getUin() + "_POST_UIN", str);
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public void updateVipInfos(int i3, int i16, int i17) {
        VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
        vipComponentProxy.getServiceInterface().updateVipInfo(getUinString(), i3, i16, i17 != 0, null, null, vipComponentProxy.getServiceInterface().getVipInfo(getUinString()).getPersonalizedYellowVipUrl(), true);
    }

    private String getA2Async(boolean z16, TicketManager ticketManager) {
        QLog.d(TAG, 2, "getA2Async called");
        if (TextUtils.isEmpty(this.a2AsyncCache) && !z16) {
            this.a2AsyncCache = getA2Sync();
            QLog.d(TAG, 1, "not pre get A2 Async,cache is null,sync get A2!");
        }
        String str = this.a2AsyncCache;
        refreshA2Cache(ticketManager);
        return str;
    }

    @Deprecated
    private String getA2Sync() {
        QLog.d(TAG, 2, "getA2Sync called");
        TicketManager ticketManager = getTicketManager();
        if (ticketManager != null) {
            return ticketManager.getA2(getUinString());
        }
        return "";
    }

    private void resetA2() {
        this.a2AsyncCache = null;
        this.enableGetA2Async = g.f53821a.b().J();
        preGetA2();
    }

    public String getSkey() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "GetSkey.");
        TicketManager ticketManager = getTicketManager();
        if (ticketManager != null) {
            return ticketManager.getSkey(getUinString());
        }
        return "";
    }

    public void updateVipInfos(int i3, int i16, int i17, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, String str, boolean z16) {
        VipComponentProxy.f50997g.getServiceInterface().updateVipInfo(getUinString(), i3, i16, i17 != 0, star_infoVar, combine_diamond_infoVar, str, z16);
    }

    public void updateVipInfos(String str, String str2) {
        int i3;
        int i16;
        boolean z16;
        VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
        QzoneVipInfo vipInfo = vipComponentProxy.getServiceInterface().getVipInfo(String.valueOf(str));
        if (vipInfo != null) {
            int vipLevel = vipInfo.getVipLevel();
            int vipType = vipInfo.getVipType();
            z16 = vipInfo.isAnnualVip();
            i16 = vipLevel;
            i3 = vipType;
        } else {
            i3 = 0;
            i16 = 0;
            z16 = false;
        }
        vipComponentProxy.getServiceInterface().updateVipInfo(str, i3, i16, z16, null, null, str2, true);
    }

    public void login(String str) {
        String account;
        if (this.isLogining) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "drop login for " + com.qzone.util.b.b(str));
            return;
        }
        long j3 = this.uin;
        AppRuntime appRuntime = this.app;
        if (appRuntime == null) {
            account = "";
        } else {
            account = appRuntime.getAccount();
        }
        if (TextUtils.isEmpty(str) || str.equals(account) || this.app == null) {
            return;
        }
        long k3 = ef.d.k(str);
        getInstance().setUin(k3);
        SimpleAccount simpleAccount = new SimpleAccount();
        simpleAccount.setUin(str);
        simpleAccount.setAttribute(SimpleAccount._ISLOGINED, "true");
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "switchAccount " + com.qzone.util.b.b(str));
        this.isLogining = true;
        this.app.switchAccount(simpleAccount, null);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("old_uin", String.valueOf(j3));
        hashMap.put("app_account", account);
        hashMap.put("new_uin", String.valueOf(k3));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(j3 + "", "qzone_sync_login_switch_account", true, 0L, 0L, hashMap, null);
    }

    public void updateVipInfos(String str, boolean z16, String str2) {
        VipComponentProxy.f50997g.getServiceInterface().updateVipInfoDiamondUrl(str, z16, str2);
    }

    public void updateVipInfos(long j3) {
        if (j3 == 0) {
            return;
        }
        int i3 = ((j3 & VasBusiness.QWALLET) > VasBusiness.QWALLET ? 1 : ((j3 & VasBusiness.QWALLET) == VasBusiness.QWALLET ? 0 : -1)) == 0 ? 2 : ((j3 & 67108864) > 67108864L ? 1 : ((j3 & 67108864) == 67108864L ? 0 : -1)) == 0 ? 1 : 0;
        int i16 = (int) ((1966080 & j3) >> 17);
        int i17 = (int) ((j3 & 65536) >> 16);
        VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
        vipComponentProxy.getServiceInterface().updateVipInfo(getUinString(), i3, i16, i17 != 0, null, null, vipComponentProxy.getServiceInterface().getVipInfo(getUinString()).getPersonalizedYellowVipUrl(), false);
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
    }
}
