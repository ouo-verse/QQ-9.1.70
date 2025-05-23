package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderOfTianshuServiceImpl implements IQQReminderOfTianshuService {
    static IPatchRedirector $redirector_ = null;
    private static final String PREF_KEY_LAST_REQUEST_TIME = "last_request_time";
    public static final String TAG = "QQReminderOfTianshuServiceImpl";
    private boolean isUserTianshuCommonRequest;
    private WeakReference<AppRuntime> mAppRef;
    private long mLastRequestTimeInMill;
    private INetEventHandler mNetEventHandler;
    private int mRequestInterval;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements INetEventHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderOfTianshuServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16) {
                QLog.i(QQReminderOfTianshuServiceImpl.TAG, 1, "onNetChangeEvent network is available");
                QQReminderOfTianshuServiceImpl.this.getReminderDataFromTianshu(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class b implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQReminderOfTianshuServiceImpl> f280924d;

        public b(QQReminderOfTianshuServiceImpl qQReminderOfTianshuServiceImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQReminderOfTianshuServiceImpl);
            } else {
                this.f280924d = new WeakReference<>(qQReminderOfTianshuServiceImpl);
            }
        }

        public QQReminderOfTianshuServiceImpl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQReminderOfTianshuServiceImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            WeakReference<QQReminderOfTianshuServiceImpl> weakReference = this.f280924d;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), getAdsRsp);
                return;
            }
            QLog.i(QQReminderOfTianshuServiceImpl.TAG, 1, "[onGetAdvs], result:" + z16);
            if (z16 && getAdsRsp != null) {
                QQReminderOfTianshuServiceImpl a16 = a();
                if (a16 != null) {
                    a16.handleGetReminderInfoCallback(getAdsRsp);
                    return;
                }
                return;
            }
            QLog.i(QQReminderOfTianshuServiceImpl.TAG, 1, "param is error.");
        }
    }

    public QQReminderOfTianshuServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLastRequestTimeInMill = 0L;
        this.mRequestInterval = 300;
        this.isUserTianshuCommonRequest = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("reminder_use_tianshu_common_request", true);
        this.mNetEventHandler = new a();
    }

    private List<TianShuAccess.AdItem> getAdItems(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        if (getAdsRsp == null) {
            return null;
        }
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list != null && list.size() != 0) {
            TianShuAccess.RspEntry rspEntry = list.get(0);
            if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
                return pBRepeatMessageField.get();
            }
            QLog.i(TAG, 1, "ads resp param is error.");
        }
        return null;
    }

    private HashMap<String, String> getReminderDataMap(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        return hashMap;
    }

    private Wallet.a getReminderInfo(TianShuAccess.AdItem adItem) {
        try {
            QLog.i(TAG, 1, "[handleSingleAdItem]");
            Wallet.a reminderInfo = getReminderInfo(getReminderDataMap(adItem));
            reminderInfo.f25152k = String.valueOf(adItem.iAdId.get());
            reminderInfo.f25153l = adItem.traceinfo.get();
            return reminderInfo;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TianShuAdPosItemData> getRequestList() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = QQConstants.REMINDER_POS_ID;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetReminderInfoCallback(TianShuAccess.GetAdsRsp getAdsRsp) {
        try {
            List<TianShuAccess.AdItem> adItems = getAdItems(getAdsRsp);
            if (adItems != null && adItems.size() != 0) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(getReminderInfo(adItems.get(0))) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderOfTianshuServiceImpl.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Wallet.a f280922d;

                    {
                        this.f280922d = r5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderOfTianshuServiceImpl.this, (Object) r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            QQReminderUtil.J(QBaseActivity.sTopActivity, this.f280922d);
                        }
                    }
                });
                return;
            }
            QLog.i(TAG, 1, "No ads.");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[handleGetReminderInfoCallback], error happens! " + th5.getMessage());
        }
    }

    private void init() {
        this.mLastRequestTimeInMill = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(PREF_KEY_LAST_REQUEST_TIME, 0L);
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this.mNetEventHandler);
        updateRequestInterval(((com.tencent.mobileqq.reminder.data.a) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_BUBBLE_REQUEST_INTERVAL, new com.tencent.mobileqq.reminder.data.a())).mRequestIntervalInSec, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAllow2RequestData() {
        if (!QQReminderUtil.h()) {
            QLog.i(TAG, 1, "top new msg switch is off.");
            return false;
        }
        if (QQReminderUtil.w()) {
            QLog.i(TAG, 1, "isInMsgNotificationTime");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastRequestTimeInMill < this.mRequestInterval * 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "it's not time to request reminder data from tianshu.");
            }
            return false;
        }
        this.mLastRequestTimeInMill = currentTimeMillis;
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(PREF_KEY_LAST_REQUEST_TIME, currentTimeMillis).commitAsync();
        return true;
    }

    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<AppRuntime> weakReference = this.mAppRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService
    public void getReminderDataFromTianshu(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (this.isUserTianshuCommonRequest) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getReminderDataFromTianshu], from:" + i3);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderOfTianshuServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderOfTianshuServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (QQReminderOfTianshuServiceImpl.this.isAllow2RequestData()) {
                        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(QQReminderOfTianshuServiceImpl.this.getRequestList(), new b(QQReminderOfTianshuServiceImpl.this));
                    }
                } catch (Throwable th5) {
                    QLog.e(QQReminderOfTianshuServiceImpl.TAG, 1, "[getReminderDataFromTianshu], error:" + th5);
                }
            }
        }, 128, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.i(TAG, 1, "[onCreate]");
        this.mAppRef = new WeakReference<>(appRuntime);
        init();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.i(TAG, 1, "[onDestroy]");
            AppNetConnInfo.unregisterNetEventHandler(this.mNetEventHandler);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService
    public void report2Tianshu(int i3, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2);
            return;
        }
        try {
            QLog.d(TAG, 1, "[report2Tianshu], action:", Integer.valueOf(i3), ", itemId=", str, ",traceInfo=", str2);
            TianShuReportData tianShuReportData = new TianShuReportData();
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime == null) {
                str3 = "";
            } else {
                str3 = appRuntime.getAccount();
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
            tianShuReportData.mTraceId = str3 + "_" + serverTimeMillis;
            tianShuReportData.mTraceNum = 1;
            tianShuReportData.mAppId = "tianshu.32";
            tianShuReportData.mPageId = "tianshu.32";
            tianShuReportData.mItemId = str;
            tianShuReportData.mSubItemId = "";
            tianShuReportData.mOperTime = serverTimeMillis;
            tianShuReportData.mActionId = i3;
            tianShuReportData.mActionValue = 1;
            tianShuReportData.mActionAttr = 1;
            tianShuReportData.mTriggerInfo = str2;
            tianShuReportData.mAdSpace = QQConstants.REMINDER_POS_ID;
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[report2Tianshu], error:" + th5);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService
    public void updateRequestInterval(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i(TAG, 1, "[updateRequestInterval], interval:" + i3 + ",from:" + i16);
        this.mRequestInterval = i3;
    }

    private Wallet.a getReminderInfo(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        Wallet.a aVar = new Wallet.a();
        aVar.f25142a = hashMap.get("toptext");
        aVar.f25143b = hashMap.get("title");
        aVar.f25146e = hashMap.get("pic");
        aVar.f25144c = hashMap.get("text");
        aVar.f25151j = Integer.valueOf(hashMap.get("time")).intValue();
        aVar.f25149h = hashMap.get("url");
        aVar.f25150i = hashMap.get(QZoneDTLoginReporter.SCHEMA);
        return aVar;
    }
}
