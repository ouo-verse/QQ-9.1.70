package com.tencent.filament.zplan.scene.tofu;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "faceAnimUrl", "bodyAnimUrl", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "continuation", "", "fetchAvatarConfig"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.tofu.TofuScene", f = "TofuScene.kt", i = {0, 0, 0, 1, 1}, l = {322, 323}, m = "fetchAvatarConfig", n = {"this", "spanContext", "bodyAnimUrl", "this", "faceResource"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class TofuScene$fetchAvatarConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TofuScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuScene$fetchAvatarConfig$1(TofuScene tofuScene, Continuation continuation) {
        super(continuation);
        this.this$0 = tofuScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d0(null, null, null, this);
    }
}
