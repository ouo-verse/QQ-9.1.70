package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002JA\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0014\"\u00020\nH\u0002\u00a2\u0006\u0002\u0010\u0015J2\u0010\u0016\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J,\u0010\u001b\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J*\u0010\u001d\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0019H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkLaunchReporterImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkLaunchReporter;", "()V", "getEventId", "", "reportId", "getIsPeakAlive", "context", "Landroid/content/Context;", "newParam", "Lfeedcloud/FeedCloudCommon$Entry;", "kotlin.jvm.PlatformType", "key", "value", "newReportData", "", "clientTraceId", IProfileCardConst.KEY_FROM_TYPE, "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "(Ljava/lang/String;I[Lfeedcloud/FeedCloudCommon$Entry;)Ljava/util/List;", "reportBeforeStart", "", "isNewIndex", "", "choiceIndex", "reportOnClick", "schemaUrl", "reportOnClickBroken", "errCode", "intercept", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkLaunchReporterImpl implements IQQWinkLaunchReporter {
    private final String getEventId(String reportId) {
        return WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + reportId;
    }

    private final String getIsPeakAlive(Context context) {
        if (((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).isPeakAlive(context)) {
            return "PeakAlive";
        }
        return "PeakNoAlive";
    }

    private final FeedCloudCommon$Entry newParam(String key, String value) {
        return QCircleReportHelper.newEntry(key, value);
    }

    private final List<FeedCloudCommon$Entry> newReportData(String clientTraceId, int fromType, FeedCloudCommon$Entry... elements) {
        List<FeedCloudCommon$Entry> listOf;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(newParam("traceid", clientTraceId));
        spreadBuilder.add(newParam("ext1", String.valueOf(fromType)));
        spreadBuilder.addSpread(elements);
        listOf = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new FeedCloudCommon$Entry[spreadBuilder.size()]));
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportBeforeStart$lambda$1(Context context, QQWinkLaunchReporterImpl this$0, String clientTraceId, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clientTraceId, "$clientTraceId");
        if (context == null) {
            return;
        }
        String E_PUBLIC_START = QCirclePublishQualityReporter.E_PUBLIC_START;
        Intrinsics.checkNotNullExpressionValue(E_PUBLIC_START, "E_PUBLIC_START");
        String eventId = this$0.getEventId(E_PUBLIC_START);
        FeedCloudCommon$Entry newParam = this$0.newParam("ext2", this$0.getIsPeakAlive(context));
        Intrinsics.checkNotNullExpressionValue(newParam, "newParam(QCirclePublishQ\u2026 getIsPeakAlive(context))");
        FeedCloudCommon$Entry newParam2 = this$0.newParam("ext3", String.valueOf(z16));
        Intrinsics.checkNotNullExpressionValue(newParam2, "newParam(QCirclePublishQ\u20263, isNewIndex.toString())");
        FeedCloudCommon$Entry newParam3 = this$0.newParam("ext4", String.valueOf(i16));
        Intrinsics.checkNotNullExpressionValue(newParam3, "newParam(QCirclePublishQ\u2026, choiceIndex.toString())");
        FeedCloudCommon$Entry newParam4 = this$0.newParam("ret_code", "0");
        Intrinsics.checkNotNullExpressionValue(newParam4, "newParam(QCirclePublishQ\u2026ts.PublishCode.RESULT_OK)");
        FeedCloudCommon$Entry newParam5 = this$0.newParam("ext6", WinkReportUtils.isInMultiWindowMode(context));
        Intrinsics.checkNotNullExpressionValue(newParam5, "newParam(QCirclePublishQ\u2026MultiWindowMode(context))");
        QCirclePublishQualityReporter.report(eventId, this$0.newReportData(clientTraceId, i3, newParam, newParam2, newParam3, newParam4, newParam5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportOnClick$lambda$0(Context context, QQWinkLaunchReporterImpl this$0, String str, int i3, String schemaUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(schemaUrl, "$schemaUrl");
        if (context == null) {
            return;
        }
        String E_PUBLIC_CLICK = QCirclePublishQualityReporter.E_PUBLIC_CLICK;
        Intrinsics.checkNotNullExpressionValue(E_PUBLIC_CLICK, "E_PUBLIC_CLICK");
        String eventId = this$0.getEventId(E_PUBLIC_CLICK);
        FeedCloudCommon$Entry newParam = this$0.newParam("ext2", this$0.getIsPeakAlive(context));
        Intrinsics.checkNotNullExpressionValue(newParam, "newParam(QCirclePublishQ\u2026 getIsPeakAlive(context))");
        FeedCloudCommon$Entry newParam2 = this$0.newParam("ext3", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        Intrinsics.checkNotNullExpressionValue(newParam2, "newParam(QCirclePublishQ\u2026ls.getLevel().toString())");
        FeedCloudCommon$Entry newParam3 = this$0.newParam("ext4", schemaUrl);
        Intrinsics.checkNotNullExpressionValue(newParam3, "newParam(QCirclePublishQ\u2026Reporter.EXT4, schemaUrl)");
        FeedCloudCommon$Entry newParam4 = this$0.newParam("ext6", WinkReportUtils.isInMultiWindowMode(context));
        Intrinsics.checkNotNullExpressionValue(newParam4, "newParam(QCirclePublishQ\u2026MultiWindowMode(context))");
        QCirclePublishQualityReporter.report(eventId, this$0.newReportData(str, i3, newParam, newParam2, newParam3, newParam4));
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter
    public void reportBeforeStart(@Nullable final Context context, @NotNull final String clientTraceId, final int fromType, final boolean isNewIndex, final int choiceIndex) {
        Intrinsics.checkNotNullParameter(clientTraceId, "clientTraceId");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                QQWinkLaunchReporterImpl.reportBeforeStart$lambda$1(context, this, clientTraceId, fromType, isNewIndex, choiceIndex);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter
    public void reportOnClick(@Nullable final Context context, @Nullable final String clientTraceId, final int fromType, @NotNull final String schemaUrl) {
        Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                QQWinkLaunchReporterImpl.reportOnClick$lambda$0(context, this, clientTraceId, fromType, schemaUrl);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter
    public void reportOnClickBroken(@Nullable String clientTraceId, int fromType, @NotNull String errCode, boolean intercept) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        String E_PUBLIC_BREAK = QCirclePublishQualityReporter.E_PUBLIC_BREAK;
        Intrinsics.checkNotNullExpressionValue(E_PUBLIC_BREAK, "E_PUBLIC_BREAK");
        String eventId = getEventId(E_PUBLIC_BREAK);
        FeedCloudCommon$Entry newEntry = QCircleReportHelper.newEntry("ext2", errCode);
        Intrinsics.checkNotNullExpressionValue(newEntry, "newEntry(QCirclePublishQ\u2026tyReporter.EXT2, errCode)");
        FeedCloudCommon$Entry newEntry2 = QCircleReportHelper.newEntry("ext4", String.valueOf(intercept));
        Intrinsics.checkNotNullExpressionValue(newEntry2, "newEntry(QCirclePublishQ\u2026T4, intercept.toString())");
        FeedCloudCommon$Entry newEntry3 = QCircleReportHelper.newEntry("ret_code", errCode);
        Intrinsics.checkNotNullExpressionValue(newEntry3, "newEntry(QCirclePublishQ\u2026er.KEY_RET_CODE, errCode)");
        FeedCloudCommon$Entry newEntry4 = QCircleReportHelper.newEntry("ext6", WinkReportUtils.isInMultiWindowMode(null));
        Intrinsics.checkNotNullExpressionValue(newEntry4, "newEntry(QCirclePublishQ\u2026sInMultiWindowMode(null))");
        QCirclePublishQualityReporter.report(eventId, newReportData(clientTraceId, fromType, newEntry, newEntry2, newEntry3, newEntry4));
    }
}
