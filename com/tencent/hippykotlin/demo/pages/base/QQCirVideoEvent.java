package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQCirVideoEvent extends l {
    public Function1<? super Long, Unit> onClickVideoHandlerFn;
    public Function1<? super QVideoPlayState, Unit> playStateDidChangedHandler;
    public Function2<? super Float, ? super Float, Unit> playTimeDidChangedHandler;
}
