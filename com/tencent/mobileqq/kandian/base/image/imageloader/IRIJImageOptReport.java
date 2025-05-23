package com.tencent.mobileqq.kandian.base.image.imageloader;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "", "", QzoneIPCModule.RESULT_CODE, "eventId", "", QCircleWeakNetReporter.KEY_COST, "Ljava/util/HashMap;", "", "params", "", "reportQualityDataDimension", "Lcom/tencent/mobileqq/kandian/base/image/b;", "imageRequest", "reportSlowImageRequest", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface IRIJImageOptReport {
    void reportQualityDataDimension(int resultCode, int eventId, long cost, @Nullable HashMap<String, Object> params);

    void reportSlowImageRequest(@Nullable com.tencent.mobileqq.kandian.base.image.b imageRequest);
}
