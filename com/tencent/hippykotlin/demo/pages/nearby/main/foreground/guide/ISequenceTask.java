package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface ISequenceTask {
    boolean canStart();

    void onStart(Function1<? super Boolean, Unit> function1);
}
