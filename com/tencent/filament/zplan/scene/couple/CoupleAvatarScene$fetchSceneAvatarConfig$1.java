package com.tencent.filament.zplan.scene.couple;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "bpUrl", "detailBpUrl", "faceAnimUrl", "bodyAnimUrl", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "continuation", "", "fetchSceneAvatarConfig"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene", f = "CoupleAvatarScene.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {701, 706, 710, 711, 713, 714}, m = "fetchSceneAvatarConfig", n = {"this", "spanContext", "detailBpUrl", "faceAnimUrl", "bodyAnimUrl", "this", "spanContext", "faceAnimUrl", "bodyAnimUrl", "bpConfig", "this", "spanContext", "faceAnimUrl", "bodyAnimUrl", "bpConfig", "detailBpConfig", "this", "spanContext", "faceAnimUrl", "bodyAnimUrl", "bpConfig", "detailBpConfig", "this", "spanContext", "bodyAnimUrl", "bpConfig", "detailBpConfig", "this", "bpConfig", "detailBpConfig", "faceResource"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchSceneAvatarConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchSceneAvatarConfig$1(CoupleAvatarScene coupleAvatarScene, Continuation continuation) {
        super(continuation);
        this.this$0 = coupleAvatarScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.S0(null, null, null, null, null, this);
    }
}
