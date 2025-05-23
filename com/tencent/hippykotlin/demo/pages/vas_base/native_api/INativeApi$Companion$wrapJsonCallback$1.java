package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class INativeApi$Companion$wrapJsonCallback$1 extends Lambda implements Function1<e, Unit> {
    public static final INativeApi$Companion$wrapJsonCallback$1 INSTANCE = new INativeApi$Companion$wrapJsonCallback$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        eVar2.z("result", -1);
        eVar2.z("msg", "unknown error");
        return Unit.INSTANCE;
    }

    public INativeApi$Companion$wrapJsonCallback$1() {
        super(1);
    }
}
