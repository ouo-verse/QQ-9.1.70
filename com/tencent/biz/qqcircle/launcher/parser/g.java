package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudMeta$StPoiInfoV2;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StSimulateData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f91413a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f91413a = arrayList;
        arrayList.add(String.valueOf(16));
        arrayList.add(String.valueOf(4));
    }

    public static boolean o(String str) {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QCirclePolymerizeSchemeParser", 1, "[isNeedIntercept] forbid launch some polymerize page because of sencebeat., sourceType =" + str);
            return !f91413a.contains(str);
        }
        return false;
    }

    private void p(Context context, QCircleSchemeBean qCircleSchemeBean) {
        QCirclePolymerizationBean q16 = q(qCircleSchemeBean);
        if (q16 == null) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.j0(context, q16);
    }

    private void r(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        String str = hashMap.get(QCircleSchemeAttr.Polymerize.FILTER_ID);
        String str2 = hashMap.get(QCircleSchemeAttr.Polymerize.FILTER_NAME);
        QQCircleFeedBase$StSimulateData qQCircleFeedBase$StSimulateData = new QQCircleFeedBase$StSimulateData();
        if (!TextUtils.isEmpty(str)) {
            qQCircleFeedBase$StSimulateData.material_id.set(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            qQCircleFeedBase$StSimulateData.simulate_name.set(str2);
        }
        qQCircleFeedBase$StSimulateData.simulate_schema.set(HostStaticInvokeHelper.getQCircleSchemeFromJumpUtil(str, ""));
        qCirclePolymerizationBean.setSimulateData(qQCircleFeedBase$StSimulateData);
        String str3 = hashMap.get(QCircleSchemeAttr.Polymerize.EXT1_FROM);
        try {
            if (!TextUtils.isEmpty(str3)) {
                qCirclePolymerizationBean.setExt1From(Integer.parseInt(str3));
            }
        } catch (Exception e16) {
            QLog.e("QCirclePolymerizeSchemeParser", 1, "launchPublishFragmentByScheme parseNumError:" + e16.getMessage());
        }
    }

    private void s(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        int i3;
        String str = hashMap.get("tagid");
        try {
            i3 = Integer.parseInt(hashMap.get("rank"));
        } catch (NumberFormatException e16) {
            QLog.e("QCirclePolymerizeSchemeParser", 1, "parseHotEventListParams", e16);
            i3 = 0;
        }
        if (!TextUtils.isEmpty(str)) {
            qCirclePolymerizationBean.setHotEventInfo(HotEventInfo.fromIdAndRank(str, i3));
        }
    }

    private void t(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        String str = hashMap.get(QCircleSchemeAttr.Polymerize.POI_NAME);
        FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV2 = new FeedCloudMeta$StPoiInfoV2();
        feedCloudMeta$StPoiInfoV2.name.set(str);
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        feedCloudMeta$StGPSV2.lat.set(Long.parseLong(hashMap.get(QCircleSchemeAttr.Polymerize.LAT)));
        feedCloudMeta$StGPSV2.lon.set(Long.parseLong(hashMap.get("lon")));
        feedCloudMeta$StGPSV2.alt.set(Long.parseLong(hashMap.get(QCircleSchemeAttr.Polymerize.ALT)));
        feedCloudMeta$StPoiInfoV2.gps.set(feedCloudMeta$StGPSV2);
        qCirclePolymerizationBean.setPoiInfo(feedCloudMeta$StPoiInfoV2);
    }

    private void u(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        String str = hashMap.get("tagid");
        String str2 = hashMap.get("tagname");
        String str3 = hashMap.get("feedtagpagefromtype");
        try {
            if (!TextUtils.isEmpty(str)) {
                feedCloudMeta$StTagInfo.tagId.set(URLDecoder.decode(str, StandardCharsets.UTF_8.name()));
            }
            if (!TextUtils.isEmpty(str2)) {
                feedCloudMeta$StTagInfo.tagName.set(URLDecoder.decode(str2, StandardCharsets.UTF_8.name()));
            }
            if (!TextUtils.isEmpty(str3)) {
                qCirclePolymerizationBean.setFeedTagPageFromType(URLDecoder.decode(str3, StandardCharsets.UTF_8.name()));
            }
        } catch (UnsupportedEncodingException e16) {
            QLog.d("QCirclePolymerizeSchemeParser", 1, "URLDecoder schoolPage attrs error");
            e16.printStackTrace();
        }
        qCirclePolymerizationBean.setOperationActivityId(hashMap.get("xsj_operation_activity_id"));
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
    }

    private void v(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        String str = hashMap.get("tagid");
        if (!TextUtils.isEmpty(str)) {
            feedCloudMeta$StTagInfo.tagId.set(str);
        }
        String str2 = hashMap.get("tagname");
        if (!TextUtils.isEmpty(str2)) {
            feedCloudMeta$StTagInfo.tagName.set(str2);
        }
        String str3 = hashMap.get("feedtagpagefromtype");
        if (!TextUtils.isEmpty(str3)) {
            qCirclePolymerizationBean.setFeedTagPageFromType(str3);
        }
        qCirclePolymerizationBean.setOperationActivityId(hashMap.get("xsj_operation_activity_id"));
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        w(hashMap, qCirclePolymerizationBean);
    }

    private void w(HashMap<String, String> hashMap, QCirclePolymerizationBean qCirclePolymerizationBean) {
        int i3;
        int i16 = 1;
        try {
            i3 = Integer.parseInt(hashMap.get(QCircleSchemeAttr.Polymerize.TAB_TYPE));
        } catch (NumberFormatException e16) {
            QLog.e("QCirclePolymerizeSchemeParser", 1, "parseTagPageTabTypeParams", e16);
            i3 = -1;
        }
        if (i3 == -1) {
            QLog.e("QCirclePolymerizeSchemeParser", 1, "[parseTagPageTabTypeParams] is not selected tab");
            return;
        }
        if (i3 != 2) {
            i16 = 0;
        }
        qCirclePolymerizationBean.setTagTabType(i16);
        qCirclePolymerizationBean.setSelectedTabType(i3);
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        p(context, qCircleSchemeBean);
    }

    public QCirclePolymerizationBean q(QCircleSchemeBean qCircleSchemeBean) {
        QCirclePolymerizationBean qCirclePolymerizationBean = null;
        if (qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
            if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_TAG_PAGE.equals(qCircleSchemeBean.getSchemeAction())) {
                attrs.put("sourcetype", String.valueOf(7));
            }
            String str = attrs.get("sourcetype");
            if (str == null || o(str)) {
                return null;
            }
            qCirclePolymerizationBean = new QCirclePolymerizationBean();
            b(qCircleSchemeBean, qCirclePolymerizationBean);
            if (str.equals(String.valueOf(7))) {
                v(attrs, qCirclePolymerizationBean);
            } else if (str.equals(String.valueOf(16))) {
                t(attrs, qCirclePolymerizationBean);
            } else if (str.equals(String.valueOf(20))) {
                r(attrs, qCirclePolymerizationBean);
            } else if (str.equals(String.valueOf(4))) {
                u(attrs, qCirclePolymerizationBean);
            } else if (str.equals(String.valueOf(63))) {
                s(attrs, qCirclePolymerizationBean);
            }
            i(qCirclePolymerizationBean, attrs);
            qCirclePolymerizationBean.setPolymerizationType(Integer.valueOf(str).intValue());
            qCirclePolymerizationBean.setExt1From(5);
        }
        return qCirclePolymerizationBean;
    }
}
