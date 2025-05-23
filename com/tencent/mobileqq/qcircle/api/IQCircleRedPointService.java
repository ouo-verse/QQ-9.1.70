package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.List;
import mqq.app.api.IRuntimeService;
import qqcircle.QQCircleCounter$RedPointInfo;
import trpc.tianshu.RedPointTransInfo;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleRedPointService extends IRuntimeService {
    void clearPedPoint();

    QQCircleCounter$RedPointInfo getFriendRedPointInfoByAppId(String str);

    QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str, int i3);

    QQCircleCounter$RedPointInfo getLastReceiveOuterEntranceRedPointInfoByAppid(String str);

    QQCircleCounter$RedPointInfo getNumRedPointInfoByAppid(String str);

    QQCircleCounter$RedPointInfo getOuterEntranceRedPointInfoByAppid(String str);

    QQCircleCounter$RedPointInfo getQQMainTabOuterEntranceRedPointInfoByAppId(String str);

    int getRedPointNumberByAppid(String str);

    QQCircleCounter$RedPointInfo getSmallRedPointInfotByAppid(String str);

    void loadRedPointFromSP();

    void refreshRedPointData();

    void saveTianshuOuterEntranceRedPointInfo(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo);

    void setFriendRedPointRead(String str, boolean z16);

    void setNumRedPointReaded(String str);

    void setOuterEntranceRedPointReaded(String str, List<Integer> list);

    void setSmallRedPointReaded(String str);

    void updateRedPoint();
}
