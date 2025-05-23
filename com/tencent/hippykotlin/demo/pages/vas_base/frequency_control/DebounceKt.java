package com.tencent.hippykotlin.demo.pages.vas_base.frequency_control;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class DebounceKt {
    public static final Function1 debounce(Function1 function1) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        return new DebounceKt$debounce$2(objectRef, function1);
    }
}
