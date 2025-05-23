package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.tencent.kuikly.core.kmp.a;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a8\u0006\u0004"}, d2 = {"runOnUIThread", "", "task", "Lkotlin/Function0;", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneBaseServiceKt {
    public static final void runOnUIThread(final Function0<Unit> function0) {
        if (c.f117352a.n(BridgeManager.f117344a.u())) {
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseServiceKt$runOnUIThread$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        } else {
            a.b(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseServiceKt$runOnUIThread$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        }
    }
}
