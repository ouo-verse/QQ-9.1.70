package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneActiveRedCountInfoApi extends QRouteApi {
    boolean checkIsNeedToBatchDeleteCountInfo(HashMap<Integer, QZoneCountInfo> hashMap);

    boolean checkIsNeedToSingleDeleteCountInfo(QZoneCountInfo qZoneCountInfo, int i3);

    void daTongClickReport();

    void daTongExposeReport();

    void deleteRedCountInfo(int i3);

    boolean existQZoneActiveRedCountInfo();

    long getRedCountInfoTimestamp(int i3);

    boolean isValidPublishPlusIconRedDot(QZoneCountInfo qZoneCountInfo);

    void saveRedCountInfo(int i3, QZoneCountInfo qZoneCountInfo);
}
