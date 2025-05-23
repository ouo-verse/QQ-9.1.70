package com.tencent.mobileqq.mini.helper;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.config.ad.MiniAdConfigBean;
import com.tencent.mobileqq.mini.config.ad.MiniAdConfigParser;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAdExposureHelper {
    private static final String EXPO_TIMESTAMP_LIST_SPLIT_FLAG = ",";
    private static final String KEY_EXPO_TIMESTAMP_LIST = "mini_loading_ad_expo_timestamp_list_";
    public static final String TAG = "MiniAdExposureHelper";
    private static int sMaxCacheExpoTimeStampNum;

    public static boolean checkAdExpoFreqAvailable() {
        MiniAdConfigBean miniAdConfigBean = (MiniAdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniAdConfigParser.GROUP_ID);
        if (miniAdConfigBean == null) {
            QLog.d(TAG, 1, "checkAdExpoFreqAvailable: config is null -> expo freq access");
            return true;
        }
        long miniLoadingAdCheckDuration1 = miniAdConfigBean.getMiniLoadingAdCheckDuration1();
        long miniLoadingAdCheckDuration2 = miniAdConfigBean.getMiniLoadingAdCheckDuration2();
        int miniLoadingAdCheckTime1 = miniAdConfigBean.getMiniLoadingAdCheckTime1();
        int miniLoadingAdCheckTime2 = miniAdConfigBean.getMiniLoadingAdCheckTime2();
        sMaxCacheExpoTimeStampNum = Math.max(miniLoadingAdCheckTime1, miniLoadingAdCheckTime2);
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        List<Long> recentExpoTimeStampList = getRecentExpoTimeStampList(peekAppRuntime != null ? peekAppRuntime.getAccount() : "");
        return checkAdExpoFreqAvailable(miniLoadingAdCheckDuration1, miniLoadingAdCheckTime1, recentExpoTimeStampList) && checkAdExpoFreqAvailable(miniLoadingAdCheckDuration2, miniLoadingAdCheckTime2, recentExpoTimeStampList);
    }

    private static List<Long> getRecentExpoTimeStampList(String str) {
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString(KEY_EXPO_TIMESTAMP_LIST + str, "");
        ArrayList arrayList = new ArrayList();
        for (String str2 : decodeString.split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(str2)));
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "getRecentExpoTimeStampList error:", th5);
                }
            }
        }
        return arrayList;
    }

    public static void updateRecentExpoTimeStampList() {
        String str;
        if (sMaxCacheExpoTimeStampNum == 0) {
            QLog.d(TAG, 1, "updateRecentExpoTimeStampList return: cache num is 0");
            return;
        }
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = "";
        }
        List<Long> recentExpoTimeStampList = getRecentExpoTimeStampList(str);
        recentExpoTimeStampList.add(Long.valueOf(System.currentTimeMillis()));
        int size = recentExpoTimeStampList.size();
        int i3 = sMaxCacheExpoTimeStampNum;
        if (size > i3) {
            recentExpoTimeStampList = recentExpoTimeStampList.subList(size - i3, size);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<Long> it = recentExpoTimeStampList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().longValue());
            sb5.append(",");
        }
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString(KEY_EXPO_TIMESTAMP_LIST + str, sb5.toString());
        QLog.d(TAG, 1, "updateRecentExpoTimeStampList: " + sb5.toString());
    }

    private static boolean checkAdExpoFreqAvailable(long j3, int i3, List<Long> list) {
        if (j3 != 0 && i3 != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            int size = list.size();
            if (size < i3) {
                QLog.d(TAG, 1, "checkAdExpoFreqAvailable: checkDuration: " + j3 + ",checkTime: " + i3 + ", cacheSize:" + size + " -> expo freq access");
                return true;
            }
            Iterator<Long> it = list.subList(size - i3, size).iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - it.next().longValue() > j3) {
                    QLog.d(TAG, 1, "checkAdExpoFreqAvailable: checkDuration: " + j3 + ",checkTime: " + i3 + ", cacheSize:" + size + " (curTimeStamp - timeStamp > checkDuration) -> expo freq access");
                    return true;
                }
            }
            QLog.e(TAG, 1, "checkAdExpoFreqAvailable: checkDuration: " + j3 + ",checkTime: " + i3 + " -> expo freq limit");
            return false;
        }
        QLog.d(TAG, 1, "checkAdExpoFreqAvailable: checkDuration: " + j3 + ",checkTime: " + i3 + "-> expo freq access");
        return true;
    }
}
