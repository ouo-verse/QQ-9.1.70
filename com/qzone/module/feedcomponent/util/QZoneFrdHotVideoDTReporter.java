package com.qzone.module.feedcomponent.util;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.CircleReportData;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/module/feedcomponent/util/QZoneFrdHotVideoDTReporter;", "", "Lcom/qzone/proxy/feedcomponent/model/o;", "", "", "toCommonReportMap", "Landroid/view/View;", "view", "", "reportFeedListExposure", "parsedFeedData", "", "position", "reportItemExposure", "reportClick", "videoView", "bindVideoPlayerInfo", "unbindVideoPlayerInfo", "IMP", "Ljava/lang/String;", "KEY_EID", "CLCK", "DT_APP_KEY", "CUSTOM_PAGE_ID", "PAGE_ID", "XSJ_FEED_ID", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneFrdHotVideoDTReporter {
    private static final String CLCK = "dt_clck";
    private static final String CUSTOM_PAGE_ID = "xsj_custom_pgid";
    private static final String DT_APP_KEY = "dt_appkey";
    private static final String IMP = "dt_imp";
    public static final QZoneFrdHotVideoDTReporter INSTANCE = new QZoneFrdHotVideoDTReporter();
    private static final String KEY_EID = "eid";
    private static final String PAGE_ID = "dt_pgid";
    private static final String XSJ_FEED_ID = "xsj_feed_id";

    QZoneFrdHotVideoDTReporter() {
    }

    public final void bindVideoPlayerInfo(View videoView, ParsedFeedData parsedFeedData) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_appkey", "00000QG6YX3X0LZH");
        hashMap.put("xsj_custom_pgid", "pg_discover_feeds_page");
        hashMap.put("dt_pgid", "pg_discover_feeds_page");
        hashMap.put("xsj_feed_id", parsedFeedData.getFeedId());
        VideoEntity build = new VideoEntity.Builder().setContentId(parsedFeedData.getFeedId()).setContentType(2).setPage((Object) "pg_discover_feeds_page").setVideoDuration((int) parsedFeedData.getDuration()).setVideoView(videoView).addCustomParams((Map<String, ?>) hashMap).ignoreReport(false).bizReady(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s\u2026\u89e6\u53d1\u8865\u62a5\n            .build()");
        if (videoView instanceof QZoneVideoView) {
            ISuperPlayer superPlayer = ((QZoneVideoView) videoView).getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                return;
            }
            return;
        }
        VideoReport.bindVideoPlayerInfo(videoView, build);
    }

    public final void reportClick(View view, ParsedFeedData parsedFeedData, int position) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("dt_appkey", "00000QG6YX3X0LZH"), TuplesKt.to("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(position)));
        mutableMapOf.putAll(toCommonReportMap(parsedFeedData));
        VideoReport.reportEvent("dt_clck", view, mutableMapOf);
    }

    public final void reportFeedListExposure(View view) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_appkey", "00000QG6YX3X0LZH"), TuplesKt.to("eid", "em_xsj_friend_recommend_card"));
        VideoReport.reportEvent("dt_imp", view, mapOf);
    }

    public final void reportItemExposure(View view, ParsedFeedData parsedFeedData, int position) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("dt_appkey", "00000QG6YX3X0LZH"), TuplesKt.to("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(position)));
        mutableMapOf.putAll(toCommonReportMap(parsedFeedData));
        VideoReport.reportEvent("dt_imp", view, mutableMapOf);
    }

    public final void unbindVideoPlayerInfo(View videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        VideoReport.unbindVideoPlayerInfo(videoView);
    }

    private final Map<String, Object> toCommonReportMap(ParsedFeedData parsedFeedData) {
        String str;
        String str2;
        Map<String, Object> mapOf;
        String xsjFeedType3;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("xsj_feed_id", parsedFeedData.getFeedId());
        pairArr[1] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, Long.valueOf(parsedFeedData.getPosterId()));
        pairArr[2] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_LIKE_NUM, Integer.valueOf(parsedFeedData.getLikeCount()));
        CircleReportData reportData = parsedFeedData.getReportData();
        String str3 = "";
        if (reportData == null || (str = reportData.getXsjFeedType1()) == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, str);
        CircleReportData reportData2 = parsedFeedData.getReportData();
        if (reportData2 == null || (str2 = reportData2.getXsjFeedType2()) == null) {
            str2 = "";
        }
        pairArr[4] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE2, str2);
        CircleReportData reportData3 = parsedFeedData.getReportData();
        if (reportData3 != null && (xsjFeedType3 = reportData3.getXsjFeedType3()) != null) {
            str3 = xsjFeedType3;
        }
        pairArr[5] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, str3);
        pairArr[6] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, parsedFeedData.getRecommendReason());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }
}
