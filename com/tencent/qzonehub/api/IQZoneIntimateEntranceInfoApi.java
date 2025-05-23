package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneIntimateEntranceInfoApi extends QRouteApi {
    long getEntranceAvatarShowInterval();

    int getEntranceAvatarShowTimes();

    ArrayList<String> getEntranceAvatarUinList();

    void saveEntranceAvatarUinList(ArrayList<String> arrayList);
}
