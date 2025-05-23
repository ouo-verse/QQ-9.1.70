package com.tencent.hippykotlin.demo.pages.qwallet.base.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class QWalletBridgeModule extends Module {
    public final void callNativeMethod(String str, e eVar, Function1<? super e, Unit> function1) {
        toNative(false, str, eVar.toString(), function1, false);
    }
}
