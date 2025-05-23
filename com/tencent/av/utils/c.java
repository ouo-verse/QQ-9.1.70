package com.tencent.av.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f77081a = new HashMap(5);

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f77082b = new HashMap(5);

    public static void a(String str, String str2, int i3, Object... objArr) {
        long j3;
        String str3;
        if (QLog.isColorLevel()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map<String, Long> map = f77082b;
            Long l3 = map.get(str);
            if (i3 != 1 && l3 != null) {
                j3 = elapsedRealtime - l3.longValue();
                map.put(str, Long.valueOf(elapsedRealtime));
            } else {
                f77081a.put(str, Long.valueOf(elapsedRealtime));
                map.put(str, Long.valueOf(elapsedRealtime));
                j3 = 0;
            }
            if (objArr != null && objArr.length > 0) {
                StringBuilder sb5 = new StringBuilder(100);
                sb5.append("[");
                int i16 = 0;
                for (Object obj : objArr) {
                    if (i16 > 0) {
                        sb5.append(",");
                    }
                    sb5.append(obj);
                    i16++;
                }
                sb5.append("]");
                str3 = sb5.toString();
            } else {
                str3 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            QLog.i("AVTraceUtil", 2, str + "--" + str2 + "--" + str3 + "--" + j3);
            if (i3 == 2) {
                Long l16 = f77081a.get(str);
                if (l16 == null) {
                    l16 = Long.valueOf(elapsedRealtime);
                }
                QLog.i("AVTraceUtil", 2, str + MsgSummary.STR_COLON + (elapsedRealtime - l16.longValue()));
            }
        }
    }
}
