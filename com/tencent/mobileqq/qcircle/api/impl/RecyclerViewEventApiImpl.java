package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qcircle.api.IRecyclerViewEventApi;
import com.tencent.richframework.argus.business.performance.report.ArgusReportHelper;
import com.tencent.richframework.argus.business.performance.report.RecyclerViewEventInterceptor;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/RecyclerViewEventApiImpl;", "Lcom/tencent/mobileqq/qcircle/api/IRecyclerViewEventApi;", "()V", "isOpenPreload", "", h.f248218g, "", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class RecyclerViewEventApiImpl implements IRecyclerViewEventApi {
    @Override // com.tencent.mobileqq.qcircle.api.IRecyclerViewEventApi
    public void isOpenPreload(boolean isOpen) {
        RecyclerViewEventInterceptor.INSTANCE.isOpenPreload(isOpen);
        ArgusReportHelper.INSTANCE.setSIsOpenPreload(isOpen ? 1 : 0);
    }
}
