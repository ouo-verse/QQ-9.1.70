package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.room.StartRoomConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ah {
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        String str;
        String str2;
        if (context == null || feedCloudMeta$StFeed == null || (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) == null || (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) == null) {
            return;
        }
        long j3 = feedCloudMeta$RoomInfoData.roomId.get();
        int i16 = feedCloudMeta$StFeed.live.room.roomType.get();
        String str3 = feedCloudMeta$StFeed.live.room.rtmpUrl.get();
        boolean z17 = feedCloudMeta$StFeed.live.room.isUseFlvUrl.has() && feedCloudMeta$StFeed.live.room.isUseFlvUrl.get();
        String str4 = "";
        String str5 = feedCloudMeta$StFeed.live.room.flvUrl.has() ? feedCloudMeta$StFeed.live.room.flvUrl.get() : "";
        long j16 = feedCloudMeta$StFeed.live.room.source.get();
        String d16 = d(feedCloudMeta$StFeed);
        String str6 = feedCloudMeta$StFeed.cover.picUrl.get();
        String b16 = ag.b(feedCloudMeta$StFeed);
        if (z17 && !TextUtils.isEmpty(str5)) {
            str3 = str5;
        }
        if (TextUtils.isEmpty(str3)) {
            str2 = "";
        } else {
            try {
                str = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str = "";
            }
            try {
                str2 = URLEncoder.encode(str6, "UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                QLog.w("QFSLiveJumpUtil", 1, "encode videoUrl fail");
                str2 = "";
                str4 = str;
                StartRoomConfig startRoomConfig = new StartRoomConfig(j3, i16, str4, str2, z16, j16, b16, i3);
                String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
                c(generateTraceId, String.valueOf(j3));
                startRoomConfig.getBundle().putString("live_traceid", generateTraceId);
                startRoomConfig.getBundle().putString("activity_id", d16);
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).startQQLiveAudiencePage(context, startRoomConfig);
                if (z16) {
                }
            }
            str4 = str;
        }
        StartRoomConfig startRoomConfig2 = new StartRoomConfig(j3, i16, str4, str2, z16, j16, b16, i3);
        String generateTraceId2 = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        c(generateTraceId2, String.valueOf(j3));
        startRoomConfig2.getBundle().putString("live_traceid", generateTraceId2);
        startRoomConfig2.getBundle().putString("activity_id", d16);
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).startQQLiveAudiencePage(context, startRoomConfig2);
        if (z16) {
            return;
        }
        Context e16 = e(context);
        if (e16 instanceof Activity) {
            ((Activity) e16).overridePendingTransition(0, 0);
        }
    }

    private static void b(Context context, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        String str2 = feedCloudMeta$StFeed.live.schema.get();
        String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        String d16 = d(feedCloudMeta$StFeed);
        try {
            str = Uri.parse(str2).getQueryParameter("roomid");
        } catch (Exception e16) {
            QLog.e("QFSLiveJumpUtil", 1, "doStartLiveRoomBySchema, parse roomId error", e16);
            str = "";
        }
        c(generateTraceId, str);
        StringBuilder sb5 = new StringBuilder(str2);
        sb5.append("&translucent_page");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(z16);
        sb5.append("&rcmd_context");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(ag.b(feedCloudMeta$StFeed));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("live_traceid");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(generateTraceId);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("activity_id");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(d16);
        if (QLog.isColorLevel()) {
            QLog.d("QFSLiveJumpUtil", 2, "doStartLiveRoomBySchema: " + ((Object) sb5));
        }
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(context, sb5.toString());
        if (z16) {
            Context e17 = e(context);
            if (e17 instanceof Activity) {
                ((Activity) e17).overridePendingTransition(0, 0);
            }
        }
    }

    private static void c(String str, String str2) {
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(str).roomId(str2).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_CLICKED).ext6(QQLiveReportConstants.Scene.SCENE_QFS_FEED_ENTRANCE).ext7(String.valueOf(System.currentTimeMillis())).ext8(String.valueOf(QQLiveRemoteFloatWindowHelper.f88336d.i())));
    }

    private static String d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!feedCloudMeta$StFeed.reportInfoForClient.has()) {
            QLog.i("QFSLiveJumpUtil", 1, "[getActivityId] data is empty.");
            return "";
        }
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            if (qQCircleFeedBase$StReportInfoForClient.has() && qQCircleFeedBase$StReportInfoForClient.datongJsonData.has()) {
                try {
                    String optString = new JSONObject(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get()).optString(QCircleDaTongConstant.ElementParamKey.XSJ_SEAL_ACTIVITY_INFO, "");
                    HashMap hashMap = new HashMap();
                    for (String str : optString.split(ContainerUtils.FIELD_DELIMITER)) {
                        String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                    if (!hashMap.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TASK_ID)) {
                        return "";
                    }
                    return (String) hashMap.get(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TASK_ID);
                } catch (Exception e16) {
                    QLog.e("QFSLiveJumpUtil", 1, "[getActivityId] get hot task id error:" + e16);
                }
            }
            return "";
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.e("QFSLiveJumpUtil", 1, "[getActivityId] InvalidProtocolBufferMicroException");
            return "";
        }
    }

    private static Context e(Context context) {
        if (!(context instanceof Activity)) {
            return context;
        }
        Activity activity = (Activity) context;
        if (activity.getWindow() == null) {
            QLog.d("QFSLiveJumpUtil", 1, "getActivity error with null activity");
            return activity;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView.getParent() instanceof View) {
            return ((View) decorView.getParent()).getContext();
        }
        return activity;
    }

    public static void f(Context context, String str) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        String str2 = str + "&from=21";
        iAegisLogApi.i("QFSLiveJumpUtil", 1, "onClick jumpLiveRoom() jumpUrl=" + str2);
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            if (TextUtils.equals(qCircleInitBean.getSchemeAttrs().get("is_from_live_room"), "true") && (context instanceof Activity)) {
                iAegisLogApi.i("QFSLiveJumpUtil", 1, "onClick noclearTop=0");
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(context, str2 + "&noclearTop=0");
                return;
            }
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(context, str2);
            return;
        }
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(context, str2);
    }

    public static void g(Context context, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (!TextUtils.isEmpty(feedCloudMeta$StFeed.live.schema.get())) {
            b(context, z16, feedCloudMeta$StFeed);
        } else {
            a(context, z16, feedCloudMeta$StFeed, i3);
        }
    }
}
