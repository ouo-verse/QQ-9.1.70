package cooperation.vip.tianshu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QUA;
import cooperation.vip.VasC2SReporter;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.pb.TianShuReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianShuManager {
    private static final long DEFAULT_REPORT_DELAY_TIME = 3000;
    public static final String KEY_VAS_NEXT_REQUEST_TIME = "next_request_time_";
    private static final String SP_NAME = "tianshu_manager";
    private static final String SP_TIME_DELAY_KEY = "time_delay";
    private static final String TAG = "TianShuManager";
    private static TianShuManager mInstance;
    private long mTimeDelay = 3000;
    private final ConcurrentHashMap<String, String> mTianshuTraceInfoCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, Long> mShowingAdId = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<TianShuReportData>> mReportList = new ConcurrentHashMap<>();
    private final AtomicBoolean mLockFlag = new AtomicBoolean(false);
    private Boolean mCanDestroyReport = null;
    private ConcurrentHashMap<Integer, TianShuGetAdvCallback> mCallbackHashMap = new ConcurrentHashMap<>();

    TianShuManager() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: cooperation.vip.tianshu.TianShuManager.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4);
                TianShuManager.this.mTimeDelay = sharedPreferences.getLong(TianShuManager.SP_TIME_DELAY_KEY, 3000L);
            }
        });
    }

    private void cacheNecessaryDataForReport(List<TianShuAccess.RspEntry> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<TianShuAccess.RspEntry> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().value.get().lst.get());
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                TianShuAccess.AdItem adItem = (TianShuAccess.AdItem) it5.next();
                VasC2SReporter.f().b(adItem);
                cacheTraceInfo(adItem);
            }
        }
    }

    private void cacheTraceInfo(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            return;
        }
        String valueOf = String.valueOf(adItem.iAdId.get());
        String str = adItem.traceinfo.get();
        if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mTianshuTraceInfoCache.put(valueOf, str);
        QLog.i(TAG, 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + valueOf + "---" + str);
    }

    private boolean checkRepEntryHasData(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry.value.lst.get(0) != null && rspEntry.value.lst.get(0).argList != null && rspEntry.value.lst.get(0).argList.get() != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TianShuAccess.AdPosItem convertAdItemToPb(TianShuAdPosItemData tianShuAdPosItemData) {
        TianShuAccess.AdPosItem adPosItem = new TianShuAccess.AdPosItem();
        adPosItem.posId.set(tianShuAdPosItemData.mPosId);
        adPosItem.nNeedCnt.set(tianShuAdPosItemData.mNeedCnt);
        HashMap<String, String> hashMap = tianShuAdPosItemData.mExtraData;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                TianShuAccess.MapEntry mapEntry = new TianShuAccess.MapEntry();
                mapEntry.key.set(String.valueOf(entry.getKey()));
                mapEntry.value.set(String.valueOf(entry.getValue()));
                adPosItem.extra_info.add(mapEntry);
            }
        }
        return adPosItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealShowingAd(TianShuAccess.GetAdsReq getAdsReq, int i3, boolean z16) {
        if (i3 == 0) {
            return;
        }
        TianShuAccess.ClientStatus clientStatus = new TianShuAccess.ClientStatus();
        TianShuAccess.MsgTabStatus msgTabStatus = new TianShuAccess.MsgTabStatus();
        msgTabStatus.scene.set(i3);
        msgTabStatus.IsContainerShowing.set(z16);
        clientStatus.stMsgTabStatus.set(msgTabStatus);
        getAdsReq.stClientStatus.set(clientStatus, true);
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<Integer, Long> entry : this.mShowingAdId.entrySet()) {
            TianShuAccess.MsgTabShowingAd msgTabShowingAd = new TianShuAccess.MsgTabShowingAd();
            msgTabShowingAd.first_show_ts.set(entry.getValue().longValue());
            msgTabShowingAd.ad_id.set(entry.getKey().intValue());
            getAdsReq.stClientStatus.stMsgTabStatus.showing_ads.add(msgTabShowingAd);
            sb5.append(entry.getValue() + " " + entry.getKey() + " ");
        }
        QLog.d(TAG, 1, "dealShowingAd show ads:" + ((Object) sb5));
    }

    private void doReport(Map<String, List<TianShuReportData>> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List<TianShuReportData>> entry : map.entrySet()) {
                List<TianShuReportData> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    TianShuReport.UserActionMultiReportReq userActionMultiReportReq = new TianShuReport.UserActionMultiReportReq();
                    NewIntent newIntent = new NewIntent(runtime.getApplication(), TianShuServlet.class);
                    userActionMultiReportReq.user_comm_report.set(k15.a.g(entry.getKey()));
                    Iterator<TianShuReportData> it = value.iterator();
                    while (it.hasNext()) {
                        userActionMultiReportReq.report_infos.add(k15.a.a(it.next()));
                    }
                    newIntent.putExtra("data", fh.b(userActionMultiReportReq.toByteArray()));
                    newIntent.putExtra("cmd", TianShuServlet.CMD_TIANSHU_REPORT);
                    runtime.startServlet(newIntent);
                }
            }
        }
    }

    private void enqueueReport(TianShuReportData tianShuReportData) {
        String account = getAccount();
        synchronized (this.mReportList) {
            List<TianShuReportData> list = this.mReportList.get(account);
            if (list == null) {
                list = new ArrayList<>();
                this.mReportList.put(account, list);
            }
            list.add(tianShuReportData);
        }
        if (this.mLockFlag.compareAndSet(false, true)) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: cooperation.vip.tianshu.TianShuManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TianShuManager.this.report();
                }
            }, this.mTimeDelay);
        }
        printReportLog(tianShuReportData);
    }

    private String getAccount() {
        return RFWApplication.getAccountId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TianShuAccess.CommInfo getCommInfo(String str, AppRuntime appRuntime) {
        TianShuAccess.CommInfo commInfo = new TianShuAccess.CommInfo();
        commInfo.lUin.set(appRuntime.getLongAccountUin());
        commInfo.strApp.set("sq");
        commInfo.strOs.set("and");
        commInfo.strDeviceInfo.set(String.valueOf(k15.a.c()));
        commInfo.strVersion.set(AppSetting.n());
        commInfo.iBid.set(AppSetting.f());
        commInfo.strCityCode.set(String.valueOf(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode()));
        commInfo.strQimei.set(String.valueOf(k15.a.d()));
        commInfo.strQua.set(String.valueOf(QUA.getQUA3()));
        int i3 = 1;
        commInfo.bLocationAuthorization.set(isLocationAuth(appRuntime.getApplicationContext(), !TextUtils.isEmpty(r1)));
        commInfo.traceId.set(str);
        commInfo.mode.set(getModeType());
        PBUInt32Field pBUInt32Field = commInfo.a11yMode;
        if (!AppSetting.f99565y) {
            i3 = 2;
        }
        pBUInt32Field.set(i3);
        return commInfo;
    }

    public static TianShuManager getInstance() {
        if (mInstance == null) {
            synchronized (TianShuManager.class) {
                if (mInstance == null) {
                    mInstance = new TianShuManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ByteStringMicro getMapPosTran(int i3) {
        byte[] decodeBytes = getTianShuMMKV().decodeBytes(getMapPosTranKey(i3), new byte[0]);
        if (decodeBytes.length == 0) {
            QLog.d(TAG, 4, "MapPosTran get: pos:", Integer.valueOf(i3), ", value is null");
            return null;
        }
        QLog.d(TAG, 4, "MapPosTran get: pos:", Integer.valueOf(i3), ", value is " + decodeBytes.length);
        return ByteStringMicro.copyFrom(decodeBytes);
    }

    private String getMapPosTranKey(int i3) {
        return getAccount() + "_map_pos_tran_" + i3;
    }

    private ByteStringMicro getMapPosTranValue(List<TianShuAccess.GetAdsEntry> list, int i3) {
        if (list.isEmpty()) {
            return null;
        }
        ListIterator<TianShuAccess.GetAdsEntry> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            TianShuAccess.GetAdsEntry next = listIterator.next();
            if (next.key.get() == i3) {
                return next.value.get();
            }
        }
        return null;
    }

    public static int getModeType() {
        if (SimpleUIUtil.isNowElderMode()) {
            return 4;
        }
        if (QQTheme.isNowSimpleUI()) {
            return 2;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return 3;
        }
        return 1;
    }

    private TianShuAccess.RspEntry getRspEntry(TianShuAccess.GetAdsRsp getAdsRsp, int i3) {
        if (!getAdsRsp.mapAds.has()) {
            return null;
        }
        for (TianShuAccess.RspEntry rspEntry : getAdsRsp.mapAds.get()) {
            if (rspEntry != null && rspEntry.key.has() && rspEntry.key.get() == i3) {
                return rspEntry;
            }
        }
        return null;
    }

    @Nullable
    public static MMKVOptionEntity getTianShuMMKV() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
    }

    private static boolean isLocationAuth(Context context, boolean z16) {
        boolean z17;
        boolean z18;
        if (context == null) {
            return false;
        }
        if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z17 && !z18) {
            return false;
        }
        return true;
    }

    public static boolean isRequestEnable(int i3) {
        boolean z16;
        long serverTime = NetConnInfoCenter.getServerTime();
        long decodeLong = getTianShuMMKV().decodeLong(KEY_VAS_NEXT_REQUEST_TIME + i3, 0L);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isRequestEnable :");
        if (serverTime > decodeLong) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" appid = ");
        sb5.append(i3);
        QLog.i(TAG, 1, sb5.toString());
        if (serverTime <= decodeLong) {
            return false;
        }
        return true;
    }

    private void markAdShowStatus(TianShuReportData tianShuReportData) {
        int i3 = tianShuReportData.mAdSpace;
        if (i3 == 0) {
            return;
        }
        int i16 = tianShuReportData.mActionId;
        if (i16 != 101) {
            if (i16 != 102) {
                if (i16 != 117) {
                    if (i16 != 118 && i16 != 122 && i16 != 133) {
                        switch (i16) {
                            case 137:
                            case 139:
                            case 141:
                                break;
                            case 138:
                            case 140:
                            case 142:
                                break;
                            default:
                                return;
                        }
                    }
                }
            }
            clearAdShowStatus(i3);
            return;
        }
        markAdShowStatus(i3);
    }

    private void printReportLog(TianShuReportData tianShuReportData) {
        if (tianShuReportData == null) {
            return;
        }
        QLog.d(TAG, 1, "printReportLog  reportData = " + tianShuReportData.toString());
    }

    private void saveMapPosTran(TianShuAccess.GetAdsRsp getAdsRsp, Intent intent) {
        if (intent == null) {
            return;
        }
        TianShuAccess.GetAdsReq getAdsReq = new TianShuAccess.GetAdsReq();
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        if (byteArrayExtra != null && byteArrayExtra.length != 0) {
            try {
                getAdsReq.mergeFrom(fh.a(byteArrayExtra));
                if (getAdsReq.lstPos.isEmpty()) {
                    return;
                }
                for (TianShuAccess.AdPosItem adPosItem : getAdsReq.lstPos.get()) {
                    ByteStringMicro mapPosTranValue = getMapPosTranValue(getAdsRsp.mapPosTran.get(), adPosItem.posId.get());
                    if (mapPosTranValue == null) {
                        QLog.d(TAG, 4, "MapPosTran save: pos:", Integer.valueOf(adPosItem.posId.get()), ", value is null");
                        getTianShuMMKV().encodeBytes(getMapPosTranKey(adPosItem.posId.get()), new byte[0]);
                    } else {
                        QLog.d(TAG, 4, "MapPosTran save: pos:", Integer.valueOf(adPosItem.posId.get()), ", value is " + mapPosTranValue.toByteArray().length);
                        getTianShuMMKV().encodeBytes(getMapPosTranKey(adPosItem.posId.get()), mapPosTranValue.toByteArray());
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "saveMapPosTran fail, e:", e16);
            }
        }
    }

    public static void saveNextRequestTime(final TianShuAccess.RspEntry rspEntry) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.tianshu.TianShuManager.5
            @Override // java.lang.Runnable
            public void run() {
                TianShuAccess.RspEntry rspEntry2 = TianShuAccess.RspEntry.this;
                if (rspEntry2 != null && rspEntry2.value.get() != null) {
                    TianShuAccess.AdPlacementInfo adPlacementInfo = TianShuAccess.RspEntry.this.value.get();
                    int i3 = TianShuAccess.RspEntry.this.key.get();
                    long j3 = adPlacementInfo.next_query_ts.get();
                    long serverTime = NetConnInfoCenter.getServerTime() + 86400;
                    if (j3 > serverTime) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(TianShuManager.TAG, 4, "saveNextRequestTime upper limit 24 :" + serverTime);
                        }
                        j3 = serverTime;
                    }
                    TianShuManager.getTianShuMMKV().encodeLong(TianShuManager.KEY_VAS_NEXT_REQUEST_TIME + i3, j3);
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TianShuManager.TAG, 4, "saveNextRequestTime appid = " + i3 + " nextRequestTime =  " + j3);
                    }
                }
            }
        }, 16, null, false);
    }

    private static void setLastClickAdId(TianShuReportData tianShuReportData) {
        if (tianShuReportData == null) {
            return;
        }
        int i3 = tianShuReportData.mActionId;
        if (i3 == 102 || i3 == 118 || i3 == 123 || i3 == 124 || i3 == 125 || i3 == 134 || i3 == 138 || i3 == 140 || i3 == 142) {
            String str = tianShuReportData.mTriggerInfo;
            if (TextUtils.isEmpty(str)) {
                str = getInstance().getTraceInfoFromCache(tianShuReportData.mItemId);
            }
            setLastClickAdTraceInfo(tianShuReportData.mItemId, str);
        }
    }

    public static void setLastClickAdTraceInfo(String str, final String str2) {
        final AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.w(TAG, 1, "setLastClickAdTraceInfo error, appRuntime is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "adId:" + str + " traceInfo:" + str2);
        }
        final String str3 = "{}";
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adId", str);
                jSONObject.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, str2);
                str3 = jSONObject.toString();
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "setLastClickAdTraceInfo error," + e16);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.tianshu.TianShuManager.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(TianShuManager.TAG, 1, "setTraceInfoOfLastClick in sub thread :" + str2);
                ((IVasService) runtime.getRuntimeService(IVasService.class, "all")).getTianshuWebManager().setTraceInfoOfLastClick(str3);
            }
        }, 16, null, true);
    }

    private void updateReportDelayTime(int i3) {
        if (i3 > 0) {
            this.mTimeDelay = i3 * 1000;
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).edit();
            edit.putLong(SP_TIME_DELAY_KEY, this.mTimeDelay);
            edit.apply();
        }
    }

    public void clearAdShowStatus(int i3) {
        this.mShowingAdId.remove(Integer.valueOf(i3));
    }

    public void clearNecessaryDataCacheForReport() {
        this.mTianshuTraceInfoCache.clear();
        VasC2SReporter.f().c();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "do clearNecessaryDataCacheForReport");
        }
    }

    public String getTraceInfoFromCache(String str) {
        if (!TextUtils.isEmpty(str) && this.mTianshuTraceInfoCache.containsKey(str)) {
            return this.mTianshuTraceInfoCache.get(str);
        }
        return "";
    }

    public void onAccountChanged() {
        this.mShowingAdId.clear();
    }

    public void onDestroy() {
        if (this.mCanDestroyReport == null) {
            this.mCanDestroyReport = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_can_destroy_report", true));
        }
        if (!this.mReportList.isEmpty() && this.mCanDestroyReport.booleanValue()) {
            report();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGetTianShuAdvRsp(Intent intent, FromServiceMsg fromServiceMsg) {
        TianShuGetAdvCallback tianShuGetAdvCallback;
        int resultCode;
        byte[] bArr = null;
        if (intent != null) {
            int intExtra = intent.getIntExtra("requestKey", -1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "onGetTianShuAdvRsp , callbackKey = " + intExtra);
            }
            if (this.mCallbackHashMap.get(Integer.valueOf(intExtra)) != null) {
                tianShuGetAdvCallback = this.mCallbackHashMap.get(Integer.valueOf(intExtra));
                if (tianShuGetAdvCallback != null) {
                    QLog.i(TAG, 1, "onGetTianShuAdvRsp, remove callback = " + tianShuGetAdvCallback.toString());
                } else {
                    tianShuGetAdvCallback = null;
                }
                this.mCallbackHashMap.remove(Integer.valueOf(intExtra));
                if (fromServiceMsg.isSuccess()) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    bArr = bArr2;
                }
                TianShuAccess.GetAdsRsp getAdsRsp = new TianShuAccess.GetAdsRsp();
                resultCode = fromServiceMsg.getResultCode();
                if (resultCode != 1000) {
                    try {
                        getAdsRsp.mergeFrom(bArr);
                        int i3 = getAdsRsp.code.get();
                        if (i3 == 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onReceive success " + i3);
                            }
                            if (tianShuGetAdvCallback != null) {
                                tianShuGetAdvCallback.onGetAdvs(true, getAdsRsp);
                            } else {
                                QLog.e(TAG, 1, "callback == null");
                            }
                            if (!getAdsRsp.mapAds.isEmpty()) {
                                cacheNecessaryDataForReport(getAdsRsp.mapAds.get());
                            }
                            saveMapPosTran(getAdsRsp, intent);
                            return;
                        }
                        QLog.d(TAG, 2, "onReceive ret " + i3);
                        if (tianShuGetAdvCallback != null) {
                            tianShuGetAdvCallback.onGetAdvs(false, getAdsRsp);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e(TAG, 2, "onReceive exception " + e16);
                        if (tianShuGetAdvCallback != null) {
                            tianShuGetAdvCallback.onGetAdvs(false, getAdsRsp);
                            return;
                        }
                        return;
                    }
                }
                QLog.e(TAG, 2, "onReceive result fail with result " + resultCode);
                if (tianShuGetAdvCallback != null) {
                    tianShuGetAdvCallback.onGetAdvs(false, getAdsRsp);
                    return;
                }
                return;
            }
        }
        tianShuGetAdvCallback = null;
        if (fromServiceMsg.isSuccess()) {
        }
        TianShuAccess.GetAdsRsp getAdsRsp2 = new TianShuAccess.GetAdsRsp();
        resultCode = fromServiceMsg.getResultCode();
        if (resultCode != 1000) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTianShuReport(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        TianShuReport.UserActionMultiReportRsp userActionMultiReportRsp = new TianShuReport.UserActionMultiReportRsp();
        int resultCode = fromServiceMsg.getResultCode();
        if (resultCode == 1000) {
            try {
                userActionMultiReportRsp.mergeFrom(bArr);
                int i3 = userActionMultiReportRsp.err_code.get();
                if (i3 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive ret " + i3);
                    }
                    updateReportDelayTime(userActionMultiReportRsp.multi_duration.get());
                    return;
                }
                QLog.d(TAG, 2, "onReceive ret " + i3);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 2, "onReceive exception " + e16);
                return;
            }
        }
        QLog.e(TAG, 2, "onReceive result fail with result " + resultCode);
    }

    public Map parseGetAdsRsp(TianShuAccess.GetAdsRsp getAdsRsp, int i3) {
        TianShuAccess.RspEntry rspEntry = getRspEntry(getAdsRsp, i3);
        HashMap hashMap = new HashMap();
        if (checkRepEntryHasData(rspEntry)) {
            return hashMap;
        }
        for (TianShuAccess.MapEntry mapEntry : rspEntry.value.lst.get(0).argList.get()) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public void removeAdvCallback(TianShuGetAdvCallback tianShuGetAdvCallback) {
        if (this.mCallbackHashMap != null && tianShuGetAdvCallback != null) {
            int hashCode = tianShuGetAdvCallback.hashCode();
            this.mCallbackHashMap.remove(Integer.valueOf(hashCode));
            QLog.i(TAG, 1, "removeAdvCallback  | key = " + hashCode + " | remove callback =  " + tianShuGetAdvCallback.toString());
        }
    }

    public void report(TianShuReportData tianShuReportData) {
        if (tianShuReportData == null) {
            return;
        }
        markAdShowStatus(tianShuReportData);
        enqueueReport(tianShuReportData);
        setLastClickAdId(tianShuReportData);
        if (tianShuReportData.mNeedReportCachedUrl) {
            VasC2SReporter.f().h(tianShuReportData);
        }
    }

    public void requestAdv(List<TianShuAdPosItemData> list, TianShuGetAdvCallback tianShuGetAdvCallback) {
        requestAdv(list, tianShuGetAdvCallback, 0, false);
    }

    public void requestAdv(final List<TianShuAdPosItemData> list, final TianShuGetAdvCallback tianShuGetAdvCallback, final int i3, final boolean z16) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: cooperation.vip.tianshu.TianShuManager.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List list2 = list;
                if (list2 != null && list2.size() > 0 && tianShuGetAdvCallback != null) {
                    BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                    AppRuntime runtime = application.getRuntime();
                    if (runtime == null) {
                        runtime = application.peekAppRuntime();
                    }
                    if (runtime == null) {
                        QLog.i(TianShuManager.TAG, 1, "requestAdv , get null appRuntime , requestAdv cancel");
                        return;
                    }
                    List<TianShuAdPosItemData> a16 = com.tencent.mobileqq.tianshu.ad.a.f293021a.a(list);
                    if (a16 != null && !a16.isEmpty()) {
                        int hashCode = tianShuGetAdvCallback.hashCode();
                        TianShuManager.this.mCallbackHashMap.put(Integer.valueOf(hashCode), tianShuGetAdvCallback);
                        TianShuAccess.GetAdsReq getAdsReq = new TianShuAccess.GetAdsReq();
                        TianShuManager.this.dealShowingAd(getAdsReq, i3, z16);
                        String str2 = runtime.getAccount() + "_" + System.currentTimeMillis() + "_" + ((int) (Math.random() * 100.0d));
                        getAdsReq.stComminfo.set(TianShuManager.getCommInfo(str2, runtime));
                        StringBuilder sb5 = new StringBuilder();
                        for (TianShuAdPosItemData tianShuAdPosItemData : a16) {
                            getAdsReq.lstPos.add(TianShuManager.convertAdItemToPb(tianShuAdPosItemData));
                            ByteStringMicro mapPosTran = TianShuManager.this.getMapPosTran(tianShuAdPosItemData.mPosId);
                            sb5.append(",");
                            sb5.append(tianShuAdPosItemData.mPosId);
                            if (mapPosTran != null) {
                                TianShuAccess.GetAdsEntry getAdsEntry = new TianShuAccess.GetAdsEntry();
                                getAdsEntry.key.set(tianShuAdPosItemData.mPosId);
                                getAdsEntry.value.set(mapPosTran);
                                getAdsReq.mapPosTran.add(getAdsEntry);
                            }
                        }
                        TianShuGetAdvCallback tianShuGetAdvCallback2 = tianShuGetAdvCallback;
                        if (tianShuGetAdvCallback2 instanceof com.tencent.mobileqq.tianshu.data.a) {
                            ((com.tencent.mobileqq.tianshu.data.a) tianShuGetAdvCallback2).f293074d = str2;
                        }
                        NewIntent newIntent = new NewIntent(runtime.getApplication(), TianShuServlet.class);
                        newIntent.putExtra("data", fh.b(getAdsReq.toByteArray()));
                        newIntent.putExtra("cmd", TianShuServlet.CMD_TIANSHU_GETADS);
                        newIntent.putExtra("requestKey", hashCode);
                        runtime.startServlet(newIntent);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("requestAdv  | time = ");
                        sb6.append(i3);
                        sb6.append(" | traceId = ");
                        TianShuAccess.CommInfo commInfo = getAdsReq.stComminfo;
                        if (commInfo != null) {
                            str = commInfo.traceId.get();
                        } else {
                            str = null;
                        }
                        sb6.append(str);
                        sb6.append(" | adblist = ");
                        sb6.append((Object) sb5);
                        sb6.append(" | key = ");
                        sb6.append(hashCode);
                        sb6.append(" | IsContainerShowing = ");
                        sb6.append(z16);
                        sb6.append(" | put callback = ");
                        sb6.append(tianShuGetAdvCallback.toString());
                        QLog.i(TianShuManager.TAG, 1, sb6.toString());
                        return;
                    }
                    QLog.i(TianShuManager.TAG, 1, "requestAdv fail, all in black list");
                    tianShuGetAdvCallback.onGetAdvs(false, new TianShuAccess.GetAdsRsp());
                    return;
                }
                QLog.e(TianShuManager.TAG, 1, "requestAdv advList is empty or callback == null");
            }
        });
    }

    public void markAdShowStatus(int i3) {
        this.mShowingAdId.put(Integer.valueOf(i3), Long.valueOf(NetConnInfoCenter.getServerTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report() {
        HashMap hashMap;
        synchronized (this.mReportList) {
            hashMap = new HashMap(this.mReportList);
            this.mReportList.clear();
            this.mLockFlag.set(false);
        }
        doReport(hashMap);
    }

    public void cacheTraceInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String d16 = PublicAccountEventReport.d(str);
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        this.mTianshuTraceInfoCache.put(d16, str);
        QLog.i(TAG, 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + d16 + "---" + str);
    }
}
