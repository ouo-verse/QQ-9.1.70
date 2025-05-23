package com.tencent.qqnt;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface ITroopListTempApi extends QRouteApi {
    void fetchTroopBasicInfo(String str, String str2, Function2<Boolean, Object, Unit> function2);

    ArrayList<?> getSortedJoinedTroopInfoFromCache();

    Object getTroopExtDBInfoSync(String str);

    Object getTroopInfoFromCache(String str);

    String getTroopUinByTroopCode(String str);

    void saveTroopInCache(Object obj);

    void updateMyTroopHonor(String str, String str2, byte b16);
}
