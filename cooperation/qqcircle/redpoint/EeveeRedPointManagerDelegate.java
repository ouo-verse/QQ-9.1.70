package cooperation.qqcircle.redpoint;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter$CountInfoRsp;
import qqcircle.QQCircleCounter$RedPointInfo;
import trpc.tianshu.RedPointTransInfo;
import uq3.k;

/* loaded from: classes28.dex */
public class EeveeRedPointManagerDelegate implements SimpleEventReceiver, BaseRedPoinManagerDelegate {
    private static final String TAG = "QCircleTabRedPoint-QCircleEeveeRedPointManagerDelegate";
    private QQCircleCounter$RedPointInfo mCacheFriendRedPointInfo;
    private QQCircleCounter$RedPointInfo mCacheNumRedPointInfo;
    private QQCircleCounter$RedPointInfo mCacheOuterEntranceRedPointInfo;
    private QQCircleCounter$RedPointInfo mCacheSmallRedPointInfo;
    private QQCircleCounter$RedPointInfo mLastReceiveOuterEntranceRedPointInfo;
    private BusinessInfoCheckUpdate.AppInfo mTianshuOuterRedPointAppInfo;
    private RedPointTransInfo mTianshuOuterRedPointTransInfo;
    private List<QQCircleCounter$RedPointInfo> mCacheFriendRedPointInfoList = new ArrayList();
    private final HashMap<Integer, QQCircleCounter$RedPointInfo> mSubTypeToGalleryRedPointInfo = new HashMap<>();
    private final Object mLock = new Object();

