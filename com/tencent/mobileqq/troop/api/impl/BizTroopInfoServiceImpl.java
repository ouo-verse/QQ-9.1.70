package com.tencent.mobileqq.troop.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopsurvey.handler.TroopSurveyHandler;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$ToastInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BizTroopInfoServiceImpl implements IBizTroopInfoService {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_FOR_SHOW_TROOP_BIG_CLUB = "show_troop_big_club";
    private static final String TAG = "BizTroopInfoService";
    protected AppRuntime app;

    /* renamed from: em, reason: collision with root package name */
    protected EntityManager f294210em;
    protected boolean isConfessPanelOpen;
    protected boolean isTroopAIOOpen;
    private Map<String, Long> mActiveTroopMap;
    protected ConcurrentHashMap<String, Integer> mAssocitedTroopCountCache;
    protected String mCurrentOpenTroop;
    public boolean mIsShowTroopBigClub;
    protected Map<String, oidb_cmd0xb36$RspBody> mMapOfSurveyList;
    private Runnable mSurveyListCheckRunnable;

    public BizTroopInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsShowTroopBigClub = true;
        this.mMapOfSurveyList = new ConcurrentHashMap();
        this.mSurveyListCheckRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.api.impl.BizTroopInfoServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BizTroopInfoServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Collection<oidb_cmd0xb36$RspBody> values = BizTroopInfoServiceImpl.this.mMapOfSurveyList.values();
                long serverTime = NetConnInfoCenter.getServerTime();
                AppRuntime appRuntime = BizTroopInfoServiceImpl.this.app;
                if (appRuntime == null) {
                    QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "Error: check survey list expire, app is null!");
                    return;
                }
                for (oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody : values) {
                    if (oidb_cmd0xb36_rspbody.toast.expired.has() && oidb_cmd0xb36_rspbody.toast.expired.get() < serverTime) {
                        String valueOf = String.valueOf(oidb_cmd0xb36_rspbody.group_id.get());
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "group id ", valueOf, "request survey toast, expiredTime: ", Integer.valueOf(oidb_cmd0xb36_rspbody.toast.expired.get()));
                        }
                        AppRuntime appRuntime2 = BizTroopInfoServiceImpl.this.app;
                        if (appRuntime2 instanceof AppInterface) {
                            ((tt2.a) ((AppInterface) appRuntime2).getBusinessHandler(TroopSurveyHandler.class.getName())).c2(valueOf, 0);
                        }
                    }
                }
                BizTroopInfoServiceImpl.this.scheduleFetchExpiredSurveyList();
            }
        };
    }

    private String getTroopNameByID(String str) {
        TroopInfo findTroopInfo = ((ITroopInfoService) this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null && findTroopInfo.getTroopDisplayName() != null) {
            return findTroopInfo.getTroopDisplayName();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleFetchExpiredSurveyList() {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "[TroopManager]scheduleFetchExpiredSurveyList()");
        }
        int serverTime = (int) NetConnInfoCenter.getServerTime();
        long j3 = 2147483647L;
        for (oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody : this.mMapOfSurveyList.values()) {
            if (oidb_cmd0xb36_rspbody.toast.has() && oidb_cmd0xb36_rspbody.toast.expired.has() && (i3 = oidb_cmd0xb36_rspbody.toast.expired.get()) > serverTime) {
                j3 = Math.max(60L, Math.min(j3, i3 - serverTime));
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "survey id=", Long.valueOf(oidb_cmd0xb36_rspbody.toast.f435985id.get()), " not expired, will schedule request in ", Long.valueOf(j3), " seconds");
                }
            }
        }
        if (j3 != TTL.MAX_VALUE) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "Will request survey toast info in ", Long.valueOf(j3), " seconds!");
            }
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mSurveyListCheckRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.mSurveyListCheckRunnable, Math.min(j3 * 1000, TTL.MAX_VALUE));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, String.valueOf(this.mMapOfSurveyList.size()) + " surveys, all of them expired");
        }
    }

    private void updateActiveTroop(String str) {
        if (((ITroopInfoService) this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str) == null) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        Map<String, Long> map = this.mActiveTroopMap;
        if (map != null && map.containsKey(str)) {
            if (serverTime - this.mActiveTroopMap.get(str).longValue() < 60) {
                QLog.i("troop_ext", 1, "onTroopReceiveOrSendMsg current time - time < 60s.");
                return;
            }
        } else {
            if (this.mActiveTroopMap == null) {
                this.mActiveTroopMap = new ConcurrentHashMap();
            }
            this.mActiveTroopMap.put(str, Long.valueOf(serverTime));
        }
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setTroopIsActive(str, null, TAG, null);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public int getAssociatedTroopCount(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.mAssocitedTroopCountCache) == null || !concurrentHashMap.containsKey(str)) {
            return 0;
        }
        return this.mAssocitedTroopCountCache.get(str).intValue();
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public String getCurrentOpenTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mCurrentOpenTroop;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public oidb_cmd0xb36$ToastInfo getTroopSurveyList(String str) {
        oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (oidb_cmd0xb36$ToastInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str == null || (oidb_cmd0xb36_rspbody = this.mMapOfSurveyList.get(str)) == null || !oidb_cmd0xb36_rspbody.toast.has()) {
            return null;
        }
        return oidb_cmd0xb36_rspbody.toast;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public boolean getmIsShowTroopBigClub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.mIsShowTroopBigClub;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public boolean isChangedTroopBigClub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return VipMMKV.getTroopVipIcon(this.app.getApp(), this.app.getAccount()).contains(KEY_FOR_SHOW_TROOP_BIG_CLUB);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized boolean isCurrentOpenTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return TextUtils.equals(str, this.mCurrentOpenTroop);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public boolean isFansTroop(String str) {
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (findTroopInfo = ((ITroopInfoService) this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str)) == null || !findTroopInfo.isFansTroop()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public boolean isShowTroopBigClub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (VipMMKV.getTroopVipIcon(this.app.getApp(), this.app.getAccount()).getBoolean(KEY_FOR_SHOW_TROOP_BIG_CLUB, true)) {
            return true;
        }
        IVipStatusManager vipStatus = VasUtil.getSignedService(this.app).getVipStatus();
        boolean isBigClub = vipStatus.isBigClub();
        boolean isStar = vipStatus.isStar();
        if (!isBigClub && !isStar) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized boolean isTroopAIOOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isTroopAIOOpen : " + this.isTroopAIOOpen);
        }
        return this.isTroopAIOOpen;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized boolean isTroopConfessPanelOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isTroopConfessPanelOpen isConfessPanelOpen: " + this.isConfessPanelOpen);
        }
        return this.isConfessPanelOpen;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        this.f294210em = appRuntime.getEntityManagerFactory().createEntityManager();
        this.mIsShowTroopBigClub = isShowTroopBigClub();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f294210em.close();
        this.mMapOfSurveyList.clear();
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mSurveyListCheckRunnable);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public void onTroopReceiveOrSendMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            updateActiveTroop(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public void setAssociatedTroopCount(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.mAssocitedTroopCountCache == null) {
                this.mAssocitedTroopCountCache = new ConcurrentHashMap<>();
            }
            this.mAssocitedTroopCountCache.put(str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized void setCurrentOpenTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mCurrentOpenTroop = str;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public void setShowTroopBigClub(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            VipMMKV.getTroopVipIcon(this.app.getApp(), this.app.getAccount()).edit().putBoolean(KEY_FOR_SHOW_TROOP_BIG_CLUB, z16).apply();
            this.mIsShowTroopBigClub = z16;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized void setTroopAIOOpen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setTroopAIOOpen flag: " + z16);
        }
        this.isTroopAIOOpen = z16;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public synchronized void setTroopConfessPanelOpen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setTroopConfessPanelOpen flag: " + z16);
        }
        this.isConfessPanelOpen = z16;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopInfoService
    public void updateTroopSurveyList(oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) oidb_cmd0xb36_rspbody);
            return;
        }
        if (oidb_cmd0xb36_rspbody != null && oidb_cmd0xb36_rspbody.group_id.has()) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "[TroopManager]updateTroopSurveyList() body ready!");
            }
            this.mMapOfSurveyList.put(String.valueOf(oidb_cmd0xb36_rspbody.group_id.get()), oidb_cmd0xb36_rspbody);
        } else if (oidb_cmd0xb36_rspbody == null) {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "[TroopManager]updateTroopSurveyList() body is null!");
        } else {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "[TroopManager]updateTroopSurveyList() IllegaleArgument!");
        }
        scheduleFetchExpiredSurveyList();
    }
}
