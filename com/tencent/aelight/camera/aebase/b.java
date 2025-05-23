package com.tencent.aelight.camera.aebase;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class b {
    public static void a(String str, String str2, Map<String, String> map) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportEnd(c(str), str2, d(map));
    }

    public static String b() {
        return ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ext2();
    }

    private static String c(String str) {
        return WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + str;
    }

    private static List<FeedCloudCommon$Entry> d(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                if (!TextUtils.isEmpty(entry.getKey())) {
                    feedCloudCommon$Entry.key.set(entry.getKey());
                }
                if (!TextUtils.isEmpty(entry.getValue())) {
                    feedCloudCommon$Entry.value.set(entry.getValue());
                }
                arrayList.add(feedCloudCommon$Entry);
            }
        }
        return arrayList;
    }

    public static String e() {
        return ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).keySwitchToCameraTab();
    }

    public static String f() {
        return ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).pJumpPageTimeCost();
    }

    public static void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(b(), e());
        hashMap.put(h(), str);
        a(f(), e(), hashMap);
    }

    public static String h() {
        return ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).traceId();
    }
}
