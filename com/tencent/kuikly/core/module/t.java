package com.tencent.kuikly.core.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/module/t;", "Lcom/tencent/kuikly/core/module/Module;", "", "b", "", "a", "", "moduleName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class t extends Module {
    public final boolean a() {
        return Intrinsics.areEqual(syncToNativeMethod("isTurboDisplay", (com.tencent.kuikly.core.nvi.serialization.json.e) null, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null), "1");
    }

    public final void b() {
        asyncToNativeMethod("setCurrentUIAsFirstScreenForNextLaunch", (com.tencent.kuikly.core.nvi.serialization.json.e) null, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRTurboDisplayModule";
    }
}
