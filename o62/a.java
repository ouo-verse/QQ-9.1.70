package o62;

import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lo62/a;", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "", QzoneIPCModule.RESULT_CODE, "eventId", "", QCircleWeakNetReporter.KEY_COST, "Ljava/util/HashMap;", "", "", "params", "", "reportQualityDataDimension", "Lcom/tencent/mobileqq/kandian/base/image/b;", "imageRequest", "reportSlowImageRequest", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IRIJImageOptReport {

    /* renamed from: d, reason: collision with root package name */
    public static final a f422157d = new a();

    a() {
    }

    @Override // com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport
    public void reportSlowImageRequest(b imageRequest) {
        if (imageRequest != null) {
            PublicAccountReportUtils.l(null, "", "0X800AEF3", "0X800AEF3", 0, 0, "", "", "", imageRequest.toString(), false);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport
    public void reportQualityDataDimension(int resultCode, int eventId, long cost, HashMap<String, Object> params) {
    }
}
