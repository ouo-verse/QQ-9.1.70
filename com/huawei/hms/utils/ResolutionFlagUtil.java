package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResolutionFlagUtil {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f37714a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f37715b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f37716c = new Object();

    ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f37715b.keySet()) {
            Map<String, Long> map = f37715b;
            Long l3 = map.get(str);
            if (l3 == null || l3.longValue() == 0) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l3.longValue()) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f37714a != null) {
            return f37714a;
        }
        synchronized (f37716c) {
            if (f37714a == null) {
                f37714a = new ResolutionFlagUtil();
            }
        }
        return f37714a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f37715b;
        if (map.get(str) == null) {
            return 0L;
        }
        return map.get(str).longValue();
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f37715b.remove(str);
            HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j3) {
        if (!TextUtils.isEmpty(str) && j3 != 0) {
            a(str, j3);
            return;
        }
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j3);
    }

    private void a(String str, long j3) {
        Map<String, Long> map = f37715b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j3));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
