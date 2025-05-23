package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/g;", "", "Lcom/tencent/mobileqq/wink/editdraft/f;", "data", "", "a", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "deleteKeys", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f318523a = new g();

    g() {
    }

    public final void a(@NotNull WinkEditorDraftReportData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QCirclePublishQualityReporter.report(WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + QCirclePublishQualityReporter.E_CLEAN_MMKV, data.a());
    }

    public final void b(@NotNull String businessName, @NotNull List<String> deleteKeys) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(deleteKeys, "deleteKeys");
        String str = WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + QCirclePublishQualityReporter.E_DELETE_WINK_EDIT_DRAFT;
        QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder = new QCirclePublishQualityDataBuilder();
        qCirclePublishQualityDataBuilder.setKeyEventId(str);
        qCirclePublishQualityDataBuilder.setDesc(businessName);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(deleteKeys, null, null, null, 0, null, null, 63, null);
        qCirclePublishQualityDataBuilder.setExt1(joinToString$default);
        QCirclePublishQualityReporter.report(qCirclePublishQualityDataBuilder);
    }
}
