package com.tencent.mobileqq.qcircle.api.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleSac$SenceBeatInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSecurityStatusUtil {
    private static final String TAG = "QCircleSecurityStatusUtil";
    private static final ConcurrentHashMap<Integer, QQCircleSac$SenceBeatInfo> mSenceBeatInfoMap = new ConcurrentHashMap<>();

    public static synchronized void clearBeatInfoList() {
        synchronized (QCircleSecurityStatusUtil.class) {
            QLog.d(TAG, 1, "[clearBeatInfoList]");
            mSenceBeatInfoMap.clear();
        }
    }

    public static QQCircleSac$SenceBeatInfo getWriteSenceBeatInfo(int i3) {
        ConcurrentHashMap<Integer, QQCircleSac$SenceBeatInfo> concurrentHashMap = mSenceBeatInfoMap;
        QQCircleSac$SenceBeatInfo qQCircleSac$SenceBeatInfo = concurrentHashMap.get(1);
        if (qQCircleSac$SenceBeatInfo != null) {
            return qQCircleSac$SenceBeatInfo;
        }
        return concurrentHashMap.get(Integer.valueOf(i3));
    }

    public static synchronized void setBeatInfoList(List<QQCircleSac$SenceBeatInfo> list) {
        synchronized (QCircleSecurityStatusUtil.class) {
            mSenceBeatInfoMap.clear();
            for (QQCircleSac$SenceBeatInfo qQCircleSac$SenceBeatInfo : list) {
                if (qQCircleSac$SenceBeatInfo != null && qQCircleSac$SenceBeatInfo.beatStatus.get() == 3) {
                    mSenceBeatInfoMap.put(Integer.valueOf(qQCircleSac$SenceBeatInfo.sence.get()), qQCircleSac$SenceBeatInfo);
                }
            }
        }
    }
}
