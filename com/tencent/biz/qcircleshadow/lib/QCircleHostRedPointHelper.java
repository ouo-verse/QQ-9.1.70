package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.List;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter$RedPointInfo;
import trpc.tianshu.RedPointTransInfo;

/* loaded from: classes4.dex */
public class QCircleHostRedPointHelper {
    public static void clearPedPoint() {
        getService().clearPedPoint();
    }

    public static QQCircleCounter$RedPointInfo getFriendRedPointInfoByAppId(String str) {
        return getService().getFriendRedPointInfoByAppId(str);
    }

    public static QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str, int i3) {
        return getService().getGalleryRedPointInfoByAppId(str, i3);
    }

    public static QQCircleCounter$RedPointInfo getLastReceiveOuterEntranceRedPointInfoByAppid(String str) {
        return getService().getLastReceiveOuterEntranceRedPointInfoByAppid(str);
    }

    public static QQCircleCounter$RedPointInfo getNumRedPointInfoByAppid(String str) {
        return getService().getNumRedPointInfoByAppid(str);
    }

    public static QQCircleCounter$RedPointInfo getQQMainTabOuterEntranceRedPointInfoByAppid(String str) {
        return getService().getQQMainTabOuterEntranceRedPointInfoByAppId(str);
    }

    public static QQCircleCounter$RedPointInfo getQQUpdatesTabOuterEntranceRedPointInfoByAppid(String str) {
        return getService().getOuterEntranceRedPointInfoByAppid(str);
    }

    private static IQCircleRedPointService getService() {
        return (IQCircleRedPointService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleRedPointService.class, "all");
    }

    public static QQCircleCounter$RedPointInfo getSmallRedPointInfotByAppid(String str) {
        return getService().getSmallRedPointInfotByAppid(str);
    }

    public static void loadRedPointFromDB() {
        getService().loadRedPointFromSP();
    }

    public static void saveTianshuOuterEntranceRedPointInfo(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo) {
        getService().saveTianshuOuterEntranceRedPointInfo(appInfo, redPointTransInfo);
    }

    public static void setFriendRedPointRead(String str, boolean z16) {
        getService().setFriendRedPointRead(str, z16);
    }

    public static void setNumRedPointReaded(String str) {
        getService().setNumRedPointReaded(str);
    }

    public static void setOuterEntranceRedPointReaded(String str, List<Integer> list) {
        getService().setOuterEntranceRedPointReaded(str, list);
    }

    public static void setSmallRedPointReaded(String str) {
        getService().setSmallRedPointReaded(str);
    }
}
