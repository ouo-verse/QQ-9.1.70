package com.tencent.ecommerce.base.report.service;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/f;", "Lcom/tencent/ecommerce/base/report/service/e;", "", IECDtReport.ACTION_IDENTIFIER, "j", "", "i", "g", "Ljava/lang/String;", "", tl.h.F, "I", IECDtReport.ACTION_EXPOSE_POLICY, IECDtReport.ACTION_EXPOSE_END_POLICY, IECDtReport.ACTION_CLICK_POLICY, "", "k", "Z", "getNeedTraverseExposure", "()Z", "(Z)V", IECDtReport.ACTION_NEED_TRAVERSE_EXPOSURE, "Landroid/view/View;", "l", "Landroid/view/View;", "target", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class f extends e<f> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String identifier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int exposePolicy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int exposeEndPolicy;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int clickPolicy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needTraverseExposure;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final View target;

    public f(View view) {
        super(view);
        this.target = view;
        this.identifier = "";
        IECDtReport.Companion companion = IECDtReport.INSTANCE;
        this.exposePolicy = companion.a();
        this.exposeEndPolicy = companion.a();
        this.clickPolicy = companion.a();
        this.needTraverseExposure = true;
    }

    public final void i() {
        c().put(IECDtReport.ACTION_DATA_READY, Boolean.valueOf(getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_DATA_READY java.lang.String()));
        c().put(IECDtReport.ACTION_IDENTIFIER, this.identifier);
        c().put(IECDtReport.ACTION_EXPOSE_POLICY, Integer.valueOf(this.exposePolicy));
        c().put(IECDtReport.ACTION_EXPOSE_END_POLICY, Integer.valueOf(this.exposeEndPolicy));
        c().put(IECDtReport.ACTION_CLICK_POLICY, Integer.valueOf(this.clickPolicy));
        c().put(IECDtReport.ACTION_NEED_TRAVERSE_EXPOSURE, Boolean.valueOf(this.needTraverseExposure));
        b.f100913b.bindDtReportInfo(this.target, getTargetId(), d(), c());
    }

    public final f j(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public final void k(boolean z16) {
        this.needTraverseExposure = z16;
    }
}
