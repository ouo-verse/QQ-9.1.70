package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o62.a;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016JP\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052.\u0010\u000b\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/ReadInJoyReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyReportUtils;", "", QzoneIPCModule.RESULT_CODE, "eventId", "", QCircleWeakNetReporter.KEY_COST, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "", "reportQualityDataDimension", "Lcom/tencent/mobileqq/kandian/base/image/b;", "imageRequest", "reportSlowImageRequest", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", Node.ATTRS_ATTR, "reportPushEffectEvent", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoyReportUtilsImpl implements IReadInJoyReportUtils {
    @Override // com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils
    public void reportPushEffectEvent(int eventId, List<oidb_cmd0x80a.AttributeList> attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        ReadinjoyReportUtils.b(eventId, attrs);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport
    public void reportQualityDataDimension(int resultCode, int eventId, long cost, HashMap<String, Object> params) {
        a.f422157d.reportQualityDataDimension(resultCode, eventId, cost, params);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport
    public void reportSlowImageRequest(b imageRequest) {
        a.f422157d.reportSlowImageRequest(imageRequest);
    }
}