    public EeveeRedPointManagerDelegate() {
        QLog.d(TAG, 1, "[EeveeRedPointManagerDelegate] create: " + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_layer_enable_db_red_point", true)) {
            loadRedPointFromSP();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void clearRedPointInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, List<Integer> list) {
        long j3 = qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            j3 &= ~(1 << r2.intValue());
            int intValue = it.next().intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3 || intValue == 6) {
                        qQCircleCounter$RedPointInfo.wording.clear();
                        qQCircleCounter$RedPointInfo.allPushInfo.tabTipWording.clear();
                        qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.clear();
                    }
                } else {
                    qQCircleCounter$RedPointInfo.redTotalNum.clear();
                    qQCircleCounter$RedPointInfo.wording.clear();
                }
            } else {
                qQCircleCounter$RedPointInfo.rptRedInfo.clear();
                qQCircleCounter$RedPointInfo.wording.clear();
            }
        }
        qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.set(j3);
        qQCircleCounter$RedPointInfo.extend.clear();
        qQCircleCounter$RedPointInfo.redJumpInfo.clear();
        QLog.d(TAG, 1, "[setOuterEntranceRedPointReaded] combineRedTypes: " + j3);
    }

    private QQCircleCounter$RedPointInfo convertToRedPointInfo(RedPointTransInfo redPointTransInfo) {
        if (redPointTransInfo == null) {
            return new QQCircleCounter$RedPointInfo();
        }
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = new QQCircleCounter$RedPointInfo();
        if (!TextUtils.isEmpty(redPointTransInfo.feedID)) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("feedID");
            feedCloudCommon$Entry.value.set(redPointTransInfo.feedID);
            qQCircleCounter$RedPointInfo.extInfo.mapInfo.add(feedCloudCommon$Entry);
            qQCircleCounter$RedPointInfo.tabType.set(6);
            qQCircleCounter$RedPointInfo.transInfo.set(ByteStringMicro.copyFrom(redPointTransInfo.feedTransInfo.toByteArray()));
        } else {
            qQCircleCounter$RedPointInfo.tabType.set(-1);
        }
        qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.set(15L);
        qQCircleCounter$RedPointInfo.allPushInfo.msgType.set(4);
        String str = redPointTransInfo.reportTransInfo;
        if (!TextUtils.isEmpty(str)) {
            qQCircleCounter$RedPointInfo.extend.set(str);
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = this.mTianshuOuterRedPointAppInfo;
        if (appInfo != null) {
            qQCircleCounter$RedPointInfo.redTotalNum.set(appInfo.num.get());
        }
        return qQCircleCounter$RedPointInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleRedPointInfoList(int i3, int i16, List<QQCircleCounter$RedPointInfo> list) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        boolean z16 = false;
        if (list.size() > 0) {
            qQCircleCounter$RedPointInfo = list.get(0);
        } else {
            qQCircleCounter$RedPointInfo = null;
        }
        if (qQCircleCounter$RedPointInfo == null) {
            qQCircleCounter$RedPointInfo = new QQCircleCounter$RedPointInfo();
        }
        QLog.d(TAG, 1, "on receive repoint. redPointMainMsgType: " + i3);
        if (i3 != 101) {
            if (i3 != 102) {
                if (i3 != 106) {
                    if (i3 != 115) {
                        if (i3 == 116) {
                            synchronized (this.mLock) {
                                this.mSubTypeToGalleryRedPointInfo.put(Integer.valueOf(i16), qQCircleCounter$RedPointInfo);
                            }
                        }
                        if (z16 && QCircleHandler.getQCircleHandler() != null) {
                            QCircleHandler.getQCircleHandler().updateRedPoint();
                            return;
                        }
                        return;
                    }
                    synchronized (this.mLock) {
                        String friendTabIdForReadOnlyWording = EeveeRedpointUtil.getFriendTabIdForReadOnlyWording();
                        if (!friendTabIdForReadOnlyWording.isEmpty()) {
                            String redPointId = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo);
                            if (TextUtils.equals(friendTabIdForReadOnlyWording, redPointId)) {
                                QLog.i(TAG, 1, "match lastFriendTabIdForReadOnlyWording, id=" + redPointId + ", clear wording");
                                qQCircleCounter$RedPointInfo.wording.set("");
                            }
                            for (QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2 : list) {
                                String redPointId2 = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo2);
                                if (TextUtils.equals(friendTabIdForReadOnlyWording, redPointId2)) {
                                    QLog.i(TAG, 1, "match lastFriendTabIdForReadOnlyWording, id=" + redPointId2 + ", clear wording");
                                    qQCircleCounter$RedPointInfo2.wording.set("");
                                }
                            }
                        }
                        this.mCacheFriendRedPointInfo = qQCircleCounter$RedPointInfo;
                        this.mCacheFriendRedPointInfoList.clear();
                        this.mCacheFriendRedPointInfoList.addAll(list);
                    }
                } else {
                    if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
                        synchronized (this.mLock) {
                            if (i16 == 1060001) {
                                this.mCacheOuterEntranceRedPointInfo = qQCircleCounter$RedPointInfo;
                                this.mLastReceiveOuterEntranceRedPointInfo = qQCircleCounter$RedPointInfo;
                            }
                        }
                    }
                    if (z16) {
                        return;
                    } else {
                        return;
                    }
                }
            } else {
                synchronized (this.mLock) {
                    this.mCacheNumRedPointInfo = qQCircleCounter$RedPointInfo;
                }
            }
        } else {
            synchronized (this.mLock) {
                this.mCacheSmallRedPointInfo = qQCircleCounter$RedPointInfo;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRedPointFromSP$0() {
        loadRedPointFromSP(106, 1060001);
    }

    private void saveRedPointInfoToSP(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo != null) {
            QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp = new QQCircleCounter$CountInfoRsp();
            ArrayList arrayList = new ArrayList();
            arrayList.add(qQCircleCounter$RedPointInfo);
            qQCircleCounter$CountInfoRsp.rptRedPoint.set(arrayList);
            final byte[] byteArray = qQCircleCounter$CountInfoRsp.toByteArray();
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        k.a().k("QFS_OUT_LAYER_RED_POINT_DATA", byteArray);
                        QLog.i(EeveeRedPointManagerDelegate.TAG, 1, "[saveRedPointInfoToSP] uin: " + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
                    } catch (Throwable th5) {
                        QLog.e(EeveeRedPointManagerDelegate.TAG, 1, "saveRedPointToDataBase error! ", th5);
                    }
                }
            });
        }
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void clearPedPoint() {
        synchronized (this.mLock) {
            this.mCacheNumRedPointInfo = new QQCircleCounter$RedPointInfo();
            this.mCacheSmallRedPointInfo = new QQCircleCounter$RedPointInfo();
            this.mCacheOuterEntranceRedPointInfo = new QQCircleCounter$RedPointInfo();
            this.mTianshuOuterRedPointAppInfo = null;
            this.mTianshuOuterRedPointTransInfo = null;
        }
        if (QCircleHandler.getQCircleHandler() != null) {
            QCircleHandler.getQCircleHandler().updateRedPoint();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleRedPointEvent.class);
        return arrayList;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getFriendRedPointInfoByAppId(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mCacheFriendRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str, int i3) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mSubTypeToGalleryRedPointInfo.get(Integer.valueOf(i3));
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getLastReceiveOuterEntranceRedPointInfoByAppid(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mLastReceiveOuterEntranceRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getNumRedPointInfotByAppid(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mCacheNumRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getOuterEntranceRedPointInfoByAppid(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            return convertToRedPointInfo(this.mTianshuOuterRedPointTransInfo);
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mCacheOuterEntranceRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getQQMainTabOuterEntranceRedPointInfoByAppId(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            return convertToRedPointInfo(this.mTianshuOuterRedPointTransInfo);
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mCacheOuterEntranceRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    public IRedTouchManager getRuntimeService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        }
        return null;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public QQCircleCounter$RedPointInfo getSmallRedPointInfotByAppid(String str) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            qQCircleCounter$RedPointInfo = this.mCacheSmallRedPointInfo;
        }
        return qQCircleCounter$RedPointInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void loadRedPointFromSP() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.redpoint.a
            @Override // java.lang.Runnable
            public final void run() {
                EeveeRedPointManagerDelegate.this.lambda$loadRedPointFromSP$0();
            }
        });
    }

    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleRedPointEvent) {
            QCircleRedPointEvent qCircleRedPointEvent = (QCircleRedPointEvent) simpleBaseEvent;
            List<QQCircleCounter$RedPointInfo> list = qCircleRedPointEvent.mRedPointInfoList;
            if (list == null) {
                list = new ArrayList<>();
            }
            handleRedPointInfoList(qCircleRedPointEvent.mRedPointMainMsgType, qCircleRedPointEvent.mRedPointSubMsgType, list);
        }
    }

    public void saveTianshuOuterEntranceRedPointInfo(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo) {
        this.mTianshuOuterRedPointAppInfo = appInfo;
        this.mTianshuOuterRedPointTransInfo = redPointTransInfo;
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void setFriendRedPointRead(String str, boolean z16) {
        QLog.d(TAG, 1, "setSmallRedPointReaded appid: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mLock) {
            QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.mCacheFriendRedPointInfo;
            if (qQCircleCounter$RedPointInfo == null) {
                QLog.e(TAG, 1, "setSmallRedPointReaded return. redPointInfo is null");
                return;
            }
            String redPointId = EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo);
            QLog.i(TAG, 1, "setFriendRedPointRead, saveFriendTabId, id=" + redPointId);
            if (z16) {
                EeveeRedpointUtil.saveFriendTabIdForReadOnlyWording(redPointId);
                this.mCacheFriendRedPointInfo.wording.set("");
            } else {
                EeveeRedpointUtil.saveFriendTabIdForRead(redPointId);
                this.mCacheFriendRedPointInfo.clear();
            }
        }
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void setNumRedPointReaded(String str) {
        QLog.d(TAG, 1, "setNumRedPointReaded appid: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mLock) {
            QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.mCacheNumRedPointInfo;
            if (qQCircleCounter$RedPointInfo == null) {
                QLog.e(TAG, 1, "setNumRedPointReaded return. redPointInfo is null");
                return;
            }
            EeveeRedpointUtil.saveLastReadedNumRedPointTimestamp(qQCircleCounter$RedPointInfo.lastVisitTime.get());
            this.mCacheNumRedPointInfo.clear();
            this.mSubTypeToGalleryRedPointInfo.clear();
        }
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void setOuterEntranceRedPointReaded(String str, List<Integer> list) {
        QLog.d(TAG, 1, "setOuterEntranceRedPointReaded appid: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list != null && list.size() > 0) {
            synchronized (this.mLock) {
                QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.mCacheOuterEntranceRedPointInfo;
                if (qQCircleCounter$RedPointInfo != null) {
                    clearRedPointInfo(qQCircleCounter$RedPointInfo, list);
                }
                saveRedPointInfoToSP(this.mCacheOuterEntranceRedPointInfo);
                this.mTianshuOuterRedPointAppInfo = null;
                this.mTianshuOuterRedPointTransInfo = null;
            }
            return;
        }
        QLog.d(TAG, 1, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
    }

    @Override // cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
    public void setSmallRedPointReaded(String str) {
        QLog.d(TAG, 1, "setSmallRedPointReaded appid: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mLock) {
            QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.mCacheSmallRedPointInfo;
            if (qQCircleCounter$RedPointInfo == null) {
                QLog.e(TAG, 1, "setSmallRedPointReaded return. redPointInfo is null");
            } else {
                EeveeRedpointUtil.saveLastReadedSmallRedPointTimestamp(qQCircleCounter$RedPointInfo.lastVisitTime.get());
                this.mCacheSmallRedPointInfo.clear();
            }
        }
    }

    private void loadRedPointFromSP(int i3, int i16) {
        byte[] d16 = k.a().d("QFS_OUT_LAYER_RED_POINT_DATA", new byte[0]);
        if (d16 == null || d16.length == 0) {
            return;
        }
        QLog.d(TAG, 1, "loadRedPointFromDataBase mainType" + i3);
        QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp = new QQCircleCounter$CountInfoRsp();
        try {
            qQCircleCounter$CountInfoRsp.mergeFrom(d16);
            handleRedPointInfoList(i3, i16, qQCircleCounter$CountInfoRsp.rptRedPoint.get());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "loadRedPointFromDataBase error", e16);
        }
    }
}
