package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IStatisticCollectorApi extends QRouteApi {
    void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4);

    void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17);

    void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17, boolean z18);

    void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3);

    void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17);

    void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17, boolean z18);

    void report(String str);
}
