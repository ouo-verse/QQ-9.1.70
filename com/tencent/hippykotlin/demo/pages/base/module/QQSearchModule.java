package com.tencent.hippykotlin.demo.pages.base.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQSearchModule extends Module {
    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQSearchModule";
    }

    public final void callNativeMethod(String str, e eVar, Function1<? super e, Unit> function1) {
        toNative(false, str, eVar.toString(), function1, false);
    }
}
