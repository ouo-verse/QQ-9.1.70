package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class aj {
    public static FeedCloudCommon$Entry a(List<FeedCloudCommon$Entry> list, String str) {
        if (list == null) {
            return null;
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && TextUtils.equals(feedCloudCommon$Entry.key.get(), str)) {
                return feedCloudCommon$Entry;
            }
        }
        return null;
    }

    private static FeedCloudCommon$Entry b(String str, String str2) {
        QLog.d("QCircleTransInfoUtils", 1, "getExtEntry key = " + str + " value = " + str2);
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        PBStringField pBStringField = feedCloudCommon$Entry.key;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        PBStringField pBStringField2 = feedCloudCommon$Entry.value;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField2.set(str2);
        return feedCloudCommon$Entry;
    }

    public static FeedCloudCommon$StCommonExt c(QCircleInitBean qCircleInitBean) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        feedCloudCommon$StCommonExt.mapInfo.set(arrayList);
        if (qCircleInitBean == null) {
            return feedCloudCommon$StCommonExt;
        }
        arrayList.add(QCircleReportFirstLogin.getFirstLoginEntry());
        String str3 = "";
        if (qCircleInitBean.getSchemeAttrs() == null) {
            str = "";
        } else {
            str = qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
        }
        arrayList.add(b("xsj_main_entrance", str));
        if (qCircleInitBean.getSchemeAttrs() == null) {
            str2 = "";
        } else {
            str2 = qCircleInitBean.getSchemeAttrs().get("xsj_sub_entrance");
        }
        arrayList.add(b("xsj_sub_entrance", str2));
        if (qCircleInitBean.getSchemeAttrs() != null) {
            str3 = qCircleInitBean.getSchemeAttrs().get("key_scheme");
        }
        arrayList.add(b("entry_schema", str3));
        arrayList.add(b("isMiddlePage", String.valueOf(qCircleInitBean.isMiddlePage())));
        return feedCloudCommon$StCommonExt;
    }

    public static void d(List<FeedCloudCommon$Entry> list, Map<String, Object> map, String[] strArr) {
        if (list != null && map != null && strArr != null) {
            for (String str : strArr) {
                FeedCloudCommon$Entry a16 = a(list, str);
                if (a16 != null) {
                    map.put(str, a16.value.get());
                }
            }
        }
    }
}
