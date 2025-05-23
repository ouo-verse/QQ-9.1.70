package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/WeiShiReportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IWeiShiReportUtil;", "()V", "reportEnter", "", "reportExit", "reportMsgExposure", "data", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "reportFrom", "", "reportWeiShiDelete", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class WeiShiReportUtilImpl implements IWeiShiReportUtil {
    @Override // com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil
    public void reportEnter() {
        WeishiReportUtil.l();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil
    public void reportExit() {
        WeishiReportUtil.n();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil
    public void reportMsgExposure(RecentBaseData data, int reportFrom) {
        WeishiReportUtil.q(data, reportFrom);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil
    public void reportWeiShiDelete() {
        WeishiReportUtil.r();
    }
}
