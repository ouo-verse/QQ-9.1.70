package com.tencent.ecommerce.biz.hr.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\b\u001a\u00020\u0005R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/a;", "", "", "success", "Lkotlin/Function0;", "", "block", "b", "a", "Lcom/tencent/ecommerce/biz/hr/component/HRPAGView;", "Lcom/tencent/ecommerce/biz/hr/component/HRPAGView;", "pagView", "<init>", "(Lcom/tencent/ecommerce/biz/hr/component/HRPAGView;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HRPAGView pagView;

    public a(HRPAGView hRPAGView) {
        this.pagView = hRPAGView;
    }

    public final void b(boolean success, Function0<Unit> block) {
        HRPAGView hRPAGView = this.pagView;
        if (hRPAGView != null) {
            hRPAGView.f0(success, block);
        }
    }

    public final void a() {
        this.pagView = null;
    }
}
