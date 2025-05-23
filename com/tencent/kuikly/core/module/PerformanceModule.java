package com.tencent.kuikly.core.module;

import com.tencent.kuikly.core.pager.PageCreateTrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/module/PerformanceModule;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/module/m;", "", "callback", "a", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "trace", "b", "(Lcom/tencent/kuikly/core/pager/PageCreateTrace;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PerformanceModule extends Module {
    public final void a(final Function1<? super m, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        toNative(false, "getPerformanceData", null, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.kuikly.core.module.PerformanceModule$getPerformanceData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                callback.invoke(m.INSTANCE.a(eVar));
            }
        }, false);
    }

    public final void b(PageCreateTrace trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        Module.toNative$default(this, false, "onPageCreateFinish", trace.a(), null, false, 8, null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRPerformanceModule";
    }
}
