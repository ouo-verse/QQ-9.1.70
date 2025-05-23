package com.tencent.ecommerce.base.report.service;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/d;", "Lcom/tencent/ecommerce/base/report/service/e;", "", "enable", "j", "", "i", "g", "Z", "autoReport", "", tl.h.F, "Ljava/lang/Object;", "target", "<init>", "(Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class d extends e<d> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean autoReport;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Object target;

    public d(Object obj) {
        super(obj);
        this.target = obj;
        this.autoReport = true;
    }

    public final void i() {
        c().put(IECDtReport.ACTION_DATA_READY, Boolean.valueOf(getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_DATA_READY java.lang.String()));
        b.f100913b.attachDtReport(this.target, getTargetId(), d(), this.autoReport, c());
    }

    public final d j(boolean enable) {
        this.autoReport = enable;
        return this;
    }
}
