package com.tencent.kuikly.core.render.android.expand.component;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class g implements Choreographer.FrameCallback {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Function1 f117868d;

    public g(Function1 function1) {
        this.f117868d = function1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final /* synthetic */ void doFrame(long j3) {
        Intrinsics.checkNotNullExpressionValue(this.f117868d.invoke(Long.valueOf(j3)), "invoke(...)");
    }
}
