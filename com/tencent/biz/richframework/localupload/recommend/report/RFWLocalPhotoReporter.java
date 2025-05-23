package com.tencent.biz.richframework.localupload.recommend.report;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import cooperation.qzone.remote.ServiceConst;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ8\u0010\u0011\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bJ8\u0010\u0017\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ \u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ0\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/report/RFWLocalPhotoReporter;", "", "", "queryTime", "", "msToSecond", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "", "totalCount", "", "reportQueryFinish", "countWithLatLon", "countWithCity", "countWithTag", "countEachTag", "photoCount", "reportFillInfoFinish", "classierId", "classierName", "countBeforeHandpick", "countAfterRemoveSimilar", "countAfterHandpick", "reportSingleClassifyFinish", "videoClassierCount", "photoClassifierCount", "reportAllClassifyFinish", "fillInfoTime", "classifyTime", "reportClassifyTimeCost", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWLocalPhotoReporter {

    @NotNull
    public static final RFWLocalPhotoReporter INSTANCE = new RFWLocalPhotoReporter();

    RFWLocalPhotoReporter() {
    }

    private final String msToSecond(long queryTime) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(queryTime / 1000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final void reportAllClassifyFinish(@Nullable RecommendContext context, int videoClassierCount, int photoClassifierCount) {
        Map<String, ? extends Object> mutableMapOf;
        if (context != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ServiceConst.PARA_SESSION_ID, context.getMSessionId()), TuplesKt.to("total_video_clusters_number", Integer.valueOf(videoClassierCount)), TuplesKt.to("total_event_clusters_number", Integer.valueOf(photoClassifierCount)), TuplesKt.to("is_clustering_complete", Integer.valueOf(!context.getIsInQZoneEnv().get() ? 1 : 0)));
            context.getDelegate().getReportDelegate().customReport("ev_qz_clustering_process_terminates", mutableMapOf);
        }
    }

    public final void reportClassifyTimeCost(@Nullable RecommendContext context, long queryTime, long fillInfoTime, long classifyTime, int photoCount) {
        Map<String, ? extends Object> mutableMapOf;
        if (context != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ServiceConst.PARA_SESSION_ID, context.getMSessionId()), TuplesKt.to("query_time", msToSecond(queryTime)), TuplesKt.to("identification_time", msToSecond(fillInfoTime)), TuplesKt.to("clustering_time", msToSecond(classifyTime)), TuplesKt.to("pic_cnt", Integer.valueOf(photoCount)));
            context.getDelegate().getReportDelegate().customReport("ev_qz_clustering_process_time_consuming", mutableMapOf);
        }
    }

    public final void reportFillInfoFinish(@Nullable RecommendContext context, int countWithLatLon, int countWithCity, int countWithTag, @NotNull String countEachTag, int photoCount) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(countEachTag, "countEachTag");
        if (context != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ServiceConst.PARA_SESSION_ID, context.getMSessionId()), TuplesKt.to("latitude_longitude_photos_number", Integer.valueOf(countWithLatLon)), TuplesKt.to("city_photos_number", Integer.valueOf(countWithCity)), TuplesKt.to("tag_photos_number", Integer.valueOf(countWithTag)), TuplesKt.to("photos_per_label_number", countEachTag), TuplesKt.to("pic_cnt", Integer.valueOf(photoCount)));
            context.getDelegate().getReportDelegate().customReport("ev_qz_identification_process_termination", mutableMapOf);
        }
    }

    public final void reportQueryFinish(@Nullable RecommendContext context, int totalCount) {
        Map<String, ? extends Object> mutableMapOf;
        if (context != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ServiceConst.PARA_SESSION_ID, context.getMSessionId()), TuplesKt.to("pic_cnt", Integer.valueOf(totalCount)));
            context.getDelegate().getReportDelegate().customReport("ev_qz_query_photo", mutableMapOf);
        }
    }

    public final void reportSingleClassifyFinish(@Nullable RecommendContext context, @NotNull String classierId, @NotNull String classierName, int countBeforeHandpick, int countAfterRemoveSimilar, int countAfterHandpick) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(classierId, "classierId");
        Intrinsics.checkNotNullParameter(classierName, "classierName");
        if (context != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ServiceConst.PARA_SESSION_ID, context.getMSessionId()), TuplesKt.to("cluster_id", classierId), TuplesKt.to("cluster_name", classierName), TuplesKt.to("before_selection_photos_number", Integer.valueOf(countBeforeHandpick)), TuplesKt.to("after_defiltering_photos_number", Integer.valueOf(countAfterRemoveSimilar)), TuplesKt.to("after_selection_photos_number", Integer.valueOf(countAfterHandpick)));
            context.getDelegate().getReportDelegate().customReport("ev_qz_single_clustering_process_terminates", mutableMapOf);
        }
    }
}
