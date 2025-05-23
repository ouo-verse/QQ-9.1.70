package com.qzone.app;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.medal_banner;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.stMomentInfo;
import NS_UNDEAL_COUNT.yellow_info;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.Observable;
import com.qzone.feed.business.protocol.QZoneGetUndealCountRequest;
import com.qzone.proxy.feedcomponent.model.MedalBannerInfo;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.reborn.qzmoment.comment.event.QZoneFeedUnreadUpdateEvent;
import com.qzone.util.ac;
import com.qzone.util.al;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneClearRedCountInfoEvent;
import com.tencent.mobileqq.service.qzone.QZonePlusSignInfoManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneLogTags;
import cooperation.vip.vipcomponent.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedAlertService extends Observable implements IQZoneServiceListener {
    private static final String KEY_PASSIVE_PUSH_SKIN = "PassiveFeedsPush";
    public static final int TASK_TYPE_FEED_ALERT = 1;
    private boolean hasLoadUnread;
    private ArrayList<entrance_cfg> navigatorEntryList;
    public ConcurrentHashMap<Integer, QZoneCountInfo> stMapCountInfo;
    private BroadcastReceiver vipInfoFromQQReceiver;
    public static String TAG = QZoneLogTags.LOG_TAG_FEEDALERT + QZoneFeedAlertService.class.getSimpleName();
    public static int CONTROL_SHOW_NUM = 1;
    public static int CONTROL_SHOW_DOT = 2;
    public static int CONTROL_SHOW_NEW = 4;
    public static boolean TEST_FEED_ALERT_FLAG = false;
    private static final al<QZoneFeedAlertService, Void> sSingleton = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneFeedAlertService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneFeedAlertService a(Void r16) {
            return new QZoneFeedAlertService();
        }
    }

    QZoneFeedAlertService() {
        this("UnRead");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteUnreadCount(int i3) {
        try {
            py3.b.e(BaseApplicationImpl.getApplication().getContentResolver(), com.tencent.common.config.provider.d.E3, "own_uin=? AND type=?", new String[]{LoginData.getInstance().getUinString(), String.valueOf(i3)});
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public static QZoneFeedAlertService getInstance() {
        return sSingleton.get(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUnreadFromDB() {
        QLog.d(TAG, 1, "loadUnreadFromDB");
        Cursor cursor = null;
        try {
            try {
                String uinString = LoginData.getInstance().getUinString();
                if (this.stMapCountInfo == null) {
                    this.stMapCountInfo = new ConcurrentHashMap<>();
                }
                cursor = ContactsMonitor.query(BaseApplicationImpl.getApplication().getContentResolver(), com.tencent.common.config.provider.d.E3, null, "own_uin=?", new String[]{uinString}, null);
                HashMap<Integer, QZoneCountInfo> createFromCursor = QZoneCountInfo.createFromCursor(cursor);
                this.stMapCountInfo.clear();
                if (createFromCursor != null) {
                    this.stMapCountInfo.putAll(createFromCursor);
                } else {
                    QZLog.w(TAG, "[loadUnreadFromDB()] QZoneCountInfo.createFromCursor(cursor) return null!!");
                }
                this.hasLoadUnread = true;
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } catch (Exception e16) {
                this.hasLoadUnread = false;
                QZLog.e(QZLog.TO_DEVICE_TAG, "", e16);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th5) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th5;
        }
    }

    private void saveFeedCount2DB() {
        try {
            ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.stMapCountInfo;
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return;
            }
            QZoneCountInfo[] qZoneCountInfoArr = (QZoneCountInfo[]) this.stMapCountInfo.values().toArray(new QZoneCountInfo[this.stMapCountInfo.size()]);
            Integer[] numArr = (Integer[]) this.stMapCountInfo.keySet().toArray(new Integer[this.stMapCountInfo.size()]);
            ContentValues[] contentValuesArr = new ContentValues[qZoneCountInfoArr.length];
            String uinString = LoginData.getInstance().getUinString();
            for (int i3 = 0; i3 < qZoneCountInfoArr.length; i3++) {
                if (uinString != null && uinString.length() > 0) {
                    ContentValues convertToContentValues = qZoneCountInfoArr[i3].convertToContentValues();
                    contentValuesArr[i3] = convertToContentValues;
                    convertToContentValues.put("own_uin", uinString);
                    contentValuesArr[i3].put("type", numArr[i3]);
                }
            }
            BaseApplicationImpl.getApplication().getContentResolver().bulkInsert(com.tencent.common.config.provider.d.E3, contentValuesArr);
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
        }
    }

    private void saveQzoneCountInfo(int i3, QZoneCountInfo qZoneCountInfo) {
        ContentValues convertToContentValues = qZoneCountInfo.convertToContentValues();
        convertToContentValues.put("own_uin", LoginData.getInstance().getUinString());
        convertToContentValues.put("type", Integer.valueOf(i3));
        try {
            BaseApplicationImpl.getApplication().getContentResolver().insert(com.tencent.common.config.provider.d.E3, convertToContentValues);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public void clearAllNavigatorConfigs() {
        ArrayList<entrance_cfg> arrayList = this.navigatorEntryList;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.navigatorEntryList.clear();
    }

    public void ensureLoadUnread() {
        if (this.hasLoadUnread) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneFeedAlertService.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.this.loadUnreadFromDB();
                Bundle bundle = new Bundle();
                bundle.putString("com.tencent.qq.syncQZoneUnreadAction", "syncQZoneUnreadActionChange");
                QZoneFeedAlertService.this.notify(1, bundle);
            }
        });
    }

    public int getPushCount(int i3) {
        long uin = LoginData.getInstance().getUin();
        int int4Uin = uin > 0 ? LocalMultiProcConfig.getInt4Uin("mine_message_count", 0, uin) : 0;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPushCount type:" + i3 + ",count" + int4Uin);
        }
        return int4Uin;
    }

    public int getQZonePassiveUnreadTotal() {
        int max = Math.max(0, getInstance().getSingleUnreadCount(1));
        int max2 = Math.max(0, getInstance().getSingleUnreadCount(73));
        if (max2 > 0) {
            com.qzone.reborn.configx.g.f53821a.h().H();
        }
        return max + max2;
    }

    public ArrayList<QZoneCountUserInfo> getQZonePassiveUnreadUserList() {
        ArrayList<QZoneCountUserInfo> arrayList;
        ArrayList<QZoneCountUserInfo> arrayList2;
        ArrayList<QZoneCountUserInfo> arrayList3 = new ArrayList<>();
        QZoneCountInfo singleUnReadItem = getInstance().getSingleUnReadItem(1);
        if (singleUnReadItem != null && (arrayList2 = singleUnReadItem.friendList) != null) {
            arrayList3.addAll(arrayList2);
        }
        QZoneCountInfo singleUnReadItem2 = getInstance().getSingleUnReadItem(73);
        if (singleUnReadItem2 != null && (arrayList = singleUnReadItem2.friendList) != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public synchronized void loadNavigatorEntryListFromDB() {
        com.tencent.common.config.provider.b.d(LoginData.getInstance().getUinString(), this.navigatorEntryList);
        ArrayList<entrance_cfg> arrayList = this.navigatorEntryList;
        if (arrayList == null || arrayList.size() == 0) {
            getFeedAlert(null, 1);
        }
    }

    public ArrayList<entrance_cfg> loadNavigatorEntryListFromMem(int i3) {
        ArrayList<entrance_cfg> arrayList = this.navigatorEntryList;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        entrance_cfg[] entrance_cfgVarArr = (entrance_cfg[]) this.navigatorEntryList.toArray(new entrance_cfg[this.navigatorEntryList.size()]);
        ArrayList<entrance_cfg> arrayList2 = new ArrayList<>();
        for (entrance_cfg entrance_cfgVar : entrance_cfgVarArr) {
            if (entrance_cfgVar != null && entrance_cfgVar.tabid == i3) {
                arrayList2.add(entrance_cfgVar);
            }
        }
        return arrayList2;
    }

    public void onGetFeedAlertResponse(QZoneTask qZoneTask) {
        try {
            QZoneResult result = qZoneTask.getResult(1000041);
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "onGetFeedAlertResponse task.succeeded: " + qZoneTask.succeeded() + " result code: " + qZoneTask.mResultCode);
            }
            if (qZoneTask.succeeded()) {
                JceStruct jceStruct = qZoneTask.mRequest.rsp;
                if (jceStruct == null) {
                    result.setSucceed(false);
                    qZoneTask.sendResultMsg(result);
                    QZLog.w("exception", "onGetFeedAlertResponse failed rsp is null");
                    return;
                }
                if (!(jceStruct instanceof mobile_count_rsp_new)) {
                    result.setSucceed(false);
                    qZoneTask.sendResultMsg(result);
                    QZLog.w("exception", "onGetFeedAlertResponse failed rsp is not mobile_count_rsp_new object");
                    return;
                }
                mobile_count_rsp_new mobile_count_rsp_newVar = (mobile_count_rsp_new) jceStruct;
                if (mobile_count_rsp_newVar != null) {
                    QZoneUnreadServletLogic.B(mobile_count_rsp_newVar, LoginData.getInstance().getUinString());
                    for (int i3 = 0; i3 < 1029; i3++) {
                        updateSigleCount(mobile_count_rsp_newVar, i3);
                    }
                    saveFeedCount2DB();
                    updateActiveBannerData(mobile_count_rsp_newVar, result);
                    handleNavigator(mobile_count_rsp_newVar);
                    handleQZoneFeatureSwitchInfo(mobile_count_rsp_newVar);
                    handleQZoneMomentInfo(mobile_count_rsp_newVar);
                    handlePlusMenuSignInfo(mobile_count_rsp_newVar);
                    handleMomentRedCountInfo(mobile_count_rsp_newVar);
                    medal_banner medal_bannerVar = mobile_count_rsp_newVar.stMedalBanner;
                    if (medal_bannerVar != null) {
                        result.setMedalBannerData(new MedalBannerInfo(medal_bannerVar));
                    }
                    result.getBundle().putInt(QZoneResult.KEY_SHOW_BANNER, mobile_count_rsp_newVar.isShowNewFeedBanner);
                    QZoneUnreadServletLogic.g0(LoginData.getInstance().getUinString(), mobile_count_rsp_newVar.extendinfo);
                    QZoneUnreadServletLogic.j0(mobile_count_rsp_newVar.mapLastGetTime, Long.valueOf(LoginData.getInstance().getUin()));
                    QZoneUnreadServletLogic.y(mobile_count_rsp_newVar);
                    QZoneUnreadServletLogic.L(mobile_count_rsp_newVar);
                    QZoneUnreadServletLogic.M(mobile_count_rsp_newVar, LoginData.getInstance().getUin());
                    QZoneUnreadServletLogic.x(mobile_count_rsp_newVar.cancellation_status, LoginData.getInstance().getUin());
                    QZoneUnreadServletLogic.R(mobile_count_rsp_newVar.isTeenagerModelActFeedRestriction, LoginData.getInstance().getUin());
                    int i16 = mobile_count_rsp_newVar.iNextTimeout;
                    if (i16 != 0) {
                        if (TEST_FEED_ALERT_FLAG) {
                            QZoneConfigHelper.f390035a = 180000;
                        } else {
                            QZoneConfigHelper.f390035a = i16 * 1000;
                            if (QZLog.isColorLevel()) {
                                QZLog.d("FeedAlert", 2, TAG + "respone.iNextTimeout*1000 " + (mobile_count_rsp_newVar.iNextTimeout * 1000));
                            }
                        }
                    }
                    qZoneTask.sendResultMsg(result);
                    putMask(mobile_count_rsp_newVar.grayOperateMask);
                    return;
                }
                result.setSucceed(false);
                result.setMessage(qZoneTask.f45835msg);
                qZoneTask.sendResultMsg(result);
                return;
            }
            QZLog.w(QZLog.TO_DEVICE_TAG, TAG + "onGetFeedAlertResponse failed: " + qZoneTask.mResultCode);
            result.setSucceed(false);
            result.setMessage(qZoneTask.f45835msg);
            qZoneTask.sendResultMsg(result);
        } catch (Exception e16) {
            QZLog.w(QZLog.TO_DEVICE_TAG, e16.toString());
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1) {
            return;
        }
        onGetFeedAlertResponse(qZoneTask);
    }

    public void putMask(int i3) {
        LocalMultiProcConfig.putInt4Uin("qzone_feed_gray_mask", i3, LoginData.getInstance().getUin());
    }

    public void registerVipInfoBocastReveiver() {
        if (this.vipInfoFromQQReceiver == null) {
            this.vipInfoFromQQReceiver = new BroadcastReceiver() { // from class: com.qzone.app.QZoneFeedAlertService.5
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, final Intent intent) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneFeedAlertService.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QZLog.isColorLevel()) {
                                QZLog.d(QZoneFeedAlertService.TAG, 2, "receive BROADCAST_SYNC_QZONE_VIP_INFO_ACTION");
                            }
                            Intent intent2 = intent;
                            if (intent2 != null) {
                                int i3 = intent2.getExtras().getInt("com.tencent.qq.syncQzoneVipInfoStr", 0);
                                if (QZLog.isColorLevel()) {
                                    QZLog.d(QZoneFeedAlertService.TAG, 2, "vip str = " + i3);
                                }
                                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                                vipComponentProxy.getServiceInterface().updateVipInfo(LoginData.getInstance().getUinString(), i3, vipComponentProxy.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString()).getPersonalizedYellowVipUrl());
                                EventCenter.getInstance().post(a.C10129a.f391398a, 11);
                            }
                        }
                    });
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qq.syncQzoneVipInfoAction");
        BaseApplication.getContext().registerReceiver(this.vipInfoFromQQReceiver, intentFilter);
    }

    public void setPushCount(int i3, int i16) {
        long uin = LoginData.getInstance().getUin();
        if (uin > 0) {
            LocalMultiProcConfig.putInt4Uin("mine_message_count", i16, uin);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setPushCount type:" + i3 + ",count" + i16);
        }
    }

    public void setUnreadCount(int i3, long j3, int i16, ArrayList<QZoneCountUserInfo> arrayList, String str, int i17, String str2) {
        try {
            QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
            qZoneCountInfo.uCount = j3;
            qZoneCountInfo.friendList = arrayList;
            qZoneCountInfo.iControl = i16;
            qZoneCountInfo.totalFriendUnread = i17;
            qZoneCountInfo.pushMesssage = str;
            qZoneCountInfo.trace_info = str2;
            setUnreadCount(i3, qZoneCountInfo);
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
        }
    }

    public void unRegisterVipInfoBocastReveiver() {
        BaseApplication.getContext().unregisterReceiver(this.vipInfoFromQQReceiver);
    }

    QZoneFeedAlertService(String str) {
        super(str);
        this.stMapCountInfo = new ConcurrentHashMap<>();
        this.hasLoadUnread = false;
        this.navigatorEntryList = new ArrayList<>();
        TAG = getClass().getSimpleName();
        try {
            BaseApplicationImpl.getApplication().getContentResolver().registerContentObserver(com.tencent.common.config.provider.d.E3, true, new ContentObserver(new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread))) { // from class: com.qzone.app.QZoneFeedAlertService.2
                @Override // android.database.ContentObserver
                public void onChange(boolean z16) {
                    super.onChange(z16);
                    QZoneFeedAlertService.this.loadUnreadFromDB();
                    Bundle bundle = new Bundle();
                    bundle.putString("com.tencent.qq.syncQZoneUnreadAction", "syncQZoneUnreadActionChange");
                    QZoneFeedAlertService.this.notify(1, bundle);
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.app.QZoneFeedAlertService.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedUnreadUpdateEvent());
                        }
                    });
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + QZoneFeedAlertService.TAG, 2, "onChange notify Observer");
                    }
                }
            });
        } catch (Exception e16) {
            QZLog.e(TAG, "registerContentObserver error", e16);
        }
    }

    public QZoneCountInfo getSingleUnReadItem(int i3) {
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap;
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getSingleUnReadItem type :" + i3);
            }
            if (i3 <= 0 || i3 >= 1029 || (concurrentHashMap = this.stMapCountInfo) == null) {
                return null;
            }
            return concurrentHashMap.get(Integer.valueOf(i3));
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
            return null;
        }
    }

    public int getSingleUnreadCount(int i3) {
        QZoneCountInfo qZoneCountInfo;
        try {
            ensureLoadUnread();
            if (i3 > 0 && i3 < 1029) {
                ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.stMapCountInfo;
                int i16 = (concurrentHashMap == null || (qZoneCountInfo = concurrentHashMap.get(Integer.valueOf(i3))) == null) ? -1 : (int) qZoneCountInfo.uCount;
                if (QLog.isColorLevel() && i16 > 0) {
                    QLog.d(TAG, 2, "getSingleUnreadCount type: " + i3 + ", unReadCount: " + i16);
                }
                return i16;
            }
            return -1;
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
            return -1;
        }
    }

    public void onAccountChange() {
        this.hasLoadUnread = false;
        ensureLoadUnread();
    }

    public boolean setSingleUnReadItem(int i3, QZoneCountInfo qZoneCountInfo) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setSingleUnReadItem type :" + i3);
            }
            if (i3 <= 0 || i3 >= 1029 || qZoneCountInfo == null) {
                return false;
            }
            if (this.stMapCountInfo == null) {
                this.stMapCountInfo = new ConcurrentHashMap<>();
            }
            this.stMapCountInfo.put(Integer.valueOf(i3), qZoneCountInfo);
            saveFeedCount2DB();
            return true;
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
            return false;
        }
    }

    private void handleMomentRedCountInfo(mobile_count_rsp_new mobile_count_rsp_newVar) {
        Map<Integer, count_info> map;
        if (mobile_count_rsp_newVar == null || (map = mobile_count_rsp_newVar.stMapCountInfo) == null) {
            return;
        }
        if (!map.containsKey(67)) {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(67));
            clearSingleUnreadCount(67);
        }
        if (mobile_count_rsp_newVar.stMapCountInfo.containsKey(68)) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(68));
        clearSingleUnreadCount(68);
    }

    private void handleNavigator(mobile_count_rsp_new mobile_count_rsp_newVar) {
        Map<Integer, ArrayList<entrance_cfg>> map;
        ArrayList<entrance_cfg> arrayList;
        if (mobile_count_rsp_newVar == null || (map = mobile_count_rsp_newVar.mapEntranceCfg) == null || (arrayList = map.get(2)) == null || arrayList.size() == 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleNavigatorBarInfo rsp entracesize is:" + arrayList.size());
        }
        com.tencent.common.config.provider.b.h(LoginData.getInstance().getUinString(), arrayList);
    }

    public void cleanNewGameCount() {
        clearSingleUnreadCount(12);
    }

    public void cleanWeiShiCount() {
        clearSingleUnreadCount(48);
    }

    public void getFeedAlert(Handler handler, int i3) {
        List<Integer> list;
        int i16;
        int i17;
        feed_host_info feed_host_infoVar;
        QZoneFeedAlertService qZoneFeedAlertService = this;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap2 = qZoneFeedAlertService.stMapCountInfo;
        if (concurrentHashMap2 != null) {
            List<Integer> t16 = QZoneUnreadServletLogic.t(concurrentHashMap2);
            int size = t16.size();
            int i18 = 0;
            int i19 = 0;
            while (i19 < size) {
                int intValue = t16.get(i19).intValue();
                QZoneCountInfo qZoneCountInfo = qZoneFeedAlertService.stMapCountInfo.get(Integer.valueOf(intValue));
                if (qZoneCountInfo != null) {
                    single_count single_countVar = new single_count(qZoneCountInfo.uCount, (byte) qZoneCountInfo.iControl);
                    ArrayList arrayList = new ArrayList();
                    ArrayList<QZoneCountUserInfo> arrayList2 = qZoneCountInfo.friendList;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        QZoneCountUserInfo qZoneCountUserInfo = qZoneCountInfo.friendList.get(i18);
                        if (qZoneCountUserInfo != null) {
                            feed_host_infoVar = new feed_host_info(qZoneCountUserInfo.uin, "", qZoneCountInfo.friendMsg, null, null, null);
                        }
                    } else {
                        feed_host_infoVar = new feed_host_info(0L, "", qZoneCountInfo.friendMsg, null, null, null);
                    }
                    arrayList.add(feed_host_infoVar);
                    i17 = i19;
                    list = t16;
                    i16 = size;
                    concurrentHashMap = concurrentHashMap;
                    concurrentHashMap.put(Integer.valueOf(intValue), new count_info(single_countVar, arrayList, qZoneCountInfo.trace_info, qZoneCountInfo.countId, qZoneCountInfo.iconUrl, qZoneCountInfo.strShowMsg, qZoneCountInfo.reportValue, qZoneCountInfo.cTime, qZoneCountInfo.iShowLevel, qZoneCountInfo.actPageAttach, qZoneCountInfo.tianshuTrans, qZoneCountInfo.expireTime, qZoneCountInfo.ext));
                    i19 = i17 + 1;
                    i18 = 0;
                    qZoneFeedAlertService = this;
                    t16 = list;
                    size = i16;
                }
                list = t16;
                i16 = size;
                i17 = i19;
                i19 = i17 + 1;
                i18 = 0;
                qZoneFeedAlertService = this;
                t16 = list;
                size = i16;
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetUndealCountRequest(concurrentHashMap, LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", LoginData.getInstance().getUin()), i3), handler, this, 1));
        }
    }

    private static void handlePlusMenuSignInfo(mobile_count_rsp_new mobile_count_rsp_newVar) {
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        QZonePlusSignInfoManager.d(mobile_count_rsp_newVar, LoginData.getInstance().getUinString());
    }

    private static void handleQZoneFeatureSwitchInfo(mobile_count_rsp_new mobile_count_rsp_newVar) {
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        Map<Integer, Boolean> map = mobile_count_rsp_newVar.featureSwitch;
        if (map != null && !map.isEmpty()) {
            ac.a(mobile_count_rsp_newVar.featureSwitch, LoginData.getInstance().getUinString());
        } else {
            QLog.d(TAG, 2, "qzone feature switch map is null or empty");
        }
    }

    private static void handleQZoneMomentInfo(mobile_count_rsp_new mobile_count_rsp_newVar) {
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        stMomentInfo stmomentinfo = mobile_count_rsp_newVar.momentInfo;
        if (stmomentinfo == null) {
            QLog.e(TAG, 2, "qzone moment info is null");
        } else {
            com.tencent.mobileqq.service.qzone.b.m(stmomentinfo, LoginData.getInstance().getUinString());
        }
    }

    private void updateActiveBannerData(mobile_count_rsp_new mobile_count_rsp_newVar, QZoneResult qZoneResult) {
        count_info count_infoVar;
        ArrayList<feed_host_info> arrayList;
        single_count single_countVar;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        byte[] bArr;
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        try {
            Map<Integer, count_info> map = mobile_count_rsp_newVar.stMapCountInfo;
            if (map == null || map.size() == 0 || (count_infoVar = mobile_count_rsp_newVar.stMapCountInfo.get(2)) == null || (arrayList = count_infoVar.vecUinList) == null || arrayList.size() == 0 || (single_countVar = count_infoVar.stCount) == null || single_countVar.uCount == 0) {
                return;
            }
            Map<String, byte[]> map2 = mobile_count_rsp_newVar.mapTransData;
            PassiveFeedsPush passiveFeedsPush = (map2 == null || (bArr = map2.get(KEY_PASSIVE_PUSH_SKIN)) == null) ? null : (PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, bArr);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < count_infoVar.vecUinList.size(); i3++) {
                feed_host_info feed_host_infoVar = count_infoVar.vecUinList.get(i3);
                if (feed_host_infoVar != null) {
                    Long valueOf = Long.valueOf(feed_host_infoVar.uUin);
                    String str = feed_host_infoVar.nickname;
                    if (TextUtils.isEmpty(str)) {
                        str = Long.toString(valueOf.longValue());
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.d(TAG, 2, "unRead friend feeds uin: " + valueOf + "nickName: " + str);
                    }
                    QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
                    long longValue = valueOf.longValue();
                    qZoneCountUserInfo.uin = longValue;
                    yellow_info yellow_infoVar = feed_host_infoVar.OpuinYellowInfo;
                    if (yellow_infoVar != null) {
                        qZoneCountUserInfo.iYellowLevel = yellow_infoVar.iYellowLevel;
                        qZoneCountUserInfo.iYellowType = yellow_infoVar.iYellowType;
                        qZoneCountUserInfo.isAnnualVip = yellow_infoVar.isAnnualVip;
                        if (passiveFeedsPush != null && (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) != null && longValue == qzmallCustomBubbleSkin.lUin) {
                            qZoneCountUserInfo.pushData = passiveFeedsPush;
                        }
                    }
                    arrayList2.add(new Pair(qZoneCountUserInfo, str));
                }
            }
            qZoneResult.setData(arrayList2);
            qZoneResult.setSucceed(true);
            qZoneResult.setNewCnt(count_infoVar.stCount.uCount);
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "respone.stActiveInfo.stCount.uCount: " + count_infoVar.stCount.uCount + ",respone.jumpType:" + mobile_count_rsp_newVar.jumpType);
            }
            qZoneResult.setKeyJumptype(mobile_count_rsp_newVar.jumpType);
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
        }
    }

    public void clearSingleUnreadCount(final int i3) {
        if (i3 <= 0 || i3 >= 1029) {
            return;
        }
        try {
            if (this.stMapCountInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "clearSingleUnreadCount type :" + i3);
                }
                if (this.stMapCountInfo.containsKey(Integer.valueOf(i3))) {
                    QLog.d(TAG, 1, "clear count info key is " + i3);
                    xm.c.h(i3, this.stMapCountInfo.remove(Integer.valueOf(i3)));
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneFeedAlertService.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneFeedAlertService.this.deleteUnreadCount(i3);
                        }
                    });
                }
            }
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
        }
    }

    public boolean updateSigleCount(mobile_count_rsp_new mobile_count_rsp_newVar, int i3) {
        count_info count_infoVar;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        byte[] bArr;
        if (mobile_count_rsp_newVar == null) {
            return false;
        }
        try {
            Map<Integer, count_info> map = mobile_count_rsp_newVar.stMapCountInfo;
            if (map == null || map.size() == 0 || (count_infoVar = mobile_count_rsp_newVar.stMapCountInfo.get(Integer.valueOf(i3))) == null || count_infoVar.stCount == null) {
                return false;
            }
            QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
            single_count single_countVar = count_infoVar.stCount;
            qZoneCountInfo.uCount = single_countVar.uCount;
            qZoneCountInfo.iControl = single_countVar.iControl;
            ArrayList<QZoneCountUserInfo> arrayList = new ArrayList<>();
            QLog.d(TAG, 1, "response unread count id is " + i3 + " count is " + qZoneCountInfo.uCount + " message is " + qZoneCountInfo.strShowMsg);
            Map<String, byte[]> map2 = mobile_count_rsp_newVar.mapTransData;
            PassiveFeedsPush passiveFeedsPush = (map2 == null || (bArr = map2.get(KEY_PASSIVE_PUSH_SKIN)) == null) ? null : (PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, bArr);
            ArrayList<feed_host_info> arrayList2 = count_infoVar.vecUinList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                int size = count_infoVar.vecUinList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
                    qZoneCountUserInfo.uin = count_infoVar.vecUinList.get(i16).uUin;
                    if (count_infoVar.vecUinList.get(i16).OpuinYellowInfo != null) {
                        qZoneCountUserInfo.iYellowType = count_infoVar.vecUinList.get(i16).OpuinYellowInfo.iYellowType;
                        qZoneCountUserInfo.iYellowLevel = count_infoVar.vecUinList.get(i16).OpuinYellowInfo.iYellowLevel;
                        qZoneCountUserInfo.isAnnualVip = count_infoVar.vecUinList.get(i16).OpuinYellowInfo.isAnnualVip;
                        if (passiveFeedsPush != null && (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) != null && qZoneCountUserInfo.uin == qzmallCustomBubbleSkin.lUin) {
                            qZoneCountUserInfo.pushData = passiveFeedsPush;
                        }
                    }
                    arrayList.add(qZoneCountUserInfo);
                }
            }
            qZoneCountInfo.friendList = arrayList;
            qZoneCountInfo.countId = count_infoVar.iSubCountID;
            qZoneCountInfo.strShowMsg = count_infoVar.strShowMsg;
            qZoneCountInfo.reportValue = count_infoVar.strReportValue;
            qZoneCountInfo.iconUrl = count_infoVar.strIconUrl;
            qZoneCountInfo.cTime = count_infoVar.cTime;
            qZoneCountInfo.tianshuTrans = count_infoVar.tianshuTrans;
            qZoneCountInfo.expireTime = count_infoVar.expireTime;
            qZoneCountInfo.ext = count_infoVar.ext;
            if (((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).checkIsNeedToSingleDeleteCountInfo(qZoneCountInfo, i3)) {
                return false;
            }
            try {
                setUnreadCount(i3, qZoneCountInfo);
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 2, "get feedalert response info:type:" + i3 + ", uCount: " + qZoneCountInfo.uCount + ", iControl: " + qZoneCountInfo.iControl + ", frienduin:0, friendMessage:");
                }
                return true;
            } catch (Exception e16) {
                e = e16;
                QZLog.e(QZLog.TO_DEVICE_TAG, e.toString());
                return false;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public void setUnreadCount(int i3, QZoneCountInfo qZoneCountInfo) {
        try {
            if (QLog.isColorLevel()) {
                Long valueOf = qZoneCountInfo != null ? Long.valueOf(qZoneCountInfo.uCount) : null;
                QLog.d(TAG, 2, "setFeedCount.feedtype=" + i3 + ",count=" + valueOf + ",uin");
            }
            if (i3 > 0 && i3 < 1029) {
                if (this.stMapCountInfo == null) {
                    this.stMapCountInfo = new ConcurrentHashMap<>();
                }
                ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.stMapCountInfo;
                if (concurrentHashMap == null) {
                    return;
                }
                if (qZoneCountInfo == null) {
                    concurrentHashMap.remove(Integer.valueOf(i3));
                } else if (!qZoneCountInfo.equals(concurrentHashMap.get(Integer.valueOf(i3)))) {
                    this.stMapCountInfo.put(Integer.valueOf(i3), qZoneCountInfo);
                }
            }
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "", e16);
        }
    }
}
