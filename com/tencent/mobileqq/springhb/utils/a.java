package com.tencent.mobileqq.springhb.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardData;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static DragonCardData a(String str, Map<String, DragonCardData> map) {
        for (DragonCardData dragonCardData : map.values()) {
            if (dragonCardData != null && d(dragonCardData.timeInfo) && dragonCardData.matchMode == 0 && str.equals(dragonCardData.keyWord)) {
                return dragonCardData;
            }
        }
        return null;
    }

    private static DragonCardData b(String str, Map<String, DragonCardData> map) {
        DragonCardData dragonCardData = null;
        for (DragonCardData dragonCardData2 : map.values()) {
            if (dragonCardData2 != null && d(dragonCardData2.timeInfo) && dragonCardData2.matchMode == 1 && str.contains(dragonCardData2.keyWord) && (dragonCardData == null || dragonCardData.priority < dragonCardData2.priority)) {
                dragonCardData = dragonCardData2;
            }
        }
        return dragonCardData;
    }

    public static DragonCardData c(String str, Map<String, DragonCardData> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            DragonCardData a16 = a(str, map);
            if (a16 != null) {
                return a16;
            }
            return b(str, map);
        }
        return null;
    }

    private static boolean d(TimeInfo timeInfo) {
        if (timeInfo != null && timeInfo.begin != 0 && timeInfo.end != 0) {
            return ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isCurTimeInTime(timeInfo);
        }
        return true;
    }
}
