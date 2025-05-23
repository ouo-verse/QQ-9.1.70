package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate;
import cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter$RedPointInfo;
import trpc.tianshu.RedPointTransInfo;

/* loaded from: classes16.dex */
public class QCircleRedPointServiceImpl implements IQCircleRedPointService {
    private static final String TAG = "QCircleRedPointManager";
    private static boolean mIsQQCircleCurrentUseEeveeRedPoint;
    private BaseRedPoinManagerDelegate mCurrentRedPointManagerDelegate;
    private EeveeRedPointManagerDelegate mEeveeRedPointManagerDelegate;

    private BaseRedPoinManagerDelegate getCurrentRedPointManagerDelegate() {
        return this.mCurrentRedPointManagerDelegate;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void clearPedPoint() {
        this.mEeveeRedPointManagerDelegate.clearPedPoint();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getFriendRedPointInfoByAppId(String str) {
        return getCurrentRedPointManagerDelegate().getFriendRedPointInfoByAppId(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str, int i3) {
        return getCurrentRedPointManagerDelegate().getGalleryRedPointInfoByAppId(str, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getLastReceiveOuterEntranceRedPointInfoByAppid(String str) {
        return getCurrentRedPointManagerDelegate().getLastReceiveOuterEntranceRedPointInfoByAppid(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getNumRedPointInfoByAppid(String str) {
        return getCurrentRedPointManagerDelegate().getNumRedPointInfotByAppid(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getOuterEntranceRedPointInfoByAppid(String str) {
        return getCurrentRedPointManagerDelegate().getOuterEntranceRedPointInfoByAppid(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getQQMainTabOuterEntranceRedPointInfoByAppId(String str) {
        return getCurrentRedPointManagerDelegate().getQQMainTabOuterEntranceRedPointInfoByAppId(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public int getRedPointNumberByAppid(String str) {
        QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = getCurrentRedPointManagerDelegate().getOuterEntranceRedPointInfoByAppid(str);
        if (outerEntranceRedPointInfoByAppid == null) {
            return 0;
        }
        if (outerEntranceRedPointInfoByAppid.redTotalNum.has() && outerEntranceRedPointInfoByAppid.redTotalNum.get() > 0) {
            return outerEntranceRedPointInfoByAppid.redTotalNum.get();
        }
        if (!QCircleHostUtil.checkOperateMaskEnabled(outerEntranceRedPointInfoByAppid.outLayerInfo.combineRedTypes.get(), 3)) {
            return 0;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public QQCircleCounter$RedPointInfo getSmallRedPointInfotByAppid(String str) {
        return getCurrentRedPointManagerDelegate().getSmallRedPointInfotByAppid(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void loadRedPointFromSP() {
        this.mEeveeRedPointManagerDelegate.loadRedPointFromSP();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        EeveeRedPointManagerDelegate eeveeRedPointManagerDelegate = new EeveeRedPointManagerDelegate();
        this.mEeveeRedPointManagerDelegate = eeveeRedPointManagerDelegate;
        this.mCurrentRedPointManagerDelegate = eeveeRedPointManagerDelegate;
        mIsQQCircleCurrentUseEeveeRedPoint = true;
        QLog.e(TAG, 1, "isQQCircleCurrentUseEeveeRedPoint: " + mIsQQCircleCurrentUseEeveeRedPoint);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mEeveeRedPointManagerDelegate.onDestroy();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void refreshRedPointData() {
        QCircleEeveeMananger.getInstance().refreshRedPoint();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void saveTianshuOuterEntranceRedPointInfo(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo) {
        this.mEeveeRedPointManagerDelegate.saveTianshuOuterEntranceRedPointInfo(appInfo, redPointTransInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void setFriendRedPointRead(String str, boolean z16) {
        this.mEeveeRedPointManagerDelegate.setFriendRedPointRead(str, z16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void setNumRedPointReaded(String str) {
        this.mEeveeRedPointManagerDelegate.setNumRedPointReaded(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void setOuterEntranceRedPointReaded(String str, List<Integer> list) {
        this.mEeveeRedPointManagerDelegate.setOuterEntranceRedPointReaded(str, list);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent(QCircleRedInfoEvent.OUTER_ENTRANCE_RED_POINT_READED, true));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void setSmallRedPointReaded(String str) {
        this.mEeveeRedPointManagerDelegate.setSmallRedPointReaded(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRedPointService
    public void updateRedPoint() {
        if (QCircleHandler.getQCircleHandler() != null) {
            QCircleHandler.getQCircleHandler().updateRedPoint();
        }
    }
}
